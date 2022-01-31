import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class arzv
  extends almw
{
  arzv(arzs paramarzs) {}
  
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
        paramString1 = alpo.a(2131705205);
        arzs.c(this.a, null);
        arzs.a(this.a, false);
        QQToast.a(this.a.a, 1, paramString1, 0).b(((BaseActivity)this.a.a).getTitleBarHeight());
      }
    }
    while ((arzs.c(this.a) == null) || (Long.parseLong(arzs.c(this.a)) != paramLong2)) {
      for (;;)
      {
        return;
        paramString1 = alpo.a(2131705212);
        continue;
        paramString1 = alpo.a(2131705211);
      }
    }
    if (arzs.a(this.a))
    {
      arzs.c(this.a, paramString1);
      arzs.a(this.a, arzs.c(this.a), true);
    }
    arzs.a(this.a, false);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ForwardOption.ForwardShareCardOption", 2, "onUpdateDiscussionFaceIcon|[" + paramBoolean1 + ", " + paramString + "]");
    }
    if ((arzs.c(this.a) != null) && (arzs.c(this.a).equals(paramString))) {
      arzs.a(this.a, arzs.c(this.a), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzv
 * JD-Core Version:    0.7.0.1
 */