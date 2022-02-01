package com.tencent.mobileqq.apollo.process.data;

import android.app.Activity;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.process.chanel.CmGameHandler;
import com.tencent.mobileqq.apollo.process.chanel.GeneralEventHandler;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class CmGameLifeCycle
{
  public static String a;
  public int a;
  private CmGameStartChecker.StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private CmGameHandler jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler;
  private GeneralEventHandler jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "cmgame_process.CmGameLifeCycle";
  }
  
  public CmGameLifeCycle(int paramInt)
  {
    this.b = paramInt;
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
    return this.b;
  }
  
  public CmGameMainManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[handleActLifeCycle], gameId:" + paramInt1 + ",status:" + paramInt2);
    Object localObject1 = a();
    if (localObject1 == null) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "app is null.");
    }
    do
    {
      do
      {
        Object localObject2;
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if ((2 == paramInt2) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler != null))
                {
                  localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler.a();
                  if (localObject2 != null) {
                    ((CmGameMainManager)localObject2).d();
                  }
                }
                if (4 != paramInt2) {
                  break;
                }
              } while (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler == null);
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler.a();
            } while (localObject1 == null);
            ((CmGameMainManager)localObject1).e();
            return;
            if (1 != paramInt2) {
              break;
            }
            localObject2 = a();
            if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (localObject2 == null))
            {
              QLog.w(jdField_a_of_type_JavaLangString, 1, "null error.");
              return;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId != paramInt1)
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
            this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler = new GeneralEventHandler((Activity)localObject2, (QQAppInterface)localObject1, this.b);
            CmGameCmdChannel.a((QQAppInterface)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler);
            if ((!CmGameUtil.a(this.b)) && (!CmGameUtil.b(this.b)))
            {
              CmGameMainManager localCmGameMainManager = new CmGameMainManager((Activity)localObject2, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
              this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler = new CmGameHandler((Activity)localObject2, localCmGameMainManager, this.b);
              CmGameCmdChannel.a((QQAppInterface)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler);
              localCmGameMainManager.a((Activity)localObject2);
              localCmGameMainManager.f();
              localCmGameMainManager.g();
              return;
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null);
          QLog.e(jdField_a_of_type_JavaLangString, 1, "land or game box game data not exit");
          ApolloGameUtil.a((AppInterface)localObject1, 0L);
          return;
        } while (5 != paramInt2);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler != null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler.a();
          if (localObject2 != null) {
            ((CmGameMainManager)localObject2).j();
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler.a();
          CmGameCmdChannel.a((QQAppInterface)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler);
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler = null;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler.a();
          CmGameCmdChannel.a((QQAppInterface)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler);
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelGeneralEventHandler = null;
        }
      } while ((CmGameUtil.a(this.b)) || (CmGameUtil.b(this.b)) || (a() == null));
      localObject1 = (ApolloManagerServiceImpl)((QQAppInterface)localObject1).getRuntimeService(IApolloManagerService.class, "all");
    } while ((localObject1 == null) || (!((ApolloManagerServiceImpl)localObject1).isPlusWhiteList()) || (CmGameUtil.a(null)) || (((ApolloManagerServiceImpl)localObject1).isNeedShowWorldCup()) || (((ApolloManagerServiceImpl)localObject1).is765GuideShowed()) || (((ApolloManagerServiceImpl)localObject1).is780GuideShowed()) || (this.jdField_a_of_type_JavaLangRefWeakReference == null));
    ((ApolloManagerServiceImpl)localObject1).setClickIgnore(false);
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src != 319) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src != 318)) {
      CmGameUtil.a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "plus status first play goBackToPlus");
  }
  
  public void a(Activity paramActivity, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler != null)
    {
      CmGameMainManager localCmGameMainManager = this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler.a();
      if ((localCmGameMainManager != null) && (localCmGameMainManager.a)) {
        ThreadManagerV2.getUIHandlerV2().post(new CmGameLifeCycle.1(this, localCmGameMainManager));
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler != null)
    {
      CmGameMainManager localCmGameMainManager = this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameHandler.a();
      if ((localCmGameMainManager != null) && (localCmGameMainManager.a)) {
        localCmGameMainManager.h();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLifeCycle
 * JD-Core Version:    0.7.0.1
 */