package com.tencent.mobileqq.activity;

import aazg;
import aazh;
import ajjy;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
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
import attm;
import awqx;
import badq;
import bbmy;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.portal.SanHuaView;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import rtr;

public class HongbaoShowerActivity
  extends BaseActivity
{
  private int jdField_a_of_type_Int;
  public long a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public View a;
  public AlphaAnimation a;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  attm jdField_a_of_type_Attm;
  private SanHuaView jdField_a_of_type_ComTencentMobileqqPortalSanHuaView;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  private String e;
  private String f;
  private String g;
  private String h;
  
  public HongbaoShowerActivity()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  private String a()
  {
    TicketManager localTicketManager = (TicketManager)this.app.getManager(2);
    if (localTicketManager != null) {
      return localTicketManager.getSkey(this.app.getCurrentAccountUin());
    }
    return "";
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 2130844044: 
      return "shower_star_high_bg";
    case 2130844043: 
      return "shower_star_bg";
    }
    return "shower_business_high_bg";
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject3.put("amount", this.e);
        localJSONObject3.put("channel", 4);
        if (this.jdField_a_of_type_Boolean) {
          continue;
        }
        str = this.f;
        localJSONObject3.put("mch_icon", str);
        if (this.jdField_a_of_type_Boolean) {
          continue;
        }
        str = this.jdField_g_of_type_JavaLangString;
        localJSONObject3.put("mch_top_img", str);
        localJSONObject3.put("wishing", this.h);
        localJSONObject3.put("send_name", this.jdField_c_of_type_JavaLangString);
        localJSONObject2.put("detailinfo", localJSONObject3);
        localJSONObject1.put("extra_data", localJSONObject2);
        localJSONObject1.put("come_from", 2);
        localJSONObject1.put("viewTag", "graphb");
        localJSONObject1.put("userId", this.app.getCurrentAccountUin());
        localJSONObject1.put("skey", a());
        localJSONObject1.put("key_type", 2);
      }
      catch (Exception localException)
      {
        String str;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        localException.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager.HongbaoShowerActivity", 2, localJSONObject1.toString());
      }
      return localJSONObject1;
      str = "";
      continue;
      str = "";
    }
  }
  
  private void a()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131309631));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1.0F, 2, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator(new aazh(this));
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(800L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new aazg(this));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131301961);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 0.7F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(350L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.widthPixels;
    int j = localDisplayMetrics.heightPixels;
    this.jdField_a_of_type_ComTencentMobileqqPortalSanHuaView = new SanHuaView(this, i / 2, j / 2);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqPortalSanHuaView, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentMobileqqPortalSanHuaView.a(100);
  }
  
  private void a(ImageView paramImageView, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      paramImageView.setImageDrawable(new BitmapDrawable(paramBitmap));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("PortalManager.HongbaoShowerActivity", 2, "HongbaoLogo == null");
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.HongbaoShowerActivity", 2, "showHongbaoResult mGiftUrl " + this.jdField_a_of_type_JavaLangString);
    }
    if (!badq.d(this)) {
      bbmy.a(this, ajjy.a(2131639732), 1).a();
    }
    while ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_JavaLangString == null)) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())) {
      rtr.a(getAppInterface(), this, this.jdField_b_of_type_JavaLangString, null, 113);
    }
    for (int i = 1;; i = 0)
    {
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        finish();
        return;
      case 0: 
        localObject2 = a();
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("json", ((JSONObject)localObject2).toString());
        ((Bundle)localObject1).putString("callbackSn", "0");
        localObject2 = new Intent(this, PayBridgeActivity.class);
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        ((Intent)localObject2).putExtra("pay_requestcode", 5);
        startActivity((Intent)localObject2);
        localObject2 = this.app;
        if (i != 0) {}
        for (localObject1 = "1";; localObject1 = "2")
        {
          awqx.b((QQAppInterface)localObject2, "dc01440", "", "", "0X80077E9", "0X80077E9", 0, 0, "1", (String)localObject1, "", "");
          break;
        }
      }
      Object localObject1 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", this.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("hide_left_button", false);
      ((Intent)localObject1).putExtra("show_right_close_button", true);
      ((Intent)localObject1).putExtra("finish_animation_up_down", true);
      ((Intent)localObject1).putExtra("hide_operation_bar", true);
      ((Intent)localObject1).addFlags(67108864);
      startActivity((Intent)localObject1);
      setResult(-1);
      Object localObject2 = this.app;
      if (i != 0) {}
      for (localObject1 = "1";; localObject1 = "2")
      {
        awqx.b((QQAppInterface)localObject2, "dc01440", "", "", "0X80077E9", "0X80077E9", 0, 0, "2", (String)localObject1, "", "");
        break;
      }
    }
  }
  
  private void c()
  {
    ThreadManager.getUIHandler().postDelayed(new HongbaoShowerActivity.6(this), 500L);
  }
  
  /* Error */
  public boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: aload_0
    //   7: iconst_0
    //   8: putfield 422	com/tencent/mobileqq/activity/HongbaoShowerActivity:mActNeedImmersive	Z
    //   11: aload_0
    //   12: aload_1
    //   13: invokespecial 424	com/tencent/mobileqq/app/BaseActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   16: pop
    //   17: aload_0
    //   18: invokevirtual 428	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   21: astore_1
    //   22: aload_1
    //   23: ifnonnull +9 -> 32
    //   26: aload_0
    //   27: invokevirtual 323	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   30: iconst_0
    //   31: ireturn
    //   32: aload_0
    //   33: aload_1
    //   34: ldc_w 430
    //   37: iconst_0
    //   38: invokevirtual 434	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   41: putfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   44: aload_0
    //   45: aload_0
    //   46: invokevirtual 428	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   49: ldc_w 436
    //   52: invokevirtual 439	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   55: putfield 285	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   58: aload_0
    //   59: invokevirtual 428	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   62: ldc_w 441
    //   65: iconst_m1
    //   66: invokevirtual 434	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   69: istore_3
    //   70: aload_0
    //   71: aload_0
    //   72: invokevirtual 428	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   75: ldc_w 443
    //   78: invokevirtual 439	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   81: putfield 315	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   84: aload_0
    //   85: invokevirtual 428	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   88: ldc_w 445
    //   91: iconst_m1
    //   92: invokevirtual 434	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   95: istore 4
    //   97: aload_0
    //   98: aload_0
    //   99: invokevirtual 428	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   102: ldc_w 447
    //   105: iconst_m1
    //   106: invokevirtual 434	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   109: putfield 449	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_Int	I
    //   112: aload_0
    //   113: invokevirtual 428	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   116: ldc_w 451
    //   119: iconst_m1
    //   120: invokevirtual 434	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   123: istore_2
    //   124: iload 4
    //   126: iconst_m1
    //   127: if_icmpeq +12 -> 139
    //   130: aload_0
    //   131: iload 4
    //   133: invokestatic 456	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   136: putfield 91	com/tencent/mobileqq/activity/HongbaoShowerActivity:e	Ljava/lang/String;
    //   139: aload_0
    //   140: aload_1
    //   141: ldc_w 458
    //   144: iconst_1
    //   145: invokevirtual 462	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   148: putfield 34	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_Boolean	Z
    //   151: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +125 -> 279
    //   157: ldc 142
    //   159: iconst_1
    //   160: new 276	java/lang/StringBuilder
    //   163: dup
    //   164: sipush 256
    //   167: invokespecial 464	java/lang/StringBuilder:<init>	(I)V
    //   170: iload_3
    //   171: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   174: ldc_w 469
    //   177: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_0
    //   181: getfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   184: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: ldc_w 469
    //   190: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_0
    //   194: getfield 285	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   197: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc_w 469
    //   203: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_0
    //   207: getfield 91	com/tencent/mobileqq/activity/HongbaoShowerActivity:e	Ljava/lang/String;
    //   210: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: ldc_w 469
    //   216: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_0
    //   220: invokevirtual 428	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   223: ldc_w 471
    //   226: iconst_m1
    //   227: invokevirtual 434	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   230: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   233: ldc_w 469
    //   236: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_0
    //   240: invokevirtual 428	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   243: ldc_w 447
    //   246: iconst_m1
    //   247: invokevirtual 434	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   250: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: ldc_w 469
    //   256: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_0
    //   260: invokevirtual 428	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   263: ldc_w 451
    //   266: iconst_m1
    //   267: invokevirtual 434	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   270: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   273: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: iload_3
    //   280: iflt +29 -> 309
    //   283: aload_0
    //   284: getfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   287: iflt +22 -> 309
    //   290: aload_0
    //   291: getfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   294: iconst_2
    //   295: if_icmpgt +14 -> 309
    //   298: aload_0
    //   299: getfield 449	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_Int	I
    //   302: ifge +35 -> 337
    //   305: iload_2
    //   306: ifge +31 -> 337
    //   309: aload_0
    //   310: invokevirtual 323	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   313: iconst_0
    //   314: ireturn
    //   315: astore_1
    //   316: iconst_m1
    //   317: istore_3
    //   318: iconst_m1
    //   319: istore_2
    //   320: ldc 142
    //   322: iconst_2
    //   323: ldc_w 473
    //   326: aload_1
    //   327: invokestatic 476	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   330: aload_0
    //   331: invokevirtual 323	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   334: goto -183 -> 151
    //   337: aload_0
    //   338: aload_0
    //   339: getfield 57	com/tencent/mobileqq/activity/HongbaoShowerActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   342: bipush 79
    //   344: invokevirtual 63	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   347: checkcast 478	com/tencent/mobileqq/portal/PortalManager
    //   350: aload_0
    //   351: getfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   354: iload_3
    //   355: aload_0
    //   356: getfield 449	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_Int	I
    //   359: iload_2
    //   360: invokevirtual 481	com/tencent/mobileqq/portal/PortalManager:a	(IIII)Lattm;
    //   363: putfield 483	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Attm	Lattm;
    //   366: aload_0
    //   367: getfield 483	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Attm	Lattm;
    //   370: ifnonnull +9 -> 379
    //   373: aload_0
    //   374: invokevirtual 323	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   377: iconst_0
    //   378: ireturn
    //   379: aload_0
    //   380: aload_0
    //   381: getfield 483	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Attm	Lattm;
    //   384: getfield 486	attm:e	Ljava/lang/String;
    //   387: putfield 116	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   390: aload_0
    //   391: aload_0
    //   392: getfield 483	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Attm	Lattm;
    //   395: getfield 487	attm:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   398: putfield 489	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   401: aload_0
    //   402: aload_0
    //   403: getfield 483	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Attm	Lattm;
    //   406: getfield 491	attm:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   409: putfield 492	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   412: aload_0
    //   413: aload_0
    //   414: getfield 483	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Attm	Lattm;
    //   417: getfield 493	attm:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   420: putfield 102	com/tencent/mobileqq/activity/HongbaoShowerActivity:f	Ljava/lang/String;
    //   423: aload_0
    //   424: aload_0
    //   425: getfield 483	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Attm	Lattm;
    //   428: getfield 494	attm:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   431: putfield 106	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   434: aload_0
    //   435: aload_0
    //   436: getfield 483	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Attm	Lattm;
    //   439: getfield 495	attm:f	Ljava/lang/String;
    //   442: putfield 112	com/tencent/mobileqq/activity/HongbaoShowerActivity:h	Ljava/lang/String;
    //   445: aload_0
    //   446: aload_0
    //   447: getfield 483	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Attm	Lattm;
    //   450: getfield 496	attm:h	Ljava/lang/String;
    //   453: putfield 315	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   456: aload_0
    //   457: getfield 483	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Attm	Lattm;
    //   460: getfield 498	attm:jdField_d_of_type_Int	I
    //   463: tableswitch	default:+21 -> 484, 1:+703->1166, 2:+696->1159
    //   485: iconst_1
    //   486: putfield 36	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Boolean	Z
    //   489: ldc_w 499
    //   492: istore_2
    //   493: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   496: ifeq +35 -> 531
    //   499: ldc 142
    //   501: iconst_1
    //   502: new 276	java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   509: ldc_w 501
    //   512: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: aload_0
    //   516: getfield 483	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Attm	Lattm;
    //   519: getfield 498	attm:jdField_d_of_type_Int	I
    //   522: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   525: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   528: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   531: iload_2
    //   532: ifeq -502 -> 30
    //   535: aload_0
    //   536: iload_2
    //   537: invokespecial 504	com/tencent/mobileqq/app/BaseActivity:setContentView	(I)V
    //   540: aload_0
    //   541: aload_0
    //   542: ldc_w 505
    //   545: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   548: checkcast 161	android/widget/RelativeLayout
    //   551: putfield 245	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   554: aload_0
    //   555: getfield 245	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   558: aload_0
    //   559: getfield 483	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Attm	Lattm;
    //   562: getfield 506	attm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   565: invokevirtual 510	android/widget/RelativeLayout:setContentDescription	(Ljava/lang/CharSequence;)V
    //   568: aload_0
    //   569: getfield 245	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   572: new 512	aazc
    //   575: dup
    //   576: aload_0
    //   577: invokespecial 513	aazc:<init>	(Lcom/tencent/mobileqq/activity/HongbaoShowerActivity;)V
    //   580: invokevirtual 517	android/widget/RelativeLayout:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   583: aload_0
    //   584: aload_0
    //   585: ldc_w 518
    //   588: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   591: checkcast 520	android/widget/TextView
    //   594: putfield 522	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   597: aload_0
    //   598: getfield 522	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   601: aload_0
    //   602: getfield 116	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   605: invokevirtual 525	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   608: aload_0
    //   609: aload_0
    //   610: ldc_w 526
    //   613: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   616: checkcast 520	android/widget/TextView
    //   619: putfield 528	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   622: aload_0
    //   623: getfield 528	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   626: astore 7
    //   628: aload_0
    //   629: getfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   632: ifne +552 -> 1184
    //   635: ldc_w 529
    //   638: invokestatic 296	ajjy:a	(I)Ljava/lang/String;
    //   641: astore_1
    //   642: aload 7
    //   644: aload_1
    //   645: invokevirtual 525	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   648: aload_0
    //   649: getfield 528	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   652: new 531	aazd
    //   655: dup
    //   656: aload_0
    //   657: invokespecial 532	aazd:<init>	(Lcom/tencent/mobileqq/activity/HongbaoShowerActivity;)V
    //   660: invokevirtual 536	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   663: aload_0
    //   664: ldc_w 537
    //   667: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   670: checkcast 520	android/widget/TextView
    //   673: astore 7
    //   675: aload_0
    //   676: getfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   679: ifne +515 -> 1194
    //   682: ldc_w 538
    //   685: invokestatic 296	ajjy:a	(I)Ljava/lang/String;
    //   688: astore_1
    //   689: aload 7
    //   691: aload_1
    //   692: invokevirtual 525	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   695: aload_0
    //   696: getfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   699: ifeq +11 -> 710
    //   702: aload_0
    //   703: getfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   706: iconst_1
    //   707: if_icmpne +115 -> 822
    //   710: aload_0
    //   711: getfield 483	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Attm	Lattm;
    //   714: getfield 540	attm:jdField_g_of_type_Int	I
    //   717: iconst_1
    //   718: if_icmpne +104 -> 822
    //   721: aload_0
    //   722: getfield 489	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   725: invokestatic 546	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   728: ifne +94 -> 822
    //   731: aload_0
    //   732: ldc_w 547
    //   735: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   738: iconst_0
    //   739: invokevirtual 550	android/view/View:setVisibility	(I)V
    //   742: aload_0
    //   743: aload_0
    //   744: ldc_w 551
    //   747: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   750: checkcast 520	android/widget/TextView
    //   753: putfield 553	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   756: aload_0
    //   757: getfield 553	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   760: aload_0
    //   761: getfield 489	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   764: invokevirtual 525	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   767: aload_0
    //   768: aload_0
    //   769: ldc_w 554
    //   772: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   775: checkcast 306	android/widget/CheckBox
    //   778: putfield 46	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetCheckBox	Landroid/widget/CheckBox;
    //   781: aload_0
    //   782: getfield 34	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_Boolean	Z
    //   785: ifne +11 -> 796
    //   788: aload_0
    //   789: getfield 46	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetCheckBox	Landroid/widget/CheckBox;
    //   792: iconst_0
    //   793: invokevirtual 557	android/widget/CheckBox:setChecked	(Z)V
    //   796: aload_0
    //   797: aload_0
    //   798: ldc_w 558
    //   801: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   804: putfield 560	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   807: aload_0
    //   808: getfield 560	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   811: new 562	aaze
    //   814: dup
    //   815: aload_0
    //   816: invokespecial 563	aaze:<init>	(Lcom/tencent/mobileqq/activity/HongbaoShowerActivity;)V
    //   819: invokevirtual 564	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   822: aload_0
    //   823: ldc_w 565
    //   826: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   829: astore_1
    //   830: aload_1
    //   831: ifnull +18 -> 849
    //   834: aload_0
    //   835: getfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   838: iconst_1
    //   839: if_icmpne +365 -> 1204
    //   842: iconst_0
    //   843: istore_2
    //   844: aload_1
    //   845: iload_2
    //   846: invokevirtual 550	android/view/View:setVisibility	(I)V
    //   849: aload_0
    //   850: invokestatic 571	java/lang/System:currentTimeMillis	()J
    //   853: putfield 32	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Long	J
    //   856: aload_0
    //   857: aload_0
    //   858: ldc_w 572
    //   861: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   864: checkcast 520	android/widget/TextView
    //   867: putfield 574	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   870: aload_0
    //   871: getfield 574	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   874: new 576	aazf
    //   877: dup
    //   878: aload_0
    //   879: invokespecial 577	aazf:<init>	(Lcom/tencent/mobileqq/activity/HongbaoShowerActivity;)V
    //   882: invokevirtual 536	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   885: aload_0
    //   886: getfield 483	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Attm	Lattm;
    //   889: getfield 498	attm:jdField_d_of_type_Int	I
    //   892: iconst_2
    //   893: if_icmpne +348 -> 1241
    //   896: aload_0
    //   897: ldc_w 578
    //   900: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   903: checkcast 264	android/widget/ImageView
    //   906: astore 7
    //   908: aload 7
    //   910: ifnull +86 -> 996
    //   913: ldc_w 579
    //   916: invokestatic 580	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   919: invokestatic 583	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   922: astore_1
    //   923: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   926: ifeq +41 -> 967
    //   929: new 276	java/lang/StringBuilder
    //   932: dup
    //   933: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   936: ldc_w 585
    //   939: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: astore 8
    //   944: aload_1
    //   945: ifnull +265 -> 1210
    //   948: iconst_1
    //   949: istore 5
    //   951: ldc 142
    //   953: iconst_2
    //   954: aload 8
    //   956: iload 5
    //   958: invokevirtual 588	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   961: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   964: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   967: aload_1
    //   968: ifnonnull +450 -> 1418
    //   971: ldc_w 579
    //   974: invokestatic 580	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   977: ldc_w 579
    //   980: invokestatic 591	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   983: astore_1
    //   984: aload_1
    //   985: ifnonnull +231 -> 1216
    //   988: aload 7
    //   990: ldc_w 579
    //   993: invokevirtual 594	android/widget/ImageView:setImageResource	(I)V
    //   996: aload_0
    //   997: ldc 155
    //   999: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   1002: checkcast 161	android/widget/RelativeLayout
    //   1005: astore 8
    //   1007: aload 8
    //   1009: ifnull +94 -> 1103
    //   1012: ldc_w 595
    //   1015: invokestatic 580	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   1018: invokestatic 583	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   1021: astore 7
    //   1023: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1026: ifeq +44 -> 1070
    //   1029: new 276	java/lang/StringBuilder
    //   1032: dup
    //   1033: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   1036: ldc_w 597
    //   1039: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: astore_1
    //   1043: iload 6
    //   1045: istore 5
    //   1047: aload 7
    //   1049: ifnull +6 -> 1055
    //   1052: iconst_1
    //   1053: istore 5
    //   1055: ldc 142
    //   1057: iconst_2
    //   1058: aload_1
    //   1059: iload 5
    //   1061: invokevirtual 588	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1064: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1067: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1070: aload 7
    //   1072: astore_1
    //   1073: aload 7
    //   1075: ifnonnull +16 -> 1091
    //   1078: ldc_w 595
    //   1081: invokestatic 580	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   1084: ldc_w 595
    //   1087: invokestatic 591	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   1090: astore_1
    //   1091: aload_1
    //   1092: ifnonnull +133 -> 1225
    //   1095: aload 8
    //   1097: ldc_w 595
    //   1100: invokevirtual 600	android/widget/RelativeLayout:setBackgroundResource	(I)V
    //   1103: aload_0
    //   1104: aload_0
    //   1105: ldc_w 601
    //   1108: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   1111: checkcast 264	android/widget/ImageView
    //   1114: putfield 603	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1117: aload_0
    //   1118: getfield 603	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1121: ifnull +28 -> 1149
    //   1124: aload_0
    //   1125: getfield 492	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1128: ifnull +21 -> 1149
    //   1131: aload_0
    //   1132: getfield 603	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1135: new 259	android/graphics/drawable/BitmapDrawable
    //   1138: dup
    //   1139: aload_0
    //   1140: getfield 492	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1143: invokespecial 262	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   1146: invokevirtual 606	android/widget/ImageView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1149: aload_0
    //   1150: invokespecial 608	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	()V
    //   1153: aload_0
    //   1154: invokespecial 610	com/tencent/mobileqq/activity/HongbaoShowerActivity:c	()V
    //   1157: iconst_1
    //   1158: ireturn
    //   1159: ldc_w 611
    //   1162: istore_2
    //   1163: goto -670 -> 493
    //   1166: ldc_w 499
    //   1169: istore_2
    //   1170: goto -677 -> 493
    //   1173: astore_1
    //   1174: aload_1
    //   1175: invokevirtual 612	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1178: aload_0
    //   1179: invokevirtual 323	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   1182: iconst_0
    //   1183: ireturn
    //   1184: ldc_w 613
    //   1187: invokestatic 296	ajjy:a	(I)Ljava/lang/String;
    //   1190: astore_1
    //   1191: goto -549 -> 642
    //   1194: ldc_w 614
    //   1197: invokestatic 296	ajjy:a	(I)Ljava/lang/String;
    //   1200: astore_1
    //   1201: goto -512 -> 689
    //   1204: bipush 8
    //   1206: istore_2
    //   1207: goto -363 -> 844
    //   1210: iconst_0
    //   1211: istore 5
    //   1213: goto -262 -> 951
    //   1216: aload 7
    //   1218: aload_1
    //   1219: invokevirtual 617	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   1222: goto -226 -> 996
    //   1225: aload 8
    //   1227: new 259	android/graphics/drawable/BitmapDrawable
    //   1230: dup
    //   1231: aload_1
    //   1232: invokespecial 262	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   1235: invokevirtual 618	android/widget/RelativeLayout:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1238: goto -135 -> 1103
    //   1241: aload_0
    //   1242: getfield 483	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Attm	Lattm;
    //   1245: getfield 498	attm:jdField_d_of_type_Int	I
    //   1248: iconst_1
    //   1249: if_icmpne -100 -> 1149
    //   1252: aload_0
    //   1253: ldc_w 578
    //   1256: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   1259: checkcast 264	android/widget/ImageView
    //   1262: astore 8
    //   1264: aload 8
    //   1266: ifnull +90 -> 1356
    //   1269: ldc_w 619
    //   1272: invokestatic 580	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   1275: invokestatic 583	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   1278: astore 7
    //   1280: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1283: ifeq +40 -> 1323
    //   1286: new 276	java/lang/StringBuilder
    //   1289: dup
    //   1290: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   1293: ldc_w 621
    //   1296: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: astore_1
    //   1300: aload 7
    //   1302: ifnull +6 -> 1308
    //   1305: iconst_1
    //   1306: istore 5
    //   1308: ldc 142
    //   1310: iconst_2
    //   1311: aload_1
    //   1312: iload 5
    //   1314: invokevirtual 588	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1317: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1320: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1323: aload 7
    //   1325: astore_1
    //   1326: aload 7
    //   1328: ifnonnull +16 -> 1344
    //   1331: ldc_w 619
    //   1334: invokestatic 580	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   1337: ldc_w 619
    //   1340: invokestatic 591	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   1343: astore_1
    //   1344: aload_1
    //   1345: ifnonnull +54 -> 1399
    //   1348: aload 8
    //   1350: ldc_w 619
    //   1353: invokevirtual 594	android/widget/ImageView:setImageResource	(I)V
    //   1356: aload_0
    //   1357: aload_0
    //   1358: ldc_w 622
    //   1361: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   1364: checkcast 264	android/widget/ImageView
    //   1367: putfield 624	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1370: aload_0
    //   1371: getfield 624	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1374: ifnull -225 -> 1149
    //   1377: aload_0
    //   1378: getfield 492	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1381: ifnull -232 -> 1149
    //   1384: aload_0
    //   1385: aload_0
    //   1386: getfield 624	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1389: aload_0
    //   1390: getfield 492	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1393: invokespecial 626	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(Landroid/widget/ImageView;Landroid/graphics/Bitmap;)V
    //   1396: goto -247 -> 1149
    //   1399: aload 8
    //   1401: aload_1
    //   1402: invokevirtual 617	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   1405: goto -49 -> 1356
    //   1408: astore_1
    //   1409: iconst_m1
    //   1410: istore_2
    //   1411: goto -1091 -> 320
    //   1414: astore_1
    //   1415: goto -1095 -> 320
    //   1418: goto -434 -> 984
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1421	0	this	HongbaoShowerActivity
    //   0	1421	1	paramBundle	Bundle
    //   123	1288	2	i	int
    //   69	286	3	j	int
    //   95	37	4	k	int
    //   1	1312	5	bool1	boolean
    //   4	1040	6	bool2	boolean
    //   626	701	7	localObject1	Object
    //   942	458	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   32	70	315	java/lang/Exception
    //   535	540	1173	java/lang/OutOfMemoryError
    //   70	124	1408	java/lang/Exception
    //   130	139	1414	java/lang/Exception
    //   139	151	1414	java/lang/Exception
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HongbaoShowerActivity
 * JD-Core Version:    0.7.0.1
 */