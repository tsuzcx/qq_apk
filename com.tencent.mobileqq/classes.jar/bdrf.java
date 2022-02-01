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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout20.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class bdrf
  extends bdom
{
  boolean a;
  String ac;
  String ad;
  String ae;
  String af;
  
  View a(View paramView, Context paramContext, String paramString)
  {
    bdrg localbdrg2;
    try
    {
      i = Integer.parseInt(this.ac);
      if (paramView == null)
      {
        bdrg localbdrg1 = new bdrg(this);
        paramView = View.inflate(paramContext, 2131561976, null);
        localbdrg1.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131371647));
        localbdrg1.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368212));
        localbdrg1.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366946));
        localbdrg1.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370299);
        paramView.setTag(localbdrg1);
        localbdrg1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramString);
        if (i != 1) {
          break label331;
        }
        localbdrg1.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localbdrg1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(Color.parseColor("#777777"));
        localbdrg1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextSize(14.0F);
        localbdrg1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        localbdrg1.jdField_a_of_type_AndroidWidgetTextView.setText(this.ae);
        localbdrg1.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        localbdrg1.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(paramContext.getResources().getDrawable(2130839327));
        paramView.setTag(2131374864, this.b);
        localbdrg1.jdField_a_of_type_AndroidWidgetTextView.setTag(2131374864, this.b);
        i = agej.a(17.0F, paramContext.getResources());
        int j = agej.a(16.0F, paramContext.getResources());
        localbdrg1.jdField_a_of_type_AndroidWidgetTextView.setPadding(j, 0, j, 0);
        localbdrg1.jdField_a_of_type_AndroidWidgetTextView.post(new StructMsgItemLayout20.1(this, i, localbdrg1));
        paramView.setOnClickListener(this);
        localbdrg1.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
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
          localbdrg2 = (bdrg)paramView.getTag();
        }
      } while (i != 0);
      localbdrg2.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramString = paramContext.getResources().getDrawable(2130840274);
      if (TextUtils.isEmpty(this.ad)) {
        break label639;
      }
    }
    int i = agej.a(40.0F, paramContext.getResources());
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramString;
    localURLDrawableOptions.mFailedDrawable = paramString;
    paramString = URLDrawable.getDrawable(this.ad, localURLDrawableOptions);
    if (paramString.getStatus() == 2) {
      paramString.restartDownload();
    }
    paramString.setTag(bhez.b(i, i, i / 2));
    paramString.setDecodeHandler(bhez.c);
    localbdrg2.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
    label446:
    if (this.jdField_a_of_type_Boolean)
    {
      paramString = paramContext.getResources().getDrawable(2130841751);
      localbdrg2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding(agej.a(3.0F, paramContext.getResources()));
      paramString.setBounds(0, 0, agej.a(15.0F, paramContext.getResources()), agej.a(15.0F, paramContext.getResources()));
      localbdrg2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, paramString);
      localbdrg2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(Color.parseColor("#000000"));
      localbdrg2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextSize(17.0F);
      localbdrg2.jdField_a_of_type_AndroidWidgetTextView.setTag(localbdrg2);
      if (!((aody)((BaseActivity)paramContext).app.getManager(56)).a(Long.valueOf(Long.parseLong(this.af)))) {
        break label664;
      }
      localbdrg2.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      localbdrg2.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131713396));
      localbdrg2.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    }
    for (;;)
    {
      label514:
      paramView.setTag(2131374866, this.af);
      localbdrg2.jdField_a_of_type_AndroidWidgetTextView.setTag(2131374866, this.af);
      break;
      label639:
      localbdrg2.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
      break label446;
      localbdrg2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      break label514;
      label664:
      localbdrg2.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(paramContext.getResources().getDrawable(2130839327));
      localbdrg2.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131713402));
      localbdrg2.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
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
  
  public boolean a(bdqc parambdqc)
  {
    super.a(parambdqc);
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
          bdol localbdol = (bdol)((Iterator)localObject).next();
          localbdol.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          if ("content".equals(localbdol.jdField_a_of_type_JavaLangString))
          {
            localObject = ((bdqn)localbdol).ai;
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
      localObject = (bdol)paramBundle.next();
      ((bdol)localObject).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (("content".equals(((bdol)localObject).jdField_a_of_type_JavaLangString)) && ((localObject instanceof bdqn))) {
        paramView.addView(a(null, paramContext, ((bdqn)localObject).ai), new LinearLayout.LayoutParams(-1, -2));
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
    //   1: getfield 21	bdrf:ac	Ljava/lang/String;
    //   4: invokestatic 27	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   7: istore_2
    //   8: aload_1
    //   9: invokevirtual 394	android/view/View:getContext	()Landroid/content/Context;
    //   12: astore 5
    //   14: aload 5
    //   16: instanceof 396
    //   19: ifne +11 -> 30
    //   22: invokestatic 402	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
    //   25: aload_1
    //   26: invokevirtual 405	com/tencent/qqlive/module/videoreport/collect/EventCollector:onViewClicked	(Landroid/view/View;)V
    //   29: return
    //   30: aload 5
    //   32: checkcast 396	android/support/v4/app/FragmentActivity
    //   35: astore 4
    //   37: aload 5
    //   39: checkcast 396	android/support/v4/app/FragmentActivity
    //   42: invokevirtual 409	android/support/v4/app/FragmentActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   45: astore_3
    //   46: aload_3
    //   47: ifnull +163 -> 210
    //   50: aload_3
    //   51: invokevirtual 414	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnull -34 -> 22
    //   59: aload_3
    //   60: bipush 88
    //   62: invokevirtual 417	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lanud;
    //   65: checkcast 419	ofe
    //   68: astore 6
    //   70: iload_2
    //   71: iconst_1
    //   72: if_icmpne +160 -> 232
    //   75: aload_1
    //   76: ldc 121
    //   78: invokevirtual 422	android/view/View:getTag	(I)Ljava/lang/Object;
    //   81: checkcast 360	java/lang/String
    //   84: astore 4
    //   86: aload 4
    //   88: invokestatic 187	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   91: ifne -69 -> 22
    //   94: new 424	android/content/Intent
    //   97: dup
    //   98: aload 5
    //   100: ldc_w 426
    //   103: invokespecial 429	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   106: astore 6
    //   108: aload 6
    //   110: ldc_w 431
    //   113: aload 4
    //   115: invokevirtual 435	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   118: pop
    //   119: aload 6
    //   121: ldc_w 437
    //   124: invokestatic 443	java/lang/System:currentTimeMillis	()J
    //   127: invokevirtual 446	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   130: pop
    //   131: aload 6
    //   133: ldc_w 448
    //   136: ldc_w 450
    //   139: invokevirtual 435	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   142: pop
    //   143: aload 5
    //   145: aload 6
    //   147: invokevirtual 454	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   150: aload_0
    //   151: getfield 457	bdrf:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   154: ifnull -132 -> 22
    //   157: new 459	oeu
    //   160: dup
    //   161: invokespecial 460	oeu:<init>	()V
    //   164: astore 4
    //   166: aload 4
    //   168: bipush 6
    //   170: putfield 463	oeu:a	I
    //   173: aload 4
    //   175: aload_0
    //   176: getfield 457	bdrf:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   179: getfield 469	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   182: invokestatic 474	oer:a	(Loeu;Lcom/tencent/mobileqq/data/MessageRecord;)Loeu;
    //   185: astore 4
    //   187: aload_3
    //   188: sipush 139
    //   191: invokevirtual 417	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lanud;
    //   194: checkcast 471	oer
    //   197: aload 4
    //   199: aconst_null
    //   200: invokevirtual 477	oer:a	(Loeu;Ljava/lang/String;)V
    //   203: goto -181 -> 22
    //   206: astore_3
    //   207: goto -185 -> 22
    //   210: invokestatic 483	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   213: invokevirtual 487	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   216: astore_3
    //   217: aload_3
    //   218: instanceof 254
    //   221: ifeq +235 -> 456
    //   224: aload_3
    //   225: checkcast 254	com/tencent/mobileqq/app/QQAppInterface
    //   228: astore_3
    //   229: goto -174 -> 55
    //   232: iload_2
    //   233: ifne -211 -> 22
    //   236: aload_1
    //   237: ldc_w 282
    //   240: invokevirtual 422	android/view/View:getTag	(I)Ljava/lang/Object;
    //   243: checkcast 360	java/lang/String
    //   246: astore 5
    //   248: aload_1
    //   249: invokevirtual 490	android/view/View:getId	()I
    //   252: ldc_w 491
    //   255: if_icmpne +78 -> 333
    //   258: new 424	android/content/Intent
    //   261: dup
    //   262: invokespecial 492	android/content/Intent:<init>	()V
    //   265: astore 7
    //   267: aload 7
    //   269: ldc_w 494
    //   272: bipush 115
    //   274: invokevirtual 497	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   277: pop
    //   278: aload 7
    //   280: aload_3
    //   281: aload 4
    //   283: aload 5
    //   285: bipush 251
    //   287: invokestatic 502	tzq:a	(Landroid/content/Intent;Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;I)V
    //   290: aload 6
    //   292: ldc_w 503
    //   295: aload_0
    //   296: getfield 457	bdrf:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   299: getfield 506	com/tencent/mobileqq/structmsg/AbsStructMsg:uin	Ljava/lang/String;
    //   302: aload_0
    //   303: getfield 457	bdrf:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   306: getfield 469	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   309: ldc_w 508
    //   312: invokevirtual 513	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   315: aconst_null
    //   316: aconst_null
    //   317: aload 5
    //   319: invokestatic 268	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   322: iconst_0
    //   323: invokevirtual 516	ofe:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V
    //   326: goto -304 -> 22
    //   329: astore_3
    //   330: goto -308 -> 22
    //   333: aload_1
    //   334: invokevirtual 490	android/view/View:getId	()I
    //   337: ldc 56
    //   339: if_icmpne -317 -> 22
    //   342: aload_1
    //   343: invokevirtual 178	android/view/View:getTag	()Ljava/lang/Object;
    //   346: checkcast 29	bdrg
    //   349: astore 6
    //   351: aload 6
    //   353: getfield 61	bdrg:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   356: iconst_4
    //   357: invokevirtual 517	android/widget/TextView:setVisibility	(I)V
    //   360: aload 6
    //   362: getfield 65	bdrg:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   365: iconst_0
    //   366: invokevirtual 518	android/view/View:setVisibility	(I)V
    //   369: aload_3
    //   370: aload 4
    //   372: aload 5
    //   374: new 520	bdrh
    //   377: dup
    //   378: aload_0
    //   379: aload 6
    //   381: invokespecial 523	bdrh:<init>	(Lbdrf;Lbdrg;)V
    //   384: iconst_1
    //   385: iconst_3
    //   386: invokestatic 526	tzq:a	(Lcom/tencent/common/app/AppInterface;Landroid/content/Context;Ljava/lang/String;Laoeg;ZI)V
    //   389: new 459	oeu
    //   392: dup
    //   393: invokespecial 460	oeu:<init>	()V
    //   396: astore 4
    //   398: aload 4
    //   400: iconst_5
    //   401: putfield 463	oeu:a	I
    //   404: aload 4
    //   406: aload 5
    //   408: invokestatic 268	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   411: putfield 529	oeu:b	J
    //   414: aload 4
    //   416: aload_0
    //   417: getfield 457	bdrf:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   420: getfield 469	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   423: invokestatic 474	oer:a	(Loeu;Lcom/tencent/mobileqq/data/MessageRecord;)Loeu;
    //   426: astore 4
    //   428: aload_3
    //   429: sipush 139
    //   432: invokevirtual 417	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lanud;
    //   435: checkcast 471	oer
    //   438: aload 4
    //   440: aconst_null
    //   441: invokevirtual 477	oer:a	(Loeu;Ljava/lang/String;)V
    //   444: goto -422 -> 22
    //   447: astore_3
    //   448: goto -426 -> 22
    //   451: astore 5
    //   453: goto -39 -> 414
    //   456: aconst_null
    //   457: astore_3
    //   458: goto -403 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	461	0	this	bdrf
    //   0	461	1	paramView	View
    //   7	226	2	i	int
    //   45	143	3	localObject1	Object
    //   206	1	3	localException1	Exception
    //   216	65	3	localObject2	Object
    //   329	100	3	localException2	Exception
    //   447	1	3	localException3	Exception
    //   457	1	3	localObject3	Object
    //   35	404	4	localObject4	Object
    //   12	395	5	localObject5	Object
    //   451	1	5	localException4	Exception
    //   68	312	6	localObject6	Object
    //   265	14	7	localIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   150	203	206	java/lang/Exception
    //   290	326	329	java/lang/Exception
    //   389	404	447	java/lang/Exception
    //   414	444	447	java/lang/Exception
    //   404	414	451	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdrf
 * JD-Core Version:    0.7.0.1
 */