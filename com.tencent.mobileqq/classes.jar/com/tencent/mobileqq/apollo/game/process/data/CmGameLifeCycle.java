package com.tencent.mobileqq.apollo.game.process.data;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.game.process.chanel.CmGameHandler;
import com.tencent.mobileqq.apollo.game.process.chanel.GeneralEventHandler;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class CmGameLifeCycle
{
  public static String a = "cmgame_process.CmGameLifeCycle";
  public int a;
  private CmGameHandler jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameHandler;
  private GeneralEventHandler jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelGeneralEventHandler;
  private StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private int b;
  
  public CmGameLifeCycle(int paramInt)
  {
    this.b = paramInt;
  }
  
  private Activity a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference == null) {
      return null;
    }
    return (Activity)localWeakReference.get();
  }
  
  private QQAppInterface a()
  {
    AppInterface localAppInterface = CmGameUtil.a();
    if ((localAppInterface instanceof QQAppInterface)) {
      return (QQAppInterface)localAppInterface;
    }
    return null;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public void a()
  {
    CmGameHandler localCmGameHandler = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameHandler;
    if (localCmGameHandler != null) {
      localCmGameHandler.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[handleActLifeCycle], gameId:");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(",status:");
    ((StringBuilder)localObject2).append(paramInt2);
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject1 = a();
    if (localObject1 == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "app is null.");
      return;
    }
    if (2 == paramInt2)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameHandler;
      if (localObject2 != null)
      {
        localObject2 = ((CmGameHandler)localObject2).a();
        if (localObject2 != null) {
          ((CmGameMainManager)localObject2).a();
        }
      }
    }
    if (4 == paramInt2)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameHandler;
      if (localObject1 != null)
      {
        localObject1 = ((CmGameHandler)localObject1).a();
        if (localObject1 != null) {
          ((CmGameMainManager)localObject1).b();
        }
      }
    }
    else if (1 == paramInt2)
    {
      localObject2 = a();
      StartCheckParam localStartCheckParam = this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam;
      if ((localStartCheckParam != null) && (localObject2 != null))
      {
        if (localStartCheckParam.gameId != paramInt1)
        {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "not the same game.");
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameHandler != null) {
          CmGameCmdChannel.a((AppInterface)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameHandler);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelGeneralEventHandler != null) {
          CmGameCmdChannel.a((AppInterface)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelGeneralEventHandler);
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelGeneralEventHandler = new GeneralEventHandler((Activity)localObject2, (QQAppInterface)localObject1, this.b);
        CmGameCmdChannel.a((AppInterface)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelGeneralEventHandler);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.game == null) {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "land or game box game data not exit");
        }
      }
      else
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "null error.");
      }
    }
    else if (5 == paramInt2)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameHandler;
      if (localObject2 != null)
      {
        localObject2 = ((CmGameHandler)localObject2).a();
        if (localObject2 != null) {
          ((CmGameMainManager)localObject2).c();
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameHandler.a();
        CmGameCmdChannel.a((AppInterface)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameHandler);
        this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameHandler = null;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelGeneralEventHandler;
      if (localObject2 != null)
      {
        ((GeneralEventHandler)localObject2).a();
        CmGameCmdChannel.a((AppInterface)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelGeneralEventHandler);
        this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelGeneralEventHandler = null;
      }
    }
  }
  
  public void a(Activity paramActivity, StartCheckParam paramStartCheckParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam = paramStartCheckParam;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameLifeCycle
 * JD-Core Version:    0.7.0.1
 */