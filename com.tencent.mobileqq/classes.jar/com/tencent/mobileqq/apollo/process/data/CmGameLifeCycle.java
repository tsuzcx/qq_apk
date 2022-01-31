package com.tencent.mobileqq.apollo.process.data;

import android.app.Activity;
import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.process.chanel.CmGameHandler;
import com.tencent.mobileqq.apollo.process.chanel.GeneralEventHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.config.WorldCup;
import com.tencent.mobileqq.ar.config.WorldCupConfigInfo;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

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
    Object localObject1 = a();
    if (localObject1 == null) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "app is null.");
    }
    ApolloManager localApolloManager;
    boolean bool;
    do
    {
      do
      {
        do
        {
          Object localObject2;
          do
          {
            for (;;)
            {
              return;
              if (1 == paramInt2)
              {
                localObject2 = a();
                if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game == null) || (localObject2 == null))
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
                  CmGameCmdChannel.a((QQAppInterface)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler);
                }
                if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler != null) {
                  CmGameCmdChannel.a((QQAppInterface)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler);
                }
                this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler = new GeneralEventHandler((Activity)localObject2, (QQAppInterface)localObject1, this.jdField_a_of_type_Int);
                CmGameCmdChannel.a((QQAppInterface)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler);
                if (!CmGameUtil.a(this.jdField_a_of_type_Int))
                {
                  this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler = new CmGameHandler((Activity)localObject2, new CmGameMainManager((Activity)localObject2, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam), this.jdField_a_of_type_Int);
                  CmGameCmdChannel.a((QQAppInterface)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler);
                }
                if (CmGameUtil.a(this.jdField_a_of_type_Int)) {
                  continue;
                }
                try
                {
                  localObject1 = (ApolloGameManager)((QQAppInterface)localObject1).getManager(210);
                  if (localObject1 != null)
                  {
                    localObject2 = new ArrayList();
                    ((ArrayList)localObject2).add(Integer.valueOf(paramInt1));
                    ((ApolloGameManager)localObject1).a("android.playgame", "apollo_aio_game.add_games_to_user_gamepanel", (ArrayList)localObject2);
                    return;
                  }
                }
                catch (Exception localException)
                {
                  QLog.e(jdField_a_of_type_JavaLangString, 1, "errInfo->" + localException.getMessage());
                  return;
                }
              }
            }
          } while (4 != paramInt2);
          if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler != null)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler.a();
            if (localObject2 != null) {
              ((CmGameMainManager)localObject2).g();
            }
            this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler.a();
            CmGameCmdChannel.a(localException).b(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler);
            this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler = null;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler.a();
            CmGameCmdChannel.a(localException).b(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler);
            this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler = null;
          }
        } while ((CmGameUtil.a(this.jdField_a_of_type_Int)) || (a() == null));
        localApolloManager = (ApolloManager)a().getManager(152);
      } while ((localApolloManager == null) || (!localApolloManager.g()) || (!localApolloManager.f()) || (WorldCupConfigInfo.d(WorldCup.a(CmGameUtil.a()))) || (localApolloManager.l));
      bool = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getBoolean("is_new_user_bar_showed" + CmGameUtil.a().getCurrentAccountUin(), false);
    } while ((localApolloManager.j) || (bool) || (this.jdField_a_of_type_JavaLangRefWeakReference == null));
    localApolloManager.h = false;
    CmGameUtil.a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    QLog.d(jdField_a_of_type_JavaLangString, 1, "frist play goBackToPlus");
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