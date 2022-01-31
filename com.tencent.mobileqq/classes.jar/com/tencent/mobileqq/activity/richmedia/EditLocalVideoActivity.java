package com.tencent.mobileqq.activity.richmedia;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.text.TextUtils;
import android.view.LayoutInflater;
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
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.maxvideo.common.GlobalInit;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.common.GloableValue;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.utils.FormatDetector;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.utils.ThumbnailUtils;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar.OnFramesClipChangeListener;
import com.tencent.mobileqq.activity.richmedia.view.ExtendEditText;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
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
import com.tencent.video.decode.ShortVideoSoLoad;
import com.tencent.widget.ActionSheet;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.font.FontInterface;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import cooperation.qzone.widget.QzoneGuideBubbleHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import mqq.app.MobileQQ;
import xti;
import xtl;
import xtm;
import xto;
import xtp;
import xtq;
import xtr;
import xts;
import xtt;
import xtu;
import xtv;
import xtw;
import xtx;
import xty;
import xtz;
import xug;
import xuj;
import xuk;
import xul;
import xum;
import xun;
import xuo;
import xup;
import xuq;
import xur;

public class EditLocalVideoActivity
  extends FlowActivity
  implements View.OnClickListener, VideoFrameSelectBar.OnFramesClipChangeListener
{
  private static String jdField_c_of_type_JavaLangString = Environment.getExternalStorageDirectory().toString() + File.separator + "tencent" + File.separator + "video_edit_music_download" + File.separator;
  private static String jdField_e_of_type_JavaLangString = Environment.getExternalStorageDirectory().toString() + File.separator + "tencent" + File.separator + "video_edit_music" + File.separator;
  private static String jdField_f_of_type_JavaLangString = jdField_e_of_type_JavaLangString + "temp.af";
  private static String jdField_g_of_type_JavaLangString = "";
  private static String jdField_h_of_type_JavaLangString = jdField_e_of_type_JavaLangString + "final.mp4";
  private static String jdField_i_of_type_JavaLangString = jdField_e_of_type_JavaLangString + "no_audio.mp4";
  private static final String jdField_j_of_type_JavaLangString = jdField_e_of_type_JavaLangString + "concat_final.m4a";
  private static final String jdField_k_of_type_JavaLangString = jdField_c_of_type_JavaLangString + "concat_config.txt";
  private static final boolean jdField_s_of_type_Boolean;
  public int a;
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PressDarkImageButton jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  private FlowComponentInterface jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface;
  public RMVideoStateMgr a;
  private FixedSizeVideoView jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView;
  private VideoFrameSelectBar jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar;
  private ExtendEditText jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  public String a;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  public ArrayList a;
  private Formatter jdField_a_of_type_JavaUtilFormatter = new Formatter(this.jdField_a_of_type_JavaLangStringBuilder, Locale.getDefault());
  boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private Handler jdField_b_of_type_AndroidOsHandler = new xti(this);
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private PressDarkImageButton jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  private ActionSheet jdField_b_of_type_ComTencentWidgetActionSheet;
  public String b;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int jdField_d_of_type_Int;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean = true;
  private int jdField_i_of_type_Int = 1;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private String jdField_l_of_type_JavaLangString = "";
  private boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int;
  private String jdField_m_of_type_JavaLangString = "";
  private boolean jdField_m_of_type_Boolean = true;
  private int jdField_n_of_type_Int;
  private String jdField_n_of_type_JavaLangString = "";
  private boolean jdField_n_of_type_Boolean;
  private int jdField_o_of_type_Int;
  private String jdField_o_of_type_JavaLangString;
  private boolean jdField_o_of_type_Boolean;
  private int jdField_p_of_type_Int = 2;
  private String jdField_p_of_type_JavaLangString;
  private boolean jdField_p_of_type_Boolean;
  private int jdField_q_of_type_Int = -1;
  private boolean jdField_q_of_type_Boolean;
  private int jdField_r_of_type_Int = -1;
  private String jdField_r_of_type_JavaLangString;
  private boolean jdField_r_of_type_Boolean = true;
  private int jdField_s_of_type_Int = -1;
  private String jdField_s_of_type_JavaLangString;
  private int jdField_t_of_type_Int = 0;
  private String jdField_t_of_type_JavaLangString = a(1);
  private boolean jdField_t_of_type_Boolean;
  private String jdField_u_of_type_JavaLangString = "";
  private boolean jdField_u_of_type_Boolean;
  private String v;
  private String w;
  private String x;
  private String y;
  private String z;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 10) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_s_of_type_Boolean = bool;
      return;
    }
  }
  
  public EditLocalVideoActivity()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = RMVideoStateMgr.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private long a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
      {
        long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
        return l1;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.i("EditLocalVideoActivity", 2, "parse lastLoginUin error");
    }
    return 0L;
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
      if (paramBoolean) {
        return a(paramBitmap, paramInt1, paramInt2, paramMatrix, false);
      }
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
        paramOptions.inSampleSize += 1;
        i1 += 1;
      }
    }
  }
  
  private Bitmap a(BitmapFactory.Options paramOptions, String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = a(paramString, paramOptions);
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!paramBoolean) {}
    }
    return localObject;
    return a(paramOptions, paramString, false);
  }
  
  /* Error */
  private static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 267	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 270	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_1
    //   12: ifnull +47 -> 59
    //   15: aload_2
    //   16: astore_0
    //   17: aload_1
    //   18: getfield 273	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   21: ifeq +38 -> 59
    //   24: aload_2
    //   25: astore_0
    //   26: new 275	java/io/BufferedInputStream
    //   29: dup
    //   30: aload_2
    //   31: sipush 2048
    //   34: invokespecial 278	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   37: aconst_null
    //   38: aload_1
    //   39: invokestatic 284	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   42: astore_1
    //   43: aload_1
    //   44: astore_0
    //   45: aload_0
    //   46: astore_1
    //   47: aload_2
    //   48: ifnull +9 -> 57
    //   51: aload_2
    //   52: invokevirtual 289	java/io/InputStream:close	()V
    //   55: aload_0
    //   56: astore_1
    //   57: aload_1
    //   58: areturn
    //   59: aload_2
    //   60: astore_0
    //   61: new 275	java/io/BufferedInputStream
    //   64: dup
    //   65: aload_2
    //   66: sipush 8192
    //   69: invokespecial 278	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   72: aconst_null
    //   73: aload_1
    //   74: invokestatic 284	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   77: astore_1
    //   78: aload_1
    //   79: astore_0
    //   80: goto -35 -> 45
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_2
    //   86: aload_2
    //   87: astore_0
    //   88: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +14 -> 105
    //   94: aload_2
    //   95: astore_0
    //   96: ldc 227
    //   98: iconst_2
    //   99: ldc 104
    //   101: aload_1
    //   102: invokestatic 296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   105: aload_3
    //   106: astore_1
    //   107: aload_2
    //   108: ifnull -51 -> 57
    //   111: aload_2
    //   112: invokevirtual 289	java/io/InputStream:close	()V
    //   115: aconst_null
    //   116: areturn
    //   117: astore_0
    //   118: aconst_null
    //   119: areturn
    //   120: astore_1
    //   121: aconst_null
    //   122: astore_2
    //   123: aload_2
    //   124: astore_0
    //   125: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +14 -> 142
    //   131: aload_2
    //   132: astore_0
    //   133: ldc 227
    //   135: iconst_2
    //   136: ldc 104
    //   138: aload_1
    //   139: invokestatic 296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   142: aload_3
    //   143: astore_1
    //   144: aload_2
    //   145: ifnull -88 -> 57
    //   148: aload_2
    //   149: invokevirtual 289	java/io/InputStream:close	()V
    //   152: aconst_null
    //   153: areturn
    //   154: astore_0
    //   155: aconst_null
    //   156: areturn
    //   157: astore_1
    //   158: aconst_null
    //   159: astore_0
    //   160: aload_0
    //   161: ifnull +7 -> 168
    //   164: aload_0
    //   165: invokevirtual 289	java/io/InputStream:close	()V
    //   168: aload_1
    //   169: athrow
    //   170: astore_1
    //   171: aload_0
    //   172: areturn
    //   173: astore_0
    //   174: goto -6 -> 168
    //   177: astore_1
    //   178: goto -18 -> 160
    //   181: astore_1
    //   182: goto -59 -> 123
    //   185: astore_1
    //   186: goto -100 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	paramString	String
    //   0	189	1	paramOptions	BitmapFactory.Options
    //   10	139	2	localFileInputStream	java.io.FileInputStream
    //   1	142	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	83	java/lang/OutOfMemoryError
    //   111	115	117	java/io/IOException
    //   2	11	120	java/io/FileNotFoundException
    //   148	152	154	java/io/IOException
    //   2	11	157	finally
    //   51	55	170	java/io/IOException
    //   164	168	173	java/io/IOException
    //   17	24	177	finally
    //   26	43	177	finally
    //   61	78	177	finally
    //   88	94	177	finally
    //   96	105	177	finally
    //   125	131	177	finally
    //   133	142	177	finally
    //   17	24	181	java/io/FileNotFoundException
    //   26	43	181	java/io/FileNotFoundException
    //   61	78	181	java/io/FileNotFoundException
    //   17	24	185	java/lang/OutOfMemoryError
    //   26	43	185	java/lang/OutOfMemoryError
    //   61	78	185	java/lang/OutOfMemoryError
  }
  
  public static String a()
  {
    File localFile1 = null;
    String str2 = null;
    Object localObject = localFile1;
    try
    {
      File localFile2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
      String str1 = str2;
      if (localFile2 != null)
      {
        str1 = str2;
        localObject = localFile1;
        if (localFile2.exists())
        {
          localObject = localFile1;
          str2 = localFile2.getAbsolutePath() + "/Camera";
          localObject = str2;
          localFile1 = new File(str2);
          str1 = str2;
          localObject = str2;
          if (!localFile1.exists())
          {
            localObject = str2;
            localFile1.mkdir();
            str1 = str2;
          }
        }
      }
      return str1;
    }
    catch (Exception localException)
    {
      QLog.w("EditLocalVideoActivity", 2, "getCameraDirectoryPath error", localException);
    }
    return localObject;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "公开";
    case 1: 
      return "公开";
    case 4: 
      return "好友";
    case 16: 
      return "指定人";
    case 64: 
      return "仅自己";
    }
    return "指定人";
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    this.jdField_g_of_type_Boolean = false;
    a("608", "2", "0", true);
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.stopPlayback();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.c();
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    b(8);
    setResult(paramInt);
    finish();
  }
  
  private void a(String paramString)
  {
    String str = getResources().getString(2131432824);
    QZoneHelper.a(this, QZoneHelper.UserInfo.a(), paramString, Long.parseLong(this.jdField_q_of_type_JavaLangString), "", 1010, str, false);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramString1 = Class.forName(paramString1).newInstance();
          if ((paramString1 instanceof FlowComponentInterface))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface = ((FlowComponentInterface)paramString1);
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface.c_(paramString2);
            return;
          }
        }
        catch (Throwable paramString1)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface = null;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("EditLocalVideoActivity", 2, "initComponentParamData:exp =" + paramString1);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString2, paramString3);
    localHashMap.put("reserve", paramString4);
    paramString2 = "";
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      paramString2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    }
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString2, paramString1, true, 0L, 0L, localHashMap, null);
  }
  
  private void a(boolean paramBoolean)
  {
    int i2 = 0;
    Object localObject;
    if ((this.jdField_c_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidWidgetButton != null) && (this.jdField_c_of_type_AndroidWidgetTextView != null))
    {
      localObject = this.jdField_c_of_type_AndroidWidgetRelativeLayout;
      if (!paramBoolean) {
        break label78;
      }
      i1 = 0;
      ((RelativeLayout)localObject).setVisibility(i1);
      localObject = this.jdField_b_of_type_AndroidWidgetButton;
      if (!paramBoolean) {
        break label84;
      }
      i1 = 0;
      label53:
      ((Button)localObject).setVisibility(i1);
      localObject = this.jdField_c_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label90;
      }
    }
    label78:
    label84:
    label90:
    for (int i1 = i2;; i1 = 8)
    {
      ((TextView)localObject).setVisibility(i1);
      return;
      i1 = 8;
      break;
      i1 = 8;
      break label53;
    }
  }
  
  private void a(boolean paramBoolean, PressDarkImageButton paramPressDarkImageButton)
  {
    if ((paramPressDarkImageButton == null) || (paramPressDarkImageButton.getDrawable() == null)) {
      return;
    }
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      paramPressDarkImageButton.setEnableDark(bool);
      if (!paramBoolean) {
        break;
      }
      paramPressDarkImageButton.getDrawable().setColorFilter(getResources().getColor(2131493773), PorterDuff.Mode.MULTIPLY);
      return;
    }
    paramPressDarkImageButton.getDrawable().clearColorFilter();
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 16) || (paramInt == 128);
  }
  
  private static String b(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong < 0L) {
      l1 = 0L;
    }
    return String.valueOf(l1 * 1.0D / 1000.0D);
  }
  
  private void b()
  {
    Typeface localTypeface = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setTextEffect(this.x);
    String str = FontInterface.a(this.jdField_q_of_type_Int, null, null, null);
    if (TextUtils.isEmpty(str)) {
      this.jdField_q_of_type_Int = -1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setTypeface(localTypeface);
      return;
      localTypeface = Typeface.createFromFile(str);
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setVisibility(paramInt);
    }
    if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(paramInt);
    }
    if (this.jdField_c_of_type_AndroidViewViewGroup != null) {
      this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(paramInt);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    QzoneHandlerThreadFactory.getHandlerThread("RealTime_HandlerThread").post(new xtt(this, paramInt1, paramInt2));
  }
  
  private void b(Bundle paramBundle)
  {
    if (this.jdField_b_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_b_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a("音乐合成中，发表视频无音乐");
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a("确定", 0);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.d("取消");
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(new xuj(this, paramBundle));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(new xuk(this));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.show();
    }
    while (this.jdField_b_of_type_ComTencentWidgetActionSheet.isShowing()) {
      return;
    }
    this.jdField_b_of_type_ComTencentWidgetActionSheet.show();
  }
  
  private void b(String paramString)
  {
    this.jdField_h_of_type_Boolean = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new xtz(this, paramString));
  }
  
  private void b(boolean paramBoolean)
  {
    int i2 = 0;
    int i3 = 8;
    this.jdField_k_of_type_Boolean = paramBoolean;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar;
    int i1;
    if (paramBoolean)
    {
      i1 = 0;
      ((VideoFrameSelectBar)localObject).setVisibility(i1);
      localObject = this.jdField_e_of_type_AndroidWidgetRelativeLayout;
      if (!paramBoolean) {
        break label244;
      }
      i1 = 0;
      label41:
      ((RelativeLayout)localObject).setVisibility(i1);
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label250;
      }
      i1 = 0;
      label59:
      ((ImageView)localObject).setVisibility(i1);
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label256;
      }
      i1 = 0;
      label77:
      ((ImageView)localObject).setVisibility(i1);
      localObject = this.jdField_b_of_type_AndroidViewViewGroup;
      if (!paramBoolean) {
        break label262;
      }
      i1 = 8;
      label96:
      ((ViewGroup)localObject).setVisibility(i1);
      if (this.jdField_t_of_type_Int != 0) {
        break label301;
      }
      localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      if (!paramBoolean) {
        break label267;
      }
      i1 = 8;
      label122:
      ((RelativeLayout)localObject).setVisibility(i1);
      localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      if (!paramBoolean) {
        break label272;
      }
      i1 = 0;
      label140:
      ((RelativeLayout)localObject).setBackgroundColor(i1);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText;
      if (!paramBoolean) {
        break label286;
      }
      i1 = 8;
      label159:
      ((ExtendEditText)localObject).setVisibility(i1);
      localObject = this.jdField_a_of_type_AndroidWidgetButton;
      if ((!paramBoolean) && (!this.jdField_q_of_type_Boolean)) {
        break label291;
      }
      i1 = 8;
      label185:
      ((Button)localObject).setVisibility(i1);
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label296;
      }
      i1 = i3;
      label204:
      ((View)localObject).setVisibility(i1);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        localObject = this.jdField_b_of_type_AndroidWidgetTextView;
        i1 = i2;
        if (paramBoolean) {
          i1 = 4;
        }
        ((TextView)localObject).setVisibility(i1);
      }
      return;
      i1 = 8;
      break;
      label244:
      i1 = 8;
      break label41;
      label250:
      i1 = 8;
      break label59;
      label256:
      i1 = 8;
      break label77;
      label262:
      i1 = 0;
      break label96;
      label267:
      i1 = 0;
      break label122;
      label272:
      i1 = getResources().getColor(2131493781);
      break label140;
      label286:
      i1 = 0;
      break label159;
      label291:
      i1 = 0;
      break label185;
      label296:
      i1 = 0;
      break label204;
      label301:
      if (this.jdField_t_of_type_Int == 1)
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.d();
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(9999);
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").removeTask(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setVideoPath(jdField_g_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.start();
      this.jdField_p_of_type_JavaLangString = jdField_g_of_type_JavaLangString;
      return;
    }
    QQToast.a(this, "音乐合成中，请稍候", 0).a();
    this.jdField_h_of_type_Int = ((this.jdField_e_of_type_Int - this.jdField_d_of_type_Int) / 1000);
    if (!TextUtils.isEmpty(this.jdField_n_of_type_JavaLangString)) {}
    for (;;)
    {
      try
      {
        Object localObject = this.jdField_n_of_type_JavaLangString.split(":");
        String str = localObject[0];
        localObject = localObject[1];
        this.jdField_g_of_type_Int = (Integer.parseInt(str) * 60 + Integer.parseInt((String)localObject));
        QLog.d("ffmpeg_concat", 2, "mSongInterval:" + this.jdField_n_of_type_JavaLangString + " - " + this.jdField_g_of_type_Int + " [split]min:" + str + " sec:" + (String)localObject);
      }
      catch (Exception localException)
      {
        QLog.d("ffmpeg_concat", 2, "mSongInterval split exception");
        continue;
      }
      this.jdField_a_of_type_JavaLangRunnable = new xug(this);
      QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(this.jdField_a_of_type_JavaLangRunnable);
      return;
      QLog.d("ffmpeg_concat", 2, "mSongInterval is Empty ");
    }
  }
  
  private boolean c()
  {
    if (!CacheManager.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("EditLocalVideoActivity", 2, "isEnoughStorage() sdcard not mounted");
      }
      QzoneVideoBeaconReport.a(this.jdField_q_of_type_JavaLangString, "qzone_video_trim", "6", null);
    }
    long l1 = cooperation.qzone.util.FileUtils.a(this.jdField_s_of_type_JavaLangString);
    if (l1 <= 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "no file size");
      }
      QzoneVideoBeaconReport.a(this.jdField_q_of_type_JavaLangString, "qzone_video_trim", "7", null);
      return false;
    }
    if (l1 / this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.getDuration() * (this.jdField_e_of_type_Int - this.jdField_d_of_type_Int) > CacheManager.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "there is not enough space on sdcard");
      }
      QzoneVideoBeaconReport.a(this.jdField_q_of_type_JavaLangString, "qzone_video_trim", "8", null);
      return false;
    }
    return true;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {}
    try
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new xtw(this);
      IntentFilter localIntentFilter = new IntentFilter("action_music_info_js_to_qzone");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean d()
  {
    return "cover_mall_record_video".equals(this.y);
  }
  
  private void e()
  {
    long l1 = a();
    if ((this.jdField_t_of_type_Int == 0) && (QzoneSyncQQStoryTool.a(l1, 3)) && (e()))
    {
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)a(2131373567));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(new xul(this, l1));
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      View localView = a(2131373568);
      localView.setVisibility(0);
      if (QzoneSyncQQStoryTool.b(l1))
      {
        this.jdField_c_of_type_AndroidWidgetButton.setSelected(true);
        this.jdField_u_of_type_Boolean = true;
      }
      if (!QzoneSyncQQStoryTool.a(l1)) {
        QzoneSyncQQStoryTool.a(this, localView, l1);
      }
    }
  }
  
  private boolean e()
  {
    boolean bool2 = false;
    try
    {
      File localFile = new File(this.jdField_p_of_type_JavaLangString);
      boolean bool1 = bool2;
      if (localFile.exists())
      {
        long l1 = localFile.length();
        int i1 = QzoneSyncQQStoryTool.a(a());
        bool1 = bool2;
        if (l1 < i1 * 1024 * 1024) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("EditLocalVideoActivity", 2, "getFile error", localThrowable);
    }
    return false;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, "放弃本次视频编辑？", null, "放弃", "取消", new xum(this), new xun(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void g()
  {
    DialogUtil.a(this, 230).setMessage(2131432468).setPositiveButton(2131432426, new xtl(this)).setNegativeButton(2131432785, new xur(this)).show();
  }
  
  private void h()
  {
    int i2 = 0;
    int i5 = (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.a();
    int i6 = (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.b();
    if (!c())
    {
      Toast.makeText(MobileQQ.getContext(), "抱歉，文件不存在或存储空间不足", 1).show();
      return;
    }
    this.jdField_p_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("EditLocalVideoActivity", 2, "toPublishMood, startTime=" + i5 + ", endTime=" + i6 + ", duration=" + (i6 - i5));
    }
    Object localObject1 = "";
    Bitmap localBitmap;
    int i1;
    if (jdField_s_of_type_Boolean)
    {
      localObject1 = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject1).setDataSource(this.jdField_s_of_type_JavaLangString);
      localBitmap = ((MediaMetadataRetriever)localObject1).getFrameAtTime(i5 * 1000L);
      ((MediaMetadataRetriever)localObject1).release();
      localObject1 = "";
      i1 = 0;
    }
    for (;;)
    {
      label222:
      int i3;
      int i4;
      Object localObject2;
      if (localBitmap != null)
      {
        localObject1 = GloableValue.jdField_a_of_type_JavaLangString + File.separator + System.currentTimeMillis() + ".jpg";
        if (cooperation.qzone.util.FileUtils.a((String)localObject1, localBitmap))
        {
          i2 = localBitmap.getWidth();
          i1 = localBitmap.getHeight();
          i3 = i1;
          i4 = i2;
          localObject2 = localObject1;
          if (!localBitmap.isRecycled())
          {
            localBitmap.recycle();
            localObject2 = localObject1;
            i4 = i2;
            i3 = i1;
          }
        }
      }
      for (;;)
      {
        GloableValue.b();
        this.jdField_d_of_type_Int = i5;
        this.jdField_e_of_type_Int = i6;
        this.jdField_o_of_type_JavaLangString = localObject2;
        this.jdField_k_of_type_Int = i3;
        this.jdField_j_of_type_Int = i4;
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1103);
        return;
        if (ThumbnailUtils.a(this.jdField_s_of_type_JavaLangString, this.jdField_n_of_type_Int, this.jdField_o_of_type_Int) == 0) {}
        for (boolean bool = TrimNative.isGetFrameReady();; bool = false)
        {
          if (!bool) {
            break label355;
          }
          localBitmap = ThumbnailUtils.a(i5, i5 + 1000);
          localObject1 = "";
          i1 = 0;
          break;
        }
        label355:
        QLog.w("EditLocalVideoActivity", 2, "TrimNative.isGetFrameReady return false,thumbnail pic is null.");
        if (!d()) {
          break label472;
        }
        if (i5 <= 1000) {
          localObject1 = this.jdField_o_of_type_JavaLangString;
        }
        i2 = this.jdField_j_of_type_Int;
        i1 = this.jdField_k_of_type_Int;
        localBitmap = null;
        break;
        localObject1 = "";
        QLog.e("EditLocalVideoActivity", 2, "save jpg failed");
        QzoneVideoBeaconReport.a(this.jdField_q_of_type_JavaLangString, "qzone_video_trim", "4", null);
        break label222;
        if (QLog.isColorLevel()) {
          QLog.d("EditLocalVideoActivity", 2, "getFrame failed");
        }
        QzoneVideoBeaconReport.a(this.jdField_q_of_type_JavaLangString, "qzone_video_trim", "5", null);
        i3 = i1;
        i4 = i2;
        localObject2 = localObject1;
      }
      label472:
      localObject1 = "";
      localBitmap = null;
      i1 = 0;
    }
  }
  
  private void i()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.c())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.start();
      b(false);
      this.jdField_j_of_type_Boolean = false;
      return;
    }
    ActionSheet localActionSheet = ActionSheet.a(this);
    localActionSheet.a("是否放弃裁剪?");
    localActionSheet.a("放弃", 3);
    localActionSheet.d("取消");
    localActionSheet.a(new xtm(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void j()
  {
    boolean bool = true;
    k();
    long l1 = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoDurationThreshold", 90000);
    if (this.jdField_b_of_type_Long > l1)
    {
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton != null) {
        this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.getDrawable().setColorFilter(-7829368, PorterDuff.Mode.MULTIPLY);
      }
      l1 = QzoneConfig.getInstance().getConfig("VideoEdit", "SupportMixMusicMaxSize", 524288000L);
      if (this.jdField_a_of_type_Long <= l1) {
        break label190;
      }
      this.jdField_e_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.getDrawable().setColorFilter(-7829368, PorterDuff.Mode.MULTIPLY);
      }
      label113:
      l1 = QzoneConfig.getInstance().getConfig("VideoEdit", "VipQualityLimitSize", 209715200L);
      if (this.jdField_t_of_type_Int == 0) {
        if (this.jdField_a_of_type_Long >= l1) {
          break label215;
        }
      }
    }
    for (;;)
    {
      a(bool);
      if (TextUtils.isEmpty(this.jdField_p_of_type_JavaLangString)) {
        break label220;
      }
      l();
      return;
      this.jdField_d_of_type_Boolean = true;
      if (this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton == null) {
        break;
      }
      this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.getDrawable().clearColorFilter();
      break;
      label190:
      this.jdField_e_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton == null) {
        break label113;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.getDrawable().clearColorFilter();
      break label113;
      label215:
      bool = false;
    }
    label220:
    QLog.e("EditLocalVideoActivity", 2, " localVideoPath is empty ");
  }
  
  private void k()
  {
    if (this.jdField_t_of_type_Int == 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("重拍");
      this.jdField_a_of_type_AndroidWidgetTextView.setText("发表");
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getResources().getColor(2131493781));
      VideoAnimation.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      VideoAnimation.a(this.jdField_a_of_type_AndroidWidgetTextView, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      if (this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton != null) {
        this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
      }
      VideoAnimation.a(this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      VideoAnimation.a(this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      a(false);
      VideoAnimation.a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      if (!this.jdField_n_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130845380);
        this.jdField_a_of_type_Boolean = false;
      }
      return;
      if (this.jdField_t_of_type_Int == 1)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText("返回");
        this.jdField_a_of_type_AndroidWidgetTextView.setText("确定");
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
      }
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidViewViewStub == null)
    {
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131370400));
      this.jdField_a_of_type_AndroidViewViewStub.inflate();
    }
    try
    {
      Object localObject1 = ShortVideoSoLoad.getShortVideoSoPath(BaseApplication.getContext());
      GlobalInit.loadLibraryWithFullPath((String)localObject1 + VideoEnvironment.a());
      if (!GloableValue.a(Long.parseLong(this.jdField_q_of_type_JavaLangString)))
      {
        QQToast.a(this, "对不起，初始化裁减引擎失败", 0).a();
        QLog.e("EditLocalVideoActivity", 2, "init trim failed");
        a("play_local_video", "play_local_video_success", "3", Build.MODEL);
        finish();
      }
      try
      {
        localObject1 = (ActivityManager)getSystemService("activity");
        localObject2 = new ActivityManager.MemoryInfo();
        ((ActivityManager)localObject1).getMemoryInfo((ActivityManager.MemoryInfo)localObject2);
        i1 = QzoneConfig.getInstance().getConfig("TrimVideo", "MinAvailableRam", 209715200);
        if (((ActivityManager.MemoryInfo)localObject2).availMem < i1) {
          QQToast.a(this, "可用内存过少，可能影响裁剪操作", 0).a();
        }
        if (QLog.isColorLevel()) {
          QLog.d("EditLocalVideoActivity", 2, "availMem=" + ((ActivityManager.MemoryInfo)localObject2).availMem + ", threshold=" + ((ActivityManager.MemoryInfo)localObject2).threshold + ", lowMem=" + ((ActivityManager.MemoryInfo)localObject2).lowMemory + ", minRam=" + i1);
        }
        GloableValue.a();
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          Object localObject2;
          int i1;
          FrameLayout.LayoutParams localLayoutParams1;
          FrameLayout.LayoutParams localLayoutParams2;
          int i3;
          int i4;
          int i2;
          Object localObject3;
          QLog.w("EditLocalVideoActivity", 2, "", localThrowable2);
          continue;
          localLayoutParams2.height = this.jdField_m_of_type_Int;
        }
      }
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131362846));
      this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131367071));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131370173));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar = ((VideoFrameSelectBar)a(2131370175));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView = ((FixedSizeVideoView)a(2131370172));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131370174));
      this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131370176));
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131370177));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131370178));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)a(2131370179));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((this.jdField_l_of_type_Int != 0) && (this.jdField_m_of_type_Int != 0))
      {
        localObject1 = (RelativeLayout.LayoutParams)a(this.jdField_c_of_type_AndroidViewViewGroup);
        localObject2 = (FrameLayout.LayoutParams)a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView);
        localLayoutParams1 = (FrameLayout.LayoutParams)a(this.jdField_a_of_type_AndroidWidgetImageView);
        localLayoutParams2 = (FrameLayout.LayoutParams)a(this.jdField_b_of_type_AndroidWidgetImageView);
        i3 = this.jdField_l_of_type_Int;
        i4 = this.jdField_m_of_type_Int;
        i2 = i4;
        i1 = i3;
        if (Build.VERSION.SDK_INT >= 17)
        {
          localObject3 = new MediaMetadataRetriever();
          ((MediaMetadataRetriever)localObject3).setDataSource(this.jdField_p_of_type_JavaLangString);
          localObject3 = ((MediaMetadataRetriever)localObject3).extractMetadata(24);
          QLog.e("EditLocalVideoActivity", 2, "rotation=" + (String)localObject3 + "  localVideoWidth=" + this.jdField_l_of_type_Int + " localVideoHeight=" + this.jdField_m_of_type_Int);
          if (!TextUtils.equals((CharSequence)localObject3, "90"))
          {
            i2 = i4;
            i1 = i3;
            if (!TextUtils.equals((CharSequence)localObject3, "270")) {}
          }
          else
          {
            i1 = this.jdField_m_of_type_Int;
            i2 = this.jdField_l_of_type_Int;
          }
        }
        if (i1 / i2 >= 1.0F)
        {
          localLayoutParams2.height = -1;
          this.jdField_c_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams1);
          this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams2);
        }
      }
      else
      {
        m();
        n();
        if (!TextUtils.isEmpty(this.jdField_p_of_type_JavaLangString)) {
          o();
        }
        b(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setVideoPath(this.jdField_p_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.jdField_d_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.start();
        jdField_g_of_type_JavaLangString = this.jdField_p_of_type_JavaLangString;
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        QLog.e("EditLocalVideoActivity", 2, "loadLibrary Exception", localThrowable1);
        a("play_local_video", "play_local_video_success", "2", Build.MODEL);
        QQToast.a(this, "对不起，初始化裁剪引擎失败", 0).a();
        finish();
      }
    }
  }
  
  private void m()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new xto(this));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.setOnFramesClipChangeListener(this);
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setOnFixVDPlayCompelteListener(new xtp(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setOnErrorListener(new xtq(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setOnPreparedListener(new xtr(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setOnTouchListener(new xts(this));
  }
  
  private void o()
  {
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(9999);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_s_of_type_JavaLangString = this.jdField_p_of_type_JavaLangString;
    this.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
    long l1 = this.jdField_b_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("EditLocalVideoActivity", 2, "initData, videoPath=" + this.jdField_s_of_type_JavaLangString + ", videoSize=" + this.jdField_c_of_type_Long + ", duration:" + l1);
    }
    this.jdField_p_of_type_Int = 2;
    if (!TextUtils.isEmpty(this.jdField_s_of_type_JavaLangString))
    {
      int i1 = FormatDetector.a(this.jdField_s_of_type_JavaLangString);
      if (i1 != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EditLocalVideoActivity", 2, "format is not supported ret=" + i1);
        }
        QzoneVideoBeaconReport.a(this.jdField_q_of_type_JavaLangString, "qzone_video_trim", "10", null);
        this.jdField_s_of_type_JavaLangString = null;
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1101);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "setVideoPath:" + this.jdField_s_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setVideoPath(this.jdField_s_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(9999, 10000L);
      return;
    }
    setResult(0);
    finish();
  }
  
  private void p()
  {
    if ("mounted".equals(Environment.getExternalStorageState())) {
      jdField_c_of_type_JavaLangString = Environment.getExternalStorageDirectory().toString() + File.separator + "tencent" + File.separator + "video_edit_music_download" + File.separator;
    }
    for (jdField_e_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + File.separator + "tencent" + File.separator + "video_edit_music" + File.separator;; jdField_e_of_type_JavaLangString = getFilesDir().getAbsolutePath() + File.separator + "tencent" + File.separator + "video_edit_music" + File.separator)
    {
      try
      {
        File localFile = new File(jdField_c_of_type_JavaLangString);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        localFile = new File(jdField_e_of_type_JavaLangString);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("EditLocalVideoActivity", 2, "assertSdcardExit exception", localException);
        }
      }
      com.tencent.mobileqq.utils.FileUtils.c(jdField_e_of_type_JavaLangString + ".nomedia");
      jdField_f_of_type_JavaLangString = jdField_e_of_type_JavaLangString + "temp.af";
      jdField_h_of_type_JavaLangString = jdField_e_of_type_JavaLangString + "final.mp4";
      jdField_i_of_type_JavaLangString = jdField_e_of_type_JavaLangString + "no_audio.mp4";
      return;
      jdField_c_of_type_JavaLangString = getFilesDir().getAbsolutePath() + File.separator + "tencent" + File.separator + "video_edit_music_download" + File.separator;
    }
  }
  
  public long a(String paramString)
  {
    try
    {
      paramString = new StatFs(paramString);
      long l1 = paramString.getAvailableBlocks();
      int i1 = paramString.getBlockSize();
      return i1 * l1;
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
      paramString = null;
      return paramString;
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
    float f1 = paramInt1 / i1;
    float f2 = paramInt2 / i2;
    if ((f1 > 1.0F) && (f2 > 1.0F)) {
      return localBitmap1;
    }
    paramString = new Matrix();
    if (paramBoolean) {
      if (f1 > f2)
      {
        f1 = f2;
        label229:
        paramString.postScale(f1, f1);
      }
    }
    for (;;)
    {
      localBitmap2 = a(localBitmap1, i1, i2, paramString, true);
      paramString = localBitmap2;
      if (localBitmap2 == localBitmap1) {
        break;
      }
      localBitmap1.recycle();
      return localBitmap2;
      break label229;
      paramString.postScale(f1, f2);
    }
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 492	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 1379	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: astore_2
    //   7: aload_2
    //   8: new 65	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 1381
    //   18: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 1387	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   31: aconst_null
    //   32: ldc_w 1389
    //   35: iconst_1
    //   36: anewarray 562	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: aload_1
    //   42: aastore
    //   43: aconst_null
    //   44: invokevirtual 1395	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +212 -> 261
    //   52: aload_1
    //   53: invokeinterface 1400 1 0
    //   58: ifeq +203 -> 261
    //   61: aload_1
    //   62: aload_1
    //   63: ldc_w 1402
    //   66: invokeinterface 1405 2 0
    //   71: invokeinterface 1406 2 0
    //   76: astore_2
    //   77: aload_2
    //   78: invokestatic 586	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: ifne +174 -> 255
    //   84: new 562	java/lang/String
    //   87: dup
    //   88: aload_2
    //   89: invokevirtual 1410	java/lang/String:getBytes	()[B
    //   92: ldc_w 1412
    //   95: invokespecial 1415	java/lang/String:<init>	([BLjava/lang/String;)V
    //   98: invokestatic 1419	com/tencent/mobileqq/utils/SecurityUtile:b	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore_2
    //   102: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +29 -> 134
    //   108: ldc 227
    //   110: iconst_2
    //   111: new 65	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   118: ldc_w 1421
    //   121: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_2
    //   125: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 234	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload_2
    //   135: astore_3
    //   136: aload_1
    //   137: ifnull +11 -> 148
    //   140: aload_1
    //   141: invokeinterface 1422 1 0
    //   146: aload_2
    //   147: astore_3
    //   148: aload_3
    //   149: areturn
    //   150: astore_3
    //   151: aconst_null
    //   152: astore_2
    //   153: ldc 104
    //   155: astore_1
    //   156: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +32 -> 191
    //   162: ldc 227
    //   164: iconst_2
    //   165: new 65	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 1424
    //   175: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_3
    //   179: invokestatic 1428	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   182: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 1012	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: aload_1
    //   192: astore_3
    //   193: aload_2
    //   194: ifnull -46 -> 148
    //   197: aload_2
    //   198: invokeinterface 1422 1 0
    //   203: aload_1
    //   204: areturn
    //   205: astore_2
    //   206: aconst_null
    //   207: astore_1
    //   208: aload_1
    //   209: ifnull +9 -> 218
    //   212: aload_1
    //   213: invokeinterface 1422 1 0
    //   218: aload_2
    //   219: athrow
    //   220: astore_2
    //   221: goto -13 -> 208
    //   224: astore_3
    //   225: aload_2
    //   226: astore_1
    //   227: aload_3
    //   228: astore_2
    //   229: goto -21 -> 208
    //   232: astore_3
    //   233: aload_1
    //   234: astore_2
    //   235: ldc 104
    //   237: astore_1
    //   238: goto -82 -> 156
    //   241: astore 4
    //   243: aload_2
    //   244: astore_3
    //   245: aload_1
    //   246: astore_2
    //   247: aload_3
    //   248: astore_1
    //   249: aload 4
    //   251: astore_3
    //   252: goto -96 -> 156
    //   255: ldc 104
    //   257: astore_2
    //   258: goto -156 -> 102
    //   261: ldc 104
    //   263: astore_2
    //   264: goto -130 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	EditLocalVideoActivity
    //   0	267	1	paramString	String
    //   6	192	2	localObject1	Object
    //   205	14	2	localObject2	Object
    //   220	6	2	localObject3	Object
    //   228	36	2	localObject4	Object
    //   135	14	3	localObject5	Object
    //   150	29	3	localException1	Exception
    //   192	1	3	str	String
    //   224	4	3	localObject6	Object
    //   232	1	3	localException2	Exception
    //   244	8	3	localObject7	Object
    //   241	9	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   7	48	150	java/lang/Exception
    //   7	48	205	finally
    //   52	102	220	finally
    //   102	134	220	finally
    //   156	191	224	finally
    //   52	102	232	java/lang/Exception
    //   102	134	241	java/lang/Exception
  }
  
  public void a()
  {
    this.jdField_t_of_type_JavaLangString = a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_t_of_type_JavaLangString);
  }
  
  public void a(float paramFloat)
  {
    runOnUiThread(new xty(this, paramFloat));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditLocalVideoActivity", 2, "onFramesClipChanged, startTime=" + paramInt1 + ", endTime=" + paramInt2);
    }
    if (this.jdField_k_of_type_Boolean) {
      LpReportInfo_pf00064.allReport(664, 4, 4);
    }
    runOnUiThread(new xtu(this));
    if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
      runOnUiThread(new xtv(this));
    }
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new xtx(this, paramInt1, paramInt2));
    if (this.jdField_d_of_type_Int == 0) {
      this.jdField_c_of_type_Int = paramInt1;
    }
  }
  
  protected void a(Bundle paramBundle)
  {
    boolean bool = false;
    super.a(paramBundle);
    paramBundle = getIntent();
    this.jdField_t_of_type_Int = paramBundle.getIntExtra("PhotoConst.EDIT_LOCAL_VIDEO_ENTRY", 0);
    this.jdField_p_of_type_JavaLangString = paramBundle.getStringExtra("file_send_path");
    this.jdField_r_of_type_JavaLangString = this.jdField_p_of_type_JavaLangString;
    this.jdField_a_of_type_Long = paramBundle.getLongExtra("PhotoConst.VIDEO_SIZE", 0L);
    this.jdField_b_of_type_Long = paramBundle.getLongExtra("file_send_duration", 0L);
    this.jdField_l_of_type_Int = paramBundle.getIntExtra("file_width", 0);
    this.jdField_m_of_type_Int = paramBundle.getIntExtra("file_height", 0);
    QLog.i("EditLocalVideoActivity", 2, "localVideoWidth: " + this.jdField_l_of_type_Int + " ,    localVideoHeight: " + this.jdField_m_of_type_Int);
    this.jdField_n_of_type_Boolean = paramBundle.getBooleanExtra("is_qzone_vip", false);
    this.v = paramBundle.getStringExtra("topic_id");
    if (!TextUtils.isEmpty(this.v)) {
      bool = true;
    }
    this.jdField_q_of_type_Boolean = bool;
    this.jdField_r_of_type_Boolean = paramBundle.getBooleanExtra("param.topicSyncQzone", this.jdField_r_of_type_Boolean);
    this.jdField_q_of_type_Int = paramBundle.getIntExtra("extra_key_font_id", -1);
    this.jdField_r_of_type_Int = paramBundle.getIntExtra("extra_key_font_format_type", -1);
    this.w = paramBundle.getStringExtra("extra_key_font_url");
    this.jdField_s_of_type_Int = paramBundle.getIntExtra("extra_key_super_font_id", -1);
    this.x = paramBundle.getStringExtra("extra_key_super_font_info");
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1009);
    this.y = paramBundle.getStringExtra("short_video_refer");
    this.z = paramBundle.getStringExtra("set_user_callback");
    a(this.z, this.y);
    this.jdField_d_of_type_Int = ((int)paramBundle.getLongExtra("PhotoConst.EDIT_LOCAL_VIDEO_START_TIME", 0L));
    this.jdField_e_of_type_Int = ((int)paramBundle.getLongExtra("PhotoConst.EDIT_LOCAL_VIDEO_END_TIME", 0L));
    this.jdField_f_of_type_Int = ((int)paramBundle.getLongExtra("PhotoConst.EDIT_LOCAL_VIDEO_DURATION", 0L));
    if (this.jdField_d_of_type_Int != 0) {
      this.jdField_c_of_type_Int = this.jdField_d_of_type_Int;
    }
  }
  
  protected void a(ViewGroup paramViewGroup)
  {
    getLayoutInflater().inflate(2130970415, paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131370399));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131369001));
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)a(2131370405));
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)a(2131370407));
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131370166));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131368626));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131370402));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)a(2131370403));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131370404));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131373556));
    paramViewGroup = new RelativeLayout.LayoutParams(-1, (int)AIOUtils.a(2, 50, getResources()));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getResources().getColor(2131493781));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    paramViewGroup.addRule(12);
    paramViewGroup.bottomMargin = AIOUtils.a(55.0F, getResources());
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText = ((ExtendEditText)a(2131373557));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setEditableFactory(QzoneTextBuilder.b);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131373558));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = a(2131373560);
    e();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.jdField_c_of_type_JavaLangString = paramString1;
    localReportInfo.jdField_d_of_type_JavaLangString = paramString2;
    localReportInfo.jdField_e_of_type_JavaLangString = paramString3;
    paramString1 = "";
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      paramString1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    }
    QZoneClickReport.report(paramString1, localReportInfo, paramBoolean);
  }
  
  public String b(int paramInt)
  {
    int i2 = (int)Math.round(paramInt * 1.0D / 1000.0D);
    paramInt = i2 % 60;
    int i1 = i2 / 60 % 60;
    i2 /= 3600;
    this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    if (i2 > 0) {
      return this.jdField_a_of_type_JavaUtilFormatter.format("%d:%02d:%02d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(paramInt) }).toString();
    }
    return this.jdField_a_of_type_JavaUtilFormatter.format("%02d:%02d", new Object[] { Integer.valueOf(i1), Integer.valueOf(paramInt) }).toString();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (paramInt1 == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
      }
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent.containsKey("permission_code")) {
          this.jdField_a_of_type_Int = paramIntent.getInt("permission_code");
        }
        if (paramIntent.containsKey("uin_list"))
        {
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {
            this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          }
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          localObject = paramIntent.getStringArrayList("uin_list");
          if (localObject != null) {
            this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
          }
        }
        if (a(this.jdField_a_of_type_Int))
        {
          this.jdField_b_of_type_JavaLangString = paramIntent.getString("key_setting_raw_json");
          this.jdField_a_of_type_JavaLangString = paramIntent.getString("key_selected_tag");
        }
        a();
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt1 != 1009) {
          break;
        }
        this.jdField_i_of_type_Boolean = false;
        this.jdField_c_of_type_Boolean = false;
        if (this.jdField_b_of_type_AndroidViewView != null) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
      } while (paramIntent == null);
      Bundle localBundle = paramIntent.getExtras();
      if (localBundle.containsKey("extra_key_bundle_priv_key"))
      {
        paramIntent = localBundle.getBundle("extra_key_bundle_priv_key");
        if (paramIntent != null)
        {
          this.jdField_a_of_type_Int = paramIntent.getInt("permission_code");
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {
            this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          }
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          localObject = paramIntent.getStringArrayList("uin_list");
          if (localObject != null) {
            this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
          }
          if (a(this.jdField_a_of_type_Int))
          {
            this.jdField_b_of_type_JavaLangString = paramIntent.getString("key_setting_raw_json");
            this.jdField_a_of_type_JavaLangString = paramIntent.getString("key_selected_tag");
          }
          a();
        }
      }
      if (localBundle.containsKey("contentIntentKey"))
      {
        localObject = localBundle.getString("contentIntentKey");
        paramIntent = (Intent)localObject;
        if (localObject == null) {
          paramIntent = "";
        }
        this.jdField_u_of_type_JavaLangString = paramIntent;
      }
      if (localBundle.containsKey("contentIntentKeyForVideoEditWithEmo"))
      {
        paramIntent = localBundle.getString("contentIntentKeyForVideoEditWithEmo");
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setText(paramIntent);
      }
      this.jdField_q_of_type_Int = localBundle.getInt("extra_key_font_id", -1);
      this.jdField_r_of_type_Int = localBundle.getInt("extra_key_font_format_type");
      this.w = localBundle.getString("extra_key_font_url");
      this.jdField_s_of_type_Int = localBundle.getInt("extra_key_super_font_id", -1);
      this.x = localBundle.getString("extra_key_super_font_info");
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1009);
      return;
    } while ((paramInt1 != 1010) || (paramInt2 != -1));
    ToastUtil.a().a("开通成功");
    this.jdField_n_of_type_Boolean = true;
  }
  
  public void onBackPressed()
  {
    this.jdField_t_of_type_Boolean = true;
    f();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    Iterator localIterator;
    switch (paramView.getId())
    {
    default: 
    case 2131370405: 
    case 2131370407: 
    case 2131368626: 
    case 2131373558: 
    case 2131370166: 
      do
      {
        return;
        LpReportInfo_pf00064.allReport(664, 3, 1);
        if (this.jdField_e_of_type_Boolean)
        {
          a(true, this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton);
          this.jdField_f_of_type_Boolean = true;
          this.jdField_g_of_type_Boolean = false;
          localObject1 = QzoneConfig.getInstance().getConfig("VideoEdit", "VideoBgMusicSelectUrl", "https://y.qq.com/m/qzone_video/index.html?_wv=1");
          paramView = (View)localObject1;
          if (!TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) {
            paramView = (String)localObject1 + "&songid=" + this.jdField_l_of_type_JavaLangString;
          }
          localObject1 = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", paramView);
          ((Intent)localObject1).putExtra("fromQZone", true);
          ((Intent)localObject1).putExtra("injectrecommend", true);
          ((Intent)localObject1).putExtra("source_name", BaseApplicationImpl.getContext().getString(2131432890));
          ((Intent)localObject1).setData(Uri.parse(paramView));
          startActivity((Intent)localObject1);
          return;
        }
        Toast.makeText(getApplicationContext(), "视频过大，暂不支持添加背景音乐", 1).show();
        return;
        LpReportInfo_pf00064.allReport(664, 4, 1);
        if (this.jdField_d_of_type_Boolean)
        {
          QLog.e("EditLocalVideoActivity", 2, "click clip ");
          paramView = a(this.jdField_o_of_type_JavaLangString, this.jdField_j_of_type_Int, this.jdField_k_of_type_Int, false);
          if (paramView != null) {
            this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramView);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.jdField_c_of_type_Int);
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
            this.jdField_k_of_type_Boolean = true;
            b(true);
            return;
            QLog.e("EditLocalVideoActivity", 2, "click clip but coverview find bitmap is null");
          }
        }
        long l1 = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoDurationThreshold", 90000);
        Toast.makeText(getApplicationContext(), "视频长度超过" + l1 / 1000L + "秒，暂不支持裁剪", 1).show();
        return;
        LpReportInfo_pf00064.allReport(664, 1);
        this.jdField_t_of_type_Boolean = false;
        f();
        return;
        localObject1 = QzoneConfig.getInstance().getConfig("H5Url", "UgcPermitSetting", "https://h5.qzone.qq.com/ugc/setting?_wv=3&type=mood&uin={uin}&qua={qua}&_proxy=1");
        paramView = "";
        if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
          paramView = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
        }
        paramView = ((String)localObject1).replace("{uin}", paramView).replace("{qua}", QUA.a());
        a("608", "6", "0", true);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("permission_code", this.jdField_a_of_type_Int);
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          ((Bundle)localObject1).putStringArrayList("uin_list", this.jdField_a_of_type_JavaUtilArrayList);
          localObject2 = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
          localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext()) {
            ((ArrayList)localObject2).add(a((String)localIterator.next()));
          }
          ((Bundle)localObject1).putStringArrayList("key_nicknames", (ArrayList)localObject2);
        }
        if ((a(this.jdField_a_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
          ((Bundle)localObject1).putString("key_setting_raw_json", this.jdField_b_of_type_JavaLangString);
        }
        QZoneHelper.a(this, paramView, 2, (Bundle)localObject1, "");
        return;
        LpReportInfo_pf00064.allReport(664, 2);
        if (this.jdField_o_of_type_Boolean) {
          if (this.jdField_j_of_type_Boolean)
          {
            this.jdField_p_of_type_Boolean = true;
            paramView = new Bundle();
            paramView.putString("param.content", this.jdField_u_of_type_JavaLangString);
            paramView.putInt("param.priv", this.jdField_a_of_type_Int);
            paramView.putStringArrayList("param.privList", this.jdField_a_of_type_JavaUtilArrayList);
            paramView.putInt("PhotoConst.EDIT_LOCAL_VIDEO_ENTRY", this.jdField_t_of_type_Int);
            paramView.putString("file_send_path", this.jdField_r_of_type_JavaLangString);
            paramView.putString("param.videoPath", this.jdField_p_of_type_JavaLangString);
            paramView.putLong("param.videoSize", this.jdField_a_of_type_Long);
            paramView.putInt("param.videoType", 1);
            paramView.putString("param.thumbnailPath", this.jdField_o_of_type_JavaLangString);
            paramView.putInt("param.thumbnailHeight", this.jdField_k_of_type_Int);
            paramView.putInt("param.thumbnailWidth", this.jdField_j_of_type_Int);
            paramView.putLong("param.startTime", this.jdField_d_of_type_Int);
            paramView.putLong("param.duration", this.jdField_e_of_type_Int - this.jdField_d_of_type_Int);
            paramView.putLong("param.totalDuration", this.jdField_b_of_type_Long);
            paramView.putBoolean("param.needProcess", this.jdField_p_of_type_Boolean);
            paramView.putBoolean("param.isUploadOrigin", this.jdField_o_of_type_Boolean);
            paramView.putString("param.topicId", this.v);
            paramView.putBoolean("param.topicSyncQzone", this.jdField_r_of_type_Boolean);
            paramView.putBoolean("param.isSyncToQQStory", this.jdField_u_of_type_Boolean);
            if (this.jdField_q_of_type_Int >= 0)
            {
              paramView.putInt("extra_key_font_id", this.jdField_q_of_type_Int);
              paramView.putInt("extra_key_font_format_type", this.jdField_r_of_type_Int);
              paramView.putString("extra_key_font_url", this.w);
            }
            if (this.jdField_s_of_type_Int >= 0)
            {
              paramView.putInt("extra_key_super_font_id", this.jdField_s_of_type_Int);
              paramView.putString("extra_key_super_font_info", this.x);
            }
            localObject1 = new Bundle();
            ((Bundle)localObject1).putInt("sv_encode_max_bitrate", CodecParam.jdField_r_of_type_Int);
            ((Bundle)localObject1).putInt("sv_encode_min_bitrate", CodecParam.jdField_s_of_type_Int);
            ((Bundle)localObject1).putInt("sv_encode_qmax", CodecParam.jdField_t_of_type_Int);
            ((Bundle)localObject1).putInt("sv_encode_qmin", CodecParam.u);
            ((Bundle)localObject1).putInt("sv_encode_qmaxdiff", CodecParam.v);
            ((Bundle)localObject1).putInt("sv_encode_ref_frame", CodecParam.w);
            ((Bundle)localObject1).putInt("sv_encode_smooth", CodecParam.x);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
                ((Bundle)localObject1).putInt("sv_total_frame_count", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex());
              }
              ((Bundle)localObject1).putInt("sv_total_record_time", (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
            }
            ((Bundle)localObject1).putInt("param.uploadEntrance", 201);
            paramView.putBundle("param.extras", (Bundle)localObject1);
            if ((this.jdField_t_of_type_Int != 1) || (this.jdField_j_of_type_Boolean) || (this.jdField_r_of_type_JavaLangString == null) || (!this.jdField_r_of_type_JavaLangString.equals(this.jdField_p_of_type_JavaLangString))) {
              break label1422;
            }
            paramView.putBoolean("PhotoConst.EDIT_LOCAL_VIDEO_DONOTHING_RETURN", true);
          }
        }
        for (;;)
        {
          l1 = QzoneConfig.getInstance().getConfig("VideoEdit", "UploadMaxSizeTipWithNoWifi", 20971520L);
          if ((NetworkUtil.b(BaseApplication.getContext()) == 1) || (this.jdField_a_of_type_Long <= l1)) {
            break label1457;
          }
          if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
            break label1439;
          }
          localObject1 = "当前视频超过" + l1 / 1024L / 1024L + "M，将会消耗你的手机流量";
          this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this);
          this.jdField_a_of_type_ComTencentWidgetActionSheet.a((CharSequence)localObject1);
          this.jdField_a_of_type_ComTencentWidgetActionSheet.a("立即上传", 0);
          this.jdField_a_of_type_ComTencentWidgetActionSheet.d("取消");
          this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new xuo(this, paramView));
          this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new xup(this));
          this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
          return;
          this.jdField_p_of_type_Boolean = false;
          break;
          l1 = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoDurationThreshold", 90000);
          if (this.jdField_j_of_type_Boolean)
          {
            this.jdField_p_of_type_Boolean = true;
            break;
          }
          if (this.jdField_b_of_type_Long > l1)
          {
            this.jdField_p_of_type_Boolean = false;
            break;
          }
          this.jdField_p_of_type_Boolean = true;
          break;
          a("608", "1", "0", true);
        }
      } while (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing());
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
      if (!this.jdField_h_of_type_Boolean)
      {
        b(paramView);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface != null) && ("ref_h5_record_video".equals(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface.a())))
      {
        localObject1 = new Intent("com.qzone.h5.video.recordCallback");
        ((Intent)localObject1).putExtras(paramView);
        BaseApplication.getContext().sendBroadcast((Intent)localObject1);
      }
      for (;;)
      {
        if (this.jdField_t_of_type_Int == 0) {
          setResult(-1);
        }
        finish();
        return;
        if (this.jdField_t_of_type_Int == 0)
        {
          RemoteHandleManager.a().a("cmd.publishVideoMood", paramView, false);
        }
        else if (this.jdField_t_of_type_Int == 1)
        {
          localObject1 = new Intent(getIntent());
          ((Intent)localObject1).putExtras(paramView);
          paramView = ((Intent)localObject1).getStringExtra("PhotoConst.PLUGIN_APK");
          boolean bool = ((Intent)localObject1).getBooleanExtra("DirectBackToQzone", false);
          if (("qzone_plugin.apk".equals(paramView)) && (bool))
          {
            ((Intent)localObject1).setFlags(603979776);
            QZoneHelper.a(this, "", (Intent)localObject1, -1);
          }
        }
      }
    case 2131373557: 
      this.jdField_i_of_type_Boolean = true;
      this.jdField_l_of_type_Boolean = true;
      this.jdField_c_of_type_Boolean = true;
      a("608", "5", "0", true);
      localObject1 = QZoneHelper.UserInfo.a();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("permission_code", this.jdField_a_of_type_Int);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        ((Bundle)localObject2).putStringArrayList("uin_list", this.jdField_a_of_type_JavaUtilArrayList);
        paramView = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          paramView.add(a((String)localIterator.next()));
        }
        ((Bundle)localObject2).putStringArrayList("key_nicknames", paramView);
      }
      if ((a(this.jdField_a_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
        ((Bundle)localObject2).putString("key_setting_raw_json", this.jdField_b_of_type_JavaLangString);
      }
      if (this.jdField_b_of_type_AndroidViewView == null)
      {
        this.jdField_b_of_type_AndroidViewView = new View(this);
        this.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.argb(128, 0, 0, 0));
        this.jdField_b_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidViewView);
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      paramView = "";
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText != null) {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.getText().toString();
      }
      if (this.jdField_q_of_type_Boolean) {}
      for (int i1 = 0;; i1 = 1)
      {
        QZoneHelper.a(this, (QZoneHelper.UserInfo)localObject1, 1009, "", paramView, "", "", 0, i1, 1, 0, 0, 0, "", 10000, (Bundle)localObject2, this.jdField_q_of_type_Boolean, this.jdField_r_of_type_Boolean, this.jdField_q_of_type_Int, this.jdField_s_of_type_Int, false);
        return;
      }
    case 2131370402: 
    case 2131370403: 
      if (!this.jdField_n_of_type_Boolean)
      {
        g();
        return;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        ToastUtil.a().a("不使用原画");
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130845380);
        this.jdField_o_of_type_Boolean = false;
        return;
      }
      ToastUtil.a().a("使用原画");
      a("608", "7", "1", true);
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130845379);
      this.jdField_o_of_type_Boolean = true;
      return;
    case 2131370177: 
      label1422:
      label1439:
      label1457:
      LpReportInfo_pf00064.allReport(664, 4, 2);
      i();
      return;
    }
    LpReportInfo_pf00064.allReport(664, 4, 3);
    a("608", "4", "1", true);
    QzoneHandlerThreadFactory.getHandlerThread("RealTime_HandlerThread").post(new xuq(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.getWindow().addFlags(128);
    p();
    this.W = true;
    this.X = false;
    super.onCreate(paramBundle);
    d();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").removeTask(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    QzoneGuideBubbleHelper.a().a();
  }
  
  protected void onPause()
  {
    super.onPause();
    if (!TextUtils.isEmpty(this.jdField_s_of_type_JavaLangString))
    {
      if (this.jdField_k_of_type_Boolean) {
        break label29;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
    }
    label29:
    while (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.isPlaying()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.jdField_f_of_type_Boolean)
    {
      LpReportInfo_pf00064.allReport(664, 3, 2);
      this.jdField_f_of_type_Boolean = false;
    }
    j();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView != null)
    {
      if (!this.jdField_k_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.jdField_d_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.start();
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        a(false, this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton);
      }
    }
    else {
      return;
    }
    Bitmap localBitmap = a(this.jdField_o_of_type_JavaLangString, this.jdField_j_of_type_Int, this.jdField_k_of_type_Int, false);
    if (localBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
    b(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity
 * JD-Core Version:    0.7.0.1
 */