import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class axvy
  extends Handler
{
  protected WeakReference<axvw> a;
  
  public axvy(axvw paramaxvw1, Looper paramLooper, axvw paramaxvw2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaxvw2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    axvw localaxvw = (axvw)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localaxvw == null) {
      if (QLog.isColorLevel()) {
        QLog.w("HWVideoRecorder", 2, "RecodeHandler.handleMessage: encoder is null");
      }
    }
    label187:
    do
    {
      do
      {
        return;
        switch (i)
        {
        default: 
          throw new RuntimeException("Unhandled msg what=" + i);
        case 0: 
          if (paramMessage.obj != null)
          {
            axvw.a(localaxvw, (axvz)paramMessage.obj);
            return;
          }
          throw new RuntimeException("bundle == null");
        case 1: 
          if ((axvw.a(this.jdField_a_of_type_Axvw)) || (axvw.a(this.jdField_a_of_type_Axvw) == null) || (!axvw.a(this.jdField_a_of_type_Axvw).a)) {
            break label187;
          }
          sendEmptyMessageDelayed(1, 100L);
        }
      } while ((!QLog.isColorLevel()) || (!QLog.isColorLevel()));
      QLog.d("HWVideoRecorder", 2, "Thumbnail is not ready. Wait 100ms and retry.");
      return;
      axvw.a(localaxvw);
      return;
      if (paramMessage.obj != null)
      {
        paramMessage = (Object[])paramMessage.obj;
        if ((paramMessage == null) || (paramMessage.length != 5)) {
          throw new IllegalArgumentException("args == null || args.length != 6");
        }
        localaxvw.b(((Integer)paramMessage[0]).intValue(), ((Integer)paramMessage[1]).intValue(), (float[])paramMessage[2], (float[])paramMessage[3], ((Long)paramMessage[4]).longValue());
        return;
      }
      throw new RuntimeException("bundle == null");
    } while (axvw.a(this.jdField_a_of_type_Axvw) == null);
    axvw.a(this.jdField_a_of_type_Axvw).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axvy
 * JD-Core Version:    0.7.0.1
 */