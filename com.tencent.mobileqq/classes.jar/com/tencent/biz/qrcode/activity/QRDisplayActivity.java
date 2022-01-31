package com.tencent.biz.qrcode.activity;

import aciy;
import afhx;
import ajhf;
import ajhh;
import ajhi;
import ajjj;
import ajjy;
import amyp;
import amyy;
import amyz;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import awqx;
import awrb;
import awrn;
import azzx;
import baan;
import babh;
import babr;
import badq;
import bafb;
import bahv;
import bahx;
import bbms;
import bbmy;
import bbsh;
import bcqu;
import begr;
import behe;
import com.tencent.biz.qrcode.CodeMaskManager;
import com.tencent.chirp.ChirpWrapper;
import com.tencent.chirp.PcmPlayer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gq;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import lor;
import mqq.os.MqqHandler;
import vsj;
import vsl;
import vtb;
import vtc;
import vtd;
import vte;
import vtf;
import vtg;
import vth;
import vti;
import vtj;
import vtl;
import vtm;
import vtn;
import vto;
import vtp;
import vtq;
import vtr;
import vvp;
import xfn;

public class QRDisplayActivity
  extends IphoneTitleBarActivity
  implements amyz, Handler.Callback, View.OnClickListener, AdapterView.OnItemClickListener, vsj, vsl, xfn
{
  public static final String h;
  public int a;
  protected long a;
  public ajhf a;
  ajhi jdField_a_of_type_Ajhi = new vtj(this);
  private amyy jdField_a_of_type_Amyy;
  public Bitmap a;
  public Bundle a;
  private CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer = new vtl(this, 1000L, 200L);
  protected Handler a;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new vtn(this);
  protected View a;
  public ImageView a;
  protected TextView a;
  private bahv jdField_a_of_type_Bahv;
  bbms jdField_a_of_type_Bbms;
  bbsh jdField_a_of_type_Bbsh;
  bcqu jdField_a_of_type_Bcqu = new vtm(this);
  begr jdField_a_of_type_Begr;
  protected CodeMaskManager a;
  private PcmPlayer jdField_a_of_type_ComTencentChirpPcmPlayer;
  public gq a;
  public Runnable a;
  public String a;
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  vtr jdField_a_of_type_Vtr = new vtb(this);
  public boolean a;
  protected int b;
  public long b;
  protected Bitmap b;
  private Handler b;
  public View b;
  public ImageView b;
  protected TextView b;
  public begr b;
  public Runnable b;
  public String b;
  public List<String> b;
  public boolean b;
  public int c;
  protected long c;
  public View c;
  public ImageView c;
  protected TextView c;
  protected Runnable c;
  public String c;
  protected boolean c;
  protected int d;
  public View d;
  public ImageView d;
  public String d;
  protected boolean d;
  protected int e;
  View e;
  public String e;
  public boolean e;
  int f;
  protected View f;
  protected String f;
  public boolean f;
  public int g;
  protected View g;
  public String g;
  private boolean g;
  public int h;
  protected View h;
  private volatile boolean h;
  private boolean i;
  
  static
  {
    jdField_h_of_type_JavaLangString = ajjy.a(2131645408);
  }
  
  public QRDisplayActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRunnable = new QRDisplayActivity.3(this);
    this.jdField_b_of_type_JavaLangRunnable = new QRDisplayActivity.4(this);
    this.jdField_c_of_type_JavaLangRunnable = new QRDisplayActivity.7(this);
    this.jdField_h_of_type_Int = -1;
  }
  
  private static void a(short[] paramArrayOfShort, byte[] paramArrayOfByte)
  {
    int j = 0;
    while (j < paramArrayOfShort.length)
    {
      paramArrayOfByte[(j * 2)] = ((byte)(paramArrayOfShort[j] & 0xFF));
      paramArrayOfByte[(j * 2 + 1)] = ((byte)(paramArrayOfShort[j] >> 8 & 0xFF));
      j += 1;
    }
  }
  
  public static boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int j = arrayOfInt[1];
    int k = arrayOfInt[1];
    int m = paramView.getHeight();
    int n = arrayOfInt[0];
    int i1 = arrayOfInt[0];
    int i2 = paramView.getWidth();
    return (paramFloat2 >= j) && (paramFloat2 < k + m) && (paramFloat1 > n) && (paramFloat1 < i1 + i2);
  }
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: new 172	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 179	java/io/File:exists	()Z
    //   13: ifne +183 -> 196
    //   16: new 181	com/tencent/chirp/ChirpWrapper
    //   19: dup
    //   20: invokespecial 182	com/tencent/chirp/ChirpWrapper:<init>	()V
    //   23: astore 5
    //   25: aload 5
    //   27: invokevirtual 184	com/tencent/chirp/ChirpWrapper:a	()I
    //   30: ifne +292 -> 322
    //   33: aload_0
    //   34: getfield 188	com/tencent/biz/qrcode/activity/QRDisplayActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: invokevirtual 194	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   40: astore_3
    //   41: new 196	java/lang/String
    //   44: dup
    //   45: ldc 198
    //   47: invokespecial 199	java/lang/String:<init>	(Ljava/lang/String;)V
    //   50: astore 4
    //   52: new 201	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   59: ldc 204
    //   61: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload 4
    //   66: iconst_0
    //   67: bipush 14
    //   69: aload_3
    //   70: invokevirtual 211	java/lang/String:length	()I
    //   73: isub
    //   74: invokevirtual 215	java/lang/String:substring	(II)Ljava/lang/String;
    //   77: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_3
    //   81: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore_3
    //   88: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +28 -> 119
    //   94: ldc 225
    //   96: iconst_2
    //   97: new 201	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   104: ldc 227
    //   106: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_3
    //   110: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload 5
    //   121: aload_3
    //   122: invokevirtual 233	com/tencent/chirp/ChirpWrapper:a	(Ljava/lang/String;)Landroid/util/Pair;
    //   125: astore_3
    //   126: aload_3
    //   127: getfield 239	android/util/Pair:first	Ljava/lang/Object;
    //   130: checkcast 241	java/lang/Integer
    //   133: invokevirtual 244	java/lang/Integer:intValue	()I
    //   136: istore_2
    //   137: aload_3
    //   138: getfield 247	android/util/Pair:second	Ljava/lang/Object;
    //   141: checkcast 249	[S
    //   144: astore 4
    //   146: iload_2
    //   147: ifne +136 -> 283
    //   150: aload 4
    //   152: ifnull +131 -> 283
    //   155: new 251	java/io/FileOutputStream
    //   158: dup
    //   159: aload_1
    //   160: invokespecial 254	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   163: astore_3
    //   164: aload 4
    //   166: arraylength
    //   167: iconst_2
    //   168: imul
    //   169: newarray byte
    //   171: astore_1
    //   172: aload 4
    //   174: aload_1
    //   175: invokestatic 256	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	([S[B)V
    //   178: aload_3
    //   179: aload_1
    //   180: invokevirtual 260	java/io/FileOutputStream:write	([B)V
    //   183: aload_3
    //   184: ifnull +7 -> 191
    //   187: aload_3
    //   188: invokevirtual 263	java/io/FileOutputStream:close	()V
    //   191: aload 5
    //   193: invokevirtual 265	com/tencent/chirp/ChirpWrapper:a	()V
    //   196: iconst_1
    //   197: ireturn
    //   198: astore_1
    //   199: aload_1
    //   200: athrow
    //   201: astore_1
    //   202: aload 5
    //   204: invokevirtual 265	com/tencent/chirp/ChirpWrapper:a	()V
    //   207: aload_1
    //   208: athrow
    //   209: astore_3
    //   210: aconst_null
    //   211: astore_1
    //   212: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +13 -> 228
    //   218: ldc 225
    //   220: iconst_2
    //   221: ldc_w 267
    //   224: aload_3
    //   225: invokestatic 270	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   228: aload_1
    //   229: astore_3
    //   230: aload_1
    //   231: ifnull +9 -> 240
    //   234: aload_1
    //   235: invokevirtual 263	java/io/FileOutputStream:close	()V
    //   238: aconst_null
    //   239: astore_3
    //   240: aload_3
    //   241: ifnull +7 -> 248
    //   244: aload_3
    //   245: invokevirtual 263	java/io/FileOutputStream:close	()V
    //   248: aload 5
    //   250: invokevirtual 265	com/tencent/chirp/ChirpWrapper:a	()V
    //   253: iconst_0
    //   254: ireturn
    //   255: astore_1
    //   256: aconst_null
    //   257: astore_3
    //   258: goto -18 -> 240
    //   261: astore_1
    //   262: aload_1
    //   263: athrow
    //   264: astore_1
    //   265: aconst_null
    //   266: astore_3
    //   267: aload_3
    //   268: ifnull +7 -> 275
    //   271: aload_3
    //   272: invokevirtual 263	java/io/FileOutputStream:close	()V
    //   275: aload_1
    //   276: athrow
    //   277: astore_1
    //   278: aload_1
    //   279: athrow
    //   280: astore_1
    //   281: aload_1
    //   282: athrow
    //   283: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq +29 -> 315
    //   289: ldc 225
    //   291: iconst_4
    //   292: new 201	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 272
    //   302: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: iload_2
    //   306: invokevirtual 275	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   309: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aload 5
    //   317: invokevirtual 265	com/tencent/chirp/ChirpWrapper:a	()V
    //   320: iconst_0
    //   321: ireturn
    //   322: aload 5
    //   324: invokevirtual 265	com/tencent/chirp/ChirpWrapper:a	()V
    //   327: iconst_0
    //   328: ireturn
    //   329: astore_1
    //   330: goto -139 -> 191
    //   333: astore_1
    //   334: goto -86 -> 248
    //   337: astore_3
    //   338: goto -63 -> 275
    //   341: astore_1
    //   342: goto -75 -> 267
    //   345: astore 4
    //   347: aload_1
    //   348: astore_3
    //   349: aload 4
    //   351: astore_1
    //   352: goto -85 -> 267
    //   355: astore 4
    //   357: aload_3
    //   358: astore_1
    //   359: aload 4
    //   361: astore_3
    //   362: goto -150 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	QRDisplayActivity
    //   0	365	1	paramString	String
    //   136	170	2	j	int
    //   40	148	3	localObject1	Object
    //   209	16	3	localException1	Exception
    //   229	43	3	str	String
    //   337	1	3	localIOException	java.io.IOException
    //   348	14	3	localObject2	Object
    //   50	123	4	localObject3	Object
    //   345	5	4	localObject4	Object
    //   355	5	4	localException2	Exception
    //   23	300	5	localChirpWrapper	ChirpWrapper
    // Exception table:
    //   from	to	target	type
    //   187	191	198	finally
    //   33	119	201	finally
    //   119	146	201	finally
    //   199	201	201	finally
    //   275	277	201	finally
    //   278	280	201	finally
    //   281	283	201	finally
    //   283	315	201	finally
    //   155	164	209	java/lang/Exception
    //   234	238	255	java/io/IOException
    //   234	238	261	finally
    //   155	164	264	finally
    //   262	264	264	finally
    //   244	248	277	finally
    //   271	275	280	finally
    //   187	191	329	java/io/IOException
    //   244	248	333	java/io/IOException
    //   271	275	337	java/io/IOException
    //   164	183	341	finally
    //   212	228	345	finally
    //   164	183	355	java/lang/Exception
  }
  
  public static List<bahx>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    bahx localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131630983);
    localbahx.jdField_b_of_type_Int = 2130838732;
    localbahx.jdField_b_of_type_Boolean = true;
    localbahx.jdField_c_of_type_Int = 0;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131630996);
    localbahx.jdField_b_of_type_Int = 2130838733;
    localbahx.jdField_b_of_type_Boolean = true;
    localbahx.jdField_c_of_type_Int = 1;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131631003);
    localbahx.jdField_b_of_type_Int = 2130838736;
    localbahx.jdField_c_of_type_Int = 2;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131630986);
    localbahx.jdField_b_of_type_Int = 2130838730;
    localbahx.jdField_c_of_type_Int = 3;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "sendIsResumeBroadcast isNeedSend = " + this.jdField_e_of_type_Boolean + " ,isResume = " + paramBoolean);
    }
    if (this.jdField_e_of_type_Boolean) {
      lor.a(BaseApplicationImpl.getContext(), paramBoolean);
    }
  }
  
  private void l()
  {
    String str1;
    if (!badq.d(BaseApplication.getContext()))
    {
      bbmy.a(this, getString(2131626719), 0).b(getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.i("QRDisplayActivity", 2, "tryToGetShareLink: net is not supported");
      }
      if (this.jdField_c_of_type_Int == 2)
      {
        str1 = "";
        switch (this.jdField_h_of_type_Int)
        {
        default: 
          if (!TextUtils.isEmpty(str1)) {
            break;
          }
        }
      }
    }
    label481:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            str1 = "qr_circle";
            break;
            str1 = "qr_qq";
            break;
            str1 = "qr_qzone";
            break;
            str1 = "qr_wechat";
            break;
            azzx.a("Grp_share", "grpData_admin", str1, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
            this.jdField_h_of_type_Int = -1;
            return;
            switch (this.jdField_h_of_type_Int)
            {
            default: 
              return;
            case 0: 
            case 2: 
            case 3: 
              try
              {
                ThreadManager.post(new QRDisplayActivity.20(this, "temp_qrcode_share_" + this.jdField_c_of_type_JavaLangString + ".png"), 8, null, true);
                if (this.jdField_c_of_type_Int != 2) {
                  break label481;
                }
                awqx.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_qq", 0, 0, this.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_Int), "");
                return;
              }
              catch (OutOfMemoryError localOutOfMemoryError2)
              {
                String str2;
                vvp.a(1, 2131631057);
              }
              try
              {
                if (this.jdField_a_of_type_Bbsh == null)
                {
                  this.jdField_a_of_type_Bbsh = new vti(this);
                  WXShareHelper.a().a(this.jdField_a_of_type_Bbsh);
                }
                ThreadManager.post(new QRDisplayActivity.19(this), 8, null, true);
                return;
              }
              catch (OutOfMemoryError localOutOfMemoryError1)
              {
                vvp.a(1, 2131631057);
              }
            }
          } while (this.jdField_c_of_type_Int != 2);
          if (this.jdField_h_of_type_Int == 2) {}
          for (str2 = "qr_wechat";; str2 = "qr_circle")
          {
            azzx.a("Grp_share", "grpData_admin", str2, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
            return;
          }
        } while (this.jdField_c_of_type_Int != 2);
        azzx.a("Grp_share", "grpData_admin", "qr_qq", 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
        return;
      } while (this.jdField_c_of_type_Int != 5);
      awqx.b(this.app, "CliOper", "", "", "0X8006674", "0X8006674", 0, 0, "", "", "", "");
      return;
      e();
      if ((this.jdField_g_of_type_Int & 0x1) != 0) {
        awqx.b(this.app, "P_CliOper", "flag1", "", "0X800416E", "0X800416E", 0, 0, "", "", "", "");
      }
      if (this.jdField_c_of_type_Int == 2)
      {
        awqx.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_qzone", 0, 0, this.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_Int), "");
        return;
      }
    } while (this.jdField_c_of_type_Int != 5);
    awqx.b(this.app, "CliOper", "", "", "0X8006675", "0X8006675", 0, 0, "", "", "", "");
  }
  
  private void m()
  {
    if ((this.app.c()) || (!AppSetting.jdField_c_of_type_Boolean)) {
      return;
    }
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1000, 5, 0);
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void n()
  {
    if ((this.app.c()) || (!AppSetting.jdField_c_of_type_Boolean)) {
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1001, 5, 0).sendToTarget();
  }
  
  public gq a(String paramString, int paramInt1, int paramInt2)
  {
    String str = b();
    if (str == null) {}
    do
    {
      return null;
      str = getSharedPreferences("qrcode", 0).getString(str, null);
      if (QLog.isColorLevel()) {
        QLog.d("QRDisplayActivity", 2, "getPrefMatrix uin: " + paramString + " type: " + paramInt1 + " data: " + str);
      }
    } while (str == null);
    return vvp.a(str, paramInt2);
  }
  
  public String a()
  {
    String str = b();
    if (str == null) {
      return null;
    }
    return getSharedPreferences("qrcode", 0).getString(str, null);
  }
  
  public String a(String paramString)
  {
    paramString = "discussionnick_name" + paramString;
    return getSharedPreferences("qrcode", 0).getString(paramString, null);
  }
  
  public String a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int j = 0;
    while (j < paramList.size())
    {
      localStringBuffer.append((String)paramList.get(j));
      if (j != paramList.size() - 1) {
        localStringBuffer.append("、");
      }
      j += 1;
    }
    return localStringBuffer.toString();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "enter focus, " + this.app.c());
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    String str;
    switch (paramInt)
    {
    default: 
      str = ajjy.a(2131645406);
    }
    for (;;)
    {
      a(2130839278, str);
      finish();
      return;
      str = ajjy.a(2131645407);
      continue;
      str = ajjy.a(2131645404);
    }
  }
  
  void a(int paramInt, String paramString)
  {
    bbmy.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "template ready, draw qrcode");
    }
    if ((this.jdField_b_of_type_Boolean) || (super.isFinishing())) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    Bitmap localBitmap1 = (Bitmap)paramBundle.getParcelable("bkg");
    Bitmap localBitmap2 = (Bitmap)paramBundle.getParcelable("qrbkg");
    int n = paramBundle.getInt("B");
    int i1 = paramBundle.getInt("W");
    Rect localRect = (Rect)paramBundle.getParcelable("qrloc");
    ArrayList localArrayList = paramBundle.getParcelableArrayList("clip");
    if (paramBundle.containsKey("qrsz"))
    {
      j = paramBundle.getInt("qrsz");
      localObject = a();
      if (localObject != null) {
        this.jdField_a_of_type_Gq = vvp.a((String)localObject, j);
      }
    }
    int i2 = this.jdField_a_of_type_Gq.a();
    Object localObject = new int[i2 * i2];
    int j = 0;
    while (j < i2)
    {
      k = 0;
      if (k < i2)
      {
        if (this.jdField_a_of_type_Gq.a(k, j)) {}
        for (int m = n;; m = i1)
        {
          localObject[(j * i2 + k)] = m;
          k += 1;
          break;
        }
      }
      j += 1;
    }
    Bitmap localBitmap3 = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
    localBitmap3.setPixels((int[])localObject, 0, i2, 0, 0, i2, i2);
    int k = 0;
    j = k;
    if ((this.jdField_a_of_type_Long & 0x800) != 0L)
    {
      if (this.jdField_b_of_type_Int == 2) {
        j = 2130843149;
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_b_of_type_AndroidGraphicsBitmap = vvp.a(this, localBitmap1, this.jdField_a_of_type_AndroidGraphicsBitmap, paramBundle.getInt("nameClr"), this.jdField_a_of_type_JavaLangString, localBitmap2, localBitmap3, paramBundle.getInt("head"), paramBundle.getInt("tipsClr"), this.jdField_b_of_type_JavaLangString, localRect, localArrayList, j);
      localBitmap3.recycle();
      if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
        break label412;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      j = k;
      if (this.jdField_b_of_type_Int != 1) {
        break;
      }
      j = 2130843149;
      break;
      label412:
      if (super.isResume())
      {
        paramBundle = babr.a(this, 230);
        paramBundle.setMessage(2131653078);
        paramBundle.setPositiveButton(2131629116, new vtc(this));
        paramBundle.show();
      }
      else
      {
        super.finish();
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    String str = b();
    if (str == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "setPrefMatrix uin: " + paramString1 + " type: " + paramInt + " data: " + paramString2);
    }
    paramString1 = getSharedPreferences("qrcode", 0).edit();
    paramString1.putString(str, paramString2);
    paramString1.commit();
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = "discussionnick_name" + paramString1;
    SharedPreferences.Editor localEditor = getSharedPreferences("qrcode", 0).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  public void a(boolean paramBoolean)
  {
    Intent localIntent;
    Object localObject;
    if (this.jdField_c_of_type_Int == 11)
    {
      localIntent = getIntent();
      localObject = localIntent.getParcelableExtra("PARAM_QRForwardReceiver");
      if ((localObject instanceof ResultReceiver))
      {
        localObject = (ResultReceiver)localObject;
        if (!paramBoolean) {
          break label55;
        }
      }
    }
    label55:
    for (int j = -1;; j = 0)
    {
      ((ResultReceiver)localObject).send(j, localIntent.getExtras());
      return;
    }
  }
  
  public String b()
  {
    if (this.jdField_c_of_type_Int == 1) {
      return "user" + this.jdField_c_of_type_JavaLangString;
    }
    if (this.jdField_c_of_type_Int == 2) {
      return "group" + this.jdField_c_of_type_JavaLangString;
    }
    if (this.jdField_c_of_type_Int == 5) {
      return "discussion" + this.jdField_c_of_type_JavaLangString;
    }
    if (this.jdField_c_of_type_Int == 11) {
      return "groupqav" + this.jdField_c_of_type_JavaLangString;
    }
    return null;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "enter focus_clear");
    }
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 1001, 3, 0).sendToTarget();
  }
  
  public void b(int paramInt)
  {
    long l = VACDReportUtil.a(null, "qqwallet", "payCode", "click", "1", 0, null);
    Intent localIntent = new Intent(this, JumpActivity.class);
    localIntent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=" + paramInt + "&entry=1&seq=" + l));
    startActivityForResult(localIntent, -1);
  }
  
  protected void c()
  {
    if (this.jdField_b_of_type_Begr == null)
    {
      this.jdField_b_of_type_Begr = ((begr)behe.a(this, null));
      this.jdField_b_of_type_Begr.a(2131651404, 1);
      this.jdField_b_of_type_Begr.a(2131651406, 1);
      this.jdField_b_of_type_Begr.a(2131651403, 1);
      this.jdField_b_of_type_Begr.c(2131625035);
      this.jdField_b_of_type_Begr.setOnDismissListener(new vto(this));
      this.jdField_b_of_type_Begr.a(new vtp(this));
    }
    if (!this.jdField_b_of_type_Begr.isShowing())
    {
      this.jdField_f_of_type_Boolean = false;
      this.jdField_b_of_type_Begr.show();
    }
  }
  
  public void c(int paramInt)
  {
    if ((QLog.isColorLevel()) && (paramInt != 0)) {
      QLog.d("QRDisplayActivity", 2, "onPlayStop, " + paramInt);
    }
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1001);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1003, 500L);
      return;
    } while (this.jdField_b_of_type_AndroidOsHandler.hasMessages(1001));
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1002, 1000L);
  }
  
  public void d()
  {
    ThreadManager.executeOnFileThread(new QRDisplayActivity.10(this));
    String str = null;
    if (this.jdField_c_of_type_Int == 1) {
      str = "saveConsumerQRcard";
    }
    for (;;)
    {
      awrn.a(BaseApplication.getContext()).b(this.app, "", str, 1);
      return;
      if (this.jdField_c_of_type_Int == 2) {
        str = "saveGroupQRcard";
      }
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1;
    if (this.jdField_c_of_type_Int == 2) {
      localObject1 = "";
    }
    Object localObject2;
    label57:
    boolean bool;
    switch (paramInt1)
    {
    default: 
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (paramInt2 == -1)
        {
          localObject2 = "0";
          azzx.a("Grp_share", "grpData_admin", (String)localObject1, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), localObject2 });
        }
      }
      else
      {
        if (paramInt2 != -1) {
          break label224;
        }
        bool = true;
        label104:
        a(bool);
        if (paramInt2 == -1)
        {
          if (paramInt1 != 1) {
            break label230;
          }
          a(0, getString(2131651405));
          if (QLog.isColorLevel()) {
            QLog.i("QRDisplayActivity", 2, "shareQRCode success");
          }
          if ((this.jdField_g_of_type_Int & 0x1) != 0) {
            awqx.b(this.app, "P_CliOper", "flag1", "", "0X800416F", "0X800416F", 0, 0, "", "", "", "");
          }
        }
      }
      break;
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      localObject1 = "qr_qzone";
      break;
      localObject1 = "qr_qq";
      break;
      localObject2 = "1";
      break label57;
      label224:
      bool = false;
      break label104;
      label230:
      if (paramInt1 == 2)
      {
        localObject1 = new Intent(this, SplashActivity.class);
        ((Intent)localObject1).putExtras(paramIntent);
        localObject2 = ForwardUtils.a((Intent)localObject1);
        ForwardUtils.a(this.app, this, (SessionInfo)localObject2, (Intent)localObject1);
      }
      else if (paramInt1 == 21)
      {
        localObject1 = aciy.a(new Intent(this, SplashActivity.class), null);
        ((Intent)localObject1).putExtras(new Bundle(paramIntent.getExtras()));
        startActivity((Intent)localObject1);
        finish();
      }
      else if (paramInt1 != 3) {}
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    super.setContentView(2131494552);
    paramBundle = super.getIntent();
    this.jdField_f_of_type_JavaLangString = paramBundle.getStringExtra("from");
    this.jdField_g_of_type_Int = paramBundle.getIntExtra("reportFlag", 0);
    super.setTitle(paramBundle.getStringExtra("title"));
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("nick");
    this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)paramBundle.getParcelableExtra("face"));
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("type", 1);
    this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("uin");
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("adminLevel", 2);
    this.jdField_a_of_type_Long = paramBundle.getLongExtra("GroupFlagExt", 0L);
    this.jdField_b_of_type_Int = ((int)paramBundle.getLongExtra("AuthGroupType", 0L));
    this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("isQidianPrivateTroop", false);
    int j;
    Object localObject1;
    if (this.jdField_c_of_type_Int == 1)
    {
      this.jdField_b_of_type_JavaLangString = getString(2131651450);
      paramBundle = findViewById(2131301612);
      paramBundle.setVisibility(0);
      this.jdField_f_of_type_AndroidViewView = findViewById(2131307724);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131307723));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131307725));
      this.jdField_g_of_type_AndroidViewView = findViewById(2131307727);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131307726));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131307728));
      this.jdField_h_of_type_AndroidViewView = findViewById(2131307740);
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131307739));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131307741));
      j = (getWindowManager().getDefaultDisplay().getWidth() - getResources().getDimensionPixelSize(2131166725) * 3) / 8;
      localObject1 = (ViewGroup.MarginLayoutParams)paramBundle.getLayoutParams();
      if (localObject1 != null)
      {
        ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = j;
        ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = j;
        paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_g_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_h_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_h_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView = super.findViewById(2131307746);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131307717));
      this.jdField_c_of_type_AndroidViewView = super.findViewById(2131307743);
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131307732);
      this.jdField_d_of_type_AndroidViewView = findViewById(2131307734);
      this.jdField_e_of_type_AndroidViewView = findViewById(2131306900);
      this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131631050));
      if (QLog.isDevelopLevel()) {
        QLog.d("QRDisplayActivity", 4, "display qrcode, type: " + this.jdField_c_of_type_Int);
      }
      if (this.jdField_c_of_type_Int != 5) {
        break label1456;
      }
      getIntent().getStringExtra("discussion_shorturl");
      addObserver(this.jdField_a_of_type_Ajhi);
      if (this.app != null)
      {
        this.jdField_a_of_type_Ajhf = ((ajhf)this.app.a(6));
        this.app.registObserver(this.jdField_a_of_type_Vtr);
      }
      this.leftView.setContentDescription(getString(2131630694));
      this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131630695));
      setResult(-1, getIntent());
      paramBundle = (ajjj)this.app.getManager(51);
      localObject2 = (ajhh)this.app.getManager(53);
      localObject1 = ((ajhh)localObject2).a(this.jdField_c_of_type_JavaLangString);
      if (localObject1 != null) {
        break;
      }
      g();
      j = 1;
      this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager = new CodeMaskManager(this, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 60000L);
      if (j != 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_JavaLangString + "," + this.jdField_b_of_type_JavaLangString);
        this.jdField_c_of_type_AndroidViewView.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      if ((this.jdField_g_of_type_Int & 0x1) != 0) {
        awqx.b(this.app, "P_CliOper", "flag1", "", "0X800416D", "0X800416D", 0, 0, "", "", "", "");
      }
      this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
      this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004, 1, 0).sendToTarget();
      return true;
      if (this.jdField_c_of_type_Int == 2)
      {
        findViewById(2131306899).setVisibility(0);
        findViewById(2131301611).setVisibility(0);
        findViewById(2131307729).setOnClickListener(this);
        findViewById(2131307730).setOnClickListener(this);
        this.jdField_b_of_type_JavaLangString = getString(2131651418);
      }
      else if (this.jdField_c_of_type_Int == 5)
      {
        findViewById(2131306899).setVisibility(0);
        findViewById(2131301611).setVisibility(0);
        findViewById(2131307729).setOnClickListener(this);
        findViewById(2131307730).setOnClickListener(this);
        this.jdField_b_of_type_JavaLangString = getString(2131651414);
      }
      else if (this.jdField_c_of_type_Int == 11)
      {
        findViewById(2131306899).setVisibility(0);
        findViewById(2131301611).setVisibility(0);
        findViewById(2131307729).setOnClickListener(this);
        findViewById(2131307730).setOnClickListener(this);
        this.jdField_b_of_type_JavaLangString = getString(2131651442);
      }
    }
    Object localObject2 = ((ajhh)localObject2).a(this.jdField_c_of_type_JavaLangString);
    if (localObject2 != null)
    {
      this.jdField_f_of_type_Int = ((List)localObject2).size();
      if (!((DiscussionInfo)localObject1).hasRenamed())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QRDisplayActivity", 4, "title not defined, join by nicks");
        }
        if (localObject2 != null) {
          localObject1 = ((List)localObject2).iterator();
        }
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label1286;
        }
        localObject2 = (DiscussionMemberInfo)((Iterator)localObject1).next();
        if (this.app.getAccount().equals(((DiscussionMemberInfo)localObject2).memberUin))
        {
          this.jdField_b_of_type_JavaUtilList.add(babh.h(this.app, ((DiscussionMemberInfo)localObject2).memberUin));
          continue;
          this.jdField_f_of_type_Int = 0;
          break;
        }
        Friends localFriends = paramBundle.e(((DiscussionMemberInfo)localObject2).memberUin);
        if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.name))) {
          this.jdField_b_of_type_JavaUtilList.add(localFriends.name);
        } else if (a(((DiscussionMemberInfo)localObject2).memberUin) != null) {
          this.jdField_b_of_type_JavaUtilList.add(a(((DiscussionMemberInfo)localObject2).memberUin));
        } else {
          this.jdField_a_of_type_JavaUtilList.add(((DiscussionMemberInfo)localObject2).memberUin);
        }
      }
      label1286:
      if ((this.jdField_b_of_type_JavaUtilList.size() >= 5) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label1555;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QRDisplayActivity", 4, "fetch nicks from server");
      }
      paramBundle = new String[this.jdField_a_of_type_JavaUtilList.size()];
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      j = 0;
      while (((Iterator)localObject1).hasNext())
      {
        paramBundle[j] = ((String)((Iterator)localObject1).next());
        j += 1;
      }
      ((ajhf)this.app.a(6)).a(new String[] { "20002" }, paramBundle);
    }
    label1555:
    for (int k = 0;; k = 1)
    {
      j = k;
      if (this.jdField_b_of_type_JavaUtilList.size() <= 0) {
        break;
      }
      Collections.sort(this.jdField_b_of_type_JavaUtilList, new vtq(this));
      this.jdField_a_of_type_JavaLangString = a(this.jdField_b_of_type_JavaUtilList);
      j = k;
      break;
      label1456:
      if (this.jdField_c_of_type_Int == 2)
      {
        this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131651416, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
        addObserver(this.jdField_a_of_type_Bcqu);
        j = 1;
        break;
      }
      if (this.jdField_c_of_type_Int == 11) {
        this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131651416, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
      }
      j = 1;
      break;
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager.a();
    if (this.jdField_c_of_type_Int == 5)
    {
      removeObserver(this.jdField_a_of_type_Ajhi);
      this.app.unRegistObserver(this.jdField_a_of_type_Vtr);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bbsh != null)
      {
        WXShareHelper.a().b(this.jdField_a_of_type_Bbsh);
        this.jdField_a_of_type_Bbsh = null;
      }
      if (this.jdField_a_of_type_Amyy != null) {
        this.jdField_a_of_type_Amyy.b(this);
      }
      super.doOnDestroy();
      return;
      if (this.jdField_c_of_type_Int == 2) {
        removeObserver(this.jdField_a_of_type_Bcqu);
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1001);
    }
    b(false);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004, 2, 0).sendToTarget();
    b(true);
  }
  
  public void e()
  {
    ThreadManager.executeOnFileThread(new QRDisplayActivity.11(this));
    String str = null;
    if (this.jdField_c_of_type_Int == 1) {
      str = "shareConsumerQRcard";
    }
    for (;;)
    {
      awrn.a(BaseApplication.getContext()).b(this.app, "", str, 1);
      return;
      if (this.jdField_c_of_type_Int == 2) {
        str = "shareGroupQRcard";
      }
    }
  }
  
  public void f()
  {
    if ((this.jdField_b_of_type_Boolean) || (super.isFinishing())) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "get code template");
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager;
    boolean bool2 = this.jdField_d_of_type_Boolean;
    if ((this.jdField_a_of_type_Long & 0x800) != 0L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ((CodeMaskManager)localObject).a(this, bool2, bool1, this.jdField_b_of_type_Int);
      if (!this.jdField_d_of_type_Boolean) {
        break;
      }
      this.jdField_d_of_type_Boolean = false;
      return;
    }
    if (this.jdField_c_of_type_Int == 1) {}
    for (localObject = "changeConsumerQRcard";; localObject = "changeGroupQRcard")
    {
      awrn.a(BaseApplication.getContext()).b(this.app, "", (String)localObject, 1);
      return;
    }
  }
  
  public void finish()
  {
    ForwardRecentActivity.a(getIntent(), this);
    super.finish();
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    if (super.isResume())
    {
      bafb localbafb = babr.a(this, 230);
      localbafb.setMessage(2131653076);
      localbafb.setPositiveButton(2131629116, new vtd(this));
      localbafb.show();
      return;
    }
    finish();
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_Bahv == null)
    {
      vtf localvtf = new vtf(this);
      vtg localvtg = new vtg(this);
      this.jdField_a_of_type_Bahv = new bahv(this);
      this.jdField_a_of_type_Bahv.a(getString(2131653614));
      this.jdField_a_of_type_Bahv.a(a(this));
      this.jdField_a_of_type_Bahv.a(localvtg);
      this.jdField_a_of_type_Bahv.a(new vth(this));
      this.jdField_a_of_type_Bahv.a(localvtf);
    }
    try
    {
      if ((this.jdField_a_of_type_Bahv != null) && (!this.jdField_a_of_type_Bahv.a()))
      {
        this.jdField_f_of_type_Boolean = false;
        this.jdField_a_of_type_Bahv.a();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  @TargetApi(14)
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool1;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1004: 
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.app.D();
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "talkback value " + AppSetting.jdField_c_of_type_Boolean);
        }
        if ((AppSetting.jdField_c_of_type_Boolean) && (this.jdField_c_of_type_Int == 1))
        {
          bool1 = ChirpWrapper.a();
          if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "isSoLoaded " + bool1);
          }
          if (!bool1)
          {
            if (this.jdField_a_of_type_Amyy == null) {
              this.jdField_a_of_type_Amyy = ((amyy)((amyp)this.app.getManager(77)).a("qq.android.system.chirp"));
            }
            this.jdField_a_of_type_Amyy.a(this);
            this.jdField_a_of_type_Amyy.a(true);
            bool1 = false;
          }
        }
      }
      break;
    }
    for (;;)
    {
      BaseApplicationImpl.sUiHandler.post(new QRDisplayActivity.22(this, bool1));
      break;
      boolean bool2 = true;
      bool1 = bool2;
      if (!this.i)
      {
        BaseApplicationImpl.sUiHandler.post(new QRDisplayActivity.21(this));
        this.i = true;
        bool1 = bool2;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "playQRCodeFailed = " + this.jdField_h_of_type_Boolean);
        }
        if (this.jdField_h_of_type_Boolean) {
          break;
        }
        String str = getFilesDir() + this.app.getCurrentAccountUin() + "_vqr.dat";
        File localFile = new File(str);
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "voiceFile.exists = " + localFile.exists());
        }
        if (!localFile.exists()) {
          if (a(str)) {
            break label525;
          }
        }
        label525:
        for (bool1 = true;; bool1 = false)
        {
          this.jdField_h_of_type_Boolean = bool1;
          if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "playQRCodeFailed = " + this.jdField_h_of_type_Boolean);
          }
          if (this.jdField_h_of_type_Boolean) {
            break label530;
          }
          if (this.jdField_a_of_type_ComTencentChirpPcmPlayer == null)
          {
            this.jdField_a_of_type_ComTencentChirpPcmPlayer = new PcmPlayer(this, this, 44100, str);
            this.jdField_a_of_type_ComTencentChirpPcmPlayer.a();
            baan.a(this, true);
          }
          if (paramMessage.arg1 != 5) {
            break;
          }
          awqx.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 0, 0, "", "", "", "");
          break;
        }
        label530:
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1003);
        break;
        if (this.jdField_a_of_type_ComTencentChirpPcmPlayer == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentChirpPcmPlayer.b();
        this.jdField_a_of_type_ComTencentChirpPcmPlayer = null;
        if (paramMessage.arg1 == 5) {
          awqx.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 1, 0, "", "", "", "");
        }
        if (paramMessage.arg1 == 3) {
          awqx.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 1, 0, "", "", "", "");
        }
        baan.a(this, false);
        break;
        if (this.jdField_a_of_type_ComTencentChirpPcmPlayer == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentChirpPcmPlayer.a();
        break;
        QQAppInterface.f(jdField_h_of_type_JavaLangString);
        break;
        bool1 = false;
      }
    }
  }
  
  public void i()
  {
    awqx.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "scan_QR_code", "code_click", 0, 0, "", "", "", "");
    if ("ScannerActivity".equals(this.jdField_f_of_type_JavaLangString))
    {
      if (isInMultiWindow()) {
        bbmy.a(this, ajjy.a(2131645403), 0).a();
      }
      setResult(-1);
      finish();
      return;
    }
    if (isInMultiWindow())
    {
      bbmy.a(this, ajjy.a(2131645405), 0).a();
      return;
    }
    Intent localIntent = new Intent(this, ScannerActivity.class);
    localIntent.putExtra("from", "QRDisplayActivity");
    startActivityForResult(localIntent, 3);
  }
  
  public void j() {}
  
  public void k()
  {
    if (isResume()) {
      this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004, 4, 0).sendToTarget();
    }
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.jdField_c_of_type_Long) <= 1000L) {}
    for (;;)
    {
      return;
      this.jdField_c_of_type_Long = l;
      if (paramView.getId() == 2131307734)
      {
        if (this.jdField_a_of_type_Boolean) {
          continue;
        }
        if (this.jdField_c_of_type_Int == 2)
        {
          f();
          if ((this.jdField_g_of_type_Int & 0x1) == 0) {
            continue;
          }
          awqx.b(this.app, "P_CliOper", "flag1", "", "0X8004170", "0X8004170", 0, 0, "", "", "", "");
          return;
        }
        if ((this.jdField_c_of_type_Int == 5) || (this.jdField_c_of_type_Int == 11))
        {
          f();
          awqx.b(this.app, "CliOper", "", "", "0X8006671", "0X8006671", 0, 0, "", "", "", "");
          return;
        }
        c();
        return;
      }
      if (paramView.getId() == 2131307719) {
        if (this.jdField_a_of_type_Begr == null) {
          this.jdField_a_of_type_Begr = new afhx(this).a(this);
        }
      }
      try
      {
        this.jdField_a_of_type_Begr.show();
        label204:
        awqx.b(this.app, "CliOper", "", "", "0X80040F6", "0X80040F6", 0, 0, "", "", "", "");
        return;
        if (paramView.getId() == 2131307729)
        {
          if (this.jdField_a_of_type_Boolean) {
            continue;
          }
          d();
          if ((this.jdField_g_of_type_Int & 0x1) != 0) {
            awqx.b(this.app, "P_CliOper", "flag1", "", "0X8004171", "0X8004171", 0, 0, "", "", "", "");
          }
          if (this.jdField_c_of_type_Int == 5) {
            awqx.b(this.app, "CliOper", "", "", "0X8006672", "0X8006672", 0, 0, "", "", "", "");
          }
          if (this.jdField_c_of_type_Int != 2) {
            continue;
          }
          new awrb(this.app).a("P_CliOper").b("Grp_set").c("Grp_data").d("qr_save").a(new String[] { this.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_Int) }).a();
          return;
        }
        if (paramView.getId() == 2131307730)
        {
          h();
          if (this.jdField_c_of_type_Int != 5) {
            continue;
          }
          awqx.b(this.app, "CliOper", "", "", "0X8006673", "0X8006673", 0, 0, "", "", "", "");
          return;
        }
        if ((paramView.getId() == 2131307739) || (paramView.getId() == 2131307741))
        {
          i();
          return;
        }
        if (paramView.getId() == 2131307724)
        {
          b(7);
          return;
        }
        if (paramView.getId() == 2131307727)
        {
          b(8);
          awqx.b(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "fukuanTCclick", 0, 0, "", "", "", "");
          return;
        }
        if (paramView.getId() != 2131307740) {
          continue;
        }
        i();
        return;
      }
      catch (Exception paramView)
      {
        break label204;
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Begr.dismiss();
      return;
      int j = -1;
      if (!WXShareHelper.a().a()) {
        j = 2131655008;
      }
      for (;;)
      {
        if (j == -1) {
          break label93;
        }
        vvp.a(1, j);
        break;
        if (!WXShareHelper.a().b()) {
          j = 2131655009;
        }
      }
      label93:
      if (this.jdField_a_of_type_Bbsh == null)
      {
        this.jdField_a_of_type_Bbsh = new vte(this);
        WXShareHelper.a().a(this.jdField_a_of_type_Bbsh);
      }
      paramView = this.app;
      label136:
      String str1;
      Bitmap localBitmap;
      String str2;
      if (paramInt == 2)
      {
        paramAdapterView = "1";
        awqx.b(paramView, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, paramAdapterView, "", "", "");
        this.jdField_g_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
        paramAdapterView = String.format(getString(2131626255), new Object[] { this.jdField_a_of_type_JavaLangString });
        if (this.jdField_c_of_type_Int == 11) {
          paramAdapterView = getString(2131627605);
        }
        paramView = WXShareHelper.a();
        str1 = this.jdField_g_of_type_JavaLangString;
        localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
        str2 = this.jdField_d_of_type_JavaLangString;
        if (paramInt != 2) {
          break label269;
        }
      }
      label269:
      for (paramInt = 0;; paramInt = 1)
      {
        paramView.b(str1, paramAdapterView, localBitmap, "", str2, paramInt);
        break;
        paramAdapterView = "0";
        break label136;
      }
      if (this.jdField_a_of_type_Bbms == null)
      {
        this.jdField_a_of_type_Bbms = new bbms(this, getTitleBarHeight());
        this.jdField_a_of_type_Bbms.c(2131629253);
        this.jdField_a_of_type_Bbms.c(false);
      }
      DiscussionInfoCardActivity.a(this.app, this, 2, this.jdField_e_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_f_of_type_Int, this.jdField_a_of_type_Bbms);
      continue;
      DiscussionInfoCardActivity.a(this.app, this, this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      continue;
      DiscussionInfoCardActivity.a(this.app, this.jdField_b_of_type_Long, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity
 * JD-Core Version:    0.7.0.1
 */