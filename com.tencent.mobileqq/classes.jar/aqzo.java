import android.os.Handler;
import android.os.Message;
import java.util.List;

class aqzo
  extends amrn
{
  aqzo(aqzl paramaqzl) {}
  
  public void onDelEmoResponse(boolean paramBoolean)
  {
    aqzl.a(this.a).clear();
  }
  
  protected void onModifyFavData(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.a != null)) {
      this.a.a.e();
    }
  }
  
  protected void onUpdateFavData(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Integer)) && (aqzl.a(this.a) != null)) {
      aqzl.a(this.a).obtainMessage(208, paramObject).sendToTarget();
    }
    if ((this.a.a != null) && (paramBoolean)) {
      this.a.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqzo
 * JD-Core Version:    0.7.0.1
 */