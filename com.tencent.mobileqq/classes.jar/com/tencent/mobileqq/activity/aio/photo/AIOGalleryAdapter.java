package com.tencent.mobileqq.activity.aio.photo;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.QQLiveImage;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.photo.ProGallery.OnProGalleryListener;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreview;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreviewProgressive;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.AdapterView;
import cooperation.peak.PeakUtils;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONObject;
import vmg;
import vmh;
import vmn;

public class AIOGalleryAdapter
  extends AbstractImageAdapter
  implements QQLiveDrawable.OnStateListener, ProGallery.OnProGalleryListener
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = -1L;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  public AIOGalleryActivity a;
  private AIOGalleryAdapter.GalleryImageStruct jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct;
  public AIOGalleryAdapter.OnAdapterNotify a;
  AIOImageListModel jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
  IAIOImageProvider jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private vmn jdField_a_of_type_Vmn;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = -1L;
  private URLDrawable jdField_b_of_type_ComTencentImageURLDrawable;
  private int jdField_c_of_type_Int = -1;
  long jdField_c_of_type_Long = -1L;
  private int d = -1;
  private int e;
  private int f;
  
  public AIOGalleryAdapter(Context paramContext, IAIOImageProvider paramIAIOImageProvider, boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity = ((AIOGalleryActivity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = paramIAIOImageProvider;
    this.jdField_e_of_type_Int = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_f_of_type_Int = paramContext.getResources().getDisplayMetrics().heightPixels;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent();
    if (paramContext != null) {
      this.jdField_b_of_type_Int = paramContext.getIntExtra("forward_source_uin_type", -1);
    }
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    EmptyDrawable localEmptyDrawable = new EmptyDrawable(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localEmptyDrawable, localEmptyDrawable);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.startDownload();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AIOGalleryAdapter", 2, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString, localException);
        }
      }
    }
    return localEmptyDrawable;
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Actives: ");
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      if (i > 0) {
        localStringBuilder.append(" , ");
      }
      localStringBuilder.append(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i) + 1);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.jdField_c_of_type_Int = -1;
  }
  
  private void a(int paramInt, URLDrawable paramURLDrawable, boolean paramBoolean)
  {
    if (paramURLDrawable == null) {}
    String str;
    do
    {
      return;
      paramURLDrawable = paramURLDrawable.getCurrDrawable();
      if (VideoDrawable.class.isInstance(paramURLDrawable))
      {
        ((VideoDrawable)paramURLDrawable).stopAudio();
        int i;
        if (this.jdField_b_of_type_Long > 0L)
        {
          this.jdField_a_of_type_Long += System.currentTimeMillis() - this.jdField_b_of_type_Long;
          paramURLDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent();
          if (paramURLDrawable != null)
          {
            i = paramURLDrawable.getIntExtra("forward_source_uin_type", -1);
            str = paramURLDrawable.getStringExtra("uin");
            new DCShortVideo(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplication().getBaseContext()).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface, 2001, 0, i, str, this.jdField_a_of_type_Long / 1000L);
            if (this.jdField_b_of_type_Int != 1) {}
          }
        }
        for (;;)
        {
          try
          {
            paramURLDrawable = new JSONObject();
            paramURLDrawable.put("author_id", str);
            paramURLDrawable.put("author_type", "1");
            paramURLDrawable.put("video_type", "1");
            paramURLDrawable.put("video_time", this.jdField_c_of_type_Long + "");
            paramURLDrawable.put("play_time", this.jdField_a_of_type_Long);
            paramURLDrawable.put("content_type", 2);
            str = StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplicationContext());
            if (!paramBoolean) {
              continue;
            }
            i = 2;
            StoryReportor.a("story_grp", "play_video_js", 1003, i, new String[] { paramURLDrawable.toString(), "", str, "" });
          }
          catch (Exception paramURLDrawable)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.w("AIOGalleryAdapter", 2, "reportTroopVideo exception:" + QLog.getStackTraceString(paramURLDrawable));
            continue;
          }
          this.jdField_b_of_type_Long = -1L;
          this.jdField_a_of_type_Long = -1L;
          this.jdField_c_of_type_Long = -1L;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.stopVideoAudio(): position " + paramInt);
          return;
          i = 3;
        }
      }
    } while ((!QQLiveDrawable.class.isInstance(paramURLDrawable)) || (this.jdField_b_of_type_Int != 1) || (this.jdField_b_of_type_Long <= 0L));
    this.jdField_a_of_type_Long += System.currentTimeMillis() - this.jdField_b_of_type_Long;
    paramURLDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent();
    if (paramURLDrawable != null) {
      str = paramURLDrawable.getStringExtra("uin");
    }
    for (;;)
    {
      try
      {
        paramURLDrawable = new JSONObject();
        paramURLDrawable.put("author_id", str);
        paramURLDrawable.put("author_type", "1");
        paramURLDrawable.put("video_type", "1");
        paramURLDrawable.put("video_time", this.jdField_c_of_type_Long + "");
        paramURLDrawable.put("play_time", this.jdField_a_of_type_Long);
        paramURLDrawable.put("content_type", 2);
        str = StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplicationContext());
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2;
        StoryReportor.a("story_grp", "play_video_js", 1003, paramInt, new String[] { paramURLDrawable.toString(), "", str, "" });
      }
      catch (Exception paramURLDrawable)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("AIOGalleryAdapter", 2, "reportTroopVideo exception:" + QLog.getStackTraceString(paramURLDrawable));
        continue;
      }
      this.jdField_b_of_type_Long = -1L;
      this.jdField_a_of_type_Long = -1L;
      this.jdField_c_of_type_Long = -1L;
      return;
      paramInt = 3;
    }
  }
  
  private void a(int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIOShortVideoData paramAIOShortVideoData, File paramFile)
  {
    QQLiveDrawable.QQLiveDrawableParams localQQLiveDrawableParams = new QQLiveDrawable.QQLiveDrawableParams();
    localQQLiveDrawableParams.mPreviewWidth = paramAIOShortVideoData.jdField_c_of_type_Int;
    localQQLiveDrawableParams.mPreviewHeight = paramAIOShortVideoData.d;
    localQQLiveDrawableParams.mDataSourceType = 3;
    localQQLiveDrawableParams.mDataSource = paramFile.getAbsolutePath();
    localQQLiveDrawableParams.mLoopback = true;
    localQQLiveDrawableParams.mMute = false;
    localQQLiveDrawableParams.mPlayType = 2;
    localQQLiveDrawableParams.mListener = this;
    localQQLiveDrawableParams.msgUniseq = paramAIOShortVideoData.jdField_a_of_type_Long;
    localQQLiveDrawableParams.mReportTag = "bus_type_aio_shortvideo";
    paramFile = paramAIOShortVideoData.a(0);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if (paramFile != null)
    {
      localQQLiveDrawableParams.mCoverUrl = ShortVideoUtils.a(paramFile.getAbsolutePath()).toString();
      localURLDrawableOptions.mLoadingDrawable = a(localQQLiveDrawableParams.mCoverUrl, paramAIOShortVideoData.jdField_c_of_type_Int, paramAIOShortVideoData.d);
    }
    localURLDrawableOptions.mExtraInfo = localQQLiveDrawableParams;
    paramFile = URLDrawable.getDrawable(ShortVideoItemBuilder.a(paramAIOShortVideoData.jdField_a_of_type_Long), localURLDrawableOptions);
    paramGalleryImageStruct.setImageDrawable(paramFile);
    a(paramInt, true);
    this.jdField_b_of_type_ComTencentImageURLDrawable = paramFile;
    this.d = paramInt;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_c_of_type_Long = (paramAIOShortVideoData.jdField_a_of_type_Int * 1000L);
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramView != null)
    {
      if (paramView.getStatus() == 3) {
        paramView.restartDownload();
      }
      return null;
    }
    paramView = a(paramInt);
    if (paramView == null) {
      return null;
    }
    Object localObject;
    if (AIOImageData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
    {
      localObject = (AIOImageData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      paramViewGroup = ((AIOImageData)localObject).a(4);
      if (paramViewGroup != null) {
        break label994;
      }
      paramView = ((AIOImageData)localObject).a(2);
      if (paramView == null) {}
    }
    for (;;)
    {
      int i;
      if (paramViewGroup != null)
      {
        i = 1;
        paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
        paramViewGroup.mLoadingDrawable = URLDrawableHelper.a;
        paramViewGroup.mFailedDrawable = URLDrawableHelper.a;
        paramViewGroup.mPlayGifImage = true;
        paramViewGroup.mUseExifOrientation = false;
        if ((((AIOImageData)localObject).jdField_c_of_type_Int == 1) && ((((AIOImageData)localObject).jdField_e_of_type_Int & 0x2) == 2)) {
          paramViewGroup.mUseAutoScaleParams = false;
        }
        if ((i != 0) || (!((AIOImageData)localObject).jdField_d_of_type_Boolean)) {
          break label224;
        }
        paramView = URLDrawable.getDrawable(((AIOImageData)localObject).a(2) + "#" + "PART", paramViewGroup);
        label195:
        paramView.setTag(Integer.valueOf(1));
        paramView.startDownload();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
      }
      for (;;)
      {
        return null;
        i = 0;
        break;
        label224:
        paramView = URLDrawable.getDrawable(paramView, paramViewGroup);
        break label195;
        if ((!((AIOImageData)localObject).jdField_c_of_type_Boolean) && (!((AIOImageData)localObject).jdField_b_of_type_Boolean) && (!((AIOImageData)localObject).jdField_a_of_type_Boolean)) {
          if (((AIOImageData)localObject).a(1) != null)
          {
            paramView = URLDrawable.URLDrawableOptions.obtain();
            paramView.mLoadingDrawable = URLDrawableHelper.a;
            paramView.mFailedDrawable = URLDrawableHelper.a;
            if ((((AIOImageData)localObject).jdField_c_of_type_Int == 1) && ((((AIOImageData)localObject).jdField_e_of_type_Int & 0x2) == 2)) {
              paramView.mUseAutoScaleParams = false;
            }
            URLDrawable.getDrawable(((AIOImageData)localObject).a(1), paramView).startDownload();
            if ((NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) && (!PeakUtils.a(((AIOImageData)localObject).jdField_a_of_type_Int))) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(((AIOImageData)localObject).jdField_g_of_type_Long, ((AIOImageData)localObject).jdField_f_of_type_Int, 2);
            }
          }
          else if ((NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) && (!PeakUtils.a(((AIOImageData)localObject).jdField_a_of_type_Int)))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(((AIOImageData)localObject).jdField_g_of_type_Long, ((AIOImageData)localObject).jdField_f_of_type_Int, 2);
            if (QLog.isDevelopLevel())
            {
              QLog.d("AIOGalleryAdapter", 4, "onCreateView():Thumb and large pic is not exist, download it. Gallery position is " + paramInt);
              continue;
              if (AIOShortVideoData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
              {
                paramViewGroup = (AIOShortVideoData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
                paramView = paramViewGroup.a(0);
                if (paramView != null)
                {
                  paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
                  paramViewGroup.mLoadingDrawable = URLDrawableHelper.a;
                  paramViewGroup.mFailedDrawable = URLDrawableHelper.a;
                  paramView = URLDrawable.getDrawable(paramView, paramViewGroup);
                  paramView.startDownload();
                  this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
                  if (QLog.isColorLevel()) {
                    QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): preload thumb, position=" + paramInt);
                  }
                }
                else if (paramViewGroup.jdField_b_of_type_Boolean)
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): Video error, position=" + paramInt);
                  }
                }
                else if (paramViewGroup.a(1) != null)
                {
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramViewGroup.jdField_g_of_type_Long, paramViewGroup.jdField_f_of_type_Int, 0);
                  if (QLog.isColorLevel()) {
                    QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): Video exist and download thumb, position=" + paramInt);
                  }
                }
                else if (paramViewGroup.jdField_b_of_type_Int != 0)
                {
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramViewGroup.jdField_g_of_type_Long, paramViewGroup.jdField_f_of_type_Int, 1);
                  if (QLog.isDevelopLevel()) {
                    QLog.d("AIOGalleryAdapter", 4, "onCreateView():Thumb and video is not exist, download video only. Gallery position is " + paramInt);
                  }
                }
              }
              else if (AIOFilePicData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
              {
                localObject = (AIOFilePicData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
                paramViewGroup = ((AIOFilePicData)localObject).a(20);
                paramView = paramViewGroup;
                if (paramViewGroup == null)
                {
                  paramView = ((AIOFilePicData)localObject).a(18);
                  if (paramView == null) {}
                }
                else
                {
                  paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
                  paramViewGroup.mLoadingDrawable = URLDrawableHelper.a;
                  paramViewGroup.mFailedDrawable = URLDrawableHelper.a;
                  paramViewGroup.mPlayGifImage = true;
                  paramViewGroup.mUseExifOrientation = false;
                  paramView = URLDrawable.getDrawable(paramView, paramViewGroup);
                  paramView.setTag(Integer.valueOf(1));
                  paramView.startDownload();
                  this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
                  continue;
                }
                paramView = ((AIOFilePicData)localObject).a(16);
                if (paramView != null)
                {
                  paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
                  paramViewGroup.mLoadingDrawable = URLDrawableHelper.a;
                  paramViewGroup.mFailedDrawable = URLDrawableHelper.a;
                  URLDrawable.getDrawable(paramView, paramViewGroup).startDownload();
                  if ((NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) && (((AIOFilePicData)localObject).jdField_a_of_type_Long <= FMConfig.c())) {
                    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(((AIOFilePicData)localObject).jdField_g_of_type_Long, ((AIOFilePicData)localObject).jdField_f_of_type_Int, 18);
                  }
                }
                else if ((NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) && (((AIOFilePicData)localObject).jdField_a_of_type_Long <= FMConfig.c()))
                {
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(((AIOFilePicData)localObject).jdField_g_of_type_Long, ((AIOFilePicData)localObject).jdField_f_of_type_Int, 18);
                  if (QLog.isDevelopLevel()) {
                    QLog.d("AIOGalleryAdapter", 4, "onCreateView():Thumb and large pic is not exist, download it. Gallery position is " + paramInt);
                  }
                }
              }
              else if (QLog.isColorLevel())
              {
                QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): nani...");
              }
            }
          }
        }
      }
      label994:
      paramView = paramViewGroup;
    }
  }
  
  public AIORichMediaInfo a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt);
  }
  
  public void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.onSlot(): position is " + paramInt);
    }
    System.gc();
  }
  
  public void a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramInt == this.jdField_c_of_type_Int)
    {
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.jdField_c_of_type_Int = -1;
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryAdapter", 2, "destory rawDrawable, position: " + paramInt);
      }
    }
    AIORichMediaInfo localAIORichMediaInfo;
    if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView))
    {
      paramViewGroup = (AIOGalleryAdapter.GalleryImageStruct)paramView;
      localAIORichMediaInfo = a(paramInt);
      if (localAIORichMediaInfo != null) {
        break label103;
      }
    }
    label103:
    do
    {
      do
      {
        AIORichMediaData localAIORichMediaData;
        do
        {
          return;
          localAIORichMediaData = localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          if (AIOImageData.class.isInstance(localAIORichMediaData))
          {
            if (URLDrawable.class.isInstance(((AIOGalleryAdapter.GalleryImageStruct)paramView).a())) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().b(localAIORichMediaInfo.hashCode());
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().a();
            return;
          }
        } while (!AIOShortVideoData.class.isInstance(localAIORichMediaData));
        paramView = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        if (paramView == null) {
          break;
        }
        paramViewGroup.setImageDrawable(paramView);
      } while (!QLog.isColorLevel());
      QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.onViewDetached(): Use thumb cache replace video.");
      return;
      paramViewGroup.setImageDrawable(URLDrawableHelper.a);
    } while (!QLog.isColorLevel());
    QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.onViewDetached(): No thumb, use TRANSPARENT");
  }
  
  public void a(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    if (!AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView)) {}
    do
    {
      return;
      paramView = ((AIOGalleryAdapter.GalleryImageStruct)paramView).a();
    } while (!URLDrawable.class.isInstance(paramView));
    paramView = (URLDrawable)paramView;
    StatisticCollector.a(BaseApplicationImpl.sApplication).a(null, "regionDecode", true, 0L, 0L, null, null);
    paramView.updateRegionBitmap(paramRegionDrawableData);
  }
  
  public void a(int paramInt, View paramView, boolean paramBoolean)
  {
    Object localObject1;
    if ((paramView instanceof AbstractImageAdapter.URLImageView2))
    {
      paramView = (AbstractImageAdapter.URLImageView2)paramView;
      localObject1 = a(paramInt);
      if (localObject1 != null) {
        break label25;
      }
    }
    label25:
    do
    {
      do
      {
        return;
        if (!AIOImageData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          break;
        }
        localObject2 = (AIOImageData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      } while ((!paramBoolean) || (((AIOImageData)localObject2).a(8) == null));
      localObject1 = paramView.getDrawable();
      Object localObject2 = ((AIOImageData)localObject2).a(8);
      localObject2 = (String)localObject2 + "#" + "DISPLAY";
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
      localURLDrawableOptions.mPlayGifImage = true;
      localURLDrawableOptions.mUseExifOrientation = false;
      localObject1 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
      paramView.setDecodingDrawble((URLDrawable)localObject1);
      ((URLDrawable)localObject1).startDownload();
      if (QLog.isColorLevel()) {
        QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateDisplayView(): Update dp image, position=" + paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().b();
      return;
    } while (!AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
  }
  
  public void a(int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct)
  {
    paramGalleryImageStruct = paramGalleryImageStruct.a();
    if (URLDrawable.class.isInstance(paramGalleryImageStruct)) {
      a(paramInt, (URLDrawable)paramGalleryImageStruct, true);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AIORichMediaInfo localAIORichMediaInfo;
    if ((paramView instanceof AIOGalleryAdapter.GalleryImageStruct))
    {
      paramView = (AIOGalleryAdapter.GalleryImageStruct)paramView;
      localAIORichMediaInfo = a(paramInt);
      if (localAIORichMediaInfo != null) {}
    }
    else
    {
      return;
    }
    if (AIOImageData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
    {
      localObject2 = (AIOImageData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (paramString1 != null) {
        ((AIOImageData)localObject2).jdField_b_of_type_JavaLangString = paramString1;
      }
      if (paramString2 != null) {
        ((AIOImageData)localObject2).jdField_a_of_type_JavaLangString = paramString2;
      }
      if (((AIOImageData)localObject2).jdField_b_of_type_Boolean)
      {
        paramString1 = paramView.a();
        if (!URLDrawable.class.isInstance(paramString1)) {
          break label1392;
        }
        paramString1 = (URLDrawable)paramString1;
      }
    }
    for (paramString2 = paramString1.getURL().getRef();; paramString2 = (String)localObject1)
    {
      if ((paramString1 == null) || (paramString2 == null) || ((!"PART".equals(paramString2)) && (!"DISPLAY".equals(paramString2))))
      {
        paramView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130837618));
        a(paramInt, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().d();
      }
      if (QLog.isColorLevel()) {
        QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): IMAGE_FILE_ERROR");
      }
      if ((QLog.isDevelopLevel()) && (((AIOImageData)localObject2).jdField_d_of_type_Boolean)) {
        QQToast.a(paramView.getContext(), "AIOGalleryAdapter.updateView(): error!", 2000).a();
      }
      for (;;)
      {
        label222:
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
          return;
          if (((AIOImageData)localObject2).a(2) != null)
          {
            paramString2 = ((AIOImageData)localObject2).a(2);
            paramString1 = paramString2;
            if (paramBoolean) {
              paramString1 = paramString2 + "#PART";
            }
            paramString2 = URLDrawable.URLDrawableOptions.obtain();
            if (((AIOImageData)localObject2).jdField_c_of_type_Int == 3)
            {
              localObject1 = ((AIOImageData)localObject2).a(1);
              if (localObject1 != null)
              {
                localObject1 = URLDrawable.getDrawable((File)localObject1, null);
                if (((URLDrawable)localObject1).getStatus() == 1)
                {
                  paramString2.mLoadingDrawable = ((Drawable)localObject1);
                  paramString2.mFailedDrawable = ((Drawable)localObject1);
                }
              }
            }
            paramString2.mUseExifOrientation = false;
            paramString2.mPlayGifImage = true;
            paramString2 = URLDrawable.getDrawable(paramString1, paramString2);
            if ((paramString2.getStatus() == 1) && (!((AIOImageData)localObject2).jdField_d_of_type_Boolean))
            {
              paramView.setImageDrawable(paramString2);
              a(paramInt, true);
            }
            for (;;)
            {
              paramString2 = FileUtils.a(((AIOImageData)localObject2).jdField_b_of_type_JavaLangString);
              if ("png".equals(paramString2)) {
                paramView.setTag(Integer.valueOf(102));
              }
              if (QLog.isColorLevel()) {
                QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): Update large image, position=" + paramInt + "url = " + paramString1 + ",extName = " + paramString2);
              }
              ((AIOImageData)localObject2).jdField_d_of_type_Boolean = paramBoolean;
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().c();
              break;
              paramString2.setTag(Integer.valueOf(1));
              paramString2.startDownload();
              paramView.setDecodingDrawble(paramString2);
            }
          }
          if (((AIOImageData)localObject2).a(1) != null)
          {
            paramView.setImageDrawable(URLDrawable.getDrawable(((AIOImageData)localObject2).a(1), URLDrawable.URLDrawableOptions.obtain()));
            continue;
            if (AIOShortVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
            {
              paramString2 = (AIOShortVideoData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
              if (paramString2.jdField_b_of_type_Int != 0) {
                if (paramString2.jdField_b_of_type_Boolean)
                {
                  paramView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130837618));
                  a(paramInt, false);
                  if (QLog.isColorLevel()) {
                    QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): IMAGE_FILE_ERROR, position=" + paramInt);
                  }
                }
                else
                {
                  paramString1 = paramString2.a(1);
                  if (paramString1 != null)
                  {
                    paramString2 = URLDrawable.URLDrawableOptions.obtain();
                    paramString2.mLoadingDrawable = URLDrawableHelper.b;
                    paramString2.mUseMemoryCache = false;
                    localObject1 = new VideoDrawable.VideoDrawableParams();
                    ((VideoDrawable.VideoDrawableParams)localObject1).mPlayVideoFrame = true;
                    ((VideoDrawable.VideoDrawableParams)localObject1).mEnableAntiAlias = true;
                    ((VideoDrawable.VideoDrawableParams)localObject1).mEnableFilter = true;
                    paramString2.mExtraInfo = localObject1;
                    paramString1 = URLDrawable.getDrawable(paramString1, paramString2);
                    if (paramString1.getStatus() == 1) {
                      paramView.setImageDrawable(paramString1);
                    }
                    for (;;)
                    {
                      a(paramInt, true);
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                      QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): Update video, position=" + paramInt);
                      break;
                      paramView.setDecodingDrawble(paramString1);
                      paramString1.startDownload();
                    }
                  }
                  if ((paramString2.a(0) != null) && (QLog.isColorLevel())) {
                    QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): thumb downloaded, position=" + paramInt);
                  }
                }
              }
            }
            else if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
            {
              localObject1 = (AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
              if (((AIOFilePicData)localObject1).jdField_a_of_type_Boolean)
              {
                paramString1 = paramView.a();
                if (!URLDrawable.class.isInstance(paramString1)) {
                  break label1384;
                }
                paramString2 = (URLDrawable)paramString1;
                paramString1 = paramString2.getURL().getRef();
              }
            }
          }
        }
      }
      for (;;)
      {
        if ((paramString1 == null) && (FileUtil.b(((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString)))
        {
          paramString1 = URLDrawable.URLDrawableOptions.obtain();
          paramString1.mLoadingDrawable = URLDrawableHelper.a;
          paramString1.mFailedDrawable = URLDrawableHelper.a;
          paramString1 = URLDrawable.getDrawable(new File(((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString), paramString1);
          if (paramString1 == null) {
            break label222;
          }
          paramView.setImageDrawable(paramString1);
          paramString1.downloadImediatly();
          break label222;
        }
        if ((paramString2 != null) && (paramString1 != null) && (("PART".equals(paramString1)) || ("DISPLAY".equals(paramString1)))) {
          break label222;
        }
        paramView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130837618));
        a(paramInt, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().d();
        if (((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_a_of_type_Long < FMConfig.c()) {
          break label222;
        }
        paramView.a();
        break label222;
        localObject2 = ((AIOFilePicData)localObject1).a(18);
        if (localObject2 == null) {
          break label222;
        }
        paramString2 = ((AIOFilePicData)localObject1).a(18);
        paramString1 = paramString2;
        if (paramBoolean) {
          paramString1 = paramString2 + "#PART";
        }
        paramString2 = URLDrawable.URLDrawableOptions.obtain();
        paramString2.mUseExifOrientation = false;
        paramString2.mPlayGifImage = true;
        paramString2 = URLDrawable.getDrawable((File)localObject2, paramString2);
        if (paramString2.getStatus() == 1)
        {
          paramView.setImageDrawable(paramString2);
          a(paramInt, true);
        }
        for (;;)
        {
          paramString2 = FileUtils.a(((AIOFilePicData)localObject1).jdField_c_of_type_JavaLangString);
          if ("png".equals(paramString2)) {
            paramView.setTag(Integer.valueOf(102));
          }
          if (QLog.isColorLevel()) {
            QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): Update large image, position=" + paramInt + "url = " + paramString1 + ",extName = " + paramString2);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().c();
          break;
          paramString2.setTag(Integer.valueOf(1));
          paramString2.startDownload();
          paramView.setDecodingDrawble(paramString2);
        }
        if (!AIOFileVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          break label222;
        }
        paramString2 = (AIOFileVideoData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        paramString1 = URLDrawable.URLDrawableOptions.obtain();
        paramString1.mUseExifOrientation = false;
        paramString1.mPlayGifImage = true;
        paramString2 = paramString2.a(0);
        if (paramString2 != null)
        {
          paramString1 = URLDrawable.getDrawable(paramString2, paramString1);
          if (paramString1.getStatus() == 1)
          {
            paramView.setImageDrawable(paramString1);
            a(paramInt, true);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().c();
            break;
            paramString1.setTag(Integer.valueOf(1));
            paramString1.startDownload();
            paramView.setDecodingDrawble(paramString1);
          }
        }
        paramView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130837618));
        a(paramInt, true);
        break label222;
        break;
        label1384:
        paramString1 = null;
        paramString2 = (String)localObject2;
      }
      label1392:
      paramString1 = null;
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getResources().getDisplayMetrics().widthPixels;
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getResources().getDisplayMetrics().heightPixels;
    if ((i != this.jdField_e_of_type_Int) || (j != this.jdField_f_of_type_Int))
    {
      this.jdField_e_of_type_Int = i;
      this.jdField_f_of_type_Int = j;
      URLDrawable.clearMemoryCache();
      a();
    }
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(AbstractImageListModel paramAbstractImageListModel)
  {
    super.a(paramAbstractImageListModel);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel = ((AIOImageListModel)paramAbstractImageListModel);
    a();
  }
  
  public void a(URLDrawable paramURLDrawable, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramURLDrawable);
    }
  }
  
  void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1 = a(paramInt);
    Object localObject2;
    int i;
    if ((paramView != null) && (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView)))
    {
      if ((this.d != paramInt) && (this.jdField_b_of_type_ComTencentImageURLDrawable != null))
      {
        a(this.d, this.jdField_b_of_type_ComTencentImageURLDrawable, false);
        if ((this.jdField_b_of_type_ComTencentImageURLDrawable.getStatus() == 1) && ((this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable)))
        {
          ((QQLiveDrawable)this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable()).recyleAndKeepPostion();
          if (QLog.isColorLevel()) {
            QLog.i("AIOGalleryAdapter", 2, "onMovedToScrapHeap(): recyleAndKeepPostion ");
          }
          this.jdField_b_of_type_ComTencentImageURLDrawable = null;
        }
      }
      if ((localObject1 == null) || (!AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
        break label645;
      }
      localObject1 = (AIOShortVideoData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (this.d == -1)
      {
        ReportController.b(null, "dc00898", "", "", "0X8007424", "0X8007424", 0, 0, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X8007427", "0X8007427", 0, 0, "", "", "", "");
      }
      if ((paramAdapterView != null) && (paramAdapterView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent() != null))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent();
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent().getBooleanExtra("extra.FROM_AIO", false)) {
          break label463;
        }
        paramAdapterView = "1";
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent().getIntExtra("forward_source_uin_type", -1);
        localObject2 = ((Intent)localObject2).getStringExtra("leftViewText");
        if (localObject2 == null) {
          break label749;
        }
        if (!((String)localObject2).equals("聊天记录")) {
          break label470;
        }
        paramAdapterView = "2";
      }
    }
    label304:
    label463:
    label470:
    label749:
    for (;;)
    {
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent().getStringExtra("uin"), String.valueOf(((AIOShortVideoData)localObject1).jdField_a_of_type_Int * 1000), i, "2", paramAdapterView);
      paramAdapterView = (AIOGalleryAdapter.GalleryImageStruct)paramView;
      paramView = ((AIOShortVideoData)localObject1).a(1);
      if (paramView != null) {
        if (URLDrawable.class.isInstance(paramAdapterView.a()))
        {
          localObject2 = ((URLDrawable)paramAdapterView.a()).getURL();
          if ((localObject2 != null) && (!"qqlive".equals(((URL)localObject2).getProtocol())))
          {
            if (QLog.isColorLevel()) {
              QLog.d("AIOGalleryAdapter", 2, "onItemSelected: not qqlive drawable");
            }
            a(paramInt, paramAdapterView, (AIOShortVideoData)localObject1, paramView);
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.onItemSelected(): video file " + paramView);
        }
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramAdapterView = "3";
              break;
              if ((i != 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a == null)) {
                break label749;
              }
              paramAdapterView = "3";
              break label304;
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a() == null) || (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a() instanceof AIOGalleryScene)) || (!((AIOGalleryScene)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a()).jdField_f_of_type_Boolean) || (localObject2 == null)) {
                break label430;
              }
              a(paramInt, paramAdapterView, (AIOShortVideoData)localObject1, paramView);
              break label430;
              paramAdapterView = ((AIOShortVideoData)localObject1).a(0);
            } while (paramAdapterView == null);
            this.d = -1;
            this.jdField_b_of_type_ComTencentImageURLDrawable = null;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(((AIOShortVideoData)localObject1).jdField_g_of_type_Long, ((AIOShortVideoData)localObject1).jdField_f_of_type_Int, 1);
          } while (!QLog.isColorLevel());
          QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.onItemSelected(): thumb file " + paramAdapterView);
          return;
          if ((localObject1 == null) || (!AIOImageData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
            break label723;
          }
          paramAdapterView = (AIOImageData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        } while ((paramAdapterView.jdField_c_of_type_Int != 3) || (paramAdapterView.a(1) != null) || (paramAdapterView.a(2) != null) || (paramAdapterView.a(4) != null) || (paramAdapterView.i >= FMConfig.c()));
        a(paramInt, -1);
        return;
        this.d = -1;
        this.jdField_b_of_type_ComTencentImageURLDrawable = null;
      } while (!QLog.isColorLevel());
      QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.onItemSelected(): Data is image");
      return;
    }
  }
  
  public void a(vmn paramvmn)
  {
    this.jdField_a_of_type_Vmn = paramvmn;
  }
  
  public void a(boolean paramBoolean)
  {
    super.notifyDataSetChanged();
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryAdapter", 2, "notifyDataSetChanged(): Data changed");
    }
    a();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AIORichMediaInfo localAIORichMediaInfo = a(paramInt1);
    if (localAIORichMediaInfo == null) {}
    do
    {
      do
      {
        return;
        if (!AIOImageData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          break;
        }
      } while (((AIOImageData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_d_of_type_Boolean);
      super.b(paramInt1, paramInt2);
      return;
      if (AIOShortVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        super.b(paramInt1, paramInt2);
        return;
      }
    } while (!AIOFilePicData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
    super.b(paramInt1, paramInt2);
  }
  
  public void b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramView != null)
    {
      if (paramView.getStatus() == 0) {
        paramView.cancelDownload(true);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    }
    if (paramInt == this.jdField_c_of_type_Int)
    {
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.jdField_c_of_type_Int = -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryAdapter", 2, a());
    }
  }
  
  public void b(int paramInt, View paramView, boolean paramBoolean)
  {
    a(paramInt, null, null, paramView, paramBoolean);
  }
  
  public void c(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AIOGalleryAdapter.GalleryImageStruct localGalleryImageStruct = (AIOGalleryAdapter.GalleryImageStruct)paramView;
    paramView = localGalleryImageStruct.a();
    paramViewGroup = localGalleryImageStruct.a();
    if (((paramView instanceof URLDrawable)) && (((URLDrawable)paramView).isFakeSize()) && (paramViewGroup == null))
    {
      paramView = ((URLDrawable)paramView).getURL();
      if (("file".equals(paramView.getProtocol())) && (paramView.getRef() == null))
      {
        if ((paramInt != this.jdField_c_of_type_Int) || (this.jdField_a_of_type_ComTencentImageURLDrawable == null)) {
          break label152;
        }
        paramViewGroup = this.jdField_a_of_type_ComTencentImageURLDrawable;
        paramView = paramViewGroup;
        if (QLog.isColorLevel())
        {
          paramView = paramViewGroup;
          if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
          {
            QLog.d("AIOGalleryAdapter", 2, "use exist raw drawable");
            paramView = paramViewGroup;
          }
        }
        if (paramView.getStatus() != 1) {
          break label281;
        }
        localGalleryImageStruct.setIgnoreLayout(true);
        localGalleryImageStruct.setImageDrawable(paramView);
        localGalleryImageStruct.setIgnoreLayout(false);
      }
    }
    label152:
    label281:
    while (!(paramView instanceof SkinnableBitmapDrawable)) {
      for (;;)
      {
        paramView = a(paramInt);
        if (paramView != null) {
          break;
        }
        return;
        if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentImageURLDrawable != null)) {
          QLog.d("AIOGalleryAdapter", 2, "rawDrawable is exist");
        }
        paramView = paramView.toString() + "#" + "NOSAMPLE";
        paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
        paramViewGroup.mUseExifOrientation = false;
        paramViewGroup.mUseMemoryCache = false;
        paramViewGroup = URLDrawable.getDrawable(paramView, paramViewGroup);
        paramViewGroup.setTag(Integer.valueOf(2));
        this.jdField_a_of_type_ComTencentImageURLDrawable = paramViewGroup;
        this.jdField_c_of_type_Int = paramInt;
        paramView = paramViewGroup;
        if (QLog.isColorLevel())
        {
          QLog.d("AIOGalleryAdapter", 2, "create rawDrawable, position:" + paramInt);
          paramView = paramViewGroup;
          continue;
          localGalleryImageStruct.setDecodingDrawble(paramView);
          paramView.startDownload();
        }
      }
    }
    return;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().c(paramView.hashCode());
  }
  
  /* Error */
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +5 -> 6
    //   4: aload_2
    //   5: areturn
    //   6: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +29 -> 38
    //   12: ldc 143
    //   14: iconst_2
    //   15: new 145	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 845
    //   25: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: iload_1
    //   29: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 292	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: new 391	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct
    //   41: dup
    //   42: aload_0
    //   43: aload_0
    //   44: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   47: invokespecial 848	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:<init>	(Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter;Landroid/content/Context;)V
    //   50: astore 8
    //   52: aload 8
    //   54: iconst_1
    //   55: invokevirtual 851	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setAdjustViewBounds	(Z)V
    //   58: aload_0
    //   59: iload_1
    //   60: invokevirtual 412	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(I)Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;
    //   63: astore 9
    //   65: aload 8
    //   67: astore_2
    //   68: aload 9
    //   70: ifnull -66 -> 4
    //   73: ldc_w 414
    //   76: aload 9
    //   78: getfield 419	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   81: invokevirtual 198	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   84: ifeq +2134 -> 2218
    //   87: aload 9
    //   89: getfield 419	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   92: checkcast 414	com/tencent/mobileqq/activity/aio/photo/AIOImageData
    //   95: astore 10
    //   97: aload 8
    //   99: iload_1
    //   100: invokevirtual 854	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setPosition	(I)V
    //   103: aload 8
    //   105: aload 9
    //   107: invokevirtual 858	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageInfo	(Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;)V
    //   110: aload 8
    //   112: iconst_0
    //   113: invokevirtual 829	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setIgnoreLayout	(Z)V
    //   116: aload 8
    //   118: aload 10
    //   120: getfield 861	com/tencent/mobileqq/activity/aio/photo/AIOImageData:k	Ljava/lang/String;
    //   123: invokevirtual 863	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:a	(Ljava/lang/String;)V
    //   126: iconst_0
    //   127: istore 4
    //   129: aconst_null
    //   130: astore_2
    //   131: aload_0
    //   132: getfield 38	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   135: iload_1
    //   136: invokevirtual 406	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   139: checkcast 124	com/tencent/image/URLDrawable
    //   142: astore_3
    //   143: aload_3
    //   144: ifnull +441 -> 585
    //   147: aload_3
    //   148: invokevirtual 132	com/tencent/image/URLDrawable:getStatus	()I
    //   151: iconst_1
    //   152: if_icmpne +433 -> 585
    //   155: aload 8
    //   157: aload_3
    //   158: invokevirtual 395	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   161: aload 10
    //   163: iconst_4
    //   164: invokevirtual 443	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/lang/String;
    //   167: astore_2
    //   168: aload_3
    //   169: invokevirtual 608	com/tencent/image/URLDrawable:getURL	()Ljava/net/URL;
    //   172: invokevirtual 368	java/net/URL:toString	()Ljava/lang/String;
    //   175: astore 7
    //   177: aload 7
    //   179: aload_2
    //   180: invokevirtual 614	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   183: ifeq +9 -> 192
    //   186: aload 8
    //   188: iconst_1
    //   189: invokevirtual 866	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setOriginalImage	(Z)V
    //   192: aload 9
    //   194: getfield 867	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_b_of_type_Int	I
    //   197: bipush 254
    //   199: if_icmpne +18 -> 217
    //   202: aload 9
    //   204: aload_3
    //   205: invokevirtual 608	com/tencent/image/URLDrawable:getURL	()Ljava/net/URL;
    //   208: invokevirtual 870	java/net/URL:getFile	()Ljava/lang/String;
    //   211: invokestatic 876	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   214: putfield 867	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_b_of_type_Int	I
    //   217: aload 8
    //   219: aload_3
    //   220: aload 9
    //   222: getfield 867	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_b_of_type_Int	I
    //   225: invokestatic 879	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(Landroid/view/View;Lcom/tencent/image/URLDrawable;I)V
    //   228: aload 8
    //   230: invokevirtual 881	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:a	()Z
    //   233: ifeq +336 -> 569
    //   236: aload 10
    //   238: getfield 882	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   241: astore_2
    //   242: aload_2
    //   243: invokestatic 648	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   246: astore_2
    //   247: ldc_w 650
    //   250: aload_2
    //   251: invokevirtual 614	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   254: ifeq +13 -> 267
    //   257: aload 8
    //   259: bipush 102
    //   261: invokestatic 453	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   264: invokevirtual 651	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setTag	(Ljava/lang/Object;)V
    //   267: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +61 -> 331
    //   273: ldc 143
    //   275: iconst_2
    //   276: new 145	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   283: ldc_w 884
    //   286: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload 7
    //   291: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: ldc_w 886
    //   297: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload 10
    //   302: aload_3
    //   303: invokevirtual 608	com/tencent/image/URLDrawable:getURL	()Ljava/net/URL;
    //   306: invokevirtual 870	java/net/URL:getFile	()Ljava/lang/String;
    //   309: invokevirtual 888	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(Ljava/lang/String;)I
    //   312: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   315: ldc_w 890
    //   318: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_2
    //   322: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 292	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: aload 10
    //   333: getfield 440	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_d_of_type_Boolean	Z
    //   336: ifeq +23 -> 359
    //   339: aload_0
    //   340: getfield 61	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider	Lcom/tencent/mobileqq/activity/aio/photo/IAIOImageProvider;
    //   343: aload 10
    //   345: getfield 483	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_g_of_type_Long	J
    //   348: aload 10
    //   350: getfield 484	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Int	I
    //   353: iconst_2
    //   354: invokeinterface 489 5 0
    //   359: aload 8
    //   361: invokevirtual 881	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:a	()Z
    //   364: ifeq +214 -> 578
    //   367: ldc_w 892
    //   370: astore_2
    //   371: iconst_1
    //   372: istore 4
    //   374: iconst_1
    //   375: istore_1
    //   376: iload_1
    //   377: ifeq +88 -> 465
    //   380: aload 9
    //   382: invokevirtual 544	java/lang/Object:hashCode	()I
    //   385: istore_1
    //   386: aload_0
    //   387: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   390: iload_1
    //   391: putfield 893	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Int	I
    //   394: aload_0
    //   395: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   398: invokevirtual 539	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:a	()Lcom/tencent/mobileqq/richmedia/dc/DCAIOPreview;
    //   401: astore_3
    //   402: aload_3
    //   403: iload_1
    //   404: invokevirtual 894	com/tencent/mobileqq/richmedia/dc/DCAIOPreview:a	(I)V
    //   407: aload_3
    //   408: iload_1
    //   409: aload 10
    //   411: getfield 895	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_a_of_type_Long	J
    //   414: aload 10
    //   416: getfield 896	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_Long	J
    //   419: invokevirtual 899	com/tencent/mobileqq/richmedia/dc/DCAIOPreview:a	(IJJ)V
    //   422: aload_3
    //   423: iload_1
    //   424: aload 10
    //   426: getfield 475	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_a_of_type_Int	I
    //   429: invokestatic 480	cooperation/peak/PeakUtils:a	(I)Z
    //   432: invokevirtual 901	com/tencent/mobileqq/richmedia/dc/DCAIOPreview:b	(IZ)V
    //   435: aload 10
    //   437: getfield 903	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_e_of_type_Boolean	Z
    //   440: ifeq +8 -> 448
    //   443: aload_3
    //   444: iload_1
    //   445: invokevirtual 905	com/tencent/mobileqq/richmedia/dc/DCAIOPreview:d	(I)V
    //   448: aload_2
    //   449: ifnull +16 -> 465
    //   452: aload_3
    //   453: iload_1
    //   454: aload_2
    //   455: invokevirtual 908	com/tencent/mobileqq/richmedia/dc/DCAIOPreview:a	(ILjava/lang/String;)V
    //   458: aload_3
    //   459: iload_1
    //   460: iload 4
    //   462: invokevirtual 909	com/tencent/mobileqq/richmedia/dc/DCAIOPreview:a	(IZ)V
    //   465: new 145	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   472: aload 10
    //   474: getfield 483	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_g_of_type_Long	J
    //   477: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   480: ldc_w 911
    //   483: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: aload 10
    //   488: getfield 484	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Int	I
    //   491: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   494: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: astore_3
    //   498: aload 8
    //   500: astore_2
    //   501: aload_0
    //   502: getfield 47	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   505: aload_3
    //   506: invokevirtual 914	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   509: ifne -505 -> 4
    //   512: aload_0
    //   513: getfield 61	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider	Lcom/tencent/mobileqq/activity/aio/photo/IAIOImageProvider;
    //   516: aload 10
    //   518: getfield 483	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_g_of_type_Long	J
    //   521: aload 10
    //   523: getfield 484	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Int	I
    //   526: invokeinterface 917 4 0
    //   531: aload_0
    //   532: getfield 47	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   535: aload_3
    //   536: invokevirtual 920	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   539: pop
    //   540: aload 8
    //   542: areturn
    //   543: astore_2
    //   544: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   547: ifeq +13 -> 560
    //   550: ldc 143
    //   552: iconst_2
    //   553: ldc_w 922
    //   556: aload_2
    //   557: invokestatic 159	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   560: aload 9
    //   562: iconst_1
    //   563: putfield 867	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_b_of_type_Int	I
    //   566: goto -349 -> 217
    //   569: aload 10
    //   571: getfield 602	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   574: astore_2
    //   575: goto -333 -> 242
    //   578: ldc_w 924
    //   581: astore_2
    //   582: goto -211 -> 371
    //   585: aload 10
    //   587: iconst_4
    //   588: invokevirtual 420	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/io/File;
    //   591: astore 7
    //   593: aload 7
    //   595: ifnonnull +3198 -> 3793
    //   598: aload 10
    //   600: iconst_2
    //   601: invokevirtual 420	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/io/File;
    //   604: astore_3
    //   605: aload_3
    //   606: ifnull +701 -> 1307
    //   609: aload 7
    //   611: ifnull +447 -> 1058
    //   614: iconst_1
    //   615: istore 5
    //   617: invokestatic 360	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   620: astore 7
    //   622: aload 7
    //   624: aload_0
    //   625: getfield 80	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_e_of_type_Int	I
    //   628: putfield 927	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   631: aload 7
    //   633: aload_0
    //   634: getfield 85	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_f_of_type_Int	I
    //   637: putfield 930	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   640: aload 7
    //   642: getstatic 424	com/tencent/mobileqq/transfile/URLDrawableHelper:a	Landroid/graphics/drawable/Drawable;
    //   645: putfield 377	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   648: aload 7
    //   650: iconst_1
    //   651: putfield 430	com/tencent/image/URLDrawable$URLDrawableOptions:mPlayGifImage	Z
    //   654: aload 7
    //   656: iconst_0
    //   657: putfield 433	com/tencent/image/URLDrawable$URLDrawableOptions:mUseExifOrientation	Z
    //   660: aload 10
    //   662: getfield 434	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_c_of_type_Int	I
    //   665: iconst_1
    //   666: if_icmpne +20 -> 686
    //   669: aload 10
    //   671: getfield 435	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_e_of_type_Int	I
    //   674: iconst_2
    //   675: iand
    //   676: iconst_2
    //   677: if_icmpne +9 -> 686
    //   680: aload 7
    //   682: iconst_0
    //   683: putfield 438	com/tencent/image/URLDrawable$URLDrawableOptions:mUseAutoScaleParams	Z
    //   686: aload_0
    //   687: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   690: getfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   693: ifeq +27 -> 720
    //   696: aload_0
    //   697: getfield 932	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   700: ifnull +364 -> 1064
    //   703: aload 7
    //   705: aload_0
    //   706: getfield 932	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   709: invokevirtual 536	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:a	()Landroid/graphics/drawable/Drawable;
    //   712: putfield 377	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   715: aload_0
    //   716: aconst_null
    //   717: putfield 932	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   720: iload 5
    //   722: ifne +393 -> 1115
    //   725: aload 10
    //   727: getfield 440	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_d_of_type_Boolean	Z
    //   730: ifeq +385 -> 1115
    //   733: new 145	java/lang/StringBuilder
    //   736: dup
    //   737: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   740: aload 10
    //   742: iconst_2
    //   743: invokevirtual 443	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/lang/String;
    //   746: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: ldc_w 445
    //   752: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: ldc_w 447
    //   758: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   764: aload 7
    //   766: invokestatic 389	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   769: astore 7
    //   771: aload 7
    //   773: iconst_1
    //   774: invokestatic 453	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   777: invokevirtual 457	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   780: aload_0
    //   781: getfield 38	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   784: iload_1
    //   785: aload 7
    //   787: invokevirtual 460	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   790: aload 7
    //   792: invokevirtual 935	com/tencent/image/URLDrawable:isDownloadStarted	()Z
    //   795: ifeq +32 -> 827
    //   798: getstatic 939	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   801: aload 7
    //   803: invokevirtual 608	com/tencent/image/URLDrawable:getURL	()Ljava/net/URL;
    //   806: invokevirtual 368	java/net/URL:toString	()Ljava/lang/String;
    //   809: invokevirtual 944	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   812: ifnull +336 -> 1148
    //   815: iconst_1
    //   816: istore 4
    //   818: iload 5
    //   820: ifeq +334 -> 1154
    //   823: ldc_w 892
    //   826: astore_2
    //   827: aload 7
    //   829: invokevirtual 132	com/tencent/image/URLDrawable:getStatus	()I
    //   832: tableswitch	default:+28 -> 860, 1:+329->1161, 2:+363->1195, 3:+363->1195
    //   861: iconst_5
    //   862: aload 7
    //   864: invokevirtual 395	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   867: aload 8
    //   869: iload 5
    //   871: invokevirtual 866	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setOriginalImage	(Z)V
    //   874: aload_0
    //   875: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   878: getfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   881: ifne +8 -> 889
    //   884: aload 7
    //   886: invokevirtual 696	com/tencent/image/URLDrawable:downloadImediatly	()V
    //   889: iload 5
    //   891: ifeq +366 -> 1257
    //   894: aload 10
    //   896: getfield 882	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   899: astore_3
    //   900: aload_3
    //   901: invokestatic 648	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   904: astore_3
    //   905: ldc_w 650
    //   908: aload_3
    //   909: invokevirtual 614	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   912: ifeq +13 -> 925
    //   915: aload 8
    //   917: bipush 102
    //   919: invokestatic 453	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   922: invokevirtual 651	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setTag	(Ljava/lang/Object;)V
    //   925: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   928: ifeq +68 -> 996
    //   931: ldc 143
    //   933: iconst_2
    //   934: new 145	java/lang/StringBuilder
    //   937: dup
    //   938: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   941: ldc_w 946
    //   944: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: aload 7
    //   949: invokevirtual 608	com/tencent/image/URLDrawable:getURL	()Ljava/net/URL;
    //   952: invokevirtual 368	java/net/URL:toString	()Ljava/lang/String;
    //   955: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: ldc_w 948
    //   961: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: aload 10
    //   966: aload 7
    //   968: invokevirtual 608	com/tencent/image/URLDrawable:getURL	()Ljava/net/URL;
    //   971: invokevirtual 368	java/net/URL:toString	()Ljava/lang/String;
    //   974: invokevirtual 888	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(Ljava/lang/String;)I
    //   977: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   980: ldc_w 657
    //   983: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: aload_3
    //   987: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   990: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   993: invokestatic 292	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   996: iload 5
    //   998: ifne +268 -> 1266
    //   1001: aload 10
    //   1003: getfield 440	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_d_of_type_Boolean	Z
    //   1006: ifeq +260 -> 1266
    //   1009: aload 10
    //   1011: getfield 467	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_Boolean	Z
    //   1014: ifne +252 -> 1266
    //   1017: aload_0
    //   1018: getfield 61	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider	Lcom/tencent/mobileqq/activity/aio/photo/IAIOImageProvider;
    //   1021: aload 10
    //   1023: getfield 483	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_g_of_type_Long	J
    //   1026: aload 10
    //   1028: getfield 484	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Int	I
    //   1031: iconst_2
    //   1032: invokeinterface 489 5 0
    //   1037: aload_0
    //   1038: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   1041: getfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   1044: ifne +9 -> 1053
    //   1047: aload_0
    //   1048: aload 8
    //   1050: putfield 932	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   1053: iconst_1
    //   1054: istore_1
    //   1055: goto -679 -> 376
    //   1058: iconst_0
    //   1059: istore 5
    //   1061: goto -444 -> 617
    //   1064: aload 10
    //   1066: iconst_1
    //   1067: invokevirtual 443	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/lang/String;
    //   1070: ifnull -350 -> 720
    //   1073: getstatic 939	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   1076: aload 10
    //   1078: iconst_1
    //   1079: invokevirtual 443	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/lang/String;
    //   1082: invokevirtual 944	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1085: ifnull -365 -> 720
    //   1088: aload 10
    //   1090: iconst_1
    //   1091: invokevirtual 420	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/io/File;
    //   1094: ifnull -374 -> 720
    //   1097: aload 7
    //   1099: aload 10
    //   1101: iconst_1
    //   1102: invokevirtual 443	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/lang/String;
    //   1105: aconst_null
    //   1106: invokestatic 389	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   1109: putfield 377	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   1112: goto -392 -> 720
    //   1115: aload_3
    //   1116: aload 7
    //   1118: invokestatic 463	com/tencent/image/URLDrawable:getDrawable	(Ljava/io/File;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   1121: astore 7
    //   1123: goto -352 -> 771
    //   1126: astore_2
    //   1127: aload 8
    //   1129: astore_2
    //   1130: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1133: ifeq -1129 -> 4
    //   1136: ldc 143
    //   1138: iconst_2
    //   1139: ldc_w 950
    //   1142: invokestatic 952	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1145: aload 8
    //   1147: areturn
    //   1148: iconst_0
    //   1149: istore 4
    //   1151: goto -333 -> 818
    //   1154: ldc_w 924
    //   1157: astore_2
    //   1158: goto -331 -> 827
    //   1161: aload 9
    //   1163: getfield 867	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_b_of_type_Int	I
    //   1166: bipush 254
    //   1168: if_icmpne +15 -> 1183
    //   1171: aload 9
    //   1173: aload_3
    //   1174: invokevirtual 325	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1177: invokestatic 876	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   1180: putfield 867	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_b_of_type_Int	I
    //   1183: aload 8
    //   1185: aload 7
    //   1187: aload 9
    //   1189: getfield 867	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_b_of_type_Int	I
    //   1192: invokestatic 879	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(Landroid/view/View;Lcom/tencent/image/URLDrawable;I)V
    //   1195: aload 7
    //   1197: invokevirtual 132	com/tencent/image/URLDrawable:getStatus	()I
    //   1200: iconst_1
    //   1201: if_icmpne +42 -> 1243
    //   1204: iconst_1
    //   1205: istore 6
    //   1207: aload_0
    //   1208: iload_1
    //   1209: iload 6
    //   1211: invokevirtual 398	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(IZ)V
    //   1214: goto -354 -> 860
    //   1217: astore_3
    //   1218: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1221: ifeq +13 -> 1234
    //   1224: ldc 143
    //   1226: iconst_2
    //   1227: ldc_w 922
    //   1230: aload_3
    //   1231: invokestatic 159	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1234: aload 9
    //   1236: iconst_1
    //   1237: putfield 867	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_b_of_type_Int	I
    //   1240: goto -57 -> 1183
    //   1243: iconst_0
    //   1244: istore 6
    //   1246: goto -39 -> 1207
    //   1249: astore_3
    //   1250: aload_3
    //   1251: invokevirtual 955	java/lang/Exception:printStackTrace	()V
    //   1254: goto -365 -> 889
    //   1257: aload 10
    //   1259: getfield 602	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1262: astore_3
    //   1263: goto -363 -> 900
    //   1266: aload_0
    //   1267: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   1270: getfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   1273: ifne -220 -> 1053
    //   1276: aload_0
    //   1277: getfield 33	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Boolean	Z
    //   1280: ifne -227 -> 1053
    //   1283: aload_0
    //   1284: getfield 61	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider	Lcom/tencent/mobileqq/activity/aio/photo/IAIOImageProvider;
    //   1287: aload_0
    //   1288: getfield 87	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Int	I
    //   1291: invokeinterface 642 2 0
    //   1296: aload_0
    //   1297: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   1300: iconst_1
    //   1301: putfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   1304: goto -251 -> 1053
    //   1307: aload 10
    //   1309: bipush 8
    //   1311: invokevirtual 420	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/io/File;
    //   1314: ifnull +267 -> 1581
    //   1317: invokestatic 360	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   1320: astore_2
    //   1321: aload_2
    //   1322: getstatic 424	com/tencent/mobileqq/transfile/URLDrawableHelper:a	Landroid/graphics/drawable/Drawable;
    //   1325: putfield 377	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   1328: aload_2
    //   1329: getstatic 424	com/tencent/mobileqq/transfile/URLDrawableHelper:a	Landroid/graphics/drawable/Drawable;
    //   1332: putfield 427	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   1335: aload_2
    //   1336: iconst_0
    //   1337: putfield 433	com/tencent/image/URLDrawable$URLDrawableOptions:mUseExifOrientation	Z
    //   1340: aload 10
    //   1342: getfield 434	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_c_of_type_Int	I
    //   1345: iconst_1
    //   1346: if_icmpne +19 -> 1365
    //   1349: aload 10
    //   1351: getfield 435	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_e_of_type_Int	I
    //   1354: iconst_2
    //   1355: iand
    //   1356: iconst_2
    //   1357: if_icmpne +8 -> 1365
    //   1360: aload_2
    //   1361: iconst_0
    //   1362: putfield 438	com/tencent/image/URLDrawable$URLDrawableOptions:mUseAutoScaleParams	Z
    //   1365: aload 8
    //   1367: aload 10
    //   1369: bipush 8
    //   1371: invokevirtual 443	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/lang/String;
    //   1374: aload_2
    //   1375: invokestatic 389	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   1378: invokevirtual 395	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1381: aload_0
    //   1382: iload_1
    //   1383: aload 9
    //   1385: getfield 956	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_Int	I
    //   1388: bipush 100
    //   1390: idiv
    //   1391: invokevirtual 799	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(II)V
    //   1394: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1397: ifeq +46 -> 1443
    //   1400: ldc 143
    //   1402: iconst_2
    //   1403: new 145	java/lang/StringBuilder
    //   1406: dup
    //   1407: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   1410: ldc_w 946
    //   1413: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1416: aload 10
    //   1418: bipush 8
    //   1420: invokevirtual 443	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/lang/String;
    //   1423: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1426: ldc_w 948
    //   1429: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1432: bipush 8
    //   1434: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1437: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1440: invokestatic 292	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1443: aload 10
    //   1445: getfield 467	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_Boolean	Z
    //   1448: ifne +92 -> 1540
    //   1451: aload_0
    //   1452: getfield 61	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider	Lcom/tencent/mobileqq/activity/aio/photo/IAIOImageProvider;
    //   1455: aload 10
    //   1457: getfield 483	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_g_of_type_Long	J
    //   1460: aload 10
    //   1462: getfield 484	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Int	I
    //   1465: iconst_2
    //   1466: invokeinterface 489 5 0
    //   1471: aload_0
    //   1472: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   1475: getfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   1478: ifne +20 -> 1498
    //   1481: aload_0
    //   1482: aload 8
    //   1484: putfield 932	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   1487: aload_0
    //   1488: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   1491: invokevirtual 552	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:a	()Lcom/tencent/mobileqq/richmedia/dc/DCAIOPreviewProgressive;
    //   1494: iconst_1
    //   1495: invokevirtual 958	com/tencent/mobileqq/richmedia/dc/DCAIOPreviewProgressive:a	(Z)V
    //   1498: invokestatic 492	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1501: ifeq +29 -> 1530
    //   1504: aload 10
    //   1506: getfield 440	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_d_of_type_Boolean	Z
    //   1509: ifeq +21 -> 1530
    //   1512: aload 8
    //   1514: invokevirtual 629	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:getContext	()Landroid/content/Context;
    //   1517: ldc_w 960
    //   1520: sipush 2000
    //   1523: invokestatic 636	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1526: invokevirtual 639	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1529: pop
    //   1530: iconst_1
    //   1531: istore_1
    //   1532: aconst_null
    //   1533: astore_2
    //   1534: iconst_0
    //   1535: istore 4
    //   1537: goto -1161 -> 376
    //   1540: aload_0
    //   1541: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   1544: getfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   1547: ifne -76 -> 1471
    //   1550: aload_0
    //   1551: getfield 33	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Boolean	Z
    //   1554: ifne -83 -> 1471
    //   1557: aload_0
    //   1558: getfield 61	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider	Lcom/tencent/mobileqq/activity/aio/photo/IAIOImageProvider;
    //   1561: aload_0
    //   1562: getfield 87	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Int	I
    //   1565: invokeinterface 642 2 0
    //   1570: aload_0
    //   1571: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   1574: iconst_1
    //   1575: putfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   1578: goto -107 -> 1471
    //   1581: aload 10
    //   1583: getfield 465	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_c_of_type_Boolean	Z
    //   1586: ifne +19 -> 1605
    //   1589: aload 10
    //   1591: getfield 467	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_Boolean	Z
    //   1594: ifne +11 -> 1605
    //   1597: aload 10
    //   1599: getfield 468	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_a_of_type_Boolean	Z
    //   1602: ifeq +111 -> 1713
    //   1605: aload_0
    //   1606: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   1609: getfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   1612: ifeq +75 -> 1687
    //   1615: aload_0
    //   1616: getfield 932	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   1619: ifnull +68 -> 1687
    //   1622: aload_0
    //   1623: getfield 932	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   1626: invokevirtual 536	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:a	()Landroid/graphics/drawable/Drawable;
    //   1629: astore_2
    //   1630: aload 8
    //   1632: aload_2
    //   1633: invokevirtual 395	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1636: ldc 124
    //   1638: aload_2
    //   1639: invokevirtual 198	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   1642: ifeq +15 -> 1657
    //   1645: aload_0
    //   1646: getfield 38	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   1649: iload_1
    //   1650: aload_2
    //   1651: checkcast 124	com/tencent/image/URLDrawable
    //   1654: invokevirtual 460	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1657: aload_0
    //   1658: aconst_null
    //   1659: putfield 932	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   1662: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1665: ifeq +376 -> 2041
    //   1668: ldc 143
    //   1670: iconst_2
    //   1671: ldc_w 962
    //   1674: invokestatic 292	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1677: aconst_null
    //   1678: astore_2
    //   1679: iconst_0
    //   1680: istore 4
    //   1682: iconst_0
    //   1683: istore_1
    //   1684: goto -1308 -> 376
    //   1687: aload 8
    //   1689: invokestatic 617	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1692: invokevirtual 618	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   1695: ldc_w 619
    //   1698: invokevirtual 622	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1701: invokevirtual 395	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1704: aload_0
    //   1705: iload_1
    //   1706: iconst_0
    //   1707: invokevirtual 398	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(IZ)V
    //   1710: goto -48 -> 1662
    //   1713: aload 10
    //   1715: iconst_1
    //   1716: invokevirtual 420	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/io/File;
    //   1719: astore_2
    //   1720: aload_2
    //   1721: ifnull +231 -> 1952
    //   1724: invokestatic 360	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   1727: astore_3
    //   1728: aload_3
    //   1729: getstatic 424	com/tencent/mobileqq/transfile/URLDrawableHelper:a	Landroid/graphics/drawable/Drawable;
    //   1732: putfield 377	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   1735: aload_3
    //   1736: getstatic 424	com/tencent/mobileqq/transfile/URLDrawableHelper:a	Landroid/graphics/drawable/Drawable;
    //   1739: putfield 427	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   1742: aload 10
    //   1744: getfield 434	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_c_of_type_Int	I
    //   1747: iconst_1
    //   1748: if_icmpne +19 -> 1767
    //   1751: aload 10
    //   1753: getfield 435	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_e_of_type_Int	I
    //   1756: iconst_2
    //   1757: iand
    //   1758: iconst_2
    //   1759: if_icmpne +8 -> 1767
    //   1762: aload_3
    //   1763: iconst_0
    //   1764: putfield 438	com/tencent/image/URLDrawable$URLDrawableOptions:mUseAutoScaleParams	Z
    //   1767: aload_2
    //   1768: aload_3
    //   1769: invokestatic 463	com/tencent/image/URLDrawable:getDrawable	(Ljava/io/File;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   1772: astore_2
    //   1773: aload 8
    //   1775: aload_2
    //   1776: invokevirtual 395	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1779: aload 10
    //   1781: getfield 964	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_g_of_type_Boolean	Z
    //   1784: ifne +128 -> 1912
    //   1787: aload_2
    //   1788: invokevirtual 696	com/tencent/image/URLDrawable:downloadImediatly	()V
    //   1791: aload_0
    //   1792: iload_1
    //   1793: aload 9
    //   1795: getfield 956	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_Int	I
    //   1798: bipush 100
    //   1800: idiv
    //   1801: invokevirtual 799	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(II)V
    //   1804: aload_0
    //   1805: getfield 61	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider	Lcom/tencent/mobileqq/activity/aio/photo/IAIOImageProvider;
    //   1808: aload 10
    //   1810: getfield 483	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_g_of_type_Long	J
    //   1813: aload 10
    //   1815: getfield 484	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Int	I
    //   1818: iconst_2
    //   1819: invokeinterface 489 5 0
    //   1824: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1827: ifeq +44 -> 1871
    //   1830: ldc 143
    //   1832: iconst_2
    //   1833: new 145	java/lang/StringBuilder
    //   1836: dup
    //   1837: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   1840: ldc_w 946
    //   1843: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1846: aload 10
    //   1848: iconst_1
    //   1849: invokevirtual 443	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/lang/String;
    //   1852: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1855: ldc_w 948
    //   1858: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1861: iconst_1
    //   1862: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1865: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1868: invokestatic 292	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1871: aload_0
    //   1872: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   1875: getfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   1878: ifne +24 -> 1902
    //   1881: aload_0
    //   1882: aload 8
    //   1884: putfield 932	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   1887: aload_0
    //   1888: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   1891: invokevirtual 552	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:a	()Lcom/tencent/mobileqq/richmedia/dc/DCAIOPreviewProgressive;
    //   1894: aload 10
    //   1896: getfield 965	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Boolean	Z
    //   1899: invokevirtual 958	com/tencent/mobileqq/richmedia/dc/DCAIOPreviewProgressive:a	(Z)V
    //   1902: iconst_1
    //   1903: istore_1
    //   1904: aconst_null
    //   1905: astore_2
    //   1906: iconst_0
    //   1907: istore 4
    //   1909: goto -1533 -> 376
    //   1912: invokestatic 970	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1915: astore_2
    //   1916: aload_2
    //   1917: invokevirtual 971	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   1920: aload_2
    //   1921: aload_0
    //   1922: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   1925: getfield 972	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1928: aload 10
    //   1930: sipush 640
    //   1933: new 974	vmi
    //   1936: dup
    //   1937: aload_0
    //   1938: iload_1
    //   1939: aload 8
    //   1941: aload 10
    //   1943: invokespecial 977	vmi:<init>	(Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter;ILcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;Lcom/tencent/mobileqq/activity/aio/photo/AIOImageData;)V
    //   1946: invokevirtual 980	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/lang/String;Lcom/tencent/mobileqq/activity/aio/photo/AIOImageData;ILcom/tencent/biz/troop/TroopMemberApiClient$Callback;)V
    //   1949: goto -47 -> 1902
    //   1952: aload 10
    //   1954: getfield 964	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_g_of_type_Boolean	Z
    //   1957: ifne +94 -> 2051
    //   1960: aload_0
    //   1961: iload_1
    //   1962: aload 9
    //   1964: getfield 956	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_Int	I
    //   1967: bipush 100
    //   1969: idiv
    //   1970: invokevirtual 799	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(II)V
    //   1973: aload 8
    //   1975: getstatic 424	com/tencent/mobileqq/transfile/URLDrawableHelper:a	Landroid/graphics/drawable/Drawable;
    //   1978: invokevirtual 395	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1981: aload_0
    //   1982: getfield 61	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider	Lcom/tencent/mobileqq/activity/aio/photo/IAIOImageProvider;
    //   1985: aload 10
    //   1987: getfield 483	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_g_of_type_Long	J
    //   1990: aload 10
    //   1992: getfield 484	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Int	I
    //   1995: iconst_2
    //   1996: invokeinterface 489 5 0
    //   2001: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2004: ifeq +12 -> 2016
    //   2007: ldc 143
    //   2009: iconst_2
    //   2010: ldc_w 982
    //   2013: invokestatic 292	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2016: aload_0
    //   2017: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2020: getfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   2023: ifne +18 -> 2041
    //   2026: aload_0
    //   2027: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2030: invokevirtual 552	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:a	()Lcom/tencent/mobileqq/richmedia/dc/DCAIOPreviewProgressive;
    //   2033: aload 10
    //   2035: getfield 965	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Boolean	Z
    //   2038: invokevirtual 958	com/tencent/mobileqq/richmedia/dc/DCAIOPreviewProgressive:a	(Z)V
    //   2041: aconst_null
    //   2042: astore_2
    //   2043: iconst_0
    //   2044: istore 4
    //   2046: iconst_0
    //   2047: istore_1
    //   2048: goto -1672 -> 376
    //   2051: aload 10
    //   2053: getfield 796	com/tencent/mobileqq/activity/aio/photo/AIOImageData:i	J
    //   2056: invokestatic 516	com/tencent/mobileqq/filemanager/data/FMConfig:c	()J
    //   2059: lcmp
    //   2060: ifgt +94 -> 2154
    //   2063: aload_0
    //   2064: iload_1
    //   2065: aload 9
    //   2067: getfield 956	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_Int	I
    //   2070: bipush 100
    //   2072: idiv
    //   2073: invokevirtual 799	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(II)V
    //   2076: aload 8
    //   2078: getstatic 424	com/tencent/mobileqq/transfile/URLDrawableHelper:a	Landroid/graphics/drawable/Drawable;
    //   2081: invokevirtual 395	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2084: invokestatic 970	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   2087: astore_2
    //   2088: aload_2
    //   2089: invokevirtual 971	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   2092: aload_2
    //   2093: aload_0
    //   2094: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2097: getfield 972	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2100: aload 10
    //   2102: sipush 383
    //   2105: new 984	vmk
    //   2108: dup
    //   2109: aload_0
    //   2110: invokespecial 987	vmk:<init>	(Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter;)V
    //   2113: invokevirtual 980	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/lang/String;Lcom/tencent/mobileqq/activity/aio/photo/AIOImageData;ILcom/tencent/biz/troop/TroopMemberApiClient$Callback;)V
    //   2116: aload_0
    //   2117: iload_1
    //   2118: iconst_0
    //   2119: invokevirtual 799	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(II)V
    //   2122: aload_2
    //   2123: aload_0
    //   2124: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2127: getfield 972	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2130: aload 10
    //   2132: sipush 640
    //   2135: new 989	vml
    //   2138: dup
    //   2139: aload_0
    //   2140: iload_1
    //   2141: aload 8
    //   2143: aload 10
    //   2145: invokespecial 990	vml:<init>	(Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter;ILcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;Lcom/tencent/mobileqq/activity/aio/photo/AIOImageData;)V
    //   2148: invokevirtual 980	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/lang/String;Lcom/tencent/mobileqq/activity/aio/photo/AIOImageData;ILcom/tencent/biz/troop/TroopMemberApiClient$Callback;)V
    //   2151: goto -135 -> 2016
    //   2154: aload_0
    //   2155: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2158: getfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   2161: ifne +18 -> 2179
    //   2164: aload_0
    //   2165: getfield 33	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Boolean	Z
    //   2168: ifne +11 -> 2179
    //   2171: aload_0
    //   2172: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2175: iconst_1
    //   2176: putfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   2179: aload 8
    //   2181: invokestatic 617	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2184: invokevirtual 618	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   2187: ldc_w 619
    //   2190: invokevirtual 622	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   2193: invokevirtual 395	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2196: aload 8
    //   2198: invokevirtual 697	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:a	()V
    //   2201: aload 8
    //   2203: ldc_w 991
    //   2206: ldc_w 992
    //   2209: invokestatic 997	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   2212: invokevirtual 999	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setTag	(ILjava/lang/Object;)V
    //   2215: goto -199 -> 2016
    //   2218: ldc_w 309
    //   2221: aload 9
    //   2223: getfield 419	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   2226: invokevirtual 198	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   2229: ifeq +387 -> 2616
    //   2232: aload 9
    //   2234: getfield 419	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   2237: checkcast 309	com/tencent/mobileqq/activity/aio/photo/AIOShortVideoData
    //   2240: astore_2
    //   2241: aload_0
    //   2242: getfield 38	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   2245: iload_1
    //   2246: invokevirtual 406	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   2249: checkcast 124	com/tencent/image/URLDrawable
    //   2252: astore_3
    //   2253: aload 8
    //   2255: iload_1
    //   2256: invokevirtual 854	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setPosition	(I)V
    //   2259: aload 8
    //   2261: aload 9
    //   2263: invokevirtual 858	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageInfo	(Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;)V
    //   2266: aload_3
    //   2267: ifnull +99 -> 2366
    //   2270: aload_3
    //   2271: invokevirtual 132	com/tencent/image/URLDrawable:getStatus	()I
    //   2274: iconst_1
    //   2275: if_icmpne +91 -> 2366
    //   2278: aload 8
    //   2280: aload_3
    //   2281: invokevirtual 395	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2284: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2287: ifeq +32 -> 2319
    //   2290: ldc 143
    //   2292: iconst_2
    //   2293: new 145	java/lang/StringBuilder
    //   2296: dup
    //   2297: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   2300: ldc_w 1001
    //   2303: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2306: aload_3
    //   2307: invokevirtual 608	com/tencent/image/URLDrawable:getURL	()Ljava/net/URL;
    //   2310: invokevirtual 775	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2313: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2316: invokestatic 292	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2319: aload 8
    //   2321: astore_2
    //   2322: aload_0
    //   2323: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2326: getfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   2329: ifne -2325 -> 4
    //   2332: aload 8
    //   2334: astore_2
    //   2335: aload_0
    //   2336: getfield 33	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Boolean	Z
    //   2339: ifne -2335 -> 4
    //   2342: aload_0
    //   2343: getfield 61	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider	Lcom/tencent/mobileqq/activity/aio/photo/IAIOImageProvider;
    //   2346: aload_0
    //   2347: getfield 87	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Int	I
    //   2350: invokeinterface 642 2 0
    //   2355: aload_0
    //   2356: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2359: iconst_1
    //   2360: putfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   2363: aload 8
    //   2365: areturn
    //   2366: aload_2
    //   2367: iconst_0
    //   2368: invokevirtual 354	com/tencent/mobileqq/activity/aio/photo/AIOShortVideoData:a	(I)Ljava/io/File;
    //   2371: ifnull +62 -> 2433
    //   2374: aload_0
    //   2375: getfield 42	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:d	I
    //   2378: iload_1
    //   2379: if_icmpne +54 -> 2433
    //   2382: aload_0
    //   2383: getfield 400	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_b_of_type_ComTencentImageURLDrawable	Lcom/tencent/image/URLDrawable;
    //   2386: ifnull +47 -> 2433
    //   2389: aload 8
    //   2391: aload_0
    //   2392: getfield 400	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_b_of_type_ComTencentImageURLDrawable	Lcom/tencent/image/URLDrawable;
    //   2395: invokevirtual 395	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2398: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2401: ifeq -82 -> 2319
    //   2404: ldc 143
    //   2406: iconst_2
    //   2407: new 145	java/lang/StringBuilder
    //   2410: dup
    //   2411: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   2414: ldc_w 1003
    //   2417: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2420: iload_1
    //   2421: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2424: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2427: invokestatic 292	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2430: goto -111 -> 2319
    //   2433: aload_2
    //   2434: iconst_1
    //   2435: invokevirtual 354	com/tencent/mobileqq/activity/aio/photo/AIOShortVideoData:a	(I)Ljava/io/File;
    //   2438: astore_3
    //   2439: aload_3
    //   2440: ifnull +47 -> 2487
    //   2443: aload_0
    //   2444: iload_1
    //   2445: aload 8
    //   2447: aload_2
    //   2448: aload_3
    //   2449: invokespecial 770	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(ILcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;Lcom/tencent/mobileqq/activity/aio/photo/AIOShortVideoData;Ljava/io/File;)V
    //   2452: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2455: ifeq -136 -> 2319
    //   2458: ldc 143
    //   2460: iconst_2
    //   2461: new 145	java/lang/StringBuilder
    //   2464: dup
    //   2465: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   2468: ldc_w 1005
    //   2471: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2474: iload_1
    //   2475: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2478: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2481: invokestatic 292	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2484: goto -165 -> 2319
    //   2487: aload_2
    //   2488: getfield 1006	com/tencent/mobileqq/activity/aio/photo/AIOShortVideoData:jdField_a_of_type_Boolean	Z
    //   2491: ifne +10 -> 2501
    //   2494: aload_2
    //   2495: getfield 499	com/tencent/mobileqq/activity/aio/photo/AIOShortVideoData:jdField_b_of_type_Boolean	Z
    //   2498: ifeq +44 -> 2542
    //   2501: aload 8
    //   2503: invokestatic 617	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2506: invokevirtual 618	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   2509: ldc_w 619
    //   2512: invokevirtual 622	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   2515: invokevirtual 395	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2518: aload_0
    //   2519: iload_1
    //   2520: iconst_0
    //   2521: invokevirtual 398	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(IZ)V
    //   2524: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2527: ifeq -208 -> 2319
    //   2530: ldc 143
    //   2532: iconst_2
    //   2533: ldc_w 1008
    //   2536: invokestatic 292	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2539: goto -220 -> 2319
    //   2542: aload_0
    //   2543: iload_1
    //   2544: aload 9
    //   2546: getfield 956	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_Int	I
    //   2549: bipush 100
    //   2551: idiv
    //   2552: invokevirtual 799	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(II)V
    //   2555: aload 8
    //   2557: getstatic 424	com/tencent/mobileqq/transfile/URLDrawableHelper:a	Landroid/graphics/drawable/Drawable;
    //   2560: invokevirtual 395	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2563: aload_0
    //   2564: getfield 61	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider	Lcom/tencent/mobileqq/activity/aio/photo/IAIOImageProvider;
    //   2567: aload_2
    //   2568: getfield 502	com/tencent/mobileqq/activity/aio/photo/AIOShortVideoData:jdField_g_of_type_Long	J
    //   2571: aload_2
    //   2572: getfield 503	com/tencent/mobileqq/activity/aio/photo/AIOShortVideoData:jdField_f_of_type_Int	I
    //   2575: iconst_1
    //   2576: invokeinterface 489 5 0
    //   2581: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2584: ifeq -265 -> 2319
    //   2587: ldc 143
    //   2589: iconst_2
    //   2590: new 145	java/lang/StringBuilder
    //   2593: dup
    //   2594: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   2597: ldc_w 1010
    //   2600: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2603: iload_1
    //   2604: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2607: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2610: invokestatic 292	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2613: goto -294 -> 2319
    //   2616: aload 8
    //   2618: astore_2
    //   2619: ldc_w 510
    //   2622: aload 9
    //   2624: getfield 419	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   2627: invokevirtual 198	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   2630: ifeq -2626 -> 4
    //   2633: aload 9
    //   2635: getfield 419	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   2638: checkcast 510	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData
    //   2641: astore 10
    //   2643: aload 8
    //   2645: iload_1
    //   2646: invokevirtual 854	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setPosition	(I)V
    //   2649: aload 8
    //   2651: aload 9
    //   2653: invokevirtual 858	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageInfo	(Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo;)V
    //   2656: aload 8
    //   2658: iconst_0
    //   2659: invokevirtual 829	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setIgnoreLayout	(Z)V
    //   2662: aload_0
    //   2663: getfield 38	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   2666: iload_1
    //   2667: invokevirtual 406	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   2670: checkcast 124	com/tencent/image/URLDrawable
    //   2673: astore_3
    //   2674: aload_3
    //   2675: ifnull +212 -> 2887
    //   2678: aload_3
    //   2679: invokevirtual 132	com/tencent/image/URLDrawable:getStatus	()I
    //   2682: iconst_1
    //   2683: if_icmpne +204 -> 2887
    //   2686: aload 8
    //   2688: aload_3
    //   2689: invokevirtual 395	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2692: aload 10
    //   2694: bipush 20
    //   2696: invokevirtual 698	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/lang/String;
    //   2699: astore_2
    //   2700: aload_3
    //   2701: invokevirtual 608	com/tencent/image/URLDrawable:getURL	()Ljava/net/URL;
    //   2704: invokevirtual 368	java/net/URL:toString	()Ljava/lang/String;
    //   2707: astore 7
    //   2709: aload_0
    //   2710: iload_1
    //   2711: iconst_1
    //   2712: invokevirtual 398	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(IZ)V
    //   2715: aload 7
    //   2717: aload_2
    //   2718: invokevirtual 614	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2721: ifeq +9 -> 2730
    //   2724: aload 8
    //   2726: iconst_1
    //   2727: invokevirtual 866	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setOriginalImage	(Z)V
    //   2730: aload 9
    //   2732: getfield 867	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_b_of_type_Int	I
    //   2735: bipush 254
    //   2737: if_icmpne +18 -> 2755
    //   2740: aload 9
    //   2742: aload_3
    //   2743: invokevirtual 608	com/tencent/image/URLDrawable:getURL	()Ljava/net/URL;
    //   2746: invokevirtual 870	java/net/URL:getFile	()Ljava/lang/String;
    //   2749: invokestatic 876	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   2752: putfield 867	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_b_of_type_Int	I
    //   2755: aload 8
    //   2757: aload_3
    //   2758: aload 9
    //   2760: getfield 867	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_b_of_type_Int	I
    //   2763: invokestatic 879	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(Landroid/view/View;Lcom/tencent/image/URLDrawable;I)V
    //   2766: aload 8
    //   2768: invokevirtual 881	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:a	()Z
    //   2771: ifeq +107 -> 2878
    //   2774: aload 10
    //   2776: getfield 1012	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2779: astore_2
    //   2780: aload_2
    //   2781: invokestatic 648	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2784: astore 9
    //   2786: ldc_w 650
    //   2789: aload 9
    //   2791: invokevirtual 614	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2794: ifeq +13 -> 2807
    //   2797: aload 8
    //   2799: bipush 102
    //   2801: invokestatic 453	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2804: invokevirtual 651	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setTag	(Ljava/lang/Object;)V
    //   2807: aload 8
    //   2809: astore_2
    //   2810: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2813: ifeq -2809 -> 4
    //   2816: ldc 143
    //   2818: iconst_2
    //   2819: new 145	java/lang/StringBuilder
    //   2822: dup
    //   2823: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   2826: ldc_w 884
    //   2829: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2832: aload 7
    //   2834: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2837: ldc_w 886
    //   2840: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2843: aload 10
    //   2845: aload_3
    //   2846: invokevirtual 608	com/tencent/image/URLDrawable:getURL	()Ljava/net/URL;
    //   2849: invokevirtual 870	java/net/URL:getFile	()Ljava/lang/String;
    //   2852: invokevirtual 1013	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(Ljava/lang/String;)I
    //   2855: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2858: ldc_w 890
    //   2861: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2864: aload 9
    //   2866: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2869: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2872: invokestatic 292	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2875: aload 8
    //   2877: areturn
    //   2878: aload 10
    //   2880: getfield 700	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2883: astore_2
    //   2884: goto -104 -> 2780
    //   2887: aload 10
    //   2889: bipush 20
    //   2891: invokevirtual 511	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   2894: astore_3
    //   2895: aload_3
    //   2896: ifnonnull +892 -> 3788
    //   2899: aload 10
    //   2901: bipush 18
    //   2903: invokevirtual 511	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   2906: astore_2
    //   2907: aload_2
    //   2908: ifnull +450 -> 3358
    //   2911: aload_3
    //   2912: ifnull +338 -> 3250
    //   2915: iconst_1
    //   2916: istore 4
    //   2918: invokestatic 360	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   2921: astore 11
    //   2923: aload 11
    //   2925: aload_0
    //   2926: getfield 80	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_e_of_type_Int	I
    //   2929: putfield 927	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   2932: aload 11
    //   2934: aload_0
    //   2935: getfield 85	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_f_of_type_Int	I
    //   2938: putfield 930	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   2941: aload 11
    //   2943: getstatic 424	com/tencent/mobileqq/transfile/URLDrawableHelper:a	Landroid/graphics/drawable/Drawable;
    //   2946: putfield 377	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   2949: aload 11
    //   2951: iconst_1
    //   2952: putfield 430	com/tencent/image/URLDrawable$URLDrawableOptions:mPlayGifImage	Z
    //   2955: aload 11
    //   2957: iconst_0
    //   2958: putfield 433	com/tencent/image/URLDrawable$URLDrawableOptions:mUseExifOrientation	Z
    //   2961: iload 4
    //   2963: iconst_1
    //   2964: if_icmpne +49 -> 3013
    //   2967: aload 8
    //   2969: iconst_1
    //   2970: invokevirtual 866	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setOriginalImage	(Z)V
    //   2973: aload 10
    //   2975: bipush 18
    //   2977: invokevirtual 511	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   2980: astore 7
    //   2982: aload 7
    //   2984: astore_3
    //   2985: aload 7
    //   2987: ifnonnull +11 -> 2998
    //   2990: aload 10
    //   2992: bipush 16
    //   2994: invokevirtual 511	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   2997: astore_3
    //   2998: aload_3
    //   2999: ifnull +14 -> 3013
    //   3002: aload 8
    //   3004: aload_3
    //   3005: aload 11
    //   3007: invokestatic 463	com/tencent/image/URLDrawable:getDrawable	(Ljava/io/File;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   3010: invokevirtual 395	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   3013: aload_0
    //   3014: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   3017: getfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   3020: ifeq +27 -> 3047
    //   3023: aload_0
    //   3024: getfield 932	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   3027: ifnull +20 -> 3047
    //   3030: aload 11
    //   3032: aload_0
    //   3033: getfield 932	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   3036: invokevirtual 536	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:a	()Landroid/graphics/drawable/Drawable;
    //   3039: putfield 377	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   3042: aload_0
    //   3043: aconst_null
    //   3044: putfield 932	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   3047: invokestatic 360	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   3050: astore_3
    //   3051: aload_3
    //   3052: aload_0
    //   3053: getfield 80	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_e_of_type_Int	I
    //   3056: putfield 927	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   3059: aload_3
    //   3060: aload_0
    //   3061: getfield 85	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_f_of_type_Int	I
    //   3064: putfield 930	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   3067: aload_3
    //   3068: getstatic 424	com/tencent/mobileqq/transfile/URLDrawableHelper:a	Landroid/graphics/drawable/Drawable;
    //   3071: putfield 377	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   3074: aload_3
    //   3075: iconst_1
    //   3076: putfield 430	com/tencent/image/URLDrawable$URLDrawableOptions:mPlayGifImage	Z
    //   3079: aload_3
    //   3080: iconst_0
    //   3081: putfield 433	com/tencent/image/URLDrawable$URLDrawableOptions:mUseExifOrientation	Z
    //   3084: aload_2
    //   3085: aload_3
    //   3086: invokestatic 463	com/tencent/image/URLDrawable:getDrawable	(Ljava/io/File;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   3089: astore_3
    //   3090: aload_3
    //   3091: iconst_1
    //   3092: invokestatic 453	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3095: invokevirtual 457	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   3098: aload_0
    //   3099: getfield 38	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   3102: iload_1
    //   3103: aload_3
    //   3104: invokevirtual 460	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   3107: aload_0
    //   3108: iload_1
    //   3109: iconst_m1
    //   3110: invokevirtual 799	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(II)V
    //   3113: aload_3
    //   3114: invokevirtual 132	com/tencent/image/URLDrawable:getStatus	()I
    //   3117: tableswitch	default:+27 -> 3144, 1:+139->3256, 2:+205->3322, 3:+205->3322
    //   3145: iconst_5
    //   3146: aload_3
    //   3147: invokevirtual 395	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   3150: aload 8
    //   3152: iload 4
    //   3154: invokevirtual 866	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setOriginalImage	(Z)V
    //   3157: aload 9
    //   3159: getfield 419	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   3162: checkcast 510	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData
    //   3165: iconst_1
    //   3166: putfield 1014	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_f_of_type_Boolean	Z
    //   3169: iload 4
    //   3171: ifeq +178 -> 3349
    //   3174: aload 10
    //   3176: getfield 1012	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3179: astore_2
    //   3180: ldc_w 650
    //   3183: aload_2
    //   3184: invokestatic 648	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   3187: invokevirtual 614	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3190: ifeq +13 -> 3203
    //   3193: aload 8
    //   3195: bipush 102
    //   3197: invokestatic 453	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3200: invokevirtual 651	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setTag	(Ljava/lang/Object;)V
    //   3203: aload 8
    //   3205: astore_2
    //   3206: aload_0
    //   3207: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   3210: getfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   3213: ifne -3209 -> 4
    //   3216: aload 8
    //   3218: astore_2
    //   3219: aload_0
    //   3220: getfield 33	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Boolean	Z
    //   3223: ifne -3219 -> 4
    //   3226: aload_0
    //   3227: getfield 61	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider	Lcom/tencent/mobileqq/activity/aio/photo/IAIOImageProvider;
    //   3230: aload_0
    //   3231: getfield 87	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Int	I
    //   3234: invokeinterface 642 2 0
    //   3239: aload_0
    //   3240: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   3243: iconst_1
    //   3244: putfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   3247: aload 8
    //   3249: areturn
    //   3250: iconst_0
    //   3251: istore 4
    //   3253: goto -335 -> 2918
    //   3256: aload 9
    //   3258: getfield 867	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_b_of_type_Int	I
    //   3261: bipush 254
    //   3263: if_icmpne +15 -> 3278
    //   3266: aload 9
    //   3268: aload_2
    //   3269: invokevirtual 325	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   3272: invokestatic 876	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   3275: putfield 867	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_b_of_type_Int	I
    //   3278: aload 8
    //   3280: aload_3
    //   3281: invokevirtual 395	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   3284: aload 8
    //   3286: aload_3
    //   3287: aload 9
    //   3289: getfield 867	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_b_of_type_Int	I
    //   3292: invokestatic 879	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(Landroid/view/View;Lcom/tencent/image/URLDrawable;I)V
    //   3295: aload_3
    //   3296: invokevirtual 132	com/tencent/image/URLDrawable:getStatus	()I
    //   3299: iconst_1
    //   3300: if_icmpne +16 -> 3316
    //   3303: iconst_1
    //   3304: istore 5
    //   3306: aload_0
    //   3307: iload_1
    //   3308: iload 5
    //   3310: invokevirtual 398	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(IZ)V
    //   3313: goto -144 -> 3169
    //   3316: iconst_0
    //   3317: istore 5
    //   3319: goto -13 -> 3306
    //   3322: aload_3
    //   3323: invokevirtual 132	com/tencent/image/URLDrawable:getStatus	()I
    //   3326: iconst_1
    //   3327: if_icmpne +16 -> 3343
    //   3330: iconst_1
    //   3331: istore 5
    //   3333: aload_0
    //   3334: iload_1
    //   3335: iload 5
    //   3337: invokevirtual 398	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(IZ)V
    //   3340: goto -171 -> 3169
    //   3343: iconst_0
    //   3344: istore 5
    //   3346: goto -13 -> 3333
    //   3349: aload 10
    //   3351: getfield 700	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3354: astore_2
    //   3355: goto -175 -> 3180
    //   3358: aload 10
    //   3360: bipush 16
    //   3362: invokevirtual 511	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   3365: astore_2
    //   3366: aload_2
    //   3367: ifnull +244 -> 3611
    //   3370: invokestatic 360	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   3373: astore_3
    //   3374: aload_3
    //   3375: getstatic 424	com/tencent/mobileqq/transfile/URLDrawableHelper:a	Landroid/graphics/drawable/Drawable;
    //   3378: putfield 377	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   3381: aload_3
    //   3382: getstatic 424	com/tencent/mobileqq/transfile/URLDrawableHelper:a	Landroid/graphics/drawable/Drawable;
    //   3385: putfield 427	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   3388: aload_2
    //   3389: aload_3
    //   3390: invokestatic 463	com/tencent/image/URLDrawable:getDrawable	(Ljava/io/File;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   3393: astore_2
    //   3394: aload 8
    //   3396: aload_2
    //   3397: invokevirtual 395	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   3400: aload 10
    //   3402: getfield 1015	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_d_of_type_Boolean	Z
    //   3405: ifne +165 -> 3570
    //   3408: aload 10
    //   3410: getfield 512	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_a_of_type_Long	J
    //   3413: invokestatic 516	com/tencent/mobileqq/filemanager/data/FMConfig:c	()J
    //   3416: lcmp
    //   3417: ifgt +112 -> 3529
    //   3420: aload_2
    //   3421: invokevirtual 696	com/tencent/image/URLDrawable:downloadImediatly	()V
    //   3424: aload_0
    //   3425: iload_1
    //   3426: aload 9
    //   3428: getfield 956	com/tencent/mobileqq/activity/aio/photo/AIORichMediaInfo:jdField_a_of_type_Int	I
    //   3431: bipush 100
    //   3433: idiv
    //   3434: invokevirtual 799	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(II)V
    //   3437: aload_0
    //   3438: getfield 61	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider	Lcom/tencent/mobileqq/activity/aio/photo/IAIOImageProvider;
    //   3441: aload 10
    //   3443: getfield 517	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_g_of_type_Long	J
    //   3446: aload 10
    //   3448: getfield 518	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_f_of_type_Int	I
    //   3451: bipush 18
    //   3453: invokeinterface 489 5 0
    //   3458: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3461: ifeq +46 -> 3507
    //   3464: ldc 143
    //   3466: iconst_2
    //   3467: new 145	java/lang/StringBuilder
    //   3470: dup
    //   3471: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   3474: ldc_w 946
    //   3477: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3480: aload 10
    //   3482: bipush 16
    //   3484: invokevirtual 698	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/lang/String;
    //   3487: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3490: ldc_w 948
    //   3493: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3496: bipush 16
    //   3498: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3501: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3504: invokestatic 292	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3507: aload 8
    //   3509: astore_2
    //   3510: aload_0
    //   3511: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   3514: getfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   3517: ifne -3513 -> 4
    //   3520: aload_0
    //   3521: aload 8
    //   3523: putfield 932	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   3526: aload 8
    //   3528: areturn
    //   3529: aload_0
    //   3530: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   3533: getfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   3536: ifne -78 -> 3458
    //   3539: aload_0
    //   3540: getfield 33	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Boolean	Z
    //   3543: ifne -85 -> 3458
    //   3546: aload_0
    //   3547: getfield 61	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider	Lcom/tencent/mobileqq/activity/aio/photo/IAIOImageProvider;
    //   3550: aload_0
    //   3551: getfield 87	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Int	I
    //   3554: invokeinterface 642 2 0
    //   3559: aload_0
    //   3560: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   3563: iconst_1
    //   3564: putfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   3567: goto -109 -> 3458
    //   3570: aload_0
    //   3571: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   3574: getfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   3577: ifne -119 -> 3458
    //   3580: aload_0
    //   3581: getfield 33	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Boolean	Z
    //   3584: ifne -126 -> 3458
    //   3587: aload_0
    //   3588: getfield 61	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider	Lcom/tencent/mobileqq/activity/aio/photo/IAIOImageProvider;
    //   3591: aload_0
    //   3592: getfield 87	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Int	I
    //   3595: invokeinterface 642 2 0
    //   3600: aload_0
    //   3601: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   3604: iconst_1
    //   3605: putfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   3608: goto -150 -> 3458
    //   3611: aload 10
    //   3613: getfield 512	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_a_of_type_Long	J
    //   3616: invokestatic 516	com/tencent/mobileqq/filemanager/data/FMConfig:c	()J
    //   3619: lcmp
    //   3620: ifgt +91 -> 3711
    //   3623: aload 10
    //   3625: getfield 684	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_a_of_type_Boolean	Z
    //   3628: ifeq +51 -> 3679
    //   3631: aload 8
    //   3633: invokestatic 617	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3636: invokevirtual 618	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   3639: ldc_w 619
    //   3642: invokevirtual 622	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   3645: invokevirtual 395	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   3648: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3651: ifeq +12 -> 3663
    //   3654: ldc 143
    //   3656: iconst_2
    //   3657: ldc_w 982
    //   3660: invokestatic 292	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3663: aload 8
    //   3665: astore_2
    //   3666: aload_0
    //   3667: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   3670: getfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   3673: ifne -3669 -> 4
    //   3676: aload 8
    //   3678: areturn
    //   3679: aload 8
    //   3681: getstatic 424	com/tencent/mobileqq/transfile/URLDrawableHelper:a	Landroid/graphics/drawable/Drawable;
    //   3684: invokevirtual 395	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   3687: aload_0
    //   3688: getfield 61	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider	Lcom/tencent/mobileqq/activity/aio/photo/IAIOImageProvider;
    //   3691: aload 10
    //   3693: getfield 517	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_g_of_type_Long	J
    //   3696: aload 10
    //   3698: getfield 518	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_f_of_type_Int	I
    //   3701: bipush 18
    //   3703: invokeinterface 489 5 0
    //   3708: goto -60 -> 3648
    //   3711: aload_0
    //   3712: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   3715: getfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   3718: ifne +31 -> 3749
    //   3721: aload_0
    //   3722: getfield 33	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Boolean	Z
    //   3725: ifne +24 -> 3749
    //   3728: aload_0
    //   3729: getfield 61	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider	Lcom/tencent/mobileqq/activity/aio/photo/IAIOImageProvider;
    //   3732: aload_0
    //   3733: getfield 87	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Int	I
    //   3736: invokeinterface 642 2 0
    //   3741: aload_0
    //   3742: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   3745: iconst_1
    //   3746: putfield 640	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   3749: aload 8
    //   3751: invokestatic 617	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3754: invokevirtual 618	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   3757: ldc_w 619
    //   3760: invokevirtual 622	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   3763: invokevirtual 395	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   3766: aload 8
    //   3768: invokevirtual 697	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:a	()V
    //   3771: aload 8
    //   3773: ldc_w 991
    //   3776: ldc_w 992
    //   3779: invokestatic 997	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   3782: invokevirtual 999	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setTag	(ILjava/lang/Object;)V
    //   3785: aload 8
    //   3787: areturn
    //   3788: aload_3
    //   3789: astore_2
    //   3790: goto -879 -> 2911
    //   3793: aload 7
    //   3795: astore_3
    //   3796: goto -3187 -> 609
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3799	0	this	AIOGalleryAdapter
    //   0	3799	1	paramInt	int
    //   0	3799	2	paramView	View
    //   0	3799	3	paramViewGroup	ViewGroup
    //   127	3125	4	bool1	boolean
    //   615	2730	5	bool2	boolean
    //   1205	40	6	bool3	boolean
    //   175	3619	7	localObject1	Object
    //   50	3736	8	localGalleryImageStruct	AIOGalleryAdapter.GalleryImageStruct
    //   63	3364	9	localObject2	Object
    //   95	3602	10	localObject3	Object
    //   2921	110	11	localURLDrawableOptions	URLDrawable.URLDrawableOptions
    // Exception table:
    //   from	to	target	type
    //   202	217	543	java/lang/Exception
    //   725	771	1126	java/lang/Throwable
    //   1115	1123	1126	java/lang/Throwable
    //   1171	1183	1217	java/lang/Exception
    //   884	889	1249	java/lang/Exception
  }
  
  public void onStateChange(String paramString, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryAdapter", 2, "onStateChange => " + QQLiveImage.getStateStr(paramInt) + ", msgUniseq=" + paramQQLiveDrawableParams.msgUniseq + ", extra = " + paramObject);
    }
    if (paramInt == 6) {
      new Handler(Looper.getMainLooper()).post(new vmg(this));
    }
    while (paramInt != 2) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new vmh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */