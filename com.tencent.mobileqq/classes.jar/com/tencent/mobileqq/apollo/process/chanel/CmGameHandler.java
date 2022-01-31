package com.tencent.mobileqq.apollo.process.chanel;

import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.aioChannel.HandleResult;
import com.tencent.mobileqq.apollo.process.data.CmGameMainManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class CmGameHandler
  implements CmGameCmdChannel.IRequestHandler
{
  private int jdField_a_of_type_Int;
  private CmGameMainManager jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameMainManager;
  public WeakReference a;
  
  public CmGameHandler(Activity paramActivity, CmGameMainManager paramCmGameMainManager, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameMainManager = paramCmGameMainManager;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 200;
  }
  
  public HandleResult a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) || (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameMainManager == null)) {}
    do
    {
      do
      {
        return null;
        if (this.jdField_a_of_type_Int == paramInt2) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("CmGameHandler", 2, new Object[] { "not the same gameId, self:", Integer.valueOf(this.jdField_a_of_type_Int), "cmd gameId:", Integer.valueOf(paramInt2), ",cmd:", paramString1 });
      return null;
      if ("cs.first_frame_drawn.local".equals(paramString1))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameMainManager.e(paramString2);
        return null;
      }
      if ("cs.create_room.local".equals(paramString1))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameMainManager.f(paramString2);
        return null;
      }
      if ("cs.join_room.local".equals(paramString1))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameMainManager.g(paramString2);
        return null;
      }
      if ("cs.game_start.local".equals(paramString1))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameMainManager.h(paramString2);
        return null;
      }
      if ("cs.make_room_min.local".equals(paramString1))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameMainManager.b();
        return null;
      }
      if ("cs.close_room.local".equals(paramString1))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameMainManager.c();
        return null;
      }
      if ("cs.game_tips.local".equals(paramString1))
      {
        paramString1 = ApolloUtil.a(paramString2, "tips");
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameMainManager.i(paramString1);
        return null;
      }
      if ("cs.check_pubAccount_state.local".equals(paramString1))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameMainManager.a(paramString2, paramInt1);
        return null;
      }
    } while (!"cs.on_get_open_key.local".equals(paramString1));
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameMainManager.b(paramString2, paramInt1);
    return null;
  }
  
  public CmGameMainManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameMainManager;
  }
  
  public void a()
  {
    QLog.i("CmGameHandler", 1, "[destroyHandler]");
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameMainManager = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameHandler
 * JD-Core Version:    0.7.0.1
 */