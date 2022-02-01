import android.os.Handler;
import android.os.Message;
import java.util.List;

class asdy
  extends anub
{
  asdy(asdv paramasdv) {}
  
  public void onDelEmoResponse(boolean paramBoolean)
  {
    asdv.a(this.a).clear();
  }
  
  protected void onModifyFavData(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.a != null)) {
      this.a.a.e();
    }
  }
  
  protected void onUpdateFavData(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Integer)) && (asdv.a(this.a) != null)) {
      asdv.a(this.a).obtainMessage(208, paramObject).sendToTarget();
    }
    if ((this.a.a != null) && (paramBoolean)) {
      this.a.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asdy
 * JD-Core Version:    0.7.0.1
 */