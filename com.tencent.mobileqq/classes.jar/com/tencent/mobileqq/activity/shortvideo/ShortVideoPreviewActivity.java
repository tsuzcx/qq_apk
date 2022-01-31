package com.tencent.mobileqq.activity.shortvideo;

import akds;
import akdt;
import akdu;
import akdv;
import akdw;
import akdx;
import akdy;
import akdz;
import akea;
import akeb;
import akec;
import aked;
import akee;
import akef;
import akeg;
import akeh;
import akei;
import akej;
import akek;
import akel;
import akem;
import alud;
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
import arbp;
import arre;
import azdd;
import azhc;
import azlf;
import azlu;
import azlv;
import azqs;
import bdeu;
import bdgm;
import bdhb;
import bdin;
import bdjz;
import bdzk;
import bdzl;
import bdzm;
import bdzn;
import bdzo;
import bezm;
import bhtb;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class ShortVideoPreviewActivity
  extends BaseActivity
  implements View.OnClickListener, Runnable
{
  public static int i;
  public int a;
  public long a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new akds(this);
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  SurfaceHolder.Callback jdField_a_of_type_AndroidViewSurfaceHolder$Callback = new akef(this);
  public SurfaceView a;
  public ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new aked(this);
  public SeekBar a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public bdzk a;
  private bdzl jdField_a_of_type_Bdzl = new akei(this);
  private bdzm jdField_a_of_type_Bdzm = new akej(this);
  private bdzn jdField_a_of_type_Bdzn = new akeh(this);
  public Runnable a;
  String jdField_a_of_type_JavaLangString;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
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
    this.jdField_a_of_type_Bdzk = new bdzo();
    this.jdField_a_of_type_MqqOsMqqHandler = new akec(this);
    this.jdField_a_of_type_JavaLangRunnable = new ShortVideoPreviewActivity.21(this);
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
    //   11: new 107	java/io/File
    //   14: dup
    //   15: new 109	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   22: getstatic 115	alof:aX	Ljava/lang/String;
    //   25: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 121
    //   30: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 130	bdzf:a	(Ljava/lang/String;)Ljava/lang/String;
    //   39: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore 5
    //   44: aload 5
    //   46: invokevirtual 137	java/io/File:exists	()Z
    //   49: ifne +9 -> 58
    //   52: aload 5
    //   54: invokevirtual 140	java/io/File:mkdirs	()Z
    //   57: pop
    //   58: invokestatic 146	java/lang/System:currentTimeMillis	()J
    //   61: lstore_1
    //   62: aload_0
    //   63: ifnull +92 -> 155
    //   66: new 107	java/io/File
    //   69: dup
    //   70: aload 5
    //   72: new 109	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   79: lload_1
    //   80: invokestatic 152	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   83: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 154
    //   88: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokespecial 157	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   97: astore 5
    //   99: aload 5
    //   101: invokevirtual 160	java/io/File:createNewFile	()Z
    //   104: ifeq +205 -> 309
    //   107: aload 5
    //   109: invokevirtual 163	java/io/File:getPath	()Ljava/lang/String;
    //   112: astore_3
    //   113: new 165	java/io/FileOutputStream
    //   116: dup
    //   117: aload 5
    //   119: invokevirtual 163	java/io/File:getPath	()Ljava/lang/String;
    //   122: invokespecial 166	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   125: astore 4
    //   127: aload_0
    //   128: getstatic 172	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   131: bipush 100
    //   133: aload 4
    //   135: invokevirtual 178	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   138: pop
    //   139: aload_3
    //   140: astore_0
    //   141: aload_0
    //   142: astore_3
    //   143: aload 4
    //   145: ifnull +10 -> 155
    //   148: aload 4
    //   150: invokevirtual 181	java/io/FileOutputStream:close	()V
    //   153: aload_0
    //   154: astore_3
    //   155: aload_3
    //   156: areturn
    //   157: astore 5
    //   159: aconst_null
    //   160: astore 4
    //   162: aload 6
    //   164: astore_0
    //   165: aload 4
    //   167: astore_3
    //   168: aload 5
    //   170: invokevirtual 184	java/lang/OutOfMemoryError:printStackTrace	()V
    //   173: aload_0
    //   174: astore_3
    //   175: aload 4
    //   177: ifnull -22 -> 155
    //   180: aload 4
    //   182: invokevirtual 181	java/io/FileOutputStream:close	()V
    //   185: aload_0
    //   186: areturn
    //   187: astore_3
    //   188: aload_0
    //   189: areturn
    //   190: astore 5
    //   192: aconst_null
    //   193: astore 4
    //   195: aload 7
    //   197: astore_0
    //   198: aload 4
    //   200: astore_3
    //   201: ldc 186
    //   203: iconst_1
    //   204: new 109	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   211: ldc 188
    //   213: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload 5
    //   218: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 196	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: aload_0
    //   228: astore_3
    //   229: aload 4
    //   231: ifnull -76 -> 155
    //   234: aload 4
    //   236: invokevirtual 181	java/io/FileOutputStream:close	()V
    //   239: aload_0
    //   240: areturn
    //   241: astore_3
    //   242: aload_0
    //   243: areturn
    //   244: astore_0
    //   245: aconst_null
    //   246: astore_3
    //   247: aload_3
    //   248: ifnull +7 -> 255
    //   251: aload_3
    //   252: invokevirtual 181	java/io/FileOutputStream:close	()V
    //   255: aload_0
    //   256: athrow
    //   257: astore_3
    //   258: aload_0
    //   259: areturn
    //   260: astore_3
    //   261: goto -6 -> 255
    //   264: astore_0
    //   265: aload 4
    //   267: astore_3
    //   268: goto -21 -> 247
    //   271: astore_0
    //   272: goto -25 -> 247
    //   275: astore 5
    //   277: aload_3
    //   278: astore_0
    //   279: aconst_null
    //   280: astore 4
    //   282: goto -84 -> 198
    //   285: astore 5
    //   287: aload_3
    //   288: astore_0
    //   289: goto -91 -> 198
    //   292: astore 5
    //   294: aload_3
    //   295: astore_0
    //   296: aconst_null
    //   297: astore 4
    //   299: goto -134 -> 165
    //   302: astore 5
    //   304: aload_3
    //   305: astore_0
    //   306: goto -141 -> 165
    //   309: aconst_null
    //   310: astore_3
    //   311: aload 4
    //   313: astore_0
    //   314: aload_3
    //   315: astore 4
    //   317: goto -176 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	paramBitmap	Bitmap
    //   61	19	1	l	long
    //   1	174	3	localObject1	Object
    //   187	1	3	localException1	Exception
    //   200	29	3	localObject2	Object
    //   241	1	3	localException2	Exception
    //   246	6	3	localObject3	Object
    //   257	1	3	localException3	Exception
    //   260	1	3	localException4	Exception
    //   267	48	3	localObject4	Object
    //   9	307	4	localObject5	Object
    //   42	76	5	localFile	File
    //   157	12	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   190	27	5	localException5	Exception
    //   275	1	5	localException6	Exception
    //   285	1	5	localException7	Exception
    //   292	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   302	1	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   3	160	6	localObject6	Object
    //   6	190	7	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   99	113	157	java/lang/OutOfMemoryError
    //   180	185	187	java/lang/Exception
    //   99	113	190	java/lang/Exception
    //   234	239	241	java/lang/Exception
    //   99	113	244	finally
    //   113	127	244	finally
    //   148	153	257	java/lang/Exception
    //   251	255	260	java/lang/Exception
    //   127	139	264	finally
    //   168	173	271	finally
    //   201	227	271	finally
    //   113	127	275	java/lang/Exception
    //   127	139	285	java/lang/Exception
    //   113	127	292	java/lang/OutOfMemoryError
    //   127	139	302	java/lang/OutOfMemoryError
  }
  
  public static HashMap<String, String> a(String paramString, Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    String str1 = ShortVideoUtils.c(paramString, paramString.substring(paramString.lastIndexOf(".") + 1));
    Object localObject1 = ShortVideoTrimmer.a(paramString);
    int k;
    boolean bool;
    int m;
    if ((localObject1 != null) && (((azlf)localObject1).jdField_a_of_type_Boolean)) {
      if (Build.VERSION.SDK_INT >= 18)
      {
        Object localObject2 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject2).setDataSource(paramString);
        String str2 = ((MediaMetadataRetriever)localObject2).extractMetadata(9);
        ((MediaMetadataRetriever)localObject2).release();
        long l = Long.parseLong(str2);
        k = azhc.a(paramContext);
        if (((k & 0x1) > 0) && ((k & 0x2) > 0))
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("VideoCompressTask", 2, "CompressTask, step: isHWCodecSupported = " + bool);
          }
          if (!bool) {
            break label345;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoCompressTask", 2, "CompressTask, step: Try to compress using MediaCodec");
          }
          localObject2 = new File(paramString);
          localObject1 = new akel(str1, (int)(((azlf)localObject1).jdField_b_of_type_Long * 1024L), (int)((azlf)localObject1).jdField_a_of_type_Long, 0L, l);
          if ((!new azlu().a((File)localObject2, (azlv)localObject1, true)) || (((akel)localObject1).a != null)) {
            break label330;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoCompressTask", 2, "CompressTask, step: compress completed using MediaCodec");
          }
          m = 0;
          label246:
          k = m;
          localObject1 = str1;
          if (m != 0)
          {
            k = m;
            localObject1 = str1;
            if (!TextUtils.isEmpty(str1))
            {
              if (QLog.isColorLevel()) {
                QLog.d("VideoCompressTask", 2, "CompressTask, step: Try to compress using ShortVideoTrimmer.compressVideo");
              }
              k = ShortVideoTrimmer.a(paramContext, paramString, str1);
              localObject1 = str1;
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
      label330:
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressTask", 2, "CompressTask, step: compress failed using MediaCodecr");
      }
      label345:
      m = -1;
      break label246;
      if ((localObject1 != null) && (!((azlf)localObject1).jdField_a_of_type_Boolean))
      {
        k = 0;
        localObject1 = paramString;
      }
      else
      {
        k = -1;
        localObject1 = str1;
      }
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    bdgm.a(paramContext, 232, null, paramContext.getString(paramInt), new akea(), null).show();
  }
  
  private void f()
  {
    this.jdField_a_of_type_Long = new File(this.jdField_c_of_type_JavaLangString).length();
    if ((bdin.g(this)) && (!bdin.h(this)) && (this.jdField_a_of_type_Long > arbp.a()))
    {
      arre.a(this, 2131692754, 2131692759, new akdz(this));
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
      azqs.b(null, "CliOper", "", "", "0X8006130", "0X8006130", 0, 0, "", "", "", "");
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
        azqs.b(null, "CliOper", "", "", str2, str2, 0, 0, (String)localObject, "", "", "");
      }
    }
    startActivity(localIntent);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Bdzk.a();
  }
  
  public String a(int paramInt)
  {
    return bdzo.a(paramInt);
  }
  
  void a()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      switch (this.j)
      {
      default: 
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131694953);
      }
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719921);
        }
      }
      return;
      StringBuilder localStringBuilder = new StringBuilder(alud.a(2131714478));
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        localStringBuilder.append("(").append(this.jdField_a_of_type_JavaUtilArrayList.size()).append(")");
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localStringBuilder);
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131694953);
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131697711);
    }
  }
  
  public void a(int paramInt)
  {
    if (!bdhb.b(this.jdField_c_of_type_JavaLangString)) {
      QQToast.a(this, 2131720125, 0).a();
    }
    do
    {
      return;
      this.jdField_a_of_type_Bdzk.a(this.jdField_a_of_type_Bdzl);
      this.jdField_a_of_type_Bdzk.a(this.jdField_a_of_type_Bdzn);
      this.jdField_a_of_type_Bdzk.a(this.jdField_a_of_type_Bdzm);
      if (!this.jdField_a_of_type_Bdzk.a(this.jdField_c_of_type_JavaLangString, paramInt)) {
        break;
      }
      if (bhtb.b()) {
        ((AudioManager)getSystemService("audio")).requestAudioFocus(null, 3, 2);
      }
    } while (this.j == 10);
    try
    {
      this.jdField_a_of_type_Bdzk.a(this.jdField_a_of_type_AndroidViewSurfaceView.getHolder());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ShortVideoPreviewActivity", 1, "play exception:", localException);
      return;
    }
    bdgm.a(this, 232, null, getString(2131720152), new akeg(this), null).show();
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
      if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || ((this.j != 2) && (this.j != 6) && (this.j != 10) && (!bool3) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) || (!bdhb.b(this.jdField_c_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoPreviewActivity", 2, "ShortVideoPreviewActivity initData(),mVideoPath or mUin is empty or mVideoPath not exits, just finish.");
        }
        QQToast.a(this, 2131720125, 0).a();
        super.finish();
      }
      return;
      if ((paramIntent.contains("QZonePublishMoodTabActivity")) || (paramIntent.contains("QZonePublishMoodRealActivity"))) {
        this.j = 1;
      } else if (paramIntent.contains("QZoneUploadPhotoRealActivity")) {
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
    this.jdField_a_of_type_Bdzk.a();
    if (bhtb.b()) {
      ((AudioManager)getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
  }
  
  void c()
  {
    if (this.jdField_a_of_type_Bdzk != null) {
      this.jdField_a_of_type_Bdzk.c();
    }
  }
  
  public void d()
  {
    if (bhtb.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    }
    this.jdField_a_of_type_Bdzk.b();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
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
    super.setContentView(2131561310);
    this.jdField_a_of_type_AndroidViewSurfaceView = ((SurfaceView)findViewById(2131377285));
    this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().setType(3);
    this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().addCallback(this.jdField_a_of_type_AndroidViewSurfaceHolder$Callback);
    this.jdField_a_of_type_AndroidViewSurfaceView.getViewTreeObserver().addOnGlobalLayoutListener(new akeb(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364881));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363910));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376387));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371461));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131371221));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372340));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378221));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371462));
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845707);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131376326));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_a_of_type_AndroidWidgetImageView.getViewTreeObserver().addOnGlobalLayoutListener(new akee(this));
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
  
  public void doOnDestroy()
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
        break label256;
      }
      k = 1;
      label38:
      this.jdField_a_of_type_Long = new File(this.jdField_c_of_type_JavaLangString).length();
      if (k == 0) {
        break label279;
      }
      if (bdeu.b() <= 512000L) {
        break label271;
      }
      if ((azdd.jdField_b_of_type_Long == 0L) || (System.currentTimeMillis() - azdd.jdField_b_of_type_Long >= 300000L)) {
        break label261;
      }
    }
    label256:
    label261:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + azdd.jdField_b_of_type_Long);
      }
      if ((!bdin.b(this)) || (bool) || (this.jdField_a_of_type_Long < 1048576L)) {
        break label266;
      }
      localObject = ShortVideoUtils.a(this, this.jdField_a_of_type_Long);
      localObject = String.format(getResources().getString(2131720118), new Object[] { localObject });
      ShortVideoPreviewActivity.13 local13 = new ShortVideoPreviewActivity.13(this);
      if (bezm.a(this, 4, new akdw(this, local13))) {
        bdgm.a(this, 232, null, (String)localObject, new akdx(this, local13), new akdy(this)).show();
      }
      return;
      k = 0;
      break;
      k = 0;
      break label38;
    }
    label266:
    g();
    return;
    label271:
    a(this, 2131720143);
    return;
    label279:
    QQToast.a(this, 1, 2131719547, 0).b(getTitleBarHeight());
  }
  
  @TargetApi(11)
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363910: 
      super.finish();
      return;
    case 2131371461: 
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
          QQToast.a(this, 0, 2131720131, 0).a();
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
    case 2131371462: 
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
          QQToast.a(this, 0, 2131720131, 0).a();
          return;
        }
        a(0);
        return;
      case 1: 
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845706);
        d();
        return;
      case 2: 
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845707);
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
      bdgm.a(this, 232, null, getString(2131698168, new Object[] { String.format("%.2fMB", new Object[] { Double.valueOf(this.jdField_a_of_type_Long / 1024.0D / 1024.0D) }) }), new akek(this, paramView, localArrayList), new akdt(this)).show();
      return;
    case 2: 
      bdgm.a(this, 232, null, getString(2131698168, new Object[] { String.format("%.2fMB", new Object[] { Double.valueOf(this.jdField_a_of_type_Long / 1024.0D / 1024.0D) }) }), new akdu(this), new akdv(this)).show();
      paramView = new Intent("key_video_select_apply_click");
      paramView.putExtra("className", super.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
      sendBroadcast(paramView);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "ldStart Compress");
    }
    i = -1;
    new akem(this, this).execute(new String[] { this.jdField_c_of_type_JavaLangString });
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if ((a() == 1) || (a() == 2)) {
      this.g = this.jdField_a_of_type_Bdzk.b();
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
    super.onStart();
  }
  
  public void onStop()
  {
    if (bhtb.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    }
    super.onStop();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void run()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = ShortVideoUtils.a(this, this.jdField_c_of_type_JavaLangString);
    runOnUiThread(new ShortVideoPreviewActivity.19(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */