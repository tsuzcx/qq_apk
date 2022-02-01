import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class bbnc
  extends Handler
{
  protected WeakReference<bbna> a;
  
  public bbnc(bbna parambbna1, Looper paramLooper, bbna parambbna2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambbna2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    bbna localbbna = (bbna)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localbbna == null) {
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
            bbna.a(localbbna, (bbnd)paramMessage.obj);
            return;
          }
          throw new RuntimeException("bundle == null");
        case 1: 
          if ((bbna.a(this.jdField_a_of_type_Bbna)) || (bbna.a(this.jdField_a_of_type_Bbna) == null) || (!bbna.a(this.jdField_a_of_type_Bbna).a)) {
            break label187;
          }
          sendEmptyMessageDelayed(1, 100L);
        }
      } while ((!QLog.isColorLevel()) || (!QLog.isColorLevel()));
      QLog.d("HWVideoRecorder", 2, "Thumbnail is not ready. Wait 100ms and retry.");
      return;
      bbna.a(localbbna);
      return;
      if (paramMessage.obj != null)
      {
        paramMessage = (Object[])paramMessage.obj;
        if ((paramMessage == null) || (paramMessage.length != 5)) {
          throw new IllegalArgumentException("args == null || args.length != 6");
        }
        localbbna.b(((Integer)paramMessage[0]).intValue(), ((Integer)paramMessage[1]).intValue(), (float[])paramMessage[2], (float[])paramMessage[3], ((Long)paramMessage[4]).longValue());
        return;
      }
      throw new RuntimeException("bundle == null");
    } while (bbna.a(this.jdField_a_of_type_Bbna) == null);
    bbna.a(this.jdField_a_of_type_Bbna).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbnc
 * JD-Core Version:    0.7.0.1
 */