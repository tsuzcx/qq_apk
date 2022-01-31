import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class auzv
  extends Handler
{
  protected WeakReference<auzt> a;
  
  public auzv(auzt paramauzt1, Looper paramLooper, auzt paramauzt2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramauzt2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    auzt localauzt = (auzt)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localauzt == null) {
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
            auzt.a(localauzt, (auzw)paramMessage.obj);
            return;
          }
          throw new RuntimeException("bundle == null");
        case 1: 
          if ((auzt.a(this.jdField_a_of_type_Auzt)) || (auzt.a(this.jdField_a_of_type_Auzt) == null) || (!auzt.a(this.jdField_a_of_type_Auzt).a)) {
            break label187;
          }
          sendEmptyMessageDelayed(1, 100L);
        }
      } while ((!QLog.isColorLevel()) || (!QLog.isColorLevel()));
      QLog.d("HWVideoRecorder", 2, "Thumbnail is not ready. Wait 100ms and retry.");
      return;
      auzt.a(localauzt);
      return;
      if (paramMessage.obj != null)
      {
        paramMessage = (Object[])paramMessage.obj;
        if ((paramMessage == null) || (paramMessage.length != 5)) {
          throw new IllegalArgumentException("args == null || args.length != 6");
        }
        localauzt.b(((Integer)paramMessage[0]).intValue(), ((Integer)paramMessage[1]).intValue(), (float[])paramMessage[2], (float[])paramMessage[3], ((Long)paramMessage[4]).longValue());
        return;
      }
      throw new RuntimeException("bundle == null");
    } while (auzt.a(this.jdField_a_of_type_Auzt) == null);
    auzt.a(this.jdField_a_of_type_Auzt).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     auzv
 * JD-Core Version:    0.7.0.1
 */