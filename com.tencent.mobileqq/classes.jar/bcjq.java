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
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout20.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class bcjq
  extends bcgx
{
  boolean a;
  String ac;
  String ad;
  String ae;
  String af;
  
  View a(View paramView, Context paramContext, String paramString)
  {
    bcjr localbcjr2;
    try
    {
      i = Integer.parseInt(this.ac);
      if (paramView == null)
      {
        bcjr localbcjr1 = new bcjr(this);
        paramView = View.inflate(paramContext, 2131561853, null);
        localbcjr1.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131371615));
        localbcjr1.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368236));
        localbcjr1.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366967));
        localbcjr1.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370267);
        paramView.setTag(localbcjr1);
        localbcjr1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramString);
        if (i != 1) {
          break label331;
        }
        localbcjr1.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localbcjr1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(Color.parseColor("#777777"));
        localbcjr1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextSize(14.0F);
        localbcjr1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        localbcjr1.jdField_a_of_type_AndroidWidgetTextView.setText(this.ae);
        localbcjr1.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        localbcjr1.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(paramContext.getResources().getDrawable(2130839362));
        paramView.setTag(2131374629, this.b);
        localbcjr1.jdField_a_of_type_AndroidWidgetTextView.setTag(2131374629, this.b);
        i = AIOUtils.dp2px(17.0F, paramContext.getResources());
        int j = AIOUtils.dp2px(16.0F, paramContext.getResources());
        localbcjr1.jdField_a_of_type_AndroidWidgetTextView.setPadding(j, 0, j, 0);
        localbcjr1.jdField_a_of_type_AndroidWidgetTextView.post(new StructMsgItemLayout20.1(this, i, localbcjr1));
        paramView.setOnClickListener(this);
        localbcjr1.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
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
          localbcjr2 = (bcjr)paramView.getTag();
        }
      } while (i != 0);
      localbcjr2.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramString = paramContext.getResources().getDrawable(2130840312);
      if (TextUtils.isEmpty(this.ad)) {
        break label639;
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
    paramString.setTag(bfol.b(i, i, i / 2));
    paramString.setDecodeHandler(bfol.c);
    localbcjr2.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
    label446:
    if (this.jdField_a_of_type_Boolean)
    {
      paramString = paramContext.getResources().getDrawable(2130841793);
      localbcjr2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding(AIOUtils.dp2px(3.0F, paramContext.getResources()));
      paramString.setBounds(0, 0, AIOUtils.dp2px(15.0F, paramContext.getResources()), AIOUtils.dp2px(15.0F, paramContext.getResources()));
      localbcjr2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, paramString);
      localbcjr2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(Color.parseColor("#000000"));
      localbcjr2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextSize(17.0F);
      localbcjr2.jdField_a_of_type_AndroidWidgetTextView.setTag(localbcjr2);
      if (!((amxz)((BaseActivity)paramContext).app.getManager(56)).a(Long.valueOf(Long.parseLong(this.af)))) {
        break label664;
      }
      localbcjr2.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      localbcjr2.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131713628));
      localbcjr2.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    }
    for (;;)
    {
      label514:
      paramView.setTag(2131374631, this.af);
      localbcjr2.jdField_a_of_type_AndroidWidgetTextView.setTag(2131374631, this.af);
      break;
      label639:
      localbcjr2.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
      break label446;
      localbcjr2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      break label514;
      label664:
      localbcjr2.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(paramContext.getResources().getDrawable(2130839362));
      localbcjr2.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131713634));
      localbcjr2.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
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
  
  public boolean a(bcin parambcin)
  {
    super.a(parambcin);
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
          bcgw localbcgw = (bcgw)((Iterator)localObject).next();
          localbcgw.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          if ("content".equals(localbcgw.jdField_a_of_type_JavaLangString))
          {
            localObject = ((bciy)localbcgw).ai;
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
      localObject = (bcgw)paramBundle.next();
      ((bcgw)localObject).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (("content".equals(((bcgw)localObject).jdField_a_of_type_JavaLangString)) && ((localObject instanceof bciy))) {
        paramView.addView(a(null, paramContext, ((bciy)localObject).ai), new LinearLayout.LayoutParams(-1, -2));
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
    //   1: getfield 21	bcjq:ac	Ljava/lang/String;
    //   4: invokestatic 27	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   7: istore_2
    //   8: aload_1
    //   9: invokevirtual 395	android/view/View:getContext	()Landroid/content/Context;
    //   12: astore 4
    //   14: aload 4
    //   16: instanceof 397
    //   19: ifne +11 -> 30
    //   22: invokestatic 403	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
    //   25: aload_1
    //   26: invokevirtual 406	com/tencent/qqlive/module/videoreport/collect/EventCollector:onViewClicked	(Landroid/view/View;)V
    //   29: return
    //   30: aload 4
    //   32: checkcast 397	android/support/v4/app/FragmentActivity
    //   35: astore 5
    //   37: aload 4
    //   39: checkcast 397	android/support/v4/app/FragmentActivity
    //   42: invokevirtual 410	android/support/v4/app/FragmentActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   45: astore_3
    //   46: aload_3
    //   47: ifnull +66 -> 113
    //   50: aload_3
    //   51: invokevirtual 415	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnull -34 -> 22
    //   59: aload_3
    //   60: bipush 88
    //   62: invokevirtual 419	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   65: checkcast 421	ogr
    //   68: astore 6
    //   70: iload_2
    //   71: iconst_1
    //   72: if_icmpne +202 -> 274
    //   75: aload_0
    //   76: getfield 424	bcjq:Y	Ljava/lang/String;
    //   79: invokestatic 429	ofx:b	(Ljava/lang/String;)Z
    //   82: ifeq +53 -> 135
    //   85: aload_3
    //   86: bipush 88
    //   88: invokevirtual 259	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   91: checkcast 426	ofx
    //   94: astore_3
    //   95: aload_3
    //   96: ifnull -74 -> 22
    //   99: aload_3
    //   100: aload_0
    //   101: aload 4
    //   103: checkcast 431	android/app/Activity
    //   106: invokevirtual 434	ofx:a	(Lbcgw;Landroid/app/Activity;)Z
    //   109: pop
    //   110: goto -88 -> 22
    //   113: invokestatic 440	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   116: invokevirtual 444	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   119: astore_3
    //   120: aload_3
    //   121: instanceof 255
    //   124: ifeq +374 -> 498
    //   127: aload_3
    //   128: checkcast 255	com/tencent/mobileqq/app/QQAppInterface
    //   131: astore_3
    //   132: goto -77 -> 55
    //   135: aload_1
    //   136: ldc 121
    //   138: invokevirtual 447	android/view/View:getTag	(I)Ljava/lang/Object;
    //   141: checkcast 361	java/lang/String
    //   144: astore 5
    //   146: aload 5
    //   148: invokestatic 188	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   151: ifne -129 -> 22
    //   154: new 449	android/content/Intent
    //   157: dup
    //   158: aload 4
    //   160: ldc_w 451
    //   163: invokespecial 454	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   166: astore 6
    //   168: aload 6
    //   170: ldc_w 456
    //   173: aload 5
    //   175: invokevirtual 460	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   178: pop
    //   179: aload 6
    //   181: ldc_w 462
    //   184: invokestatic 468	java/lang/System:currentTimeMillis	()J
    //   187: invokevirtual 471	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   190: pop
    //   191: aload 6
    //   193: ldc_w 473
    //   196: aload_0
    //   197: getfield 476	bcjq:ab	Ljava/lang/String;
    //   200: invokestatic 480	ugf:b	(Ljava/lang/String;)Ljava/lang/String;
    //   203: invokevirtual 460	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   206: pop
    //   207: aload 4
    //   209: aload 6
    //   211: invokevirtual 484	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   214: aload_0
    //   215: getfield 487	bcjq:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   218: ifnull -196 -> 22
    //   221: new 489	ogh
    //   224: dup
    //   225: invokespecial 490	ogh:<init>	()V
    //   228: astore 4
    //   230: aload 4
    //   232: bipush 6
    //   234: putfield 493	ogh:a	I
    //   237: aload 4
    //   239: aload_0
    //   240: getfield 487	bcjq:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   243: getfield 499	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   246: invokestatic 504	oge:a	(Logh;Lcom/tencent/mobileqq/data/MessageRecord;)Logh;
    //   249: astore 4
    //   251: aload_3
    //   252: sipush 139
    //   255: invokevirtual 419	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   258: checkcast 501	oge
    //   261: aload 4
    //   263: aconst_null
    //   264: invokevirtual 507	oge:a	(Logh;Ljava/lang/String;)V
    //   267: goto -245 -> 22
    //   270: astore_3
    //   271: goto -249 -> 22
    //   274: iload_2
    //   275: ifne -253 -> 22
    //   278: aload_1
    //   279: ldc_w 283
    //   282: invokevirtual 447	android/view/View:getTag	(I)Ljava/lang/Object;
    //   285: checkcast 361	java/lang/String
    //   288: astore 4
    //   290: aload_1
    //   291: invokevirtual 510	android/view/View:getId	()I
    //   294: ldc_w 511
    //   297: if_icmpne +78 -> 375
    //   300: new 449	android/content/Intent
    //   303: dup
    //   304: invokespecial 512	android/content/Intent:<init>	()V
    //   307: astore 7
    //   309: aload 7
    //   311: ldc_w 514
    //   314: bipush 115
    //   316: invokevirtual 517	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   319: pop
    //   320: aload 7
    //   322: aload_3
    //   323: aload 5
    //   325: aload 4
    //   327: bipush 251
    //   329: invokestatic 520	ugf:a	(Landroid/content/Intent;Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;I)V
    //   332: aload 6
    //   334: ldc_w 521
    //   337: aload_0
    //   338: getfield 487	bcjq:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   341: getfield 524	com/tencent/mobileqq/structmsg/AbsStructMsg:uin	Ljava/lang/String;
    //   344: aload_0
    //   345: getfield 487	bcjq:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   348: getfield 499	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   351: ldc_w 526
    //   354: invokevirtual 531	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   357: aconst_null
    //   358: aconst_null
    //   359: aload 4
    //   361: invokestatic 269	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   364: iconst_0
    //   365: invokevirtual 534	ogr:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V
    //   368: goto -346 -> 22
    //   371: astore_3
    //   372: goto -350 -> 22
    //   375: aload_1
    //   376: invokevirtual 510	android/view/View:getId	()I
    //   379: ldc 56
    //   381: if_icmpne -359 -> 22
    //   384: aload_1
    //   385: invokevirtual 179	android/view/View:getTag	()Ljava/lang/Object;
    //   388: checkcast 29	bcjr
    //   391: astore 6
    //   393: aload 6
    //   395: getfield 61	bcjr:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   398: iconst_4
    //   399: invokevirtual 535	android/widget/TextView:setVisibility	(I)V
    //   402: aload 6
    //   404: getfield 65	bcjr:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   407: iconst_0
    //   408: invokevirtual 536	android/view/View:setVisibility	(I)V
    //   411: aload_3
    //   412: aload 5
    //   414: aload 4
    //   416: new 538	bcjs
    //   419: dup
    //   420: aload_0
    //   421: aload 6
    //   423: invokespecial 541	bcjs:<init>	(Lbcjq;Lbcjr;)V
    //   426: iconst_1
    //   427: iconst_3
    //   428: invokestatic 544	ugf:a	(Lcom/tencent/common/app/AppInterface;Landroid/content/Context;Ljava/lang/String;Lamyh;ZI)V
    //   431: new 489	ogh
    //   434: dup
    //   435: invokespecial 490	ogh:<init>	()V
    //   438: astore 5
    //   440: aload 5
    //   442: iconst_5
    //   443: putfield 493	ogh:a	I
    //   446: aload 5
    //   448: aload 4
    //   450: invokestatic 269	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   453: putfield 547	ogh:b	J
    //   456: aload 5
    //   458: aload_0
    //   459: getfield 487	bcjq:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   462: getfield 499	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   465: invokestatic 504	oge:a	(Logh;Lcom/tencent/mobileqq/data/MessageRecord;)Logh;
    //   468: astore 4
    //   470: aload_3
    //   471: sipush 139
    //   474: invokevirtual 419	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   477: checkcast 501	oge
    //   480: aload 4
    //   482: aconst_null
    //   483: invokevirtual 507	oge:a	(Logh;Ljava/lang/String;)V
    //   486: goto -464 -> 22
    //   489: astore_3
    //   490: goto -468 -> 22
    //   493: astore 4
    //   495: goto -39 -> 456
    //   498: aconst_null
    //   499: astore_3
    //   500: goto -445 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	503	0	this	bcjq
    //   0	503	1	paramView	View
    //   7	268	2	i	int
    //   45	207	3	localObject1	Object
    //   270	53	3	localException1	Exception
    //   371	100	3	localException2	Exception
    //   489	1	3	localException3	Exception
    //   499	1	3	localObject2	Object
    //   12	469	4	localObject3	Object
    //   493	1	4	localException4	Exception
    //   35	422	5	localObject4	Object
    //   68	354	6	localObject5	Object
    //   307	14	7	localIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   214	267	270	java/lang/Exception
    //   332	368	371	java/lang/Exception
    //   431	446	489	java/lang/Exception
    //   456	486	489	java/lang/Exception
    //   446	456	493	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjq
 * JD-Core Version:    0.7.0.1
 */