package com.tencent.mobileqq.activity.selectmember;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.NearFieldDiscussHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

class CreateFaceToFaceDiscussionActivity$10$1
  extends SosoInterfaceOnLocationListener
{
  CreateFaceToFaceDiscussionActivity$10$1(CreateFaceToFaceDiscussionActivity.10 param10, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null))
    {
      paramSosoLbsInfo = CreateFaceToFaceDiscussionActivity.access$800(this.a.this$0, paramSosoLbsInfo);
      NearFieldDiscussHandler localNearFieldDiscussHandler = (NearFieldDiscussHandler)this.a.this$0.app.getBusinessHandler(BusinessHandlerFactory.NEARFIELD_DISCUSS_HANDLER);
      paramInt = this.a.a;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt != 4) {
                return;
              }
              localNearFieldDiscussHandler.a(this.a.this$0.digits.toString(), this.a.this$0.mSessionId, paramSosoLbsInfo);
              return;
            }
            localNearFieldDiscussHandler.a(this.a.this$0.digits.toString(), this.a.this$0.mSessionId, paramSosoLbsInfo, false);
            return;
          }
          localNearFieldDiscussHandler.a(this.a.this$0.digits.toString(), this.a.this$0.mSessionId, paramSosoLbsInfo, true);
          return;
        }
        localNearFieldDiscussHandler.a(this.a.this$0.digits.toString(), this.a.this$0.mSessionId, paramSosoLbsInfo, 2, this.a.this$0.createSource);
        return;
      }
      localNearFieldDiscussHandler.a(this.a.this$0.digits.toString(), this.a.this$0.mSessionId, paramSosoLbsInfo, this.a.this$0.TYPE_DISCUSS, this.a.this$0.createSource);
      return;
    }
    paramSosoLbsInfo = this.a.this$0.mHandler.obtainMessage(2);
    paramSosoLbsInfo.arg1 = 1;
    paramSosoLbsInfo.arg2 = 2131698973;
    paramSosoLbsInfo.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity.10.1
 * JD-Core Version:    0.7.0.1
 */