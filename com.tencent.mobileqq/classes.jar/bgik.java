import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public abstract class bgik
  extends ntf
{
  public bgik()
  {
    super(false);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i(".troop.troop_app", 2, "clickReport errorCode = " + paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
  
  protected abstract void a(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgik
 * JD-Core Version:    0.7.0.1
 */