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
    if (!this.e.selectedIndex.contains(paramLocalMediaInfo.position)) {
      this.e.selectedIndex.add(paramLocalMediaInfo.position);
    }
    if ((this.g.B) && (paramInt == 1))
    {
      PhotoListBaseData localPhotoListBaseData = this.g;
      localPhotoListBaseData.C += 1;
      if (this.g.C == 1) {
        this.g.E = paramLocalMediaInfo;
      }
    }
    if ((this.g.O) && (!this.e.selectedMediaInfoHashMap.containsKey(paramLocalMediaInfo.path))) {
      this.e.selectedMediaInfoHashMap.put(paramLocalMediaInfo.path, paramLocalMediaInfo);
    }
    if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
    {
      paramLocalMediaInfo = this.g;
      paramLocalMediaInfo.D += 1;
    }
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, PhotoCommonBaseData paramPhotoCommonBaseData, String[] paramArrayOfString, String paramString)
  {
    if ((this.g.B) && (paramArrayOfString != null) && ("video".equals(paramArrayOfString[0])))
    {
      paramArrayOfString = this.g;
      paramArrayOfString.C -= 1;
      if (this.g.C == 1) {
        this.g.E = paramLocalMediaInfo;
      }
    }
    if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
    {
      paramArrayOfString = this.g;
      paramArrayOfString.D -= 1;
    }
    paramPhotoCommonBaseData.selectedPhotoList.remove(paramLocalMediaInfo.path);
    paramPhotoCommonBaseData.selectedIndex.remove(paramLocalMediaInfo.position);
    paramPhotoCommonBaseData.selectedMediaInfoHashMap.remove(paramString);
    paramLocalMediaInfo.selectStatus = 2;
    paramLocalMediaInfo = (HashMap)QAlbumUtil.sSelectItemPosMap.get(this.e.albumId);
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
    if ((this.g.B) && (paramArrayOfString != null) && ("video".equals(paramArrayOfString[0])))
    {
      paramArrayOfString = this.g;
      paramArrayOfString.C += 1;
      if (this.g.C == 1) {
        this.g.E = paramLocalMediaInfo;
      }
    }
    if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
    {
      paramLocalMediaInfo = this.g;
      paramLocalMediaInfo.D += 1;
    }
  }
  
  private void a(@NonNull Holder paramHolder, View paramView, LocalMediaInfo paramLocalMediaInfo)
  {
    int i = paramLocalMediaInfo.selectStatus;
    if (i == 1)
    {
      paramHolder.f.setCheckedNumber(this.e.selectedPhotoList.indexOf(paramLocalMediaInfo.path) + 1);
      if (paramView.getBackground() != null) {
        paramView.setBackgroundDrawable(null);
      }
    }
    else if (i == 3)
    {
      paramHolder.f.setChecked(false);
    }
    else
    {
      paramHolder.f.setChecked(false);
      if (paramView.getBackground() != null) {
        paramView.setBackgroundDrawable(null);
      }
    }
    if ((this.e.selectedPhotoList.size() >= this.e.maxSelectNum) && (i != 1) && (!this.e.isSingleMode))
    {
      paramHolder.b.setAlpha(0.3F);
      return;
    }
    paramHolder.b.setAlpha(1.0F);
  }
  
  private void a(ArrayList<String> paramArrayList, LocalMediaInfo paramLocalMediaInfo, String paramString)
  {
    Object localObject = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    if ((this.g.B) && (localObject != null) && ("video".equals(localObject[0])))
    {
      localObject = this.g;
      ((PhotoListBaseData)localObject).C -= 1;
      if (this.g.C == 1) {
        this.g.E = paramLocalMediaInfo;
      }
    }
    if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
    {
      localObject = this.g;
      ((PhotoListBaseData)localObject).D -= 1;
    }
    paramArrayList.remove(paramString);
    this.e.selectedIndex.remove(paramLocalMediaInfo.position);
    this.e.selectedMediaInfoHashMap.remove(paramString);
    paramArrayList = (HashMap)QAlbumUtil.sSelectItemPosMap.get(this.e.albumId);
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
        if ((this.e.firstVideoInfo == null) && (localLocalMediaInfo.mMediaType == 1) && (("$RecentAlbumId".equals(this.e.albumId)) || ("$VideoAlbumId".equals(this.e.albumId)))) {
          this.e.firstVideoInfo = localLocalMediaInfo;
        }
        int i = QAlbumUtil.getMediaType(localLocalMediaInfo);
        localLocalMediaInfo.position = Integer.valueOf(this.e.mediaPathsList.size());
        this.e.mediaPathsList.add(localLocalMediaInfo.path);
        if (this.e.selectedPhotoList.contains(localLocalMediaInfo.path))
        {
          a(localLocalMediaInfo, i);
        }
        else if ((this.e.selectedPhotoList.size() < this.e.maxSelectNum) && (localLocalMediaInfo.path.equals(this.g.A)))
        {
          localLocalMediaInfo.selectStatus = 1;
          this.e.selectedPhotoList.add(localLocalMediaInfo.path);
          this.e.selectedIndex.add(localLocalMediaInfo.position);
          this.e.selectedMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
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
    if ((this.g.N) && (paramLong <= 60000L) && (paramInt == paramList.size()) && (paramLocalMediaInfo.path.equals(QAlbumUtil.sLastAlbumPath)))
    {
      paramLocalMediaInfo.selectStatus = 3;
      return;
    }
    paramLocalMediaInfo.selectStatus = 2;
  }
  
  private void a(List<LocalMediaInfo> paramList, PhotoCommonBaseData<O> paramPhotoCommonBaseData, HashMap<String, LocalMediaInfo> paramHashMap)
  {
    if ((this.g.P) && (paramPhotoCommonBaseData.albumId.equals("$VideoAlbumId")))
    {
      paramPhotoCommonBaseData = paramList.iterator();
      while (paramPhotoCommonBaseData.hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramPhotoCommonBaseData.next();
        if ((localLocalMediaInfo != null) && (!TextUtils.isEmpty(localLocalMediaInfo.path)))
        {
          PhotoListBaseData.x.remove(localLocalMediaInfo.path);
          paramHashMap.remove(localLocalMediaInfo.path);
        }
      }
      paramPhotoCommonBaseData = PhotoListBaseData.x.values();
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
    paramPhotoCommonBaseData = this.d.getIntent();
    if (!paramPhotoCommonBaseData.hasExtra("param_initTime")) {
      paramPhotoCommonBaseData.putExtra("param_initTime", System.currentTimeMillis());
    }
    paramLocalMediaInfo.selectStatus = 1;
    paramPhotoCommonBaseData = (LinkedHashMap)QAlbumUtil.sSelectItemPosMap.get(this.e.albumId);
    paramLocalMediaInfo = paramPhotoCommonBaseData;
    if (paramPhotoCommonBaseData == null)
    {
      paramLocalMediaInfo = new LinkedHashMap();
      QAlbumUtil.sSelectItemPosMap.put(this.e.albumId, paramLocalMediaInfo);
    }
    paramLocalMediaInfo.put(paramString, Integer.valueOf(this.h.m.findFirstVisibleItemPosition()));
    paramLocalMediaInfo = QAlbumUtil.sSelectItemAlbum;
    if (!paramLocalMediaInfo.containsKey(paramString)) {
      paramLocalMediaInfo.put(paramString, new Pair(this.e.albumId, this.e.albumName));
    }
  }
  
  private void b(ArrayList<String> paramArrayList, LocalMediaInfo paramLocalMediaInfo, String paramString)
  {
    a(paramLocalMediaInfo, MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType));
    paramArrayList.add(paramString);
    this.e.selectedIndex.add(paramLocalMediaInfo.position);
    this.e.selectedMediaInfoHashMap.put(paramString, paramLocalMediaInfo);
    paramArrayList = this.d.getIntent();
    if (!paramArrayList.hasExtra("param_initTime")) {
      paramArrayList.putExtra("param_initTime", System.currentTimeMillis());
    }
    paramLocalMediaInfo = (LinkedHashMap)QAlbumUtil.sSelectItemPosMap.get(this.e.albumId);
    paramArrayList = paramLocalMediaInfo;
    if (paramLocalMediaInfo == null)
    {
      paramArrayList = new LinkedHashMap();
      QAlbumUtil.sSelectItemPosMap.put(this.e.albumId, paramArrayList);
    }
    paramArrayList.put(paramString, Integer.valueOf(this.h.m.findFirstVisibleItemPosition()));
    paramArrayList = QAlbumUtil.sSelectItemAlbum;
    if (!paramArrayList.containsKey(paramString)) {
      paramArrayList.put(paramString, new Pair(this.e.albumId, this.e.albumName));
    }
  }
  
  private void b(List<LocalMediaInfo> paramList)
  {
    if (((this.g.O) && (this.e.albumId.equals("$RecentAlbumId"))) || ((this.g.P) && (this.e.albumId.equals("$VideoAlbumId")) && ((paramList.isEmpty()) || (((LocalMediaInfo)paramList.get(0)).mMediaType != 2))))
    {
      LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.mMimeType = "mobileqq/camera";
      localLocalMediaInfo.mMediaType = 2;
      paramList.add(0, localLocalMediaInfo);
    }
  }
  
  private void b(List<LocalMediaInfo> paramList, PhotoCommonBaseData<O> paramPhotoCommonBaseData, HashMap<String, LocalMediaInfo> paramHashMap)
  {
    if ((this.g.O) && (paramPhotoCommonBaseData.albumId.equals("$RecentAlbumId")))
    {
      paramPhotoCommonBaseData = paramList.iterator();
      while (paramPhotoCommonBaseData.hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramPhotoCommonBaseData.next();
        if ((localLocalMediaInfo != null) && (!TextUtils.isEmpty(localLocalMediaInfo.path)))
        {
          PhotoListBaseData.x.remove(localLocalMediaInfo.path);
          paramHashMap.remove(localLocalMediaInfo.path);
        }
      }
      paramList.addAll(0, PhotoListBaseData.x.values());
    }
  }
  
  public Holder a(@NonNull Holder paramHolder, int paramInt)
  {
    return paramHolder;
  }
  
  public List<LocalMediaInfo> a(Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAlbum", 2, "PhotoListCustomizationBase,doInBackground");
    }
    if ((this.e.mMediaQueryHelper == null) || (!this.e.albumId.equals(this.g.K))) {
      this.e.createMediaQueryHelper(this.d);
    }
    this.e.mMediaQueryHelper.queryNext();
    if ((this.e.firstRecentInfo == null) && ("$RecentAlbumId".equals(this.e.albumId)))
    {
      this.e.firstRecentInfo = this.e.mMediaQueryHelper.getFirstInfo();
      this.e.mMediaQueryHelper.upDateCount();
      if ((this.e.recentCountLimit > 0) && (this.e.recentCountLimit < this.e.mMediaQueryHelper.cursorsCount)) {
        this.e.recentCount = this.e.recentCountLimit;
      } else {
        this.e.recentCount = this.e.mMediaQueryHelper.cursorsCount;
      }
      this.e.videoCount = this.e.mMediaQueryHelper.cursorsVideoCount;
    }
    paramVarArgs = this.e.mMediaQueryHelper.mediaList;
    c(paramVarArgs);
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
    ArrayList localArrayList = this.e.selectedPhotoList;
    String str;
    if (this.e.customSendBtnText != null) {
      str = this.e.customSendBtnText;
    } else {
      str = this.d.getString(2131892542);
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
    if (this.h.o != null)
    {
      this.h.o.setText((CharSequence)localObject);
      this.h.o.setEnabled(bool);
    }
    if (this.h.n != null) {
      this.h.n.setEnabled(bool);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.g.J = paramInt1;
    if (paramInt2 == -1)
    {
      if (paramInt1 != 16) {
        return;
      }
      a(true, this.d.getIntent());
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.g.N = paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    this.g.K = this.e.albumId;
    if (paramIntent.getBooleanExtra("album_enter_directly", false))
    {
      long l1 = System.currentTimeMillis();
      long l2 = QAlbumUtil.sLastAlbumRecordTime;
      if ((this.g.N) && (l1 - l2 < 60000L))
      {
        this.e.albumName = QAlbumUtil.sLastAlbumName;
        this.e.albumId = QAlbumUtil.sLastAlbumId;
      }
    }
    else
    {
      this.e.albumName = paramIntent.getStringExtra("ALBUM_NAME");
      this.e.albumId = paramIntent.getStringExtra("ALBUM_ID");
    }
    if (this.e.albumId == null)
    {
      this.e.albumId = "$RecentAlbumId";
      this.e.albumName = null;
    }
    this.g.B = paramIntent.getBooleanExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", false);
    this.g.Q = paramIntent.getBooleanExtra("PeakConstants.showGifTypeIcon", false);
    Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
      this.e.selectedPhotoList = ((ArrayList)localObject);
    }
    if (this.e.selectedPhotoList == null) {
      this.e.selectedPhotoList = new ArrayList();
    }
    if (this.e.selectedMediaInfoHashMap == null) {
      this.e.selectedMediaInfoHashMap = new HashMap();
    }
    localObject = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if ((localObject != null) && (!((HashMap)localObject).isEmpty()) && (this.e.selectedPhotoList.size() == ((HashMap)localObject).size()))
    {
      this.e.selectedMediaInfoHashMap.clear();
      this.e.selectedMediaInfoHashMap.putAll((Map)localObject);
    }
    this.e.selectedIndex = new ArrayList();
    this.e.maxSelectNum = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    this.e.isSingleMode = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", true);
    if (this.e.maxSelectNum > 1) {
      this.e.isSingleMode = false;
    }
    this.e.showMediaType = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    this.e.filter = MediaFileFilter.getFilter(this.e.showMediaType);
    this.e.customSendBtnText = paramIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
    this.g.O = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_CAMERA", false);
    if (this.g.O) {
      this.g.P = paramIntent.getBooleanExtra("PhotoConst.SHOW_CAMERA_IN_VIDEO", false);
    }
    this.g.F = paramIntent.getIntExtra("PHOTOLIST_START_POSITION", -1);
    paramIntent.removeExtra("PHOTOLIST_START_POSITION");
  }
  
  public void a(Message paramMessage) {}
  
  public void a(View paramView) {}
  
  public void a(View paramView, int paramInt) {}
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    paramView = this.e.selectedPhotoList;
    if (this.e.isSingleMode) {
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
    Object localObject = this.h.t.a(paramInt);
    int j = ((LocalMediaInfo)localObject).selectStatus;
    bool = false;
    if ((j != 1) && (paramView.size() >= this.e.maxSelectNum))
    {
      long l = System.currentTimeMillis();
      if (l - this.g.H >= 1000L)
      {
        QQToast.makeText(this.d, c((LocalMediaInfo)localObject), 0).show();
        paramCheckBox.setChecked(false);
        this.g.H = l;
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
    this.h.a(paramInt, bool);
    this.h.b(bool ^ true);
  }
  
  public void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent) {}
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  protected void a(Holder paramHolder, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void a(List<LocalMediaInfo> paramList, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    long l2 = QAlbumUtil.sLastAlbumRecordTime;
    int i;
    if (QAlbumUtil.sLastAlbumPhotoCountMap.containsKey(this.e.albumId)) {
      i = ((Integer)QAlbumUtil.sLastAlbumPhotoCountMap.get(this.e.albumId)).intValue();
    } else {
      i = 0;
    }
    int j = paramList.size();
    a(paramList, paramInt, l1 - l2, i);
    while (paramInt < j)
    {
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramList.get(paramInt);
      if (localLocalMediaInfo.path != null) {
        this.e.allMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
      }
      paramInt += 1;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, Intent paramIntent)
  {
    paramIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    ArrayList localArrayList = this.e.selectedPhotoList;
    if (!paramBoolean) {
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    } else {
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.g.A);
    }
    paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.e.selectedMediaInfoHashMap);
    paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
    paramIntent.putExtra("ALBUM_NAME", this.e.albumName);
    paramIntent.putExtra("ALBUM_ID", this.e.albumId);
    paramIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    PhotoListBaseData.w = this.h.m.findFirstVisibleItemPosition();
    paramIntent.setClass(this.d, i());
    paramIntent.addFlags(603979776);
    b(paramIntent);
    QAlbumUtil.anim(this.d, true, true);
  }
  
  public void a(boolean paramBoolean, LocalMediaInfo paramLocalMediaInfo) {}
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    PhotoCommonBaseData localPhotoCommonBaseData = this.e;
    String[] arrayOfString = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    if ((!this.g.B) && (arrayOfString != null) && (!"image".equals(arrayOfString[0]))) {
      return false;
    }
    int i = paramLocalMediaInfo.selectStatus;
    if (a(paramBoolean, i)) {
      return false;
    }
    if ((i == 2) && (paramBoolean) && (localPhotoCommonBaseData.selectedPhotoList.size() >= localPhotoCommonBaseData.maxSelectNum))
    {
      long l = System.currentTimeMillis();
      if (l - this.g.H >= 700L)
      {
        QQToast.makeText(this.d, c(paramLocalMediaInfo), 1000).show();
        this.g.H = l;
        this.g.I = true;
      }
      return false;
    }
    this.g.I = false;
    String str = paramLocalMediaInfo.path;
    if (paramBoolean) {
      b(paramLocalMediaInfo, localPhotoCommonBaseData, arrayOfString, str);
    } else {
      a(paramLocalMediaInfo, localPhotoCommonBaseData, arrayOfString, str);
    }
    this.h.b(paramBoolean ^ true);
    return true;
  }
  
  public boolean a(List<LocalMediaInfo> paramList)
  {
    if (this.d == null) {
      return false;
    }
    if (paramList == null)
    {
      Object localObject;
      if ((!this.g.O) || (!this.e.albumId.equals("$RecentAlbumId")))
      {
        localObject = paramList;
        if (this.g.P)
        {
          localObject = paramList;
          if (!this.e.albumId.equals("$VideoAlbumId")) {}
        }
      }
      else
      {
        paramList = new LocalMediaInfo();
        paramList.mMimeType = "mobileqq/camera";
        localObject = new ArrayList();
        ((List)localObject).add(0, paramList);
      }
      this.h.t.a((List)localObject);
      this.h.t.notifyDataSetChanged();
      a();
      QQToast.makeText(this.d, "暂无媒体文件", 1000).show();
      return false;
    }
    this.h.t.a(paramList);
    if (paramList.isEmpty()) {
      QQToast.makeText(this.d, "暂无媒体文件", 1000).show();
    }
    this.h.t.notifyDataSetChanged();
    a();
    return true;
  }
  
  public Intent b(View paramView, int paramInt)
  {
    paramView = this.h.t.a(paramInt);
    Intent localIntent = this.d.getIntent();
    localIntent.putExtra("ALBUM_NAME", this.e.albumName);
    localIntent.putExtra("ALBUM_ID", this.e.albumId);
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.e.selectedPhotoList);
    localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.e.selectedIndex);
    if (QAlbumUtil.getMediaType(paramView) == 0) {
      localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramView.position);
    }
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", true);
    PhotoListBaseData.w = this.h.m.findFirstVisibleItemPosition();
    if (!this.e.selectedMediaInfoHashMap.containsKey(paramView.path)) {
      this.e.selectedMediaInfoHashMap.put(paramView.path, paramView);
    }
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.e.selectedMediaInfoHashMap);
    localIntent.setClass(this.d, i());
    localIntent.addFlags(603979776);
    return localIntent;
  }
  
  public Holder b(@NonNull Holder paramHolder, int paramInt)
  {
    Object localObject1 = paramHolder.itemView;
    paramHolder.k.a(paramInt);
    paramHolder.k.a(paramHolder.f);
    ImageView localImageView = paramHolder.b;
    localImageView.setAdjustViewBounds(false);
    LocalMediaInfo localLocalMediaInfo = this.h.t.a(paramInt);
    Object localObject2 = QAlbumUtil.createContentDescription(0, localLocalMediaInfo, paramInt);
    paramHolder.b.setContentDescription((CharSequence)localObject2);
    if (localLocalMediaInfo != null)
    {
      paramHolder.a.setVisibility(4);
      if ((this.g.Q) && (QAlbumUtil.isGif(localLocalMediaInfo)))
      {
        if (paramHolder.j == null)
        {
          paramHolder.j = this.h.t.b();
          paramHolder.j.setText("GIF");
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout)paramHolder.itemView).addView(paramHolder.j, (ViewGroup.LayoutParams)localObject2);
        }
        paramHolder.j.setVisibility(0);
      }
      else if (paramHolder.j != null)
      {
        paramHolder.j.setVisibility(8);
      }
      int i = AlbumThumbDownloader.THUMB_WIDHT;
      localLocalMediaInfo.thumbHeight = i;
      localLocalMediaInfo.thumbWidth = i;
      localObject2 = paramHolder.g;
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
        localObject2 = URLDrawableHelper.getDrawable((URL)localObject2, this.h.t.e, this.h.t.c);
        ((URLDrawable)localObject2).setTag(localLocalMediaInfo);
        localImageView.setImageDrawable((Drawable)localObject2);
        paramHolder.g = ((URLDrawable)localObject2);
      }
      a(paramHolder, (View)localObject1, localLocalMediaInfo);
      if (AppSetting.e)
      {
        localObject1 = QAlbumUtil.createContentDescriptionWithCheckBox(0, localLocalMediaInfo, paramInt, paramHolder.f.isChecked());
        paramHolder.f.setContentDescription((CharSequence)localObject1);
      }
      localLocalMediaInfo.visableTime = SystemClock.uptimeMillis();
      localLocalMediaInfo.listViewPosition = paramInt;
      a(paramHolder, localLocalMediaInfo);
    }
    return paramHolder;
  }
  
  public void b(Intent paramIntent)
  {
    this.d.startActivity(paramIntent);
    this.d.finish();
  }
  
  public void b(View paramView)
  {
    QAlbumUtil.clearSelectItemInfo();
    this.d.finish();
    QAlbumUtil.anim(this.d, false, false);
  }
  
  public Holder c(@NonNull Holder paramHolder, int paramInt)
  {
    paramHolder.k.a(paramInt);
    paramHolder.k.a(paramHolder.f);
    ImageView localImageView = paramHolder.b;
    localImageView.setAdjustViewBounds(false);
    LocalMediaInfo localLocalMediaInfo = this.h.t.a(paramInt);
    Object localObject = QAlbumUtil.createContentDescription(1, localLocalMediaInfo, paramInt);
    paramHolder.b.setContentDescription((CharSequence)localObject);
    if (localLocalMediaInfo.isSystemMeidaStore) {
      localObject = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "VIDEO");
    } else {
      localObject = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "APP_VIDEO");
    }
    int i = AlbumThumbDownloader.THUMB_WIDHT;
    localLocalMediaInfo.thumbHeight = i;
    localLocalMediaInfo.thumbWidth = i;
    URLDrawable localURLDrawable = paramHolder.g;
    if ((localURLDrawable == null) || (!localURLDrawable.getURL().equals(localObject)))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PhotoListAdapter,getView(),vedio url :");
        localStringBuilder.append(((URL)localObject).toString());
        QLog.d("QQAlbum", 2, localStringBuilder.toString());
      }
      localObject = URLDrawableHelper.getDrawable((URL)localObject, this.h.t.e, this.h.t.c);
      ((URLDrawable)localObject).setTag(localLocalMediaInfo);
      localImageView.setImageDrawable((Drawable)localObject);
      paramHolder.g = ((URLDrawable)localObject);
      if (localURLDrawable != null) {
        localURLDrawable.cancelDownload();
      }
    }
    localObject = paramHolder.h;
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
  
  public String c(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.e.maxSelectNum;
    return this.d.getResources().getString(2131892559, new Object[] { Integer.valueOf(i) });
  }
  
  public void c(Intent paramIntent)
  {
    Object localObject = this.e.selectedPhotoList;
    HashMap localHashMap1 = this.e.selectedMediaInfoHashMap;
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject);
    HashMap localHashMap2 = new HashMap(localHashMap1);
    Iterator localIterator = ((ArrayList)localObject).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localObject = null;
      if (this.e.allMediaInfoHashMap != null) {
        localObject = (LocalMediaInfo)this.e.allMediaInfoHashMap.get(str);
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
    a(false, this.d.getIntent());
  }
  
  public void c(View paramView, int paramInt)
  {
    paramView = this.h.t.a(paramInt);
    if (paramView == null) {
      return;
    }
    this.d.getIntent();
    Object localObject1 = QAlbumUtil.sSelectItemAlbum;
    Object localObject2;
    if (!((HashMap)localObject1).containsKey(paramView.path))
    {
      localObject2 = new Pair(this.e.albumId, this.e.albumName);
      ((HashMap)localObject1).put(paramView.path, localObject2);
    }
    this.h.a(paramView.path);
    if (!this.e.isSingleMode)
    {
      paramView = this.d.getIntent();
      paramView.putExtra("ALBUM_NAME", this.e.albumName);
      paramView.putExtra("ALBUM_ID", this.e.albumId);
      localObject1 = this.h.t.a(paramInt);
      paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", ((LocalMediaInfo)localObject1).position);
      paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.e.selectedPhotoList);
      paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.e.selectedIndex);
      paramView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      paramView.putExtra("PhotoConst.SHOW_ALBUM", true);
      PhotoListBaseData.w = this.h.m.findFirstVisibleItemPosition();
      localObject2 = this.e.selectedMediaInfoHashMap;
      if (!((HashMap)localObject2).containsKey(((LocalMediaInfo)localObject1).path)) {
        ((HashMap)localObject2).put(((LocalMediaInfo)localObject1).path, localObject1);
      }
      paramView.putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject2);
      paramView.setClass(this.d, i());
      paramView.addFlags(603979776);
      this.d.startActivity(paramView);
      this.d.finish();
      QAlbumUtil.anim(this.d, true, true);
    }
  }
  
  public void c(List<LocalMediaInfo> paramList)
  {
    PhotoCommonBaseData localPhotoCommonBaseData = this.e;
    if (localPhotoCommonBaseData.selectedPhotoList == null) {
      localPhotoCommonBaseData.selectedPhotoList = new ArrayList();
    }
    Object localObject = localPhotoCommonBaseData.selectedPhotoList;
    if (localPhotoCommonBaseData.selectedMediaInfoHashMap == null) {
      localPhotoCommonBaseData.selectedMediaInfoHashMap = new HashMap();
    }
    localObject = localPhotoCommonBaseData.selectedMediaInfoHashMap;
    LogTag.a();
    this.g.C = 0;
    this.g.D = 0;
    if (this.e.allMediaInfoHashMap == null)
    {
      this.e.allMediaInfoHashMap = new HashMap();
    }
    else
    {
      Iterator localIterator = this.e.selectedPhotoList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((this.e.allMediaInfoHashMap.containsKey(str)) && (!this.e.selectedMediaInfoHashMap.containsKey(str))) {
          this.e.selectedMediaInfoHashMap.put(str, this.e.allMediaInfoHashMap.get(str));
        }
      }
      localPhotoCommonBaseData.allMediaInfoHashMap.clear();
    }
    if (this.e.mediaPathsList != null) {
      this.e.mediaPathsList.clear();
    } else {
      this.e.mediaPathsList = new ArrayList();
    }
    b(paramList, localPhotoCommonBaseData, (HashMap)localObject);
    a(paramList, localPhotoCommonBaseData, (HashMap)localObject);
  }
  
  public void d(View paramView, int paramInt) {}
  
  public void e()
  {
    this.g.z = true;
    b(null);
  }
  
  public void e(Intent paramIntent) {}
  
  public void f(Intent paramIntent) {}
  
  public void g()
  {
    if (this.g.G)
    {
      this.d.runOnUiThread(new PhotoListCustomizationBase.1(this));
      return;
    }
    this.g.G = true;
  }
  
  public void h()
  {
    if (!this.g.z) {
      AlbumThumbManager.getInstance(this.d).clear();
    }
    if (this.h.t != null)
    {
      int i = this.h.t.getItemCount();
      QAlbumUtil.sLastAlbumPhotoCountMap.put(this.e.albumId, Integer.valueOf(i));
    }
    if (this.h.k != null) {
      this.h.k.cancel(true);
    }
    u();
  }
  
  public Class i()
  {
    return AbstractPhotoPreviewActivity.class;
  }
  
  public AbstractAlbumListFragment j()
  {
    return new AbstractAlbumListFragment();
  }
  
  public void k()
  {
    this.h.c();
    if (this.h.h != null)
    {
      View localView = this.h.h;
      int i;
      if (this.e.isSingleMode) {
        i = 8;
      } else {
        i = 0;
      }
      localView.setVisibility(i);
    }
    if (this.h.o != null) {
      this.h.o.setOnClickListener(this.h);
    }
  }
  
  public View m()
  {
    return this.h.m();
  }
  
  public RelativeLayout.LayoutParams n()
  {
    return this.h.n();
  }
  
  public View o()
  {
    return this.h.o();
  }
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo) {}
  
  public RelativeLayout.LayoutParams p()
  {
    return this.h.p();
  }
  
  public View q()
  {
    return this.h.q();
  }
  
  public RelativeLayout.LayoutParams r()
  {
    return this.h.r();
  }
  
  public RelativeLayout.LayoutParams s()
  {
    return this.h.s();
  }
  
  public void v()
  {
    this.h.k = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase
 * JD-Core Version:    0.7.0.1
 */