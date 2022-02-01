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
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class AIOGalleryAdapter
  extends AbstractImageAdapter
  implements QQLiveDrawable.OnDownloadListener, QQLiveDrawable.OnLoopBackListener, QQLiveDrawable.OnStateListener, OnProGalleryListener
{
  private long A = -1L;
  private int B = -1;
  private AIOGalleryAdapter.GalleryImageStruct C;
  AIOGalleryActivity a;
  IAIOImageProvider b;
  AIOImageListModel c;
  AIORichMediaData d;
  public boolean e;
  boolean f = false;
  int g;
  int i;
  String j;
  VideoPlayController k;
  long l = -1L;
  long m = -1L;
  long n = -1L;
  public AIOGalleryAdapter.OnAdapterNotify o;
  private SparseArray<URLDrawable> p = new SparseArray();
  private SparseArray<URLDrawable> q = new SparseArray();
  private URLDrawable r;
  private int s = -1;
  private URLDrawable t;
  private int u = -1;
  private AIOGalleryAdapter.GalleryImageStruct v;
  private ArrayList<String> w = new ArrayList();
  private int x;
  private int y;
  private AIOGalleryAdapter.OnTroopThumbListener z;
  
  public AIOGalleryAdapter(Context paramContext, IAIOImageProvider paramIAIOImageProvider, boolean paramBoolean, int paramInt)
  {
    this.a = ((AIOGalleryActivity)paramContext);
    this.b = paramIAIOImageProvider;
    this.x = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.y = paramContext.getResources().getDisplayMetrics().heightPixels;
    this.f = paramBoolean;
    this.g = paramInt;
    paramContext = this.a.getIntent();
    if (paramContext != null)
    {
      this.i = paramContext.getIntExtra("forward_source_uin_type", -1);
      this.j = paramContext.getStringExtra("uin");
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
    Object localObject1 = this.a;
    Object localObject2 = Boolean.valueOf(true);
    ((AIOGalleryActivity)localObject1).n = true;
    localObject1 = (AIOShortVideoData)paramAIORichMediaInfo.a;
    if (((AIOShortVideoData)localObject1).d != 0)
    {
      localObject2 = new AIOGalleryAdapter.GalleryImageStruct(this, this.a, 1);
      ((AIOGalleryAdapter.GalleryImageStruct)localObject2).setAdjustViewBounds(true);
      localURLDrawable = (URLDrawable)this.q.get(paramInt);
      ((AIOGalleryAdapter.GalleryImageStruct)localObject2).setPosition(paramInt);
      ((AIOGalleryAdapter.GalleryImageStruct)localObject2).setImageInfo(paramAIORichMediaInfo);
      ((AIOGalleryAdapter.GalleryImageStruct)localObject2).b();
      if (localURLDrawable != null)
      {
        ((AIOGalleryAdapter.GalleryImageStruct)localObject2).a.setImageDrawable(localURLDrawable);
        if (QLog.isColorLevel())
        {
          paramAIORichMediaInfo = new StringBuilder();
          paramAIORichMediaInfo.append("getView():load thumb hit cache , position is ");
          paramAIORichMediaInfo.append(paramInt);
          QLog.i(" AIOGalleryAdapter", 2, paramAIORichMediaInfo.toString());
        }
      }
      else if (((AIOShortVideoData)localObject1).c(0) != null)
      {
        a(((AIOShortVideoData)localObject1).a, ((AIOShortVideoData)localObject1).g, ((AIOShortVideoData)localObject1).h, ((AIOGalleryAdapter.GalleryImageStruct)localObject2).a, paramInt);
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
        ((AIOGalleryAdapter.GalleryImageStruct)localObject2).b.setVisibility(8);
        this.b.a(((AIOShortVideoData)localObject1).L, ((AIOShortVideoData)localObject1).M, 0);
        paramAIORichMediaInfo = new StringBuilder();
        paramAIORichMediaInfo.append("getView(): load thumb download THUMB, position is ");
        paramAIORichMediaInfo.append(paramInt);
        QLog.i(" AIOGalleryAdapter", 2, paramAIORichMediaInfo.toString());
      }
      if (this.a.k)
      {
        if (this.a.l == 1)
        {
          paramAIORichMediaInfo = this.a;
          paramAIORichMediaInfo.l -= 1;
          if (this.f)
          {
            ((AIOGalleryAdapter.GalleryImageStruct)localObject2).b(paramInt);
            this.a.k = false;
          }
        }
        else if (this.a.l == 0)
        {
          ((AIOGalleryAdapter.GalleryImageStruct)localObject2).b(paramInt);
          ReportController.b(null, "dc00898", "", "", "0X8009EF1", "0X8009EF1", 1, 0, "", "", "", "");
          this.a.k = false;
        }
      }
      else {
        ReportController.b(null, "dc00898", "", "", "0X8009EF1", "0X8009EF1", 2, 0, "", "", "", "");
      }
      if ((!this.a.g) && (!this.f))
      {
        this.b.a(this.g);
        this.a.g = true;
      }
      return localObject2;
    }
    paramAIORichMediaInfo = this.a.getLayoutInflater().inflate(2131627644, null);
    paramAIORichMediaInfo.setTag(2131296400, localObject2);
    paramAIORichMediaInfo.setTag(2131296433, localObject2);
    paramAIORichMediaInfo.setLayoutParams(new Gallery.LayoutParams(-1, -1));
    localObject2 = (URLImageView)paramAIORichMediaInfo.findViewById(2131440625);
    URLDrawable localURLDrawable = (URLDrawable)this.q.get(paramInt);
    if (localURLDrawable != null) {
      ((URLImageView)localObject2).setImageDrawable(localURLDrawable);
    } else if (((AIOShortVideoData)localObject1).c(0) != null) {
      a(((AIOShortVideoData)localObject1).a, ((AIOShortVideoData)localObject1).g, ((AIOShortVideoData)localObject1).h, (ImageView)localObject2, paramInt);
    }
    if (((AIOShortVideoData)localObject1).L != this.a.m) {
      this.a.k = false;
    }
    if (this.a.m == ((AIOShortVideoData)localObject1).L)
    {
      if (a((AIOShortVideoData)localObject1, paramAIORichMediaInfo))
      {
        ((ImageView)paramAIORichMediaInfo.findViewById(2131440624)).setVisibility(8);
        this.k.h();
      }
      this.a.k = false;
      ReportController.b(null, "dc00898", "", "", "0X8009EF2", "0X8009EF2", 1, 0, "", "", "", "");
    }
    else
    {
      ReportController.b(null, "dc00898", "", "", "0X8009EF2", "0X8009EF2", 2, 0, "", "", "", "");
    }
    if ((!this.a.g) && (!this.f))
    {
      this.b.a(this.g);
      this.a.g = true;
    }
    return paramAIORichMediaInfo;
  }
  
  private View a(AIORichMediaInfo paramAIORichMediaInfo, int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct)
  {
    if (this.a.k)
    {
      this.a.k = false;
      ReportController.b(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 1, 0, "", "", "", "");
    }
    else
    {
      ReportController.b(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 2, 0, "", "", "", "");
    }
    AIOFileVideoData localAIOFileVideoData = (AIOFileVideoData)paramAIORichMediaInfo.a;
    paramGalleryImageStruct.setPosition(paramInt);
    paramGalleryImageStruct.setImageInfo(paramAIORichMediaInfo);
    paramGalleryImageStruct.setIgnoreLayout(false);
    if ((!this.a.g) && (!this.f))
    {
      this.b.a(this.g);
      this.a.g = true;
    }
    paramGalleryImageStruct = (Drawable)this.p.get(paramInt);
    if (!localAIOFileVideoData.b()) {
      if ((paramGalleryImageStruct != null) && (((URLDrawable)paramGalleryImageStruct).getStatus() == 1))
      {
        a(paramInt, true);
      }
      else if (!TextUtils.isEmpty(localAIOFileVideoData.b))
      {
        localObject = new File(localAIOFileVideoData.b);
        if (((File)localObject).exists())
        {
          paramGalleryImageStruct = URLDrawable.URLDrawableOptions.obtain();
          paramGalleryImageStruct.mRequestWidth = this.x;
          paramGalleryImageStruct.mRequestHeight = this.y;
          paramGalleryImageStruct.mLoadingDrawable = URLDrawableHelperConstants.a;
          paramGalleryImageStruct.mPlayGifImage = true;
          paramGalleryImageStruct.mUseExifOrientation = false;
          paramGalleryImageStruct = URLDrawable.getDrawable((File)localObject, paramGalleryImageStruct);
          localObject = (URLDrawable)paramGalleryImageStruct;
          ((URLDrawable)localObject).setTag(Integer.valueOf(1));
          this.p.put(paramInt, localObject);
        }
      }
      else
      {
        paramGalleryImageStruct = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838066);
      }
    }
    Object localObject = this.a.getLayoutInflater().inflate(2131627644, null);
    ((View)localObject).setTag(2131296400, Boolean.valueOf(true));
    ((View)localObject).setTag(2131296433, Boolean.valueOf(true));
    ((View)localObject).setLayoutParams(new Gallery.LayoutParams(-1, -1));
    URLImageView localURLImageView = (URLImageView)((View)localObject).findViewById(2131440625);
    localURLImageView.setImageDrawable(paramGalleryImageStruct);
    if (localAIOFileVideoData.b())
    {
      localURLImageView.setImageDrawable(null);
      return localObject;
    }
    if ((paramAIORichMediaInfo.i) && (!this.a.n))
    {
      if (this.a.l == 1)
      {
        paramAIORichMediaInfo = this.a;
        paramAIORichMediaInfo.l -= 1;
        this.A = -1L;
        if (QLog.isColorLevel())
        {
          QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP set hasDoneItemSelectUid = -1");
          return localObject;
        }
      }
      else if (this.a.l == 0)
      {
        this.A = localAIOFileVideoData.L;
        localAIOFileVideoData.q = true;
        if (QLog.isColorLevel())
        {
          paramAIORichMediaInfo = new StringBuilder();
          paramAIORichMediaInfo.append("FileVideo_AP set hasDoneItemSelectUid = ");
          paramAIORichMediaInfo.append(this.A);
          QLog.i(" AIOGalleryAdapter", 1, paramAIORichMediaInfo.toString());
          return localObject;
        }
      }
    }
    else
    {
      this.A = localAIOFileVideoData.L;
      if (QLog.isColorLevel())
      {
        paramAIORichMediaInfo = new StringBuilder();
        paramAIORichMediaInfo.append("FileVideo_AP is not EnterImage && isAutoPlayed, set hasDoneItemSelectUid = ");
        paramAIORichMediaInfo.append(this.A);
        QLog.i(" AIOGalleryAdapter", 1, paramAIORichMediaInfo.toString());
      }
    }
    return localObject;
  }
  
  private URLDrawable a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIORichMediaInfo paramAIORichMediaInfo, AIOImageData paramAIOImageData, boolean paramBoolean, int paramInt, File paramFile)
  {
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.x;
    ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.y;
    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject1).mUseExifOrientation = false;
    ((URLDrawable.URLDrawableOptions)localObject1).mDecodeFileStrategy = 2;
    if ((paramAIOImageData.r == 1) && ((paramAIOImageData.y & 0x2) == 2)) {
      ((URLDrawable.URLDrawableOptions)localObject1).mUseAutoScaleParams = false;
    }
    Object localObject2;
    if (this.a.g)
    {
      localObject2 = this.v;
      if (localObject2 != null)
      {
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((AIOGalleryAdapter.GalleryImageStruct)localObject2).getDrawable();
        paramGalleryImageStruct.setTag(2131296389, this.v.getTag(2131296389));
        this.v = null;
      }
      else if ((paramAIOImageData.b(1) != null) && (GlobalImageCache.a.get(paramAIOImageData.b(1)) != null) && (paramAIOImageData.c(1) != null))
      {
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawable.getDrawable(paramAIOImageData.b(1), null);
      }
    }
    if (!paramBoolean) {}
    try
    {
      if (paramAIOImageData.h)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramAIOImageData.b(2));
        ((StringBuilder)localObject2).append("#");
        ((StringBuilder)localObject2).append("PART");
        localObject1 = URLDrawable.getDrawable(((StringBuilder)localObject2).toString(), (URLDrawable.URLDrawableOptions)localObject1);
      }
      else
      {
        localObject1 = URLDrawable.getDrawable(paramFile, (URLDrawable.URLDrawableOptions)localObject1);
      }
      ((URLDrawable)localObject1).setTag(Integer.valueOf(1));
      this.p.put(paramInt, localObject1);
      a((URLDrawable)localObject1, paramGalleryImageStruct, paramAIORichMediaInfo, paramInt, paramFile, paramBoolean);
      if (paramBoolean) {
        paramAIORichMediaInfo = paramAIOImageData.c;
      } else {
        paramAIORichMediaInfo = paramAIOImageData.b;
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
      if ((!paramBoolean) && (paramAIOImageData.h) && (!paramAIOImageData.f))
      {
        this.b.a(paramAIOImageData.L, paramAIOImageData.M, 2);
        if (!this.a.g)
        {
          this.v = paramGalleryImageStruct;
          return localObject1;
        }
      }
      else if ((!this.a.g) && (!this.f))
      {
        this.b.a(this.g);
        this.a.g = true;
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
  
  private void a(int paramInt, URLDrawable paramURLDrawable, boolean paramBoolean)
  {
    if (paramURLDrawable == null) {
      return;
    }
    paramURLDrawable = paramURLDrawable.getCurrDrawable();
    int i1;
    Object localObject;
    if (VideoDrawable.class.isInstance(paramURLDrawable))
    {
      ((VideoDrawable)paramURLDrawable).stopAudio();
      if (this.m > 0L)
      {
        this.l += System.currentTimeMillis() - this.m;
        paramURLDrawable = this.a.getIntent();
        if (paramURLDrawable != null)
        {
          i1 = paramURLDrawable.getIntExtra("forward_source_uin_type", -1);
          localObject = paramURLDrawable.getStringExtra("uin");
          new DCShortVideo(this.a.getApplication().getBaseContext()).a(((IAECaptureContext)QRoute.api(IAECaptureContext.class)).getAppInterface(), 2001, 0, i1, (String)localObject, this.l / 1000L);
          if (this.i == 1) {
            try
            {
              paramURLDrawable = new JSONObject();
              paramURLDrawable.put("author_id", localObject);
              paramURLDrawable.put("author_type", "1");
              paramURLDrawable.put("video_type", "1");
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(this.n);
              ((StringBuilder)localObject).append("");
              paramURLDrawable.put("video_time", ((StringBuilder)localObject).toString());
              paramURLDrawable.put("play_time", this.l);
              paramURLDrawable.put("content_type", 2);
              paramURLDrawable.put("mobile_type", Build.MODEL);
              paramURLDrawable.put("wifi_ssid", NetworkUtils.d(this.a.getApplicationContext()));
              paramURLDrawable.put("wifi_mac", NetworkUtils.c(this.a.getApplicationContext()));
              localObject = StoryReportor.a(this.a.getApplicationContext());
              if (!paramBoolean) {
                break label761;
              }
              i1 = 2;
              StoryReportor.a("story_grp", "play_video_js", 1003, i1, new String[] { paramURLDrawable.toString(), "", localObject, "" });
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
        this.m = -1L;
        this.l = -1L;
        this.n = -1L;
      }
      if (QLog.isColorLevel())
      {
        paramURLDrawable = new StringBuilder();
        paramURLDrawable.append("AIOGalleryAdapter.stopVideoAudio(): position ");
        paramURLDrawable.append(paramInt);
        QLog.i(" AIOGalleryAdapter", 2, paramURLDrawable.toString());
      }
    }
    else if ((QQLiveDrawable.class.isInstance(paramURLDrawable)) && (this.i == 1) && (this.m > 0L))
    {
      this.l += System.currentTimeMillis() - this.m;
      paramURLDrawable = this.a.getIntent();
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
        ((StringBuilder)localObject).append(this.n);
        ((StringBuilder)localObject).append("");
        paramURLDrawable.put("video_time", ((StringBuilder)localObject).toString());
        paramURLDrawable.put("play_time", this.l);
        paramURLDrawable.put("content_type", 2);
        localObject = StoryReportor.a(this.a.getApplicationContext());
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
      this.m = -1L;
      this.l = -1L;
      this.n = -1L;
      return;
      label761:
      i1 = 3;
      break;
      label767:
      paramInt = 3;
    }
  }
  
  private void a(int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIOShortVideoData paramAIOShortVideoData, File paramFile, boolean paramBoolean)
  {
    QQLiveDrawable.QQLiveDrawableParams localQQLiveDrawableParams = new QQLiveDrawable.QQLiveDrawableParams();
    localQQLiveDrawableParams.mPreviewWidth = paramAIOShortVideoData.g;
    localQQLiveDrawableParams.mPreviewHeight = paramAIOShortVideoData.h;
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
    localQQLiveDrawableParams.msgUniseq = paramAIOShortVideoData.i;
    localQQLiveDrawableParams.mVideoTime = paramAIOShortVideoData.c;
    localQQLiveDrawableParams.mReportTag = "bus_type_aio_short_fs";
    Object localObject = paramAIOShortVideoData.c(0);
    paramFile = URLDrawable.URLDrawableOptions.obtain();
    if ((localObject != null) && (((File)localObject).getAbsoluteFile() != null))
    {
      localQQLiveDrawableParams.mCoverUrl = ShortVideoUtils.getThumbUrl(((File)localObject).getAbsolutePath()).toString();
      localObject = a(localQQLiveDrawableParams.mCoverUrl, paramAIOShortVideoData.g, paramAIOShortVideoData.h);
      if ((localObject instanceof URLDrawable)) {
        paramFile.mLoadingDrawable = ((URLDrawable)localObject).getCurrDrawable();
      } else {
        paramFile.mLoadingDrawable = ((Drawable)localObject);
      }
    }
    paramFile.mExtraInfo = localQQLiveDrawableParams;
    paramFile = URLDrawable.getDrawable(ShortVideoItemBuilder.a(paramAIOShortVideoData.i), paramFile);
    paramGalleryImageStruct.setImageDrawable(paramFile);
    a(paramInt, true);
    this.t = paramFile;
    this.u = paramInt;
    this.m = System.currentTimeMillis();
    this.n = (paramAIOShortVideoData.c * 1000L);
  }
  
  private void a(int paramInt, AIORichMediaInfo paramAIORichMediaInfo, AdapterView<?> paramAdapterView, View paramView)
  {
    this.A = -1L;
    int i1 = this.u;
    if (i1 != paramInt)
    {
      Object localObject1 = this.t;
      if (localObject1 != null)
      {
        a(i1, (URLDrawable)localObject1, false);
        if ((this.t.getStatus() == 1) && ((this.t.getCurrDrawable() instanceof QQLiveDrawable)))
        {
          localObject1 = (QQLiveDrawable)this.t.getCurrDrawable();
          Object localObject2;
          if (((QQLiveDrawable)localObject1).getCurrentPosition() > 0L)
          {
            localObject2 = a(this.u);
            if ((localObject2 != null) && (((AIORichMediaInfo)localObject2).a != null) && ((((AIORichMediaInfo)localObject2).a instanceof AIOShortVideoData)))
            {
              localObject2 = (AIOShortVideoData)((AIORichMediaInfo)localObject2).a;
              a(((AIOShortVideoData)localObject2).i, ((AIOShortVideoData)localObject2).c * 1000, ((QQLiveDrawable)localObject1).getCurrentPosition());
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
          this.t = null;
        }
      }
    }
    if ((paramAIORichMediaInfo != null) && (AIOShortVideoData.class.isInstance(paramAIORichMediaInfo.a)))
    {
      a(paramAdapterView, (AIOShortVideoData)paramAIORichMediaInfo.a, paramView, paramInt);
      return;
    }
    if ((paramAIORichMediaInfo != null) && (AIOImageData.class.isInstance(paramAIORichMediaInfo.a)))
    {
      paramAIORichMediaInfo = (AIOImageData)paramAIORichMediaInfo.a;
      if ((paramAIORichMediaInfo.r == 3) && (paramAIORichMediaInfo.c(1) == null) && (paramAIORichMediaInfo.c(2) == null) && (paramAIORichMediaInfo.c(4) == null))
      {
        if (paramAIORichMediaInfo.O >= ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize()) {
          return;
        }
        a(paramInt, -1);
      }
    }
    else
    {
      this.u = -1;
      this.t = null;
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, " onItemSelected():else Data is mVideoDrawable set null");
      }
    }
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (!AIOSingleReporter.a().a(paramLong1, "0X8009AA6"))
    {
      AIOSingleReporter.a().b(paramLong1, "0X8009AA6");
      ShortVideoUtils.reportVideoPlayEvent(null, this.i, this.j, 2, 2, paramLong2, paramLong3);
    }
  }
  
  private void a(URLDrawable paramURLDrawable, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIORichMediaInfo paramAIORichMediaInfo, int paramInt, File paramFile, boolean paramBoolean)
  {
    int i1 = paramURLDrawable.getStatus();
    boolean bool = true;
    if (i1 != 1)
    {
      if ((i1 != 2) && (i1 != 3)) {
        break label109;
      }
    }
    else
    {
      if (paramAIORichMediaInfo.c == -2) {
        try
        {
          paramAIORichMediaInfo.c = JpegExifReader.readOrientation(paramFile.getAbsolutePath());
        }
        catch (Exception paramFile)
        {
          if (QLog.isColorLevel()) {
            QLog.e(" AIOGalleryAdapter", 2, "read exif error", paramFile);
          }
          paramAIORichMediaInfo.c = 1;
        }
      }
      a(paramGalleryImageStruct, paramURLDrawable, paramAIORichMediaInfo.c);
    }
    if (paramURLDrawable.getStatus() != 1) {
      bool = false;
    }
    a(paramInt, bool);
    label109:
    paramGalleryImageStruct.setImageDrawable(paramURLDrawable);
    paramGalleryImageStruct.setOriginalImage(paramBoolean);
    if (!this.a.g) {
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
    Object localObject2 = paramAIOFilePicData.c(20);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = paramAIOFilePicData.c(18);
      if (localObject1 == null)
      {
        localObject1 = paramAIOFilePicData.c(16);
        if (localObject1 != null)
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelperConstants.a;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = URLDrawableHelperConstants.a;
          URLDrawable.getDrawable((File)localObject1, (URLDrawable.URLDrawableOptions)localObject2).startDownload();
          if ((!NetworkUtil.isWifiConnected(this.a)) || (paramAIOFilePicData.l > ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize())) {
            return;
          }
          this.b.a(paramAIOFilePicData.L, paramAIOFilePicData.M, 18);
          return;
        }
        if ((!NetworkUtil.isWifiConnected(this.a)) || (paramAIOFilePicData.l > ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize())) {
          return;
        }
        this.b.a(paramAIOFilePicData.L, paramAIOFilePicData.M, 18);
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
    this.p.put(paramInt, paramAIOFilePicData);
  }
  
  private void a(AIOFilePicData paramAIOFilePicData, int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIORichMediaInfo paramAIORichMediaInfo, boolean paramBoolean)
  {
    Object localObject;
    if (paramAIOFilePicData.g)
    {
      localObject = paramGalleryImageStruct.getDrawable();
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
      if ((localObject == null) && (FileUtil.b(((AIOFilePicData)paramAIORichMediaInfo.a).c)))
      {
        paramAIOFilePicData = URLDrawable.URLDrawableOptions.obtain();
        paramAIOFilePicData.mLoadingDrawable = URLDrawableHelperConstants.a;
        paramAIOFilePicData.mFailedDrawable = URLDrawableHelperConstants.a;
        paramAIOFilePicData = URLDrawable.getDrawable(new File(((AIOFilePicData)paramAIORichMediaInfo.a).c), paramAIOFilePicData);
        if (paramAIOFilePicData != null)
        {
          paramGalleryImageStruct.setImageDrawable(paramAIOFilePicData);
          paramAIOFilePicData.downloadImediatly();
        }
      }
      else if ((paramAIOFilePicData == null) || (localObject == null) || ((!"PART".equals(localObject)) && (!"DISPLAY".equals(localObject))))
      {
        paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838066));
        a(paramInt, false);
        this.a.d().d();
        if (((AIOFilePicData)paramAIORichMediaInfo.a).l >= ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize()) {
          paramGalleryImageStruct.c();
        }
      }
    }
    else
    {
      File localFile = paramAIOFilePicData.c(18);
      if (localFile != null)
      {
        localObject = paramAIOFilePicData.b(18);
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
        paramAIOFilePicData = FileUtils.estimateFileType(paramAIOFilePicData.d);
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
        this.a.d().c();
      }
    }
  }
  
  private void a(AIOFileVideoData paramAIOFileVideoData, int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mUseExifOrientation = false;
    localURLDrawableOptions.mPlayGifImage = true;
    paramAIOFileVideoData = paramAIOFileVideoData.c(0);
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
      this.a.d().c();
      return;
    }
    paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838066));
    a(paramInt, true);
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, int paramInt)
  {
    if (this.a.g)
    {
      Object localObject = this.v;
      if (localObject != null)
      {
        localObject = ((AIOGalleryAdapter.GalleryImageStruct)localObject).getDrawable();
        paramGalleryImageStruct.setImageDrawable((Drawable)localObject);
        if (URLDrawable.class.isInstance(localObject)) {
          this.p.put(paramInt, (URLDrawable)localObject);
        }
        this.v = null;
        break label80;
      }
    }
    paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838066));
    a(paramInt, false);
    label80:
    if (QLog.isColorLevel()) {
      QLog.i(" AIOGalleryAdapter", 2, "getView(): IMAGE_FILE_ERROR");
    }
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, int paramInt, AIORichMediaInfo paramAIORichMediaInfo)
  {
    Object localObject1 = this.a;
    ((AIOGalleryActivity)localObject1).n = true;
    boolean bool2 = ((AIOGalleryActivity)localObject1).k;
    boolean bool1 = false;
    if (bool2)
    {
      this.a.k = false;
      ReportController.b(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 1, 0, "", "", "", "");
    }
    else
    {
      ReportController.b(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 2, 0, "", "", "", "");
    }
    paramGalleryImageStruct.setCenterBtnVisiable(8);
    AIOFilePicData localAIOFilePicData = (AIOFilePicData)paramAIORichMediaInfo.a;
    paramGalleryImageStruct.setPosition(paramInt);
    paramGalleryImageStruct.setImageInfo(paramAIORichMediaInfo);
    paramGalleryImageStruct.setIgnoreLayout(false);
    localObject1 = (URLDrawable)this.p.get(paramInt);
    Object localObject2;
    if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1))
    {
      paramGalleryImageStruct.setImageDrawable((Drawable)localObject1);
      String str = localAIOFilePicData.b(20);
      localObject2 = ((URLDrawable)localObject1).getURL().toString();
      a(paramInt, true);
      if (((String)localObject2).equals(str)) {
        paramGalleryImageStruct.setOriginalImage(true);
      }
      if (paramAIORichMediaInfo.c == -2) {
        paramAIORichMediaInfo.c = JpegExifReader.readOrientation(((URLDrawable)localObject1).getURL().getFile());
      }
      a(paramGalleryImageStruct, (URLDrawable)localObject1, paramAIORichMediaInfo.c);
      if (paramGalleryImageStruct.a()) {
        paramGalleryImageStruct = localAIOFilePicData.e;
      } else {
        paramGalleryImageStruct = localAIOFilePicData.d;
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
      localObject2 = localAIOFilePicData.c(20);
      if (localObject2 == null)
      {
        localObject1 = localAIOFilePicData.c(18);
        if (localObject1 == null)
        {
          localObject1 = localAIOFilePicData.c(16);
          if (localObject1 != null)
          {
            a(paramGalleryImageStruct, paramInt, paramAIORichMediaInfo, localAIOFilePicData, (File)localObject1);
            return;
          }
          if (localAIOFilePicData.l <= ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize())
          {
            if (localAIOFilePicData.g)
            {
              paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838066));
            }
            else
            {
              paramGalleryImageStruct.setImageDrawable(URLDrawableHelperConstants.a);
              this.b.a(localAIOFilePicData.L, localAIOFilePicData.M, 18);
            }
            if (QLog.isColorLevel()) {
              QLog.i(" AIOGalleryAdapter", 2, "getView(): No pic");
            }
            bool1 = this.a.g;
            return;
          }
          if ((!this.a.g) && (!this.f))
          {
            this.b.a(this.g);
            this.a.g = true;
          }
          paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838066));
          paramGalleryImageStruct.c();
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
    if (!paramAIOFilePicData.k)
    {
      if (paramAIOFilePicData.l <= ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize())
      {
        paramFile.downloadImediatly();
        a(paramInt, paramAIORichMediaInfo.b / 100);
        this.b.a(paramAIOFilePicData.L, paramAIOFilePicData.M, 18);
      }
      else if ((!this.a.g) && (!this.f))
      {
        this.b.a(this.g);
        this.a.g = true;
      }
    }
    else if ((!this.a.g) && (!this.f))
    {
      this.b.a(this.g);
      this.a.g = true;
    }
    if (QLog.isColorLevel())
    {
      paramAIORichMediaInfo = new StringBuilder();
      paramAIORichMediaInfo.append("getView(): url is ");
      paramAIORichMediaInfo.append(paramAIOFilePicData.b(16));
      paramAIORichMediaInfo.append(", file type is ");
      paramAIORichMediaInfo.append(16);
      QLog.i(" AIOGalleryAdapter", 2, paramAIORichMediaInfo.toString());
    }
    if (!this.a.g) {
      this.v = paramGalleryImageStruct;
    }
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, int paramInt, AIORichMediaInfo paramAIORichMediaInfo, AIOFilePicData paramAIOFilePicData, boolean paramBoolean, File paramFile)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.x;
    localURLDrawableOptions.mRequestHeight = this.y;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mPlayGifImage = true;
    if (paramBoolean == true)
    {
      paramGalleryImageStruct.setOriginalImage(true);
      File localFile = paramAIOFilePicData.c(18);
      localObject = localFile;
      if (localFile == null) {
        localObject = paramAIOFilePicData.c(16);
      }
      if (localObject != null) {
        paramGalleryImageStruct.setImageDrawable(URLDrawable.getDrawable((File)localObject, localURLDrawableOptions));
      }
    }
    if (this.a.g)
    {
      localObject = this.v;
      if (localObject != null)
      {
        localURLDrawableOptions.mLoadingDrawable = ((AIOGalleryAdapter.GalleryImageStruct)localObject).getDrawable();
        this.v = null;
      }
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.x;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.y;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    boolean bool2 = false;
    boolean bool1 = false;
    ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
    localObject = URLDrawable.getDrawable(paramFile, (URLDrawable.URLDrawableOptions)localObject);
    ((URLDrawable)localObject).setTag(Integer.valueOf(1));
    this.p.put(paramInt, localObject);
    a(paramInt, -1);
    int i1 = ((URLDrawable)localObject).getStatus();
    if (i1 != 1)
    {
      if ((i1 != 2) && (i1 != 3))
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
      if (paramAIORichMediaInfo.c == -2) {
        paramAIORichMediaInfo.c = JpegExifReader.readOrientation(paramFile.getAbsolutePath());
      }
      paramGalleryImageStruct.setImageDrawable((Drawable)localObject);
      a(paramGalleryImageStruct, (URLDrawable)localObject, paramAIORichMediaInfo.c);
      bool1 = bool2;
      if (((URLDrawable)localObject).getStatus() == 1) {
        bool1 = true;
      }
      a(paramInt, bool1);
    }
    if (paramBoolean) {
      paramGalleryImageStruct = paramAIOFilePicData.e;
    } else {
      paramGalleryImageStruct = paramAIOFilePicData.d;
    }
    FileUtils.estimateFileType(paramGalleryImageStruct);
    if ((!this.a.g) && (!this.f))
    {
      this.b.a(this.g);
      this.a.g = true;
    }
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIORichMediaInfo paramAIORichMediaInfo, int paramInt, AIOImageData paramAIOImageData)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mUseExifOrientation = false;
    if ((paramAIOImageData.r == 1) && ((paramAIOImageData.y & 0x2) == 2)) {
      localURLDrawableOptions.mUseAutoScaleParams = false;
    }
    paramGalleryImageStruct.setImageDrawable(URLDrawable.getDrawable(paramAIOImageData.b(8), localURLDrawableOptions));
    a(paramInt, paramAIORichMediaInfo.b / 100);
    if (QLog.isColorLevel())
    {
      paramAIORichMediaInfo = new StringBuilder();
      paramAIORichMediaInfo.append("getView(): url is ");
      paramAIORichMediaInfo.append(paramAIOImageData.b(8));
      paramAIORichMediaInfo.append(", file type is ");
      paramAIORichMediaInfo.append(8);
      QLog.i(" AIOGalleryAdapter", 2, paramAIORichMediaInfo.toString());
    }
    if (!paramAIOImageData.f)
    {
      this.b.a(paramAIOImageData.L, paramAIOImageData.M, 2);
    }
    else if ((!this.a.g) && (!this.f))
    {
      this.b.a(this.g);
      this.a.g = true;
    }
    if (!this.a.g)
    {
      this.v = paramGalleryImageStruct;
      this.a.d().a(true);
    }
    if ((QLog.isDevelopLevel()) && (paramAIOImageData.h)) {
      QQToast.makeText(paramGalleryImageStruct.getContext(), "Refresh temp display image", 2000).show();
    }
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIORichMediaInfo paramAIORichMediaInfo, int paramInt, AIOImageData paramAIOImageData, File paramFile)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
    if ((paramAIOImageData.r == 1) && ((paramAIOImageData.y & 0x2) == 2)) {
      localURLDrawableOptions.mUseAutoScaleParams = false;
    }
    paramFile = URLDrawable.getDrawable(paramFile, localURLDrawableOptions);
    paramGalleryImageStruct.setImageDrawable(paramFile);
    if (!paramAIOImageData.t)
    {
      paramFile.downloadImediatly();
      a(paramInt, paramAIORichMediaInfo.b / 100);
      this.b.a(paramAIOImageData.L, paramAIOImageData.M, 2);
      if (QLog.isColorLevel())
      {
        paramAIORichMediaInfo = new StringBuilder();
        paramAIORichMediaInfo.append("getView(): url is ");
        paramAIORichMediaInfo.append(paramAIOImageData.b(1));
        paramAIORichMediaInfo.append(", file type is ");
        paramAIORichMediaInfo.append(1);
        QLog.i(" AIOGalleryAdapter", 2, paramAIORichMediaInfo.toString());
      }
      if (!this.a.g)
      {
        this.v = paramGalleryImageStruct;
        this.a.d().a(paramAIOImageData.k);
      }
    }
    else
    {
      paramAIORichMediaInfo = TroopMemberApiClient.a();
      paramAIORichMediaInfo.e();
      paramAIORichMediaInfo.a(this.a.i, paramAIOImageData, 640, new AIOGalleryAdapter.4(this, paramInt, paramGalleryImageStruct, paramAIOImageData));
    }
  }
  
  private void a(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIORichMediaInfo paramAIORichMediaInfo, URLDrawable paramURLDrawable, AIOImageData paramAIOImageData)
  {
    paramGalleryImageStruct.setImageDrawable(paramURLDrawable);
    String str2 = paramAIOImageData.b(4);
    String str1 = paramURLDrawable.getURL().toString();
    if (str1.equals(str2)) {
      paramGalleryImageStruct.setOriginalImage(true);
    }
    if (paramAIORichMediaInfo.c == -2) {
      try
      {
        paramAIORichMediaInfo.c = JpegExifReader.readOrientation(paramURLDrawable.getURL().getFile());
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e(" AIOGalleryAdapter", 2, "read exif error", localException);
        }
        paramAIORichMediaInfo.c = 1;
      }
    }
    a(paramGalleryImageStruct, paramURLDrawable, paramAIORichMediaInfo.c);
    if (paramGalleryImageStruct.a()) {
      paramGalleryImageStruct = paramAIOImageData.c;
    } else {
      paramGalleryImageStruct = paramAIOImageData.b;
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
    if (paramAIOImageData.h) {
      this.b.a(paramAIOImageData.L, paramAIOImageData.M, 2);
    }
  }
  
  private void a(AIOImageData paramAIOImageData)
  {
    if (this.a.k)
    {
      this.a.k = false;
      if ((paramAIOImageData.Q == 1) && (paramAIOImageData.C))
      {
        ReportController.b(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 1, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "dc00898", "", "", "0X8009EEF", "0X8009EEF", 1, 0, "", "", "", "");
      return;
    }
    if ((paramAIOImageData.Q == 1) && (paramAIOImageData.C))
    {
      ReportController.b(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 2, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X8009EEF", "0X8009EEF", 2, 0, "", "", "", "");
  }
  
  private void a(AIOImageData paramAIOImageData, int paramInt)
  {
    Object localObject2 = paramAIOImageData.c(4);
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = paramAIOImageData.c(2);
      if (localObject1 == null)
      {
        if ((paramAIOImageData.g) || (paramAIOImageData.f)) {
          return;
        }
        if (paramAIOImageData.e) {
          return;
        }
        if (paramAIOImageData.c(1) != null)
        {
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelperConstants.a;
          ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = URLDrawableHelperConstants.a;
          if ((paramAIOImageData.r == 1) && ((paramAIOImageData.y & 0x2) == 2)) {
            ((URLDrawable.URLDrawableOptions)localObject1).mUseAutoScaleParams = false;
          }
          URLDrawable.getDrawable(paramAIOImageData.b(1), (URLDrawable.URLDrawableOptions)localObject1).startDownload();
          if ((!NetworkUtil.isWifiConnected(this.a)) || (((IPicUtil)QRoute.api(IPicUtil.class)).isDynamicImg(paramAIOImageData.i))) {
            return;
          }
          this.b.a(paramAIOImageData.L, paramAIOImageData.M, 2);
          return;
        }
        if ((!NetworkUtil.isWifiConnected(this.a)) || (((IPicUtil)QRoute.api(IPicUtil.class)).isDynamicImg(paramAIOImageData.i))) {
          return;
        }
        this.b.a(paramAIOImageData.L, paramAIOImageData.M, 2);
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
    int i1;
    if (localObject2 != null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject2).mUseExifOrientation = false;
    if ((paramAIOImageData.r == 1) && ((paramAIOImageData.y & 0x2) == 2)) {
      ((URLDrawable.URLDrawableOptions)localObject2).mUseAutoScaleParams = false;
    }
    if ((i1 == 0) && (paramAIOImageData.h))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramAIOImageData.b(2));
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
    this.p.put(paramInt, paramAIOImageData);
  }
  
  private void a(AIOImageData paramAIOImageData, String paramString1, String paramString2, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, int paramInt, AIORichMediaInfo paramAIORichMediaInfo, boolean paramBoolean)
  {
    if (paramString1 != null) {
      paramAIOImageData.b = paramString1;
    }
    if (paramString2 != null) {
      paramAIOImageData.a = paramString2;
    }
    boolean bool = paramAIOImageData.f;
    paramString1 = null;
    if (bool)
    {
      paramString2 = paramGalleryImageStruct.getDrawable();
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
        paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838066));
        a(paramInt, false);
        this.a.d().d();
      }
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): IMAGE_FILE_ERROR");
      }
      if ((QLog.isDevelopLevel()) && (paramAIOImageData.h)) {
        QQToast.makeText(paramGalleryImageStruct.getContext(), "AIOGalleryAdapter.updateView(): error!", 2000).show();
      }
    }
    else
    {
      File localFile = paramAIOImageData.c(2);
      if (localFile != null)
      {
        paramString2 = paramAIOImageData.b(2);
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
          paramAIORichMediaInfo.c = JpegExifReader.readOrientation(localFile.getAbsolutePath());
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("AIOGalleryAdapter.updateView(): read orientation:");
            paramString2.append(paramAIORichMediaInfo.c);
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
        if (paramAIOImageData.r == 3)
        {
          paramAIORichMediaInfo = paramAIOImageData.c(1);
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
        if ((paramString2.getStatus() == 1) && (!paramAIOImageData.h))
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
        paramString2 = FileUtils.estimateFileType(paramAIOImageData.b);
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
        paramAIOImageData.h = paramBoolean;
        this.a.d().c();
        return;
      }
      if (paramAIOImageData.c(1) != null) {
        paramGalleryImageStruct.setImageDrawable(URLDrawable.getDrawable(paramAIOImageData.b(1), URLDrawable.URLDrawableOptions.obtain()));
      }
    }
  }
  
  private void a(AIORichMediaInfo paramAIORichMediaInfo, View paramView)
  {
    this.B = 1;
    a(this.u, this.t, false);
    Object localObject1 = this.t;
    if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1) && ((this.t.getCurrDrawable() instanceof QQLiveDrawable)))
    {
      localObject1 = (QQLiveDrawable)this.t.getCurrDrawable();
      if (((QQLiveDrawable)localObject1).getCurrentPosition() > 0L)
      {
        Object localObject2 = a(this.u);
        if ((localObject2 != null) && (((AIORichMediaInfo)localObject2).a != null) && ((((AIORichMediaInfo)localObject2).a instanceof AIOShortVideoData)))
        {
          localObject2 = (AIOShortVideoData)((AIORichMediaInfo)localObject2).a;
          a(((AIOShortVideoData)localObject2).i, ((AIOShortVideoData)localObject2).c * 1000, ((QQLiveDrawable)localObject1).getCurrentPosition());
        }
      }
      ((QQLiveDrawable)localObject1).recyleAndNotKeepPosition();
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, " recyleAndNotKeepPosition ");
      }
      this.t = null;
    }
    if ((paramAIORichMediaInfo != null) && (AIOShortVideoData.class.isInstance(paramAIORichMediaInfo.a)))
    {
      b(paramAIORichMediaInfo, paramView);
      return;
    }
    if ((paramAIORichMediaInfo != null) && (AIOFileVideoData.class.isInstance(paramAIORichMediaInfo.a)))
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
    File localFile = paramAIOShortVideoData.c(0);
    if (localFile != null)
    {
      paramAIOShortVideoData = URLDrawable.URLDrawableOptions.obtain();
      paramAIOShortVideoData.mLoadingDrawable = URLDrawableHelperConstants.a;
      paramAIOShortVideoData.mFailedDrawable = URLDrawableHelperConstants.a;
      paramAIOShortVideoData = URLDrawable.getDrawable(localFile, paramAIOShortVideoData);
      paramAIOShortVideoData.startDownload();
      this.q.put(paramInt, paramAIOShortVideoData);
      if (QLog.isColorLevel())
      {
        paramAIOShortVideoData = new StringBuilder();
        paramAIOShortVideoData.append("AIOGalleryAdapter.onCreateView(): preload thumb, position=");
        paramAIOShortVideoData.append(paramInt);
        QLog.i(" AIOGalleryAdapter", 2, paramAIOShortVideoData.toString());
      }
    }
    else if (paramAIOShortVideoData.f)
    {
      if (QLog.isColorLevel())
      {
        paramAIOShortVideoData = new StringBuilder();
        paramAIOShortVideoData.append("AIOGalleryAdapter.onCreateView(): Video error, position=");
        paramAIOShortVideoData.append(paramInt);
        QLog.i(" AIOGalleryAdapter", 2, paramAIOShortVideoData.toString());
      }
    }
    else if (paramAIOShortVideoData.c(1) != null)
    {
      if (paramAIOShortVideoData.d != 0) {
        this.b.a(paramAIOShortVideoData.L, paramAIOShortVideoData.M, 0);
      }
      if (QLog.isColorLevel())
      {
        paramAIOShortVideoData = new StringBuilder();
        paramAIOShortVideoData.append("AIOGalleryAdapter.onCreateView(): Video exist and download thumb, position=");
        paramAIOShortVideoData.append(paramInt);
        QLog.i(" AIOGalleryAdapter", 2, paramAIOShortVideoData.toString());
      }
    }
    else if (paramAIOShortVideoData.d != 0)
    {
      this.b.a(paramAIOShortVideoData.L, paramAIOShortVideoData.M, 1);
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
    if (paramAIOShortVideoData.d != 0) {
      if (paramAIOShortVideoData.f)
      {
        paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838066));
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
        File localFile = paramAIOShortVideoData.c(1);
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
        else if ((paramAIOShortVideoData.c(0) != null) && (QLog.isColorLevel()))
        {
          paramAIOShortVideoData = new StringBuilder();
          paramAIOShortVideoData.append("AIOGalleryAdapter.updateView(): thumb downloaded, position=");
          paramAIOShortVideoData.append(paramInt);
          QLog.i(" AIOGalleryAdapter", 2, paramAIOShortVideoData.toString());
        }
      }
    }
  }
  
  private void a(AdapterView<?> paramAdapterView, AIOShortVideoData paramAIOShortVideoData, View paramView, int paramInt)
  {
    this.C = ((AIOGalleryAdapter.GalleryImageStruct)paramView);
    this.B = 0;
    if (this.u == -1) {
      ReportController.b(null, "dc00898", "", "", "0X8007424", "0X8007424", 0, 0, "", "", "", "");
    }
    if ((paramAdapterView != null) && (paramAdapterView.getVisibility() == 0) && (this.a.getIntent() != null))
    {
      Object localObject = this.a.getIntent();
      boolean bool = this.a.getIntent().getBooleanExtra("extra.FROM_AIO", false);
      paramView = "3";
      if (bool) {
        paramAdapterView = "1";
      } else {
        paramAdapterView = "3";
      }
      int i1 = this.a.getIntent().getIntExtra("forward_source_uin_type", -1);
      localObject = ((Intent)localObject).getStringExtra("leftViewText");
      if (localObject != null)
      {
        if (((String)localObject).equals(HardCodeUtil.a(2131898330))) {}
        for (paramAdapterView = "2";; paramAdapterView = paramView)
        {
          break;
          if ((i1 != 1) || (this.a.a == null) || (this.a.a.c == null)) {
            break;
          }
        }
      }
      ShortVideoUtils.reportVideoPlay(MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), this.a.getIntent().getStringExtra("uin"), String.valueOf(paramAIOShortVideoData.c * 1000), i1, "2", paramAdapterView);
    }
    paramAdapterView = (AIOGalleryScene)this.a.a.c();
    if ((paramAdapterView != null) && (paramAdapterView.ax))
    {
      paramAdapterView.ax = false;
      paramAdapterView = this.C;
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
          this.q.put(paramInt3, (URLDrawable)paramString);
        }
        paramImageView.setImageDrawable(paramString);
        return;
      }
      QLog.d(" AIOGalleryAdapter", 2, "url  is null ");
    }
  }
  
  private void b(AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct, AIORichMediaInfo paramAIORichMediaInfo, int paramInt, AIOImageData paramAIOImageData)
  {
    if (!paramAIOImageData.t)
    {
      a(paramInt, paramAIORichMediaInfo.b / 100);
      paramGalleryImageStruct.setImageDrawable(URLDrawableHelperConstants.a);
      this.b.a(paramAIOImageData.L, paramAIOImageData.M, 2);
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "getView(): No pic");
      }
    }
    else if (paramAIOImageData.O <= ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize())
    {
      a(paramInt, paramAIORichMediaInfo.b / 100);
      paramGalleryImageStruct.setImageDrawable(URLDrawableHelperConstants.a);
      paramAIORichMediaInfo = TroopMemberApiClient.a();
      paramAIORichMediaInfo.e();
      paramAIORichMediaInfo.a(this.a.i, paramAIOImageData, 383, new AIOGalleryAdapter.5(this));
      a(paramInt, 0);
      paramAIORichMediaInfo.a(this.a.i, paramAIOImageData, 640, new AIOGalleryAdapter.6(this, paramInt, paramGalleryImageStruct, paramAIOImageData));
    }
    else
    {
      if ((!this.a.g) && (!this.f)) {
        this.a.g = true;
      }
      paramGalleryImageStruct.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838066));
      paramGalleryImageStruct.c();
      paramGalleryImageStruct.setTag(2131296386, Float.valueOf(1.5F));
    }
    if (!this.a.g) {
      this.a.d().a(paramAIOImageData.k);
    }
  }
  
  private void b(AIORichMediaInfo paramAIORichMediaInfo, View paramView)
  {
    this.a.n = true;
    Object localObject = (AIOShortVideoData)paramAIORichMediaInfo.a;
    if ((localObject != null) && (((AIOShortVideoData)localObject).d == 0) && (this.a.m != ((AIOShortVideoData)localObject).L))
    {
      paramAIORichMediaInfo = a((AIOShortVideoData)localObject);
      if (paramAIORichMediaInfo == null)
      {
        b((AIOShortVideoData)localObject, paramView);
        if (QLog.isColorLevel()) {
          QLog.i(" AIOGalleryAdapter", 2, "onItemSelect undownload notequal");
        }
      }
      else
      {
        localObject = this.k;
        if (localObject != null)
        {
          ((VideoPlayController)localObject).a(paramView, paramAIORichMediaInfo);
          paramAIORichMediaInfo = (AIOGalleryScene)this.a.a.c();
          if ((paramAIORichMediaInfo != null) && (paramAIORichMediaInfo.ax))
          {
            if (QLog.isColorLevel()) {
              QLog.i(" AIOGalleryAdapter", 2, "onItemSelect from nine");
            }
            paramAIORichMediaInfo.ax = false;
            this.k.h();
            this.A = -1L;
          }
        }
      }
    }
  }
  
  private void b(AIOShortVideoData paramAIOShortVideoData, View paramView)
  {
    this.b.a(paramAIOShortVideoData.L, paramAIOShortVideoData.M, 1);
    ((ImageView)paramView.findViewById(2131440624)).setVisibility(8);
    paramView = this.k;
    if (paramView != null) {
      paramView.a(paramAIOShortVideoData, true, false);
    }
  }
  
  private void c(AIORichMediaInfo paramAIORichMediaInfo, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP onItemSelected is FileVideodata ");
    }
    AIOFileVideoData localAIOFileVideoData = (AIOFileVideoData)paramAIORichMediaInfo.a;
    if (paramAIORichMediaInfo.i) {
      localAIOFileVideoData.q = true;
    }
    if (localAIOFileVideoData.a(this.b))
    {
      if (this.a.n) {
        this.A = -1L;
      }
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP onItemSelected needUrl return ");
      }
      return;
    }
    AIOGalleryScene localAIOGalleryScene = (AIOGalleryScene)this.a.a.c();
    int i1;
    if ((localAIOGalleryScene != null) && (localAIOGalleryScene.aq == 3)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    long l1;
    if ((paramAIORichMediaInfo.i) && ((!this.a.n) || (i1 != 0)))
    {
      if (i1 == 0)
      {
        l1 = this.A;
        if ((l1 == -1L) || (l1 != localAIOFileVideoData.L)) {}
      }
      else
      {
        this.a.n = true;
        this.A = -1L;
        localAIOFileVideoData.q = true;
        paramAIORichMediaInfo = localAIOFileVideoData.a(this.e);
        this.k.a(paramView, paramAIORichMediaInfo);
        this.k.c();
        this.k.h();
        this.k.b(8);
        if (localAIOGalleryScene != null)
        {
          if (QLog.isColorLevel())
          {
            paramAIORichMediaInfo = new StringBuilder();
            paramAIORichMediaInfo.append("FileVideo_AP onItemSelected, aioGalleryScene.mIsMute =  ");
            paramAIORichMediaInfo.append(localAIOGalleryScene.as);
            QLog.d(" AIOGalleryAdapter", 2, paramAIORichMediaInfo.toString());
          }
          localAIOGalleryScene.as = false;
        }
        this.e = false;
      }
    }
    else if (this.a.n) {
      if (i1 == 0)
      {
        l1 = this.A;
        if ((l1 == -1L) || (l1 != localAIOFileVideoData.L)) {}
      }
      else
      {
        this.A = -1L;
        paramAIORichMediaInfo = localAIOFileVideoData.a(this.e);
        this.k.a(paramView, paramAIORichMediaInfo);
        if (QLog.isColorLevel()) {
          QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP onItemSelected need user click ");
        }
      }
    }
  }
  
  private String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Actives: ");
    int i1 = 0;
    while (i1 < this.p.size())
    {
      if (i1 > 0) {
        localStringBuilder.append(" , ");
      }
      localStringBuilder.append(this.p.keyAt(i1) + 1);
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void OnDownload(String paramString1, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, String paramString2)
  {
    new Handler(Looper.getMainLooper()).post(new AIOGalleryAdapter.3(this));
  }
  
  public AIORichMediaInfo a(int paramInt)
  {
    AIOImageListModel localAIOImageListModel = this.c;
    if (localAIOImageListModel == null) {
      return null;
    }
    return localAIOImageListModel.a(paramInt);
  }
  
  public VideoPlayMedioInfo a(AIOShortVideoData paramAIOShortVideoData)
  {
    Object localObject = new File(paramAIOShortVideoData.b);
    long l1;
    if (((File)localObject).exists())
    {
      l1 = ((File)localObject).length();
      if (l1 >= paramAIOShortVideoData.O)
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
      l1 = 0L;
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
      LongVideoUrlCacheManager.UrlsCacheBean localUrlsCacheBean = LongVideoUrlCacheManager.a().a(paramAIOShortVideoData.L);
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
          ((VideoPlayMedioInfo)localObject).a = true;
          ((VideoPlayMedioInfo)localObject).c = localUrlsCacheBean.a;
          ((VideoPlayMedioInfo)localObject).f = localUrlsCacheBean.c;
          ((VideoPlayMedioInfo)localObject).g = localUrlsCacheBean.d;
          ((VideoPlayMedioInfo)localObject).k = paramAIOShortVideoData.L;
          ((VideoPlayMedioInfo)localObject).l = paramAIOShortVideoData.M;
        }
      }
    }
    else
    {
      localObject = new VideoPlayMedioInfo();
      ((VideoPlayMedioInfo)localObject).a = false;
      ((VideoPlayMedioInfo)localObject).k = paramAIOShortVideoData.L;
      ((VideoPlayMedioInfo)localObject).l = paramAIOShortVideoData.M;
      ((VideoPlayMedioInfo)localObject).b = paramAIOShortVideoData.b;
      ((VideoPlayMedioInfo)localObject).p = l1;
    }
    if ((localObject != null) && (this.e))
    {
      localAIORichMediaData = this.d;
      if ((localAIORichMediaData != null) && (localAIORichMediaData.L == paramAIOShortVideoData.L))
      {
        ((VideoPlayMedioInfo)localObject).m = true;
        if (QLog.isColorLevel()) {
          QLog.d(" AIOGalleryAdapter", 2, new Object[] { "set playMedioInfo.isMute = ", Boolean.valueOf(this.e), " data.id = ", Long.valueOf(paramAIOShortVideoData.L) });
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
    Object localObject = this.t;
    if ((localObject != null) && ((((URLDrawable)localObject).getCurrDrawable() instanceof QQLiveDrawable)))
    {
      localObject = (QQLiveDrawable)this.t.getCurrDrawable();
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
    this.t = null;
    this.u = -1;
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
      if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject1).a))
      {
        Object localObject2 = (AIOImageData)((AIORichMediaInfo)localObject1).a;
        if ((paramBoolean) && (((AIOImageData)localObject2).c(8) != null))
        {
          localObject1 = paramView.getDrawable();
          localObject2 = ((AIOImageData)localObject2).b(8);
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
          this.a.d().b();
        }
      }
      else
      {
        AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject1).a);
      }
    }
  }
  
  void a(int paramInt, AIOGalleryAdapter.GalleryImageStruct paramGalleryImageStruct)
  {
    paramGalleryImageStruct = paramGalleryImageStruct.getDrawable();
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
      if (AIOImageData.class.isInstance(localAIORichMediaInfo.a)) {
        a((AIOImageData)localAIORichMediaInfo.a, paramString1, paramString2, paramView, paramInt, localAIORichMediaInfo, paramBoolean);
      } else if (AIOShortVideoData.class.isInstance(localAIORichMediaInfo.a)) {
        a((AIOShortVideoData)localAIORichMediaInfo.a, paramInt, paramView);
      } else if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.a)) {
        a((AIOFilePicData)localAIORichMediaInfo.a, paramInt, paramView, localAIORichMediaInfo, paramBoolean);
      } else if (AIOFileVideoData.class.isInstance(localAIORichMediaInfo.a)) {
        a((AIOFileVideoData)localAIORichMediaInfo.a, paramInt, paramView);
      }
      if (!this.a.g)
      {
        this.b.a(this.g);
        this.a.g = true;
      }
    }
    else if (((paramView instanceof RelativeLayout)) && (AIOShortVideoData.class.isInstance(localAIORichMediaInfo.a)))
    {
      paramString1 = (AIOShortVideoData)localAIORichMediaInfo.a;
      if (paramString1.d == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(" AIOGalleryAdapter", 2, " updateView loadShortVideoCover");
        }
        paramString2 = (URLImageView)paramView.findViewById(2131440625);
        a(paramString1.a, paramString1.g, paramString1.h, paramString2, paramInt);
      }
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    int i1 = this.a.getResources().getDisplayMetrics().widthPixels;
    int i2 = this.a.getResources().getDisplayMetrics().heightPixels;
    if ((i1 != this.x) || (i2 != this.y))
    {
      this.x = i1;
      this.y = i2;
      URLDrawable.clearMemoryCache();
      b();
    }
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(AbstractImageListModel paramAbstractImageListModel)
  {
    super.a(paramAbstractImageListModel);
    this.c = ((AIOImageListModel)paramAbstractImageListModel);
    b();
  }
  
  void a(URLDrawable paramURLDrawable, int paramInt)
  {
    if (this.p.get(paramInt) != null) {
      this.p.put(paramInt, paramURLDrawable);
    }
  }
  
  public void a(AIOGalleryAdapter.OnTroopThumbListener paramOnTroopThumbListener)
  {
    this.z = paramOnTroopThumbListener;
  }
  
  public void a(AIORichMediaData paramAIORichMediaData)
  {
    this.d = paramAIORichMediaData;
    this.A = paramAIORichMediaData.L;
    this.a.m = paramAIORichMediaData.L;
  }
  
  public void a(VideoPlayController paramVideoPlayController)
  {
    this.k = paramVideoPlayController;
  }
  
  void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AIORichMediaInfo localAIORichMediaInfo = a(paramInt);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onItemSelected isShortVideoAutoPlay=");
      ((StringBuilder)localObject).append(this.a.k);
      ((StringBuilder)localObject).append(" hasDoneItemSelectUid=");
      ((StringBuilder)localObject).append(this.A);
      ((StringBuilder)localObject).append(" mContext.entryId=");
      ((StringBuilder)localObject).append(this.a.m);
      QLog.d(" AIOGalleryAdapter", 2, ((StringBuilder)localObject).toString());
      QLog.i(" AIOGalleryAdapter", 1, "FileVideo_AP call onItemSelected ");
    }
    if ((localAIORichMediaInfo != null) && (localAIORichMediaInfo.a != null) && (localAIORichMediaInfo.a.L != this.a.m))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onItemSelected not first image.mData.id=");
      ((StringBuilder)localObject).append(localAIORichMediaInfo.a.L);
      ((StringBuilder)localObject).append(" entryId=");
      ((StringBuilder)localObject).append(this.a.m);
      QLog.d(" AIOGalleryAdapter", 2, ((StringBuilder)localObject).toString());
      this.a.m = -1L;
    }
    if ((this.e) && (this.d != null) && (localAIORichMediaInfo != null) && (localAIORichMediaInfo.a != null) && (this.d.L != localAIORichMediaInfo.a.L))
    {
      this.e = false;
      localObject = (AIOGalleryScene)this.a.a.c();
      if (localObject != null) {
        ((AIOGalleryScene)localObject).as = false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onItemSelected, set mIsmute false,  mDataOfBubble.id = ");
        ((StringBuilder)localObject).append(this.d.L);
        ((StringBuilder)localObject).append(", image.mData.id + ");
        ((StringBuilder)localObject).append(localAIORichMediaInfo.a.L);
        QLog.d(" AIOGalleryAdapter", 2, ((StringBuilder)localObject).toString());
      }
    }
    if ((localAIORichMediaInfo != null) && ((AIOShortVideoData.class.isInstance(localAIORichMediaInfo.a)) || (AIOFileVideoData.class.isInstance(localAIORichMediaInfo.a)))) {
      ((AudioManager)this.a.getSystemService("audio")).requestAudioFocus(null, 3, 2);
    } else {
      ((AudioManager)this.a.getSystemService("audio")).abandonAudioFocus(null);
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
    if (this.a.m == paramLong)
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
    this.A = paramAIOShortVideoData.i;
    if (localVideoPlayMedioInfo == null)
    {
      b(paramAIOShortVideoData, paramView);
      return false;
    }
    paramAIOShortVideoData = this.k;
    if (paramAIOShortVideoData != null) {
      paramAIOShortVideoData.a(paramView, localVideoPlayMedioInfo);
    }
    return true;
  }
  
  public void b()
  {
    this.p.clear();
    this.q.clear();
    URLDrawable localURLDrawable = this.r;
    if ((localURLDrawable != null) && (localURLDrawable.getStatus() == 0)) {
      this.r.cancelDownload(true);
    }
    this.r = null;
    this.s = -1;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject = a(paramInt1);
    if (localObject == null) {
      return;
    }
    if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject).a))
    {
      if (!((AIOImageData)((AIORichMediaInfo)localObject).a).h) {
        super.b(paramInt1, paramInt2);
      }
    }
    else
    {
      if (AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject).a)) {
        return;
      }
      if (AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject).a))
      {
        super.b(paramInt1, paramInt2);
        return;
      }
      if (AIOFileVideoData.class.isInstance(((AIORichMediaInfo)localObject).a))
      {
        AIOFileVideoData localAIOFileVideoData = (AIOFileVideoData)((AIORichMediaInfo)localObject).a;
        if (!localAIOFileVideoData.p) {
          return;
        }
        localAIOFileVideoData.n = paramInt2;
        AIOGalleryScene localAIOGalleryScene = (AIOGalleryScene)this.a.a.c();
        float f1 = (float)(paramInt2 * 100) / 10000.0F;
        if (localAIOFileVideoData.p)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131898331));
          ((StringBuilder)localObject).append(FileUtil.a(((float)localAIOFileVideoData.O * f1)));
          ((StringBuilder)localObject).append("/");
          ((StringBuilder)localObject).append(FileUtil.a(localAIOFileVideoData.O));
          ((StringBuilder)localObject).append(")");
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131898291));
          ((StringBuilder)localObject).append(FileUtil.a(((float)localAIOFileVideoData.O * f1)));
          ((StringBuilder)localObject).append("/");
          ((StringBuilder)localObject).append(FileUtil.a(localAIOFileVideoData.O));
          ((StringBuilder)localObject).append(")");
          localObject = ((StringBuilder)localObject).toString();
        }
        localAIOGalleryScene.a(localAIOFileVideoData.L, f1, (String)localObject);
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
    Object localObject1 = this.t;
    if ((localObject1 != null) && ((((URLDrawable)localObject1).getCurrDrawable() instanceof QQLiveDrawable)))
    {
      localObject1 = (QQLiveDrawable)this.t.getCurrDrawable();
      if (((QQLiveDrawable)localObject1).getCurrentPosition() > 0L)
      {
        Object localObject2 = a(this.u);
        if ((localObject2 != null) && (((AIORichMediaInfo)localObject2).a != null) && ((((AIORichMediaInfo)localObject2).a instanceof AIOShortVideoData)))
        {
          localObject2 = (AIOShortVideoData)((AIORichMediaInfo)localObject2).a;
          a(((AIOShortVideoData)localObject2).i, ((AIOShortVideoData)localObject2).c * 1000, ((QQLiveDrawable)localObject1).getCurrentPosition());
        }
      }
    }
    AIOSingleReporter.a().b();
    b();
    a();
  }
  
  public void e()
  {
    int i1 = this.B;
    Object localObject;
    if (i1 == 0)
    {
      localObject = this.C;
      if (localObject != null) {
        ((AIOGalleryAdapter.GalleryImageStruct)localObject).b();
      }
    }
    else if (i1 == 1)
    {
      localObject = this.k;
      if ((localObject != null) && (((VideoPlayController)localObject).p())) {
        this.k.j();
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
      AIOGalleryAdapter.GalleryImageStruct localGalleryImageStruct = new AIOGalleryAdapter.GalleryImageStruct(this, this.a, 0);
      localGalleryImageStruct.setAdjustViewBounds(true);
      AIORichMediaInfo localAIORichMediaInfo = a(paramInt);
      if ((localAIORichMediaInfo != null) && (localAIORichMediaInfo.a != null))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" getView(): position=");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append(" uid=");
          ((StringBuilder)localObject).append(localAIORichMediaInfo.a.L);
          ((StringBuilder)localObject).append(" isShortVideoAutoPlay=");
          ((StringBuilder)localObject).append(this.a.k);
          ((StringBuilder)localObject).append(" mDataLoaded=");
          ((StringBuilder)localObject).append(this.a.g);
          ((StringBuilder)localObject).append(" entryid=");
          ((StringBuilder)localObject).append(this.a.m);
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
      if ((localAIORichMediaInfo != null) && (localAIORichMediaInfo.a != null)) {
        if (AIOImageData.class.isInstance(localAIORichMediaInfo.a))
        {
          localObject = (AIOImageData)localAIORichMediaInfo.a;
          this.a.n = true;
          a((AIOImageData)localObject);
          localGalleryImageStruct.setCenterBtnVisiable(8);
          AIOImageData localAIOImageData = (AIOImageData)localAIORichMediaInfo.a;
          localGalleryImageStruct.setPosition(paramInt);
          localGalleryImageStruct.setImageInfo(localAIORichMediaInfo);
          localGalleryImageStruct.setIgnoreLayout(false);
          localGalleryImageStruct.a(localAIOImageData.z);
          localObject = (URLDrawable)this.p.get(paramInt);
          if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 1))
          {
            a(localGalleryImageStruct, localAIORichMediaInfo, (URLDrawable)localObject, localAIOImageData);
            localGalleryImageStruct.a();
          }
          else
          {
            File localFile = localAIOImageData.c(4);
            if (localFile == null)
            {
              localObject = localAIOImageData.c(2);
              if (localObject == null)
              {
                if (localAIOImageData.c(8) != null)
                {
                  a(localGalleryImageStruct, localAIORichMediaInfo, paramInt, localAIOImageData);
                  break label572;
                }
                if ((!localAIOImageData.g) && (!localAIOImageData.f) && (!localAIOImageData.e))
                {
                  localObject = localAIOImageData.c(1);
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
          ((StringBuilder)localObject).append(localAIOImageData.L);
          ((StringBuilder)localObject).append("_");
          ((StringBuilder)localObject).append(localAIOImageData.M);
          localObject = ((StringBuilder)localObject).toString();
          if (!this.w.contains(localObject))
          {
            this.b.c(localAIOImageData.L, localAIOImageData.M);
            this.w.add(localObject);
          }
        }
        else
        {
          if (AIOShortVideoData.class.isInstance(localAIORichMediaInfo.a))
          {
            localObject = a(paramInt, localAIORichMediaInfo);
            break label746;
          }
          if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.a))
          {
            a(localGalleryImageStruct, paramInt, localAIORichMediaInfo);
          }
          else if (AIOFileVideoData.class.isInstance(localAIORichMediaInfo.a))
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
    paramView = (URLDrawable)this.p.get(paramInt);
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
    if (AIOImageData.class.isInstance(paramView.a))
    {
      a((AIOImageData)paramView.a, paramInt);
      return null;
    }
    if (AIOShortVideoData.class.isInstance(paramView.a))
    {
      a((AIOShortVideoData)paramView.a, paramInt);
      return null;
    }
    if (AIOFilePicData.class.isInstance(paramView.a))
    {
      a((AIOFilePicData)paramView.a, paramInt);
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i(" AIOGalleryAdapter", 2, "AIOGalleryAdapter.onCreateView(): nani...");
    }
    return null;
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.p.get(paramInt);
    if (paramView != null)
    {
      if (paramView.getStatus() == 0) {
        paramView.cancelDownload(true);
      }
      this.p.remove(paramInt);
    }
    this.q.remove(paramInt);
    if (paramInt == this.s)
    {
      paramView = this.r;
      if ((paramView != null) && (paramView.getStatus() == 0)) {
        this.r.cancelDownload(true);
      }
      this.r = null;
      this.s = -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(" AIOGalleryAdapter", 2, f());
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
    paramView = ((AIOGalleryAdapter.GalleryImageStruct)paramView).getDrawable();
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
      if (this.C == null) {
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
      paramString = this.C;
      if (paramString != null) {
        paramString.b.setVisibility(0);
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
    if (paramInt == this.s)
    {
      paramViewGroup = this.r;
      if ((paramViewGroup != null) && (paramViewGroup.getStatus() == 0)) {
        this.r.cancelDownload(true);
      }
      this.r = null;
      this.s = -1;
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
      AIORichMediaData localAIORichMediaData = paramViewGroup.a;
      if (AIOImageData.class.isInstance(localAIORichMediaData))
      {
        if (URLDrawable.class.isInstance(paramView.getDrawable())) {
          this.a.b().a(paramViewGroup.hashCode());
        }
        this.a.d().a();
        return;
      }
      if (AIOShortVideoData.class.isInstance(localAIORichMediaData))
      {
        paramViewGroup = (URLDrawable)this.p.get(paramInt);
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
    paramView = localGalleryImageStruct.getDrawable();
    paramViewGroup = localGalleryImageStruct.getDecoding();
    if ((paramView instanceof URLDrawable))
    {
      URLDrawable localURLDrawable = (URLDrawable)paramView;
      if ((localURLDrawable.isFakeSize()) && (paramViewGroup == null))
      {
        paramView = localURLDrawable.getURL();
        if ((!"file".equals(paramView.getProtocol())) || (paramView.getRef() != null)) {
          break label307;
        }
        if (paramInt == this.s)
        {
          paramViewGroup = this.r;
          if (paramViewGroup != null)
          {
            paramView = paramViewGroup;
            if (!QLog.isColorLevel()) {
              break label257;
            }
            paramView = paramViewGroup;
            if (this.r == null) {
              break label257;
            }
            QLog.d(" AIOGalleryAdapter", 2, "use exist raw drawable");
            paramView = paramViewGroup;
            break label257;
          }
        }
        if ((QLog.isColorLevel()) && (this.r != null)) {
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
        this.r = paramViewGroup;
        this.s = paramInt;
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
    this.a.b().b(paramView.hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */