package com.tencent.mobileqq.activity.aio.photo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.aelight.camera.qqstory.api.IAECaptureContext;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.common.app.AppInterface;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.device.msg.activities.AIODevLittleVideoData;
import com.tencent.image.NativeVideoImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.image.VideoDrawable;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.MsgRevokeListener;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.OnProGalleryListener;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.ProGallery;
import com.tencent.mobileqq.activity.photo.ProGallery.OnProGalleryGestureListener;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.VideoPlayController.VideoPlayerStateListener;
import com.tencent.mobileqq.activity.photo.VideoPlayControllerForAIO;
import com.tencent.mobileqq.activity.photo.VideoPlayControllerForAIO.OnDownloadListener;
import com.tencent.mobileqq.activity.photo.VideoPlayControllerForFile;
import com.tencent.mobileqq.activity.photo.VideoPlayMedioInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MiniCodePeakHandler;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPlayUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanReportApi;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.splashad.SplashADUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qqfloatingscreen.videoview.TVKVideoController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.UnCompletedCode;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.WatchDismissActions;
import com.tencent.widget.AdapterView;
import com.tencent.widget.DragView;
import com.tencent.widget.Gallery;
import com.tencent.widget.RecentDynamicAvatarView;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.os.MqqHandler;

public class AIOGalleryScene
  extends AbstractGalleryScene
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, MsgRevokeListener, ProGallery.OnProGalleryGestureListener, VideoPlayController.VideoPlayerStateListener, VideoPlayControllerForAIO.OnDownloadListener, INetInfoHandler, ActionSheet.WatchDismissActions
{
  TextView D;
  ImageButton E;
  ImageButton F;
  RecentDynamicAvatarView G;
  ImageButton H;
  DragView I;
  AIOGalleryScene.RawPhotoProgress J;
  boolean K = false;
  long L = 0L;
  boolean M = false;
  boolean N = false;
  final int O = -3321;
  int P;
  final int Q = -2147483648;
  int R;
  boolean S = false;
  String T;
  boolean U;
  IAIOImageProvider V;
  String W;
  String X;
  boolean Y = false;
  String Z;
  AIOGalleryAdapter a;
  final Runnable aA = new AIOGalleryScene.3(this);
  boolean aB = false;
  MessageQueue.IdleHandler aC = new AIOGalleryScene.7(this);
  int aD;
  final MqqHandler aE = new AIOGalleryScene.8(this);
  ShareActionSheetBuilder aF;
  boolean aG;
  private INonMainProcAvatarLoader aH;
  private String aI;
  private Dialog aJ;
  private int aK = 0;
  String aa;
  int ab = 1;
  int ac;
  String ad;
  String ae;
  boolean af;
  boolean ag;
  boolean ah = false;
  boolean ai;
  int aj;
  boolean ak;
  int al = 5;
  ProgressPieDrawable am;
  boolean an = false;
  boolean ao = false;
  int ap = 0;
  protected int aq = -1;
  protected boolean ar = false;
  protected boolean as = false;
  boolean at = true;
  VideoPlayControllerForAIO au = new VideoPlayControllerForFile();
  TVKVideoController av;
  int aw;
  protected boolean ax = false;
  protected AIOGalleryScene.UIState ay = new AIOGalleryScene.UIState(this);
  final Runnable az = new AIOGalleryScene.2(this);
  AIORichMediaData b;
  AIOImageListModel c;
  boolean d = false;
  boolean e = false;
  TextView f;
  ImageButton g;
  LinearLayout h;
  RelativeLayout i;
  TextView j;
  ImageView k;
  SeekBar l;
  SeekBar m;
  TextView n;
  TextView o;
  RelativeLayout p;
  
  public AIOGalleryScene(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel, IAIOImageProvider paramIAIOImageProvider, String paramString)
  {
    super(paramActivity, paramAbstractImageListModel);
    this.c = ((AIOImageListModel)paramAbstractImageListModel);
    this.V = paramIAIOImageProvider;
    ((VideoPlayControllerForFile)this.au).a(paramIAIOImageProvider);
    this.W = paramString;
    if ((paramString == null) && (PeakActivity.class.isInstance(paramActivity))) {
      this.W = ((IAECaptureContext)QRoute.api(IAECaptureContext.class)).getAppInterface().getCurrentAccountUin();
    }
    paramAbstractImageListModel = (PeakAppInterface)((PeakActivity)paramActivity).getAppRuntime();
    if (paramAbstractImageListModel != null) {
      ((MiniCodePeakHandler)paramAbstractImageListModel.getBusinessHandler(PeakAppInterface.d)).a(paramActivity);
    }
  }
  
  private int S()
  {
    Object localObject = this.c.c().a;
    int i1 = 5;
    if (localObject != null)
    {
      if ((localObject instanceof AIOFilePicData)) {
        return 2;
      }
      if ((localObject instanceof AIOImageData))
      {
        if (((AIOImageData)localObject).C) {
          return i1;
        }
        return 1;
      }
      if ((localObject instanceof AIOShortVideoData))
      {
        localObject = (AIOShortVideoData)localObject;
        if (((AIOShortVideoData)localObject).d == 0) {
          return 4;
        }
        if (((AIOShortVideoData)localObject).d == 1) {
          return 3;
        }
      }
      else if ((localObject instanceof AIOFileVideoData))
      {
        return 5;
      }
    }
    i1 = -1;
    return i1;
  }
  
  private int T()
  {
    int i2 = this.ac;
    int i1 = 1;
    if (i2 != 0)
    {
      if (i2 != 1) {
        return 4;
      }
      i1 = 2;
    }
    return i1;
  }
  
  private void U()
  {
    Object localObject = this.c.c();
    if ((localObject != null) && (this.V.asBinder().pingBinder()))
    {
      this.J = new AIOGalleryScene.RawPhotoProgress(this);
      this.J.a = ((AIORichMediaInfo)localObject).a.L;
      this.J.b = ((AIORichMediaInfo)localObject).a.M;
      if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject).a))
      {
        ((AIORichMediaInfo)localObject).d.d = true;
        E();
        this.V.a(this.J.a, this.J.b, 4);
        return;
      }
      if (AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject).a))
      {
        if (!NetworkUtil.isNetSupport(this.w))
        {
          QQToast.makeText(this.w, this.w.getString(2131891334), 0).show();
          this.J = null;
          E();
          return;
        }
        localObject = (AIOFilePicData)((AIORichMediaInfo)localObject).a;
        if (((AIOFilePicData)localObject).k)
        {
          QQToast.makeText(this.w, this.w.getString(2131889788), 0).show();
          E();
          this.J = null;
          return;
        }
        if (((AIOFilePicData)localObject).n) {
          E();
        }
        long l1 = ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize();
        if ((((AIOFilePicData)localObject).l <= l1) || (!FileManagerUtil.b())) {}
      }
    }
    try
    {
      FileManagerUtil.a(false, this.w, new AIOGalleryScene.1(this));
      return;
    }
    catch (Throwable localThrowable) {}
    c(true);
    this.V.a(this.J.a, this.J.b, 20);
    this.q.enableDoubleTap(true);
    this.q.enableScaleGesture(true);
    return;
  }
  
  private void V()
  {
    if (this.au != null)
    {
      Object localObject1 = this.c.c();
      if (localObject1 != null)
      {
        if (AIOFileVideoData.class.isInstance(((AIORichMediaInfo)localObject1).a))
        {
          ((AIOFileVideoData)((AIORichMediaInfo)localObject1).a).m = true;
          this.au.e();
          this.au.g();
          x();
          return;
        }
        Object localObject2;
        if (AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject1).a))
        {
          localObject1 = (AIOShortVideoData)((AIORichMediaInfo)localObject1).a;
          if (((AIOShortVideoData)localObject1).d == 0)
          {
            localObject2 = this.V;
            if (localObject2 != null) {
              ((IAIOImageProvider)localObject2).b(((AIOShortVideoData)localObject1).L, ((AIOShortVideoData)localObject1).M, 256);
            }
            E();
            return;
          }
          if (((AIOShortVideoData)localObject1).d == 1)
          {
            this.ay.c = false;
            E();
          }
        }
        else
        {
          if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject1).a))
          {
            localObject2 = (AIOImageData)((AIORichMediaInfo)localObject1).a;
            if (((AIORichMediaInfo)localObject1).d.d)
            {
              localObject2 = this.V;
              if (localObject2 != null) {
                ((IAIOImageProvider)localObject2).b(this.J.a, this.J.b, 4);
              }
              ((AIORichMediaInfo)localObject1).d.d = false;
            }
            else
            {
              IAIOImageProvider localIAIOImageProvider = this.V;
              if (localIAIOImageProvider != null) {
                localIAIOImageProvider.b(((AIOImageData)localObject2).L, ((AIOImageData)localObject2).M, 24);
              }
              ((AIORichMediaInfo)localObject1).d.g = true;
            }
            E();
            return;
          }
          if (AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject1).a))
          {
            localObject1 = (AIOFilePicData)((AIORichMediaInfo)localObject1).a;
            localObject2 = this.V;
            if (localObject2 != null) {
              ((IAIOImageProvider)localObject2).b(((AIOFilePicData)localObject1).L, ((AIOFilePicData)localObject1).M, 24);
            }
            ((AIOFilePicData)localObject1).s = false;
            c(false);
            E();
          }
        }
      }
    }
  }
  
  private void W()
  {
    Object localObject1 = this.c.c();
    Object localObject2 = this.au;
    long l1;
    if (localObject2 != null) {
      l1 = ((VideoPlayControllerForAIO)localObject2).q();
    } else {
      l1 = 0L;
    }
    if ((localObject1 != null) && ((((AIORichMediaInfo)localObject1).a instanceof AIOShortVideoData)))
    {
      localObject1 = (AIOShortVideoData)((AIORichMediaInfo)localObject1).a;
      localObject2 = this.av;
      if (localObject2 != null) {
        ((TVKVideoController)localObject2).b();
      }
      this.av = new TVKVideoController(this.w);
      localObject2 = this.a.a((AIOShortVideoData)localObject1);
      if (localObject2 != null)
      {
        this.av.a((VideoPlayMedioInfo)localObject2, ((AIOShortVideoData)localObject1).i, l1);
        this.av.a(((AIOShortVideoData)localObject1).a, ((AIOShortVideoData)localObject1).g, ((AIOShortVideoData)localObject1).h);
        if (this.av.a(((AIOShortVideoData)localObject1).Q, ((AIOShortVideoData)localObject1).g, ((AIOShortVideoData)localObject1).h)) {
          x();
        }
      }
      else
      {
        QLog.d("AIOGalleryScene", 1, "Failed to floating, videoPlayMedioInfo is null");
      }
    }
    else if ((localObject1 != null) && ((((AIORichMediaInfo)localObject1).a instanceof AIOFileVideoData)))
    {
      localObject1 = (AIOFileVideoData)((AIORichMediaInfo)localObject1).a;
      if (!com.tencent.biz.qqstory.utils.FileUtils.d(((AIOFileVideoData)localObject1).c)) {
        return;
      }
      localObject2 = this.av;
      if (localObject2 != null) {
        ((TVKVideoController)localObject2).b();
      }
      this.av = new TVKVideoController(this.w);
      this.av.a(((AIOFileVideoData)localObject1).c, ((AIOFileVideoData)localObject1).L, l1);
      if (com.tencent.mobileqq.utils.FileUtils.fileExistsAndNotEmpty(((AIOFileVideoData)localObject1).b)) {
        this.av.a(((AIOFileVideoData)localObject1).b, ((AIOFileVideoData)localObject1).e, ((AIOFileVideoData)localObject1).f);
      }
      if (this.av.a(((AIOFileVideoData)localObject1).Q, ((AIOFileVideoData)localObject1).e, ((AIOFileVideoData)localObject1).f)) {
        x();
      }
    }
  }
  
  private AIOGalleryAdapter.GalleryImageStruct X()
  {
    int i1 = this.q.getFirstVisiblePosition();
    int i2 = this.q.getChildCount();
    int i3 = this.c.b();
    if ((i3 >= i1) && (i3 <= i2 + i1 - 1))
    {
      View localView = this.q.getChildAt(i3 - i1);
      if ((localView instanceof AIOGalleryAdapter.GalleryImageStruct)) {
        return (AIOGalleryAdapter.GalleryImageStruct)localView;
      }
    }
    return null;
  }
  
  private void Y()
  {
    this.F = new ImageButton(this.w);
    this.F.setContentDescription(HardCodeUtil.a(2131898293));
    this.F.setId(2131442308);
    this.F.setImageResource(2130847944);
    this.F.setBackgroundDrawable(null);
    this.F.setPadding(32, 12, 32, 12);
    Object localObject = this.w.getResources().getDisplayMetrics();
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.topMargin = ((int)TypedValue.applyDimension(1, 10.0F, (DisplayMetrics)localObject));
    localLayoutParams.leftMargin = ((int)TypedValue.applyDimension(1, 24.0F, (DisplayMetrics)localObject));
    localObject = (AIORichMediaData)this.w.getIntent().getExtras().getParcelable("extra.EXTRA_CURRENT_IMAGE");
    this.t.addView(this.F, localLayoutParams);
    this.F.setOnClickListener(this);
    e(false);
  }
  
  private void Z()
  {
    int i1 = this.ac;
    String str;
    if (i1 != 0) {
      if (i1 != 1)
      {
        if ((i1 != 1000) && (i1 != 1004)) {
          if (i1 != 3000)
          {
            if ((i1 != 10008) && (i1 != 10013))
            {
              localObject = "";
              break label105;
            }
          }
          else
          {
            str = this.Z;
            localObject = str;
            if (!TextUtils.isEmpty(str)) {
              break label105;
            }
            localObject = this.X;
            break label105;
          }
        }
      }
      else
      {
        str = this.Z;
        localObject = str;
        if (!TextUtils.isEmpty(str)) {
          break label105;
        }
        localObject = this.X;
        break label105;
      }
    }
    Object localObject = this.X;
    label105:
    Activity localActivity = this.w;
    i1 = this.ac;
    if (TextUtils.isEmpty(this.aI)) {
      str = this.X;
    } else {
      str = this.aI;
    }
    MiniChatActivity.a(localActivity, i1, (String)localObject, str);
  }
  
  private int a(String paramString)
  {
    int i1 = this.aq;
    if (i1 != 1)
    {
      if (i1 != 2) {
        if (i1 != 3) {
          if (i1 == 5) {}
        }
      }
      do
      {
        for (;;)
        {
          return -1;
          if ("0X8009EFC".equals(paramString)) {
            return 6;
          }
          if ("0X8009EFD".equals(paramString))
          {
            break;
            if ("0X8009EFC".equals(paramString)) {
              return 4;
            }
            "0X8009EFD".equals(paramString);
          }
        }
        if ("0X8009EFC".equals(paramString)) {
          return 5;
        }
      } while (!"0X8009EFD".equals(paramString));
      return 4;
    }
    return 1;
  }
  
  private <T extends AIORichMediaInfo> T a(long paramLong1, long paramLong2)
  {
    Iterator localIterator = this.c.i().iterator();
    while (localIterator.hasNext())
    {
      AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)localIterator.next();
      if ((localAIORichMediaInfo.a.L == paramLong1) && (localAIORichMediaInfo.a.M == paramLong2)) {
        return localAIORichMediaInfo;
      }
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.w.getString(paramInt1);
    localActionSheetItem.icon = paramInt2;
    localActionSheetItem.action = paramInt3;
    localActionSheetItem.argus = paramString;
    paramArrayList.add(localActionSheetItem);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.w.getString(paramInt1);
    localActionSheetItem.icon = paramInt2;
    localActionSheetItem.action = paramInt3;
    localActionSheetItem.argus = "";
    paramArrayList.add(localActionSheetItem);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList, int paramInt4)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.w.getString(paramInt1);
    localActionSheetItem.icon = paramInt2;
    localActionSheetItem.action = paramInt3;
    localActionSheetItem.argus = "";
    localActionSheetItem.firstLineCount = paramInt4;
    paramArrayList.add(localActionSheetItem);
  }
  
  private void a(int paramInt, File paramFile)
  {
    if (paramInt != 1) {
      if (paramInt != 2) {
        localObject1 = null;
      }
    }
    for (;;)
    {
      break;
      localObject1 = "0X8007A25";
      continue;
      localObject1 = "0X8007A24";
    }
    if (localObject1 != null) {
      ReportController.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
    }
    Object localObject1 = (PeakActivity)this.w;
    if (this.w.getIntent() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "save video failed, intent is null");
      }
      QQToast.makeText((Context)localObject1, 1, HardCodeUtil.a(2131898312), 0).show();
      return;
    }
    NativeVideoImage.pauseAll();
    paramInt = this.q.getFirstVisiblePosition();
    int i1 = this.q.getChildCount();
    int i2 = this.c.b();
    if ((i2 >= paramInt) && (i2 <= i1 + paramInt - 1))
    {
      localObject2 = this.q.getChildAt(i2 - paramInt);
      if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(localObject2)) {
        this.a.a(i2, (AIOGalleryAdapter.GalleryImageStruct)localObject2);
      }
    }
    Object localObject2 = ShortVideoUtils.getLocalShortVideoPath();
    a((Activity)localObject1, HardCodeUtil.a(2131898311), false, 0);
    if (com.tencent.biz.qqstory.utils.FileUtils.a(BaseApplication.getContext(), paramFile.getAbsolutePath(), (String)localObject2)) {
      this.aE.sendEmptyMessage(10000);
    } else {
      this.aE.sendEmptyMessage(10001);
    }
    ReportController.b(null, "CliOper", "", "", "0X800610F", "0X800610F", 0, 0, "", "", "", "");
  }
  
  private void a(long paramLong, int paramInt)
  {
    Object localObject = this.c.c().a;
    if ((((AIORichMediaData)localObject).L == paramLong) && (((AIORichMediaData)localObject).M == paramInt))
    {
      if (this.l != null)
      {
        localObject = this.j;
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131898302));
          double d1 = this.aj;
          Double.isNaN(d1);
          localStringBuilder.append(d1 / 100.0D);
          localStringBuilder.append("%");
          ((TextView)localObject).setText(localStringBuilder.toString());
          this.l.setProgress(this.aj);
        }
      }
      return;
    }
    localObject = a(paramLong, paramInt);
    if (localObject != null) {
      ((AIORichMediaInfo)localObject).d.a = this.aj;
    }
  }
  
  private void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
  {
    Object localObject = this.c.c().a;
    if ((((AIORichMediaData)localObject).L == paramLong1) && (((AIORichMediaData)localObject).M == paramInt1))
    {
      this.c.c().b = paramInt3;
      localObject = this.j;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131898296));
      double d1 = paramLong2;
      double d2 = paramInt3;
      Double.isNaN(d2);
      d2 /= 10000.0D;
      Double.isNaN(d1);
      localStringBuilder.append(FileUtil.a((d1 * d2)));
      localStringBuilder.append("/");
      localStringBuilder.append(FileUtil.a(paramLong2));
      localStringBuilder.append(")");
      ((TextView)localObject).setText(localStringBuilder.toString());
      this.l.setProgress(paramInt3);
      return;
    }
    localObject = a(paramLong1, paramInt1);
    if (localObject != null) {
      ((AIORichMediaInfo)localObject).b = paramInt3;
    }
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Object localObject = this.c.c().a;
    if ((((AIORichMediaData)localObject).L == paramLong) && (((AIORichMediaData)localObject).M == paramInt1))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("save pic result = ");
        ((StringBuilder)localObject).append(paramInt3);
        ((StringBuilder)localObject).append(", resultStr = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject).toString());
      }
      if (paramInt3 == 1) {
        QQToast.makeText(this.w, this.w.getString(2131915871), 0).show();
      } else {
        QQToast.makeText(this.w, this.w.getString(2131915867), 0).show();
      }
      E();
    }
    else
    {
      paramString = a(paramLong, paramInt1);
      if (paramString != null) {
        paramString.d.f = false;
      }
    }
    paramString = this.J;
    if ((paramString != null) && (paramString.a == paramLong) && (this.J.b == paramInt1)) {
      this.J = null;
    }
  }
  
  private void a(long paramLong, int paramInt, String paramString)
  {
    int i1 = 0;
    while (i1 < this.c.a())
    {
      AIORichMediaInfo localAIORichMediaInfo = this.c.a(i1);
      if ((localAIORichMediaInfo != null) && (localAIORichMediaInfo.a != null) && (AIOFileVideoData.class.isInstance(localAIORichMediaInfo.a)))
      {
        AIOFileVideoData localAIOFileVideoData = (AIOFileVideoData)localAIORichMediaInfo.a;
        if (localAIORichMediaInfo.a.L == paramLong)
        {
          if (paramInt == 1)
          {
            localAIOFileVideoData.o = true;
            localAIOFileVideoData.p = false;
            localAIOFileVideoData.c = paramString;
          }
          else if (paramInt == 2)
          {
            localAIOFileVideoData.o = false;
          }
          E();
          if (this.c.c() == localAIORichMediaInfo) {
            this.au.b(0);
          }
        }
      }
      i1 += 1;
    }
  }
  
  private void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject = this.c.i();
    int i1 = 0;
    while (i1 < ((List)localObject).size())
    {
      AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)((List)localObject).get(i1);
      if ((localAIORichMediaInfo.a.L == paramLong) && (localAIORichMediaInfo.a.M == paramInt))
      {
        paramInt = this.aj;
        localAIORichMediaInfo.b = paramInt;
        this.a.b(i1, paramInt / 100);
        if (paramBoolean)
        {
          paramInt = this.q.getFirstVisiblePosition();
          int i2 = this.q.getChildCount();
          if ((i1 >= paramInt) && (i1 <= i2 + paramInt - 1))
          {
            localObject = this.q.getChildAt(i1 - paramInt);
            this.a.a(i1, (View)localObject, paramBoolean);
          }
        }
        return;
      }
      i1 += 1;
    }
  }
  
  private void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = this.c.i();
    int i1 = 0;
    while (i1 < ((List)localObject).size())
    {
      AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)((List)localObject).get(i1);
      if (localAIORichMediaInfo.a.L == paramLong)
      {
        int i2 = this.aj;
        localAIORichMediaInfo.b = i2;
        this.a.b(i1, i2 / 100);
        if (paramBoolean)
        {
          i2 = this.q.getFirstVisiblePosition();
          int i3 = this.q.getChildCount();
          if ((i1 >= i2) && (i1 <= i3 + i2 - 1))
          {
            localObject = this.q.getChildAt(i1 - i2);
            this.a.a(i1, (View)localObject, paramBoolean);
          }
        }
        return;
      }
      i1 += 1;
    }
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean)
  {
    if (paramActivity == null) {
      return;
    }
    long l1;
    if ((paramInt2 != 1) && (paramInt2 != 3000)) {
      l1 = paramLong1;
    } else {
      l1 = paramLong2;
    }
    Object localObject2 = paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("jumpToTargetAIOPosition, className = ");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(", time = ");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append(" , shmsgseq = ");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append(", isEmotion = ");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putBoolean("need_jump_to_msg", true);
    ((Bundle)localObject1).putLong("searched_timeorseq", l1);
    ((Bundle)localObject1).putLong("searched_time", paramLong1);
    ((Bundle)localObject1).putLong("target_shmsgseq", paramLong2);
    ((Bundle)localObject1).putBoolean("searched_update_session", true);
    Intent localIntent = new Intent();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localIntent.setClassName(paramActivity, (String)localObject2);
    } else {
      localIntent.setClass(paramActivity, SplashActivity.class);
    }
    int i1 = paramActivity.getIntent().getIntExtra("extra.EXTRA_ENTRANCE", -1);
    boolean bool1;
    if ((i1 != 2) && (i1 != 3)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    boolean bool3 = paramActivity.getIntent().getBooleanExtra("from_chat_history", false);
    boolean bool2;
    if (paramBoolean) {
      bool2 = bool3;
    } else {
      bool2 = bool1;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("jumpToTargetAIOPosition, isFromHistory = ");
      ((StringBuilder)localObject2).append(bool2);
      ((StringBuilder)localObject2).append(", isEmotion = ");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(", sourceEntrance = ");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append(", fromHistory_picAndVideo = ");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(", fromHistory_emotion = ");
      ((StringBuilder)localObject2).append(bool3);
      QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject2).toString());
    }
    if (bool2)
    {
      paramInt1 = paramActivity.getIntent().getIntExtra("FromChatHistoryTab", 0);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("jumpToTargetAIOPosition, fromType = ");
        ((StringBuilder)localObject2).append(paramInt1);
        QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject2).toString());
      }
      if ((paramInt1 != 2) && (paramInt1 != 4))
      {
        localIntent.putExtras((Bundle)localObject1);
        paramActivity.setResult(-1, localIntent);
        paramActivity.finish();
        return;
      }
      if (paramInt2 == 1)
      {
        ChatHistoryBubbleListForTroopFragment.a(paramActivity, paramString2, paramLong2, -1, 0);
        return;
      }
      ChatHistoryActivity.a(paramActivity, paramString1, paramInt2, "", paramLong1, paramLong2, 0);
      return;
    }
    localIntent = AIOUtils.a(localIntent, null);
    localIntent.putExtras((Bundle)localObject1);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt1);
    localIntent.putExtra("troop_uin", paramString2);
    localIntent.addFlags(603979776);
    localIntent.putExtra("entrance", 1);
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.a(new Intent(paramActivity, SplashActivity.class), null);
    paramBundle = new Bundle(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "AIOGallerysence startChatAndSendMsg IS_WAIT_DEST_RESULT=true");
    }
    paramBundle.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
    paramBundle.putBoolean("PhotoConst.IS_FORWARD", true);
    paramBundle.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
    paramBundle.putBoolean("PicContants.NEED_COMPRESS", false);
    localIntent.putExtras(paramBundle);
    String str = paramBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(str);
    PhotoUtils.sendPhoto(paramActivity, localIntent, localArrayList, paramBundle.getInt("PhotoConst.SEND_SIZE_SPEC", 0), true);
  }
  
  private void a(Dialog paramDialog)
  {
    if ((paramDialog != null) && (this.w != null) && (!this.w.isFinishing())) {
      try
      {
        paramDialog.show();
        return;
      }
      catch (Throwable paramDialog)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("showDialogSafe exception: ");
          localStringBuilder.append(paramDialog.getMessage());
          QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  private void a(Uri paramUri, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    if (this.w != null)
    {
      if (this.w.isFinishing()) {
        return;
      }
      Object localObject1 = this.q.getSelectedView();
      SparseArray localSparseArray = new SparseArray(2);
      AIOGalleryAdapter.GalleryImageStruct localGalleryImageStruct = null;
      Object localObject3 = null;
      int i2;
      Object localObject2;
      if ((localObject1 instanceof AIOGalleryAdapter.GalleryImageStruct))
      {
        localGalleryImageStruct = (AIOGalleryAdapter.GalleryImageStruct)localObject1;
        i2 = localGalleryImageStruct.getWidth();
        int i3 = localGalleryImageStruct.getHeight();
        if (i2 >= i3 * 2) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i3 >= i2 * 2) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        if (i1 == 0)
        {
          localObject1 = localObject3;
          if (i2 == 0) {}
        }
        else
        {
          localObject1 = new Matrix();
          ((Matrix)localObject1).set(this.q.getChildMatrix(localGalleryImageStruct));
          Rect localRect = new Rect(localGalleryImageStruct.getLeft(), localGalleryImageStruct.getTop(), localGalleryImageStruct.getRight(), localGalleryImageStruct.getBottom());
          try
          {
            localObject1 = localGalleryImageStruct.a(localRect, (Matrix)localObject1, this.q.getWidth(), this.q.getHeight());
          }
          catch (Throwable localThrowable)
          {
            localObject1 = localObject3;
            if (QLog.isColorLevel())
            {
              QLog.i("AIOGalleryScene", 2, localThrowable.getMessage(), localThrowable);
              localObject1 = localObject3;
            }
          }
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          i2 = ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).decodeQQCodeFromBmp((Bitmap)localObject1, 3, localSparseArray) | 0x0;
          i1 = i2;
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            break label311;
          }
          QLog.i("AIOGalleryScene", 2, String.format("checkQQCode bmp!=null result=%d", new Object[] { Integer.valueOf(i2) }));
          i1 = i2;
          localObject2 = localObject1;
          break label311;
        }
      }
      int i1 = 0;
      label311:
      if (localObject2 == null)
      {
        i2 = ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile(paramUri, this.w, 3, localSparseArray);
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.i("AIOGalleryScene", 2, String.format("checkQQCode bmp=null result=%d", new Object[] { Integer.valueOf(i2) }));
          i1 = i2;
        }
      }
      ThreadManager.getUIHandler().post(new AIOGalleryScene.21(this, i1, localSparseArray, paramArrayList));
      if (i1 > 0) {
        this.ad = paramUri.getPath();
      }
      ((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).onAIOScanRecogTypeReport(i1);
    }
  }
  
  private void a(View paramView)
  {
    paramView = (ImageView)paramView;
    Object localObject;
    if ((this.c.c().a instanceof AIOShortVideoData))
    {
      if (((AIOShortVideoData)this.c.c().a).d == 0)
      {
        localObject = this.au;
        if (localObject != null)
        {
          ((VideoPlayControllerForAIO)localObject).h();
          if (this.au.p()) {
            paramView.setImageResource(2130847780);
          } else {
            paramView.setImageResource(2130847779);
          }
          this.aE.postDelayed(this.aA, 100L);
        }
      }
      else
      {
        localObject = X();
        if (localObject != null)
        {
          Drawable localDrawable = ((AIOGalleryAdapter.GalleryImageStruct)localObject).getDrawable();
          if ((localDrawable instanceof URLDrawable))
          {
            int i1 = ((URLDrawable)localDrawable).getPlayState();
            int i2 = this.c.b();
            if (i1 == 2)
            {
              ((AIOGalleryAdapter.GalleryImageStruct)localObject).b(i2);
              paramView.setImageResource(2130847779);
              ((AIOGalleryAdapter.GalleryImageStruct)localObject).b.setVisibility(0);
              return;
            }
            if (i1 == 4)
            {
              ((AIOGalleryAdapter.GalleryImageStruct)localObject).b(i2);
              paramView.setImageResource(2130847780);
              ((AIOGalleryAdapter.GalleryImageStruct)localObject).b.setVisibility(8);
              return;
            }
            if (i1 == 6)
            {
              ((AIOGalleryAdapter.GalleryImageStruct)localObject).b(i2);
              ((AIOGalleryAdapter.GalleryImageStruct)localObject).b.setVisibility(8);
              paramView.setImageResource(2130847780);
              return;
            }
            if (i1 == -1)
            {
              ((AIOGalleryAdapter.GalleryImageStruct)localObject).b(i2);
              ((AIOGalleryAdapter.GalleryImageStruct)localObject).b.setVisibility(8);
              paramView.setImageResource(2130847780);
            }
          }
        }
      }
    }
    else if ((this.c.c().a instanceof AIOFileVideoData))
    {
      localObject = this.au;
      if (localObject != null)
      {
        ((VideoPlayControllerForAIO)localObject).h();
        if (this.au.p()) {
          paramView.setImageResource(2130847780);
        } else {
          paramView.setImageResource(2130847779);
        }
        this.aE.postDelayed(this.aA, 100L);
      }
    }
  }
  
  private void a(AIOFilePicData paramAIOFilePicData)
  {
    this.g.setVisibility(0);
    if (paramAIOFilePicData.l > 10485760) {
      this.g.setEnabled(false);
    } else if ((paramAIOFilePicData.c(18) == null) && (paramAIOFilePicData.c(20) == null)) {
      this.g.setEnabled(false);
    } else {
      this.g.setEnabled(true);
    }
    if (FileUtil.b(paramAIOFilePicData.e)) {
      this.f.setVisibility(8);
    } else {
      this.f.setVisibility(0);
    }
    if (this.A) {
      this.H.setVisibility(8);
    } else {
      this.H.setVisibility(0);
    }
    if (paramAIOFilePicData.s)
    {
      d(false);
      this.H.setVisibility(8);
      this.g.setVisibility(8);
    }
  }
  
  private void a(AIOFilePicData paramAIOFilePicData, int paramInt)
  {
    Object localObject2 = paramAIOFilePicData.c(20);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramAIOFilePicData.c(18);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramAIOFilePicData.c(16);
    }
    if ((localObject2 == null) && (this.aB)) {
      return;
    }
    a(paramAIOFilePicData, (File)localObject2, paramInt);
  }
  
  private void a(AIOFileVideoData paramAIOFileVideoData)
  {
    this.au.a(8, "");
    this.H.setVisibility(8);
    e(true);
    if ((paramAIOFileVideoData.o) || (paramAIOFileVideoData.a()))
    {
      this.H.setVisibility(0);
      this.i.setVisibility(8);
      this.h.setVisibility(0);
    }
    if (paramAIOFileVideoData.b())
    {
      this.au.a(0, paramAIOFileVideoData.c());
      this.h.setVisibility(8);
    }
    if (paramAIOFileVideoData.p)
    {
      this.h.setVisibility(8);
      if (!paramAIOFileVideoData.a()) {
        this.au.b(8);
      } else {
        this.au.b(0);
      }
    }
    if (!this.c.c().d.h)
    {
      this.h.setVisibility(8);
      this.i.setVisibility(8);
    }
    if (this.aq == 3) {
      this.H.setVisibility(8);
    }
  }
  
  private void a(AIOFileVideoData paramAIOFileVideoData, int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    a(2131889838, 2130840466, 59, localArrayList1);
    a(2131889848, 2130840475, 53, localArrayList1);
    ReportController.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
    a(2131889840, 2130845687, 67, localArrayList1);
    a(2131889850, 2130840476, 58, localArrayList1);
    a(2131889837, 2130840465, 57, localArrayList1);
    if ((this.ac != -1) && (!TextUtils.isEmpty(this.X)) && (this.at)) {
      a(2131889852, 2130840477, 54, localArrayList2);
    }
    if (FileUtil.b(paramAIOFileVideoData.c)) {
      a(2131889844, 2130840471, 64, localArrayList2, 5);
    }
    a(paramAIOFileVideoData, null, false);
    paramAIOFileVideoData = (List[])new ArrayList[] { localArrayList1, localArrayList2 };
    this.aF.setActionSheetItems(paramAIOFileVideoData);
    this.aF.show();
  }
  
  private void a(AIOImageData paramAIOImageData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_Manager", 2, "action sheet add to favorite.");
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("pic_md5", paramAIOImageData.q);
    paramAIOImageData = new AIOGalleryScene.11(this);
    QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_add_fav", localBundle, paramAIOImageData);
    if (this.U) {
      VasWebviewUtil.a("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
    }
  }
  
  private void a(AIOImageData paramAIOImageData, int paramInt, AIORichMediaInfo paramAIORichMediaInfo)
  {
    if ((paramAIOImageData.Q == 1) && (paramAIOImageData.C))
    {
      Object localObject = paramAIOImageData.c(4);
      paramAIORichMediaInfo = (AIORichMediaInfo)localObject;
      if (localObject == null) {
        paramAIORichMediaInfo = paramAIOImageData.c(2);
      }
      localObject = paramAIORichMediaInfo;
      if (paramAIORichMediaInfo == null) {
        localObject = paramAIOImageData.c(1);
      }
      if ((localObject == null) && (this.aB)) {
        return;
      }
      a(paramAIOImageData, (File)localObject, paramInt);
      return;
    }
    e(paramAIORichMediaInfo);
  }
  
  private void a(AIOImageData paramAIOImageData, AIORichMediaInfo paramAIORichMediaInfo)
  {
    this.h.setVisibility(8);
    this.i.setVisibility(8);
    this.p.setVisibility(8);
    e(false);
    int i1 = this.V.a(paramAIOImageData.L, paramAIOImageData.M);
    Object localObject;
    StringBuilder localStringBuilder;
    if (paramAIORichMediaInfo.d.d)
    {
      this.f.setVisibility(8);
      this.H.setVisibility(8);
      this.g.setVisibility(8);
      this.l.setProgress(0);
      localObject = this.j;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131898304));
      localStringBuilder.append(paramAIORichMediaInfo.d.a);
      localStringBuilder.append("%");
      ((TextView)localObject).setText(localStringBuilder.toString());
      this.i.setVisibility(0);
    }
    else if (paramAIORichMediaInfo.d.f)
    {
      this.f.setVisibility(8);
      this.H.setVisibility(8);
      this.g.setVisibility(8);
      this.l.setProgress(0);
      this.j.setText(HardCodeUtil.a(2131898292));
      this.i.setVisibility(0);
      paramAIORichMediaInfo.d.f = false;
    }
    else if ((i1 != -1) && (!paramAIORichMediaInfo.d.g))
    {
      this.f.setVisibility(8);
      this.H.setVisibility(8);
      this.g.setVisibility(8);
      localObject = this.l;
      double d1 = i1;
      Double.isNaN(d1);
      ((SeekBar)localObject).setProgress((int)(d1 / 100.0D * 10000.0D));
      localObject = this.j;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131898305));
      localStringBuilder.append(i1);
      localStringBuilder.append("%");
      ((TextView)localObject).setText(localStringBuilder.toString());
      this.i.setVisibility(0);
    }
    else
    {
      if (this.A) {
        this.H.setVisibility(8);
      } else {
        this.H.setVisibility(0);
      }
      if ((paramAIOImageData.a(4)) && (paramAIOImageData.c(4) == null)) {
        d(true);
      } else {
        d(false);
      }
      this.g.setVisibility(0);
      if ((paramAIOImageData.c(2) == null) && (paramAIOImageData.c(4) == null)) {
        this.g.setEnabled(false);
      } else {
        this.g.setEnabled(true);
      }
    }
    if (paramAIOImageData.r == 3)
    {
      if (!AIOImageData.class.isInstance(paramAIOImageData)) {
        return;
      }
      if (paramAIOImageData.k)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "troop show pic file, file is progressive");
        }
        this.f.setVisibility(8);
        this.H.setVisibility(8);
        this.g.setVisibility(8);
        this.l.setProgress(0);
        localObject = this.j;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131898333));
        localStringBuilder.append(paramAIORichMediaInfo.d.a);
        localStringBuilder.append("%");
        ((TextView)localObject).setText(localStringBuilder.toString());
        this.i.setVisibility(0);
        if (this.J == null)
        {
          this.J = new AIOGalleryScene.RawPhotoProgress(this);
          this.J.a = paramAIOImageData.L;
          this.J.b = paramAIOImageData.M;
          this.c.c().d.d = true;
          paramAIOImageData.k = false;
        }
      }
    }
  }
  
  private void a(AIOImageData paramAIOImageData, AIORichMediaInfo paramAIORichMediaInfo, File paramFile)
  {
    this.aF.setItemClickListener(new AIOGalleryScene.9(this, paramAIOImageData, paramAIORichMediaInfo, paramFile));
    this.aF.setCancelListener(new AIOGalleryScene.10(this));
  }
  
  private void a(AIORichMediaData paramAIORichMediaData)
  {
    if (this.V.asBinder().pingBinder())
    {
      Intent localIntent1 = this.V.c(paramAIORichMediaData.L, paramAIORichMediaData.M, 0);
      if (localIntent1 == null)
      {
        QLog.w("AIOGalleryScene", 1, "getForwardData return null from main process");
        return;
      }
      localIntent1.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
      int i1;
      if (paramAIORichMediaData.Q == 1) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 == 0)
      {
        localIntent1.putExtra("filepictest", true);
        paramAIORichMediaData = (ForwardFileInfo)localIntent1.getParcelableExtra("fileinfo");
        String str1 = localIntent1.getStringExtra("forward_filepath");
        boolean bool1 = localIntent1.getBooleanExtra("k_favorites", false);
        String str2 = localIntent1.getStringExtra("forward_text");
        boolean bool2 = localIntent1.getBooleanExtra("isFromShare", false);
        i1 = localIntent1.getIntExtra("forward_type", 0);
        Intent localIntent2 = new Intent();
        localIntent2.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
        Bundle localBundle = new Bundle();
        localBundle.putInt("forward_type", i1);
        localBundle.putParcelable("fileinfo", paramAIORichMediaData);
        localBundle.putBoolean("not_forward", true);
        localIntent2.putExtras(localBundle);
        localIntent2.putExtra("forward_filepath", str1);
        localIntent2.putExtra("forward_text", str2);
        localIntent2.putExtra("k_favorites", bool1);
        localIntent2.putExtra("isFromShare", bool2);
        if (AIOFilePicData.class.isInstance(localIntent1))
        {
          localIntent2.putExtra("isPic", true);
          localIntent2.putExtra("direct_send_if_dataline_forward", true);
        }
        ForwardBaseOption.a(this.w, localIntent1, 103);
        return;
      }
      ForwardBaseOption.a(this.w, localIntent1, 21);
    }
  }
  
  private void a(AIORichMediaData paramAIORichMediaData, File paramFile)
  {
    if (AIOFilePicData.class.isInstance(paramAIORichMediaData))
    {
      AIOGalleryUtils.a(this.w, paramFile, Utils.Crc64String(paramFile.getAbsolutePath()));
      return;
    }
    if (AIOFileVideoData.class.isInstance(paramAIORichMediaData))
    {
      paramFile = new Bundle();
      float f1 = 0.0F;
      if (VideoPlayControllerForFile.class.isInstance(this.au)) {
        f1 = ((VideoPlayControllerForFile)this.au).a(paramAIORichMediaData.L);
      }
      paramFile.putFloat("progress", f1);
      this.V.a(paramAIORichMediaData.L, 13, paramFile);
      ((AIOFileVideoData)paramAIORichMediaData).p = true;
      this.au.j();
      E();
      return;
    }
    if (AIOImageData.class.isInstance(paramAIORichMediaData))
    {
      if ((paramFile != null) && (paramFile.exists()))
      {
        AIOGalleryUtils.a(this.w, paramFile, Utils.Crc64String(paramFile.getAbsolutePath()));
        return;
      }
      QLog.i("AIOGalleryScene", 1, "menu item click, troop file action AIOGallerysence, but file is null");
    }
  }
  
  private void a(AIORichMediaData paramAIORichMediaData, File paramFile, int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    a(2131889838, 2130840466, 59, localArrayList1);
    if ((PicShareToWX.b().e()) && (PicShareToWX.b().a(paramFile))) {
      a(2131889849, 2130848588, 69, localArrayList1);
    }
    a(2131889848, 2130840475, 53, localArrayList1);
    ReportController.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
    a(2131889840, 2130845687, 67, localArrayList1);
    a(2131889850, 2130840476, 58, localArrayList1);
    a(2131889837, 2130840465, 57, localArrayList1);
    if ((this.ac != -1) && (!TextUtils.isEmpty(this.X)) && (this.at)) {
      a(2131889852, 2130840477, 54, localArrayList2);
    }
    if (this.S) {
      a(2131889843, 2130840470, 52, localArrayList2, 2);
    }
    ThreadManager.getFileThreadHandler().post(new AIOGalleryScene.20(this, paramFile, localArrayList2));
    a(paramAIORichMediaData, paramFile, true);
    paramAIORichMediaData = (List[])new ArrayList[] { localArrayList1, localArrayList2 };
    this.aF.setActionSheetItems(paramAIORichMediaData);
    this.aF.show();
  }
  
  private void a(AIORichMediaData paramAIORichMediaData, File paramFile, boolean paramBoolean)
  {
    this.aF.setItemClickListener(new AIOGalleryScene.22(this, paramAIORichMediaData, paramBoolean, paramFile));
  }
  
  private void a(AIORichMediaData paramAIORichMediaData, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("preResult", paramString);
    if (AIOImageData.class.isInstance(paramAIORichMediaData))
    {
      paramAIORichMediaData = (AIOImageData)paramAIORichMediaData;
      a(this.ad, paramAIORichMediaData.Q, paramAIORichMediaData.C, paramAIORichMediaData.B, paramAIORichMediaData.q, paramAIORichMediaData.A, paramAIORichMediaData.n, 2, localIntent);
      return;
    }
    if (AIOFilePicData.class.isInstance(paramAIORichMediaData))
    {
      paramString = (AIOFilePicData)paramAIORichMediaData;
      if (MessageRecordInfo.b(paramString.p)) {
        paramAIORichMediaData = this.W;
      } else {
        paramAIORichMediaData = this.X;
      }
      a(this.ad, paramString.b, true, paramAIORichMediaData, null, null, paramString.r, 2, localIntent);
    }
  }
  
  private void a(AIORichMediaInfo paramAIORichMediaInfo, File paramFile)
  {
    try
    {
      paramAIORichMediaInfo = this.V.b(paramAIORichMediaInfo.a.L, paramAIORichMediaInfo.a.M);
      if (paramAIORichMediaInfo == null) {
        QfavBuilder.b(paramFile.getAbsolutePath()).a(this.w, this.W);
      } else {
        new QfavBuilder(paramAIORichMediaInfo).a(this.w, this.W);
      }
      QfavReport.a(null, 40, 3);
      return;
    }
    catch (RemoteException paramAIORichMediaInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AIOGalleryScene", 2, "", paramAIORichMediaInfo);
      }
      QQToast.makeText(this.w.getApplicationContext(), this.w.getString(2131889833), 0).show();
    }
  }
  
  private void a(AIORichMediaInfo paramAIORichMediaInfo, String paramString1, String[] paramArrayOfString, String paramString2, View paramView)
  {
    AIOFileVideoData localAIOFileVideoData = (AIOFileVideoData)paramAIORichMediaInfo.a;
    if (localAIOFileVideoData.l)
    {
      paramString1 = new StringBuilder();
      paramString1.append("filevideo is playing:");
      paramString1.append(paramAIORichMediaInfo.a.L);
      QLog.i("VideoPlayControllerForFile", 1, paramString1.toString());
      return;
    }
    localAIOFileVideoData.l = true;
    if ("I:E".equals(paramString1)) {}
    try
    {
      localAIOFileVideoData.j = Long.parseLong(paramArrayOfString[0]);
      paramString1 = paramArrayOfString[1];
      localAIOFileVideoData.a(paramString1);
      if (localAIOFileVideoData.j == -134L)
      {
        paramAIORichMediaInfo = this.w.getString(2131916639);
      }
      else
      {
        paramAIORichMediaInfo = paramString1;
        if (localAIOFileVideoData.j != -7003L) {
          if (localAIOFileVideoData.j == -6101L) {
            paramAIORichMediaInfo = paramString1;
          }
        }
      }
    }
    catch (NumberFormatException paramAIORichMediaInfo)
    {
      for (;;)
      {
        continue;
        paramAIORichMediaInfo = paramString1;
        int i1 = 0;
        continue;
        i1 = 1;
      }
    }
    if (i1 != 0)
    {
      paramAIORichMediaInfo = DialogUtil.a(this.w, 230, "", paramAIORichMediaInfo, null, HardCodeUtil.a(2131898306), new AIOGalleryScene.30(this), null);
      if (!paramAIORichMediaInfo.isShowing()) {
        paramAIORichMediaInfo.show();
      }
      return;
      localAIOFileVideoData.j = -1L;
    }
    localAIOFileVideoData.k = paramArrayOfString[1];
    break label239;
    localAIOFileVideoData.g = paramArrayOfString[0];
    localAIOFileVideoData.i = paramString1;
    localAIOFileVideoData.h = paramString2;
    label239:
    paramAIORichMediaInfo = localAIOFileVideoData.a(this.as);
    this.au.a(paramView, paramAIORichMediaInfo);
    if ((AIOGalleryActivity.class.isInstance(this.w)) && (this.a.a(localAIOFileVideoData.L)))
    {
      ((AIOGalleryActivity)this.w).n = true;
      this.au.c();
      this.au.h();
      this.as = false;
    }
  }
  
  private void a(AIORichMediaInfo paramAIORichMediaInfo, boolean paramBoolean)
  {
    if ((paramAIORichMediaInfo.a instanceof AIOFileVideoData))
    {
      paramAIORichMediaInfo = this.au;
      if ((paramAIORichMediaInfo != null) && (paramAIORichMediaInfo.p())) {
        this.au.j();
      }
    }
    else if ((paramAIORichMediaInfo.a instanceof AIOShortVideoData))
    {
      paramAIORichMediaInfo = (AIOShortVideoData)paramAIORichMediaInfo.a;
      if (paramAIORichMediaInfo.d == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "onRevokeMsg BUSI_TYPE_VIDEO");
        }
        if (paramBoolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AIOGalleryScene", 2, "onRevokeMsg cancelDownloadMedia");
          }
          this.V.b(paramAIORichMediaInfo.L, paramAIORichMediaInfo.M, 256);
        }
        paramAIORichMediaInfo = this.au;
        if ((paramAIORichMediaInfo != null) && (paramAIORichMediaInfo.p())) {
          this.au.j();
        }
      }
      else if (paramAIORichMediaInfo.d == 1)
      {
        paramAIORichMediaInfo = X();
        if (paramAIORichMediaInfo != null)
        {
          Drawable localDrawable = paramAIORichMediaInfo.getDrawable();
          if ((localDrawable instanceof URLDrawable))
          {
            int i1 = ((URLDrawable)localDrawable).getPlayState();
            int i2 = this.c.b();
            if (i1 == 2) {
              paramAIORichMediaInfo.b(i2);
            }
          }
        }
      }
    }
    else if (((paramAIORichMediaInfo.a instanceof AIOImageData)) && (paramBoolean))
    {
      this.V.b(paramAIORichMediaInfo.a.L, paramAIORichMediaInfo.a.M, 24);
    }
  }
  
  private void a(AIORichMediaInfo paramAIORichMediaInfo, String[] paramArrayOfString, String paramString, View paramView, MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("carverW notifyVideoUrl setShortVideoDrawableWithUrls ,AIOShortVideoData id=");
      localStringBuilder.append(paramAIORichMediaInfo.a.L);
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    LongVideoUrlCacheManager.a().a(paramAIORichMediaInfo.a.L, paramArrayOfString, System.currentTimeMillis(), paramMessageForShortVideo, paramInt, paramString);
    paramString = new VideoPlayMedioInfo();
    paramString.a = true;
    paramString.c = paramArrayOfString;
    paramString.f = paramMessageForShortVideo;
    paramString.g = paramInt;
    paramString.k = paramAIORichMediaInfo.a.L;
    paramString.l = paramAIORichMediaInfo.a.M;
    paramArrayOfString = new File(((AIOShortVideoData)paramAIORichMediaInfo.a).b);
    if (paramArrayOfString.exists()) {
      paramString.p = paramArrayOfString.length();
    } else {
      paramString.p = 0L;
    }
    if (this.as)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("setShortVideoDrawableWithUrls, dataOfBubble.id =  ");
        paramArrayOfString.append(this.b.L);
        paramArrayOfString.append(", msg.uniseq = ");
        paramArrayOfString.append(paramMessageForShortVideo.uniseq);
        paramArrayOfString.append(", mIsmute = ");
        paramArrayOfString.append(this.as);
        QLog.d("AIOGalleryScene", 2, paramArrayOfString.toString());
      }
      paramArrayOfString = this.b;
      if ((paramArrayOfString != null) && (paramArrayOfString.L == paramMessageForShortVideo.uniseq))
      {
        paramString.m = true;
        if (QLog.isColorLevel())
        {
          paramArrayOfString = new StringBuilder();
          paramArrayOfString.append("setShortVideoDrawableWithUrls, set playMedioInfo.isMute =  ");
          paramArrayOfString.append(this.as);
          QLog.d("AIOGalleryScene", 2, paramArrayOfString.toString());
        }
      }
    }
    this.au.a(paramView, paramString);
    paramArrayOfString = (AIOShortVideoData)paramAIORichMediaInfo.a;
    if (this.a.a(((AIOShortVideoData)paramAIORichMediaInfo.a).i))
    {
      this.au.h();
      this.au.a((AIOShortVideoData)paramAIORichMediaInfo.a, false, false);
    }
    else
    {
      this.au.a((AIOShortVideoData)paramAIORichMediaInfo.a, false, true);
    }
    if ((this.V != null) && (paramArrayOfString.c(0) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "setShortVideoDrawableWithUrls, get THUMB");
      }
      this.V.a(paramArrayOfString.L, paramArrayOfString.M, 0);
    }
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData)
  {
    if (this.V.asBinder().pingBinder())
    {
      paramAIOShortVideoData = this.V.c(paramAIOShortVideoData.L, paramAIOShortVideoData.M, this.ac);
      if (paramAIOShortVideoData != null)
      {
        paramAIOShortVideoData.putExtra("NeedReportForwardShortVideo", true);
        ForwardBaseOption.a(this.w, paramAIOShortVideoData);
      }
    }
    if (this.K) {
      MultiMsgUtil.a("0X8009ABC");
    }
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, int paramInt)
  {
    File localFile = paramAIOShortVideoData.c(1);
    AIORichMediaInfo localAIORichMediaInfo = this.c.c();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((localFile != null) && (localFile.exists()))
    {
      long l1 = localFile.length();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showActionSheetForShortVideo, file.getPath()=");
        localStringBuilder.append(localFile.getPath());
        localStringBuilder.append(", mTransferredSize = ");
        localStringBuilder.append(l1);
        localStringBuilder.append(", data.size = ");
        localStringBuilder.append(paramAIOShortVideoData.O);
        QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
      }
      if (l1 >= paramAIOShortVideoData.O)
      {
        i1 = 0;
        break label173;
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("AIOGalleryScene", 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
    }
    int i1 = 1;
    label173:
    if ((paramAIOShortVideoData.d != 1) || (i1 == 0)) {
      a(2131889838, 2130840466, 59, localArrayList1);
    }
    if ((VersionUtils.d()) && ((paramAIOShortVideoData.d != 1) || (i1 == 0))) {
      a(2131889848, 2130840475, 61, localArrayList1);
    }
    if (i1 == 0)
    {
      a(2131889837, 2130840465, 63, localArrayList1);
      a(2131889841, 2130840468, 60, localArrayList1);
      a(2131889850, 2130840476, 58, localArrayList1);
    }
    if ((this.ac != -1) && (!TextUtils.isEmpty(this.X)) && (this.at)) {
      a(2131889852, 2130840477, 62, localArrayList2);
    }
    if (i1 == 0) {
      a(2131889844, 2130840471, 64, localArrayList2, 5);
    }
    a(paramAIOShortVideoData, localFile, paramInt, localAIORichMediaInfo);
    paramAIOShortVideoData = (List[])new ArrayList[] { localArrayList1, localArrayList2 };
    this.aF.setActionSheetItems(paramAIOShortVideoData);
    this.aF.show();
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, AIORichMediaInfo paramAIORichMediaInfo)
  {
    if (paramAIOShortVideoData != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "dealSaveVideo");
      }
      this.V.a(paramAIOShortVideoData.L, paramAIOShortVideoData.M, 256);
    }
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, AIORichMediaInfo paramAIORichMediaInfo)
  {
    this.aF.setItemClickListener(new AIOGalleryScene.17(this, paramAIOShortVideoData, paramFile, paramInt, paramAIORichMediaInfo));
    this.aF.setCancelListener(new AIOGalleryScene.18(this));
  }
  
  private void a(ActionSheet paramActionSheet, AIOImageData paramAIOImageData, File paramFile1, File paramFile2)
  {
    if ((UinTypeUtil.e(this.ac) == 1032) && (paramFile1 != null)) {
      paramActionSheet.addButton(2131890810);
    }
    paramActionSheet.addCancelButton(2131887648);
    paramActionSheet.setOnButtonClickListener(new AIOGalleryScene.16(this, paramActionSheet, paramAIOImageData, paramFile2));
    paramActionSheet.show();
    paramActionSheet.registerWatchDisMissActionListener(this);
  }
  
  private void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = this.c.a(paramInt);
    if (localObject != null)
    {
      a((AIORichMediaInfo)localObject);
      if ((((AIORichMediaInfo)localObject).a.a(4)) || (((AIORichMediaInfo)localObject).a.a(20)))
      {
        if (((AIORichMediaInfo)localObject).a.O > 0L) {
          this.f.setText(String.format(Locale.CHINA, this.w.getString(2131892727), new Object[] { FileUtil.a(((AIORichMediaInfo)localObject).a.O) }));
        } else {
          this.f.setText(2131892724);
        }
        d(true);
        localObject = this.a;
        if (localObject != null)
        {
          ((AIOGalleryAdapter)localObject).a(paramAdapterView, paramView, paramInt, paramLong);
          paramAdapterView = C().findViewById(2131433943);
          if (paramAdapterView != null)
          {
            if (paramAdapterView.getAnimation() != null)
            {
              paramAdapterView.getAnimation().cancel();
              paramAdapterView.setAnimation(null);
            }
            paramAdapterView.setVisibility(4);
          }
        }
      }
    }
  }
  
  private void a(ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList1, File paramFile1, AIOImageData paramAIOImageData, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList2, File paramFile2)
  {
    if (this.U)
    {
      a(2131889835, 2130840461, 48, paramArrayList1);
      VasWebviewUtil.a("", "QLbq", "ClickMore", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
    if (UinTypeUtil.e(this.ac) != 1044) {
      a(2131889838, 2130840466, 49, paramArrayList1);
    }
    if ((PicShareToWX.b().e()) && (PicShareToWX.b().a(paramFile1))) {
      a(2131889849, 2130848588, 69, paramArrayList1);
    }
    if (!ZhuoXusManager.a().b()) {
      a(2131889848, 2130840475, 53, paramArrayList1);
    }
    if (!this.U) {
      a(2131889837, 2130840465, 57, paramArrayList1);
    }
    if (UinTypeUtil.e(this.ac) != 1044)
    {
      if (paramAIOImageData.n != null) {
        a(2131889842, 2130840469, 50, paramArrayList1, 3);
      }
      if ((this.Y) && (paramAIOImageData.n != null)) {
        a(2131889839, 2130840467, 51, paramArrayList1, 3);
      }
    }
    a(2131889850, 2130840476, 58, paramArrayList1);
    if (UinTypeUtil.e(this.ac) != 1044)
    {
      if ((this.ac != -1) && (!TextUtils.isEmpty(this.X)) && (this.at)) {
        a(2131889852, 2130840477, 54, paramArrayList2, 3);
      }
      if (this.S) {
        a(2131889843, 2130840470, 52, paramArrayList2, 2);
      }
      ThreadManager.getFileThreadHandler().post(new AIOGalleryScene.15(this, paramFile2, paramArrayList2));
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Aio preview ");
      localStringBuilder.append(paramBoolean);
      QLog.i("PicReporter", 2, localStringBuilder.toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "Pic.AioPreview.Empty", paramBoolean, 0L, 0L, null, "");
  }
  
  private int aa()
  {
    int i1 = this.aq;
    if (i1 == 1) {
      return 1;
    }
    if (i1 == 2) {
      return 5;
    }
    if (i1 == 3) {
      return 4;
    }
    if (this.K) {
      return 6;
    }
    return 0;
  }
  
  private void ab()
  {
    int i1 = this.q.getFirstVisiblePosition();
    int i2 = this.q.getChildCount();
    int i3 = this.c.b();
    if ((i3 >= i1) && (i3 <= i2 + i1 - 1))
    {
      Object localObject = this.q.getChildAt(i3 - i1);
      if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(localObject))
      {
        localObject = (AIOGalleryAdapter.GalleryImageStruct)localObject;
        if ((((AIOGalleryAdapter.GalleryImageStruct)localObject).getDrawable() instanceof URLDrawable))
        {
          localObject = ((URLDrawable)((AIOGalleryAdapter.GalleryImageStruct)localObject).getDrawable()).getCurrDrawable();
          if ((localObject != null) && ((localObject instanceof VideoDrawable))) {
            ((VideoDrawable)localObject).resetAndPlayAudioCircle();
          }
        }
      }
    }
  }
  
  private void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AIOImageListModel localAIOImageListModel = this.c;
    if (paramInt3 == 1) {
      localObject = paramString;
    } else {
      localObject = "I:E";
    }
    localAIOImageListModel.a(paramLong, paramInt1, paramInt2, (String)localObject, false);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AIOFilePicData.TYPE_ORIGINAL_IMAGE,result:");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append(",resultStr: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject).toString());
    if (paramInt3 == 1)
    {
      paramString = this.c.c();
      if ((paramString != null) && (paramString.a != null) && (AIOFilePicData.class.isInstance(paramString.a))) {
        ((AIOFilePicData)paramString.a).s = false;
      }
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mPlayGifImage = true;
      paramString.mUseExifOrientation = false;
      localObject = this.c.c().a.b(20);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.e("AIOGalleryScene", 1, "null url");
        return;
      }
      paramString = URLDrawable.getDrawable((String)localObject, paramString);
      paramInt1 = paramString.getStatus();
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 == 3) {
            this.J.onLoadCanceled(paramString);
          }
          paramString.setTag(Integer.valueOf(1));
          paramString.setURLDrawableListener(this.J);
          paramString.startDownload();
          this.J.c = paramString;
          return;
        }
        this.J.onLoadFialed(paramString, null);
        return;
      }
      this.J.onLoadSuccessed(paramString);
      return;
    }
    if (!"TroopFileError".equals(paramString)) {
      if (this.w.getString(2131889788).equals(paramString)) {
        QQToast.makeText(this.w, paramString, 0).show();
      } else {
        QQToast.makeText(this.w, this.w.getString(2131892726), 0).show();
      }
    }
    c(false);
    d(true);
    this.J = null;
  }
  
  private void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    Object localObject = this.c;
    if (paramInt3 != 1) {
      paramString = "I:E";
    }
    paramInt2 = ((AIOImageListModel)localObject).a(paramLong, paramInt1, paramInt2, paramString, false);
    int i1 = this.q.getFirstVisiblePosition();
    int i2 = this.q.getChildCount();
    if ((paramInt2 >= i1) && (paramInt2 <= i2 + i1 - 1))
    {
      paramString = this.q.getChildAt(paramInt2 - i1);
      this.a.b(paramInt2, paramString, paramBoolean);
    }
    if (QLog.isDevelopLevel())
    {
      paramString = new StringBuilder();
      paramString.append("notifyImageResult(): Gallery position is ");
      paramString.append(paramInt2);
      QLog.d("AIOGalleryScene", 4, paramString.toString());
    }
    paramInt2 = 0;
    while (paramInt2 < this.c.a())
    {
      paramString = this.c.a(paramInt2);
      if ((paramString != null) && (paramString.a.L == paramLong) && (paramString.a.M == paramInt1) && (paramInt3 == 1) && (AIOImageData.class.isInstance(paramString.a)))
      {
        paramString = (AIOImageData)paramString.a;
        if (!paramString.t)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString.a);
          ((StringBuilder)localObject).append("_hd");
          if (new File(((StringBuilder)localObject).toString()).exists())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString.a);
            ((StringBuilder)localObject).append("_hd");
            paramString.a = ((StringBuilder)localObject).toString();
          }
        }
      }
      paramInt2 += 1;
    }
  }
  
  private void b(long paramLong1, long paramLong2)
  {
    Object localObject1 = this.c.c();
    if (!AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject1).a)) {
      return;
    }
    Object localObject2 = (AIOFilePicData)((AIORichMediaInfo)localObject1).a;
    ((AIOFilePicData)localObject2).s = true;
    if (this.J == null)
    {
      this.J = new AIOGalleryScene.RawPhotoProgress(this);
      this.J.a = ((AIORichMediaInfo)localObject1).a.L;
      this.J.b = ((AIORichMediaInfo)localObject1).a.M;
    }
    if ((((AIOFilePicData)localObject2).L == paramLong1) && (this.l != null))
    {
      c(true);
      this.c.c().b = this.aj;
      localObject1 = this.j;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131898327));
      double d1 = paramLong2;
      double d2 = this.aj;
      Double.isNaN(d2);
      d2 /= 10000.0D;
      Double.isNaN(d1);
      ((StringBuilder)localObject2).append(FileUtil.a((d1 * d2)));
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append(FileUtil.a(paramLong2));
      ((StringBuilder)localObject2).append(")");
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      this.l.setProgress(this.aj);
    }
  }
  
  private void b(AIOImageData paramAIOImageData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.W);
    localStringBuilder.append("__qzone_pic_permission__");
    localStringBuilder.append(this.Z);
    if (LocalMultiProcConfig.getInt4Uin(localStringBuilder.toString(), -1, Long.valueOf(this.W).longValue()) == 0)
    {
      paramAIOImageData = new QQCustomDialog(this.w, 2131953338);
      paramAIOImageData.setContentView(2131624611);
      paramAIOImageData.setTitle(this.w.getString(2131895447));
      paramAIOImageData.setMessage(this.w.getString(2131895445));
      paramAIOImageData.setNegativeButton(this.w.getString(2131895446), new AIOGalleryScene.12(this));
      paramAIOImageData.setCanceledOnTouchOutside(false);
      paramAIOImageData.setCancelable(false);
      paramAIOImageData.show();
      QZoneClickReport.startReportImediately(this.W, "40", "1");
      return;
    }
    a("Pic_Forward_Grpalbum", 0);
    AIOGalleryUtils.a(this.w, this.W, this.Z, this.aa, paramAIOImageData.a, paramAIOImageData.n, paramAIOImageData.o, -1);
  }
  
  private void b(AIOImageData paramAIOImageData, AIORichMediaInfo paramAIORichMediaInfo)
  {
    if (paramAIOImageData != null)
    {
      this.J = new AIOGalleryScene.RawPhotoProgress(this);
      this.J.a = paramAIOImageData.L;
      this.J.b = paramAIOImageData.M;
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "dealSaveOriginalImage");
      }
      this.V.a(this.J.a, this.J.b, 24);
    }
  }
  
  private void b(AIOImageData paramAIOImageData, AIORichMediaInfo paramAIORichMediaInfo, File paramFile)
  {
    a("Pic_save", 0);
    if ((paramAIOImageData.c(4) == null) && (paramAIOImageData.a(4)) && (AppNetConnInfo.isNetSupport()))
    {
      if ((!AppNetConnInfo.isWifiConn()) && (paramAIOImageData.O > 29360128L))
      {
        a(1, paramAIOImageData, paramAIORichMediaInfo);
      }
      else
      {
        b(paramAIOImageData, paramAIORichMediaInfo);
        paramAIORichMediaInfo.d.f = true;
        E();
      }
    }
    else
    {
      paramAIOImageData = this.w;
      paramAIORichMediaInfo = new StringBuilder();
      paramAIORichMediaInfo.append(paramFile.getAbsolutePath());
      paramAIORichMediaInfo.append(NetConnInfoCenter.getServerTime());
      AIOGalleryUtils.a(paramAIOImageData, paramFile, Utils.Crc64String(paramAIORichMediaInfo.toString()));
    }
    a(paramFile.getAbsolutePath(), 55);
    if (this.U) {
      VasWebviewUtil.a("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "3", "", "", "", "", 0, 0, 0, 0);
    }
    if (this.K) {
      MultiMsgUtil.a("0X8009ABB");
    }
  }
  
  private void b(AIORichMediaData paramAIORichMediaData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.W);
    localStringBuilder.append("__qzone_pic_permission__");
    localStringBuilder.append(this.Z);
    if (LocalMultiProcConfig.getInt4Uin(localStringBuilder.toString(), -1, Long.valueOf(this.W).longValue()) == 0)
    {
      paramAIORichMediaData = new QQCustomDialog(this.w, 2131953338);
      paramAIORichMediaData.setContentView(2131624611);
      paramAIORichMediaData.setTitle(this.w.getString(2131895447));
      paramAIORichMediaData.setMessage(this.w.getString(2131895445));
      paramAIORichMediaData.setNegativeButton(this.w.getString(2131895446), new AIOGalleryScene.23(this));
      paramAIORichMediaData.setCanceledOnTouchOutside(false);
      paramAIORichMediaData.setCancelable(false);
      paramAIORichMediaData.show();
      QZoneClickReport.startReportImediately(this.W, "40", "1");
      return;
    }
    paramAIORichMediaData = (AIOImageData)paramAIORichMediaData;
    a("Pic_Forward_Grpalbum", 0);
    AIOGalleryUtils.a(this.w, this.W, this.Z, this.aa, paramAIORichMediaData.a, paramAIORichMediaData.n, paramAIORichMediaData.o, -1);
  }
  
  private void b(AIORichMediaData paramAIORichMediaData, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("preResult", paramString);
    if (AIOImageData.class.isInstance(paramAIORichMediaData))
    {
      paramAIORichMediaData = (AIOImageData)paramAIORichMediaData;
      a(this.ad, paramAIORichMediaData.Q, paramAIORichMediaData.C, paramAIORichMediaData.B, paramAIORichMediaData.q, paramAIORichMediaData.A, paramAIORichMediaData.n, 1, localIntent);
    }
    else if (AIOFilePicData.class.isInstance(paramAIORichMediaData))
    {
      paramString = (AIOFilePicData)paramAIORichMediaData;
      if (MessageRecordInfo.b(paramString.p)) {
        paramAIORichMediaData = this.W;
      } else {
        paramAIORichMediaData = this.X;
      }
      a(this.ad, paramString.b, true, paramAIORichMediaData, null, null, paramString.r, 1, localIntent);
    }
    ReportController.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
  }
  
  private void b(AIORichMediaInfo paramAIORichMediaInfo)
  {
    this.g.setVisibility(8);
    this.f.setVisibility(8);
    this.p.setVisibility(8);
    e(true);
    if (this.A) {
      this.H.setVisibility(8);
    } else {
      this.H.setVisibility(0);
    }
    Object localObject = (AIOShortVideoData)this.c.c().a;
    if (((AIOShortVideoData)localObject).d == 0)
    {
      this.p.setVisibility(8);
      int i1 = this.V.a(((AIOShortVideoData)localObject).L, ((AIOShortVideoData)localObject).M);
      this.au.a(8, "");
      if (paramAIORichMediaInfo.d.b)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOGalleryScene", 2, "updateUI selectedItem.longVideoSaving");
        }
        paramAIORichMediaInfo.d.b = false;
        this.l.setProgress(0);
        this.j.setText(HardCodeUtil.a(2131898326));
        this.H.setVisibility(8);
        this.i.setVisibility(0);
        this.h.setVisibility(8);
        return;
      }
      if (i1 != -1)
      {
        paramAIORichMediaInfo = this.l;
        double d1 = i1;
        Double.isNaN(d1);
        paramAIORichMediaInfo.setProgress((int)(d1 / 100.0D * 10000.0D));
        this.H.setVisibility(8);
        this.i.setVisibility(0);
        this.h.setVisibility(8);
        return;
      }
      if (paramAIORichMediaInfo.d.e)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOGalleryScene", 2, "updateUI selectedItem.longVideoBuffering");
        }
        this.i.setVisibility(8);
        this.p.setVisibility(0);
        this.h.setVisibility(0);
        return;
      }
      if (!paramAIORichMediaInfo.d.h)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateUI selectedItem.hasEnterPlaying longVideoDownloading=");
          ((StringBuilder)localObject).append(paramAIORichMediaInfo.d.i);
          ((StringBuilder)localObject).append(" selectedItem.state=");
          ((StringBuilder)localObject).append(paramAIORichMediaInfo.d);
          ((StringBuilder)localObject).append(" longVideoGetUrl=");
          ((StringBuilder)localObject).append(paramAIORichMediaInfo.d.k);
          QLog.i("AIOGalleryScene", 2, ((StringBuilder)localObject).toString());
        }
        this.i.setVisibility(8);
        this.h.setVisibility(8);
        if (paramAIORichMediaInfo.d.i) {
          this.p.setVisibility(0);
        }
        if (paramAIORichMediaInfo.d.k) {
          this.p.setVisibility(0);
        }
      }
      else
      {
        if (paramAIORichMediaInfo.d.l)
        {
          this.au.a(0, ((AIOShortVideoData)localObject).a());
          this.h.setVisibility(8);
          paramAIORichMediaInfo.d.l = false;
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("AIOGalleryScene", 2, "updateUI selectedItem.else");
        }
        this.i.setVisibility(8);
        this.h.setVisibility(0);
      }
    }
    else if (((AIOShortVideoData)localObject).d == 1)
    {
      if (this.ay.c)
      {
        this.i.setVisibility(0);
        this.h.setVisibility(8);
        return;
      }
      if (!paramAIORichMediaInfo.d.h)
      {
        this.i.setVisibility(8);
        this.h.setVisibility(8);
        if (paramAIORichMediaInfo.d.j) {
          this.p.setVisibility(0);
        }
      }
      else
      {
        this.i.setVisibility(8);
        this.h.setVisibility(0);
      }
    }
  }
  
  public static void b(AIORichMediaInfo paramAIORichMediaInfo, Activity paramActivity, int paramInt)
  {
    if (!AIOImageData.class.isInstance(paramAIORichMediaInfo.a)) {
      return;
    }
    AIOImageData localAIOImageData = (AIOImageData)paramAIORichMediaInfo.a;
    File localFile = localAIOImageData.c(4);
    int i1;
    if (localFile == null)
    {
      localFile = localAIOImageData.c(2);
      i1 = 0;
    }
    else
    {
      i1 = 1;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    localBundle.putBoolean("forward_urldrawable", true);
    localBundle.putString("forward_urldrawable_thumb_url", localAIOImageData.b(1));
    paramAIORichMediaInfo = paramAIORichMediaInfo.a;
    int i2;
    if (i1 != 0) {
      i2 = 4;
    } else {
      i2 = 2;
    }
    localBundle.putString("forward_urldrawable_big_url", paramAIORichMediaInfo.b(i2));
    if (paramActivity.getIntent().getBooleanExtra("image_share_by_server", false))
    {
      paramAIORichMediaInfo = Long.toString(paramActivity.getIntent().getLongExtra("appid", 0L));
      i2 = paramActivity.getIntent().getIntExtra("curType", 0);
      String str = paramActivity.getIntent().getStringExtra("title");
      localBundle.putBoolean("key_forward_image_share", true);
      localBundle.putString("key_forward_image_share_appid", paramAIORichMediaInfo);
      localBundle.putInt("key_forward_image_share_uin_type", i2);
      localBundle.putString("key_forward_image_share_title", str);
    }
    if (localFile != null) {}
    try
    {
      localBundle.putString("GALLERY.FORWORD_LOCAL_PATH", localFile.getAbsolutePath());
      localBundle.putInt("forward_source_uin_type", paramActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
      if (i1 != 0) {
        localBundle.putInt("PhotoConst.SEND_SIZE_SPEC", 2);
      }
      localBundle.putParcelable("FORWARD_MSG_FOR_PIC", localAIOImageData);
      if (localAIOImageData.r == 4) {
        localBundle.putBoolean("HOT_PIC_HAS_EXTRA", true);
      }
      paramAIORichMediaInfo = new Intent();
      paramAIORichMediaInfo.putExtras(localBundle);
      ForwardBaseOption.a(paramActivity, paramAIORichMediaInfo, paramInt);
      return;
    }
    catch (NullPointerException paramAIORichMediaInfo)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      paramActivity = new StringBuilder();
      paramActivity.append("showFriendPickerForForward ,NullPointerException: ");
      paramActivity.append(paramAIORichMediaInfo);
      QLog.d("AIOGalleryScene", 2, paramActivity.toString());
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "showFriendPickerForForward ,cache path is null");
    }
    return;
  }
  
  private void b(AIOShortVideoData paramAIOShortVideoData)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file://");
    localStringBuilder.append(paramAIOShortVideoData.b);
    localIntent.setDataAndType(Uri.parse(localStringBuilder.toString()), "video/*");
    localIntent.putExtra("big_brother_source_key", " biz_src_jc_video");
    this.w.startActivity(localIntent);
    int i1 = paramAIOShortVideoData.Q;
    if (i1 == 0)
    {
      ReportController.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
      return;
    }
    if (i1 == 3000)
    {
      ReportController.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
      return;
    }
    if (i1 == 1)
    {
      ReportController.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
  }
  
  private void b(AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, AIORichMediaInfo paramAIORichMediaInfo)
  {
    if (paramAIOShortVideoData.p == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "video file is expired");
      }
      QQToast.makeText(this.w, 1, HardCodeUtil.a(2131898313), 0).show();
      return;
    }
    if (paramAIOShortVideoData.d == 1)
    {
      a(paramInt, paramFile);
      return;
    }
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.length() == paramAIOShortVideoData.O))
    {
      paramAIOShortVideoData = new StringBuilder();
      paramAIORichMediaInfo = new StringBuilder();
      paramAIORichMediaInfo.append(paramFile.getParentFile().getName());
      paramAIORichMediaInfo.append(NetConnInfoCenter.getServerTime());
      paramAIOShortVideoData.append(paramAIORichMediaInfo.toString().toLowerCase(Locale.US));
      paramAIOShortVideoData.append(".mp4");
      paramAIOShortVideoData = paramAIOShortVideoData.toString();
      ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(paramFile.getAbsolutePath(), this.aE, paramAIOShortVideoData, false));
      return;
    }
    if (!AppNetConnInfo.isNetSupport())
    {
      this.aE.sendEmptyMessage(10001);
      return;
    }
    if ((!AppNetConnInfo.isWifiConn()) && (paramAIOShortVideoData.O > 29360128L))
    {
      a(3, paramAIOShortVideoData, paramAIORichMediaInfo);
      return;
    }
    a(paramAIOShortVideoData, paramAIORichMediaInfo);
    paramAIORichMediaInfo.d.b = true;
    E();
  }
  
  private ProgressPieDrawable c(Context paramContext)
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(paramContext);
    localProgressPieDrawable.a(AIOUtils.b(50.0F, paramContext.getResources()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.h(-1);
    localProgressPieDrawable.g(0);
    localProgressPieDrawable.e(-15550475);
    localProgressPieDrawable.j(3);
    localProgressPieDrawable.D = true;
    localProgressPieDrawable.A = 2;
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.a(new AIOGalleryScene.29(this));
    return localProgressPieDrawable;
  }
  
  private File c(AIORichMediaData paramAIORichMediaData)
  {
    Object localObject2;
    Object localObject1;
    if ((paramAIORichMediaData instanceof AIOImageData))
    {
      localObject2 = paramAIORichMediaData.c(4);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramAIORichMediaData.c(2);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        return paramAIORichMediaData.c(1);
      }
    }
    else if ((paramAIORichMediaData instanceof AIOFilePicData))
    {
      localObject2 = paramAIORichMediaData.c(20);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramAIORichMediaData.c(18);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        return paramAIORichMediaData.c(16);
      }
    }
    else
    {
      localObject2 = null;
    }
    return localObject2;
  }
  
  private void c(int paramInt)
  {
    if (!this.N)
    {
      if (this.c.h())
      {
        K();
        return;
      }
      int i1 = this.c.a();
      if (this.ag) {
        if ((i1 - paramInt <= 0) || (paramInt <= i1 - 25)) {}
      }
      for (;;)
      {
        paramInt = 1;
        break;
        do
        {
          paramInt = 0;
          break;
        } while (paramInt >= 25);
      }
      if ((i1 != 1) && (paramInt != 0) && (!this.d) && (this.aK != i1))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[onItemSelected] loadMedias: mLastLoadCount=");
          localStringBuilder.append(this.aK);
          QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
        }
        this.aK = this.c.a();
        this.V.a(0);
      }
    }
  }
  
  private void c(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    Object localObject = this.J;
    if ((localObject != null) && (((AIOGalleryScene.RawPhotoProgress)localObject).a == paramLong) && (this.J.b == paramInt1))
    {
      AIOImageListModel localAIOImageListModel = this.c;
      if (paramInt3 == 1) {
        localObject = paramString;
      } else {
        localObject = "I:E";
      }
      localAIOImageListModel.a(paramLong, paramInt1, paramInt2, (String)localObject, false);
      if (paramInt3 == 1)
      {
        paramString = URLDrawable.URLDrawableOptions.obtain();
        paramString.mPlayGifImage = true;
        paramString.mUseExifOrientation = false;
        try
        {
          paramString = URLDrawable.getDrawable(this.c.c().a.b(4), paramString);
        }
        catch (Throwable paramString)
        {
          paramString.printStackTrace();
          paramString = null;
        }
        if (paramString == null) {
          return;
        }
        paramInt2 = paramString.getStatus();
        if (paramInt2 != 1)
        {
          if (paramInt2 != 2)
          {
            if (paramInt2 == 3) {
              this.J.onLoadCanceled(paramString);
            }
            paramString.setTag(Integer.valueOf(1));
            paramString.setURLDrawableListener(this.J);
            paramString.startDownload();
            this.J.c = paramString;
          }
          else
          {
            this.J.onLoadFialed(paramString, null);
          }
        }
        else {
          this.J.onLoadSuccessed(paramString);
        }
      }
      else
      {
        if (!"TroopFileError".equals(paramString)) {
          QQToast.makeText(this.w, this.w.getString(2131892726), 0).show();
        }
        this.J = null;
      }
      paramString = this.c.c().a;
      if ((paramString.L == paramLong) && (paramString.M == paramInt1))
      {
        this.c.c().d.d = false;
      }
      else
      {
        paramString = a(paramLong, paramInt1);
        if (paramString != null)
        {
          paramString.b = 0;
          paramString.d.d = false;
        }
      }
      E();
    }
  }
  
  private void c(AIOImageData paramAIOImageData)
  {
    if (this.U)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonFromGroup_Manager", 2, "action sheet share weiyun.");
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("pic_md5", paramAIOImageData.q);
      QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_upload_wy", localBundle, null);
      VasWebviewUtil.a("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "5", "", "", "", "", 0, 0, 0, 0);
      return;
    }
    if ((paramAIOImageData.L > 0L) && (this.V.asBinder().pingBinder()))
    {
      this.V.e(paramAIOImageData.L);
      QQToast.makeText(this.w, this.w.getString(2131889761), 0).show();
    }
  }
  
  private void c(AIORichMediaInfo paramAIORichMediaInfo)
  {
    if (paramAIORichMediaInfo == null) {
      return;
    }
    if (AIOShortVideoData.class.isInstance(paramAIORichMediaInfo.a))
    {
      AIOShortVideoData localAIOShortVideoData = (AIOShortVideoData)paramAIORichMediaInfo.a;
      if (localAIOShortVideoData.d == 0)
      {
        paramAIORichMediaInfo.d.i = false;
        paramAIORichMediaInfo.d.e = false;
      }
      else
      {
        this.o.setText(ShortVideoUtils.stringForTime(localAIOShortVideoData.c * 1000));
        paramAIORichMediaInfo.d.j = false;
      }
      this.m.setProgress(0);
      this.n.setText(ShortVideoUtils.stringForTime(0L));
      paramAIORichMediaInfo.d.h = false;
      return;
    }
    if ((paramAIORichMediaInfo.a instanceof AIOFileVideoData))
    {
      this.m.setProgress(0);
      paramAIORichMediaInfo.d.h = false;
      return;
    }
    paramAIORichMediaInfo = this.aE;
    if (paramAIORichMediaInfo != null) {
      paramAIORichMediaInfo.removeCallbacks(this.aA);
    }
  }
  
  private void d(int paramInt)
  {
    AIORichMediaInfo localAIORichMediaInfo = this.c.a(paramInt);
    if ((localAIORichMediaInfo != null) && ((localAIORichMediaInfo.a instanceof AIOFilePicData)))
    {
      this.f.setText(String.format(Locale.CHINA, this.w.getString(2131892727), new Object[] { FileUtil.a(localAIORichMediaInfo.a.O) }));
      if (localAIORichMediaInfo.a.O > ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize())
      {
        d(true);
        this.q.enableDoubleTap(false);
        this.q.enableScaleGesture(false);
      }
      else
      {
        d(true);
      }
    }
    if ((localAIORichMediaInfo != null) && ((localAIORichMediaInfo.a instanceof AIOImageData)) && (((AIOImageData)localAIORichMediaInfo.a).Q == 1))
    {
      this.f.setText(String.format(Locale.CHINA, this.w.getString(2131892727), new Object[] { FileUtil.a(localAIORichMediaInfo.a.O) }));
      if (localAIORichMediaInfo.a.O > ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize())
      {
        d(true);
        this.q.enableDoubleTap(false);
        this.q.enableScaleGesture(false);
        return;
      }
      d(true);
    }
  }
  
  private void d(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    AIOImageListModel localAIOImageListModel = this.c;
    if (paramInt3 != 1) {
      paramString = "I:E";
    }
    paramInt1 = localAIOImageListModel.a(paramLong, paramInt1, paramInt2, paramString, false);
    paramInt2 = this.q.getFirstVisiblePosition();
    paramInt3 = this.q.getChildCount();
    if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3 + paramInt2 - 1))
    {
      paramString = this.q.getChildAt(paramInt1 - paramInt2);
      this.a.b(paramInt1, paramString, paramBoolean);
    }
    if (QLog.isDevelopLevel())
    {
      paramString = new StringBuilder();
      paramString.append("notifyImageResult(): Gallery position is ");
      paramString.append(paramInt1);
      QLog.d("AIOGalleryScene", 4, paramString.toString());
    }
  }
  
  private void d(AIORichMediaInfo paramAIORichMediaInfo)
  {
    a("Pic_Forward_Contacts", 0);
    a(paramAIORichMediaInfo, this.w, 0);
    if (this.U) {
      VasWebviewUtil.a("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "2", "", "", "", "", 0, 0, 0, 0);
    }
    if (this.K) {
      MultiMsgUtil.a("0X8009ABA");
    }
  }
  
  private int e(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if ((paramInt != 1004) && (paramInt != 1008) && (paramInt != 1009) && (paramInt != 1010) && (paramInt != 1011) && (paramInt != 1020) && (paramInt != 1021) && (paramInt != 1022) && (paramInt != 1023) && (paramInt != 1024) && (paramInt != 1025) && (paramInt != 1036) && (paramInt != 10002) && (paramInt != 10003) && (paramInt != 10004)) {
      return 4;
    }
    return 3;
  }
  
  private void e(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    AIOImageListModel localAIOImageListModel = this.c;
    if (paramInt3 != 1) {
      paramString = "I:E";
    }
    paramInt1 = localAIOImageListModel.a(paramLong, paramInt1, paramInt2, paramString, false);
    paramInt2 = this.q.getFirstVisiblePosition();
    int i1 = this.q.getChildCount();
    if ((paramInt1 >= paramInt2) && (paramInt1 <= i1 + paramInt2 - 1))
    {
      paramString = this.q.getChildAt(paramInt1 - paramInt2);
      this.a.b(paramInt1, paramString, paramBoolean);
      if (paramInt3 == 2)
      {
        c(false);
        d(true);
        this.J = null;
      }
    }
    if (QLog.isDevelopLevel())
    {
      paramString = new StringBuilder();
      paramString.append("notifyImageResult(): Gallery position is ");
      paramString.append(paramInt1);
      QLog.d("AIOGalleryScene", 4, paramString.toString());
    }
  }
  
  private void e(AIORichMediaInfo paramAIORichMediaInfo)
  {
    AIOImageData localAIOImageData = (AIOImageData)paramAIORichMediaInfo.a;
    Object localObject2 = localAIOImageData.c(4);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localAIOImageData.c(2);
    }
    if ((localObject1 == null) && (this.aB)) {
      return;
    }
    if (localObject1 != null) {
      this.ae = ((File)localObject1).getPath();
    }
    localObject2 = ActionSheet.createMenuSheet(this.w);
    if ((!a((ActionSheet)localObject2, localAIOImageData)) && (UinTypeUtil.e(this.ac) != 1032))
    {
      localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      if (localObject1 != null)
      {
        if (!this.K)
        {
          a((ArrayList)localObject2, (File)localObject1, localAIOImageData, localArrayList, (File)localObject1);
        }
        else
        {
          a(2131890804, 2130840466, 49, (ArrayList)localObject2);
          a(2131890810, 2130840475, 53, (ArrayList)localObject2);
        }
      }
      else if ((!this.K) && (UinTypeUtil.e(this.ac) != 1044) && (this.ac != -1) && (!TextUtils.isEmpty(this.X)) && (this.at)) {
        a(2131889852, 2130840477, 54, localArrayList, 3);
      }
      if ((localAIOImageData.D == 4) && (!localAIOImageData.E)) {
        a(2131890809, 2130848453, 66, (ArrayList)localObject2);
      }
      a(localAIOImageData, paramAIORichMediaInfo, (File)localObject1);
      paramAIORichMediaInfo = (List[])new ArrayList[] { localObject2, localArrayList };
      this.aF.setActionSheetItems(paramAIORichMediaInfo);
      this.aF.show();
      return;
    }
    a((ActionSheet)localObject2, localAIOImageData, (File)localObject1, (File)localObject1);
  }
  
  private boolean e(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      AIORichMediaInfo localAIORichMediaInfo = this.c.c();
      if ((localAIORichMediaInfo != null) && ((localAIORichMediaInfo.a instanceof AIOShortVideoData)))
      {
        AIOGalleryAdapter localAIOGalleryAdapter = this.a;
        if ((localAIOGalleryAdapter == null) || (localAIOGalleryAdapter.a((AIOShortVideoData)localAIORichMediaInfo.a) == null)) {
          break label118;
        }
        this.F.setVisibility(0);
      }
      else
      {
        if ((localAIORichMediaInfo == null) || (!(localAIORichMediaInfo.a instanceof AIOFileVideoData)) || (!com.tencent.biz.qqstory.utils.FileUtils.d(((AIOFileVideoData)localAIORichMediaInfo.a).c))) {
          break label118;
        }
        this.F.setVisibility(0);
      }
      return true;
    }
    else
    {
      this.F.setVisibility(4);
    }
    label118:
    return false;
  }
  
  private void f(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.w).inflate(2131627841, null);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
    if (paramBoolean) {
      ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131442309);
    } else {
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
    }
    this.t.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
    this.h = ((LinearLayout)localRelativeLayout.findViewById(2131439381));
    this.m = ((SeekBar)this.h.findViewById(2131445496));
    localObject = (ImageView)this.h.findViewById(2131439679);
    this.n = ((TextView)this.h.findViewById(2131440735));
    this.o = ((TextView)this.h.findViewById(2131447787));
    ((ImageView)localObject).setOnClickListener(this);
    this.m.setMax(10000);
    this.m.setOnSeekBarChangeListener(this);
    this.i = ((RelativeLayout)localRelativeLayout.findViewById(2131449155));
    this.l = ((SeekBar)this.i.findViewById(2131449157));
    this.l.setMax(10000);
    this.j = ((TextView)this.i.findViewById(2131449156));
    this.k = ((ImageView)this.i.findViewById(2131430807));
    this.k.setOnClickListener(this);
    this.p = ((RelativeLayout)localRelativeLayout.findViewById(2131430097));
    this.D = ((TextView)localRelativeLayout.findViewById(2131444171));
  }
  
  protected void E()
  {
    if ((!this.ay.a) && (!this.ay.d) && (!this.ay.e) && (!this.ay.f))
    {
      if ((this.c.c().a instanceof AIOShortVideoData)) {
        b(this.c.c());
      } else if ((this.c.c().a instanceof AIOImageData)) {
        a((AIOImageData)this.c.c().a, this.c.c());
      } else if ((this.c.c().a instanceof AIOFilePicData)) {
        a((AIOFilePicData)this.c.c().a);
      } else if ((this.c.c().a instanceof AIOFileVideoData)) {
        a((AIOFileVideoData)this.c.c().a);
      }
      if ((this.aq == 4) || (UinTypeUtil.e(this.ac) == 1032)) {
        this.H.setVisibility(8);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryScene", 2, "updateUI selectedItem all gone");
    }
    this.h.setVisibility(8);
    this.i.setVisibility(8);
    this.g.setVisibility(8);
    this.f.setVisibility(8);
    this.p.setVisibility(8);
    e(false);
  }
  
  public void F() {}
  
  @TargetApi(11)
  public void G()
  {
    if ((!this.aB) && (!this.d) && (!this.e)) {
      return;
    }
    this.q.setSelection(this.c.b());
  }
  
  public boolean H()
  {
    int i1 = UinTypeUtil.e(this.ac);
    boolean bool2 = false;
    if (i1 == 1032) {
      return false;
    }
    if (UinTypeUtil.e(this.ac) == 1044) {
      return false;
    }
    if (this.K) {
      return false;
    }
    Object localObject = this.c;
    boolean bool1 = true;
    if (localObject != null)
    {
      localObject = ((AIOImageListModel)localObject).c();
      if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject).a))
      {
        AIOImageData localAIOImageData = (AIOImageData)((AIORichMediaInfo)localObject).a;
        File localFile = localAIOImageData.c(4);
        localObject = localFile;
        if (localFile == null) {
          localObject = localAIOImageData.c(2);
        }
        if ((localObject == null) && (this.aB)) {
          return false;
        }
        bool1 = bool2;
        if (!this.aB)
        {
          bool1 = bool2;
          if (!this.K) {
            bool1 = true;
          }
        }
        return bool1;
      }
      if (AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject).a))
      {
        localObject = ((AIOShortVideoData)((AIORichMediaInfo)localObject).a).c(1);
        if ((localObject != null) && (((File)localObject).exists())) {
          return bool1;
        }
        return false;
      }
      if (AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject).a))
      {
        if (!this.K) {
          return true;
        }
      }
      else if (AIOFileVideoData.class.isInstance(((AIORichMediaInfo)localObject).a))
      {
        localObject = (AIOFileVideoData)((AIORichMediaInfo)localObject).a;
        if ((!this.K) && (!TextUtils.isEmpty(((AIOFileVideoData)localObject).c))) {
          return true;
        }
      }
    }
    bool1 = false;
    return bool1;
  }
  
  protected void I()
  {
    int i1;
    if (this.aq == 2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (this.af)
    {
      this.ah = true;
      this.w.onBackPressed();
      return;
    }
    Intent localIntent = new Intent(this.w, ChatHistoryActivity.class);
    localIntent.addFlags(536870912);
    localIntent.putExtra("tab_tab_type", 0);
    localIntent.putExtra("uin", this.X);
    localIntent.putExtra("SissionUin", this.X);
    localIntent.putExtra("uintype", this.ac);
    localIntent.putExtra("extra.IS_FROM_CHAT_AIO_GALLERY", true);
    AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)this.s.d();
    if (localAIORichMediaInfo != null) {
      localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", localAIORichMediaInfo.a);
    }
    localIntent.putExtra("leftViewText", this.w.getString(2131887812));
    this.w.getIntent().putExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", true);
    if (i1 == 0) {
      this.w.finish();
    }
    this.w.startActivity(localIntent);
    this.w.overridePendingTransition(2130772429, 2130772363);
  }
  
  public void J()
  {
    if (this.q != null)
    {
      if (this.c == null) {
        return;
      }
      int i1 = this.q.getFirstVisiblePosition();
      int i2 = this.q.getChildCount();
      int i3 = this.c.b();
      if ((i3 >= i1) && (i3 <= i2 + i1 - 1))
      {
        Object localObject = this.q.getChildAt(i3 - i1);
        if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(localObject))
        {
          this.a.a(i3, (AIOGalleryAdapter.GalleryImageStruct)localObject);
          return;
        }
        localObject = this.au;
        if (localObject != null) {
          ((VideoPlayControllerForAIO)localObject).m();
        }
      }
    }
  }
  
  public void K()
  {
    if (this.N) {
      return;
    }
    if (this.c.f() == 0)
    {
      a(false);
      QQToast.makeText(this.w, 2131890028, 0).show();
      this.w.finish();
    }
    else
    {
      a(true);
    }
    this.a.a(true);
    this.d = false;
    this.e = true;
    int i1 = this.c.b();
    if (i1 == this.q.getSelectedItemPosition()) {
      return;
    }
    this.q.setSelection(i1);
  }
  
  boolean L()
  {
    return false;
  }
  
  public void L_()
  {
    z();
    VideoPlayControllerForAIO localVideoPlayControllerForAIO = this.au;
    if (localVideoPlayControllerForAIO != null) {
      localVideoPlayControllerForAIO.k();
    }
  }
  
  boolean M()
  {
    return false;
  }
  
  void N()
  {
    this.aE.postDelayed(new AIOGalleryScene.28(this), 1000L);
  }
  
  public void O()
  {
    this.ak = true;
    Dialog localDialog = this.aJ;
    if (localDialog != null) {
      try
      {
        localDialog.dismiss();
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AIOGalleryScene", 2, localException, new Object[0]);
        }
      }
    }
  }
  
  void P()
  {
    try
    {
      Object localObject2 = this.c.c().a;
      if (((localObject2 instanceof AIOImageData)) || ((localObject2 instanceof AIOFilePicData)))
      {
        Object localObject1 = c((AIORichMediaData)localObject2);
        if (localObject1 == null) {
          return;
        }
        this.ae = ((File)localObject1).getAbsolutePath();
        int i1 = this.aq;
        int i3 = 19000;
        boolean bool;
        int i2;
        switch (i1)
        {
        default: 
          bool = false;
          i1 = 0;
          i3 = 0;
          i2 = 99;
          break;
        case 6: 
          bool = true;
          i1 = 0;
          i2 = 130;
          break;
        case 5: 
          bool = true;
          i1 = 1;
          i2 = 129;
          break;
        case 4: 
          ReportController.b(null, "dc00898", "", "", "0X800A187", "0X800A187", 0, 0, "", "", "", "");
          bool = true;
          i1 = 0;
          i3 = 19002;
          i2 = 125;
          break;
        case 3: 
          bool = true;
          i1 = 1;
          i2 = 128;
          break;
        case 2: 
          bool = true;
          i1 = 1;
          i2 = 127;
          break;
        case 1: 
          bool = true;
          i1 = 1;
          i2 = 126;
        }
        localObject1 = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(this.w, ((File)localObject1).getAbsolutePath(), true, true, true, true, true, 2, i2, 7);
        ((Intent)localObject1).putExtra("uintype", this.ac);
        ((Intent)localObject1).putExtra("open_chatfragment", true);
        ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1041);
        ((Intent)localObject1).putExtra("key_enable_edit_title_bar", true);
        if (bool) {
          ((Intent)localObject1).putExtra("key_help_forward_pic", bool);
        }
        if (i1 != 0) {
          ((Intent)localObject1).putExtra("key_allow_multiple_forward_from_limit", false);
        }
        if ((localObject2 instanceof AIOFilePicData))
        {
          if (this.V.asBinder().pingBinder())
          {
            localObject2 = this.V.c(((AIORichMediaData)localObject2).L, ((AIORichMediaData)localObject2).M, this.ac);
            if (localObject2 != null)
            {
              ((Intent)localObject2).setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
              localObject2 = (ForwardFileInfo)((Intent)localObject2).getParcelableExtra("fileinfo");
              if (localObject2 != null) {
                ((Intent)localObject1).putExtra("fileinfo", (Parcelable)localObject2);
              }
            }
          }
          ((Intent)localObject1).putExtra("not_forward", true);
        }
        if (i3 != 0) {
          this.w.startActivityForResult((Intent)localObject1, i3);
        } else {
          this.w.startActivity((Intent)localObject1);
        }
        this.w.overridePendingTransition(2130772090, 2130772092);
        ReportController.b(null, "dc00898", "", "", "0X8007ACE", "0X8007ACE", 0, 0, "", "", "", "");
      }
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  public void Q()
  {
    this.a.b();
    this.a.a();
  }
  
  public void R()
  {
    Object localObject = this.au;
    if ((localObject != null) && (((VideoPlayControllerForAIO)localObject).a != null) && (this.au.a.a) && (this.au.p()))
    {
      this.au.d(2);
      localObject = this.w.getString(2131916623);
      localObject = DialogUtil.a(this.w, 230, null, (String)localObject, 2131892140, 2131918207, new AIOGalleryScene.32(this), new AIOGalleryScene.33(this));
      VideoPlayControllerForAIO localVideoPlayControllerForAIO = this.au;
      if (localVideoPlayControllerForAIO != null) {
        localVideoPlayControllerForAIO.j();
      }
      a((Dialog)localObject);
    }
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.w).inflate(2131627648, null);
  }
  
  void a(int paramInt)
  {
    if (this.aF == null)
    {
      this.aF = new ShareActionSheetBuilder(this.w);
      this.aF.setActionSheetTitle(this.w.getString(2131889851));
    }
    this.aF.setOnDismissListener(new AIOGalleryScene.19(this));
    AIORichMediaInfo localAIORichMediaInfo = this.c.c();
    boolean bool = AIOImageData.class.isInstance(localAIORichMediaInfo.a);
    int i2 = 0;
    Object localObject;
    int i1;
    if (bool)
    {
      localObject = (AIOImageData)localAIORichMediaInfo.a;
      a((AIOImageData)localObject, paramInt, localAIORichMediaInfo);
      if ((((AIOImageData)localObject).Q == 1) && (((AIOImageData)localObject).C)) {
        i1 = 2;
      } else {
        i1 = 1;
      }
    }
    else if (AIOShortVideoData.class.isInstance(localAIORichMediaInfo.a))
    {
      localObject = (AIOShortVideoData)localAIORichMediaInfo.a;
      if (((AIOShortVideoData)localObject).d == 0) {
        i1 = 4;
      } else if (((AIOShortVideoData)localObject).d == 1) {
        i1 = 3;
      } else {
        i1 = 0;
      }
      a((AIOShortVideoData)localObject, paramInt);
    }
    else if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.a))
    {
      a((AIOFilePicData)localAIORichMediaInfo.a, paramInt);
      i1 = 2;
    }
    else if (AIOFileVideoData.class.isInstance(localAIORichMediaInfo.a))
    {
      a((AIOFileVideoData)localAIORichMediaInfo.a, paramInt);
      i1 = 5;
    }
    else
    {
      i1 = 0;
    }
    int i3 = e(localAIORichMediaInfo.a.Q);
    int i4 = aa();
    if (paramInt == 2) {
      i2 = 1;
    } else if (paramInt == 1) {
      i2 = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X8009EFB", "0X8009EFB", i1, 0, String.valueOf(i3), String.valueOf(i4), String.valueOf(i2), "");
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 0))
    {
      a(this.w, paramIntent.getExtras());
      if (this.ac == 9501) {
        this.w.finish();
      }
    }
    else if ((paramInt2 == -1) && (paramInt1 == 10001))
    {
      QQToast.makeText(this.w, 2131916617, 0).show();
    }
  }
  
  public void a(int paramInt1, View paramView, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("carverW notifyVideoUrl setShortVideoDrawableWithUrls ,position = ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a.a(paramInt1);
    if (localObject == null) {
      return;
    }
    if (AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject).a))
    {
      a((AIORichMediaInfo)localObject, paramArrayOfString, paramString2, paramView, paramMessageForShortVideo, paramInt2);
      return;
    }
    if (AIOFileVideoData.class.isInstance(((AIORichMediaInfo)localObject).a)) {
      a((AIORichMediaInfo)localObject, paramString1, paramArrayOfString, paramString2, paramView);
    }
  }
  
  public void a(int paramInt, Object paramObject, AIORichMediaInfo paramAIORichMediaInfo)
  {
    a(DialogUtil.a(this.w, 230, this.w.getString(2131915874), this.w.getString(2131915873), new AIOGalleryScene.13(this, paramInt, paramObject, paramAIORichMediaInfo), new AIOGalleryScene.14(this)));
  }
  
  public void a(long paramLong)
  {
    int i1;
    if ((this.C != null) && (this.C.e() == this)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "onRevokeMsg not currentScene!");
      }
      return;
    }
    AIORichMediaInfo localAIORichMediaInfo = this.c.c();
    if ((localAIORichMediaInfo != null) && (localAIORichMediaInfo.a != null))
    {
      boolean bool;
      if ((this.K) && (this.L == paramLong)) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onRevokeMsg seq:");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(", selectItem seq:");
        ((StringBuilder)localObject).append(localAIORichMediaInfo.a.L);
        ((StringBuilder)localObject).append(", isFromMultiMsg:");
        ((StringBuilder)localObject).append(this.K);
        ((StringBuilder)localObject).append(", OriSeq:");
        ((StringBuilder)localObject).append(this.L);
        QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.V;
      if ((localObject != null) && (!bool)) {
        ((IAIOImageProvider)localObject).c(paramLong);
      }
      this.w.runOnUiThread(new AIOGalleryScene.31(this, paramLong, localAIORichMediaInfo, bool));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("AIOGalleryScene", 2, "onRevokeMsg exp!");
    }
  }
  
  public void a(long paramLong, float paramFloat, String paramString)
  {
    this.w.runOnUiThread(new AIOGalleryScene.4(this, paramLong, paramFloat, paramString));
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    if (paramInt2 == 2)
    {
      a(paramLong1, paramInt1, paramBoolean);
      return;
    }
    if (paramInt2 == 24)
    {
      a(paramLong1, paramInt1);
      return;
    }
    if (paramInt2 == 4)
    {
      a(paramLong1, paramInt1, paramInt2, paramInt3, paramLong2);
      return;
    }
    Object localObject1;
    Object localObject2;
    if (paramInt2 == 1)
    {
      localObject1 = this.c.i();
      paramInt1 = 0;
      while (paramInt1 < ((List)localObject1).size())
      {
        localObject2 = (AIORichMediaInfo)((List)localObject1).get(paramInt1);
        if (((AIORichMediaInfo)localObject2).a.L == paramLong1)
        {
          ((AIORichMediaInfo)localObject2).b = paramInt3;
          this.a.b(paramInt1, paramInt3 / 100);
          return;
        }
        paramInt1 += 1;
      }
    }
    if (paramInt2 == 256)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("save video progress : ");
        ((StringBuilder)localObject1).append(paramInt3);
        QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = this.c.c().a;
      if ((((AIORichMediaData)localObject1).L == paramLong1) && (((AIORichMediaData)localObject1).M == paramInt1))
      {
        localObject1 = this.j;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131898325));
        ((StringBuilder)localObject2).append(paramInt3);
        ((StringBuilder)localObject2).append("%");
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
        localObject1 = this.l;
        double d1 = paramInt3;
        Double.isNaN(d1);
        ((SeekBar)localObject1).setProgress((int)(d1 / 100.0D * 10000.0D));
      }
    }
    else
    {
      if (paramInt2 == 18)
      {
        a(paramLong1, paramBoolean);
        return;
      }
      if (paramInt2 == 20) {
        b(paramLong1, paramLong2);
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    if (paramInt2 == 2)
    {
      b(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
      return;
    }
    if (paramInt2 == 24)
    {
      a(paramLong, paramInt1, paramInt2, paramInt3, paramString);
      return;
    }
    if (paramInt2 == 4)
    {
      c(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
      return;
    }
    Object localObject;
    if (paramInt2 == 256)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("save video result resultStr = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject).toString());
      }
      if (paramInt3 == 1) {
        QQToast.makeText(this.w, this.w.getString(2131915871), 0).show();
      } else {
        QQToast.makeText(this.w, this.w.getString(2131915867), 0).show();
      }
      this.ay.b = false;
      E();
      return;
    }
    if ((paramInt2 != 1) && (paramInt2 != 0))
    {
      if (paramInt2 == 18)
      {
        e(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
        return;
      }
      if (paramInt2 == 20)
      {
        localObject = this.J;
        if ((localObject != null) && (((AIOGalleryScene.RawPhotoProgress)localObject).a == paramLong))
        {
          b(paramLong, paramInt1, paramInt2, paramInt3, paramString);
          return;
        }
      }
      if (paramInt2 == 269484034) {
        a(paramLong, paramInt3, paramString);
      }
    }
    else
    {
      d(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    paramInt1 = this.c.a(paramLong, paramInt1, paramInt2, paramString1, false);
    paramInt2 = this.q.getFirstVisiblePosition();
    int i1 = this.q.getChildCount();
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" carverW notifyVideoUrl(): Gallery position is ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", first = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", count = ");
      localStringBuilder.append(i1);
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    if ((paramInt1 >= paramInt2) && (paramInt1 <= i1 + paramInt2 - 1)) {
      a(paramInt1, this.q.getChildAt(paramInt1 - paramInt2), paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
    }
  }
  
  @TargetApi(14)
  public void a(Activity paramActivity, String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.aJ == null)
    {
      this.aJ = new ReportDialog(paramActivity);
      Object localObject = this.aJ.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.aJ.requestWindowFeature(1);
      this.aJ.setContentView(2131628207);
      localObject = (ImageView)this.aJ.findViewById(2131440726);
      this.am = c(paramActivity);
      ((ImageView)localObject).setImageDrawable(this.am);
    }
    ((TextView)this.aJ.findViewById(2131438908)).setText(paramString);
    this.aJ.setCancelable(paramBoolean);
    this.aJ.setCanceledOnTouchOutside(paramBoolean);
    if (!paramBoolean) {
      this.aJ.setOnKeyListener(new AIOGalleryScene.26(this));
    }
    this.am.d(0);
    this.aE.postDelayed(new AIOGalleryScene.27(this), paramInt);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    this.a.a(paramConfiguration);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    LiuHaiUtils.enableNotch(this.w);
    super.a(paramViewGroup);
    AppNetConnInfo.registerConnectionChangeReceiver(this.w, this);
    this.t = ((RelativeLayout)C());
    Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(9, -1);
    paramViewGroup = this.w.getResources().getDisplayMetrics();
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ((int)TypedValue.applyDimension(1, 23.0F, paramViewGroup));
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)TypedValue.applyDimension(1, 14.0F, paramViewGroup));
    int i1 = (int)TypedValue.applyDimension(1, 5.0F, paramViewGroup);
    this.f = new TextView(this.w);
    this.f.setId(2131442314);
    this.f.setTextColor(this.w.getResources().getColorStateList(2131165594));
    this.f.setTextSize(1, 14.0F);
    this.f.setShadowLayer(2.0F, 0.0F, 0.0F, this.w.getResources().getColor(2131165741));
    this.f.setText(2131892724);
    this.f.setContentDescription(this.w.getString(2131892724));
    this.f.setPadding(i1, i1, i1, i1);
    this.f.setBackgroundDrawable(this.w.getResources().getDrawable(2130844733));
    this.t.addView(this.f, (ViewGroup.LayoutParams)localObject1);
    this.f.setVisibility(4);
    this.H = new ImageButton(this.w);
    this.H.setContentDescription(HardCodeUtil.a(2131898328));
    this.H.setId(2131442309);
    this.H.setImageResource(2130838023);
    this.H.setBackgroundDrawable(null);
    this.H.setPadding(0, 0, 0, 0);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ((int)TypedValue.applyDimension(1, 23.0F, paramViewGroup));
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)TypedValue.applyDimension(1, 25.0F, paramViewGroup));
    if ((H()) && (!(this.w.getIntent().getExtras().getParcelable("extra.EXTRA_CURRENT_IMAGE") instanceof AIODevLittleVideoData))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    boolean bool;
    if ((i1 != 0) && (this.aq != 3)) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      this.t.addView(this.H, (ViewGroup.LayoutParams)localObject1);
    }
    this.H.setOnClickListener(this);
    this.H.setVisibility(4);
    this.E = new ImageButton(this.w);
    this.E.setContentDescription(HardCodeUtil.a(2131898323));
    this.E.setId(2131442310);
    this.E.setImageResource(2130838021);
    this.E.setBackgroundDrawable(null);
    this.E.setPadding(0, 0, 0, 0);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)TypedValue.applyDimension(1, 10.0F, paramViewGroup));
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)TypedValue.applyDimension(1, 24.0F, paramViewGroup));
    localObject1 = this.w.getIntent().getExtras();
    if (!((AIORichMediaData)((Bundle)localObject1).getParcelable("extra.EXTRA_CURRENT_IMAGE") instanceof AIODevLittleVideoData)) {
      this.t.addView(this.E, (ViewGroup.LayoutParams)localObject2);
    }
    this.E.setOnClickListener(this);
    this.aq = ((Bundle)localObject1).getInt("extra.EXTRA_ENTRANCE");
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("editPhotoBtn mContext.getIntent().getBooleanExtra: ");
      ((StringBuilder)localObject2).append(this.w.getIntent().getBooleanExtra("extra.FROM_AIO", false));
      QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject2).toString());
    }
    this.g = new ImageButton(this.w);
    if (!this.w.getIntent().getBooleanExtra("extra.FROM_AIO", false))
    {
      i1 = this.aq;
      if ((i1 != 3) && (i1 != 2))
      {
        i1 = 0;
        break label779;
      }
    }
    i1 = 1;
    label779:
    if (((i1 != 0) || ((this.aq == 4) && (((Bundle)localObject1).getBoolean("key_allow_forward_photo_preview_edit", false)))) && (UinTypeUtil.e(this.ac) != 1032) && (UinTypeUtil.e(this.ac) != 1044))
    {
      this.g.setContentDescription(HardCodeUtil.a(2131898319));
      this.g.setImageResource(2130838016);
      this.g.setBackgroundDrawable(null);
      this.g.setEnabled(false);
      this.g.setId(2131442311);
      this.g.setPadding(0, 0, 0, 0);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
      ((RelativeLayout.LayoutParams)localObject1).alignWithParent = true;
      if (bool) {
        ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131442309);
      } else {
        ((RelativeLayout.LayoutParams)localObject1).addRule(11, -1);
      }
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ((int)TypedValue.applyDimension(1, 23.0F, paramViewGroup));
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)TypedValue.applyDimension(1, 20.0F, paramViewGroup));
      this.t.addView(this.g, (ViewGroup.LayoutParams)localObject1);
      this.g.setOnClickListener(this);
      this.g.setVisibility(4);
    }
    f(bool);
    Y();
    this.f.setOnClickListener(this);
    if ((OnProGalleryListener.class.isInstance(this.a)) && (ProGallery.class.isInstance(this.q))) {
      ((ProGallery)this.q).setOnNoBlankListener(this.a);
    }
    this.au.a(this);
    this.au.a(this);
    this.au.e(this.aq);
    ((ProGallery)this.q).setGestureListener(this);
    this.aw = (SplashADUtil.c(this.w) / 2);
    AIOGalleryMsgRevokeMgr.a().a(this);
  }
  
  protected void a(AIORichMediaInfo paramAIORichMediaInfo, Activity paramActivity, int paramInt)
  {
    b(paramAIORichMediaInfo, this.w, 0);
  }
  
  public void a(VideoPlayMedioInfo paramVideoPlayMedioInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[TVKInfo] onPlayStart, id : ");
      Object localObject;
      if (paramVideoPlayMedioInfo == null)
      {
        localObject = "null";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramVideoPlayMedioInfo.k);
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    if ((paramVideoPlayMedioInfo != null) && (paramVideoPlayMedioInfo.h) && (paramVideoPlayMedioInfo.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "Filevideo onPlayStart igon playProgress");
      }
      return;
    }
    this.aE.post(this.az);
    this.aE.removeCallbacks(this.aA);
    this.aE.postDelayed(this.aA, 100L);
    this.c.c().d.h = true;
    E();
  }
  
  public void a(VideoPlayMedioInfo paramVideoPlayMedioInfo, int paramInt)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[TVKInfo] onEndBuffering, id : ");
      if (paramVideoPlayMedioInfo == null)
      {
        localObject1 = "null";
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramVideoPlayMedioInfo.k);
        ((StringBuilder)localObject1).append("");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.c.c();
    if ((localObject1 != null) && (((AIORichMediaInfo)localObject1).a != null))
    {
      if (paramVideoPlayMedioInfo == null) {
        return;
      }
      localObject2 = a(paramVideoPlayMedioInfo.k, paramVideoPlayMedioInfo.l);
      if (localObject2 != null) {
        ((AIORichMediaInfo)localObject2).d.e = false;
      }
      if (((AIORichMediaInfo)localObject1).a.L == paramVideoPlayMedioInfo.k) {
        E();
      }
    }
  }
  
  public void a(VideoPlayMedioInfo paramVideoPlayMedioInfo, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[TVKInfo] onError , id : ");
      if (paramVideoPlayMedioInfo == null)
      {
        localObject = "null";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramVideoPlayMedioInfo.k);
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    if (paramVideoPlayMedioInfo == null) {
      return;
    }
    Object localObject = this.c.c();
    if (((AIORichMediaInfo)localObject).a.L != paramVideoPlayMedioInfo.k) {
      return;
    }
    if (paramVideoPlayMedioInfo.h)
    {
      if (!AIOFileVideoData.class.isInstance(((AIORichMediaInfo)localObject).a)) {
        return;
      }
      paramString = ((IVideoPlayUtils)QRoute.api(IVideoPlayUtils.class)).makeErrorText(paramInt1, paramInt2);
      localObject = (AIOFileVideoData)((AIORichMediaInfo)localObject).a;
      if (((AIOFileVideoData)localObject).m) {
        return;
      }
      ((AIOFileVideoData)localObject).a(paramString);
      paramString = new Bundle();
      float f1 = 0.0F;
      if (VideoPlayControllerForFile.class.isInstance(this.au)) {
        f1 = ((VideoPlayControllerForFile)this.au).a(paramVideoPlayMedioInfo.k);
      }
      paramString.putFloat("progress", f1);
      this.V.a(((AIOFileVideoData)localObject).L, 10, paramString);
      E();
      return;
    }
    paramVideoPlayMedioInfo = a(paramVideoPlayMedioInfo.k, paramVideoPlayMedioInfo.l);
    if (paramVideoPlayMedioInfo == null) {
      return;
    }
    paramVideoPlayMedioInfo.d.l = true;
    if (!AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject).a)) {
      return;
    }
    ((AIOShortVideoData)((AIORichMediaInfo)localObject).a).a(paramString);
    E();
  }
  
  public void a(VideoPlayMedioInfo paramVideoPlayMedioInfo, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("[TVKInfo] onDurationReady , id : ");
      if (paramVideoPlayMedioInfo == null)
      {
        paramVideoPlayMedioInfo = "null";
      }
      else
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(paramVideoPlayMedioInfo.k);
        localStringBuilder2.append("");
        paramVideoPlayMedioInfo = localStringBuilder2.toString();
      }
      localStringBuilder1.append(paramVideoPlayMedioInfo);
      QLog.d("AIOGalleryScene", 2, localStringBuilder1.toString());
    }
    this.o.setText(ShortVideoUtils.stringForTime(paramLong));
  }
  
  public void a(VideoPlayMedioInfo paramVideoPlayMedioInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[TVKInfo] onGetUrl, id : ");
      Object localObject;
      if (paramVideoPlayMedioInfo == null)
      {
        localObject = "null";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramVideoPlayMedioInfo.k);
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" isStart=");
      localStringBuilder.append(paramBoolean);
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    if (paramVideoPlayMedioInfo == null) {
      return;
    }
    paramVideoPlayMedioInfo = a(paramVideoPlayMedioInfo.k, paramVideoPlayMedioInfo.l);
    if (paramVideoPlayMedioInfo == null) {
      return;
    }
    paramVideoPlayMedioInfo.d.k = paramBoolean;
    if (!paramVideoPlayMedioInfo.d.h)
    {
      this.D.setText("");
      E();
    }
  }
  
  @UnCompletedCode
  void a(String paramString, int paramInt)
  {
    IAIOImageProvider localIAIOImageProvider = this.V;
    if (localIAIOImageProvider != null) {
      localIAIOImageProvider.a(paramString, paramInt);
    }
  }
  
  void a(String paramString1, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, Intent paramIntent)
  {
    Intent localIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    } else {
      localIntent = paramIntent;
    }
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString1);
    localIntent.putExtra("detectType", paramInt2);
    localIntent.putExtra("fromPicQRDecode", true);
    paramInt2 = 0;
    Object localObject = null;
    if ((paramInt1 != 1) && (paramInt1 != 3000)) {
      if (paramBoolean) {
        paramInt1 = 3;
      } else {
        paramInt1 = 1;
      }
    }
    label706:
    label717:
    for (;;)
    {
      String str;
      try
      {
        if (TextUtils.equals(paramString2, this.W)) {
          paramIntent = this.X;
        } else {
          paramIntent = this.W;
        }
        if (!TextUtils.isEmpty(paramString4))
        {
          int i1 = BaseDownloadProcessor.getPicDownloadPort();
          if (paramInt2 == 0) {
            break label706;
          }
          str = "gchat.qpic.cn";
          paramString1 = localObject;
          if (TextUtils.isEmpty(str)) {
            break label717;
          }
          if (i1 != 80)
          {
            paramString1 = new StringBuilder();
            paramString1.append(str);
            paramString1.append(":");
            paramString1.append(i1);
            paramString1.append(paramString4);
            paramString1 = paramString1.toString();
            break label717;
          }
          paramString1 = new StringBuilder();
          paramString1.append(str);
          paramString1.append(paramString4);
          paramString1 = paramString1.toString();
          break label717;
        }
        paramBoolean = TextUtils.isEmpty(paramString5);
        paramString1 = localObject;
        if (paramBoolean) {
          break label717;
        }
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            paramString1 = localObject;
            break label717;
          }
          paramString1 = "gchat.qpic.cn/gchatpic_new";
          if (!TextUtils.isEmpty(paramString2))
          {
            paramString1 = new StringBuilder();
            paramString1.append("gchat.qpic.cn/gchatpic_new");
            paramString1.append("/");
            paramString1.append(paramString2);
            paramString1 = paramString1.toString();
          }
          paramBoolean = paramString5.startsWith("/");
          if (paramBoolean)
          {
            paramString4 = new StringBuilder();
            paramString4.append(paramString1);
            paramString4.append("0-0-");
            paramString4.append(paramString5.replace(".jpg", ""));
            paramString4.append("/0");
            paramString1 = paramString4.toString();
          }
          else
          {
            paramString4 = new StringBuilder();
            paramString4.append(paramString1);
            paramString4.append("/0-0-");
            paramString4.append(paramString5.replace(".jpg", ""));
            paramString4.append("/0");
            paramString1 = paramString4.toString();
          }
        }
        else
        {
          paramString1 = "c2cpicdw.qpic.cn/offpic_new";
          if (!TextUtils.isEmpty(paramString2))
          {
            paramString1 = new StringBuilder();
            paramString1.append("c2cpicdw.qpic.cn/offpic_new");
            paramString1.append("/");
            paramString1.append(paramString2);
            paramString1 = paramString1.toString();
          }
          if (paramString5.startsWith("/"))
          {
            paramString4 = new StringBuilder();
            paramString4.append(paramString1);
            paramString4.append(paramString5);
            paramString4.append("/0");
            paramString1 = paramString4.toString();
          }
          else
          {
            paramString4 = new StringBuilder();
            paramString4.append(paramString1);
            paramString4.append("/");
            paramString4.append(paramString5);
            paramString4.append("/0");
            paramString1 = paramString4.toString();
          }
        }
      }
      catch (Throwable paramString2)
      {
        continue;
      }
      localIntent.putExtra("report_params", ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(paramString3, paramString1, paramString5, paramString2, paramIntent, paramInt1));
      continue;
      paramString1 = new StringBuilder();
      paramString1.append("onQRDecodeSucceed error:");
      paramString1.append(paramString2.getMessage());
      QLog.e("AIOGalleryScene", 1, paramString1.toString());
      RouteUtils.a(this.w, localIntent, "/qrscan/scanner");
      return;
      if (paramBoolean)
      {
        paramIntent = null;
        paramInt1 = 4;
      }
      else
      {
        paramIntent = null;
        paramInt1 = 2;
        paramInt2 = 1;
        continue;
        str = "c2cpicdw.qpic.cn";
        continue;
      }
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode()) {}
    try
    {
      if (AIODevLittleVideoData.class.isInstance(this.c.c().a)) {
        break label52;
      }
      a(3);
    }
    catch (Throwable paramKeyEvent)
    {
      label36:
      break label36;
    }
    if (QLog.isColorLevel()) {
      QLog.e("AIOGalleryScene", 2, "showActionSheet oom");
    }
    label52:
    return true;
    return super.a(paramInt, paramKeyEvent);
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("distanceX=");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append(" x1=");
      localStringBuilder.append(paramMotionEvent1.getRawX());
      localStringBuilder.append(" x2=");
      localStringBuilder.append(paramMotionEvent2.getRawX());
      localStringBuilder.append(" x2-x1=");
      localStringBuilder.append(paramMotionEvent2.getRawX() - paramMotionEvent1.getRawX());
      localStringBuilder.append(" alldis=");
      QLog.d("onScroll", 2, localStringBuilder.toString());
    }
    if (Math.abs(paramMotionEvent2.getRawX() - paramMotionEvent1.getRawX()) > this.aw) {
      this.a.e();
    }
    return false;
  }
  
  boolean a(AIORichMediaInfo paramAIORichMediaInfo)
  {
    return false;
  }
  
  boolean a(ActionSheet paramActionSheet, AIOImageData paramAIOImageData)
  {
    return false;
  }
  
  boolean a(String paramString, AIOImageData paramAIOImageData, File paramFile)
  {
    return false;
  }
  
  protected AbstractImageAdapter b(Context paramContext)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b()
  {
    Bundle localBundle = this.w.getIntent().getExtras();
    Object localObject = (AIORichMediaData)localBundle.getParcelable("extra.EXTRA_CURRENT_IMAGE");
    if ((localObject instanceof AIOShortVideoData))
    {
      int i1 = this.w.getIntent().getIntExtra("forward_source_uin_type", -1);
      if (i1 != -1) {
        ((AIOShortVideoData)localObject).Q = i1;
      }
    }
    this.b = ((AIORichMediaData)localObject);
    localObject = new AIORichMediaInfo((AIORichMediaData)localObject);
    this.c.a((AIORichMediaInfo)localObject);
    this.as = localBundle.getBoolean("muate_play");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initData , mIsMute = ");
      localStringBuilder.append(this.as);
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    ((AIORichMediaInfo)localObject).g = ((Rect)localBundle.getParcelable("KEY_THUMBNAL_BOUND"));
    this.P = localBundle.getInt("extra.AIO_CURRENT_PANEL_STATE", -3321);
    this.aB = localBundle.getBoolean("IS_APP_SHARE_PIC", false);
    this.R = localBundle.getInt("extra.MOBILE_QQ_PROCESS_ID", -2147483648);
    this.an = localBundle.getBoolean("extra.IS_HOT_CHAT", false);
    this.ao = localBundle.getBoolean("extra.IS_SAVING_FILE", false);
    this.ap = localBundle.getInt("extra.SAVE_FILE_PROGRESS", 0);
    this.Y = localBundle.getBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", false);
    this.Z = localBundle.getString("extra.GROUP_UIN");
    if (this.Y)
    {
      this.aa = localBundle.getString("extra.GROUP_CODE");
      if (((this.Z == null) || (this.aa == null) || (this.W == null)) && (QLog.isColorLevel()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mGroupUin=");
        localStringBuilder.append(this.Z);
        localStringBuilder.append(", mGroupCode=");
        localStringBuilder.append(this.aa);
        localStringBuilder.append(", mMyUin=");
        localStringBuilder.append(this.W);
        QLog.i("AIOGalleryScene", 2, localStringBuilder.toString());
      }
    }
    this.ab = localBundle.getInt("extra.EXTRA_FORWARD_TO_QZONE_SRC");
    this.N = localBundle.getBoolean("extra.IS_APOLLO");
    this.K = localBundle.getBoolean("extra.IS_FROM_MULTI_MSG");
    this.L = localBundle.getLong("key_multi_forward_seq", 0L);
    this.M = localBundle.getBoolean("extra.IS_RECEIPT_MSG");
    this.ac = localBundle.getInt("forward_source_uin_type", -1);
    this.X = localBundle.getString("uin");
    this.af = localBundle.getBoolean("extra.IS_FROM_CHAT_FILE_HISTORY", false);
    if (this.af)
    {
      this.c.a(true);
      this.ag = true;
    }
    else
    {
      ((AIORichMediaInfo)localObject).isImgCenterCropMode = false;
    }
    this.ai = (TextUtils.isEmpty(localBundle.getString("babyq_video_type")) ^ true);
    this.S = localBundle.getBoolean("extra.OCR", false);
    this.T = localBundle.getString("extra.OCR_TEXT");
    if (TextUtils.isEmpty(this.T)) {
      this.T = this.w.getString(2131890806);
    }
    this.U = localBundle.getBoolean("group.emo.big.preview", false);
    this.aq = localBundle.getInt("extra.EXTRA_ENTRANCE");
    this.at = localBundle.getBoolean("is_ReplyMsg_From_Same_Session", true);
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.am;
    if (localObject == null) {
      return;
    }
    ((ProgressPieDrawable)localObject).b();
    this.am.d(paramInt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[setProgress] current:");
      ((StringBuilder)localObject).append(this.am.c());
      ((StringBuilder)localObject).append(", progress:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.w("AIOGalleryScene", 2, ((StringBuilder)localObject).toString());
    }
    this.am.b(true);
    this.am.d(false);
    localObject = this.am;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramInt));
    localStringBuilder.append("%");
    ((ProgressPieDrawable)localObject).a(localStringBuilder.toString());
  }
  
  public void b(long paramLong)
  {
    this.c.c().d.h = true;
    int i1 = this.c.a(paramLong, 0, 0, "", false);
    Object localObject = this.a.a(i1);
    if (AIOFileVideoData.class.isInstance(((AIORichMediaInfo)localObject).a))
    {
      ((AIOFileVideoData)((AIORichMediaInfo)localObject).a).d();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("file[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("],download success, set downloadSuccess");
      QLog.i("FileVideoMediaPlayHelper.filevideoPeek", 1, ((StringBuilder)localObject).toString());
    }
    this.w.runOnUiThread(new AIOGalleryScene.5(this));
  }
  
  public void b(VideoPlayMedioInfo paramVideoPlayMedioInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("[TVKInfo] onPlayPause , id : ");
      if (paramVideoPlayMedioInfo == null)
      {
        paramVideoPlayMedioInfo = "null";
      }
      else
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(paramVideoPlayMedioInfo.k);
        localStringBuilder2.append("");
        paramVideoPlayMedioInfo = localStringBuilder2.toString();
      }
      localStringBuilder1.append(paramVideoPlayMedioInfo);
      QLog.d("AIOGalleryScene", 2, localStringBuilder1.toString());
    }
    this.aE.post(this.az);
  }
  
  public void b(VideoPlayMedioInfo paramVideoPlayMedioInfo, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[TVKInfo] onDownloading, id : ");
      Object localObject;
      if (paramVideoPlayMedioInfo == null)
      {
        localObject = "null";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramVideoPlayMedioInfo.k);
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    if (paramVideoPlayMedioInfo == null) {
      return;
    }
    paramVideoPlayMedioInfo = a(paramVideoPlayMedioInfo.k, paramVideoPlayMedioInfo.l);
    if (paramVideoPlayMedioInfo == null) {
      return;
    }
    paramVideoPlayMedioInfo.d.i = true;
    if (!paramVideoPlayMedioInfo.d.h)
    {
      this.D.setText("");
      E();
    }
  }
  
  public void c(VideoPlayMedioInfo paramVideoPlayMedioInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("[TVKInfo] onPlayFinish , id : ");
      if (paramVideoPlayMedioInfo == null)
      {
        paramVideoPlayMedioInfo = "null";
      }
      else
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(paramVideoPlayMedioInfo.k);
        localStringBuilder2.append("");
        paramVideoPlayMedioInfo = localStringBuilder2.toString();
      }
      localStringBuilder1.append(paramVideoPlayMedioInfo);
      QLog.d("AIOGalleryScene", 2, localStringBuilder1.toString());
    }
    this.aE.removeCallbacks(this.aA);
    this.aE.post(this.az);
    this.c.c();
    this.m.setProgress(100);
    E();
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showLoadPanel : ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.i;
    if (localObject == null) {
      return;
    }
    if (paramBoolean)
    {
      ((RelativeLayout)localObject).setVisibility(0);
      d(false);
      this.H.setVisibility(8);
      this.g.setVisibility(8);
      this.h.setVisibility(8);
      return;
    }
    ((RelativeLayout)localObject).setVisibility(8);
  }
  
  public void d()
  {
    VideoPlayControllerForAIO localVideoPlayControllerForAIO = this.au;
    if ((localVideoPlayControllerForAIO != null) && (localVideoPlayControllerForAIO.p())) {
      this.au.j();
    }
  }
  
  public void d(VideoPlayMedioInfo paramVideoPlayMedioInfo)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[TVKInfo] onBuffering, id : ");
      if (paramVideoPlayMedioInfo == null)
      {
        localObject1 = "null";
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramVideoPlayMedioInfo.k);
        ((StringBuilder)localObject1).append("");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.c.c();
    if ((localObject1 != null) && (((AIORichMediaInfo)localObject1).a != null))
    {
      if (paramVideoPlayMedioInfo == null) {
        return;
      }
      localObject2 = a(paramVideoPlayMedioInfo.k, paramVideoPlayMedioInfo.l);
      if (localObject2 != null) {
        ((AIORichMediaInfo)localObject2).d.e = true;
      }
      if ((((AIORichMediaInfo)localObject1).a.L == paramVideoPlayMedioInfo.k) && (((AIORichMediaInfo)localObject1).a.M == paramVideoPlayMedioInfo.l)) {
        E();
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.aG = paramBoolean;
    TextView localTextView = this.f;
    if (localTextView != null)
    {
      if (this.aG)
      {
        localTextView.setVisibility(0);
        return;
      }
      localTextView.setVisibility(4);
    }
  }
  
  public void f()
  {
    J();
    VideoPlayControllerForAIO localVideoPlayControllerForAIO = this.au;
    if (localVideoPlayControllerForAIO != null) {
      localVideoPlayControllerForAIO.f();
    }
  }
  
  public void g()
  {
    G();
    AIORichMediaInfo localAIORichMediaInfo = this.c.e();
    if (localAIORichMediaInfo != null) {
      localAIORichMediaInfo.h = true;
    }
    if (!L()) {
      this.E.setVisibility(0);
    }
    if (this.aq == 4) {
      this.E.setVisibility(8);
    }
    this.ay.d = false;
    E();
    Looper.myQueue().addIdleHandler(this.aC);
  }
  
  public void h()
  {
    this.ay.d = true;
    E();
    if (!M()) {
      this.E.setVisibility(4);
    }
    ImageButton localImageButton = this.H;
    if (localImageButton != null) {
      localImageButton.setVisibility(4);
    }
  }
  
  public void i()
  {
    if (!M()) {
      this.E.setVisibility(4);
    }
    ImageButton localImageButton = this.g;
    if (localImageButton != null) {
      localImageButton.setVisibility(4);
    }
    localImageButton = this.H;
    if (localImageButton != null) {
      localImageButton.setVisibility(4);
    }
    this.ay.f = true;
    E();
  }
  
  public void j()
  {
    if (this.ah)
    {
      this.ah = false;
      Intent localIntent = new Intent(this.w, ChatHistoryFileActivity.class);
      localIntent.addFlags(603979776);
      AIORichMediaInfo localAIORichMediaInfo = this.c.c();
      if (localAIORichMediaInfo != null) {
        localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", localAIORichMediaInfo.a);
      }
      localIntent.putExtra("tab_tab_type", 0);
      localIntent.putExtra("uin", this.X);
      localIntent.putExtra("uintype", this.ac);
      localIntent.putExtra("extra.IS_FROM_CHAT_AIO_GALLERY", true);
      localIntent.putExtra("leftViewText", this.w.getString(2131887812));
      this.w.startActivity(localIntent);
      this.w.overridePendingTransition(0, 0);
    }
  }
  
  public void k()
  {
    Object localObject = this.c.c();
    if ((localObject != null) && (AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject).a)) && (((AIOShortVideoData)((AIORichMediaInfo)localObject).a).d == 0))
    {
      localObject = this.au;
      if (localObject != null) {
        ((VideoPlayControllerForAIO)localObject).l();
      }
    }
    AppNetConnInfo.unregisterNetInfoHandler(this);
    super.k();
    if (this.aD > 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.aD);
      ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_spin", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
    }
    AIOGalleryMsgRevokeMgr.a().b(this);
    localObject = this.a;
    if (localObject != null) {
      ((AIOGalleryAdapter)localObject).c();
    }
    localObject = this.aF;
    if (localObject != null)
    {
      ((ShareActionSheetBuilder)localObject).setItemClickListener(null);
      this.aF.dismiss();
    }
    localObject = this.aE;
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacks(this.aA);
    }
    LongVideoUrlCacheManager.a().b();
    localObject = this.aH;
    if (localObject != null) {
      ((INonMainProcAvatarLoader)localObject).c();
    }
  }
  
  public boolean o()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    Object localObject;
    switch (i1)
    {
    default: 
      int i2;
      switch (i1)
      {
      default: 
        break;
      case 2131442312: 
        Z();
        break;
      case 2131442311: 
        P();
        i1 = S();
        i2 = T();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(a("0X8009EFC"));
        ReportController.b(null, "dc00898", "", "", "0X8009EFC", "0X8009EFC", i1, i2, ((StringBuilder)localObject).toString(), "", "", "");
        break;
      case 2131442310: 
        ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "1", "", "", "");
        a(2);
        break;
      case 2131442309: 
        I();
        i1 = S();
        i2 = T();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(a("0X8009EFD"));
        ReportController.b(null, "dc00898", "", "", "0X8009EFD", "0X8009EFD", i1, i2, ((StringBuilder)localObject).toString(), "", "", "");
        break;
      case 2131442308: 
        W();
      }
      break;
    case 2131442314: 
      U();
      break;
    case 2131439679: 
      a(paramView);
      break;
    case 2131437976: 
      localObject = this.c.c();
      if ((localObject != null) && (((AIORichMediaInfo)localObject).a != null) && ((((AIORichMediaInfo)localObject).a instanceof AIOFilePicData)))
      {
        if (this.J != null)
        {
          x();
          x();
        }
      }
      else if ((localObject != null) && (((AIORichMediaInfo)localObject).a != null) && ((((AIORichMediaInfo)localObject).a instanceof AIOImageData)) && (((AIOImageData)((AIORichMediaInfo)localObject).a).r == 3) && (this.J != null))
      {
        x();
        x();
      }
      break;
    case 2131430807: 
      V();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismissOperations()
  {
    z();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onItemClick");
    }
    paramAdapterView = this.a.a(paramInt);
    if ((paramAdapterView != null) && (paramAdapterView.a != null))
    {
      if ((AIOImageData.class.isInstance(paramAdapterView.a)) || (AIOFilePicData.class.isInstance(paramAdapterView.a))) {
        x();
      }
      MotionEvent localMotionEvent = ((DragGallery)this.q).getSingleTapConfirmedEvent();
      Object localObject;
      if (AIOShortVideoData.class.isInstance(paramAdapterView.a)) {
        if (((AIOShortVideoData)paramAdapterView.a).d != 0)
        {
          if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView))
          {
            localObject = (AIOGalleryAdapter.GalleryImageStruct)paramView;
            if (((AIOGalleryAdapter.GalleryImageStruct)localObject).a(localMotionEvent)) {
              ((AIOGalleryAdapter.GalleryImageStruct)localObject).b(paramInt);
            } else {
              x();
            }
          }
          else
          {
            x();
          }
        }
        else
        {
          localObject = this.au;
          if ((localObject != null) && (localMotionEvent != null) && (((VideoPlayControllerForAIO)localObject).a(localMotionEvent)))
          {
            if (!this.ay.b) {
              this.au.h();
            }
          }
          else {
            x();
          }
        }
      }
      if (AIOFileVideoData.class.isInstance(paramAdapterView.a))
      {
        localObject = this.au;
        if (localObject != null) {
          if ((localMotionEvent != null) && (localObject != null) && (((VideoPlayControllerForAIO)localObject).a(localMotionEvent)))
          {
            paramAdapterView = (AIOFileVideoData)paramAdapterView.a;
            paramAdapterView.a(paramView, this.au);
            paramAdapterView.p = false;
            if (!TextUtils.isEmpty(paramAdapterView.c)) {
              E();
            }
          }
          else
          {
            x();
          }
        }
      }
      return;
    }
    paramAdapterView = new StringBuilder();
    paramAdapterView.append("there data is null, position:");
    paramAdapterView.append(paramInt);
    QLog.e("AIOGalleryScene", 1, paramAdapterView.toString());
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "0", "", "", "");
    if (this.aq == 4) {
      return true;
    }
    try
    {
      if (AIODevLittleVideoData.class.isInstance(this.c.c().a)) {
        break label85;
      }
      a(1);
      return true;
    }
    catch (Throwable paramAdapterView)
    {
      label69:
      label85:
      break label69;
    }
    if (QLog.isColorLevel()) {
      QLog.e("AIOGalleryScene", 2, "showActionSheet oom");
    }
    return true;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    c(paramInt);
    d(false);
    this.q.enableDoubleTap(true);
    this.q.enableScaleGesture(true);
    if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView))
    {
      localObject = (AIOGalleryAdapter.GalleryImageStruct)paramView;
      Drawable localDrawable = ((AIOGalleryAdapter.GalleryImageStruct)localObject).getDrawable();
      if ((!((AIOGalleryAdapter.GalleryImageStruct)localObject).a()) && (localDrawable != null) && ((localDrawable instanceof URLDrawable))) {
        a(paramAdapterView, paramView, paramInt, paramLong);
      } else if ((!((AIOGalleryAdapter.GalleryImageStruct)localObject).a()) && (localDrawable != null) && ((localDrawable instanceof SkinnableBitmapDrawable))) {
        d(paramInt);
      }
    }
    c(false);
    Object localObject = this.a;
    if (localObject != null)
    {
      ((AIOGalleryAdapter)localObject).a(paramAdapterView, paramView, paramInt, paramLong);
      paramAdapterView = C().findViewById(2131433943);
      if (paramAdapterView != null)
      {
        if (paramAdapterView.getAnimation() != null)
        {
          paramAdapterView.getAnimation().cancel();
          paramAdapterView.setAnimation(null);
        }
        paramAdapterView.setVisibility(4);
      }
    }
    paramAdapterView = this.c.a(paramInt);
    if (paramAdapterView != null) {
      this.I.setOriginRect(paramAdapterView.getThumbRect());
    }
    if (paramAdapterView != null) {
      if (((paramAdapterView.a instanceof AIOFilePicData)) && (((AIOFilePicData)paramAdapterView.a).s))
      {
        paramView = this.a;
        if (paramView != null)
        {
          paramView.a(paramInt, -1);
          ((AIOFilePicData)paramAdapterView.a).s = false;
        }
      }
      else if ((paramAdapterView.a instanceof AIOFileVideoData))
      {
        c(false);
        this.aE.post(this.az);
      }
    }
    c(paramAdapterView);
    E();
  }
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onNetMobile2None");
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNetMobile2Wifi s=");
      localStringBuilder.append(paramString);
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    paramString = this.au;
    if (paramString != null) {
      paramString.d(1);
    }
    LongVideoUrlCacheManager.a().b();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNetNone2Mobile s=");
      localStringBuilder.append(paramString);
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    R();
    LongVideoUrlCacheManager.a().b();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNetNone2Wifi s=");
      localStringBuilder.append(paramString);
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    LongVideoUrlCacheManager.a().b();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNetWifi2Mobile s=");
      localStringBuilder.append(paramString);
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    R();
    LongVideoUrlCacheManager.a().b();
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onNetWifi2None");
    }
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramSeekBar = this.c.c().a;
      if ((paramSeekBar instanceof AIOShortVideoData))
      {
        paramSeekBar = (AIOShortVideoData)paramSeekBar;
        if (paramSeekBar.d == 0)
        {
          paramSeekBar = this.au;
          if (paramSeekBar != null)
          {
            paramInt = (int)(paramInt / 10000.0F * (float)paramSeekBar.r());
            this.au.c(paramInt);
          }
        }
        else if (paramSeekBar.d == 1)
        {
          Object localObject = X();
          if (localObject != null)
          {
            localObject = ((AIOGalleryAdapter.GalleryImageStruct)localObject).getDrawable();
            if ((localObject instanceof URLDrawable))
            {
              localObject = (URLDrawable)localObject;
              double d1 = paramInt;
              Double.isNaN(d1);
              d1 /= 10000.0D;
              double d2 = paramSeekBar.c;
              Double.isNaN(d2);
              ((URLDrawable)localObject).seek((int)(d1 * d2 * 1000.0D));
            }
          }
        }
      }
      else if (AIOFileVideoData.class.isInstance(paramSeekBar))
      {
        paramSeekBar = this.au;
        if (paramSeekBar != null)
        {
          paramInt = (int)(paramInt / 10000.0F * (float)paramSeekBar.r());
          this.au.c(paramInt);
        }
      }
    }
  }
  
  public void onRotateFinished(View paramView, int paramInt1, int paramInt2) {}
  
  public void onScrollEnd(int paramInt)
  {
    super.onScrollEnd(paramInt);
    this.ay.a = false;
    E();
  }
  
  public void onScrollStart(int paramInt)
  {
    super.onScrollStart(paramInt);
    this.ay.a = true;
    E();
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    VideoPlayControllerForAIO localVideoPlayControllerForAIO = this.au;
    if (localVideoPlayControllerForAIO != null) {
      localVideoPlayControllerForAIO.u();
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  protected boolean p()
  {
    return this.P != 1;
  }
  
  protected boolean q()
  {
    int i1 = this.P;
    if (((i1 == -3321) || (i1 == 1)) && (!this.af)) {
      return false;
    }
    i1 = this.R;
    int i2 = -2147483648;
    if (i1 == -2147483648) {
      return false;
    }
    Iterator localIterator = ((ActivityManager)this.w.getSystemService("activity")).getRunningAppProcesses().iterator();
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      i1 = i2;
      if (!localIterator.hasNext()) {
        break;
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
    } while (!localRunningAppProcessInfo.processName.endsWith("mobileqq"));
    i1 = localRunningAppProcessInfo.pid;
    return i1 == this.R;
  }
  
  public void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onStop");
    }
    super.u();
    Q();
    Object localObject1 = this.c.c();
    if (localObject1 != null)
    {
      if (((AIORichMediaInfo)localObject1).a == null) {
        return;
      }
      Object localObject2 = (ImageView)this.h.findViewById(2131439679);
      if (((((AIORichMediaInfo)localObject1).a instanceof AIOShortVideoData)) && (((AIOShortVideoData)((AIORichMediaInfo)localObject1).a).d == 1))
      {
        localObject1 = X();
        if (localObject1 != null)
        {
          localObject2 = ((AIOGalleryAdapter.GalleryImageStruct)localObject1).getDrawable();
          if ((localObject2 instanceof URLDrawable)) {
            ((URLDrawable)localObject2).pauseVideo();
          }
          ((AIOGalleryAdapter.GalleryImageStruct)localObject1).b.setVisibility(0);
        }
      }
      else if (((((AIORichMediaInfo)localObject1).a instanceof AIOShortVideoData)) && (((AIOShortVideoData)((AIORichMediaInfo)localObject1).a).d == 0))
      {
        localObject1 = this.au;
        if (localObject1 != null) {
          ((VideoPlayControllerForAIO)localObject1).j();
        }
      }
      else if (AIOFileVideoData.class.isInstance(((AIORichMediaInfo)localObject1).a))
      {
        localObject1 = this.au;
        if ((localObject1 != null) && (((VideoPlayControllerForAIO)localObject1).p())) {
          this.au.j();
        }
      }
    }
  }
  
  public void v()
  {
    super.v();
    AIORichMediaInfo localAIORichMediaInfo = this.c.e();
    if (localAIORichMediaInfo != null) {
      localAIORichMediaInfo.h = false;
    }
  }
  
  public void w()
  {
    super.w();
    AIORichMediaInfo localAIORichMediaInfo = this.c.e();
    if (localAIORichMediaInfo != null) {
      localAIORichMediaInfo.h = false;
    }
    this.aq = 3;
    this.ax = true;
    if ((this.w instanceof AIOGalleryActivity))
    {
      ((AIOGalleryActivity)this.w).k = false;
      ((AIOGalleryActivity)this.w).m = -1L;
    }
  }
  
  public boolean x()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      if (((AIOImageListModel)localObject).c() == null) {
        return false;
      }
      localObject = this.c.c().a;
      if ((localObject != null) && (AIOImageData.class.isInstance(localObject)) && (this.c.c().d != null) && (this.c.c().d.d))
      {
        localObject = this.J;
        if (localObject != null) {
          this.V.b(((AIOGalleryScene.RawPhotoProgress)localObject).a, this.J.b, 4);
        }
        this.c.c().d.d = false;
        E();
        return true;
      }
      d(false);
      boolean bool = super.x();
      J();
      localObject = C().findViewById(2131433943);
      if (localObject != null) {
        ((View)localObject).setVisibility(4);
      }
      if (this.af)
      {
        localObject = this.c.c();
        if (localObject != null)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", ((AIORichMediaInfo)localObject).a);
          this.w.setResult(-1, localIntent);
        }
      }
      if (this.ai) {
        this.w.setResult(-1, this.w.getIntent());
      }
      return bool;
    }
    return false;
  }
  
  protected void z()
  {
    int i1;
    if (Build.VERSION.SDK_INT >= 19) {
      i1 = 4356;
    } else {
      i1 = 4;
    }
    this.t.setSystemUiVisibility(i1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene
 * JD-Core Version:    0.7.0.1
 */