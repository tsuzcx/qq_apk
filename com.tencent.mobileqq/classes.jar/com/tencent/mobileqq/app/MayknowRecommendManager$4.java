package com.tencent.mobileqq.app;

import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import com.tencent.qphone.base.util.QLog;

class MayknowRecommendManager$4
  implements IPhoneContactListener
{
  MayknowRecommendManager$4(MayknowRecommendManager paramMayknowRecommendManager) {}
  
  public void a(int paramInt)
  {
    boolean bool1 = MayknowRecommendManager.b(this.a);
    MayknowRecommendManager.a(this.a, false);
    boolean bool2 = this.a.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBindStateChanged last:");
      localStringBuilder.append(bool1);
      localStringBuilder.append("  now:");
      localStringBuilder.append(bool2);
      QLog.i("MayknowRecommendManager", 2, localStringBuilder.toString());
    }
    if (bool1 != bool2) {
      ((FriendListHandler)MayknowRecommendManager.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(90, true, null);
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void b(int paramInt) {}
  
  public void c(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.4
 * JD-Core Version:    0.7.0.1
 */