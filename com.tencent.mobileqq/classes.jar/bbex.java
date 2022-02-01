import com.tencent.qphone.base.util.QLog;
import rx.functions.Action1;

class bbex
  implements Action1<Throwable>
{
  bbex(bbev parambbev) {}
  
  public void a(Throwable paramThrowable)
  {
    QLog.d("ResourceGrabModel", 1, paramThrowable, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbex
 * JD-Core Version:    0.7.0.1
 */