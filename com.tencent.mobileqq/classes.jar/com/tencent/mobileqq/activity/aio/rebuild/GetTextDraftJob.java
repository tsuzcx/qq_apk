package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import vrk;

public class GetTextDraftJob
  implements Runnable
{
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private DraftTextManager jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private WeakReference b;
  
  public GetTextDraftJob(MqqHandler paramMqqHandler, SessionInfo paramSessionInfo, DraftTextManager paramDraftTextManager, QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager = paramDraftTextManager;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramBaseChatPie);
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      QLog.e("Q.aio.BaseChatPie", 1, "AIO---GetTextDraftJob app == null");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager == null)
    {
      QLog.e("Q.aio.BaseChatPie", 1, "AIO---GetTextDraftJob mDraftManager == null");
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.b((QQAppInterface)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    this.jdField_a_of_type_MqqOsMqqHandler.post(new vrk(this, (DraftTextInfo)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GetTextDraftJob
 * JD-Core Version:    0.7.0.1
 */