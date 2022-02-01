package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.Editable;
import android.text.Html;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qwallet.temp.IQWalletAIOLifeCycleHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.copyprompt.CopyPromptHelper;
import com.tencent.mobileqq.managers.PasswdRedBagFoldManager;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qqgamepub.api.IGameShareUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletGdtAdApi;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class QWalletAIOLifeCycleHelper
  implements IQWalletAIOLifeCycleHelper
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IPasswdRedBagService jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService;
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
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService = ((IPasswdRedBagService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPasswdRedBagService.class));
  }
  
  private static String a(int paramInt)
  {
    if (paramInt == 0) {
      return HardCodeUtil.a(2131711113);
    }
    if (paramInt == 1) {
      return HardCodeUtil.a(2131720392);
    }
    if (paramInt == 2) {
      return HardCodeUtil.a(2131720394);
    }
    return "";
  }
  
  private void a(String paramString1, String paramString2, int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((paramString1 != null) && (paramString1.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    }
    paramString1 = this.jdField_a_of_type_AndroidViewView;
    if (paramString1 != null) {
      paramString1.setVisibility(8);
    }
    paramString1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramString1 != null) {
      paramString1.setText(paramString2);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      paramString1 = a(paramInt);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165327));
    }
    paramString1 = this.c;
    if (paramString1 != null)
    {
      paramString1.setVisibility(0);
      if (paramInt == 0) {
        this.c.setText(HardCodeUtil.a(2131720397));
      } else if (paramInt == 1) {
        this.c.setText(HardCodeUtil.a(2131720391));
      } else if (paramInt == 2) {
        this.c.setText(HardCodeUtil.a(2131720393));
      }
    }
    paramString1 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (paramString1 != null)
    {
      paramString1.removeView(this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_b_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, 0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, 2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.bringToFront();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramOnClickListener);
    }
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (paramString1 != null) {
      ((CopyPromptHelper)paramString1.a(19)).a();
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    paramString1 = this.jdField_a_of_type_AndroidViewView;
    if (paramString1 != null) {
      paramString1.setVisibility(0);
    }
    paramString1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramString1 != null)
    {
      paramString1.setText(paramString2);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ff4222"));
    }
    paramString1 = this.jdField_b_of_type_AndroidWidgetTextView;
    if (paramString1 != null)
    {
      paramString1.setText(paramString3);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165327));
    }
    paramString1 = this.c;
    if (paramString1 != null) {
      paramString1.setVisibility(8);
    }
    paramString1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if ((paramString1 != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null))
    {
      paramString2 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (paramString2 != null)
      {
        paramString2.removeView(paramString1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_b_of_type_AndroidWidgetTextView);
        if (paramBoolean)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, 0);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, 2);
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, 0);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, 2);
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.bringToFront();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramOnClickListener);
      }
    }
    ((CopyPromptHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(19)).a();
  }
  
  private Object[] a(String paramString, int paramInt)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object[] arrayOfObject = null;
    if (bool) {
      return null;
    }
    Object localObject;
    if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService.openPasswdRedBagById(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangString, paramInt);
      } else {
        arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService.openPasswdRedBagByPassword(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, paramInt);
      }
      localObject = arrayOfObject;
      if (arrayOfObject != null)
      {
        localObject = arrayOfObject;
        if (((Integer)arrayOfObject[0]).intValue() == 1)
        {
          this.jdField_a_of_type_JavaLangString = "";
          this.jdField_b_of_type_JavaLangString = "";
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().sendEmptyMessage(12);
          localObject = arrayOfObject;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString.charAt(0));
            ((StringBuilder)localObject).append("|");
            ((StringBuilder)localObject).append(paramString.length());
            paramString = new StringBuilder();
            paramString.append("passwdredbags result[0]=");
            paramString.append(arrayOfObject[0]);
            paramString.append(",result[1]=");
            paramString.append(arrayOfObject[1]);
            paramString.append(",send str=");
            paramString.append(((StringBuilder)localObject).toString());
            QLog.d("PasswdRedBagSgervice", 2, paramString.toString());
            return arrayOfObject;
          }
        }
      }
    }
    else
    {
      localObject = arrayOfObject;
      if (QLog.isColorLevel())
      {
        QLog.d("PasswdRedBagSgervice", 2, "current is in Anonymous, dont search passwdredbags");
        localObject = arrayOfObject;
      }
    }
    return localObject;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setText("");
    }
    localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setText("");
    }
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(8);
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
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if ((localLinearLayout != null) && (localLinearLayout.getVisibility() == 0) && (!StringUtil.a(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramString))) {
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
      if ((paramString[2] != null) && (PasswdRedBagFoldManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        paramSendMsgParams.c = ((String)paramString[2]);
        paramSendMsgParams.jdField_d_of_type_JavaLangString = ((String)paramString[3]);
        paramSendMsgParams.e = ((PasswdRedBagFoldManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramSendMsgParams.c, paramSendMsgParams.jdField_d_of_type_JavaLangString).booleanValue();
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, String.format("Send, get RedBagId, friendUin: %s, senderUin: %d, redBagFlag: %d, foldFlag: %s, redBagId: %s, redBagIndex: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Long.valueOf(paramSendMsgParams.jdField_d_of_type_Long), Integer.valueOf(paramSendMsgParams.f), Boolean.valueOf(paramSendMsgParams.e), paramSendMsgParams.c, paramSendMsgParams.jdField_d_of_type_JavaLangString }));
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if ((localLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (localLinearLayout.getVisibility() == 0) && (!StringUtil.a(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramString1)))
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
      a(paramString1, this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService.getLastIdiom(paramString2), "回复下一句参与接龙", local2, true);
      return;
    }
    a(paramString1, this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService.getLastIdiomPinyin(paramString2), paramInt, local2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, paramString2, paramString3, new QWalletAIOLifeCycleHelper.1(this, paramString1, paramString2), false);
  }
  
  public boolean a()
  {
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    return (localLinearLayout != null) && (localLinearLayout.getVisibility() == 0);
  }
  
  public void b()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if ((str != null) && (str.equals("0"))) {
      a();
    }
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    QWalletAIOLifeCycleHelper.3 local3 = new QWalletAIOLifeCycleHelper.3(this);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<font color=\"#C0976A\">回复“</font><font color=\"#FF2954\">");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("</font><font color=\"#C0976A\">”的拼音</font>");
    paramString2 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("<font color=\"#C0976A\">提示：</font><font color=\"#FF2954\">");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("</font>");
    paramString3 = localStringBuilder.toString();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString3;
    paramString1 = this.jdField_a_of_type_AndroidViewView;
    if (paramString1 != null) {
      paramString1.setVisibility(0);
    }
    paramString1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramString1 != null)
    {
      paramString1.setTextSize(1, 12.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(Html.fromHtml(paramString3));
    }
    paramString1 = this.jdField_b_of_type_AndroidWidgetTextView;
    if (paramString1 != null)
    {
      paramString1.setTextSize(1, 12.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(Html.fromHtml(paramString2));
    }
    paramString1 = this.c;
    if (paramString1 != null) {
      paramString1.setVisibility(8);
    }
    paramString1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if ((paramString1 != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null))
    {
      paramString2 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (paramString2 != null)
      {
        paramString2.removeView(paramString1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_b_of_type_AndroidWidgetTextView);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, 0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, 2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.bringToFront();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(local3);
      }
    }
    ((CopyPromptHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(19)).a();
  }
  
  public String getTag()
  {
    return "QWalletAIOLifeCycleHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 9, 15, 7, 11 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt == 9)
    {
      StringBuilder localStringBuilder;
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService != null) && (this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService.isFirstInAio()) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004))) {
          this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService.fetchNewestIdomRedbagWordWhenFirstEnterAIO(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
      }
      catch (Throwable localThrowable1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("fetchNewestIdomRedbagWordWhenFirstEnterAIO throw an exception: ");
        localStringBuilder.append(localThrowable1);
        QLog.e("QWalletAIOLifeCycleHelper", 1, localStringBuilder.toString());
      }
      try
      {
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131364581));
        this.c = new TextView(this.jdField_a_of_type_AndroidContentContext);
        this.c.setTextColor(-16777216);
        this.c.setTextSize(1, 12.0F);
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131364583));
        float f = this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(HardCodeUtil.a(2131711372));
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth((int)(f * 9.0F + 0.5F));
        this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131364469);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131364582));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.c);
        this.c.getLayoutParams().width = -2;
        this.c.getLayoutParams().height = -2;
      }
      catch (Throwable localThrowable2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("init ui throw an exception: ");
        localStringBuilder.append(localThrowable2);
        QLog.e("QWalletAIOLifeCycleHelper", 1, localStringBuilder.toString());
      }
      try
      {
        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof PublicAccountChatPie)) {
          return;
        }
        if ("3046055438".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 54);
          return;
        }
        if (!"2711679534".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          return;
        }
        ((IQWalletGdtAdApi)QRoute.api(IQWalletGdtAdApi.class)).checkReportTailAdShow();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "public.aio.click", 0, 0, "", "", "", "");
        return;
      }
      catch (Throwable localThrowable3)
      {
        QLog.e("QWalletAIOLifeCycleHelper", 1, localThrowable3, new Object[0]);
        return;
      }
    }
    else if (paramInt == 15)
    {
      ((IGameShareUtil)QRoute.api(IGameShareUtil.class)).releaseCache();
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof PublicAccountChatPie)) {
          if ("3046055438".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 54);
          } else if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isQWalletPubAccount(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
            ((IQWalletGdtAdApi)QRoute.api(IQWalletGdtAdApi.class)).handleWhenPubQuit(this.jdField_a_of_type_AndroidAppActivity);
          }
        }
      }
      catch (Throwable localThrowable4)
      {
        QLog.e("QWalletAIOLifeCycleHelper", 1, localThrowable4, new Object[0]);
      }
      try
      {
        if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.c == null)) {
          return;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.c);
        this.c = null;
        return;
      }
      catch (Throwable localThrowable5)
      {
        QLog.e("QWalletAIOLifeCycleHelper", 1, QLog.getStackTraceString(localThrowable5));
        return;
      }
    }
    else if (paramInt == 7)
    {
      if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isQWalletPubAccount(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
        ((IQWalletGdtAdApi)QRoute.api(IQWalletGdtAdApi.class)).handleWhenPubResume();
      }
    }
    else if (paramInt == 11)
    {
      if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isQWalletPubAccount(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
        ((IQWalletGdtAdApi)QRoute.api(IQWalletGdtAdApi.class)).handleWhenPubPause();
      }
    }
    else if (paramInt == 13)
    {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper
 * JD-Core Version:    0.7.0.1
 */