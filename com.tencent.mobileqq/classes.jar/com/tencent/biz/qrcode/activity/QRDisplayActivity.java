package com.tencent.biz.qrcode.activity;

import aekt;
import ahrk;
import almt;
import almv;
import almw;
import aloz;
import alpo;
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
import apgj;
import apgs;
import apgt;
import azmj;
import azmo;
import azmz;
import bdaj;
import bdaz;
import bdbt;
import bdcd;
import bdee;
import bdfq;
import bepp;
import bevy;
import bfvh;
import bhpy;
import bhql;
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
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gs;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mbt;
import mqq.os.MqqHandler;
import xtu;
import xtw;
import xum;
import xun;
import xuo;
import xup;
import xuq;
import xur;
import xus;
import xut;
import xuu;
import xuw;
import xux;
import xuy;
import xuz;
import xva;
import xvb;
import xvc;
import xxb;
import zdd;

public class QRDisplayActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, AdapterView.OnItemClickListener, apgt, xtu, xtw, zdd
{
  public static final String h;
  public int a;
  protected long a;
  public almt a;
  almw jdField_a_of_type_Almw = new xuu(this);
  public Bitmap a;
  public Bundle a;
  private CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer = new xuw(this, 1000L, 200L);
  protected Handler a;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new xuy(this);
  protected View a;
  public ImageView a;
  protected TextView a;
  private apgs jdField_a_of_type_Apgs;
  bepp jdField_a_of_type_Bepp;
  bevy jdField_a_of_type_Bevy;
  bfvh jdField_a_of_type_Bfvh = new xux(this);
  bhpy jdField_a_of_type_Bhpy;
  protected CodeMaskManager a;
  private PcmPlayer jdField_a_of_type_ComTencentChirpPcmPlayer;
  private ShareActionSheetBuilder jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
  public gs a;
  public Runnable a;
  public String a;
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  xvc jdField_a_of_type_Xvc = new xum(this);
  public boolean a;
  protected int b;
  public long b;
  protected Bitmap b;
  private Handler b;
  public View b;
  public ImageView b;
  protected TextView b;
  public bhpy b;
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
    jdField_h_of_type_JavaLangString = alpo.a(2131711579);
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
  
