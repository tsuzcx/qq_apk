import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class aqgg
  extends ajvj
{
  aqgg(aqgd paramaqgd) {}
  
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
        paramString1 = ajya.a(2131704833);
        aqgd.c(this.a, null);
        aqgd.a(this.a, false);
        bcql.a(this.a.a, 1, paramString1, 0).b(((BaseActivity)this.a.a).getTitleBarHeight());
      }
    }
    while ((aqgd.c(this.a) == null) || (Long.parseLong(aqgd.c(this.a)) != paramLong2)) {
      for (;;)
      {
        return;
        paramString1 = ajya.a(2131704840);
        continue;
        paramString1 = ajya.a(2131704839);
      }
    }
    if (aqgd.a(this.a))
    {
      aqgd.c(this.a, paramString1);
      aqgd.a(this.a, aqgd.c(this.a), true);
    }
    aqgd.a(this.a, false);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ForwardOption.ForwardShareCardOption", 2, "onUpdateDiscussionFaceIcon|[" + paramBoolean1 + ", " + paramString + "]");
    }
    if ((aqgd.c(this.a) != null) && (aqgd.c(this.a).equals(paramString))) {
      aqgd.a(this.a, aqgd.c(this.a), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqgg
 * JD-Core Version:    0.7.0.1
 */