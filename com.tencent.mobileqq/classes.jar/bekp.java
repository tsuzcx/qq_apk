import com.tencent.TMG.utils.QLog;
import java.util.Observable;

public class bekp
  extends Observable
{
  private boolean a;
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClockAnimController", 0, "notifyAnimChanged : nEventId = " + paramInt);
    }
    if (paramInt == 1) {
      this.a = true;
    }
    if (paramInt == 4) {
      this.a = false;
    }
    setChanged();
    notifyObservers(Integer.valueOf(paramInt));
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClockAnimController", 0, "isPlayAnim : isPlayAnim = " + this.a);
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bekp
 * JD-Core Version:    0.7.0.1
 */