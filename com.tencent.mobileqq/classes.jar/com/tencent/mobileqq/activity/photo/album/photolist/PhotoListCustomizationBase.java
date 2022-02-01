package com.tencent.mobileqq.activity.photo.album.photolist;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PhotoListCustomizationBase<O extends OtherCommonData>
  extends PhotoListCustomization<O>
{
  protected PhotoListCustomizationBase(PeakFragmentActivity paramPeakFragmentActivity)
  {
    super(paramPeakFragmentActivity);
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    paramLocalMediaInfo.selectStatus = 1;
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.contains(paramLocalMediaInfo.position)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(paramLocalMediaInfo.position);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.n) && (paramInt == 1))
    {
      PhotoListBaseData localPhotoListBaseData = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData;
      localPhotoListBaseData.c += 1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.c == 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.r) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.containsKey(paramLocalMediaInfo.path))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(paramLocalMediaInfo.path, paramLocalMediaInfo);
    }
    if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
    {
      paramLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData;
      paramLocalMediaInfo.d += 1;
    }
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, PhotoCommonBaseData paramPhotoCommonBaseData, String[] paramArrayOfString, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.n) && (paramArrayOfString != null) && ("video".equals(paramArrayOfString[0])))
    {
      paramArrayOfString = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData;
      paramArrayOfString.c -= 1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.c == 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
      }
    }
    if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
    {
      paramArrayOfString = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData;
      paramArrayOfString.d -= 1;
    }
    paramPhotoCommonBaseData.selectedPhotoList.remove(paramLocalMediaInfo.path);
    paramPhotoCommonBaseData.selectedIndex.remove(paramLocalMediaInfo.position);
    paramPhotoCommonBaseData.selectedMediaInfoHashMap.remove(paramString);
    paramLocalMediaInfo.selectStatus = 2;
    paramLocalMediaInfo = (HashMap)QAlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    if (paramLocalMediaInfo != null) {
      paramLocalMediaInfo.remove(paramString);
    }
    paramLocalMediaInfo = QAlbumUtil.sSelectItemAlbum;
    if (paramLocalMediaInfo.containsKey(paramString)) {
      paramLocalMediaInfo.remove(paramString);
    }
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, String[] paramArrayOfString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.n) && (paramArrayOfString != null) && ("video".equals(paramArrayOfString[0])))
    {
      paramArrayOfString = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData;
      paramArrayOfString.c += 1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.c == 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
      }
    }
    if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
    {
      paramLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData;
      paramLocalMediaInfo.d += 1;
    }
  }
  
  private void a(@NonNull Holder paramHolder, View paramView, LocalMediaInfo paramLocalMediaInfo)
  {
    int i = paramLocalMediaInfo.selectStatus;
    if (i == 1)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.indexOf(paramLocalMediaInfo.path) + 1);
      if (paramView.getBackground() != null) {
        paramView.setBackgroundDrawable(null);
      }
    }
    else if (i == 3)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
    }
    else
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      if (paramView.getBackground() != null) {
        paramView.setBackgroundDrawable(null);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) && (i != 1) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode))
    {
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.3F);
      return;
    }
    paramHolder.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
  }
  
  private void a(ArrayList<String> paramArrayList, LocalMediaInfo paramLocalMediaInfo, String paramString)
  {
    Object localObject = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.n) && (localObject != null) && ("video".equals(localObject[0])))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData;
      ((PhotoListBaseData)localObject).c -= 1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.c == 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
      }
    }
    if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData;
      ((PhotoListBaseData)localObject).d -= 1;
    }
    paramArrayList.remove(paramString);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.remove(paramLocalMediaInfo.position);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.remove(paramString);
    paramArrayList = (HashMap)QAlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    if (paramArrayList != null) {
      paramArrayList.remove(paramString);
    }
    paramArrayList = QAlbumUtil.sSelectItemAlbum;
    if (paramArrayList.containsKey(paramString)) {
      paramArrayList.remove(paramString);
    }
  }
  
  private void a(List<LocalMediaInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    while (paramInt1 < paramList.size())
    {
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramList.get(paramInt1);
      if (localLocalMediaInfo.path != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.firstVideoInfo == null) && (localLocalMediaInfo.mMediaType == 1) && (("$RecentAlbumId".equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId)) || ("$VideoAlbumId".equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId)))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.firstVideoInfo = localLocalMediaInfo;
        }
        int i = QAlbumUtil.getMediaType(localLocalMediaInfo);
        localLocalMediaInfo.position = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mediaPathsList.size());
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mediaPathsList.add(localLocalMediaInfo.path);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.contains(localLocalMediaInfo.path))
        {
          a(localLocalMediaInfo, i);
        }
        else if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) && (localLocalMediaInfo.path.equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.jdField_e_of_type_JavaLangString)))
        {
          localLocalMediaInfo.selectStatus = 1;
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(localLocalMediaInfo.path);
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(localLocalMediaInfo.position);
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
        }
        else
        {
          a(paramList, paramLong, paramInt2, localLocalMediaInfo);
        }
      }
      paramInt1 += 1;
    }
  }
  
  private void a(List<LocalMediaInfo> paramList, long paramLong, int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.q) && (paramLong <= 60000L) && (paramInt == paramList.size()) && (paramLocalMediaInfo.path.equals(QAlbumUtil.sLastAlbumPath)))
    {
      paramLocalMediaInfo.selectStatus = 3;
      return;
    }
    paramLocalMediaInfo.selectStatus = 2;
  }
  
  private void a(List<LocalMediaInfo> paramList, PhotoCommonBaseData<O> paramPhotoCommonBaseData, HashMap<String, LocalMediaInfo> paramHashMap)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.s) && (paramPhotoCommonBaseData.albumId.equals("$VideoAlbumId")))
    {
      paramPhotoCommonBaseData = paramList.iterator();
      while (paramPhotoCommonBaseData.hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramPhotoCommonBaseData.next();
        if ((localLocalMediaInfo != null) && (!TextUtils.isEmpty(localLocalMediaInfo.path)))
        {
          PhotoListBaseData.jdField_a_of_type_JavaUtilMap.remove(localLocalMediaInfo.path);
          paramHashMap.remove(localLocalMediaInfo.path);
        }
      }
      paramPhotoCommonBaseData = PhotoListBaseData.jdField_a_of_type_JavaUtilMap.values();
      int i = 0;
      paramPhotoCommonBaseData = paramPhotoCommonBaseData.iterator();
      while (paramPhotoCommonBaseData.hasNext())
      {
        paramHashMap = (LocalMediaInfo)paramPhotoCommonBaseData.next();
        if ((paramHashMap != null) && ("video/mp4".equals(paramHashMap.mMimeType)))
        {
          paramList.add(i, paramHashMap);
          i += 1;
        }
      }
    }
  }
  
  private boolean a(boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    if ((paramInt != 1) || (!paramBoolean))
    {
      if ((paramInt == 2) && (!paramBoolean)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void b(LocalMediaInfo paramLocalMediaInfo, PhotoCommonBaseData paramPhotoCommonBaseData, String[] paramArrayOfString, String paramString)
  {
    a(paramLocalMediaInfo, paramArrayOfString);
    paramPhotoCommonBaseData.selectedPhotoList.add(paramString);
    paramPhotoCommonBaseData.selectedIndex.add(paramLocalMediaInfo.position);
    paramPhotoCommonBaseData.selectedMediaInfoHashMap.put(paramString, paramLocalMediaInfo);
    paramPhotoCommonBaseData = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getIntent();
    if (!paramPhotoCommonBaseData.hasExtra("param_initTime")) {
      paramPhotoCommonBaseData.putExtra("param_initTime", System.currentTimeMillis());
    }
    paramLocalMediaInfo.selectStatus = 1;
    paramPhotoCommonBaseData = (LinkedHashMap)QAlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    paramLocalMediaInfo = paramPhotoCommonBaseData;
    if (paramPhotoCommonBaseData == null)
    {
      paramLocalMediaInfo = new LinkedHashMap();
      QAlbumUtil.sSelectItemPosMap.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, paramLocalMediaInfo);
    }
    paramLocalMediaInfo.put(paramString, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition()));
    paramLocalMediaInfo = QAlbumUtil.sSelectItemAlbum;
    if (!paramLocalMediaInfo.containsKey(paramString)) {
      paramLocalMediaInfo.put(paramString, new Pair(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName));
    }
  }
  
  private void b(ArrayList<String> paramArrayList, LocalMediaInfo paramLocalMediaInfo, String paramString)
  {
    a(paramLocalMediaInfo, MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType));
    paramArrayList.add(paramString);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(paramLocalMediaInfo.position);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(paramString, paramLocalMediaInfo);
    paramArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getIntent();
    if (!paramArrayList.hasExtra("param_initTime")) {
      paramArrayList.putExtra("param_initTime", System.currentTimeMillis());
    }
    paramLocalMediaInfo = (LinkedHashMap)QAlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    paramArrayList = paramLocalMediaInfo;
    if (paramLocalMediaInfo == null)
    {
      paramArrayList = new LinkedHashMap();
      QAlbumUtil.sSelectItemPosMap.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, paramArrayList);
    }
    paramArrayList.put(paramString, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition()));
    paramArrayList = QAlbumUtil.sSelectItemAlbum;
    if (!paramArrayList.containsKey(paramString)) {
      paramArrayList.put(paramString, new Pair(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName));
    }
  }
  
  private void b(List<LocalMediaInfo> paramList)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.r) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$RecentAlbumId"))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.s) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$VideoAlbumId")) && ((paramList.isEmpty()) || (((LocalMediaInfo)paramList.get(0)).mMediaType != 2))))
    {
      LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.mMimeType = "mobileqq/camera";
      localLocalMediaInfo.mMediaType = 2;
      paramList.add(0, localLocalMediaInfo);
    }
  }
  
  private void b(List<LocalMediaInfo> paramList, PhotoCommonBaseData<O> paramPhotoCommonBaseData, HashMap<String, LocalMediaInfo> paramHashMap)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.r) && (paramPhotoCommonBaseData.albumId.equals("$RecentAlbumId")))
    {
      paramPhotoCommonBaseData = paramList.iterator();
      while (paramPhotoCommonBaseData.hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramPhotoCommonBaseData.next();
        if ((localLocalMediaInfo != null) && (!TextUtils.isEmpty(localLocalMediaInfo.path)))
        {
          PhotoListBaseData.jdField_a_of_type_JavaUtilMap.remove(localLocalMediaInfo.path);
          paramHashMap.remove(localLocalMediaInfo.path);
        }
      }
      paramList.addAll(0, PhotoListBaseData.jdField_a_of_type_JavaUtilMap.values());
    }
  }
  
  public Intent a(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramInt);
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getIntent();
    localIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
    localIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex);
    if (QAlbumUtil.getMediaType(paramView) == 0) {
      localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramView.position);
    }
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", true);
    PhotoListBaseData.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.containsKey(paramView.path)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(paramView.path, paramView);
    }
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap);
    localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, a());
    localIntent.addFlags(603979776);
    return localIntent;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a();
  }
  
  public RelativeLayout.LayoutParams a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a();
  }
  
  public AbstractAlbumListFragment a()
  {
    return new AbstractAlbumListFragment();
  }
  
  public Holder a(@NonNull Holder paramHolder, int paramInt)
  {
    return paramHolder;
  }
  
  public Class a()
  {
    return AbstractPhotoPreviewActivity.class;
  }
  
  public String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum;
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getResources().getString(2131694856, new Object[] { Integer.valueOf(i) });
  }
  
  public List<LocalMediaInfo> a(Object... paramVarArgs)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mMediaQueryHelper == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.jdField_f_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.createMediaQueryHelper(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mMediaQueryHelper.queryNext();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.firstRecentInfo == null) && ("$RecentAlbumId".equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.firstRecentInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mMediaQueryHelper.getFirstInfo();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mMediaQueryHelper.upDateCount();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.recentCountLimit > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.recentCountLimit < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mMediaQueryHelper.cursorsCount)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.recentCount = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.recentCountLimit;
      } else {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.recentCount = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mMediaQueryHelper.cursorsCount;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.videoCount = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mMediaQueryHelper.cursorsVideoCount;
    }
    paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mMediaQueryHelper.mediaList;
    a(paramVarArgs);
    a(paramVarArgs, 0);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QueryPhotoTask,doInBackground,mediaList.size :");
      localStringBuilder.append(paramVarArgs.size());
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    b(paramVarArgs);
    return paramVarArgs;
  }
  
  public void a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.customSendBtnText != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.customSendBtnText;
    } else {
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getString(2131694839);
    }
    boolean bool;
    if (localArrayList.size() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = str;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(localArrayList.size());
      ((StringBuilder)localObject).append(")");
      localObject = ((StringBuilder)localObject).toString();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton.setEnabled(bool);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetTextView.setEnabled(bool);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.jdField_f_of_type_Int = paramInt1;
    if (paramInt2 == -1)
    {
      if (paramInt1 != 16) {
        return;
      }
      a(true, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getIntent());
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.q = paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId;
    if (paramIntent.getBooleanExtra("album_enter_directly", false))
    {
      long l1 = System.currentTimeMillis();
      long l2 = QAlbumUtil.sLastAlbumRecordTime;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.q) && (l1 - l2 < 60000L))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = QAlbumUtil.sLastAlbumName;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = QAlbumUtil.sLastAlbumId;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = paramIntent.getStringExtra("ALBUM_NAME");
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = paramIntent.getStringExtra("ALBUM_ID");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = "$RecentAlbumId";
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.n = paramIntent.getBooleanExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.t = paramIntent.getBooleanExtra("PeakConstants.showGifTypeIcon", false);
    Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList = ((ArrayList)localObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList = new ArrayList();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap = new HashMap();
    }
    localObject = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if ((localObject != null) && (!((HashMap)localObject).isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == ((HashMap)localObject).size()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.putAll((Map)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum > 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter = MediaFileFilter.getFilter(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.customSendBtnText = paramIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.r = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_CAMERA", false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.r) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.s = paramIntent.getBooleanExtra("PhotoConst.SHOW_CAMERA_IN_VIDEO", false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.jdField_e_of_type_Int = paramIntent.getIntExtra("PHOTOLIST_START_POSITION", -1);
    paramIntent.removeExtra("PHOTOLIST_START_POSITION");
  }
  
  public void a(Message paramMessage) {}
  
  public void a(View paramView) {}
  
  public void a(View paramView, int paramInt) {}
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode) {
      return;
    }
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("current select count:");
      ((StringBuilder)localObject).append(paramView.size());
      QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramInt);
    int j = ((LocalMediaInfo)localObject).selectStatus;
    bool = false;
    if ((j != 1) && (paramView.size() >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum))
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.jdField_b_of_type_Long >= 1000L)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, a((LocalMediaInfo)localObject), 0).a();
        paramCheckBox.setChecked(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.jdField_b_of_type_Long = l;
      }
      return;
    }
    if (j != 1) {
      i = 1;
    }
    ((LocalMediaInfo)localObject).selectStatus = i;
    if (((LocalMediaInfo)localObject).selectStatus == 1) {
      bool = true;
    }
    paramCheckBox = ((LocalMediaInfo)localObject).path;
    if (bool) {
      b(paramView, (LocalMediaInfo)localObject, paramCheckBox);
    } else {
      a(paramView, (LocalMediaInfo)localObject, paramCheckBox);
    }
    a(bool, (LocalMediaInfo)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a(paramInt, bool);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.b(bool ^ true);
  }
  
  public void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent) {}
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  protected void a(Holder paramHolder, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void a(List<LocalMediaInfo> paramList)
  {
    PhotoCommonBaseData localPhotoCommonBaseData = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData;
    if (localPhotoCommonBaseData.selectedPhotoList == null) {
      localPhotoCommonBaseData.selectedPhotoList = new ArrayList();
    }
    Object localObject = localPhotoCommonBaseData.selectedPhotoList;
    if (localPhotoCommonBaseData.selectedMediaInfoHashMap == null) {
      localPhotoCommonBaseData.selectedMediaInfoHashMap = new HashMap();
    }
    localObject = localPhotoCommonBaseData.selectedMediaInfoHashMap;
    LogTag.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.c = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.d = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap = new HashMap();
    }
    else
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap.containsKey(str)) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.containsKey(str))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(str, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap.get(str));
        }
      }
      localPhotoCommonBaseData.allMediaInfoHashMap.clear();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mediaPathsList != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mediaPathsList.clear();
    } else {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mediaPathsList = new ArrayList();
    }
    b(paramList, localPhotoCommonBaseData, (HashMap)localObject);
    a(paramList, localPhotoCommonBaseData, (HashMap)localObject);
  }
  
  public void a(List<LocalMediaInfo> paramList, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    long l2 = QAlbumUtil.sLastAlbumRecordTime;
    int i;
    if (QAlbumUtil.sLastAlbumPhotoCountMap.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId)) {
      i = ((Integer)QAlbumUtil.sLastAlbumPhotoCountMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId)).intValue();
    } else {
      i = 0;
    }
    int j = paramList.size();
    a(paramList, paramInt, l1 - l2, i);
    while (paramInt < j)
    {
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramList.get(paramInt);
      if (localLocalMediaInfo.path != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
      }
      paramInt += 1;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, Intent paramIntent)
  {
    paramIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    if (!paramBoolean) {
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    } else {
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.jdField_e_of_type_JavaLangString);
    }
    paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap);
    paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
    paramIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
    paramIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    paramIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    PhotoListBaseData.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
    paramIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, a());
    paramIntent.addFlags(603979776);
    b(paramIntent);
    QAlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, true, true);
  }
  
  public void a(boolean paramBoolean, LocalMediaInfo paramLocalMediaInfo) {}
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    PhotoCommonBaseData localPhotoCommonBaseData = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData;
    String[] arrayOfString = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.n) && (arrayOfString != null) && (!"image".equals(arrayOfString[0]))) {
      return false;
    }
    int i = paramLocalMediaInfo.selectStatus;
    if (a(paramBoolean, i)) {
      return false;
    }
    if ((i == 2) && (paramBoolean) && (localPhotoCommonBaseData.selectedPhotoList.size() >= localPhotoCommonBaseData.maxSelectNum))
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.jdField_b_of_type_Long >= 700L)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, a(paramLocalMediaInfo), 1000).a();
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.jdField_b_of_type_Long = l;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.p = true;
      }
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.p = false;
    String str = paramLocalMediaInfo.path;
    if (paramBoolean) {
      b(paramLocalMediaInfo, localPhotoCommonBaseData, arrayOfString, str);
    } else {
      a(paramLocalMediaInfo, localPhotoCommonBaseData, arrayOfString, str);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.b(paramBoolean ^ true);
    return true;
  }
  
  public boolean a(List<LocalMediaInfo> paramList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity == null) {
      return false;
    }
    if (paramList == null)
    {
      Object localObject;
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.r) || (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$RecentAlbumId")))
      {
        localObject = paramList;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.s)
        {
          localObject = paramList;
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$VideoAlbumId")) {}
        }
      }
      else
      {
        paramList = new LocalMediaInfo();
        paramList.mMimeType = "mobileqq/camera";
        localObject = new ArrayList();
        ((List)localObject).add(0, paramList);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a((List)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.notifyDataSetChanged();
      a();
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, "暂无媒体文件", 1000).a();
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramList);
    if (paramList.isEmpty()) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, "暂无媒体文件", 1000).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.notifyDataSetChanged();
    a();
    return true;
  }
  
  public View b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.b();
  }
  
  public RelativeLayout.LayoutParams b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.b();
  }
  
  public Holder b(@NonNull Holder paramHolder, int paramInt)
  {
    Object localObject1 = paramHolder.itemView;
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter$CheckBoxClickedListener.a(paramInt);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter$CheckBoxClickedListener.a(paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
    ImageView localImageView = paramHolder.jdField_b_of_type_AndroidWidgetImageView;
    localImageView.setAdjustViewBounds(false);
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramInt);
    Object localObject2 = QAlbumUtil.createContentDescription(0, localLocalMediaInfo, paramInt);
    paramHolder.jdField_b_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject2);
    if (localLocalMediaInfo != null)
    {
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.t) && (QAlbumUtil.isGif(localLocalMediaInfo)))
      {
        if (paramHolder.jdField_b_of_type_AndroidWidgetTextView == null)
        {
          paramHolder.jdField_b_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a();
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText("GIF");
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout)paramHolder.itemView).addView(paramHolder.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
        }
        paramHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else if (paramHolder.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        paramHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      int i = AlbumThumbDownloader.THUMB_WIDHT;
      localLocalMediaInfo.thumbHeight = i;
      localLocalMediaInfo.thumbWidth = i;
      localObject2 = paramHolder.jdField_a_of_type_ComTencentImageURLDrawable;
      StringBuilder localStringBuilder = new StringBuilder("albumthumb");
      localStringBuilder.append("://");
      localStringBuilder.append(localLocalMediaInfo.path);
      if ((localObject2 == null) || (!((URLDrawable)localObject2).getURL().toString().equals(localStringBuilder.toString())))
      {
        localObject2 = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("PhotoListAdapter,getView(),image url :");
          localStringBuilder.append(((URL)localObject2).toString());
          QLog.d("QQAlbum", 2, localStringBuilder.toString());
        }
        localObject2 = URLDrawableHelper.getDrawable((URL)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        ((URLDrawable)localObject2).setTag(localLocalMediaInfo);
        localImageView.setImageDrawable((Drawable)localObject2);
        paramHolder.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject2);
      }
      a(paramHolder, (View)localObject1, localLocalMediaInfo);
      if (AppSetting.d)
      {
        localObject1 = QAlbumUtil.createContentDescriptionWithCheckBox(0, localLocalMediaInfo, paramInt, paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked());
        paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setContentDescription((CharSequence)localObject1);
      }
      localLocalMediaInfo.visableTime = SystemClock.uptimeMillis();
      localLocalMediaInfo.listViewPosition = paramInt;
      a(paramHolder, localLocalMediaInfo);
    }
    return paramHolder;
  }
  
  public void b(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.startActivity(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.finish();
  }
  
  public void b(View paramView)
  {
    QAlbumUtil.clearSelectItemInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.finish();
    QAlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, false, false);
  }
  
  public void b(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramInt);
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getIntent();
    Object localObject1 = QAlbumUtil.sSelectItemAlbum;
    Object localObject2;
    if (!((HashMap)localObject1).containsKey(paramView.path))
    {
      localObject2 = new Pair(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
      ((HashMap)localObject1).put(paramView.path, localObject2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a(paramView.path);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getIntent();
      paramView.putExtra("ALBUM_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
      paramView.putExtra("ALBUM_ID", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramInt);
      paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", ((LocalMediaInfo)localObject1).position);
      paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
      paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex);
      paramView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      paramView.putExtra("PhotoConst.SHOW_ALBUM", true);
      PhotoListBaseData.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap;
      if (!((HashMap)localObject2).containsKey(((LocalMediaInfo)localObject1).path)) {
        ((HashMap)localObject2).put(((LocalMediaInfo)localObject1).path, localObject1);
      }
      paramView.putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject2);
      paramView.setClass(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, a());
      paramView.addFlags(603979776);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.startActivity(paramView);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.finish();
      QAlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, true, true);
    }
  }
  
  public View c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.c();
  }
  
  public RelativeLayout.LayoutParams c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.c();
  }
  
  public Holder c(@NonNull Holder paramHolder, int paramInt)
  {
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter$CheckBoxClickedListener.a(paramInt);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter$CheckBoxClickedListener.a(paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
    ImageView localImageView = paramHolder.jdField_b_of_type_AndroidWidgetImageView;
    localImageView.setAdjustViewBounds(false);
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramInt);
    Object localObject = QAlbumUtil.createContentDescription(1, localLocalMediaInfo, paramInt);
    paramHolder.jdField_b_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject);
    if (localLocalMediaInfo.isSystemMeidaStore) {
      localObject = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "VIDEO");
    } else {
      localObject = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "APP_VIDEO");
    }
    int i = AlbumThumbDownloader.THUMB_WIDHT;
    localLocalMediaInfo.thumbHeight = i;
    localLocalMediaInfo.thumbWidth = i;
    URLDrawable localURLDrawable = paramHolder.jdField_a_of_type_ComTencentImageURLDrawable;
    if ((localURLDrawable == null) || (!localURLDrawable.getURL().equals(localObject)))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PhotoListAdapter,getView(),vedio url :");
        localStringBuilder.append(((URL)localObject).toString());
        QLog.d("QQAlbum", 2, localStringBuilder.toString());
      }
      localObject = URLDrawableHelper.getDrawable((URL)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      ((URLDrawable)localObject).setTag(localLocalMediaInfo);
      localImageView.setImageDrawable((Drawable)localObject);
      paramHolder.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
      if (localURLDrawable != null) {
        localURLDrawable.cancelDownload();
      }
    }
    localObject = paramHolder.jdField_a_of_type_AndroidWidgetTextView;
    if ((!localLocalMediaInfo.isSystemMeidaStore) && (localLocalMediaInfo.mDuration <= 0L))
    {
      ((TextView)localObject).setVisibility(8);
      localObject = MediaScanner.getInstance(BaseApplication.getContext());
      if (localObject != null) {
        ((MediaScanner)localObject).queryMediaInfoDuration(this, localLocalMediaInfo, paramInt);
      }
    }
    else
    {
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(QAlbumUtil.formatTimeToString(localLocalMediaInfo.mDuration));
    }
    a(paramHolder, paramHolder.itemView, localLocalMediaInfo);
    localLocalMediaInfo.visableTime = SystemClock.uptimeMillis();
    localLocalMediaInfo.listViewPosition = paramInt;
    return paramHolder;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.m = true;
    b(null);
  }
  
  public void c(Intent paramIntent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    HashMap localHashMap1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap;
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject);
    HashMap localHashMap2 = new HashMap(localHashMap1);
    Iterator localIterator = ((ArrayList)localObject).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localObject = null;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap != null) {
        localObject = (LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap.get(str);
      }
      if (localObject != null)
      {
        localHashMap2.put(str, localObject);
      }
      else
      {
        localObject = (LocalMediaInfo)localHashMap1.get(str);
        if (localObject != null) {
          localHashMap2.put(str, localObject);
        }
      }
    }
    paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap2);
  }
  
  public void c(View paramView)
  {
    a(false, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getIntent());
  }
  
  public void c(View paramView, int paramInt) {}
  
  public RelativeLayout.LayoutParams d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.d();
  }
  
  public void e(Intent paramIntent) {}
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.o)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.runOnUiThread(new PhotoListCustomizationBase.1(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.o = true;
  }
  
  public void f(Intent paramIntent) {}
  
  public void g()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.m) {
      AlbumThumbManager.getInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity).clear();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter != null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.getItemCount();
      QAlbumUtil.sLastAlbumPhotoCountMap.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, Integer.valueOf(i));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidOsAsyncTask != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
    }
    i();
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.b != null)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.b;
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode) {
        i = 8;
      } else {
        i = 0;
      }
      localView.setVisibility(i);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase);
    }
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidOsAsyncTask = null;
  }
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase
 * JD-Core Version:    0.7.0.1
 */