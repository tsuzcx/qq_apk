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
  private static final String jdField_d_of_type_JavaLangString;
  private static final String jdField_e_of_type_JavaLangString;
  private static String jdField_f_of_type_JavaLangString;
  private static final boolean jdField_n_of_type_Boolean;
  public int a;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FlowComponentInterface jdField_a_of_type_ComTencentAelightCameraStructEditorFlowComponentInterface = null;
  private PressDarkImageButton jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  private EditLocalVideoActivity.TrimHandler jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity$TrimHandler = new EditLocalVideoActivity.TrimHandler(this);
  private EditLocalVideoMusicMixer jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer;
  public RMVideoStateMgr a;
  private FixedSizeVideoView jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView;
  private VideoFrameSelectBar jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar;
  private ExtendEditText jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private QzoneVerticalVideoTopicInfo jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  public ArrayList<String> a;
  private Formatter jdField_a_of_type_JavaUtilFormatter = new Formatter(this.jdField_a_of_type_JavaLangStringBuilder, Locale.getDefault());
  boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private PressDarkImageButton jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  public String b;
  private boolean jdField_b_of_type_Boolean = false;
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
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = 0;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int = 0;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int;
  private String jdField_h_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean = true;
  private int jdField_i_of_type_Int;
  private String jdField_i_of_type_JavaLangString;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private String jdField_j_of_type_JavaLangString;
  private boolean jdField_j_of_type_Boolean = false;
  private int jdField_k_of_type_Int;
  private String jdField_k_of_type_JavaLangString = "";
  private boolean jdField_k_of_type_Boolean = false;
  private int jdField_l_of_type_Int = 2;
  private String jdField_l_of_type_JavaLangString;
  private boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int = -1;
  private String jdField_m_of_type_JavaLangString;
  private boolean jdField_m_of_type_Boolean = true;
  private int jdField_n_of_type_Int = -1;
  private String jdField_n_of_type_JavaLangString;
  private int jdField_o_of_type_Int = -1;
  private String jdField_o_of_type_JavaLangString;
  private boolean jdField_o_of_type_Boolean = false;
  private int jdField_p_of_type_Int = 0;
  private String jdField_p_of_type_JavaLangString;
  private boolean jdField_p_of_type_Boolean;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/tencent");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("video_edit_music_download");
    localStringBuilder.append(File.separator);
    jdField_d_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("/tencent");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("video_edit_music");
    localStringBuilder.append(File.separator);
    jdField_e_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(PathUtils.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(jdField_d_of_type_JavaLangString);
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(PathUtils.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(jdField_e_of_type_JavaLangString);
    jdField_f_of_type_JavaLangString = localStringBuilder.toString();
    boolean bool;
    if (Build.VERSION.SDK_INT >= 10) {
      bool = true;
    } else {
      bool = false;
    }
    jdField_n_of_type_Boolean = bool;
  }
  
  public EditLocalVideoActivity()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = RMVideoStateMgr.a();
  }
  
  private void A()
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
    //   2: new 220	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 223	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_1
    //   12: ifnull +36 -> 48
    //   15: aload_2
    //   16: astore_0
    //   17: aload_1
    //   18: getfield 226	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   21: ifeq +27 -> 48
    //   24: aload_2
    //   25: astore_0
    //   26: new 228	java/io/BufferedInputStream
    //   29: dup
    //   30: aload_2
    //   31: sipush 2048
    //   34: invokespecial 231	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   37: aconst_null
    //   38: aload_1
    //   39: invokestatic 237	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   42: astore_1
    //   43: aload_1
    //   44: astore_0
    //   45: goto +24 -> 69
    //   48: aload_2
    //   49: astore_0
    //   50: new 228	java/io/BufferedInputStream
    //   53: dup
    //   54: aload_2
    //   55: sipush 8192
    //   58: invokespecial 231	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   61: aconst_null
    //   62: aload_1
    //   63: invokestatic 237	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   66: astore_1
    //   67: aload_1
    //   68: astore_0
    //   69: aload_2
    //   70: invokevirtual 242	java/io/InputStream:close	()V
    //   73: aload_0
    //   74: areturn
    //   75: astore_1
    //   76: goto +16 -> 92
    //   79: astore_1
    //   80: goto +34 -> 114
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_0
    //   86: goto +59 -> 145
    //   89: astore_1
    //   90: aconst_null
    //   91: astore_2
    //   92: aload_2
    //   93: astore_0
    //   94: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +71 -> 168
    //   100: aload_2
    //   101: astore_0
    //   102: ldc 250
    //   104: iconst_2
    //   105: ldc 128
    //   107: aload_1
    //   108: invokestatic 253	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   111: goto +57 -> 168
    //   114: aload_2
    //   115: astore_0
    //   116: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +14 -> 133
    //   122: aload_2
    //   123: astore_0
    //   124: ldc 250
    //   126: iconst_2
    //   127: ldc 128
    //   129: aload_1
    //   130: invokestatic 253	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   133: aload_2
    //   134: ifnull +8 -> 142
    //   137: aload_3
    //   138: astore_0
    //   139: goto -70 -> 69
    //   142: aconst_null
    //   143: areturn
    //   144: astore_1
    //   145: aload_0
    //   146: ifnull +7 -> 153
    //   149: aload_0
    //   150: invokevirtual 242	java/io/InputStream:close	()V
    //   153: goto +5 -> 158
    //   156: aload_1
    //   157: athrow
    //   158: goto -2 -> 156
    //   161: astore_1
    //   162: aload_0
    //   163: areturn
    //   164: astore_0
    //   165: goto -12 -> 153
    //   168: aload_2
    //   169: ifnull -27 -> 142
    //   172: aload_3
    //   173: astore_0
    //   174: goto -105 -> 69
    //   177: astore_1
    //   178: aconst_null
    //   179: astore_2
    //   180: goto -66 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramString	String
    //   0	183	1	paramOptions	BitmapFactory.Options
    //   10	170	2	localFileInputStream	java.io.FileInputStream
    //   1	172	3	localObject	Object
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
    //   17	24	144	finally
    //   26	43	144	finally
    //   50	67	144	finally
    //   94	100	144	finally
    //   102	111	144	finally
    //   116	122	144	finally
    //   124	133	144	finally
    //   69	73	161	java/io/IOException
    //   149	153	164	java/io/IOException
    //   2	11	177	java/lang/OutOfMemoryError
  }
  
  public static String a()
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
  
  private void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
    if (localObject != null)
    {
      ((ProgressBar)localObject).setProgress(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    a("608", "2", "0", true);
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView;
    if (localObject != null) {
      ((FixedSizeVideoView)localObject).stopPlayback();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar;
    if (localObject != null) {
      ((VideoFrameSelectBar)localObject).c();
    }
    localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    b(8);
    setResult(paramInt);
    finish();
  }
  
  private void a(Bundle paramBundle)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraStructEditorFlowComponentInterface;
    if ((localObject != null) && ("ref_h5_record_video".equals(((FlowComponentInterface)localObject).getRefer())))
    {
      localObject = new Intent("com.qzone.h5.video.recordCallback");
      ((Intent)localObject).putExtras(paramBundle);
      BaseApplication.getContext().sendBroadcast((Intent)localObject);
    }
    else
    {
      int i1 = this.jdField_p_of_type_Int;
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
    if (this.jdField_p_of_type_Int == 0) {
      setResult(-1);
    }
    finish();
  }
  
  private void a(Message paramMessage)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      try
      {
        paramMessage = (String)paramMessage.obj;
        int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.getWidth();
        int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.getHeight();
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
        this.jdField_a_of_type_AndroidGraphicsBitmap = a(paramMessage, i1, i2, false);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          localObject = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = i2;
          ((ViewGroup.LayoutParams)localObject).width = i1;
          this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
          if (this.jdField_g_of_type_Boolean) {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          }
          this.jdField_f_of_type_Int = i1;
          this.jdField_g_of_type_Int = i2;
          this.jdField_g_of_type_JavaLangString = paramMessage;
          return;
        }
      }
      catch (Throwable paramMessage)
      {
        QLog.w("EditLocalVideoActivity", 2, "VIDEO_SHOW_COVER failed", paramMessage);
      }
    }
  }
  
  private void a(String paramString)
  {
    String str = getResources().getString(2131717526);
    QZoneHelper.forwardOpenQzoneVip2(this, QZoneHelper.UserInfo.getInstance(), paramString, this.jdField_d_of_type_Long, "", 1010, str, false);
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
        this.jdField_a_of_type_ComTencentAelightCameraStructEditorFlowComponentInterface = ((FlowComponentInterface)paramString1);
        this.jdField_a_of_type_ComTencentAelightCameraStructEditorFlowComponentInterface.setRefer(paramString2);
        return;
      }
    }
    catch (Throwable paramString1)
    {
      this.jdField_a_of_type_ComTencentAelightCameraStructEditorFlowComponentInterface = null;
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
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(String.valueOf(this.jdField_d_of_type_Long), paramString1, true, 0L, 0L, localHashMap, null);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_c_of_type_AndroidWidgetRelativeLayout;
    if ((localObject != null) && (this.jdField_b_of_type_AndroidWidgetButton != null) && (this.jdField_c_of_type_AndroidWidgetTextView != null))
    {
      int i2 = 0;
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      ((RelativeLayout)localObject).setVisibility(i1);
      localObject = this.jdField_b_of_type_AndroidWidgetButton;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      ((Button)localObject).setVisibility(i1);
      localObject = this.jdField_c_of_type_AndroidWidgetTextView;
      if (paramBoolean) {
        i1 = i2;
      } else {
        i1 = 8;
      }
      ((TextView)localObject).setVisibility(i1);
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
    if (paramInt != 1)
    {
      if (paramInt != 4)
      {
        if (paramInt != 16)
        {
          if (paramInt != 64)
          {
            if (paramInt != 128) {
              return HardCodeUtil.a(2131703822);
            }
            return HardCodeUtil.a(2131703806);
          }
          return HardCodeUtil.a(2131703820);
        }
        return HardCodeUtil.a(2131703809);
      }
      return HardCodeUtil.a(2131703815);
    }
    return HardCodeUtil.a(2131703799);
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView;
    if (localObject != null) {
      ((FixedSizeVideoView)localObject).setVisibility(paramInt);
    }
    localObject = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(paramInt);
    }
    localObject = this.jdField_b_of_type_AndroidViewViewGroup;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(paramInt);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    QzoneHandlerThreadFactory.getHandlerThread("RealTime_HandlerThread").post(new EditLocalVideoActivity.18(this, paramInt1, paramInt2));
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar;
    int i3 = 8;
    int i2 = 0;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((VideoFrameSelectBar)localObject).setVisibility(i1);
    localObject = this.jdField_e_of_type_AndroidWidgetRelativeLayout;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((RelativeLayout)localObject).setVisibility(i1);
    localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((ImageView)localObject).setVisibility(i1);
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((ImageView)localObject).setVisibility(i1);
    localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramBoolean) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    ((ViewGroup)localObject).setVisibility(i1);
    localObject = this.jdField_c_of_type_AndroidViewView;
    if (localObject != null)
    {
      if (paramBoolean) {
        i1 = i3;
      } else {
        i1 = 0;
      }
      ((View)localObject).setVisibility(i1);
    }
    int i1 = this.jdField_p_of_type_Int;
    if (i1 == 0) {
      c(paramBoolean);
    } else if (i1 == 1) {
      c(true);
    }
    localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject != null)
    {
      i1 = i2;
      if (paramBoolean) {
        i1 = 4;
      }
      ((TextView)localObject).setVisibility(i1);
    }
  }
  
  private boolean b()
  {
    if (!CacheManager.isExternalAvailable())
    {
      if (QLog.isColorLevel()) {
        QLog.i("EditLocalVideoActivity", 2, "isEnoughStorage() sdcard not mounted");
      }
      QzoneVideoBeaconReport.reportVideoEvent(String.valueOf(this.jdField_d_of_type_Long), "qzone_video_trim", "6", null);
    }
    long l1 = cooperation.qzone.util.FileUtils.getFileSize(this.jdField_j_of_type_JavaLangString);
    if (l1 <= 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "no file size");
      }
      QzoneVideoBeaconReport.reportVideoEvent(String.valueOf(this.jdField_d_of_type_Long), "qzone_video_trim", "7", null);
      return false;
    }
    if (l1 / this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.getDuration() * (this.jdField_d_of_type_Int - this.jdField_c_of_type_Int) > CacheManager.getSDCardRemain())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "there is not enough space on sdcard");
      }
      QzoneVideoBeaconReport.reportVideoEvent(String.valueOf(this.jdField_d_of_type_Long), "qzone_video_trim", "8", null);
      return false;
    }
    return true;
  }
  
  private void c()
  {
    new AlertDialog.Builder(this).setMessage(HardCodeUtil.a(2131703816)).setNegativeButton(2131693890, new EditLocalVideoActivity.1(this)).setCancelable(false).show();
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    int i2 = 8;
    int i1;
    if (paramBoolean) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    ((RelativeLayout)localObject).setVisibility(i1);
    localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = getResources().getColor(2131166500);
    }
    ((RelativeLayout)localObject).setBackgroundColor(i1);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText;
    if (paramBoolean) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    ((ExtendEditText)localObject).setVisibility(i1);
    localObject = this.jdField_a_of_type_AndroidWidgetButton;
    if ((!paramBoolean) && (!this.jdField_l_of_type_Boolean)) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((Button)localObject).setVisibility(i1);
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (paramBoolean) {
      i1 = i2;
    } else {
      i1 = 0;
    }
    ((View)localObject).setVisibility(i1);
  }
  
  private boolean c()
  {
    return "cover_mall_record_video".equals(this.jdField_o_of_type_JavaLangString);
  }
  
  private void d()
  {
    a("play_local_video", "play_local_video_success", "1", Build.MODEL);
    try
    {
      new AlertDialog.Builder(this).setMessage(HardCodeUtil.a(2131703814)).setNegativeButton(2131693890, new EditLocalVideoActivity.2(this)).setCancelable(false).create().show();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("EditLocalVideoActivity", 2, "LOAD_VIDEO_TIME_OUT showDialog error", localException);
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditLocalVideoActivity", 2, "handleMessage, MSG_ON_CONFIRM");
    }
    b(false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.isPlaying()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
    }
    FixedSizeVideoView localFixedSizeVideoView = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView;
    int i1 = this.jdField_c_of_type_Int;
    localFixedSizeVideoView.setPlayDuration(i1, this.jdField_d_of_type_Int - i1);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.start();
    this.jdField_f_of_type_Boolean = true;
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText;
    if (localObject == null) {
      return;
    }
    ((ExtendEditText)localObject).setTextEffect(this.jdField_n_of_type_JavaLangString);
    localObject = null;
    String str = ((IFontManager)QRoute.api(IFontManager.class)).getTrueTypeFont(this.jdField_m_of_type_Int, null, null, true, null);
    if (TextUtils.isEmpty(str)) {
      this.jdField_m_of_type_Int = -1;
    } else {
      localObject = Typeface.createFromFile(str);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setTypeface((Typeface)localObject);
  }
  
  private void g()
  {
    VideoFrameSelectBar localVideoFrameSelectBar = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar;
    if (localVideoFrameSelectBar != null) {
      localVideoFrameSelectBar.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity$TrimHandler.removeMessages(9999);
  }
  
  private void h()
  {
    A();
    Object localObject = getIntent();
    this.jdField_p_of_type_Int = ((Intent)localObject).getIntExtra("PhotoConst.EDIT_LOCAL_VIDEO_ENTRY", 0);
    this.jdField_h_of_type_JavaLangString = ((Intent)localObject).getStringExtra("file_send_path");
    if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))
    {
      if (!new File(this.jdField_h_of_type_JavaLangString).exists())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("localVideoPath not exists : ");
        ((StringBuilder)localObject).append(this.jdField_h_of_type_JavaLangString);
        QLog.e("EditLocalVideoActivity", 2, ((StringBuilder)localObject).toString());
        ToastUtil.a().a(HardCodeUtil.a(2131703818));
        finish();
        return;
      }
      this.jdField_i_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
      this.jdField_a_of_type_Long = ((Intent)localObject).getLongExtra("PhotoConst.VIDEO_SIZE", 0L);
      this.jdField_b_of_type_Long = ((Intent)localObject).getLongExtra("file_send_duration", 0L);
      this.jdField_h_of_type_Int = ((Intent)localObject).getIntExtra("file_width", 0);
      this.jdField_i_of_type_Int = ((Intent)localObject).getIntExtra("file_height", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("localVideoWidth: ");
      localStringBuilder.append(this.jdField_h_of_type_Int);
      localStringBuilder.append(" ,    localVideoHeight: ");
      localStringBuilder.append(this.jdField_i_of_type_Int);
      QLog.i("EditLocalVideoActivity", 2, localStringBuilder.toString());
      this.jdField_i_of_type_Boolean = ((Intent)localObject).getBooleanExtra("is_qzone_vip", false);
      this.jdField_l_of_type_JavaLangString = ((Intent)localObject).getStringExtra("topic_id");
      this.jdField_l_of_type_Boolean = (TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString) ^ true);
      this.jdField_m_of_type_Boolean = ((Intent)localObject).getBooleanExtra("param.topicSyncQzone", this.jdField_m_of_type_Boolean);
      this.jdField_m_of_type_Int = ((Intent)localObject).getIntExtra("extra_key_font_id", -1);
      this.jdField_n_of_type_Int = ((Intent)localObject).getIntExtra("extra_key_font_format_type", -1);
      this.jdField_m_of_type_JavaLangString = ((Intent)localObject).getStringExtra("extra_key_font_url");
      this.jdField_o_of_type_Int = ((Intent)localObject).getIntExtra("extra_key_super_font_id", -1);
      this.jdField_n_of_type_JavaLangString = ((Intent)localObject).getStringExtra("extra_key_super_font_info");
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity$TrimHandler.sendEmptyMessage(1009);
      this.jdField_o_of_type_JavaLangString = ((Intent)localObject).getStringExtra("short_video_refer");
      this.jdField_p_of_type_JavaLangString = ((Intent)localObject).getStringExtra("set_user_callback");
      a(this.jdField_p_of_type_JavaLangString, this.jdField_o_of_type_JavaLangString);
      this.jdField_c_of_type_Int = ((int)((Intent)localObject).getLongExtra("PhotoConst.EDIT_LOCAL_VIDEO_START_TIME", 0L));
      this.jdField_d_of_type_Int = ((int)((Intent)localObject).getLongExtra("PhotoConst.EDIT_LOCAL_VIDEO_END_TIME", 0L));
      this.jdField_e_of_type_Int = ((int)((Intent)localObject).getLongExtra("PhotoConst.EDIT_LOCAL_VIDEO_DURATION", 0L));
      int i1 = this.jdField_c_of_type_Int;
      if (i1 != 0) {
        this.jdField_b_of_type_Int = i1;
      }
      this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo = ((QzoneVerticalVideoTopicInfo)((Intent)localObject).getParcelableExtra("key_qzone_topic"));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("localVideoPath is null : ");
    ((StringBuilder)localObject).append(this.jdField_h_of_type_JavaLangString);
    QLog.e("EditLocalVideoActivity", 2, ((StringBuilder)localObject).toString());
    ToastUtil.a().a(HardCodeUtil.a(2131703812));
    finish();
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo != null)
    {
      this.jdField_c_of_type_AndroidViewView = $(2131379038);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      ((TextView)$(2131379920)).setText(this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getDescName());
      URLImageView localURLImageView = (URLImageView)$(2131369437);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getThumbImgUrl()))
      {
        localURLImageView.setBackgroundURL(this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getThumbImgUrl());
        return;
      }
      localURLImageView.setVisibility(8);
    }
  }
  
  private void j()
  {
    int i1 = SystemUtil.getNotchHeight(this, this);
    if (i1 <= 0) {
      return;
    }
    Object localObject = findViewById(2131374210);
    if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof RelativeLayout.LayoutParams)))
    {
      localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height += i1;
    }
  }
  
  private void k()
  {
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.performClick();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, HardCodeUtil.a(2131703810), null, getString(2131692932), getString(2131690728), new EditLocalVideoActivity.3(this), new EditLocalVideoActivity.4(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer.a(this.jdField_b_of_type_Long, this.jdField_h_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer.a(new EditLocalVideoActivity.6(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer.a(new EditLocalVideoActivity.7(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer.a();
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer = EditLocalVideoMusicMixer.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView, this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo, this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton);
      return;
    }
    QZLog.i("EditLocalVideoActivity", 2, "use old music mixer");
  }
  
  private void n()
  {
    if (!a(this.jdField_h_of_type_JavaLangString))
    {
      ToastUtil.a().a("视频文件不存在");
      return;
    }
    LpReportInfo_pf00064.allReport(664, 2);
    if (this.jdField_j_of_type_Boolean)
    {
      if (this.jdField_f_of_type_Boolean) {
        this.jdField_k_of_type_Boolean = true;
      } else {
        this.jdField_k_of_type_Boolean = false;
      }
    }
    else
    {
      l1 = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoDurationThreshold", 90000);
      if (this.jdField_f_of_type_Boolean) {
        this.jdField_k_of_type_Boolean = true;
      } else if (this.jdField_b_of_type_Long > l1) {
        this.jdField_k_of_type_Boolean = false;
      } else {
        this.jdField_k_of_type_Boolean = true;
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("param.content", this.jdField_k_of_type_JavaLangString);
    localBundle.putInt("param.priv", this.jdField_a_of_type_Int);
    localBundle.putStringArrayList("param.privList", this.jdField_a_of_type_JavaUtilArrayList);
    localBundle.putInt("PhotoConst.EDIT_LOCAL_VIDEO_ENTRY", this.jdField_p_of_type_Int);
    localBundle.putString("file_send_path", this.jdField_i_of_type_JavaLangString);
    localBundle.putString("param.videoPath", this.jdField_h_of_type_JavaLangString);
    localBundle.putLong("param.videoSize", this.jdField_a_of_type_Long);
    localBundle.putInt("param.videoType", 1);
    localBundle.putString("param.thumbnailPath", this.jdField_g_of_type_JavaLangString);
    localBundle.putInt("param.thumbnailHeight", this.jdField_g_of_type_Int);
    localBundle.putInt("param.thumbnailWidth", this.jdField_f_of_type_Int);
    localBundle.putLong("param.startTime", this.jdField_c_of_type_Int);
    localBundle.putLong("param.duration", this.jdField_d_of_type_Int - this.jdField_c_of_type_Int);
    localBundle.putLong("param.totalDuration", this.jdField_b_of_type_Long);
    localBundle.putBoolean("param.needProcess", this.jdField_k_of_type_Boolean);
    localBundle.putBoolean("param.isUploadOrigin", this.jdField_j_of_type_Boolean);
    localBundle.putString("param.topicId", this.jdField_l_of_type_JavaLangString);
    localBundle.putBoolean("param.topicSyncQzone", this.jdField_m_of_type_Boolean);
    localBundle.putBoolean("param.isSyncToQQStory", this.jdField_p_of_type_Boolean);
    localBundle.putParcelable("param.QzoneTopic", this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo);
    int i1 = this.jdField_m_of_type_Int;
    if (i1 >= 0)
    {
      localBundle.putInt("extra_key_font_id", i1);
      localBundle.putInt("extra_key_font_format_type", this.jdField_n_of_type_Int);
      localBundle.putString("extra_key_font_url", this.jdField_m_of_type_JavaLangString);
    }
    i1 = this.jdField_o_of_type_Int;
    if (i1 >= 0)
    {
      localBundle.putInt("extra_key_super_font_id", i1);
      localBundle.putString("extra_key_super_font_info", this.jdField_n_of_type_JavaLangString);
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("sv_encode_max_bitrate", CodecParam.mMaxrate);
    ((Bundle)localObject1).putInt("sv_encode_min_bitrate", CodecParam.mMinrate);
    ((Bundle)localObject1).putInt("sv_encode_qmax", CodecParam.mQmax);
    ((Bundle)localObject1).putInt("sv_encode_qmin", CodecParam.mQmin);
    ((Bundle)localObject1).putInt("sv_encode_qmaxdiff", CodecParam.mMaxQdiff);
    ((Bundle)localObject1).putInt("sv_encode_ref_frame", CodecParam.mRefframe);
    ((Bundle)localObject1).putInt("sv_encode_smooth", CodecParam.mIsSmooth);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
    if (localObject2 != null)
    {
      if (((RMVideoStateMgr)localObject2).jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
        ((Bundle)localObject1).putInt("sv_total_frame_count", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex());
      }
      ((Bundle)localObject1).putInt("sv_total_record_time", (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
    }
    i1 = 201;
    localObject2 = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo;
    if (localObject2 != null) {
      if (((QzoneVerticalVideoTopicInfo)localObject2).hasMusic()) {
        i1 = 213;
      } else {
        i1 = 214;
      }
    }
    ((Bundle)localObject1).putInt("param.uploadEntrance", i1);
    localBundle.putBundle("param.extras", (Bundle)localObject1);
    if ((this.jdField_p_of_type_Int == 1) && (!this.jdField_f_of_type_Boolean))
    {
      localObject1 = this.jdField_i_of_type_JavaLangString;
      if ((localObject1 != null) && (((String)localObject1).equals(this.jdField_h_of_type_JavaLangString)))
      {
        localBundle.putBoolean("PhotoConst.EDIT_LOCAL_VIDEO_DONOTHING_RETURN", true);
        break label693;
      }
    }
    a("608", "1", "0", true);
    label693:
    long l1 = QzoneConfig.getInstance().getConfig("VideoEdit", "UploadMaxSizeTipWithNoWifi", 20971520L);
    if ((NetworkUtil.getNetworkType(BaseApplication.getContext()) != 1) && (this.jdField_a_of_type_Long > l1))
    {
      localObject1 = this.jdField_a_of_type_ComTencentWidgetActionSheet;
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131703811));
        ((StringBuilder)localObject1).append(l1 / 1024L / 1024L);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131703817));
        localObject1 = ((StringBuilder)localObject1).toString();
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(this);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.setMainTitle((CharSequence)localObject1);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton("立即上传", 0);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new EditLocalVideoActivity.8(this, localBundle));
        this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new EditLocalVideoActivity.9(this));
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        return;
      }
      if (!((ActionSheet)localObject1).isShowing()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      }
    }
    else
    {
      a(localBundle);
    }
  }
  
  private void o()
  {
    EditLocalVideoMusicMixer localEditLocalVideoMusicMixer = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer;
    if ((localEditLocalVideoMusicMixer != null) && (localEditLocalVideoMusicMixer.b()))
    {
      p();
      return;
    }
    n();
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer.a(new EditLocalVideoActivity.10(this));
  }
  
  private void q()
  {
    QZoneHelper.showQzoneVipOriginalVideoDialog(this, new EditLocalVideoActivity.11(this));
  }
  
  private void r()
  {
    int i3 = (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.a();
    int i4 = (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.b();
    if (!b())
    {
      Toast.makeText(MobileQQ.getContext(), HardCodeUtil.a(2131703807), 1).show();
      return;
    }
    this.jdField_k_of_type_Boolean = true;
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
    if (jdField_n_of_type_Boolean)
    {
      localObject2 = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject2).setDataSource(this.jdField_j_of_type_JavaLangString);
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
      if (ThumbnailUtils.a(this.jdField_j_of_type_JavaLangString, this.jdField_j_of_type_Int, this.jdField_k_of_type_Int) == 0) {
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
        if (c())
        {
          if (i3 <= 1000) {
            localObject1 = this.jdField_g_of_type_JavaLangString;
          } else {
            localObject1 = "";
          }
          i2 = this.jdField_f_of_type_Int;
          i1 = this.jdField_g_of_type_Int;
          localObject2 = null;
          break;
        }
        localObject1 = null;
      }
    }
    if (localObject2 != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(GloableValue.jdField_a_of_type_JavaLangString);
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
        QzoneVideoBeaconReport.reportVideoEvent(String.valueOf(this.jdField_d_of_type_Long), "qzone_video_trim", "4", null);
        localObject1 = "";
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "getFrame failed");
      }
      QzoneVideoBeaconReport.reportVideoEvent(String.valueOf(this.jdField_d_of_type_Long), "qzone_video_trim", "5", null);
    }
    GloableValue.b();
    this.jdField_c_of_type_Int = i3;
    this.jdField_d_of_type_Int = i4;
    this.jdField_g_of_type_JavaLangString = ((String)localObject1);
    this.jdField_g_of_type_Int = i1;
    this.jdField_f_of_type_Int = i2;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity$TrimHandler.sendEmptyMessage(1103);
  }
  
  private void s()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.c())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.start();
      b(false);
      this.jdField_f_of_type_Boolean = false;
      return;
    }
    ActionSheet localActionSheet = ActionSheet.create(this);
    localActionSheet.setMainTitle(HardCodeUtil.a(2131703804));
    localActionSheet.addButton(2131692932, 3);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new EditLocalVideoActivity.12(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void t()
  {
    u();
    long l1 = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoDurationThreshold", 90000);
    PressDarkImageButton localPressDarkImageButton;
    if (this.jdField_b_of_type_Long > l1)
    {
      this.jdField_b_of_type_Boolean = false;
      localPressDarkImageButton = this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
      if (localPressDarkImageButton != null) {
        localPressDarkImageButton.getDrawable().setColorFilter(-7829368, PorterDuff.Mode.MULTIPLY);
      }
    }
    else
    {
      this.jdField_b_of_type_Boolean = true;
      localPressDarkImageButton = this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
      if (localPressDarkImageButton != null) {
        localPressDarkImageButton.getDrawable().clearColorFilter();
      }
    }
    l1 = QzoneConfig.getInstance().getConfig("VideoEdit", "SupportMixMusicMaxSize", 524288000L);
    if (this.jdField_a_of_type_Long <= 0L) {
      this.jdField_a_of_type_Long = new File(this.jdField_h_of_type_JavaLangString).length();
    }
    if (this.jdField_a_of_type_Long > l1)
    {
      this.jdField_c_of_type_Boolean = false;
      localPressDarkImageButton = this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
      if (localPressDarkImageButton != null) {
        localPressDarkImageButton.getDrawable().setColorFilter(-7829368, PorterDuff.Mode.MULTIPLY);
      }
    }
    else
    {
      this.jdField_c_of_type_Boolean = true;
      localPressDarkImageButton = this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
      if (localPressDarkImageButton != null) {
        localPressDarkImageButton.getDrawable().clearColorFilter();
      }
    }
    if (this.jdField_p_of_type_Int == 0) {
      a(true);
    }
    if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))
    {
      v();
      return;
    }
    QLog.e("EditLocalVideoActivity", 2, " localVideoPath is empty ");
  }
  
  private void u()
  {
    int i1 = this.jdField_p_of_type_Int;
    if (i1 == 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131694880);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695277);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer;
      if ((localObject == null) || (!((EditLocalVideoMusicMixer)localObject).a()))
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getResources().getColor(2131166500));
        VideoAnimation.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      }
    }
    else if (i1 == 1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131690529);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694583);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    VideoAnimation.a(this.jdField_a_of_type_AndroidWidgetTextView, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
    Object localObject = this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
    if (localObject != null) {
      ((PressDarkImageButton)localObject).setVisibility(0);
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
    if (localObject != null) {
      ((PressDarkImageButton)localObject).setVisibility(0);
    }
    VideoAnimation.a(this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
    VideoAnimation.a(this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
    a(false);
    VideoAnimation.a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
    if (!this.jdField_i_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130849474);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void v()
  {
    Object localObject;
    int i1;
    if (this.jdField_a_of_type_AndroidViewViewStub == null)
    {
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131374209));
      this.jdField_a_of_type_AndroidViewViewStub.inflate();
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
        QQToast.a(this, HardCodeUtil.a(2131703819), 0).a();
        finish();
      }
      if (!GloableValue.a(this.jdField_d_of_type_Long))
      {
        QQToast.a(this, HardCodeUtil.a(2131703801), 0).a();
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
          QQToast.a(this, HardCodeUtil.a(2131703825), 0).a();
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
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)$(2131365132));
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)$(2131380553));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)$(2131365305));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar = ((VideoFrameSelectBar)$(2131380521));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView = ((FixedSizeVideoView)$(2131380795));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)$(2131380854));
      this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)$(2131380522));
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)$(2131380523));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)$(2131380525));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)$(2131380524));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
    if ((this.jdField_h_of_type_Int != 0) && (this.jdField_i_of_type_Int != 0))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)$lp(this.jdField_b_of_type_AndroidViewViewGroup);
      localObject = (FrameLayout.LayoutParams)$lp(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView);
      FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)$lp(this.jdField_a_of_type_AndroidWidgetImageView);
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)$lp(this.jdField_b_of_type_AndroidWidgetImageView);
      int i5 = this.jdField_h_of_type_Int;
      int i4 = this.jdField_i_of_type_Int;
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
          localMediaMetadataRetriever.setDataSource(this.jdField_h_of_type_JavaLangString);
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
          localStringBuilder.append(this.jdField_h_of_type_Int);
          i1 = i5;
          i6 = i4;
          localStringBuilder.append(" localVideoHeight=");
          i1 = i5;
          i6 = i4;
          localStringBuilder.append(this.jdField_i_of_type_Int);
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
            i3 = this.jdField_i_of_type_Int;
            i1 = i3;
            i6 = i4;
            i2 = this.jdField_h_of_type_Int;
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
        localLayoutParams2.height = this.jdField_i_of_type_Int;
      }
      this.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams1);
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams2);
    }
    w();
    x();
    if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
      y();
    }
    b(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setVideoPath(this.jdField_h_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.start();
  }
  
  private void w()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new EditLocalVideoActivity.13(this));
    VideoFrameSelectBar localVideoFrameSelectBar = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar;
    if (localVideoFrameSelectBar != null) {
      localVideoFrameSelectBar.setOnFramesClipChangeListener(this);
    }
  }
  
  private void x()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setOnFixVDPlayCompelteListener(new EditLocalVideoActivity.14(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setOnErrorListener(new EditLocalVideoActivity.15(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setOnPreparedListener(new EditLocalVideoActivity.16(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setOnTouchListener(new EditLocalVideoActivity.17(this));
  }
  
  private void y()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity$TrimHandler.removeMessages(9999);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_j_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
    this.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
    long l1 = this.jdField_b_of_type_Long;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initData, videoPath=");
      localStringBuilder.append(this.jdField_j_of_type_JavaLangString);
      localStringBuilder.append(", videoSize=");
      localStringBuilder.append(this.jdField_c_of_type_Long);
      localStringBuilder.append(", duration:");
      localStringBuilder.append(l1);
      QLog.d("EditLocalVideoActivity", 2, localStringBuilder.toString());
    }
    this.jdField_l_of_type_Int = 2;
    if (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString))
    {
      int i1 = FormatDetector.a(this.jdField_j_of_type_JavaLangString);
      if (i1 != 0)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("format is not supported ret=");
          localStringBuilder.append(i1);
          QLog.d("EditLocalVideoActivity", 2, localStringBuilder.toString());
        }
        QzoneVideoBeaconReport.reportVideoEvent(String.valueOf(this.jdField_d_of_type_Long), "qzone_video_trim", "10", null);
        this.jdField_j_of_type_JavaLangString = null;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity$TrimHandler.sendEmptyMessage(1101);
        return;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setVideoPath:");
        localStringBuilder.append(this.jdField_j_of_type_JavaLangString);
        QLog.d("EditLocalVideoActivity", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setVideoPath(this.jdField_j_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity$TrimHandler.sendEmptyMessageDelayed(9999, 10000L);
      return;
    }
    setResult(0);
    finish();
  }
  
  private void z()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(PathUtils.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(jdField_d_of_type_JavaLangString);
    jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(PathUtils.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(jdField_e_of_type_JavaLangString);
    jdField_f_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    try
    {
      localObject = new ArrayList();
      Collections.addAll((Collection)localObject, new String[] { jdField_a_of_type_JavaLangString, jdField_f_of_type_JavaLangString });
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
      localStringBuilder.append(jdField_f_of_type_JavaLangString);
      localStringBuilder.append(".nomedia");
      com.tencent.mobileqq.utils.FileUtils.createFileIfNotExits(localStringBuilder.toString());
    }
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
    //   0: ldc 128
    //   2: astore 6
    //   4: invokestatic 578	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 1725	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
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
    //   28: new 56	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   35: astore 9
    //   37: aload 4
    //   39: astore 5
    //   41: aload 6
    //   43: astore_3
    //   44: aload 7
    //   46: astore_2
    //   47: aload 9
    //   49: ldc_w 1727
    //   52: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 4
    //   58: astore 5
    //   60: aload 6
    //   62: astore_3
    //   63: aload 7
    //   65: astore_2
    //   66: aload 9
    //   68: aload_1
    //   69: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 4
    //   75: astore 5
    //   77: aload 6
    //   79: astore_3
    //   80: aload 7
    //   82: astore_2
    //   83: aload 8
    //   85: aload 9
    //   87: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 1733	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   93: aconst_null
    //   94: ldc_w 1735
    //   97: iconst_1
    //   98: anewarray 375	java/lang/String
    //   101: dup
    //   102: iconst_0
    //   103: aload_1
    //   104: aastore
    //   105: aconst_null
    //   106: invokevirtual 1741	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   109: astore 7
    //   111: aload 6
    //   113: astore 4
    //   115: aload 7
    //   117: ifnull +199 -> 316
    //   120: aload 6
    //   122: astore 4
    //   124: aload 7
    //   126: astore 5
    //   128: aload 6
    //   130: astore_3
    //   131: aload 7
    //   133: astore_2
    //   134: aload 7
    //   136: invokeinterface 1746 1 0
    //   141: ifeq +175 -> 316
    //   144: aload 7
    //   146: astore 5
    //   148: aload 6
    //   150: astore_3
    //   151: aload 7
    //   153: astore_2
    //   154: aload 7
    //   156: aload 7
    //   158: ldc_w 1748
    //   161: invokeinterface 1751 2 0
    //   166: invokeinterface 1752 2 0
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
    //   188: invokestatic 616	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   191: ifne +32 -> 223
    //   194: aload 7
    //   196: astore 5
    //   198: aload 6
    //   200: astore_3
    //   201: aload 7
    //   203: astore_2
    //   204: new 375	java/lang/String
    //   207: dup
    //   208: aload 4
    //   210: invokevirtual 1756	java/lang/String:getBytes	()[B
    //   213: ldc_w 1758
    //   216: invokespecial 1761	java/lang/String:<init>	([BLjava/lang/String;)V
    //   219: invokestatic 1766	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   222: astore_1
    //   223: aload_1
    //   224: astore 4
    //   226: aload 7
    //   228: astore 5
    //   230: aload_1
    //   231: astore_3
    //   232: aload 7
    //   234: astore_2
    //   235: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +78 -> 316
    //   241: aload 7
    //   243: astore 5
    //   245: aload_1
    //   246: astore_3
    //   247: aload 7
    //   249: astore_2
    //   250: new 56	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   257: astore 4
    //   259: aload 7
    //   261: astore 5
    //   263: aload_1
    //   264: astore_3
    //   265: aload 7
    //   267: astore_2
    //   268: aload 4
    //   270: ldc_w 1768
    //   273: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 7
    //   279: astore 5
    //   281: aload_1
    //   282: astore_3
    //   283: aload 7
    //   285: astore_2
    //   286: aload 4
    //   288: aload_1
    //   289: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 7
    //   295: astore 5
    //   297: aload_1
    //   298: astore_3
    //   299: aload 7
    //   301: astore_2
    //   302: ldc 250
    //   304: iconst_2
    //   305: aload 4
    //   307: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 676	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: aload_1
    //   314: astore 4
    //   316: aload 4
    //   318: astore_1
    //   319: aload 7
    //   321: ifnull +91 -> 412
    //   324: aload 7
    //   326: astore_2
    //   327: aload 4
    //   329: astore_3
    //   330: aload_2
    //   331: invokeinterface 1769 1 0
    //   336: aload_3
    //   337: areturn
    //   338: astore_1
    //   339: goto +75 -> 414
    //   342: astore_1
    //   343: aload_2
    //   344: astore 5
    //   346: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   349: ifeq +54 -> 403
    //   352: aload_2
    //   353: astore 5
    //   355: new 56	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   362: astore 4
    //   364: aload_2
    //   365: astore 5
    //   367: aload 4
    //   369: ldc_w 1771
    //   372: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload_2
    //   377: astore 5
    //   379: aload 4
    //   381: aload_1
    //   382: invokestatic 1775	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   385: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload_2
    //   390: astore 5
    //   392: ldc 250
    //   394: iconst_2
    //   395: aload 4
    //   397: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 852	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: aload_3
    //   404: astore_1
    //   405: aload_2
    //   406: ifnull +6 -> 412
    //   409: goto -79 -> 330
    //   412: aload_1
    //   413: areturn
    //   414: aload 5
    //   416: ifnull +10 -> 426
    //   419: aload 5
    //   421: invokeinterface 1769 1 0
    //   426: goto +5 -> 431
    //   429: aload_1
    //   430: athrow
    //   431: goto -2 -> 429
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	EditLocalVideoActivity
    //   0	434	1	paramString	String
    //   27	379	2	localCursor1	android.database.Cursor
    //   24	380	3	localObject1	Object
    //   16	380	4	localObject2	Object
    //   20	400	5	localObject3	Object
    //   2	197	6	str	String
    //   13	312	7	localCursor2	android.database.Cursor
    //   10	74	8	localContentResolver	android.content.ContentResolver
    //   35	51	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   28	37	338	finally
    //   47	56	338	finally
    //   66	73	338	finally
    //   83	111	338	finally
    //   134	144	338	finally
    //   154	173	338	finally
    //   186	194	338	finally
    //   204	223	338	finally
    //   235	241	338	finally
    //   250	259	338	finally
    //   268	277	338	finally
    //   286	293	338	finally
    //   302	313	338	finally
    //   346	352	338	finally
    //   355	364	338	finally
    //   367	376	338	finally
    //   379	389	338	finally
    //   392	403	338	finally
    //   28	37	342	java/lang/Exception
    //   47	56	342	java/lang/Exception
    //   66	73	342	java/lang/Exception
    //   83	111	342	java/lang/Exception
    //   134	144	342	java/lang/Exception
    //   154	173	342	java/lang/Exception
    //   186	194	342	java/lang/Exception
    //   204	223	342	java/lang/Exception
    //   235	241	342	java/lang/Exception
    //   250	259	342	java/lang/Exception
    //   268	277	342	java/lang/Exception
    //   286	293	342	java/lang/Exception
    //   302	313	342	java/lang/Exception
  }
  
  protected void a()
  {
    setContentViewNoTitle(2131561155);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)$(2131366063));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)$(2131366999));
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)$(2131366995));
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)$(2131366994));
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)$(2131367022));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)$(2131367020));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)$(2131367005));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)$(2131367006));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)$(2131367007));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)$(2131366996));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)AIOUtils.a(2, 50, getResources()));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getResources().getColor(2131166500));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = AIOUtils.b(55.0F, getResources());
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText = ((ExtendEditText)$(2131366997));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setEditableFactory(QzoneTextBuilder.a);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)$(2131367016));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = $(2131367018);
    i();
    j();
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer;
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
    QZoneClickReport.report(String.valueOf(this.jdField_d_of_type_Long), localReportInfo, paramBoolean);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setText(b(this.jdField_a_of_type_Int));
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
        b();
      }
    }
    else if (paramInt1 == 1009)
    {
      this.jdField_e_of_type_Boolean = false;
      localObject = this.jdField_b_of_type_AndroidViewView;
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
          this.jdField_k_of_type_JavaLangString = paramIntent;
        }
        if (localBundle.containsKey("contentIntentKeyForVideoEditWithEmo"))
        {
          paramIntent = localBundle.getString("contentIntentKeyForVideoEditWithEmo");
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setText(paramIntent);
        }
        this.jdField_m_of_type_Int = localBundle.getInt("extra_key_font_id", -1);
        this.jdField_n_of_type_Int = localBundle.getInt("extra_key_font_format_type");
        this.jdField_m_of_type_JavaLangString = localBundle.getString("extra_key_font_url");
        this.jdField_o_of_type_Int = localBundle.getInt("extra_key_super_font_id", -1);
        this.jdField_n_of_type_JavaLangString = localBundle.getString("extra_key_super_font_info");
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity$TrimHandler.sendEmptyMessage(1009);
      }
    }
    else if ((paramInt1 == 1010) && (paramInt2 == -1))
    {
      ToastUtil.a().a(2131717396);
      this.jdField_i_of_type_Boolean = true;
    }
  }
  
  public void onBackPressed()
  {
    this.jdField_o_of_type_Boolean = true;
    k();
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
    case 2131380524: 
      LpReportInfo_pf00064.allReport(664, 4, 3);
      a("608", "4", "1", true);
      QzoneHandlerThreadFactory.getHandlerThread("RealTime_HandlerThread").post(new EditLocalVideoActivity.5(this));
      break;
    case 2131380523: 
      LpReportInfo_pf00064.allReport(664, 4, 2);
      s();
      break;
    case 2131367022: 
      o();
      break;
    case 2131367020: 
      LpReportInfo_pf00064.allReport(664, 1);
      this.jdField_o_of_type_Boolean = false;
      k();
      break;
    case 2131367016: 
      localObject1 = QzoneConfig.getInstance().getConfig("H5Url", "UgcPermitSetting", "https://h5.qzone.qq.com/ugc/setting?_wv=3&type=mood&uin={uin}&qua={qua}&_proxy=1").replace("{uin}", String.valueOf(this.jdField_d_of_type_Long)).replace("{qua}", QUA.getQUA3());
      a("608", "6", "0", true);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("permission_code", this.jdField_a_of_type_Int);
      localObject3 = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
      {
        ((Bundle)localObject2).putStringArrayList("uin_list", this.jdField_a_of_type_JavaUtilArrayList);
        localObject3 = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((ArrayList)localObject3).add(a((String)localIterator.next()));
        }
        ((Bundle)localObject2).putStringArrayList("key_nicknames", (ArrayList)localObject3);
      }
      if ((a(this.jdField_a_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
        ((Bundle)localObject2).putString("key_setting_raw_json", this.jdField_c_of_type_JavaLangString);
      }
      QZoneHelper.forwardToBrowser(this, (String)localObject1, 2, (Bundle)localObject2, "");
      break;
    case 2131367005: 
    case 2131367006: 
      if (!this.jdField_i_of_type_Boolean) {
        q();
      }
      break;
    }
    for (;;)
    {
      break;
      if (this.jdField_a_of_type_Boolean)
      {
        ToastUtil.a().a(2131717678);
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130849474);
        this.jdField_j_of_type_Boolean = false;
      }
      else
      {
        ToastUtil.a().a(2131717680);
        a("608", "7", "1", true);
        this.jdField_a_of_type_Boolean = true;
        this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130849473);
        this.jdField_j_of_type_Boolean = true;
        continue;
        this.jdField_e_of_type_Boolean = true;
        a("608", "5", "0", true);
        localObject2 = QZoneHelper.UserInfo.getInstance();
        localObject3 = new Bundle();
        ((Bundle)localObject3).putInt("permission_code", this.jdField_a_of_type_Int);
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          ((Bundle)localObject3).putStringArrayList("uin_list", this.jdField_a_of_type_JavaUtilArrayList);
          localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
          localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext()) {
            ((ArrayList)localObject1).add(a((String)localIterator.next()));
          }
          ((Bundle)localObject3).putStringArrayList("key_nicknames", (ArrayList)localObject1);
        }
        if ((a(this.jdField_a_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
          ((Bundle)localObject3).putString("key_setting_raw_json", this.jdField_c_of_type_JavaLangString);
        }
        if (this.jdField_b_of_type_AndroidViewView == null)
        {
          this.jdField_b_of_type_AndroidViewView = new View(this);
          this.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.argb(128, 0, 0, 0));
          this.jdField_b_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidViewView);
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText;
        if (localObject1 != null) {
          localObject1 = ((ExtendEditText)localObject1).getText().toString();
        } else {
          localObject1 = "";
        }
        boolean bool = this.jdField_l_of_type_Boolean;
        QZoneHelper.forwardToVideoEditActionPanel(this, (QZoneHelper.UserInfo)localObject2, 1009, "", (String)localObject1, "", "", 0, bool ^ true, 1, 0, 0, 0, "", 10000, (Bundle)localObject3, bool, this.jdField_m_of_type_Boolean, this.jdField_m_of_type_Int, this.jdField_o_of_type_Int, false);
        break;
        LpReportInfo_pf00064.allReport(664, 3, 1);
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_d_of_type_Boolean = true;
          m();
          l();
        }
        else
        {
          Toast.makeText(getApplicationContext(), HardCodeUtil.a(2131703802), 1).show();
          break;
          LpReportInfo_pf00064.allReport(664, 4, 1);
          if (this.jdField_b_of_type_Boolean)
          {
            QLog.e("EditLocalVideoActivity", 2, "click clip ");
            localObject1 = a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, false);
            if (localObject1 != null) {
              this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
            } else {
              QLog.e("EditLocalVideoActivity", 2, "click clip but coverview find bitmap is null");
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.jdField_b_of_type_Int);
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
            this.jdField_g_of_type_Boolean = true;
            b(true);
          }
          else
          {
            long l1 = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoDurationThreshold", 90000);
            localObject1 = getApplicationContext();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131703808));
            ((StringBuilder)localObject2).append(l1 / 1000L);
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131703823));
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
    z();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    h();
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    QzoneGuideBubbleHelper.getInstance().dismissGuideBubble();
    EditLocalVideoMusicMixer localEditLocalVideoMusicMixer = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer;
    if (localEditLocalVideoMusicMixer != null) {
      localEditLocalVideoMusicMixer.c();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {
      if (!this.jdField_g_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
      } else if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.isPlaying()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
      }
    }
    EditLocalVideoMusicMixer localEditLocalVideoMusicMixer = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer;
    if (localEditLocalVideoMusicMixer != null) {
      localEditLocalVideoMusicMixer.d();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.jdField_d_of_type_Boolean)
    {
      LpReportInfo_pf00064.allReport(664, 3, 2);
      this.jdField_d_of_type_Boolean = false;
    }
    t();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView;
    if (localObject != null)
    {
      if (!this.jdField_g_of_type_Boolean)
      {
        ((FixedSizeVideoView)localObject).seekTo(this.jdField_c_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.start();
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      else
      {
        localObject = a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, false);
        if (localObject != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
        }
        b(true);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer;
      if (localObject != null) {
        ((EditLocalVideoMusicMixer)localObject).e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity
 * JD-Core Version:    0.7.0.1
 */