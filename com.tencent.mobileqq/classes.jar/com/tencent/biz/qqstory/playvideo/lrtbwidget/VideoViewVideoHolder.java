package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.events.ReadStoryVideoEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo.VipFrwrdLinkInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.handler.WatchVideoHandler;
import com.tencent.biz.qqstory.playmode.VideoPlayModeConstants;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.ImageViewLoadCallback;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.StartInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.ReportData;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.playvideo.player.ProgressVideoViewWrapper;
import com.tencent.biz.qqstory.playvideo.player.StoryPlayerTVKWrapper.ReportData;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.playvideo.player.VideoViewFactory;
import com.tencent.biz.qqstory.playvideo.player.VideoViewFactory.TVKSDKOnLogListener;
import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl;
import com.tencent.biz.qqstory.playvideo.player.VideoViewTextureImpl;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.StoryNewGuideDialog;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import com.tencent.util.URLUtil;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.reactive.Stream;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class VideoViewVideoHolder
  extends VideoHolderBase
  implements View.OnClickListener
{
  public static final SparseArray<int[]> a;
  public static final String[] a;
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "SE", "VI", "DD", "SV", "VD", "SP", "VP", "HC" };
  private long jdField_a_of_type_Long = 0L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private Button jdField_a_of_type_AndroidWidgetButton;
  public ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WatchVideoHandler jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerWatchVideoHandler = new WatchVideoHandler();
  private BatchGetVideoInfo jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfo;
  PlayModeUtils.ImageViewLoadCallback jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilPlayModeUtils$ImageViewLoadCallback = new VideoViewVideoHolder.14(this);
  public QQStoryVideoPlayerErrorView a;
  VideoViewVideoHolder.SingleFileDownloaderHolder jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$SingleFileDownloaderHolder = new VideoViewVideoHolder.SingleFileDownloaderHolder(this, null);
  private VideoViewVideoHolder.VideoViewListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoViewListener;
  public IVideoView a;
  private StoryPlayerTVKWrapper.ReportData jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$ReportData = new StoryPlayerTVKWrapper.ReportData();
  public StoryNewGuideDialog a;
  public QQStoryLoadingView a;
  Stream jdField_a_of_type_ComTribeAsyncReactiveStream = null;
  private Map<String, Long> jdField_a_of_type_JavaUtilMap = new VideoViewVideoHolder.12(this);
  private int[] jdField_a_of_type_ArrayOfInt = new int[6];
  private long jdField_b_of_type_Long = 0L;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  public ImageView b;
  String jdField_b_of_type_JavaLangString = null;
  int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = 0L;
  private Button jdField_c_of_type_AndroidWidgetButton;
  public String c;
  private boolean jdField_c_of_type_Boolean = false;
  public int d;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString = null;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString = null;
  private boolean jdField_f_of_type_Boolean = false;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private int j;
  private int k;
  private int l = 0;
  private int m = 0;
  private int n;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "s_Idle", "s_VideoInfo", "s_VideoInfo_OK", "s_DoodleDown", "s_DoodleDown_OK", "s_VideoFile", "s_VideoFile_OK", "s_Prepare", "s_Prepare_OK", "s_Starting", "s_Playing_OK", "s_Pause", "s_Complete_OK" };
    jdField_a_of_type_AndroidUtilSparseArray = new VideoViewVideoHolder.1();
  }
  
  public VideoViewVideoHolder(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.jdField_d_of_type_Int = 3;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365295));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370708));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)paramViewGroup.findViewById(2131370360));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)paramViewGroup.findViewById(2131380703));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131378448);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378447));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131378445));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131378449));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131378446));
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void a(long paramLong, String paramString)
  {
    a("HC", SystemClock.uptimeMillis());
    this.jdField_e_of_type_Boolean = true;
    SLog.b(this.jdField_a_of_type_JavaLangString, "hideCover, hide loading view");
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    h();
    SLog.d(this.jdField_a_of_type_JavaLangString, "CheckVideoViewRealStartRunnable, %s, currentPosition=%d, outputTimeOutCount=%d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(VideoViewFactory.a(a()).a().jdField_a_of_type_Int) });
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString;
    k();
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoViewVideoHolder.11(this), 600L);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoViewListener.c(this, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView);
  }
  
  private static void a(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).width = paramInt1;
      ((ViewGroup.MarginLayoutParams)localObject).height = paramInt2;
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = paramInt3;
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = paramInt3;
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = paramInt4;
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = paramInt4;
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void a(ErrorMessage paramErrorMessage)
  {
    SLog.d(this.jdField_a_of_type_JavaLangString, "onError. %d : %s", new Object[] { Integer.valueOf(paramErrorMessage.errorCode), paramErrorMessage.errorMsg });
    if (paramErrorMessage.errorCode == 0) {
      return;
    }
    switch (paramErrorMessage.errorCode)
    {
    default: 
      return;
    case 9: 
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new VideoViewVideoHolder.10(this));
      return;
    case 7: 
    case 14: 
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(null);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new VideoViewVideoHolder.9(this));
      return;
    case 5: 
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
      paramErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView;
      paramErrorMessage.setTipsText(paramErrorMessage.getResources().getString(2131699917));
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(null);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new VideoViewVideoHolder.8(this, paramErrorMessage));
  }
  
  private void a(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    int i1 = paramStoryVideoItem.mVideoWidth;
    int i2 = paramStoryVideoItem.mVideoHeight;
    if (!TextUtils.equals(this.jdField_d_of_type_JavaLangString, paramStoryVideoItem.mVid))
    {
      int i3 = this.g;
      int i4;
      if (i3 == i1)
      {
        i4 = this.h;
        if ((i4 == i2) && (i3 > 0) && (i4 > 0) && (this.i == paramStoryVideoItem.playerScaleType)) {}
      }
      else
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a();
        boolean bool = localObject1 instanceof TextureVideoView;
        int i7 = UIUtils.b(this.jdField_a_of_type_AndroidViewView.getContext());
        int i8 = UIUtils.c(this.jdField_a_of_type_AndroidViewView.getContext());
        double d5 = i1;
        double d6 = i2;
        Double.isNaN(d5);
        Double.isNaN(d6);
        double d1 = d5 / d6;
        double d2 = i7;
        double d3 = i8;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = d2 / d3;
        int i12;
        int i11;
        int i10;
        int i9;
        if ((bool) && (i1 > 0) && (i2 > 0))
        {
          if (d1 < 1.0D) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          if (d4 < 1.0D) {
            i4 = 1;
          } else {
            i4 = 0;
          }
          if (i3 != i4) {
            bool = true;
          } else {
            bool = false;
          }
          this.jdField_c_of_type_Boolean = bool;
          int i5 = i1;
          int i6 = i2;
          if (this.jdField_c_of_type_Boolean)
          {
            Double.isNaN(d6);
            Double.isNaN(d5);
            d1 = d6 / d5;
            i6 = i1;
            i5 = i2;
          }
          float f2;
          float f1;
          float f4;
          float f3;
          if (paramStoryVideoItem.playerScaleType == 1)
          {
            f2 = i7;
            f1 = i5;
            f2 /= f1;
            f4 = i8;
            f3 = i6;
            f4 /= f3;
            if (f2 < f4)
            {
              i3 = (int)(f1 * f2);
              i4 = (int)(f3 * f2);
              i2 = (i8 - i4) / 2;
              i1 = 0;
            }
            else
            {
              i3 = (int)(f1 * f4);
              i4 = (int)(f3 * f4);
              i1 = (i7 - i3) / 2;
              i2 = 0;
            }
            i5 = i3;
            i6 = i4;
          }
          else if (d4 >= d1)
          {
            Double.isNaN(d2);
            i4 = (int)(d2 / d1);
            d1 = i8 - i4;
            Double.isNaN(d1);
            i2 = (int)(d1 * 1.0D / 2.0D + 0.5D);
            i1 = 0;
            i3 = i7;
          }
          else
          {
            Double.isNaN(d3);
            i3 = (int)(d3 * d1);
            d1 = i7 - i3;
            Double.isNaN(d1);
            i1 = (int)(d1 * 1.0D / 2.0D + 0.5D);
            i2 = 0;
            i4 = i8;
          }
          i12 = i5;
          i11 = i6;
          i10 = i1;
          i9 = i2;
          i8 = i3;
          i7 = i4;
          if (this.jdField_c_of_type_Boolean)
          {
            localObject2 = new Matrix();
            f3 = i4;
            f4 = i3;
            f1 = f3 / f4;
            f2 = f4 / f3;
            f4 /= 2.0F;
            f3 /= 2.0F;
            ((Matrix)localObject2).setScale(f1, f2, f4, f3);
            ((Matrix)localObject2).postRotate(90.0F, f4, f3);
            ((TextureVideoView)localObject1).setTransform((Matrix)localObject2);
            i12 = i5;
            i11 = i6;
            i10 = i1;
            i9 = i2;
            i8 = i3;
            i7 = i4;
          }
        }
        else
        {
          i10 = 0;
          i9 = 0;
          i8 = -1;
          i7 = -1;
          i11 = i2;
          i12 = i1;
        }
        this.jdField_d_of_type_JavaLangString = paramStoryVideoItem.mVid;
        this.i = paramStoryVideoItem.playerScaleType;
        this.h = paramStoryVideoItem.mVideoHeight;
        this.g = paramStoryVideoItem.mVideoWidth;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131716170));
        ((StringBuilder)localObject1).append(i12);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131716165));
        ((StringBuilder)localObject1).append(i11);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131716167));
        ((StringBuilder)localObject1).append(String.valueOf(this.jdField_c_of_type_Boolean));
        a(((StringBuilder)localObject1).toString());
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131716164));
        ((StringBuilder)localObject2).append(paramStoryVideoItem.mVideoDuration);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131716184));
        ((StringBuilder)localObject2).append(paramStoryVideoItem.mVideoBytes);
        if (paramStoryVideoItem.mIsPicture == 1) {
          localObject1 = HardCodeUtil.a(2131716178);
        } else {
          localObject1 = "";
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        a(((StringBuilder)localObject2).toString());
        localObject1 = this.jdField_a_of_type_ArrayOfInt;
        localObject1[0] = i12;
        localObject1[1] = i11;
        localObject1[2] = i8;
        localObject1[3] = i7;
        localObject1[4] = i10;
        localObject1[5] = i9;
        SLog.b(this.jdField_a_of_type_JavaLangString, "updateViewParam, videoWidth/videoHeight=%d/%d, layoutWidth/layoutHeight=%d/%d, leftMargin=%d, topMargin=%d, vid=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[0]), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[1]), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[2]), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[3]), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[4]), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[5]), paramStoryVideoItem.mVid });
        a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(), i8, i7, i10, i9);
        a(this.jdField_a_of_type_AndroidWidgetImageView, i8, i7, i10, i9);
        a(this.jdField_b_of_type_AndroidWidgetImageView, i8, i7, i10, i9);
        return;
      }
    }
    this.jdField_d_of_type_JavaLangString = paramStoryVideoItem.mVid;
  }
  
  private void a(StoryPlayerVideoData paramStoryPlayerVideoData, IVideoView paramIVideoView, int paramInt)
  {
    if (!TextUtils.equals(this.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString)) {
      return;
    }
    String str = StoryReportor.a(a());
    StoryPlayerTVKWrapper.ReportData localReportData = paramIVideoView.a();
    long l1;
    if (localReportData.jdField_d_of_type_Long == 0L) {
      l1 = paramIVideoView.b();
    } else {
      l1 = localReportData.jdField_d_of_type_Long;
    }
    long l2;
    if (paramInt == 1) {
      l2 = l1;
    } else if (localReportData.jdField_d_of_type_Long == 0L) {
      l2 = paramIVideoView.a();
    } else {
      l2 = localReportData.e;
    }
    Bosses.get().postJob(new VideoViewVideoHolder.16(this, this.jdField_a_of_type_JavaLangString, paramStoryPlayerVideoData, l1, l2, paramInt, str));
  }
  
  private void a(@NonNull String paramString)
  {
    SLog.b(this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  private void a(String paramString, long paramLong)
  {
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(paramLong));
      i();
    }
  }
  
  private boolean a(int paramInt)
  {
    return a(paramInt, (int[])jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_e_of_type_Int));
  }
  
  public static boolean a(int paramInt, int[] paramArrayOfInt)
  {
    int i2 = paramArrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (paramArrayOfInt[i1] == paramInt) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
    if (localObject == null)
    {
      b().setVisibility(8);
      return;
    }
    localObject = ((StoryVideoItem)localObject).getVideoLinkInfo();
    if ((localObject != null) && (((VideoLinkInfo)localObject).a()) && (((VideoLinkInfo)localObject).a.a()) && (a().mReportData.from != 86))
    {
      b().setVisibility(paramInt);
      return;
    }
    b().setVisibility(8);
  }
  
  private void b(StoryVideoItem paramStoryVideoItem)
  {
    if ((!TextUtils.isEmpty(paramStoryVideoItem.mOwnerUid)) && (!StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid)))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerWatchVideoHandler.a(paramStoryVideoItem.mVid, paramStoryVideoItem.mOwnerUid, a().mReportData.from, false, paramStoryVideoItem.mCreateTime);
    }
    else if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("not report play, vid = ");
      ((StringBuilder)localObject2).append(paramStoryVideoItem.mVid);
      ((StringBuilder)localObject2).append(" mOwnerUid:");
      ((StringBuilder)localObject2).append(paramStoryVideoItem.mOwnerUid);
      ((StringBuilder)localObject2).append(", myUin:");
      ((StringBuilder)localObject2).append(QQStoryContext.a().b());
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = paramStoryVideoItem.mOwnerUid;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_Int == 13) {
        localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_JavaLangString;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new ReadStoryVideoEvent((String)localObject1, paramStoryVideoItem);
      StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject1);
    }
    ((StoryManager)SuperManager.a(5)).b(paramStoryVideoItem.mVid);
    SLog.b(this.jdField_a_of_type_JavaLangString, "Do play video. vid = %s", paramStoryVideoItem.mVid);
  }
  
  private void b(StoryPlayerVideoData paramStoryPlayerVideoData, IVideoView paramIVideoView, int paramInt)
  {
    StoryVideoItem localStoryVideoItem = paramStoryPlayerVideoData.a();
    if (localStoryVideoItem == null)
    {
      SLog.e(this.jdField_a_of_type_JavaLangString, "video info empty , report error! vid :%s", new Object[] { paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!TextUtils.equals(this.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString)) {
      return;
    }
    paramStoryPlayerVideoData = StoryReportor.a(a());
    StoryPlayerTVKWrapper.ReportData localReportData = paramIVideoView.a();
    long l1;
    if (localReportData.jdField_d_of_type_Long == 0L) {
      l1 = paramIVideoView.b();
    } else {
      l1 = localReportData.jdField_d_of_type_Long;
    }
    long l2;
    if (paramInt == 1) {
      l2 = l1;
    } else if (localReportData.jdField_d_of_type_Long == 0L) {
      l2 = paramIVideoView.a();
    } else {
      l2 = localReportData.e;
    }
    Bosses.get().postJob(new VideoViewVideoHolder.17(this, this.jdField_a_of_type_JavaLangString, localStoryVideoItem, l1, l2, paramInt, paramStoryPlayerVideoData));
  }
  
  private boolean b(int paramInt)
  {
    boolean bool;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool, "not - main - thread");
    if (a(paramInt, (int[])jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_e_of_type_Int)))
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = jdField_a_of_type_ArrayOfJavaLangString;
      SLog.d((String)localObject1, "changeState : %s => %s", new Object[] { localObject2[this.jdField_e_of_type_Int], localObject2[paramInt] });
      this.jdField_e_of_type_Int = paramInt;
      return true;
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = new Throwable();
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    SLog.c((String)localObject1, (Throwable)localObject2, "changeState not allow ! current = %s, new = %s", new Object[] { arrayOfString[this.jdField_e_of_type_Int], arrayOfString[paramInt] });
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("changeState ! ");
    ((StringBuilder)localObject1).append(jdField_a_of_type_ArrayOfJavaLangString[this.jdField_e_of_type_Int]);
    ((StringBuilder)localObject1).append(" -- ");
    ((StringBuilder)localObject1).append(jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
    CaughtExceptionReport.a(new IllegalStateException(((StringBuilder)localObject1).toString()));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("changeState not allow. current=");
    ((StringBuilder)localObject1).append(jdField_a_of_type_ArrayOfJavaLangString[this.jdField_e_of_type_Int]);
    ((StringBuilder)localObject1).append(", new=");
    ((StringBuilder)localObject1).append(jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
    AssertUtils.assertTrue(false, ((StringBuilder)localObject1).toString());
    return false;
  }
  
  private void d(boolean paramBoolean)
  {
    boolean bool;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool, "not - main - thread");
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = jdField_a_of_type_ArrayOfJavaLangString;
    SLog.a((String)localObject1, "checkStateAndGoAhead. %s => %s. reset=%s", localObject2[this.jdField_e_of_type_Int], localObject2[this.jdField_c_of_type_Int], Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(jdField_a_of_type_ArrayOfJavaLangString[this.jdField_e_of_type_Int]);
      ((StringBuilder)localObject1).append(" - ");
      ((StringBuilder)localObject1).append(jdField_a_of_type_ArrayOfJavaLangString[0]);
      this.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
      this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of("");
      this.jdField_a_of_type_ComTribeAsyncReactiveStream.map(new VideoViewVideoHolder.VideoIdleSegment(this, null)).subscribe(new VideoViewVideoHolder.2(this));
      return;
    }
    int i1 = this.jdField_e_of_type_Int;
    int i2 = this.jdField_c_of_type_Int;
    if (i1 == i2)
    {
      SLog.a(this.jdField_a_of_type_JavaLangString, "checkStateAndGoAhead. DONE => %s", jdField_a_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int]);
      return;
    }
    if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null)
    {
      SLog.d(this.jdField_a_of_type_JavaLangString, "checkStateAndGoAhead. do nothing. waiting ...");
      return;
    }
    if (i2 == 0)
    {
      d(true);
      return;
    }
    if (i2 == 2)
    {
      if (i1 == 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(jdField_a_of_type_ArrayOfJavaLangString[0]);
        ((StringBuilder)localObject1).append(" - ");
        ((StringBuilder)localObject1).append(jdField_a_of_type_ArrayOfJavaLangString[2]);
        this.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
        this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData);
        this.jdField_a_of_type_ComTribeAsyncReactiveStream.map(new VideoViewVideoHolder.CheckDataSegment(this, null)).map(new VideoViewVideoHolder.VideoInfoSegment(this, null)).subscribe(new VideoViewVideoHolder.3(this));
        return;
      }
      d(true);
      return;
    }
    if ((i2 != 8) && (i2 != 10))
    {
      if (i2 == 11)
      {
        if (i1 == 10)
        {
          localObject1 = this.jdField_a_of_type_JavaLangString;
          localObject2 = jdField_a_of_type_ArrayOfJavaLangString;
          SLog.a((String)localObject1, "requestChangeState. current=%s, target=%s, pause video", localObject2[this.jdField_e_of_type_Int], localObject2[this.jdField_c_of_type_Int]);
          b(11);
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.c();
          return;
        }
        localObject1 = this.jdField_a_of_type_JavaLangString;
        localObject2 = jdField_a_of_type_ArrayOfJavaLangString;
        SLog.d((String)localObject1, "requestChangeState. current=%s, target=%s, ERROR !", new Object[] { localObject2[this.jdField_e_of_type_Int], localObject2[this.jdField_c_of_type_Int] });
      }
    }
    else
    {
      i1 = this.jdField_e_of_type_Int;
      if (i1 == 0)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(jdField_a_of_type_ArrayOfJavaLangString[0]);
          ((StringBuilder)localObject1).append(" - ");
          ((StringBuilder)localObject1).append(jdField_a_of_type_ArrayOfJavaLangString[6]);
          this.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
          this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData);
          this.jdField_a_of_type_ComTribeAsyncReactiveStream.map(new VideoViewVideoHolder.CheckDataSegment(this, null)).map(new VideoViewVideoHolder.VideoInfoSegment(this, null)).map(new VideoViewVideoHolder.DoodleSegment(this, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$SingleFileDownloaderHolder)).map(new VideoViewVideoHolder.VideoFileSegment(this, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$SingleFileDownloaderHolder, b())).subscribe(new VideoViewVideoHolder.4(this));
          return;
        }
        SLog.e(this.jdField_a_of_type_JavaLangString, "mData is null");
        a(new ErrorMessage(0, "mData is null. un bind !"));
        return;
      }
      if (i1 == 2)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData != null)
        {
          localObject1 = ((StoryManager)SuperManager.a(5)).b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString);
          if (localObject1 != null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(jdField_a_of_type_ArrayOfJavaLangString[2]);
            ((StringBuilder)localObject2).append(" - ");
            ((StringBuilder)localObject2).append(jdField_a_of_type_ArrayOfJavaLangString[6]);
            this.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
            this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(localObject1);
            this.jdField_a_of_type_ComTribeAsyncReactiveStream.map(new VideoViewVideoHolder.DoodleSegment(this, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$SingleFileDownloaderHolder)).map(new VideoViewVideoHolder.VideoFileSegment(this, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$SingleFileDownloaderHolder, b())).subscribe(new VideoViewVideoHolder.5(this));
            return;
          }
          SLog.e(this.jdField_a_of_type_JavaLangString, "mData is null");
          a(new ErrorMessage(0, "Go To VideoFile. storyVideoItem is null. un bind !"));
          return;
        }
        SLog.e(this.jdField_a_of_type_JavaLangString, "mData is null");
        a(new ErrorMessage(0, "Go To VideoFile. mData is null. un bind !"));
        return;
      }
      if (i1 < 6)
      {
        d(true);
        return;
      }
      if (i1 == 6)
      {
        localObject1 = ((StoryManager)SuperManager.a(5)).b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString);
        if (localObject1 != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(jdField_a_of_type_ArrayOfJavaLangString[6]);
          ((StringBuilder)localObject2).append(" - ");
          ((StringBuilder)localObject2).append(jdField_a_of_type_ArrayOfJavaLangString[8]);
          this.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
          this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(localObject1);
          this.jdField_a_of_type_ComTribeAsyncReactiveStream.map(new VideoViewVideoHolder.VideoPrepareSegment(this, null)).subscribe(new VideoViewVideoHolder.6(this));
          return;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("no videoInfo ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString);
        a(new ErrorMessage(12, ((StringBuilder)localObject1).toString()));
        return;
      }
      if ((i1 != 7) && (i1 != 9) && (i1 != 12))
      {
        if ((this.jdField_c_of_type_Int == 8) && ((i1 == 11) || (i1 == 10)))
        {
          d(true);
          return;
        }
        if (this.jdField_c_of_type_Int == 10)
        {
          i1 = this.jdField_e_of_type_Int;
          if ((i1 == 11) || (i1 == 8))
          {
            localObject1 = this.jdField_a_of_type_JavaLangString;
            localObject2 = jdField_a_of_type_ArrayOfJavaLangString;
            SLog.a((String)localObject1, "requestChangeState. current=%s, target=%s, start play", localObject2[this.jdField_e_of_type_Int], localObject2[this.jdField_c_of_type_Int]);
            localObject1 = ((StoryManager)SuperManager.a(5)).b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString);
            if (localObject1 != null)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(jdField_a_of_type_ArrayOfJavaLangString[this.jdField_e_of_type_Int]);
              ((StringBuilder)localObject2).append(" - ");
              ((StringBuilder)localObject2).append(jdField_a_of_type_ArrayOfJavaLangString[10]);
              this.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
              this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(localObject1);
              this.jdField_a_of_type_ComTribeAsyncReactiveStream.map(new VideoViewVideoHolder.VideoStartSegment(this, null)).subscribe(new VideoViewVideoHolder.7(this));
              return;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("no videoInfo ");
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString);
            a(new ErrorMessage(12, ((StringBuilder)localObject1).toString()));
            return;
          }
        }
        localObject1 = this.jdField_a_of_type_JavaLangString;
        localObject2 = jdField_a_of_type_ArrayOfJavaLangString;
        SLog.e((String)localObject1, "state error. currentTargetState = %s, currentState = %s", new Object[] { localObject2[this.jdField_c_of_type_Int], localObject2[this.jdField_e_of_type_Int] });
        return;
      }
    }
    try
    {
      d(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private void g()
  {
    d(false);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey("SE"))
    {
      long l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("SE")).longValue();
      String[] arrayOfString = jdField_b_of_type_ArrayOfJavaLangString;
      int i2 = arrayOfString.length;
      int i1 = 0;
      Object localObject1 = "SE";
      while (i1 < i2)
      {
        String str = arrayOfString[i1];
        Object localObject2;
        long l2;
        if (str.equals("SE"))
        {
          localObject2 = localObject1;
          l2 = l1;
        }
        else
        {
          localObject2 = localObject1;
          l2 = l1;
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(str))
          {
            a(String.format((Locale)null, HardCodeUtil.a(2131716185), new Object[] { localObject1, str, Long.valueOf(((Long)this.jdField_a_of_type_JavaUtilMap.get(str)).longValue() - l1) }));
            l2 = ((Long)this.jdField_a_of_type_JavaUtilMap.get(str)).longValue();
            localObject2 = str;
          }
        }
        i1 += 1;
        localObject1 = localObject2;
        l1 = l2;
      }
      if (this.jdField_f_of_type_Boolean) {
        a(String.format((Locale)null, HardCodeUtil.a(2131716166), new Object[] { Long.valueOf(((Long)this.jdField_a_of_type_JavaUtilMap.get("HC")).longValue() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("SE")).longValue()) }));
      }
    }
  }
  
  private void i()
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  private void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView;
    boolean bool1;
    if ((localObject != null) && ((((QQStoryLoadingView)localObject).getVisibility() == 0) || (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.a() == 0))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView;
    boolean bool2;
    if ((localObject != null) && (((QQStoryVideoPlayerErrorView)localObject).getVisibility() == 0)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    int i1 = this.n;
    int i2 = this.j;
    int i3 = this.k;
    int i4 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a();
    localObject = this.jdField_f_of_type_JavaLangString;
    String str1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString;
    String str2 = this.jdField_e_of_type_JavaLangString;
    String str3 = this.jdField_c_of_type_JavaLangString;
    long l1 = this.jdField_d_of_type_Long;
    int i5 = this.l;
    int i6 = this.m;
    int i7 = a().mReportData.from;
    Long localLong = (Long)this.jdField_a_of_type_JavaUtilMap.get("SE");
    StoryPlayerTVKWrapper.ReportData localReportData = new StoryPlayerTVKWrapper.ReportData(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a());
    Bosses.get().postJob(new VideoViewVideoHolder.15(this, this.jdField_a_of_type_JavaLangString, bool1, i1, localLong, bool2, i2, i3, i4, (String)localObject, str1, i7, i5, i6, localReportData, l1, str2, str3));
  }
  
  private void k()
  {
    if (!this.jdField_f_of_type_Boolean) {
      return;
    }
    this.jdField_f_of_type_Boolean = false;
    int i1;
    if ((!a().mReportData.hasReportFirstVideoTime) && ((TextUtils.equals(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString, a().jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(a().jdField_a_of_type_JavaLangString)))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (!a().mReportData.hasReportFirstVideoTime) {
      a().mReportData.hasReportFirstVideoTime = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    long l2 = a().mReportData.startActivityTimeStamp;
    long l3 = a().mReportData.activityOnCreateTimeStamp;
    long l4 = a().mReportData.initViewPagerUiTimeStamp;
    long l1 = a().mReportData.initViewPagerDataTimeStamp;
    localStringBuilder.append("staAct");
    localStringBuilder.append(" ");
    localStringBuilder.append(0);
    localStringBuilder.append(" ");
    localStringBuilder.append("onCre");
    localStringBuilder.append(" ");
    localStringBuilder.append(l3 - l2);
    localStringBuilder.append(" ");
    localStringBuilder.append("initUi");
    localStringBuilder.append(" ");
    localStringBuilder.append(l4 - l2);
    localStringBuilder.append(" ");
    localStringBuilder.append("initData");
    localStringBuilder.append(" ");
    localStringBuilder.append(l1 - l2);
    localStringBuilder.append(" ");
    Object localObject1 = jdField_b_of_type_ArrayOfJavaLangString;
    int i3 = localObject1.length;
    int i2 = 0;
    while (i2 < i3)
    {
      localObject2 = localObject1[i2];
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject2))
      {
        l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get(localObject2)).longValue();
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(" ");
        localStringBuilder.append(l1 - l2);
        localStringBuilder.append(" ");
      }
      else
      {
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(" ");
        localStringBuilder.append(l1 - l2);
        localStringBuilder.append(" ");
      }
      i2 += 1;
    }
    if (i1 != 0)
    {
      l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("HC")).longValue() - l2;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131716171));
      ((StringBuilder)localObject1).append(l1);
      a(((StringBuilder)localObject1).toString());
    }
    else
    {
      l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("HC")).longValue() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("SE")).longValue();
    }
    if (i1 != 0) {
      localObject1 = "CL ";
    } else {
      localObject1 = "SL ";
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a() == 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("LO ");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a() == 1)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("ST ");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("3 ");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.b());
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" ");
    localObject1 = ((StringBuilder)localObject2).toString();
    if (b())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("TVK");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("TEX");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    this.jdField_b_of_type_Long = l1;
    StoryReportor.b("play_video", "start_wait_time", a().mReportData.from, (int)l1, new String[] { localObject1, localStringBuilder.toString(), StoryReportor.a(a()), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString });
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.c())
    {
      int i1 = this.jdField_e_of_type_Int;
      if (i1 == 10)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.getVisibility() == 0)
        {
          SLog.d(this.jdField_a_of_type_JavaLangString, "toggle video, PLAYING = > PAUSE. ignore because loading while playing");
          return 0;
        }
        SLog.d(this.jdField_a_of_type_JavaLangString, "toggle video, PLAYING = > PAUSE");
        a().setVisibility(0);
        a(11, "toggle pause");
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
        b(0);
        StoryReportor.a("play_video", "exp_tips", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString });
        return 2;
      }
      if ((i1 == 11) && (a().getVisibility() == 0))
      {
        SLog.d(this.jdField_a_of_type_JavaLangString, "toggle video, PAUSE = > PLAYING");
        a().setVisibility(8);
        a(10, "toggle start");
        b(8);
        return 1;
      }
      SLog.d(this.jdField_a_of_type_JavaLangString, "toggle video, ignore. isPlaying=%s, hideCover=%s, visibility=%d", new Object[] { Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a()), Boolean.valueOf(this.jdField_e_of_type_Boolean), Integer.valueOf(a().getVisibility()) });
      b(8);
    }
    return 0;
  }
  
  protected View a()
  {
    VideoPauseVideoHolder localVideoPauseVideoHolder = (VideoPauseVideoHolder)a(VideoPauseVideoHolder.class);
    if (localVideoPauseVideoHolder != null) {
      return localVideoPauseVideoHolder.jdField_b_of_type_AndroidViewView;
    }
    return new View(a());
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt)
  {
    i();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131716179));
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("-");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    a(localStringBuilder.toString());
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull StoryPlayerVideoData paramStoryPlayerVideoData, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    String str;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData != null) {
      str = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString;
    } else {
      str = null;
    }
    super.a(paramInt1, paramInt2, paramStoryPlayerVideoData, paramStoryPlayerGroupHolder);
    SLog.a(this.jdField_a_of_type_JavaLangString, "onBind, newVer=%d, newHor=%d, data=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), paramStoryPlayerVideoData);
    i();
    this.jdField_a_of_type_JavaUtilMap.clear();
    a(2, paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString.equals(str) ^ true, "onBind");
  }
  
  public void a(int paramInt, String paramString)
  {
    a(paramInt, false, paramString);
  }
  
  public void a(int paramInt, boolean paramBoolean, String paramString)
  {
    boolean bool;
    if ((paramInt != 2) && (paramInt != 8) && (paramInt != 10) && (paramInt != 11) && (paramInt != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    AssertUtils.assertTrue(bool);
    String str = this.jdField_a_of_type_JavaLangString;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    SLog.a(str, "requestChangeState. START. current=%s, newTarget=%s. reset=%s, reason=%s", arrayOfString[this.jdField_e_of_type_Int], arrayOfString[paramInt], Boolean.valueOf(paramBoolean), paramString);
    if ((this.jdField_c_of_type_Int != paramInt) || (paramBoolean))
    {
      this.jdField_c_of_type_Int = paramInt;
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null)
        {
          SLog.a(this.jdField_a_of_type_JavaLangString, "cancel current stream : %s. current state = %s", this.jdField_b_of_type_JavaLangString, jdField_a_of_type_ArrayOfJavaLangString[this.jdField_e_of_type_Int]);
          this.jdField_a_of_type_ComTribeAsyncReactiveStream.cancel();
          this.jdField_b_of_type_JavaLangString = null;
          this.jdField_a_of_type_ComTribeAsyncReactiveStream = null;
          g();
        }
        else
        {
          d(true);
        }
      }
      else if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null) {
        SLog.b(this.jdField_a_of_type_JavaLangString, "just waiting");
      } else {
        g();
      }
    }
    str = this.jdField_a_of_type_JavaLangString;
    arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    SLog.a(str, "requestChangeState. DONE. current=%s, newTarget=%s. reset=%s, reason=%s", arrayOfString[this.jdField_e_of_type_Int], arrayOfString[paramInt], Boolean.valueOf(paramBoolean), paramString);
  }
  
  public void a(VideoViewVideoHolder.VideoViewListener paramVideoViewListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoViewListener = paramVideoViewListener;
  }
  
  protected View b()
  {
    VideoForwardVideoHolder localVideoForwardVideoHolder = (VideoForwardVideoHolder)a(VideoForwardVideoHolder.class);
    if (localVideoForwardVideoHolder != null) {
      return localVideoForwardVideoHolder.jdField_a_of_type_AndroidViewView;
    }
    return new View(a());
  }
  
  protected void b()
  {
    super.b();
    Activity localActivity = a();
    if (b()) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView = new ProgressVideoViewWrapper(new VideoViewTVKImpl(localActivity, String.valueOf(System.identityHashCode(this))));
    } else {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView = new ProgressVideoViewWrapper(new VideoViewTextureImpl(localActivity, String.valueOf(System.identityHashCode(this))));
    }
    SLog.a(this.jdField_a_of_type_JavaLangString, "create video view, use-TVK=%s videoView=%s", Boolean.valueOf(b()), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView);
    ((ViewGroup)this.jdField_a_of_type_AndroidViewView).addView(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(), 0, new RelativeLayout.LayoutParams(-1, -1));
    a(new VideoViewVideoHolder.13(this));
  }
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_JavaUtilMap.clear();
      a("SE", SystemClock.uptimeMillis());
      this.jdField_b_of_type_Long = 0L;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_d_of_type_Int = 3;
      this.n = 1;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibilityDelay(0, 1000L, "onSelectedChanged true");
      StoryReportor.b("play_video", "onSelectedState", 0, 0, new String[] { jdField_a_of_type_ArrayOfJavaLangString[this.jdField_e_of_type_Int] });
      a(10, "selected");
      StoryReportor.a("play_video", "exp", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString });
    }
    else
    {
      this.jdField_e_of_type_Boolean = false;
      f();
      j();
      this.jdField_f_of_type_JavaLangString = null;
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      a().setVisibility(8);
      b().setVisibility(8);
      a(0, true, "unSelected");
    }
    this.l = 0;
    this.jdField_c_of_type_Long = 0L;
    this.m = 0;
  }
  
  public void c()
  {
    super.c();
    a(0, true, "unBind");
    StoryNewGuideDialog localStoryNewGuideDialog = this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog;
    if (localStoryNewGuideDialog != null) {
      localStoryNewGuideDialog.dismiss();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    SLog.d(this.jdField_a_of_type_JavaLangString, "setRepeatWhilePlayDone = %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void d()
  {
    if ((this.jdField_e_of_type_Int == 11) && (a().getVisibility() != 0)) {
      a(10, "call resume");
    }
  }
  
  public void e()
  {
    if ((this.jdField_e_of_type_Int == 10) && (a().getVisibility() != 0)) {
      a(11, "call Pause");
    }
  }
  
  public boolean e()
  {
    if ((d()) && (c()))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder == null) {
        return false;
      }
      StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
      StoryNewGuideDialog localStoryNewGuideDialog;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.a.size() > 1) && (!localStoryConfigManager.a()))
      {
        e();
        localStoryNewGuideDialog = this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog;
        if (localStoryNewGuideDialog != null) {
          localStoryNewGuideDialog.dismiss();
        }
        this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog = new StoryNewGuideDialog(a());
        this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog.a(true);
        this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog.a(HardCodeUtil.a(2131716172));
        this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog.setOnDismissListener(new VideoViewVideoHolder.OnNewGuideDialogDismissListener(this, this.jdField_d_of_type_Boolean));
        this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog.show();
        localStoryConfigManager.a(true);
        return true;
      }
      if ((a().a().getCount() > 1) && (!localStoryConfigManager.b()))
      {
        e();
        localStoryNewGuideDialog = this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog;
        if (localStoryNewGuideDialog != null) {
          localStoryNewGuideDialog.dismiss();
        }
        this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog = new StoryNewGuideDialog(a());
        this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog.a(HardCodeUtil.a(2131716174));
        this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog.setOnDismissListener(new VideoViewVideoHolder.OnNewGuideDialogDismissListener(this, this.jdField_d_of_type_Boolean));
        this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog.show();
        localStoryConfigManager.b(true);
        return true;
      }
    }
    return false;
  }
  
  public void f()
  {
    if (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.c()) {
      return;
    }
    int i1 = a().mReportData.from;
    if (VideoPlayModeConstants.a(i1)) {
      b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView, this.jdField_d_of_type_Int);
    } else {
      a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView, this.jdField_d_of_type_Int);
    }
    SLog.a(this.jdField_a_of_type_JavaLangString, "report video player done! vid :%s , from :%d , op_result: %d", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString, Integer.valueOf(i1), Integer.valueOf(this.jdField_d_of_type_Int));
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    switch (paramView.getId())
    {
    case 2131378447: 
    case 2131378448: 
    default: 
      break;
    case 2131378449: 
      localObject1 = ((VideoServerInfoManager)SuperManager.a(4)).b();
      if ((localObject1 != null) && (this.jdField_c_of_type_JavaLangString != null))
      {
        localObject2 = ((DownloadUrlManager)SuperManager.a(28)).a(URLUtil.a(this.jdField_c_of_type_JavaLangString, "authkey", (String)localObject1).replace("https://", "http://"));
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          localObject1 = (ClipboardManager)paramView.getContext().getSystemService("clipboard");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("VideoUrl(");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString);
          localStringBuilder.append(")");
          localObject2 = ClipData.newPlainText(localStringBuilder.toString(), localObject2[0]);
          ClipboardMonitor.setPrimaryClip((ClipboardManager)localObject1, (ClipData)localObject2);
          ((ClipboardManager)localObject1).setPrimaryClip((ClipData)localObject2);
          QQToast.a(paramView.getContext(), 2131694354, 0).a();
        }
      }
      break;
    case 2131378446: 
      localObject1 = FileCacheUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString, 0, false, false);
      if ((localObject1 != null) && (((File)localObject1).exists()))
      {
        localObject2 = new Intent("android.intent.action.VIEW");
        ((Intent)localObject2).addFlags(268435456);
        ((Intent)localObject2).setDataAndType(Uri.parse(((File)localObject1).getParent()), "resource/folder");
        try
        {
          if (((Intent)localObject2).resolveActivityInfo(a().getPackageManager(), 0) != null) {
            a((Intent)localObject2);
          } else {
            QQToast.a(paramView.getContext(), HardCodeUtil.a(2131716182), 0).a();
          }
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          localActivityNotFoundException.printStackTrace();
        }
      }
      break;
    case 2131378445: 
      ClipboardManager localClipboardManager = (ClipboardManager)paramView.getContext().getSystemService("clipboard");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("VideoInfo(");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(")");
      localObject2 = ClipData.newPlainText(((StringBuilder)localObject2).toString(), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString);
      ClipboardMonitor.setPrimaryClip(localClipboardManager, (ClipData)localObject2);
      localClipboardManager.setPrimaryClip((ClipData)localObject2);
      QQToast.a(paramView.getContext(), 2131694354, 0).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder
 * JD-Core Version:    0.7.0.1
 */