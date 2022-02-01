package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.portal.PortalManager.ResultData;
import com.tencent.mobileqq.portal.SanHuaView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class HongbaoShowerActivity
  extends BaseActivity
{
  private String A;
  private boolean B = true;
  private SanHuaView C;
  long a = 0L;
  View b;
  AlphaAnimation c;
  PortalManager.ResultData d;
  boolean e = false;
  private RelativeLayout f;
  private RelativeLayout g;
  private CheckBox h;
  private View i;
  private ImageView j;
  private ImageView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private Animation p;
  private String q;
  private int r;
  private String s;
  private String t;
  private String u;
  private Bitmap v;
  private int w;
  private String x;
  private String y;
  private String z;
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 2130846376: 
      return "shower_star_high_bg";
    case 2130846375: 
      return "shower_star_bg";
    }
    return "shower_business_high_bg";
  }
  
  private void a()
  {
    this.g = ((RelativeLayout)findViewById(2131444965));
    this.g.setVisibility(4);
    this.p = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1.0F, 2, 0.0F);
    this.p.setInterpolator(new HongbaoShowerActivity.MyOvershotInterpolator(this));
    this.p.setDuration(800L);
    this.p.setAnimationListener(new HongbaoShowerActivity.5(this));
    this.b = findViewById(2131435105);
    this.c = new AlphaAnimation(0.0F, 0.7F);
    this.c.setDuration(350L);
    this.c.setFillAfter(true);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i1 = localDisplayMetrics.widthPixels;
    int i2 = localDisplayMetrics.heightPixels;
    this.C = new SanHuaView(this, i1 / 2, i2 / 2);
    this.f.addView(this.C, new ViewGroup.LayoutParams(-1, -1));
    this.C.a(100);
  }
  
  private void a(ImageView paramImageView, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramImageView.setImageDrawable(new BitmapDrawable(paramBitmap));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PortalManager.HongbaoShowerActivity", 2, "HongbaoLogo == null");
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showHongbaoResult mGiftUrl ");
      ((StringBuilder)localObject1).append(this.q);
      QLog.d("PortalManager.HongbaoShowerActivity", 2, ((StringBuilder)localObject1).toString());
    }
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.makeText(this, HardCodeUtil.a(2131903503), 1).show();
      return;
    }
    if ((this.r != 0) && (this.q == null)) {
      return;
    }
    Object localObject1 = this.h;
    int i1;
    if ((localObject1 != null) && (((CheckBox)localObject1).isChecked()))
    {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).followUin(getAppInterface(), this, this.s, null, 113);
      i1 = 1;
    }
    else
    {
      i1 = 0;
    }
    int i2 = this.r;
    Object localObject2;
    if (i2 != 0)
    {
      if ((i2 == 1) || (i2 == 2))
      {
        localObject1 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", this.q);
        ((Intent)localObject1).putExtra("hide_left_button", false);
        ((Intent)localObject1).putExtra("show_right_close_button", true);
        ((Intent)localObject1).putExtra("finish_animation_up_down", true);
        ((Intent)localObject1).putExtra("hide_operation_bar", true);
        ((Intent)localObject1).addFlags(67108864);
        startActivity((Intent)localObject1);
        setResult(-1);
        localObject2 = this.app;
        if (i1 != 0) {
          localObject1 = "1";
        } else {
          localObject1 = "2";
        }
        ReportController.b((AppRuntime)localObject2, "dc01440", "", "", "0X80077E9", "0X80077E9", 0, 0, "2", (String)localObject1, "", "");
      }
    }
    else
    {
      localObject2 = c();
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("json", ((JSONObject)localObject2).toString());
      ((Bundle)localObject1).putString("callbackSn", "0");
      localObject2 = new Intent(this, PayBridgeActivity.class);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtra("pay_requestcode", 5);
      startActivity((Intent)localObject2);
      localObject2 = this.app;
      if (i1 != 0) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
      ReportController.b((AppRuntime)localObject2, "dc01440", "", "", "0X80077E9", "0X80077E9", 0, 0, "1", (String)localObject1, "", "");
    }
    finish();
  }
  
  private JSONObject c()
  {
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject3.put("amount", this.x);
        localJSONObject3.put("channel", 4);
        boolean bool = this.e;
        String str3 = "";
        if (bool) {
          break label248;
        }
        String str1 = this.y;
        localJSONObject3.put("mch_icon", str1);
        str1 = str3;
        if (!this.e) {
          str1 = this.z;
        }
        localJSONObject3.put("mch_top_img", str1);
        localJSONObject3.put("wishing", this.A);
        localJSONObject3.put("send_name", this.t);
        localJSONObject2.put("detailinfo", localJSONObject3);
        localJSONObject1.put("extra_data", localJSONObject2);
        localJSONObject1.put("come_from", 2);
        localJSONObject1.put("viewTag", "graphb");
        localJSONObject1.put("userId", this.app.getCurrentAccountUin());
        localJSONObject1.put("skey", e());
        localJSONObject1.put("key_type", 2);
      }
      catch (Exception localException)
      {
        if (QLog.isDevelopLevel()) {
          localException.printStackTrace();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager.HongbaoShowerActivity", 2, localJSONObject1.toString());
      }
      return localJSONObject1;
      label248:
      String str2 = "";
    }
  }
  
  private void d()
  {
    ThreadManager.getUIHandler().postDelayed(new HongbaoShowerActivity.6(this), 500L);
  }
  
  private String e()
  {
    TicketManager localTicketManager = (TicketManager)this.app.getManager(2);
    if (localTicketManager != null) {
      return localTicketManager.getSkey(this.app.getCurrentAccountUin());
    }
    return "";
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  /* Error */
  protected boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: aload_0
    //   7: iconst_0
    //   8: putfield 469	com/tencent/mobileqq/activity/HongbaoShowerActivity:mActNeedImmersive	Z
    //   11: aload_0
    //   12: aload_1
    //   13: invokespecial 471	com/tencent/mobileqq/app/BaseActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   16: pop
    //   17: aload_0
    //   18: invokevirtual 475	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   21: astore_1
    //   22: aload_1
    //   23: ifnonnull +9 -> 32
    //   26: aload_0
    //   27: invokevirtual 354	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   30: iconst_0
    //   31: ireturn
    //   32: aload_0
    //   33: aload_1
    //   34: ldc_w 477
    //   37: iconst_0
    //   38: invokevirtual 481	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   41: putfield 243	com/tencent/mobileqq/activity/HongbaoShowerActivity:r	I
    //   44: aload_0
    //   45: aload_0
    //   46: invokevirtual 475	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   49: ldc_w 483
    //   52: invokevirtual 486	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   55: putfield 214	com/tencent/mobileqq/activity/HongbaoShowerActivity:q	Ljava/lang/String;
    //   58: aload_0
    //   59: invokevirtual 475	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   62: ldc_w 488
    //   65: iconst_m1
    //   66: invokevirtual 481	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   69: istore_2
    //   70: aload_0
    //   71: aload_0
    //   72: invokevirtual 475	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   75: ldc_w 490
    //   78: invokevirtual 486	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   81: putfield 262	com/tencent/mobileqq/activity/HongbaoShowerActivity:s	Ljava/lang/String;
    //   84: aload_0
    //   85: invokevirtual 475	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   88: ldc_w 492
    //   91: iconst_m1
    //   92: invokevirtual 481	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   95: istore 4
    //   97: aload_0
    //   98: aload_0
    //   99: invokevirtual 475	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   102: ldc_w 494
    //   105: iconst_m1
    //   106: invokevirtual 481	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   109: putfield 496	com/tencent/mobileqq/activity/HongbaoShowerActivity:w	I
    //   112: aload_0
    //   113: invokevirtual 475	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   116: ldc_w 498
    //   119: iconst_m1
    //   120: invokevirtual 481	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   123: istore_3
    //   124: iload 4
    //   126: iconst_m1
    //   127: if_icmpeq +12 -> 139
    //   130: aload_0
    //   131: iload 4
    //   133: invokestatic 503	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   136: putfield 362	com/tencent/mobileqq/activity/HongbaoShowerActivity:x	Ljava/lang/String;
    //   139: aload_0
    //   140: aload_1
    //   141: ldc_w 505
    //   144: iconst_1
    //   145: invokevirtual 509	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   148: putfield 55	com/tencent/mobileqq/activity/HongbaoShowerActivity:B	Z
    //   151: goto +30 -> 181
    //   154: astore_1
    //   155: goto +12 -> 167
    //   158: astore_1
    //   159: goto +6 -> 165
    //   162: astore_1
    //   163: iconst_m1
    //   164: istore_2
    //   165: iconst_m1
    //   166: istore_3
    //   167: ldc 193
    //   169: iconst_2
    //   170: ldc_w 511
    //   173: aload_1
    //   174: invokestatic 514	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   177: aload_0
    //   178: invokevirtual 354	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   181: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   184: ifeq +153 -> 337
    //   187: new 205	java/lang/StringBuilder
    //   190: dup
    //   191: sipush 256
    //   194: invokespecial 516	java/lang/StringBuilder:<init>	(I)V
    //   197: astore_1
    //   198: aload_1
    //   199: iload_2
    //   200: invokevirtual 519	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_1
    //   205: ldc_w 521
    //   208: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_1
    //   213: aload_0
    //   214: getfield 243	com/tencent/mobileqq/activity/HongbaoShowerActivity:r	I
    //   217: invokevirtual 519	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload_1
    //   222: ldc_w 521
    //   225: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload_1
    //   230: aload_0
    //   231: getfield 214	com/tencent/mobileqq/activity/HongbaoShowerActivity:q	Ljava/lang/String;
    //   234: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload_1
    //   239: ldc_w 521
    //   242: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload_1
    //   247: aload_0
    //   248: getfield 362	com/tencent/mobileqq/activity/HongbaoShowerActivity:x	Ljava/lang/String;
    //   251: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload_1
    //   256: ldc_w 521
    //   259: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload_1
    //   264: aload_0
    //   265: invokevirtual 475	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   268: ldc_w 523
    //   271: iconst_m1
    //   272: invokevirtual 481	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   275: invokevirtual 519	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload_1
    //   280: ldc_w 521
    //   283: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_1
    //   288: aload_0
    //   289: invokevirtual 475	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   292: ldc_w 494
    //   295: iconst_m1
    //   296: invokevirtual 481	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   299: invokevirtual 519	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload_1
    //   304: ldc_w 521
    //   307: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload_1
    //   312: aload_0
    //   313: invokevirtual 475	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   316: ldc_w 498
    //   319: iconst_m1
    //   320: invokevirtual 481	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   323: invokevirtual 519	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: ldc 193
    //   329: iconst_1
    //   330: aload_1
    //   331: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: iload_2
    //   338: iflt +1110 -> 1448
    //   341: aload_0
    //   342: getfield 243	com/tencent/mobileqq/activity/HongbaoShowerActivity:r	I
    //   345: istore 4
    //   347: iload 4
    //   349: iflt +1099 -> 1448
    //   352: iload 4
    //   354: iconst_2
    //   355: if_icmpgt +1093 -> 1448
    //   358: aload_0
    //   359: getfield 496	com/tencent/mobileqq/activity/HongbaoShowerActivity:w	I
    //   362: ifge +10 -> 372
    //   365: iload_3
    //   366: ifge +6 -> 372
    //   369: goto +1079 -> 1448
    //   372: aload_0
    //   373: aload_0
    //   374: getfield 306	com/tencent/mobileqq/activity/HongbaoShowerActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   377: getstatic 528	com/tencent/mobileqq/app/QQManagerFactory:MGR_PORTAL	I
    //   380: invokevirtual 439	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   383: checkcast 530	com/tencent/mobileqq/portal/PortalManager
    //   386: aload_0
    //   387: getfield 243	com/tencent/mobileqq/activity/HongbaoShowerActivity:r	I
    //   390: iload_2
    //   391: aload_0
    //   392: getfield 496	com/tencent/mobileqq/activity/HongbaoShowerActivity:w	I
    //   395: iload_3
    //   396: invokevirtual 533	com/tencent/mobileqq/portal/PortalManager:a	(IIII)Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   399: putfield 535	com/tencent/mobileqq/activity/HongbaoShowerActivity:d	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   402: aload_0
    //   403: getfield 535	com/tencent/mobileqq/activity/HongbaoShowerActivity:d	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   406: astore_1
    //   407: aload_1
    //   408: ifnonnull +9 -> 417
    //   411: aload_0
    //   412: invokevirtual 354	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   415: iconst_0
    //   416: ireturn
    //   417: aload_0
    //   418: aload_1
    //   419: getfield 539	com/tencent/mobileqq/portal/PortalManager$ResultData:i	Ljava/lang/String;
    //   422: putfield 387	com/tencent/mobileqq/activity/HongbaoShowerActivity:t	Ljava/lang/String;
    //   425: aload_0
    //   426: aload_0
    //   427: getfield 535	com/tencent/mobileqq/activity/HongbaoShowerActivity:d	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   430: getfield 541	com/tencent/mobileqq/portal/PortalManager$ResultData:l	Ljava/lang/String;
    //   433: putfield 543	com/tencent/mobileqq/activity/HongbaoShowerActivity:u	Ljava/lang/String;
    //   436: aload_0
    //   437: aload_0
    //   438: getfield 535	com/tencent/mobileqq/activity/HongbaoShowerActivity:d	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   441: getfield 545	com/tencent/mobileqq/portal/PortalManager$ResultData:a	Landroid/graphics/Bitmap;
    //   444: putfield 547	com/tencent/mobileqq/activity/HongbaoShowerActivity:v	Landroid/graphics/Bitmap;
    //   447: aload_0
    //   448: aload_0
    //   449: getfield 535	com/tencent/mobileqq/activity/HongbaoShowerActivity:d	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   452: getfield 549	com/tencent/mobileqq/portal/PortalManager$ResultData:g	Ljava/lang/String;
    //   455: putfield 373	com/tencent/mobileqq/activity/HongbaoShowerActivity:y	Ljava/lang/String;
    //   458: aload_0
    //   459: aload_0
    //   460: getfield 535	com/tencent/mobileqq/activity/HongbaoShowerActivity:d	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   463: getfield 551	com/tencent/mobileqq/portal/PortalManager$ResultData:h	Ljava/lang/String;
    //   466: putfield 377	com/tencent/mobileqq/activity/HongbaoShowerActivity:z	Ljava/lang/String;
    //   469: aload_0
    //   470: aload_0
    //   471: getfield 535	com/tencent/mobileqq/activity/HongbaoShowerActivity:d	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   474: getfield 553	com/tencent/mobileqq/portal/PortalManager$ResultData:k	Ljava/lang/String;
    //   477: putfield 383	com/tencent/mobileqq/activity/HongbaoShowerActivity:A	Ljava/lang/String;
    //   480: aload_0
    //   481: aload_0
    //   482: getfield 535	com/tencent/mobileqq/activity/HongbaoShowerActivity:d	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   485: getfield 555	com/tencent/mobileqq/portal/PortalManager$ResultData:m	Ljava/lang/String;
    //   488: putfield 262	com/tencent/mobileqq/activity/HongbaoShowerActivity:s	Ljava/lang/String;
    //   491: aload_0
    //   492: getfield 535	com/tencent/mobileqq/activity/HongbaoShowerActivity:d	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   495: getfield 557	com/tencent/mobileqq/portal/PortalManager$ResultData:j	I
    //   498: istore 4
    //   500: ldc_w 558
    //   503: istore_3
    //   504: iload_3
    //   505: istore_2
    //   506: iload 4
    //   508: iconst_1
    //   509: if_icmpeq +23 -> 532
    //   512: iload 4
    //   514: iconst_2
    //   515: if_icmpeq +13 -> 528
    //   518: aload_0
    //   519: iconst_1
    //   520: putfield 57	com/tencent/mobileqq/activity/HongbaoShowerActivity:e	Z
    //   523: iload_3
    //   524: istore_2
    //   525: goto +7 -> 532
    //   528: ldc_w 559
    //   531: istore_2
    //   532: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   535: ifeq +41 -> 576
    //   538: new 205	java/lang/StringBuilder
    //   541: dup
    //   542: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   545: astore_1
    //   546: aload_1
    //   547: ldc_w 561
    //   550: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: aload_1
    //   555: aload_0
    //   556: getfield 535	com/tencent/mobileqq/activity/HongbaoShowerActivity:d	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   559: getfield 557	com/tencent/mobileqq/portal/PortalManager$ResultData:j	I
    //   562: invokevirtual 519	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: ldc 193
    //   568: iconst_1
    //   569: aload_1
    //   570: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   573: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   576: iload_2
    //   577: ifne +5 -> 582
    //   580: iconst_0
    //   581: ireturn
    //   582: aload_0
    //   583: iload_2
    //   584: invokespecial 564	com/tencent/mobileqq/app/BaseActivity:setContentView	(I)V
    //   587: aload_0
    //   588: aload_0
    //   589: ldc_w 565
    //   592: invokevirtual 70	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   595: checkcast 72	android/widget/RelativeLayout
    //   598: putfield 162	com/tencent/mobileqq/activity/HongbaoShowerActivity:f	Landroid/widget/RelativeLayout;
    //   601: aload_0
    //   602: getfield 162	com/tencent/mobileqq/activity/HongbaoShowerActivity:f	Landroid/widget/RelativeLayout;
    //   605: aload_0
    //   606: getfield 535	com/tencent/mobileqq/activity/HongbaoShowerActivity:d	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   609: getfield 567	com/tencent/mobileqq/portal/PortalManager$ResultData:b	Ljava/lang/String;
    //   612: invokevirtual 571	android/widget/RelativeLayout:setContentDescription	(Ljava/lang/CharSequence;)V
    //   615: aload_0
    //   616: getfield 162	com/tencent/mobileqq/activity/HongbaoShowerActivity:f	Landroid/widget/RelativeLayout;
    //   619: new 573	com/tencent/mobileqq/activity/HongbaoShowerActivity$1
    //   622: dup
    //   623: aload_0
    //   624: invokespecial 574	com/tencent/mobileqq/activity/HongbaoShowerActivity$1:<init>	(Lcom/tencent/mobileqq/activity/HongbaoShowerActivity;)V
    //   627: invokevirtual 578	android/widget/RelativeLayout:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   630: aload_0
    //   631: aload_0
    //   632: ldc_w 579
    //   635: invokevirtual 70	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   638: checkcast 581	android/widget/TextView
    //   641: putfield 583	com/tencent/mobileqq/activity/HongbaoShowerActivity:m	Landroid/widget/TextView;
    //   644: aload_0
    //   645: getfield 583	com/tencent/mobileqq/activity/HongbaoShowerActivity:m	Landroid/widget/TextView;
    //   648: aload_0
    //   649: getfield 387	com/tencent/mobileqq/activity/HongbaoShowerActivity:t	Ljava/lang/String;
    //   652: invokevirtual 586	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   655: aload_0
    //   656: aload_0
    //   657: ldc_w 587
    //   660: invokevirtual 70	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   663: checkcast 581	android/widget/TextView
    //   666: putfield 589	com/tencent/mobileqq/activity/HongbaoShowerActivity:o	Landroid/widget/TextView;
    //   669: aload_0
    //   670: getfield 589	com/tencent/mobileqq/activity/HongbaoShowerActivity:o	Landroid/widget/TextView;
    //   673: astore_1
    //   674: aload_0
    //   675: getfield 243	com/tencent/mobileqq/activity/HongbaoShowerActivity:r	I
    //   678: ifne +10 -> 688
    //   681: ldc_w 590
    //   684: istore_2
    //   685: goto +7 -> 692
    //   688: ldc_w 591
    //   691: istore_2
    //   692: aload_1
    //   693: iload_2
    //   694: invokestatic 231	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   697: invokevirtual 586	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   700: aload_0
    //   701: getfield 589	com/tencent/mobileqq/activity/HongbaoShowerActivity:o	Landroid/widget/TextView;
    //   704: new 593	com/tencent/mobileqq/activity/HongbaoShowerActivity$2
    //   707: dup
    //   708: aload_0
    //   709: invokespecial 594	com/tencent/mobileqq/activity/HongbaoShowerActivity$2:<init>	(Lcom/tencent/mobileqq/activity/HongbaoShowerActivity;)V
    //   712: invokevirtual 598	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   715: aload_0
    //   716: ldc_w 599
    //   719: invokevirtual 70	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   722: checkcast 581	android/widget/TextView
    //   725: astore_1
    //   726: aload_0
    //   727: getfield 243	com/tencent/mobileqq/activity/HongbaoShowerActivity:r	I
    //   730: ifne +10 -> 740
    //   733: ldc_w 600
    //   736: istore_2
    //   737: goto +7 -> 744
    //   740: ldc_w 601
    //   743: istore_2
    //   744: aload_1
    //   745: iload_2
    //   746: invokestatic 231	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   749: invokevirtual 586	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   752: aload_0
    //   753: getfield 243	com/tencent/mobileqq/activity/HongbaoShowerActivity:r	I
    //   756: istore_2
    //   757: iload_2
    //   758: ifeq +8 -> 766
    //   761: iload_2
    //   762: iconst_1
    //   763: if_icmpne +115 -> 878
    //   766: aload_0
    //   767: getfield 535	com/tencent/mobileqq/activity/HongbaoShowerActivity:d	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   770: getfield 603	com/tencent/mobileqq/portal/PortalManager$ResultData:q	I
    //   773: iconst_1
    //   774: if_icmpne +104 -> 878
    //   777: aload_0
    //   778: getfield 543	com/tencent/mobileqq/activity/HongbaoShowerActivity:u	Ljava/lang/String;
    //   781: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   784: ifne +94 -> 878
    //   787: aload_0
    //   788: ldc_w 610
    //   791: invokevirtual 70	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   794: iconst_0
    //   795: invokevirtual 613	android/view/View:setVisibility	(I)V
    //   798: aload_0
    //   799: aload_0
    //   800: ldc_w 614
    //   803: invokevirtual 70	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   806: checkcast 581	android/widget/TextView
    //   809: putfield 616	com/tencent/mobileqq/activity/HongbaoShowerActivity:n	Landroid/widget/TextView;
    //   812: aload_0
    //   813: getfield 616	com/tencent/mobileqq/activity/HongbaoShowerActivity:n	Landroid/widget/TextView;
    //   816: aload_0
    //   817: getfield 543	com/tencent/mobileqq/activity/HongbaoShowerActivity:u	Ljava/lang/String;
    //   820: invokevirtual 586	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   823: aload_0
    //   824: aload_0
    //   825: ldc_w 617
    //   828: invokevirtual 70	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   831: checkcast 245	android/widget/CheckBox
    //   834: putfield 203	com/tencent/mobileqq/activity/HongbaoShowerActivity:h	Landroid/widget/CheckBox;
    //   837: aload_0
    //   838: getfield 55	com/tencent/mobileqq/activity/HongbaoShowerActivity:B	Z
    //   841: ifne +11 -> 852
    //   844: aload_0
    //   845: getfield 203	com/tencent/mobileqq/activity/HongbaoShowerActivity:h	Landroid/widget/CheckBox;
    //   848: iconst_0
    //   849: invokevirtual 620	android/widget/CheckBox:setChecked	(Z)V
    //   852: aload_0
    //   853: aload_0
    //   854: ldc_w 621
    //   857: invokevirtual 70	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   860: putfield 623	com/tencent/mobileqq/activity/HongbaoShowerActivity:i	Landroid/view/View;
    //   863: aload_0
    //   864: getfield 623	com/tencent/mobileqq/activity/HongbaoShowerActivity:i	Landroid/view/View;
    //   867: new 625	com/tencent/mobileqq/activity/HongbaoShowerActivity$3
    //   870: dup
    //   871: aload_0
    //   872: invokespecial 626	com/tencent/mobileqq/activity/HongbaoShowerActivity$3:<init>	(Lcom/tencent/mobileqq/activity/HongbaoShowerActivity;)V
    //   875: invokevirtual 627	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   878: aload_0
    //   879: ldc_w 628
    //   882: invokevirtual 70	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   885: astore_1
    //   886: aload_1
    //   887: ifnull +24 -> 911
    //   890: aload_0
    //   891: getfield 243	com/tencent/mobileqq/activity/HongbaoShowerActivity:r	I
    //   894: iconst_1
    //   895: if_icmpne +8 -> 903
    //   898: iconst_0
    //   899: istore_2
    //   900: goto +6 -> 906
    //   903: bipush 8
    //   905: istore_2
    //   906: aload_1
    //   907: iload_2
    //   908: invokevirtual 613	android/view/View:setVisibility	(I)V
    //   911: aload_0
    //   912: invokestatic 634	java/lang/System:currentTimeMillis	()J
    //   915: putfield 53	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	J
    //   918: aload_0
    //   919: aload_0
    //   920: ldc_w 635
    //   923: invokevirtual 70	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   926: checkcast 581	android/widget/TextView
    //   929: putfield 637	com/tencent/mobileqq/activity/HongbaoShowerActivity:l	Landroid/widget/TextView;
    //   932: aload_0
    //   933: getfield 637	com/tencent/mobileqq/activity/HongbaoShowerActivity:l	Landroid/widget/TextView;
    //   936: new 639	com/tencent/mobileqq/activity/HongbaoShowerActivity$4
    //   939: dup
    //   940: aload_0
    //   941: invokespecial 640	com/tencent/mobileqq/activity/HongbaoShowerActivity$4:<init>	(Lcom/tencent/mobileqq/activity/HongbaoShowerActivity;)V
    //   944: invokevirtual 598	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   947: aload_0
    //   948: getfield 535	com/tencent/mobileqq/activity/HongbaoShowerActivity:d	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   951: getfield 557	com/tencent/mobileqq/portal/PortalManager$ResultData:j	I
    //   954: iconst_2
    //   955: if_icmpne +303 -> 1258
    //   958: aload_0
    //   959: ldc_w 641
    //   962: invokevirtual 70	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   965: checkcast 181	android/widget/ImageView
    //   968: astore 8
    //   970: aload 8
    //   972: ifnull +109 -> 1081
    //   975: ldc_w 642
    //   978: invokestatic 643	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   981: invokestatic 646	com/tencent/mobileqq/portal/PortalManager:b	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   984: astore 7
    //   986: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   989: ifeq +50 -> 1039
    //   992: new 205	java/lang/StringBuilder
    //   995: dup
    //   996: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   999: astore_1
    //   1000: aload_1
    //   1001: ldc_w 648
    //   1004: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: pop
    //   1008: aload 7
    //   1010: ifnull +9 -> 1019
    //   1013: iconst_1
    //   1014: istore 5
    //   1016: goto +6 -> 1022
    //   1019: iconst_0
    //   1020: istore 5
    //   1022: aload_1
    //   1023: iload 5
    //   1025: invokevirtual 651	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1028: pop
    //   1029: ldc 193
    //   1031: iconst_2
    //   1032: aload_1
    //   1033: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1036: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1039: aload 7
    //   1041: astore_1
    //   1042: aload 7
    //   1044: ifnonnull +16 -> 1060
    //   1047: ldc_w 642
    //   1050: invokestatic 643	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   1053: ldc_w 642
    //   1056: invokestatic 654	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   1059: astore_1
    //   1060: aload_1
    //   1061: ifnonnull +14 -> 1075
    //   1064: aload 8
    //   1066: ldc_w 642
    //   1069: invokevirtual 657	android/widget/ImageView:setImageResource	(I)V
    //   1072: goto +9 -> 1081
    //   1075: aload 8
    //   1077: aload_1
    //   1078: invokevirtual 660	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   1081: aload_0
    //   1082: ldc 66
    //   1084: invokevirtual 70	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   1087: checkcast 72	android/widget/RelativeLayout
    //   1090: astore 8
    //   1092: aload 8
    //   1094: ifnull +114 -> 1208
    //   1097: ldc_w 661
    //   1100: invokestatic 643	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   1103: invokestatic 646	com/tencent/mobileqq/portal/PortalManager:b	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   1106: astore 7
    //   1108: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1111: ifeq +48 -> 1159
    //   1114: new 205	java/lang/StringBuilder
    //   1117: dup
    //   1118: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   1121: astore_1
    //   1122: aload_1
    //   1123: ldc_w 663
    //   1126: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: pop
    //   1130: iload 6
    //   1132: istore 5
    //   1134: aload 7
    //   1136: ifnull +6 -> 1142
    //   1139: iconst_1
    //   1140: istore 5
    //   1142: aload_1
    //   1143: iload 5
    //   1145: invokevirtual 651	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1148: pop
    //   1149: ldc 193
    //   1151: iconst_2
    //   1152: aload_1
    //   1153: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1156: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1159: aload 7
    //   1161: astore_1
    //   1162: aload 7
    //   1164: ifnonnull +16 -> 1180
    //   1167: ldc_w 661
    //   1170: invokestatic 643	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   1173: ldc_w 661
    //   1176: invokestatic 654	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   1179: astore_1
    //   1180: aload_1
    //   1181: ifnonnull +14 -> 1195
    //   1184: aload 8
    //   1186: ldc_w 661
    //   1189: invokevirtual 666	android/widget/RelativeLayout:setBackgroundResource	(I)V
    //   1192: goto +16 -> 1208
    //   1195: aload 8
    //   1197: new 176	android/graphics/drawable/BitmapDrawable
    //   1200: dup
    //   1201: aload_1
    //   1202: invokespecial 179	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   1205: invokevirtual 669	android/widget/RelativeLayout:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1208: aload_0
    //   1209: aload_0
    //   1210: ldc_w 670
    //   1213: invokevirtual 70	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   1216: checkcast 181	android/widget/ImageView
    //   1219: putfield 672	com/tencent/mobileqq/activity/HongbaoShowerActivity:k	Landroid/widget/ImageView;
    //   1222: aload_0
    //   1223: getfield 672	com/tencent/mobileqq/activity/HongbaoShowerActivity:k	Landroid/widget/ImageView;
    //   1226: astore_1
    //   1227: aload_1
    //   1228: ifnull +199 -> 1427
    //   1231: aload_0
    //   1232: getfield 547	com/tencent/mobileqq/activity/HongbaoShowerActivity:v	Landroid/graphics/Bitmap;
    //   1235: astore 7
    //   1237: aload 7
    //   1239: ifnull +188 -> 1427
    //   1242: aload_1
    //   1243: new 176	android/graphics/drawable/BitmapDrawable
    //   1246: dup
    //   1247: aload 7
    //   1249: invokespecial 179	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   1252: invokevirtual 673	android/widget/ImageView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1255: goto +172 -> 1427
    //   1258: aload_0
    //   1259: getfield 535	com/tencent/mobileqq/activity/HongbaoShowerActivity:d	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   1262: getfield 557	com/tencent/mobileqq/portal/PortalManager$ResultData:j	I
    //   1265: iconst_1
    //   1266: if_icmpne +161 -> 1427
    //   1269: aload_0
    //   1270: ldc_w 641
    //   1273: invokevirtual 70	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   1276: checkcast 181	android/widget/ImageView
    //   1279: astore 8
    //   1281: aload 8
    //   1283: ifnull +103 -> 1386
    //   1286: ldc_w 674
    //   1289: invokestatic 643	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   1292: invokestatic 646	com/tencent/mobileqq/portal/PortalManager:b	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   1295: astore 7
    //   1297: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1300: ifeq +44 -> 1344
    //   1303: new 205	java/lang/StringBuilder
    //   1306: dup
    //   1307: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   1310: astore_1
    //   1311: aload_1
    //   1312: ldc_w 676
    //   1315: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: pop
    //   1319: aload 7
    //   1321: ifnull +6 -> 1327
    //   1324: iconst_1
    //   1325: istore 5
    //   1327: aload_1
    //   1328: iload 5
    //   1330: invokevirtual 651	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1333: pop
    //   1334: ldc 193
    //   1336: iconst_2
    //   1337: aload_1
    //   1338: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1341: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1344: aload 7
    //   1346: astore_1
    //   1347: aload 7
    //   1349: ifnonnull +16 -> 1365
    //   1352: ldc_w 674
    //   1355: invokestatic 643	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   1358: ldc_w 674
    //   1361: invokestatic 654	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   1364: astore_1
    //   1365: aload_1
    //   1366: ifnonnull +14 -> 1380
    //   1369: aload 8
    //   1371: ldc_w 674
    //   1374: invokevirtual 657	android/widget/ImageView:setImageResource	(I)V
    //   1377: goto +9 -> 1386
    //   1380: aload 8
    //   1382: aload_1
    //   1383: invokevirtual 660	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   1386: aload_0
    //   1387: aload_0
    //   1388: ldc_w 677
    //   1391: invokevirtual 70	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   1394: checkcast 181	android/widget/ImageView
    //   1397: putfield 679	com/tencent/mobileqq/activity/HongbaoShowerActivity:j	Landroid/widget/ImageView;
    //   1400: aload_0
    //   1401: getfield 679	com/tencent/mobileqq/activity/HongbaoShowerActivity:j	Landroid/widget/ImageView;
    //   1404: astore_1
    //   1405: aload_1
    //   1406: ifnull +21 -> 1427
    //   1409: aload_0
    //   1410: getfield 547	com/tencent/mobileqq/activity/HongbaoShowerActivity:v	Landroid/graphics/Bitmap;
    //   1413: astore 7
    //   1415: aload 7
    //   1417: ifnull +10 -> 1427
    //   1420: aload_0
    //   1421: aload_1
    //   1422: aload 7
    //   1424: invokespecial 681	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(Landroid/widget/ImageView;Landroid/graphics/Bitmap;)V
    //   1427: aload_0
    //   1428: invokespecial 683	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	()V
    //   1431: aload_0
    //   1432: invokespecial 685	com/tencent/mobileqq/activity/HongbaoShowerActivity:d	()V
    //   1435: iconst_1
    //   1436: ireturn
    //   1437: astore_1
    //   1438: aload_1
    //   1439: invokevirtual 686	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1442: aload_0
    //   1443: invokevirtual 354	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   1446: iconst_0
    //   1447: ireturn
    //   1448: aload_0
    //   1449: invokevirtual 354	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   1452: iconst_0
    //   1453: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1454	0	this	HongbaoShowerActivity
    //   0	1454	1	paramBundle	Bundle
    //   69	839	2	i1	int
    //   123	401	3	i2	int
    //   95	421	4	i3	int
    //   1	1328	5	bool1	boolean
    //   4	1127	6	bool2	boolean
    //   984	439	7	localBitmap	Bitmap
    //   968	413	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   130	139	154	java/lang/Exception
    //   139	151	154	java/lang/Exception
    //   70	124	158	java/lang/Exception
    //   32	70	162	java/lang/Exception
    //   582	587	1437	java/lang/OutOfMemoryError
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HongbaoShowerActivity
 * JD-Core Version:    0.7.0.1
 */