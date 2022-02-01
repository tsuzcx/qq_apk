package com.tencent.mobileqq.app;

import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.qphone.base.util.QLog;

class MayknowRecommendManager$3
  implements PhoneContactManager.IPhoneContactListener
{
  MayknowRecommendManager$3(MayknowRecommendManager paramMayknowRecommendManager) {}
  
  public void a(int paramInt)
  {
    boolean bool1 = MayknowRecommendManager.b(this.a);
    MayknowRecommendManager.a(this.a, false);
    boolean bool2 = this.a.a();
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "onBindStateChanged last:" + bool1 + "  now:" + bool2);
    }
    if (bool1 != bool2) {
      ((FriendListHandler)MayknowRecommendManager.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(92, true, null);
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void b(int paramInt) {}
  
  public void c(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.3
 * JD-Core Version:    0.7.0.1
 */