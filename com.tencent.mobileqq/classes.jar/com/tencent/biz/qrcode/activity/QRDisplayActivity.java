package com.tencent.biz.qrcode.activity;

import Override;
import aben;
import afur;
import ajmn;
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
import anks;
import ankw;
import ankx;
import anmw;
import anni;
import aqsq;
import aqss;
import aqst;
import arno;
import arnx;
import arny;
import azml;
import bcst;
import bcsy;
import bctj;
import bgjt;
import bgkl;
import bglf;
import bglp;
import bgmo;
import bgnt;
import bgpa;
import biau;
import bihh;
import bjha;
import bkho;
import bkif;
import com.tencent.biz.qrcode.CodeMaskManager;
import com.tencent.chirp.ChirpWrapper;
import com.tencent.chirp.PcmPlayer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
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
import lyu;
import mqq.os.MqqHandler;
import zro;
import zrq;
import zsg;
import zsh;
import zsi;
import zsj;
import zsk;
import zsl;
import zsm;
import zsn;
import zso;
import zsp;
import zsr;
import zss;
import zst;
import zsu;
import zsv;
import zsw;
import zsx;
import zsy;
import zsz;
import zta;
import ztb;
import ztc;
import ztd;
import zvc;

public class QRDisplayActivity
  extends IphoneTitleBarActivity
  implements aben, Handler.Callback, View.OnClickListener, AdapterView.OnItemClickListener, CompoundButton.OnCheckedChangeListener, arny, zro, zrq
{
  public static final String j;
  public int a;
  protected long a;
  public Bitmap a;
  protected Drawable a;
  public Bundle a;
  private CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer = new zsr(this, 1000L, 200L);
  protected Handler a;
  protected View a;
  public ImageView a;
  public TextView a;
  public anks a;
  ankx jdField_a_of_type_Ankx = new zsw(this);
  protected aqsq a;
  private arnx jdField_a_of_type_Arnx;
  biau jdField_a_of_type_Biau;
  bihh jdField_a_of_type_Bihh;
  bjha jdField_a_of_type_Bjha = new zsy(this);
  bkho jdField_a_of_type_Bkho;
  protected CodeMaskManager a;
  private PcmPlayer jdField_a_of_type_ComTencentChirpPcmPlayer;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private ShareActionSheetBuilder jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
  public gt a;
  public Runnable a;
  public String a;
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  ztc jdField_a_of_type_Ztc = new zsg(this);
  private ztd jdField_a_of_type_Ztd;
  public boolean a;
  protected int b;
  public long b;
  protected Bitmap b;
  private Handler b;
  public View b;
  public ImageView b;
  public TextView b;
  public bkho b;
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
    jdField_j_of_type_JavaLangString = anni.a(2131709969);
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
    this.jdField_c_of_type_JavaLangRunnable = new QRDisplayActivity.7(this);
    this.jdField_i_of_type_Int = -1;
  }
  
  private void a(Bundle paramBundle, ArrayList<Rect> paramArrayList, Bitmap paramBitmap)
  {
    Bitmap localBitmap1;
    if (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
      localBitmap1 = BitmapFactory.decodeResource(getResources(), 2130846935);
    }
    for (;;)
    {
      paramBundle = zvc.a(this, localBitmap1, this.jdField_a_of_type_AndroidGraphicsBitmap, paramBitmap, paramArrayList, paramBundle.getInt("nameClr"), this.jdField_a_of_type_JavaLangString, String.format(getString(2131698193), new Object[] { this.jdField_c_of_type_JavaLangString }), paramBundle.getInt("tipsClr"), this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_Boolean, this.jdField_h_of_type_JavaLangString, true);
      if (this.jdField_b_of_type_AndroidGraphicsBitmap == null)
      {
        this.jdField_g_of_type_AndroidWidgetImageView.setImageBitmap(paramBundle[0]);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(String.format(getString(2131698193), new Object[] { this.jdField_c_of_type_JavaLangString }));
        this.jdField_f_of_type_AndroidWidgetTextView.setText(getString(2131698202));
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
        localBitmap1 = bgmo.b(URLDrawable.getDrawable(this.jdField_i_of_type_JavaLangString).getCurrDrawable().mutate());
      }
      catch (Exception localException)
      {
        Bitmap localBitmap2 = BitmapFactory.decodeResource(getResources(), 2130846935);
      }
    }
  }
  
  private void a(aqss paramaqss, int paramInt, boolean paramBoolean)
  {
    if ("default_bg".equals(paramaqss.jdField_a_of_type_JavaLangString))
    {
      b(paramaqss, paramInt, paramBoolean);
      this.jdField_i_of_type_AndroidViewView.setBackgroundResource(2130846935);
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
          break label236;
        }
        localDrawable = getResources().getDrawable(2130846935);
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramaqss.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "setURLDrawable: urlDrawable = " + this.jdField_a_of_type_ComTencentImageURLDrawable + " status = " + this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus());
        }
        if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) {
          break label248;
        }
        b(paramaqss, paramInt, paramBoolean);
        this.jdField_i_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable());
        return;
      }
      catch (IllegalArgumentException paramaqss)
      {
        QLog.d("QRDisplayActivity", 1, "bkgURL is illegal please check manage info e =" + paramaqss);
        QQToast.a(this, getString(2131695759), 0).a();
        w();
      }
      if (i1 == 0) {
        break;
      }
      this.jdField_i_of_type_AndroidViewView.setBackgroundResource(2130846935);
      return;
      i1 = 0;
      continue;
      label236:
      Drawable localDrawable = this.jdField_i_of_type_AndroidViewView.getBackground();
    }
    label248:
    if (i1 != 0) {
      this.jdField_i_of_type_AndroidViewView.setBackgroundResource(2130846935);
    }
    a(paramaqss, paramInt, paramBoolean, this.jdField_a_of_type_ComTencentImageURLDrawable);
    v();
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
    this.jdField_a_of_type_ComTencentImageURLDrawable.setAutoDownload(true);
  }
  
  private void a(aqss paramaqss, int paramInt, boolean paramBoolean, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "setDrawableListener(): ud = " + paramURLDrawable + " bkgURL = " + paramaqss.jdField_a_of_type_JavaLangString);
    }
    paramURLDrawable.setURLDrawableListener(new zsv(this, paramaqss, paramInt, paramBoolean));
  }
  
  private void a(aqss paramaqss, boolean paramBoolean)
  {
    if (paramaqss == null) {
      QLog.i("QRDisplayActivity", 2, "switchMyQrTheme() qrCodeList is null just return");
    }
    do
    {
      return;
      this.jdField_h_of_type_Int = this.jdField_a_of_type_Aqsq.jdField_a_of_type_JavaUtilList.indexOf(paramaqss);
      if (QLog.isColorLevel()) {
        QLog.i("QRDisplayActivity", 2, "switchMyQrTheme().qrCodeList:" + paramaqss.toString());
      }
    } while (TextUtils.isEmpty(paramaqss.jdField_a_of_type_JavaLangString));
    this.jdField_h_of_type_JavaLangString = paramaqss.jdField_b_of_type_JavaLangString;
    this.jdField_e_of_type_Boolean = paramaqss.c();
    this.jdField_i_of_type_JavaLangString = paramaqss.jdField_a_of_type_JavaLangString;
    a(paramaqss, this.jdField_h_of_type_Int, paramBoolean);
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
    //   0: new 430	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 433	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 436	java/io/File:exists	()Z
    //   13: ifne +186 -> 199
    //   16: new 438	com/tencent/chirp/ChirpWrapper
    //   19: dup
    //   20: invokespecial 439	com/tencent/chirp/ChirpWrapper:<init>	()V
    //   23: astore 5
    //   25: aload 5
    //   27: invokevirtual 441	com/tencent/chirp/ChirpWrapper:a	()I
    //   30: ifne +295 -> 325
    //   33: aload_0
    //   34: getfield 445	com/tencent/biz/qrcode/activity/QRDisplayActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   40: astore_3
    //   41: new 196	java/lang/String
    //   44: dup
    //   45: ldc_w 452
    //   48: invokespecial 453	java/lang/String:<init>	(Ljava/lang/String;)V
    //   51: astore 4
    //   53: new 254	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   60: ldc_w 455
    //   63: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload 4
    //   68: iconst_0
    //   69: bipush 14
    //   71: aload_3
    //   72: invokevirtual 458	java/lang/String:length	()I
    //   75: isub
    //   76: invokevirtual 462	java/lang/String:substring	(II)Ljava/lang/String;
    //   79: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_3
    //   83: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore_3
    //   90: invokestatic 250	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq +29 -> 122
    //   96: ldc 252
    //   98: iconst_2
    //   99: new 254	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   106: ldc_w 464
    //   109: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_3
    //   113: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 271	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: aload 5
    //   124: aload_3
    //   125: invokevirtual 467	com/tencent/chirp/ChirpWrapper:a	(Ljava/lang/String;)Landroid/util/Pair;
    //   128: astore_3
    //   129: aload_3
    //   130: getfield 473	android/util/Pair:first	Ljava/lang/Object;
    //   133: checkcast 475	java/lang/Integer
    //   136: invokevirtual 478	java/lang/Integer:intValue	()I
    //   139: istore_2
    //   140: aload_3
    //   141: getfield 481	android/util/Pair:second	Ljava/lang/Object;
    //   144: checkcast 483	[S
    //   147: astore 4
    //   149: iload_2
    //   150: ifne +136 -> 286
    //   153: aload 4
    //   155: ifnull +131 -> 286
    //   158: new 485	java/io/FileOutputStream
    //   161: dup
    //   162: aload_1
    //   163: invokespecial 488	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   166: astore_3
    //   167: aload 4
    //   169: arraylength
    //   170: iconst_2
    //   171: imul
    //   172: newarray byte
    //   174: astore_1
    //   175: aload 4
    //   177: aload_1
    //   178: invokestatic 490	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	([S[B)V
    //   181: aload_3
    //   182: aload_1
    //   183: invokevirtual 494	java/io/FileOutputStream:write	([B)V
    //   186: aload_3
    //   187: ifnull +7 -> 194
    //   190: aload_3
    //   191: invokevirtual 497	java/io/FileOutputStream:close	()V
    //   194: aload 5
    //   196: invokevirtual 499	com/tencent/chirp/ChirpWrapper:a	()V
    //   199: iconst_1
    //   200: ireturn
    //   201: astore_1
    //   202: aload_1
    //   203: athrow
    //   204: astore_1
    //   205: aload 5
    //   207: invokevirtual 499	com/tencent/chirp/ChirpWrapper:a	()V
    //   210: aload_1
    //   211: athrow
    //   212: astore_3
    //   213: aconst_null
    //   214: astore_1
    //   215: invokestatic 250	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq +13 -> 231
    //   221: ldc 252
    //   223: iconst_2
    //   224: ldc_w 501
    //   227: aload_3
    //   228: invokestatic 504	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   231: aload_1
    //   232: astore_3
    //   233: aload_1
    //   234: ifnull +9 -> 243
    //   237: aload_1
    //   238: invokevirtual 497	java/io/FileOutputStream:close	()V
    //   241: aconst_null
    //   242: astore_3
    //   243: aload_3
    //   244: ifnull +7 -> 251
    //   247: aload_3
    //   248: invokevirtual 497	java/io/FileOutputStream:close	()V
    //   251: aload 5
    //   253: invokevirtual 499	com/tencent/chirp/ChirpWrapper:a	()V
    //   256: iconst_0
    //   257: ireturn
    //   258: astore_1
    //   259: aconst_null
    //   260: astore_3
    //   261: goto -18 -> 243
    //   264: astore_1
    //   265: aload_1
    //   266: athrow
    //   267: astore_1
    //   268: aconst_null
    //   269: astore_3
    //   270: aload_3
    //   271: ifnull +7 -> 278
    //   274: aload_3
    //   275: invokevirtual 497	java/io/FileOutputStream:close	()V
    //   278: aload_1
    //   279: athrow
    //   280: astore_1
    //   281: aload_1
    //   282: athrow
    //   283: astore_1
    //   284: aload_1
    //   285: athrow
    //   286: invokestatic 250	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +29 -> 318
    //   292: ldc 252
    //   294: iconst_4
    //   295: new 254	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   302: ldc_w 506
    //   305: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: iload_2
    //   309: invokevirtual 348	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   312: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 271	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: aload 5
    //   320: invokevirtual 499	com/tencent/chirp/ChirpWrapper:a	()V
    //   323: iconst_0
    //   324: ireturn
    //   325: aload 5
    //   327: invokevirtual 499	com/tencent/chirp/ChirpWrapper:a	()V
    //   330: iconst_0
    //   331: ireturn
    //   332: astore_1
    //   333: goto -139 -> 194
    //   336: astore_1
    //   337: goto -86 -> 251
    //   340: astore_3
    //   341: goto -63 -> 278
    //   344: astore_1
    //   345: goto -75 -> 270
    //   348: astore 4
    //   350: aload_1
    //   351: astore_3
    //   352: aload 4
    //   354: astore_1
    //   355: goto -85 -> 270
    //   358: astore 4
    //   360: aload_3
    //   361: astore_1
    //   362: aload 4
    //   364: astore_3
    //   365: goto -150 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	QRDisplayActivity
    //   0	368	1	paramString	String
    //   139	170	2	i1	int
    //   40	151	3	localObject1	Object
    //   212	16	3	localException1	Exception
    //   232	43	3	str	String
    //   340	1	3	localIOException	java.io.IOException
    //   351	14	3	localObject2	Object
    //   51	125	4	localObject3	Object
    //   348	5	4	localObject4	Object
    //   358	5	4	localException2	Exception
    //   23	303	5	localChirpWrapper	ChirpWrapper
    // Exception table:
    //   from	to	target	type
    //   190	194	201	finally
    //   33	122	204	finally
    //   122	149	204	finally
    //   202	204	204	finally
    //   278	280	204	finally
    //   281	283	204	finally
    //   284	286	204	finally
    //   286	318	204	finally
    //   158	167	212	java/lang/Exception
    //   237	241	258	java/io/IOException
    //   237	241	264	finally
    //   158	167	267	finally
    //   265	267	267	finally
    //   247	251	280	finally
    //   274	278	283	finally
    //   190	194	332	java/io/IOException
    //   247	251	336	java/io/IOException
    //   274	278	340	java/io/IOException
    //   167	186	344	finally
    //   215	231	348	finally
    //   167	186	358	java/lang/Exception
  }
  
  public static List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131695695);
    localActionSheetItem.icon = 2130839083;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 0;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131695708);
    localActionSheetItem.icon = 2130839084;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131695715);
    localActionSheetItem.icon = 2130839087;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131695698);
    localActionSheetItem.icon = 2130839081;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private void b(int paramInt, String paramString)
  {
    try
    {
      ThreadManager.post(new QRDisplayActivity.28(this, "temp_qrcode_share_" + paramString + ".png", paramInt, paramString), 8, null, true);
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      zvc.a(1, 2131695774);
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
      localBitmap1 = BitmapFactory.decodeResource(getResources(), 2130846935);
      localBitmap3 = this.jdField_a_of_type_AndroidGraphicsBitmap;
      i1 = paramBundle.getInt("nameClr");
      str1 = this.jdField_a_of_type_JavaLangString;
      str2 = String.format(getString(2131698417), new Object[] { this.jdField_c_of_type_JavaLangString });
      i2 = paramBundle.getInt("tipsClr");
      paramBundle = this.jdField_b_of_type_JavaLangString;
      bool2 = this.jdField_e_of_type_Boolean;
      str3 = this.jdField_h_of_type_JavaLangString;
      if (this.jdField_f_of_type_Boolean) {
        break label255;
      }
    }
    label255:
    for (boolean bool1 = true;; bool1 = false)
    {
      for (;;)
      {
        paramBundle = zvc.a(this, localBitmap1, localBitmap3, paramBitmap, paramArrayList, i1, str1, str2, i2, paramBundle, bool2, str3, bool1);
        if (this.jdField_b_of_type_AndroidGraphicsBitmap == null)
        {
          this.jdField_i_of_type_AndroidWidgetImageView.setImageBitmap(paramBundle[0]);
          this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
          this.jdField_i_of_type_AndroidWidgetTextView.setText(String.format(getString(2131698417), new Object[] { this.jdField_c_of_type_JavaLangString }));
          this.jdField_j_of_type_AndroidWidgetTextView.setText(getString(2131698202));
          this.jdField_h_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        }
        this.jdField_b_of_type_AndroidGraphicsBitmap = paramBundle[1];
        localBitmap1.recycle();
        return;
        try
        {
          localBitmap1 = bgmo.b(URLDrawable.getDrawable(this.jdField_i_of_type_JavaLangString).getCurrDrawable().mutate());
        }
        catch (Exception localException)
        {
          Bitmap localBitmap2 = BitmapFactory.decodeResource(getResources(), 2130846935);
        }
      }
      break;
    }
  }
  
  private void b(aqss paramaqss, int paramInt, boolean paramBoolean)
  {
    int i1 = -1;
    if (paramBoolean) {
      h();
    }
    w();
    zvc.a(this.app, paramInt);
    Object localObject;
    if (!paramaqss.a())
    {
      paramBoolean = true;
      ImmersiveUtils.a(paramBoolean, getWindow());
      localObject = getResources().getDrawable(2130843652);
      if (!paramaqss.b()) {
        break label168;
      }
      paramInt = -1;
      label63:
      ((Drawable)localObject).setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
      this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
      localObject = getResources().getDrawable(2130850652);
      if (!paramaqss.b()) {
        break label175;
      }
      paramInt = -1;
      label102:
      ((Drawable)localObject).setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
      this.leftView.setBackgroundDrawable((Drawable)localObject);
      localObject = this.centerView;
      if (!paramaqss.b()) {
        break label182;
      }
    }
    label168:
    label175:
    label182:
    for (paramInt = i1;; paramInt = -16777216)
    {
      ((TextView)localObject).setTextColor(paramInt);
      this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130844899);
      this.jdField_g_of_type_AndroidViewView.setBackgroundResource(2130844899);
      return;
      paramBoolean = false;
      break;
      paramInt = -16777216;
      break label63;
      paramInt = -16777216;
      break label102;
    }
  }
  
  private void b(aqss paramaqss, int paramInt, boolean paramBoolean, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "setTroopDrawableListener(): ud = " + paramURLDrawable + " bkgURL = " + paramaqss.jdField_a_of_type_JavaLangString);
    }
    paramURLDrawable.setURLDrawableListener(new zsx(this, paramaqss, paramInt, paramBoolean));
  }
  
  private void b(aqss paramaqss, boolean paramBoolean)
  {
    if (paramaqss == null) {
      QLog.i("QRDisplayActivity", 2, "switchMyQrTheme() qrCodeList is null just return");
    }
    do
    {
      return;
      this.jdField_h_of_type_Int = this.jdField_a_of_type_Aqsq.jdField_a_of_type_JavaUtilList.indexOf(paramaqss);
      if (QLog.isColorLevel()) {
        QLog.i("QRDisplayActivity", 2, "switchMyQrTheme().qrCodeList:" + paramaqss.toString());
      }
    } while (TextUtils.isEmpty(paramaqss.jdField_a_of_type_JavaLangString));
    this.jdField_h_of_type_JavaLangString = paramaqss.jdField_b_of_type_JavaLangString;
    this.jdField_e_of_type_Boolean = paramaqss.c();
    this.jdField_i_of_type_JavaLangString = paramaqss.jdField_a_of_type_JavaLangString;
    c(paramaqss, this.jdField_h_of_type_Int, paramBoolean);
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "sendIsResumeBroadcast isNeedSend = " + this.jdField_g_of_type_Boolean + " ,isResume = " + paramBoolean);
    }
    if (this.jdField_g_of_type_Boolean) {
      lyu.a(BaseApplicationImpl.getContext(), paramBoolean);
    }
  }
  
  private void c(aqss paramaqss, int paramInt, boolean paramBoolean)
  {
    if (paramaqss == null)
    {
      QLog.i("QRDisplayActivity", 2, "setTroopURLDrawable() qrCodeList is null just return");
      return;
    }
    if ("default_bg".equals(paramaqss.jdField_a_of_type_JavaLangString))
    {
      d(paramaqss, paramInt, paramBoolean);
      this.l.setBackgroundResource(2130846935);
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
          break label271;
        }
        localObject = getResources().getDrawable(2130846935);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramaqss.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
        if (QLog.isColorLevel())
        {
          if ("setTroopURLDrawable: urlDrawable = " + this.jdField_a_of_type_ComTencentImageURLDrawable + " status = " + this.jdField_a_of_type_ComTencentImageURLDrawable == null) {
            break label328;
          }
          localObject = Integer.valueOf(this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus());
          QLog.d("QRDisplayActivity", 2, new Object[] { localObject });
        }
        if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) {
          break label283;
        }
        d(paramaqss, paramInt, paramBoolean);
        this.l.setBackgroundDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable());
        return;
      }
      catch (IllegalArgumentException paramaqss)
      {
        QLog.d("QRDisplayActivity", 1, "setTroopURLDrawable bkgURL is illegal please check manage info e =" + paramaqss);
        QQToast.a(this, getString(2131695759), 0).a();
        w();
      }
      if (i1 == 0) {
        break;
      }
      this.l.setBackgroundResource(2130846935);
      return;
      i1 = 0;
      continue;
      label271:
      Object localObject = this.l.getBackground();
      continue;
      label283:
      if (i1 != 0) {
        this.l.setBackgroundResource(2130846935);
      }
      b(paramaqss, paramInt, paramBoolean, this.jdField_a_of_type_ComTencentImageURLDrawable);
      v();
      this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
      this.jdField_a_of_type_ComTencentImageURLDrawable.setAutoDownload(true);
      return;
      label328:
      localObject = " is null";
    }
  }
  
  private void d(aqss paramaqss, int paramInt, boolean paramBoolean)
  {
    int i1 = -1;
    if (paramBoolean) {
      h();
    }
    w();
    zvc.b(this.app, paramInt);
    Object localObject;
    if (!paramaqss.a())
    {
      paramBoolean = true;
      ImmersiveUtils.a(paramBoolean, getWindow());
      localObject = getResources().getDrawable(2130850652);
      if (!paramaqss.b()) {
        break label129;
      }
      paramInt = -1;
      label63:
      ((Drawable)localObject).setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
      this.leftView.setBackgroundDrawable((Drawable)localObject);
      localObject = this.centerView;
      if (!paramaqss.b()) {
        break label136;
      }
    }
    label129:
    label136:
    for (paramInt = i1;; paramInt = -16777216)
    {
      ((TextView)localObject).setTextColor(paramInt);
      this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130844899);
      this.jdField_h_of_type_AndroidViewView.setBackgroundResource(2130844899);
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
    findViewById(2131374648).setBackgroundDrawable(null);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_i_of_type_AndroidViewView = findViewById(16908290);
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368961));
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(getString(2131696799));
    this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.leftView.setContentDescription(getString(2131717865));
    this.jdField_j_of_type_AndroidViewView = findViewById(2131374669);
    this.jdField_j_of_type_AndroidViewView.setVisibility(0);
    this.jdField_k_of_type_AndroidViewView = this.jdField_j_of_type_AndroidViewView.findViewById(2131374625);
    this.jdField_k_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_k_of_type_AndroidViewView.setContentDescription(getString(2131698202));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_j_of_type_AndroidViewView.findViewById(2131369202));
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_j_of_type_AndroidViewView.findViewById(2131369243));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131379784));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131379988));
    localObject1 = anni.a(2131695761);
    Object localObject2 = this.jdField_c_of_type_JavaLangString;
    localObject1 = azml.a(this.jdField_e_of_type_AndroidWidgetTextView, (String)localObject1, (String)localObject2);
    if (localObject1 != null) {
      ((azml)localObject1).a(new zsp(this));
    }
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131379953));
    this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131715725));
    this.jdField_b_of_type_JavaLangString = getString(2131715863);
    localObject1 = findViewById(2131367670);
    ((View)localObject1).setVisibility(0);
    this.jdField_f_of_type_AndroidViewView = findViewById(2131374659);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374658));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374660));
    this.jdField_g_of_type_AndroidViewView = findViewById(2131374674);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374673));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374675));
    int i1 = (getWindowManager().getDefaultDisplay().getWidth() - getResources().getDimensionPixelSize(2131297916) * 3) / 8;
    localObject2 = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
    if (localObject2 != null)
    {
      ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = i1;
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = i1;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    this.jdField_a_of_type_Ztd = new ztd(this, null);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_Ztd);
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_g_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_Ztd);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839406);
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374286));
    this.jdField_a_of_type_Aqsq = aqst.a();
    if ((this.jdField_a_of_type_Aqsq.jdField_a_of_type_JavaUtilList.size() <= 0) || (TextUtils.isEmpty(((aqss)this.jdField_a_of_type_Aqsq.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString))) {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_h_of_type_Int = zvc.a(this.app);
    if ((this.jdField_h_of_type_Int < 0) || (this.jdField_h_of_type_Int >= this.jdField_a_of_type_Aqsq.jdField_a_of_type_JavaUtilList.size()))
    {
      this.jdField_i_of_type_AndroidViewView.setBackgroundResource(2130846935);
      localObject1 = getResources().getDrawable(2130843652);
      ((Drawable)localObject1).setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
      this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject1);
      localObject1 = getResources().getDrawable(2130850652);
      ((Drawable)localObject1).setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
      this.leftView.setBackgroundDrawable((Drawable)localObject1);
      this.centerView.setTextColor(-16777216);
    }
    for (;;)
    {
      bcst.b(this.app, "CliOper", "", "", "0X800AEAB", "0X800AEAB", 0, 0, "", "", "", "");
      return;
      a((aqss)this.jdField_a_of_type_Aqsq.jdField_a_of_type_JavaUtilList.get(this.jdField_h_of_type_Int), false);
    }
  }
  
  private void o()
  {
    String str1;
    if (!bgnt.d(BaseApplication.getContext()))
    {
      QQToast.a(this, getString(2131691985), 0).b(getTitleBarHeight());
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
        bgjt.a("Grp_share", "grpData_admin", str1, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
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
        ThreadManager.post(new QRDisplayActivity.21(this, "temp_qrcode_share_" + this.jdField_c_of_type_JavaLangString + ".png"), 8, null, true);
        if (this.jdField_c_of_type_Int != 2) {
          break;
        }
        bcst.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_qq", 0, 0, this.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_Int), "");
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        int i1;
        zvc.a(1, 2131695774);
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
        i1 = 2131719199;
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
          bgjt.a("Grp_share", "grpData_admin", str1, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
        }
        this.jdField_i_of_type_Int = -1;
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        zvc.a(1, 2131695774);
      }
      if (this.jdField_c_of_type_Int != 2) {
        break;
      }
      if (this.jdField_i_of_type_Int == 2) {}
      for (String str2 = "qr_wechat";; str2 = "qr_circle")
      {
        bgjt.a("Grp_share", "grpData_admin", str2, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
        return;
        label474:
        if (WXShareHelper.a().b()) {
          break;
        }
        i1 = 2131719200;
        break;
        label490:
        if (this.jdField_a_of_type_Bihh == null)
        {
          this.jdField_a_of_type_Bihh = new zso(this);
          WXShareHelper.a().a(this.jdField_a_of_type_Bihh);
        }
        ThreadManager.post(new QRDisplayActivity.20(this), 8, null, true);
        return;
      }
      if (this.jdField_c_of_type_Int != 2) {
        break;
      }
      bgjt.a("Grp_share", "grpData_admin", "qr_qq", 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
      return;
      if (this.jdField_c_of_type_Int != 5) {
        break;
      }
      bcst.b(this.app, "CliOper", "", "", "0X8006674", "0X8006674", 0, 0, "", "", "", "");
      return;
      g();
      if ((this.jdField_g_of_type_Int & 0x1) != 0) {
        bcst.b(this.app, "P_CliOper", "flag1", "", "0X800416E", "0X800416E", 0, 0, "", "", "", "");
      }
      if (this.jdField_c_of_type_Int == 2)
      {
        bcst.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_qzone", 0, 0, this.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_Int), "");
        return;
      }
      if (this.jdField_c_of_type_Int != 5) {
        break;
      }
      bcst.b(this.app, "CliOper", "", "", "0X8006675", "0X8006675", 0, 0, "", "", "", "");
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
    bkho localbkho = (bkho)bkif.a(this, null);
    localbkho.a(2131695760, 1, 7);
    localbkho.a(2131695766, 1, 8);
    localbkho.c(2131690582);
    localbkho.a(new zss(this, localbkho));
    if (!localbkho.isShowing()) {
      localbkho.show();
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
    ((ShareActionSheet)localObject1).setItemClickListenerV2(new zst(this));
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
    ((ShareActionSheet)localObject1).setItemClickListenerV2(new zsu(this));
    ((ShareActionSheet)localObject1).show();
  }
  
  private void u()
  {
    String str = String.format(getString(2131689584), new Object[] { a() });
    if (QLog.isColorLevel()) {
      QLog.i("QRDisplayActivity", 2, "copyTroopLink.text:" + str);
    }
    if (Build.VERSION.SDK_INT < 11) {
      ((android.text.ClipboardManager)getSystemService("clipboard")).setText(str);
    }
    for (;;)
    {
      QQToast.a(this, 2, getString(2131689980), 0).b(getTitleBarHeight());
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
    return zvc.a(str, paramInt2);
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
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    String str;
    switch (paramInt)
    {
    default: 
      str = anni.a(2131709967);
    }
    for (;;)
    {
      a(2130839571, str);
      finish();
      return;
      str = anni.a(2131709968);
      continue;
      str = anni.a(2131709965);
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
    int i4 = paramBundle.getInt("B");
    int i5 = paramBundle.getInt("W");
    Rect localRect = (Rect)paramBundle.getParcelable("qrloc");
    ArrayList localArrayList = paramBundle.getParcelableArrayList("clip");
    if (paramBundle.containsKey("qrsz"))
    {
      i1 = paramBundle.getInt("qrsz");
      localObject = a();
      if (localObject != null) {
        this.jdField_a_of_type_Gt = zvc.a((String)localObject, i1);
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
        i1 = 2130843791;
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      }
      if (this.jdField_c_of_type_Int != 1) {
        break label377;
      }
      a(paramBundle, localArrayList, localBitmap3);
      label331:
      localBitmap3.recycle();
      if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
        break label450;
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
      i1 = 2130843791;
      break;
      label377:
      if (this.jdField_c_of_type_Int == 2)
      {
        b(paramBundle, localArrayList, localBitmap3);
        break label331;
      }
      this.jdField_b_of_type_AndroidGraphicsBitmap = zvc.a(this, localBitmap1, this.jdField_a_of_type_AndroidGraphicsBitmap, paramBundle.getInt("nameClr"), this.jdField_a_of_type_JavaLangString, localBitmap2, localBitmap3, paramBundle.getInt("head"), paramBundle.getInt("tipsClr"), this.jdField_b_of_type_JavaLangString, localRect, localArrayList, i1);
      break label331;
      label450:
      if (super.isResume())
      {
        paramBundle = bglp.a(this, 230);
        paramBundle.setMessage(2131717449);
        paramBundle.setPositiveButton(2131694081, new zsi(this));
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
    ((FrameLayout.LayoutParams)localObject1).gravity = 17;
    this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(null);
    getTitleBarView().setBackgroundColor(0);
    ImmersiveUtils.a(true, getWindow());
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    findViewById(2131374648).setBackgroundDrawable(null);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.l = findViewById(16908290);
    this.m = findViewById(2131374680);
    this.m.setVisibility(0);
    this.n = this.m.findViewById(2131374624);
    this.n.setOnClickListener(this);
    this.n.setContentDescription(getString(2131698202));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)this.m.findViewById(2131374616));
    this.jdField_h_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)this.m.findViewById(2131374617));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.m.findViewById(2131374621));
    this.jdField_h_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_h_of_type_AndroidWidgetTextView.setSingleLine();
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.m.findViewById(2131374623));
    this.jdField_j_of_type_AndroidWidgetImageView = ((ImageView)this.m.findViewById(2131374618));
    this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)this.m.findViewById(2131374620));
    Object localObject2 = anni.a(2131695762);
    Object localObject3 = this.jdField_c_of_type_JavaLangString;
    azml.a(this.jdField_i_of_type_AndroidWidgetTextView, (String)localObject2, (String)localObject3);
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.m.findViewById(2131374622));
    this.jdField_i_of_type_AndroidWidgetTextView.setContentDescription(getString(2131715724));
    localObject2 = findViewById(2131367671);
    ((View)localObject2).setVisibility(0);
    this.jdField_f_of_type_AndroidViewView = findViewById(2131374662);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374661));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374663));
    this.jdField_h_of_type_AndroidViewView = findViewById(2131374682);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374681));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374683));
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
          break label932;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "initTroopQrCodeUI: not allow join mask");
        }
        this.jdField_j_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_k_of_type_AndroidWidgetTextView.setText(getString(2131695775));
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        this.jdField_h_of_type_AndroidViewView.setVisibility(8);
      }
    }
    for (;;)
    {
      int i1 = (getWindowManager().getDefaultDisplay().getWidth() - getResources().getDimensionPixelSize(2131297916) * 3) / 8;
      localObject1 = (ViewGroup.MarginLayoutParams)((View)localObject2).getLayoutParams();
      if (localObject1 != null)
      {
        ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = i1;
        ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = i1;
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.jdField_a_of_type_Ztd = new ztd(this, null);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_Ztd);
      this.jdField_h_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_h_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_Ztd);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839406);
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374286));
      this.jdField_b_of_type_JavaLangString = getString(2131715830);
      this.leftView.setContentDescription(getString(2131696980));
      this.jdField_a_of_type_Aqsq = aqst.a();
      if ((this.jdField_a_of_type_Aqsq.jdField_a_of_type_JavaUtilList.size() <= 0) || (TextUtils.isEmpty(((aqss)this.jdField_a_of_type_Aqsq.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString))) {
        this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_h_of_type_Int = zvc.b(this.app);
      if ((this.jdField_h_of_type_Int >= 0) && (this.jdField_h_of_type_Int < this.jdField_a_of_type_Aqsq.jdField_a_of_type_JavaUtilList.size())) {
        break;
      }
      this.l.setBackgroundResource(2130846935);
      localObject1 = getResources().getDrawable(2130850652);
      ((Drawable)localObject1).setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
      this.leftView.setBackgroundDrawable((Drawable)localObject1);
      this.centerView.setTextColor(-16777216);
      return;
      label932:
      if (((((TroopInfo)localObject3).dwGroupFlagExt & 0x80) != 0L) && (!((TroopInfo)localObject3).isAdmin()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "initTroopQrCodeUI: not invite join mask");
        }
        this.jdField_j_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_k_of_type_AndroidWidgetTextView.setText(getString(2131695776));
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        this.jdField_h_of_type_AndroidViewView.setVisibility(8);
      }
    }
    b((aqss)this.jdField_a_of_type_Aqsq.jdField_a_of_type_JavaUtilList.get(this.jdField_h_of_type_Int), false);
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
    if (this.jdField_b_of_type_Bkho == null)
    {
      this.jdField_b_of_type_Bkho = ((bkho)bkif.a(this, null));
      this.jdField_b_of_type_Bkho.a(2131715816, 1);
      this.jdField_b_of_type_Bkho.a(2131715818, 1);
      this.jdField_b_of_type_Bkho.a(2131715815, 1);
      this.jdField_b_of_type_Bkho.c(2131690582);
      this.jdField_b_of_type_Bkho.setOnDismissListener(new zsz(this));
      this.jdField_b_of_type_Bkho.a(new zta(this));
    }
    if (!this.jdField_b_of_type_Bkho.isShowing())
    {
      this.jdField_h_of_type_Boolean = false;
      this.jdField_b_of_type_Bkho.show();
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
          bgjt.a("Grp_share", "grpData_admin", (String)localObject1, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), localObject2 });
        }
      }
      else
      {
        if (paramInt2 != -1) {
          break label225;
        }
        bool = true;
        label105:
        a(bool);
        if (paramInt2 == -1)
        {
          if (paramInt1 != 1) {
            break label231;
          }
          a(0, getString(2131715817));
          if (QLog.isColorLevel()) {
            QLog.i("QRDisplayActivity", 2, "shareQRCode success");
          }
          if ((this.jdField_g_of_type_Int & 0x1) != 0) {
            bcst.b(this.app, "P_CliOper", "flag1", "", "0X800416F", "0X800416F", 0, 0, "", "", "", "");
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
      label225:
      bool = false;
      break label105;
      label231:
      if (paramInt1 == 2)
      {
        localObject1 = new Intent(this, SplashActivity.class);
        ((Intent)localObject1).putExtras(paramIntent);
        localObject2 = ForwardUtils.a((Intent)localObject1);
        ForwardUtils.a(this.app, this, (SessionInfo)localObject2, (Intent)localObject1);
      }
      else if (paramInt1 == 21)
      {
        localObject1 = afur.a(new Intent(this, SplashActivity.class), null);
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
    super.setContentView(2131560384);
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131374649));
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131374677);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131374667);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131374684);
    if (this.jdField_c_of_type_Int == 1) {
      n();
    }
    Object localObject1;
    int i1;
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131374665);
      this.jdField_e_of_type_AndroidViewView = findViewById(2131373620);
      this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131695765));
      if (QLog.isDevelopLevel()) {
        QLog.d("QRDisplayActivity", 4, "display qrcode, type: " + this.jdField_c_of_type_Int);
      }
      if (this.jdField_c_of_type_Int != 5) {
        break label1185;
      }
      getIntent().getStringExtra("discussion_shorturl");
      addObserver(this.jdField_a_of_type_Ankx);
      if (this.app != null)
      {
        this.jdField_a_of_type_Anks = ((anks)this.app.a(6));
        this.app.registObserver(this.jdField_a_of_type_Ztc);
      }
      this.leftView.setContentDescription(getString(2131695398));
      this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131695399));
      setResult(-1, getIntent());
      paramBundle = (anmw)this.app.getManager(51);
      localObject2 = (ankw)this.app.getManager(53);
      localObject1 = ((ankw)localObject2).a(this.jdField_c_of_type_JavaLangString);
      if (localObject1 != null) {
        break;
      }
      i();
      i1 = 1;
      this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager = new CodeMaskManager(this, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 60000L);
      if (i1 != 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_JavaLangString + "," + this.jdField_b_of_type_JavaLangString);
        this.jdField_c_of_type_AndroidViewView.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      if ((this.jdField_g_of_type_Int & 0x1) != 0) {
        bcst.b(this.app, "P_CliOper", "flag1", "", "0X800416D", "0X800416D", 0, 0, "", "", "", "");
      }
      this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
      this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004, 1, 0).sendToTarget();
      return true;
      if (this.jdField_c_of_type_Int == 2)
      {
        c();
      }
      else if (this.jdField_c_of_type_Int == 5)
      {
        findViewById(2131373619).setVisibility(0);
        findViewById(2131367669).setVisibility(0);
        findViewById(2131374656).setOnClickListener(this);
        findViewById(2131374657).setOnClickListener(this);
        this.jdField_b_of_type_JavaLangString = getString(2131715826);
      }
      else if (this.jdField_c_of_type_Int == 11)
      {
        findViewById(2131373619).setVisibility(0);
        findViewById(2131367669).setVisibility(0);
        findViewById(2131374656).setOnClickListener(this);
        findViewById(2131374657).setOnClickListener(this);
        this.jdField_b_of_type_JavaLangString = getString(2131715854);
      }
    }
    Object localObject2 = ((ankw)localObject2).a(this.jdField_c_of_type_JavaLangString);
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
          break label1015;
        }
        localObject2 = (DiscussionMemberInfo)((Iterator)localObject1).next();
        if (this.app.getAccount().equals(((DiscussionMemberInfo)localObject2).memberUin))
        {
          this.jdField_b_of_type_JavaUtilList.add(bglf.h(this.app, ((DiscussionMemberInfo)localObject2).memberUin));
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
      label1015:
      if ((this.jdField_b_of_type_JavaUtilList.size() >= 5) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label1284;
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
      ((anks)this.app.a(6)).a(new String[] { "20002" }, paramBundle);
    }
    label1284:
    for (int i2 = 0;; i2 = 1)
    {
      i1 = i2;
      if (this.jdField_b_of_type_JavaUtilList.size() <= 0) {
        break;
      }
      Collections.sort(this.jdField_b_of_type_JavaUtilList, new ztb(this));
      this.jdField_a_of_type_JavaLangString = a(this.jdField_b_of_type_JavaUtilList);
      i1 = i2;
      break;
      label1185:
      if (this.jdField_c_of_type_Int == 2)
      {
        this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131715828, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
        addObserver(this.jdField_a_of_type_Bjha);
        i1 = 1;
        break;
      }
      if (this.jdField_c_of_type_Int == 11) {
        this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131715828, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
      }
      i1 = 1;
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
      removeObserver(this.jdField_a_of_type_Ankx);
      this.app.unRegistObserver(this.jdField_a_of_type_Ztc);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bihh != null)
      {
        WXShareHelper.a().b(this.jdField_a_of_type_Bihh);
        this.jdField_a_of_type_Bihh = null;
      }
      if (this.jdField_a_of_type_Arnx != null) {
        this.jdField_a_of_type_Arnx.b(this);
      }
      super.doOnDestroy();
      return;
      if (this.jdField_c_of_type_Int == 2) {
        removeObserver(this.jdField_a_of_type_Bjha);
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
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004, 2, 0).sendToTarget();
    b(true);
  }
  
  public void e()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
      {
        requestPermissions(new zsh(this), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      f();
      return;
    }
    f();
  }
  
  public void f()
  {
    ThreadManager.executeOnFileThread(new QRDisplayActivity.11(this));
    String str = null;
    if (this.jdField_c_of_type_Int == 1) {
      str = "saveConsumerQRcard";
    }
    for (;;)
    {
      bctj.a(BaseApplication.getContext()).b(this.app, "", str, 1);
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
    ThreadManager.executeOnFileThread(new QRDisplayActivity.12(this));
    String str = null;
    if (this.jdField_c_of_type_Int == 1) {
      str = "shareConsumerQRcard";
    }
    for (;;)
    {
      bctj.a(BaseApplication.getContext()).b(this.app, "", str, 1);
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
        break label122;
      }
    }
    label122:
    for (boolean bool2 = true;; bool2 = false)
    {
      ((CodeMaskManager)localObject).a(this, bool3, bool1, i1, bool2);
      if (!this.jdField_d_of_type_Boolean) {
        break label127;
      }
      this.jdField_d_of_type_Boolean = false;
      return;
      bool1 = false;
      break;
    }
    label127:
    if (this.jdField_c_of_type_Int == 1) {}
    for (localObject = "changeConsumerQRcard";; localObject = "changeGroupQRcard")
    {
      bctj.a(BaseApplication.getContext()).b(this.app, "", (String)localObject, 1);
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
            if (this.jdField_a_of_type_Arnx == null) {
              this.jdField_a_of_type_Arnx = ((arnx)((arno)this.app.getManager(77)).a("qq.android.system.chirp"));
            }
            this.jdField_a_of_type_Arnx.a(this);
            this.jdField_a_of_type_Arnx.a(true);
            bool1 = false;
          }
        }
      }
      break;
    }
    for (;;)
    {
      BaseApplicationImpl.sUiHandler.post(new QRDisplayActivity.23(this, bool1));
      break;
      boolean bool2 = true;
      bool1 = bool2;
      if (!this.jdField_k_of_type_Boolean)
      {
        BaseApplicationImpl.sUiHandler.post(new QRDisplayActivity.22(this));
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
            break label525;
          }
        }
        label525:
        for (bool1 = true;; bool1 = false)
        {
          this.jdField_j_of_type_Boolean = bool1;
          if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "playQRCodeFailed = " + this.jdField_j_of_type_Boolean);
          }
          if (this.jdField_j_of_type_Boolean) {
            break label530;
          }
          if (this.jdField_a_of_type_ComTencentChirpPcmPlayer == null)
          {
            this.jdField_a_of_type_ComTencentChirpPcmPlayer = new PcmPlayer(this, this, 44100, str);
            this.jdField_a_of_type_ComTencentChirpPcmPlayer.a();
            bgkl.a(this, true);
          }
          if (paramMessage.arg1 != 5) {
            break;
          }
          bcst.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 0, 0, "", "", "", "");
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
          bcst.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 1, 0, "", "", "", "");
        }
        if (paramMessage.arg1 == 3) {
          bcst.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 1, 0, "", "", "", "");
        }
        bgkl.a(this, false);
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
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    if (super.isResume())
    {
      bgpa localbgpa = bglp.a(this, 230);
      localbgpa.setMessage(2131717447);
      localbgpa.setPositiveButton(2131694081, new zsj(this));
      localbgpa.show();
      return;
    }
    finish();
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      zsl localzsl = new zsl(this);
      zsm localzsm = new zsm(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(getString(2131718027));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setOnDismissListener(localzsm);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setCancelListener(new zsn(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(localzsl);
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
      bcst.b(this.app, "CliOper", "", "", "0X800AEAF", "0X800AEAF", 0, 0, "", "", "", "");
    }
    bcst.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "scan_QR_code", "code_click", 0, 0, "", "", "", "");
    if ("ScannerActivity".equals(this.jdField_f_of_type_JavaLangString))
    {
      if (isInMultiWindow()) {
        QQToast.a(this, anni.a(2131709964), 0).a();
      }
      setResult(-1);
      finish();
      return;
    }
    if (isInMultiWindow())
    {
      QQToast.a(this, anni.a(2131709966), 0).a();
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
      if (paramView.getId() == 2131374667)
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
          bcst.b(this.app, "P_CliOper", "flag1", "", "0X8004170", "0X8004170", 0, 0, "", "", "", "");
          continue;
        }
        if ((this.jdField_c_of_type_Int == 5) || (this.jdField_c_of_type_Int == 11))
        {
          h();
          bcst.b(this.app, "CliOper", "", "", "0X8006671", "0X8006671", 0, 0, "", "", "", "");
          continue;
        }
        d();
        continue;
      }
      if (paramView.getId() == 2131374651) {
        if (this.jdField_a_of_type_Bkho == null) {
          this.jdField_a_of_type_Bkho = new ajmn(this).a(this);
        }
      }
      try
      {
        this.jdField_a_of_type_Bkho.show();
        label217:
        bcst.b(this.app, "CliOper", "", "", "0X80040F6", "0X80040F6", 0, 0, "", "", "", "");
        continue;
        if (paramView.getId() == 2131374656)
        {
          if (this.jdField_a_of_type_Boolean) {
            continue;
          }
          e();
          if ((this.jdField_g_of_type_Int & 0x1) != 0) {
            bcst.b(this.app, "P_CliOper", "flag1", "", "0X8004171", "0X8004171", 0, 0, "", "", "", "");
          }
          if (this.jdField_c_of_type_Int == 5) {
            bcst.b(this.app, "CliOper", "", "", "0X8006672", "0X8006672", 0, 0, "", "", "", "");
          }
          if (this.jdField_c_of_type_Int != 2) {
            continue;
          }
          new bcsy(this.app).a("P_CliOper").b("Grp_set").c("Grp_data").d("qr_save").a(new String[] { this.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_Int) }).a();
          continue;
        }
        if (paramView.getId() == 2131374657)
        {
          j();
          if (this.jdField_c_of_type_Int != 5) {
            continue;
          }
          bcst.b(this.app, "CliOper", "", "", "0X8006673", "0X8006673", 0, 0, "", "", "", "");
          continue;
        }
        if ((paramView.getId() == 2131374673) || (paramView.getId() == 2131374675))
        {
          k();
          continue;
        }
        if (paramView.getId() == 2131374659)
        {
          bcst.b(this.app, "CliOper", "", "", "0X800AEAD", "0X800AEAD", 0, 0, "", "", "", "");
          s();
          continue;
        }
        if (paramView.getId() == 2131374662)
        {
          t();
          continue;
        }
        if (paramView.getId() == 2131374682)
        {
          e();
          continue;
        }
        if (paramView.getId() == 2131374674)
        {
          k();
          continue;
        }
        if (paramView.getId() == 2131368961)
        {
          bcst.b(this.app, "CliOper", "", "", "0X800AEB5", "0X800AEB5", 0, 0, "", "", "", "");
          r();
          continue;
        }
        if (paramView.getId() == 2131374625)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "onClick qr_code_white_bg isLoading =" + this.jdField_a_of_type_Boolean);
          }
          if (this.jdField_a_of_type_Boolean) {
            continue;
          }
          bcst.b(this.app, "CliOper", "", "", "0X800AEB4", "0X800AEB4", 0, 0, "", "", "", "");
          a(zvc.a(this.app, this.jdField_a_of_type_Aqsq, this.jdField_h_of_type_Int), true);
          continue;
        }
        if (paramView.getId() != 2131374624) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "onClick qr_code_troop_white_bg isLoading =" + this.jdField_a_of_type_Boolean);
        }
        if (this.jdField_a_of_type_Boolean) {
          continue;
        }
        b(zvc.a(this.app, this.jdField_a_of_type_Aqsq, this.jdField_h_of_type_Int), true);
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
      this.jdField_a_of_type_Bkho.dismiss();
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      int i1 = -1;
      if (!WXShareHelper.a().a()) {
        i1 = 2131719199;
      }
      for (;;)
      {
        if (i1 == -1) {
          break label104;
        }
        zvc.a(1, i1);
        break;
        if (!WXShareHelper.a().b()) {
          i1 = 2131719200;
        }
      }
      label104:
      if (this.jdField_a_of_type_Bihh == null)
      {
        this.jdField_a_of_type_Bihh = new zsk(this);
        WXShareHelper.a().a(this.jdField_a_of_type_Bihh);
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
        bcst.b((QQAppInterface)localObject, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, str1, "", "", "");
        this.jdField_g_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
        str1 = String.format(getString(2131691599), new Object[] { this.jdField_a_of_type_JavaLangString });
        if (this.jdField_c_of_type_Int == 11) {
          str1 = getString(2131692841);
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
      if (this.jdField_a_of_type_Biau == null)
      {
        this.jdField_a_of_type_Biau = new biau(this, getTitleBarHeight());
        this.jdField_a_of_type_Biau.c(2131694158);
        this.jdField_a_of_type_Biau.c(false);
      }
      DiscussionInfoCardActivity.a(this.app, this, 2, this.jdField_e_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_f_of_type_Int, this.jdField_a_of_type_Biau);
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