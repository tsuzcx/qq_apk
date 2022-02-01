package com.tencent.mobileqq.activity.aio.avatardoubletap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.settings.message.AssistantSettingFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class PaiYiPaiManager
  implements Manager
{
  private QQAppInterface a;
  
  public PaiYiPaiManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PaiYiPaiManager", 2, "updateModified() called");
    }
    String str = this.a.getCurrentAccountUin();
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pai_yi_pai_profile_info_");
    localStringBuilder.append(str);
    localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("modified", true).apply();
  }
  
  public void a(MessageForGrayTips.HightlightClickableSpan paramHightlightClickableSpan)
  {
    Context localContext = paramHightlightClickableSpan.getContext();
    if ((localContext instanceof ChatHistoryActivity))
    {
      if (QLog.isColorLevel())
      {
        paramHightlightClickableSpan = new StringBuilder();
        paramHightlightClickableSpan.append("onClickDoubleTapTips() no action for ");
        paramHightlightClickableSpan.append(localContext);
        QLog.d("PaiYiPaiManager", 2, paramHightlightClickableSpan.toString());
      }
      return;
    }
    localContext.startActivity(new Intent(localContext, QQSettingSettingActivity.class));
    PublicFragmentActivity.a(localContext, new Intent(), AssistantSettingFragment.class);
    paramHightlightClickableSpan.clickWebMsg("https://zb.vip.qq.com/v2/pages/nudgeMall?_wv=2");
    int i;
    if (paramHightlightClickableSpan.getMessage().istroop == 0) {
      i = 1;
    } else if (paramHightlightClickableSpan.getMessage().istroop == 1) {
      i = 2;
    } else {
      i = 10;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B3A4", "0X800B3A4", i, 0, "", "", "", "");
  }
  
  public void a(short paramShort)
  {
    Object localObject1 = this.a.getCurrentAccountUin();
    Object localObject2 = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pai_yi_pai_profile_info_");
    localStringBuilder.append((String)localObject1);
    localObject1 = ((BaseApplicationImpl)localObject2).getSharedPreferences(localStringBuilder.toString(), 0);
    short s = ((SharedPreferences)localObject1).getInt("switch", 0);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onUpdateSwitch() called with: isClosed = [");
      ((StringBuilder)localObject2).append(paramShort);
      ((StringBuilder)localObject2).append("], currentSwitch = [");
      ((StringBuilder)localObject2).append(s);
      ((StringBuilder)localObject2).append("]");
      QLog.d("PaiYiPaiManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (s != paramShort)
    {
      localObject1 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject1).putInt("switch", paramShort);
      ((SharedPreferences.Editor)localObject1).apply();
    }
  }
  
  public boolean a()
  {
    Object localObject = this.a.getCurrentAccountUin();
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pai_yi_pai_profile_info_");
    localStringBuilder.append((String)localObject);
    boolean bool = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("modified", false);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isModified() isModified = [");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("]");
      QLog.d("PaiYiPaiManager", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public void b(short paramShort)
  {
    Object localObject1 = this.a.getCurrentAccountUin();
    Object localObject2 = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pai_yi_pai_profile_info_");
    localStringBuilder.append((String)localObject1);
    localObject1 = ((BaseApplicationImpl)localObject2).getSharedPreferences(localStringBuilder.toString(), 0);
    short s = ((SharedPreferences)localObject1).getInt("action", 0);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onUpdateAction() called with: action = [");
      ((StringBuilder)localObject2).append(paramShort);
      ((StringBuilder)localObject2).append("], currentAction = [");
      ((StringBuilder)localObject2).append(s);
      ((StringBuilder)localObject2).append("]");
      QLog.d("PaiYiPaiManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (s != paramShort)
    {
      localObject1 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject1).putInt("action", paramShort);
      ((SharedPreferences.Editor)localObject1).apply();
    }
    if ((paramShort != 0) || (s != 0)) {
      b();
    }
  }
  
  public void c(short paramShort)
  {
    Object localObject1 = this.a.getCurrentAccountUin();
    Object localObject2 = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pai_yi_pai_profile_info_");
    localStringBuilder.append((String)localObject1);
    localObject1 = ((BaseApplicationImpl)localObject2).getSharedPreferences(localStringBuilder.toString(), 0);
    short s = ((SharedPreferences)localObject1).getInt("effect", 0);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onUpdateEffect() called with: effect = [");
      ((StringBuilder)localObject2).append(paramShort);
      ((StringBuilder)localObject2).append("], currentEffect = [");
      ((StringBuilder)localObject2).append(s);
      ((StringBuilder)localObject2).append("]");
      QLog.d("PaiYiPaiManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (s != paramShort)
    {
      localObject1 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject1).putInt("effect", paramShort);
      ((SharedPreferences.Editor)localObject1).apply();
    }
    if ((paramShort != 0) || (s != 0)) {
      b();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.avatardoubletap.PaiYiPaiManager
 * JD-Core Version:    0.7.0.1
 */