package com.tencent.mobileqq.apollo.view.pannel;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionObserverImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.utils.ApolloPanelUtil;
import com.tencent.mobileqq.apollo.utils.CmShowWnsUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

class ApolloPanel$3
  extends ApolloExtensionObserverImpl
{
  private volatile String jdField_a_of_type_JavaLangString = null;
  
  ApolloPanel$3(ApolloPanel paramApolloPanel) {}
  
  private boolean a(@NotNull String paramString, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    if (paramArrayList.contains(paramString))
    {
      paramString = ApolloPanelUtil.a(paramString);
      QLog.d("ApolloPanel", 1, "check needReGetFrame, current dressInfo:" + paramString + ", old dressInfo:" + this.jdField_a_of_type_JavaLangString);
      if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_JavaLangString = paramString;
        return true;
      }
    }
    return false;
  }
  
  public void e(boolean paramBoolean, Object paramObject)
  {
    super.e(paramBoolean, paramObject);
    if (!paramBoolean) {
      QLog.e("ApolloPanel", 1, this + " onApolloDressChange fail");
    }
    do
    {
      do
      {
        return;
        paramBoolean = false;
        try
        {
          paramObject = (ArrayList)paramObject;
          boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.a.a.getCurrentUin(), paramObject);
          paramBoolean = bool;
        }
        catch (Exception paramObject)
        {
          for (;;)
          {
            QLog.e("ApolloPanel", 1, "onApolloDressChange needReGetFrame exception", paramObject);
          }
        }
        QLog.d("ApolloPanel", 1, "onApolloDressChange reGetFrame:" + paramBoolean);
      } while (!paramBoolean);
      paramObject = (ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.a.a.getRuntimeService(IApolloManagerService.class, "all");
    } while ((paramObject == null) || (paramObject.getApolloUserStatus(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.a.a) == 2));
    ThreadManager.getSubThreadHandler().post(new ApolloPanel.3.1(this, paramObject));
    ThreadManager.getSubThreadHandler().postDelayed(new ApolloPanel.3.2(this, paramObject), CmShowWnsUtils.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.3
 * JD-Core Version:    0.7.0.1
 */