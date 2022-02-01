package com.tencent.mobileqq.activity.aio.rebuild;

import awtg;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class GetTextDraftJob
  implements Runnable
{
  private awtg jdField_a_of_type_Awtg;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private WeakReference<BaseChatPie> b;
  
  public GetTextDraftJob(MqqHandler paramMqqHandler, SessionInfo paramSessionInfo, awtg paramawtg, QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Awtg = paramawtg;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramBaseChatPie);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GetTextDraftJob", 2, "getting text draft");
    }
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      QLog.e("Q.aio.BaseChatPie", 1, "AIO---GetTextDraftJob app == null");
      return;
    }
    if (this.jdField_a_of_type_Awtg == null)
    {
      QLog.e("Q.aio.BaseChatPie", 1, "AIO---GetTextDraftJob mDraftManager == null");
      return;
    }
    localObject = this.jdField_a_of_type_Awtg.b((QQAppInterface)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    if ((localObject != null) && (((DraftTextInfo)localObject).sourceMsgText != null))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new GetTextDraftJob.1(this, (DraftTextInfo)localObject), 500L);
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new GetTextDraftJob.2(this, (DraftTextInfo)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GetTextDraftJob
 * JD-Core Version:    0.7.0.1
 */