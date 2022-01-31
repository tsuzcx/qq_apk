package com.tencent.mobileqq.activity.aio.photo;

import adzf;
import aegm;
import aegn;
import aegs;
import aeic;
import aeiy;
import aejb;
import aejk;
import aejn;
import agpc;
import agqs;
import agra;
import ajya;
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
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import anoz;
import apei;
import apvd;
import avwo;
import avwr;
import avwu;
import axqy;
import aywm;
import bbbt;
import bbdx;
import bbfj;
import bcql;
import bgky;
import bjal;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
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
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.AdapterView;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONObject;
import vei;
import vym;
import xpj;
import xpw;

public class AIOGalleryAdapter
  extends AbstractImageAdapter
  implements agpc, QQLiveDrawable.OnDownloadListener, QQLiveDrawable.OnLoopBackListener, QQLiveDrawable.OnStateListener
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = -1L;
  public aegm a;
  private aegn jdField_a_of_type_Aegn;
  aeic jdField_a_of_type_Aeic;
  aejb jdField_a_of_type_Aejb;
  agqs jdField_a_of_type_Agqs;
  private SparseArray<URLDrawable> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  public AIOGalleryActivity a;
  private AIOGalleryAdapter.GalleryImageStruct jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct;
  AIORichMediaData jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
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
  
  public AIOGalleryAdapter(Context paramContext, aejb paramaejb, boolean paramBoolean, int paramInt)
  {
    this.jdField_g_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity = ((AIOGalleryActivity)paramContext);
    this.jdField_a_of_type_Aejb = paramaejb;
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
    anoz localanoz = new anoz(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localanoz, localanoz);
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
    return localanoz;
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
            new avwu(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplication().getBaseContext()).a(bjal.a(), 2001, 0, i, str, this.jdField_a_of_type_Long / 1000L);
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
            paramURLDrawable.put("wifi_ssid", vym.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplicationContext()));
            paramURLDrawable.put("wifi_mac", vym.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplicationContext()));
            str = vei.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplicationContext());
            if (!paramBoolean) {
              continue;
            }
            i = 2;
            vei.a("story_grp", "play_video_js", 1003, i, new String[] { paramURLDrawable.toString(), "", str, "" });
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
        str = vei.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getApplicationContext());
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2;
        vei.a("story_grp", "play_video_js", 1003, paramInt, new String[] { paramURLDrawable.toString(), "", str, "" });
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
      localQQLiveDrawableParams.mCoverUrl = ShortVideoUtils.a(((File)localObject).getAbsolutePath()).toString();
      localObject = a(localQQLiveDrawableParams.mCoverUrl, paramAIOShortVideoData.jdField_c_of_type_Int, paramAIOShortVideoData.jdField_d_of_type_Int);
      if (!(localObject instanceof URLDrawable)) {
        break label257;
      }
    }
    label257:
    for (paramFile.mLoadingDrawable = ((URLDrawable)localObject).getCurrDrawable();; paramFile.mLoadingDrawable = ((Drawable)localObject))
    {
      paramFile.mExtraInfo = localQQLiveDrawableParams;
      paramFile = URLDrawable.getDrawable(adzf.a(paramAIOShortVideoData.jdField_a_of_type_Long), paramFile);
      paramGalleryImageStruct.setImageDrawable(paramFile);
      a(paramInt, true);
      this.jdField_b_of_type_ComTencentImageURLDrawable = paramFile;
      this.jdField_d_of_type_Int = paramInt;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_c_of_type_Long = (paramAIOShortVideoData.jdField_a_of_type_Int * 1000L);
      return;
    }
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (!bbbt.a().a(paramLong1, "0X8009AA6"))
    {
      bbbt.a().a(paramLong1, "0X8009AA6");
      ShortVideoUtils.a(null, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, 2, 2, paramLong2, paramLong3);
    }
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, View paramView)
  {
    this.jdField_a_of_type_Aejb.a(paramAIOShortVideoData.jdField_f_of_type_Long, paramAIOShortVideoData.jdField_f_of_type_Int, 1);
    ((ImageView)paramView.findViewById(2131371918)).setVisibility(8);
    if (this.jdField_a_of_type_Agqs != null) {
      this.jdField_a_of_type_Agqs.a(paramAIOShortVideoData, true, false);
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ImageView paramImageView, int paramInt3)
  {
    if (bbdx.b(paramString))
    {
      paramString = ShortVideoUtils.a(paramString);
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
  
  public void OnDownload(String paramString1, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, String paramString2)
  {
    new Handler(Looper.getMainLooper()).post(new AIOGalleryAdapter.3(this));
  }
  
  public aeiy a(int paramInt)
  {
    if (this.jdField_a_of_type_Aeic == null) {
      return null;
    }
    return this.jdField_a_of_type_Aeic.a(paramInt);
  }
  
  public agra a(AIOShortVideoData paramAIOShortVideoData)
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
        aejn localaejn = aejk.a().a(paramAIOShortVideoData.jdField_f_of_type_Long);
        if ((localaejn == null) || (!localaejn.a())) {
          break label345;
        }
        if (QLog.isColorLevel()) {
          QLog.d(" AIOGalleryAdapter", 2, "carverW getVideoPlayMedioInfo  hit cache");
        }
        localObject = new agra();
        ((agra)localObject).jdField_a_of_type_Boolean = true;
        ((agra)localObject).jdField_a_of_type_ArrayOfJavaLangString = localaejn.jdField_a_of_type_ArrayOfJavaLangString;
        ((agra)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = localaejn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
        ((agra)localObject).jdField_a_of_type_Int = localaejn.jdField_a_of_type_Int;
        ((agra)localObject).jdField_a_of_type_Long = paramAIOShortVideoData.jdField_f_of_type_Long;
        ((agra)localObject).jdField_b_of_type_Int = paramAIOShortVideoData.jdField_f_of_type_Int;
      }
      for (;;)
      {
        if ((localObject != null) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramAIOShortVideoData.jdField_f_of_type_Long))
        {
          ((agra)localObject).e = true;
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
        localObject = new agra();
        ((agra)localObject).jdField_a_of_type_Boolean = false;
        ((agra)localObject).jdField_a_of_type_Long = paramAIOShortVideoData.jdField_f_of_type_Long;
        ((agra)localObject).jdField_b_of_type_Int = paramAIOShortVideoData.jdField_f_of_type_Int;
        ((agra)localObject).jdField_a_of_type_JavaLangString = paramAIOShortVideoData.jdField_b_of_type_JavaLangString;
        ((agra)localObject).jdField_d_of_type_Long = l;
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
        if (!AIOImageData.class.isInstance(((aeiy)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          break;
        }
        localObject2 = (AIOImageData)((aeiy)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
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
    } while (!AIOShortVideoData.class.isInstance(((aeiy)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
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
    Object localObject2 = a(paramInt);
    if (localObject2 == null) {
      return;
    }
    Object localObject1;
    if ((paramView instanceof AIOGalleryAdapter.GalleryImageStruct))
    {
      paramView = (AIOGalleryAdapter.GalleryImageStruct)paramView;
      if (AIOImageData.class.isInstance(((aeiy)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        localObject1 = (AIOImageData)((aeiy)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if (paramString1 != null) {
          ((AIOImageData)localObject1).jdField_b_of_type_JavaLangString = paramString1;
        }
        if (paramString2 != null) {
          ((AIOImageData)localObject1).jdField_a_of_type_JavaLangString = paramString2;
        }
        if (((AIOImageData)localObject1).jdField_b_of_type_Boolean)
        {
          paramString1 = paramView.a();
          if (!URLDrawable.class.isInstance(paramString1)) {
            break label1500;
          }
          paramString1 = (URLDrawable)paramString1;
          paramString2 = paramString1.getURL().getRef();
        }
      }
    }
    for (;;)
    {
      if ((paramString1 == null) || (paramString2 == null) || ((!"PART".equals(paramString2)) && (!"DISPLAY".equals(paramString2))))
      {
        paramView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130837911));
        a(paramInt, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().d();
      }
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): IMAGE_FILE_ERROR");
      }
      if ((QLog.isDevelopLevel()) && (((AIOImageData)localObject1).jdField_d_of_type_Boolean)) {
        bcql.a(paramView.getContext(), "AIOGalleryAdapter.updateView(): error!", 2000).a();
      }
      label216:
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Aejb.a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
        return;
        paramString2 = ((AIOImageData)localObject1).a(2);
        if (paramString2 != null)
        {
          paramString1 = ((AIOImageData)localObject1).a(2);
          if (!paramBoolean) {
            break label1497;
          }
          paramString1 = paramString1 + "#PART";
        }
      }
      label1497:
      for (;;)
      {
        try
        {
          ((aeiy)localObject2).jdField_b_of_type_Int = JpegExifReader.readOrientation(paramString2.getAbsolutePath());
          if (QLog.isColorLevel()) {
            QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): read orientation:" + ((aeiy)localObject2).jdField_b_of_type_Int);
          }
          paramString2 = URLDrawable.URLDrawableOptions.obtain();
          if (((AIOImageData)localObject1).jdField_b_of_type_Int == 3)
          {
            localObject2 = ((AIOImageData)localObject1).a(1);
            if (localObject2 != null)
            {
              localObject2 = URLDrawable.getDrawable((File)localObject2, null);
              if (((URLDrawable)localObject2).getStatus() == 1)
              {
                paramString2.mLoadingDrawable = ((Drawable)localObject2);
                paramString2.mFailedDrawable = ((Drawable)localObject2);
              }
            }
          }
          paramString2.mUseExifOrientation = false;
          paramString2.mPlayGifImage = true;
          paramString2 = URLDrawable.getDrawable(paramString1, paramString2);
          if ((paramString2.getStatus() == 1) && (!((AIOImageData)localObject1).jdField_d_of_type_Boolean))
          {
            paramView.setImageDrawable(paramString2);
            a(paramInt, true);
            paramString2 = bbdx.b(((AIOImageData)localObject1).jdField_b_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): Update large image, position=" + paramInt + "url = " + paramString1 + ",extName = " + paramString2);
            }
            ((AIOImageData)localObject1).jdField_d_of_type_Boolean = paramBoolean;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().c();
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
          paramView.setDecodingDrawble(paramString2);
          continue;
        }
        if (((AIOImageData)localObject1).a(1) == null) {
          break label216;
        }
        paramView.setImageDrawable(URLDrawable.getDrawable(((AIOImageData)localObject1).a(1), URLDrawable.URLDrawableOptions.obtain()));
        break label216;
        if (AIOShortVideoData.class.isInstance(((aeiy)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          paramString2 = (AIOShortVideoData)((aeiy)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          if (paramString2.jdField_b_of_type_Int == 0) {
            break label216;
          }
          if (paramString2.jdField_b_of_type_Boolean)
          {
            paramView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130837911));
            a(paramInt, false);
            if (!QLog.isColorLevel()) {
              break label216;
            }
            QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): IMAGE_FILE_ERROR, position=" + paramInt);
            break label216;
          }
          paramString1 = paramString2.a(1);
          if (paramString1 != null)
          {
            paramString2 = URLDrawable.URLDrawableOptions.obtain();
            paramString2.mLoadingDrawable = aywm.b;
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
              QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): Update video, position=" + paramInt);
              break;
              paramView.setDecodingDrawble(paramString1);
              paramString1.startDownload();
            }
          }
          if ((paramString2.a(0) == null) || (!QLog.isColorLevel())) {
            break label216;
          }
          QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): thumb downloaded, position=" + paramInt);
          break label216;
        }
        if (AIOFilePicData.class.isInstance(((aeiy)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          localObject1 = (AIOFilePicData)((aeiy)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          if (((AIOFilePicData)localObject1).jdField_a_of_type_Boolean)
          {
            localObject1 = paramView.a();
            paramString2 = null;
            paramString1 = null;
            if (URLDrawable.class.isInstance(localObject1))
            {
              paramString2 = (URLDrawable)localObject1;
              paramString1 = paramString2.getURL().getRef();
            }
            if ((paramString1 == null) && (apvd.b(((AIOFilePicData)((aeiy)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString)))
            {
              paramString1 = URLDrawable.URLDrawableOptions.obtain();
              paramString1.mLoadingDrawable = aywm.a;
              paramString1.mFailedDrawable = aywm.a;
              paramString1 = URLDrawable.getDrawable(new File(((AIOFilePicData)((aeiy)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString), paramString1);
              if (paramString1 == null) {
                break label216;
              }
              paramView.setImageDrawable(paramString1);
              paramString1.downloadImediatly();
              break label216;
            }
            if ((paramString2 != null) && (paramString1 != null) && (("PART".equals(paramString1)) || ("DISPLAY".equals(paramString1)))) {
              break label216;
            }
            paramView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130837911));
            a(paramInt, false);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().d();
            if (((AIOFilePicData)((aeiy)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_a_of_type_Long < apei.c()) {
              break label216;
            }
            paramView.b();
            break label216;
          }
          localObject2 = ((AIOFilePicData)localObject1).a(18);
          if (localObject2 == null) {
            break label216;
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
            paramString2 = bbdx.b(((AIOFilePicData)localObject1).jdField_c_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): Update large image, position=" + paramInt + "url = " + paramString1 + ",extName = " + paramString2);
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().c();
            break;
            paramString2.setTag(Integer.valueOf(1));
            paramString2.startDownload();
            paramView.setDecodingDrawble(paramString2);
          }
        }
        if (!AIOFileVideoData.class.isInstance(((aeiy)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          break label216;
        }
        paramString2 = (AIOFileVideoData)((aeiy)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
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
        paramView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130837911));
        a(paramInt, true);
        break label216;
        break;
        if ((!(paramView instanceof RelativeLayout)) || (!AIOShortVideoData.class.isInstance(((aeiy)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
          break;
        }
        paramString1 = (AIOShortVideoData)((aeiy)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if (paramString1.jdField_b_of_type_Int != 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(" AIOGalleryAdapter", 2, " updateView loadShortVideoCover");
        }
        paramString2 = (URLImageView)paramView.findViewById(2131371919);
        a(paramString1.jdField_a_of_type_JavaLangString, paramString1.jdField_c_of_type_Int, paramString1.jdField_d_of_type_Int, paramString2, paramInt);
        return;
      }
      label1500:
      paramString2 = null;
      paramString1 = null;
    }
  }
  
  public void a(aegn paramaegn)
  {
    this.jdField_a_of_type_Aegn = paramaegn;
  }
  
  public void a(agqs paramagqs)
  {
    this.jdField_a_of_type_Agqs = paramagqs;
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
  
  public void a(URLDrawable paramURLDrawable, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramURLDrawable);
    }
  }
  
  public void a(AIORichMediaData paramAIORichMediaData)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData = paramAIORichMediaData;
    this.jdField_d_of_type_Long = paramAIORichMediaData.jdField_f_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long = paramAIORichMediaData.jdField_f_of_type_Long;
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1 = a(paramInt);
    if (QLog.isColorLevel())
    {
      QLog.d(" AIOGalleryAdapter", 2, "onItemSelected isShortVideoAutoPlay=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_c_of_type_Boolean + " hasDoneItemSelectUid=" + this.jdField_d_of_type_Long + " mContext.entryId=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long);
      QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP call onItemSelected ");
    }
    if ((localObject1 != null) && (((aeiy)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (((aeiy)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long))
    {
      QLog.d(" AIOGalleryAdapter", 2, "onItemSelected not first image.mData.id=" + ((aeiy)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long + " entryId=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long = -1L;
    }
    Object localObject2;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (localObject1 != null) && (((aeiy)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != ((aeiy)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long))
    {
      this.jdField_a_of_type_Boolean = false;
      localObject2 = (aegs)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Xpw.a();
      if (localObject2 != null) {
        ((aegs)localObject2).q = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d(" AIOGalleryAdapter", 2, "onItemSelected, set mIsmute false,  mDataOfBubble.id = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long + ", image.mData.id + " + ((aeiy)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
      }
    }
    label704:
    int i;
    if ((localObject1 != null) && ((AIOShortVideoData.class.isInstance(((aeiy)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) || (AIOFileVideoData.class.isInstance(((aeiy)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))))
    {
      ((AudioManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getSystemService("audio")).requestAudioFocus(null, 3, 2);
      if ((paramView == null) || (!AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView))) {
        break label1001;
      }
      this.jdField_d_of_type_Long = -1L;
      if ((this.jdField_d_of_type_Int != paramInt) && (this.jdField_b_of_type_ComTencentImageURLDrawable != null))
      {
        a(this.jdField_d_of_type_Int, this.jdField_b_of_type_ComTencentImageURLDrawable, false);
        if ((this.jdField_b_of_type_ComTencentImageURLDrawable.getStatus() == 1) && ((this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable)))
        {
          localObject2 = (QQLiveDrawable)this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable();
          if (((QQLiveDrawable)localObject2).getCurrentPosition() > 0L)
          {
            Object localObject3 = a(this.jdField_d_of_type_Int);
            if ((localObject3 != null) && (((aeiy)localObject3).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && ((((aeiy)localObject3).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)))
            {
              localObject3 = (AIOShortVideoData)((aeiy)localObject3).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
              a(((AIOShortVideoData)localObject3).jdField_a_of_type_Long, ((AIOShortVideoData)localObject3).jdField_a_of_type_Int * 1000, ((QQLiveDrawable)localObject2).getCurrentPosition());
            }
          }
          ((QQLiveDrawable)localObject2).recyleAndNotKeepPosition();
          if (QLog.isColorLevel()) {
            QLog.i(" AIOGalleryAdapter", 2, "onItemSelected recyleAndNotKeepPosition =" + localObject2 + " mVideoDrawable set null");
          }
          this.jdField_b_of_type_ComTencentImageURLDrawable = null;
        }
      }
      if ((localObject1 == null) || (!AIOShortVideoData.class.isInstance(((aeiy)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
        break label897;
      }
      localObject1 = (AIOShortVideoData)((aeiy)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct = ((AIOGalleryAdapter.GalleryImageStruct)paramView);
      this.jdField_g_of_type_Int = 0;
      if (this.jdField_d_of_type_Int == -1) {
        axqy.b(null, "dc00898", "", "", "0X8007424", "0X8007424", 0, 0, "", "", "", "");
      }
      if ((paramAdapterView != null) && (paramAdapterView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent() != null))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent();
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent().getBooleanExtra("extra.FROM_AIO", false)) {
          break label854;
        }
        paramAdapterView = "1";
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent().getIntExtra("forward_source_uin_type", -1);
        paramView = paramView.getStringExtra("leftViewText");
        if (paramView == null) {
          break label1781;
        }
        if (!paramView.equals(ajya.a(2131700071))) {
          break label861;
        }
        paramAdapterView = "2";
      }
    }
    label748:
    label1268:
    label1781:
    for (;;)
    {
      ShortVideoUtils.a(bjal.a().getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getIntent().getStringExtra("uin"), String.valueOf(((AIOShortVideoData)localObject1).jdField_a_of_type_Int * 1000), i, "2", paramAdapterView);
      paramAdapterView = (aegs)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Xpw.a();
      if ((paramAdapterView != null) && (paramAdapterView.s))
      {
        paramAdapterView.s = false;
        if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct != null) {
          this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct.b(paramInt);
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
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return;
                            ((AudioManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getSystemService("audio")).abandonAudioFocus(null);
                            break;
                            paramAdapterView = "3";
                            break label704;
                            if ((i != 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Xpw == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Xpw.a == null)) {
                              break label1781;
                            }
                            paramAdapterView = "3";
                            break label748;
                            if ((localObject1 == null) || (!AIOImageData.class.isInstance(((aeiy)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
                              break label975;
                            }
                            paramAdapterView = (AIOImageData)((aeiy)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
                          } while ((paramAdapterView.jdField_b_of_type_Int != 3) || (paramAdapterView.a(1) != null) || (paramAdapterView.a(2) != null) || (paramAdapterView.a(4) != null) || (paramAdapterView.jdField_h_of_type_Long >= apei.c()));
                          a(paramInt, -1);
                          return;
                          this.jdField_d_of_type_Int = -1;
                          this.jdField_b_of_type_ComTencentImageURLDrawable = null;
                        } while (!QLog.isColorLevel());
                        QLog.i(" AIOGalleryAdapter", 2, " onItemSelected():else Data is mVideoDrawable set null");
                        return;
                      } while ((paramView == null) || (!(paramView instanceof RelativeLayout)));
                      this.jdField_g_of_type_Int = 1;
                      a(this.jdField_d_of_type_Int, this.jdField_b_of_type_ComTencentImageURLDrawable, false);
                      if ((this.jdField_b_of_type_ComTencentImageURLDrawable != null) && (this.jdField_b_of_type_ComTencentImageURLDrawable.getStatus() == 1) && ((this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable)))
                      {
                        paramAdapterView = (QQLiveDrawable)this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable();
                        if (paramAdapterView.getCurrentPosition() > 0L)
                        {
                          localObject2 = a(this.jdField_d_of_type_Int);
                          if ((localObject2 != null) && (((aeiy)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && ((((aeiy)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)))
                          {
                            localObject2 = (AIOShortVideoData)((aeiy)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
                            a(((AIOShortVideoData)localObject2).jdField_a_of_type_Long, ((AIOShortVideoData)localObject2).jdField_a_of_type_Int * 1000, paramAdapterView.getCurrentPosition());
                          }
                        }
                        paramAdapterView.recyleAndNotKeepPosition();
                        if (QLog.isColorLevel()) {
                          QLog.i(" AIOGalleryAdapter", 2, " recyleAndNotKeepPosition ");
                        }
                        this.jdField_b_of_type_ComTencentImageURLDrawable = null;
                      }
                      if ((localObject1 == null) || (!AIOShortVideoData.class.isInstance(((aeiy)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
                        break label1345;
                      }
                      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean = true;
                      paramAdapterView = (AIOShortVideoData)((aeiy)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
                    } while ((paramAdapterView == null) || (paramAdapterView.jdField_b_of_type_Int != 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Long == paramAdapterView.jdField_f_of_type_Long));
                    localObject1 = a(paramAdapterView);
                    if (localObject1 != null) {
                      break label1268;
                    }
                    a(paramAdapterView, paramView);
                  } while (!QLog.isColorLevel());
                  QLog.i(" AIOGalleryAdapter", 2, "onItemSelect undownload notequal");
                  return;
                } while (this.jdField_a_of_type_Agqs == null);
                this.jdField_a_of_type_Agqs.a(paramView, (agra)localObject1);
                paramAdapterView = (aegs)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Xpw.a();
              } while ((paramAdapterView == null) || (!paramAdapterView.s));
              if (QLog.isColorLevel()) {
                QLog.i(" AIOGalleryAdapter", 2, "onItemSelect from nine");
              }
              paramAdapterView.s = false;
              this.jdField_a_of_type_Agqs.f();
              this.jdField_d_of_type_Long = -1L;
              return;
              if ((localObject1 == null) || (!AIOFileVideoData.class.isInstance(((aeiy)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
                break label1726;
              }
              if (QLog.isColorLevel()) {
                QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP onItemSelected is FileVideodata ");
              }
              localObject2 = (AIOFileVideoData)((aeiy)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
              if (((aeiy)localObject1).jdField_d_of_type_Boolean) {
                ((AIOFileVideoData)localObject2).e = true;
              }
              if (!((AIOFileVideoData)localObject2).a(this.jdField_a_of_type_Aejb)) {
                break label1448;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean) {
                this.jdField_d_of_type_Long = -1L;
              }
            } while (!QLog.isColorLevel());
            QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP onItemSelected needUrl return ");
            return;
            paramAdapterView = (aegs)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Xpw.a();
            if ((paramAdapterView != null) && (paramAdapterView.k == 3)) {}
            for (paramInt = 1;; paramInt = 0)
            {
              if ((!((aeiy)localObject1).jdField_d_of_type_Boolean) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean) && (paramInt == 0))) {
                break label1646;
              }
              if ((paramInt == 0) && ((this.jdField_d_of_type_Long == -1L) || (this.jdField_d_of_type_Long != ((AIOFileVideoData)localObject2).jdField_f_of_type_Long))) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean = true;
              this.jdField_d_of_type_Long = -1L;
              ((AIOFileVideoData)localObject2).e = true;
              localObject1 = ((AIOFileVideoData)localObject2).a(this.jdField_a_of_type_Boolean);
              this.jdField_a_of_type_Agqs.a(paramView, (agra)localObject1);
              this.jdField_a_of_type_Agqs.b();
              this.jdField_a_of_type_Agqs.f();
              this.jdField_a_of_type_Agqs.b(8);
              if (paramAdapterView != null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(" AIOGalleryAdapter", 2, "FileVideo_AP onItemSelected, aioGalleryScene.mIsMute =  " + paramAdapterView.q);
                }
                paramAdapterView.q = false;
              }
              this.jdField_a_of_type_Boolean = false;
              return;
            }
          } while ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_d_of_type_Boolean) || ((paramInt == 0) && ((this.jdField_d_of_type_Long == -1L) || (this.jdField_d_of_type_Long != ((AIOFileVideoData)localObject2).jdField_f_of_type_Long))));
          this.jdField_d_of_type_Long = -1L;
          paramAdapterView = ((AIOFileVideoData)localObject2).a(this.jdField_a_of_type_Boolean);
          this.jdField_a_of_type_Agqs.a(paramView, paramAdapterView);
        } while (!QLog.isColorLevel());
        QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP onItemSelected need user click ");
        return;
      } while (!QLog.isColorLevel());
      if (localObject1 != null)
      {
        QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP unsupport type :" + localObject1.getClass().getSimpleName());
        return;
      }
      QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP unsupport type, image null!");
      return;
    }
  }
  
  public void a(xpj paramxpj)
  {
    super.a(paramxpj);
    this.jdField_a_of_type_Aeic = ((aeic)paramxpj);
    b();
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
    agra localagra = a(paramAIOShortVideoData);
    this.jdField_d_of_type_Long = paramAIOShortVideoData.jdField_a_of_type_Long;
    if (localagra == null)
    {
      a(paramAIOShortVideoData, paramView);
      return false;
    }
    if (this.jdField_a_of_type_Agqs != null) {
      this.jdField_a_of_type_Agqs.a(paramView, localagra);
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
            if (!AIOImageData.class.isInstance(((aeiy)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
              break;
            }
          } while (((AIOImageData)((aeiy)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_d_of_type_Boolean);
          super.b(paramInt1, paramInt2);
          return;
        } while (AIOShortVideoData.class.isInstance(((aeiy)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
        if (AIOFilePicData.class.isInstance(((aeiy)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          super.b(paramInt1, paramInt2);
          return;
        }
      } while (!AIOFileVideoData.class.isInstance(((aeiy)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
      localAIOFileVideoData = (AIOFileVideoData)((aeiy)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    } while (!localAIOFileVideoData.jdField_d_of_type_Boolean);
    localAIOFileVideoData.jdField_c_of_type_Long = paramInt2;
    aegs localaegs = (aegs)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Xpw.a();
    float f1 = (float)(paramInt2 * 100) / 10000.0F;
    if (localAIOFileVideoData.jdField_d_of_type_Boolean) {}
    for (localObject = ajya.a(2131700072) + apvd.a(((float)localAIOFileVideoData.jdField_h_of_type_Long * f1)) + "/" + apvd.a(localAIOFileVideoData.jdField_h_of_type_Long) + ")";; localObject = ajya.a(2131700030) + apvd.a(((float)localAIOFileVideoData.jdField_h_of_type_Long * f1)) + "/" + apvd.a(localAIOFileVideoData.jdField_h_of_type_Long) + ")")
    {
      localaegs.a(localAIOFileVideoData.jdField_f_of_type_Long, f1, (String)localObject);
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
        if ((localObject != null) && (((aeiy)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && ((((aeiy)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)))
        {
          localObject = (AIOShortVideoData)((aeiy)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          a(((AIOShortVideoData)localObject).jdField_a_of_type_Long, ((AIOShortVideoData)localObject).jdField_a_of_type_Int * 1000, localQQLiveDrawable.getCurrentPosition());
        }
      }
    }
    bbbt.a().a();
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
    while ((this.jdField_g_of_type_Int != 1) || (this.jdField_a_of_type_Agqs == null) || (!this.jdField_a_of_type_Agqs.c())) {
      return;
    }
    this.jdField_a_of_type_Agqs.h();
  }
  
  /* Error */
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +5 -> 6
    //   4: aload_2
    //   5: areturn
    //   6: new 441	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct
    //   9: dup
    //   10: aload_0
    //   11: aload_0
    //   12: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   15: iconst_0
    //   16: invokespecial 1076	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:<init>	(Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter;Landroid/content/Context;I)V
    //   19: astore 8
    //   21: aload 8
    //   23: iconst_1
    //   24: invokevirtual 1079	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setAdjustViewBounds	(Z)V
    //   27: aload_0
    //   28: iload_1
    //   29: invokevirtual 644	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(I)Laeiy;
    //   32: astore 9
    //   34: aload 9
    //   36: ifnull +11 -> 47
    //   39: aload 9
    //   41: getfield 649	aeiy:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   44: ifnonnull +594 -> 638
    //   47: ldc 171
    //   49: iconst_2
    //   50: new 173	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   57: ldc_w 1081
    //   60: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: iload_1
    //   64: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: ldc_w 1083
    //   70: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 1085	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: aload 8
    //   81: astore_2
    //   82: aload 9
    //   84: ifnull -80 -> 4
    //   87: aload 8
    //   89: astore_2
    //   90: aload 9
    //   92: getfield 649	aeiy:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   95: ifnull -91 -> 4
    //   98: ldc_w 646
    //   101: aload 9
    //   103: getfield 649	aeiy:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   106: invokevirtual 221	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   109: ifeq +2429 -> 2538
    //   112: aload 9
    //   114: getfield 649	aeiy:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   117: checkcast 646	com/tencent/mobileqq/activity/aio/photo/AIOImageData
    //   120: astore_2
    //   121: aload_0
    //   122: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   125: iconst_1
    //   126: putfield 969	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_d_of_type_Boolean	Z
    //   129: aload_0
    //   130: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   133: getfield 857	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_c_of_type_Boolean	Z
    //   136: ifeq +638 -> 774
    //   139: aload_0
    //   140: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   143: iconst_0
    //   144: putfield 857	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_c_of_type_Boolean	Z
    //   147: aload_2
    //   148: getfield 1086	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_g_of_type_Int	I
    //   151: iconst_1
    //   152: if_icmpne +586 -> 738
    //   155: aload_2
    //   156: getfield 1088	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_h_of_type_Boolean	Z
    //   159: ifeq +579 -> 738
    //   162: aconst_null
    //   163: ldc_w 910
    //   166: ldc_w 277
    //   169: ldc_w 277
    //   172: ldc_w 1090
    //   175: ldc_w 1090
    //   178: iconst_1
    //   179: iconst_0
    //   180: ldc_w 277
    //   183: ldc_w 277
    //   186: ldc_w 277
    //   189: ldc_w 277
    //   192: invokestatic 917	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   195: aload 8
    //   197: bipush 8
    //   199: invokevirtual 1093	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setCenterBtnVisiable	(I)V
    //   202: aload 9
    //   204: getfield 649	aeiy:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   207: checkcast 646	com/tencent/mobileqq/activity/aio/photo/AIOImageData
    //   210: astore 10
    //   212: aload 8
    //   214: iload_1
    //   215: invokevirtual 1096	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setPosition	(I)V
    //   218: aload 8
    //   220: aload 9
    //   222: invokevirtual 1100	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageInfo	(Laeiy;)V
    //   225: aload 8
    //   227: iconst_0
    //   228: invokevirtual 1103	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setIgnoreLayout	(Z)V
    //   231: aload 8
    //   233: aload 10
    //   235: getfield 1105	com/tencent/mobileqq/activity/aio/photo/AIOImageData:i	Ljava/lang/String;
    //   238: invokevirtual 1107	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:a	(Ljava/lang/String;)V
    //   241: iconst_0
    //   242: istore 4
    //   244: aconst_null
    //   245: astore_2
    //   246: aload_0
    //   247: getfield 48	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   250: iload_1
    //   251: invokevirtual 850	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   254: checkcast 152	com/tencent/image/URLDrawable
    //   257: astore_3
    //   258: aload_3
    //   259: ifnull +644 -> 903
    //   262: aload_3
    //   263: invokevirtual 160	com/tencent/image/URLDrawable:getStatus	()I
    //   266: iconst_1
    //   267: if_icmpne +636 -> 903
    //   270: aload 8
    //   272: aload_3
    //   273: invokevirtual 445	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   276: aload 10
    //   278: iconst_4
    //   279: invokevirtual 655	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/lang/String;
    //   282: astore_2
    //   283: aload_3
    //   284: invokevirtual 697	com/tencent/image/URLDrawable:getURL	()Ljava/net/URL;
    //   287: invokevirtual 418	java/net/URL:toString	()Ljava/lang/String;
    //   290: astore 7
    //   292: aload 7
    //   294: aload_2
    //   295: invokevirtual 705	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   298: ifeq +9 -> 307
    //   301: aload 8
    //   303: iconst_1
    //   304: invokevirtual 1110	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setOriginalImage	(Z)V
    //   307: aload 9
    //   309: getfield 749	aeiy:jdField_b_of_type_Int	I
    //   312: bipush 254
    //   314: if_icmpne +18 -> 332
    //   317: aload 9
    //   319: aload_3
    //   320: invokevirtual 697	com/tencent/image/URLDrawable:getURL	()Ljava/net/URL;
    //   323: invokevirtual 1113	java/net/URL:getFile	()Ljava/lang/String;
    //   326: invokestatic 748	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   329: putfield 749	aeiy:jdField_b_of_type_Int	I
    //   332: aload 8
    //   334: aload_3
    //   335: aload 9
    //   337: getfield 749	aeiy:jdField_b_of_type_Int	I
    //   340: invokestatic 1116	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(Landroid/view/View;Lcom/tencent/image/URLDrawable;I)V
    //   343: aload 8
    //   345: invokevirtual 1117	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:a	()Z
    //   348: ifeq +539 -> 887
    //   351: aload 10
    //   353: getfield 1118	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   356: astore_2
    //   357: aload_2
    //   358: invokestatic 757	bbdx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   361: astore_2
    //   362: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   365: ifeq +61 -> 426
    //   368: ldc 171
    //   370: iconst_2
    //   371: new 173	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   378: ldc_w 1120
    //   381: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload 7
    //   386: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: ldc_w 1122
    //   392: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload 10
    //   397: aload_3
    //   398: invokevirtual 697	com/tencent/image/URLDrawable:getURL	()Ljava/net/URL;
    //   401: invokevirtual 1113	java/net/URL:getFile	()Ljava/lang/String;
    //   404: invokevirtual 1124	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(Ljava/lang/String;)I
    //   407: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   410: ldc_w 1126
    //   413: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload_2
    //   417: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokestatic 327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   426: aload 10
    //   428: getfield 724	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_d_of_type_Boolean	Z
    //   431: ifeq +23 -> 454
    //   434: aload_0
    //   435: getfield 77	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Aejb	Laejb;
    //   438: aload 10
    //   440: getfield 1127	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Long	J
    //   443: aload 10
    //   445: getfield 1128	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Int	I
    //   448: iconst_2
    //   449: invokeinterface 477 5 0
    //   454: aload 8
    //   456: invokevirtual 1117	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:a	()Z
    //   459: ifeq +437 -> 896
    //   462: ldc_w 1130
    //   465: astore_2
    //   466: iconst_1
    //   467: istore 4
    //   469: iconst_1
    //   470: istore_1
    //   471: iload_1
    //   472: ifeq +88 -> 560
    //   475: aload 9
    //   477: invokevirtual 1133	java/lang/Object:hashCode	()I
    //   480: istore_1
    //   481: aload_0
    //   482: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   485: iload_1
    //   486: putfield 1134	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Int	I
    //   489: aload_0
    //   490: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   493: invokevirtual 1137	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:a	()Lavwo;
    //   496: astore_3
    //   497: aload_3
    //   498: iload_1
    //   499: invokevirtual 1140	avwo:a	(I)V
    //   502: aload_3
    //   503: iload_1
    //   504: aload 10
    //   506: getfield 1141	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_a_of_type_Long	J
    //   509: aload 10
    //   511: getfield 1142	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_Long	J
    //   514: invokevirtual 1145	avwo:a	(IJJ)V
    //   517: aload_3
    //   518: iload_1
    //   519: aload 10
    //   521: getfield 1146	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_a_of_type_Int	I
    //   524: invokestatic 1151	bgky:a	(I)Z
    //   527: invokevirtual 1153	avwo:b	(IZ)V
    //   530: aload 10
    //   532: getfield 1154	com/tencent/mobileqq/activity/aio/photo/AIOImageData:e	Z
    //   535: ifeq +8 -> 543
    //   538: aload_3
    //   539: iload_1
    //   540: invokevirtual 1156	avwo:d	(I)V
    //   543: aload_2
    //   544: ifnull +16 -> 560
    //   547: aload_3
    //   548: iload_1
    //   549: aload_2
    //   550: invokevirtual 1159	avwo:a	(ILjava/lang/String;)V
    //   553: aload_3
    //   554: iload_1
    //   555: iload 4
    //   557: invokevirtual 1160	avwo:a	(IZ)V
    //   560: new 173	java/lang/StringBuilder
    //   563: dup
    //   564: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   567: aload 10
    //   569: getfield 1127	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Long	J
    //   572: invokevirtual 275	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   575: ldc_w 1162
    //   578: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: aload 10
    //   583: getfield 1128	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Int	I
    //   586: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   589: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: astore_3
    //   593: aload 8
    //   595: astore_2
    //   596: aload_0
    //   597: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   600: aload_3
    //   601: invokevirtual 1165	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   604: ifne -600 -> 4
    //   607: aload_0
    //   608: getfield 77	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Aejb	Laejb;
    //   611: aload 10
    //   613: getfield 1127	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Long	J
    //   616: aload 10
    //   618: getfield 1128	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Int	I
    //   621: invokeinterface 1168 4 0
    //   626: aload_0
    //   627: getfield 59	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   630: aload_3
    //   631: invokevirtual 1171	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   634: pop
    //   635: aload 8
    //   637: areturn
    //   638: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   641: ifeq -562 -> 79
    //   644: ldc 171
    //   646: iconst_2
    //   647: new 173	java/lang/StringBuilder
    //   650: dup
    //   651: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   654: ldc_w 1081
    //   657: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: iload_1
    //   661: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   664: ldc_w 1173
    //   667: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: aload 9
    //   672: getfield 649	aeiy:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   675: getfield 597	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData:jdField_f_of_type_Long	J
    //   678: invokevirtual 275	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   681: ldc_w 1175
    //   684: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: aload_0
    //   688: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   691: getfield 857	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_c_of_type_Boolean	Z
    //   694: invokevirtual 560	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   697: ldc_w 1177
    //   700: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: aload_0
    //   704: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   707: getfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   710: invokevirtual 560	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   713: ldc_w 1179
    //   716: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: aload_0
    //   720: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   723: getfield 852	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Long	J
    //   726: invokevirtual 275	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   729: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   732: invokestatic 327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   735: goto -656 -> 79
    //   738: aconst_null
    //   739: ldc_w 910
    //   742: ldc_w 277
    //   745: ldc_w 277
    //   748: ldc_w 1181
    //   751: ldc_w 1181
    //   754: iconst_1
    //   755: iconst_0
    //   756: ldc_w 277
    //   759: ldc_w 277
    //   762: ldc_w 277
    //   765: ldc_w 277
    //   768: invokestatic 917	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   771: goto -576 -> 195
    //   774: aload_2
    //   775: getfield 1086	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_g_of_type_Int	I
    //   778: iconst_1
    //   779: if_icmpne +46 -> 825
    //   782: aload_2
    //   783: getfield 1088	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_h_of_type_Boolean	Z
    //   786: ifeq +39 -> 825
    //   789: aconst_null
    //   790: ldc_w 910
    //   793: ldc_w 277
    //   796: ldc_w 277
    //   799: ldc_w 1090
    //   802: ldc_w 1090
    //   805: iconst_2
    //   806: iconst_0
    //   807: ldc_w 277
    //   810: ldc_w 277
    //   813: ldc_w 277
    //   816: ldc_w 277
    //   819: invokestatic 917	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   822: goto -627 -> 195
    //   825: aconst_null
    //   826: ldc_w 910
    //   829: ldc_w 277
    //   832: ldc_w 277
    //   835: ldc_w 1181
    //   838: ldc_w 1181
    //   841: iconst_2
    //   842: iconst_0
    //   843: ldc_w 277
    //   846: ldc_w 277
    //   849: ldc_w 277
    //   852: ldc_w 277
    //   855: invokestatic 917	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   858: goto -663 -> 195
    //   861: astore_2
    //   862: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   865: ifeq +13 -> 878
    //   868: ldc 171
    //   870: iconst_2
    //   871: ldc_w 767
    //   874: aload_2
    //   875: invokestatic 187	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   878: aload 9
    //   880: iconst_1
    //   881: putfield 749	aeiy:jdField_b_of_type_Int	I
    //   884: goto -552 -> 332
    //   887: aload 10
    //   889: getfield 691	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   892: astore_2
    //   893: goto -536 -> 357
    //   896: ldc_w 1183
    //   899: astore_2
    //   900: goto -434 -> 466
    //   903: aload 10
    //   905: iconst_4
    //   906: invokevirtual 650	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/io/File;
    //   909: astore 7
    //   911: aload 7
    //   913: ifnonnull +4200 -> 5113
    //   916: aload 10
    //   918: iconst_2
    //   919: invokevirtual 650	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/io/File;
    //   922: astore_3
    //   923: aload_3
    //   924: ifnull +703 -> 1627
    //   927: aload 7
    //   929: ifnull +449 -> 1378
    //   932: iconst_1
    //   933: istore 5
    //   935: invokestatic 406	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   938: astore 7
    //   940: aload 7
    //   942: aload_0
    //   943: getfield 96	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:e	I
    //   946: putfield 1186	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   949: aload 7
    //   951: aload_0
    //   952: getfield 101	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_f_of_type_Int	I
    //   955: putfield 1189	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   958: aload 7
    //   960: getstatic 813	aywm:a	Landroid/graphics/drawable/Drawable;
    //   963: putfield 427	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   966: aload 7
    //   968: iconst_1
    //   969: putfield 665	com/tencent/image/URLDrawable$URLDrawableOptions:mPlayGifImage	Z
    //   972: aload 7
    //   974: iconst_0
    //   975: putfield 668	com/tencent/image/URLDrawable$URLDrawableOptions:mUseExifOrientation	Z
    //   978: aload 7
    //   980: iconst_2
    //   981: putfield 1192	com/tencent/image/URLDrawable$URLDrawableOptions:mDecodeFileStrategy	I
    //   984: aload 10
    //   986: getfield 752	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_Int	I
    //   989: iconst_1
    //   990: if_icmpne +20 -> 1010
    //   993: aload 10
    //   995: getfield 1193	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_d_of_type_Int	I
    //   998: iconst_2
    //   999: iand
    //   1000: iconst_2
    //   1001: if_icmpne +9 -> 1010
    //   1004: aload 7
    //   1006: iconst_0
    //   1007: putfield 1196	com/tencent/image/URLDrawable$URLDrawableOptions:mUseAutoScaleParams	Z
    //   1010: aload_0
    //   1011: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   1014: getfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   1017: ifeq +45 -> 1062
    //   1020: aload_0
    //   1021: getfield 1198	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   1024: ifnull +360 -> 1384
    //   1027: aload 7
    //   1029: aload_0
    //   1030: getfield 1198	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   1033: invokevirtual 687	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:a	()Landroid/graphics/drawable/Drawable;
    //   1036: putfield 427	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   1039: aload 8
    //   1041: ldc_w 1199
    //   1044: aload_0
    //   1045: getfield 1198	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   1048: ldc_w 1199
    //   1051: invokevirtual 1202	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:getTag	(I)Ljava/lang/Object;
    //   1054: invokevirtual 1204	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setTag	(ILjava/lang/Object;)V
    //   1057: aload_0
    //   1058: aconst_null
    //   1059: putfield 1198	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   1062: iload 5
    //   1064: ifne +371 -> 1435
    //   1067: aload 10
    //   1069: getfield 724	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_d_of_type_Boolean	Z
    //   1072: ifeq +363 -> 1435
    //   1075: new 173	java/lang/StringBuilder
    //   1078: dup
    //   1079: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   1082: aload 10
    //   1084: iconst_2
    //   1085: invokevirtual 655	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/lang/String;
    //   1088: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: ldc_w 657
    //   1094: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1097: ldc_w 702
    //   1100: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1106: aload 7
    //   1108: invokestatic 439	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   1111: astore 7
    //   1113: aload 7
    //   1115: iconst_1
    //   1116: invokestatic 772	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1119: invokevirtual 776	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   1122: aload_0
    //   1123: getfield 48	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   1126: iload_1
    //   1127: aload 7
    //   1129: invokevirtual 506	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1132: aload 7
    //   1134: invokevirtual 1207	com/tencent/image/URLDrawable:isDownloadStarted	()Z
    //   1137: ifeq +32 -> 1169
    //   1140: getstatic 1211	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   1143: aload 7
    //   1145: invokevirtual 697	com/tencent/image/URLDrawable:getURL	()Ljava/net/URL;
    //   1148: invokevirtual 418	java/net/URL:toString	()Ljava/lang/String;
    //   1151: invokevirtual 1216	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1154: ifnull +314 -> 1468
    //   1157: iconst_1
    //   1158: istore 4
    //   1160: iload 5
    //   1162: ifeq +312 -> 1474
    //   1165: ldc_w 1130
    //   1168: astore_2
    //   1169: aload 7
    //   1171: invokevirtual 160	com/tencent/image/URLDrawable:getStatus	()I
    //   1174: tableswitch	default:+26 -> 1200, 1:+307->1481, 2:+341->1515, 3:+341->1515
    //   1201: iconst_5
    //   1202: aload 7
    //   1204: invokevirtual 445	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1207: aload 8
    //   1209: iload 5
    //   1211: invokevirtual 1110	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setOriginalImage	(Z)V
    //   1214: aload_0
    //   1215: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   1218: getfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   1221: ifne +8 -> 1229
    //   1224: aload 7
    //   1226: invokevirtual 163	com/tencent/image/URLDrawable:downloadImediatly	()V
    //   1229: iload 5
    //   1231: ifeq +346 -> 1577
    //   1234: aload 10
    //   1236: getfield 1118	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1239: astore_3
    //   1240: aload_3
    //   1241: invokestatic 757	bbdx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1244: astore_3
    //   1245: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1248: ifeq +68 -> 1316
    //   1251: ldc 171
    //   1253: iconst_2
    //   1254: new 173	java/lang/StringBuilder
    //   1257: dup
    //   1258: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   1261: ldc_w 1218
    //   1264: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: aload 7
    //   1269: invokevirtual 697	com/tencent/image/URLDrawable:getURL	()Ljava/net/URL;
    //   1272: invokevirtual 418	java/net/URL:toString	()Ljava/lang/String;
    //   1275: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1278: ldc_w 1220
    //   1281: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: aload 10
    //   1286: aload 7
    //   1288: invokevirtual 697	com/tencent/image/URLDrawable:getURL	()Ljava/net/URL;
    //   1291: invokevirtual 418	java/net/URL:toString	()Ljava/lang/String;
    //   1294: invokevirtual 1124	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(Ljava/lang/String;)I
    //   1297: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1300: ldc_w 763
    //   1303: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: aload_3
    //   1307: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1310: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1313: invokestatic 327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1316: iload 5
    //   1318: ifne +268 -> 1586
    //   1321: aload 10
    //   1323: getfield 724	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_d_of_type_Boolean	Z
    //   1326: ifeq +260 -> 1586
    //   1329: aload 10
    //   1331: getfield 693	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_Boolean	Z
    //   1334: ifne +252 -> 1586
    //   1337: aload_0
    //   1338: getfield 77	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Aejb	Laejb;
    //   1341: aload 10
    //   1343: getfield 1127	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Long	J
    //   1346: aload 10
    //   1348: getfield 1128	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Int	I
    //   1351: iconst_2
    //   1352: invokeinterface 477 5 0
    //   1357: aload_0
    //   1358: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   1361: getfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   1364: ifne +9 -> 1373
    //   1367: aload_0
    //   1368: aload 8
    //   1370: putfield 1198	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   1373: iconst_1
    //   1374: istore_1
    //   1375: goto -904 -> 471
    //   1378: iconst_0
    //   1379: istore 5
    //   1381: goto -446 -> 935
    //   1384: aload 10
    //   1386: iconst_1
    //   1387: invokevirtual 655	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/lang/String;
    //   1390: ifnull -328 -> 1062
    //   1393: getstatic 1211	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   1396: aload 10
    //   1398: iconst_1
    //   1399: invokevirtual 655	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/lang/String;
    //   1402: invokevirtual 1216	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1405: ifnull -343 -> 1062
    //   1408: aload 10
    //   1410: iconst_1
    //   1411: invokevirtual 650	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/io/File;
    //   1414: ifnull -352 -> 1062
    //   1417: aload 7
    //   1419: aload 10
    //   1421: iconst_1
    //   1422: invokevirtual 655	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/lang/String;
    //   1425: aconst_null
    //   1426: invokestatic 439	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   1429: putfield 427	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   1432: goto -370 -> 1062
    //   1435: aload_3
    //   1436: aload 7
    //   1438: invokestatic 755	com/tencent/image/URLDrawable:getDrawable	(Ljava/io/File;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   1441: astore 7
    //   1443: goto -330 -> 1113
    //   1446: astore_2
    //   1447: aload 8
    //   1449: astore_2
    //   1450: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1453: ifeq -1449 -> 4
    //   1456: ldc 171
    //   1458: iconst_2
    //   1459: ldc_w 1222
    //   1462: invokestatic 1085	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1465: aload 8
    //   1467: areturn
    //   1468: iconst_0
    //   1469: istore 4
    //   1471: goto -311 -> 1160
    //   1474: ldc_w 1183
    //   1477: astore_2
    //   1478: goto -309 -> 1169
    //   1481: aload 9
    //   1483: getfield 749	aeiy:jdField_b_of_type_Int	I
    //   1486: bipush 254
    //   1488: if_icmpne +15 -> 1503
    //   1491: aload 9
    //   1493: aload_3
    //   1494: invokevirtual 360	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1497: invokestatic 748	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   1500: putfield 749	aeiy:jdField_b_of_type_Int	I
    //   1503: aload 8
    //   1505: aload 7
    //   1507: aload 9
    //   1509: getfield 749	aeiy:jdField_b_of_type_Int	I
    //   1512: invokestatic 1116	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(Landroid/view/View;Lcom/tencent/image/URLDrawable;I)V
    //   1515: aload 7
    //   1517: invokevirtual 160	com/tencent/image/URLDrawable:getStatus	()I
    //   1520: iconst_1
    //   1521: if_icmpne +42 -> 1563
    //   1524: iconst_1
    //   1525: istore 6
    //   1527: aload_0
    //   1528: iload_1
    //   1529: iload 6
    //   1531: invokevirtual 448	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(IZ)V
    //   1534: goto -334 -> 1200
    //   1537: astore_3
    //   1538: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1541: ifeq +13 -> 1554
    //   1544: ldc 171
    //   1546: iconst_2
    //   1547: ldc_w 767
    //   1550: aload_3
    //   1551: invokestatic 187	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1554: aload 9
    //   1556: iconst_1
    //   1557: putfield 749	aeiy:jdField_b_of_type_Int	I
    //   1560: goto -57 -> 1503
    //   1563: iconst_0
    //   1564: istore 6
    //   1566: goto -39 -> 1527
    //   1569: astore_3
    //   1570: aload_3
    //   1571: invokevirtual 1225	java/lang/Exception:printStackTrace	()V
    //   1574: goto -345 -> 1229
    //   1577: aload 10
    //   1579: getfield 691	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1582: astore_3
    //   1583: goto -343 -> 1240
    //   1586: aload_0
    //   1587: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   1590: getfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   1593: ifne -220 -> 1373
    //   1596: aload_0
    //   1597: getfield 43	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_b_of_type_Boolean	Z
    //   1600: ifne -227 -> 1373
    //   1603: aload_0
    //   1604: getfield 77	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Aejb	Laejb;
    //   1607: aload_0
    //   1608: getfield 103	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Int	I
    //   1611: invokeinterface 740 2 0
    //   1616: aload_0
    //   1617: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   1620: iconst_1
    //   1621: putfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   1624: goto -251 -> 1373
    //   1627: aload 10
    //   1629: bipush 8
    //   1631: invokevirtual 650	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/io/File;
    //   1634: ifnull +267 -> 1901
    //   1637: invokestatic 406	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   1640: astore_2
    //   1641: aload_2
    //   1642: getstatic 813	aywm:a	Landroid/graphics/drawable/Drawable;
    //   1645: putfield 427	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   1648: aload_2
    //   1649: getstatic 813	aywm:a	Landroid/graphics/drawable/Drawable;
    //   1652: putfield 662	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   1655: aload_2
    //   1656: iconst_0
    //   1657: putfield 668	com/tencent/image/URLDrawable$URLDrawableOptions:mUseExifOrientation	Z
    //   1660: aload 10
    //   1662: getfield 752	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_Int	I
    //   1665: iconst_1
    //   1666: if_icmpne +19 -> 1685
    //   1669: aload 10
    //   1671: getfield 1193	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_d_of_type_Int	I
    //   1674: iconst_2
    //   1675: iand
    //   1676: iconst_2
    //   1677: if_icmpne +8 -> 1685
    //   1680: aload_2
    //   1681: iconst_0
    //   1682: putfield 1196	com/tencent/image/URLDrawable$URLDrawableOptions:mUseAutoScaleParams	Z
    //   1685: aload 8
    //   1687: aload 10
    //   1689: bipush 8
    //   1691: invokevirtual 655	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/lang/String;
    //   1694: aload_2
    //   1695: invokestatic 439	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   1698: invokevirtual 445	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1701: aload_0
    //   1702: iload_1
    //   1703: aload 9
    //   1705: getfield 1226	aeiy:jdField_a_of_type_Int	I
    //   1708: bipush 100
    //   1710: idiv
    //   1711: invokevirtual 964	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(II)V
    //   1714: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1717: ifeq +46 -> 1763
    //   1720: ldc 171
    //   1722: iconst_2
    //   1723: new 173	java/lang/StringBuilder
    //   1726: dup
    //   1727: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   1730: ldc_w 1228
    //   1733: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1736: aload 10
    //   1738: bipush 8
    //   1740: invokevirtual 655	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/lang/String;
    //   1743: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1746: ldc_w 1220
    //   1749: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1752: bipush 8
    //   1754: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1757: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1760: invokestatic 327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1763: aload 10
    //   1765: getfield 693	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_Boolean	Z
    //   1768: ifne +92 -> 1860
    //   1771: aload_0
    //   1772: getfield 77	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Aejb	Laejb;
    //   1775: aload 10
    //   1777: getfield 1127	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Long	J
    //   1780: aload 10
    //   1782: getfield 1128	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Int	I
    //   1785: iconst_2
    //   1786: invokeinterface 477 5 0
    //   1791: aload_0
    //   1792: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   1795: getfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   1798: ifne +20 -> 1818
    //   1801: aload_0
    //   1802: aload 8
    //   1804: putfield 1198	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   1807: aload_0
    //   1808: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   1811: invokevirtual 680	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:a	()Lavwr;
    //   1814: iconst_1
    //   1815: invokevirtual 1230	avwr:a	(Z)V
    //   1818: invokestatic 722	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1821: ifeq +29 -> 1850
    //   1824: aload 10
    //   1826: getfield 724	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_d_of_type_Boolean	Z
    //   1829: ifeq +21 -> 1850
    //   1832: aload 8
    //   1834: invokevirtual 727	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:getContext	()Landroid/content/Context;
    //   1837: ldc_w 1232
    //   1840: sipush 2000
    //   1843: invokestatic 734	bcql:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lbcql;
    //   1846: invokevirtual 737	bcql:a	()Landroid/widget/Toast;
    //   1849: pop
    //   1850: iconst_1
    //   1851: istore_1
    //   1852: aconst_null
    //   1853: astore_2
    //   1854: iconst_0
    //   1855: istore 4
    //   1857: goto -1386 -> 471
    //   1860: aload_0
    //   1861: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   1864: getfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   1867: ifne -76 -> 1791
    //   1870: aload_0
    //   1871: getfield 43	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_b_of_type_Boolean	Z
    //   1874: ifne -83 -> 1791
    //   1877: aload_0
    //   1878: getfield 77	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Aejb	Laejb;
    //   1881: aload_0
    //   1882: getfield 103	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Int	I
    //   1885: invokeinterface 740 2 0
    //   1890: aload_0
    //   1891: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   1894: iconst_1
    //   1895: putfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   1898: goto -107 -> 1791
    //   1901: aload 10
    //   1903: getfield 1233	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_c_of_type_Boolean	Z
    //   1906: ifne +19 -> 1925
    //   1909: aload 10
    //   1911: getfield 693	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_Boolean	Z
    //   1914: ifne +11 -> 1925
    //   1917: aload 10
    //   1919: getfield 1234	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_a_of_type_Boolean	Z
    //   1922: ifeq +111 -> 2033
    //   1925: aload_0
    //   1926: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   1929: getfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   1932: ifeq +75 -> 2007
    //   1935: aload_0
    //   1936: getfield 1198	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   1939: ifnull +68 -> 2007
    //   1942: aload_0
    //   1943: getfield 1198	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   1946: invokevirtual 687	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:a	()Landroid/graphics/drawable/Drawable;
    //   1949: astore_2
    //   1950: aload 8
    //   1952: aload_2
    //   1953: invokevirtual 445	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1956: ldc 152
    //   1958: aload_2
    //   1959: invokevirtual 221	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   1962: ifeq +15 -> 1977
    //   1965: aload_0
    //   1966: getfield 48	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   1969: iload_1
    //   1970: aload_2
    //   1971: checkcast 152	com/tencent/image/URLDrawable
    //   1974: invokevirtual 506	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1977: aload_0
    //   1978: aconst_null
    //   1979: putfield 1198	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   1982: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1985: ifeq +376 -> 2361
    //   1988: ldc 171
    //   1990: iconst_2
    //   1991: ldc_w 1236
    //   1994: invokestatic 327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1997: aconst_null
    //   1998: astore_2
    //   1999: iconst_0
    //   2000: istore 4
    //   2002: iconst_0
    //   2003: istore_1
    //   2004: goto -1533 -> 471
    //   2007: aload 8
    //   2009: invokestatic 710	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2012: invokevirtual 711	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   2015: ldc_w 712
    //   2018: invokevirtual 715	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   2021: invokevirtual 445	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2024: aload_0
    //   2025: iload_1
    //   2026: iconst_0
    //   2027: invokevirtual 448	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(IZ)V
    //   2030: goto -48 -> 1982
    //   2033: aload 10
    //   2035: iconst_1
    //   2036: invokevirtual 650	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/io/File;
    //   2039: astore_2
    //   2040: aload_2
    //   2041: ifnull +231 -> 2272
    //   2044: invokestatic 406	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   2047: astore_3
    //   2048: aload_3
    //   2049: getstatic 813	aywm:a	Landroid/graphics/drawable/Drawable;
    //   2052: putfield 427	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   2055: aload_3
    //   2056: getstatic 813	aywm:a	Landroid/graphics/drawable/Drawable;
    //   2059: putfield 662	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   2062: aload 10
    //   2064: getfield 752	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_Int	I
    //   2067: iconst_1
    //   2068: if_icmpne +19 -> 2087
    //   2071: aload 10
    //   2073: getfield 1193	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_d_of_type_Int	I
    //   2076: iconst_2
    //   2077: iand
    //   2078: iconst_2
    //   2079: if_icmpne +8 -> 2087
    //   2082: aload_3
    //   2083: iconst_0
    //   2084: putfield 1196	com/tencent/image/URLDrawable$URLDrawableOptions:mUseAutoScaleParams	Z
    //   2087: aload_2
    //   2088: aload_3
    //   2089: invokestatic 755	com/tencent/image/URLDrawable:getDrawable	(Ljava/io/File;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   2092: astore_2
    //   2093: aload 8
    //   2095: aload_2
    //   2096: invokevirtual 445	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2099: aload 10
    //   2101: getfield 1238	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_g_of_type_Boolean	Z
    //   2104: ifne +128 -> 2232
    //   2107: aload_2
    //   2108: invokevirtual 163	com/tencent/image/URLDrawable:downloadImediatly	()V
    //   2111: aload_0
    //   2112: iload_1
    //   2113: aload 9
    //   2115: getfield 1226	aeiy:jdField_a_of_type_Int	I
    //   2118: bipush 100
    //   2120: idiv
    //   2121: invokevirtual 964	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(II)V
    //   2124: aload_0
    //   2125: getfield 77	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Aejb	Laejb;
    //   2128: aload 10
    //   2130: getfield 1127	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Long	J
    //   2133: aload 10
    //   2135: getfield 1128	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Int	I
    //   2138: iconst_2
    //   2139: invokeinterface 477 5 0
    //   2144: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2147: ifeq +44 -> 2191
    //   2150: ldc 171
    //   2152: iconst_2
    //   2153: new 173	java/lang/StringBuilder
    //   2156: dup
    //   2157: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   2160: ldc_w 1228
    //   2163: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2166: aload 10
    //   2168: iconst_1
    //   2169: invokevirtual 655	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/lang/String;
    //   2172: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2175: ldc_w 1220
    //   2178: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2181: iconst_1
    //   2182: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2185: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2188: invokestatic 327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2191: aload_0
    //   2192: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2195: getfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   2198: ifne +24 -> 2222
    //   2201: aload_0
    //   2202: aload 8
    //   2204: putfield 1198	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   2207: aload_0
    //   2208: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2211: invokevirtual 680	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:a	()Lavwr;
    //   2214: aload 10
    //   2216: getfield 1240	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Boolean	Z
    //   2219: invokevirtual 1230	avwr:a	(Z)V
    //   2222: iconst_1
    //   2223: istore_1
    //   2224: aconst_null
    //   2225: astore_2
    //   2226: iconst_0
    //   2227: istore 4
    //   2229: goto -1758 -> 471
    //   2232: invokestatic 1245	wxr:a	()Lwxr;
    //   2235: astore_2
    //   2236: aload_2
    //   2237: invokevirtual 1246	wxr:a	()V
    //   2240: aload_2
    //   2241: aload_0
    //   2242: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2245: getfield 1247	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2248: aload 10
    //   2250: sipush 640
    //   2253: new 1249	aegj
    //   2256: dup
    //   2257: aload_0
    //   2258: iload_1
    //   2259: aload 8
    //   2261: aload 10
    //   2263: invokespecial 1252	aegj:<init>	(Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter;ILcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;Lcom/tencent/mobileqq/activity/aio/photo/AIOImageData;)V
    //   2266: invokevirtual 1255	wxr:a	(Ljava/lang/String;Lcom/tencent/mobileqq/activity/aio/photo/AIOImageData;ILwxt;)V
    //   2269: goto -47 -> 2222
    //   2272: aload 10
    //   2274: getfield 1238	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_g_of_type_Boolean	Z
    //   2277: ifne +94 -> 2371
    //   2280: aload_0
    //   2281: iload_1
    //   2282: aload 9
    //   2284: getfield 1226	aeiy:jdField_a_of_type_Int	I
    //   2287: bipush 100
    //   2289: idiv
    //   2290: invokevirtual 964	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(II)V
    //   2293: aload 8
    //   2295: getstatic 813	aywm:a	Landroid/graphics/drawable/Drawable;
    //   2298: invokevirtual 445	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2301: aload_0
    //   2302: getfield 77	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Aejb	Laejb;
    //   2305: aload 10
    //   2307: getfield 1127	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Long	J
    //   2310: aload 10
    //   2312: getfield 1128	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Int	I
    //   2315: iconst_2
    //   2316: invokeinterface 477 5 0
    //   2321: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2324: ifeq +12 -> 2336
    //   2327: ldc 171
    //   2329: iconst_2
    //   2330: ldc_w 1257
    //   2333: invokestatic 327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2336: aload_0
    //   2337: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2340: getfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   2343: ifne +18 -> 2361
    //   2346: aload_0
    //   2347: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2350: invokevirtual 680	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:a	()Lavwr;
    //   2353: aload 10
    //   2355: getfield 1240	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Boolean	Z
    //   2358: invokevirtual 1230	avwr:a	(Z)V
    //   2361: aconst_null
    //   2362: astore_2
    //   2363: iconst_0
    //   2364: istore 4
    //   2366: iconst_0
    //   2367: istore_1
    //   2368: goto -1897 -> 471
    //   2371: aload 10
    //   2373: getfield 961	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_h_of_type_Long	J
    //   2376: invokestatic 818	apei:c	()J
    //   2379: lcmp
    //   2380: ifgt +94 -> 2474
    //   2383: aload_0
    //   2384: iload_1
    //   2385: aload 9
    //   2387: getfield 1226	aeiy:jdField_a_of_type_Int	I
    //   2390: bipush 100
    //   2392: idiv
    //   2393: invokevirtual 964	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(II)V
    //   2396: aload 8
    //   2398: getstatic 813	aywm:a	Landroid/graphics/drawable/Drawable;
    //   2401: invokevirtual 445	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2404: invokestatic 1245	wxr:a	()Lwxr;
    //   2407: astore_2
    //   2408: aload_2
    //   2409: invokevirtual 1246	wxr:a	()V
    //   2412: aload_2
    //   2413: aload_0
    //   2414: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2417: getfield 1247	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2420: aload 10
    //   2422: sipush 383
    //   2425: new 1259	aegk
    //   2428: dup
    //   2429: aload_0
    //   2430: invokespecial 1260	aegk:<init>	(Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter;)V
    //   2433: invokevirtual 1255	wxr:a	(Ljava/lang/String;Lcom/tencent/mobileqq/activity/aio/photo/AIOImageData;ILwxt;)V
    //   2436: aload_0
    //   2437: iload_1
    //   2438: iconst_0
    //   2439: invokevirtual 964	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(II)V
    //   2442: aload_2
    //   2443: aload_0
    //   2444: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2447: getfield 1247	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2450: aload 10
    //   2452: sipush 640
    //   2455: new 1262	aegl
    //   2458: dup
    //   2459: aload_0
    //   2460: iload_1
    //   2461: aload 8
    //   2463: aload 10
    //   2465: invokespecial 1263	aegl:<init>	(Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter;ILcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;Lcom/tencent/mobileqq/activity/aio/photo/AIOImageData;)V
    //   2468: invokevirtual 1255	wxr:a	(Ljava/lang/String;Lcom/tencent/mobileqq/activity/aio/photo/AIOImageData;ILwxt;)V
    //   2471: goto -135 -> 2336
    //   2474: aload_0
    //   2475: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2478: getfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   2481: ifne +18 -> 2499
    //   2484: aload_0
    //   2485: getfield 43	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_b_of_type_Boolean	Z
    //   2488: ifne +11 -> 2499
    //   2491: aload_0
    //   2492: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2495: iconst_1
    //   2496: putfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   2499: aload 8
    //   2501: invokestatic 710	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2504: invokevirtual 711	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   2507: ldc_w 712
    //   2510: invokevirtual 715	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   2513: invokevirtual 445	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2516: aload 8
    //   2518: invokevirtual 819	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:b	()V
    //   2521: aload 8
    //   2523: ldc_w 1264
    //   2526: ldc_w 1265
    //   2529: invokestatic 1270	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   2532: invokevirtual 1204	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setTag	(ILjava/lang/Object;)V
    //   2535: goto -199 -> 2336
    //   2538: ldc_w 344
    //   2541: aload 9
    //   2543: getfield 649	aeiy:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   2546: invokevirtual 221	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   2549: ifeq +742 -> 3291
    //   2552: aload_0
    //   2553: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2556: iconst_1
    //   2557: putfield 969	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_d_of_type_Boolean	Z
    //   2560: aload 9
    //   2562: getfield 649	aeiy:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   2565: checkcast 344	com/tencent/mobileqq/activity/aio/photo/AIOShortVideoData
    //   2568: astore_2
    //   2569: aload_2
    //   2570: getfield 778	com/tencent/mobileqq/activity/aio/photo/AIOShortVideoData:jdField_b_of_type_Int	I
    //   2573: ifeq +411 -> 2984
    //   2576: new 441	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct
    //   2579: dup
    //   2580: aload_0
    //   2581: aload_0
    //   2582: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2585: iconst_1
    //   2586: invokespecial 1076	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:<init>	(Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter;Landroid/content/Context;I)V
    //   2589: astore_3
    //   2590: aload_3
    //   2591: iconst_1
    //   2592: invokevirtual 1079	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setAdjustViewBounds	(Z)V
    //   2595: aload_0
    //   2596: getfield 50	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   2599: iload_1
    //   2600: invokevirtual 850	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   2603: checkcast 152	com/tencent/image/URLDrawable
    //   2606: astore 7
    //   2608: aload_3
    //   2609: iload_1
    //   2610: invokevirtual 1096	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setPosition	(I)V
    //   2613: aload_3
    //   2614: aload 9
    //   2616: invokevirtual 1100	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageInfo	(Laeiy;)V
    //   2619: aload_3
    //   2620: invokevirtual 1064	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:a	()V
    //   2623: aload 7
    //   2625: ifnull +144 -> 2769
    //   2628: aload_3
    //   2629: getfield 1273	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView;
    //   2632: aload 7
    //   2634: invokevirtual 1276	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2637: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2640: ifeq +29 -> 2669
    //   2643: ldc 171
    //   2645: iconst_2
    //   2646: new 173	java/lang/StringBuilder
    //   2649: dup
    //   2650: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   2653: ldc_w 1278
    //   2656: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2659: iload_1
    //   2660: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2663: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2666: invokestatic 327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2669: aload_0
    //   2670: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2673: getfield 857	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_c_of_type_Boolean	Z
    //   2676: ifeq +272 -> 2948
    //   2679: aload_0
    //   2680: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2683: getfield 1279	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_b_of_type_Int	I
    //   2686: iconst_1
    //   2687: if_icmpne +202 -> 2889
    //   2690: aload_0
    //   2691: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2694: astore_2
    //   2695: aload_2
    //   2696: aload_2
    //   2697: getfield 1279	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_b_of_type_Int	I
    //   2700: iconst_1
    //   2701: isub
    //   2702: putfield 1279	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_b_of_type_Int	I
    //   2705: aload_0
    //   2706: getfield 43	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_b_of_type_Boolean	Z
    //   2709: ifeq +16 -> 2725
    //   2712: aload_3
    //   2713: iload_1
    //   2714: invokevirtual 951	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:b	(I)V
    //   2717: aload_0
    //   2718: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2721: iconst_0
    //   2722: putfield 857	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_c_of_type_Boolean	Z
    //   2725: aload_3
    //   2726: astore_2
    //   2727: aload_0
    //   2728: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2731: getfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   2734: ifne -2730 -> 4
    //   2737: aload_3
    //   2738: astore_2
    //   2739: aload_0
    //   2740: getfield 43	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_b_of_type_Boolean	Z
    //   2743: ifne -2739 -> 4
    //   2746: aload_0
    //   2747: getfield 77	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Aejb	Laejb;
    //   2750: aload_0
    //   2751: getfield 103	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Int	I
    //   2754: invokeinterface 740 2 0
    //   2759: aload_0
    //   2760: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2763: iconst_1
    //   2764: putfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   2767: aload_3
    //   2768: areturn
    //   2769: aload_2
    //   2770: iconst_0
    //   2771: invokevirtual 400	com/tencent/mobileqq/activity/aio/photo/AIOShortVideoData:a	(I)Ljava/io/File;
    //   2774: ifnull +59 -> 2833
    //   2777: aload_0
    //   2778: aload_2
    //   2779: getfield 834	com/tencent/mobileqq/activity/aio/photo/AIOShortVideoData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2782: aload_2
    //   2783: getfield 345	com/tencent/mobileqq/activity/aio/photo/AIOShortVideoData:jdField_c_of_type_Int	I
    //   2786: aload_2
    //   2787: getfield 349	com/tencent/mobileqq/activity/aio/photo/AIOShortVideoData:jdField_d_of_type_Int	I
    //   2790: aload_3
    //   2791: getfield 1273	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView;
    //   2794: iload_1
    //   2795: invokespecial 836	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(Ljava/lang/String;IILandroid/widget/ImageView;I)V
    //   2798: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2801: ifeq -132 -> 2669
    //   2804: ldc 171
    //   2806: iconst_2
    //   2807: new 173	java/lang/StringBuilder
    //   2810: dup
    //   2811: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   2814: ldc_w 1281
    //   2817: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2820: iload_1
    //   2821: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2824: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2827: invokestatic 327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2830: goto -161 -> 2669
    //   2833: aload_3
    //   2834: getfield 1284	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   2837: bipush 8
    //   2839: invokevirtual 490	android/widget/ImageView:setVisibility	(I)V
    //   2842: aload_0
    //   2843: getfield 77	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Aejb	Laejb;
    //   2846: aload_2
    //   2847: getfield 471	com/tencent/mobileqq/activity/aio/photo/AIOShortVideoData:jdField_f_of_type_Long	J
    //   2850: aload_2
    //   2851: getfield 472	com/tencent/mobileqq/activity/aio/photo/AIOShortVideoData:jdField_f_of_type_Int	I
    //   2854: iconst_0
    //   2855: invokeinterface 477 5 0
    //   2860: ldc 171
    //   2862: iconst_2
    //   2863: new 173	java/lang/StringBuilder
    //   2866: dup
    //   2867: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   2870: ldc_w 1286
    //   2873: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2876: iload_1
    //   2877: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2880: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2883: invokestatic 327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2886: goto -217 -> 2669
    //   2889: aload_0
    //   2890: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2893: getfield 1279	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_b_of_type_Int	I
    //   2896: ifne -171 -> 2725
    //   2899: aload_3
    //   2900: iload_1
    //   2901: invokevirtual 951	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:b	(I)V
    //   2904: aconst_null
    //   2905: ldc_w 910
    //   2908: ldc_w 277
    //   2911: ldc_w 277
    //   2914: ldc_w 1288
    //   2917: ldc_w 1288
    //   2920: iconst_1
    //   2921: iconst_0
    //   2922: ldc_w 277
    //   2925: ldc_w 277
    //   2928: ldc_w 277
    //   2931: ldc_w 277
    //   2934: invokestatic 917	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2937: aload_0
    //   2938: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2941: iconst_0
    //   2942: putfield 857	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_c_of_type_Boolean	Z
    //   2945: goto -220 -> 2725
    //   2948: aconst_null
    //   2949: ldc_w 910
    //   2952: ldc_w 277
    //   2955: ldc_w 277
    //   2958: ldc_w 1288
    //   2961: ldc_w 1288
    //   2964: iconst_2
    //   2965: iconst_0
    //   2966: ldc_w 277
    //   2969: ldc_w 277
    //   2972: ldc_w 277
    //   2975: ldc_w 277
    //   2978: invokestatic 917	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2981: goto -256 -> 2725
    //   2984: aload_0
    //   2985: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   2988: invokevirtual 1292	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:getLayoutInflater	()Landroid/view/LayoutInflater;
    //   2991: ldc_w 1293
    //   2994: aconst_null
    //   2995: invokevirtual 1299	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   2998: astore_3
    //   2999: aload_3
    //   3000: ldc_w 1300
    //   3003: iconst_1
    //   3004: invokestatic 609	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3007: invokevirtual 1301	android/view/View:setTag	(ILjava/lang/Object;)V
    //   3010: aload_3
    //   3011: ldc_w 1302
    //   3014: iconst_1
    //   3015: invokestatic 609	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3018: invokevirtual 1301	android/view/View:setTag	(ILjava/lang/Object;)V
    //   3021: aload_3
    //   3022: new 1304	com/tencent/widget/Gallery$LayoutParams
    //   3025: dup
    //   3026: iconst_m1
    //   3027: iconst_m1
    //   3028: invokespecial 1306	com/tencent/widget/Gallery$LayoutParams:<init>	(II)V
    //   3031: invokevirtual 1310	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   3034: aload_3
    //   3035: ldc_w 831
    //   3038: invokevirtual 484	android/view/View:findViewById	(I)Landroid/view/View;
    //   3041: checkcast 833	com/tencent/image/URLImageView
    //   3044: astore 7
    //   3046: aload_0
    //   3047: getfield 50	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   3050: iload_1
    //   3051: invokevirtual 850	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   3054: checkcast 152	com/tencent/image/URLDrawable
    //   3057: astore 8
    //   3059: aload 8
    //   3061: ifnull +164 -> 3225
    //   3064: aload 7
    //   3066: aload 8
    //   3068: invokevirtual 1311	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   3071: aload_2
    //   3072: getfield 471	com/tencent/mobileqq/activity/aio/photo/AIOShortVideoData:jdField_f_of_type_Long	J
    //   3075: aload_0
    //   3076: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   3079: getfield 852	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Long	J
    //   3082: lcmp
    //   3083: ifeq +11 -> 3094
    //   3086: aload_0
    //   3087: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   3090: iconst_0
    //   3091: putfield 857	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_c_of_type_Boolean	Z
    //   3094: aload_0
    //   3095: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   3098: getfield 852	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Long	J
    //   3101: aload_2
    //   3102: getfield 471	com/tencent/mobileqq/activity/aio/photo/AIOShortVideoData:jdField_f_of_type_Long	J
    //   3105: lcmp
    //   3106: ifne +149 -> 3255
    //   3109: aload_0
    //   3110: aload_2
    //   3111: aload_3
    //   3112: invokevirtual 1313	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(Lcom/tencent/mobileqq/activity/aio/photo/AIOShortVideoData;Landroid/view/View;)Z
    //   3115: ifeq +25 -> 3140
    //   3118: aload_3
    //   3119: ldc_w 478
    //   3122: invokevirtual 484	android/view/View:findViewById	(I)Landroid/view/View;
    //   3125: checkcast 486	android/widget/ImageView
    //   3128: bipush 8
    //   3130: invokevirtual 490	android/widget/ImageView:setVisibility	(I)V
    //   3133: aload_0
    //   3134: getfield 492	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Agqs	Lagqs;
    //   3137: invokevirtual 982	agqs:f	()V
    //   3140: aload_0
    //   3141: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   3144: iconst_0
    //   3145: putfield 857	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_c_of_type_Boolean	Z
    //   3148: aconst_null
    //   3149: ldc_w 910
    //   3152: ldc_w 277
    //   3155: ldc_w 277
    //   3158: ldc_w 1315
    //   3161: ldc_w 1315
    //   3164: iconst_1
    //   3165: iconst_0
    //   3166: ldc_w 277
    //   3169: ldc_w 277
    //   3172: ldc_w 277
    //   3175: ldc_w 277
    //   3178: invokestatic 917	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3181: aload_3
    //   3182: astore_2
    //   3183: aload_0
    //   3184: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   3187: getfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   3190: ifne -3186 -> 4
    //   3193: aload_3
    //   3194: astore_2
    //   3195: aload_0
    //   3196: getfield 43	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_b_of_type_Boolean	Z
    //   3199: ifne -3195 -> 4
    //   3202: aload_0
    //   3203: getfield 77	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Aejb	Laejb;
    //   3206: aload_0
    //   3207: getfield 103	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Int	I
    //   3210: invokeinterface 740 2 0
    //   3215: aload_0
    //   3216: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   3219: iconst_1
    //   3220: putfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   3223: aload_3
    //   3224: areturn
    //   3225: aload_2
    //   3226: iconst_0
    //   3227: invokevirtual 400	com/tencent/mobileqq/activity/aio/photo/AIOShortVideoData:a	(I)Ljava/io/File;
    //   3230: ifnull -159 -> 3071
    //   3233: aload_0
    //   3234: aload_2
    //   3235: getfield 834	com/tencent/mobileqq/activity/aio/photo/AIOShortVideoData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3238: aload_2
    //   3239: getfield 345	com/tencent/mobileqq/activity/aio/photo/AIOShortVideoData:jdField_c_of_type_Int	I
    //   3242: aload_2
    //   3243: getfield 349	com/tencent/mobileqq/activity/aio/photo/AIOShortVideoData:jdField_d_of_type_Int	I
    //   3246: aload 7
    //   3248: iload_1
    //   3249: invokespecial 836	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(Ljava/lang/String;IILandroid/widget/ImageView;I)V
    //   3252: goto -181 -> 3071
    //   3255: aconst_null
    //   3256: ldc_w 910
    //   3259: ldc_w 277
    //   3262: ldc_w 277
    //   3265: ldc_w 1315
    //   3268: ldc_w 1315
    //   3271: iconst_2
    //   3272: iconst_0
    //   3273: ldc_w 277
    //   3276: ldc_w 277
    //   3279: ldc_w 277
    //   3282: ldc_w 277
    //   3285: invokestatic 917	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3288: goto -107 -> 3181
    //   3291: ldc_w 806
    //   3294: aload 9
    //   3296: getfield 649	aeiy:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   3299: invokevirtual 221	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   3302: ifeq +1204 -> 4506
    //   3305: aload_0
    //   3306: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   3309: iconst_1
    //   3310: putfield 969	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_d_of_type_Boolean	Z
    //   3313: aload_0
    //   3314: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   3317: getfield 857	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_c_of_type_Boolean	Z
    //   3320: ifeq +275 -> 3595
    //   3323: aload_0
    //   3324: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   3327: iconst_0
    //   3328: putfield 857	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_c_of_type_Boolean	Z
    //   3331: aconst_null
    //   3332: ldc_w 910
    //   3335: ldc_w 277
    //   3338: ldc_w 277
    //   3341: ldc_w 1090
    //   3344: ldc_w 1090
    //   3347: iconst_1
    //   3348: iconst_0
    //   3349: ldc_w 277
    //   3352: ldc_w 277
    //   3355: ldc_w 277
    //   3358: ldc_w 277
    //   3361: invokestatic 917	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3364: aload 8
    //   3366: bipush 8
    //   3368: invokevirtual 1093	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setCenterBtnVisiable	(I)V
    //   3371: aload 9
    //   3373: getfield 649	aeiy:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   3376: checkcast 806	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData
    //   3379: astore 10
    //   3381: aload 8
    //   3383: iload_1
    //   3384: invokevirtual 1096	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setPosition	(I)V
    //   3387: aload 8
    //   3389: aload 9
    //   3391: invokevirtual 1100	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageInfo	(Laeiy;)V
    //   3394: aload 8
    //   3396: iconst_0
    //   3397: invokevirtual 1103	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setIgnoreLayout	(Z)V
    //   3400: aload_0
    //   3401: getfield 48	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   3404: iload_1
    //   3405: invokevirtual 850	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   3408: checkcast 152	com/tencent/image/URLDrawable
    //   3411: astore_3
    //   3412: aload_3
    //   3413: ifnull +227 -> 3640
    //   3416: aload_3
    //   3417: invokevirtual 160	com/tencent/image/URLDrawable:getStatus	()I
    //   3420: iconst_1
    //   3421: if_icmpne +219 -> 3640
    //   3424: aload 8
    //   3426: aload_3
    //   3427: invokevirtual 445	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   3430: aload 10
    //   3432: bipush 20
    //   3434: invokevirtual 821	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/lang/String;
    //   3437: astore_2
    //   3438: aload_3
    //   3439: invokevirtual 697	com/tencent/image/URLDrawable:getURL	()Ljava/net/URL;
    //   3442: invokevirtual 418	java/net/URL:toString	()Ljava/lang/String;
    //   3445: astore 7
    //   3447: aload_0
    //   3448: iload_1
    //   3449: iconst_1
    //   3450: invokevirtual 448	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(IZ)V
    //   3453: aload 7
    //   3455: aload_2
    //   3456: invokevirtual 705	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3459: ifeq +9 -> 3468
    //   3462: aload 8
    //   3464: iconst_1
    //   3465: invokevirtual 1110	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setOriginalImage	(Z)V
    //   3468: aload 9
    //   3470: getfield 749	aeiy:jdField_b_of_type_Int	I
    //   3473: bipush 254
    //   3475: if_icmpne +18 -> 3493
    //   3478: aload 9
    //   3480: aload_3
    //   3481: invokevirtual 697	com/tencent/image/URLDrawable:getURL	()Ljava/net/URL;
    //   3484: invokevirtual 1113	java/net/URL:getFile	()Ljava/lang/String;
    //   3487: invokestatic 748	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   3490: putfield 749	aeiy:jdField_b_of_type_Int	I
    //   3493: aload 8
    //   3495: aload_3
    //   3496: aload 9
    //   3498: getfield 749	aeiy:jdField_b_of_type_Int	I
    //   3501: invokestatic 1116	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(Landroid/view/View;Lcom/tencent/image/URLDrawable;I)V
    //   3504: aload 8
    //   3506: invokevirtual 1117	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:a	()Z
    //   3509: ifeq +122 -> 3631
    //   3512: aload 10
    //   3514: getfield 1317	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3517: astore_2
    //   3518: aload_2
    //   3519: invokestatic 757	bbdx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3522: astore 9
    //   3524: aload 8
    //   3526: astore_2
    //   3527: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3530: ifeq -3526 -> 4
    //   3533: ldc 171
    //   3535: iconst_2
    //   3536: new 173	java/lang/StringBuilder
    //   3539: dup
    //   3540: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   3543: ldc_w 1120
    //   3546: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3549: aload 7
    //   3551: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3554: ldc_w 1122
    //   3557: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3560: aload 10
    //   3562: aload_3
    //   3563: invokevirtual 697	com/tencent/image/URLDrawable:getURL	()Ljava/net/URL;
    //   3566: invokevirtual 1113	java/net/URL:getFile	()Ljava/lang/String;
    //   3569: invokevirtual 1318	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(Ljava/lang/String;)I
    //   3572: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3575: ldc_w 1126
    //   3578: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3581: aload 9
    //   3583: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3586: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3589: invokestatic 327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3592: aload 8
    //   3594: areturn
    //   3595: aconst_null
    //   3596: ldc_w 910
    //   3599: ldc_w 277
    //   3602: ldc_w 277
    //   3605: ldc_w 1090
    //   3608: ldc_w 1090
    //   3611: iconst_2
    //   3612: iconst_0
    //   3613: ldc_w 277
    //   3616: ldc_w 277
    //   3619: ldc_w 277
    //   3622: ldc_w 277
    //   3625: invokestatic 917	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3628: goto -264 -> 3364
    //   3631: aload 10
    //   3633: getfield 823	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3636: astore_2
    //   3637: goto -119 -> 3518
    //   3640: aload 10
    //   3642: bipush 20
    //   3644: invokevirtual 820	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   3647: astore_3
    //   3648: aload_3
    //   3649: ifnonnull +1459 -> 5108
    //   3652: aload 10
    //   3654: bipush 18
    //   3656: invokevirtual 820	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   3659: astore_2
    //   3660: aload_2
    //   3661: ifnull +415 -> 4076
    //   3664: aload_3
    //   3665: ifnull +303 -> 3968
    //   3668: iconst_1
    //   3669: istore 4
    //   3671: invokestatic 406	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   3674: astore 11
    //   3676: aload 11
    //   3678: aload_0
    //   3679: getfield 96	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:e	I
    //   3682: putfield 1186	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   3685: aload 11
    //   3687: aload_0
    //   3688: getfield 101	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_f_of_type_Int	I
    //   3691: putfield 1189	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   3694: aload 11
    //   3696: getstatic 813	aywm:a	Landroid/graphics/drawable/Drawable;
    //   3699: putfield 427	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   3702: aload 11
    //   3704: iconst_1
    //   3705: putfield 665	com/tencent/image/URLDrawable$URLDrawableOptions:mPlayGifImage	Z
    //   3708: iload 4
    //   3710: iconst_1
    //   3711: if_icmpne +49 -> 3760
    //   3714: aload 8
    //   3716: iconst_1
    //   3717: invokevirtual 1110	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setOriginalImage	(Z)V
    //   3720: aload 10
    //   3722: bipush 18
    //   3724: invokevirtual 820	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   3727: astore 7
    //   3729: aload 7
    //   3731: astore_3
    //   3732: aload 7
    //   3734: ifnonnull +11 -> 3745
    //   3737: aload 10
    //   3739: bipush 16
    //   3741: invokevirtual 820	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   3744: astore_3
    //   3745: aload_3
    //   3746: ifnull +14 -> 3760
    //   3749: aload 8
    //   3751: aload_3
    //   3752: aload 11
    //   3754: invokestatic 755	com/tencent/image/URLDrawable:getDrawable	(Ljava/io/File;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   3757: invokevirtual 445	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   3760: aload_0
    //   3761: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   3764: getfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   3767: ifeq +27 -> 3794
    //   3770: aload_0
    //   3771: getfield 1198	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   3774: ifnull +20 -> 3794
    //   3777: aload 11
    //   3779: aload_0
    //   3780: getfield 1198	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   3783: invokevirtual 687	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:a	()Landroid/graphics/drawable/Drawable;
    //   3786: putfield 427	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   3789: aload_0
    //   3790: aconst_null
    //   3791: putfield 1198	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   3794: invokestatic 406	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   3797: astore_3
    //   3798: aload_3
    //   3799: aload_0
    //   3800: getfield 96	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:e	I
    //   3803: putfield 1186	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   3806: aload_3
    //   3807: aload_0
    //   3808: getfield 101	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_f_of_type_Int	I
    //   3811: putfield 1189	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   3814: aload_3
    //   3815: getstatic 813	aywm:a	Landroid/graphics/drawable/Drawable;
    //   3818: putfield 427	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   3821: aload_3
    //   3822: iconst_1
    //   3823: putfield 665	com/tencent/image/URLDrawable$URLDrawableOptions:mPlayGifImage	Z
    //   3826: aload_3
    //   3827: iconst_0
    //   3828: putfield 668	com/tencent/image/URLDrawable$URLDrawableOptions:mUseExifOrientation	Z
    //   3831: aload_2
    //   3832: aload_3
    //   3833: invokestatic 755	com/tencent/image/URLDrawable:getDrawable	(Ljava/io/File;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   3836: astore_3
    //   3837: aload_3
    //   3838: iconst_1
    //   3839: invokestatic 772	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3842: invokevirtual 776	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   3845: aload_0
    //   3846: getfield 48	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   3849: iload_1
    //   3850: aload_3
    //   3851: invokevirtual 506	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   3854: aload_0
    //   3855: iload_1
    //   3856: iconst_m1
    //   3857: invokevirtual 964	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(II)V
    //   3860: aload_3
    //   3861: invokevirtual 160	com/tencent/image/URLDrawable:getStatus	()I
    //   3864: tableswitch	default:+28 -> 3892, 1:+110->3974, 2:+176->4040, 3:+176->4040
    //   3893: iconst_5
    //   3894: aload_3
    //   3895: invokevirtual 445	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   3898: aload 8
    //   3900: iload 4
    //   3902: invokevirtual 1110	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setOriginalImage	(Z)V
    //   3905: iload 4
    //   3907: ifeq +160 -> 4067
    //   3910: aload 10
    //   3912: getfield 1317	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3915: astore_2
    //   3916: aload_2
    //   3917: invokestatic 757	bbdx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3920: pop
    //   3921: aload 8
    //   3923: astore_2
    //   3924: aload_0
    //   3925: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   3928: getfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   3931: ifne -3927 -> 4
    //   3934: aload 8
    //   3936: astore_2
    //   3937: aload_0
    //   3938: getfield 43	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_b_of_type_Boolean	Z
    //   3941: ifne -3937 -> 4
    //   3944: aload_0
    //   3945: getfield 77	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Aejb	Laejb;
    //   3948: aload_0
    //   3949: getfield 103	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Int	I
    //   3952: invokeinterface 740 2 0
    //   3957: aload_0
    //   3958: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   3961: iconst_1
    //   3962: putfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   3965: aload 8
    //   3967: areturn
    //   3968: iconst_0
    //   3969: istore 4
    //   3971: goto -300 -> 3671
    //   3974: aload 9
    //   3976: getfield 749	aeiy:jdField_b_of_type_Int	I
    //   3979: bipush 254
    //   3981: if_icmpne +15 -> 3996
    //   3984: aload 9
    //   3986: aload_2
    //   3987: invokevirtual 360	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   3990: invokestatic 748	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   3993: putfield 749	aeiy:jdField_b_of_type_Int	I
    //   3996: aload 8
    //   3998: aload_3
    //   3999: invokevirtual 445	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   4002: aload 8
    //   4004: aload_3
    //   4005: aload 9
    //   4007: getfield 749	aeiy:jdField_b_of_type_Int	I
    //   4010: invokestatic 1116	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(Landroid/view/View;Lcom/tencent/image/URLDrawable;I)V
    //   4013: aload_3
    //   4014: invokevirtual 160	com/tencent/image/URLDrawable:getStatus	()I
    //   4017: iconst_1
    //   4018: if_icmpne +16 -> 4034
    //   4021: iconst_1
    //   4022: istore 5
    //   4024: aload_0
    //   4025: iload_1
    //   4026: iload 5
    //   4028: invokevirtual 448	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(IZ)V
    //   4031: goto -126 -> 3905
    //   4034: iconst_0
    //   4035: istore 5
    //   4037: goto -13 -> 4024
    //   4040: aload_3
    //   4041: invokevirtual 160	com/tencent/image/URLDrawable:getStatus	()I
    //   4044: iconst_1
    //   4045: if_icmpne +16 -> 4061
    //   4048: iconst_1
    //   4049: istore 5
    //   4051: aload_0
    //   4052: iload_1
    //   4053: iload 5
    //   4055: invokevirtual 448	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(IZ)V
    //   4058: goto -153 -> 3905
    //   4061: iconst_0
    //   4062: istore 5
    //   4064: goto -13 -> 4051
    //   4067: aload 10
    //   4069: getfield 823	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   4072: astore_2
    //   4073: goto -157 -> 3916
    //   4076: aload 10
    //   4078: bipush 16
    //   4080: invokevirtual 820	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   4083: astore_2
    //   4084: aload_2
    //   4085: ifnull +244 -> 4329
    //   4088: invokestatic 406	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   4091: astore_3
    //   4092: aload_3
    //   4093: getstatic 813	aywm:a	Landroid/graphics/drawable/Drawable;
    //   4096: putfield 427	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   4099: aload_3
    //   4100: getstatic 813	aywm:a	Landroid/graphics/drawable/Drawable;
    //   4103: putfield 662	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   4106: aload_2
    //   4107: aload_3
    //   4108: invokestatic 755	com/tencent/image/URLDrawable:getDrawable	(Ljava/io/File;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   4111: astore_2
    //   4112: aload 8
    //   4114: aload_2
    //   4115: invokevirtual 445	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   4118: aload 10
    //   4120: getfield 1319	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_d_of_type_Boolean	Z
    //   4123: ifne +165 -> 4288
    //   4126: aload 10
    //   4128: getfield 814	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_a_of_type_Long	J
    //   4131: invokestatic 818	apei:c	()J
    //   4134: lcmp
    //   4135: ifgt +112 -> 4247
    //   4138: aload_2
    //   4139: invokevirtual 163	com/tencent/image/URLDrawable:downloadImediatly	()V
    //   4142: aload_0
    //   4143: iload_1
    //   4144: aload 9
    //   4146: getfield 1226	aeiy:jdField_a_of_type_Int	I
    //   4149: bipush 100
    //   4151: idiv
    //   4152: invokevirtual 964	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(II)V
    //   4155: aload_0
    //   4156: getfield 77	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Aejb	Laejb;
    //   4159: aload 10
    //   4161: getfield 1320	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_f_of_type_Long	J
    //   4164: aload 10
    //   4166: getfield 1321	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_f_of_type_Int	I
    //   4169: bipush 18
    //   4171: invokeinterface 477 5 0
    //   4176: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4179: ifeq +46 -> 4225
    //   4182: ldc 171
    //   4184: iconst_2
    //   4185: new 173	java/lang/StringBuilder
    //   4188: dup
    //   4189: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   4192: ldc_w 1228
    //   4195: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4198: aload 10
    //   4200: bipush 16
    //   4202: invokevirtual 821	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/lang/String;
    //   4205: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4208: ldc_w 1220
    //   4211: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4214: bipush 16
    //   4216: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4219: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4222: invokestatic 327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4225: aload 8
    //   4227: astore_2
    //   4228: aload_0
    //   4229: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   4232: getfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   4235: ifne -4231 -> 4
    //   4238: aload_0
    //   4239: aload 8
    //   4241: putfield 1198	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct;
    //   4244: aload 8
    //   4246: areturn
    //   4247: aload_0
    //   4248: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   4251: getfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   4254: ifne -78 -> 4176
    //   4257: aload_0
    //   4258: getfield 43	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_b_of_type_Boolean	Z
    //   4261: ifne -85 -> 4176
    //   4264: aload_0
    //   4265: getfield 77	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Aejb	Laejb;
    //   4268: aload_0
    //   4269: getfield 103	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Int	I
    //   4272: invokeinterface 740 2 0
    //   4277: aload_0
    //   4278: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   4281: iconst_1
    //   4282: putfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   4285: goto -109 -> 4176
    //   4288: aload_0
    //   4289: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   4292: getfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   4295: ifne -119 -> 4176
    //   4298: aload_0
    //   4299: getfield 43	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_b_of_type_Boolean	Z
    //   4302: ifne -126 -> 4176
    //   4305: aload_0
    //   4306: getfield 77	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Aejb	Laejb;
    //   4309: aload_0
    //   4310: getfield 103	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Int	I
    //   4313: invokeinterface 740 2 0
    //   4318: aload_0
    //   4319: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   4322: iconst_1
    //   4323: putfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   4326: goto -150 -> 4176
    //   4329: aload 10
    //   4331: getfield 814	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_a_of_type_Long	J
    //   4334: invokestatic 818	apei:c	()J
    //   4337: lcmp
    //   4338: ifgt +91 -> 4429
    //   4341: aload 10
    //   4343: getfield 807	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_a_of_type_Boolean	Z
    //   4346: ifeq +51 -> 4397
    //   4349: aload 8
    //   4351: invokestatic 710	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   4354: invokevirtual 711	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   4357: ldc_w 712
    //   4360: invokevirtual 715	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   4363: invokevirtual 445	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   4366: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4369: ifeq +12 -> 4381
    //   4372: ldc 171
    //   4374: iconst_2
    //   4375: ldc_w 1257
    //   4378: invokestatic 327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4381: aload 8
    //   4383: astore_2
    //   4384: aload_0
    //   4385: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   4388: getfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   4391: ifne -4387 -> 4
    //   4394: aload 8
    //   4396: areturn
    //   4397: aload 8
    //   4399: getstatic 813	aywm:a	Landroid/graphics/drawable/Drawable;
    //   4402: invokevirtual 445	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   4405: aload_0
    //   4406: getfield 77	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Aejb	Laejb;
    //   4409: aload 10
    //   4411: getfield 1320	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_f_of_type_Long	J
    //   4414: aload 10
    //   4416: getfield 1321	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:jdField_f_of_type_Int	I
    //   4419: bipush 18
    //   4421: invokeinterface 477 5 0
    //   4426: goto -60 -> 4366
    //   4429: aload_0
    //   4430: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   4433: getfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   4436: ifne +31 -> 4467
    //   4439: aload_0
    //   4440: getfield 43	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_b_of_type_Boolean	Z
    //   4443: ifne +24 -> 4467
    //   4446: aload_0
    //   4447: getfield 77	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Aejb	Laejb;
    //   4450: aload_0
    //   4451: getfield 103	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Int	I
    //   4454: invokeinterface 740 2 0
    //   4459: aload_0
    //   4460: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   4463: iconst_1
    //   4464: putfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   4467: aload 8
    //   4469: invokestatic 710	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   4472: invokevirtual 711	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   4475: ldc_w 712
    //   4478: invokevirtual 715	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   4481: invokevirtual 445	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   4484: aload 8
    //   4486: invokevirtual 819	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:b	()V
    //   4489: aload 8
    //   4491: ldc_w 1264
    //   4494: ldc_w 1265
    //   4497: invokestatic 1270	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   4500: invokevirtual 1204	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setTag	(ILjava/lang/Object;)V
    //   4503: aload 8
    //   4505: areturn
    //   4506: aload 8
    //   4508: astore_2
    //   4509: ldc_w 825
    //   4512: aload 9
    //   4514: getfield 649	aeiy:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   4517: invokevirtual 221	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   4520: ifeq -4516 -> 4
    //   4523: aload_0
    //   4524: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   4527: getfield 857	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_c_of_type_Boolean	Z
    //   4530: ifeq +215 -> 4745
    //   4533: aload_0
    //   4534: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   4537: iconst_0
    //   4538: putfield 857	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_c_of_type_Boolean	Z
    //   4541: aconst_null
    //   4542: ldc_w 910
    //   4545: ldc_w 277
    //   4548: ldc_w 277
    //   4551: ldc_w 1323
    //   4554: ldc_w 1323
    //   4557: iconst_1
    //   4558: iconst_0
    //   4559: ldc_w 277
    //   4562: ldc_w 277
    //   4565: ldc_w 277
    //   4568: ldc_w 277
    //   4571: invokestatic 917	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   4574: aload 9
    //   4576: getfield 649	aeiy:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   4579: checkcast 825	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData
    //   4582: astore 7
    //   4584: aload 8
    //   4586: iload_1
    //   4587: invokevirtual 1096	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setPosition	(I)V
    //   4590: aload 8
    //   4592: aload 9
    //   4594: invokevirtual 1100	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setImageInfo	(Laeiy;)V
    //   4597: aload 8
    //   4599: iconst_0
    //   4600: invokevirtual 1103	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter$GalleryImageStruct:setIgnoreLayout	(Z)V
    //   4603: aload_0
    //   4604: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   4607: getfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   4610: ifne +31 -> 4641
    //   4613: aload_0
    //   4614: getfield 43	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_b_of_type_Boolean	Z
    //   4617: ifne +24 -> 4641
    //   4620: aload_0
    //   4621: getfield 77	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Aejb	Laejb;
    //   4624: aload_0
    //   4625: getfield 103	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_Int	I
    //   4628: invokeinterface 740 2 0
    //   4633: aload_0
    //   4634: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   4637: iconst_1
    //   4638: putfield 738	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_a_of_type_Boolean	Z
    //   4641: aload_0
    //   4642: getfield 48	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   4645: iload_1
    //   4646: invokevirtual 850	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   4649: checkcast 1325	android/graphics/drawable/Drawable
    //   4652: astore_2
    //   4653: aload 7
    //   4655: invokevirtual 1327	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:b	()Z
    //   4658: ifeq +123 -> 4781
    //   4661: aload_0
    //   4662: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   4665: invokevirtual 1292	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:getLayoutInflater	()Landroid/view/LayoutInflater;
    //   4668: ldc_w 1293
    //   4671: aconst_null
    //   4672: invokevirtual 1299	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   4675: astore_3
    //   4676: aload_3
    //   4677: ldc_w 1300
    //   4680: iconst_1
    //   4681: invokestatic 609	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4684: invokevirtual 1301	android/view/View:setTag	(ILjava/lang/Object;)V
    //   4687: aload_3
    //   4688: ldc_w 1302
    //   4691: iconst_1
    //   4692: invokestatic 609	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4695: invokevirtual 1301	android/view/View:setTag	(ILjava/lang/Object;)V
    //   4698: aload_3
    //   4699: new 1304	com/tencent/widget/Gallery$LayoutParams
    //   4702: dup
    //   4703: iconst_m1
    //   4704: iconst_m1
    //   4705: invokespecial 1306	com/tencent/widget/Gallery$LayoutParams:<init>	(II)V
    //   4708: invokevirtual 1310	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   4711: aload_3
    //   4712: ldc_w 831
    //   4715: invokevirtual 484	android/view/View:findViewById	(I)Landroid/view/View;
    //   4718: checkcast 833	com/tencent/image/URLImageView
    //   4721: astore 8
    //   4723: aload 8
    //   4725: aload_2
    //   4726: invokevirtual 1311	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   4729: aload 7
    //   4731: invokevirtual 1327	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:b	()Z
    //   4734: ifeq +187 -> 4921
    //   4737: aload 8
    //   4739: aconst_null
    //   4740: invokevirtual 1311	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   4743: aload_3
    //   4744: areturn
    //   4745: aconst_null
    //   4746: ldc_w 910
    //   4749: ldc_w 277
    //   4752: ldc_w 277
    //   4755: ldc_w 1323
    //   4758: ldc_w 1323
    //   4761: iconst_2
    //   4762: iconst_0
    //   4763: ldc_w 277
    //   4766: ldc_w 277
    //   4769: ldc_w 277
    //   4772: ldc_w 277
    //   4775: invokestatic 917	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   4778: goto -204 -> 4574
    //   4781: aload_2
    //   4782: ifnull +23 -> 4805
    //   4785: aload_2
    //   4786: checkcast 152	com/tencent/image/URLDrawable
    //   4789: invokevirtual 160	com/tencent/image/URLDrawable:getStatus	()I
    //   4792: iconst_1
    //   4793: if_icmpne +12 -> 4805
    //   4796: aload_0
    //   4797: iload_1
    //   4798: iconst_1
    //   4799: invokevirtual 448	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:a	(IZ)V
    //   4802: goto -141 -> 4661
    //   4805: aload 7
    //   4807: getfield 1328	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   4810: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4813: ifne +92 -> 4905
    //   4816: new 357	java/io/File
    //   4819: dup
    //   4820: aload 7
    //   4822: getfield 1328	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   4825: invokespecial 546	java/io/File:<init>	(Ljava/lang/String;)V
    //   4828: astore_3
    //   4829: aload_3
    //   4830: invokevirtual 549	java/io/File:exists	()Z
    //   4833: ifeq +272 -> 5105
    //   4836: invokestatic 406	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   4839: astore_2
    //   4840: aload_2
    //   4841: aload_0
    //   4842: getfield 96	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:e	I
    //   4845: putfield 1186	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   4848: aload_2
    //   4849: aload_0
    //   4850: getfield 101	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_f_of_type_Int	I
    //   4853: putfield 1189	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   4856: aload_2
    //   4857: getstatic 813	aywm:a	Landroid/graphics/drawable/Drawable;
    //   4860: putfield 427	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   4863: aload_2
    //   4864: iconst_1
    //   4865: putfield 665	com/tencent/image/URLDrawable$URLDrawableOptions:mPlayGifImage	Z
    //   4868: aload_2
    //   4869: iconst_0
    //   4870: putfield 668	com/tencent/image/URLDrawable$URLDrawableOptions:mUseExifOrientation	Z
    //   4873: aload_3
    //   4874: aload_2
    //   4875: invokestatic 755	com/tencent/image/URLDrawable:getDrawable	(Ljava/io/File;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   4878: astore_2
    //   4879: aload_2
    //   4880: checkcast 152	com/tencent/image/URLDrawable
    //   4883: iconst_1
    //   4884: invokestatic 772	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4887: invokevirtual 776	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   4890: aload_0
    //   4891: getfield 48	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   4894: iload_1
    //   4895: aload_2
    //   4896: checkcast 152	com/tencent/image/URLDrawable
    //   4899: invokevirtual 506	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   4902: goto -241 -> 4661
    //   4905: invokestatic 710	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   4908: invokevirtual 711	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   4911: ldc_w 712
    //   4914: invokevirtual 715	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   4917: astore_2
    //   4918: goto -257 -> 4661
    //   4921: aload 9
    //   4923: getfield 985	aeiy:jdField_d_of_type_Boolean	Z
    //   4926: ifeq +131 -> 5057
    //   4929: aload_0
    //   4930: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   4933: getfield 969	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_d_of_type_Boolean	Z
    //   4936: ifne +121 -> 5057
    //   4939: aload_0
    //   4940: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   4943: getfield 1279	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_b_of_type_Int	I
    //   4946: iconst_1
    //   4947: if_icmpne +44 -> 4991
    //   4950: aload_0
    //   4951: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   4954: astore_2
    //   4955: aload_2
    //   4956: aload_2
    //   4957: getfield 1279	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_b_of_type_Int	I
    //   4960: iconst_1
    //   4961: isub
    //   4962: putfield 1279	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_b_of_type_Int	I
    //   4965: aload_0
    //   4966: ldc2_w 60
    //   4969: putfield 69	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_d_of_type_Long	J
    //   4972: aload_3
    //   4973: astore_2
    //   4974: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4977: ifeq -4973 -> 4
    //   4980: ldc 171
    //   4982: iconst_1
    //   4983: ldc_w 1330
    //   4986: invokestatic 327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4989: aload_3
    //   4990: areturn
    //   4991: aload_3
    //   4992: astore_2
    //   4993: aload_0
    //   4994: getfield 75	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity	Lcom/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity;
    //   4997: getfield 1279	com/tencent/mobileqq/activity/aio/photo/AIOGalleryActivity:jdField_b_of_type_Int	I
    //   5000: ifne -4996 -> 4
    //   5003: aload_0
    //   5004: aload 7
    //   5006: getfield 995	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_f_of_type_Long	J
    //   5009: putfield 69	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_d_of_type_Long	J
    //   5012: aload 7
    //   5014: iconst_1
    //   5015: putfield 986	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:e	Z
    //   5018: aload_3
    //   5019: astore_2
    //   5020: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5023: ifeq -5019 -> 4
    //   5026: ldc 171
    //   5028: iconst_1
    //   5029: new 173	java/lang/StringBuilder
    //   5032: dup
    //   5033: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   5036: ldc_w 1332
    //   5039: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5042: aload_0
    //   5043: getfield 69	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_d_of_type_Long	J
    //   5046: invokevirtual 275	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5049: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5052: invokestatic 327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5055: aload_3
    //   5056: areturn
    //   5057: aload_0
    //   5058: aload 7
    //   5060: getfield 995	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:jdField_f_of_type_Long	J
    //   5063: putfield 69	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_d_of_type_Long	J
    //   5066: aload_3
    //   5067: astore_2
    //   5068: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5071: ifeq -5067 -> 4
    //   5074: ldc 171
    //   5076: iconst_1
    //   5077: new 173	java/lang/StringBuilder
    //   5080: dup
    //   5081: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   5084: ldc_w 1334
    //   5087: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5090: aload_0
    //   5091: getfield 69	com/tencent/mobileqq/activity/aio/photo/AIOGalleryAdapter:jdField_d_of_type_Long	J
    //   5094: invokevirtual 275	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5097: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5100: invokestatic 327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5103: aload_3
    //   5104: areturn
    //   5105: goto -444 -> 4661
    //   5108: aload_3
    //   5109: astore_2
    //   5110: goto -1446 -> 3664
    //   5113: aload 7
    //   5115: astore_3
    //   5116: goto -4189 -> 927
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5119	0	this	AIOGalleryAdapter
    //   0	5119	1	paramInt	int
    //   0	5119	2	paramView	View
    //   0	5119	3	paramViewGroup	ViewGroup
    //   242	3728	4	bool1	boolean
    //   933	3130	5	bool2	boolean
    //   1525	40	6	bool3	boolean
    //   290	4824	7	localObject1	Object
    //   19	4719	8	localObject2	Object
    //   32	4890	9	localObject3	Object
    //   210	4205	10	localObject4	Object
    //   3674	104	11	localURLDrawableOptions	URLDrawable.URLDrawableOptions
    // Exception table:
    //   from	to	target	type
    //   317	332	861	java/lang/Exception
    //   1067	1113	1446	java/lang/Throwable
    //   1435	1443	1446	java/lang/Throwable
    //   1491	1503	1537	java/lang/Exception
    //   1224	1229	1569	java/lang/Exception
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
    Object localObject;
    if (AIOImageData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
    {
      localObject = (AIOImageData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      paramViewGroup = ((AIOImageData)localObject).a(4);
      if (paramViewGroup != null) {
        break label1001;
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
        paramViewGroup.mLoadingDrawable = aywm.a;
        paramViewGroup.mFailedDrawable = aywm.a;
        paramViewGroup.mPlayGifImage = true;
        paramViewGroup.mUseExifOrientation = false;
        if ((((AIOImageData)localObject).jdField_b_of_type_Int == 1) && ((((AIOImageData)localObject).jdField_d_of_type_Int & 0x2) == 2)) {
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
            paramView.mLoadingDrawable = aywm.a;
            paramView.mFailedDrawable = aywm.a;
            if ((((AIOImageData)localObject).jdField_b_of_type_Int == 1) && ((((AIOImageData)localObject).jdField_d_of_type_Int & 0x2) == 2)) {
              paramView.mUseAutoScaleParams = false;
            }
            URLDrawable.getDrawable(((AIOImageData)localObject).a(1), paramView).startDownload();
            if ((bbfj.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) && (!bgky.a(((AIOImageData)localObject).jdField_a_of_type_Int))) {
              this.jdField_a_of_type_Aejb.a(((AIOImageData)localObject).jdField_f_of_type_Long, ((AIOImageData)localObject).jdField_f_of_type_Int, 2);
            }
          }
          else if ((bbfj.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) && (!bgky.a(((AIOImageData)localObject).jdField_a_of_type_Int)))
          {
            this.jdField_a_of_type_Aejb.a(((AIOImageData)localObject).jdField_f_of_type_Long, ((AIOImageData)localObject).jdField_f_of_type_Int, 2);
            if (QLog.isDevelopLevel())
            {
              QLog.d(" AIOGalleryAdapter", 4, "onCreateView():Thumb and large pic is not exist, download it. Gallery position is " + paramInt);
              continue;
              if (AIOShortVideoData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
              {
                paramViewGroup = (AIOShortVideoData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
                paramView = paramViewGroup.a(0);
                if (paramView != null)
                {
                  paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
                  paramViewGroup.mLoadingDrawable = aywm.a;
                  paramViewGroup.mFailedDrawable = aywm.a;
                  paramView = URLDrawable.getDrawable(paramView, paramViewGroup);
                  paramView.startDownload();
                  this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
                  if (QLog.isColorLevel()) {
                    QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): preload thumb, position=" + paramInt);
                  }
                }
                else if (paramViewGroup.jdField_b_of_type_Boolean)
                {
                  if (QLog.isColorLevel()) {
                    QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): Video error, position=" + paramInt);
                  }
                }
                else if (paramViewGroup.a(1) != null)
                {
                  if (paramViewGroup.jdField_b_of_type_Int != 0) {
                    this.jdField_a_of_type_Aejb.a(paramViewGroup.jdField_f_of_type_Long, paramViewGroup.jdField_f_of_type_Int, 0);
                  }
                  if (QLog.isColorLevel()) {
                    QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): Video exist and download thumb, position=" + paramInt);
                  }
                }
                else if (paramViewGroup.jdField_b_of_type_Int != 0)
                {
                  this.jdField_a_of_type_Aejb.a(paramViewGroup.jdField_f_of_type_Long, paramViewGroup.jdField_f_of_type_Int, 1);
                  if (QLog.isDevelopLevel()) {
                    QLog.d(" AIOGalleryAdapter", 4, "onCreateView():Thumb and video is not exist, download video only. Gallery position is " + paramInt);
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
                  paramViewGroup.mLoadingDrawable = aywm.a;
                  paramViewGroup.mFailedDrawable = aywm.a;
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
                  paramViewGroup.mLoadingDrawable = aywm.a;
                  paramViewGroup.mFailedDrawable = aywm.a;
                  URLDrawable.getDrawable(paramView, paramViewGroup).startDownload();
                  if ((bbfj.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) && (((AIOFilePicData)localObject).jdField_a_of_type_Long <= apei.c())) {
                    this.jdField_a_of_type_Aejb.a(((AIOFilePicData)localObject).jdField_f_of_type_Long, ((AIOFilePicData)localObject).jdField_f_of_type_Int, 18);
                  }
                }
                else if ((bbfj.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) && (((AIOFilePicData)localObject).jdField_a_of_type_Long <= apei.c()))
                {
                  this.jdField_a_of_type_Aejb.a(((AIOFilePicData)localObject).jdField_f_of_type_Long, ((AIOFilePicData)localObject).jdField_f_of_type_Int, 18);
                  if (QLog.isDevelopLevel()) {
                    QLog.d(" AIOGalleryAdapter", 4, "onCreateView():Thumb and large pic is not exist, download it. Gallery position is " + paramInt);
                  }
                }
              }
              else if (QLog.isColorLevel())
              {
                QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): nani...");
              }
            }
          }
        }
      }
      label1001:
      paramView = paramViewGroup;
    }
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
    aeiy localaeiy;
    if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView))
    {
      paramViewGroup = (AIOGalleryAdapter.GalleryImageStruct)paramView;
      localaeiy = a(paramInt);
      if (localaeiy != null) {
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
          localAIORichMediaData = localaeiy.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          if (AIOImageData.class.isInstance(localAIORichMediaData))
          {
            if (URLDrawable.class.isInstance(((AIOGalleryAdapter.GalleryImageStruct)paramView).a())) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().b(localaeiy.hashCode());
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
      paramViewGroup.setImageDrawable(aywm.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */