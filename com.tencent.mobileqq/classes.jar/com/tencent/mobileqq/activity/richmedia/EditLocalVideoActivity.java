package com.tencent.mobileqq.activity.richmedia;

import aekt;
import ajju;
import ajjv;
import ajjw;
import ajjx;
import ajjy;
import ajjz;
import ajka;
import ajkb;
import ajkc;
import ajkd;
import ajke;
import ajkf;
import ajkg;
import ajkh;
import ajki;
import ajkj;
import ajkk;
import ajkm;
import ajlk;
import ajni;
import ajqx;
import ajra;
import ajrb;
import ajrp;
import alpo;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
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
import azds;
import azhe;
import azmz;
import baiv;
import bdcd;
import bdcs;
import bdee;
import bdfq;
import bfhq;
import bhpy;
import bizf;
import bizg;
import bizm;
import bizt;
import bjdq;
import bjfh;
import bjmn;
import bjps;
import bjqi;
import bjri;
import bjsb;
import bjwq;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.maxvideo.common.GlobalInit;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar;
import com.tencent.mobileqq.activity.richmedia.view.ExtendEditText;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.ShortVideoSoLoad;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
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
  implements ajrp, View.OnClickListener
{
  public static String a;
  private static final String jdField_d_of_type_JavaLangString = "/tencent" + File.separator + "video_edit_music_download" + File.separator;
  private static final String jdField_f_of_type_JavaLangString = "/tencent" + File.separator + "video_edit_music" + File.separator;
  private static String jdField_g_of_type_JavaLangString;
  private static final boolean jdField_q_of_type_Boolean;
  public int a;
  private long jdField_a_of_type_Long;
  private ajkk jdField_a_of_type_Ajkk = new ajkk(this);
  private ajkm jdField_a_of_type_Ajkm;
  private ajlk jdField_a_of_type_Ajlk;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bdfq jdField_a_of_type_Bdfq;
  private bhpy jdField_a_of_type_Bhpy;
  private PressDarkImageButton jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  public RMVideoStateMgr a;
  private FixedSizeVideoView jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView;
  private VideoFrameSelectBar jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar;
  private ExtendEditText jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText;
  private QzoneVerticalVideoTopicInfo jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  public ArrayList<String> a;
  private Formatter jdField_a_of_type_JavaUtilFormatter = new Formatter(this.jdField_a_of_type_JavaLangStringBuilder, Locale.getDefault());
  boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private PressDarkImageButton jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private String jdField_h_of_type_JavaLangString;
  private int jdField_i_of_type_Int;
  private String jdField_i_of_type_JavaLangString;
  private int jdField_j_of_type_Int;
  private String jdField_j_of_type_JavaLangString;
  private int jdField_k_of_type_Int;
  private String jdField_k_of_type_JavaLangString;
  private boolean jdField_k_of_type_Boolean = true;
  private int jdField_l_of_type_Int = 2;
  private String jdField_l_of_type_JavaLangString = "";
  private boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int = -1;
  private String jdField_m_of_type_JavaLangString;
  private boolean jdField_m_of_type_Boolean;
  private int jdField_n_of_type_Int = -1;
  private String jdField_n_of_type_JavaLangString;
  private boolean jdField_n_of_type_Boolean;
  private int jdField_o_of_type_Int = -1;
  private String jdField_o_of_type_JavaLangString;
  private boolean jdField_o_of_type_Boolean;
  private int jdField_p_of_type_Int = 0;
  private String jdField_p_of_type_JavaLangString;
  private boolean jdField_p_of_type_Boolean = true;
  private String jdField_q_of_type_JavaLangString;
  private boolean r;
  private boolean s;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajni.jdField_a_of_type_JavaLangString + jdField_d_of_type_JavaLangString;
    jdField_g_of_type_JavaLangString = ajni.jdField_a_of_type_JavaLangString + jdField_f_of_type_JavaLangString;
    if (Build.VERSION.SDK_INT >= 10) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_q_of_type_Boolean = bool;
      return;
    }
  }
  
  public EditLocalVideoActivity()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = RMVideoStateMgr.a();
  }
  
  private void A()
  {
    this.jdField_a_of_type_Ajkk.removeMessages(9999);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_k_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
    this.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
    long l1 = this.jdField_b_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("EditLocalVideoActivity", 2, "initData, videoPath=" + this.jdField_k_of_type_JavaLangString + ", videoSize=" + this.jdField_c_of_type_Long + ", duration:" + l1);
    }
    this.jdField_l_of_type_Int = 2;
    if (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString))
    {
      int i1 = ajra.a(this.jdField_k_of_type_JavaLangString);
      if (i1 != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EditLocalVideoActivity", 2, "format is not supported ret=" + i1);
        }
        bjsb.a(String.valueOf(this.jdField_d_of_type_Long), "qzone_video_trim", "10", null);
        this.jdField_k_of_type_JavaLangString = null;
        this.jdField_a_of_type_Ajkk.sendEmptyMessage(1101);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "setVideoPath:" + this.jdField_k_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setVideoPath(this.jdField_k_of_type_JavaLangString);
      this.jdField_a_of_type_Ajkk.sendEmptyMessageDelayed(9999, 10000L);
      return;
    }
    setResult(0);
    finish();
  }
  
  private void B()
  {
    jdField_a_of_type_JavaLangString = ajni.jdField_a_of_type_JavaLangString + jdField_d_of_type_JavaLangString;
    jdField_g_of_type_JavaLangString = ajni.jdField_a_of_type_JavaLangString + jdField_f_of_type_JavaLangString;
    try
    {
      Object localObject = new ArrayList();
      Collections.addAll((Collection)localObject, new String[] { jdField_a_of_type_JavaLangString, jdField_g_of_type_JavaLangString });
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        File localFile = new File(str);
        if ((!localFile.exists()) && (localFile.mkdirs())) {
          QZLog.d("EditLocalVideoActivity", 2, new Object[] { "assertSdcardExit create directory ", str });
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("EditLocalVideoActivity", 2, "assertSdcardExit exception", localException);
      bdcs.c(jdField_g_of_type_JavaLangString + ".nomedia");
    }
  }
  
  private void C()
  {
    this.jdField_d_of_type_Long = getAppRuntime().getLongAccountUin();
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
    //   2: new 361	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 362	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_1
    //   12: ifnull +47 -> 59
    //   15: aload_2
    //   16: astore_0
    //   17: aload_1
    //   18: getfield 365	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   21: ifeq +38 -> 59
    //   24: aload_2
    //   25: astore_0
    //   26: new 367	java/io/BufferedInputStream
    //   29: dup
    //   30: aload_2
    //   31: sipush 2048
    //   34: invokespecial 370	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   37: aconst_null
    //   38: aload_1
    //   39: invokestatic 376	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   42: astore_1
    //   43: aload_1
    //   44: astore_0
    //   45: aload_0
    //   46: astore_1
    //   47: aload_2
    //   48: ifnull +9 -> 57
    //   51: aload_2
    //   52: invokevirtual 381	java/io/InputStream:close	()V
    //   55: aload_0
    //   56: astore_1
    //   57: aload_1
    //   58: areturn
    //   59: aload_2
    //   60: astore_0
    //   61: new 367	java/io/BufferedInputStream
    //   64: dup
    //   65: aload_2
    //   66: sipush 8192
    //   69: invokespecial 370	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   72: aconst_null
    //   73: aload_1
    //   74: invokestatic 376	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   77: astore_1
    //   78: aload_1
    //   79: astore_0
    //   80: goto -35 -> 45
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_2
    //   86: aload_2
    //   87: astore_0
    //   88: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +14 -> 105
    //   94: aload_2
    //   95: astore_0
    //   96: ldc 186
    //   98: iconst_2
    //   99: ldc 111
    //   101: aload_1
    //   102: invokestatic 383	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   105: aload_3
    //   106: astore_1
    //   107: aload_2
    //   108: ifnull -51 -> 57
    //   111: aload_2
    //   112: invokevirtual 381	java/io/InputStream:close	()V
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
    //   125: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +14 -> 142
    //   131: aload_2
    //   132: astore_0
    //   133: ldc 186
    //   135: iconst_2
    //   136: ldc 111
    //   138: aload_1
    //   139: invokestatic 383	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   142: aload_3
    //   143: astore_1
    //   144: aload_2
    //   145: ifnull -88 -> 57
    //   148: aload_2
    //   149: invokevirtual 381	java/io/InputStream:close	()V
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
    //   165: invokevirtual 381	java/io/InputStream:close	()V
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
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    a("608", "2", "0", true);
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.stopPlayback();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.c();
    }
    if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
    }
    c(8);
    setResult(paramInt);
    finish();
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent;
    if ((this.jdField_a_of_type_Ajlk != null) && ("ref_h5_record_video".equals(this.jdField_a_of_type_Ajlk.a())))
    {
      localIntent = new Intent("com.qzone.h5.video.recordCallback");
      localIntent.putExtras(paramBundle);
      BaseApplication.getContext().sendBroadcast(localIntent);
    }
    for (;;)
    {
      if (this.jdField_p_of_type_Int == 0) {
        setResult(-1);
      }
      finish();
      return;
      if (this.jdField_p_of_type_Int == 0)
      {
        bjmn.a().a("cmd.publishVideoMood", paramBundle, false);
      }
      else if (this.jdField_p_of_type_Int == 1)
      {
        localIntent = new Intent(getIntent());
        localIntent.putExtras(paramBundle);
        paramBundle = localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
        boolean bool = localIntent.getBooleanExtra("DirectBackToQzone", false);
        if (("qzone_plugin.apk".equals(paramBundle)) && (bool))
        {
          localIntent.setFlags(603979776);
          bizm.a(this, "", localIntent, -1);
        }
      }
    }
  }
  
  private void a(Message paramMessage)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {}
    try
    {
      paramMessage = (String)paramMessage.obj;
      int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.getWidth();
      int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.getHeight();
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "VIDEO_SHOW_COVER, filename=" + paramMessage + ", w=" + i1 + ", h=" + i2);
      }
      this.jdField_b_of_type_AndroidGraphicsBitmap = a(paramMessage, i1, i2, false);
      if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
      {
        ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        localLayoutParams.height = i2;
        localLayoutParams.width = i1;
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
        if (this.jdField_g_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        this.jdField_f_of_type_Int = i1;
        this.jdField_g_of_type_Int = i2;
        this.jdField_h_of_type_JavaLangString = paramMessage;
      }
      return;
    }
    catch (Throwable paramMessage)
    {
      QLog.w("EditLocalVideoActivity", 2, "VIDEO_SHOW_COVER failed", paramMessage);
    }
  }
  
  private void a(String paramString)
  {
    String str = getResources().getString(2131718491);
    bizm.a(this, bizt.a(), paramString, this.jdField_d_of_type_Long, "", 1010, str, false);
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
          if ((paramString1 instanceof ajlk))
          {
            this.jdField_a_of_type_Ajlk = ((ajlk)paramString1);
            this.jdField_a_of_type_Ajlk.d_(paramString2);
            return;
          }
        }
        catch (Throwable paramString1)
        {
          this.jdField_a_of_type_Ajlk = null;
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
    azmz.a(BaseApplicationImpl.getContext()).a(String.valueOf(this.jdField_d_of_type_Long), paramString1, true, 0L, 0L, localHashMap, null);
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
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 16) || (paramInt == 128);
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  private static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return alpo.a(2131704044);
    case 1: 
      return alpo.a(2131704020);
    case 4: 
      return alpo.a(2131704037);
    case 16: 
      return alpo.a(2131704031);
    case 64: 
      return alpo.a(2131704042);
    }
    return alpo.a(2131704028);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    QzoneHandlerThreadFactory.getHandlerThread("RealTime_HandlerThread").post(new EditLocalVideoActivity.18(this, paramInt1, paramInt2));
  }
  
  private void b(boolean paramBoolean)
  {
    int i3 = 8;
    int i2 = 0;
    this.jdField_g_of_type_Boolean = paramBoolean;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar;
    int i1;
    if (paramBoolean)
    {
      i1 = 0;
      ((VideoFrameSelectBar)localObject).setVisibility(i1);
      localObject = this.jdField_e_of_type_AndroidWidgetRelativeLayout;
      if (!paramBoolean) {
        break label174;
      }
      i1 = 0;
      label41:
      ((RelativeLayout)localObject).setVisibility(i1);
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label180;
      }
      i1 = 0;
      label59:
      ((ImageView)localObject).setVisibility(i1);
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label186;
      }
      i1 = 0;
      label77:
      ((ImageView)localObject).setVisibility(i1);
      localObject = this.jdField_a_of_type_AndroidViewViewGroup;
      if (!paramBoolean) {
        break label192;
      }
      i1 = 8;
      label96:
      ((ViewGroup)localObject).setVisibility(i1);
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        localObject = this.jdField_c_of_type_AndroidViewView;
        if (!paramBoolean) {
          break label197;
        }
        i1 = i3;
        label122:
        ((View)localObject).setVisibility(i1);
      }
      if (this.jdField_p_of_type_Int != 0) {
        break label202;
      }
      c(paramBoolean);
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
      label174:
      i1 = 8;
      break label41;
      label180:
      i1 = 8;
      break label59;
      label186:
      i1 = 8;
      break label77;
      label192:
      i1 = 0;
      break label96;
      label197:
      i1 = 0;
      break label122;
      label202:
      if (this.jdField_p_of_type_Int == 1) {
        c(true);
      }
    }
  }
  
  private boolean b()
  {
    if (!bjdq.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("EditLocalVideoActivity", 2, "isEnoughStorage() sdcard not mounted");
      }
      bjsb.a(String.valueOf(this.jdField_d_of_type_Long), "qzone_video_trim", "6", null);
    }
    long l1 = bjps.a(this.jdField_k_of_type_JavaLangString);
    if (l1 <= 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "no file size");
      }
      bjsb.a(String.valueOf(this.jdField_d_of_type_Long), "qzone_video_trim", "7", null);
      return false;
    }
    if (l1 / this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.getDuration() * (this.jdField_d_of_type_Int - this.jdField_c_of_type_Int) > bjdq.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "there is not enough space on sdcard");
      }
      bjsb.a(String.valueOf(this.jdField_d_of_type_Long), "qzone_video_trim", "8", null);
      return false;
    }
    return true;
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setVisibility(paramInt);
    }
    if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(paramInt);
    }
    if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(paramInt);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    int i2 = 8;
    Object localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    if (paramBoolean)
    {
      i1 = 8;
      ((RelativeLayout)localObject).setVisibility(i1);
      localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      if (!paramBoolean) {
        break label109;
      }
      i1 = 0;
      label34:
      ((RelativeLayout)localObject).setBackgroundColor(i1);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText;
      if (!paramBoolean) {
        break label123;
      }
      i1 = 8;
      label53:
      ((ExtendEditText)localObject).setVisibility(i1);
      localObject = this.jdField_a_of_type_AndroidWidgetButton;
      if ((!paramBoolean) && (!this.jdField_o_of_type_Boolean)) {
        break label128;
      }
      i1 = 8;
      label79:
      ((Button)localObject).setVisibility(i1);
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label133;
      }
    }
    label128:
    label133:
    for (int i1 = i2;; i1 = 0)
    {
      ((View)localObject).setVisibility(i1);
      return;
      i1 = 0;
      break;
      label109:
      i1 = getResources().getColor(2131166374);
      break label34;
      label123:
      i1 = 0;
      break label53;
      i1 = 0;
      break label79;
    }
  }
  
  private boolean c()
  {
    return "cover_mall_record_video".equals(this.jdField_p_of_type_JavaLangString);
  }
  
  private void e()
  {
    new AlertDialog.Builder(this).setMessage(alpo.a(2131704038)).setNegativeButton(2131694205, new ajju(this)).setCancelable(false).show();
  }
  
  private void f()
  {
    a("play_local_video", "play_local_video_success", "1", Build.MODEL);
    try
    {
      new AlertDialog.Builder(this).setMessage(alpo.a(2131704036)).setNegativeButton(2131694205, new ajkd(this)).setCancelable(false).create().show();
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.isPlaying()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setPlayDuration(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int - this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.start();
    this.jdField_f_of_type_Boolean = true;
  }
  
  private void h()
  {
    Typeface localTypeface = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setTextEffect(this.jdField_o_of_type_JavaLangString);
    String str = bjfh.a(this.jdField_m_of_type_Int, null, null, null);
    if (TextUtils.isEmpty(str)) {
      this.jdField_m_of_type_Int = -1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setTypeface(localTypeface);
      return;
      localTypeface = Typeface.createFromFile(str);
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.d();
    }
    this.jdField_a_of_type_Ajkk.removeMessages(9999);
  }
  
  private void j()
  {
    boolean bool = false;
    C();
    Intent localIntent = getIntent();
    this.jdField_p_of_type_Int = localIntent.getIntExtra("PhotoConst.EDIT_LOCAL_VIDEO_ENTRY", 0);
    this.jdField_i_of_type_JavaLangString = localIntent.getStringExtra("file_send_path");
    if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))
    {
      if (!new File(this.jdField_i_of_type_JavaLangString).exists())
      {
        QLog.e("EditLocalVideoActivity", 2, "localVideoPath not exists : " + this.jdField_i_of_type_JavaLangString);
        bfhq.a().a(alpo.a(2131704040));
        finish();
      }
    }
    else
    {
      QLog.e("EditLocalVideoActivity", 2, "localVideoPath is null : " + this.jdField_i_of_type_JavaLangString);
      bfhq.a().a(alpo.a(2131704034));
      finish();
      return;
    }
    this.jdField_j_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
    this.jdField_a_of_type_Long = localIntent.getLongExtra("PhotoConst.VIDEO_SIZE", 0L);
    this.jdField_b_of_type_Long = localIntent.getLongExtra("file_send_duration", 0L);
    this.jdField_h_of_type_Int = localIntent.getIntExtra("file_width", 0);
    this.jdField_i_of_type_Int = localIntent.getIntExtra("file_height", 0);
    QLog.i("EditLocalVideoActivity", 2, "localVideoWidth: " + this.jdField_h_of_type_Int + " ,    localVideoHeight: " + this.jdField_i_of_type_Int);
    this.jdField_l_of_type_Boolean = localIntent.getBooleanExtra("is_qzone_vip", false);
    this.jdField_m_of_type_JavaLangString = localIntent.getStringExtra("topic_id");
    if (!TextUtils.isEmpty(this.jdField_m_of_type_JavaLangString)) {
      bool = true;
    }
    this.jdField_o_of_type_Boolean = bool;
    this.jdField_p_of_type_Boolean = localIntent.getBooleanExtra("param.topicSyncQzone", this.jdField_p_of_type_Boolean);
    this.jdField_m_of_type_Int = localIntent.getIntExtra("extra_key_font_id", -1);
    this.jdField_n_of_type_Int = localIntent.getIntExtra("extra_key_font_format_type", -1);
    this.jdField_n_of_type_JavaLangString = localIntent.getStringExtra("extra_key_font_url");
    this.jdField_o_of_type_Int = localIntent.getIntExtra("extra_key_super_font_id", -1);
    this.jdField_o_of_type_JavaLangString = localIntent.getStringExtra("extra_key_super_font_info");
    this.jdField_a_of_type_Ajkk.sendEmptyMessage(1009);
    this.jdField_p_of_type_JavaLangString = localIntent.getStringExtra("short_video_refer");
    this.jdField_q_of_type_JavaLangString = localIntent.getStringExtra("set_user_callback");
    a(this.jdField_q_of_type_JavaLangString, this.jdField_p_of_type_JavaLangString);
    this.jdField_c_of_type_Int = ((int)localIntent.getLongExtra("PhotoConst.EDIT_LOCAL_VIDEO_START_TIME", 0L));
    this.jdField_d_of_type_Int = ((int)localIntent.getLongExtra("PhotoConst.EDIT_LOCAL_VIDEO_END_TIME", 0L));
    this.jdField_e_of_type_Int = ((int)localIntent.getLongExtra("PhotoConst.EDIT_LOCAL_VIDEO_DURATION", 0L));
    if (this.jdField_c_of_type_Int != 0) {
      this.jdField_b_of_type_Int = this.jdField_c_of_type_Int;
    }
    this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo = ((QzoneVerticalVideoTopicInfo)localIntent.getParcelableExtra("key_qzone_topic"));
  }
  
  private void k()
  {
    URLImageView localURLImageView;
    if (this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo != null)
    {
      this.jdField_c_of_type_AndroidViewView = a(2131378133);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      ((TextView)a(2131378975)).setText(this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.e());
      localURLImageView = (URLImageView)a(2131368841);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.g())) {
        localURLImageView.setBackgroundURL(this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.g());
      }
    }
    else
    {
      return;
    }
    localURLImageView.setVisibility(8);
  }
  
  private void l()
  {
    int i1 = bjri.a(this, this);
    if (i1 <= 0) {}
    do
    {
      return;
      localObject = findViewById(2131373454);
    } while ((localObject == null) || (!(((View)localObject).getLayoutParams() instanceof RelativeLayout.LayoutParams)));
    Object localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = (i1 + ((RelativeLayout.LayoutParams)localObject).height);
  }
  
  private void m()
  {
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.performClick();
      return;
    }
    if (this.jdField_a_of_type_Bdfq == null) {
      this.jdField_a_of_type_Bdfq = bdcd.a(this, 230, alpo.a(2131704032), null, getString(2131693165), getString(2131690648), new ajke(this), new ajkf(this));
    }
    this.jdField_a_of_type_Bdfq.show();
  }
  
  private void n()
  {
    this.jdField_a_of_type_Ajkm.a(this.jdField_b_of_type_Long, this.jdField_i_of_type_JavaLangString);
    this.jdField_a_of_type_Ajkm.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    this.jdField_a_of_type_Ajkm.a(new ajkg(this));
    this.jdField_a_of_type_Ajkm.a(new ajkh(this));
    this.jdField_a_of_type_Ajkm.a();
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_Ajkm == null)
    {
      this.jdField_a_of_type_Ajkm = ajkm.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView, this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo, this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton);
      return;
    }
    QZLog.i("EditLocalVideoActivity", 2, "use old music mixer");
  }
  
  private void p()
  {
    if (!a(this.jdField_i_of_type_JavaLangString)) {
      bfhq.a().a("视频文件不存在");
    }
    Bundle localBundle;
    label536:
    label827:
    label834:
    label851:
    do
    {
      return;
      LpReportInfo_pf00064.allReport(664, 2);
      Object localObject;
      int i1;
      if (this.jdField_m_of_type_Boolean) {
        if (this.jdField_f_of_type_Boolean)
        {
          this.jdField_n_of_type_Boolean = true;
          localBundle = new Bundle();
          localBundle.putString("param.content", this.jdField_l_of_type_JavaLangString);
          localBundle.putInt("param.priv", this.jdField_a_of_type_Int);
          localBundle.putStringArrayList("param.privList", this.jdField_a_of_type_JavaUtilArrayList);
          localBundle.putInt("PhotoConst.EDIT_LOCAL_VIDEO_ENTRY", this.jdField_p_of_type_Int);
          localBundle.putString("file_send_path", this.jdField_j_of_type_JavaLangString);
          localBundle.putString("param.videoPath", this.jdField_i_of_type_JavaLangString);
          localBundle.putLong("param.videoSize", this.jdField_a_of_type_Long);
          localBundle.putInt("param.videoType", 1);
          localBundle.putString("param.thumbnailPath", this.jdField_h_of_type_JavaLangString);
          localBundle.putInt("param.thumbnailHeight", this.jdField_g_of_type_Int);
          localBundle.putInt("param.thumbnailWidth", this.jdField_f_of_type_Int);
          localBundle.putLong("param.startTime", this.jdField_c_of_type_Int);
          localBundle.putLong("param.duration", this.jdField_d_of_type_Int - this.jdField_c_of_type_Int);
          localBundle.putLong("param.totalDuration", this.jdField_b_of_type_Long);
          localBundle.putBoolean("param.needProcess", this.jdField_n_of_type_Boolean);
          localBundle.putBoolean("param.isUploadOrigin", this.jdField_m_of_type_Boolean);
          localBundle.putString("param.topicId", this.jdField_m_of_type_JavaLangString);
          localBundle.putBoolean("param.topicSyncQzone", this.jdField_p_of_type_Boolean);
          localBundle.putBoolean("param.isSyncToQQStory", this.s);
          localBundle.putParcelable("param.QzoneTopic", this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo);
          if (this.jdField_m_of_type_Int >= 0)
          {
            localBundle.putInt("extra_key_font_id", this.jdField_m_of_type_Int);
            localBundle.putInt("extra_key_font_format_type", this.jdField_n_of_type_Int);
            localBundle.putString("extra_key_font_url", this.jdField_n_of_type_JavaLangString);
          }
          if (this.jdField_o_of_type_Int >= 0)
          {
            localBundle.putInt("extra_key_super_font_id", this.jdField_o_of_type_Int);
            localBundle.putString("extra_key_super_font_info", this.jdField_o_of_type_JavaLangString);
          }
          localObject = new Bundle();
          ((Bundle)localObject).putInt("sv_encode_max_bitrate", azds.r);
          ((Bundle)localObject).putInt("sv_encode_min_bitrate", azds.s);
          ((Bundle)localObject).putInt("sv_encode_qmax", azds.t);
          ((Bundle)localObject).putInt("sv_encode_qmin", azds.u);
          ((Bundle)localObject).putInt("sv_encode_qmaxdiff", azds.v);
          ((Bundle)localObject).putInt("sv_encode_ref_frame", azds.w);
          ((Bundle)localObject).putInt("sv_encode_smooth", azds.x);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
              ((Bundle)localObject).putInt("sv_total_frame_count", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex());
            }
            ((Bundle)localObject).putInt("sv_total_record_time", (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
          }
          i1 = 201;
          if (this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo != null)
          {
            if (!this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.a()) {
              break label827;
            }
            i1 = 213;
          }
          ((Bundle)localObject).putInt("param.uploadEntrance", i1);
          localBundle.putBundle("param.extras", (Bundle)localObject);
          if ((this.jdField_p_of_type_Int != 1) || (this.jdField_f_of_type_Boolean) || (this.jdField_j_of_type_JavaLangString == null) || (!this.jdField_j_of_type_JavaLangString.equals(this.jdField_i_of_type_JavaLangString))) {
            break label834;
          }
          localBundle.putBoolean("PhotoConst.EDIT_LOCAL_VIDEO_DONOTHING_RETURN", true);
        }
      }
      for (;;)
      {
        long l1 = QzoneConfig.getInstance().getConfig("VideoEdit", "UploadMaxSizeTipWithNoWifi", 20971520L);
        if ((bdee.b(BaseApplication.getContext()) == 1) || (this.jdField_a_of_type_Long <= l1)) {
          break label869;
        }
        if (this.jdField_a_of_type_Bhpy != null) {
          break label851;
        }
        localObject = alpo.a(2131704033) + l1 / 1024L / 1024L + alpo.a(2131704039);
        this.jdField_a_of_type_Bhpy = bhpy.a(this);
        this.jdField_a_of_type_Bhpy.a((CharSequence)localObject);
        this.jdField_a_of_type_Bhpy.a("立即上传", 0);
        this.jdField_a_of_type_Bhpy.c(2131690648);
        this.jdField_a_of_type_Bhpy.a(new ajki(this, localBundle));
        this.jdField_a_of_type_Bhpy.a(new ajkj(this));
        this.jdField_a_of_type_Bhpy.show();
        return;
        this.jdField_n_of_type_Boolean = false;
        break;
        l1 = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoDurationThreshold", 90000);
        if (this.jdField_f_of_type_Boolean)
        {
          this.jdField_n_of_type_Boolean = true;
          break;
        }
        if (this.jdField_b_of_type_Long > l1)
        {
          this.jdField_n_of_type_Boolean = false;
          break;
        }
        this.jdField_n_of_type_Boolean = true;
        break;
        i1 = 214;
        break label536;
        a("608", "1", "0", true);
      }
    } while (this.jdField_a_of_type_Bhpy.isShowing());
    this.jdField_a_of_type_Bhpy.show();
    return;
    label869:
    a(localBundle);
  }
  
  private void q()
  {
    if ((this.jdField_a_of_type_Ajkm != null) && (this.jdField_a_of_type_Ajkm.b()))
    {
      r();
      return;
    }
    p();
  }
  
  private void r()
  {
    this.jdField_a_of_type_Ajkm.a(new ajjv(this));
  }
  
  private void s()
  {
    bizm.a(this, new ajjw(this));
  }
  
  private void t()
  {
    int i2 = 0;
    int i3 = (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.a();
    int i4 = (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.b();
    if (!b())
    {
      Toast.makeText(MobileQQ.getContext(), alpo.a(2131704029), 1).show();
      return;
    }
    this.jdField_n_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("EditLocalVideoActivity", 2, "toPublishMood, startTime=" + i3 + ", endTime=" + i4 + ", duration=" + (i4 - i3));
    }
    Object localObject = "";
    Bitmap localBitmap;
    int i1;
    if (jdField_q_of_type_Boolean)
    {
      localObject = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject).setDataSource(this.jdField_k_of_type_JavaLangString);
      localBitmap = ((MediaMetadataRetriever)localObject).getFrameAtTime(i3 * 1000L);
      ((MediaMetadataRetriever)localObject).release();
      localObject = "";
      i1 = 0;
    }
    for (;;)
    {
      if (localBitmap != null)
      {
        localObject = ajqx.jdField_a_of_type_JavaLangString + File.separator + System.currentTimeMillis() + ".jpg";
        if (bjqi.a(localBitmap, (String)localObject, Bitmap.CompressFormat.JPEG, 90, true))
        {
          i2 = localBitmap.getWidth();
          i1 = localBitmap.getHeight();
        }
      }
      for (;;)
      {
        ajqx.b();
        this.jdField_c_of_type_Int = i3;
        this.jdField_d_of_type_Int = i4;
        this.jdField_h_of_type_JavaLangString = ((String)localObject);
        this.jdField_g_of_type_Int = i1;
        this.jdField_f_of_type_Int = i2;
        this.jdField_a_of_type_Ajkk.sendEmptyMessage(1103);
        return;
        if (ajrb.a(this.jdField_k_of_type_JavaLangString, this.jdField_j_of_type_Int, this.jdField_k_of_type_Int) == 0) {}
        for (boolean bool = TrimNative.isGetFrameReady();; bool = false)
        {
          if (!bool) {
            break label325;
          }
          localBitmap = ajrb.a(i3, i3 + 1000);
          localObject = "";
          i1 = 0;
          break;
        }
        label325:
        QLog.w("EditLocalVideoActivity", 2, "TrimNative.isGetFrameReady return false,thumbnail pic is null.");
        if (!c()) {
          break label436;
        }
        if (i3 <= 1000) {
          localObject = this.jdField_h_of_type_JavaLangString;
        }
        i2 = this.jdField_f_of_type_Int;
        i1 = this.jdField_g_of_type_Int;
        localBitmap = null;
        break;
        localObject = "";
        QLog.e("EditLocalVideoActivity", 2, "save jpg failed");
        bjsb.a(String.valueOf(this.jdField_d_of_type_Long), "qzone_video_trim", "4", null);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("EditLocalVideoActivity", 2, "getFrame failed");
        }
        bjsb.a(String.valueOf(this.jdField_d_of_type_Long), "qzone_video_trim", "5", null);
      }
      label436:
      localObject = "";
      localBitmap = null;
      i1 = 0;
    }
  }
  
  private void u()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.c())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.start();
      b(false);
      this.jdField_f_of_type_Boolean = false;
      return;
    }
    bhpy localbhpy = bhpy.a(this);
    localbhpy.a(alpo.a(2131704025));
    localbhpy.a(2131693165, 3);
    localbhpy.c(2131690648);
    localbhpy.a(new ajjx(this, localbhpy));
    localbhpy.show();
  }
  
  private void v()
  {
    w();
    long l1 = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoDurationThreshold", 90000);
    if (this.jdField_b_of_type_Long > l1)
    {
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton != null) {
        this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.getDrawable().setColorFilter(-7829368, PorterDuff.Mode.MULTIPLY);
      }
      l1 = QzoneConfig.getInstance().getConfig("VideoEdit", "SupportMixMusicMaxSize", 524288000L);
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = new File(this.jdField_i_of_type_JavaLangString).length();
      }
      if (this.jdField_a_of_type_Long <= l1) {
        break label190;
      }
      this.jdField_c_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.getDrawable().setColorFilter(-7829368, PorterDuff.Mode.MULTIPLY);
      }
    }
    for (;;)
    {
      if (this.jdField_p_of_type_Int == 0) {
        a(true);
      }
      if (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
        break label215;
      }
      x();
      return;
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton == null) {
        break;
      }
      this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.getDrawable().clearColorFilter();
      break;
      label190:
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.getDrawable().clearColorFilter();
      }
    }
    label215:
    QLog.e("EditLocalVideoActivity", 2, " localVideoPath is empty ");
  }
  
  private void w()
  {
    if (this.jdField_p_of_type_Int == 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131695294);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695779);
      if ((this.jdField_a_of_type_Ajkm == null) || (!this.jdField_a_of_type_Ajkm.a()))
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getResources().getColor(2131166374));
        azhe.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      azhe.a(this.jdField_a_of_type_AndroidWidgetTextView, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      if (this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton != null) {
        this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
      }
      azhe.a(this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      azhe.a(this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      a(false);
      azhe.a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      if (!this.jdField_l_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130848625);
        this.jdField_a_of_type_Boolean = false;
      }
      return;
      if (this.jdField_p_of_type_Int == 1)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131690382);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694951);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
      }
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_AndroidViewViewStub == null)
    {
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131373453));
      this.jdField_a_of_type_AndroidViewViewStub.inflate();
    }
    try
    {
      Object localObject1 = ShortVideoSoLoad.getShortVideoSoPath(BaseApplication.getContext());
      GlobalInit.loadLibraryWithFullPath((String)localObject1 + VideoEnvironment.a());
      if (!ajqx.a(this.jdField_d_of_type_Long))
      {
        QQToast.a(this, alpo.a(2131704022), 0).a();
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
          QQToast.a(this, alpo.a(2131704047), 0).a();
        }
        if (QLog.isColorLevel()) {
          QLog.d("EditLocalVideoActivity", 2, "availMem=" + ((ActivityManager.MemoryInfo)localObject2).availMem + ", threshold=" + ((ActivityManager.MemoryInfo)localObject2).threshold + ", lowMem=" + ((ActivityManager.MemoryInfo)localObject2).lowMemory + ", minRam=" + i1);
        }
        ajqx.a();
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          Object localObject2;
          int i1;
          FrameLayout.LayoutParams localLayoutParams1;
          int i5;
          int i4;
          QLog.w("EditLocalVideoActivity", 2, "", localThrowable2);
        }
      }
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131364735));
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131379593));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131364903));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar = ((VideoFrameSelectBar)a(2131379567));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView = ((FixedSizeVideoView)a(2131379817));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131379885));
      this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131379568));
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131379569));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131379571));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)a(2131379570));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((this.jdField_h_of_type_Int != 0) && (this.jdField_i_of_type_Int != 0))
      {
        localObject1 = (RelativeLayout.LayoutParams)a(this.jdField_b_of_type_AndroidViewViewGroup);
        localObject2 = (FrameLayout.LayoutParams)a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView);
        localLayoutParams1 = (FrameLayout.LayoutParams)a(this.jdField_a_of_type_AndroidWidgetImageView);
        localLayoutParams2 = (FrameLayout.LayoutParams)a(this.jdField_b_of_type_AndroidWidgetImageView);
        i5 = this.jdField_h_of_type_Int;
        i4 = this.jdField_i_of_type_Int;
        i2 = i4;
        i1 = i5;
        if (Build.VERSION.SDK_INT >= 17)
        {
          i6 = i4;
          i1 = i5;
        }
      }
      try
      {
        MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
        i6 = i4;
        i1 = i5;
        localMediaMetadataRetriever.setDataSource(this.jdField_i_of_type_JavaLangString);
        i6 = i4;
        i1 = i5;
        String str = localMediaMetadataRetriever.extractMetadata(24);
        i6 = i4;
        i1 = i5;
        QLog.e("EditLocalVideoActivity", 2, "rotation=" + str + "  localVideoWidth=" + this.jdField_h_of_type_Int + " localVideoHeight=" + this.jdField_i_of_type_Int);
        i6 = i4;
        i1 = i5;
        int i3;
        if (!TextUtils.equals(str, "90"))
        {
          i2 = i4;
          i3 = i5;
          i6 = i4;
          i1 = i5;
          if (!TextUtils.equals(str, "270")) {}
        }
        else
        {
          i6 = i4;
          i1 = i5;
          i3 = this.jdField_i_of_type_Int;
          i6 = i4;
          i1 = i3;
          i2 = this.jdField_h_of_type_Int;
        }
        i6 = i2;
        i1 = i3;
        localMediaMetadataRetriever.release();
        i1 = i3;
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          QLog.e("EditLocalVideoActivity", 1, "replay error", localThrowable3);
          i2 = i6;
          continue;
          localLayoutParams2.height = this.jdField_i_of_type_Int;
        }
      }
      if (i1 / i2 >= 1.0F)
      {
        localLayoutParams2.height = -1;
        this.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams1);
        this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams2);
        y();
        z();
        if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
          A();
        }
        c(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setVideoPath(this.jdField_i_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.jdField_c_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.start();
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        QLog.e("EditLocalVideoActivity", 2, "loadLibrary Exception", localThrowable1);
        a("play_local_video", "play_local_video_success", "2", Build.MODEL);
        QQToast.a(this, alpo.a(2131704041), 0).a();
        finish();
      }
    }
  }
  
  private void y()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new ajjy(this));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.setOnFramesClipChangeListener(this);
    }
  }
  
  private void z()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setOnFixVDPlayCompelteListener(new ajjz(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setOnErrorListener(new ajka(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setOnPreparedListener(new ajkb(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setOnTouchListener(new ajkc(this));
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
  
  public String a(int paramInt)
  {
    int i2 = paramInt / 1000;
    paramInt = i2 % 60;
    int i1 = i2 / 60 % 60;
    i2 /= 3600;
    this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    if (i2 > 0) {
      return this.jdField_a_of_type_JavaUtilFormatter.format("%d:%02d:%02d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(paramInt) }).toString();
    }
    return this.jdField_a_of_type_JavaUtilFormatter.format("%02d:%02d", new Object[] { Integer.valueOf(i1), Integer.valueOf(paramInt) }).toString();
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 666	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 1682	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: astore_2
    //   7: aload_2
    //   8: new 59	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 1684
    //   18: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 1690	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   31: aconst_null
    //   32: ldc_w 1692
    //   35: iconst_1
    //   36: anewarray 218	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: aload_1
    //   42: aastore
    //   43: aconst_null
    //   44: invokevirtual 1698	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +212 -> 261
    //   52: aload_1
    //   53: invokeinterface 1703 1 0
    //   58: ifeq +203 -> 261
    //   61: aload_1
    //   62: aload_1
    //   63: ldc_w 1705
    //   66: invokeinterface 1708 2 0
    //   71: invokeinterface 1709 2 0
    //   76: astore_2
    //   77: aload_2
    //   78: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: ifne +174 -> 255
    //   84: new 218	java/lang/String
    //   87: dup
    //   88: aload_2
    //   89: invokevirtual 1713	java/lang/String:getBytes	()[B
    //   92: ldc_w 1715
    //   95: invokespecial 1718	java/lang/String:<init>	([BLjava/lang/String;)V
    //   98: invokestatic 1722	com/tencent/mobileqq/utils/SecurityUtile:b	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore_2
    //   102: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +29 -> 134
    //   108: ldc 186
    //   110: iconst_2
    //   111: new 59	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   118: ldc_w 1724
    //   121: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_2
    //   125: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 749	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload_2
    //   135: astore_3
    //   136: aload_1
    //   137: ifnull +11 -> 148
    //   140: aload_1
    //   141: invokeinterface 1725 1 0
    //   146: aload_2
    //   147: astore_3
    //   148: aload_3
    //   149: areturn
    //   150: astore_3
    //   151: aconst_null
    //   152: astore_2
    //   153: ldc 111
    //   155: astore_1
    //   156: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +32 -> 191
    //   162: ldc 186
    //   164: iconst_2
    //   165: new 59	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 1727
    //   175: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_3
    //   179: invokestatic 1731	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   182: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 914	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: aload_1
    //   192: astore_3
    //   193: aload_2
    //   194: ifnull -46 -> 148
    //   197: aload_2
    //   198: invokeinterface 1725 1 0
    //   203: aload_1
    //   204: areturn
    //   205: astore_2
    //   206: aconst_null
    //   207: astore_1
    //   208: aload_1
    //   209: ifnull +9 -> 218
    //   212: aload_1
    //   213: invokeinterface 1725 1 0
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
    //   235: ldc 111
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
    //   255: ldc 111
    //   257: astore_2
    //   258: goto -156 -> 102
    //   261: ldc 111
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
  
  protected void a()
  {
    setContentViewNoTitle(2131561006);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131365587));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131366515));
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)a(2131366504));
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)a(2131366501));
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131366570));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131366565));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131366537));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)a(2131366538));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131366539));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131366512));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)aekt.a(2, 50, getResources()));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getResources().getColor(2131166374));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = aekt.a(55.0F, getResources());
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText = ((ExtendEditText)a(2131366513));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setEditableFactory(baiv.c);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131366556));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = a(2131366561);
    k();
    l();
  }
  
  public void a(float paramFloat)
  {
    runOnUiThread(new EditLocalVideoActivity.22(this, paramFloat));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditLocalVideoActivity", 2, "onFramesClipChanged, startTime=" + paramInt1 + ", endTime=" + paramInt2);
    }
    if (this.jdField_g_of_type_Boolean) {
      LpReportInfo_pf00064.allReport(664, 4, 4);
    }
    runOnUiThread(new EditLocalVideoActivity.19(this));
    if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
      runOnUiThread(new EditLocalVideoActivity.20(this));
    }
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new EditLocalVideoActivity.21(this, paramInt1, paramInt2));
    if (this.jdField_c_of_type_Int == 0) {
      this.jdField_b_of_type_Int = paramInt1;
    }
    if (this.jdField_a_of_type_Ajkm != null) {
      this.jdField_a_of_type_Ajkm.a(paramInt1, paramInt2);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    bizg localbizg = new bizg();
    localbizg.jdField_c_of_type_JavaLangString = paramString1;
    localbizg.jdField_d_of_type_JavaLangString = paramString2;
    localbizg.e = paramString3;
    QZoneClickReport.report(String.valueOf(this.jdField_d_of_type_Long), localbizg, paramBoolean);
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setText(b(this.jdField_a_of_type_Int));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
          this.jdField_c_of_type_JavaLangString = paramIntent.getString("key_setting_raw_json");
          this.jdField_b_of_type_JavaLangString = paramIntent.getString("key_selected_tag");
        }
        d();
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
        this.jdField_e_of_type_Boolean = false;
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
            this.jdField_c_of_type_JavaLangString = paramIntent.getString("key_setting_raw_json");
            this.jdField_b_of_type_JavaLangString = paramIntent.getString("key_selected_tag");
          }
          d();
        }
      }
      if (localBundle.containsKey("contentIntentKey"))
      {
        localObject = localBundle.getString("contentIntentKey");
        paramIntent = (Intent)localObject;
        if (localObject == null) {
          paramIntent = "";
        }
        this.jdField_l_of_type_JavaLangString = paramIntent;
      }
      if (localBundle.containsKey("contentIntentKeyForVideoEditWithEmo"))
      {
        paramIntent = localBundle.getString("contentIntentKeyForVideoEditWithEmo");
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setText(paramIntent);
      }
      this.jdField_m_of_type_Int = localBundle.getInt("extra_key_font_id", -1);
      this.jdField_n_of_type_Int = localBundle.getInt("extra_key_font_format_type");
      this.jdField_n_of_type_JavaLangString = localBundle.getString("extra_key_font_url");
      this.jdField_o_of_type_Int = localBundle.getInt("extra_key_super_font_id", -1);
      this.jdField_o_of_type_JavaLangString = localBundle.getString("extra_key_super_font_info");
      this.jdField_a_of_type_Ajkk.sendEmptyMessage(1009);
      return;
    } while ((paramInt1 != 1010) || (paramInt2 != -1));
    bfhq.a().a(2131718361);
    this.jdField_l_of_type_Boolean = true;
  }
  
  public void onBackPressed()
  {
    this.r = true;
    m();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    Iterator localIterator;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131366504: 
      LpReportInfo_pf00064.allReport(664, 3, 1);
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = true;
        o();
        n();
        return;
      }
      Toast.makeText(getApplicationContext(), alpo.a(2131704023), 1).show();
      return;
    case 2131366501: 
      LpReportInfo_pf00064.allReport(664, 4, 1);
      if (this.jdField_b_of_type_Boolean)
      {
        QLog.e("EditLocalVideoActivity", 2, "click clip ");
        paramView = a(this.jdField_h_of_type_JavaLangString, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, false);
        if (paramView != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramView);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.jdField_b_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
          this.jdField_g_of_type_Boolean = true;
          b(true);
          return;
          QLog.e("EditLocalVideoActivity", 2, "click clip but coverview find bitmap is null");
        }
      }
      long l1 = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoDurationThreshold", 90000);
      Toast.makeText(getApplicationContext(), alpo.a(2131704030) + l1 / 1000L + alpo.a(2131704045), 1).show();
      return;
    case 2131366565: 
      LpReportInfo_pf00064.allReport(664, 1);
      this.r = false;
      m();
      return;
    case 2131366556: 
      paramView = QzoneConfig.getInstance().getConfig("H5Url", "UgcPermitSetting", "https://h5.qzone.qq.com/ugc/setting?_wv=3&type=mood&uin={uin}&qua={qua}&_proxy=1").replace("{uin}", String.valueOf(this.jdField_d_of_type_Long)).replace("{qua}", bizf.a());
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
      if ((a(this.jdField_a_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
        ((Bundle)localObject1).putString("key_setting_raw_json", this.jdField_c_of_type_JavaLangString);
      }
      bizm.a(this, paramView, 2, (Bundle)localObject1, "");
      return;
    case 2131366570: 
      q();
      return;
    case 2131366513: 
      this.jdField_e_of_type_Boolean = true;
      a("608", "5", "0", true);
      localObject1 = bizt.a();
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
      if ((a(this.jdField_a_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
        ((Bundle)localObject2).putString("key_setting_raw_json", this.jdField_c_of_type_JavaLangString);
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
      if (this.jdField_o_of_type_Boolean) {}
      for (int i1 = 0;; i1 = 1)
      {
        bizm.a(this, (bizt)localObject1, 1009, "", paramView, "", "", 0, i1, 1, 0, 0, 0, "", 10000, (Bundle)localObject2, this.jdField_o_of_type_Boolean, this.jdField_p_of_type_Boolean, this.jdField_m_of_type_Int, this.jdField_o_of_type_Int, false);
        return;
      }
    case 2131366537: 
    case 2131366538: 
      if (!this.jdField_l_of_type_Boolean)
      {
        s();
        return;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        bfhq.a().a(2131718646);
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130848625);
        this.jdField_m_of_type_Boolean = false;
        return;
      }
      bfhq.a().a(2131718648);
      a("608", "7", "1", true);
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130848624);
      this.jdField_m_of_type_Boolean = true;
      return;
    case 2131379569: 
      LpReportInfo_pf00064.allReport(664, 4, 2);
      u();
      return;
    }
    LpReportInfo_pf00064.allReport(664, 4, 3);
    a("608", "4", "1", true);
    QzoneHandlerThreadFactory.getHandlerThread("RealTime_HandlerThread").post(new EditLocalVideoActivity.5(this));
  }
  
  public void onCreate(Bundle paramBundle)
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
  
  public void onDestroy()
  {
    super.onDestroy();
    bjwq.a().a();
    if (this.jdField_a_of_type_Ajkm != null) {
      this.jdField_a_of_type_Ajkm.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString))
    {
      if (this.jdField_g_of_type_Boolean) {
        break label43;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ajkm != null) {
        this.jdField_a_of_type_Ajkm.d();
      }
      return;
      label43:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.isPlaying()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_d_of_type_Boolean)
    {
      LpReportInfo_pf00064.allReport(664, 3, 2);
      this.jdField_d_of_type_Boolean = false;
    }
    v();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView != null)
    {
      if (this.jdField_g_of_type_Boolean) {
        break label84;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.start();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ajkm != null) {
        this.jdField_a_of_type_Ajkm.e();
      }
      return;
      label84:
      Bitmap localBitmap = a(this.jdField_h_of_type_JavaLangString, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, false);
      if (localBitmap != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
      b(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity
 * JD-Core Version:    0.7.0.1
 */