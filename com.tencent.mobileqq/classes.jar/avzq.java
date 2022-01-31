import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class avzq
  extends Handler
{
  protected WeakReference<avzo> a;
  
  public avzq(avzo paramavzo1, Looper paramLooper, avzo paramavzo2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramavzo2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    avzo localavzo = (avzo)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localavzo == null) {
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
            avzo.a(localavzo, (avzr)paramMessage.obj);
            return;
          }
          throw new RuntimeException("bundle == null");
        case 1: 
          if ((avzo.a(this.jdField_a_of_type_Avzo)) || (avzo.a(this.jdField_a_of_type_Avzo) == null) || (!avzo.a(this.jdField_a_of_type_Avzo).a)) {
            break label187;
          }
          sendEmptyMessageDelayed(1, 100L);
        }
      } while ((!QLog.isColorLevel()) || (!QLog.isColorLevel()));
      QLog.d("HWVideoRecorder", 2, "Thumbnail is not ready. Wait 100ms and retry.");
      return;
      avzo.a(localavzo);
      return;
      if (paramMessage.obj != null)
      {
        paramMessage = (Object[])paramMessage.obj;
        if ((paramMessage == null) || (paramMessage.length != 5)) {
          throw new IllegalArgumentException("args == null || args.length != 6");
        }
        localavzo.b(((Integer)paramMessage[0]).intValue(), ((Integer)paramMessage[1]).intValue(), (float[])paramMessage[2], (float[])paramMessage[3], ((Long)paramMessage[4]).longValue());
        return;
      }
      throw new RuntimeException("bundle == null");
    } while (avzo.a(this.jdField_a_of_type_Avzo) == null);
    avzo.a(this.jdField_a_of_type_Avzo).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avzq
 * JD-Core Version:    0.7.0.1
 */