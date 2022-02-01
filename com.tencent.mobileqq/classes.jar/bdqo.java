import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout20.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class bdqo
  extends bdnv
{
  boolean a;
  String ac;
  String ad;
  String ae;
  String af;
  
  View a(View paramView, Context paramContext, String paramString)
  {
    bdqp localbdqp2;
    try
    {
      i = Integer.parseInt(this.ac);
      if (paramView == null)
      {
        bdqp localbdqp1 = new bdqp(this);
        paramView = View.inflate(paramContext, 2131561921, null);
        localbdqp1.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131371803));
        localbdqp1.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368381));
        localbdqp1.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367085));
        localbdqp1.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370446);
        paramView.setTag(localbdqp1);
        localbdqp1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramString);
        if (i != 1) {
          break label331;
        }
        localbdqp1.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localbdqp1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(Color.parseColor("#777777"));
        localbdqp1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextSize(14.0F);
        localbdqp1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        localbdqp1.jdField_a_of_type_AndroidWidgetTextView.setText(this.ae);
        localbdqp1.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        localbdqp1.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(paramContext.getResources().getDrawable(2130839383));
        paramView.setTag(2131374870, this.b);
        localbdqp1.jdField_a_of_type_AndroidWidgetTextView.setTag(2131374870, this.b);
        i = AIOUtils.dp2px(17.0F, paramContext.getResources());
        int j = AIOUtils.dp2px(16.0F, paramContext.getResources());
        localbdqp1.jdField_a_of_type_AndroidWidgetTextView.setPadding(j, 0, j, 0);
        localbdqp1.jdField_a_of_type_AndroidWidgetTextView.post(new StructMsgItemLayout20.1(this, i, localbdqp1));
        paramView.setOnClickListener(this);
        localbdqp1.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        return paramView;
      }
    }
    catch (Exception localException)
    {
      label331:
      do
      {
        for (;;)
        {
          QLog.e("StructMsgItemLayout20", 1, "content type:" + this.ac);
          i = 0;
          continue;
          localbdqp2 = (bdqp)paramView.getTag();
        }
      } while (i != 0);
      localbdqp2.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramString = paramContext.getResources().getDrawable(2130840348);
      if (TextUtils.isEmpty(this.ad)) {
        break label640;
      }
    }
    int i = AIOUtils.dp2px(40.0F, paramContext.getResources());
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramString;
    localURLDrawableOptions.mFailedDrawable = paramString;
    paramString = URLDrawable.getDrawable(this.ad, localURLDrawableOptions);
    if (paramString.getStatus() == 2) {
      paramString.restartDownload();
    }
    paramString.setTag(bgxc.b(i, i, i / 2));
    paramString.setDecodeHandler(bgxc.c);
    localbdqp2.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
    label446:
    if (this.jdField_a_of_type_Boolean)
    {
      paramString = paramContext.getResources().getDrawable(2130841803);
      localbdqp2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding(AIOUtils.dp2px(3.0F, paramContext.getResources()));
      paramString.setBounds(0, 0, AIOUtils.dp2px(15.0F, paramContext.getResources()), AIOUtils.dp2px(15.0F, paramContext.getResources()));
      localbdqp2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, paramString);
      localbdqp2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(Color.parseColor("#000000"));
      localbdqp2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextSize(17.0F);
      localbdqp2.jdField_a_of_type_AndroidWidgetTextView.setTag(localbdqp2);
      if (!((aoan)((BaseActivity)paramContext).app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a(Long.valueOf(Long.parseLong(this.af)))) {
        break label665;
      }
      localbdqp2.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      localbdqp2.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131713975));
      localbdqp2.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    }
    for (;;)
    {
      label514:
      paramView.setTag(2131374872, this.af);
      localbdqp2.jdField_a_of_type_AndroidWidgetTextView.setTag(2131374872, this.af);
      break;
      label640:
      localbdqp2.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
      break label446;
      localbdqp2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      break label514;
      label665:
      localbdqp2.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(paramContext.getResources().getDrawable(2130839383));
      localbdqp2.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131713981));
      localbdqp2.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    }
  }
  
  void a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.h);
      this.ac = localJSONObject.optString("contentType");
      if (localJSONObject.optInt("isCert") == 1) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_Boolean = bool;
        this.ad = localJSONObject.optString("faceUrl");
        this.ae = localJSONObject.optString("btnText");
        this.af = localJSONObject.optString("puin");
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("StructMsgItemLayout20", 1, "Exception:" + localException);
    }
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    a();
  }
  
  public boolean a(bdpl parambdpl)
  {
    super.a(parambdpl);
    a();
    return true;
  }
  
  protected int b()
  {
    return 20;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject;
    if ((paramView != null) && ((paramView instanceof LinearLayout)) && (((LinearLayout)paramView).getChildCount() == this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      paramBundle = (LinearLayout)paramView;
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      int i = 0;
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          bdnu localbdnu = (bdnu)((Iterator)localObject).next();
          localbdnu.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          if ("content".equals(localbdnu.jdField_a_of_type_JavaLangString))
          {
            localObject = ((bdpw)localbdnu).ai;
            a(((LinearLayout)paramView).getChildAt(i), paramContext, (String)localObject);
          }
        }
        else
        {
          return paramBundle;
        }
        i += 1;
      }
    }
    paramView = new LinearLayout(paramContext);
    paramBundle = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramBundle.hasNext())
    {
      localObject = (bdnu)paramBundle.next();
      ((bdnu)localObject).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (("content".equals(((bdnu)localObject).jdField_a_of_type_JavaLangString)) && ((localObject instanceof bdpw))) {
        paramView.addView(a(null, paramContext, ((bdpw)localObject).ai), new LinearLayout.LayoutParams(-1, -2));
      }
    }
    return paramView;
  }
  
  public String b()
  {
    return "Layout20";
  }
  
  /* Error */
  public void onClick(View paramView)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	bdqo:ac	Ljava/lang/String;
    //   4: invokestatic 27	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   7: istore_2
    //   8: aload_1
    //   9: invokevirtual 401	android/view/View:getContext	()Landroid/content/Context;
    //   12: astore 4
    //   14: aload 4
    //   16: instanceof 403
    //   19: ifne +11 -> 30
    //   22: invokestatic 409	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
    //   25: aload_1
    //   26: invokevirtual 412	com/tencent/qqlive/module/videoreport/collect/EventCollector:onViewClicked	(Landroid/view/View;)V
    //   29: return
    //   30: aload 4
    //   32: checkcast 403	android/support/v4/app/FragmentActivity
    //   35: astore 5
    //   37: aload 4
    //   39: checkcast 403	android/support/v4/app/FragmentActivity
    //   42: invokevirtual 416	android/support/v4/app/FragmentActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   45: astore_3
    //   46: aload_3
    //   47: ifnull +68 -> 115
    //   50: aload_3
    //   51: invokevirtual 421	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnull -34 -> 22
    //   59: aload_3
    //   60: getstatic 426	com/tencent/mobileqq/app/BusinessHandlerFactory:EC_SHOP_REPORT_HANDLER	I
    //   63: invokevirtual 430	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   66: checkcast 432	ook
    //   69: astore 6
    //   71: iload_2
    //   72: iconst_1
    //   73: if_icmpne +203 -> 276
    //   76: aload_0
    //   77: getfield 435	bdqo:Y	Ljava/lang/String;
    //   80: invokestatic 440	onq:b	(Ljava/lang/String;)Z
    //   83: ifeq +54 -> 137
    //   86: aload_3
    //   87: getstatic 443	com/tencent/mobileqq/app/QQManagerFactory:EC_SHOP_ASSISTANT_MANAGER	I
    //   90: invokevirtual 265	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   93: checkcast 437	onq
    //   96: astore_3
    //   97: aload_3
    //   98: ifnull -76 -> 22
    //   101: aload_3
    //   102: aload_0
    //   103: aload 4
    //   105: checkcast 445	android/app/Activity
    //   108: invokevirtual 448	onq:a	(Lbdnu;Landroid/app/Activity;)Z
    //   111: pop
    //   112: goto -90 -> 22
    //   115: invokestatic 454	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   118: invokevirtual 458	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   121: astore_3
    //   122: aload_3
    //   123: instanceof 261
    //   126: ifeq +374 -> 500
    //   129: aload_3
    //   130: checkcast 261	com/tencent/mobileqq/app/QQAppInterface
    //   133: astore_3
    //   134: goto -79 -> 55
    //   137: aload_1
    //   138: ldc 121
    //   140: invokevirtual 461	android/view/View:getTag	(I)Ljava/lang/Object;
    //   143: checkcast 367	java/lang/String
    //   146: astore 5
    //   148: aload 5
    //   150: invokestatic 188	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   153: ifne -131 -> 22
    //   156: new 463	android/content/Intent
    //   159: dup
    //   160: aload 4
    //   162: ldc_w 465
    //   165: invokespecial 468	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   168: astore 6
    //   170: aload 6
    //   172: ldc_w 470
    //   175: aload 5
    //   177: invokevirtual 474	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   180: pop
    //   181: aload 6
    //   183: ldc_w 476
    //   186: invokestatic 482	java/lang/System:currentTimeMillis	()J
    //   189: invokevirtual 485	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   192: pop
    //   193: aload 6
    //   195: ldc_w 487
    //   198: aload_0
    //   199: getfield 490	bdqo:ab	Ljava/lang/String;
    //   202: invokestatic 494	uuc:b	(Ljava/lang/String;)Ljava/lang/String;
    //   205: invokevirtual 474	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   208: pop
    //   209: aload 4
    //   211: aload 6
    //   213: invokevirtual 498	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   216: aload_0
    //   217: getfield 501	bdqo:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   220: ifnull -198 -> 22
    //   223: new 503	ooa
    //   226: dup
    //   227: invokespecial 504	ooa:<init>	()V
    //   230: astore 4
    //   232: aload 4
    //   234: bipush 6
    //   236: putfield 506	ooa:a	I
    //   239: aload 4
    //   241: aload_0
    //   242: getfield 501	bdqo:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   245: getfield 512	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   248: invokestatic 517	onx:a	(Looa;Lcom/tencent/mobileqq/data/MessageRecord;)Looa;
    //   251: astore 4
    //   253: aload_3
    //   254: getstatic 520	com/tencent/mobileqq/app/BusinessHandlerFactory:ESHOP_AD_HANDLER	I
    //   257: invokevirtual 430	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   260: checkcast 514	onx
    //   263: aload 4
    //   265: aconst_null
    //   266: invokevirtual 523	onx:a	(Looa;Ljava/lang/String;)V
    //   269: goto -247 -> 22
    //   272: astore_3
    //   273: goto -251 -> 22
    //   276: iload_2
    //   277: ifne -255 -> 22
    //   280: aload_1
    //   281: ldc_w 289
    //   284: invokevirtual 461	android/view/View:getTag	(I)Ljava/lang/Object;
    //   287: checkcast 367	java/lang/String
    //   290: astore 4
    //   292: aload_1
    //   293: invokevirtual 526	android/view/View:getId	()I
    //   296: ldc_w 527
    //   299: if_icmpne +78 -> 377
    //   302: new 463	android/content/Intent
    //   305: dup
    //   306: invokespecial 528	android/content/Intent:<init>	()V
    //   309: astore 7
    //   311: aload 7
    //   313: ldc_w 530
    //   316: bipush 115
    //   318: invokevirtual 533	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   321: pop
    //   322: aload 7
    //   324: aload_3
    //   325: aload 5
    //   327: aload 4
    //   329: bipush 251
    //   331: invokestatic 536	uuc:a	(Landroid/content/Intent;Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;I)V
    //   334: aload 6
    //   336: ldc_w 537
    //   339: aload_0
    //   340: getfield 501	bdqo:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   343: getfield 540	com/tencent/mobileqq/structmsg/AbsStructMsg:uin	Ljava/lang/String;
    //   346: aload_0
    //   347: getfield 501	bdqo:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   350: getfield 512	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   353: ldc_w 542
    //   356: invokevirtual 547	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   359: aconst_null
    //   360: aconst_null
    //   361: aload 4
    //   363: invokestatic 275	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   366: iconst_0
    //   367: invokevirtual 550	ook:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V
    //   370: goto -348 -> 22
    //   373: astore_3
    //   374: goto -352 -> 22
    //   377: aload_1
    //   378: invokevirtual 526	android/view/View:getId	()I
    //   381: ldc 56
    //   383: if_icmpne -361 -> 22
    //   386: aload_1
    //   387: invokevirtual 179	android/view/View:getTag	()Ljava/lang/Object;
    //   390: checkcast 29	bdqp
    //   393: astore 6
    //   395: aload 6
    //   397: getfield 61	bdqp:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   400: iconst_4
    //   401: invokevirtual 551	android/widget/TextView:setVisibility	(I)V
    //   404: aload 6
    //   406: getfield 65	bdqp:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   409: iconst_0
    //   410: invokevirtual 552	android/view/View:setVisibility	(I)V
    //   413: aload_3
    //   414: aload 5
    //   416: aload 4
    //   418: new 554	bdqq
    //   421: dup
    //   422: aload_0
    //   423: aload 6
    //   425: invokespecial 557	bdqq:<init>	(Lbdqo;Lbdqp;)V
    //   428: iconst_1
    //   429: iconst_3
    //   430: invokestatic 560	uuc:a	(Lcom/tencent/common/app/AppInterface;Landroid/content/Context;Ljava/lang/String;Laoav;ZI)V
    //   433: new 503	ooa
    //   436: dup
    //   437: invokespecial 504	ooa:<init>	()V
    //   440: astore 5
    //   442: aload 5
    //   444: iconst_5
    //   445: putfield 506	ooa:a	I
    //   448: aload 5
    //   450: aload 4
    //   452: invokestatic 275	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   455: putfield 563	ooa:b	J
    //   458: aload 5
    //   460: aload_0
    //   461: getfield 501	bdqo:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   464: getfield 512	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   467: invokestatic 517	onx:a	(Looa;Lcom/tencent/mobileqq/data/MessageRecord;)Looa;
    //   470: astore 4
    //   472: aload_3
    //   473: getstatic 520	com/tencent/mobileqq/app/BusinessHandlerFactory:ESHOP_AD_HANDLER	I
    //   476: invokevirtual 430	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   479: checkcast 514	onx
    //   482: aload 4
    //   484: aconst_null
    //   485: invokevirtual 523	onx:a	(Looa;Ljava/lang/String;)V
    //   488: goto -466 -> 22
    //   491: astore_3
    //   492: goto -470 -> 22
    //   495: astore 4
    //   497: goto -39 -> 458
    //   500: aconst_null
    //   501: astore_3
    //   502: goto -447 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	505	0	this	bdqo
    //   0	505	1	paramView	View
    //   7	270	2	i	int
    //   45	209	3	localObject1	Object
    //   272	53	3	localException1	Exception
    //   373	100	3	localException2	Exception
    //   491	1	3	localException3	Exception
    //   501	1	3	localObject2	Object
    //   12	471	4	localObject3	Object
    //   495	1	4	localException4	Exception
    //   35	424	5	localObject4	Object
    //   69	355	6	localObject5	Object
    //   309	14	7	localIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   216	269	272	java/lang/Exception
    //   334	370	373	java/lang/Exception
    //   433	448	491	java/lang/Exception
    //   458	488	491	java/lang/Exception
    //   448	458	495	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdqo
 * JD-Core Version:    0.7.0.1
 */