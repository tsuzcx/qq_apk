import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

class bdvw
  implements Observer
{
  bdvw(bdvv parambdvv) {}
  
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
        this.a.a.a().sendEmptyMessage(10003);
        return;
      }
      this.a.a.a().sendEmptyMessage(10002);
      return;
    }
    this.a.a.a().sendEmptyMessage(10003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvw
 * JD-Core Version:    0.7.0.1
 */