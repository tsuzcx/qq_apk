package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class SougouInputGrayTips
  implements GrayTipsTask, Runnable
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Time jdField_a_of_type_AndroidTextFormatTime;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private String a(Context paramContext)
  {
    Object localObject = this.jdField_a_of_type_JavaLangStringBuilder;
    int j = 0;
    ((StringBuilder)localObject).setLength(0);
    localObject = (InputMethodManager)paramContext.getSystemService("input_method");
    try
    {
      localObject = ((InputMethodManager)localObject).getInputMethodList();
    }
    catch (Exception localException)
    {
      label35:
      int i;
      break label35;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SougouInputGrayTips", 2, "TransactionTooLargeException occursed when getInputMethodList");
    }
    localObject = null;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((List)localObject).size();
    }
    while (j < i)
    {
      InputMethodInfo localInputMethodInfo = (InputMethodInfo)((List)localObject).get(j);
      this.jdField_a_of_type_JavaLangStringBuilder.append(localInputMethodInfo.loadLabel(paramContext.getPackageManager()));
      this.jdField_a_of_type_JavaLangStringBuilder.append(" ");
      j += 1;
    }
    return this.jdField_a_of_type_JavaLangStringBuilder.toString();
  }
  
  private boolean a(Context paramContext)
  {
    long l1 = System.currentTimeMillis();
    paramContext = a(paramContext);
    boolean bool;
    if ((!paramContext.contains(HardCodeUtil.a(2131714094))) && (!paramContext.contains("QQ输入法"))) {
      bool = false;
    } else {
      bool = true;
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("hasInstallSougouOrQQInput ret = ");
      paramContext.append(bool);
      paramContext.append(", cost:");
      paramContext.append(l2 - l1);
      paramContext.append(" ms");
      QLog.d("SougouInputGrayTips", 2, paramContext.toString());
    }
    return bool;
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    paramVarArgs = MessageRecordFactory.a(-1014);
    long l = MessageCache.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    paramVarArgs.init(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", l, -1043, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
    paramVarArgs.isread = true;
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1002) {
      return;
    }
    paramInt = ((String)paramVarArgs[0]).length();
    if (QLog.isColorLevel())
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("sendContent size = ");
      paramVarArgs.append(paramInt);
      QLog.d("SougouInputGrayTips", 2, paramVarArgs.toString());
    }
    if (paramInt < 10) {
      return;
    }
    ThreadManager.getSubThreadHandler().postDelayed(this, 1000L);
  }
  
  public int[] a()
  {
    return TipsConstants.a;
  }
  
  public int b()
  {
    return 1002;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SougouInputGrayTips", 2, ".....run......");
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.b = a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Boolean = true;
    }
    if (this.b)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SougouInputGrayTips", 2, "installSougouOrQQInput, just return");
      }
      return;
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAIOList cost:");
      ((StringBuilder)localObject2).append(l2 - l1);
      ((StringBuilder)localObject2).append(" ms");
      QLog.d("SougouInputGrayTips", 2, ((StringBuilder)localObject2).toString());
    }
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SougouInputGrayTips", 2, "aioMsgList == null");
      }
      return;
    }
    int j = ((List)localObject1).size();
    int i = j - 1;
    while ((i >= 0) && (i >= j - 11))
    {
      localObject2 = (ChatMessage)((List)localObject1).get(i);
      if ((((ChatMessage)localObject2).msgtype != -1014) && (((ChatMessage)localObject2).msgtype != -1017) && (((ChatMessage)localObject2).msgtype != -1016) && (((ChatMessage)localObject2).msgtype != -1041) && (((ChatMessage)localObject2).msgtype != -1043) && ((((ChatMessage)localObject2).msgtype != -1013) || (((ChatMessage)localObject2).istroop != 0)))
      {
        i -= 1;
      }
      else
      {
        bool = true;
        break label302;
      }
    }
    boolean bool = false;
    label302:
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("findExcludeMsg :");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("SougouInputGrayTips", 2, ((StringBuilder)localObject1).toString());
    }
    if (bool) {
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("key_sougou_input_gray_tips_");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("key_sougou_input_gray_tips_count_");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localObject2 = ((StringBuilder)localObject2).toString();
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("free_call", 0);
    Object localObject3 = localSharedPreferences.getString((String)localObject1, "");
    Object localObject4 = localSharedPreferences.getString((String)localObject2, "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sougouInputGrayShowCountStr = ");
      localStringBuilder.append((String)localObject4);
      QLog.d("SougouInputGrayTips", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty((CharSequence)localObject4))
    {
      j = Integer.parseInt((String)localObject4);
      i = j;
      if (j >= 2) {
        if (QLog.isColorLevel()) {
          QLog.d("SougouInputGrayTips", 2, "showCount >= 2, just return;");
        }
      }
    }
    else
    {
      i = 0;
    }
    l1 = MessageCache.a() * 1000L;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      if (this.jdField_a_of_type_AndroidTextFormatTime == null) {
        this.jdField_a_of_type_AndroidTextFormatTime = new Time();
      }
      this.jdField_a_of_type_AndroidTextFormatTime.set(l1);
      j = this.jdField_a_of_type_AndroidTextFormatTime.year;
      int k = this.jdField_a_of_type_AndroidTextFormatTime.month;
      int m = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
      int n = this.jdField_a_of_type_AndroidTextFormatTime.hour;
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("curDate :");
        ((StringBuilder)localObject4).append(j);
        ((StringBuilder)localObject4).append(" - ");
        ((StringBuilder)localObject4).append(k);
        ((StringBuilder)localObject4).append(" - ");
        ((StringBuilder)localObject4).append(m);
        ((StringBuilder)localObject4).append(" - ");
        ((StringBuilder)localObject4).append(n);
        QLog.d("SougouInputGrayTips", 2, ((StringBuilder)localObject4).toString());
      }
      l2 = Long.parseLong((String)localObject3);
      this.jdField_a_of_type_AndroidTextFormatTime.set(l2);
      j = this.jdField_a_of_type_AndroidTextFormatTime.year;
      k = this.jdField_a_of_type_AndroidTextFormatTime.month;
      m = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
      n = this.jdField_a_of_type_AndroidTextFormatTime.hour;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("lastShowDate :");
        ((StringBuilder)localObject3).append(j);
        ((StringBuilder)localObject3).append(" - ");
        ((StringBuilder)localObject3).append(k);
        ((StringBuilder)localObject3).append(" - ");
        ((StringBuilder)localObject3).append(m);
        ((StringBuilder)localObject3).append(" - ");
        ((StringBuilder)localObject3).append(n);
        QLog.d("SougouInputGrayTips", 2, ((StringBuilder)localObject3).toString());
      }
      if (l1 - l2 <= 604800000L) {
        if (QLog.isColorLevel()) {
          QLog.d("SougouInputGrayTips", 2, "has show in a week, just return;");
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("SougouInputGrayTips", 2, "has never shown sougouInput Gray Tips");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0]))
    {
      localSharedPreferences.edit().putString((String)localObject1, String.valueOf(l1)).putString((String)localObject2, String.valueOf(i + 1)).commit();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80047CE", "0X80047CE", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.SougouInputGrayTips
 * JD-Core Version:    0.7.0.1
 */