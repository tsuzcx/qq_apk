import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class axvq
  extends Handler
{
  protected WeakReference<axvp> a;
  
  public axvq(axvp paramaxvp1, Looper paramLooper, axvp paramaxvp2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaxvp2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    axvp localaxvp = (axvp)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localaxvp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("HWAudioEncoder", 2, "AudioEncodeHandler.handleMessage: encoder is null");
      }
      return;
    }
    int i = paramMessage.what;
    switch (i)
    {
    default: 
      throw new RuntimeException("Unhandled msg what=" + i);
    case 1: 
      paramMessage = (Object[])paramMessage.obj;
      try
      {
        localaxvp.a((byte[])paramMessage[0], ((Long)paramMessage[1]).longValue(), false);
        return;
      }
      catch (Exception paramMessage)
      {
        QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler encode audio fail.", paramMessage);
        axvp.a(this.jdField_a_of_type_Axvp);
        return;
      }
    case 2: 
      this.jdField_a_of_type_Axvp.a();
      return;
    case 3: 
      paramMessage = (String)paramMessage.obj;
      try
      {
        axvp.a(this.jdField_a_of_type_Axvp, paramMessage);
        return;
      }
      catch (Exception paramMessage)
      {
        QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler start fail.", paramMessage);
        axvp.a(this.jdField_a_of_type_Axvp);
        return;
      }
    }
    this.jdField_a_of_type_Axvp.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axvq
 * JD-Core Version:    0.7.0.1
 */