package com.tencent.mobileqq.activity;

import Override;
import aedy;
import aedz;
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
import anvx;
import aznu;
import bdla;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.portal.SanHuaView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import uuc;

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
  aznu jdField_a_of_type_Aznu;
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
    case 2130844902: 
      return "shower_star_high_bg";
    case 2130844901: 
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
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376823));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1.0F, 2, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator(new aedz(this));
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(800L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new aedy(this));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131368275);
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
    if (!NetworkUtil.isNetSupport(this)) {
      QQToast.a(this, anvx.a(2131705001), 1).a();
    }
    while ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_JavaLangString == null)) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())) {
      uuc.a(getAppInterface(), this, this.jdField_b_of_type_JavaLangString, null, 113);
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
          bdla.b((QQAppInterface)localObject2, "dc01440", "", "", "0X80077E9", "0X80077E9", 0, 0, "1", (String)localObject1, "", "");
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
        bdla.b((QQAppInterface)localObject2, "dc01440", "", "", "0X80077E9", "0X80077E9", 0, 0, "2", (String)localObject1, "", "");
        break;
      }
    }
  }
  
  private void c()
  {
    ThreadManager.getUIHandler().postDelayed(new HongbaoShowerActivity.6(this), 500L);
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
  public boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: aload_0
    //   7: iconst_0
    //   8: putfield 439	com/tencent/mobileqq/activity/HongbaoShowerActivity:mActNeedImmersive	Z
    //   11: aload_0
    //   12: aload_1
    //   13: invokespecial 441	com/tencent/mobileqq/app/BaseActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   16: pop
    //   17: aload_0
    //   18: invokevirtual 445	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   21: astore_1
    //   22: aload_1
    //   23: ifnonnull +9 -> 32
    //   26: aload_0
    //   27: invokevirtual 324	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   30: iconst_0
    //   31: ireturn
    //   32: aload_0
    //   33: aload_1
    //   34: ldc_w 447
    //   37: iconst_0
    //   38: invokevirtual 451	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   41: putfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   44: aload_0
    //   45: aload_0
    //   46: invokevirtual 445	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   49: ldc_w 453
    //   52: invokevirtual 456	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   55: putfield 285	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   58: aload_0
    //   59: invokevirtual 445	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   62: ldc_w 458
    //   65: iconst_m1
    //   66: invokevirtual 451	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   69: istore_3
    //   70: aload_0
    //   71: aload_0
    //   72: invokevirtual 445	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   75: ldc_w 460
    //   78: invokevirtual 456	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   81: putfield 316	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   84: aload_0
    //   85: invokevirtual 445	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   88: ldc_w 462
    //   91: iconst_m1
    //   92: invokevirtual 451	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   95: istore 4
    //   97: aload_0
    //   98: aload_0
    //   99: invokevirtual 445	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   102: ldc_w 464
    //   105: iconst_m1
    //   106: invokevirtual 451	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   109: putfield 466	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_Int	I
    //   112: aload_0
    //   113: invokevirtual 445	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   116: ldc_w 468
    //   119: iconst_m1
    //   120: invokevirtual 451	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   123: istore_2
    //   124: iload 4
    //   126: iconst_m1
    //   127: if_icmpeq +12 -> 139
    //   130: aload_0
    //   131: iload 4
    //   133: invokestatic 473	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   136: putfield 91	com/tencent/mobileqq/activity/HongbaoShowerActivity:e	Ljava/lang/String;
    //   139: aload_0
    //   140: aload_1
    //   141: ldc_w 475
    //   144: iconst_1
    //   145: invokevirtual 479	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   148: putfield 34	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_Boolean	Z
    //   151: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +125 -> 279
    //   157: ldc 142
    //   159: iconst_1
    //   160: new 276	java/lang/StringBuilder
    //   163: dup
    //   164: sipush 256
    //   167: invokespecial 481	java/lang/StringBuilder:<init>	(I)V
    //   170: iload_3
    //   171: invokevirtual 484	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   174: ldc_w 486
    //   177: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_0
    //   181: getfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   184: invokevirtual 484	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: ldc_w 486
    //   190: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_0
    //   194: getfield 285	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   197: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc_w 486
    //   203: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_0
    //   207: getfield 91	com/tencent/mobileqq/activity/HongbaoShowerActivity:e	Ljava/lang/String;
    //   210: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: ldc_w 486
    //   216: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_0
    //   220: invokevirtual 445	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   223: ldc_w 488
    //   226: iconst_m1
    //   227: invokevirtual 451	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   230: invokevirtual 484	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   233: ldc_w 486
    //   236: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_0
    //   240: invokevirtual 445	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   243: ldc_w 464
    //   246: iconst_m1
    //   247: invokevirtual 451	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   250: invokevirtual 484	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: ldc_w 486
    //   256: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_0
    //   260: invokevirtual 445	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   263: ldc_w 468
    //   266: iconst_m1
    //   267: invokevirtual 451	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   270: invokevirtual 484	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
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
    //   299: getfield 466	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_Int	I
    //   302: ifge +35 -> 337
    //   305: iload_2
    //   306: ifge +31 -> 337
    //   309: aload_0
    //   310: invokevirtual 324	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   313: iconst_0
    //   314: ireturn
    //   315: astore_1
    //   316: iconst_m1
    //   317: istore_3
    //   318: iconst_m1
    //   319: istore_2
    //   320: ldc 142
    //   322: iconst_2
    //   323: ldc_w 490
    //   326: aload_1
    //   327: invokestatic 493	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   330: aload_0
    //   331: invokevirtual 324	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   334: goto -183 -> 151
    //   337: aload_0
    //   338: aload_0
    //   339: getfield 57	com/tencent/mobileqq/activity/HongbaoShowerActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   342: getstatic 498	com/tencent/mobileqq/app/QQManagerFactory:MGR_PORTAL	I
    //   345: invokevirtual 63	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   348: checkcast 500	com/tencent/mobileqq/portal/PortalManager
    //   351: aload_0
    //   352: getfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   355: iload_3
    //   356: aload_0
    //   357: getfield 466	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_Int	I
    //   360: iload_2
    //   361: invokevirtual 503	com/tencent/mobileqq/portal/PortalManager:a	(IIII)Laznu;
    //   364: putfield 505	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Aznu	Laznu;
    //   367: aload_0
    //   368: getfield 505	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Aznu	Laznu;
    //   371: ifnonnull +9 -> 380
    //   374: aload_0
    //   375: invokevirtual 324	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   378: iconst_0
    //   379: ireturn
    //   380: aload_0
    //   381: aload_0
    //   382: getfield 505	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Aznu	Laznu;
    //   385: getfield 508	aznu:e	Ljava/lang/String;
    //   388: putfield 116	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   391: aload_0
    //   392: aload_0
    //   393: getfield 505	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Aznu	Laznu;
    //   396: getfield 509	aznu:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   399: putfield 511	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   402: aload_0
    //   403: aload_0
    //   404: getfield 505	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Aznu	Laznu;
    //   407: getfield 513	aznu:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   410: putfield 514	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   413: aload_0
    //   414: aload_0
    //   415: getfield 505	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Aznu	Laznu;
    //   418: getfield 515	aznu:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   421: putfield 102	com/tencent/mobileqq/activity/HongbaoShowerActivity:f	Ljava/lang/String;
    //   424: aload_0
    //   425: aload_0
    //   426: getfield 505	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Aznu	Laznu;
    //   429: getfield 516	aznu:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   432: putfield 106	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   435: aload_0
    //   436: aload_0
    //   437: getfield 505	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Aznu	Laznu;
    //   440: getfield 517	aznu:f	Ljava/lang/String;
    //   443: putfield 112	com/tencent/mobileqq/activity/HongbaoShowerActivity:h	Ljava/lang/String;
    //   446: aload_0
    //   447: aload_0
    //   448: getfield 505	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Aznu	Laznu;
    //   451: getfield 518	aznu:h	Ljava/lang/String;
    //   454: putfield 316	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   457: aload_0
    //   458: getfield 505	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Aznu	Laznu;
    //   461: getfield 520	aznu:jdField_d_of_type_Int	I
    //   464: tableswitch	default:+24 -> 488, 1:+706->1170, 2:+699->1163
    //   489: iconst_1
    //   490: putfield 36	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Boolean	Z
    //   493: ldc_w 521
    //   496: istore_2
    //   497: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   500: ifeq +35 -> 535
    //   503: ldc 142
    //   505: iconst_1
    //   506: new 276	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   513: ldc_w 523
    //   516: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: aload_0
    //   520: getfield 505	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Aznu	Laznu;
    //   523: getfield 520	aznu:jdField_d_of_type_Int	I
    //   526: invokevirtual 484	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   529: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   535: iload_2
    //   536: ifeq -506 -> 30
    //   539: aload_0
    //   540: iload_2
    //   541: invokespecial 526	com/tencent/mobileqq/app/BaseActivity:setContentView	(I)V
    //   544: aload_0
    //   545: aload_0
    //   546: ldc_w 527
    //   549: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   552: checkcast 161	android/widget/RelativeLayout
    //   555: putfield 245	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   558: aload_0
    //   559: getfield 245	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   562: aload_0
    //   563: getfield 505	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Aznu	Laznu;
    //   566: getfield 528	aznu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   569: invokevirtual 532	android/widget/RelativeLayout:setContentDescription	(Ljava/lang/CharSequence;)V
    //   572: aload_0
    //   573: getfield 245	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   576: new 534	aedu
    //   579: dup
    //   580: aload_0
    //   581: invokespecial 535	aedu:<init>	(Lcom/tencent/mobileqq/activity/HongbaoShowerActivity;)V
    //   584: invokevirtual 539	android/widget/RelativeLayout:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   587: aload_0
    //   588: aload_0
    //   589: ldc_w 540
    //   592: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   595: checkcast 542	android/widget/TextView
    //   598: putfield 544	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   601: aload_0
    //   602: getfield 544	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   605: aload_0
    //   606: getfield 116	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   609: invokevirtual 547	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   612: aload_0
    //   613: aload_0
    //   614: ldc_w 548
    //   617: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   620: checkcast 542	android/widget/TextView
    //   623: putfield 550	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   626: aload_0
    //   627: getfield 550	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   630: astore 7
    //   632: aload_0
    //   633: getfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   636: ifne +552 -> 1188
    //   639: ldc_w 551
    //   642: invokestatic 297	anvx:a	(I)Ljava/lang/String;
    //   645: astore_1
    //   646: aload 7
    //   648: aload_1
    //   649: invokevirtual 547	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   652: aload_0
    //   653: getfield 550	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   656: new 553	aedv
    //   659: dup
    //   660: aload_0
    //   661: invokespecial 554	aedv:<init>	(Lcom/tencent/mobileqq/activity/HongbaoShowerActivity;)V
    //   664: invokevirtual 558	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   667: aload_0
    //   668: ldc_w 559
    //   671: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   674: checkcast 542	android/widget/TextView
    //   677: astore 7
    //   679: aload_0
    //   680: getfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   683: ifne +515 -> 1198
    //   686: ldc_w 560
    //   689: invokestatic 297	anvx:a	(I)Ljava/lang/String;
    //   692: astore_1
    //   693: aload 7
    //   695: aload_1
    //   696: invokevirtual 547	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   699: aload_0
    //   700: getfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   703: ifeq +11 -> 714
    //   706: aload_0
    //   707: getfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   710: iconst_1
    //   711: if_icmpne +115 -> 826
    //   714: aload_0
    //   715: getfield 505	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Aznu	Laznu;
    //   718: getfield 562	aznu:jdField_g_of_type_Int	I
    //   721: iconst_1
    //   722: if_icmpne +104 -> 826
    //   725: aload_0
    //   726: getfield 511	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   729: invokestatic 568	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   732: ifne +94 -> 826
    //   735: aload_0
    //   736: ldc_w 569
    //   739: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   742: iconst_0
    //   743: invokevirtual 572	android/view/View:setVisibility	(I)V
    //   746: aload_0
    //   747: aload_0
    //   748: ldc_w 573
    //   751: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   754: checkcast 542	android/widget/TextView
    //   757: putfield 575	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   760: aload_0
    //   761: getfield 575	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   764: aload_0
    //   765: getfield 511	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   768: invokevirtual 547	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   771: aload_0
    //   772: aload_0
    //   773: ldc_w 576
    //   776: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   779: checkcast 307	android/widget/CheckBox
    //   782: putfield 46	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetCheckBox	Landroid/widget/CheckBox;
    //   785: aload_0
    //   786: getfield 34	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_Boolean	Z
    //   789: ifne +11 -> 800
    //   792: aload_0
    //   793: getfield 46	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetCheckBox	Landroid/widget/CheckBox;
    //   796: iconst_0
    //   797: invokevirtual 579	android/widget/CheckBox:setChecked	(Z)V
    //   800: aload_0
    //   801: aload_0
    //   802: ldc_w 580
    //   805: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   808: putfield 582	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   811: aload_0
    //   812: getfield 582	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   815: new 584	aedw
    //   818: dup
    //   819: aload_0
    //   820: invokespecial 585	aedw:<init>	(Lcom/tencent/mobileqq/activity/HongbaoShowerActivity;)V
    //   823: invokevirtual 586	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   826: aload_0
    //   827: ldc_w 587
    //   830: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   833: astore_1
    //   834: aload_1
    //   835: ifnull +18 -> 853
    //   838: aload_0
    //   839: getfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   842: iconst_1
    //   843: if_icmpne +365 -> 1208
    //   846: iconst_0
    //   847: istore_2
    //   848: aload_1
    //   849: iload_2
    //   850: invokevirtual 572	android/view/View:setVisibility	(I)V
    //   853: aload_0
    //   854: invokestatic 593	java/lang/System:currentTimeMillis	()J
    //   857: putfield 32	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Long	J
    //   860: aload_0
    //   861: aload_0
    //   862: ldc_w 594
    //   865: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   868: checkcast 542	android/widget/TextView
    //   871: putfield 596	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   874: aload_0
    //   875: getfield 596	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   878: new 598	aedx
    //   881: dup
    //   882: aload_0
    //   883: invokespecial 599	aedx:<init>	(Lcom/tencent/mobileqq/activity/HongbaoShowerActivity;)V
    //   886: invokevirtual 558	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   889: aload_0
    //   890: getfield 505	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Aznu	Laznu;
    //   893: getfield 520	aznu:jdField_d_of_type_Int	I
    //   896: iconst_2
    //   897: if_icmpne +348 -> 1245
    //   900: aload_0
    //   901: ldc_w 600
    //   904: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   907: checkcast 264	android/widget/ImageView
    //   910: astore 7
    //   912: aload 7
    //   914: ifnull +86 -> 1000
    //   917: ldc_w 601
    //   920: invokestatic 602	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   923: invokestatic 605	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   926: astore_1
    //   927: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   930: ifeq +41 -> 971
    //   933: new 276	java/lang/StringBuilder
    //   936: dup
    //   937: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   940: ldc_w 607
    //   943: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: astore 8
    //   948: aload_1
    //   949: ifnull +265 -> 1214
    //   952: iconst_1
    //   953: istore 5
    //   955: ldc 142
    //   957: iconst_2
    //   958: aload 8
    //   960: iload 5
    //   962: invokevirtual 610	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   965: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   968: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   971: aload_1
    //   972: ifnonnull +450 -> 1422
    //   975: ldc_w 601
    //   978: invokestatic 602	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   981: ldc_w 601
    //   984: invokestatic 613	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   987: astore_1
    //   988: aload_1
    //   989: ifnonnull +231 -> 1220
    //   992: aload 7
    //   994: ldc_w 601
    //   997: invokevirtual 616	android/widget/ImageView:setImageResource	(I)V
    //   1000: aload_0
    //   1001: ldc 155
    //   1003: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   1006: checkcast 161	android/widget/RelativeLayout
    //   1009: astore 8
    //   1011: aload 8
    //   1013: ifnull +94 -> 1107
    //   1016: ldc_w 617
    //   1019: invokestatic 602	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   1022: invokestatic 605	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   1025: astore 7
    //   1027: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1030: ifeq +44 -> 1074
    //   1033: new 276	java/lang/StringBuilder
    //   1036: dup
    //   1037: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   1040: ldc_w 619
    //   1043: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: astore_1
    //   1047: iload 6
    //   1049: istore 5
    //   1051: aload 7
    //   1053: ifnull +6 -> 1059
    //   1056: iconst_1
    //   1057: istore 5
    //   1059: ldc 142
    //   1061: iconst_2
    //   1062: aload_1
    //   1063: iload 5
    //   1065: invokevirtual 610	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1068: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1071: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1074: aload 7
    //   1076: astore_1
    //   1077: aload 7
    //   1079: ifnonnull +16 -> 1095
    //   1082: ldc_w 617
    //   1085: invokestatic 602	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   1088: ldc_w 617
    //   1091: invokestatic 613	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   1094: astore_1
    //   1095: aload_1
    //   1096: ifnonnull +133 -> 1229
    //   1099: aload 8
    //   1101: ldc_w 617
    //   1104: invokevirtual 622	android/widget/RelativeLayout:setBackgroundResource	(I)V
    //   1107: aload_0
    //   1108: aload_0
    //   1109: ldc_w 623
    //   1112: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   1115: checkcast 264	android/widget/ImageView
    //   1118: putfield 625	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1121: aload_0
    //   1122: getfield 625	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1125: ifnull +28 -> 1153
    //   1128: aload_0
    //   1129: getfield 514	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1132: ifnull +21 -> 1153
    //   1135: aload_0
    //   1136: getfield 625	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1139: new 259	android/graphics/drawable/BitmapDrawable
    //   1142: dup
    //   1143: aload_0
    //   1144: getfield 514	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1147: invokespecial 262	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   1150: invokevirtual 628	android/widget/ImageView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1153: aload_0
    //   1154: invokespecial 630	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	()V
    //   1157: aload_0
    //   1158: invokespecial 632	com/tencent/mobileqq/activity/HongbaoShowerActivity:c	()V
    //   1161: iconst_1
    //   1162: ireturn
    //   1163: ldc_w 633
    //   1166: istore_2
    //   1167: goto -670 -> 497
    //   1170: ldc_w 521
    //   1173: istore_2
    //   1174: goto -677 -> 497
    //   1177: astore_1
    //   1178: aload_1
    //   1179: invokevirtual 634	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1182: aload_0
    //   1183: invokevirtual 324	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   1186: iconst_0
    //   1187: ireturn
    //   1188: ldc_w 635
    //   1191: invokestatic 297	anvx:a	(I)Ljava/lang/String;
    //   1194: astore_1
    //   1195: goto -549 -> 646
    //   1198: ldc_w 636
    //   1201: invokestatic 297	anvx:a	(I)Ljava/lang/String;
    //   1204: astore_1
    //   1205: goto -512 -> 693
    //   1208: bipush 8
    //   1210: istore_2
    //   1211: goto -363 -> 848
    //   1214: iconst_0
    //   1215: istore 5
    //   1217: goto -262 -> 955
    //   1220: aload 7
    //   1222: aload_1
    //   1223: invokevirtual 639	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   1226: goto -226 -> 1000
    //   1229: aload 8
    //   1231: new 259	android/graphics/drawable/BitmapDrawable
    //   1234: dup
    //   1235: aload_1
    //   1236: invokespecial 262	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   1239: invokevirtual 640	android/widget/RelativeLayout:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1242: goto -135 -> 1107
    //   1245: aload_0
    //   1246: getfield 505	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Aznu	Laznu;
    //   1249: getfield 520	aznu:jdField_d_of_type_Int	I
    //   1252: iconst_1
    //   1253: if_icmpne -100 -> 1153
    //   1256: aload_0
    //   1257: ldc_w 600
    //   1260: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   1263: checkcast 264	android/widget/ImageView
    //   1266: astore 8
    //   1268: aload 8
    //   1270: ifnull +90 -> 1360
    //   1273: ldc_w 641
    //   1276: invokestatic 602	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   1279: invokestatic 605	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   1282: astore 7
    //   1284: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1287: ifeq +40 -> 1327
    //   1290: new 276	java/lang/StringBuilder
    //   1293: dup
    //   1294: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   1297: ldc_w 643
    //   1300: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1303: astore_1
    //   1304: aload 7
    //   1306: ifnull +6 -> 1312
    //   1309: iconst_1
    //   1310: istore 5
    //   1312: ldc 142
    //   1314: iconst_2
    //   1315: aload_1
    //   1316: iload 5
    //   1318: invokevirtual 610	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1321: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1324: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1327: aload 7
    //   1329: astore_1
    //   1330: aload 7
    //   1332: ifnonnull +16 -> 1348
    //   1335: ldc_w 641
    //   1338: invokestatic 602	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   1341: ldc_w 641
    //   1344: invokestatic 613	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   1347: astore_1
    //   1348: aload_1
    //   1349: ifnonnull +54 -> 1403
    //   1352: aload 8
    //   1354: ldc_w 641
    //   1357: invokevirtual 616	android/widget/ImageView:setImageResource	(I)V
    //   1360: aload_0
    //   1361: aload_0
    //   1362: ldc_w 644
    //   1365: invokevirtual 159	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   1368: checkcast 264	android/widget/ImageView
    //   1371: putfield 646	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1374: aload_0
    //   1375: getfield 646	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1378: ifnull -225 -> 1153
    //   1381: aload_0
    //   1382: getfield 514	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1385: ifnull -232 -> 1153
    //   1388: aload_0
    //   1389: aload_0
    //   1390: getfield 646	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1393: aload_0
    //   1394: getfield 514	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1397: invokespecial 648	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(Landroid/widget/ImageView;Landroid/graphics/Bitmap;)V
    //   1400: goto -247 -> 1153
    //   1403: aload 8
    //   1405: aload_1
    //   1406: invokevirtual 639	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   1409: goto -49 -> 1360
    //   1412: astore_1
    //   1413: iconst_m1
    //   1414: istore_2
    //   1415: goto -1095 -> 320
    //   1418: astore_1
    //   1419: goto -1099 -> 320
    //   1422: goto -434 -> 988
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1425	0	this	HongbaoShowerActivity
    //   0	1425	1	paramBundle	Bundle
    //   123	1292	2	i	int
    //   69	287	3	j	int
    //   95	37	4	k	int
    //   1	1316	5	bool1	boolean
    //   4	1044	6	bool2	boolean
    //   630	701	7	localObject1	Object
    //   946	458	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   32	70	315	java/lang/Exception
    //   539	544	1177	java/lang/OutOfMemoryError
    //   70	124	1412	java/lang/Exception
    //   130	139	1418	java/lang/Exception
    //   139	151	1418	java/lang/Exception
  }
  
  public boolean isWrapContent()
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
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HongbaoShowerActivity
 * JD-Core Version:    0.7.0.1
 */