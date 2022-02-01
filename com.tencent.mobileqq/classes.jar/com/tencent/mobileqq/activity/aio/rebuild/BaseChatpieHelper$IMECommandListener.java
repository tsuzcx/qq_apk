package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.SogouEmoji;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XEditTextEx.OnPrivateIMECommandListener;
import mqq.os.MqqHandler;

public class BaseChatpieHelper$IMECommandListener
  implements XEditTextEx.OnPrivateIMECommandListener
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private SogouEmoji jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji;
  
  public BaseChatpieHelper$IMECommandListener(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private void a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("PACKAGE_ID");
    String str = paramBundle.getString("EXP_ID");
    paramBundle = paramBundle.getString("EXP_PATH");
    if (QLog.isColorLevel()) {
      QLog.d("IMECommandListener", 2, "onPrivateIMECommand(), packId:" + i + ",exprId:" + str + ",ePath:" + paramBundle);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji == null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji = new SogouEmoji(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.a(i, str);
  }
  
  private void a(Bundle paramBundle, QQAppInterface paramQQAppInterface, Context paramContext, View paramView)
  {
    Object localObject = paramBundle.getString("SOGOU_APP_ID");
    String str = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = AuthorityUtil.a(paramQQAppInterface.getApp(), str, (String)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("IMECommandListener", 2, "onPrivateIMECommand(), appId:" + (String)localObject + "selfUin:" + str + "openId:" + paramQQAppInterface);
    }
    paramContext = (InputMethodManager)paramContext.getSystemService("input_method");
    if (paramContext != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("SOGOU_OPENID", paramQQAppInterface);
      paramContext.sendAppPrivateCommand(paramView, "com.tencent.mobileqq.sogou.openid", (Bundle)localObject);
    }
    paramBundle = paramBundle.getStringArrayList("EXP_ALL_PACKID");
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji == null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji = new SogouEmoji(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.a(paramBundle);
  }
  
  private void a(String paramString, Bundle paramBundle, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ("com.sogou.inputmethod.expression".equals(paramString)) {
      paramString = paramBundle.getString("SOGOU_EXP_PATH");
    }
    for (int i = 1034;; i = 1038)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IMECommandListener", 2, "onPrivateIMECommand(), path:" + paramString + ", busiType = " + i);
      }
      if (!TextUtils.isEmpty(paramString)) {
        ChatActivityFacade.a(paramQQAppInterface, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, i);
      }
      return;
      paramString = paramBundle.getString("QQINPUT_EXP_PATH");
    }
  }
  
  private boolean a(Bundle paramBundle, QQAppInterface paramQQAppInterface, Context paramContext, View paramView)
  {
    String str = paramBundle.getString("PCMFilePath");
    int i = paramBundle.getInt("SampleRate");
    int j = paramBundle.getInt("Channels");
    RecordParams.RecorderParam localRecorderParam = (RecordParams.RecorderParam)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.a;
    paramBundle = paramBundle.getString("InputMethodName");
    if (QLog.isColorLevel()) {
      QLog.d("sougouptt", 2, "recv args from sogou, pcmPath = " + str + " sampleRate = " + i + " channels = " + j + " inputName = " + paramBundle + " my sampleRate = " + localRecorderParam.a);
    }
    if ((i != localRecorderParam.a) || (StringUtil.a(str)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("sougouptt", 2, "invalid datas from sougou ");
      }
      return true;
    }
    ThreadManager.getSubThreadHandler().post(new BaseChatpieHelper.IMECommandListener.1(this, paramQQAppInterface, str, i, paramBundle, paramContext, paramView));
    return false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.a();
    }
  }
  
  public boolean a(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMECommandListener", 2, "onPrivateIMECommand(), action:" + paramString);
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext;
    XEditTextEx localXEditTextEx = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx;
    if ((!TextUtils.isEmpty(paramString)) && (paramBundle != null) && (InputMethodUtil.a(localContext)))
    {
      if ((!"com.sogou.inputmethod.expression".equals(paramString)) && (!"com.tencent.qqpinyin.expression".equals(paramString))) {
        break label105;
      }
      a(paramString, paramBundle, localQQAppInterface, localContext);
    }
    label105:
    do
    {
      return true;
      if ("com.sogou.inputmethod.appid".equals(paramString))
      {
        a(paramBundle, localQQAppInterface, localContext, localXEditTextEx);
        return true;
      }
      if (("com.sogou.inputmethod.qqexp".equals(paramString)) || ("com.tencent.qqpinyin.qqexp".equals(paramString)))
      {
        a(paramBundle);
        return true;
      }
    } while ((!"com.tencent.mobileqq_audioArgs".equals(paramString)) || (!a(paramBundle, localQQAppInterface, localContext, localXEditTextEx)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper.IMECommandListener
 * JD-Core Version:    0.7.0.1
 */