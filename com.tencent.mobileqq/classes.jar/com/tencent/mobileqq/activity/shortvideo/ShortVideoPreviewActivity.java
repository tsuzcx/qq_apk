package com.tencent.mobileqq.activity.shortvideo;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.mediacodec.ShortVideoCodec;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer.CompressConfig;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.Processor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.video.IMediaPlayer;
import com.tencent.mobileqq.video.IMediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.video.IMediaPlayer.OnPlayStateListener;
import com.tencent.mobileqq.video.IMediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.video.LocalVideoMediaPlayer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;
import yef;
import yeg;
import yeh;
import yei;
import yej;
import yek;
import yel;
import yem;
import yen;
import yeo;
import yep;
import yeq;
import yer;
import yes;
import yet;
import yeu;
import yev;
import yew;
import yex;
import yey;
import yez;

public class ShortVideoPreviewActivity
  extends BaseActivity
  implements View.OnClickListener, Runnable
{
  public static int i;
  public int a;
  public long a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new yef(this);
  public Bitmap a;
  SurfaceHolder.Callback jdField_a_of_type_AndroidViewSurfaceHolder$Callback = new yet(this);
  public SurfaceView a;
  public ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new yer(this);
  public SeekBar a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private IMediaPlayer.OnCompletionListener jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer$OnCompletionListener = new yew(this);
  private IMediaPlayer.OnPlayStateListener jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer$OnPlayStateListener = new yex(this);
  private IMediaPlayer.OnPreparedListener jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer$OnPreparedListener = new yev(this);
  public IMediaPlayer a;
  public Runnable a;
  String jdField_a_of_type_JavaLangString;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  public final MqqHandler a;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  public long b;
  public ImageView b;
  public TextView b;
  public String b;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  public ImageView c;
  public TextView c;
  public String c;
  boolean jdField_c_of_type_Boolean = false;
  int d;
  public TextView d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int j;
  
  public ShortVideoPreviewActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer = new LocalVideoMediaPlayer();
    this.jdField_a_of_type_MqqOsMqqHandler = new yeo(this);
    this.jdField_a_of_type_JavaLangRunnable = new yep(this);
  }
  
  /* Error */
  public static String a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 7
    //   8: aconst_null
    //   9: astore 4
    //   11: new 106	java/io/File
    //   14: dup
    //   15: new 108	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   22: getstatic 114	com/tencent/mobileqq/app/AppConstants:aJ	Ljava/lang/String;
    //   25: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 120
    //   30: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokespecial 127	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore 5
    //   41: aload 5
    //   43: invokevirtual 131	java/io/File:exists	()Z
    //   46: ifne +9 -> 55
    //   49: aload 5
    //   51: invokevirtual 134	java/io/File:mkdirs	()Z
    //   54: pop
    //   55: invokestatic 140	java/lang/System:currentTimeMillis	()J
    //   58: lstore_1
    //   59: aload_0
    //   60: ifnull +92 -> 152
    //   63: new 106	java/io/File
    //   66: dup
    //   67: aload 5
    //   69: new 108	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   76: lload_1
    //   77: invokestatic 146	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   80: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 148
    //   85: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokespecial 151	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   94: astore 5
    //   96: aload 5
    //   98: invokevirtual 154	java/io/File:createNewFile	()Z
    //   101: ifeq +205 -> 306
    //   104: aload 5
    //   106: invokevirtual 157	java/io/File:getPath	()Ljava/lang/String;
    //   109: astore_3
    //   110: new 159	java/io/FileOutputStream
    //   113: dup
    //   114: aload 5
    //   116: invokevirtual 157	java/io/File:getPath	()Ljava/lang/String;
    //   119: invokespecial 160	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   122: astore 4
    //   124: aload_0
    //   125: getstatic 166	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   128: bipush 100
    //   130: aload 4
    //   132: invokevirtual 172	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   135: pop
    //   136: aload_3
    //   137: astore_0
    //   138: aload_0
    //   139: astore_3
    //   140: aload 4
    //   142: ifnull +10 -> 152
    //   145: aload 4
    //   147: invokevirtual 175	java/io/FileOutputStream:close	()V
    //   150: aload_0
    //   151: astore_3
    //   152: aload_3
    //   153: areturn
    //   154: astore 5
    //   156: aconst_null
    //   157: astore 4
    //   159: aload 6
    //   161: astore_0
    //   162: aload 4
    //   164: astore_3
    //   165: aload 5
    //   167: invokevirtual 178	java/lang/OutOfMemoryError:printStackTrace	()V
    //   170: aload_0
    //   171: astore_3
    //   172: aload 4
    //   174: ifnull -22 -> 152
    //   177: aload 4
    //   179: invokevirtual 175	java/io/FileOutputStream:close	()V
    //   182: aload_0
    //   183: areturn
    //   184: astore_3
    //   185: aload_0
    //   186: areturn
    //   187: astore 5
    //   189: aconst_null
    //   190: astore 4
    //   192: aload 7
    //   194: astore_0
    //   195: aload 4
    //   197: astore_3
    //   198: ldc 180
    //   200: iconst_1
    //   201: new 108	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   208: ldc 182
    //   210: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload 5
    //   215: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 190	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: aload_0
    //   225: astore_3
    //   226: aload 4
    //   228: ifnull -76 -> 152
    //   231: aload 4
    //   233: invokevirtual 175	java/io/FileOutputStream:close	()V
    //   236: aload_0
    //   237: areturn
    //   238: astore_3
    //   239: aload_0
    //   240: areturn
    //   241: astore_0
    //   242: aconst_null
    //   243: astore_3
    //   244: aload_3
    //   245: ifnull +7 -> 252
    //   248: aload_3
    //   249: invokevirtual 175	java/io/FileOutputStream:close	()V
    //   252: aload_0
    //   253: athrow
    //   254: astore_3
    //   255: aload_0
    //   256: areturn
    //   257: astore_3
    //   258: goto -6 -> 252
    //   261: astore_0
    //   262: aload 4
    //   264: astore_3
    //   265: goto -21 -> 244
    //   268: astore_0
    //   269: goto -25 -> 244
    //   272: astore 5
    //   274: aload_3
    //   275: astore_0
    //   276: aconst_null
    //   277: astore 4
    //   279: goto -84 -> 195
    //   282: astore 5
    //   284: aload_3
    //   285: astore_0
    //   286: goto -91 -> 195
    //   289: astore 5
    //   291: aload_3
    //   292: astore_0
    //   293: aconst_null
    //   294: astore 4
    //   296: goto -134 -> 162
    //   299: astore 5
    //   301: aload_3
    //   302: astore_0
    //   303: goto -141 -> 162
    //   306: aconst_null
    //   307: astore_3
    //   308: aload 4
    //   310: astore_0
    //   311: aload_3
    //   312: astore 4
    //   314: goto -176 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	paramBitmap	Bitmap
    //   58	19	1	l	long
    //   1	171	3	localObject1	Object
    //   184	1	3	localException1	java.lang.Exception
    //   197	29	3	localObject2	Object
    //   238	1	3	localException2	java.lang.Exception
    //   243	6	3	localObject3	Object
    //   254	1	3	localException3	java.lang.Exception
    //   257	1	3	localException4	java.lang.Exception
    //   264	48	3	localObject4	Object
    //   9	304	4	localObject5	Object
    //   39	76	5	localFile	File
    //   154	12	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   187	27	5	localException5	java.lang.Exception
    //   272	1	5	localException6	java.lang.Exception
    //   282	1	5	localException7	java.lang.Exception
    //   289	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   299	1	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   3	157	6	localObject6	Object
    //   6	187	7	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   96	110	154	java/lang/OutOfMemoryError
    //   177	182	184	java/lang/Exception
    //   96	110	187	java/lang/Exception
    //   231	236	238	java/lang/Exception
    //   96	110	241	finally
    //   110	124	241	finally
    //   145	150	254	java/lang/Exception
    //   248	252	257	java/lang/Exception
    //   124	136	261	finally
    //   165	170	268	finally
    //   198	224	268	finally
    //   110	124	272	java/lang/Exception
    //   124	136	282	java/lang/Exception
    //   110	124	289	java/lang/OutOfMemoryError
    //   124	136	299	java/lang/OutOfMemoryError
  }
  
  public static HashMap a(String paramString, Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    String str = ShortVideoUtils.c(paramString, paramString.substring(paramString.lastIndexOf(".") + 1));
    Object localObject1 = ShortVideoTrimmer.a(paramString);
    int k;
    boolean bool;
    int m;
    if ((localObject1 != null) && (((ShortVideoTrimmer.CompressConfig)localObject1).jdField_a_of_type_Boolean)) {
      if (Build.VERSION.SDK_INT >= 18)
      {
        Object localObject2 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject2).setDataSource(paramString);
        long l = Long.parseLong(((MediaMetadataRetriever)localObject2).extractMetadata(9));
        k = ShortVideoCodec.b(paramContext);
        if (((k & 0x1) > 0) && ((k & 0x2) > 0))
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("VideoCompressTask", 2, "CompressTask, step: isHWCodecSupported = " + bool);
          }
          if (!bool) {
            break label334;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoCompressTask", 2, "CompressTask, step: Try to compress using MediaCodec");
          }
          localObject2 = new File(paramString);
          localObject1 = new ShortVideoPreviewActivity.HWCompressProcessor(str, (int)(((ShortVideoTrimmer.CompressConfig)localObject1).jdField_b_of_type_Long * 1024L), (int)((ShortVideoTrimmer.CompressConfig)localObject1).jdField_a_of_type_Long, 0L, l);
          if ((!new VideoConverter().a((File)localObject2, (VideoConverter.Processor)localObject1, true)) || (((ShortVideoPreviewActivity.HWCompressProcessor)localObject1).a != null)) {
            break label319;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoCompressTask", 2, "CompressTask, step: compress completed using MediaCodec");
          }
          m = 0;
          label235:
          k = m;
          localObject1 = str;
          if (m != 0)
          {
            k = m;
            localObject1 = str;
            if (!TextUtils.isEmpty(str))
            {
              if (QLog.isColorLevel()) {
                QLog.d("VideoCompressTask", 2, "CompressTask, step: Try to compress using ShortVideoTrimmer.compressVideo");
              }
              k = ShortVideoTrimmer.a(paramContext, paramString, str);
              localObject1 = str;
            }
          }
        }
      }
    }
    for (;;)
    {
      localHashMap.put("outputPath", localObject1);
      localHashMap.put("ret", String.valueOf(k));
      return localHashMap;
      bool = false;
      break;
      label319:
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressTask", 2, "CompressTask, step: compress failed using MediaCodecr");
      }
      label334:
      m = -1;
      break label235;
      if ((localObject1 != null) && (!((ShortVideoTrimmer.CompressConfig)localObject1).jdField_a_of_type_Boolean))
      {
        k = 0;
        localObject1 = paramString;
      }
      else
      {
        k = -1;
        localObject1 = str;
      }
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    DialogUtil.a(paramContext, 232, null, paramContext.getString(paramInt), new yem(), null).show();
  }
  
  private void f()
  {
    this.jdField_a_of_type_Long = new File(this.jdField_c_of_type_JavaLangString).length();
    if ((NetworkUtil.g(this)) && (!NetworkUtil.h(this)) && (this.jdField_a_of_type_Long > FMConfig.a()))
    {
      FMDialogUtil.a(this, 2131428241, 2131428237, new yel(this));
      return;
    }
    g();
    setResult(-1);
  }
  
  private void g()
  {
    Intent localIntent = getIntent();
    String str2 = localIntent.getStringExtra("PhotoConst.DEST_VIDEO_ACTIVITY_CLASS_NAME");
    Object localObject = localIntent.getStringExtra("PhotoConst.DEST_VIDEO_ACTIVITY_PACKAGE_NAME");
    String str1 = str2;
    if (str2 == null)
    {
      str2 = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      localObject = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      str1 = str2;
      if (str2 == null)
      {
        QQToast.a(this, "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
        return;
      }
    }
    localIntent.setClassName((String)localObject, str1);
    localIntent.putExtra("file_send_path", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("file_send_duration", this.jdField_b_of_type_Long);
    localIntent.putExtra("file_send_size", this.jdField_a_of_type_Long);
    localIntent.putExtra("uin", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_b_of_type_Int);
    localIntent.putExtra("file_source", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("start_init_activity_after_sended", true);
    if (!this.jdField_a_of_type_Boolean) {
      ReportController.b(null, "CliOper", "", "", "0X8006130", "0X8006130", 0, 0, "", "", "", "");
    }
    localObject = getIntent();
    if ((localObject != null) && (((Intent)localObject).hasExtra("custom_shortvideopreview_sendbtn_reportActionName")))
    {
      str2 = ((Intent)localObject).getStringExtra("custom_shortvideopreview_sendbtn_reportActionName");
      str1 = ((Intent)localObject).getStringExtra("custom_shortvideopreview_sendbtn_reportReverse2");
      localObject = str1;
      if (str1 == null) {
        localObject = "";
      }
      if (str2 != null) {
        ReportController.b(null, "CliOper", "", "", str2, str2, 0, 0, (String)localObject, "", "", "");
      }
    }
    startActivity(localIntent);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.a();
  }
  
  public String a(int paramInt)
  {
    return LocalVideoMediaPlayer.a(paramInt);
  }
  
  void a()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      switch (this.j)
      {
      default: 
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131433016);
      }
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131430152);
        }
      }
      return;
      StringBuilder localStringBuilder = new StringBuilder("发送");
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        localStringBuilder.append("(").append(this.jdField_a_of_type_JavaUtilArrayList.size()).append(")");
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localStringBuilder);
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131433016);
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131430494);
    }
  }
  
  public void a(int paramInt)
  {
    if (!FileUtils.b(this.jdField_c_of_type_JavaLangString)) {
      QQToast.a(this, 2131437356, 0).a();
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.a(this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer$OnCompletionListener);
      this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.a(this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer$OnPreparedListener);
      this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.a(this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer$OnPlayStateListener);
      if (!this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.a(this.jdField_c_of_type_JavaLangString, paramInt)) {
        break;
      }
    } while (this.j == 10);
    this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.a(this.jdField_a_of_type_AndroidViewSurfaceView.getHolder());
    return;
    DialogUtil.a(this, 232, null, getString(2131437366), new yeu(this), null).show();
  }
  
  void a(Intent paramIntent)
  {
    this.jdField_c_of_type_JavaLangString = paramIntent.getExtras().getString("file_send_path");
    this.jdField_b_of_type_Long = paramIntent.getExtras().getLong("file_send_duration");
    this.jdField_a_of_type_Long = paramIntent.getExtras().getLong("file_send_size");
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("file_width", 0);
    this.jdField_d_of_type_Int = paramIntent.getIntExtra("file_height", 0);
    paramIntent.removeExtra("file_width");
    paramIntent.removeExtra("file_height");
    this.jdField_a_of_type_JavaLangString = paramIntent.getExtras().getString("uin");
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("file_source");
    this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("preview_only", false);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("is_from_system_media", true);
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", false);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    }
    boolean bool1 = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_BAR", false);
    boolean bool2 = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_REWARD", false);
    boolean bool3 = paramIntent.getBooleanExtra("from_health", false);
    paramIntent = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    if ((paramIntent.contains("SplashActivity")) || (paramIntent.contains("ChatActivity"))) {
      this.j = 0;
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || ((this.j != 2) && (this.j != 6) && (this.j != 10) && (!bool3) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) || (!FileUtils.b(this.jdField_c_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoPreviewActivity", 2, "ShortVideoPreviewActivity initData(),mVideoPath or mUin is empty or mVideoPath not exits, just finish.");
        }
        QQToast.a(this, 2131437356, 0).a();
        super.finish();
      }
      return;
      if ((paramIntent.contains("QZonePublishMoodTabActivity")) || (paramIntent.contains("QZonePublishMoodActivity"))) {
        this.j = 1;
      } else if (paramIntent.contains("QZoneUploadPhotoActivity")) {
        this.j = 1;
      } else if (bool1) {
        this.j = 2;
      } else if (bool2) {
        this.j = 5;
      } else if (paramIntent.contains("TrimVideoActivity")) {
        this.j = 3;
      } else if (paramIntent.contains("LiteActivity")) {
        this.j = 4;
      } else if ((paramIntent.contains("QQBrowserActivity")) || (paramIntent.contains("PublicAccountBrowser"))) {
        this.j = 6;
      } else if (bool3) {
        this.j = 7;
      } else if (paramIntent.contains("ReadInJoyDeliverVideoActivity")) {
        this.j = 10;
      } else {
        this.j = 0;
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "#resume#");
    }
    this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.a();
  }
  
  void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.c();
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.b();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    a(super.getIntent());
    if (paramBundle != null)
    {
      this.h = paramBundle.getInt("state_play_state");
      this.g = paramBundle.getInt("state_play_position");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "onCreate(), mSavedCurPosition : " + this.g + ",mSavedPlayState : " + a(this.h));
      }
    }
    super.setContentView(2130970625);
    this.jdField_a_of_type_AndroidViewSurfaceView = ((SurfaceView)findViewById(2131364941));
    this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().setType(3);
    this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().addCallback(this.jdField_a_of_type_AndroidViewSurfaceHolder$Callback);
    this.jdField_a_of_type_AndroidViewSurfaceView.getViewTreeObserver().addOnGlobalLayoutListener(new yeq(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364477));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371492));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371494));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371483));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131371486));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371489));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371491));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371488));
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130843336);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131371490));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_a_of_type_AndroidWidgetImageView.getViewTreeObserver().addOnGlobalLayoutListener(new yes(this));
    a();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    if (this.j == 10)
    {
      if (paramBundle != null) {
        break label427;
      }
      a(0);
    }
    label427:
    while (this.h != 1) {
      return true;
    }
    a(this.g);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "doOnDestroy");
    }
    c();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      if (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  void e()
  {
    Object localObject = Environment.getExternalStorageDirectory();
    int k;
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      k = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (k == 0)) {
        break label140;
      }
      k = 1;
    }
    for (;;)
    {
      if (k != 0)
      {
        if (Utils.b() > 512000L)
        {
          if (NetworkUtil.b(this))
          {
            this.jdField_a_of_type_Long = new File(this.jdField_c_of_type_JavaLangString).length();
            localObject = ShortVideoUtils.a(this, this.jdField_a_of_type_Long);
            DialogUtil.a(this, 232, null, String.format(getResources().getString(2131437376), new Object[] { localObject }), new yej(this), new yek(this)).show();
            return;
            k = 0;
            break;
            label140:
            k = 0;
            continue;
          }
          g();
          return;
        }
        a(this, 2131437372);
        return;
      }
    }
    QQToast.a(this, 1, 2131434770, 0).b(getTitleBarHeight());
  }
  
  @TargetApi(11)
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131371492: 
      super.finish();
      return;
    case 2131371483: 
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "handleClick: mPlayState = " + a(a()));
      }
      if ((this.h == 2) && (this.g > 0))
      {
        a(this.g);
        this.h = 0;
        this.g = 0;
        return;
      }
      switch (a())
      {
      default: 
        return;
      case 0: 
        if (this.app.c())
        {
          QQToast.a(this, 0, 2131437379, 0).a();
          return;
        }
        a(0);
        return;
      case 1: 
        d();
        return;
      case 2: 
        b();
        return;
      }
      a(0);
      return;
    case 2131371488: 
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "handleClick: mPlayState = " + a(a()));
      }
      if ((this.h == 2) && (this.g > 0))
      {
        a(this.g);
        this.h = 0;
        this.g = 0;
        return;
      }
      switch (a())
      {
      default: 
        return;
      case 0: 
        if (this.app.c())
        {
          QQToast.a(this, 0, 2131437379, 0).a();
          return;
        }
        a(0);
        return;
      case 1: 
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130843335);
        d();
        return;
      case 2: 
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130843336);
        b();
        return;
      }
      a(0);
      return;
    }
    ArrayList localArrayList;
    switch (this.j)
    {
    case 6: 
    default: 
      return;
    case 0: 
      e();
      return;
    case 4: 
      f();
      return;
    case 1: 
    case 3: 
      paramView = super.getIntent();
      paramView.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
      paramView.putExtra("PhotoConst.VIDEO_SIZE", this.jdField_a_of_type_Long);
      paramView.putExtra("file_send_duration", this.jdField_b_of_type_Long);
      localArrayList = new ArrayList();
      localArrayList.add(this.jdField_c_of_type_JavaLangString);
      PhotoUtils.a(this, paramView, localArrayList, 2, false);
      return;
    case 5: 
      paramView = super.getIntent();
      paramView.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
      paramView.putExtra("PhotoConst.VIDEO_SIZE", this.jdField_a_of_type_Long);
      paramView.putExtra("file_send_duration", this.jdField_b_of_type_Long);
      localArrayList = new ArrayList();
      localArrayList.add(this.jdField_c_of_type_JavaLangString);
      DialogUtil.a(this, 232, null, getString(2131430499, new Object[] { String.format("%.2fMB", new Object[] { Double.valueOf(this.jdField_a_of_type_Long / 1024.0D / 1024.0D) }) }), new yey(this, paramView, localArrayList), new yeg(this)).show();
      return;
    case 2: 
      DialogUtil.a(this, 232, null, getString(2131430499, new Object[] { String.format("%.2fMB", new Object[] { Double.valueOf(this.jdField_a_of_type_Long / 1024.0D / 1024.0D) }) }), new yeh(this), new yei(this)).show();
      paramView = new Intent("key_video_select_apply_click");
      paramView.putExtra("className", super.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
      sendBroadcast(paramView);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "ldStart Compress");
    }
    i = -1;
    new yez(this, this).execute(new String[] { this.jdField_c_of_type_JavaLangString });
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if ((a() == 1) || (a() == 2)) {
      this.g = this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer.b();
    }
    this.h = a();
    paramBundle.putInt("state_play_state", a());
    paramBundle.putInt("state_play_position", this.g);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "onSaveInstanceState: mSavedCurPosition: " + this.g + " ,playState = " + a(a()));
    }
  }
  
  public void onStart()
  {
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
    super.onStart();
  }
  
  protected void onStop()
  {
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    }
    super.onStop();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void run()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = ShortVideoUtils.a(this, this.jdField_c_of_type_JavaLangString);
    runOnUiThread(new yen(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */