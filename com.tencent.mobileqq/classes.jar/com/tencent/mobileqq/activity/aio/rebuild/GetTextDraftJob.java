package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class GetTextDraftJob
  implements Runnable
{
  private MqqHandler a;
  private BaseSessionInfo b;
  private DraftTextManager c;
  private WeakReference<QQAppInterface> d;
  private WeakReference<BaseChatPie> e;
  
  public GetTextDraftJob(MqqHandler paramMqqHandler, BaseSessionInfo paramBaseSessionInfo, QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie)
  {
    this.a = paramMqqHandler;
    this.b = paramBaseSessionInfo;
    this.d = new WeakReference(paramQQAppInterface);
    this.e = new WeakReference(paramBaseChatPie);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GetTextDraftJob", 2, "getting text draft");
    }
    Object localObject = (QQAppInterface)this.d.get();
    if (localObject == null)
    {
      QLog.e("Q.aio.BaseChatPie", 1, "AIO---GetTextDraftJob app == null");
      return;
    }
    if (this.c == null) {
      this.c = DraftTextManager.a((QQAppInterface)localObject);
    }
    localObject = this.c.e((QQAppInterface)localObject, this.b.b, this.b.a);
    if ((localObject != null) && (((DraftTextInfo)localObject).sourceMsgText != null))
    {
      this.a.postDelayed(new GetTextDraftJob.1(this, (DraftTextInfo)localObject), 500L);
      return;
    }
    this.a.post(new GetTextDraftJob.2(this, (DraftTextInfo)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GetTextDraftJob
 * JD-Core Version:    0.7.0.1
 */