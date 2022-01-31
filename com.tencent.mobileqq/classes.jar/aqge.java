import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class aqge
  extends ajvl
{
  aqge(aqgb paramaqgb) {}
  
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
        paramString1 = ajyc.a(2131704822);
        aqgb.c(this.a, null);
        aqgb.a(this.a, false);
        bcpw.a(this.a.a, 1, paramString1, 0).b(((BaseActivity)this.a.a).getTitleBarHeight());
      }
    }
    while ((aqgb.c(this.a) == null) || (Long.parseLong(aqgb.c(this.a)) != paramLong2)) {
      for (;;)
      {
        return;
        paramString1 = ajyc.a(2131704829);
        continue;
        paramString1 = ajyc.a(2131704828);
      }
    }
    if (aqgb.a(this.a))
    {
      aqgb.c(this.a, paramString1);
      aqgb.a(this.a, aqgb.c(this.a), true);
    }
    aqgb.a(this.a, false);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ForwardOption.ForwardShareCardOption", 2, "onUpdateDiscussionFaceIcon|[" + paramBoolean1 + ", " + paramString + "]");
    }
    if ((aqgb.c(this.a) != null) && (aqgb.c(this.a).equals(paramString))) {
      aqgb.a(this.a, aqgb.c(this.a), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqge
 * JD-Core Version:    0.7.0.1
 */