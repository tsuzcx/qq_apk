package com.tencent.mobileqq.activity.richmedia;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.os.StatFs;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.aelight.camera.struct.editor.FlowComponentInterface;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.maxvideo.common.GlobalInit;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.common.GloableValue;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.utils.FormatDetector;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.utils.ThumbnailUtils;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar.OnFramesClipChangeListener;
import com.tencent.mobileqq.activity.richmedia.view.ExtendEditText;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.util.VideoAnimation;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QzoneTextBuilder;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.font.IFontManager;
import com.tencent.video.decode.ShortVideoSoLoad;
import com.tencent.widget.ActionSheet;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.PhotoUtils;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.SystemUtil;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import cooperation.qzone.widget.QzoneGuideBubbleHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class EditLocalVideoActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, VideoFrameSelectBar.OnFramesClipChangeListener
{
  public static String a;
  private static final boolean ax;
  private static final String h;
  private static final String i;
  private static String j;
  private View A;
  private boolean B = false;
  private PressDarkImageButton C;
  private boolean D = false;
  private boolean E = false;
  private boolean F = true;
  private int G = 0;
  private int H;
  private int I;
  private int J;
  private Bitmap K;
  private int L = 0;
  private int M = 0;
  private String N;
  private String O;
  private String P;
  private long Q;
  private long R;
  private int S;
  private int T;
  private ViewStub U;
  private FixedSizeVideoView V;
  private RelativeLayout W;
  private ViewGroup X;
  private ImageView Y;
  private VideoFrameSelectBar Z;
  private String aA;
  private String aB;
  private FlowComponentInterface aC = null;
  private int aD = 0;
  private boolean aE = false;
  private boolean aF;
  private QzoneVerticalVideoTopicInfo aG;
  private View aH;
  private long aI;
  private EditLocalVideoActivity.TrimHandler aJ = new EditLocalVideoActivity.TrimHandler(this);
  private StringBuilder aK = new StringBuilder();
  private Formatter aL = new Formatter(this.aK, Locale.getDefault());
  private RelativeLayout aa;
  private TextView ab;
  private TextView ac;
  private TextView ad;
  private ImageView ae;
  private ProgressBar af;
  private boolean ag;
  private boolean ah = false;
  private boolean ai = false;
  private String aj;
  private long ak;
  private int al;
  private int am;
  private int an = 2;
  private String ao = "";
  private String ap;
  private boolean aq;
  private boolean ar = true;
  private int as = -1;
  private int at = -1;
  private String au;
  private int av = -1;
  private String aw;
  private ActionSheet ay;
  private QQCustomDialog az;
  boolean b;
  public int c = 1;
  public ArrayList<String> d = null;
  public String e;
  public String f;
  public RMVideoStateMgr g = RMVideoStateMgr.a();
  private ViewGroup k;
  private RelativeLayout l;
  private TextView m;
  private TextView n;
  private RelativeLayout o;
  private Button p;
  private ExtendEditText q;
  private View r;
  private RelativeLayout s;
  private Button t;
  private TextView u;
  private boolean v = false;
  private boolean w = true;
  private PressDarkImageButton x;
  private boolean y;
  private EditLocalVideoMusicMixer z;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/tencent");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("video_edit_music_download");
    localStringBuilder.append(File.separator);
    h = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("/tencent");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("video_edit_music");
    localStringBuilder.append(File.separator);
    i = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(PathUtils.a);
    localStringBuilder.append(h);
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(PathUtils.a);
    localStringBuilder.append(i);
    j = localStringBuilder.toString();
    boolean bool;
    if (Build.VERSION.SDK_INT >= 10) {
      bool = true;
    } else {
      bool = false;
    }
    ax = bool;
  }
  
  private void A()
  {
    this.aJ.removeMessages(9999);
    this.Y.setImageBitmap(null);
    this.Y.setVisibility(8);
    this.aj = this.O;
    this.ak = this.Q;
    long l1 = this.R;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initData, videoPath=");
      localStringBuilder.append(this.aj);
      localStringBuilder.append(", videoSize=");
      localStringBuilder.append(this.ak);
      localStringBuilder.append(", duration:");
      localStringBuilder.append(l1);
      QLog.d("EditLocalVideoActivity", 2, localStringBuilder.toString());
    }
    this.an = 2;
    if (!TextUtils.isEmpty(this.aj))
    {
      int i1 = FormatDetector.a(this.aj);
      if (i1 != 0)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("format is not supported ret=");
          localStringBuilder.append(i1);
          QLog.d("EditLocalVideoActivity", 2, localStringBuilder.toString());
        }
        QzoneVideoBeaconReport.reportVideoEvent(String.valueOf(this.aI), "qzone_video_trim", "10", null);
        this.aj = null;
        this.aJ.sendEmptyMessage(1101);
        return;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setVideoPath:");
        localStringBuilder.append(this.aj);
        QLog.d("EditLocalVideoActivity", 2, localStringBuilder.toString());
      }
      this.V.setVideoPath(this.aj);
      this.aJ.sendEmptyMessageDelayed(9999, 10000L);
      return;
    }
    setResult(0);
    finish();
  }
  
  private void B()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(PathUtils.a);
    ((StringBuilder)localObject).append(h);
    a = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(PathUtils.a);
    ((StringBuilder)localObject).append(i);
    j = ((StringBuilder)localObject).toString();
    try
    {
      localObject = new ArrayList();
      Collections.addAll((Collection)localObject, new String[] { a, j });
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        File localFile = new File(str);
        if ((!localFile.exists()) && (localFile.mkdirs())) {
          QZLog.d("EditLocalVideoActivity", 2, new Object[] { "assertSdcardExit create directory ", str });
        }
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      QLog.d("EditLocalVideoActivity", 2, "assertSdcardExit exception", localException);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(j);
      localStringBuilder.append(".nomedia");
      com.tencent.mobileqq.utils.FileUtils.createFileIfNotExits(localStringBuilder.toString());
    }
  }
  
  private boolean C()
  {
    if (!CacheManager.isExternalAvailable())
    {
      if (QLog.isColorLevel()) {
        QLog.i("EditLocalVideoActivity", 2, "isEnoughStorage() sdcard not mounted");
      }
      QzoneVideoBeaconReport.reportVideoEvent(String.valueOf(this.aI), "qzone_video_trim", "6", null);
    }
    long l1 = cooperation.qzone.util.FileUtils.getFileSize(this.aj);
    if (l1 <= 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "no file size");
      }
      QzoneVideoBeaconReport.reportVideoEvent(String.valueOf(this.aI), "qzone_video_trim", "7", null);
      return false;
    }
    if (l1 / this.V.getDuration() * (this.I - this.H) > CacheManager.getSDCardRemain())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "there is not enough space on sdcard");
      }
      QzoneVideoBeaconReport.reportVideoEvent(String.valueOf(this.aI), "qzone_video_trim", "8", null);
      return false;
    }
    return true;
  }
  
  private boolean D()
  {
    return "cover_mall_record_video".equals(this.aA);
  }
  
  private void E()
  {
    this.aI = getAppRuntime().getLongAccountUin();
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, Matrix paramMatrix, boolean paramBoolean)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt1, paramInt2, paramMatrix, true);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label15:
      break label15;
    }
    if (paramBoolean) {
      return a(paramBitmap, paramInt1, paramInt2, paramMatrix, false);
    }
    return null;
  }
  
  private static Bitmap a(BitmapFactory.Options paramOptions, String paramString)
  {
    int i1 = 0;
    for (;;)
    {
      if ((i1 > 0) && (paramOptions.inSampleSize > 7)) {
        return null;
      }
      try
      {
        Bitmap localBitmap = a(paramString, paramOptions);
        return localBitmap;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        label25:
        break label25;
      }
      paramOptions.inSampleSize += 1;
      i1 += 1;
    }
  }
  
  private Bitmap a(BitmapFactory.Options paramOptions, String paramString, boolean paramBoolean)
  {
    try
    {
      Bitmap localBitmap = a(paramString, paramOptions);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label10:
      break label10;
    }
    if (paramBoolean) {
      return a(paramOptions, paramString, false);
    }
    return null;
  }
  
  /* Error */
  private static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 492	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 493	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_1
    //   12: ifnull +36 -> 48
    //   15: aload_2
    //   16: astore_0
    //   17: aload_1
    //   18: getfield 496	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   21: ifeq +27 -> 48
    //   24: aload_2
    //   25: astore_0
    //   26: new 498	java/io/BufferedInputStream
    //   29: dup
    //   30: aload_2
    //   31: sipush 2048
    //   34: invokespecial 501	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   37: aconst_null
    //   38: aload_1
    //   39: invokestatic 507	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   42: astore_1
    //   43: aload_1
    //   44: astore_0
    //   45: goto +24 -> 69
    //   48: aload_2
    //   49: astore_0
    //   50: new 498	java/io/BufferedInputStream
    //   53: dup
    //   54: aload_2
    //   55: sipush 8192
    //   58: invokespecial 501	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   61: aconst_null
    //   62: aload_1
    //   63: invokestatic 507	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   66: astore_1
    //   67: aload_1
    //   68: astore_0
    //   69: aload_2
    //   70: invokevirtual 512	java/io/InputStream:close	()V
    //   73: aload_0
    //   74: areturn
    //   75: astore_1
    //   76: goto +16 -> 92
    //   79: astore_1
    //   80: goto +35 -> 115
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_0
    //   86: goto +61 -> 147
    //   89: astore_1
    //   90: aconst_null
    //   91: astore_2
    //   92: aload_2
    //   93: astore_0
    //   94: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +73 -> 170
    //   100: aload_2
    //   101: astore_0
    //   102: ldc_w 287
    //   105: iconst_2
    //   106: ldc 199
    //   108: aload_1
    //   109: invokestatic 514	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   112: goto +58 -> 170
    //   115: aload_2
    //   116: astore_0
    //   117: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +15 -> 135
    //   123: aload_2
    //   124: astore_0
    //   125: ldc_w 287
    //   128: iconst_2
    //   129: ldc 199
    //   131: aload_1
    //   132: invokestatic 514	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   135: aload_2
    //   136: ifnull +8 -> 144
    //   139: aload_3
    //   140: astore_0
    //   141: goto -72 -> 69
    //   144: aconst_null
    //   145: areturn
    //   146: astore_1
    //   147: aload_0
    //   148: ifnull +7 -> 155
    //   151: aload_0
    //   152: invokevirtual 512	java/io/InputStream:close	()V
    //   155: goto +5 -> 160
    //   158: aload_1
    //   159: athrow
    //   160: goto -2 -> 158
    //   163: astore_1
    //   164: aload_0
    //   165: areturn
    //   166: astore_0
    //   167: goto -12 -> 155
    //   170: aload_2
    //   171: ifnull -27 -> 144
    //   174: aload_3
    //   175: astore_0
    //   176: goto -107 -> 69
    //   179: astore_1
    //   180: aconst_null
    //   181: astore_2
    //   182: goto -67 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramString	String
    //   0	185	1	paramOptions	BitmapFactory.Options
    //   10	172	2	localFileInputStream	java.io.FileInputStream
    //   1	174	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	75	java/io/FileNotFoundException
    //   26	43	75	java/io/FileNotFoundException
    //   50	67	75	java/io/FileNotFoundException
    //   17	24	79	java/lang/OutOfMemoryError
    //   26	43	79	java/lang/OutOfMemoryError
    //   50	67	79	java/lang/OutOfMemoryError
    //   2	11	83	finally
    //   2	11	89	java/io/FileNotFoundException
    //   17	24	146	finally
    //   26	43	146	finally
    //   50	67	146	finally
    //   94	100	146	finally
    //   102	112	146	finally
    //   117	123	146	finally
    //   125	135	146	finally
    //   69	73	163	java/io/IOException
    //   151	155	166	java/io/IOException
    //   2	11	179	java/lang/OutOfMemoryError
  }
  
  private void a(Bundle paramBundle)
  {
    Object localObject = this.aC;
    if ((localObject != null) && ("ref_h5_record_video".equals(((FlowComponentInterface)localObject).getRefer())))
    {
      localObject = new Intent("com.qzone.h5.video.recordCallback");
      ((Intent)localObject).putExtras(paramBundle);
      BaseApplication.getContext().sendBroadcast((Intent)localObject);
    }
    else
    {
      int i1 = this.aD;
      if (i1 == 0)
      {
        RemoteHandleManager.getInstance().sendData("cmd.publishVideoMood", paramBundle, false);
      }
      else if (i1 == 1)
      {
        localObject = new Intent(getIntent());
        ((Intent)localObject).putExtras(paramBundle);
        paramBundle = ((Intent)localObject).getStringExtra("PhotoConst.PLUGIN_APK");
        boolean bool = ((Intent)localObject).getBooleanExtra("DirectBackToQzone", false);
        if (("qzone_plugin.apk".equals(paramBundle)) && (bool))
        {
          ((Intent)localObject).setFlags(603979776);
          QZoneHelper.launchQZone(this, "", (Intent)localObject, -1);
        }
      }
    }
    if (this.aD == 0) {
      setResult(-1);
    }
    finish();
  }
  
  private void a(Message paramMessage)
  {
    if (this.Y != null) {
      try
      {
        paramMessage = (String)paramMessage.obj;
        int i1 = this.V.getWidth();
        int i2 = this.V.getHeight();
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("VIDEO_SHOW_COVER, filename=");
          ((StringBuilder)localObject).append(paramMessage);
          ((StringBuilder)localObject).append(", w=");
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).append(", h=");
          ((StringBuilder)localObject).append(i2);
          QLog.d("EditLocalVideoActivity", 2, ((StringBuilder)localObject).toString());
        }
        this.K = a(paramMessage, i1, i2, false);
        if (this.K != null)
        {
          localObject = this.Y.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = i2;
          ((ViewGroup.LayoutParams)localObject).width = i1;
          this.Y.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.Y.setImageBitmap(this.K);
          if (this.E) {
            this.Y.setVisibility(0);
          }
          this.L = i1;
          this.M = i2;
          this.N = paramMessage;
          return;
        }
      }
      catch (Throwable paramMessage)
      {
        QLog.w("EditLocalVideoActivity", 2, "VIDEO_SHOW_COVER failed", paramMessage);
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return;
    }
    try
    {
      paramString1 = Class.forName(paramString1).newInstance();
      if ((paramString1 instanceof FlowComponentInterface))
      {
        this.aC = ((FlowComponentInterface)paramString1);
        this.aC.setRefer(paramString2);
        return;
      }
    }
    catch (Throwable paramString1)
    {
      this.aC = null;
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("initComponentParamData:exp =");
        paramString2.append(paramString1);
        QLog.d("EditLocalVideoActivity", 2, paramString2.toString());
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString2, paramString3);
    localHashMap.put("reserve", paramString4);
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(String.valueOf(this.aI), paramString1, true, 0L, 0L, localHashMap, null);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.s;
    if ((localObject != null) && (this.t != null) && (this.u != null))
    {
      int i2 = 0;
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      ((RelativeLayout)localObject).setVisibility(i1);
      localObject = this.t;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      ((Button)localObject).setVisibility(i1);
      localObject = this.u;
      if (paramBoolean) {
        i1 = i2;
      } else {
        i1 = 8;
      }
      ((TextView)localObject).setVisibility(i1);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    QzoneHandlerThreadFactory.getHandlerThread("RealTime_HandlerThread").post(new EditLocalVideoActivity.18(this, paramInt1, paramInt2));
  }
  
  private void b(boolean paramBoolean)
  {
    this.E = paramBoolean;
    Object localObject = this.Z;
    int i3 = 8;
    int i2 = 0;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((VideoFrameSelectBar)localObject).setVisibility(i1);
    localObject = this.aa;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((RelativeLayout)localObject).setVisibility(i1);
    localObject = this.ae;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((ImageView)localObject).setVisibility(i1);
    localObject = this.Y;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((ImageView)localObject).setVisibility(i1);
    localObject = this.k;
    if (paramBoolean) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    ((ViewGroup)localObject).setVisibility(i1);
    localObject = this.aH;
    if (localObject != null)
    {
      if (paramBoolean) {
        i1 = i3;
      } else {
        i1 = 0;
      }
      ((View)localObject).setVisibility(i1);
    }
    int i1 = this.aD;
    if (i1 == 0) {
      c(paramBoolean);
    } else if (i1 == 1) {
      c(true);
    }
    localObject = this.n;
    if (localObject != null)
    {
      i1 = i2;
      if (paramBoolean) {
        i1 = 4;
      }
      ((TextView)localObject).setVisibility(i1);
    }
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 16) || (paramInt == 128);
  }
  
  public static String c()
  {
    File localFile1 = null;
    String str3 = null;
    String str1 = str3;
    try
    {
      File localFile2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
      Object localObject = localFile1;
      if (localFile2 != null)
      {
        str1 = str3;
        localObject = localFile1;
        if (localFile2.exists())
        {
          str1 = str3;
          localObject = new StringBuilder();
          str1 = str3;
          ((StringBuilder)localObject).append(localFile2.getAbsolutePath());
          str1 = str3;
          ((StringBuilder)localObject).append("/Camera");
          str1 = str3;
          str3 = ((StringBuilder)localObject).toString();
          str1 = str3;
          localFile1 = new File(str3);
          str1 = str3;
          localObject = str3;
          if (!localFile1.exists())
          {
            str1 = str3;
            localFile1.mkdir();
            return str3;
          }
        }
      }
    }
    catch (Exception localException)
    {
      QLog.w("EditLocalVideoActivity", 2, "getCameraDirectoryPath error", localException);
      String str2 = str1;
      return str2;
    }
  }
  
  private static String c(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 4)
      {
        if (paramInt != 16)
        {
          if (paramInt != 64)
          {
            if (paramInt != 128) {
              return HardCodeUtil.a(2131901768);
            }
            return HardCodeUtil.a(2131901752);
          }
          return HardCodeUtil.a(2131901766);
        }
        return HardCodeUtil.a(2131901755);
      }
      return HardCodeUtil.a(2131901761);
    }
    return HardCodeUtil.a(2131901746);
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = this.o;
    int i2 = 8;
    int i1;
    if (paramBoolean) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    ((RelativeLayout)localObject).setVisibility(i1);
    localObject = this.o;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = getResources().getColor(2131167343);
    }
    ((RelativeLayout)localObject).setBackgroundColor(i1);
    localObject = this.q;
    if (paramBoolean) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    ((ExtendEditText)localObject).setVisibility(i1);
    localObject = this.p;
    if ((!paramBoolean) && (!this.aq)) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((Button)localObject).setVisibility(i1);
    localObject = this.r;
    if (paramBoolean) {
      i1 = i2;
    } else {
      i1 = 0;
    }
    ((View)localObject).setVisibility(i1);
  }
  
  private boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  private void d(int paramInt)
  {
    Object localObject = this.af;
    if (localObject != null)
    {
      ((ProgressBar)localObject).setProgress(0);
      this.af.setVisibility(8);
    }
    a("608", "2", "0", true);
    this.H = 0;
    this.I = 0;
    this.G = 0;
    localObject = this.V;
    if (localObject != null) {
      ((FixedSizeVideoView)localObject).stopPlayback();
    }
    localObject = this.Z;
    if (localObject != null) {
      ((VideoFrameSelectBar)localObject).f();
    }
    localObject = this.K;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
      this.K.recycle();
    }
    e(8);
    setResult(paramInt);
    finish();
  }
  
  private void d(String paramString)
  {
    String str = getResources().getString(2131915001);
    QZoneHelper.forwardOpenQzoneVip2(this, QZoneHelper.UserInfo.getInstance(), paramString, this.aI, "", 1010, str, false);
  }
  
  private void e()
  {
    new AlertDialog.Builder(this).setMessage(HardCodeUtil.a(2131901762)).setNegativeButton(2131891511, new EditLocalVideoActivity.1(this)).setCancelable(false).show();
  }
  
  private void e(int paramInt)
  {
    Object localObject = this.V;
    if (localObject != null) {
      ((FixedSizeVideoView)localObject).setVisibility(paramInt);
    }
    localObject = this.W;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(paramInt);
    }
    localObject = this.X;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(paramInt);
    }
  }
  
  private void f()
  {
    a("play_local_video", "play_local_video_success", "1", Build.MODEL);
    try
    {
      new AlertDialog.Builder(this).setMessage(HardCodeUtil.a(2131901760)).setNegativeButton(2131891511, new EditLocalVideoActivity.2(this)).setCancelable(false).create().show();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("EditLocalVideoActivity", 2, "LOAD_VIDEO_TIME_OUT showDialog error", localException);
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditLocalVideoActivity", 2, "handleMessage, MSG_ON_CONFIRM");
    }
    b(false);
    if (this.V.isPlaying()) {
      this.V.pause();
    }
    FixedSizeVideoView localFixedSizeVideoView = this.V;
    int i1 = this.H;
    localFixedSizeVideoView.setPlayDuration(i1, this.I - i1);
    this.V.start();
    this.D = true;
  }
  
  private void h()
  {
    Object localObject = this.q;
    if (localObject == null) {
      return;
    }
    ((ExtendEditText)localObject).setTextEffect(this.aw);
    localObject = null;
    String str = ((IFontManager)QRoute.api(IFontManager.class)).getTrueTypeFont(this.as, null, null, true, null);
    if (TextUtils.isEmpty(str)) {
      this.as = -1;
    } else {
      localObject = Typeface.createFromFile(str);
    }
    this.q.setTypeface((Typeface)localObject);
  }
  
  private void i()
  {
    VideoFrameSelectBar localVideoFrameSelectBar = this.Z;
    if (localVideoFrameSelectBar != null) {
      localVideoFrameSelectBar.g();
    }
    this.aJ.removeMessages(9999);
  }
  
  private void j()
  {
    E();
    Object localObject = getIntent();
    this.aD = ((Intent)localObject).getIntExtra("PhotoConst.EDIT_LOCAL_VIDEO_ENTRY", 0);
    this.O = ((Intent)localObject).getStringExtra("file_send_path");
    if (!TextUtils.isEmpty(this.O))
    {
      if (!new File(this.O).exists())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("localVideoPath not exists : ");
        ((StringBuilder)localObject).append(this.O);
        QLog.e("EditLocalVideoActivity", 2, ((StringBuilder)localObject).toString());
        ToastUtil.a().a(HardCodeUtil.a(2131901764));
        finish();
        return;
      }
      this.P = this.O;
      this.Q = ((Intent)localObject).getLongExtra("PhotoConst.VIDEO_SIZE", 0L);
      this.R = ((Intent)localObject).getLongExtra("file_send_duration", 0L);
      this.S = ((Intent)localObject).getIntExtra("file_width", 0);
      this.T = ((Intent)localObject).getIntExtra("file_height", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("localVideoWidth: ");
      localStringBuilder.append(this.S);
      localStringBuilder.append(" ,    localVideoHeight: ");
      localStringBuilder.append(this.T);
      QLog.i("EditLocalVideoActivity", 2, localStringBuilder.toString());
      this.ag = ((Intent)localObject).getBooleanExtra("is_qzone_vip", false);
      this.ap = ((Intent)localObject).getStringExtra("topic_id");
      this.aq = (TextUtils.isEmpty(this.ap) ^ true);
      this.ar = ((Intent)localObject).getBooleanExtra("param.topicSyncQzone", this.ar);
      this.as = ((Intent)localObject).getIntExtra("extra_key_font_id", -1);
      this.at = ((Intent)localObject).getIntExtra("extra_key_font_format_type", -1);
      this.au = ((Intent)localObject).getStringExtra("extra_key_font_url");
      this.av = ((Intent)localObject).getIntExtra("extra_key_super_font_id", -1);
      this.aw = ((Intent)localObject).getStringExtra("extra_key_super_font_info");
      this.aJ.sendEmptyMessage(1009);
      this.aA = ((Intent)localObject).getStringExtra("short_video_refer");
      this.aB = ((Intent)localObject).getStringExtra("set_user_callback");
      a(this.aB, this.aA);
      this.H = ((int)((Intent)localObject).getLongExtra("PhotoConst.EDIT_LOCAL_VIDEO_START_TIME", 0L));
      this.I = ((int)((Intent)localObject).getLongExtra("PhotoConst.EDIT_LOCAL_VIDEO_END_TIME", 0L));
      this.J = ((int)((Intent)localObject).getLongExtra("PhotoConst.EDIT_LOCAL_VIDEO_DURATION", 0L));
      int i1 = this.H;
      if (i1 != 0) {
        this.G = i1;
      }
      this.aG = ((QzoneVerticalVideoTopicInfo)((Intent)localObject).getParcelableExtra("key_qzone_topic"));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("localVideoPath is null : ");
    ((StringBuilder)localObject).append(this.O);
    QLog.e("EditLocalVideoActivity", 2, ((StringBuilder)localObject).toString());
    ToastUtil.a().a(HardCodeUtil.a(2131901758));
    finish();
  }
  
  private void k()
  {
    if (this.aG != null)
    {
      this.aH = $(2131447761);
      this.aH.setVisibility(0);
      ((TextView)$(2131448801)).setText(this.aG.getDescName());
      URLImageView localURLImageView = (URLImageView)$(2131436489);
      if (!TextUtils.isEmpty(this.aG.getThumbImgUrl()))
      {
        localURLImageView.setBackgroundURL(this.aG.getThumbImgUrl());
        return;
      }
      localURLImageView.setVisibility(8);
    }
  }
  
  private void l()
  {
    int i1 = SystemUtil.getNotchHeight(this, this);
    if (i1 <= 0) {
      return;
    }
    Object localObject = findViewById(2131442305);
    if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof RelativeLayout.LayoutParams)))
    {
      localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height += i1;
    }
  }
  
  private void m()
  {
    if (this.E)
    {
      this.ab.performClick();
      return;
    }
    if (this.az == null) {
      this.az = DialogUtil.a(this, 230, HardCodeUtil.a(2131901756), null, getString(2131890045), getString(2131887648), new EditLocalVideoActivity.3(this), new EditLocalVideoActivity.4(this));
    }
    this.az.show();
  }
  
  private void n()
  {
    this.z.a(this.R, this.O);
    this.z.a(this.H, this.I);
    this.z.a(new EditLocalVideoActivity.6(this));
    this.z.a(new EditLocalVideoActivity.7(this));
    this.z.a();
  }
  
  private void o()
  {
    if (this.z == null)
    {
      this.z = EditLocalVideoMusicMixer.a(this, this.V, this.aG, this.x);
      return;
    }
    QZLog.i("EditLocalVideoActivity", 2, "use old music mixer");
  }
  
  private void p()
  {
    if (!c(this.O))
    {
      ToastUtil.a().a("视频文件不存在");
      return;
    }
    LpReportInfo_pf00064.allReport(664, 2);
    if (this.ah)
    {
      if (this.D) {
        this.ai = true;
      } else {
        this.ai = false;
      }
    }
    else
    {
      l1 = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoDurationThreshold", 90000);
      if (this.D) {
        this.ai = true;
      } else if (this.R > l1) {
        this.ai = false;
      } else {
        this.ai = true;
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("param.content", this.ao);
    localBundle.putInt("param.priv", this.c);
    localBundle.putStringArrayList("param.privList", this.d);
    localBundle.putInt("PhotoConst.EDIT_LOCAL_VIDEO_ENTRY", this.aD);
    localBundle.putString("file_send_path", this.P);
    localBundle.putString("param.videoPath", this.O);
    localBundle.putLong("param.videoSize", this.Q);
    localBundle.putInt("param.videoType", 1);
    localBundle.putString("param.thumbnailPath", this.N);
    localBundle.putInt("param.thumbnailHeight", this.M);
    localBundle.putInt("param.thumbnailWidth", this.L);
    localBundle.putLong("param.startTime", this.H);
    localBundle.putLong("param.duration", this.I - this.H);
    localBundle.putLong("param.totalDuration", this.R);
    localBundle.putBoolean("param.needProcess", this.ai);
    localBundle.putBoolean("param.isUploadOrigin", this.ah);
    localBundle.putString("param.topicId", this.ap);
    localBundle.putBoolean("param.topicSyncQzone", this.ar);
    localBundle.putBoolean("param.isSyncToQQStory", this.aF);
    localBundle.putParcelable("param.QzoneTopic", this.aG);
    int i1 = this.as;
    if (i1 >= 0)
    {
      localBundle.putInt("extra_key_font_id", i1);
      localBundle.putInt("extra_key_font_format_type", this.at);
      localBundle.putString("extra_key_font_url", this.au);
    }
    i1 = this.av;
    if (i1 >= 0)
    {
      localBundle.putInt("extra_key_super_font_id", i1);
      localBundle.putString("extra_key_super_font_info", this.aw);
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("sv_encode_max_bitrate", CodecParam.mMaxrate);
    ((Bundle)localObject1).putInt("sv_encode_min_bitrate", CodecParam.mMinrate);
    ((Bundle)localObject1).putInt("sv_encode_qmax", CodecParam.mQmax);
    ((Bundle)localObject1).putInt("sv_encode_qmin", CodecParam.mQmin);
    ((Bundle)localObject1).putInt("sv_encode_qmaxdiff", CodecParam.mMaxQdiff);
    ((Bundle)localObject1).putInt("sv_encode_ref_frame", CodecParam.mRefframe);
    ((Bundle)localObject1).putInt("sv_encode_smooth", CodecParam.mIsSmooth);
    Object localObject2 = this.g;
    if (localObject2 != null)
    {
      if (((RMVideoStateMgr)localObject2).o != null) {
        ((Bundle)localObject1).putInt("sv_total_frame_count", this.g.o.getFrameIndex());
      }
      ((Bundle)localObject1).putInt("sv_total_record_time", (int)this.g.n);
    }
    i1 = 201;
    localObject2 = this.aG;
    if (localObject2 != null) {
      if (((QzoneVerticalVideoTopicInfo)localObject2).hasMusic()) {
        i1 = 213;
      } else {
        i1 = 214;
      }
    }
    ((Bundle)localObject1).putInt("param.uploadEntrance", i1);
    localBundle.putBundle("param.extras", (Bundle)localObject1);
    if ((this.aD == 1) && (!this.D))
    {
      localObject1 = this.P;
      if ((localObject1 != null) && (((String)localObject1).equals(this.O)))
      {
        localBundle.putBoolean("PhotoConst.EDIT_LOCAL_VIDEO_DONOTHING_RETURN", true);
        break label693;
      }
    }
    a("608", "1", "0", true);
    label693:
    long l1 = QzoneConfig.getInstance().getConfig("VideoEdit", "UploadMaxSizeTipWithNoWifi", 20971520L);
    if ((NetworkUtil.getNetworkType(BaseApplication.getContext()) != 1) && (this.Q > l1))
    {
      localObject1 = this.ay;
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131901757));
        ((StringBuilder)localObject1).append(l1 / 1024L / 1024L);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131901763));
        localObject1 = ((StringBuilder)localObject1).toString();
        this.ay = ActionSheet.create(this);
        this.ay.setMainTitle((CharSequence)localObject1);
        this.ay.addButton("立即上传", 0);
        this.ay.addCancelButton(2131887648);
        this.ay.setOnButtonClickListener(new EditLocalVideoActivity.8(this, localBundle));
        this.ay.setOnDismissListener(new EditLocalVideoActivity.9(this));
        this.ay.show();
        return;
      }
      if (!((ActionSheet)localObject1).isShowing()) {
        this.ay.show();
      }
    }
    else
    {
      a(localBundle);
    }
  }
  
  private void q()
  {
    EditLocalVideoMusicMixer localEditLocalVideoMusicMixer = this.z;
    if ((localEditLocalVideoMusicMixer != null) && (localEditLocalVideoMusicMixer.g()))
    {
      r();
      return;
    }
    p();
  }
  
  private void r()
  {
    this.z.a(new EditLocalVideoActivity.10(this));
  }
  
  private void s()
  {
    QZoneHelper.showQzoneVipOriginalVideoDialog(this, new EditLocalVideoActivity.11(this));
  }
  
  private void t()
  {
    int i3 = (int)this.Z.getSelectBeginTime();
    int i4 = (int)this.Z.getSelectEndTime();
    if (!C())
    {
      Toast.makeText(MobileQQ.getContext(), HardCodeUtil.a(2131901753), 1).show();
      return;
    }
    this.ai = true;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("toPublishMood, startTime=");
      ((StringBuilder)localObject1).append(i3);
      ((StringBuilder)localObject1).append(", endTime=");
      ((StringBuilder)localObject1).append(i4);
      ((StringBuilder)localObject1).append(", duration=");
      ((StringBuilder)localObject1).append(i4 - i3);
      QLog.d("EditLocalVideoActivity", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2;
    if (ax)
    {
      localObject2 = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject2).setDataSource(this.aj);
      localObject1 = ((MediaMetadataRetriever)localObject2).getFrameAtTime(i3 * 1000L);
      ((MediaMetadataRetriever)localObject2).release();
    }
    int i1;
    int i2;
    for (;;)
    {
      String str = "";
      i1 = 0;
      i2 = 0;
      localObject2 = localObject1;
      localObject1 = str;
      break;
      boolean bool;
      if (ThumbnailUtils.a(this.aj, this.al, this.am) == 0) {
        bool = TrimNative.isGetFrameReady();
      } else {
        bool = false;
      }
      if (bool)
      {
        localObject1 = ThumbnailUtils.a(i3, i3 + 1000);
      }
      else
      {
        QLog.w("EditLocalVideoActivity", 2, "TrimNative.isGetFrameReady return false,thumbnail pic is null.");
        if (D())
        {
          if (i3 <= 1000) {
            localObject1 = this.N;
          } else {
            localObject1 = "";
          }
          i2 = this.L;
          i1 = this.M;
          localObject2 = null;
          break;
        }
        localObject1 = null;
      }
    }
    if (localObject2 != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(GloableValue.b);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      ((StringBuilder)localObject1).append(".jpg");
      localObject1 = ((StringBuilder)localObject1).toString();
      if (PhotoUtils.saveBitmapToFile((Bitmap)localObject2, (String)localObject1, Bitmap.CompressFormat.JPEG, 90, true))
      {
        i2 = ((Bitmap)localObject2).getWidth();
        i1 = ((Bitmap)localObject2).getHeight();
      }
      else
      {
        QLog.e("EditLocalVideoActivity", 2, "save jpg failed");
        QzoneVideoBeaconReport.reportVideoEvent(String.valueOf(this.aI), "qzone_video_trim", "4", null);
        localObject1 = "";
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "getFrame failed");
      }
      QzoneVideoBeaconReport.reportVideoEvent(String.valueOf(this.aI), "qzone_video_trim", "5", null);
    }
    GloableValue.b();
    this.H = i3;
    this.I = i4;
    this.N = ((String)localObject1);
    this.M = i1;
    this.L = i2;
    this.aJ.sendEmptyMessage(1103);
  }
  
  private void u()
  {
    if (!this.Z.e())
    {
      this.V.seekTo(this.H);
      this.V.start();
      b(false);
      this.D = false;
      return;
    }
    ActionSheet localActionSheet = ActionSheet.create(this);
    localActionSheet.setMainTitle(HardCodeUtil.a(2131901750));
    localActionSheet.addButton(2131890045, 3);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new EditLocalVideoActivity.12(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void v()
  {
    w();
    long l1 = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoDurationThreshold", 90000);
    PressDarkImageButton localPressDarkImageButton;
    if (this.R > l1)
    {
      this.v = false;
      localPressDarkImageButton = this.C;
      if (localPressDarkImageButton != null) {
        localPressDarkImageButton.getDrawable().setColorFilter(-7829368, PorterDuff.Mode.MULTIPLY);
      }
    }
    else
    {
      this.v = true;
      localPressDarkImageButton = this.C;
      if (localPressDarkImageButton != null) {
        localPressDarkImageButton.getDrawable().clearColorFilter();
      }
    }
    l1 = QzoneConfig.getInstance().getConfig("VideoEdit", "SupportMixMusicMaxSize", 524288000L);
    if (this.Q <= 0L) {
      this.Q = new File(this.O).length();
    }
    if (this.Q > l1)
    {
      this.w = false;
      localPressDarkImageButton = this.x;
      if (localPressDarkImageButton != null) {
        localPressDarkImageButton.getDrawable().setColorFilter(-7829368, PorterDuff.Mode.MULTIPLY);
      }
    }
    else
    {
      this.w = true;
      localPressDarkImageButton = this.x;
      if (localPressDarkImageButton != null) {
        localPressDarkImageButton.getDrawable().clearColorFilter();
      }
    }
    if (this.aD == 0) {
      a(true);
    }
    if (!TextUtils.isEmpty(this.O))
    {
      x();
      return;
    }
    QLog.e("EditLocalVideoActivity", 2, " localVideoPath is empty ");
  }
  
  private void w()
  {
    int i1 = this.aD;
    if (i1 == 0)
    {
      this.n.setText(2131892583);
      this.m.setText(2131893012);
      localObject = this.z;
      if ((localObject == null) || (!((EditLocalVideoMusicMixer)localObject).b()))
      {
        this.o.setVisibility(0);
        this.o.setBackgroundColor(getResources().getColor(2131167343));
        VideoAnimation.a(this.o, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      }
    }
    else if (i1 == 1)
    {
      this.n.setText(2131887440);
      this.m.setText(2131892267);
      this.o.setVisibility(8);
      this.o.setBackgroundColor(0);
    }
    this.n.setVisibility(0);
    this.m.setVisibility(0);
    VideoAnimation.a(this.m, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
    Object localObject = this.C;
    if (localObject != null) {
      ((PressDarkImageButton)localObject).setVisibility(0);
    }
    localObject = this.x;
    if (localObject != null) {
      ((PressDarkImageButton)localObject).setVisibility(0);
    }
    VideoAnimation.a(this.C, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
    VideoAnimation.a(this.x, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
    a(false);
    VideoAnimation.a(this.s, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
    if (!this.ag)
    {
      this.t.setBackgroundResource(2130851158);
      this.b = false;
    }
  }
  
  private void x()
  {
    Object localObject;
    int i1;
    if (this.U == null)
    {
      this.U = ((ViewStub)findViewById(2131442304));
      this.U.inflate();
      try
      {
        String str1 = ShortVideoSoLoad.getShortVideoSoPath(BaseApplication.getContext());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).append(VideoEnvironment.getShortVideoSoLibName());
        GlobalInit.loadLibraryWithFullPath(((StringBuilder)localObject).toString());
      }
      catch (Throwable localThrowable1)
      {
        QLog.e("EditLocalVideoActivity", 2, "loadLibrary Exception", localThrowable1);
        a("play_local_video", "play_local_video_success", "2", Build.MODEL);
        QQToast.makeText(this, HardCodeUtil.a(2131901765), 0).show();
        finish();
      }
      if (!GloableValue.a(this.aI))
      {
        QQToast.makeText(this, HardCodeUtil.a(2131901748), 0).show();
        QLog.e("EditLocalVideoActivity", 2, "init trim failed");
        a("play_local_video", "play_local_video_success", "3", Build.MODEL);
        finish();
      }
      try
      {
        localObject = (ActivityManager)getSystemService("activity");
        ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager)localObject).getMemoryInfo(localMemoryInfo);
        i1 = QzoneConfig.getInstance().getConfig("TrimVideo", "MinAvailableRam", 209715200);
        if (localMemoryInfo.availMem < i1) {
          QQToast.makeText(this, HardCodeUtil.a(2131901771), 0).show();
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("availMem=");
          ((StringBuilder)localObject).append(localMemoryInfo.availMem);
          ((StringBuilder)localObject).append(", threshold=");
          ((StringBuilder)localObject).append(localMemoryInfo.threshold);
          ((StringBuilder)localObject).append(", lowMem=");
          ((StringBuilder)localObject).append(localMemoryInfo.lowMemory);
          ((StringBuilder)localObject).append(", minRam=");
          ((StringBuilder)localObject).append(i1);
          QLog.d("EditLocalVideoActivity", 2, ((StringBuilder)localObject).toString());
        }
      }
      catch (Throwable localThrowable2)
      {
        QLog.w("EditLocalVideoActivity", 2, "", localThrowable2);
      }
      GloableValue.a();
      this.W = ((RelativeLayout)$(2131431280));
      this.X = ((ViewGroup)$(2131449510));
      this.Y = ((ImageView)$(2131431486));
      this.Z = ((VideoFrameSelectBar)$(2131449478));
      this.V = ((FixedSizeVideoView)$(2131449765));
      this.ae = ((ImageView)$(2131449832));
      this.aa = ((RelativeLayout)$(2131449479));
      this.aa.setVisibility(8);
      this.ab = ((TextView)$(2131449480));
      this.ac = ((TextView)$(2131449482));
      this.ad = ((TextView)$(2131449481));
      this.ab.setOnClickListener(this);
      this.ad.setOnClickListener(this);
    }
    if ((this.S != 0) && (this.T != 0))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)$lp(this.X);
      localObject = (FrameLayout.LayoutParams)$lp(this.V);
      FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)$lp(this.Y);
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)$lp(this.ae);
      int i5 = this.S;
      int i4 = this.T;
      i1 = i5;
      int i2 = i4;
      if (Build.VERSION.SDK_INT >= 17)
      {
        i1 = i5;
        int i6 = i4;
        try
        {
          MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
          i1 = i5;
          i6 = i4;
          localMediaMetadataRetriever.setDataSource(this.O);
          i1 = i5;
          i6 = i4;
          String str2 = localMediaMetadataRetriever.extractMetadata(24);
          i1 = i5;
          i6 = i4;
          StringBuilder localStringBuilder = new StringBuilder();
          i1 = i5;
          i6 = i4;
          localStringBuilder.append("rotation=");
          i1 = i5;
          i6 = i4;
          localStringBuilder.append(str2);
          i1 = i5;
          i6 = i4;
          localStringBuilder.append("  localVideoWidth=");
          i1 = i5;
          i6 = i4;
          localStringBuilder.append(this.S);
          i1 = i5;
          i6 = i4;
          localStringBuilder.append(" localVideoHeight=");
          i1 = i5;
          i6 = i4;
          localStringBuilder.append(this.T);
          i1 = i5;
          i6 = i4;
          QLog.e("EditLocalVideoActivity", 2, localStringBuilder.toString());
          i1 = i5;
          i6 = i4;
          int i3;
          if (!TextUtils.equals(str2, "90"))
          {
            i3 = i5;
            i2 = i4;
            i1 = i5;
            i6 = i4;
            if (!TextUtils.equals(str2, "270")) {}
          }
          else
          {
            i1 = i5;
            i6 = i4;
            i3 = this.T;
            i1 = i3;
            i6 = i4;
            i2 = this.S;
          }
          i1 = i3;
          i6 = i2;
          localMediaMetadataRetriever.release();
          i1 = i3;
        }
        catch (Throwable localThrowable3)
        {
          QLog.e("EditLocalVideoActivity", 1, "replay error", localThrowable3);
          i2 = i6;
        }
      }
      if (i1 / i2 >= 1.0F) {
        localLayoutParams2.height = -1;
      } else {
        localLayoutParams2.height = this.T;
      }
      this.X.setLayoutParams(localLayoutParams);
      this.V.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.Y.setLayoutParams(localLayoutParams1);
      this.ae.setLayoutParams(localLayoutParams2);
    }
    y();
    z();
    if (!TextUtils.isEmpty(this.O)) {
      A();
    }
    e(0);
    this.V.setVideoPath(this.O);
    this.V.seekTo(this.H);
    this.V.start();
  }
  
  private void y()
  {
    this.ae.setOnClickListener(new EditLocalVideoActivity.13(this));
    VideoFrameSelectBar localVideoFrameSelectBar = this.Z;
    if (localVideoFrameSelectBar != null) {
      localVideoFrameSelectBar.setOnFramesClipChangeListener(this);
    }
  }
  
  private void z()
  {
    this.V.setOnFixVDPlayCompelteListener(new EditLocalVideoActivity.14(this));
    this.V.setOnErrorListener(new EditLocalVideoActivity.15(this));
    this.V.setOnPreparedListener(new EditLocalVideoActivity.16(this));
    this.V.setOnTouchListener(new EditLocalVideoActivity.17(this));
  }
  
  public long a(String paramString)
  {
    try
    {
      paramString = new StatFs(paramString);
      long l1 = paramString.getAvailableBlocks();
      int i1 = paramString.getBlockSize();
      return l1 * i1;
    }
    catch (Exception paramString)
    {
      QLog.w("EditLocalVideoActivity", 2, "getFreeSpace error", paramString);
    }
    return 0L;
  }
  
  public Bitmap a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("EditLocalVideoActivity", 2, "getBitmapWithSize but fileName is empty");
      return null;
    }
    if (!new File(paramString).exists()) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    a(paramString, localOptions);
    localOptions.inJustDecodeBounds = false;
    int i1 = localOptions.outWidth;
    int i2 = localOptions.outHeight;
    i2 = Math.min(i1 / paramInt1, i2 / paramInt2);
    i1 = i2;
    if (i2 < 1) {
      i1 = 1;
    }
    localOptions.inSampleSize = i1;
    Bitmap localBitmap2 = a(localOptions, paramString, true);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localOptions.inSampleSize += 1;
      localBitmap1 = a(localOptions, paramString);
    }
    if (localBitmap1 == null) {
      return null;
    }
    i1 = localBitmap1.getWidth();
    i2 = localBitmap1.getHeight();
    float f2 = paramInt1 / i1;
    float f3 = paramInt2 / i2;
    if ((f2 > 1.0F) && (f3 > 1.0F)) {
      return localBitmap1;
    }
    paramString = new Matrix();
    if (paramBoolean)
    {
      float f1 = f2;
      if (f2 > f3) {
        f1 = f3;
      }
      paramString.postScale(f1, f1);
    }
    else
    {
      paramString.postScale(f2, f3);
    }
    paramString = a(localBitmap1, i1, i2, paramString, true);
    if (paramString != localBitmap1) {
      localBitmap1.recycle();
    }
    return paramString;
  }
  
  public String a(int paramInt)
  {
    int i2 = paramInt / 1000;
    paramInt = i2 % 60;
    int i1 = i2 / 60 % 60;
    i2 /= 3600;
    this.aK.setLength(0);
    if (i2 > 0) {
      return this.aL.format("%d:%02d:%02d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(paramInt) }).toString();
    }
    return this.aL.format("%02d:%02d", new Object[] { Integer.valueOf(i1), Integer.valueOf(paramInt) }).toString();
  }
  
  protected void a()
  {
    setContentViewNoTitle(2131627506);
    this.l = ((RelativeLayout)$(2131432339));
    this.k = ((ViewGroup)$(2131433447));
    this.x = ((PressDarkImageButton)$(2131433443));
    this.x.setOnClickListener(this);
    this.C = ((PressDarkImageButton)$(2131433442));
    this.C.setOnClickListener(this);
    this.m = ((TextView)$(2131433470));
    this.m.setOnClickListener(this);
    this.n = ((TextView)$(2131433468));
    this.n.setOnClickListener(this);
    this.s = ((RelativeLayout)$(2131433453));
    this.s.setOnClickListener(this);
    this.t = ((Button)$(2131433454));
    this.t.setOnClickListener(this);
    this.u = ((TextView)$(2131433455));
    this.o = ((RelativeLayout)$(2131433444));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)AIOUtils.a(2, 50, getResources()));
    this.o.setBackgroundColor(getResources().getColor(2131167343));
    this.o.setVisibility(0);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = AIOUtils.b(55.0F, getResources());
    this.o.setLayoutParams(localLayoutParams);
    this.q = ((ExtendEditText)$(2131433445));
    this.q.setEditableFactory(QzoneTextBuilder.a);
    this.q.setOnClickListener(this);
    this.p = ((Button)$(2131433464));
    this.p.setOnClickListener(this);
    this.r = $(2131433466);
    k();
    l();
  }
  
  public void a(float paramFloat)
  {
    runOnUiThread(new EditLocalVideoActivity.22(this, paramFloat));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onFramesClipChanged, startTime=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", endTime=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("EditLocalVideoActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (this.E) {
      LpReportInfo_pf00064.allReport(664, 4, 4);
    }
    runOnUiThread(new EditLocalVideoActivity.19(this));
    if (this.ae.getVisibility() != 0) {
      runOnUiThread(new EditLocalVideoActivity.20(this));
    }
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new EditLocalVideoActivity.21(this, paramInt1, paramInt2));
    if (this.H == 0) {
      this.G = paramInt1;
    }
    Object localObject = this.z;
    if (localObject != null) {
      ((EditLocalVideoMusicMixer)localObject).a(paramInt1, paramInt2);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.actionType = paramString1;
    localReportInfo.subactionType = paramString2;
    localReportInfo.reserves = paramString3;
    QZoneClickReport.report(String.valueOf(this.aI), localReportInfo, paramBoolean);
  }
  
  /* Error */
  public String b(String paramString)
  {
    // Byte code:
    //   0: ldc 199
    //   2: astore 6
    //   4: invokestatic 685	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 1890	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 7
    //   15: aconst_null
    //   16: astore 4
    //   18: aload 4
    //   20: astore 5
    //   22: aload 6
    //   24: astore_3
    //   25: aload 7
    //   27: astore_2
    //   28: new 127	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   35: astore 9
    //   37: aload 4
    //   39: astore 5
    //   41: aload 6
    //   43: astore_3
    //   44: aload 7
    //   46: astore_2
    //   47: aload 9
    //   49: ldc_w 1892
    //   52: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 4
    //   58: astore 5
    //   60: aload 6
    //   62: astore_3
    //   63: aload 7
    //   65: astore_2
    //   66: aload 9
    //   68: aload_1
    //   69: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 4
    //   75: astore 5
    //   77: aload 6
    //   79: astore_3
    //   80: aload 7
    //   82: astore_2
    //   83: aload 8
    //   85: aload 9
    //   87: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 1898	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   93: aconst_null
    //   94: ldc_w 1900
    //   97: iconst_1
    //   98: anewarray 310	java/lang/String
    //   101: dup
    //   102: iconst_0
    //   103: aload_1
    //   104: aastore
    //   105: aconst_null
    //   106: invokevirtual 1906	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   109: astore 7
    //   111: aload 6
    //   113: astore 4
    //   115: aload 7
    //   117: ifnull +200 -> 317
    //   120: aload 6
    //   122: astore 4
    //   124: aload 7
    //   126: astore 5
    //   128: aload 6
    //   130: astore_3
    //   131: aload 7
    //   133: astore_2
    //   134: aload 7
    //   136: invokeinterface 1911 1 0
    //   141: ifeq +176 -> 317
    //   144: aload 7
    //   146: astore 5
    //   148: aload 6
    //   150: astore_3
    //   151: aload 7
    //   153: astore_2
    //   154: aload 7
    //   156: aload 7
    //   158: ldc_w 1913
    //   161: invokeinterface 1916 2 0
    //   166: invokeinterface 1917 2 0
    //   171: astore 4
    //   173: aload 6
    //   175: astore_1
    //   176: aload 7
    //   178: astore 5
    //   180: aload 6
    //   182: astore_3
    //   183: aload 7
    //   185: astore_2
    //   186: aload 4
    //   188: invokestatic 296	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   191: ifne +32 -> 223
    //   194: aload 7
    //   196: astore 5
    //   198: aload 6
    //   200: astore_3
    //   201: aload 7
    //   203: astore_2
    //   204: new 310	java/lang/String
    //   207: dup
    //   208: aload 4
    //   210: invokevirtual 1921	java/lang/String:getBytes	()[B
    //   213: ldc_w 1923
    //   216: invokespecial 1926	java/lang/String:<init>	([BLjava/lang/String;)V
    //   219: invokestatic 1931	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   222: astore_1
    //   223: aload_1
    //   224: astore 4
    //   226: aload 7
    //   228: astore 5
    //   230: aload_1
    //   231: astore_3
    //   232: aload 7
    //   234: astore_2
    //   235: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +79 -> 317
    //   241: aload 7
    //   243: astore 5
    //   245: aload_1
    //   246: astore_3
    //   247: aload 7
    //   249: astore_2
    //   250: new 127	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   257: astore 4
    //   259: aload 7
    //   261: astore 5
    //   263: aload_1
    //   264: astore_3
    //   265: aload 7
    //   267: astore_2
    //   268: aload 4
    //   270: ldc_w 1933
    //   273: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 7
    //   279: astore 5
    //   281: aload_1
    //   282: astore_3
    //   283: aload 7
    //   285: astore_2
    //   286: aload 4
    //   288: aload_1
    //   289: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 7
    //   295: astore 5
    //   297: aload_1
    //   298: astore_3
    //   299: aload 7
    //   301: astore_2
    //   302: ldc_w 287
    //   305: iconst_2
    //   306: aload 4
    //   308: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 415	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: aload_1
    //   315: astore 4
    //   317: aload 4
    //   319: astore_1
    //   320: aload 7
    //   322: ifnull +92 -> 414
    //   325: aload 7
    //   327: astore_2
    //   328: aload 4
    //   330: astore_3
    //   331: aload_2
    //   332: invokeinterface 1934 1 0
    //   337: aload_3
    //   338: areturn
    //   339: astore_1
    //   340: goto +76 -> 416
    //   343: astore_1
    //   344: aload_2
    //   345: astore 5
    //   347: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   350: ifeq +55 -> 405
    //   353: aload_2
    //   354: astore 5
    //   356: new 127	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   363: astore 4
    //   365: aload_2
    //   366: astore 5
    //   368: aload 4
    //   370: ldc_w 1936
    //   373: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload_2
    //   378: astore 5
    //   380: aload 4
    //   382: aload_1
    //   383: invokestatic 1940	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   386: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload_2
    //   391: astore 5
    //   393: ldc_w 287
    //   396: iconst_2
    //   397: aload 4
    //   399: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokestatic 988	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   405: aload_3
    //   406: astore_1
    //   407: aload_2
    //   408: ifnull +6 -> 414
    //   411: goto -80 -> 331
    //   414: aload_1
    //   415: areturn
    //   416: aload 5
    //   418: ifnull +10 -> 428
    //   421: aload 5
    //   423: invokeinterface 1934 1 0
    //   428: goto +5 -> 433
    //   431: aload_1
    //   432: athrow
    //   433: goto -2 -> 431
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	436	0	this	EditLocalVideoActivity
    //   0	436	1	paramString	String
    //   27	381	2	localCursor1	android.database.Cursor
    //   24	382	3	localObject1	Object
    //   16	382	4	localObject2	Object
    //   20	402	5	localObject3	Object
    //   2	197	6	str	String
    //   13	313	7	localCursor2	android.database.Cursor
    //   10	74	8	localContentResolver	android.content.ContentResolver
    //   35	51	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   28	37	339	finally
    //   47	56	339	finally
    //   66	73	339	finally
    //   83	111	339	finally
    //   134	144	339	finally
    //   154	173	339	finally
    //   186	194	339	finally
    //   204	223	339	finally
    //   235	241	339	finally
    //   250	259	339	finally
    //   268	277	339	finally
    //   286	293	339	finally
    //   302	314	339	finally
    //   347	353	339	finally
    //   356	365	339	finally
    //   368	377	339	finally
    //   380	390	339	finally
    //   393	405	339	finally
    //   28	37	343	java/lang/Exception
    //   47	56	343	java/lang/Exception
    //   66	73	343	java/lang/Exception
    //   83	111	343	java/lang/Exception
    //   134	144	343	java/lang/Exception
    //   154	173	343	java/lang/Exception
    //   186	194	343	java/lang/Exception
    //   204	223	343	java/lang/Exception
    //   235	241	343	java/lang/Exception
    //   250	259	343	java/lang/Exception
    //   268	277	343	java/lang/Exception
    //   286	293	343	java/lang/Exception
    //   302	314	343	java/lang/Exception
  }
  
  public void b()
  {
    this.p.setText(c(this.c));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (paramInt1 == 2)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onActivityResult:requestCode=");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append("  resultCode=");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.d("EditLocalVideoActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent.containsKey("permission_code")) {
          this.c = paramIntent.getInt("permission_code");
        }
        if (paramIntent.containsKey("uin_list"))
        {
          if (this.d == null) {
            this.d = new ArrayList();
          }
          this.d.clear();
          localObject = paramIntent.getStringArrayList("uin_list");
          if (localObject != null) {
            this.d.addAll((Collection)localObject);
          }
        }
        if (b(this.c))
        {
          this.f = paramIntent.getString("key_setting_raw_json");
          this.e = paramIntent.getString("key_selected_tag");
        }
        b();
      }
    }
    else if (paramInt1 == 1009)
    {
      this.B = false;
      localObject = this.A;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      if (paramIntent != null)
      {
        Bundle localBundle = paramIntent.getExtras();
        if (localBundle.containsKey("extra_key_bundle_priv_key"))
        {
          paramIntent = localBundle.getBundle("extra_key_bundle_priv_key");
          if (paramIntent != null)
          {
            this.c = paramIntent.getInt("permission_code");
            if (this.d == null) {
              this.d = new ArrayList();
            }
            this.d.clear();
            localObject = paramIntent.getStringArrayList("uin_list");
            if (localObject != null) {
              this.d.addAll((Collection)localObject);
            }
            if (b(this.c))
            {
              this.f = paramIntent.getString("key_setting_raw_json");
              this.e = paramIntent.getString("key_selected_tag");
            }
            b();
          }
        }
        if (localBundle.containsKey("contentIntentKey"))
        {
          localObject = localBundle.getString("contentIntentKey");
          paramIntent = (Intent)localObject;
          if (localObject == null) {
            paramIntent = "";
          }
          this.ao = paramIntent;
        }
        if (localBundle.containsKey("contentIntentKeyForVideoEditWithEmo"))
        {
          paramIntent = localBundle.getString("contentIntentKeyForVideoEditWithEmo");
          this.q.setText(paramIntent);
        }
        this.as = localBundle.getInt("extra_key_font_id", -1);
        this.at = localBundle.getInt("extra_key_font_format_type");
        this.au = localBundle.getString("extra_key_font_url");
        this.av = localBundle.getInt("extra_key_super_font_id", -1);
        this.aw = localBundle.getString("extra_key_super_font_info");
        this.aJ.sendEmptyMessage(1009);
      }
    }
    else if ((paramInt1 == 1010) && (paramInt2 == -1))
    {
      ToastUtil.a().a(2131914869);
      this.ag = true;
    }
  }
  
  public void onBackPressed()
  {
    this.aE = true;
    m();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Iterator localIterator;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131449481: 
      LpReportInfo_pf00064.allReport(664, 4, 3);
      a("608", "4", "1", true);
      QzoneHandlerThreadFactory.getHandlerThread("RealTime_HandlerThread").post(new EditLocalVideoActivity.5(this));
      break;
    case 2131449480: 
      LpReportInfo_pf00064.allReport(664, 4, 2);
      u();
      break;
    case 2131433470: 
      q();
      break;
    case 2131433468: 
      LpReportInfo_pf00064.allReport(664, 1);
      this.aE = false;
      m();
      break;
    case 2131433464: 
      localObject1 = QzoneConfig.getInstance().getConfig("H5Url", "UgcPermitSetting", "https://h5.qzone.qq.com/ugc/setting?_wv=3&type=mood&uin={uin}&qua={qua}&_proxy=1").replace("{uin}", String.valueOf(this.aI)).replace("{qua}", QUA.getQUA3());
      a("608", "6", "0", true);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("permission_code", this.c);
      localObject3 = this.d;
      if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
      {
        ((Bundle)localObject2).putStringArrayList("uin_list", this.d);
        localObject3 = new ArrayList(this.d.size());
        localIterator = this.d.iterator();
        while (localIterator.hasNext()) {
          ((ArrayList)localObject3).add(b((String)localIterator.next()));
        }
        ((Bundle)localObject2).putStringArrayList("key_nicknames", (ArrayList)localObject3);
      }
      if ((b(this.c)) && (!TextUtils.isEmpty(this.f))) {
        ((Bundle)localObject2).putString("key_setting_raw_json", this.f);
      }
      QZoneHelper.forwardToBrowser(this, (String)localObject1, 2, (Bundle)localObject2, "");
      break;
    case 2131433453: 
    case 2131433454: 
      if (!this.ag) {
        s();
      }
      break;
    }
    for (;;)
    {
      break;
      if (this.b)
      {
        ToastUtil.a().a(2131915153);
        this.b = false;
        this.t.setBackgroundResource(2130851158);
        this.ah = false;
      }
      else
      {
        ToastUtil.a().a(2131915155);
        a("608", "7", "1", true);
        this.b = true;
        this.t.setBackgroundResource(2130851157);
        this.ah = true;
        continue;
        this.B = true;
        a("608", "5", "0", true);
        localObject2 = QZoneHelper.UserInfo.getInstance();
        localObject3 = new Bundle();
        ((Bundle)localObject3).putInt("permission_code", this.c);
        localObject1 = this.d;
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          ((Bundle)localObject3).putStringArrayList("uin_list", this.d);
          localObject1 = new ArrayList(this.d.size());
          localIterator = this.d.iterator();
          while (localIterator.hasNext()) {
            ((ArrayList)localObject1).add(b((String)localIterator.next()));
          }
          ((Bundle)localObject3).putStringArrayList("key_nicknames", (ArrayList)localObject1);
        }
        if ((b(this.c)) && (!TextUtils.isEmpty(this.f))) {
          ((Bundle)localObject3).putString("key_setting_raw_json", this.f);
        }
        if (this.A == null)
        {
          this.A = new View(this);
          this.A.setBackgroundColor(Color.argb(128, 0, 0, 0));
          this.A.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
          this.l.addView(this.A);
        }
        this.A.setVisibility(0);
        localObject1 = this.q;
        if (localObject1 != null) {
          localObject1 = ((ExtendEditText)localObject1).getText().toString();
        } else {
          localObject1 = "";
        }
        boolean bool = this.aq;
        QZoneHelper.forwardToVideoEditActionPanel(this, (QZoneHelper.UserInfo)localObject2, 1009, "", (String)localObject1, "", "", 0, bool ^ true, 1, 0, 0, 0, "", 10000, (Bundle)localObject3, bool, this.ar, this.as, this.av, false);
        break;
        LpReportInfo_pf00064.allReport(664, 3, 1);
        if (this.w)
        {
          this.y = true;
          o();
          n();
        }
        else
        {
          Toast.makeText(getApplicationContext(), HardCodeUtil.a(2131901749), 1).show();
          break;
          LpReportInfo_pf00064.allReport(664, 4, 1);
          if (this.v)
          {
            QLog.e("EditLocalVideoActivity", 2, "click clip ");
            localObject1 = a(this.N, this.L, this.M, false);
            if (localObject1 != null) {
              this.Y.setImageBitmap((Bitmap)localObject1);
            } else {
              QLog.e("EditLocalVideoActivity", 2, "click clip but coverview find bitmap is null");
            }
            this.V.seekTo(this.G);
            this.V.pause();
            this.E = true;
            b(true);
          }
          else
          {
            long l1 = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoDurationThreshold", 90000);
            localObject1 = getApplicationContext();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131901754));
            ((StringBuilder)localObject2).append(l1 / 1000L);
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131901769));
            Toast.makeText((Context)localObject1, ((StringBuilder)localObject2).toString(), 1).show();
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    getWindow().addFlags(128);
    getWindow().addFlags(1024);
    B();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    j();
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    QzoneGuideBubbleHelper.getInstance().dismissGuideBubble();
    EditLocalVideoMusicMixer localEditLocalVideoMusicMixer = this.z;
    if (localEditLocalVideoMusicMixer != null) {
      localEditLocalVideoMusicMixer.d();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (!TextUtils.isEmpty(this.aj)) {
      if (!this.E) {
        this.V.pause();
      } else if (this.V.isPlaying()) {
        this.V.pause();
      }
    }
    EditLocalVideoMusicMixer localEditLocalVideoMusicMixer = this.z;
    if (localEditLocalVideoMusicMixer != null) {
      localEditLocalVideoMusicMixer.e();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.y)
    {
      LpReportInfo_pf00064.allReport(664, 3, 2);
      this.y = false;
    }
    v();
    Object localObject = this.V;
    if (localObject != null)
    {
      if (!this.E)
      {
        ((FixedSizeVideoView)localObject).seekTo(this.H);
        this.V.start();
        this.ae.setVisibility(8);
      }
      else
      {
        localObject = a(this.N, this.L, this.M, false);
        if (localObject != null) {
          this.Y.setImageBitmap((Bitmap)localObject);
        }
        b(true);
        this.V.seekTo(this.G);
        this.V.pause();
      }
      localObject = this.z;
      if (localObject != null) {
        ((EditLocalVideoMusicMixer)localObject).f();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity
 * JD-Core Version:    0.7.0.1
 */