package com.tencent.mobileqq.apollo;

import amlm;
import amln;
import amvg;
import android.os.Handler;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class ApolloBrickPlayer$1
  implements Runnable
{
  public ApolloBrickPlayer$1(amlm paramamlm) {}
  
  public void run()
  {
    Object localObject = (String)amlm.a().get(this.this$0.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction.a(null, null));
    if (localObject != null)
    {
      localObject = amlm.a((String)localObject, amlm.a(this.this$0));
      amlm.a(this.this$0).post(new ApolloBrickPlayer.1.1(this, (URLDrawable)localObject));
    }
    do
    {
      return;
      this.this$0.jdField_a_of_type_Amvg.a(null, this.this$0.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction, new amln(amlm.a(this.this$0), amlm.a(this.this$0), amlm.b(this.this$0), amlm.a(this.this$0), amlm.a(this.this$0), amlm.a(this.this$0)));
      amlm.a(this.this$0).post(new ApolloBrickPlayer.1.2(this));
    } while (!QLog.isColorLevel());
    QLog.d("ApolloBrickPlayer", 2, "start recordAction " + amlm.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloBrickPlayer.1
 * JD-Core Version:    0.7.0.1
 */