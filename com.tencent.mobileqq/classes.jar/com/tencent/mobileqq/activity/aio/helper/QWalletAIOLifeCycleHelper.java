package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.copyprompt.CopyPromptHelper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class QWalletAIOLifeCycleHelper
  implements ILifeCycleHelper
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private PasswdRedBagManager jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private TextView c;
  
  public QWalletAIOLifeCycleHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager = ((PasswdRedBagManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER));
  }
  
  private static String a(int paramInt)
  {
    String str = "";
    if (paramInt == 0) {
      str = HardCodeUtil.a(2131711138);
    }
    do
    {
      return str;
      if (paramInt == 1) {
        return HardCodeUtil.a(2131720673);
      }
    } while (paramInt != 2);
    return HardCodeUtil.a(2131720675);
  }
  
  private void a(String paramString1, String paramString2, int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      paramString1 = a(paramInt);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
    }
    if (this.c != null)
    {
      this.c.setVisibility(0);
      if (paramInt != 0) {
        break label231;
      }
      this.c.setText(HardCodeUtil.a(2131720678));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_a_of_type_AndroidWidgetTextView);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_b_of_type_AndroidWidgetTextView);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, 0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, 2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.bringToFront();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramOnClickListener);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
        ((CopyPromptHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(19)).a();
      }
      return;
      label231:
      if (paramInt == 1) {
        this.c.setText(HardCodeUtil.a(2131720672));
      } else if (paramInt == 2) {
        this.c.setText(HardCodeUtil.a(2131720674));
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString3);
    }
    if (this.c != null) {
      this.c.setVisibility(8);
    }
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_b_of_type_AndroidWidgetTextView);
      if (!paramBoolean) {
        break label205;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, 0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, 2);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.bringToFront();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramOnClickListener);
      ((CopyPromptHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(19)).a();
      return;
      label205:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, 0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, 2);
    }
  }
  
  private Object[] a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object[] arrayOfObject;
    do
    {
      return null;
      if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
        for (arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangString, paramInt); (arrayOfObject != null) && (((Integer)arrayOfObject[0]).intValue() == 1); arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, paramInt))
        {
          this.jdField_a_of_type_JavaLangString = "";
          this.jdField_b_of_type_JavaLangString = "";
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().sendEmptyMessage(12);
          if (!QLog.isColorLevel()) {
            break;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString.charAt(0));
          localStringBuilder.append("|");
          localStringBuilder.append(paramString.length());
          QLog.d("PasswdRedBagManager", 2, "passwdredbags result[0]=" + arrayOfObject[0] + ",result[1]=" + arrayOfObject[1] + ",send str=" + localStringBuilder.toString());
          return arrayOfObject;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont search passwdredbags");
    return null;
    return arrayOfObject;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Int = paramInt;
    }
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Int - paramInt > 5)) {
      a();
    }
  }
  
  public void a(Editable paramEditable)
  {
    if ((paramEditable != null) && (paramEditable.toString().equals(this.jdField_b_of_type_JavaLangString))) {
      a();
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (!StringUtil.a(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramString))) {
      a();
    }
  }
  
  public void a(String paramString, ChatActivityFacade.SendMsgParams paramSendMsgParams, int paramInt)
  {
    paramString = a(paramString, paramInt);
    if ((paramString != null) && (paramString.length == 4))
    {
      paramSendMsgParams.f = ((Integer)paramString[0]).intValue();
      paramSendMsgParams.jdField_d_of_type_Long = ((Long)paramString[1]).longValue();
      if ((paramString[2] != null) && (PasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        paramSendMsgParams.c = ((String)paramString[2]);
        paramSendMsgParams.jdField_d_of_type_JavaLangString = ((String)paramString[3]);
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager = ((PasswdRedBagManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER));
        paramSendMsgParams.e = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramSendMsgParams.c, paramSendMsgParams.jdField_d_of_type_JavaLangString).booleanValue();
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, String.format("Send, get RedBagId, friendUin: %s, senderUin: %d, redBagFlag: %d, foldFlag: %s, redBagId: %s, redBagIndex: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Long.valueOf(paramSendMsgParams.jdField_d_of_type_Long), Integer.valueOf(paramSendMsgParams.f), Boolean.valueOf(paramSendMsgParams.e), paramSendMsgParams.c, paramSendMsgParams.jdField_d_of_type_JavaLangString }));
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (!StringUtil.a(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramString1)))
    {
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    QWalletAIOLifeCycleHelper.2 local2 = new QWalletAIOLifeCycleHelper.2(this);
    if (paramInt == 3)
    {
      a(paramString1, PasswdRedBagManager.b(paramString2), "回复下一句参与接龙", local2, true);
      return;
    }
    a(paramString1, PasswdRedBagManager.a(paramString2), paramInt, local2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, paramString2, paramString3, new QWalletAIOLifeCycleHelper.1(this, paramString1, paramString2), false);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals("0"))) {
      a();
    }
  }
  
  public String getTag()
  {
    return "QWalletAIOLifeCycleHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 8, 14, 6, 10 };
  }
  
  /* Error */
  public void onMoveToState(int paramInt)
  {
    // Byte code:
    //   0: iload_1
    //   1: bipush 8
    //   3: if_icmpne +441 -> 444
    //   6: aload_0
    //   7: getfield 61	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager	Lcom/tencent/mobileqq/activity/qwallet/PasswdRedBagManager;
    //   10: ifnull +48 -> 58
    //   13: aload_0
    //   14: getfield 61	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager	Lcom/tencent/mobileqq/activity/qwallet/PasswdRedBagManager;
    //   17: getfield 340	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager:jdField_a_of_type_Boolean	Z
    //   20: ifeq +38 -> 58
    //   23: aload_0
    //   24: getfield 46	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   27: getfield 269	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   30: iconst_1
    //   31: if_icmpeq +16 -> 47
    //   34: aload_0
    //   35: getfield 46	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   38: getfield 269	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   41: sipush 1004
    //   44: if_icmpne +14 -> 58
    //   47: aload_0
    //   48: getfield 61	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager	Lcom/tencent/mobileqq/activity/qwallet/PasswdRedBagManager;
    //   51: aload_0
    //   52: getfield 46	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   55: invokevirtual 343	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager:a	(Lcom/tencent/mobileqq/activity/aio/SessionInfo;)V
    //   58: aload_0
    //   59: aload_0
    //   60: getfield 30	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   63: getfield 346	com/tencent/mobileqq/activity/aio/core/BaseChatPie:c	Landroid/view/ViewGroup;
    //   66: ldc_w 347
    //   69: invokevirtual 353	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   72: checkcast 104	android/widget/TextView
    //   75: putfield 102	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   78: aload_0
    //   79: new 104	android/widget/TextView
    //   82: dup
    //   83: aload_0
    //   84: getfield 38	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   87: invokespecial 356	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   90: putfield 113	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:c	Landroid/widget/TextView;
    //   93: aload_0
    //   94: getfield 113	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:c	Landroid/widget/TextView;
    //   97: ldc_w 357
    //   100: invokevirtual 360	android/widget/TextView:setTextColor	(I)V
    //   103: aload_0
    //   104: getfield 113	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:c	Landroid/widget/TextView;
    //   107: iconst_1
    //   108: ldc_w 361
    //   111: invokevirtual 365	android/widget/TextView:setTextSize	(IF)V
    //   114: aload_0
    //   115: aload_0
    //   116: getfield 30	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   119: getfield 346	com/tencent/mobileqq/activity/aio/core/BaseChatPie:c	Landroid/view/ViewGroup;
    //   122: ldc_w 366
    //   125: invokevirtual 353	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   128: checkcast 104	android/widget/TextView
    //   131: putfield 110	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   134: aload_0
    //   135: getfield 102	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   138: invokevirtual 370	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   141: ldc_w 371
    //   144: invokestatic 73	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   147: invokevirtual 377	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   150: fstore_2
    //   151: aload_0
    //   152: getfield 102	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   155: fload_2
    //   156: ldc_w 378
    //   159: fmul
    //   160: ldc_w 379
    //   163: fadd
    //   164: f2i
    //   165: invokevirtual 382	android/widget/TextView:setMaxWidth	(I)V
    //   168: aload_0
    //   169: aload_0
    //   170: getfield 30	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   173: getfield 346	com/tencent/mobileqq/activity/aio/core/BaseChatPie:c	Landroid/view/ViewGroup;
    //   176: ldc_w 383
    //   179: invokevirtual 353	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   182: putfield 94	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   185: aload_0
    //   186: aload_0
    //   187: getfield 30	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   190: getfield 346	com/tencent/mobileqq/activity/aio/core/BaseChatPie:c	Landroid/view/ViewGroup;
    //   193: ldc_w 384
    //   196: invokevirtual 353	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   199: checkcast 119	android/widget/LinearLayout
    //   202: putfield 117	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   205: aload_0
    //   206: getfield 117	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   209: aload_0
    //   210: getfield 113	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:c	Landroid/widget/TextView;
    //   213: invokevirtual 386	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   216: aload_0
    //   217: getfield 113	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:c	Landroid/widget/TextView;
    //   220: invokevirtual 390	android/widget/TextView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   223: bipush 254
    //   225: putfield 395	android/view/ViewGroup$LayoutParams:width	I
    //   228: aload_0
    //   229: getfield 113	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:c	Landroid/widget/TextView;
    //   232: invokevirtual 390	android/widget/TextView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   235: bipush 254
    //   237: putfield 398	android/view/ViewGroup$LayoutParams:height	I
    //   240: aload_0
    //   241: getfield 30	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   244: instanceof 400
    //   247: ifeq +42 -> 289
    //   250: ldc_w 402
    //   253: aload_0
    //   254: getfield 30	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   257: getfield 45	com/tencent/mobileqq/activity/aio/core/BaseChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   260: getfield 163	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   263: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   266: ifeq +86 -> 352
    //   269: ldc_w 404
    //   272: invokestatic 410	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   275: checkcast 404	com/tencent/mobileqq/qqfloatingwindow/IQQFloatingWindowBroadcast
    //   278: invokestatic 416	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   281: iconst_0
    //   282: bipush 54
    //   284: invokeinterface 420 4 0
    //   289: return
    //   290: astore_3
    //   291: ldc_w 334
    //   294: iconst_1
    //   295: new 191	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   302: ldc_w 422
    //   305: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_3
    //   309: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 424	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: goto -260 -> 58
    //   321: astore_3
    //   322: ldc_w 334
    //   325: iconst_1
    //   326: new 191	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   333: ldc_w 426
    //   336: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: aload_3
    //   340: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 424	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: goto -109 -> 240
    //   352: ldc_w 428
    //   355: aload_0
    //   356: getfield 30	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   359: getfield 45	com/tencent/mobileqq/activity/aio/core/BaseChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   362: getfield 163	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   365: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   368: ifeq -79 -> 289
    //   371: aload_0
    //   372: getfield 35	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   375: getstatic 431	com/tencent/mobileqq/app/QQManagerFactory:QWALLET_GDT_AD_MANAGER	I
    //   378: invokevirtual 57	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   381: checkcast 433	com/tencent/mobileqq/activity/qwallet/QWalletGdtAdManager
    //   384: aload_0
    //   385: getfield 43	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   388: checkcast 435	com/tencent/mobileqq/app/BaseActivity
    //   391: aload_0
    //   392: getfield 30	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   395: invokevirtual 438	com/tencent/mobileqq/activity/qwallet/QWalletGdtAdManager:a	(Lcom/tencent/mobileqq/app/BaseActivity;Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;)V
    //   398: aload_0
    //   399: getfield 35	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   402: ldc_w 440
    //   405: ldc_w 442
    //   408: ldc 68
    //   410: ldc_w 444
    //   413: ldc_w 446
    //   416: iconst_0
    //   417: iconst_0
    //   418: ldc 68
    //   420: ldc 68
    //   422: ldc 68
    //   424: ldc 68
    //   426: invokestatic 451	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   429: return
    //   430: astore_3
    //   431: ldc_w 334
    //   434: iconst_1
    //   435: aload_3
    //   436: iconst_0
    //   437: anewarray 4	java/lang/Object
    //   440: invokestatic 454	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   443: return
    //   444: iload_1
    //   445: bipush 14
    //   447: if_icmpne +162 -> 609
    //   450: invokestatic 457	com/tencent/mobileqq/gamecenter/share/GameShareUtil:a	()V
    //   453: aload_0
    //   454: getfield 30	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   457: instanceof 400
    //   460: ifeq +42 -> 502
    //   463: ldc_w 402
    //   466: aload_0
    //   467: getfield 30	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   470: getfield 45	com/tencent/mobileqq/activity/aio/core/BaseChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   473: getfield 163	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   476: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   479: ifeq +67 -> 546
    //   482: ldc_w 404
    //   485: invokestatic 410	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   488: checkcast 404	com/tencent/mobileqq/qqfloatingwindow/IQQFloatingWindowBroadcast
    //   491: invokestatic 416	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   494: iconst_1
    //   495: bipush 54
    //   497: invokeinterface 420 4 0
    //   502: aload_0
    //   503: getfield 117	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   506: ifnull -217 -> 289
    //   509: aload_0
    //   510: getfield 113	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:c	Landroid/widget/TextView;
    //   513: ifnull -224 -> 289
    //   516: aload_0
    //   517: getfield 117	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   520: aload_0
    //   521: getfield 113	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:c	Landroid/widget/TextView;
    //   524: invokevirtual 123	android/widget/LinearLayout:removeView	(Landroid/view/View;)V
    //   527: aload_0
    //   528: aconst_null
    //   529: putfield 113	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:c	Landroid/widget/TextView;
    //   532: return
    //   533: astore_3
    //   534: ldc_w 334
    //   537: iconst_1
    //   538: aload_3
    //   539: invokestatic 461	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   542: invokestatic 424	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   545: return
    //   546: ldc_w 463
    //   549: invokestatic 410	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   552: checkcast 463	com/tencent/biz/pubaccount/util/api/IPublicAccountUtil
    //   555: aload_0
    //   556: getfield 30	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   559: getfield 45	com/tencent/mobileqq/activity/aio/core/BaseChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   562: invokeinterface 467 2 0
    //   567: ifeq -65 -> 502
    //   570: aload_0
    //   571: getfield 35	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   574: getstatic 431	com/tencent/mobileqq/app/QQManagerFactory:QWALLET_GDT_AD_MANAGER	I
    //   577: invokevirtual 57	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   580: checkcast 433	com/tencent/mobileqq/activity/qwallet/QWalletGdtAdManager
    //   583: aload_0
    //   584: getfield 43	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   587: invokevirtual 469	com/tencent/mobileqq/activity/qwallet/QWalletGdtAdManager:a	(Landroid/content/Context;)V
    //   590: goto -88 -> 502
    //   593: astore_3
    //   594: ldc_w 334
    //   597: iconst_1
    //   598: aload_3
    //   599: iconst_0
    //   600: anewarray 4	java/lang/Object
    //   603: invokestatic 454	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   606: goto -104 -> 502
    //   609: iload_1
    //   610: bipush 6
    //   612: if_icmpne +44 -> 656
    //   615: ldc_w 463
    //   618: invokestatic 410	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   621: checkcast 463	com/tencent/biz/pubaccount/util/api/IPublicAccountUtil
    //   624: aload_0
    //   625: getfield 30	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   628: getfield 45	com/tencent/mobileqq/activity/aio/core/BaseChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   631: invokeinterface 467 2 0
    //   636: ifeq -347 -> 289
    //   639: aload_0
    //   640: getfield 35	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   643: getstatic 431	com/tencent/mobileqq/app/QQManagerFactory:QWALLET_GDT_AD_MANAGER	I
    //   646: invokevirtual 57	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   649: checkcast 433	com/tencent/mobileqq/activity/qwallet/QWalletGdtAdManager
    //   652: invokevirtual 470	com/tencent/mobileqq/activity/qwallet/QWalletGdtAdManager:a	()V
    //   655: return
    //   656: iload_1
    //   657: bipush 10
    //   659: if_icmpne +44 -> 703
    //   662: ldc_w 463
    //   665: invokestatic 410	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   668: checkcast 463	com/tencent/biz/pubaccount/util/api/IPublicAccountUtil
    //   671: aload_0
    //   672: getfield 30	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   675: getfield 45	com/tencent/mobileqq/activity/aio/core/BaseChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   678: invokeinterface 467 2 0
    //   683: ifeq -394 -> 289
    //   686: aload_0
    //   687: getfield 35	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   690: getstatic 431	com/tencent/mobileqq/app/QQManagerFactory:QWALLET_GDT_AD_MANAGER	I
    //   693: invokevirtual 57	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   696: checkcast 433	com/tencent/mobileqq/activity/qwallet/QWalletGdtAdManager
    //   699: invokevirtual 472	com/tencent/mobileqq/activity/qwallet/QWalletGdtAdManager:b	()V
    //   702: return
    //   703: iload_1
    //   704: bipush 12
    //   706: if_icmpne -417 -> 289
    //   709: aload_0
    //   710: invokevirtual 238	com/tencent/mobileqq/activity/aio/helper/QWalletAIOLifeCycleHelper:a	()V
    //   713: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	714	0	this	QWalletAIOLifeCycleHelper
    //   0	714	1	paramInt	int
    //   150	6	2	f	float
    //   290	19	3	localThrowable1	java.lang.Throwable
    //   321	19	3	localThrowable2	java.lang.Throwable
    //   430	6	3	localThrowable3	java.lang.Throwable
    //   533	6	3	localThrowable4	java.lang.Throwable
    //   593	6	3	localThrowable5	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   6	47	290	java/lang/Throwable
    //   47	58	290	java/lang/Throwable
    //   58	240	321	java/lang/Throwable
    //   240	289	430	java/lang/Throwable
    //   352	429	430	java/lang/Throwable
    //   502	532	533	java/lang/Throwable
    //   453	502	593	java/lang/Throwable
    //   546	590	593	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper
 * JD-Core Version:    0.7.0.1
 */