package com.tencent.biz.qrcode.activity;

import Override;
import abiq;
import agej;
import ajxw;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anwo;
import anws;
import anwt;
import anyw;
import anzj;
import aric;
import arie;
import arif;
import asde;
import asdl;
import asdm;
import baex;
import bdll;
import bdlq;
import bdmc;
import bhju;
import bhkm;
import bhlg;
import bhlq;
import bhmq;
import bhnv;
import bhpc;
import bhyu;
import bjbs;
import bjig;
import bkia;
import blir;
import blji;
import com.tencent.biz.qrcode.CodeMaskManager;
import com.tencent.chirp.ChirpWrapper;
import com.tencent.chirp.PcmPlayer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
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
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import gt;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import lzq;
import mqq.os.MqqHandler;
import zvj;
import zvl;
import zwb;
import zwc;
import zwd;
import zwe;
import zwf;
import zwg;
import zwh;
import zwi;
import zwj;
import zwk;
import zwl;
import zwn;
import zwo;
import zwp;
import zwq;
import zwr;
import zws;
import zwt;
import zwu;
import zwv;
import zww;
import zwx;
import zwy;
import zyx;

public class QRDisplayActivity
  extends IphoneTitleBarActivity
  implements abiq, Handler.Callback, View.OnClickListener, AdapterView.OnItemClickListener, CompoundButton.OnCheckedChangeListener, asdm, zvj, zvl
{
  public static final String j;
  public int a;
  protected long a;
  public Bitmap a;
  protected Drawable a;
  public Bundle a;
  private CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer = new zwn(this, 1000L, 200L);
  protected Handler a;
  protected View a;
  public ImageView a;
  public TextView a;
  public anwo a;
  anwt jdField_a_of_type_Anwt = new zwr(this);
  protected aric a;
  private asdl jdField_a_of_type_Asdl;
  bjbs jdField_a_of_type_Bjbs;
  bjig jdField_a_of_type_Bjig;
  bkia jdField_a_of_type_Bkia = new zwu(this);
  blir jdField_a_of_type_Blir;
  protected CodeMaskManager a;
  private PcmPlayer jdField_a_of_type_ComTencentChirpPcmPlayer;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private ShareActionSheetBuilder jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
  public gt a;
  public Runnable a;
  public String a;
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  zwx jdField_a_of_type_Zwx = new zwb(this);
  private zwy jdField_a_of_type_Zwy;
  public boolean a;
  protected int b;
  public long b;
  protected volatile Bitmap b;
  private Handler b;
  public View b;
  public ImageView b;
  public TextView b;
  public blir b;
  public Runnable b;
  public String b;
  public List<String> b;
  public boolean b;
  public int c;
  protected long c;
  public View c;
  public ImageView c;
  public TextView c;
  protected Runnable c;
  public String c;
  protected boolean c;
  protected int d;
  public View d;
  public ImageView d;
  protected TextView d;
  protected Runnable d;
  public String d;
  protected boolean d;
  protected int e;
  View e;
  protected ImageView e;
  protected TextView e;
  public String e;
  protected boolean e;
  int f;
  protected View f;
  protected ImageView f;
  protected TextView f;
  protected String f;
  protected boolean f;
  public int g;
  protected View g;
  protected ImageView g;
  protected TextView g;
  public String g;
  public boolean g;
  protected int h;
  protected View h;
  protected ImageView h;
  protected TextView h;
  protected String h;
  public boolean h;
  public int i;
  public View i;
  protected ImageView i;
  protected TextView i;
  protected String i;
  private boolean i;
  protected View j;
  protected ImageView j;
  protected TextView j;
  private volatile boolean j;
  protected View k;
  protected TextView k;
  private boolean k;
  public View l;
  protected View m;
  protected View n;
  
  static
  {
    jdField_j_of_type_JavaLangString = anzj.a(2131710078);
  }
  
  public QRDisplayActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_e_of_type_Boolean = true;
    this.jdField_h_of_type_Int = -1;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRunnable = new QRDisplayActivity.4(this);
    this.jdField_b_of_type_JavaLangRunnable = new QRDisplayActivity.5(this);
    this.jdField_c_of_type_JavaLangRunnable = new QRDisplayActivity.6(this);
    this.jdField_d_of_type_JavaLangRunnable = new QRDisplayActivity.8(this);
    this.jdField_i_of_type_Int = -1;
  }
  
  private void a(Bundle paramBundle, ArrayList<Rect> paramArrayList, Bitmap paramBitmap)
  {
    Bitmap localBitmap1;
    if (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
      localBitmap1 = BitmapFactory.decodeResource(getResources(), 2130846952);
    }
    for (;;)
    {
      paramBundle = zyx.a(this, localBitmap1, this.jdField_a_of_type_AndroidGraphicsBitmap, paramBitmap, paramArrayList, paramBundle.getInt("nameClr"), this.jdField_a_of_type_JavaLangString, String.format(getString(2131698295), new Object[] { this.jdField_c_of_type_JavaLangString }), paramBundle.getInt("tipsClr"), this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_Boolean, this.jdField_h_of_type_JavaLangString, true);
      if (this.jdField_b_of_type_AndroidGraphicsBitmap == null)
      {
        this.jdField_g_of_type_AndroidWidgetImageView.setImageBitmap(paramBundle[0]);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
        int i1 = bhyu.a();
        int i2 = bhyu.b();
        paramArrayList = bhyu.a(i1, i2, false, String.format(getString(2131698295), new Object[] { this.jdField_c_of_type_JavaLangString }));
        this.jdField_e_of_type_AndroidWidgetTextView.setText(paramArrayList);
        bhyu.a(this.jdField_e_of_type_AndroidWidgetTextView, i1, i2);
        bhyu.a("0X800B239", i1, i2);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(getString(2131698304));
        this.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        w();
      }
      this.jdField_b_of_type_AndroidGraphicsBitmap = paramBundle[1];
      if (localBitmap1 != null) {
        localBitmap1.recycle();
      }
      if (QLog.isColorLevel()) {
        QLog.d("QRDisplayActivity", 2, "onMaskReady: qrcodeCardCache = " + this.jdField_b_of_type_AndroidGraphicsBitmap);
      }
      return;
      try
      {
        localBitmap1 = bhmq.b(URLDrawable.getDrawable(this.jdField_i_of_type_JavaLangString).getCurrDrawable().mutate());
      }
      catch (Exception localException)
      {
        Bitmap localBitmap2 = BitmapFactory.decodeResource(getResources(), 2130846952);
      }
    }
  }
  
  private void a(arie paramarie, int paramInt, boolean paramBoolean)
  {
    if ("default_bg".equals(paramarie.jdField_a_of_type_JavaLangString))
    {
      b(paramarie, paramInt, paramBoolean);
      this.jdField_i_of_type_AndroidViewView.setBackgroundResource(2130846952);
      return;
    }
    int i1;
    if (this.jdField_i_of_type_AndroidViewView.getBackground() == null) {
      i1 = 1;
    }
    for (;;)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        if (i1 == 0) {
          break label238;
        }
        localDrawable = getResources().getDrawable(2130846952);
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramarie.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "setURLDrawable: urlDrawable = " + this.jdField_a_of_type_ComTencentImageURLDrawable + " status = " + this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus());
        }
        if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) {
          break label250;
        }
        b(paramarie, paramInt, paramBoolean);
        this.jdField_i_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable());
        return;
      }
      catch (IllegalArgumentException paramarie)
      {
        QLog.d("QRDisplayActivity", 1, "bkgURL is illegal please check manage info e =" + paramarie);
        QQToast.a(this, getString(2131695802), 0).a();
        w();
      }
      if (i1 == 0) {
        break;
      }
      this.jdField_i_of_type_AndroidViewView.setBackgroundResource(2130846952);
      return;
      i1 = 0;
      continue;
      label238:
      Drawable localDrawable = this.jdField_i_of_type_AndroidViewView.getBackground();
    }
    label250:
    if (i1 != 0) {
      this.jdField_i_of_type_AndroidViewView.setBackgroundResource(2130846952);
    }
    a(paramarie, paramInt, paramBoolean, this.jdField_a_of_type_ComTencentImageURLDrawable);
    v();
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
    this.jdField_a_of_type_ComTencentImageURLDrawable.setAutoDownload(true);
  }
  
  private void a(arie paramarie, int paramInt, boolean paramBoolean, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "setDrawableListener(): ud = " + paramURLDrawable + " bkgURL = " + paramarie.jdField_a_of_type_JavaLangString);
    }
    paramURLDrawable.setURLDrawableListener(new zws(this, paramarie, paramInt, paramBoolean));
  }
  
  private void a(arie paramarie, boolean paramBoolean)
  {
    if (paramarie == null) {
      QLog.i("QRDisplayActivity", 2, "switchMyQrTheme() qrCodeList is null just return");
    }
    do
    {
      return;
      this.jdField_h_of_type_Int = this.jdField_a_of_type_Aric.jdField_a_of_type_JavaUtilList.indexOf(paramarie);
      if (QLog.isColorLevel()) {
        QLog.i("QRDisplayActivity", 2, "switchMyQrTheme().qrCodeList:" + paramarie.toString());
      }
    } while (TextUtils.isEmpty(paramarie.jdField_a_of_type_JavaLangString));
    this.jdField_h_of_type_JavaLangString = paramarie.jdField_b_of_type_JavaLangString;
    this.jdField_e_of_type_Boolean = paramarie.c();
    this.jdField_i_of_type_JavaLangString = paramarie.jdField_a_of_type_JavaLangString;
    a(paramarie, this.jdField_h_of_type_Int, paramBoolean);
  }
  
  private static void a(short[] paramArrayOfShort, byte[] paramArrayOfByte)
  {
    int i1 = 0;
    while (i1 < paramArrayOfShort.length)
    {
      paramArrayOfByte[(i1 * 2)] = ((byte)(paramArrayOfShort[i1] & 0xFF));
      paramArrayOfByte[(i1 * 2 + 1)] = ((byte)(paramArrayOfShort[i1] >> 8 & 0xFF));
      i1 += 1;
    }
  }
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: new 452	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 455	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 458	java/io/File:exists	()Z
    //   13: ifne +187 -> 200
    //   16: new 460	com/tencent/chirp/ChirpWrapper
    //   19: dup
    //   20: invokespecial 461	com/tencent/chirp/ChirpWrapper:<init>	()V
    //   23: astore 5
    //   25: aload 5
    //   27: invokevirtual 462	com/tencent/chirp/ChirpWrapper:a	()I
    //   30: ifne +298 -> 328
    //   33: aload_0
    //   34: getfield 466	com/tencent/biz/qrcode/activity/QRDisplayActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: invokevirtual 471	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   40: astore_3
    //   41: new 201	java/lang/String
    //   44: dup
    //   45: ldc_w 473
    //   48: invokespecial 474	java/lang/String:<init>	(Ljava/lang/String;)V
    //   51: astore 4
    //   53: new 277	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 278	java/lang/StringBuilder:<init>	()V
    //   60: ldc_w 476
    //   63: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload 4
    //   68: iconst_0
    //   69: bipush 14
    //   71: aload_3
    //   72: invokevirtual 479	java/lang/String:length	()I
    //   75: isub
    //   76: invokevirtual 483	java/lang/String:substring	(II)Ljava/lang/String;
    //   79: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_3
    //   83: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore_3
    //   90: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq +30 -> 123
    //   96: ldc_w 275
    //   99: iconst_2
    //   100: new 277	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 278	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 485
    //   110: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_3
    //   114: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 294	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload 5
    //   125: aload_3
    //   126: invokevirtual 488	com/tencent/chirp/ChirpWrapper:a	(Ljava/lang/String;)Landroid/util/Pair;
    //   129: astore_3
    //   130: aload_3
    //   131: getfield 494	android/util/Pair:first	Ljava/lang/Object;
    //   134: checkcast 496	java/lang/Integer
    //   137: invokevirtual 499	java/lang/Integer:intValue	()I
    //   140: istore_2
    //   141: aload_3
    //   142: getfield 502	android/util/Pair:second	Ljava/lang/Object;
    //   145: checkcast 504	[S
    //   148: astore 4
    //   150: iload_2
    //   151: ifne +137 -> 288
    //   154: aload 4
    //   156: ifnull +132 -> 288
    //   159: new 506	java/io/FileOutputStream
    //   162: dup
    //   163: aload_1
    //   164: invokespecial 509	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   167: astore_3
    //   168: aload 4
    //   170: arraylength
    //   171: iconst_2
    //   172: imul
    //   173: newarray byte
    //   175: astore_1
    //   176: aload 4
    //   178: aload_1
    //   179: invokestatic 511	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	([S[B)V
    //   182: aload_3
    //   183: aload_1
    //   184: invokevirtual 515	java/io/FileOutputStream:write	([B)V
    //   187: aload_3
    //   188: ifnull +7 -> 195
    //   191: aload_3
    //   192: invokevirtual 518	java/io/FileOutputStream:close	()V
    //   195: aload 5
    //   197: invokevirtual 520	com/tencent/chirp/ChirpWrapper:a	()V
    //   200: iconst_1
    //   201: ireturn
    //   202: astore_1
    //   203: aload_1
    //   204: athrow
    //   205: astore_1
    //   206: aload 5
    //   208: invokevirtual 520	com/tencent/chirp/ChirpWrapper:a	()V
    //   211: aload_1
    //   212: athrow
    //   213: astore_3
    //   214: aconst_null
    //   215: astore_1
    //   216: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   219: ifeq +14 -> 233
    //   222: ldc_w 275
    //   225: iconst_2
    //   226: ldc_w 522
    //   229: aload_3
    //   230: invokestatic 525	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   233: aload_1
    //   234: astore_3
    //   235: aload_1
    //   236: ifnull +9 -> 245
    //   239: aload_1
    //   240: invokevirtual 518	java/io/FileOutputStream:close	()V
    //   243: aconst_null
    //   244: astore_3
    //   245: aload_3
    //   246: ifnull +7 -> 253
    //   249: aload_3
    //   250: invokevirtual 518	java/io/FileOutputStream:close	()V
    //   253: aload 5
    //   255: invokevirtual 520	com/tencent/chirp/ChirpWrapper:a	()V
    //   258: iconst_0
    //   259: ireturn
    //   260: astore_1
    //   261: aconst_null
    //   262: astore_3
    //   263: goto -18 -> 245
    //   266: astore_1
    //   267: aload_1
    //   268: athrow
    //   269: astore_1
    //   270: aconst_null
    //   271: astore_3
    //   272: aload_3
    //   273: ifnull +7 -> 280
    //   276: aload_3
    //   277: invokevirtual 518	java/io/FileOutputStream:close	()V
    //   280: aload_1
    //   281: athrow
    //   282: astore_1
    //   283: aload_1
    //   284: athrow
    //   285: astore_1
    //   286: aload_1
    //   287: athrow
    //   288: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   291: ifeq +30 -> 321
    //   294: ldc_w 275
    //   297: iconst_4
    //   298: new 277	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 278	java/lang/StringBuilder:<init>	()V
    //   305: ldc_w 527
    //   308: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: iload_2
    //   312: invokevirtual 370	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   315: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 294	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: aload 5
    //   323: invokevirtual 520	com/tencent/chirp/ChirpWrapper:a	()V
    //   326: iconst_0
    //   327: ireturn
    //   328: aload 5
    //   330: invokevirtual 520	com/tencent/chirp/ChirpWrapper:a	()V
    //   333: iconst_0
    //   334: ireturn
    //   335: astore_1
    //   336: goto -141 -> 195
    //   339: astore_1
    //   340: goto -87 -> 253
    //   343: astore_3
    //   344: goto -64 -> 280
    //   347: astore_1
    //   348: goto -76 -> 272
    //   351: astore 4
    //   353: aload_1
    //   354: astore_3
    //   355: aload 4
    //   357: astore_1
    //   358: goto -86 -> 272
    //   361: astore 4
    //   363: aload_3
    //   364: astore_1
    //   365: aload 4
    //   367: astore_3
    //   368: goto -152 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	this	QRDisplayActivity
    //   0	371	1	paramString	String
    //   140	172	2	i1	int
    //   40	152	3	localObject1	Object
    //   213	17	3	localException1	Exception
    //   234	43	3	str	String
    //   343	1	3	localIOException	java.io.IOException
    //   354	14	3	localObject2	Object
    //   51	126	4	localObject3	Object
    //   351	5	4	localObject4	Object
    //   361	5	4	localException2	Exception
    //   23	306	5	localChirpWrapper	ChirpWrapper
    // Exception table:
    //   from	to	target	type
    //   191	195	202	finally
    //   33	123	205	finally
    //   123	150	205	finally
    //   203	205	205	finally
    //   280	282	205	finally
    //   283	285	205	finally
    //   286	288	205	finally
    //   288	321	205	finally
    //   159	168	213	java/lang/Exception
    //   239	243	260	java/io/IOException
    //   239	243	266	finally
    //   159	168	269	finally
    //   267	269	269	finally
    //   249	253	282	finally
    //   276	280	285	finally
    //   191	195	335	java/io/IOException
    //   249	253	339	java/io/IOException
    //   276	280	343	java/io/IOException
    //   168	187	347	finally
    //   216	233	351	finally
    //   168	187	361	java/lang/Exception
  }
  
  public static List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131695738);
    localActionSheetItem.icon = 2130839091;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 0;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131695751);
    localActionSheetItem.icon = 2130839092;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131695758);
    localActionSheetItem.icon = 2130839095;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131695741);
    localActionSheetItem.icon = 2130839089;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private void b(int paramInt, String paramString)
  {
    try
    {
      ThreadManager.post(new QRDisplayActivity.29(this, "temp_qrcode_share_" + paramString + ".png", paramInt, paramString), 8, null, true);
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      zyx.a(1, 2131695817);
    }
  }
  
  private void b(Bundle paramBundle, ArrayList<Rect> paramArrayList, Bitmap paramBitmap)
  {
    Bitmap localBitmap1;
    Bitmap localBitmap3;
    int i1;
    String str1;
    String str2;
    int i2;
    boolean bool2;
    String str3;
    if (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))
    {
      localBitmap1 = BitmapFactory.decodeResource(getResources(), 2130846952);
      localBitmap3 = this.jdField_a_of_type_AndroidGraphicsBitmap;
      i1 = paramBundle.getInt("nameClr");
      str1 = this.jdField_a_of_type_JavaLangString;
      str2 = String.format(getString(2131698519), new Object[] { this.jdField_c_of_type_JavaLangString });
      i2 = paramBundle.getInt("tipsClr");
      paramBundle = this.jdField_b_of_type_JavaLangString;
      bool2 = this.jdField_e_of_type_Boolean;
      str3 = this.jdField_h_of_type_JavaLangString;
      if (this.jdField_f_of_type_Boolean) {
        break label256;
      }
    }
    label256:
    for (boolean bool1 = true;; bool1 = false)
    {
      for (;;)
      {
        paramBundle = zyx.a(this, localBitmap1, localBitmap3, paramBitmap, paramArrayList, i1, str1, str2, i2, paramBundle, bool2, str3, bool1);
        if (this.jdField_b_of_type_AndroidGraphicsBitmap == null)
        {
          this.jdField_i_of_type_AndroidWidgetImageView.setImageBitmap(paramBundle[0]);
          this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
          this.jdField_i_of_type_AndroidWidgetTextView.setText(String.format(getString(2131698519), new Object[] { this.jdField_c_of_type_JavaLangString }));
          this.jdField_j_of_type_AndroidWidgetTextView.setText(getString(2131698304));
          this.jdField_h_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        }
        this.jdField_b_of_type_AndroidGraphicsBitmap = paramBundle[1];
        localBitmap1.recycle();
        return;
        try
        {
          localBitmap1 = bhmq.b(URLDrawable.getDrawable(this.jdField_i_of_type_JavaLangString).getCurrDrawable().mutate());
        }
        catch (Exception localException)
        {
          Bitmap localBitmap2 = BitmapFactory.decodeResource(getResources(), 2130846952);
        }
      }
      break;
    }
  }
  
  private void b(arie paramarie, int paramInt, boolean paramBoolean)
  {
    int i1 = -1;
    if (paramBoolean) {
      h();
    }
    w();
    zyx.a(this.app, paramInt);
    Object localObject;
    if (!paramarie.a())
    {
      paramBoolean = true;
      ImmersiveUtils.a(paramBoolean, getWindow());
      localObject = getResources().getDrawable(2130843670);
      if (!paramarie.b()) {
        break label168;
      }
      paramInt = -1;
      label63:
      ((Drawable)localObject).setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
      this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
      localObject = getResources().getDrawable(2130850668);
      if (!paramarie.b()) {
        break label175;
      }
      paramInt = -1;
      label102:
      ((Drawable)localObject).setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
      this.leftView.setBackgroundDrawable((Drawable)localObject);
      localObject = this.centerView;
      if (!paramarie.b()) {
        break label182;
      }
    }
    label168:
    label175:
    label182:
    for (paramInt = i1;; paramInt = -16777216)
    {
      ((TextView)localObject).setTextColor(paramInt);
      this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130844913);
      this.jdField_g_of_type_AndroidViewView.setBackgroundResource(2130844913);
      return;
      paramBoolean = false;
      break;
      paramInt = -16777216;
      break label63;
      paramInt = -16777216;
      break label102;
    }
  }
  
  private void b(arie paramarie, int paramInt, boolean paramBoolean, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "setTroopDrawableListener(): ud = " + paramURLDrawable + " bkgURL = " + paramarie.jdField_a_of_type_JavaLangString);
    }
    paramURLDrawable.setURLDrawableListener(new zwt(this, paramarie, paramInt, paramBoolean));
  }
  
  private void b(arie paramarie, boolean paramBoolean)
  {
    if (paramarie == null) {
      QLog.i("QRDisplayActivity", 2, "switchMyQrTheme() qrCodeList is null just return");
    }
    do
    {
      return;
      this.jdField_h_of_type_Int = this.jdField_a_of_type_Aric.jdField_a_of_type_JavaUtilList.indexOf(paramarie);
      if (QLog.isColorLevel()) {
        QLog.i("QRDisplayActivity", 2, "switchMyQrTheme().qrCodeList:" + paramarie.toString());
      }
    } while (TextUtils.isEmpty(paramarie.jdField_a_of_type_JavaLangString));
    this.jdField_h_of_type_JavaLangString = paramarie.jdField_b_of_type_JavaLangString;
    this.jdField_e_of_type_Boolean = paramarie.c();
    this.jdField_i_of_type_JavaLangString = paramarie.jdField_a_of_type_JavaLangString;
    c(paramarie, this.jdField_h_of_type_Int, paramBoolean);
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "sendIsResumeBroadcast isNeedSend = " + this.jdField_g_of_type_Boolean + " ,isResume = " + paramBoolean);
    }
    if (this.jdField_g_of_type_Boolean) {
      lzq.a(BaseApplicationImpl.getContext(), paramBoolean);
    }
  }
  
  private void c(arie paramarie, int paramInt, boolean paramBoolean)
  {
    if (paramarie == null)
    {
      QLog.i("QRDisplayActivity", 2, "setTroopURLDrawable() qrCodeList is null just return");
      return;
    }
    if ("default_bg".equals(paramarie.jdField_a_of_type_JavaLangString))
    {
      d(paramarie, paramInt, paramBoolean);
      this.l.setBackgroundResource(2130846952);
      return;
    }
    int i1;
    if (this.l.getBackground() == null) {
      i1 = 1;
    }
    for (;;)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        if (i1 == 0) {
          break label274;
        }
        localObject = getResources().getDrawable(2130846952);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramarie.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
        if (QLog.isColorLevel())
        {
          if ("setTroopURLDrawable: urlDrawable = " + this.jdField_a_of_type_ComTencentImageURLDrawable + " status = " + this.jdField_a_of_type_ComTencentImageURLDrawable == null) {
            break label331;
          }
          localObject = Integer.valueOf(this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus());
          QLog.d("QRDisplayActivity", 2, new Object[] { localObject });
        }
        if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) {
          break label286;
        }
        d(paramarie, paramInt, paramBoolean);
        this.l.setBackgroundDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable());
        return;
      }
      catch (IllegalArgumentException paramarie)
      {
        QLog.d("QRDisplayActivity", 1, "setTroopURLDrawable bkgURL is illegal please check manage info e =" + paramarie);
        QQToast.a(this, getString(2131695802), 0).a();
        w();
      }
      if (i1 == 0) {
        break;
      }
      this.l.setBackgroundResource(2130846952);
      return;
      i1 = 0;
      continue;
      label274:
      Object localObject = this.l.getBackground();
      continue;
      label286:
      if (i1 != 0) {
        this.l.setBackgroundResource(2130846952);
      }
      b(paramarie, paramInt, paramBoolean, this.jdField_a_of_type_ComTencentImageURLDrawable);
      v();
      this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
      this.jdField_a_of_type_ComTencentImageURLDrawable.setAutoDownload(true);
      return;
      label331:
      localObject = " is null";
    }
  }
  
  private void d(arie paramarie, int paramInt, boolean paramBoolean)
  {
    int i1 = -1;
    if (paramBoolean) {
      h();
    }
    w();
    zyx.b(this.app, paramInt);
    Object localObject;
    if (!paramarie.a())
    {
      paramBoolean = true;
      ImmersiveUtils.a(paramBoolean, getWindow());
      localObject = getResources().getDrawable(2130850668);
      if (!paramarie.b()) {
        break label129;
      }
      paramInt = -1;
      label63:
      ((Drawable)localObject).setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
      this.leftView.setBackgroundDrawable((Drawable)localObject);
      localObject = this.centerView;
      if (!paramarie.b()) {
        break label136;
      }
    }
    label129:
    label136:
    for (paramInt = i1;; paramInt = -16777216)
    {
      ((TextView)localObject).setTextColor(paramInt);
      this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130844913);
      this.jdField_h_of_type_AndroidViewView.setBackgroundResource(2130844913);
      return;
      paramBoolean = false;
      break;
      paramInt = -16777216;
      break label63;
    }
  }
  
  private void n()
  {
    Object localObject1 = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject1).gravity = 17;
    this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(null);
    getTitleBarView().setBackgroundColor(0);
    ImmersiveUtils.a(true, getWindow());
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    findViewById(2131374785).setBackgroundDrawable(null);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_i_of_type_AndroidViewView = findViewById(16908290);
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369056));
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(getString(2131696848));
    this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.leftView.setContentDescription(getString(2131717997));
    this.jdField_j_of_type_AndroidViewView = findViewById(2131374806);
    this.jdField_j_of_type_AndroidViewView.setVisibility(0);
    this.jdField_k_of_type_AndroidViewView = this.jdField_j_of_type_AndroidViewView.findViewById(2131374762);
    this.jdField_k_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_k_of_type_AndroidViewView.setContentDescription(getString(2131698304));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_j_of_type_AndroidViewView.findViewById(2131369293));
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_j_of_type_AndroidViewView.findViewById(2131369333));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131379963));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131380172));
    localObject1 = anzj.a(2131695804);
    Object localObject2 = this.jdField_c_of_type_JavaLangString;
    localObject1 = baex.a(this.jdField_e_of_type_AndroidWidgetTextView, (String)localObject1, (String)localObject2);
    if (localObject1 != null) {
      ((baex)localObject1).a(new zwk(this));
    }
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131380137));
    this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131715834));
    this.jdField_b_of_type_JavaLangString = getString(2131715972);
    localObject1 = findViewById(2131367739);
    ((View)localObject1).setVisibility(0);
    this.jdField_f_of_type_AndroidViewView = findViewById(2131374796);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374795));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374797));
    this.jdField_g_of_type_AndroidViewView = findViewById(2131374811);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374810));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374812));
    int i1 = (getWindowManager().getDefaultDisplay().getWidth() - getResources().getDimensionPixelSize(2131297928) * 3) / 8;
    localObject2 = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
    if (localObject2 != null)
    {
      ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = i1;
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = i1;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    this.jdField_a_of_type_Zwy = new zwy(this, null);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_Zwy);
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_g_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_Zwy);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839414);
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374423));
    this.jdField_a_of_type_Aric = arif.a();
    if ((this.jdField_a_of_type_Aric.jdField_a_of_type_JavaUtilList.size() <= 0) || (TextUtils.isEmpty(((arie)this.jdField_a_of_type_Aric.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString))) {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_h_of_type_Int = zyx.a(this.app);
    if ((this.jdField_h_of_type_Int < 0) || (this.jdField_h_of_type_Int >= this.jdField_a_of_type_Aric.jdField_a_of_type_JavaUtilList.size()))
    {
      this.jdField_i_of_type_AndroidViewView.setBackgroundResource(2130846952);
      localObject1 = getResources().getDrawable(2130843670);
      ((Drawable)localObject1).setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
      this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject1);
      localObject1 = getResources().getDrawable(2130850668);
      ((Drawable)localObject1).setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
      this.leftView.setBackgroundDrawable((Drawable)localObject1);
      this.centerView.setTextColor(-16777216);
    }
    for (;;)
    {
      bdll.b(this.app, "CliOper", "", "", "0X800AEAB", "0X800AEAB", 0, 0, "", "", "", "");
      return;
      a((arie)this.jdField_a_of_type_Aric.jdField_a_of_type_JavaUtilList.get(this.jdField_h_of_type_Int), false);
    }
  }
  
  private void o()
  {
    String str1;
    if (!bhnv.d(BaseApplication.getContext()))
    {
      QQToast.a(this, getString(2131691989), 0).b(getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.i("QRDisplayActivity", 2, "tryToGetShareLink: net is not supported");
      }
      if (this.jdField_c_of_type_Int == 2)
      {
        str1 = "";
        switch (this.jdField_i_of_type_Int)
        {
        }
        while (TextUtils.isEmpty(str1))
        {
          return;
          str1 = "qr_circle";
          continue;
          str1 = "qr_qq";
          continue;
          str1 = "qr_qzone";
          continue;
          str1 = "qr_wechat";
        }
        bhju.a("Grp_share", "grpData_admin", str1, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
      }
      this.jdField_i_of_type_Int = -1;
      return;
    }
    switch (this.jdField_i_of_type_Int)
    {
    default: 
      return;
    case 0: 
    case 2: 
    case 3: 
      try
      {
        ThreadManager.post(new QRDisplayActivity.22(this, "temp_qrcode_share_" + this.jdField_c_of_type_JavaLangString + ".png"), 8, null, true);
        if (this.jdField_c_of_type_Int != 2) {
          break;
        }
        bdll.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_qq", 0, 0, this.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_Int), "");
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        int i1;
        zyx.a(1, 2131695817);
      }
      i1 = -1;
    }
    for (;;)
    {
      try
      {
        if (WXShareHelper.a().a()) {
          break label474;
        }
        i1 = 2131719399;
        if (i1 == -1) {
          break label490;
        }
        QQToast.a(this, getString(i1), 0).b(getTitleBarHeight());
        if (this.jdField_c_of_type_Int == 2)
        {
          if (this.jdField_i_of_type_Int != 2) {
            break label789;
          }
          str1 = "qr_wechat";
          bhju.a("Grp_share", "grpData_admin", str1, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
        }
        this.jdField_i_of_type_Int = -1;
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        zyx.a(1, 2131695817);
      }
      if (this.jdField_c_of_type_Int != 2) {
        break;
      }
      if (this.jdField_i_of_type_Int == 2) {}
      for (String str2 = "qr_wechat";; str2 = "qr_circle")
      {
        bhju.a("Grp_share", "grpData_admin", str2, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
        return;
        label474:
        if (WXShareHelper.a().b()) {
          break;
        }
        i1 = 2131719400;
        break;
        label490:
        if (this.jdField_a_of_type_Bjig == null)
        {
          this.jdField_a_of_type_Bjig = new zwl(this);
          WXShareHelper.a().a(this.jdField_a_of_type_Bjig);
        }
        ThreadManager.post(new QRDisplayActivity.21(this), 8, null, true);
        return;
      }
      if (this.jdField_c_of_type_Int != 2) {
        break;
      }
      bhju.a("Grp_share", "grpData_admin", "qr_qq", 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
      return;
      if (this.jdField_c_of_type_Int != 5) {
        break;
      }
      bdll.b(this.app, "CliOper", "", "", "0X8006674", "0X8006674", 0, 0, "", "", "", "");
      return;
      g();
      if ((this.jdField_g_of_type_Int & 0x1) != 0) {
        bdll.b(this.app, "P_CliOper", "flag1", "", "0X800416E", "0X800416E", 0, 0, "", "", "", "");
      }
      if (this.jdField_c_of_type_Int == 2)
      {
        bdll.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_qzone", 0, 0, this.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_Int), "");
        return;
      }
      if (this.jdField_c_of_type_Int != 5) {
        break;
      }
      bdll.b(this.app, "CliOper", "", "", "0X8006675", "0X8006675", 0, 0, "", "", "", "");
      return;
      label789:
      String str3 = "qr_circle";
    }
  }
  
  private void p()
  {
    if ((this.app.d()) || (!AppSetting.jdField_c_of_type_Boolean)) {
      return;
    }
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1000, 5, 0);
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void q()
  {
    if ((this.app.d()) || (!AppSetting.jdField_c_of_type_Boolean)) {
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1001, 5, 0).sendToTarget();
  }
  
  private void r()
  {
    blir localblir = (blir)blji.a(this, null);
    localblir.a(2131695803, 1, 7);
    localblir.a(2131695809, 1, 8);
    localblir.c(2131690580);
    localblir.a(new zwo(this, localblir));
    if (!localblir.isShowing()) {
      localblir.show();
    }
  }
  
  private void s()
  {
    Object localObject1 = new ShareActionSheetV2.Param();
    getIntent().putExtra("big_brother_source_key", "biz_src_jc_gxl_ctcshare");
    ((ShareActionSheetV2.Param)localObject1).canceledOnTouchOutside = true;
    ((ShareActionSheetV2.Param)localObject1).context = this;
    ((ShareActionSheetV2.Param)localObject1).fullScreen = true;
    ((ShareActionSheetV2.Param)localObject1).lp = new ViewGroup.LayoutParams(-1, -2);
    localObject1 = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject1);
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("forward_type", 27);
    ((ShareActionSheet)localObject1).setIntentForStartForwardRecentActivity((Intent)localObject2);
    ((ShareActionSheet)localObject1).setRowVisibility(0, 0, 0);
    localObject2 = new ArrayList();
    ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(26));
    ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    boolean bool1 = WXShareHelper.a().a();
    boolean bool2 = WXShareHelper.a().b();
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, " showMyQrCodeActionSheet() isWxInstalled = " + bool1 + " isWxSupportApi =" + bool2);
    }
    if ((bool1) && (bool2))
    {
      ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(9));
      ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(1));
    ((ShareActionSheet)localObject1).setActionSheetItems((List)localObject2, localArrayList);
    ((ShareActionSheet)localObject1).setItemClickListenerV2(new zwp(this));
    ((ShareActionSheet)localObject1).show();
  }
  
  private void t()
  {
    Object localObject1 = new ShareActionSheetV2.Param();
    getIntent().putExtra("big_brother_source_key", "biz_src_jc_gxl_ctcshare");
    ((ShareActionSheetV2.Param)localObject1).canceledOnTouchOutside = true;
    ((ShareActionSheetV2.Param)localObject1).context = this;
    ((ShareActionSheetV2.Param)localObject1).fullScreen = true;
    ((ShareActionSheetV2.Param)localObject1).lp = new ViewGroup.LayoutParams(-1, -2);
    localObject1 = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject1);
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("forward_type", 27);
    ((ShareActionSheet)localObject1).setIntentForStartForwardRecentActivity((Intent)localObject2);
    ((ShareActionSheet)localObject1).setRowVisibility(0, 0, 0);
    localObject2 = new ArrayList();
    ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(26));
    ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    boolean bool1 = WXShareHelper.a().a();
    boolean bool2 = WXShareHelper.a().b();
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, " showMyQrCodeActionSheet() isWxInstalled = " + bool1 + " isWxSupportApi =" + bool2);
    }
    if ((bool1) && (bool2))
    {
      ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(9));
      ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
    ((ShareActionSheet)localObject1).setActionSheetItems((List)localObject2, localArrayList);
    ((ShareActionSheet)localObject1).setItemClickListenerV2(new zwq(this));
    ((ShareActionSheet)localObject1).show();
  }
  
  private void u()
  {
    String str = String.format(getString(2131689586), new Object[] { a() });
    if (QLog.isColorLevel()) {
      QLog.i("QRDisplayActivity", 2, "copyTroopLink.text:" + str);
    }
    if (Build.VERSION.SDK_INT < 11) {
      ((android.text.ClipboardManager)getSystemService("clipboard")).setText(str);
    }
    for (;;)
    {
      QQToast.a(this, 2, getString(2131689987), 0).b(getTitleBarHeight());
      this.jdField_i_of_type_Int = -1;
      return;
      ((android.content.ClipboardManager)getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("my_qr_url", str));
    }
  }
  
  private void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "showURLProgressView() mTvProgress =" + this.jdField_g_of_type_AndroidWidgetTextView);
    }
    if ((this.jdField_g_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  private void w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "hideURLProgressView() mTvProgress =" + this.jdField_g_of_type_AndroidWidgetTextView);
    }
    if ((this.jdField_g_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_g_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public gt a(String paramString, int paramInt1, int paramInt2)
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
    return zyx.a(str, paramInt2);
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
    int i1 = 0;
    while (i1 < paramList.size())
    {
      localStringBuffer.append((String)paramList.get(i1));
      if (i1 != paramList.size() - 1) {
        localStringBuffer.append("、");
      }
      i1 += 1;
    }
    return localStringBuffer.toString();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "enter focus, " + this.app.d());
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    String str;
    switch (paramInt)
    {
    default: 
      str = anzj.a(2131710076);
    }
    for (;;)
    {
      a(2130839580, str);
      finish();
      return;
      str = anzj.a(2131710077);
      continue;
      str = anzj.a(2131710074);
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
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    Bitmap localBitmap1 = (Bitmap)paramBundle.getParcelable("bkg");
    Bitmap localBitmap2 = (Bitmap)paramBundle.getParcelable("qrbkg");
    int i4 = paramBundle.getInt("B");
    int i5 = paramBundle.getInt("W");
    Rect localRect = (Rect)paramBundle.getParcelable("qrloc");
    ArrayList localArrayList = paramBundle.getParcelableArrayList("clip");
    if (paramBundle.containsKey("qrsz"))
    {
      i1 = paramBundle.getInt("qrsz");
      localObject = a();
      if (localObject != null) {
        this.jdField_a_of_type_Gt = zyx.a((String)localObject, i1);
      }
    }
    int i6 = this.jdField_a_of_type_Gt.a();
    Object localObject = new int[i6 * i6];
    int i1 = 0;
    while (i1 < i6)
    {
      i2 = 0;
      if (i2 < i6)
      {
        if (this.jdField_a_of_type_Gt.a(i2, i1)) {}
        for (int i3 = i4;; i3 = i5)
        {
          localObject[(i1 * i6 + i2)] = i3;
          i2 += 1;
          break;
        }
      }
      i1 += 1;
    }
    Bitmap localBitmap3 = Bitmap.createBitmap(i6, i6, Bitmap.Config.ARGB_8888);
    localBitmap3.setPixels((int[])localObject, 0, i6, 0, 0, i6, i6);
    int i2 = 0;
    i1 = i2;
    if ((this.jdField_a_of_type_Long & 0x800) != 0L)
    {
      if (this.jdField_b_of_type_Int == 2) {
        i1 = 2130843809;
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      }
      if (this.jdField_c_of_type_Int != 1) {
        break label378;
      }
      a(paramBundle, localArrayList, localBitmap3);
      label332:
      localBitmap3.recycle();
      if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
        break label451;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      i1 = i2;
      if (this.jdField_b_of_type_Int != 1) {
        break;
      }
      i1 = 2130843809;
      break;
      label378:
      if (this.jdField_c_of_type_Int == 2)
      {
        b(paramBundle, localArrayList, localBitmap3);
        break label332;
      }
      this.jdField_b_of_type_AndroidGraphicsBitmap = zyx.a(this, localBitmap1, this.jdField_a_of_type_AndroidGraphicsBitmap, paramBundle.getInt("nameClr"), this.jdField_a_of_type_JavaLangString, localBitmap2, localBitmap3, paramBundle.getInt("head"), paramBundle.getInt("tipsClr"), this.jdField_b_of_type_JavaLangString, localRect, localArrayList, i1);
      break label332;
      label451:
      if (super.isResume())
      {
        paramBundle = bhlq.a(this, 230);
        paramBundle.setMessage(2131717580);
        paramBundle.setPositiveButton(2131694098, new zwe(this));
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
    for (int i1 = -1;; i1 = 0)
    {
      ((ResultReceiver)localObject).send(i1, localIntent.getExtras());
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
    long l1 = VACDReportUtil.a(null, "qqwallet", "payCode", "click", "1", 0, null);
    Intent localIntent = new Intent(this, JumpActivity.class);
    localIntent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=" + paramInt + "&entry=1&seq=" + l1));
    startActivityForResult(localIntent, -1);
  }
  
  protected void c()
  {
    Object localObject1 = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(null);
    getTitleBarView().setBackgroundColor(0);
    ImmersiveUtils.a(true, getWindow());
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    findViewById(2131374785).setBackgroundDrawable(null);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.l = findViewById(16908290);
    this.m = findViewById(2131374817);
    this.m.setVisibility(0);
    this.n = this.m.findViewById(2131374761);
    this.n.setOnClickListener(this);
    this.n.setContentDescription(getString(2131698304));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)this.m.findViewById(2131374753));
    this.jdField_h_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)this.m.findViewById(2131374754));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.m.findViewById(2131374758));
    this.jdField_h_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_h_of_type_AndroidWidgetTextView.setSingleLine();
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.m.findViewById(2131374760));
    this.jdField_j_of_type_AndroidWidgetImageView = ((ImageView)this.m.findViewById(2131374755));
    this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)this.m.findViewById(2131374757));
    Object localObject2 = anzj.a(2131695805);
    Object localObject3 = this.jdField_c_of_type_JavaLangString;
    baex.a(this.jdField_i_of_type_AndroidWidgetTextView, (String)localObject2, (String)localObject3);
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.m.findViewById(2131374759));
    this.jdField_i_of_type_AndroidWidgetTextView.setContentDescription(getString(2131715833));
    localObject2 = findViewById(2131367740);
    ((View)localObject2).setVisibility(0);
    this.jdField_f_of_type_AndroidViewView = findViewById(2131374799);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374798));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374800));
    this.jdField_h_of_type_AndroidViewView = findViewById(2131374819);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374818));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374820));
    localObject3 = (TroopManager)this.app.getManager(52);
    if (localObject3 != null)
    {
      localObject3 = ((TroopManager)localObject3).b(this.jdField_c_of_type_JavaLangString);
      if (localObject3 != null)
      {
        if (((TroopInfo)localObject3).isNewTroop)
        {
          this.jdField_f_of_type_Boolean = true;
          this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_i_of_type_AndroidWidgetTextView.getLayoutParams();
          ((FrameLayout.LayoutParams)localObject1).topMargin = 0;
          this.jdField_i_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
          localObject1 = (RelativeLayout.LayoutParams)this.n.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).height -= 42;
          this.n.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if ((((TroopInfo)localObject3).cGroupOption != 3) || ((TroopInfo.hasPayPrivilege(((TroopInfo)localObject3).troopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(((TroopInfo)localObject3).troopPrivilegeFlag, 512)))) {
          break label920;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "initTroopQrCodeUI: not allow join mask");
        }
        this.jdField_j_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_k_of_type_AndroidWidgetTextView.setText(getString(2131695818));
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        this.jdField_h_of_type_AndroidViewView.setVisibility(8);
      }
    }
    for (;;)
    {
      int i1 = (getWindowManager().getDefaultDisplay().getWidth() - getResources().getDimensionPixelSize(2131297928) * 3) / 8;
      localObject1 = (ViewGroup.MarginLayoutParams)((View)localObject2).getLayoutParams();
      if (localObject1 != null)
      {
        ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = i1;
        ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = i1;
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.jdField_a_of_type_Zwy = new zwy(this, null);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_Zwy);
      this.jdField_h_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_h_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_Zwy);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839414);
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374423));
      this.jdField_b_of_type_JavaLangString = getString(2131715939);
      this.leftView.setContentDescription(getString(2131697029));
      this.jdField_a_of_type_Aric = arif.a();
      if ((this.jdField_a_of_type_Aric.jdField_a_of_type_JavaUtilList.size() <= 0) || (TextUtils.isEmpty(((arie)this.jdField_a_of_type_Aric.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString))) {
        this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_h_of_type_Int = zyx.b(this.app);
      if ((this.jdField_h_of_type_Int >= 0) && (this.jdField_h_of_type_Int < this.jdField_a_of_type_Aric.jdField_a_of_type_JavaUtilList.size())) {
        break;
      }
      this.l.setBackgroundResource(2130846952);
      localObject1 = getResources().getDrawable(2130850668);
      ((Drawable)localObject1).setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
      this.leftView.setBackgroundDrawable((Drawable)localObject1);
      this.centerView.setTextColor(-16777216);
      return;
      label920:
      if (((((TroopInfo)localObject3).dwGroupFlagExt & 0x80) != 0L) && (!((TroopInfo)localObject3).isAdmin()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "initTroopQrCodeUI: not invite join mask");
        }
        this.jdField_j_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_k_of_type_AndroidWidgetTextView.setText(getString(2131695819));
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        this.jdField_h_of_type_AndroidViewView.setVisibility(8);
      }
    }
    b((arie)this.jdField_a_of_type_Aric.jdField_a_of_type_JavaUtilList.get(this.jdField_h_of_type_Int), false);
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
  
  protected void d()
  {
    if (this.jdField_b_of_type_Blir == null)
    {
      this.jdField_b_of_type_Blir = ((blir)blji.a(this, null));
      this.jdField_b_of_type_Blir.a(2131715925, 1);
      this.jdField_b_of_type_Blir.a(2131715927, 1);
      this.jdField_b_of_type_Blir.a(2131715924, 1);
      this.jdField_b_of_type_Blir.c(2131690580);
      this.jdField_b_of_type_Blir.setOnDismissListener(new zwv(this));
      this.jdField_b_of_type_Blir.a(new zwc(this));
    }
    if (!this.jdField_b_of_type_Blir.isShowing())
    {
      this.jdField_h_of_type_Boolean = false;
      this.jdField_b_of_type_Blir.show();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1;
    if (this.jdField_c_of_type_Int == 2) {
      localObject1 = "";
    }
    Object localObject2;
    label58:
    boolean bool;
    switch (paramInt1)
    {
    default: 
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (paramInt2 == -1)
        {
          localObject2 = "0";
          bhju.a("Grp_share", "grpData_admin", (String)localObject1, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), localObject2 });
        }
      }
      else
      {
        if (paramInt2 != -1) {
          break label226;
        }
        bool = true;
        label105:
        a(bool);
        if (paramInt2 == -1)
        {
          if (paramInt1 != 1) {
            break label232;
          }
          a(0, getString(2131715926));
          if (QLog.isColorLevel()) {
            QLog.i("QRDisplayActivity", 2, "shareQRCode success");
          }
          if ((this.jdField_g_of_type_Int & 0x1) != 0) {
            bdll.b(this.app, "P_CliOper", "flag1", "", "0X800416F", "0X800416F", 0, 0, "", "", "", "");
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
      break label58;
      label226:
      bool = false;
      break label105;
      label232:
      if (paramInt1 == 2)
      {
        localObject1 = new Intent(this, SplashActivity.class);
        ((Intent)localObject1).putExtras(paramIntent);
        localObject2 = ForwardUtils.a((Intent)localObject1);
        ForwardUtils.a(this.app, this, (SessionInfo)localObject2, (Intent)localObject1);
      }
      else if (paramInt1 == 21)
      {
        localObject1 = agej.a(new Intent(this, SplashActivity.class), null);
        ((Intent)localObject1).putExtras(new Bundle(paramIntent.getExtras()));
        startActivity((Intent)localObject1);
        finish();
      }
      else if (paramInt1 != 3) {}
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if ((1 == super.getIntent().getIntExtra("type", 1)) || (2 == super.getIntent().getIntExtra("type", 2))) {
      this.mActNeedImmersive = false;
    }
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    super.setContentView(2131560399);
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131374786));
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131374814);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131374804);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131374821);
    if (this.jdField_c_of_type_Int == 1) {
      n();
    }
    Object localObject1;
    int i1;
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131374802);
      this.jdField_e_of_type_AndroidViewView = findViewById(2131373739);
      this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131695808));
      if (QLog.isDevelopLevel()) {
        QLog.d("QRDisplayActivity", 4, "display qrcode, type: " + this.jdField_c_of_type_Int);
      }
      if (this.jdField_c_of_type_Int != 5) {
        break label1200;
      }
      getIntent().getStringExtra("discussion_shorturl");
      addObserver(this.jdField_a_of_type_Anwt);
      if (this.app != null)
      {
        this.jdField_a_of_type_Anwo = ((anwo)this.app.a(6));
        this.app.registObserver(this.jdField_a_of_type_Zwx);
      }
      this.leftView.setContentDescription(getString(2131695441));
      this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131695442));
      setResult(-1, getIntent());
      paramBundle = (anyw)this.app.getManager(51);
      localObject2 = (anws)this.app.getManager(53);
      localObject1 = ((anws)localObject2).a(this.jdField_c_of_type_JavaLangString);
      if (localObject1 != null) {
        break;
      }
      i();
      i1 = 1;
      this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager = new CodeMaskManager(this, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_d_of_type_JavaLangRunnable, 60000L);
      if (i1 != 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_JavaLangString + "," + this.jdField_b_of_type_JavaLangString);
        this.jdField_c_of_type_AndroidViewView.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      if ((this.jdField_g_of_type_Int & 0x1) != 0) {
        bdll.b(this.app, "P_CliOper", "flag1", "", "0X800416D", "0X800416D", 0, 0, "", "", "", "");
      }
      this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
      this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004, 1, 0).sendToTarget();
      return true;
      if (this.jdField_c_of_type_Int == 2)
      {
        c();
        this.jdField_c_of_type_AndroidViewView.post(this.jdField_c_of_type_JavaLangRunnable);
      }
      else if (this.jdField_c_of_type_Int == 5)
      {
        findViewById(2131373738).setVisibility(0);
        findViewById(2131367738).setVisibility(0);
        findViewById(2131374793).setOnClickListener(this);
        findViewById(2131374794).setOnClickListener(this);
        this.jdField_b_of_type_JavaLangString = getString(2131715935);
      }
      else if (this.jdField_c_of_type_Int == 11)
      {
        findViewById(2131373738).setVisibility(0);
        findViewById(2131367738).setVisibility(0);
        findViewById(2131374793).setOnClickListener(this);
        findViewById(2131374794).setOnClickListener(this);
        this.jdField_b_of_type_JavaLangString = getString(2131715963);
      }
    }
    Object localObject2 = ((anws)localObject2).a(this.jdField_c_of_type_JavaLangString);
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
          break label1029;
        }
        localObject2 = (DiscussionMemberInfo)((Iterator)localObject1).next();
        if (this.app.getAccount().equals(((DiscussionMemberInfo)localObject2).memberUin))
        {
          this.jdField_b_of_type_JavaUtilList.add(bhlg.h(this.app, ((DiscussionMemberInfo)localObject2).memberUin));
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
      label1029:
      if ((this.jdField_b_of_type_JavaUtilList.size() >= 5) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label1299;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QRDisplayActivity", 4, "fetch nicks from server");
      }
      paramBundle = new String[this.jdField_a_of_type_JavaUtilList.size()];
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      i1 = 0;
      while (((Iterator)localObject1).hasNext())
      {
        paramBundle[i1] = ((String)((Iterator)localObject1).next());
        i1 += 1;
      }
      ((anwo)this.app.a(6)).a(new String[] { "20002" }, paramBundle);
    }
    label1299:
    for (int i2 = 0;; i2 = 1)
    {
      i1 = i2;
      if (this.jdField_b_of_type_JavaUtilList.size() <= 0) {
        break;
      }
      Collections.sort(this.jdField_b_of_type_JavaUtilList, new zww(this));
      this.jdField_a_of_type_JavaLangString = a(this.jdField_b_of_type_JavaUtilList);
      i1 = i2;
      break;
      label1200:
      if (this.jdField_c_of_type_Int == 2)
      {
        this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131715937, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
        addObserver(this.jdField_a_of_type_Bkia);
        i1 = 1;
        break;
      }
      if (this.jdField_c_of_type_Int == 11) {
        this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131715937, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
      }
      i1 = 1;
      break;
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager.a();
    if (this.jdField_c_of_type_Int == 5)
    {
      removeObserver(this.jdField_a_of_type_Anwt);
      this.app.unRegistObserver(this.jdField_a_of_type_Zwx);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bjig != null)
      {
        WXShareHelper.a().b(this.jdField_a_of_type_Bjig);
        this.jdField_a_of_type_Bjig = null;
      }
      if (this.jdField_a_of_type_Asdl != null) {
        this.jdField_a_of_type_Asdl.b(this);
      }
      super.doOnDestroy();
      return;
      if (this.jdField_c_of_type_Int == 2) {
        removeObserver(this.jdField_a_of_type_Bkia);
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
    w();
    ApngImage.pauseByTag(35);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004, 2, 0).sendToTarget();
    b(true);
    ApngImage.playByTag(35);
  }
  
  public void e()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
      {
        requestPermissions(new zwd(this), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      f();
      return;
    }
    f();
  }
  
  public void f()
  {
    ThreadManager.executeOnFileThread(new QRDisplayActivity.12(this));
    String str = null;
    if (this.jdField_c_of_type_Int == 1) {
      str = "saveConsumerQRcard";
    }
    for (;;)
    {
      bdmc.a(BaseApplication.getContext()).b(this.app, "", str, 1);
      return;
      if (this.jdField_c_of_type_Int == 2) {
        str = "saveGroupQRcard";
      }
    }
  }
  
  public void finish()
  {
    ForwardRecentActivity.a(getIntent(), this);
    super.finish();
  }
  
  public void g()
  {
    ThreadManager.executeOnFileThread(new QRDisplayActivity.13(this));
    String str = null;
    if (this.jdField_c_of_type_Int == 1) {
      str = "shareConsumerQRcard";
    }
    for (;;)
    {
      bdmc.a(BaseApplication.getContext()).b(this.app, "", str, 1);
      return;
      if (this.jdField_c_of_type_Int == 2) {
        str = "shareGroupQRcard";
      }
    }
  }
  
  public void h()
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
    boolean bool3 = this.jdField_d_of_type_Boolean;
    boolean bool1;
    int i1;
    if ((this.jdField_a_of_type_Long & 0x800) != 0L)
    {
      bool1 = true;
      i1 = this.jdField_b_of_type_Int;
      if ((this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Int != 2)) {
        break label123;
      }
    }
    label123:
    for (boolean bool2 = true;; bool2 = false)
    {
      ((CodeMaskManager)localObject).a(this, bool3, bool1, i1, bool2);
      if (!this.jdField_d_of_type_Boolean) {
        break label128;
      }
      this.jdField_d_of_type_Boolean = false;
      return;
      bool1 = false;
      break;
    }
    label128:
    if (this.jdField_c_of_type_Int == 1) {}
    for (localObject = "changeConsumerQRcard";; localObject = "changeGroupQRcard")
    {
      bdmc.a(BaseApplication.getContext()).b(this.app, "", (String)localObject, 1);
      return;
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
        this.app.F();
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
            if (this.jdField_a_of_type_Asdl == null) {
              this.jdField_a_of_type_Asdl = ((asdl)((asde)this.app.getManager(77)).a("qq.android.system.chirp"));
            }
            this.jdField_a_of_type_Asdl.a(this);
            this.jdField_a_of_type_Asdl.a(true);
            bool1 = false;
          }
        }
      }
      break;
    }
    for (;;)
    {
      BaseApplicationImpl.sUiHandler.post(new QRDisplayActivity.24(this, bool1));
      break;
      boolean bool2 = true;
      bool1 = bool2;
      if (!this.jdField_k_of_type_Boolean)
      {
        BaseApplicationImpl.sUiHandler.post(new QRDisplayActivity.23(this));
        this.jdField_k_of_type_Boolean = true;
        bool1 = bool2;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "playQRCodeFailed = " + this.jdField_j_of_type_Boolean);
        }
        if (this.jdField_j_of_type_Boolean) {
          break;
        }
        String str = getFilesDir() + this.app.getCurrentAccountUin() + "_vqr.dat";
        File localFile = new File(str);
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "voiceFile.exists = " + localFile.exists());
        }
        if (!localFile.exists()) {
          if (a(str)) {
            break label530;
          }
        }
        label530:
        for (bool1 = true;; bool1 = false)
        {
          this.jdField_j_of_type_Boolean = bool1;
          if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "playQRCodeFailed = " + this.jdField_j_of_type_Boolean);
          }
          if (this.jdField_j_of_type_Boolean) {
            break label535;
          }
          if (this.jdField_a_of_type_ComTencentChirpPcmPlayer == null)
          {
            this.jdField_a_of_type_ComTencentChirpPcmPlayer = new PcmPlayer(this, this, 44100, str);
            this.jdField_a_of_type_ComTencentChirpPcmPlayer.a();
            bhkm.a(this, true);
          }
          if (paramMessage.arg1 != 5) {
            break;
          }
          bdll.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 0, 0, "", "", "", "");
          break;
        }
        label535:
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1003);
        break;
        if (this.jdField_a_of_type_ComTencentChirpPcmPlayer == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentChirpPcmPlayer.b();
        this.jdField_a_of_type_ComTencentChirpPcmPlayer = null;
        if (paramMessage.arg1 == 5) {
          bdll.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 1, 0, "", "", "", "");
        }
        if (paramMessage.arg1 == 3) {
          bdll.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 1, 0, "", "", "", "");
        }
        bhkm.a(this, false);
        break;
        if (this.jdField_a_of_type_ComTencentChirpPcmPlayer == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentChirpPcmPlayer.a();
        break;
        QQAppInterface.f(jdField_j_of_type_JavaLangString);
        break;
        bool1 = false;
      }
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    if (super.isResume())
    {
      bhpc localbhpc = bhlq.a(this, 230);
      localbhpc.setMessage(2131717578);
      localbhpc.setPositiveButton(2131694098, new zwf(this));
      localbhpc.show();
      return;
    }
    finish();
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      zwh localzwh = new zwh(this);
      zwi localzwi = new zwi(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(getString(2131718159));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setOnDismissListener(localzwi);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setCancelListener(new zwj(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(localzwh);
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.isShowing()))
      {
        this.jdField_h_of_type_Boolean = false;
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
  
  public void k()
  {
    if (this.jdField_c_of_type_Int == 1) {
      bdll.b(this.app, "CliOper", "", "", "0X800AEAF", "0X800AEAF", 0, 0, "", "", "", "");
    }
    bdll.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "scan_QR_code", "code_click", 0, 0, "", "", "", "");
    if ("ScannerActivity".equals(this.jdField_f_of_type_JavaLangString))
    {
      if (isInMultiWindow()) {
        QQToast.a(this, anzj.a(2131710073), 0).a();
      }
      setResult(-1);
      finish();
      return;
    }
    if (isInMultiWindow())
    {
      QQToast.a(this, anzj.a(2131710075), 0).a();
      return;
    }
    Intent localIntent = new Intent(this, ScannerActivity.class);
    localIntent.putExtra("from", "QRDisplayActivity");
    startActivityForResult(localIntent, 3);
  }
  
  public void l() {}
  
  public void m()
  {
    if (isResume()) {
      this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004, 4, 0).sendToTarget();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    if (Math.abs(l1 - this.jdField_c_of_type_Long) <= 1000L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_c_of_type_Long = l1;
      if (paramView.getId() == 2131374804)
      {
        if (this.jdField_a_of_type_Boolean) {
          continue;
        }
        if (this.jdField_c_of_type_Int == 2)
        {
          h();
          if ((this.jdField_g_of_type_Int & 0x1) == 0) {
            continue;
          }
          bdll.b(this.app, "P_CliOper", "flag1", "", "0X8004170", "0X8004170", 0, 0, "", "", "", "");
          continue;
        }
        if ((this.jdField_c_of_type_Int == 5) || (this.jdField_c_of_type_Int == 11))
        {
          h();
          bdll.b(this.app, "CliOper", "", "", "0X8006671", "0X8006671", 0, 0, "", "", "", "");
          continue;
        }
        d();
        continue;
      }
      if (paramView.getId() == 2131374788) {
        if (this.jdField_a_of_type_Blir == null) {
          this.jdField_a_of_type_Blir = new ajxw(this).a(this);
        }
      }
      try
      {
        this.jdField_a_of_type_Blir.show();
        label217:
        bdll.b(this.app, "CliOper", "", "", "0X80040F6", "0X80040F6", 0, 0, "", "", "", "");
        continue;
        if (paramView.getId() == 2131374793)
        {
          if (this.jdField_a_of_type_Boolean) {
            continue;
          }
          e();
          if ((this.jdField_g_of_type_Int & 0x1) != 0) {
            bdll.b(this.app, "P_CliOper", "flag1", "", "0X8004171", "0X8004171", 0, 0, "", "", "", "");
          }
          if (this.jdField_c_of_type_Int == 5) {
            bdll.b(this.app, "CliOper", "", "", "0X8006672", "0X8006672", 0, 0, "", "", "", "");
          }
          if (this.jdField_c_of_type_Int != 2) {
            continue;
          }
          new bdlq(this.app).a("P_CliOper").b("Grp_set").c("Grp_data").d("qr_save").a(new String[] { this.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_Int) }).a();
          continue;
        }
        if (paramView.getId() == 2131374794)
        {
          j();
          if (this.jdField_c_of_type_Int != 5) {
            continue;
          }
          bdll.b(this.app, "CliOper", "", "", "0X8006673", "0X8006673", 0, 0, "", "", "", "");
          continue;
        }
        if ((paramView.getId() == 2131374810) || (paramView.getId() == 2131374812))
        {
          k();
          continue;
        }
        if (paramView.getId() == 2131374796)
        {
          bdll.b(this.app, "CliOper", "", "", "0X800AEAD", "0X800AEAD", 0, 0, "", "", "", "");
          s();
          continue;
        }
        if (paramView.getId() == 2131374799)
        {
          t();
          continue;
        }
        if (paramView.getId() == 2131374819)
        {
          e();
          continue;
        }
        if (paramView.getId() == 2131374811)
        {
          k();
          continue;
        }
        if (paramView.getId() == 2131369056)
        {
          bdll.b(this.app, "CliOper", "", "", "0X800AEB5", "0X800AEB5", 0, 0, "", "", "", "");
          r();
          continue;
        }
        if (paramView.getId() == 2131374762)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "onClick qr_code_white_bg isLoading =" + this.jdField_a_of_type_Boolean);
          }
          if (this.jdField_a_of_type_Boolean) {
            continue;
          }
          bdll.b(this.app, "CliOper", "", "", "0X800AEB4", "0X800AEB4", 0, 0, "", "", "", "");
          a(zyx.a(this.app, this.jdField_a_of_type_Aric, this.jdField_h_of_type_Int), true);
          continue;
        }
        if (paramView.getId() != 2131374761) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "onClick qr_code_troop_white_bg isLoading =" + this.jdField_a_of_type_Boolean);
        }
        if (this.jdField_a_of_type_Boolean) {
          continue;
        }
        b(zyx.a(this.app, this.jdField_a_of_type_Aric, this.jdField_h_of_type_Int), true);
      }
      catch (Exception localException)
      {
        break label217;
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Blir.dismiss();
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      int i1 = -1;
      if (!WXShareHelper.a().a()) {
        i1 = 2131719399;
      }
      for (;;)
      {
        if (i1 == -1) {
          break label104;
        }
        zyx.a(1, i1);
        break;
        if (!WXShareHelper.a().b()) {
          i1 = 2131719400;
        }
      }
      label104:
      if (this.jdField_a_of_type_Bjig == null)
      {
        this.jdField_a_of_type_Bjig = new zwg(this);
        WXShareHelper.a().a(this.jdField_a_of_type_Bjig);
      }
      Object localObject = this.app;
      String str1;
      label149:
      String str2;
      Bitmap localBitmap;
      String str3;
      if (paramInt == 2)
      {
        str1 = "1";
        bdll.b((QQAppInterface)localObject, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, str1, "", "", "");
        this.jdField_g_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
        str1 = String.format(getString(2131691602), new Object[] { this.jdField_a_of_type_JavaLangString });
        if (this.jdField_c_of_type_Int == 11) {
          str1 = getString(2131692849);
        }
        localObject = WXShareHelper.a();
        str2 = this.jdField_g_of_type_JavaLangString;
        localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
        str3 = this.jdField_d_of_type_JavaLangString;
        if (paramInt != 2) {
          break label293;
        }
      }
      label293:
      for (i1 = 0;; i1 = 1)
      {
        ((WXShareHelper)localObject).b(str2, str1, localBitmap, "", str3, i1);
        break;
        str1 = "0";
        break label149;
      }
      if (this.jdField_a_of_type_Bjbs == null)
      {
        this.jdField_a_of_type_Bjbs = new bjbs(this, getTitleBarHeight());
        this.jdField_a_of_type_Bjbs.c(2131694176);
        this.jdField_a_of_type_Bjbs.c(false);
      }
      DiscussionInfoCardActivity.a(this.app, this, 2, this.jdField_e_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_f_of_type_Int, this.jdField_a_of_type_Bjbs);
      continue;
      DiscussionInfoCardActivity.a(this.app, this, this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      continue;
      DiscussionInfoCardActivity.a(this.app, this.jdField_b_of_type_Long, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity
 * JD-Core Version:    0.7.0.1
 */