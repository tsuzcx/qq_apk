import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class batz
  extends Handler
{
  protected WeakReference<batx> a;
  
  public batz(batx parambatx1, Looper paramLooper, batx parambatx2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambatx2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    batx localbatx = (batx)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localbatx == null) {
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
            batx.a(localbatx, (baua)paramMessage.obj);
            return;
          }
          throw new RuntimeException("bundle == null");
        case 1: 
          if ((batx.a(this.jdField_a_of_type_Batx)) || (batx.a(this.jdField_a_of_type_Batx) == null) || (!batx.a(this.jdField_a_of_type_Batx).a)) {
            break label187;
          }
          sendEmptyMessageDelayed(1, 100L);
        }
      } while ((!QLog.isColorLevel()) || (!QLog.isColorLevel()));
      QLog.d("HWVideoRecorder", 2, "Thumbnail is not ready. Wait 100ms and retry.");
      return;
      batx.a(localbatx);
      return;
      if (paramMessage.obj != null)
      {
        paramMessage = (Object[])paramMessage.obj;
        if ((paramMessage == null) || (paramMessage.length != 5)) {
          throw new IllegalArgumentException("args == null || args.length != 6");
        }
        localbatx.b(((Integer)paramMessage[0]).intValue(), ((Integer)paramMessage[1]).intValue(), (float[])paramMessage[2], (float[])paramMessage[3], ((Long)paramMessage[4]).longValue());
        return;
      }
      throw new RuntimeException("bundle == null");
    } while (batx.a(this.jdField_a_of_type_Batx) == null);
    batx.a(this.jdField_a_of_type_Batx).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     batz
 * JD-Core Version:    0.7.0.1
 */