  public static List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696871);
    localActionSheetItem.icon = 2130838916;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 0;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696884);
    localActionSheetItem.icon = 2130838917;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696891);
    localActionSheetItem.icon = 2130838920;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696874);
    localActionSheetItem.icon = 2130838914;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "sendIsResumeBroadcast isNeedSend = " + this.jdField_e_of_type_Boolean + " ,isResume = " + paramBoolean);
    }
    if (this.jdField_e_of_type_Boolean) {
      mbt.a(BaseApplicationImpl.getContext(), paramBoolean);
    }
  }
  
  private void l()
  {
    String str1;
    if (!bdee.d(BaseApplication.getContext()))
    {
      QQToast.a(this, getString(2131692397), 0).b(getTitleBarHeight());
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
            bdaj.a("Grp_share", "grpData_admin", str1, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
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
                azmj.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_qq", 0, 0, this.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_Int), "");
                return;
              }
              catch (OutOfMemoryError localOutOfMemoryError2)
              {
                String str2;
                xxb.a(1, 2131696945);
              }
              try
              {
                if (this.jdField_a_of_type_Bevy == null)
                {
                  this.jdField_a_of_type_Bevy = new xut(this);
                  WXShareHelper.a().a(this.jdField_a_of_type_Bevy);
                }
                ThreadManager.post(new QRDisplayActivity.19(this), 8, null, true);
                return;
              }
              catch (OutOfMemoryError localOutOfMemoryError1)
              {
                xxb.a(1, 2131696945);
              }
            }
          } while (this.jdField_c_of_type_Int != 2);
          if (this.jdField_h_of_type_Int == 2) {}
          for (str2 = "qr_wechat";; str2 = "qr_circle")
          {
            bdaj.a("Grp_share", "grpData_admin", str2, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
            return;
          }
        } while (this.jdField_c_of_type_Int != 2);
        bdaj.a("Grp_share", "grpData_admin", "qr_qq", 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
        return;
      } while (this.jdField_c_of_type_Int != 5);
      azmj.b(this.app, "CliOper", "", "", "0X8006674", "0X8006674", 0, 0, "", "", "", "");
      return;
      e();
      if ((this.jdField_g_of_type_Int & 0x1) != 0) {
        azmj.b(this.app, "P_CliOper", "flag1", "", "0X800416E", "0X800416E", 0, 0, "", "", "", "");
      }
      if (this.jdField_c_of_type_Int == 2)
      {
        azmj.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_qzone", 0, 0, this.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_Int), "");
        return;
      }
    } while (this.jdField_c_of_type_Int != 5);
    azmj.b(this.app, "CliOper", "", "", "0X8006675", "0X8006675", 0, 0, "", "", "", "");
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
  
  public gs a(String paramString, int paramInt1, int paramInt2)
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
    return xxb.a(str, paramInt2);
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
      str = alpo.a(2131711577);
    }
    for (;;)
    {
      a(2130839391, str);
      finish();
      return;
      str = alpo.a(2131711578);
      continue;
      str = alpo.a(2131711575);
    }
  }
  
  void a(int paramInt, String paramString)
  {
    QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
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
        this.jdField_a_of_type_Gs = xxb.a((String)localObject, j);
      }
    }
    int i2 = this.jdField_a_of_type_Gs.a();
    Object localObject = new int[i2 * i2];
    int j = 0;
    while (j < i2)
    {
      k = 0;
      if (k < i2)
      {
        if (this.jdField_a_of_type_Gs.a(k, j)) {}
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
        j = 2130843417;
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_b_of_type_AndroidGraphicsBitmap = xxb.a(this, localBitmap1, this.jdField_a_of_type_AndroidGraphicsBitmap, paramBundle.getInt("nameClr"), this.jdField_a_of_type_JavaLangString, localBitmap2, localBitmap3, paramBundle.getInt("head"), paramBundle.getInt("tipsClr"), this.jdField_b_of_type_JavaLangString, localRect, localArrayList, j);
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
      j = 2130843417;
      break;
      label412:
      if (super.isResume())
      {
        paramBundle = bdcd.a(this, 230);
        paramBundle.setMessage(2131719393);
        paramBundle.setPositiveButton(2131694951, new xun(this));
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
    if (this.jdField_b_of_type_Bhpy == null)
    {
      this.jdField_b_of_type_Bhpy = ((bhpy)bhql.a(this, null));
      this.jdField_b_of_type_Bhpy.a(2131717579, 1);
      this.jdField_b_of_type_Bhpy.a(2131717581, 1);
      this.jdField_b_of_type_Bhpy.a(2131717578, 1);
      this.jdField_b_of_type_Bhpy.c(2131690648);
      this.jdField_b_of_type_Bhpy.setOnDismissListener(new xuz(this));
      this.jdField_b_of_type_Bhpy.a(new xva(this));
    }
    if (!this.jdField_b_of_type_Bhpy.isShowing())
    {
      this.jdField_f_of_type_Boolean = false;
      this.jdField_b_of_type_Bhpy.show();
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
      azmz.a(BaseApplication.getContext()).b(this.app, "", str, 1);
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
          bdaj.a("Grp_share", "grpData_admin", (String)localObject1, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), localObject2 });
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
          a(0, getString(2131717580));
          if (QLog.isColorLevel()) {
            QLog.i("QRDisplayActivity", 2, "shareQRCode success");
          }
          if ((this.jdField_g_of_type_Int & 0x1) != 0) {
            azmj.b(this.app, "P_CliOper", "flag1", "", "0X800416F", "0X800416F", 0, 0, "", "", "", "");
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
        localObject1 = aekt.a(new Intent(this, SplashActivity.class), null);
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
    super.setContentView(2131560232);
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
      this.jdField_b_of_type_JavaLangString = getString(2131717625);
      paramBundle = findViewById(2131367354);
      paramBundle.setVisibility(0);
      this.jdField_f_of_type_AndroidViewView = findViewById(2131373889);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373888));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373890));
      this.jdField_g_of_type_AndroidViewView = findViewById(2131373892);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373891));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373893));
      this.jdField_h_of_type_AndroidViewView = findViewById(2131373905);
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373904));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373906));
      j = (getWindowManager().getDefaultDisplay().getWidth() - getResources().getDimensionPixelSize(2131297835) * 3) / 8;
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
      this.jdField_b_of_type_AndroidViewView = super.findViewById(2131373911);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131373882));
      this.jdField_c_of_type_AndroidViewView = super.findViewById(2131373908);
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131373897);
      this.jdField_d_of_type_AndroidViewView = findViewById(2131373899);
      this.jdField_e_of_type_AndroidViewView = findViewById(2131372970);
      this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131696938));
      if (QLog.isDevelopLevel()) {
        QLog.d("QRDisplayActivity", 4, "display qrcode, type: " + this.jdField_c_of_type_Int);
      }
      if (this.jdField_c_of_type_Int != 5) {
        break label1456;
      }
      getIntent().getStringExtra("discussion_shorturl");
      addObserver(this.jdField_a_of_type_Almw);
      if (this.app != null)
      {
        this.jdField_a_of_type_Almt = ((almt)this.app.a(6));
        this.app.registObserver(this.jdField_a_of_type_Xvc);
      }
      this.leftView.setContentDescription(getString(2131696570));
      this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131696571));
      setResult(-1, getIntent());
      paramBundle = (aloz)this.app.getManager(51);
      localObject2 = (almv)this.app.getManager(53);
      localObject1 = ((almv)localObject2).a(this.jdField_c_of_type_JavaLangString);
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
        azmj.b(this.app, "P_CliOper", "flag1", "", "0X800416D", "0X800416D", 0, 0, "", "", "", "");
      }
      this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
      this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004, 1, 0).sendToTarget();
      return true;
      if (this.jdField_c_of_type_Int == 2)
      {
        findViewById(2131372969).setVisibility(0);
        findViewById(2131367353).setVisibility(0);
        findViewById(2131373894).setOnClickListener(this);
        findViewById(2131373895).setOnClickListener(this);
        this.jdField_b_of_type_JavaLangString = getString(2131717593);
      }
      else if (this.jdField_c_of_type_Int == 5)
      {
        findViewById(2131372969).setVisibility(0);
        findViewById(2131367353).setVisibility(0);
        findViewById(2131373894).setOnClickListener(this);
        findViewById(2131373895).setOnClickListener(this);
        this.jdField_b_of_type_JavaLangString = getString(2131717589);
      }
      else if (this.jdField_c_of_type_Int == 11)
      {
        findViewById(2131372969).setVisibility(0);
        findViewById(2131367353).setVisibility(0);
        findViewById(2131373894).setOnClickListener(this);
        findViewById(2131373895).setOnClickListener(this);
        this.jdField_b_of_type_JavaLangString = getString(2131717617);
      }
    }
    Object localObject2 = ((almv)localObject2).a(this.jdField_c_of_type_JavaLangString);
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
          this.jdField_b_of_type_JavaUtilList.add(bdbt.h(this.app, ((DiscussionMemberInfo)localObject2).memberUin));
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
      ((almt)this.app.a(6)).a(new String[] { "20002" }, paramBundle);
    }
    label1555:
    for (int k = 0;; k = 1)
    {
      j = k;
      if (this.jdField_b_of_type_JavaUtilList.size() <= 0) {
        break;
      }
      Collections.sort(this.jdField_b_of_type_JavaUtilList, new xvb(this));
      this.jdField_a_of_type_JavaLangString = a(this.jdField_b_of_type_JavaUtilList);
      j = k;
      break;
      label1456:
      if (this.jdField_c_of_type_Int == 2)
      {
        this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131717591, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
        addObserver(this.jdField_a_of_type_Bfvh);
        j = 1;
        break;
      }
      if (this.jdField_c_of_type_Int == 11) {
        this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131717591, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
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
      removeObserver(this.jdField_a_of_type_Almw);
      this.app.unRegistObserver(this.jdField_a_of_type_Xvc);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bevy != null)
      {
        WXShareHelper.a().b(this.jdField_a_of_type_Bevy);
        this.jdField_a_of_type_Bevy = null;
      }
      if (this.jdField_a_of_type_Apgs != null) {
        this.jdField_a_of_type_Apgs.b(this);
      }
      super.doOnDestroy();
      return;
      if (this.jdField_c_of_type_Int == 2) {
        removeObserver(this.jdField_a_of_type_Bfvh);
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
      azmz.a(BaseApplication.getContext()).b(this.app, "", str, 1);
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
      azmz.a(BaseApplication.getContext()).b(this.app, "", (String)localObject, 1);
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
      bdfq localbdfq = bdcd.a(this, 230);
      localbdfq.setMessage(2131719391);
      localbdfq.setPositiveButton(2131694951, new xuo(this));
      localbdfq.show();
      return;
    }
    finish();
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      xuq localxuq = new xuq(this);
      xur localxur = new xur(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(getString(2131720040));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setOnDismissListener(localxur);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setCancelListener(new xus(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(localxuq);
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.isShowing()))
      {
        this.jdField_f_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
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
        this.app.E();
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
            if (this.jdField_a_of_type_Apgs == null) {
              this.jdField_a_of_type_Apgs = ((apgs)((apgj)this.app.getManager(77)).a("qq.android.system.chirp"));
            }
            this.jdField_a_of_type_Apgs.a(this);
            this.jdField_a_of_type_Apgs.a(true);
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
            bdaz.a(this, true);
          }
          if (paramMessage.arg1 != 5) {
            break;
          }
          azmj.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 0, 0, "", "", "", "");
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
          azmj.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 1, 0, "", "", "", "");
        }
        if (paramMessage.arg1 == 3) {
          azmj.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 1, 0, "", "", "", "");
        }
        bdaz.a(this, false);
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
    azmj.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "scan_QR_code", "code_click", 0, 0, "", "", "", "");
    if ("ScannerActivity".equals(this.jdField_f_of_type_JavaLangString))
    {
      if (isInMultiWindow()) {
        QQToast.a(this, alpo.a(2131711574), 0).a();
      }
      setResult(-1);
      finish();
      return;
    }
    if (isInMultiWindow())
    {
      QQToast.a(this, alpo.a(2131711576), 0).a();
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
      if (paramView.getId() == 2131373899)
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
          azmj.b(this.app, "P_CliOper", "flag1", "", "0X8004170", "0X8004170", 0, 0, "", "", "", "");
          return;
        }
        if ((this.jdField_c_of_type_Int == 5) || (this.jdField_c_of_type_Int == 11))
        {
          f();
          azmj.b(this.app, "CliOper", "", "", "0X8006671", "0X8006671", 0, 0, "", "", "", "");
          return;
        }
        c();
        return;
      }
      if (paramView.getId() == 2131373884) {
        if (this.jdField_a_of_type_Bhpy == null) {
          this.jdField_a_of_type_Bhpy = new ahrk(this).a(this);
        }
      }
      try
      {
        this.jdField_a_of_type_Bhpy.show();
        label204:
        azmj.b(this.app, "CliOper", "", "", "0X80040F6", "0X80040F6", 0, 0, "", "", "", "");
        return;
        if (paramView.getId() == 2131373894)
        {
          if (this.jdField_a_of_type_Boolean) {
            continue;
          }
          d();
          if ((this.jdField_g_of_type_Int & 0x1) != 0) {
            azmj.b(this.app, "P_CliOper", "flag1", "", "0X8004171", "0X8004171", 0, 0, "", "", "", "");
          }
          if (this.jdField_c_of_type_Int == 5) {
            azmj.b(this.app, "CliOper", "", "", "0X8006672", "0X8006672", 0, 0, "", "", "", "");
          }
          if (this.jdField_c_of_type_Int != 2) {
            continue;
          }
          new azmo(this.app).a("P_CliOper").b("Grp_set").c("Grp_data").d("qr_save").a(new String[] { this.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_Int) }).a();
          return;
        }
        if (paramView.getId() == 2131373895)
        {
          h();
          if (this.jdField_c_of_type_Int != 5) {
            continue;
          }
          azmj.b(this.app, "CliOper", "", "", "0X8006673", "0X8006673", 0, 0, "", "", "", "");
          return;
        }
        if ((paramView.getId() == 2131373904) || (paramView.getId() == 2131373906))
        {
          i();
          return;
        }
        if (paramView.getId() == 2131373889)
        {
          b(7);
          return;
        }
        if (paramView.getId() == 2131373892)
        {
          b(8);
          azmj.b(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "fukuanTCclick", 0, 0, "", "", "", "");
          return;
        }
        if (paramView.getId() != 2131373905) {
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
      this.jdField_a_of_type_Bhpy.dismiss();
      return;
      int j = -1;
      if (!WXShareHelper.a().a()) {
        j = 2131721478;
      }
      for (;;)
      {
        if (j == -1) {
          break label93;
        }
        xxb.a(1, j);
        break;
        if (!WXShareHelper.a().b()) {
          j = 2131721479;
        }
      }
      label93:
      if (this.jdField_a_of_type_Bevy == null)
      {
        this.jdField_a_of_type_Bevy = new xup(this);
        WXShareHelper.a().a(this.jdField_a_of_type_Bevy);
      }
      paramView = this.app;
      label136:
      String str1;
      Bitmap localBitmap;
      String str2;
      if (paramInt == 2)
      {
        paramAdapterView = "1";
        azmj.b(paramView, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, paramAdapterView, "", "", "");
        this.jdField_g_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
        paramAdapterView = String.format(getString(2131691893), new Object[] { this.jdField_a_of_type_JavaLangString });
        if (this.jdField_c_of_type_Int == 11) {
          paramAdapterView = getString(2131693347);
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
      if (this.jdField_a_of_type_Bepp == null)
      {
        this.jdField_a_of_type_Bepp = new bepp(this, getTitleBarHeight());
        this.jdField_a_of_type_Bepp.c(2131695088);
        this.jdField_a_of_type_Bepp.c(false);
      }
      DiscussionInfoCardActivity.a(this.app, this, 2, this.jdField_e_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_f_of_type_Int, this.jdField_a_of_type_Bepp);
      continue;
      DiscussionInfoCardActivity.a(this.app, this, this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      continue;
      DiscussionInfoCardActivity.a(this.app, this.jdField_b_of_type_Long, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity
 * JD-Core Version:    0.7.0.1
 */