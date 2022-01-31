import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

class baqh
  implements Observer
{
  baqh(baqg parambaqg) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SignatureFontAdapter", 2, "SignatureFontAdapter type = " + paramObject);
    }
    if ((paramObject instanceof Integer))
    {
      switch (((Integer)paramObject).intValue())
      {
      default: 
        return;
      case 1: 
        baqg.a(this.a).a().sendEmptyMessage(10003);
        return;
      }
      baqg.a(this.a).a().sendEmptyMessage(10002);
      return;
    }
    baqg.a(this.a).a().sendEmptyMessage(10003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     baqh
 * JD-Core Version:    0.7.0.1
 */