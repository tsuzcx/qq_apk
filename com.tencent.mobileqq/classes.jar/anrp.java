import android.os.Handler;
import android.os.Message;
import java.util.List;

class anrp
  extends ajvz
{
  anrp(anrm paramanrm) {}
  
  public void a(boolean paramBoolean)
  {
    anrm.a(this.a).clear();
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.a != null)) {
      this.a.a.e();
    }
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Integer)) && (anrm.a(this.a) != null)) {
      anrm.a(this.a).obtainMessage(208, paramObject).sendToTarget();
    }
    if ((this.a.a != null) && (paramBoolean)) {
      this.a.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anrp
 * JD-Core Version:    0.7.0.1
 */