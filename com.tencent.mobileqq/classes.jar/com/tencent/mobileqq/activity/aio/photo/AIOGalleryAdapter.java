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
import com.tencent.aelight.camera.qqstory.api.IAECaptureContext;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.common.galleryactivity.URLImageView2;
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
import com.tencent.mobileqq.activity.photo.OnProGalleryListener;
import com.tencent.mobileqq.activity.photo.VideoPlayController;
import com.tencent.mobileqq.activity.photo.VideoPlayMedioInfo;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreview;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreviewProgressive;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery.LayoutParams;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONObject;

public class AIOGalleryAdapter
  extends AbstractImageAdapter
  implements QQLiveDrawable.OnDownloadListener, QQLiveDrawable.OnLoopBackListener, QQLiveDrawable.OnStateListener, OnProGalleryListener
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getCoverDrawable():  getDrawable Exception, coverUrl=");
          localStringBuilder.append(paramString);
          QLog.e(" AIOGalleryAdapter", 2, localStringBuilder.toString(), localException);
        }
      }
    }
    return localEmptyDrawable;
  }
  
  private View a(int paramInt, AIORichMediaInfo paramAIORichMediaInfo)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity;
    Object localObject2 = Boolean.valueOf(true);
    ((AIOGalleryActivity)localObject1).jdField_d_of_type_Boolean = true;
    localObject1 = (AIOShortVideoData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if (((AIOShortVideoData)localObject1).jdField_b_of_type_Int != 0)
    {
      localObject2 = new AIOGalleryAdapter.GalleryImageStruct(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity, 1);
      ((AIOGalleryAdapter.GalleryImageStruct)localObject2).setAdjustViewBounds(true);
      localURLDrawable = (URLDrawable)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
      ((AIOGalleryAdapter.GalleryImageStruct)localObject2).setPosition(paramInt);
      ((AIOGalleryAdapter.GalleryImageStruct)localObject2).setImageInfo(paramAIORichMediaInfo);
      ((AIOGalleryAdapter.GalleryImageStruct)localObject2).a();
      if (localURLDrawable != null)
      {
        ((AIOGalleryAdapter.GalleryImageStruct)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.setImageDrawable(localURLDrawable);
        if (QLog.isColorLevel())
        {
          paramAIORichMediaInfo = new StringBuilder();
          paramAIORichMediaInfo.append("getView():load thumb hit cache , position is ");
          paramAIORichMediaInfo.append(paramInt);
          QLog.i(" AIOGalleryAdapter", 2, paramAIORichMediaInfo.toString());
        }
      }
      else if (((AIOShortVideoData)localObject1).a(0) != null)
      {
        a(((AIOShortVideoData)localObject1).jdField_a_of_type_JavaLangString, ((AIOShortVideoData)localObject1).jdField_c_of_type_Int, ((AIOShortVideoData)localObject1).jdField_d_of_type_Int, ((AIOGalleryAdapter.GalleryImageStruct)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView, paramInt);
        if (QLog.isColorLevel())
        {
          paramAIORichMediaInfo = new StringBuilder();
          paramAIORichMediaInfo.append("getView(): load thumb and videoDrawable exist, position is ");
          paramAIORichMediaInfo.append(paramInt);
          QLog.i(" AIOGalleryAdapter", 2, paramAIORichMediaInfo.toString());
        }
      }
      else
      {
        ((AIOGalleryAdapter.GalleryImageStruct)localObject2).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(((AIOShortVideoData)localObject1).jdField_f_of_type_Long, ((AIOShortVideoData)localObject1).jdField_f_of_type_Int, 0);
        paramAIORichMediaInfo = new StringBuilder();
        paramAIORichMediaInfo.append("getView(): load thumb download THUMB, position is ");
        paramAIORichMediaInfo.append(paramInt);
        QLog.i(" AIOGalleryAdapter", 2, paramAIORichMediaInfo.toString());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_b_of_type_Int == 1)
        {
          paramAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity;
          paramAIORichMediaInfo.jdField_b_of_type_Int -= 1;
          if (this.jdField_b_of_type_Boolean)
          {
            ((AIOGalleryAdapter.GalleryImageStruct)localObject2).b(paramInt);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean = false;
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_b_of_type_Int == 0)
        {
          ((AIOGalleryAdapter.GalleryImageStruct)localObject2).b(paramInt);
          ReportController.b(null, "dc00898", "", "", "0X8009EF1", "0X8009EF1", 1, 0, "", "", "", "");
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean = false;
        }
      }
      else {
        ReportController.b(null, "dc00898", "", "", "0X8009EF1", "0X8009EF1", 2, 0, "", "", "", "");
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
      }
      return localObject2;
    }
    paramAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getLayoutInflater().inflate(2131561288, null);
    paramAIORichMediaInfo.setTag(2131296400, localObject2);
    paramAIORichMediaInfo.setTag(2131296433, localObject2);
    paramAIORichMediaInfo.setLayoutParams(new Gallery.LayoutParams(-1, -1));
    localObject2 = (URLImageView)paramAIORichMediaInfo.findViewById(2131373043);
    URLDrawable localURLDrawable = (URLDrawable)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localURLDrawable != null) {
      ((URLImageView)localObject2).setImageDrawable(localURLDrawable);
    } else if (((AIOShortVideoData)localObject1).a(0) != null) {
      a(((AIOShortVideoData)localObject1).jdField_a_of_type_JavaLangString, ((AIOShortVideoData)localObject1).jdField_c_of_type_Int, ((AIOShortVideoData)localObject1).jdField_d_of_type_Int, (ImageView)localObject2, paramInt);
    }
    if (((AIOShortVideoData)localObject1).jdField_f_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long == ((AIOShortVideoData)localObject1).jdField_f_of_type_Long)
    {
      if (a((AIOShortVideoData)localObject1, paramAIORichMediaInfo))
      {
        ((ImageView)paramAIORichMediaInfo.findViewById(2131373042)).setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController.f();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean = false;
      ReportController.b(null, "dc00898", "", "", "0X8009EF2", "0X8009EF2", 1, 0, "", "", "", "");
    }
    else
    {
      ReportController.b(null, "dc00898", "", "", "0X8009EF2", "0X8009EF2", 2, 0, "", "", "", "");
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
    }
    return paramAIORichMediaInfo;
  }
  
  private View a(AIORichMediaInfo paramAIORichMediaInfo, int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean = false;
      ReportController.b(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 1, 0, "", "", "", "");
    }
    else
    {
      ReportController.b(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 2, 0, "", "", "", "");
    }
    AIOFileVideoData localAIOFileVideoData = (AIOFileVideoData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
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
      if ((paramGalleryImageStruct != null) && (((URLDrawable)paramGalleryImageStruct).getStatus() == 1))
      {
        a(paramInt, true);
      }
      else if (!TextUtils.isEmpty(localAIOFileVideoData.jdField_b_of_type_JavaLangString))
      {
        localObject = new File(localAIOFileVideoData.jdField_b_of_type_JavaLangString);
        if (((File)localObject).exists())
        {
          paramGalleryImageStruct = URLDrawable.URLDrawableOptions.obtain();
          paramGalleryImageStruct.mRequestWidth = this.e;
          paramGalleryImageStruct.mRequestHeight = this.jdField_f_of_type_Int;
          paramGalleryImageStruct.mLoadingDrawable = URLDrawableHelperConstants.a;
          paramGalleryImageStruct.mPlayGifImage = true;
          paramGalleryImageStruct.mUseExifOrientation = false;
          paramGalleryImageStruct = URLDrawable.getDrawable((File)localObject, paramGalleryImageStruct);
          localObject = (URLDrawable)paramGalleryImageStruct;
          ((URLDrawable)localObject).setTag(Integer.valueOf(1));
          this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject);
        }
      }
      else
      {
        paramGalleryImageStruct = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838024);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getLayoutInflater().inflate(2131561288, null);
    ((View)localObject).setTag(2131296400, Boolean.valueOf(true));
    ((View)localObject).setTag(2131296433, Boolean.valueOf(true));
    ((View)localObject).setLayoutParams(new Gallery.LayoutParams(-1, -1));
    URLImageView localURLImageView = (URLImageView)((View)localObject).findViewById(2131373043);
    localURLImageView.setImageDrawable(paramGalleryImageStruct);
    if (localAIOFileVideoData.b())
    {
      localURLImageView.setImageDrawable(null);
      return localObject;
    }
    if ((paramAIORichMediaInfo.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_b_of_type_Int == 1)
      {
        paramAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity;
        paramAIORichMediaInfo.jdField_b_of_type_Int -= 1;
        this.jdField_d_of_type_Long = -1L;
        if (QLog.isColorLevel())
        {
          QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP set hasDoneItemSelectUid = -1");
          return localObject;
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_b_of_type_Int == 0)
      {
        this.jdField_d_of_type_Long = localAIOFileVideoData.jdField_f_of_type_Long;
        localAIOFileVideoData.e = true;
        if (QLog.isColorLevel())
        {
          paramAIORichMediaInfo = new StringBuilder();
          paramAIORichMediaInfo.append("FileVideo_AP set hasDoneItemSelectUid = ");
          paramAIORichMediaInfo.append(this.jdField_d_of_type_Long);
          QLog.i(" AIOGalleryAdapter", 1, paramAIORichMediaInfo.toString());
          return localObject;
        }
      }
    }
    else
    {
      this.jdField_d_of_type_Long = localAIOFileVideoData.jdField_f_of_type_Long;
      if (QLog.isColorLevel())
      {
        paramAIORichMediaInfo = new StringBuilder();
        paramAIORichMediaInfo.append("FileVideo_AP is not EnterImage && isAutoPlayed, set hasDoneItemSelectUid = ");
        paramAIORichMediaInfo.append(this.jdField_d_of_type_Long);
        QLog.i(" AIOGalleryAdapter", 1, paramAIORichMediaInfo.toString());
      }
    }
    return localObject;
  }
  
  private URLDrawable a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIORichMediaInfo paramAIORichMediaInfo, AIOImageData paramAIOImageData, boolean paramBoolean, int paramInt, File paramFile)
  {
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.e;
    ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.jdField_f_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject1).mUseExifOrientation = false;
    ((URLDrawable.URLDrawableOptions)localObject1).mDecodeFileStrategy = 2;
    if ((paramAIOImageData.jdField_b_of_type_Int == 1) && ((paramAIOImageData.jdField_d_of_type_Int & 0x2) == 2)) {
      ((URLDrawable.URLDrawableOptions)localObject1).mUseAutoScaleParams = false;
    }
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct;
      if (localObject2 != null)
      {
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((AIOGalleryAdapter.GalleryImageStruct)localObject2).a();
        paramGalleryImageStruct.setTag(2131296389, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.getTag(2131296389));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = null;
      }
      else if ((paramAIOImageData.a(1) != null) && (GlobalImageCache.a.get(paramAIOImageData.a(1)) != null) && (paramAIOImageData.a(1) != null))
      {
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawable.getDrawable(paramAIOImageData.a(1), null);
      }
    }
    if (!paramBoolean) {}
    try
    {
      if (paramAIOImageData.jdField_d_of_type_Boolean)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramAIOImageData.a(2));
        ((StringBuilder)localObject2).append("#");
        ((StringBuilder)localObject2).append("PART");
        localObject1 = URLDrawable.getDrawable(((StringBuilder)localObject2).toString(), (URLDrawable.URLDrawableOptions)localObject1);
      }
      else
      {
        localObject1 = URLDrawable.getDrawable(paramFile, (URLDrawable.URLDrawableOptions)localObject1);
      }
      ((URLDrawable)localObject1).setTag(Integer.valueOf(1));
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
      a((URLDrawable)localObject1, paramGalleryImageStruct, paramAIORichMediaInfo, paramInt, paramFile, paramBoolean);
      if (paramBoolean) {
        paramAIORichMediaInfo = paramAIOImageData.jdField_c_of_type_JavaLangString;
      } else {
        paramAIORichMediaInfo = paramAIOImageData.jdField_b_of_type_JavaLangString;
      }
      paramAIORichMediaInfo = FileUtils.estimateFileType(paramAIORichMediaInfo);
      if (QLog.isColorLevel())
      {
        paramFile = new StringBuilder();
        paramFile.append("getview url is ");
        paramFile.append(((URLDrawable)localObject1).getURL().toString());
        paramFile.append(", file type is ");
        paramFile.append(paramAIOImageData.a(((URLDrawable)localObject1).getURL().toString()));
        paramFile.append(",extName = ");
        paramFile.append(paramAIORichMediaInfo);
        QLog.i(" AIOGalleryAdapter", 2, paramFile.toString());
      }
      if ((!paramBoolean) && (paramAIOImageData.jdField_d_of_type_Boolean) && (!paramAIOImageData.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOImageData.jdField_f_of_type_Long, paramAIOImageData.jdField_f_of_type_Int, 2);
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = paramGalleryImageStruct;
          return localObject1;
        }
      }
      else if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
      }
      return localObject1;
    }
    catch (Throwable paramGalleryImageStruct)
    {
      label492:
      break label492;
    }
    if (QLog.isColorLevel()) {
      QLog.e(" AIOGalleryAdapter", 2, "[getView] URLDrawable.getDrawable failed.");
    }
    return null;
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
    if (paramURLDrawable == null) {
      return;
    }
    paramURLDrawable = paramURLDrawable.getCurrDrawable();
    int i;
    Object localObject;
    if (VideoDrawable.class.isInstance(paramURLDrawable))
    {
      ((VideoDrawable)paramURLDrawable).stopAudio();
      if (this.jdField_b_of_type_Long > 0L)
      {
        this.jdField_a_of_type_Long += System.currentTimeMillis() - this.jdField_b_of_type_Long;
        paramURLDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent();
        if (paramURLDrawable != null)
        {
          i = paramURLDrawable.getIntExtra("forward_source_uin_type", -1);
          localObject = paramURLDrawable.getStringExtra("uin");
          new DCShortVideo(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplication().getBaseContext()).a(((IAECaptureContext)QRoute.api(IAECaptureContext.class)).getAppInterface(), 2001, 0, i, (String)localObject, this.jdField_a_of_type_Long / 1000L);
          if (this.jdField_b_of_type_Int == 1) {
            try
            {
              paramURLDrawable = new JSONObject();
              paramURLDrawable.put("author_id", localObject);
              paramURLDrawable.put("author_type", "1");
              paramURLDrawable.put("video_type", "1");
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
              ((StringBuilder)localObject).append("");
              paramURLDrawable.put("video_time", ((StringBuilder)localObject).toString());
              paramURLDrawable.put("play_time", this.jdField_a_of_type_Long);
              paramURLDrawable.put("content_type", 2);
              paramURLDrawable.put("mobile_type", Build.MODEL);
              paramURLDrawable.put("wifi_ssid", NetworkUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplicationContext()));
              paramURLDrawable.put("wifi_mac", NetworkUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplicationContext()));
              localObject = StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplicationContext());
              if (!paramBoolean) {
                break label761;
              }
              i = 2;
              StoryReportor.a("story_grp", "play_video_js", 1003, i, new String[] { paramURLDrawable.toString(), "", localObject, "" });
            }
            catch (Exception paramURLDrawable)
            {
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("reportTroopVideo exception:");
                ((StringBuilder)localObject).append(QLog.getStackTraceString(paramURLDrawable));
                QLog.w(" AIOGalleryAdapter", 2, ((StringBuilder)localObject).toString());
              }
            }
          }
        }
        this.jdField_b_of_type_Long = -1L;
        this.jdField_a_of_type_Long = -1L;
        this.jdField_c_of_type_Long = -1L;
      }
      if (QLog.isColorLevel())
      {
        paramURLDrawable = new StringBuilder();
        paramURLDrawable.append("AIOGalleryAdapter.stopVideoAudio(): position ");
        paramURLDrawable.append(paramInt);
        QLog.i(" AIOGalleryAdapter", 2, paramURLDrawable.toString());
      }
    }
    else if ((QQLiveDrawable.class.isInstance(paramURLDrawable)) && (this.jdField_b_of_type_Int == 1) && (this.jdField_b_of_type_Long > 0L))
    {
      this.jdField_a_of_type_Long += System.currentTimeMillis() - this.jdField_b_of_type_Long;
      paramURLDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent();
      if (paramURLDrawable != null) {
        localObject = paramURLDrawable.getStringExtra("uin");
      }
    }
    for (;;)
    {
      try
      {
        paramURLDrawable = new JSONObject();
        paramURLDrawable.put("author_id", localObject);
        paramURLDrawable.put("author_type", "1");
        paramURLDrawable.put("video_type", "1");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
        ((StringBuilder)localObject).append("");
        paramURLDrawable.put("video_time", ((StringBuilder)localObject).toString());
        paramURLDrawable.put("play_time", this.jdField_a_of_type_Long);
        paramURLDrawable.put("content_type", 2);
        localObject = StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplicationContext());
        if (!paramBoolean) {
          break label767;
        }
        paramInt = 2;
        StoryReportor.a("story_grp", "play_video_js", 1003, paramInt, new String[] { paramURLDrawable.toString(), "", localObject, "" });
      }
      catch (Exception paramURLDrawable)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("reportTroopVideo exception:");
          ((StringBuilder)localObject).append(QLog.getStackTraceString(paramURLDrawable));
          QLog.w(" AIOGalleryAdapter", 2, ((StringBuilder)localObject).toString());
        }
      }
      this.jdField_b_of_type_Long = -1L;
      this.jdField_a_of_type_Long = -1L;
      this.jdField_c_of_type_Long = -1L;
      return;
      label761:
      i = 3;
      break;
      label767:
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
      if ((localObject instanceof URLDrawable)) {
        paramFile.mLoadingDrawable = ((URLDrawable)localObject).getCurrDrawable();
      } else {
        paramFile.mLoadingDrawable = ((Drawable)localObject);
      }
    }
    paramFile.mExtraInfo = localQQLiveDrawableParams;
    paramFile = URLDrawable.getDrawable(ShortVideoItemBuilder.a(paramAIOShortVideoData.jdField_a_of_type_Long), paramFile);
    paramGalleryImageStruct.setImageDrawable(paramFile);
    a(paramInt, true);
    this.jdField_b_of_type_ComTencentImageURLDrawable = paramFile;
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_c_of_type_Long = (paramAIOShortVideoData.jdField_a_of_type_Int * 1000L);
  }
  
  private void a(int paramInt, AIORichMediaInfo paramAIORichMediaInfo, AdapterView<?> paramAdapterView, View paramView)
  {
    this.jdField_d_of_type_Long = -1L;
    int i = this.jdField_d_of_type_Int;
    if (i != paramInt)
    {
      Object localObject1 = this.jdField_b_of_type_ComTencentImageURLDrawable;
      if (localObject1 != null)
      {
        a(i, (URLDrawable)localObject1, false);
        if ((this.jdField_b_of_type_ComTencentImageURLDrawable.getStatus() == 1) && ((this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable)))
        {
          localObject1 = (QQLiveDrawable)this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable();
          Object localObject2;
          if (((QQLiveDrawable)localObject1).getCurrentPosition() > 0L)
          {
            localObject2 = a(this.jdField_d_of_type_Int);
            if ((localObject2 != null) && (((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && ((((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)))
            {
              localObject2 = (AIOShortVideoData)((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
              a(((AIOShortVideoData)localObject2).jdField_a_of_type_Long, ((AIOShortVideoData)localObject2).jdField_a_of_type_Int * 1000, ((QQLiveDrawable)localObject1).getCurrentPosition());
            }
          }
          ((QQLiveDrawable)localObject1).recyleAndNotKeepPosition();
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onItemSelected recyleAndNotKeepPosition =");
            ((StringBuilder)localObject2).append(localObject1);
            ((StringBuilder)localObject2).append(" mVideoDrawable set null");
            QLog.i(" AIOGalleryAdapter", 2, ((StringBuilder)localObject2).toString());
          }
          this.jdField_b_of_type_ComTencentImageURLDrawable = null;
        }
      }
    }
    if ((paramAIORichMediaInfo != null) && (AIOShortVideoData.class.isInstance(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)))
    {
      a(paramAdapterView, (AIOShortVideoData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramView, paramInt);
      return;
    }
    if ((paramAIORichMediaInfo != null) && (AIOImageData.class.isInstance(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)))
    {
      paramAIORichMediaInfo = (AIOImageData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if ((paramAIORichMediaInfo.jdField_b_of_type_Int == 3) && (paramAIORichMediaInfo.a(1) == null) && (paramAIORichMediaInfo.a(2) == null) && (paramAIORichMediaInfo.a(4) == null))
      {
        if (paramAIORichMediaInfo.jdField_h_of_type_Long >= ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize()) {
          return;
        }
        a(paramInt, -1);
      }
    }
    else
    {
      this.jdField_d_of_type_Int = -1;
      this.jdField_b_of_type_ComTencentImageURLDrawable = null;
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, " onItemSelected():else Data is mVideoDrawable set null");
      }
    }
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
    int i = paramURLDrawable.getStatus();
    boolean bool = true;
    if (i != 1)
    {
      if ((i != 2) && (i != 3)) {
        break label109;
      }
    }
    else
    {
      if (paramAIORichMediaInfo.jdField_b_of_type_Int == -2) {
        try
        {
          paramAIORichMediaInfo.jdField_b_of_type_Int = JpegExifReader.readOrientation(paramFile.getAbsolutePath());
        }
        catch (Exception paramFile)
        {
          if (QLog.isColorLevel()) {
            QLog.e(" AIOGalleryAdapter", 2, "read exif error", paramFile);
          }
          paramAIORichMediaInfo.jdField_b_of_type_Int = 1;
        }
      }
      a(paramGalleryImageStruct, paramURLDrawable, paramAIORichMediaInfo.jdField_b_of_type_Int);
    }
    if (paramURLDrawable.getStatus() != 1) {
      bool = false;
    }
    a(paramInt, bool);
    label109:
    paramGalleryImageStruct.setImageDrawable(paramURLDrawable);
    paramGalleryImageStruct.setOriginalImage(paramBoolean);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) {
      try
      {
        paramURLDrawable.downloadImediatly();
        return;
      }
      catch (Exception paramURLDrawable)
      {
        paramURLDrawable.printStackTrace();
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
      if (localObject1 == null)
      {
        localObject1 = paramAIOFilePicData.a(16);
        if (localObject1 != null)
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelperConstants.a;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = URLDrawableHelperConstants.a;
          URLDrawable.getDrawable((File)localObject1, (URLDrawable.URLDrawableOptions)localObject2).startDownload();
          if ((!NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) || (paramAIOFilePicData.jdField_a_of_type_Long > ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize())) {
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOFilePicData.jdField_f_of_type_Long, paramAIOFilePicData.jdField_f_of_type_Int, 18);
          return;
        }
        if ((!NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) || (paramAIOFilePicData.jdField_a_of_type_Long > ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize())) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOFilePicData.jdField_f_of_type_Long, paramAIOFilePicData.jdField_f_of_type_Int, 18);
        if (!QLog.isDevelopLevel()) {
          return;
        }
        paramAIOFilePicData = new StringBuilder();
        paramAIOFilePicData.append("onCreateView():Thumb and large pic is not exist, download it. Gallery position is ");
        paramAIOFilePicData.append(paramInt);
        QLog.d(" AIOGalleryAdapter", 4, paramAIOFilePicData.toString());
        return;
      }
    }
    paramAIOFilePicData = URLDrawable.URLDrawableOptions.obtain();
    paramAIOFilePicData.mLoadingDrawable = URLDrawableHelperConstants.a;
    paramAIOFilePicData.mFailedDrawable = URLDrawableHelperConstants.a;
    paramAIOFilePicData.mPlayGifImage = true;
    paramAIOFilePicData.mUseExifOrientation = false;
    paramAIOFilePicData = URLDrawable.getDrawable((File)localObject1, paramAIOFilePicData);
    paramAIOFilePicData.setTag(Integer.valueOf(1));
    paramAIOFilePicData.startDownload();
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramAIOFilePicData);
  }
  
  private void a(AIOFilePicData paramAIOFilePicData, int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIORichMediaInfo paramAIORichMediaInfo, boolean paramBoolean)
  {
    Object localObject;
    if (paramAIOFilePicData.jdField_a_of_type_Boolean)
    {
      localObject = paramGalleryImageStruct.a();
      paramBoolean = URLDrawable.class.isInstance(localObject);
      paramAIOFilePicData = null;
      if (paramBoolean)
      {
        paramAIOFilePicData = (URLDrawable)localObject;
        localObject = paramAIOFilePicData.getURL().getRef();
      }
      else
      {
        localObject = null;
      }
      if ((localObject == null) && (FileUtil.a(((AIOFilePicData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString)))
      {
        paramAIOFilePicData = URLDrawable.URLDrawableOptions.obtain();
        paramAIOFilePicData.mLoadingDrawable = URLDrawableHelperConstants.a;
        paramAIOFilePicData.mFailedDrawable = URLDrawableHelperConstants.a;
        paramAIOFilePicData = URLDrawable.getDrawable(new File(((AIOFilePicData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString), paramAIOFilePicData);
        if (paramAIOFilePicData != null)
        {
          paramGalleryImageStruct.setImageDrawable(paramAIOFilePicData);
          paramAIOFilePicData.downloadImediatly();
        }
      }
      else if ((paramAIOFilePicData == null) || (localObject == null) || ((!"PART".equals(localObject)) && (!"DISPLAY".equals(localObject))))
      {
        paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838024));
        a(paramInt, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().d();
        if (((AIOFilePicData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_a_of_type_Long >= ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize()) {
          paramGalleryImageStruct.b();
        }
      }
    }
    else
    {
      File localFile = paramAIOFilePicData.a(18);
      if (localFile != null)
      {
        localObject = paramAIOFilePicData.a(18);
        paramAIORichMediaInfo = (AIORichMediaInfo)localObject;
        if (paramBoolean)
        {
          paramAIORichMediaInfo = new StringBuilder();
          paramAIORichMediaInfo.append((String)localObject);
          paramAIORichMediaInfo.append("#PART");
          paramAIORichMediaInfo = paramAIORichMediaInfo.toString();
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
        else
        {
          ((URLDrawable)localObject).setTag(Integer.valueOf(1));
          ((URLDrawable)localObject).startDownload();
          paramGalleryImageStruct.setDecodingDrawble((URLDrawable)localObject);
        }
        paramAIOFilePicData = FileUtils.estimateFileType(paramAIOFilePicData.jdField_c_of_type_JavaLangString);
        if (QLog.isColorLevel())
        {
          paramGalleryImageStruct = new StringBuilder();
          paramGalleryImageStruct.append("AIOGalleryAdapter.updateView(): Update large image, position=");
          paramGalleryImageStruct.append(paramInt);
          paramGalleryImageStruct.append("url = ");
          paramGalleryImageStruct.append(paramAIORichMediaInfo);
          paramGalleryImageStruct.append(",extName = ");
          paramGalleryImageStruct.append(paramAIOFilePicData);
          QLog.i(" AIOGalleryAdapter", 2, paramGalleryImageStruct.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().c();
      }
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
      else
      {
        paramAIOFileVideoData.setTag(Integer.valueOf(1));
        paramAIOFileVideoData.startDownload();
        paramGalleryImageStruct.setDecodingDrawble(paramAIOFileVideoData);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().c();
      return;
    }
    paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838024));
    a(paramInt, true);
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct;
      if (localObject != null)
      {
        localObject = ((AIOGalleryAdapter.GalleryImageStruct)localObject).a();
        paramGalleryImageStruct.setImageDrawable((Drawable)localObject);
        if (URLDrawable.class.isInstance(localObject)) {
          this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, (URLDrawable)localObject);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = null;
        break label80;
      }
    }
    paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838024));
    a(paramInt, false);
    label80:
    if (QLog.isColorLevel()) {
      QLog.i(" AIOGalleryAdapter", 2, "getView(): IMAGE_FILE_ERROR");
    }
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, int paramInt, AIORichMediaInfo paramAIORichMediaInfo)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity;
    ((AIOGalleryActivity)localObject1).jdField_d_of_type_Boolean = true;
    boolean bool2 = ((AIOGalleryActivity)localObject1).jdField_c_of_type_Boolean;
    boolean bool1 = false;
    if (bool2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean = false;
      ReportController.b(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 1, 0, "", "", "", "");
    }
    else
    {
      ReportController.b(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 2, 0, "", "", "", "");
    }
    paramGalleryImageStruct.setCenterBtnVisiable(8);
    AIOFilePicData localAIOFilePicData = (AIOFilePicData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    paramGalleryImageStruct.setPosition(paramInt);
    paramGalleryImageStruct.setImageInfo(paramAIORichMediaInfo);
    paramGalleryImageStruct.setIgnoreLayout(false);
    localObject1 = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject2;
    if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1))
    {
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
      if (paramGalleryImageStruct.a()) {
        paramGalleryImageStruct = localAIOFilePicData.jdField_d_of_type_JavaLangString;
      } else {
        paramGalleryImageStruct = localAIOFilePicData.jdField_c_of_type_JavaLangString;
      }
      paramGalleryImageStruct = FileUtils.estimateFileType(paramGalleryImageStruct);
      if (QLog.isColorLevel())
      {
        paramAIORichMediaInfo = new StringBuilder();
        paramAIORichMediaInfo.append("getView(): cache url is ");
        paramAIORichMediaInfo.append((String)localObject2);
        paramAIORichMediaInfo.append(", cache type is ");
        paramAIORichMediaInfo.append(localAIOFilePicData.a(((URLDrawable)localObject1).getURL().getFile()));
        paramAIORichMediaInfo.append(",extName = + ");
        paramAIORichMediaInfo.append(paramGalleryImageStruct);
        QLog.i(" AIOGalleryAdapter", 2, paramAIORichMediaInfo.toString());
      }
    }
    else
    {
      localObject2 = localAIOFilePicData.a(20);
      if (localObject2 == null)
      {
        localObject1 = localAIOFilePicData.a(18);
        if (localObject1 == null)
        {
          localObject1 = localAIOFilePicData.a(16);
          if (localObject1 != null)
          {
            a(paramGalleryImageStruct, paramInt, paramAIORichMediaInfo, localAIOFilePicData, (File)localObject1);
            return;
          }
          if (localAIOFilePicData.jdField_a_of_type_Long <= ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize())
          {
            if (localAIOFilePicData.jdField_a_of_type_Boolean)
            {
              paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838024));
            }
            else
            {
              paramGalleryImageStruct.setImageDrawable(URLDrawableHelperConstants.a);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOFilePicData.jdField_f_of_type_Long, localAIOFilePicData.jdField_f_of_type_Int, 18);
            }
            if (QLog.isColorLevel()) {
              QLog.i(" AIOGalleryAdapter", 2, "getView(): No pic");
            }
            bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean;
            return;
          }
          if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
          }
          paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838024));
          paramGalleryImageStruct.b();
          paramGalleryImageStruct.setTag(2131296386, Float.valueOf(1.5F));
        }
      }
      else
      {
        localObject1 = localObject2;
      }
      if (localObject2 != null) {
        bool1 = true;
      }
      a(paramGalleryImageStruct, paramInt, paramAIORichMediaInfo, localAIOFilePicData, bool1, (File)localObject1);
    }
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, int paramInt, AIORichMediaInfo paramAIORichMediaInfo, AIOFilePicData paramAIOFilePicData, File paramFile)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
    paramFile = URLDrawable.getDrawable(paramFile, localURLDrawableOptions);
    paramGalleryImageStruct.setImageDrawable(paramFile);
    if (!paramAIOFilePicData.jdField_d_of_type_Boolean)
    {
      if (paramAIOFilePicData.jdField_a_of_type_Long <= ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize())
      {
        paramFile.downloadImediatly();
        a(paramInt, paramAIORichMediaInfo.jdField_a_of_type_Int / 100);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOFilePicData.jdField_f_of_type_Long, paramAIOFilePicData.jdField_f_of_type_Int, 18);
      }
      else if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
      }
    }
    else if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel())
    {
      paramAIORichMediaInfo = new StringBuilder();
      paramAIORichMediaInfo.append("getView(): url is ");
      paramAIORichMediaInfo.append(paramAIOFilePicData.a(16));
      paramAIORichMediaInfo.append(", file type is ");
      paramAIORichMediaInfo.append(16);
      QLog.i(" AIOGalleryAdapter", 2, paramAIORichMediaInfo.toString());
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = paramGalleryImageStruct;
    }
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, int paramInt, AIORichMediaInfo paramAIORichMediaInfo, AIOFilePicData paramAIOFilePicData, boolean paramBoolean, File paramFile)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.e;
    localURLDrawableOptions.mRequestHeight = this.jdField_f_of_type_Int;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct;
      if (localObject != null)
      {
        localURLDrawableOptions.mLoadingDrawable = ((AIOGalleryAdapter.GalleryImageStruct)localObject).a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = null;
      }
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.e;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_f_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    boolean bool2 = false;
    boolean bool1 = false;
    ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
    localObject = URLDrawable.getDrawable(paramFile, (URLDrawable.URLDrawableOptions)localObject);
    ((URLDrawable)localObject).setTag(Integer.valueOf(1));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject);
    a(paramInt, -1);
    int i = ((URLDrawable)localObject).getStatus();
    if (i != 1)
    {
      if ((i != 2) && (i != 3))
      {
        paramGalleryImageStruct.setImageDrawable((Drawable)localObject);
        paramGalleryImageStruct.setOriginalImage(paramBoolean);
      }
      else
      {
        if (((URLDrawable)localObject).getStatus() == 1) {
          bool1 = true;
        }
        a(paramInt, bool1);
      }
    }
    else
    {
      if (paramAIORichMediaInfo.jdField_b_of_type_Int == -2) {
        paramAIORichMediaInfo.jdField_b_of_type_Int = JpegExifReader.readOrientation(paramFile.getAbsolutePath());
      }
      paramGalleryImageStruct.setImageDrawable((Drawable)localObject);
      a(paramGalleryImageStruct, (URLDrawable)localObject, paramAIORichMediaInfo.jdField_b_of_type_Int);
      bool1 = bool2;
      if (((URLDrawable)localObject).getStatus() == 1) {
        bool1 = true;
      }
      a(paramInt, bool1);
    }
    if (paramBoolean) {
      paramGalleryImageStruct = paramAIOFilePicData.jdField_d_of_type_JavaLangString;
    } else {
      paramGalleryImageStruct = paramAIOFilePicData.jdField_c_of_type_JavaLangString;
    }
    FileUtils.estimateFileType(paramGalleryImageStruct);
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIORichMediaInfo paramAIORichMediaInfo, int paramInt, AIOImageData paramAIOImageData)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mUseExifOrientation = false;
    if ((paramAIOImageData.jdField_b_of_type_Int == 1) && ((paramAIOImageData.jdField_d_of_type_Int & 0x2) == 2)) {
      localURLDrawableOptions.mUseAutoScaleParams = false;
    }
    paramGalleryImageStruct.setImageDrawable(URLDrawable.getDrawable(paramAIOImageData.a(8), localURLDrawableOptions));
    a(paramInt, paramAIORichMediaInfo.jdField_a_of_type_Int / 100);
    if (QLog.isColorLevel())
    {
      paramAIORichMediaInfo = new StringBuilder();
      paramAIORichMediaInfo.append("getView(): url is ");
      paramAIORichMediaInfo.append(paramAIOImageData.a(8));
      paramAIORichMediaInfo.append(", file type is ");
      paramAIORichMediaInfo.append(8);
      QLog.i(" AIOGalleryAdapter", 2, paramAIORichMediaInfo.toString());
    }
    if (!paramAIOImageData.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOImageData.jdField_f_of_type_Long, paramAIOImageData.jdField_f_of_type_Int, 2);
    }
    else if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = paramGalleryImageStruct;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().a(true);
    }
    if ((QLog.isDevelopLevel()) && (paramAIOImageData.jdField_d_of_type_Boolean)) {
      QQToast.a(paramGalleryImageStruct.getContext(), "Refresh temp display image", 2000).a();
    }
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIORichMediaInfo paramAIORichMediaInfo, int paramInt, AIOImageData paramAIOImageData, File paramFile)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
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
      if (QLog.isColorLevel())
      {
        paramAIORichMediaInfo = new StringBuilder();
        paramAIORichMediaInfo.append("getView(): url is ");
        paramAIORichMediaInfo.append(paramAIOImageData.a(1));
        paramAIORichMediaInfo.append(", file type is ");
        paramAIORichMediaInfo.append(1);
        QLog.i(" AIOGalleryAdapter", 2, paramAIORichMediaInfo.toString());
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = paramGalleryImageStruct;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().a(paramAIOImageData.jdField_f_of_type_Boolean);
      }
    }
    else
    {
      paramAIORichMediaInfo = TroopMemberApiClient.a();
      paramAIORichMediaInfo.a();
      paramAIORichMediaInfo.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_JavaLangString, paramAIOImageData, 640, new AIOGalleryAdapter.4(this, paramInt, paramGalleryImageStruct, paramAIOImageData));
    }
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIORichMediaInfo paramAIORichMediaInfo, URLDrawable paramURLDrawable, AIOImageData paramAIOImageData)
  {
    paramGalleryImageStruct.setImageDrawable(paramURLDrawable);
    String str2 = paramAIOImageData.a(4);
    String str1 = paramURLDrawable.getURL().toString();
    if (str1.equals(str2)) {
      paramGalleryImageStruct.setOriginalImage(true);
    }
    if (paramAIORichMediaInfo.jdField_b_of_type_Int == -2) {
      try
      {
        paramAIORichMediaInfo.jdField_b_of_type_Int = JpegExifReader.readOrientation(paramURLDrawable.getURL().getFile());
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e(" AIOGalleryAdapter", 2, "read exif error", localException);
        }
        paramAIORichMediaInfo.jdField_b_of_type_Int = 1;
      }
    }
    a(paramGalleryImageStruct, paramURLDrawable, paramAIORichMediaInfo.jdField_b_of_type_Int);
    if (paramGalleryImageStruct.a()) {
      paramGalleryImageStruct = paramAIOImageData.jdField_c_of_type_JavaLangString;
    } else {
      paramGalleryImageStruct = paramAIOImageData.jdField_b_of_type_JavaLangString;
    }
    paramGalleryImageStruct = FileUtils.estimateFileType(paramGalleryImageStruct);
    if (QLog.isColorLevel())
    {
      paramAIORichMediaInfo = new StringBuilder();
      paramAIORichMediaInfo.append("getView(): cache url is ");
      paramAIORichMediaInfo.append(str1);
      paramAIORichMediaInfo.append(", cache type is ");
      paramAIORichMediaInfo.append(paramAIOImageData.a(paramURLDrawable.getURL().getFile()));
      paramAIORichMediaInfo.append(",extName = + ");
      paramAIORichMediaInfo.append(paramGalleryImageStruct);
      QLog.i(" AIOGalleryAdapter", 2, paramAIORichMediaInfo.toString());
    }
    if (paramAIOImageData.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOImageData.jdField_f_of_type_Long, paramAIOImageData.jdField_f_of_type_Int, 2);
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
      if (localObject1 == null)
      {
        if ((paramAIOImageData.jdField_c_of_type_Boolean) || (paramAIOImageData.jdField_b_of_type_Boolean)) {
          return;
        }
        if (paramAIOImageData.jdField_a_of_type_Boolean) {
          return;
        }
        if (paramAIOImageData.a(1) != null)
        {
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelperConstants.a;
          ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = URLDrawableHelperConstants.a;
          if ((paramAIOImageData.jdField_b_of_type_Int == 1) && ((paramAIOImageData.jdField_d_of_type_Int & 0x2) == 2)) {
            ((URLDrawable.URLDrawableOptions)localObject1).mUseAutoScaleParams = false;
          }
          URLDrawable.getDrawable(paramAIOImageData.a(1), (URLDrawable.URLDrawableOptions)localObject1).startDownload();
          if ((!NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) || (((IPicUtil)QRoute.api(IPicUtil.class)).isDynamicImg(paramAIOImageData.jdField_a_of_type_Int))) {
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOImageData.jdField_f_of_type_Long, paramAIOImageData.jdField_f_of_type_Int, 2);
          return;
        }
        if ((!NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) || (((IPicUtil)QRoute.api(IPicUtil.class)).isDynamicImg(paramAIOImageData.jdField_a_of_type_Int))) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOImageData.jdField_f_of_type_Long, paramAIOImageData.jdField_f_of_type_Int, 2);
        if (!QLog.isDevelopLevel()) {
          return;
        }
        paramAIOImageData = new StringBuilder();
        paramAIOImageData.append("onCreateView():Thumb and large pic is not exist, download it. Gallery position is ");
        paramAIOImageData.append(paramInt);
        QLog.d(" AIOGalleryAdapter", 4, paramAIOImageData.toString());
      }
    }
    else
    {
      localObject1 = localObject2;
    }
    int i;
    if (localObject2 != null) {
      i = 1;
    } else {
      i = 0;
    }
    localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject2).mUseExifOrientation = false;
    if ((paramAIOImageData.jdField_b_of_type_Int == 1) && ((paramAIOImageData.jdField_d_of_type_Int & 0x2) == 2)) {
      ((URLDrawable.URLDrawableOptions)localObject2).mUseAutoScaleParams = false;
    }
    if ((i == 0) && (paramAIOImageData.jdField_d_of_type_Boolean))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramAIOImageData.a(2));
      ((StringBuilder)localObject1).append("#");
      ((StringBuilder)localObject1).append("PART");
      paramAIOImageData = URLDrawable.getDrawable(((StringBuilder)localObject1).toString(), (URLDrawable.URLDrawableOptions)localObject2);
    }
    else
    {
      paramAIOImageData = URLDrawable.getDrawable((File)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
    }
    paramAIOImageData.setTag(Integer.valueOf(1));
    paramAIOImageData.startDownload();
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramAIOImageData);
  }
  
  private void a(AIOImageData paramAIOImageData, String paramString1, String paramString2, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, int paramInt, AIORichMediaInfo paramAIORichMediaInfo, boolean paramBoolean)
  {
    if (paramString1 != null) {
      paramAIOImageData.jdField_b_of_type_JavaLangString = paramString1;
    }
    if (paramString2 != null) {
      paramAIOImageData.jdField_a_of_type_JavaLangString = paramString2;
    }
    boolean bool = paramAIOImageData.jdField_b_of_type_Boolean;
    paramString1 = null;
    if (bool)
    {
      paramString2 = paramGalleryImageStruct.a();
      if (URLDrawable.class.isInstance(paramString2))
      {
        paramString1 = (URLDrawable)paramString2;
        paramString2 = paramString1.getURL().getRef();
      }
      else
      {
        paramString2 = null;
      }
      if ((paramString1 == null) || (paramString2 == null) || ((!"PART".equals(paramString2)) && (!"DISPLAY".equals(paramString2))))
      {
        paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838024));
        a(paramInt, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().d();
      }
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): IMAGE_FILE_ERROR");
      }
      if ((QLog.isDevelopLevel()) && (paramAIOImageData.jdField_d_of_type_Boolean)) {
        QQToast.a(paramGalleryImageStruct.getContext(), "AIOGalleryAdapter.updateView(): error!", 2000).a();
      }
    }
    else
    {
      File localFile = paramAIOImageData.a(2);
      if (localFile != null)
      {
        paramString2 = paramAIOImageData.a(2);
        paramString1 = paramString2;
        if (paramBoolean)
        {
          paramString1 = new StringBuilder();
          paramString1.append(paramString2);
          paramString1.append("#PART");
          paramString1 = paramString1.toString();
        }
        try
        {
          paramAIORichMediaInfo.jdField_b_of_type_Int = JpegExifReader.readOrientation(localFile.getAbsolutePath());
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("AIOGalleryAdapter.updateView(): read orientation:");
            paramString2.append(paramAIORichMediaInfo.jdField_b_of_type_Int);
            QLog.i(" AIOGalleryAdapter", 2, paramString2.toString());
          }
        }
        catch (Exception paramString2)
        {
          if (QLog.isColorLevel()) {
            QLog.e(" AIOGalleryAdapter", 2, "read exif error", paramString2);
          }
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
        }
        else
        {
          paramString2.setTag(Integer.valueOf(1));
          paramString2.startDownload();
          paramGalleryImageStruct.setDecodingDrawble(paramString2);
        }
        paramString2 = FileUtils.estimateFileType(paramAIOImageData.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel())
        {
          paramGalleryImageStruct = new StringBuilder();
          paramGalleryImageStruct.append("AIOGalleryAdapter.updateView(): Update large image, position=");
          paramGalleryImageStruct.append(paramInt);
          paramGalleryImageStruct.append("url = ");
          paramGalleryImageStruct.append(paramString1);
          paramGalleryImageStruct.append(",extName = ");
          paramGalleryImageStruct.append(paramString2);
          QLog.i(" AIOGalleryAdapter", 2, paramGalleryImageStruct.toString());
        }
        paramAIOImageData.jdField_d_of_type_Boolean = paramBoolean;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().c();
        return;
      }
      if (paramAIOImageData.a(1) != null) {
        paramGalleryImageStruct.setImageDrawable(URLDrawable.getDrawable(paramAIOImageData.a(1), URLDrawable.URLDrawableOptions.obtain()));
      }
    }
  }
  
  private void a(AIORichMediaInfo paramAIORichMediaInfo, View paramView)
  {
    this.jdField_g_of_type_Int = 1;
    a(this.jdField_d_of_type_Int, this.jdField_b_of_type_ComTencentImageURLDrawable, false);
    Object localObject1 = this.jdField_b_of_type_ComTencentImageURLDrawable;
    if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1) && ((this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable)))
    {
      localObject1 = (QQLiveDrawable)this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if (((QQLiveDrawable)localObject1).getCurrentPosition() > 0L)
      {
        Object localObject2 = a(this.jdField_d_of_type_Int);
        if ((localObject2 != null) && (((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && ((((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)))
        {
          localObject2 = (AIOShortVideoData)((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          a(((AIOShortVideoData)localObject2).jdField_a_of_type_Long, ((AIOShortVideoData)localObject2).jdField_a_of_type_Int * 1000, ((QQLiveDrawable)localObject1).getCurrentPosition());
        }
      }
      ((QQLiveDrawable)localObject1).recyleAndNotKeepPosition();
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, " recyleAndNotKeepPosition ");
      }
      this.jdField_b_of_type_ComTencentImageURLDrawable = null;
    }
    if ((paramAIORichMediaInfo != null) && (AIOShortVideoData.class.isInstance(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)))
    {
      b(paramAIORichMediaInfo, paramView);
      return;
    }
    if ((paramAIORichMediaInfo != null) && (AIOFileVideoData.class.isInstance(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)))
    {
      c(paramAIORichMediaInfo, paramView);
      return;
    }
    if (QLog.isColorLevel())
    {
      if (paramAIORichMediaInfo != null)
      {
        paramView = new StringBuilder();
        paramView.append("FileVideo_AP unsupport type :");
        paramView.append(paramAIORichMediaInfo.getClass().getSimpleName());
        QLog.i(" AIOGalleryAdapter", 1, paramView.toString());
        return;
      }
      QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP unsupport type, image null!");
    }
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, int paramInt)
  {
    File localFile = paramAIOShortVideoData.a(0);
    if (localFile != null)
    {
      paramAIOShortVideoData = URLDrawable.URLDrawableOptions.obtain();
      paramAIOShortVideoData.mLoadingDrawable = URLDrawableHelperConstants.a;
      paramAIOShortVideoData.mFailedDrawable = URLDrawableHelperConstants.a;
      paramAIOShortVideoData = URLDrawable.getDrawable(localFile, paramAIOShortVideoData);
      paramAIOShortVideoData.startDownload();
      this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt, paramAIOShortVideoData);
      if (QLog.isColorLevel())
      {
        paramAIOShortVideoData = new StringBuilder();
        paramAIOShortVideoData.append("AIOGalleryAdapter.onCreateView(): preload thumb, position=");
        paramAIOShortVideoData.append(paramInt);
        QLog.i(" AIOGalleryAdapter", 2, paramAIOShortVideoData.toString());
      }
    }
    else if (paramAIOShortVideoData.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        paramAIOShortVideoData = new StringBuilder();
        paramAIOShortVideoData.append("AIOGalleryAdapter.onCreateView(): Video error, position=");
        paramAIOShortVideoData.append(paramInt);
        QLog.i(" AIOGalleryAdapter", 2, paramAIOShortVideoData.toString());
      }
    }
    else if (paramAIOShortVideoData.a(1) != null)
    {
      if (paramAIOShortVideoData.jdField_b_of_type_Int != 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOShortVideoData.jdField_f_of_type_Long, paramAIOShortVideoData.jdField_f_of_type_Int, 0);
      }
      if (QLog.isColorLevel())
      {
        paramAIOShortVideoData = new StringBuilder();
        paramAIOShortVideoData.append("AIOGalleryAdapter.onCreateView(): Video exist and download thumb, position=");
        paramAIOShortVideoData.append(paramInt);
        QLog.i(" AIOGalleryAdapter", 2, paramAIOShortVideoData.toString());
      }
    }
    else if (paramAIOShortVideoData.jdField_b_of_type_Int != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOShortVideoData.jdField_f_of_type_Long, paramAIOShortVideoData.jdField_f_of_type_Int, 1);
      if (QLog.isDevelopLevel())
      {
        paramAIOShortVideoData = new StringBuilder();
        paramAIOShortVideoData.append("onCreateView():Thumb and video is not exist, download video only. Gallery position is ");
        paramAIOShortVideoData.append(paramInt);
        QLog.d(" AIOGalleryAdapter", 4, paramAIOShortVideoData.toString());
      }
    }
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct)
  {
    if (paramAIOShortVideoData.jdField_b_of_type_Int != 0) {
      if (paramAIOShortVideoData.jdField_b_of_type_Boolean)
      {
        paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838024));
        a(paramInt, false);
        if (QLog.isColorLevel())
        {
          paramAIOShortVideoData = new StringBuilder();
          paramAIOShortVideoData.append("AIOGalleryAdapter.updateView(): IMAGE_FILE_ERROR, position=");
          paramAIOShortVideoData.append(paramInt);
          QLog.i(" AIOGalleryAdapter", 2, paramAIOShortVideoData.toString());
        }
      }
      else
      {
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
          if (paramAIOShortVideoData.getStatus() == 1)
          {
            paramGalleryImageStruct.setImageDrawable(paramAIOShortVideoData);
          }
          else
          {
            paramGalleryImageStruct.setDecodingDrawble(paramAIOShortVideoData);
            paramAIOShortVideoData.startDownload();
          }
          a(paramInt, true);
          if (QLog.isColorLevel())
          {
            paramAIOShortVideoData = new StringBuilder();
            paramAIOShortVideoData.append("AIOGalleryAdapter.updateView(): Update video, position=");
            paramAIOShortVideoData.append(paramInt);
            QLog.i(" AIOGalleryAdapter", 2, paramAIOShortVideoData.toString());
          }
        }
        else if ((paramAIOShortVideoData.a(0) != null) && (QLog.isColorLevel()))
        {
          paramAIOShortVideoData = new StringBuilder();
          paramAIOShortVideoData.append("AIOGalleryAdapter.updateView(): thumb downloaded, position=");
          paramAIOShortVideoData.append(paramInt);
          QLog.i(" AIOGalleryAdapter", 2, paramAIOShortVideoData.toString());
        }
      }
    }
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOShortVideoData.jdField_f_of_type_Long, paramAIOShortVideoData.jdField_f_of_type_Int, 1);
    ((ImageView)paramView.findViewById(2131373042)).setVisibility(8);
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController;
    if (paramView != null) {
      paramView.a(paramAIOShortVideoData, true, false);
    }
  }
  
  private void a(AdapterView<?> paramAdapterView, AIOShortVideoData paramAIOShortVideoData, View paramView, int paramInt)
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = ((AIOGalleryAdapter.GalleryImageStruct)paramView);
    this.jdField_g_of_type_Int = 0;
    if (this.jdField_d_of_type_Int == -1) {
      ReportController.b(null, "dc00898", "", "", "0X8007424", "0X8007424", 0, 0, "", "", "", "");
    }
    if ((paramAdapterView != null) && (paramAdapterView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent() != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent();
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent().getBooleanExtra("extra.FROM_AIO", false);
      paramView = "3";
      if (bool) {
        paramAdapterView = "1";
      } else {
        paramAdapterView = "3";
      }
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent().getIntExtra("forward_source_uin_type", -1);
      localObject = ((Intent)localObject).getStringExtra("leftViewText");
      if (localObject != null)
      {
        if (((String)localObject).equals(HardCodeUtil.a(2131700290))) {}
        for (paramAdapterView = "2";; paramAdapterView = paramView)
        {
          break;
          if ((i != 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a == null)) {
            break;
          }
        }
      }
      ShortVideoUtils.reportVideoPlay(((IAECaptureContext)QRoute.api(IAECaptureContext.class)).getAppInterface().getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent().getStringExtra("uin"), String.valueOf(paramAIOShortVideoData.jdField_a_of_type_Int * 1000), i, "2", paramAdapterView);
    }
    paramAdapterView = (AIOGalleryScene)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a();
    if ((paramAdapterView != null) && (paramAdapterView.t))
    {
      paramAdapterView.t = false;
      paramAdapterView = this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct;
      if (paramAdapterView != null) {
        paramAdapterView.b(paramInt);
      }
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ImageView paramImageView, int paramInt3)
  {
    if (FileUtils.fileExistsAndNotEmpty(paramString))
    {
      paramString = ShortVideoUtils.getThumbUrl(paramString);
      if (paramString != null)
      {
        paramString = a(paramString.toString(), paramInt1, paramInt2);
        if ((paramString instanceof URLDrawable)) {
          this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt3, (URLDrawable)paramString);
        }
        paramImageView.setImageDrawable(paramString);
        return;
      }
      QLog.d(" AIOGalleryAdapter", 2, "url  is null ");
    }
  }
  
  private void b(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIORichMediaInfo paramAIORichMediaInfo, int paramInt, AIOImageData paramAIOImageData)
  {
    if (!paramAIOImageData.jdField_g_of_type_Boolean)
    {
      a(paramInt, paramAIORichMediaInfo.jdField_a_of_type_Int / 100);
      paramGalleryImageStruct.setImageDrawable(URLDrawableHelperConstants.a);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOImageData.jdField_f_of_type_Long, paramAIOImageData.jdField_f_of_type_Int, 2);
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "getView(): No pic");
      }
    }
    else if (paramAIOImageData.jdField_h_of_type_Long <= ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize())
    {
      a(paramInt, paramAIORichMediaInfo.jdField_a_of_type_Int / 100);
      paramGalleryImageStruct.setImageDrawable(URLDrawableHelperConstants.a);
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
      paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838024));
      paramGalleryImageStruct.b();
      paramGalleryImageStruct.setTag(2131296386, Float.valueOf(1.5F));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().a(paramAIOImageData.jdField_f_of_type_Boolean);
    }
  }
  
  private void b(AIORichMediaInfo paramAIORichMediaInfo, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean = true;
    Object localObject = (AIOShortVideoData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if ((localObject != null) && (((AIOShortVideoData)localObject).jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long != ((AIOShortVideoData)localObject).jdField_f_of_type_Long))
    {
      paramAIORichMediaInfo = a((AIOShortVideoData)localObject);
      if (paramAIORichMediaInfo == null)
      {
        a((AIOShortVideoData)localObject, paramView);
        if (QLog.isColorLevel()) {
          QLog.i(" AIOGalleryAdapter", 2, "onItemSelect undownload notequal");
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController;
        if (localObject != null)
        {
          ((VideoPlayController)localObject).a(paramView, paramAIORichMediaInfo);
          paramAIORichMediaInfo = (AIOGalleryScene)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a();
          if ((paramAIORichMediaInfo != null) && (paramAIORichMediaInfo.t))
          {
            if (QLog.isColorLevel()) {
              QLog.i(" AIOGalleryAdapter", 2, "onItemSelect from nine");
            }
            paramAIORichMediaInfo.t = false;
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController.f();
            this.jdField_d_of_type_Long = -1L;
          }
        }
      }
    }
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
      return;
    }
    AIOGalleryScene localAIOGalleryScene = (AIOGalleryScene)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a();
    int i;
    if ((localAIOGalleryScene != null) && (localAIOGalleryScene.k == 3)) {
      i = 1;
    } else {
      i = 0;
    }
    long l;
    if ((paramAIORichMediaInfo.jdField_c_of_type_Boolean) && ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean) || (i != 0)))
    {
      if (i == 0)
      {
        l = this.jdField_d_of_type_Long;
        if ((l == -1L) || (l != localAIOFileVideoData.jdField_f_of_type_Long)) {}
      }
      else
      {
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
          if (QLog.isColorLevel())
          {
            paramAIORichMediaInfo = new StringBuilder();
            paramAIORichMediaInfo.append("FileVideo_AP onItemSelected, aioGalleryScene.mIsMute =  ");
            paramAIORichMediaInfo.append(localAIOGalleryScene.r);
            QLog.d(" AIOGalleryAdapter", 2, paramAIORichMediaInfo.toString());
          }
          localAIOGalleryScene.r = false;
        }
        this.jdField_a_of_type_Boolean = false;
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean) {
      if (i == 0)
      {
        l = this.jdField_d_of_type_Long;
        if ((l == -1L) || (l != localAIOFileVideoData.jdField_f_of_type_Long)) {}
      }
      else
      {
        this.jdField_d_of_type_Long = -1L;
        paramAIORichMediaInfo = localAIOFileVideoData.a(this.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController.a(paramView, paramAIORichMediaInfo);
        if (QLog.isColorLevel()) {
          QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP onItemSelected need user click ");
        }
      }
    }
  }
  
  public void OnDownload(String paramString1, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, String paramString2)
  {
    new Handler(Looper.getMainLooper()).post(new AIOGalleryAdapter.3(this));
  }
  
  public AIORichMediaInfo a(int paramInt)
  {
    AIOImageListModel localAIOImageListModel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
    if (localAIOImageListModel == null) {
      return null;
    }
    return localAIOImageListModel.a(paramInt);
  }
  
  public VideoPlayMedioInfo a(AIOShortVideoData paramAIOShortVideoData)
  {
    Object localObject = new File(paramAIOShortVideoData.jdField_b_of_type_JavaLangString);
    long l;
    if (((File)localObject).exists())
    {
      l = ((File)localObject).length();
      if (l >= paramAIOShortVideoData.jdField_h_of_type_Long)
      {
        bool = false;
        break label65;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(" AIOGalleryAdapter", 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
      }
      l = 0L;
    }
    boolean bool = true;
    label65:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("carverW getVideoPlayMedioInfo longvideo GetUrlAction =");
      ((StringBuilder)localObject).append(bool);
      QLog.d(" AIOGalleryAdapter", 2, ((StringBuilder)localObject).toString());
    }
    AIORichMediaData localAIORichMediaData = null;
    if (bool)
    {
      LongVideoUrlCacheManager.UrlsCacheBean localUrlsCacheBean = LongVideoUrlCacheManager.a().a(paramAIOShortVideoData.jdField_f_of_type_Long);
      localObject = localAIORichMediaData;
      if (localUrlsCacheBean != null)
      {
        localObject = localAIORichMediaData;
        if (localUrlsCacheBean.a())
        {
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
      }
    }
    else
    {
      localObject = new VideoPlayMedioInfo();
      ((VideoPlayMedioInfo)localObject).jdField_a_of_type_Boolean = false;
      ((VideoPlayMedioInfo)localObject).jdField_a_of_type_Long = paramAIOShortVideoData.jdField_f_of_type_Long;
      ((VideoPlayMedioInfo)localObject).jdField_b_of_type_Int = paramAIOShortVideoData.jdField_f_of_type_Int;
      ((VideoPlayMedioInfo)localObject).jdField_a_of_type_JavaLangString = paramAIOShortVideoData.jdField_b_of_type_JavaLangString;
      ((VideoPlayMedioInfo)localObject).jdField_d_of_type_Long = l;
    }
    if ((localObject != null) && (this.jdField_a_of_type_Boolean))
    {
      localAIORichMediaData = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if ((localAIORichMediaData != null) && (localAIORichMediaData.jdField_f_of_type_Long == paramAIOShortVideoData.jdField_f_of_type_Long))
      {
        ((VideoPlayMedioInfo)localObject).e = true;
        if (QLog.isColorLevel()) {
          QLog.d(" AIOGalleryAdapter", 2, new Object[] { "set playMedioInfo.isMute = ", Boolean.valueOf(this.jdField_a_of_type_Boolean), " data.id = ", Long.valueOf(paramAIOShortVideoData.jdField_f_of_type_Long) });
        }
      }
    }
    return localObject;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(" AIOGalleryAdapter", 2, "clearVideoDrawable");
    }
    Object localObject = this.jdField_b_of_type_ComTencentImageURLDrawable;
    if ((localObject != null) && ((((URLDrawable)localObject).getCurrDrawable() instanceof QQLiveDrawable)))
    {
      localObject = (QQLiveDrawable)this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mVideoDrawabl=");
        localStringBuilder.append(((QQLiveDrawable)localObject).getPlayState());
        localStringBuilder.append(" id=");
        localStringBuilder.append(((QQLiveDrawable)localObject).getMsgUniseq());
        QLog.d(" AIOGalleryAdapter", 2, localStringBuilder.toString());
      }
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(" AIOGalleryAdapter", 2, "clearVideoDrawable recyleAndNotKeepPosition");
        }
        ((QQLiveDrawable)localObject).recyleAndNotKeepPosition();
      }
    }
    this.jdField_b_of_type_ComTencentImageURLDrawable = null;
    this.jdField_d_of_type_Int = -1;
  }
  
  public void a(int paramInt, View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof URLImageView2))
    {
      paramView = (URLImageView2)paramView;
      Object localObject1 = a(paramInt);
      if (localObject1 == null) {
        return;
      }
      if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        Object localObject2 = (AIOImageData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if ((paramBoolean) && (((AIOImageData)localObject2).a(8) != null))
        {
          localObject1 = paramView.getDrawable();
          localObject2 = ((AIOImageData)localObject2).a(8);
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append("#");
          ((StringBuilder)localObject3).append("DISPLAY");
          localObject2 = ((StringBuilder)localObject3).toString();
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject3).mUseExifOrientation = false;
          localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
          paramView.setDecodingDrawble((URLDrawable)localObject1);
          ((URLDrawable)localObject1).startDownload();
          if (QLog.isColorLevel())
          {
            paramView = new StringBuilder();
            paramView.append("AIOGalleryAdapter.updateDisplayView(): Update dp image, position=");
            paramView.append(paramInt);
            QLog.i(" AIOGalleryAdapter", 2, paramView.toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().b();
        }
      }
      else
      {
        AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
      }
    }
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
    if (localAIORichMediaInfo == null) {
      return;
    }
    if ((paramView instanceof AIOGalleryAdapter.GalleryImageStruct))
    {
      paramView = (AIOGalleryAdapter.GalleryImageStruct)paramView;
      if (AIOImageData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        a((AIOImageData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramString1, paramString2, paramView, paramInt, localAIORichMediaInfo, paramBoolean);
      } else if (AIOShortVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        a((AIOShortVideoData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramInt, paramView);
      } else if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        a((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramInt, paramView, localAIORichMediaInfo, paramBoolean);
      } else if (AIOFileVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        a((AIOFileVideoData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramInt, paramView);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
      }
    }
    else if (((paramView instanceof RelativeLayout)) && (AIOShortVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)))
    {
      paramString1 = (AIOShortVideoData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (paramString1.jdField_b_of_type_Int == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(" AIOGalleryAdapter", 2, " updateView loadShortVideoCover");
        }
        paramString2 = (URLImageView)paramView.findViewById(2131373043);
        a(paramString1.jdField_a_of_type_JavaLangString, paramString1.jdField_c_of_type_Int, paramString1.jdField_d_of_type_Int, paramString2, paramInt);
      }
    }
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onItemSelected isShortVideoAutoPlay=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean);
      ((StringBuilder)localObject).append(" hasDoneItemSelectUid=");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Long);
      ((StringBuilder)localObject).append(" mContext.entryId=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long);
      QLog.d(" AIOGalleryAdapter", 2, ((StringBuilder)localObject).toString());
      QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP call onItemSelected ");
    }
    if ((localAIORichMediaInfo != null) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onItemSelected not first image.mData.id=");
      ((StringBuilder)localObject).append(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
      ((StringBuilder)localObject).append(" entryId=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long);
      QLog.d(" AIOGalleryAdapter", 2, ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long = -1L;
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (localAIORichMediaInfo != null) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long))
    {
      this.jdField_a_of_type_Boolean = false;
      localObject = (AIOGalleryScene)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a();
      if (localObject != null) {
        ((AIOGalleryScene)localObject).r = false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onItemSelected, set mIsmute false,  mDataOfBubble.id = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
        ((StringBuilder)localObject).append(", image.mData.id + ");
        ((StringBuilder)localObject).append(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
        QLog.d(" AIOGalleryAdapter", 2, ((StringBuilder)localObject).toString());
      }
    }
    if ((localAIORichMediaInfo != null) && ((AIOShortVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) || (AIOFileVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)))) {
      ((AudioManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getSystemService("audio")).requestAudioFocus(null, 3, 2);
    } else {
      ((AudioManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getSystemService("audio")).abandonAudioFocus(null);
    }
    if ((paramView != null) && (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView)))
    {
      a(paramInt, localAIORichMediaInfo, paramAdapterView, paramView);
      return;
    }
    if ((paramView != null) && ((paramView instanceof RelativeLayout))) {
      a(localAIORichMediaInfo, paramView);
    }
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
    paramAIOShortVideoData = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController;
    if (paramAIOShortVideoData != null) {
      paramAIOShortVideoData.a(paramView, localVideoPlayMedioInfo);
    }
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_b_of_type_AndroidUtilSparseArray.clear();
    URLDrawable localURLDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if ((localURLDrawable != null) && (localURLDrawable.getStatus() == 0)) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.jdField_c_of_type_Int = -1;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject = a(paramInt1);
    if (localObject == null) {
      return;
    }
    if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
    {
      if (!((AIOImageData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_d_of_type_Boolean) {
        super.b(paramInt1, paramInt2);
      }
    }
    else
    {
      if (AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        return;
      }
      if (AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        super.b(paramInt1, paramInt2);
        return;
      }
      if (AIOFileVideoData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        AIOFileVideoData localAIOFileVideoData = (AIOFileVideoData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if (!localAIOFileVideoData.jdField_d_of_type_Boolean) {
          return;
        }
        localAIOFileVideoData.jdField_c_of_type_Long = paramInt2;
        AIOGalleryScene localAIOGalleryScene = (AIOGalleryScene)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a();
        float f1 = (float)(paramInt2 * 100) / 10000.0F;
        if (localAIOFileVideoData.jdField_d_of_type_Boolean)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131700291));
          ((StringBuilder)localObject).append(FileUtil.a(((float)localAIOFileVideoData.jdField_h_of_type_Long * f1)));
          ((StringBuilder)localObject).append("/");
          ((StringBuilder)localObject).append(FileUtil.a(localAIOFileVideoData.jdField_h_of_type_Long));
          ((StringBuilder)localObject).append(")");
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131700249));
          ((StringBuilder)localObject).append(FileUtil.a(((float)localAIOFileVideoData.jdField_h_of_type_Long * f1)));
          ((StringBuilder)localObject).append("/");
          ((StringBuilder)localObject).append(FileUtil.a(localAIOFileVideoData.jdField_h_of_type_Long));
          ((StringBuilder)localObject).append(")");
          localObject = ((StringBuilder)localObject).toString();
        }
        localAIOGalleryScene.a(localAIOFileVideoData.jdField_f_of_type_Long, f1, (String)localObject);
      }
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
    Object localObject1 = this.jdField_b_of_type_ComTencentImageURLDrawable;
    if ((localObject1 != null) && ((((URLDrawable)localObject1).getCurrDrawable() instanceof QQLiveDrawable)))
    {
      localObject1 = (QQLiveDrawable)this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if (((QQLiveDrawable)localObject1).getCurrentPosition() > 0L)
      {
        Object localObject2 = a(this.jdField_d_of_type_Int);
        if ((localObject2 != null) && (((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && ((((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)))
        {
          localObject2 = (AIOShortVideoData)((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          a(((AIOShortVideoData)localObject2).jdField_a_of_type_Long, ((AIOShortVideoData)localObject2).jdField_a_of_type_Int * 1000, ((QQLiveDrawable)localObject1).getCurrentPosition());
        }
      }
    }
    AIOSingleReporter.a().a();
    b();
    a();
  }
  
  public void d()
  {
    int i = this.jdField_g_of_type_Int;
    Object localObject;
    if (i == 0)
    {
      localObject = this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct;
      if (localObject != null) {
        ((AIOGalleryAdapter.GalleryImageStruct)localObject).a();
      }
    }
    else if (i == 1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController;
      if ((localObject != null) && (((VideoPlayController)localObject).c())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController.h();
      }
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
    }
    else
    {
      AIOGalleryAdapter.GalleryImageStruct localGalleryImageStruct = new AIOGalleryAdapter.GalleryImageStruct(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity, 0);
      localGalleryImageStruct.setAdjustViewBounds(true);
      AIORichMediaInfo localAIORichMediaInfo = a(paramInt);
      if ((localAIORichMediaInfo != null) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" getView(): position=");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append(" uid=");
          ((StringBuilder)localObject).append(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
          ((StringBuilder)localObject).append(" isShortVideoAutoPlay=");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean);
          ((StringBuilder)localObject).append(" mDataLoaded=");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean);
          ((StringBuilder)localObject).append(" entryid=");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long);
          QLog.i(" AIOGalleryAdapter", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" getView(): position=");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" data is null");
        QLog.e(" AIOGalleryAdapter", 2, ((StringBuilder)localObject).toString());
      }
      if ((localAIORichMediaInfo != null) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null)) {
        if (AIOImageData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          localObject = (AIOImageData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean = true;
          a((AIOImageData)localObject);
          localGalleryImageStruct.setCenterBtnVisiable(8);
          AIOImageData localAIOImageData = (AIOImageData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          localGalleryImageStruct.setPosition(paramInt);
          localGalleryImageStruct.setImageInfo(localAIORichMediaInfo);
          localGalleryImageStruct.setIgnoreLayout(false);
          localGalleryImageStruct.a(localAIOImageData.i);
          localObject = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
          if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 1))
          {
            a(localGalleryImageStruct, localAIORichMediaInfo, (URLDrawable)localObject, localAIOImageData);
            localGalleryImageStruct.a();
          }
          else
          {
            File localFile = localAIOImageData.a(4);
            if (localFile == null)
            {
              localObject = localAIOImageData.a(2);
              if (localObject == null)
              {
                if (localAIOImageData.a(8) != null)
                {
                  a(localGalleryImageStruct, localAIORichMediaInfo, paramInt, localAIOImageData);
                  break label572;
                }
                if ((!localAIOImageData.jdField_c_of_type_Boolean) && (!localAIOImageData.jdField_b_of_type_Boolean) && (!localAIOImageData.jdField_a_of_type_Boolean))
                {
                  localObject = localAIOImageData.a(1);
                  if (localObject != null)
                  {
                    a(localGalleryImageStruct, localAIORichMediaInfo, paramInt, localAIOImageData, (File)localObject);
                    break label572;
                  }
                  b(localGalleryImageStruct, localAIORichMediaInfo, paramInt, localAIOImageData);
                  break label572;
                }
                a(localGalleryImageStruct, paramInt);
                break label572;
              }
            }
            else
            {
              localObject = localFile;
            }
            boolean bool;
            if (localFile != null) {
              bool = true;
            } else {
              bool = false;
            }
            localObject = a(localGalleryImageStruct, localAIORichMediaInfo, localAIOImageData, bool, paramInt, (File)localObject);
            if (((URLDrawable)localObject).isDownloadStarted()) {
              GlobalImageCache.a.get(((URLDrawable)localObject).getURL().toString());
            }
          }
          label572:
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localAIOImageData.jdField_f_of_type_Long);
          ((StringBuilder)localObject).append("_");
          ((StringBuilder)localObject).append(localAIOImageData.jdField_f_of_type_Int);
          localObject = ((StringBuilder)localObject).toString();
          if (!this.jdField_a_of_type_JavaUtilArrayList.contains(localObject))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOImageData.jdField_f_of_type_Long, localAIOImageData.jdField_f_of_type_Int);
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          }
        }
        else
        {
          if (AIOShortVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
          {
            localObject = a(paramInt, localAIORichMediaInfo);
            break label746;
          }
          if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
          {
            a(localGalleryImageStruct, paramInt, localAIORichMediaInfo);
          }
          else if (AIOFileVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
          {
            localObject = a(localAIORichMediaInfo, paramInt, localGalleryImageStruct);
            break label746;
          }
        }
      }
      localObject = localGalleryImageStruct;
    }
    label746:
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
  
  public View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup)
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
    if (QLog.isColorLevel()) {
      QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): nani...");
    }
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
      paramView = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if ((paramView != null) && (paramView.getStatus() == 0)) {
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
    a(paramQQLiveDrawableParams.msgUniseq, paramQQLiveDrawableParams.mVideoTime * 1000L, paramLong);
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    if (!AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView)) {
      return;
    }
    paramView = ((AIOGalleryAdapter.GalleryImageStruct)paramView).a();
    if (!URLDrawable.class.isInstance(paramView)) {
      return;
    }
    ((URLDrawable)paramView).updateRegionBitmap(paramRegionDrawableData);
  }
  
  public void onSlot(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("AIOGalleryAdapter.onSlot(): position is ");
      paramView.append(paramInt);
      QLog.i(" AIOGalleryAdapter", 2, paramView.toString());
    }
    System.gc();
  }
  
  public void onStateChange(String paramString, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStateChange => ");
      localStringBuilder.append(QQLiveImage.getStateStr(paramInt));
      localStringBuilder.append(", msgUniseq=");
      localStringBuilder.append(paramQQLiveDrawableParams.msgUniseq);
      localStringBuilder.append(", extra = ");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(" mSelectImagView=");
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct == null) {
        paramString = "null";
      } else {
        paramString = "not null";
      }
      localStringBuilder.append(paramString);
      QLog.d(" AIOGalleryAdapter", 2, localStringBuilder.toString());
    }
    if (paramInt == 6)
    {
      a(paramQQLiveDrawableParams.msgUniseq, paramQQLiveDrawableParams.mVideoTime * 1000L, paramQQLiveDrawableParams.mVideoTime * 1000L);
      paramString = this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct;
      if (paramString != null) {
        paramString.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      new Handler(Looper.getMainLooper()).post(new AIOGalleryAdapter.1(this));
      return;
    }
    if (paramInt == 2) {
      new Handler(Looper.getMainLooper()).post(new AIOGalleryAdapter.2(this));
    }
  }
  
  public void onViewDetached(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramInt == this.jdField_c_of_type_Int)
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if ((paramViewGroup != null) && (paramViewGroup.getStatus() == 0)) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.jdField_c_of_type_Int = -1;
      if (QLog.isColorLevel())
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append("destory rawDrawable, position: ");
        paramViewGroup.append(paramInt);
        QLog.d(" AIOGalleryAdapter", 2, paramViewGroup.toString());
      }
    }
    if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView))
    {
      paramView = (AIOGalleryAdapter.GalleryImageStruct)paramView;
      paramViewGroup = a(paramInt);
      if (paramViewGroup == null) {
        return;
      }
      AIORichMediaData localAIORichMediaData = paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (AIOImageData.class.isInstance(localAIORichMediaData))
      {
        if (URLDrawable.class.isInstance(paramView.a())) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().a(paramViewGroup.hashCode());
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().a();
        return;
      }
      if (AIOShortVideoData.class.isInstance(localAIORichMediaData))
      {
        paramViewGroup = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        if (paramViewGroup != null)
        {
          paramView.setImageDrawable(paramViewGroup);
          if (QLog.isColorLevel()) {
            QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onViewDetached(): Use thumb cache replace video.");
          }
        }
        else
        {
          paramView.setImageDrawable(URLDrawableHelperConstants.a);
          if (QLog.isColorLevel()) {
            QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onViewDetached(): No thumb, use TRANSPARENT");
          }
        }
      }
    }
  }
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AIOGalleryAdapter.GalleryImageStruct localGalleryImageStruct = (AIOGalleryAdapter.GalleryImageStruct)paramView;
    paramView = localGalleryImageStruct.a();
    paramViewGroup = localGalleryImageStruct.a();
    if ((paramView instanceof URLDrawable))
    {
      URLDrawable localURLDrawable = (URLDrawable)paramView;
      if ((localURLDrawable.isFakeSize()) && (paramViewGroup == null))
      {
        paramView = localURLDrawable.getURL();
        if ((!"file".equals(paramView.getProtocol())) || (paramView.getRef() != null)) {
          break label307;
        }
        if (paramInt == this.jdField_c_of_type_Int)
        {
          paramViewGroup = this.jdField_a_of_type_ComTencentImageURLDrawable;
          if (paramViewGroup != null)
          {
            paramView = paramViewGroup;
            if (!QLog.isColorLevel()) {
              break label257;
            }
            paramView = paramViewGroup;
            if (this.jdField_a_of_type_ComTencentImageURLDrawable == null) {
              break label257;
            }
            QLog.d(" AIOGalleryAdapter", 2, "use exist raw drawable");
            paramView = paramViewGroup;
            break label257;
          }
        }
        if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentImageURLDrawable != null)) {
          QLog.d(" AIOGalleryAdapter", 2, "rawDrawable is exist");
        }
        paramViewGroup = new StringBuilder();
        paramViewGroup.append(paramView.toString());
        paramViewGroup.append("#");
        paramViewGroup.append("NOSAMPLE");
        paramView = paramViewGroup.toString();
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
          paramView = new StringBuilder();
          paramView.append("create rawDrawable, position:");
          paramView.append(paramInt);
          QLog.d(" AIOGalleryAdapter", 2, paramView.toString());
          paramView = paramViewGroup;
        }
        label257:
        if (paramView.getStatus() == 1)
        {
          localGalleryImageStruct.setIgnoreLayout(true);
          localGalleryImageStruct.setImageDrawable(paramView);
          localGalleryImageStruct.setIgnoreLayout(false);
          break label307;
        }
        localGalleryImageStruct.setDecodingDrawble(paramView);
        paramView.startDownload();
        break label307;
      }
    }
    if ((paramView instanceof SkinnableBitmapDrawable)) {
      return;
    }
    label307:
    paramView = a(paramInt);
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().b(paramView.hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */