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
    int j = 0;
    this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    Object localObject1 = (InputMethodManager)paramContext.getSystemService("input_method");
    try
    {
      localObject1 = ((InputMethodManager)localObject1).getInputMethodList();
      if (localObject1 == null)
      {
        i = 0;
        while (j < i)
        {
          InputMethodInfo localInputMethodInfo = (InputMethodInfo)((List)localObject1).get(j);
          this.jdField_a_of_type_JavaLangStringBuilder.append(localInputMethodInfo.loadLabel(paramContext.getPackageManager()));
          this.jdField_a_of_type_JavaLangStringBuilder.append(" ");
          j += 1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SougouInputGrayTips", 2, "TransactionTooLargeException occursed when getInputMethodList");
        }
        Object localObject2 = null;
        continue;
        int i = localObject2.size();
      }
    }
    return this.jdField_a_of_type_JavaLangStringBuilder.toString();
  }
  
  private boolean a(Context paramContext)
  {
    long l1 = System.currentTimeMillis();
    paramContext = a(paramContext);
    if ((paramContext.contains(HardCodeUtil.a(2131714165))) || (paramContext.contains("QQ输入法"))) {}
    for (boolean bool = true;; bool = false)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("SougouInputGrayTips", 2, "hasInstallSougouOrQQInput ret = " + bool + ", cost:" + (l2 - l1) + " ms");
      }
      return bool;
    }
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
    if (paramInt != 1002) {}
    do
    {
      return;
      paramInt = ((String)paramVarArgs[0]).length();
      if (QLog.isColorLevel()) {
        QLog.d("SougouInputGrayTips", 2, "sendContent size = " + paramInt);
      }
    } while (paramInt < 10);
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
    if (this.b) {
      if (QLog.isColorLevel()) {
        QLog.d("SougouInputGrayTips", 2, "installSougouOrQQInput, just return");
      }
    }
    long l1;
    Object localObject1;
    long l2;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("SougouInputGrayTips", 2, "getAIOList cost:" + (l2 - l1) + " ms");
      }
      if (localObject1 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SougouInputGrayTips", 2, "aioMsgList == null");
    return;
    int j = ((List)localObject1).size();
    int i = j - 1;
    label168:
    boolean bool;
    if (i >= 0) {
      if (i < j - 11) {
        bool = false;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SougouInputGrayTips", 2, "findExcludeMsg :" + bool);
      }
      if (bool) {
        break;
      }
      localObject1 = "key_sougou_input_gray_tips_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      Object localObject2 = "key_sougou_input_gray_tips_count_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("free_call", 0);
      String str1 = localSharedPreferences.getString((String)localObject1, "");
      String str2 = localSharedPreferences.getString((String)localObject2, "");
      if (QLog.isColorLevel()) {
        QLog.d("SougouInputGrayTips", 2, "sougouInputGrayShowCountStr = " + str2);
      }
      if (!TextUtils.isEmpty(str2))
      {
        j = Integer.parseInt(str2);
        i = j;
        if (j < 2) {
          break label482;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SougouInputGrayTips", 2, "showCount >= 2, just return;");
        return;
        localObject2 = (ChatMessage)((List)localObject1).get(i);
        if ((((ChatMessage)localObject2).msgtype == -1014) || (((ChatMessage)localObject2).msgtype == -1017) || (((ChatMessage)localObject2).msgtype == -1016) || (((ChatMessage)localObject2).msgtype == -1041) || (((ChatMessage)localObject2).msgtype == -1043) || ((((ChatMessage)localObject2).msgtype == -1013) && (((ChatMessage)localObject2).istroop == 0)))
        {
          bool = true;
          continue;
        }
        i -= 1;
        break label168;
      }
      i = 0;
      label482:
      l1 = MessageCache.a() * 1000L;
      if (!TextUtils.isEmpty(str1))
      {
        if (this.jdField_a_of_type_AndroidTextFormatTime == null) {
          this.jdField_a_of_type_AndroidTextFormatTime = new Time();
        }
        this.jdField_a_of_type_AndroidTextFormatTime.set(l1);
        j = this.jdField_a_of_type_AndroidTextFormatTime.year;
        int k = this.jdField_a_of_type_AndroidTextFormatTime.month;
        int m = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
        int n = this.jdField_a_of_type_AndroidTextFormatTime.hour;
        if (QLog.isColorLevel()) {
          QLog.d("SougouInputGrayTips", 2, "curDate :" + j + " - " + k + " - " + m + " - " + n);
        }
        l2 = Long.parseLong(str1);
        this.jdField_a_of_type_AndroidTextFormatTime.set(l2);
        j = this.jdField_a_of_type_AndroidTextFormatTime.year;
        k = this.jdField_a_of_type_AndroidTextFormatTime.month;
        m = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
        n = this.jdField_a_of_type_AndroidTextFormatTime.hour;
        if (QLog.isColorLevel()) {
          QLog.d("SougouInputGrayTips", 2, "lastShowDate :" + j + " - " + k + " - " + m + " - " + n);
        }
        if (l1 - l2 > 604800000L) {
          break label781;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SougouInputGrayTips", 2, "has show in a week, just return;");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SougouInputGrayTips", 2, "has never shown sougouInput Gray Tips");
      }
      label781:
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0])) {
        break;
      }
      localSharedPreferences.edit().putString((String)localObject1, String.valueOf(l1)).putString((String)localObject2, String.valueOf(i + 1)).commit();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80047CE", "0X80047CE", 0, 0, "", "", "", "");
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.SougouInputGrayTips
 * JD-Core Version:    0.7.0.1
 */