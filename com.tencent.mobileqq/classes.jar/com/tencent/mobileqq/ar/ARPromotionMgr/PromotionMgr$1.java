package com.tencent.mobileqq.ar.ARPromotionMgr;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.SyncLoadTask;
import com.tencent.mobileqq.utils.SyncLoadTask.OnSyncTaskListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class PromotionMgr$1
  implements SyncLoadTask.OnSyncTaskListener
{
  PromotionMgr$1(PromotionMgr paramPromotionMgr, AppInterface paramAppInterface, String paramString, PromotionMgr.GetConfigListen paramGetConfigListen) {}
  
  public void a(boolean paramBoolean, ArrayList<SyncLoadTask> paramArrayList)
  {
    paramArrayList = (ReadConfigTask)paramArrayList.get(0);
    Object localObject;
    if ((PromotionMgr.a(this.d) != null) && (PromotionMgr.a(this.d) == paramArrayList) && (this.a != null))
    {
      localObject = this.d.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("异步加载config返回, bsuc[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], TAG[");
      localStringBuilder.append(paramArrayList.mTAG);
      localStringBuilder.append("], isEnableFromLocal[");
      localStringBuilder.append(PromotionDevice.c());
      localStringBuilder.append("], config[");
      localStringBuilder.append(paramArrayList.a);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      if (paramBoolean)
      {
        this.d.a(paramArrayList.a);
        this.d.b(this.a);
      }
      PromotionMgr.a(this.d, null);
    }
    else
    {
      paramArrayList = this.d.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("异步加载config返回[");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("], 但原请求取消了");
      QLog.w(paramArrayList, 1, ((StringBuilder)localObject).toString());
    }
    paramArrayList = this.c;
    if (paramArrayList != null) {
      paramArrayList.a(this.d.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionMgr.1
 * JD-Core Version:    0.7.0.1
 */