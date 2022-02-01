package com.tencent.mobileqq.activity.aio.photo;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.image.JpegExifReader;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.QQLiveDrawable.OnDownloadListener;
import com.tencent.image.QQLiveDrawable.OnLoopBackListener;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.QQLiveImage;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.photo.ProGallery.OnProGalleryListener;
import com.tencent.mobileqq.activity.photo.VideoPlayController;
import com.tencent.mobileqq.activity.photo.VideoPlayMedioInfo;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreview;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreviewProgressive;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery.LayoutParams;
import cooperation.peak.PeakUtils;
import dov.com.qq.im.capture.CaptureContext;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONObject;

public class AIOGalleryAdapter
  extends AbstractImageAdapter
  implements QQLiveDrawable.OnDownloadListener, QQLiveDrawable.OnLoopBackListener, QQLiveDrawable.OnStateListener, ProGallery.OnProGalleryListener
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = -1L;
  private SparseArray<URLDrawable> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  AIOGalleryActivity jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity;
  private AIOGalleryAdapter.GalleryImageStruct jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct;
  public AIOGalleryAdapter.OnAdapterNotify a;
  private AIOGalleryAdapter.OnTroopThumbListener jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$OnTroopThumbListener;
  AIOImageListModel jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
  AIORichMediaData jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
  IAIOImageProvider jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
  VideoPlayController jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController;
  String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = -1L;
  private SparseArray<URLDrawable> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private URLDrawable jdField_b_of_type_ComTencentImageURLDrawable;
  private AIOGalleryAdapter.GalleryImageStruct jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct;
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -1;
  long jdField_c_of_type_Long = -1L;
  private int jdField_d_of_type_Int = -1;
  private long jdField_d_of_type_Long = -1L;
  private int e;
  private int f;
  private int g;
  
  public AIOGalleryAdapter(Context paramContext, IAIOImageProvider paramIAIOImageProvider, boolean paramBoolean, int paramInt)
  {
    this.jdField_g_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity = ((AIOGalleryActivity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = paramIAIOImageProvider;
    this.e = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_f_of_type_Int = paramContext.getResources().getDisplayMetrics().heightPixels;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent();
    if (paramContext != null)
    {
      this.jdField_b_of_type_Int = paramContext.getIntExtra("forward_source_uin_type", -1);
      this.jdField_a_of_type_JavaLangString = paramContext.getStringExtra("uin");
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
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e(" AIOGalleryAdapter", 2, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString, localException);
        }
      }
    }
    return localEmptyDrawable;
  }
  
  private View a(int paramInt, AIORichMediaInfo paramAIORichMediaInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean = true;
    AIOShortVideoData localAIOShortVideoData = (AIOShortVideoData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if (localAIOShortVideoData.jdField_b_of_type_Int != 0)
    {
      localObject = new AIOGalleryAdapter.GalleryImageStruct(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity, 1);
      ((AIOGalleryAdapter.GalleryImageStruct)localObject).setAdjustViewBounds(true);
      localURLDrawable = (URLDrawable)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
      ((AIOGalleryAdapter.GalleryImageStruct)localObject).setPosition(paramInt);
      ((AIOGalleryAdapter.GalleryImageStruct)localObject).setImageInfo(paramAIORichMediaInfo);
      ((AIOGalleryAdapter.GalleryImageStruct)localObject).a();
      if (localURLDrawable != null)
      {
        ((AIOGalleryAdapter.GalleryImageStruct)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.setImageDrawable(localURLDrawable);
        if (QLog.isColorLevel()) {
          QLog.i(" AIOGalleryAdapter", 2, "getView():load thumb hit cache , position is " + paramInt);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean) {
          break label400;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_b_of_type_Int != 1) {
          break label340;
        }
        paramAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity;
        paramAIORichMediaInfo.jdField_b_of_type_Int -= 1;
        if (this.jdField_b_of_type_Boolean)
        {
          ((AIOGalleryAdapter.GalleryImageStruct)localObject).b(paramInt);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean = false;
        }
      }
      label400:
      for (;;)
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
        }
        return localObject;
        if (localAIOShortVideoData.a(0) != null)
        {
          a(localAIOShortVideoData.jdField_a_of_type_JavaLangString, localAIOShortVideoData.jdField_c_of_type_Int, localAIOShortVideoData.jdField_d_of_type_Int, ((AIOGalleryAdapter.GalleryImageStruct)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView, paramInt);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i(" AIOGalleryAdapter", 2, "getView(): load thumb and videoDrawable exist, position is " + paramInt);
          break;
        }
        ((AIOGalleryAdapter.GalleryImageStruct)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOShortVideoData.jdField_f_of_type_Long, localAIOShortVideoData.jdField_f_of_type_Int, 0);
        QLog.i(" AIOGalleryAdapter", 2, "getView(): load thumb download THUMB, position is " + paramInt);
        break;
        label340:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_b_of_type_Int == 0)
        {
          ((AIOGalleryAdapter.GalleryImageStruct)localObject).b(paramInt);
          ReportController.b(null, "dc00898", "", "", "0X8009EF1", "0X8009EF1", 1, 0, "", "", "", "");
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean = false;
          continue;
          ReportController.b(null, "dc00898", "", "", "0X8009EF1", "0X8009EF1", 2, 0, "", "", "", "");
        }
      }
    }
    paramAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getLayoutInflater().inflate(2131561447, null);
    paramAIORichMediaInfo.setTag(2131296400, Boolean.valueOf(true));
    paramAIORichMediaInfo.setTag(2131296433, Boolean.valueOf(true));
    paramAIORichMediaInfo.setLayoutParams(new Gallery.LayoutParams(-1, -1));
    Object localObject = (URLImageView)paramAIORichMediaInfo.findViewById(2131373468);
    URLDrawable localURLDrawable = (URLDrawable)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localURLDrawable != null)
    {
      ((URLImageView)localObject).setImageDrawable(localURLDrawable);
      if (localAIOShortVideoData.jdField_f_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean = false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long != localAIOShortVideoData.jdField_f_of_type_Long) {
        break label703;
      }
      if (a(localAIOShortVideoData, paramAIORichMediaInfo))
      {
        ((ImageView)paramAIORichMediaInfo.findViewById(2131373467)).setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController.f();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean = false;
      ReportController.b(null, "dc00898", "", "", "0X8009EF2", "0X8009EF2", 1, 0, "", "", "", "");
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
      }
      return paramAIORichMediaInfo;
      if (localAIOShortVideoData.a(0) == null) {
        break;
      }
      a(localAIOShortVideoData.jdField_a_of_type_JavaLangString, localAIOShortVideoData.jdField_c_of_type_Int, localAIOShortVideoData.jdField_d_of_type_Int, (ImageView)localObject, paramInt);
      break;
      label703:
      ReportController.b(null, "dc00898", "", "", "0X8009EF2", "0X8009EF2", 2, 0, "", "", "", "");
    }
  }
  
  private View a(AIORichMediaInfo paramAIORichMediaInfo, int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct)
  {
    AIOFileVideoData localAIOFileVideoData;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean = false;
      ReportController.b(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 1, 0, "", "", "", "");
      localAIOFileVideoData = (AIOFileVideoData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      paramGalleryImageStruct.setPosition(paramInt);
      paramGalleryImageStruct.setImageInfo(paramAIORichMediaInfo);
      paramGalleryImageStruct.setIgnoreLayout(false);
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
      }
      paramGalleryImageStruct = (Drawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      if (!localAIOFileVideoData.b()) {
        break label259;
      }
    }
    label259:
    label580:
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getLayoutInflater().inflate(2131561447, null);
      ((View)localObject).setTag(2131296400, Boolean.valueOf(true));
      ((View)localObject).setTag(2131296433, Boolean.valueOf(true));
      ((View)localObject).setLayoutParams(new Gallery.LayoutParams(-1, -1));
      URLImageView localURLImageView = (URLImageView)((View)localObject).findViewById(2131373468);
      localURLImageView.setImageDrawable(paramGalleryImageStruct);
      if (localAIOFileVideoData.b())
      {
        localURLImageView.setImageDrawable(null);
        return localObject;
        ReportController.b(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 2, 0, "", "", "", "");
        break;
        if ((paramGalleryImageStruct != null) && (((URLDrawable)paramGalleryImageStruct).getStatus() == 1))
        {
          a(paramInt, true);
          continue;
        }
        if (!TextUtils.isEmpty(localAIOFileVideoData.jdField_b_of_type_JavaLangString))
        {
          localObject = new File(localAIOFileVideoData.jdField_b_of_type_JavaLangString);
          if (!((File)localObject).exists()) {
            break label580;
          }
          paramGalleryImageStruct = URLDrawable.URLDrawableOptions.obtain();
          paramGalleryImageStruct.mRequestWidth = this.e;
          paramGalleryImageStruct.mRequestHeight = this.jdField_f_of_type_Int;
          paramGalleryImageStruct.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
          paramGalleryImageStruct.mPlayGifImage = true;
          paramGalleryImageStruct.mUseExifOrientation = false;
          paramGalleryImageStruct = URLDrawable.getDrawable((File)localObject, paramGalleryImageStruct);
          ((URLDrawable)paramGalleryImageStruct).setTag(Integer.valueOf(1));
          this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, (URLDrawable)paramGalleryImageStruct);
          continue;
        }
        paramGalleryImageStruct = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838183);
        continue;
      }
      if ((paramAIORichMediaInfo.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean)) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_b_of_type_Int == 1)
        {
          paramAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity;
          paramAIORichMediaInfo.jdField_b_of_type_Int -= 1;
          this.jdField_d_of_type_Long = -1L;
          if (QLog.isColorLevel()) {
            QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP set hasDoneItemSelectUid = -1");
          }
        }
      }
      for (;;)
      {
        return localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_b_of_type_Int == 0)
        {
          this.jdField_d_of_type_Long = localAIOFileVideoData.jdField_f_of_type_Long;
          localAIOFileVideoData.e = true;
          if (QLog.isColorLevel())
          {
            QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP set hasDoneItemSelectUid = " + this.jdField_d_of_type_Long);
            continue;
            this.jdField_d_of_type_Long = localAIOFileVideoData.jdField_f_of_type_Long;
            if (QLog.isColorLevel()) {
              QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP is not EnterImage && isAutoPlayed, set hasDoneItemSelectUid = " + this.jdField_d_of_type_Long);
            }
          }
        }
      }
    }
  }
  
  private URLDrawable a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIORichMediaInfo paramAIORichMediaInfo, AIOImageData paramAIOImageData, boolean paramBoolean, int paramInt, File paramFile)
  {
    Object localObject1 = null;
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.e;
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_f_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject2).mUseExifOrientation = false;
    ((URLDrawable.URLDrawableOptions)localObject2).mDecodeFileStrategy = 2;
    if ((paramAIOImageData.jdField_b_of_type_Int == 1) && ((paramAIOImageData.jdField_d_of_type_Int & 0x2) == 2)) {
      ((URLDrawable.URLDrawableOptions)localObject2).mUseAutoScaleParams = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct != null)
      {
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.a();
        paramGalleryImageStruct.setTag(2131296389, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.getTag(2131296389));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = null;
      }
    }
    else {
      if (paramBoolean) {
        break label406;
      }
    }
    label406:
    label443:
    label451:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            if (!paramAIOImageData.jdField_d_of_type_Boolean) {
              continue;
            }
            localObject2 = URLDrawable.getDrawable(paramAIOImageData.a(2) + "#" + "PART", (URLDrawable.URLDrawableOptions)localObject2);
            localObject1 = localObject2;
            localObject1.setTag(Integer.valueOf(1));
            this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
            a(localObject1, paramGalleryImageStruct, paramAIORichMediaInfo, paramInt, paramFile, paramBoolean);
            if (!paramBoolean) {
              break label443;
            }
            paramAIORichMediaInfo = paramAIOImageData.jdField_c_of_type_JavaLangString;
            paramAIORichMediaInfo = FileUtils.b(paramAIORichMediaInfo);
            if (QLog.isColorLevel()) {
              QLog.i(" AIOGalleryAdapter", 2, "getview url is " + localObject1.getURL().toString() + ", file type is " + paramAIOImageData.a(localObject1.getURL().toString()) + ",extName = " + paramAIORichMediaInfo);
            }
            if ((paramBoolean) || (!paramAIOImageData.jdField_d_of_type_Boolean) || (paramAIOImageData.jdField_b_of_type_Boolean)) {
              break label451;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOImageData.jdField_f_of_type_Long, paramAIOImageData.jdField_f_of_type_Int, 2);
            paramAIORichMediaInfo = localObject1;
            if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = paramGalleryImageStruct;
              paramAIORichMediaInfo = localObject1;
            }
          }
          catch (Throwable paramGalleryImageStruct)
          {
            paramAIORichMediaInfo = localObject1;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e(" AIOGalleryAdapter", 2, "[getView] URLDrawable.getDrawable failed.");
            return null;
          }
          return paramAIORichMediaInfo;
          if ((paramAIOImageData.a(1) == null) || (GlobalImageCache.a.get(paramAIOImageData.a(1)) == null) || (paramAIOImageData.a(1) == null)) {
            break;
          }
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawable.getDrawable(paramAIOImageData.a(1), null);
          break;
          localObject2 = URLDrawable.getDrawable(paramFile, (URLDrawable.URLDrawableOptions)localObject2);
          localObject1 = localObject2;
          continue;
          paramAIORichMediaInfo = paramAIOImageData.jdField_b_of_type_JavaLangString;
        }
        paramAIORichMediaInfo = localObject1;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean);
      paramAIORichMediaInfo = localObject1;
    } while (this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
    return localObject1;
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
            new DCShortVideo(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplication().getBaseContext()).a(CaptureContext.a(), 2001, 0, i, str, this.jdField_a_of_type_Long / 1000L);
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
            paramURLDrawable.put("mobile_type", Build.MODEL);
            paramURLDrawable.put("wifi_ssid", NetworkUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplicationContext()));
            paramURLDrawable.put("wifi_mac", NetworkUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplicationContext()));
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
            QLog.w(" AIOGalleryAdapter", 2, "reportTroopVideo exception:" + QLog.getStackTraceString(paramURLDrawable));
            continue;
          }
          this.jdField_b_of_type_Long = -1L;
          this.jdField_a_of_type_Long = -1L;
          this.jdField_c_of_type_Long = -1L;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.stopVideoAudio(): position " + paramInt);
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
        QLog.w(" AIOGalleryAdapter", 2, "reportTroopVideo exception:" + QLog.getStackTraceString(paramURLDrawable));
        continue;
      }
      this.jdField_b_of_type_Long = -1L;
      this.jdField_a_of_type_Long = -1L;
      this.jdField_c_of_type_Long = -1L;
      return;
      paramInt = 3;
    }
  }
  
  private void a(int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIOShortVideoData paramAIOShortVideoData, File paramFile, boolean paramBoolean)
  {
    QQLiveDrawable.QQLiveDrawableParams localQQLiveDrawableParams = new QQLiveDrawable.QQLiveDrawableParams();
    localQQLiveDrawableParams.mPreviewWidth = paramAIOShortVideoData.jdField_c_of_type_Int;
    localQQLiveDrawableParams.mPreviewHeight = paramAIOShortVideoData.jdField_d_of_type_Int;
    localQQLiveDrawableParams.mDataSourceType = 3;
    if (paramFile != null) {
      localQQLiveDrawableParams.mDataSource = paramFile.getAbsolutePath();
    }
    localQQLiveDrawableParams.mLoopback = false;
    localQQLiveDrawableParams.mMute = paramBoolean;
    localQQLiveDrawableParams.mPlayType = 2;
    localQQLiveDrawableParams.mListener = this;
    localQQLiveDrawableParams.mLoopBackListener = this;
    localQQLiveDrawableParams.mDownloadListener = this;
    localQQLiveDrawableParams.msgUniseq = paramAIOShortVideoData.jdField_a_of_type_Long;
    localQQLiveDrawableParams.mVideoTime = paramAIOShortVideoData.jdField_a_of_type_Int;
    localQQLiveDrawableParams.mReportTag = "bus_type_aio_short_fs";
    Object localObject = paramAIOShortVideoData.a(0);
    paramFile = URLDrawable.URLDrawableOptions.obtain();
    if ((localObject != null) && (((File)localObject).getAbsoluteFile() != null))
    {
      localQQLiveDrawableParams.mCoverUrl = ShortVideoUtils.getThumbUrl(((File)localObject).getAbsolutePath()).toString();
      localObject = a(localQQLiveDrawableParams.mCoverUrl, paramAIOShortVideoData.jdField_c_of_type_Int, paramAIOShortVideoData.jdField_d_of_type_Int);
      if (!(localObject instanceof URLDrawable)) {
        break label257;
      }
    }
    label257:
    for (paramFile.mLoadingDrawable = ((URLDrawable)localObject).getCurrDrawable();; paramFile.mLoadingDrawable = ((Drawable)localObject))
    {
      paramFile.mExtraInfo = localQQLiveDrawableParams;
      paramFile = URLDrawable.getDrawable(ShortVideoItemBuilder.a(paramAIOShortVideoData.jdField_a_of_type_Long), paramFile);
      paramGalleryImageStruct.setImageDrawable(paramFile);
      a(paramInt, true);
      this.jdField_b_of_type_ComTencentImageURLDrawable = paramFile;
      this.jdField_d_of_type_Int = paramInt;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_c_of_type_Long = (paramAIOShortVideoData.jdField_a_of_type_Int * 1000L);
      return;
    }
  }
  
  private void a(int paramInt, AIORichMediaInfo paramAIORichMediaInfo, AdapterView<?> paramAdapterView, View paramView)
  {
    this.jdField_d_of_type_Long = -1L;
    if ((this.jdField_d_of_type_Int != paramInt) && (this.jdField_b_of_type_ComTencentImageURLDrawable != null))
    {
      a(this.jdField_d_of_type_Int, this.jdField_b_of_type_ComTencentImageURLDrawable, false);
      if ((this.jdField_b_of_type_ComTencentImageURLDrawable.getStatus() == 1) && ((this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable)))
      {
        QQLiveDrawable localQQLiveDrawable = (QQLiveDrawable)this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable();
        if (localQQLiveDrawable.getCurrentPosition() > 0L)
        {
          Object localObject = a(this.jdField_d_of_type_Int);
          if ((localObject != null) && (((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && ((((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)))
          {
            localObject = (AIOShortVideoData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
            a(((AIOShortVideoData)localObject).jdField_a_of_type_Long, ((AIOShortVideoData)localObject).jdField_a_of_type_Int * 1000, localQQLiveDrawable.getCurrentPosition());
          }
        }
        localQQLiveDrawable.recyleAndNotKeepPosition();
        if (QLog.isColorLevel()) {
          QLog.i(" AIOGalleryAdapter", 2, "onItemSelected recyleAndNotKeepPosition =" + localQQLiveDrawable + " mVideoDrawable set null");
        }
        this.jdField_b_of_type_ComTencentImageURLDrawable = null;
      }
    }
    if ((paramAIORichMediaInfo != null) && (AIOShortVideoData.class.isInstance(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
      a(paramAdapterView, (AIOShortVideoData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramView, paramInt);
    }
    do
    {
      do
      {
        return;
        if ((paramAIORichMediaInfo == null) || (!AIOImageData.class.isInstance(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
          break;
        }
        paramAIORichMediaInfo = (AIOImageData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      } while ((paramAIORichMediaInfo.jdField_b_of_type_Int != 3) || (paramAIORichMediaInfo.a(1) != null) || (paramAIORichMediaInfo.a(2) != null) || (paramAIORichMediaInfo.a(4) != null) || (paramAIORichMediaInfo.jdField_h_of_type_Long >= ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize()));
      a(paramInt, -1);
      return;
      this.jdField_d_of_type_Int = -1;
      this.jdField_b_of_type_ComTencentImageURLDrawable = null;
    } while (!QLog.isColorLevel());
    QLog.i(" AIOGalleryAdapter", 2, " onItemSelected():else Data is mVideoDrawable set null");
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (!AIOSingleReporter.a().a(paramLong1, "0X8009AA6"))
    {
      AIOSingleReporter.a().a(paramLong1, "0X8009AA6");
      ShortVideoUtils.reportVideoPlayEvent(null, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, 2, 2, paramLong2, paramLong3);
    }
  }
  
  private void a(URLDrawable paramURLDrawable, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIORichMediaInfo paramAIORichMediaInfo, int paramInt, File paramFile, boolean paramBoolean)
  {
    boolean bool = true;
    switch (paramURLDrawable.getStatus())
    {
    }
    for (;;)
    {
      paramGalleryImageStruct.setImageDrawable(paramURLDrawable);
      paramGalleryImageStruct.setOriginalImage(paramBoolean);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) {}
      try
      {
        paramURLDrawable.downloadImediatly();
        return;
      }
      catch (Exception paramURLDrawable)
      {
        paramURLDrawable.printStackTrace();
      }
      if (paramAIORichMediaInfo.jdField_b_of_type_Int == -2) {}
      try
      {
        paramAIORichMediaInfo.jdField_b_of_type_Int = JpegExifReader.readOrientation(paramFile.getAbsolutePath());
        a(paramGalleryImageStruct, paramURLDrawable, paramAIORichMediaInfo.jdField_b_of_type_Int);
        if (paramURLDrawable.getStatus() == 1) {
          a(paramInt, bool);
        }
      }
      catch (Exception paramFile)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(" AIOGalleryAdapter", 2, "read exif error", paramFile);
          }
          paramAIORichMediaInfo.jdField_b_of_type_Int = 1;
          continue;
          bool = false;
        }
      }
    }
  }
  
  private void a(AIOFilePicData paramAIOFilePicData, int paramInt)
  {
    Object localObject2 = paramAIOFilePicData.a(20);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = paramAIOFilePicData.a(18);
      if (localObject1 == null) {}
    }
    else
    {
      paramAIOFilePicData = URLDrawable.URLDrawableOptions.obtain();
      paramAIOFilePicData.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      paramAIOFilePicData.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
      paramAIOFilePicData.mPlayGifImage = true;
      paramAIOFilePicData.mUseExifOrientation = false;
      paramAIOFilePicData = URLDrawable.getDrawable((File)localObject1, paramAIOFilePicData);
      paramAIOFilePicData.setTag(Integer.valueOf(1));
      paramAIOFilePicData.startDownload();
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramAIOFilePicData);
    }
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = paramAIOFilePicData.a(16);
          if (localObject1 == null) {
            break;
          }
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
          URLDrawable.getDrawable((File)localObject1, (URLDrawable.URLDrawableOptions)localObject2).startDownload();
        } while ((!NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) || (paramAIOFilePicData.jdField_a_of_type_Long > ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize()));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOFilePicData.jdField_f_of_type_Long, paramAIOFilePicData.jdField_f_of_type_Int, 18);
        return;
      } while ((!NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) || (paramAIOFilePicData.jdField_a_of_type_Long > ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize()));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOFilePicData.jdField_f_of_type_Long, paramAIOFilePicData.jdField_f_of_type_Int, 18);
    } while (!QLog.isDevelopLevel());
    QLog.d(" AIOGalleryAdapter", 4, "onCreateView():Thumb and large pic is not exist, download it. Gallery position is " + paramInt);
  }
  
  private void a(AIOFilePicData paramAIOFilePicData, int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIORichMediaInfo paramAIORichMediaInfo, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramAIOFilePicData.jdField_a_of_type_Boolean)
    {
      paramAIOFilePicData = paramGalleryImageStruct.a();
      if (!URLDrawable.class.isInstance(paramAIOFilePicData)) {
        break label405;
      }
      localObject = (URLDrawable)paramAIOFilePicData;
      paramAIOFilePicData = ((URLDrawable)localObject).getURL().getRef();
    }
    for (;;)
    {
      if ((paramAIOFilePicData == null) && (FileUtil.b(((AIOFilePicData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString)))
      {
        paramAIOFilePicData = URLDrawable.URLDrawableOptions.obtain();
        paramAIOFilePicData.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
        paramAIOFilePicData.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
        paramAIOFilePicData = URLDrawable.getDrawable(new File(((AIOFilePicData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString), paramAIOFilePicData);
        if (paramAIOFilePicData != null)
        {
          paramGalleryImageStruct.setImageDrawable(paramAIOFilePicData);
          paramAIOFilePicData.downloadImediatly();
        }
      }
      do
      {
        do
        {
          do
          {
            return;
          } while ((localObject != null) && (paramAIOFilePicData != null) && (("PART".equals(paramAIOFilePicData)) || ("DISPLAY".equals(paramAIOFilePicData))));
          paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838183));
          a(paramInt, false);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().d();
        } while (((AIOFilePicData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_a_of_type_Long < ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize());
        paramGalleryImageStruct.b();
        return;
        localFile = paramAIOFilePicData.a(18);
      } while (localFile == null);
      localObject = paramAIOFilePicData.a(18);
      paramAIORichMediaInfo = (AIORichMediaInfo)localObject;
      if (paramBoolean) {
        paramAIORichMediaInfo = (String)localObject + "#PART";
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      localObject = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        paramGalleryImageStruct.setImageDrawable((Drawable)localObject);
        a(paramInt, true);
      }
      for (;;)
      {
        paramAIOFilePicData = FileUtils.b(paramAIOFilePicData.jdField_c_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): Update large image, position=" + paramInt + "url = " + paramAIORichMediaInfo + ",extName = " + paramAIOFilePicData);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().c();
        return;
        ((URLDrawable)localObject).setTag(Integer.valueOf(1));
        ((URLDrawable)localObject).startDownload();
        paramGalleryImageStruct.setDecodingDrawble((URLDrawable)localObject);
      }
      label405:
      File localFile = null;
      paramAIOFilePicData = (AIOFilePicData)localObject;
      localObject = localFile;
    }
  }
  
  private void a(AIOFileVideoData paramAIOFileVideoData, int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mUseExifOrientation = false;
    localURLDrawableOptions.mPlayGifImage = true;
    paramAIOFileVideoData = paramAIOFileVideoData.a(0);
    if (paramAIOFileVideoData != null)
    {
      paramAIOFileVideoData = URLDrawable.getDrawable(paramAIOFileVideoData, localURLDrawableOptions);
      if (paramAIOFileVideoData.getStatus() == 1)
      {
        paramGalleryImageStruct.setImageDrawable(paramAIOFileVideoData);
        a(paramInt, true);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().c();
        return;
        paramAIOFileVideoData.setTag(Integer.valueOf(1));
        paramAIOFileVideoData.startDownload();
        paramGalleryImageStruct.setDecodingDrawble(paramAIOFileVideoData);
      }
    }
    paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838183));
    a(paramInt, true);
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct != null))
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.a();
      paramGalleryImageStruct.setImageDrawable(localDrawable);
      if (URLDrawable.class.isInstance(localDrawable)) {
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, (URLDrawable)localDrawable);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = null;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "getView(): IMAGE_FILE_ERROR");
      }
      return;
      paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838183));
      a(paramInt, false);
    }
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, int paramInt, AIORichMediaInfo paramAIORichMediaInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean = true;
    AIOFilePicData localAIOFilePicData;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean = false;
      ReportController.b(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 1, 0, "", "", "", "");
      paramGalleryImageStruct.setCenterBtnVisiable(8);
      localAIOFilePicData = (AIOFilePicData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      paramGalleryImageStruct.setPosition(paramInt);
      paramGalleryImageStruct.setImageInfo(paramAIORichMediaInfo);
      paramGalleryImageStruct.setIgnoreLayout(false);
      localObject1 = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      if ((localObject1 == null) || (((URLDrawable)localObject1).getStatus() != 1)) {
        break label325;
      }
      paramGalleryImageStruct.setImageDrawable((Drawable)localObject1);
      String str = localAIOFilePicData.a(20);
      localObject2 = ((URLDrawable)localObject1).getURL().toString();
      a(paramInt, true);
      if (((String)localObject2).equals(str)) {
        paramGalleryImageStruct.setOriginalImage(true);
      }
      if (paramAIORichMediaInfo.jdField_b_of_type_Int == -2) {
        paramAIORichMediaInfo.jdField_b_of_type_Int = JpegExifReader.readOrientation(((URLDrawable)localObject1).getURL().getFile());
      }
      a(paramGalleryImageStruct, (URLDrawable)localObject1, paramAIORichMediaInfo.jdField_b_of_type_Int);
      if (!paramGalleryImageStruct.a()) {
        break label316;
      }
    }
    label316:
    for (paramGalleryImageStruct = localAIOFilePicData.jdField_d_of_type_JavaLangString;; paramGalleryImageStruct = localAIOFilePicData.jdField_c_of_type_JavaLangString)
    {
      paramGalleryImageStruct = FileUtils.b(paramGalleryImageStruct);
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "getView(): cache url is " + (String)localObject2 + ", cache type is " + localAIOFilePicData.a(((URLDrawable)localObject1).getURL().getFile()) + ",extName = + " + paramGalleryImageStruct);
      }
      return;
      ReportController.b(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 2, 0, "", "", "", "");
      break;
    }
    label325:
    Object localObject2 = localAIOFilePicData.a(20);
    if (localObject2 == null)
    {
      localObject1 = localAIOFilePicData.a(18);
      if (localObject1 == null) {}
    }
    for (;;)
    {
      if (localObject2 != null) {}
      for (boolean bool = true;; bool = false)
      {
        a(paramGalleryImageStruct, paramInt, paramAIORichMediaInfo, localAIOFilePicData, bool, (File)localObject1);
        return;
      }
      localObject1 = localAIOFilePicData.a(16);
      if (localObject1 != null)
      {
        a(paramGalleryImageStruct, paramInt, paramAIORichMediaInfo, localAIOFilePicData, (File)localObject1);
        return;
      }
      if (localAIOFilePicData.jdField_a_of_type_Long <= ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize())
      {
        if (localAIOFilePicData.jdField_a_of_type_Boolean) {
          paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838183));
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i(" AIOGalleryAdapter", 2, "getView(): No pic");
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) {
            break;
          }
          return;
          paramGalleryImageStruct.setImageDrawable(URLDrawableHelper.TRANSPARENT);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOFilePicData.jdField_f_of_type_Long, localAIOFilePicData.jdField_f_of_type_Int, 18);
        }
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
      }
      paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838183));
      paramGalleryImageStruct.b();
      paramGalleryImageStruct.setTag(2131296386, Float.valueOf(1.5F));
      return;
      localObject1 = localObject2;
    }
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, int paramInt, AIORichMediaInfo paramAIORichMediaInfo, AIOFilePicData paramAIOFilePicData, File paramFile)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    paramFile = URLDrawable.getDrawable(paramFile, localURLDrawableOptions);
    paramGalleryImageStruct.setImageDrawable(paramFile);
    if (!paramAIOFilePicData.jdField_d_of_type_Boolean) {
      if (paramAIOFilePicData.jdField_a_of_type_Long <= ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize())
      {
        paramFile.downloadImediatly();
        a(paramInt, paramAIORichMediaInfo.jdField_a_of_type_Int / 100);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOFilePicData.jdField_f_of_type_Long, paramAIOFilePicData.jdField_f_of_type_Int, 18);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "getView(): url is " + paramAIOFilePicData.a(16) + ", file type is " + 16);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = paramGalleryImageStruct;
      }
      return;
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
        continue;
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
        }
      }
    }
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, int paramInt, AIORichMediaInfo paramAIORichMediaInfo, AIOFilePicData paramAIOFilePicData, boolean paramBoolean, File paramFile)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.e;
    localURLDrawableOptions.mRequestHeight = this.jdField_f_of_type_Int;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mPlayGifImage = true;
    if (paramBoolean == true)
    {
      paramGalleryImageStruct.setOriginalImage(true);
      File localFile = paramAIOFilePicData.a(18);
      localObject = localFile;
      if (localFile == null) {
        localObject = paramAIOFilePicData.a(16);
      }
      if (localObject != null) {
        paramGalleryImageStruct.setImageDrawable(URLDrawable.getDrawable((File)localObject, localURLDrawableOptions));
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct != null))
    {
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = null;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.e;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_f_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
    localObject = URLDrawable.getDrawable(paramFile, (URLDrawable.URLDrawableOptions)localObject);
    ((URLDrawable)localObject).setTag(Integer.valueOf(1));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject);
    a(paramInt, -1);
    switch (((URLDrawable)localObject).getStatus())
    {
    default: 
      paramGalleryImageStruct.setImageDrawable((Drawable)localObject);
      paramGalleryImageStruct.setOriginalImage(paramBoolean);
      if (!paramBoolean) {
        break;
      }
    }
    for (paramGalleryImageStruct = paramAIOFilePicData.jdField_d_of_type_JavaLangString;; paramGalleryImageStruct = paramAIOFilePicData.jdField_c_of_type_JavaLangString)
    {
      FileUtils.b(paramGalleryImageStruct);
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
      }
      return;
      if (paramAIORichMediaInfo.jdField_b_of_type_Int == -2) {
        paramAIORichMediaInfo.jdField_b_of_type_Int = JpegExifReader.readOrientation(paramFile.getAbsolutePath());
      }
      paramGalleryImageStruct.setImageDrawable((Drawable)localObject);
      a(paramGalleryImageStruct, (URLDrawable)localObject, paramAIORichMediaInfo.jdField_b_of_type_Int);
      if (((URLDrawable)localObject).getStatus() == 1) {
        bool1 = true;
      }
      a(paramInt, bool1);
      break;
      bool1 = bool2;
      if (((URLDrawable)localObject).getStatus() == 1) {
        bool1 = true;
      }
      a(paramInt, bool1);
      break;
    }
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIORichMediaInfo paramAIORichMediaInfo, int paramInt, AIOImageData paramAIOImageData)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mUseExifOrientation = false;
    if ((paramAIOImageData.jdField_b_of_type_Int == 1) && ((paramAIOImageData.jdField_d_of_type_Int & 0x2) == 2)) {
      localURLDrawableOptions.mUseAutoScaleParams = false;
    }
    paramGalleryImageStruct.setImageDrawable(URLDrawable.getDrawable(paramAIOImageData.a(8), localURLDrawableOptions));
    a(paramInt, paramAIORichMediaInfo.jdField_a_of_type_Int / 100);
    if (QLog.isColorLevel()) {
      QLog.i(" AIOGalleryAdapter", 2, "getView(): url is " + paramAIOImageData.a(8) + ", file type is " + 8);
    }
    if (!paramAIOImageData.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOImageData.jdField_f_of_type_Long, paramAIOImageData.jdField_f_of_type_Int, 2);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = paramGalleryImageStruct;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().a(true);
      }
      if ((QLog.isDevelopLevel()) && (paramAIOImageData.jdField_d_of_type_Boolean)) {
        QQToast.a(paramGalleryImageStruct.getContext(), "Refresh temp display image", 2000).a();
      }
      return;
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIORichMediaInfo paramAIORichMediaInfo, int paramInt, AIOImageData paramAIOImageData, File paramFile)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    if ((paramAIOImageData.jdField_b_of_type_Int == 1) && ((paramAIOImageData.jdField_d_of_type_Int & 0x2) == 2)) {
      localURLDrawableOptions.mUseAutoScaleParams = false;
    }
    paramFile = URLDrawable.getDrawable(paramFile, localURLDrawableOptions);
    paramGalleryImageStruct.setImageDrawable(paramFile);
    if (!paramAIOImageData.jdField_g_of_type_Boolean)
    {
      paramFile.downloadImediatly();
      a(paramInt, paramAIORichMediaInfo.jdField_a_of_type_Int / 100);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOImageData.jdField_f_of_type_Long, paramAIOImageData.jdField_f_of_type_Int, 2);
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "getView(): url is " + paramAIOImageData.a(1) + ", file type is " + 1);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = paramGalleryImageStruct;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().a(paramAIOImageData.jdField_f_of_type_Boolean);
      }
      return;
    }
    paramAIORichMediaInfo = TroopMemberApiClient.a();
    paramAIORichMediaInfo.a();
    paramAIORichMediaInfo.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_JavaLangString, paramAIOImageData, 640, new AIOGalleryAdapter.4(this, paramInt, paramGalleryImageStruct, paramAIOImageData));
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIORichMediaInfo paramAIORichMediaInfo, URLDrawable paramURLDrawable, AIOImageData paramAIOImageData)
  {
    paramGalleryImageStruct.setImageDrawable(paramURLDrawable);
    String str2 = paramAIOImageData.a(4);
    String str1 = paramURLDrawable.getURL().toString();
    if (str1.equals(str2)) {
      paramGalleryImageStruct.setOriginalImage(true);
    }
    if (paramAIORichMediaInfo.jdField_b_of_type_Int == -2) {}
    try
    {
      paramAIORichMediaInfo.jdField_b_of_type_Int = JpegExifReader.readOrientation(paramURLDrawable.getURL().getFile());
      a(paramGalleryImageStruct, paramURLDrawable, paramAIORichMediaInfo.jdField_b_of_type_Int);
      if (paramGalleryImageStruct.a())
      {
        paramGalleryImageStruct = paramAIOImageData.jdField_c_of_type_JavaLangString;
        paramGalleryImageStruct = FileUtils.b(paramGalleryImageStruct);
        if (QLog.isColorLevel()) {
          QLog.i(" AIOGalleryAdapter", 2, "getView(): cache url is " + str1 + ", cache type is " + paramAIOImageData.a(paramURLDrawable.getURL().getFile()) + ",extName = + " + paramGalleryImageStruct);
        }
        if (paramAIOImageData.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOImageData.jdField_f_of_type_Long, paramAIOImageData.jdField_f_of_type_Int, 2);
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(" AIOGalleryAdapter", 2, "read exif error", localException);
        }
        paramAIORichMediaInfo.jdField_b_of_type_Int = 1;
        continue;
        paramGalleryImageStruct = paramAIOImageData.jdField_b_of_type_JavaLangString;
      }
    }
  }
  
  private void a(AIOImageData paramAIOImageData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean = false;
      if ((paramAIOImageData.jdField_g_of_type_Int == 1) && (paramAIOImageData.jdField_h_of_type_Boolean))
      {
        ReportController.b(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 1, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "dc00898", "", "", "0X8009EEF", "0X8009EEF", 1, 0, "", "", "", "");
      return;
    }
    if ((paramAIOImageData.jdField_g_of_type_Int == 1) && (paramAIOImageData.jdField_h_of_type_Boolean))
    {
      ReportController.b(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 2, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X8009EEF", "0X8009EEF", 2, 0, "", "", "", "");
  }
  
  private void a(AIOImageData paramAIOImageData, int paramInt)
  {
    Object localObject2 = paramAIOImageData.a(4);
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = paramAIOImageData.a(2);
      if (localObject1 == null) {}
    }
    for (;;)
    {
      int i;
      if (localObject2 != null)
      {
        i = 1;
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject2).mUseExifOrientation = false;
        if ((paramAIOImageData.jdField_b_of_type_Int == 1) && ((paramAIOImageData.jdField_d_of_type_Int & 0x2) == 2)) {
          ((URLDrawable.URLDrawableOptions)localObject2).mUseAutoScaleParams = false;
        }
        if ((i != 0) || (!paramAIOImageData.jdField_d_of_type_Boolean)) {
          break label162;
        }
        paramAIOImageData = URLDrawable.getDrawable(paramAIOImageData.a(2) + "#" + "PART", (URLDrawable.URLDrawableOptions)localObject2);
        label135:
        paramAIOImageData.setTag(Integer.valueOf(1));
        paramAIOImageData.startDownload();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramAIOImageData);
      }
      label162:
      label299:
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              i = 0;
              break;
              paramAIOImageData = URLDrawable.getDrawable((File)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
              break label135;
            } while ((paramAIOImageData.jdField_c_of_type_Boolean) || (paramAIOImageData.jdField_b_of_type_Boolean) || (paramAIOImageData.jdField_a_of_type_Boolean));
            if (paramAIOImageData.a(1) == null) {
              break label299;
            }
            localObject1 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
            ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
            if ((paramAIOImageData.jdField_b_of_type_Int == 1) && ((paramAIOImageData.jdField_d_of_type_Int & 0x2) == 2)) {
              ((URLDrawable.URLDrawableOptions)localObject1).mUseAutoScaleParams = false;
            }
            URLDrawable.getDrawable(paramAIOImageData.a(1), (URLDrawable.URLDrawableOptions)localObject1).startDownload();
          } while ((!NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) || (PeakUtils.a(paramAIOImageData.jdField_a_of_type_Int)));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOImageData.jdField_f_of_type_Long, paramAIOImageData.jdField_f_of_type_Int, 2);
          return;
        } while ((!NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) || (PeakUtils.a(paramAIOImageData.jdField_a_of_type_Int)));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOImageData.jdField_f_of_type_Long, paramAIOImageData.jdField_f_of_type_Int, 2);
      } while (!QLog.isDevelopLevel());
      QLog.d(" AIOGalleryAdapter", 4, "onCreateView():Thumb and large pic is not exist, download it. Gallery position is " + paramInt);
      return;
      localObject1 = localObject2;
    }
  }
  
  private void a(AIOImageData paramAIOImageData, String paramString1, String paramString2, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, int paramInt, AIORichMediaInfo paramAIORichMediaInfo, boolean paramBoolean)
  {
    if (paramString1 != null) {
      paramAIOImageData.jdField_b_of_type_JavaLangString = paramString1;
    }
    if (paramString2 != null) {
      paramAIOImageData.jdField_a_of_type_JavaLangString = paramString2;
    }
    if (paramAIOImageData.jdField_b_of_type_Boolean)
    {
      paramString1 = paramGalleryImageStruct.a();
      if (!URLDrawable.class.isInstance(paramString1)) {
        break label496;
      }
      paramString1 = (URLDrawable)paramString1;
      paramString2 = paramString1.getURL().getRef();
    }
    for (;;)
    {
      if ((paramString1 == null) || (paramString2 == null) || ((!"PART".equals(paramString2)) && (!"DISPLAY".equals(paramString2))))
      {
        paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838183));
        a(paramInt, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().d();
      }
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): IMAGE_FILE_ERROR");
      }
      if ((QLog.isDevelopLevel()) && (paramAIOImageData.jdField_d_of_type_Boolean)) {
        QQToast.a(paramGalleryImageStruct.getContext(), "AIOGalleryAdapter.updateView(): error!", 2000).a();
      }
      return;
      paramString2 = paramAIOImageData.a(2);
      if (paramString2 != null)
      {
        paramString1 = paramAIOImageData.a(2);
        if (!paramBoolean) {
          break label493;
        }
        paramString1 = paramString1 + "#PART";
      }
      label493:
      for (;;)
      {
        try
        {
          paramAIORichMediaInfo.jdField_b_of_type_Int = JpegExifReader.readOrientation(paramString2.getAbsolutePath());
          if (QLog.isColorLevel()) {
            QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): read orientation:" + paramAIORichMediaInfo.jdField_b_of_type_Int);
          }
          paramString2 = URLDrawable.URLDrawableOptions.obtain();
          if (paramAIOImageData.jdField_b_of_type_Int == 3)
          {
            paramAIORichMediaInfo = paramAIOImageData.a(1);
            if (paramAIORichMediaInfo != null)
            {
              paramAIORichMediaInfo = URLDrawable.getDrawable(paramAIORichMediaInfo, null);
              if (paramAIORichMediaInfo.getStatus() == 1)
              {
                paramString2.mLoadingDrawable = paramAIORichMediaInfo;
                paramString2.mFailedDrawable = paramAIORichMediaInfo;
              }
            }
          }
          paramString2.mUseExifOrientation = false;
          paramString2.mPlayGifImage = true;
          paramString2 = URLDrawable.getDrawable(paramString1, paramString2);
          if ((paramString2.getStatus() == 1) && (!paramAIOImageData.jdField_d_of_type_Boolean))
          {
            paramGalleryImageStruct.setImageDrawable(paramString2);
            a(paramInt, true);
            paramString2 = FileUtils.b(paramAIOImageData.jdField_b_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): Update large image, position=" + paramInt + "url = " + paramString1 + ",extName = " + paramString2);
            }
            paramAIOImageData.jdField_d_of_type_Boolean = paramBoolean;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().c();
            return;
          }
        }
        catch (Exception paramString2)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(" AIOGalleryAdapter", 2, "read exif error", paramString2);
          continue;
          paramString2.setTag(Integer.valueOf(1));
          paramString2.startDownload();
          paramGalleryImageStruct.setDecodingDrawble(paramString2);
          continue;
        }
        if (paramAIOImageData.a(1) == null) {
          break;
        }
        paramGalleryImageStruct.setImageDrawable(URLDrawable.getDrawable(paramAIOImageData.a(1), URLDrawable.URLDrawableOptions.obtain()));
        return;
      }
      label496:
      paramString2 = null;
      paramString1 = null;
    }
  }
  
  private void a(AIORichMediaInfo paramAIORichMediaInfo, View paramView)
  {
    this.jdField_g_of_type_Int = 1;
    a(this.jdField_d_of_type_Int, this.jdField_b_of_type_ComTencentImageURLDrawable, false);
    if ((this.jdField_b_of_type_ComTencentImageURLDrawable != null) && (this.jdField_b_of_type_ComTencentImageURLDrawable.getStatus() == 1) && ((this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable)))
    {
      QQLiveDrawable localQQLiveDrawable = (QQLiveDrawable)this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if (localQQLiveDrawable.getCurrentPosition() > 0L)
      {
        Object localObject = a(this.jdField_d_of_type_Int);
        if ((localObject != null) && (((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && ((((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)))
        {
          localObject = (AIOShortVideoData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          a(((AIOShortVideoData)localObject).jdField_a_of_type_Long, ((AIOShortVideoData)localObject).jdField_a_of_type_Int * 1000, localQQLiveDrawable.getCurrentPosition());
        }
      }
      localQQLiveDrawable.recyleAndNotKeepPosition();
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, " recyleAndNotKeepPosition ");
      }
      this.jdField_b_of_type_ComTencentImageURLDrawable = null;
    }
    if ((paramAIORichMediaInfo != null) && (AIOShortVideoData.class.isInstance(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
      b(paramAIORichMediaInfo, paramView);
    }
    do
    {
      return;
      if ((paramAIORichMediaInfo != null) && (AIOFileVideoData.class.isInstance(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)))
      {
        c(paramAIORichMediaInfo, paramView);
        return;
      }
    } while (!QLog.isColorLevel());
    if (paramAIORichMediaInfo != null)
    {
      QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP unsupport type :" + paramAIORichMediaInfo.getClass().getSimpleName());
      return;
    }
    QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP unsupport type, image null!");
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, int paramInt)
  {
    File localFile = paramAIOShortVideoData.a(0);
    if (localFile != null)
    {
      paramAIOShortVideoData = URLDrawable.URLDrawableOptions.obtain();
      paramAIOShortVideoData.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      paramAIOShortVideoData.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
      paramAIOShortVideoData = URLDrawable.getDrawable(localFile, paramAIOShortVideoData);
      paramAIOShortVideoData.startDownload();
      this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt, paramAIOShortVideoData);
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): preload thumb, position=" + paramInt);
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
            if (!paramAIOShortVideoData.jdField_b_of_type_Boolean) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): Video error, position=" + paramInt);
          return;
          if (paramAIOShortVideoData.a(1) == null) {
            break;
          }
          if (paramAIOShortVideoData.jdField_b_of_type_Int != 0) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOShortVideoData.jdField_f_of_type_Long, paramAIOShortVideoData.jdField_f_of_type_Int, 0);
          }
        } while (!QLog.isColorLevel());
        QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): Video exist and download thumb, position=" + paramInt);
        return;
      } while (paramAIOShortVideoData.jdField_b_of_type_Int == 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOShortVideoData.jdField_f_of_type_Long, paramAIOShortVideoData.jdField_f_of_type_Int, 1);
    } while (!QLog.isDevelopLevel());
    QLog.d(" AIOGalleryAdapter", 4, "onCreateView():Thumb and video is not exist, download video only. Gallery position is " + paramInt);
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct)
  {
    if (paramAIOShortVideoData.jdField_b_of_type_Int != 0)
    {
      if (!paramAIOShortVideoData.jdField_b_of_type_Boolean) {
        break label69;
      }
      paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838183));
      a(paramInt, false);
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): IMAGE_FILE_ERROR, position=" + paramInt);
      }
    }
    label69:
    do
    {
      return;
      File localFile = paramAIOShortVideoData.a(1);
      if (localFile != null)
      {
        paramAIOShortVideoData = URLDrawable.URLDrawableOptions.obtain();
        paramAIOShortVideoData.mLoadingDrawable = URLDrawableHelper.TRANSLUCENT;
        paramAIOShortVideoData.mUseMemoryCache = false;
        VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
        localVideoDrawableParams.mPlayVideoFrame = true;
        localVideoDrawableParams.mEnableAntiAlias = true;
        localVideoDrawableParams.mEnableFilter = true;
        paramAIOShortVideoData.mExtraInfo = localVideoDrawableParams;
        paramAIOShortVideoData = URLDrawable.getDrawable(localFile, paramAIOShortVideoData);
        if (paramAIOShortVideoData.getStatus() == 1) {
          paramGalleryImageStruct.setImageDrawable(paramAIOShortVideoData);
        }
        for (;;)
        {
          a(paramInt, true);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): Update video, position=" + paramInt);
          return;
          paramGalleryImageStruct.setDecodingDrawble(paramAIOShortVideoData);
          paramAIOShortVideoData.startDownload();
        }
      }
    } while ((paramAIOShortVideoData.a(0) == null) || (!QLog.isColorLevel()));
    QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): thumb downloaded, position=" + paramInt);
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOShortVideoData.jdField_f_of_type_Long, paramAIOShortVideoData.jdField_f_of_type_Int, 1);
    ((ImageView)paramView.findViewById(2131373467)).setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController.a(paramAIOShortVideoData, true, false);
    }
  }
  
  private void a(AdapterView<?> paramAdapterView, AIOShortVideoData paramAIOShortVideoData, View paramView, int paramInt)
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = ((AIOGalleryAdapter.GalleryImageStruct)paramView);
    this.jdField_g_of_type_Int = 0;
    if (this.jdField_d_of_type_Int == -1) {
      ReportController.b(null, "dc00898", "", "", "0X8007424", "0X8007424", 0, 0, "", "", "", "");
    }
    int i;
    if ((paramAdapterView != null) && (paramAdapterView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent() != null))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent();
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent().getBooleanExtra("extra.FROM_AIO", false)) {
        break label233;
      }
      paramAdapterView = "1";
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent().getIntExtra("forward_source_uin_type", -1);
      paramView = paramView.getStringExtra("leftViewText");
      if (paramView == null) {
        break label276;
      }
      if (!paramView.equals(HardCodeUtil.a(2131700149))) {
        break label240;
      }
      paramAdapterView = "2";
    }
    label276:
    for (;;)
    {
      ShortVideoUtils.reportVideoPlay(CaptureContext.a().getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent().getStringExtra("uin"), String.valueOf(paramAIOShortVideoData.jdField_a_of_type_Int * 1000), i, "2", paramAdapterView);
      paramAdapterView = (AIOGalleryScene)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a();
      if ((paramAdapterView != null) && (paramAdapterView.t))
      {
        paramAdapterView.t = false;
        if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct != null) {
          this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.b(paramInt);
        }
      }
      return;
      label233:
      paramAdapterView = "3";
      break;
      label240:
      if ((i == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a != null)) {
        paramAdapterView = "3";
      }
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ImageView paramImageView, int paramInt3)
  {
    if (FileUtils.b(paramString))
    {
      paramString = ShortVideoUtils.getThumbUrl(paramString);
      if (paramString != null)
      {
        paramString = a(paramString.toString(), paramInt1, paramInt2);
        if ((paramString instanceof URLDrawable)) {
          this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt3, (URLDrawable)paramString);
        }
        paramImageView.setImageDrawable(paramString);
      }
    }
    else
    {
      return;
    }
    QLog.d(" AIOGalleryAdapter", 2, "url  is null ");
  }
  
  private void a(boolean paramBoolean1, AIORichMediaInfo paramAIORichMediaInfo, AIOImageData paramAIOImageData, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1)
    {
      int i = paramAIORichMediaInfo.hashCode();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Int = i;
      paramAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a();
      paramAIORichMediaInfo.a(i);
      paramAIORichMediaInfo.a(i, paramAIOImageData.jdField_a_of_type_Long, paramAIOImageData.jdField_b_of_type_Long);
      paramAIORichMediaInfo.b(i, PeakUtils.a(paramAIOImageData.jdField_a_of_type_Int));
      if (paramAIOImageData.e) {
        paramAIORichMediaInfo.d(i);
      }
      if (paramString != null)
      {
        paramAIORichMediaInfo.a(i, paramString);
        paramAIORichMediaInfo.a(i, paramBoolean2);
      }
    }
  }
  
  private void b(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIORichMediaInfo paramAIORichMediaInfo, int paramInt, AIOImageData paramAIOImageData)
  {
    if (!paramAIOImageData.jdField_g_of_type_Boolean)
    {
      a(paramInt, paramAIORichMediaInfo.jdField_a_of_type_Int / 100);
      paramGalleryImageStruct.setImageDrawable(URLDrawableHelper.TRANSPARENT);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOImageData.jdField_f_of_type_Long, paramAIOImageData.jdField_f_of_type_Int, 2);
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "getView(): No pic");
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().a(paramAIOImageData.jdField_f_of_type_Boolean);
      }
      return;
      if (paramAIOImageData.jdField_h_of_type_Long <= ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize())
      {
        a(paramInt, paramAIORichMediaInfo.jdField_a_of_type_Int / 100);
        paramGalleryImageStruct.setImageDrawable(URLDrawableHelper.TRANSPARENT);
        paramAIORichMediaInfo = TroopMemberApiClient.a();
        paramAIORichMediaInfo.a();
        paramAIORichMediaInfo.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_JavaLangString, paramAIOImageData, 383, new AIOGalleryAdapter.5(this));
        a(paramInt, 0);
        paramAIORichMediaInfo.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_JavaLangString, paramAIOImageData, 640, new AIOGalleryAdapter.6(this, paramInt, paramGalleryImageStruct, paramAIOImageData));
      }
      else
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
        }
        paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838183));
        paramGalleryImageStruct.b();
        paramGalleryImageStruct.setTag(2131296386, Float.valueOf(1.5F));
      }
    }
  }
  
  private void b(AIORichMediaInfo paramAIORichMediaInfo, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean = true;
    paramAIORichMediaInfo = (AIOShortVideoData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    VideoPlayMedioInfo localVideoPlayMedioInfo;
    if ((paramAIORichMediaInfo != null) && (paramAIORichMediaInfo.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long != paramAIORichMediaInfo.jdField_f_of_type_Long))
    {
      localVideoPlayMedioInfo = a(paramAIORichMediaInfo);
      if (localVideoPlayMedioInfo != null) {
        break label74;
      }
      a(paramAIORichMediaInfo, paramView);
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "onItemSelect undownload notequal");
      }
    }
    label74:
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController.a(paramView, localVideoPlayMedioInfo);
      paramAIORichMediaInfo = (AIOGalleryScene)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a();
    } while ((paramAIORichMediaInfo == null) || (!paramAIORichMediaInfo.t));
    if (QLog.isColorLevel()) {
      QLog.i(" AIOGalleryAdapter", 2, "onItemSelect from nine");
    }
    paramAIORichMediaInfo.t = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController.f();
    this.jdField_d_of_type_Long = -1L;
  }
  
  private void c(AIORichMediaInfo paramAIORichMediaInfo, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP onItemSelected is FileVideodata ");
    }
    AIOFileVideoData localAIOFileVideoData = (AIOFileVideoData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if (paramAIORichMediaInfo.jdField_c_of_type_Boolean) {
      localAIOFileVideoData.e = true;
    }
    if (localAIOFileVideoData.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean) {
        this.jdField_d_of_type_Long = -1L;
      }
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP onItemSelected needUrl return ");
      }
    }
    label283:
    do
    {
      int i;
      do
      {
        return;
        AIOGalleryScene localAIOGalleryScene = (AIOGalleryScene)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a();
        if ((localAIOGalleryScene != null) && (localAIOGalleryScene.k == 3)) {}
        for (i = 1;; i = 0)
        {
          if ((!paramAIORichMediaInfo.jdField_c_of_type_Boolean) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean) && (i == 0))) {
            break label283;
          }
          if ((i == 0) && ((this.jdField_d_of_type_Long == -1L) || (this.jdField_d_of_type_Long != localAIOFileVideoData.jdField_f_of_type_Long))) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean = true;
          this.jdField_d_of_type_Long = -1L;
          localAIOFileVideoData.e = true;
          paramAIORichMediaInfo = localAIOFileVideoData.a(this.jdField_a_of_type_Boolean);
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController.a(paramView, paramAIORichMediaInfo);
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController.b();
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController.f();
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController.b(8);
          if (localAIOGalleryScene != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(" AIOGalleryAdapter", 2, "FileVideo_AP onItemSelected, aioGalleryScene.mIsMute =  " + localAIOGalleryScene.r);
            }
            localAIOGalleryScene.r = false;
          }
          this.jdField_a_of_type_Boolean = false;
          return;
        }
      } while ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean) || ((i == 0) && ((this.jdField_d_of_type_Long == -1L) || (this.jdField_d_of_type_Long != localAIOFileVideoData.jdField_f_of_type_Long))));
      this.jdField_d_of_type_Long = -1L;
      paramAIORichMediaInfo = localAIOFileVideoData.a(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController.a(paramView, paramAIORichMediaInfo);
    } while (!QLog.isColorLevel());
    QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP onItemSelected need user click ");
  }
  
  public void OnDownload(String paramString1, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, String paramString2)
  {
    new Handler(Looper.getMainLooper()).post(new AIOGalleryAdapter.3(this));
  }
  
  public AIORichMediaInfo a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt);
  }
  
  public VideoPlayMedioInfo a(AIOShortVideoData paramAIOShortVideoData)
  {
    Object localObject = new File(paramAIOShortVideoData.jdField_b_of_type_JavaLangString);
    long l = 0L;
    boolean bool;
    if (((File)localObject).exists())
    {
      l = ((File)localObject).length();
      if (l >= paramAIOShortVideoData.jdField_h_of_type_Long) {
        break label351;
      }
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(" AIOGalleryAdapter", 2, "carverW getVideoPlayMedioInfo longvideo GetUrlAction =" + bool);
      }
      if (bool)
      {
        LongVideoUrlCacheManager.UrlsCacheBean localUrlsCacheBean = LongVideoUrlCacheManager.a().a(paramAIOShortVideoData.jdField_f_of_type_Long);
        if ((localUrlsCacheBean == null) || (!localUrlsCacheBean.a())) {
          break label345;
        }
        if (QLog.isColorLevel()) {
          QLog.d(" AIOGalleryAdapter", 2, "carverW getVideoPlayMedioInfo  hit cache");
        }
        localObject = new VideoPlayMedioInfo();
        ((VideoPlayMedioInfo)localObject).jdField_a_of_type_Boolean = true;
        ((VideoPlayMedioInfo)localObject).jdField_a_of_type_ArrayOfJavaLangString = localUrlsCacheBean.jdField_a_of_type_ArrayOfJavaLangString;
        ((VideoPlayMedioInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = localUrlsCacheBean.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
        ((VideoPlayMedioInfo)localObject).jdField_a_of_type_Int = localUrlsCacheBean.jdField_a_of_type_Int;
        ((VideoPlayMedioInfo)localObject).jdField_a_of_type_Long = paramAIOShortVideoData.jdField_f_of_type_Long;
        ((VideoPlayMedioInfo)localObject).jdField_b_of_type_Int = paramAIOShortVideoData.jdField_f_of_type_Int;
      }
      for (;;)
      {
        if ((localObject != null) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramAIOShortVideoData.jdField_f_of_type_Long))
        {
          ((VideoPlayMedioInfo)localObject).e = true;
          if (QLog.isColorLevel()) {
            QLog.d(" AIOGalleryAdapter", 2, new Object[] { "set playMedioInfo.isMute = ", Boolean.valueOf(this.jdField_a_of_type_Boolean), " data.id = ", Long.valueOf(paramAIOShortVideoData.jdField_f_of_type_Long) });
          }
        }
        return localObject;
        if (QLog.isColorLevel()) {
          QLog.d(" AIOGalleryAdapter", 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
        }
        bool = true;
        break;
        localObject = new VideoPlayMedioInfo();
        ((VideoPlayMedioInfo)localObject).jdField_a_of_type_Boolean = false;
        ((VideoPlayMedioInfo)localObject).jdField_a_of_type_Long = paramAIOShortVideoData.jdField_f_of_type_Long;
        ((VideoPlayMedioInfo)localObject).jdField_b_of_type_Int = paramAIOShortVideoData.jdField_f_of_type_Int;
        ((VideoPlayMedioInfo)localObject).jdField_a_of_type_JavaLangString = paramAIOShortVideoData.jdField_b_of_type_JavaLangString;
        ((VideoPlayMedioInfo)localObject).jdField_d_of_type_Long = l;
        continue;
        label345:
        localObject = null;
      }
      label351:
      bool = false;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(" AIOGalleryAdapter", 2, "clearVideoDrawable");
    }
    if ((this.jdField_b_of_type_ComTencentImageURLDrawable != null) && ((this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable)))
    {
      QQLiveDrawable localQQLiveDrawable = (QQLiveDrawable)this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if (QLog.isColorLevel()) {
        QLog.d(" AIOGalleryAdapter", 2, "mVideoDrawabl=" + localQQLiveDrawable.getPlayState() + " id=" + localQQLiveDrawable.getMsgUniseq());
      }
      if (localQQLiveDrawable != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(" AIOGalleryAdapter", 2, "clearVideoDrawable recyleAndNotKeepPosition");
        }
        localQQLiveDrawable.recyleAndNotKeepPosition();
      }
    }
    this.jdField_b_of_type_ComTencentImageURLDrawable = null;
    this.jdField_d_of_type_Int = -1;
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
        QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateDisplayView(): Update dp image, position=" + paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().b();
      return;
    } while (!AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
  }
  
  void a(int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct)
  {
    paramGalleryImageStruct = paramGalleryImageStruct.a();
    if (URLDrawable.class.isInstance(paramGalleryImageStruct)) {
      a(paramInt, (URLDrawable)paramGalleryImageStruct, true);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    AIORichMediaInfo localAIORichMediaInfo = a(paramInt);
    if (localAIORichMediaInfo == null) {}
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!(paramView instanceof AIOGalleryAdapter.GalleryImageStruct)) {
            break;
          }
          paramView = (AIOGalleryAdapter.GalleryImageStruct)paramView;
          if (AIOImageData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            a((AIOImageData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramString1, paramString2, paramView, paramInt, localAIORichMediaInfo, paramBoolean);
          }
          while (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
            return;
            if (AIOShortVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
              a((AIOShortVideoData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramInt, paramView);
            } else if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
              a((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramInt, paramView, localAIORichMediaInfo, paramBoolean);
            } else if (AIOFileVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
              a((AIOFileVideoData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramInt, paramView);
            }
          }
        }
      } while ((!(paramView instanceof RelativeLayout)) || (!AIOShortVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)));
      paramString1 = (AIOShortVideoData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    } while (paramString1.jdField_b_of_type_Int != 0);
    if (QLog.isColorLevel()) {
      QLog.d(" AIOGalleryAdapter", 2, " updateView loadShortVideoCover");
    }
    paramString2 = (URLImageView)paramView.findViewById(2131373468);
    a(paramString1.jdField_a_of_type_JavaLangString, paramString1.jdField_c_of_type_Int, paramString1.jdField_d_of_type_Int, paramString2, paramInt);
  }
  
  public void a(Configuration paramConfiguration)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getResources().getDisplayMetrics().widthPixels;
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getResources().getDisplayMetrics().heightPixels;
    if ((i != this.e) || (j != this.jdField_f_of_type_Int))
    {
      this.e = i;
      this.jdField_f_of_type_Int = j;
      URLDrawable.clearMemoryCache();
      b();
    }
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(AbstractImageListModel paramAbstractImageListModel)
  {
    super.a(paramAbstractImageListModel);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel = ((AIOImageListModel)paramAbstractImageListModel);
    b();
  }
  
  void a(URLDrawable paramURLDrawable, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramURLDrawable);
    }
  }
  
  public void a(AIOGalleryAdapter.OnTroopThumbListener paramOnTroopThumbListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$OnTroopThumbListener = paramOnTroopThumbListener;
  }
  
  public void a(AIORichMediaData paramAIORichMediaData)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData = paramAIORichMediaData;
    this.jdField_d_of_type_Long = paramAIORichMediaData.jdField_f_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long = paramAIORichMediaData.jdField_f_of_type_Long;
  }
  
  public void a(VideoPlayController paramVideoPlayController)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController = paramVideoPlayController;
  }
  
  void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AIORichMediaInfo localAIORichMediaInfo = a(paramInt);
    if (QLog.isColorLevel())
    {
      QLog.d(" AIOGalleryAdapter", 2, "onItemSelected isShortVideoAutoPlay=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean + " hasDoneItemSelectUid=" + this.jdField_d_of_type_Long + " mContext.entryId=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long);
      QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP call onItemSelected ");
    }
    if ((localAIORichMediaInfo != null) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long))
    {
      QLog.d(" AIOGalleryAdapter", 2, "onItemSelected not first image.mData.id=" + localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long + " entryId=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long = -1L;
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (localAIORichMediaInfo != null) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long))
    {
      this.jdField_a_of_type_Boolean = false;
      AIOGalleryScene localAIOGalleryScene = (AIOGalleryScene)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a();
      if (localAIOGalleryScene != null) {
        localAIOGalleryScene.r = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d(" AIOGalleryAdapter", 2, "onItemSelected, set mIsmute false,  mDataOfBubble.id = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long + ", image.mData.id + " + localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
      }
    }
    if ((localAIORichMediaInfo != null) && ((AIOShortVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) || (AIOFileVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))))
    {
      ((AudioManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getSystemService("audio")).requestAudioFocus(null, 3, 2);
      if ((paramView == null) || (!AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView))) {
        break label402;
      }
      a(paramInt, localAIORichMediaInfo, paramAdapterView, paramView);
    }
    label402:
    while ((paramView == null) || (!(paramView instanceof RelativeLayout)))
    {
      return;
      ((AudioManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getSystemService("audio")).abandonAudioFocus(null);
      break;
    }
    a(localAIORichMediaInfo, paramView);
  }
  
  public void a(boolean paramBoolean)
  {
    super.notifyDataSetChanged();
    if (QLog.isColorLevel()) {
      QLog.d(" AIOGalleryAdapter", 2, "notifyDataSetChanged(): Data changed");
    }
    b();
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long == paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.d(" AIOGalleryAdapter", 2, "carverW isNeedAutoPlay true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(" AIOGalleryAdapter", 2, "carverW isNeedAutoPlay false");
    }
    return false;
  }
  
  public boolean a(AIOShortVideoData paramAIOShortVideoData, View paramView)
  {
    VideoPlayMedioInfo localVideoPlayMedioInfo = a(paramAIOShortVideoData);
    this.jdField_d_of_type_Long = paramAIOShortVideoData.jdField_a_of_type_Long;
    if (localVideoPlayMedioInfo == null)
    {
      a(paramAIOShortVideoData, paramView);
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController.a(paramView, localVideoPlayMedioInfo);
    }
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_b_of_type_AndroidUtilSparseArray.clear();
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.jdField_c_of_type_Int = -1;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject = a(paramInt1);
    if (localObject == null) {}
    AIOFileVideoData localAIOFileVideoData;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!AIOImageData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
              break;
            }
          } while (((AIOImageData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_d_of_type_Boolean);
          super.b(paramInt1, paramInt2);
          return;
        } while (AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
        if (AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          super.b(paramInt1, paramInt2);
          return;
        }
      } while (!AIOFileVideoData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
      localAIOFileVideoData = (AIOFileVideoData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    } while (!localAIOFileVideoData.jdField_d_of_type_Boolean);
    localAIOFileVideoData.jdField_c_of_type_Long = paramInt2;
    AIOGalleryScene localAIOGalleryScene = (AIOGalleryScene)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a();
    float f1 = (float)(paramInt2 * 100) / 10000.0F;
    if (localAIOFileVideoData.jdField_d_of_type_Boolean) {}
    for (localObject = HardCodeUtil.a(2131700150) + FileUtil.a(((float)localAIOFileVideoData.jdField_h_of_type_Long * f1)) + "/" + FileUtil.a(localAIOFileVideoData.jdField_h_of_type_Long) + ")";; localObject = HardCodeUtil.a(2131700108) + FileUtil.a(((float)localAIOFileVideoData.jdField_h_of_type_Long * f1)) + "/" + FileUtil.a(localAIOFileVideoData.jdField_h_of_type_Long) + ")")
    {
      localAIOGalleryScene.a(localAIOFileVideoData.jdField_f_of_type_Long, f1, (String)localObject);
      return;
    }
  }
  
  public void b(int paramInt, View paramView, boolean paramBoolean)
  {
    a(paramInt, null, null, paramView, paramBoolean);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(" AIOGalleryAdapter", 2, "destory");
    }
    if ((this.jdField_b_of_type_ComTencentImageURLDrawable != null) && ((this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable)))
    {
      QQLiveDrawable localQQLiveDrawable = (QQLiveDrawable)this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if (localQQLiveDrawable.getCurrentPosition() > 0L)
      {
        Object localObject = a(this.jdField_d_of_type_Int);
        if ((localObject != null) && (((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && ((((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)))
        {
          localObject = (AIOShortVideoData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          a(((AIOShortVideoData)localObject).jdField_a_of_type_Long, ((AIOShortVideoData)localObject).jdField_a_of_type_Int * 1000, localQQLiveDrawable.getCurrentPosition());
        }
      }
    }
    AIOSingleReporter.a().a();
    b();
    a();
  }
  
  public void d()
  {
    if (this.jdField_g_of_type_Int == 0) {
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct != null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.a();
      }
    }
    while ((this.jdField_g_of_type_Int != 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController.c())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController.h();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    AIOGalleryAdapter.GalleryImageStruct localGalleryImageStruct = new AIOGalleryAdapter.GalleryImageStruct(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity, 0);
    localGalleryImageStruct.setAdjustViewBounds(true);
    AIORichMediaInfo localAIORichMediaInfo = a(paramInt);
    if ((localAIORichMediaInfo == null) || (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData == null)) {
      QLog.e(" AIOGalleryAdapter", 2, " getView(): position=" + paramInt + " data is null");
    }
    for (;;)
    {
      if ((localAIORichMediaInfo != null) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null)) {
        break label217;
      }
      localObject = localGalleryImageStruct;
      break;
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, " getView(): position=" + paramInt + " uid=" + localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long + " isShortVideoAutoPlay=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean + " mDataLoaded=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean + " entryid=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long);
      }
    }
    label217:
    AIOImageData localAIOImageData;
    boolean bool2;
    boolean bool1;
    label362:
    File localFile;
    if (AIOImageData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
    {
      localObject = (AIOImageData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean = true;
      a((AIOImageData)localObject);
      localGalleryImageStruct.setCenterBtnVisiable(8);
      localAIOImageData = (AIOImageData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      localGalleryImageStruct.setPosition(paramInt);
      localGalleryImageStruct.setImageInfo(localAIORichMediaInfo);
      localGalleryImageStruct.setIgnoreLayout(false);
      localGalleryImageStruct.a(localAIOImageData.i);
      bool2 = false;
      localObject = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 1))
      {
        a(localGalleryImageStruct, localAIORichMediaInfo, (URLDrawable)localObject, localAIOImageData);
        bool2 = true;
        if (localGalleryImageStruct.a()) {}
        for (localObject = "original";; localObject = "large")
        {
          bool1 = true;
          a(bool2, localAIORichMediaInfo, localAIOImageData, bool1, (String)localObject);
          localObject = localAIOImageData.jdField_f_of_type_Long + "_" + localAIOImageData.jdField_f_of_type_Int;
          if (!this.jdField_a_of_type_JavaUtilArrayList.contains(localObject))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOImageData.jdField_f_of_type_Long, localAIOImageData.jdField_f_of_type_Int);
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          }
          label451:
          localObject = localGalleryImageStruct;
          break;
        }
      }
      localFile = localAIOImageData.a(4);
      if (localFile != null) {
        break label800;
      }
      localObject = localAIOImageData.a(2);
      if (localObject == null) {}
    }
    for (;;)
    {
      if (localFile != null)
      {
        bool2 = true;
        label500:
        localObject = a(localGalleryImageStruct, localAIORichMediaInfo, localAIOImageData, bool2, paramInt, (File)localObject);
        if (!((URLDrawable)localObject).isDownloadStarted()) {
          break label791;
        }
        if (GlobalImageCache.a.get(((URLDrawable)localObject).getURL().toString()) == null) {
          break label567;
        }
        bool1 = true;
        label545:
        if (!bool2) {
          break label573;
        }
        localObject = "original";
      }
      for (;;)
      {
        bool2 = true;
        break label362;
        bool2 = false;
        break label500;
        label567:
        bool1 = false;
        break label545;
        label573:
        localObject = "large";
        continue;
        if (localAIOImageData.a(8) != null)
        {
          a(localGalleryImageStruct, localAIORichMediaInfo, paramInt, localAIOImageData);
          bool2 = true;
          localObject = null;
          bool1 = false;
          break label362;
        }
        if ((localAIOImageData.jdField_c_of_type_Boolean) || (localAIOImageData.jdField_b_of_type_Boolean) || (localAIOImageData.jdField_a_of_type_Boolean))
        {
          a(localGalleryImageStruct, paramInt);
          localObject = null;
          bool1 = false;
          break label362;
        }
        localObject = localAIOImageData.a(1);
        if (localObject != null)
        {
          a(localGalleryImageStruct, localAIORichMediaInfo, paramInt, localAIOImageData, (File)localObject);
          bool2 = true;
          localObject = null;
          bool1 = false;
          break label362;
        }
        b(localGalleryImageStruct, localAIORichMediaInfo, paramInt, localAIOImageData);
        localObject = null;
        bool1 = false;
        break label362;
        if (AIOShortVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          localObject = a(paramInt, localAIORichMediaInfo);
          break;
        }
        if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          a(localGalleryImageStruct, paramInt, localAIORichMediaInfo);
          break label451;
        }
        if (!AIOFileVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          break label451;
        }
        localObject = a(localAIORichMediaInfo, paramInt, localGalleryImageStruct);
        break;
        label791:
        localObject = null;
        bool1 = false;
      }
      label800:
      localObject = localFile;
    }
  }
  
  public View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramView != null) {
      if (paramView.getStatus() == 3) {
        paramView.restartDownload();
      }
    }
    do
    {
      do
      {
        return null;
        paramView = a(paramInt);
      } while (paramView == null);
      if (AIOImageData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        a((AIOImageData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramInt);
        return null;
      }
      if (AIOShortVideoData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        a((AIOShortVideoData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramInt);
        return null;
      }
      if (AIOFilePicData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        a((AIOFilePicData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramInt);
        return null;
      }
    } while (!QLog.isColorLevel());
    QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): nani...");
    return null;
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramView != null)
    {
      if (paramView.getStatus() == 0) {
        paramView.cancelDownload(true);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    }
    this.jdField_b_of_type_AndroidUtilSparseArray.remove(paramInt);
    if (paramInt == this.jdField_c_of_type_Int)
    {
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.jdField_c_of_type_Int = -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(" AIOGalleryAdapter", 2, a());
    }
  }
  
  public void onLoopBack(QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(" AIOGalleryAdapter", 2, "onLoopBack");
    }
    a(paramQQLiveDrawableParams.msgUniseq, 1000L * paramQQLiveDrawableParams.mVideoTime, paramLong);
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    if (!AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView)) {}
    do
    {
      return;
      paramView = ((AIOGalleryAdapter.GalleryImageStruct)paramView).a();
    } while (!URLDrawable.class.isInstance(paramView));
    ((URLDrawable)paramView).updateRegionBitmap(paramRegionDrawableData);
  }
  
  public void onSlot(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onSlot(): position is " + paramInt);
    }
    System.gc();
  }
  
  public void onStateChange(String paramString, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder().append("onStateChange => ").append(QQLiveImage.getStateStr(paramInt)).append(", msgUniseq=").append(paramQQLiveDrawableParams.msgUniseq).append(", extra = ").append(paramObject).append(" mSelectImagView=");
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct == null)
      {
        paramString = "null";
        QLog.d(" AIOGalleryAdapter", 2, paramString);
      }
    }
    else
    {
      if (paramInt != 6) {
        break label162;
      }
      a(paramQQLiveDrawableParams.msgUniseq, paramQQLiveDrawableParams.mVideoTime * 1000L, 1000L * paramQQLiveDrawableParams.mVideoTime);
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct != null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      new Handler(Looper.getMainLooper()).post(new AIOGalleryAdapter.1(this));
    }
    label162:
    while (paramInt != 2)
    {
      return;
      paramString = "not null";
      break;
    }
    new Handler(Looper.getMainLooper()).post(new AIOGalleryAdapter.2(this));
  }
  
  public void onViewDetached(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramInt == this.jdField_c_of_type_Int)
    {
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.jdField_c_of_type_Int = -1;
      if (QLog.isColorLevel()) {
        QLog.d(" AIOGalleryAdapter", 2, "destory rawDrawable, position: " + paramInt);
      }
    }
    AIORichMediaInfo localAIORichMediaInfo;
    if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView))
    {
      paramViewGroup = (AIOGalleryAdapter.GalleryImageStruct)paramView;
      localAIORichMediaInfo = a(paramInt);
      if (localAIORichMediaInfo != null) {
        break label102;
      }
    }
    label102:
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
      QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onViewDetached(): Use thumb cache replace video.");
      return;
      paramViewGroup.setImageDrawable(URLDrawableHelper.TRANSPARENT);
    } while (!QLog.isColorLevel());
    QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onViewDetached(): No thumb, use TRANSPARENT");
  }
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup)
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
            QLog.d(" AIOGalleryAdapter", 2, "use exist raw drawable");
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
          QLog.d(" AIOGalleryAdapter", 2, "rawDrawable is exist");
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
          QLog.d(" AIOGalleryAdapter", 2, "create rawDrawable, position:" + paramInt);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */