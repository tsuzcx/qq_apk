package com.tencent.mobileqq.apollo.process.data;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.process.chanel.CmGameHandler;
import com.tencent.mobileqq.apollo.process.chanel.GeneralEventHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class CmGameLifeCycle
{
  public static String a;
  private int jdField_a_of_type_Int;
  private CmGameStartChecker.StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private CmGameHandler jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler;
  private GeneralEventHandler jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  static
  {
    jdField_a_of_type_JavaLangString = "cmgame_process.CmGameLifeCycle";
  }
  
  public CmGameLifeCycle(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private Activity a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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
    return this.jdField_a_of_type_Int;
  }
  
  public CmGameMainManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[handleActLifeCycle], gameId:" + paramInt1 + ",status:" + paramInt2);
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "app is null.");
    }
    do
    {
      do
      {
        Activity localActivity;
        do
        {
          return;
          if (1 != paramInt2) {
            break;
          }
          localActivity = a();
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game == null) || (localActivity == null))
          {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "null error.");
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId != paramInt1)
          {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "not the same game.");
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler != null) {
            CmGameCmdChannel.a(localQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler != null) {
            CmGameCmdChannel.a(localQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler);
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler = new GeneralEventHandler(localActivity, localQQAppInterface, this.jdField_a_of_type_Int);
          CmGameCmdChannel.a(localQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler);
        } while (CmGameUtil.a(this.jdField_a_of_type_Int));
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler = new CmGameHandler(localActivity, new CmGameMainManager(localActivity, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam), this.jdField_a_of_type_Int);
        CmGameCmdChannel.a(localQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler);
        return;
      } while (4 != paramInt2);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler.a().g();
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler.a();
        CmGameCmdChannel.a(localQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler);
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler = null;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler.a();
    CmGameCmdChannel.a(localQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler);
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler = null;
  }
  
  public void a(Activity paramActivity, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLifeCycle
 * JD-Core Version:    0.7.0.1
 */