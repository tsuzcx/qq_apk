package com.tencent.mobileqq.activity;

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
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.PortalManager.ResultData;
import com.tencent.mobileqq.portal.SanHuaView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import ssg;
import ssh;

public class HongbaoShowerActivity
  extends BaseActivity
{
  private int jdField_a_of_type_Int;
  public long a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  View jdField_a_of_type_AndroidViewView;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  PortalManager.ResultData jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData;
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
    case 2130842280: 
      return "shower_star_high_bg";
    case 2130842279: 
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
  
  public static void a()
  {
    PortalManager.a(a(2130842280), 2130842280);
    PortalManager.a(a(2130842279), 2130842279);
    PortalManager.a(a(2130842269), 2130842269);
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.HongbaoShowerActivity", 2, "preloadBg stated!");
    }
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
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363196));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1.0F, 2, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator(new HongbaoShowerActivity.MyOvershotInterpolator(this));
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(800L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new ssg(this));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131363195);
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
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.HongbaoShowerActivity", 2, "showHongbaoResult mGiftUrl " + this.jdField_a_of_type_JavaLangString);
    }
    if (!NetworkUtil.d(this)) {
      QQToast.a(this, "当前网络不可用", 1).a();
    }
    while ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_JavaLangString == null)) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())) {
      PublicAccountUtil.a(getAppInterface(), this, this.jdField_b_of_type_JavaLangString, null, 113);
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
          ReportController.b((QQAppInterface)localObject2, "dc01440", "", "", "0X80077E9", "0X80077E9", 0, 0, "1", (String)localObject1, "", "");
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
        ReportController.b((QQAppInterface)localObject2, "dc01440", "", "", "0X80077E9", "0X80077E9", 0, 0, "2", (String)localObject1, "", "");
        break;
      }
    }
  }
  
  private void d()
  {
    ThreadManager.getUIHandler().postDelayed(new ssh(this), 500L);
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
    //   8: putfield 431	com/tencent/mobileqq/activity/HongbaoShowerActivity:mActNeedImmersive	Z
    //   11: aload_0
    //   12: aload_1
    //   13: invokespecial 433	com/tencent/mobileqq/app/BaseActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   16: pop
    //   17: aload_0
    //   18: invokevirtual 437	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   21: astore_1
    //   22: aload_1
    //   23: ifnonnull +9 -> 32
    //   26: aload_0
    //   27: invokevirtual 332	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   30: iconst_0
    //   31: ireturn
    //   32: aload_0
    //   33: aload_1
    //   34: ldc_w 439
    //   37: iconst_0
    //   38: invokevirtual 443	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   41: putfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   44: aload_0
    //   45: aload_0
    //   46: invokevirtual 437	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   49: ldc_w 445
    //   52: invokevirtual 448	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   55: putfield 297	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   58: aload_0
    //   59: invokevirtual 437	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   62: ldc_w 450
    //   65: iconst_m1
    //   66: invokevirtual 443	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   69: istore_3
    //   70: aload_0
    //   71: aload_0
    //   72: invokevirtual 437	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   75: ldc_w 452
    //   78: invokevirtual 448	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   81: putfield 324	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   84: aload_0
    //   85: invokevirtual 437	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   88: ldc_w 454
    //   91: iconst_m1
    //   92: invokevirtual 443	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   95: istore 4
    //   97: aload_0
    //   98: aload_0
    //   99: invokevirtual 437	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   102: ldc_w 456
    //   105: iconst_m1
    //   106: invokevirtual 443	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   109: putfield 458	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_Int	I
    //   112: aload_0
    //   113: invokevirtual 437	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   116: ldc_w 460
    //   119: iconst_m1
    //   120: invokevirtual 443	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   123: istore_2
    //   124: iload 4
    //   126: iconst_m1
    //   127: if_icmpeq +12 -> 139
    //   130: aload_0
    //   131: iload 4
    //   133: invokestatic 465	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   136: putfield 91	com/tencent/mobileqq/activity/HongbaoShowerActivity:e	Ljava/lang/String;
    //   139: aload_0
    //   140: aload_1
    //   141: ldc_w 467
    //   144: iconst_1
    //   145: invokevirtual 471	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   148: putfield 34	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_Boolean	Z
    //   151: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +125 -> 279
    //   157: ldc 142
    //   159: iconst_1
    //   160: new 288	java/lang/StringBuilder
    //   163: dup
    //   164: sipush 256
    //   167: invokespecial 473	java/lang/StringBuilder:<init>	(I)V
    //   170: iload_3
    //   171: invokevirtual 476	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   174: ldc_w 478
    //   177: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_0
    //   181: getfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   184: invokevirtual 476	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: ldc_w 478
    //   190: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_0
    //   194: getfield 297	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   197: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc_w 478
    //   203: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_0
    //   207: getfield 91	com/tencent/mobileqq/activity/HongbaoShowerActivity:e	Ljava/lang/String;
    //   210: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: ldc_w 478
    //   216: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_0
    //   220: invokevirtual 437	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   223: ldc_w 480
    //   226: iconst_m1
    //   227: invokevirtual 443	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   230: invokevirtual 476	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   233: ldc_w 478
    //   236: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_0
    //   240: invokevirtual 437	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   243: ldc_w 456
    //   246: iconst_m1
    //   247: invokevirtual 443	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   250: invokevirtual 476	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: ldc_w 478
    //   256: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_0
    //   260: invokevirtual 437	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   263: ldc_w 460
    //   266: iconst_m1
    //   267: invokevirtual 443	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   270: invokevirtual 476	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   273: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    //   299: getfield 458	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_Int	I
    //   302: ifge +35 -> 337
    //   305: iload_2
    //   306: ifge +31 -> 337
    //   309: aload_0
    //   310: invokevirtual 332	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   313: iconst_0
    //   314: ireturn
    //   315: astore_1
    //   316: iconst_m1
    //   317: istore_3
    //   318: iconst_m1
    //   319: istore_2
    //   320: ldc 142
    //   322: iconst_2
    //   323: ldc_w 482
    //   326: aload_1
    //   327: invokestatic 485	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   330: aload_0
    //   331: invokevirtual 332	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   334: goto -183 -> 151
    //   337: aload_0
    //   338: aload_0
    //   339: getfield 57	com/tencent/mobileqq/activity/HongbaoShowerActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   342: bipush 78
    //   344: invokevirtual 63	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   347: checkcast 159	com/tencent/mobileqq/portal/PortalManager
    //   350: aload_0
    //   351: getfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   354: iload_3
    //   355: aload_0
    //   356: getfield 458	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_Int	I
    //   359: iload_2
    //   360: invokevirtual 488	com/tencent/mobileqq/portal/PortalManager:a	(IIII)Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   363: putfield 490	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   366: aload_0
    //   367: getfield 490	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   370: ifnonnull +9 -> 379
    //   373: aload_0
    //   374: invokevirtual 332	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   377: iconst_0
    //   378: ireturn
    //   379: aload_0
    //   380: aload_0
    //   381: getfield 490	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   384: getfield 493	com/tencent/mobileqq/portal/PortalManager$ResultData:e	Ljava/lang/String;
    //   387: putfield 116	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   390: aload_0
    //   391: aload_0
    //   392: getfield 490	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   395: getfield 494	com/tencent/mobileqq/portal/PortalManager$ResultData:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   398: putfield 496	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   401: aload_0
    //   402: aload_0
    //   403: getfield 490	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   406: getfield 498	com/tencent/mobileqq/portal/PortalManager$ResultData:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   409: putfield 499	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   412: aload_0
    //   413: aload_0
    //   414: getfield 490	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   417: getfield 500	com/tencent/mobileqq/portal/PortalManager$ResultData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   420: putfield 102	com/tencent/mobileqq/activity/HongbaoShowerActivity:f	Ljava/lang/String;
    //   423: aload_0
    //   424: aload_0
    //   425: getfield 490	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   428: getfield 501	com/tencent/mobileqq/portal/PortalManager$ResultData:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   431: putfield 106	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   434: aload_0
    //   435: aload_0
    //   436: getfield 490	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   439: getfield 502	com/tencent/mobileqq/portal/PortalManager$ResultData:f	Ljava/lang/String;
    //   442: putfield 112	com/tencent/mobileqq/activity/HongbaoShowerActivity:h	Ljava/lang/String;
    //   445: aload_0
    //   446: aload_0
    //   447: getfield 490	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   450: getfield 503	com/tencent/mobileqq/portal/PortalManager$ResultData:h	Ljava/lang/String;
    //   453: putfield 324	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   456: aload_0
    //   457: getfield 490	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   460: getfield 505	com/tencent/mobileqq/portal/PortalManager$ResultData:jdField_d_of_type_Int	I
    //   463: tableswitch	default:+21 -> 484, 1:+689->1152, 2:+682->1145
    //   485: iconst_1
    //   486: putfield 36	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Boolean	Z
    //   489: ldc_w 506
    //   492: istore_2
    //   493: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   496: ifeq +35 -> 531
    //   499: ldc 142
    //   501: iconst_1
    //   502: new 288	java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   509: ldc_w 508
    //   512: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: aload_0
    //   516: getfield 490	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   519: getfield 505	com/tencent/mobileqq/portal/PortalManager$ResultData:jdField_d_of_type_Int	I
    //   522: invokevirtual 476	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   525: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   528: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   531: iload_2
    //   532: ifeq -502 -> 30
    //   535: aload_0
    //   536: iload_2
    //   537: invokespecial 511	com/tencent/mobileqq/app/BaseActivity:setContentView	(I)V
    //   540: aload_0
    //   541: aload_0
    //   542: ldc_w 512
    //   545: invokevirtual 190	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   548: checkcast 192	android/widget/RelativeLayout
    //   551: putfield 275	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   554: aload_0
    //   555: getfield 275	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   558: aload_0
    //   559: getfield 490	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   562: getfield 513	com/tencent/mobileqq/portal/PortalManager$ResultData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   565: invokevirtual 517	android/widget/RelativeLayout:setContentDescription	(Ljava/lang/CharSequence;)V
    //   568: aload_0
    //   569: getfield 275	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   572: new 519	ssc
    //   575: dup
    //   576: aload_0
    //   577: invokespecial 520	ssc:<init>	(Lcom/tencent/mobileqq/activity/HongbaoShowerActivity;)V
    //   580: invokevirtual 524	android/widget/RelativeLayout:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   583: aload_0
    //   584: aload_0
    //   585: ldc_w 525
    //   588: invokevirtual 190	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   591: checkcast 527	android/widget/TextView
    //   594: putfield 529	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   597: aload_0
    //   598: getfield 529	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   601: aload_0
    //   602: getfield 116	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   605: invokevirtual 532	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   608: aload_0
    //   609: aload_0
    //   610: ldc_w 533
    //   613: invokevirtual 190	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   616: checkcast 527	android/widget/TextView
    //   619: putfield 535	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   622: aload_0
    //   623: getfield 535	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   626: astore 7
    //   628: aload_0
    //   629: getfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   632: ifne +538 -> 1170
    //   635: ldc_w 537
    //   638: astore_1
    //   639: aload 7
    //   641: aload_1
    //   642: invokevirtual 532	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   645: aload_0
    //   646: getfield 535	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   649: new 539	ssd
    //   652: dup
    //   653: aload_0
    //   654: invokespecial 540	ssd:<init>	(Lcom/tencent/mobileqq/activity/HongbaoShowerActivity;)V
    //   657: invokevirtual 544	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   660: aload_0
    //   661: ldc_w 545
    //   664: invokevirtual 190	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   667: checkcast 527	android/widget/TextView
    //   670: astore 7
    //   672: aload_0
    //   673: getfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   676: ifne +501 -> 1177
    //   679: ldc_w 547
    //   682: astore_1
    //   683: aload 7
    //   685: aload_1
    //   686: invokevirtual 532	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   689: aload_0
    //   690: getfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   693: ifeq +11 -> 704
    //   696: aload_0
    //   697: getfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   700: iconst_1
    //   701: if_icmpne +115 -> 816
    //   704: aload_0
    //   705: getfield 490	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   708: getfield 549	com/tencent/mobileqq/portal/PortalManager$ResultData:jdField_g_of_type_Int	I
    //   711: iconst_1
    //   712: if_icmpne +104 -> 816
    //   715: aload_0
    //   716: getfield 496	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   719: invokestatic 555	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   722: ifne +94 -> 816
    //   725: aload_0
    //   726: ldc_w 556
    //   729: invokevirtual 190	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   732: iconst_0
    //   733: invokevirtual 559	android/view/View:setVisibility	(I)V
    //   736: aload_0
    //   737: aload_0
    //   738: ldc_w 560
    //   741: invokevirtual 190	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   744: checkcast 527	android/widget/TextView
    //   747: putfield 562	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   750: aload_0
    //   751: getfield 562	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   754: aload_0
    //   755: getfield 496	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   758: invokevirtual 532	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   761: aload_0
    //   762: aload_0
    //   763: ldc_w 563
    //   766: invokevirtual 190	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   769: checkcast 315	android/widget/CheckBox
    //   772: putfield 46	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetCheckBox	Landroid/widget/CheckBox;
    //   775: aload_0
    //   776: getfield 34	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_Boolean	Z
    //   779: ifne +11 -> 790
    //   782: aload_0
    //   783: getfield 46	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetCheckBox	Landroid/widget/CheckBox;
    //   786: iconst_0
    //   787: invokevirtual 566	android/widget/CheckBox:setChecked	(Z)V
    //   790: aload_0
    //   791: aload_0
    //   792: ldc_w 567
    //   795: invokevirtual 190	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   798: putfield 569	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   801: aload_0
    //   802: getfield 569	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   805: new 571	sse
    //   808: dup
    //   809: aload_0
    //   810: invokespecial 572	sse:<init>	(Lcom/tencent/mobileqq/activity/HongbaoShowerActivity;)V
    //   813: invokevirtual 573	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   816: aload_0
    //   817: ldc_w 574
    //   820: invokevirtual 190	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   823: astore_1
    //   824: aload_1
    //   825: ifnull +18 -> 843
    //   828: aload_0
    //   829: getfield 40	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Int	I
    //   832: iconst_1
    //   833: if_icmpne +351 -> 1184
    //   836: iconst_0
    //   837: istore_2
    //   838: aload_1
    //   839: iload_2
    //   840: invokevirtual 559	android/view/View:setVisibility	(I)V
    //   843: aload_0
    //   844: invokestatic 580	java/lang/System:currentTimeMillis	()J
    //   847: putfield 32	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_Long	J
    //   850: aload_0
    //   851: aload_0
    //   852: ldc_w 581
    //   855: invokevirtual 190	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   858: checkcast 527	android/widget/TextView
    //   861: putfield 583	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   864: aload_0
    //   865: getfield 583	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   868: new 585	ssf
    //   871: dup
    //   872: aload_0
    //   873: invokespecial 586	ssf:<init>	(Lcom/tencent/mobileqq/activity/HongbaoShowerActivity;)V
    //   876: invokevirtual 544	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   879: aload_0
    //   880: getfield 490	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   883: getfield 505	com/tencent/mobileqq/portal/PortalManager$ResultData:jdField_d_of_type_Int	I
    //   886: iconst_2
    //   887: if_icmpne +334 -> 1221
    //   890: aload_0
    //   891: ldc_w 587
    //   894: invokevirtual 190	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   897: checkcast 174	android/widget/ImageView
    //   900: astore 7
    //   902: aload 7
    //   904: ifnull +82 -> 986
    //   907: ldc 155
    //   909: invokestatic 157	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   912: invokestatic 590	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   915: astore_1
    //   916: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   919: ifeq +41 -> 960
    //   922: new 288	java/lang/StringBuilder
    //   925: dup
    //   926: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   929: ldc_w 592
    //   932: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: astore 8
    //   937: aload_1
    //   938: ifnull +252 -> 1190
    //   941: iconst_1
    //   942: istore 5
    //   944: ldc 142
    //   946: iconst_2
    //   947: aload 8
    //   949: iload 5
    //   951: invokevirtual 595	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   954: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   957: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   960: aload_1
    //   961: ifnonnull +433 -> 1394
    //   964: ldc 155
    //   966: invokestatic 157	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   969: ldc 155
    //   971: invokestatic 162	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   974: astore_1
    //   975: aload_1
    //   976: ifnonnull +220 -> 1196
    //   979: aload 7
    //   981: ldc 155
    //   983: invokevirtual 598	android/widget/ImageView:setImageResource	(I)V
    //   986: aload_0
    //   987: ldc 186
    //   989: invokevirtual 190	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   992: checkcast 192	android/widget/RelativeLayout
    //   995: astore 8
    //   997: aload 8
    //   999: ifnull +90 -> 1089
    //   1002: ldc 163
    //   1004: invokestatic 157	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   1007: invokestatic 590	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   1010: astore 7
    //   1012: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1015: ifeq +44 -> 1059
    //   1018: new 288	java/lang/StringBuilder
    //   1021: dup
    //   1022: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   1025: ldc_w 600
    //   1028: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1031: astore_1
    //   1032: iload 6
    //   1034: istore 5
    //   1036: aload 7
    //   1038: ifnull +6 -> 1044
    //   1041: iconst_1
    //   1042: istore 5
    //   1044: ldc 142
    //   1046: iconst_2
    //   1047: aload_1
    //   1048: iload 5
    //   1050: invokevirtual 595	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1053: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1056: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1059: aload 7
    //   1061: astore_1
    //   1062: aload 7
    //   1064: ifnonnull +14 -> 1078
    //   1067: ldc 163
    //   1069: invokestatic 157	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   1072: ldc 163
    //   1074: invokestatic 162	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   1077: astore_1
    //   1078: aload_1
    //   1079: ifnonnull +126 -> 1205
    //   1082: aload 8
    //   1084: ldc 163
    //   1086: invokevirtual 603	android/widget/RelativeLayout:setBackgroundResource	(I)V
    //   1089: aload_0
    //   1090: aload_0
    //   1091: ldc_w 604
    //   1094: invokevirtual 190	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   1097: checkcast 174	android/widget/ImageView
    //   1100: putfield 606	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1103: aload_0
    //   1104: getfield 606	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1107: ifnull +28 -> 1135
    //   1110: aload_0
    //   1111: getfield 499	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1114: ifnull +21 -> 1135
    //   1117: aload_0
    //   1118: getfield 606	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1121: new 169	android/graphics/drawable/BitmapDrawable
    //   1124: dup
    //   1125: aload_0
    //   1126: getfield 499	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1129: invokespecial 172	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   1132: invokevirtual 609	android/widget/ImageView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1135: aload_0
    //   1136: invokespecial 611	com/tencent/mobileqq/activity/HongbaoShowerActivity:b	()V
    //   1139: aload_0
    //   1140: invokespecial 613	com/tencent/mobileqq/activity/HongbaoShowerActivity:d	()V
    //   1143: iconst_1
    //   1144: ireturn
    //   1145: ldc_w 614
    //   1148: istore_2
    //   1149: goto -656 -> 493
    //   1152: ldc_w 506
    //   1155: istore_2
    //   1156: goto -663 -> 493
    //   1159: astore_1
    //   1160: aload_1
    //   1161: invokevirtual 615	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1164: aload_0
    //   1165: invokevirtual 332	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   1168: iconst_0
    //   1169: ireturn
    //   1170: ldc_w 617
    //   1173: astore_1
    //   1174: goto -535 -> 639
    //   1177: ldc_w 619
    //   1180: astore_1
    //   1181: goto -498 -> 683
    //   1184: bipush 8
    //   1186: istore_2
    //   1187: goto -349 -> 838
    //   1190: iconst_0
    //   1191: istore 5
    //   1193: goto -249 -> 944
    //   1196: aload 7
    //   1198: aload_1
    //   1199: invokevirtual 622	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   1202: goto -216 -> 986
    //   1205: aload 8
    //   1207: new 169	android/graphics/drawable/BitmapDrawable
    //   1210: dup
    //   1211: aload_1
    //   1212: invokespecial 172	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   1215: invokevirtual 623	android/widget/RelativeLayout:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1218: goto -129 -> 1089
    //   1221: aload_0
    //   1222: getfield 490	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$ResultData	Lcom/tencent/mobileqq/portal/PortalManager$ResultData;
    //   1225: getfield 505	com/tencent/mobileqq/portal/PortalManager$ResultData:jdField_d_of_type_Int	I
    //   1228: iconst_1
    //   1229: if_icmpne -94 -> 1135
    //   1232: aload_0
    //   1233: ldc_w 587
    //   1236: invokevirtual 190	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   1239: checkcast 174	android/widget/ImageView
    //   1242: astore 8
    //   1244: aload 8
    //   1246: ifnull +86 -> 1332
    //   1249: ldc 164
    //   1251: invokestatic 157	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   1254: invokestatic 590	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   1257: astore 7
    //   1259: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1262: ifeq +40 -> 1302
    //   1265: new 288	java/lang/StringBuilder
    //   1268: dup
    //   1269: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   1272: ldc_w 625
    //   1275: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1278: astore_1
    //   1279: aload 7
    //   1281: ifnull +6 -> 1287
    //   1284: iconst_1
    //   1285: istore 5
    //   1287: ldc 142
    //   1289: iconst_2
    //   1290: aload_1
    //   1291: iload 5
    //   1293: invokevirtual 595	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1296: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1299: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1302: aload 7
    //   1304: astore_1
    //   1305: aload 7
    //   1307: ifnonnull +14 -> 1321
    //   1310: ldc 164
    //   1312: invokestatic 157	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(I)Ljava/lang/String;
    //   1315: ldc 164
    //   1317: invokestatic 162	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   1320: astore_1
    //   1321: aload_1
    //   1322: ifnonnull +53 -> 1375
    //   1325: aload 8
    //   1327: ldc 164
    //   1329: invokevirtual 598	android/widget/ImageView:setImageResource	(I)V
    //   1332: aload_0
    //   1333: aload_0
    //   1334: ldc_w 626
    //   1337: invokevirtual 190	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   1340: checkcast 174	android/widget/ImageView
    //   1343: putfield 628	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1346: aload_0
    //   1347: getfield 628	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1350: ifnull -215 -> 1135
    //   1353: aload_0
    //   1354: getfield 499	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1357: ifnull -222 -> 1135
    //   1360: aload_0
    //   1361: aload_0
    //   1362: getfield 628	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1365: aload_0
    //   1366: getfield 499	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1369: invokespecial 630	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(Landroid/widget/ImageView;Landroid/graphics/Bitmap;)V
    //   1372: goto -237 -> 1135
    //   1375: aload 8
    //   1377: aload_1
    //   1378: invokevirtual 622	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   1381: goto -49 -> 1332
    //   1384: astore_1
    //   1385: iconst_m1
    //   1386: istore_2
    //   1387: goto -1067 -> 320
    //   1390: astore_1
    //   1391: goto -1071 -> 320
    //   1394: goto -419 -> 975
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1397	0	this	HongbaoShowerActivity
    //   0	1397	1	paramBundle	Bundle
    //   123	1264	2	i	int
    //   69	286	3	j	int
    //   95	37	4	k	int
    //   1	1291	5	bool1	boolean
    //   4	1029	6	bool2	boolean
    //   626	680	7	localObject1	Object
    //   935	441	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   32	70	315	java/lang/Exception
    //   535	540	1159	java/lang/OutOfMemoryError
    //   70	124	1384	java/lang/Exception
    //   130	139	1390	java/lang/Exception
    //   139	151	1390	java/lang/Exception
  }
  
  protected boolean isWrapContent()
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