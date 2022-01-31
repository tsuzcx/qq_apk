import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class asee
  extends alrl
{
  asee(aseb paramaseb) {}
  
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
        paramString1 = alud.a(2131705217);
        aseb.c(this.a, null);
        aseb.a(this.a, false);
        QQToast.a(this.a.a, 1, paramString1, 0).b(((BaseActivity)this.a.a).getTitleBarHeight());
      }
    }
    while ((aseb.c(this.a) == null) || (Long.parseLong(aseb.c(this.a)) != paramLong2)) {
      for (;;)
      {
        return;
        paramString1 = alud.a(2131705224);
        continue;
        paramString1 = alud.a(2131705223);
      }
    }
    if (aseb.a(this.a))
    {
      aseb.c(this.a, paramString1);
      aseb.a(this.a, aseb.c(this.a), true);
    }
    aseb.a(this.a, false);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ForwardOption.ForwardShareCardOption", 2, "onUpdateDiscussionFaceIcon|[" + paramBoolean1 + ", " + paramString + "]");
    }
    if ((aseb.c(this.a) != null) && (aseb.c(this.a).equals(paramString))) {
      aseb.a(this.a, aseb.c(this.a), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asee
 * JD-Core Version:    0.7.0.1
 */