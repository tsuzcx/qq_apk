package com.tencent.mobileqq.activity.photo.album;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowViewController;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowViewController.SlideShowActionListener;
import com.tencent.biz.qqstory.takevideo.slideshow.TransitionHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.ReplacePhotoDataUtil;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.TroopPhotoUtil;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoUtil;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.servlet.QZoneAlbumListNumServlet;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PhotoGridView;
import cooperation.qzone.util.QZLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class PhotoListLogicDefault
  extends PhotoListLogicBase<NewPhotoListActivity, PhotoOtherData>
  implements SlideShowViewController.SlideShowActionListener, PhotoListLogic.IadapterCallback, PhotoListLogic.IcheckBoxCallback, PhotoListLogic.IitemClickCallback
{
  public PhotoListData a;
  
  public PhotoListLogicDefault(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
    this.mPhotoListData = new PhotoListData();
    this.a = ((PhotoListData)this.mPhotoListData);
  }
  
  int a(List<LocalMediaInfo> paramList)
  {
    int i;
    int k;
    int j;
    if (this.a.photoListStartPos == -1)
    {
      i = PhotoListData.sPhotoListFirstPos;
      if (i != -1) {
        break label321;
      }
      Object localObject = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
      k = i;
      if (localObject != null)
      {
        j = ((LinkedHashMap)localObject).size();
        k = i;
        if (j > 0) {
          k = ((Integer)((LinkedHashMap)localObject).get(localObject.keySet().toArray()[(j - 1)])).intValue();
        }
      }
      j = k;
      if (k == -1)
      {
        j = k;
        if (this.a.isRecodeLastAlbumPath)
        {
          localObject = paramList.iterator();
          i = 0;
          label118:
          j = k;
          if (((Iterator)localObject).hasNext())
          {
            if (((LocalMediaInfo)((Iterator)localObject).next()).selectStatus != 3) {
              break label305;
            }
            j = i;
          }
        }
      }
      localObject = this.mPhotoCommonData.selectedPhotoList;
      i = j;
      if (j == -1)
      {
        i = j;
        if (this.mPhotoCommonData.albumId.equals("$RecentAlbumId"))
        {
          i = j;
          if (!((ArrayList)localObject).isEmpty())
          {
            int m = paramList.size();
            localObject = (String)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
            k = 0;
            label221:
            i = j;
            if (k < m)
            {
              if (!((String)localObject).equals(((LocalMediaInfo)paramList.get(k)).path)) {
                break label312;
              }
              i = k;
            }
          }
        }
      }
    }
    for (;;)
    {
      k = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItemCount();
      if ((k > 0) && (i != -1))
      {
        j = i;
        if (i <= k - 1) {}
      }
      else
      {
        j = 0;
      }
      return j;
      i = this.a.photoListStartPos;
      break;
      label305:
      i += 1;
      break label118;
      label312:
      k += 1;
      break label221;
      label321:
      PhotoListData.sPhotoListFirstPos = -1;
    }
  }
  
  protected PhotoOtherData a()
  {
    return new PhotoListLogicDefault.1(this);
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    AbstractPhotoListActivity.PhotoListAdapter localPhotoListAdapter = ((NewPhotoListActivity)this.mActivity).photoListAdapter;
    if ((paramInt1 >= 0) && (paramInt1 < localArrayList.size()) && (paramInt2 >= 0) && (paramInt2 < localArrayList.size()))
    {
      Collections.swap(localArrayList, paramInt1, paramInt2);
      paramInt2 = ((NewPhotoListActivity)this.mActivity).gridLayoutManager.findFirstVisibleItemPosition();
      int i = ((NewPhotoListActivity)this.mActivity).gridLayoutManager.findLastVisibleItemPosition();
      paramInt1 = paramInt2;
      while (paramInt1 <= i)
      {
        Object localObject = localPhotoListAdapter.getItem(paramInt1);
        int j = localArrayList.indexOf(((LocalMediaInfo)localObject).path);
        if (j >= 0)
        {
          localObject = (AbstractPhotoListActivity.Holder)((NewPhotoListActivity)this.mActivity).mGridView.getChildAt(((LocalMediaInfo)localObject).position.intValue() - paramInt2).getTag();
          if ((localObject != null) && (((AbstractPhotoListActivity.Holder)localObject).mCheckBox != null)) {
            ((AbstractPhotoListActivity.Holder)localObject).mCheckBox.setCheckedNumber(j + 1);
          }
        }
        paramInt1 += 1;
      }
      SlideShowPhotoListManager.a().b(localArrayList, this.mPhotoCommonData.allMediaInfoHashMap);
    }
    ((NewPhotoListActivity)this.mActivity).selectLimitRemind(true);
  }
  
  protected void a(Intent paramIntent)
  {
    ((NewPhotoListActivity)this.mActivity).startActivity(paramIntent);
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    int i2 = PhotoUtils.getTypeforReportSpcialDiscuss(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    Object localObject1 = new HashMap();
    int j = 0;
    int i = 0;
    int i1 = 0;
    int k = 0;
    while (i1 < paramArrayList.size())
    {
      localObject2 = (String)paramArrayList.get(i1);
      int m;
      if (ImageManager.isNetworkUrl((String)localObject2))
      {
        m = k;
        k = i;
        i = m;
        i1 += 1;
        m = k;
        k = i;
        i = m;
      }
      else
      {
        int n;
        if (((PhotoOtherData)this.mOtherCommonData).a(this.mPhotoCommonData, (String)localObject2) == 1)
        {
          localObject2 = ((PhotoOtherData)this.mOtherCommonData).a(this.mPhotoCommonData, (String)localObject2);
          n = j;
          m = i;
          if (localObject2 != null)
          {
            localObject3 = new SendVideoActivity.SendVideoInfo();
            ((SendVideoActivity.SendVideoInfo)localObject3).fileSize = ((LocalMediaInfo)localObject2).fileSize;
            ((SendVideoActivity.SendVideoInfo)localObject3).duration = ((LocalMediaInfo)localObject2).mDuration;
            ((HashMap)localObject1).put(Integer.valueOf(k), localObject3);
            m = i + 1;
            n = j;
          }
        }
        for (;;)
        {
          i = k + 1;
          j = n;
          k = m;
          break;
          n = j + 1;
          m = i;
        }
      }
    }
    Object localObject2 = String.valueOf(j);
    Object localObject3 = String.valueOf(i);
    if (!((HashMap)localObject1).isEmpty()) {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", (Serializable)localObject1);
    }
    for (i = 1;; i = 0)
    {
      if ((ShortVideoBusiManager.b != 0L) && (System.currentTimeMillis() - ShortVideoBusiManager.b < 300000L)) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + ShortVideoBusiManager.b);
        }
        if ((!NetworkUtil.b(BaseApplicationImpl.getContext())) || (bool) || (i == 0)) {
          break;
        }
        localObject1 = ((NewPhotoListActivity)this.mActivity).getResources().getString(2131719019);
        paramIntent = new PhotoListLogicDefault.2(this, paramBoolean, paramIntent, paramArrayList, i2, (String)localObject2, (String)localObject3);
        if (FreeWifiHelper.a(this.mActivity, 4, new PhotoListLogicDefault.3(this, paramIntent))) {
          DialogUtil.a(this.mActivity, 232, null, (String)localObject1, new PhotoListLogicDefault.4(this, paramIntent), new PhotoListLogicDefault.5(this)).show();
        }
        if (QLog.isColorLevel()) {
          QLog.i("PhotoListActivity", 2, "show shortvideo_mobile_send_confirm dialog");
        }
        return;
      }
      if (paramBoolean) {
        PhotoUtils.sendPhoto(this.mActivity, paramIntent, paramArrayList, this.a.jdField_a_of_type_JavaUtilHashMap, this.mPhotoCommonData.currentQualityType, false);
      }
      for (;;)
      {
        ReportController.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", i2, 0, (String)localObject2, (String)localObject3, "", "");
        return;
        PhotoUtils.sendPhoto(this.mActivity, paramIntent, paramArrayList, this.mPhotoCommonData.currentQualityType, this.a.jdField_a_of_type_Boolean);
      }
    }
  }
  
  public void a(SlideItemInfo paramSlideItemInfo)
  {
    Object localObject1 = ((NewPhotoListActivity)this.mActivity).photoListAdapter;
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    Object localObject2;
    int i;
    if ((localObject1 != null) && (paramSlideItemInfo != null))
    {
      localObject2 = ((AbstractPhotoListActivity.PhotoListAdapter)localObject1).getPhotoList();
      i = 0;
      if (i >= ((List)localObject2).size()) {
        break label542;
      }
      if (!((LocalMediaInfo)((List)localObject2).get(i)).path.equals(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {
        break label391;
      }
    }
    for (;;)
    {
      if ((i >= 0) && (i < ((List)localObject2).size()))
      {
        paramSlideItemInfo = ((AbstractPhotoListActivity.PhotoListAdapter)localObject1).getItem(i);
        paramSlideItemInfo.selectStatus = 2;
        localObject1 = paramSlideItemInfo.path;
        localObject2 = MimeHelper.getMimeType(paramSlideItemInfo.mMimeType);
        if ((this.a.isSupportVideoCheckbox) && (localObject2 != null) && ("video".equals(localObject2[0])))
        {
          localObject2 = this.a;
          ((PhotoListData)localObject2).videoSelectedCnt -= 1;
          if (this.a.videoSelectedCnt == 1) {
            this.a.selectedVideoInfo = paramSlideItemInfo;
          }
        }
        if ((!TextUtils.isEmpty(paramSlideItemInfo.mMimeType)) && ("image/gif".equals(paramSlideItemInfo.mMimeType)))
        {
          localObject2 = this.a;
          ((PhotoListData)localObject2).gifSelectedCount -= 1;
        }
        this.mPhotoCommonData.selectedPhotoList.remove(localObject1);
        this.mPhotoCommonData.selectedIndex.remove(paramSlideItemInfo.position);
        if (this.mPhotoCommonData.needMediaInfo) {
          this.mPhotoCommonData.selectedMediaInfoHashMap.remove(localObject1);
        }
        StatisticConstants.a(((NewPhotoListActivity)this.mActivity).getIntent(), "param_cancelSelNum");
        localObject2 = (HashMap)AlbumUtil.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
        if (localObject2 != null) {
          ((HashMap)localObject2).remove(localObject1);
        }
        localObject2 = AlbumUtil.sSelectItemAlbum;
        if (((HashMap)localObject2).containsKey(localObject1)) {
          ((HashMap)localObject2).remove(localObject1);
        }
        if (this.mSelectionListener != null) {
          this.mSelectionListener.onSelectionChange(false, paramSlideItemInfo);
        }
        ((NewPhotoListActivity)this.mActivity).updateCheckbox(i, false);
        updateButton();
        SlideShowPhotoListManager.a().b(localArrayList, this.mPhotoCommonData.allMediaInfoHashMap);
      }
      label391:
      while (i != -1)
      {
        return;
        i += 1;
        break;
      }
      localArrayList.remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      if (this.mPhotoCommonData.needMediaInfo) {
        this.mPhotoCommonData.selectedMediaInfoHashMap.remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      StatisticConstants.a(((NewPhotoListActivity)this.mActivity).getIntent(), "param_cancelSelNum");
      localObject1 = (HashMap)AlbumUtil.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
      if (localObject1 != null) {
        ((HashMap)localObject1).remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      localObject1 = AlbumUtil.sSelectItemAlbum;
      if (((HashMap)localObject1).containsKey(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {
        ((HashMap)localObject1).remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      ((NewPhotoListActivity)this.mActivity).updateCheckboxForDelete();
      updateButton();
      SlideShowPhotoListManager.a().b(localArrayList, this.mPhotoCommonData.allMediaInfoHashMap);
      return;
      label542:
      i = -1;
    }
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo)
  {
    e(paramLocalMediaInfo);
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    AlbumUtil.a();
    String str = paramLocalMediaInfo.path;
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
    localIntent.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
    localIntent.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
    localIntent.putExtra("media_info", paramLocalMediaInfo);
    if (localIntent.getBooleanExtra("PhotoConst.MULTI_PREVIEW_IN_SINGLE_MODE", false))
    {
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.mediaPathsList);
      localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramLocalMediaInfo.position);
    }
    if (this.a.f)
    {
      paramLocalMediaInfo = AlbumUtil.sSelectItemAlbum;
      if (!paramLocalMediaInfo.containsKey(str)) {
        paramLocalMediaInfo.put(str, new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName));
      }
      ((NewPhotoListActivity)this.mActivity).recordLastPos(str);
      PhotoUtils.sendPhoto(this.mActivity, localIntent, this.mPhotoCommonData.selectedPhotoList, 0, this.a.jdField_a_of_type_Boolean);
      return;
    }
    if (!this.a.g)
    {
      localIntent.putExtra("PhotoConst.ALLOW_LOCK", false);
      localIntent.setClass(this.mActivity, NewPhotoPreviewActivity.class);
      localIntent.putExtra("PasterConstants.pasters_data", this.a.jdField_b_of_type_JavaUtilHashMap);
      localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      localIntent.putExtra("PhotoConst.SOURCE_FROM", "FROM_SELECT_PHOTO");
      localIntent.addFlags(603979776);
      ((NewPhotoListActivity)this.mActivity).startActivity(localIntent);
      ((NewPhotoListActivity)this.mActivity).finish();
      AlbumUtil.anim(this.mActivity, true, true);
      return;
    }
    paramInt = localIntent.getIntExtra("Business_Origin", 0);
    if ((100 == paramInt) || (102 == paramInt) || (103 == paramInt)) {
      if (100 == paramInt)
      {
        int i = ProfileCardUtil.b(this.mActivity);
        localIntent.putExtra("PhotoConst.CLIP_WIDTH", i);
        localIntent.putExtra("PhotoConst.CLIP_HEIGHT", i);
        localIntent.putExtra("PhotoConst.TARGET_WIDTH", 1080);
        localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 1080);
        localIntent.putExtra("PhotoConst.TARGET_SAMPLE_SIZE", 1620);
        label441:
        localIntent.setClass(this.mActivity, PhotoCropForPortraitActivity.class);
        localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", TroopPhotoUtil.c(paramInt));
      }
    }
    for (;;)
    {
      AlbumUtil.a(localIntent, this.mPhotoCommonData.albumId, str, this.a.isRecodeLastAlbumPath);
      localIntent.putExtra("PHOTOLIST_START_POSITION", ((NewPhotoListActivity)this.mActivity).gridLayoutManager.findFirstVisibleItemPosition());
      break;
      localIntent.putExtra("PhotoConst.IS_WITH_PENDANT", false);
      localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
      localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
      break label441;
      localIntent.setClass(this.mActivity, PhotoCropActivity.class);
    }
  }
  
  public void a(String paramString)
  {
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    HashMap localHashMap = this.mPhotoCommonData.selectedMediaInfoHashMap;
    localIntent.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
    localIntent.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
    int j = localArrayList.size();
    Object localObject = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      ((ArrayList)localObject).add(Integer.valueOf(i));
      i += 1;
    }
    localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", (ArrayList)localObject);
    i = localArrayList.indexOf(paramString);
    if ((i > 0) && (i < ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItemCount()))
    {
      localObject = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(i);
      if ((localObject != null) && (!localHashMap.containsKey(((LocalMediaInfo)localObject).path))) {
        localHashMap.put(((LocalMediaInfo)localObject).path, localObject);
      }
    }
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap);
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    PhotoListData.sPhotoListFirstPos = ((NewPhotoListActivity)this.mActivity).gridLayoutManager.findFirstVisibleItemPosition();
    localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", localArrayList.indexOf(paramString));
    localIntent.setClass(this.mActivity, NewPhotoPreviewActivity.class);
    localIntent.addFlags(603979776);
    startPhotoPreviewActivity(localIntent);
    AlbumUtil.anim(this.mActivity, true, true);
  }
  
  boolean a(LocalMediaInfo paramLocalMediaInfo, CheckBox paramCheckBox)
  {
    long l;
    if ((paramLocalMediaInfo.selectStatus != 1) && (this.mPhotoCommonData.selectedPhotoList.size() >= this.mPhotoCommonData.maxSelectNum))
    {
      l = System.currentTimeMillis();
      if (l - this.a.lastTimeShowToast >= 1000L)
      {
        QQToast.a(this.mActivity, getExceedMaxSelectNumStr(paramLocalMediaInfo), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
        paramCheckBox.setChecked(false);
        this.a.lastTimeShowToast = l;
      }
      return false;
    }
    if ((this.a.jdField_a_of_type_Int == 9501) && (((NewPhotoListActivity)this.mActivity).getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false)) && (paramLocalMediaInfo.selectStatus != 1))
    {
      Iterator localIterator = this.mPhotoCommonData.selectedPhotoList.iterator();
      for (l = 0L; localIterator.hasNext(); l = FileUtils.a((String)localIterator.next()) + l) {}
      if (FileUtils.a(paramLocalMediaInfo.path) + l > 52428800L)
      {
        QQToast.a(this.mActivity, "选择图片总大小不能超过50M", 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
        paramCheckBox.setChecked(false);
        return false;
      }
    }
    if ((((NewPhotoListActivity)this.mActivity).getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (((NewPhotoListActivity)this.mActivity).isGif(paramLocalMediaInfo)) && (FileUtils.a(paramLocalMediaInfo.path) > 3145728L))
    {
      QQToast.a(this.mActivity, "图片文件过大", 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      paramCheckBox.setChecked(false);
      return false;
    }
    return (!((PhotoOtherData)this.mOtherCommonData).a()) || (QQStoryFlowCallback.a(this.mActivity, paramLocalMediaInfo));
  }
  
  protected boolean addAndRemovePhotoByGesture(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    boolean bool = false;
    PhotoCommonBaseData localPhotoCommonBaseData = this.mPhotoCommonData;
    String[] arrayOfString = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    if ((!this.a.isSupportVideoCheckbox) && (arrayOfString != null) && (!"image".equals(arrayOfString[0]))) {}
    long l;
    do
    {
      int i;
      do
      {
        return false;
        i = paramLocalMediaInfo.selectStatus;
      } while (((i == 1) && (paramBoolean)) || ((i == 2) && (!paramBoolean)));
      if ((i != 2) || (!paramBoolean) || (localPhotoCommonBaseData.selectedPhotoList.size() < localPhotoCommonBaseData.maxSelectNum)) {
        break;
      }
      l = System.currentTimeMillis();
    } while (l - this.a.lastTimeShowToast < 700L);
    QQToast.a(this.mActivity, getExceedMaxSelectNumStr(paramLocalMediaInfo), 1000).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
    this.a.lastTimeShowToast = l;
    this.a.hasShownMaxSelectToast = true;
    return false;
    this.a.hasShownMaxSelectToast = false;
    if (paramBoolean) {
      a(paramLocalMediaInfo);
    }
    for (;;)
    {
      paramLocalMediaInfo = (NewPhotoListActivity)this.mActivity;
      if (!paramBoolean) {
        bool = true;
      }
      paramLocalMediaInfo.selectLimitRemind(bool);
      return true;
      b(paramLocalMediaInfo);
    }
  }
  
  protected void b()
  {
    if (this.mPhotoCommonData.albumId.equals("$RecentAlbumId")) {
      StatisticCollector.getInstance(this.mActivity).collectPerformance(null, "sendAlbumRecent", true, 0L, 0L, null, "");
    }
    while ((this.a.e) && ((!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString))))
    {
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton.performClick();
      return;
      if ((this.mPhotoCommonData.albumName.equalsIgnoreCase("Camera")) || (this.mPhotoCommonData.albumName.equalsIgnoreCase("camera")) || (this.mPhotoCommonData.albumName.contains("Camera")) || (this.mPhotoCommonData.albumName.contains("camera"))) {
        StatisticCollector.getInstance(this.mActivity).collectPerformance(null, "sendAlbumRecent", false, 0L, 0L, null, "");
      } else {
        StatisticCollector.getInstance(this.mActivity).collectPerformance(null, "sendAlbumOther", true, 0L, 0L, null, "");
      }
    }
    if (this.mPhotoCommonData.selectedPhotoList != null)
    {
      StatisticConstants.a(((NewPhotoListActivity)this.mActivity).getIntent(), this.mPhotoCommonData.selectedPhotoList.size());
      StatisticConstants.a(((NewPhotoListActivity)this.mActivity).getIntent(), this.mPhotoCommonData.selectedPhotoList.size(), this.mPhotoCommonData.currentQualityType);
    }
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
    localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
    localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    if (this.mPhotoCommonData.needMediaInfo) {
      localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
    }
    if (this.mPhotoCommonData.selectedPhotoList != null) {
      NewFlowCameraReporter.a(this.mPhotoCommonData.selectedPhotoList);
    }
    a(localIntent, false, this.mPhotoCommonData.selectedPhotoList);
  }
  
  protected void b(LocalMediaInfo paramLocalMediaInfo)
  {
    f(paramLocalMediaInfo);
  }
  
  protected void c()
  {
    PhotoUtils.sendPhoto(this.mActivity, ((NewPhotoListActivity)this.mActivity).getIntent(), this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.currentQualityType, this.a.jdField_a_of_type_Boolean);
  }
  
  protected void c(LocalMediaInfo paramLocalMediaInfo)
  {
    e(paramLocalMediaInfo);
  }
  
  public void caseCamera(View paramView, int paramInt)
  {
    if (!Utils.a())
    {
      QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131718859), 0).a();
      return;
    }
    ((NewPhotoListActivity)this.mActivity).a();
  }
  
  public Intent caseNoSingModeImage(View paramView, int paramInt)
  {
    paramView = super.caseNoSingModeImage(paramView, paramInt);
    paramView.putExtra("PhotoConst.MY_UIN", this.mPhotoCommonData.myUin);
    paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
    paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.a.e);
    paramView.putExtra("PhotoConst.editPathMap", ReplacePhotoDataUtil.a(this.a.jdField_c_of_type_JavaUtilHashMap));
    paramView.putExtra("p_e_s_type", 6);
    paramView.putExtra("PasterConstants.paster_id", this.a.jdField_a_of_type_JavaLangString);
    paramView.putExtra("PasterConstants.paster_cate_id", this.a.jdField_b_of_type_JavaLangString);
    paramView.putExtra("PasterConstants.pasters_data", this.a.jdField_b_of_type_JavaUtilHashMap);
    if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0)) {
      ReportController.b(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X8005674", "0X8005674", 0, this.mPhotoCommonData.selectedPhotoList.size(), 0, "", "", "", "");
    }
    return paramView;
  }
  
  public void caseSingleModeImage(View paramView, int paramInt)
  {
    a(((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt), paramInt);
  }
  
  public void caseVideo(View paramView, int paramInt)
  {
    if (!Utils.a()) {
      QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131718859), 0).a();
    }
    Object localObject1;
    do
    {
      return;
      localObject1 = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    } while (localObject1 == null);
    paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
    Object localObject2 = AlbumUtil.sSelectItemAlbum;
    Object localObject3;
    if (!((HashMap)localObject2).containsKey(((LocalMediaInfo)localObject1).path))
    {
      localObject3 = new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName);
      ((HashMap)localObject2).put(((LocalMediaInfo)localObject1).path, localObject3);
    }
    ((NewPhotoListActivity)this.mActivity).recordLastPos(((LocalMediaInfo)localObject1).path);
    if (!this.a.jdField_b_of_type_Boolean)
    {
      paramView.putExtra("file_send_path", ((LocalMediaInfo)localObject1).path);
      paramView.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
      paramView.putExtra("PhotoConst.VIDEO_SIZE", ((LocalMediaInfo)localObject1).fileSize);
      paramView.putExtra("file_send_duration", ((LocalMediaInfo)localObject1).mDuration);
      paramView.putExtra("file_width", ((LocalMediaInfo)localObject1).mediaWidth);
      paramView.putExtra("file_height", ((LocalMediaInfo)localObject1).mediaHeight);
      paramView.putExtra("media_info", (Parcelable)localObject1);
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(((LocalMediaInfo)localObject1).path);
      PhotoUtils.sendPhoto(this.mActivity, paramView, (ArrayList)localObject2, 2, false);
      return;
    }
    if (!this.a.isSingleMode)
    {
      localObject1 = ((NewPhotoListActivity)this.mActivity).getIntent();
      ((Intent)localObject1).putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
      ((Intent)localObject1).putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
      localObject2 = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
      ((Intent)localObject1).putExtra("PhotoConst.CURRENT_SELECTED_INDEX", ((LocalMediaInfo)localObject2).position);
      ((Intent)localObject1).putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
      ((Intent)localObject1).putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.mPhotoCommonData.selectedIndex);
      ((Intent)localObject1).putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      ((Intent)localObject1).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
      ((Intent)localObject1).putExtra("PhotoConst.SHOW_ALBUM", true);
      ((Intent)localObject1).putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.a.e);
      ((Intent)localObject1).putExtra("PasterConstants.paster_id", this.a.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("PasterConstants.paster_cate_id", this.a.jdField_b_of_type_JavaLangString);
      PhotoListData.sPhotoListFirstPos = ((NewPhotoListActivity)this.mActivity).gridLayoutManager.findFirstVisibleItemPosition();
      localObject3 = this.mPhotoCommonData.selectedMediaInfoHashMap;
      if (!((HashMap)localObject3).containsKey(((LocalMediaInfo)localObject2).path)) {
        ((HashMap)localObject3).put(((LocalMediaInfo)localObject2).path, localObject2);
      }
      ((Intent)localObject1).putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject3);
      ((Intent)localObject1).putExtra("PasterConstants.pasters_data", this.a.jdField_b_of_type_JavaUtilHashMap);
      ((Intent)localObject1).setClass(this.mActivity, NewPhotoPreviewActivity.class);
      ((Intent)localObject1).addFlags(603979776);
      if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0)) {
        ReportController.b(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X8005674", "0X8005674", 0, this.mPhotoCommonData.selectedPhotoList.size(), 0, "", "", "", "");
      }
      if (((PhotoOtherData)this.mOtherCommonData).a()) {
        ((NewPhotoListActivity)this.mActivity).startActivityForResult(paramView, 100010);
      }
      for (;;)
      {
        AlbumUtil.anim(this.mActivity, true, true);
        return;
        ((NewPhotoListActivity)this.mActivity).startActivity((Intent)localObject1);
        ((NewPhotoListActivity)this.mActivity).finish();
      }
    }
    localObject2 = new Intent(this.mActivity, ShortVideoPreviewActivity.class);
    ((Intent)localObject2).putExtras(paramView);
    ((Intent)localObject2).putExtra("file_send_path", ((LocalMediaInfo)localObject1).path);
    ((Intent)localObject2).putExtra("file_send_size", ((LocalMediaInfo)localObject1).fileSize);
    ((Intent)localObject2).putExtra("file_send_duration", ((LocalMediaInfo)localObject1).mDuration);
    ((Intent)localObject2).putExtra("file_width", ((LocalMediaInfo)localObject1).mediaWidth);
    ((Intent)localObject2).putExtra("file_height", ((LocalMediaInfo)localObject1).mediaHeight);
    ((Intent)localObject2).putExtra("uin", this.a.jdField_d_of_type_JavaLangString);
    ((Intent)localObject2).putExtra("uintype", this.a.jdField_a_of_type_Int);
    ((Intent)localObject2).putExtra("file_source", "album");
    ((Intent)localObject2).putExtra("is_from_system_media", ((LocalMediaInfo)localObject1).isSystemMeidaStore);
    if (this.a.isSupportVideoCheckbox)
    {
      ((Intent)localObject2).putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      ((Intent)localObject2).putExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
    }
    ((NewPhotoListActivity)this.mActivity).startActivityForResult((Intent)localObject2, 17);
  }
  
  public void d()
  {
    ((NewPhotoListActivity)this.mActivity).finish();
  }
  
  protected void d(LocalMediaInfo paramLocalMediaInfo)
  {
    f(paramLocalMediaInfo);
  }
  
  void doOnDestroy()
  {
    if (this.mPhotoCommonData.isShowQzoneAlbum) {
      BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(((NewPhotoListActivity)this.mActivity).jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity$QZoneGetAlbumListNumObserver);
    }
    if (((PhotoOtherData)this.mOtherCommonData).a()) {
      SlideShowPhotoListManager.a().f();
    }
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    ColorNoteSmallScreenUtil.a(BaseApplicationImpl.getContext(), 2, false);
    if (this.a.requestCode == 100016) {
      if (!((NewPhotoListActivity)this.mActivity).getIntent().getBooleanExtra("FROM_QZONR_NO_FINISH", false)) {
        ((NewPhotoListActivity)this.mActivity).finish();
      }
    }
    do
    {
      return;
      ((NewPhotoListActivity)this.mActivity).getIntent().removeExtra("FROM_QZONR_NO_FINISH");
      this.a.requestCode = 0;
      if (((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton != null) {
        ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      }
    } while (!((PhotoOtherData)this.mOtherCommonData).a());
    SlideShowPhotoListManager.a().c();
    SlideShowPhotoListManager.a().a(this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController);
  }
  
  public void e()
  {
    PhotoCommonBaseData localPhotoCommonBaseData = this.mPhotoCommonData;
    switch (localPhotoCommonBaseData.currentQualityType)
    {
    case 1: 
    default: 
      return;
    case 0: 
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      return;
    }
    AlbumUtil.a(((NewPhotoListActivity)this.mActivity).b, localPhotoCommonBaseData.selectedPhotoList, localPhotoCommonBaseData.allMediaInfoHashMap, this.a.j, this.mActivity, this.a.jdField_a_of_type_JavaUtilHashMap, localPhotoCommonBaseData.selectedMediaInfoHashMap);
    ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
  }
  
  protected void e(LocalMediaInfo paramLocalMediaInfo)
  {
    paramLocalMediaInfo.selectStatus = 1;
    String str = paramLocalMediaInfo.path;
    Object localObject = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    if ((this.a.isSupportVideoCheckbox) && (localObject != null) && ("video".equals(localObject[0])))
    {
      localObject = this.a;
      ((PhotoListData)localObject).videoSelectedCnt += 1;
      if (this.a.videoSelectedCnt == 1) {
        this.a.selectedVideoInfo = paramLocalMediaInfo;
      }
    }
    if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
    {
      localObject = this.a;
      ((PhotoListData)localObject).gifSelectedCount += 1;
    }
    this.mPhotoCommonData.selectedPhotoList.add(str);
    this.mPhotoCommonData.selectedIndex.add(paramLocalMediaInfo.position);
    if (this.mPhotoCommonData.needMediaInfo) {
      this.mPhotoCommonData.selectedMediaInfoHashMap.put(str, paramLocalMediaInfo);
    }
    StatisticConstants.a(((NewPhotoListActivity)this.mActivity).getIntent(), "param_totalSelNum");
    paramLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).getIntent();
    if (!paramLocalMediaInfo.hasExtra("param_initTime")) {
      paramLocalMediaInfo.putExtra("param_initTime", System.currentTimeMillis());
    }
    paramLocalMediaInfo = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
    if (paramLocalMediaInfo == null)
    {
      paramLocalMediaInfo = new LinkedHashMap();
      AlbumUtil.sSelectItemPosMap.put(this.mPhotoCommonData.albumId, paramLocalMediaInfo);
    }
    for (;;)
    {
      paramLocalMediaInfo.put(str, Integer.valueOf(((NewPhotoListActivity)this.mActivity).gridLayoutManager.findFirstVisibleItemPosition()));
      paramLocalMediaInfo = AlbumUtil.sSelectItemAlbum;
      if (!paramLocalMediaInfo.containsKey(str)) {
        paramLocalMediaInfo.put(str, new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName));
      }
      return;
    }
  }
  
  protected void enterAlbumListFragment(Intent paramIntent)
  {
    super.enterAlbumListFragment(paramIntent);
    paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
    paramIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", this.mPhotoCommonData.isShowQzoneAlbum);
    paramIntent.putExtra("PhotoConst.PHOTO_INFOS", ((PhotoOtherData)this.mOtherCommonData).jdField_a_of_type_JavaUtilHashMap);
    paramIntent.putExtra("peak.myUin", this.mPhotoCommonData.myUin);
  }
  
  protected void enterPhotoPreviewActivity(boolean paramBoolean, Intent paramIntent)
  {
    AlbumUtil.a();
    paramIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    if (!paramBoolean)
    {
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        ReportController.b(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X8004072", "0X8004072", 0, localArrayList.size(), 0, "", "", "", "");
      }
      if ((((PhotoOtherData)this.mOtherCommonData).jdField_a_of_type_JavaUtilHashMap == null) || (((PhotoOtherData)this.mOtherCommonData).jdField_a_of_type_JavaUtilHashMap.size() <= 0)) {
        break label355;
      }
      paramIntent.putExtra("PhotoConst.PHOTO_INFOS", ((PhotoOtherData)this.mOtherCommonData).jdField_a_of_type_JavaUtilHashMap);
      paramIntent.putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
      paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      paramIntent.putExtra("PhotoConst.USE_URL_PATH", true);
      paramIntent.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false));
    }
    for (;;)
    {
      if (this.mPhotoCommonData.needMediaInfo)
      {
        paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
        paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      }
      paramIntent.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
      paramIntent.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
      paramIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
      paramIntent.putExtra("PasterConstants.pasters_data", this.a.jdField_b_of_type_JavaUtilHashMap);
      PhotoListData.sPhotoListFirstPos = ((NewPhotoListActivity)this.mActivity).gridLayoutManager.findFirstVisibleItemPosition();
      paramIntent.setClass(this.mActivity, NewPhotoPreviewActivity.class);
      paramIntent.addFlags(603979776);
      startPhotoPreviewActivity(paramIntent);
      AlbumUtil.anim(this.mActivity, true, true);
      return;
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.a.currentPhotoPath);
      break;
      label355:
      paramIntent.putExtra("PhotoConst.USE_URL_PATH", false);
    }
  }
  
  void f()
  {
    Object localObject = SlideShowPhotoListManager.a().a();
    if (this.a.k) {
      SlideShowPhotoListManager.a().b((List)localObject);
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      SlideItemInfo localSlideItemInfo = (SlideItemInfo)((Iterator)localObject).next();
      if (localSlideItemInfo != null)
      {
        if (!this.mPhotoCommonData.selectedPhotoList.contains(localSlideItemInfo.jdField_b_of_type_JavaLangString)) {
          this.mPhotoCommonData.selectedPhotoList.add(localSlideItemInfo.jdField_b_of_type_JavaLangString);
        }
        if (!this.mPhotoCommonData.selectedIndex.contains(localSlideItemInfo.a.position)) {
          this.mPhotoCommonData.selectedIndex.add(localSlideItemInfo.a.position);
        }
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(localSlideItemInfo.jdField_b_of_type_JavaLangString, localSlideItemInfo.a);
      }
    }
    if (this.mPhotoCommonData.selectedPhotoList.size() > 0) {
      SlideShowPhotoListManager.a().a(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap, false);
    }
  }
  
  protected void f(LocalMediaInfo paramLocalMediaInfo)
  {
    paramLocalMediaInfo.selectStatus = 2;
    String str = paramLocalMediaInfo.path;
    Object localObject = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    if ((this.a.isSupportVideoCheckbox) && (localObject != null) && ("video".equals(localObject[0])))
    {
      localObject = this.a;
      ((PhotoListData)localObject).videoSelectedCnt -= 1;
      if (this.a.videoSelectedCnt == 1) {
        this.a.selectedVideoInfo = paramLocalMediaInfo;
      }
    }
    if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
    {
      localObject = this.a;
      ((PhotoListData)localObject).gifSelectedCount -= 1;
    }
    this.mPhotoCommonData.selectedPhotoList.remove(str);
    this.mPhotoCommonData.selectedIndex.remove(paramLocalMediaInfo.position);
    if (this.mPhotoCommonData.needMediaInfo) {
      this.mPhotoCommonData.selectedMediaInfoHashMap.remove(str);
    }
    StatisticConstants.a(((NewPhotoListActivity)this.mActivity).getIntent(), "param_cancelSelNum");
    paramLocalMediaInfo = (HashMap)AlbumUtil.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
    if (paramLocalMediaInfo != null) {
      paramLocalMediaInfo.remove(str);
    }
    paramLocalMediaInfo = AlbumUtil.sSelectItemAlbum;
    if (paramLocalMediaInfo.containsKey(str)) {
      paramLocalMediaInfo.remove(str);
    }
  }
  
  protected String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.mPhotoCommonData.maxSelectNum;
    String str = super.getExceedMaxSelectNumStr(paramLocalMediaInfo);
    if (paramLocalMediaInfo != null)
    {
      paramLocalMediaInfo = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
      if ((((PhotoOtherData)this.mOtherCommonData).a()) && (!this.a.isSupportVideoCheckbox)) {
        return ((NewPhotoListActivity)this.mActivity).getResources().getString(2131694870, new Object[] { Integer.valueOf(i) });
      }
      if ((this.a.isSupportVideoCheckbox) && (paramLocalMediaInfo != null) && ("video".equals(paramLocalMediaInfo[0])))
      {
        if (((PhotoOtherData)this.mOtherCommonData).a()) {
          return ((NewPhotoListActivity)this.mActivity).getResources().getString(2131694871, new Object[] { Integer.valueOf(i) });
        }
        return ((NewPhotoListActivity)this.mActivity).getResources().getString(2131694869, new Object[] { Integer.valueOf(i) });
      }
    }
    return str;
  }
  
  public AbstractPhotoListActivity.Holder getViewCaseCamera(@NonNull AbstractPhotoListActivity.Holder paramHolder, int paramInt)
  {
    return super.getViewCaseCamera(paramHolder, paramInt);
  }
  
  protected void handlePicCapture(Intent paramIntent)
  {
    super.handlePicCapture(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (paramIntent.size() > 0) && (!TextUtils.isEmpty((CharSequence)paramIntent.get(0)))) {
      ThreadManager.postImmediately(new PhotoListLogicDefault.7(this, (String)paramIntent.get(0)), null, true);
    }
  }
  
  protected void handleVideoCapture(Intent paramIntent)
  {
    super.handleVideoCapture(paramIntent);
    ((NewPhotoListActivity)this.mActivity).showProgressDialog();
    long l = System.currentTimeMillis();
    Object localObject = paramIntent.getStringExtra("video_new_fake_vid");
    paramIntent = paramIntent.getStringExtra("file_video_source_dir");
    VideoCompositeHelper localVideoCompositeHelper = new VideoCompositeHelper();
    localVideoCompositeHelper.a(true);
    localObject = VideoCompositeHelper.a((String)localObject);
    String str = EncodeVideoUtil.a(((PublishVideoEntry)localObject).mLocalRawVideoDir);
    if (TextUtils.isEmpty(str))
    {
      QZLog.i("PhotoListActivity", 1, "get target path fail");
      return;
    }
    localVideoCompositeHelper.a((PublishVideoEntry)localObject, str, false, true, new PhotoListLogicDefault.8(this, l, str, (PublishVideoEntry)localObject, paramIntent));
  }
  
  protected void handleVideoEncodeSucceed(Message paramMessage)
  {
    super.handleVideoEncodeSucceed(paramMessage);
    ((NewPhotoListActivity)this.mActivity).cancleProgressDailog();
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    String str;
    if ((paramMessage.obj instanceof String))
    {
      str = (String)paramMessage.obj;
      QZLog.d("PhotoListActivity", 2, new Object[] { "onEncodeSuccess = ", str });
      paramMessage = localArrayList;
      if (localArrayList == null) {
        paramMessage = new ArrayList();
      }
      if (paramMessage.size() < PhotoCommonBaseData.getInstance().maxSelectNum) {
        break label148;
      }
      QQToast.a(this.mActivity, String.format(((NewPhotoListActivity)this.mActivity).getResources().getString(2131694869), new Object[] { Integer.valueOf(PhotoCommonBaseData.getInstance().maxSelectNum) }), 0).a();
    }
    for (;;)
    {
      ((NewPhotoListActivity)this.mActivity).a(str);
      return;
      label148:
      PhotoCommonBaseData.getInstance().selectedPhotoList.add(str);
      ((NewPhotoListActivity)this.mActivity).b();
    }
  }
  
  protected void initData(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity initData(),intent extras is:" + paramIntent.getExtras());
    }
    super.initData(paramIntent);
    this.a.k = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
    ReplacePhotoDataUtil.a(this.mActivity, paramIntent, false, this.a.jdField_c_of_type_JavaUtilHashMap);
    this.a.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
    if (this.a.jdField_a_of_type_JavaUtilHashMap == null) {
      this.a.jdField_a_of_type_JavaUtilHashMap = new HashMap(1);
    }
    this.mPhotoCommonData.isShowQzoneAlbum = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    ((PhotoOtherData)this.mOtherCommonData).jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
    this.a.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.original_button", false);
    this.a.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.quality_count_tv", true);
    this.mPhotoCommonData.myUin = paramIntent.getStringExtra("PhotoConst.MY_UIN");
    this.a.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.a.f = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
    this.a.g = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_NEED_EDIT", false);
    this.a.h = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
    this.a.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.mPhotoCommonData.currentQualityType = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    if (paramIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", false)) {
      this.a.isSingleMode = false;
    }
    this.a.i = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.a.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("uinname");
    this.a.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.mPhotoCommonData.videoSizeLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 1048576000L);
    this.a.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_PREVIEW_VIDEO", true);
    this.mPhotoCommonData.videoDurationLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", 9223372036854775807L);
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)paramIntent.getParcelableExtra("session_info"));
      if (!this.a.e) {
        this.a.e = paramIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
      }
      if (this.a.e)
      {
        this.a.jdField_b_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PasterConstants.pasters_data"));
        this.a.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_id");
        this.a.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_cate_id");
      }
      this.a.jdField_a_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_MAX_MEDIA_SIZE", -1L);
      if (this.mPhotoCommonData.isShowQzoneAlbum)
      {
        paramIntent = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        if (paramIntent != null)
        {
          NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), QZoneAlbumListNumServlet.class);
          localNewIntent.putExtra("selfuin", Long.valueOf(paramIntent));
          BaseApplicationImpl.getApplication().getRuntime().registObserver(((NewPhotoListActivity)this.mActivity).jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity$QZoneGetAlbumListNumObserver);
          BaseApplicationImpl.getApplication().getRuntime().startServlet(localNewIntent);
        }
      }
      else
      {
        if (((PhotoOtherData)this.mOtherCommonData).a()) {
          this.mPhotoCommonData.filter.videoMaxDuration = this.mPhotoCommonData.videoDurationLimit;
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("PhotoListActivity", 2, "submit", localException);
          continue;
          this.mPhotoCommonData.isShowQzoneAlbum = false;
        }
      }
    }
  }
  
  public boolean needVedio()
  {
    return super.needVedio();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    if ((QLog.isDevelopLevel()) && (localArrayList != null) && (localArrayList.size() != 0)) {
      QLog.d("PhotoListActivity", 4, "[NewPhotoListActivity] [onActivityResult] selectedPhotoList = " + localArrayList.size());
    }
    this.a.requestCode = paramInt1;
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    while (paramInt1 != 17) {
      for (;;)
      {
        PhotoUtils.onSendResult(this.mActivity, paramInt1, paramInt2, paramIntent, this.a.h, this.mPhotoCommonData.myUin);
        do
        {
          return;
          ((NewPhotoListActivity)this.mActivity).setResult(-1, paramIntent);
          ((NewPhotoListActivity)this.mActivity).finish();
          break;
          enterPhotoPreviewActivity(true, ((NewPhotoListActivity)this.mActivity).getIntent());
          return;
          paramIntent = new Intent();
          paramIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
          paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
          ((NewPhotoListActivity)this.mActivity).setResult(-1, paramIntent);
          ((NewPhotoListActivity)this.mActivity).finish();
          return;
        } while (paramIntent == null);
        this.mPhotoCommonData.selectedPhotoList = paramIntent.getStringArrayListExtra("img_list");
        continue;
        SlideShowPhotoListManager.a().a(paramIntent, this.mPhotoCommonData.selectedMediaInfoHashMap);
      }
    }
    AlbumUtil.sLastAlbumRecordTime = 0L;
  }
  
  protected void onBackPressed()
  {
    super.onBackPressed();
  }
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    boolean bool2 = true;
    paramView = this.mPhotoCommonData.selectedPhotoList;
    if (this.a.isSingleMode) {}
    int i;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListActivity", 2, "current select count:" + paramView.size());
      }
      paramView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
      i = paramView.selectStatus;
    } while (!a(paramView, paramCheckBox));
    if (i != 1)
    {
      bool1 = true;
      label97:
      if (!bool1) {
        break label310;
      }
      c(paramView);
      label107:
      if (this.mSelectionListener != null) {
        this.mSelectionListener.onSelectionChange(bool1, paramView);
      }
      ((NewPhotoListActivity)this.mActivity).updateCheckbox(paramInt, bool1);
      paramView = (NewPhotoListActivity)this.mActivity;
      if (bool1) {
        break label318;
      }
    }
    label310:
    label318:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramView.selectLimitRemind(bool1);
      updateButton();
      if (!((PhotoOtherData)this.mOtherCommonData).a()) {
        break;
      }
      if (SlideShowPhotoListManager.a().a().isEmpty())
      {
        i = ((NewPhotoListActivity)this.mActivity).gridLayoutManager.findFirstVisibleItemPosition();
        paramView = ((NewPhotoListActivity)this.mActivity).mGridView.getChildAt(paramInt - i);
        if ((paramView != null) && (((NewPhotoListActivity)this.mActivity).mGridView.getHeight() - paramView.getY() < ((NewPhotoListActivity)this.mActivity).mImageHeight)) {
          ((NewPhotoListActivity)this.mActivity).mGridView.smoothScrollBy(SlideShowPhotoListManager.jdField_a_of_type_Int, 500);
        }
      }
      SlideShowPhotoListManager.a().b(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap);
      return;
      bool1 = false;
      break label97;
      d(paramView);
      break label107;
    }
  }
  
  protected void onGestureSelectEnd(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.a.isSingleMode) {}
    while (!((PhotoOtherData)this.mOtherCommonData).a()) {
      return;
    }
    if (SlideShowPhotoListManager.a().a().isEmpty())
    {
      paramInt2 = ((NewPhotoListActivity)this.mActivity).gridLayoutManager.findFirstVisibleItemPosition();
      View localView = ((NewPhotoListActivity)this.mActivity).mGridView.getChildAt(paramInt1 - paramInt2);
      if ((localView != null) && (((NewPhotoListActivity)this.mActivity).mGridView.getHeight() - localView.getY() < ((NewPhotoListActivity)this.mActivity).mImageHeight)) {
        ((NewPhotoListActivity)this.mActivity).mGridView.smoothScrollBy(SlideShowPhotoListManager.jdField_a_of_type_Int, 500);
      }
    }
    SlideShowPhotoListManager.a().b(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap);
  }
  
  protected void onMagicStickClick(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent)
  {
    if (this.mPhotoCommonData.selectedPhotoList.size() > 0)
    {
      paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
      paramView.removeExtra("param_initTime");
      paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
      ReportController.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      paramView = paramIntent;
      if (paramIntent == null) {
        paramView = EditPicActivity.a(this.mActivity, (String)this.mPhotoCommonData.selectedPhotoList.get(0), true, true, true, true, true, paramInt, 142, 5, paramBundle);
      }
      paramView.putExtra("key_enable_edit_title_bar", true);
      a(paramView);
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton.setClickable(false);
    }
  }
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    Handler localHandler = ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidOsHandler;
    if (localHandler == null) {}
    do
    {
      do
      {
        return;
        localObject = ((NewPhotoListActivity)this.mActivity).photoListAdapter;
      } while ((localObject == null) || (((AbstractPhotoListActivity.PhotoListAdapter)localObject).mAllImages == null));
      localObject = (LocalMediaInfo)((AbstractPhotoListActivity.PhotoListAdapter)localObject).mAllImages.get(paramInt);
    } while ((localObject == null) || (paramLocalMediaInfo == null) || (((LocalMediaInfo)localObject).path == null) || (paramLocalMediaInfo.path == null) || (!((LocalMediaInfo)localObject).path.equals(paramLocalMediaInfo.path)));
    Object localObject = localHandler.obtainMessage();
    ((Message)localObject).what = 0;
    Bundle localBundle = new Bundle();
    localBundle.putInt("ALBUMLIST_POSITION", paramInt);
    localBundle.putLong("ALBUMLIST_ITEM_DURATION", paramLocalMediaInfo.mDuration);
    ((Message)localObject).setData(localBundle);
    localHandler.sendMessage((Message)localObject);
  }
  
  protected void onPreviewBtnClick(View paramView)
  {
    super.onPreviewBtnClick(paramView);
  }
  
  protected void onQueryMediaListBack(List<LocalMediaInfo> paramList)
  {
    if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() != 0))
    {
      int i = 0;
      if (i < this.mPhotoCommonData.selectedPhotoList.size())
      {
        String str = (String)this.mPhotoCommonData.selectedPhotoList.get(i);
        int j;
        if (TextUtils.isEmpty(str))
        {
          QZLog.e("PhotoListActivity:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
          j = i;
        }
        for (;;)
        {
          i = j + 1;
          break;
          j = i;
          if (!new File(str).exists()) {
            if ((str.startsWith("http")) && (((PhotoOtherData)this.mOtherCommonData).jdField_a_of_type_JavaUtilHashMap != null))
            {
              j = i;
              if (((PhotoOtherData)this.mOtherCommonData).jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {}
            }
            else
            {
              this.mPhotoCommonData.selectedPhotoList.remove(i);
              i -= 1;
              j = i;
              if (this.mPhotoCommonData.needMediaInfo)
              {
                j = i;
                if (this.mPhotoCommonData.selectedMediaInfoHashMap != null)
                {
                  j = i;
                  if (this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(str))
                  {
                    this.mPhotoCommonData.selectedMediaInfoHashMap.remove(str);
                    j = i;
                  }
                }
              }
            }
          }
        }
      }
    }
    super.onQueryMediaListBack(paramList);
  }
  
  public boolean onQueryPhoto(List<LocalMediaInfo> paramList)
  {
    boolean bool = false;
    int i;
    if (super.onQueryPhoto(paramList)) {
      if (this.a.firstResume)
      {
        this.a.firstResume = false;
        i = a(paramList);
        if (!((PhotoOtherData)this.mOtherCommonData).a()) {
          break label219;
        }
        if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0))
        {
          paramList = (String)this.mPhotoCommonData.selectedPhotoList.get(this.mPhotoCommonData.selectedPhotoList.size() - 1);
          int j = this.mPhotoCommonData.mediaPathsList.indexOf(paramList);
          if ((j >= 0) && (j < ((NewPhotoListActivity)this.mActivity).mGridView.getAdapter().getItemCount())) {
            ((NewPhotoListActivity)this.mActivity).mGridView.post(new PhotoListLogicDefault.9(this, i));
          }
        }
      }
    }
    for (;;)
    {
      if (((PhotoOtherData)this.mOtherCommonData).a())
      {
        ((NewPhotoListActivity)this.mActivity).a(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.selectedMediaInfoHashMap);
        SlideShowPhotoListManager.a().b(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap);
      }
      bool = true;
      return bool;
      label219:
      ((NewPhotoListActivity)this.mActivity).mGridView.post(new PhotoListLogicDefault.10(this, i));
    }
  }
  
  protected void onSendBtnClick(View paramView)
  {
    ((NewPhotoListActivity)this.mActivity).sendBtn.setClickable(false);
    if (!this.mPhotoCommonData.selectedPhotoList.isEmpty()) {
      ((NewPhotoListActivity)this.mActivity).recordLastPos((String)this.mPhotoCommonData.selectedPhotoList.get(this.mPhotoCommonData.selectedPhotoList.size() - 1));
    }
    AlbumUtil.a();
    if (this.mPhotoCommonData.selectedPhotoList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoList", 2, "size == 0");
      }
      return;
    }
    if (((NewPhotoListActivity)this.mActivity).getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.mPhotoCommonData.selectedPhotoList.iterator();
      for (long l = 0L; paramView.hasNext(); l = FileUtils.a((String)paramView.next()) + l) {}
      if (FileManagerUtil.a())
      {
        FMDialogUtil.a(this.mActivity, 2131692609, 2131692614, new PhotoListLogicDefault.6(this));
        return;
      }
    }
    b();
  }
  
  protected void onTitleBtnCancelClick(View paramView)
  {
    AlbumUtil.clearSelectItemInfo();
    AlbumUtil.a();
    paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
    int i;
    if (this.mPhotoCommonData.selectedPhotoList != null)
    {
      i = this.mPhotoCommonData.selectedPhotoList.size();
      StatisticConstants.b(paramView, i);
      if (this.a.i) {
        break label103;
      }
      if (((PhotoOtherData)this.mOtherCommonData).a()) {
        SlideShowPhotoListManager.a().a(SlideShowPhotoListManager.a().c());
      }
      ((NewPhotoListActivity)this.mActivity).finish();
      AlbumUtil.anim(this.mActivity, false, false);
    }
    label103:
    String str1;
    String str2;
    do
    {
      return;
      i = 0;
      break;
      paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
      str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      str2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    } while (str1 == null);
    paramView.setClassName(str2, str1);
    paramView.removeExtra("PhotoConst.PHOTO_PATHS");
    paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramView.addFlags(603979776);
    ((NewPhotoListActivity)this.mActivity).startActivity(paramView);
    ((NewPhotoListActivity)this.mActivity).finish();
    AlbumUtil.anim(this.mActivity, false, false);
  }
  
  protected void postInitUI()
  {
    Object localObject = ((NewPhotoListActivity)this.mActivity).bottomBar;
    int i;
    if ((this.a.isSingleMode) || (this.mPhotoCommonData.showMediaType == 2) || (((PhotoOtherData)this.mOtherCommonData).a()))
    {
      i = 8;
      ((View)localObject).setVisibility(i);
      ((NewPhotoListActivity)this.mActivity).previewBtn.setOnClickListener(this.mActivity);
      ((NewPhotoListActivity)this.mActivity).sendBtn.setOnClickListener(this.mActivity);
      if (!this.a.e) {
        break label283;
      }
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.mActivity);
    }
    for (;;)
    {
      if (this.a.jdField_c_of_type_Boolean) {
        ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this.mActivity);
      }
      updateButton();
      if (((PhotoOtherData)this.mOtherCommonData).a())
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController = new SlideShowViewController(this.mActivity, this);
        SlideShowPhotoListManager.a().a(this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController);
        SlideShowPhotoListManager.a().a(this.mActivity);
        f();
        if (((NewPhotoListActivity)this.mActivity).getIntent().getBooleanExtra("report_first_exposure", true))
        {
          localObject = (TransitionHandler)QQStoryContext.a().getBusinessHandler(PeakAppInterface.jdField_b_of_type_JavaLangString);
          if (localObject != null) {
            ((TransitionHandler)localObject).a();
          }
          ((NewPhotoListActivity)this.mActivity).getIntent().putExtra("report_first_exposure", false);
        }
      }
      return;
      i = 0;
      break;
      label283:
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  protected void processViewCaseImage(AbstractPhotoListActivity.Holder paramHolder, LocalMediaInfo paramLocalMediaInfo)
  {
    if (ReplacePhotoDataUtil.a(paramLocalMediaInfo.path, this.a.jdField_c_of_type_JavaUtilHashMap))
    {
      if (Build.VERSION.SDK_INT >= 21) {
        paramHolder.mPhotoFlagView.setImageDrawable(((NewPhotoListActivity)this.mActivity).getDrawable(2130839494));
      }
      for (;;)
      {
        paramHolder.mPhotoFlagView.setVisibility(0);
        return;
        paramHolder.mPhotoFlagView.setImageResource(2130839494);
      }
    }
    paramHolder.mPhotoFlagView.setVisibility(8);
  }
  
  protected void startPhotoPreviewActivity(Intent paramIntent)
  {
    super.startPhotoPreviewActivity(paramIntent);
  }
  
  protected void updateAddData(List<LocalMediaInfo> paramList, int paramInt)
  {
    if (paramList != null) {
      ReplacePhotoDataUtil.a(paramList, paramInt, null, this.a.jdField_c_of_type_JavaUtilHashMap);
    }
    super.updateAddData(paramList, paramInt);
  }
  
  protected void updateButton()
  {
    super.updateButton();
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    int i;
    if (localArrayList.size() > 0)
    {
      i = 1;
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "updateButton selectedPhotoList.size()=" + localArrayList.size());
      }
      if (i == 0)
      {
        ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
        ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        ((NewPhotoListActivity)this.mActivity).b.setEnabled(false);
      }
      if (!this.a.e) {
        break label384;
      }
      if ((localArrayList.size() != 1) || ((((PhotoOtherData)this.mOtherCommonData).jdField_a_of_type_JavaUtilHashMap != null) && (((PhotoOtherData)this.mOtherCommonData).jdField_a_of_type_JavaUtilHashMap.size() > 0)) || (((PhotoOtherData)this.mOtherCommonData).a(this.mPhotoCommonData, (String)localArrayList.get(0)) != 0)) {
        break label367;
      }
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    }
    for (;;)
    {
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      ((NewPhotoListActivity)this.mActivity).b.setVisibility(8);
      if (this.a.jdField_c_of_type_Boolean)
      {
        ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        if (i != 0)
        {
          ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
          ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
          ((NewPhotoListActivity)this.mActivity).b.setEnabled(true);
        }
      }
      e();
      if (!this.a.jdField_d_of_type_Boolean) {
        ((NewPhotoListActivity)this.mActivity).b.setVisibility(8);
      }
      return;
      i = 0;
      break;
      label367:
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      continue;
      label384:
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault
 * JD-Core Version:    0.7.0.1
 */