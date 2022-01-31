import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class apmq
  extends ajhi
{
  apmq(apmn paramapmn) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardShareCardOption", 2, "onGetFlyTicket: " + paramBoolean + " sigUrl=" + paramString1);
    }
    if (!paramBoolean)
    {
      this.a.x();
      switch (paramInt)
      {
      default: 
        paramString1 = ajjy.a(2131639037);
        apmn.c(this.a, null);
        apmn.a(this.a, false);
        bbmy.a(this.a.a, 1, paramString1, 0).b(((BaseActivity)this.a.a).getTitleBarHeight());
      }
    }
    while ((apmn.c(this.a) == null) || (Long.parseLong(apmn.c(this.a)) != paramLong2)) {
      for (;;)
      {
        return;
        paramString1 = ajjy.a(2131639044);
        continue;
        paramString1 = ajjy.a(2131639043);
      }
    }
    if (apmn.a(this.a))
    {
      apmn.c(this.a, paramString1);
      apmn.a(this.a, apmn.c(this.a), true);
    }
    apmn.a(this.a, false);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ForwardOption.ForwardShareCardOption", 2, "onUpdateDiscussionFaceIcon|[" + paramBoolean1 + ", " + paramString + "]");
    }
    if ((apmn.c(this.a) != null) && (apmn.c(this.a).equals(paramString))) {
      apmn.a(this.a, apmn.c(this.a), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apmq
 * JD-Core Version:    0.7.0.1
 */