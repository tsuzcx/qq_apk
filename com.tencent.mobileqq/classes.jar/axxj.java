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

public class axxj
  extends axuq
{
  String S;
  String T;
  String U;
  String V;
  boolean a;
  
  View a(View paramView, Context paramContext, String paramString)
  {
    axxk localaxxk2;
    try
    {
      i = Integer.parseInt(this.S);
      if (paramView == null)
      {
        axxk localaxxk1 = new axxk(this);
        paramView = View.inflate(paramContext, 2131561492, null);
        localaxxk1.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131370647));
        localaxxk1.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367679));
        localaxxk1.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366512));
        localaxxk1.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369486);
        paramView.setTag(localaxxk1);
        localaxxk1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramString);
        if (i != 1) {
          break label331;
        }
        localaxxk1.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localaxxk1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(Color.parseColor("#777777"));
        localaxxk1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextSize(14.0F);
        localaxxk1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        localaxxk1.jdField_a_of_type_AndroidWidgetTextView.setText(this.U);
        localaxxk1.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        localaxxk1.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(paramContext.getResources().getDrawable(2130839062));
        paramView.setTag(2131373502, this.b);
        localaxxk1.jdField_a_of_type_AndroidWidgetTextView.setTag(2131373502, this.b);
        i = actj.a(17.0F, paramContext.getResources());
        int j = actj.a(16.0F, paramContext.getResources());
        localaxxk1.jdField_a_of_type_AndroidWidgetTextView.setPadding(j, 0, j, 0);
        localaxxk1.jdField_a_of_type_AndroidWidgetTextView.post(new StructMsgItemLayout20.1(this, i, localaxxk1));
        paramView.setOnClickListener(this);
        localaxxk1.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
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
          QLog.e("StructMsgItemLayout20", 1, "content type:" + this.S);
          i = 0;
          continue;
          localaxxk2 = (axxk)paramView.getTag();
        }
      } while (i != 0);
      localaxxk2.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramString = paramContext.getResources().getDrawable(2130839736);
      if (TextUtils.isEmpty(this.T)) {
        break label639;
      }
    }
    int i = actj.a(40.0F, paramContext.getResources());
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramString;
    localURLDrawableOptions.mFailedDrawable = paramString;
    paramString = URLDrawable.getDrawable(this.T, localURLDrawableOptions);
    if (paramString.getStatus() == 2) {
      paramString.restartDownload();
    }
    paramString.setTag(bavw.b(i, i, i / 2));
    paramString.setDecodeHandler(bavw.c);
    localaxxk2.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
    label446:
    if (this.jdField_a_of_type_Boolean)
    {
      paramString = paramContext.getResources().getDrawable(2130841310);
      localaxxk2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding(actj.a(3.0F, paramContext.getResources()));
      paramString.setBounds(0, 0, actj.a(15.0F, paramContext.getResources()), actj.a(15.0F, paramContext.getResources()));
      localaxxk2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, paramString);
      localaxxk2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(Color.parseColor("#000000"));
      localaxxk2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextSize(17.0F);
      localaxxk2.jdField_a_of_type_AndroidWidgetTextView.setTag(localaxxk2);
      if (!((akdh)((BaseActivity)paramContext).app.getManager(56)).a(Long.valueOf(Long.parseLong(this.V)))) {
        break label664;
      }
      localaxxk2.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      localaxxk2.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131714602));
      localaxxk2.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    }
    for (;;)
    {
      label514:
      paramView.setTag(2131373504, this.V);
      localaxxk2.jdField_a_of_type_AndroidWidgetTextView.setTag(2131373504, this.V);
      break;
      label639:
      localaxxk2.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
      break label446;
      localaxxk2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      break label514;
      label664:
      localaxxk2.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(paramContext.getResources().getDrawable(2130839062));
      localaxxk2.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131714608));
      localaxxk2.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    }
  }
  
  void a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.h);
      this.S = localJSONObject.optString("contentType");
      if (localJSONObject.optInt("isCert") == 1) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_Boolean = bool;
        this.T = localJSONObject.optString("faceUrl");
        this.U = localJSONObject.optString("btnText");
        this.V = localJSONObject.optString("puin");
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
  
  public boolean a(axwg paramaxwg)
  {
    super.a(paramaxwg);
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
          axup localaxup = (axup)((Iterator)localObject).next();
          localaxup.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          if ("content".equals(localaxup.jdField_a_of_type_JavaLangString))
          {
            localObject = ((axwr)localaxup).Y;
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
      localObject = (axup)paramBundle.next();
      ((axup)localObject).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (("content".equals(((axup)localObject).jdField_a_of_type_JavaLangString)) && ((localObject instanceof axwr))) {
        paramView.addView(a(null, paramContext, ((axwr)localObject).Y), new LinearLayout.LayoutParams(-1, -2));
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
    //   1: getfield 21	axxj:S	Ljava/lang/String;
    //   4: invokestatic 27	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   7: istore_2
    //   8: aload_1
    //   9: invokevirtual 394	android/view/View:getContext	()Landroid/content/Context;
    //   12: astore 5
    //   14: aload 5
    //   16: instanceof 396
    //   19: ifne +4 -> 23
    //   22: return
    //   23: aload 5
    //   25: checkcast 396	android/support/v4/app/FragmentActivity
    //   28: astore 4
    //   30: aload 5
    //   32: checkcast 396	android/support/v4/app/FragmentActivity
    //   35: invokevirtual 400	android/support/v4/app/FragmentActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   38: astore_3
    //   39: aload_3
    //   40: ifnull +151 -> 191
    //   43: aload_3
    //   44: invokevirtual 405	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull -27 -> 22
    //   52: aload_3
    //   53: bipush 88
    //   55: invokevirtual 408	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtb;
    //   58: checkcast 410	nrf
    //   61: astore 6
    //   63: iload_2
    //   64: iconst_1
    //   65: if_icmpne +148 -> 213
    //   68: aload_1
    //   69: ldc 121
    //   71: invokevirtual 413	android/view/View:getTag	(I)Ljava/lang/Object;
    //   74: checkcast 360	java/lang/String
    //   77: astore_1
    //   78: aload_1
    //   79: invokestatic 187	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   82: ifne -60 -> 22
    //   85: new 415	android/content/Intent
    //   88: dup
    //   89: aload 5
    //   91: ldc_w 417
    //   94: invokespecial 420	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   97: astore 4
    //   99: aload 4
    //   101: ldc_w 422
    //   104: aload_1
    //   105: invokevirtual 426	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   108: pop
    //   109: aload 4
    //   111: ldc_w 428
    //   114: invokestatic 434	java/lang/System:currentTimeMillis	()J
    //   117: invokevirtual 437	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   120: pop
    //   121: aload 4
    //   123: ldc_w 439
    //   126: ldc_w 441
    //   129: invokevirtual 426	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   132: pop
    //   133: aload 5
    //   135: aload 4
    //   137: invokevirtual 445	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   140: aload_0
    //   141: getfield 448	axxj:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   144: ifnull -122 -> 22
    //   147: new 450	nqx
    //   150: dup
    //   151: invokespecial 451	nqx:<init>	()V
    //   154: astore_1
    //   155: aload_1
    //   156: bipush 6
    //   158: putfield 454	nqx:a	I
    //   161: aload_1
    //   162: aload_0
    //   163: getfield 448	axxj:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   166: getfield 460	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   169: invokestatic 465	nqu:a	(Lnqx;Lcom/tencent/mobileqq/data/MessageRecord;)Lnqx;
    //   172: astore_1
    //   173: aload_3
    //   174: sipush 139
    //   177: invokevirtual 408	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtb;
    //   180: checkcast 462	nqu
    //   183: aload_1
    //   184: aconst_null
    //   185: invokevirtual 468	nqu:a	(Lnqx;Ljava/lang/String;)V
    //   188: return
    //   189: astore_1
    //   190: return
    //   191: invokestatic 474	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   194: invokevirtual 478	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   197: astore_3
    //   198: aload_3
    //   199: instanceof 254
    //   202: ifeq +214 -> 416
    //   205: aload_3
    //   206: checkcast 254	com/tencent/mobileqq/app/QQAppInterface
    //   209: astore_3
    //   210: goto -162 -> 48
    //   213: iload_2
    //   214: ifne -192 -> 22
    //   217: aload_1
    //   218: ldc_w 282
    //   221: invokevirtual 413	android/view/View:getTag	(I)Ljava/lang/Object;
    //   224: checkcast 360	java/lang/String
    //   227: astore 5
    //   229: aload_1
    //   230: invokevirtual 481	android/view/View:getId	()I
    //   233: ldc_w 482
    //   236: if_icmpne +71 -> 307
    //   239: new 415	android/content/Intent
    //   242: dup
    //   243: invokespecial 483	android/content/Intent:<init>	()V
    //   246: astore_1
    //   247: aload_1
    //   248: ldc_w 485
    //   251: bipush 115
    //   253: invokevirtual 488	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   256: pop
    //   257: aload_1
    //   258: aload_3
    //   259: aload 4
    //   261: aload 5
    //   263: bipush 251
    //   265: invokestatic 493	sgg:a	(Landroid/content/Intent;Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;I)V
    //   268: aload 6
    //   270: ldc_w 494
    //   273: aload_0
    //   274: getfield 448	axxj:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   277: getfield 497	com/tencent/mobileqq/structmsg/AbsStructMsg:uin	Ljava/lang/String;
    //   280: aload_0
    //   281: getfield 448	axxj:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   284: getfield 460	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   287: ldc_w 499
    //   290: invokevirtual 504	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   293: aconst_null
    //   294: aconst_null
    //   295: aload 5
    //   297: invokestatic 268	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   300: iconst_0
    //   301: invokevirtual 507	nrf:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V
    //   304: return
    //   305: astore_1
    //   306: return
    //   307: aload_1
    //   308: invokevirtual 481	android/view/View:getId	()I
    //   311: ldc 56
    //   313: if_icmpne -291 -> 22
    //   316: aload_1
    //   317: invokevirtual 178	android/view/View:getTag	()Ljava/lang/Object;
    //   320: checkcast 29	axxk
    //   323: astore_1
    //   324: aload_1
    //   325: getfield 61	axxk:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   328: iconst_4
    //   329: invokevirtual 508	android/widget/TextView:setVisibility	(I)V
    //   332: aload_1
    //   333: getfield 65	axxk:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   336: iconst_0
    //   337: invokevirtual 509	android/view/View:setVisibility	(I)V
    //   340: aload_3
    //   341: aload 4
    //   343: aload 5
    //   345: new 511	axxl
    //   348: dup
    //   349: aload_0
    //   350: aload_1
    //   351: invokespecial 514	axxl:<init>	(Laxxj;Laxxk;)V
    //   354: iconst_1
    //   355: iconst_3
    //   356: invokestatic 517	sgg:a	(Lcom/tencent/common/app/AppInterface;Landroid/content/Context;Ljava/lang/String;Lakdn;ZI)V
    //   359: new 450	nqx
    //   362: dup
    //   363: invokespecial 451	nqx:<init>	()V
    //   366: astore_1
    //   367: aload_1
    //   368: iconst_5
    //   369: putfield 454	nqx:a	I
    //   372: aload_1
    //   373: aload 5
    //   375: invokestatic 268	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   378: putfield 520	nqx:b	J
    //   381: aload_1
    //   382: aload_0
    //   383: getfield 448	axxj:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   386: getfield 460	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   389: invokestatic 465	nqu:a	(Lnqx;Lcom/tencent/mobileqq/data/MessageRecord;)Lnqx;
    //   392: astore_1
    //   393: aload_3
    //   394: sipush 139
    //   397: invokevirtual 408	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtb;
    //   400: checkcast 462	nqu
    //   403: aload_1
    //   404: aconst_null
    //   405: invokevirtual 468	nqu:a	(Lnqx;Ljava/lang/String;)V
    //   408: return
    //   409: astore_1
    //   410: return
    //   411: astore 4
    //   413: goto -32 -> 381
    //   416: aconst_null
    //   417: astore_3
    //   418: goto -370 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	0	this	axxj
    //   0	421	1	paramView	View
    //   7	207	2	i	int
    //   38	380	3	localObject1	Object
    //   28	314	4	localObject2	Object
    //   411	1	4	localException	Exception
    //   12	362	5	localObject3	Object
    //   61	208	6	localnrf	nrf
    // Exception table:
    //   from	to	target	type
    //   140	188	189	java/lang/Exception
    //   268	304	305	java/lang/Exception
    //   359	372	409	java/lang/Exception
    //   381	408	409	java/lang/Exception
    //   372	381	411	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axxj
 * JD-Core Version:    0.7.0.1
 */