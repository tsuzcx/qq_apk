import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bagf
  extends Handler
{
  protected WeakReference<bage> a;
  
  public bagf(bage parambage1, Looper paramLooper, bage parambage2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambage2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bage localbage = (bage)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localbage == null)
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
        localbage.a((byte[])paramMessage[0], ((Long)paramMessage[1]).longValue(), false);
        return;
      }
      catch (Exception paramMessage)
      {
        QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler encode audio fail.", paramMessage);
        bage.a(this.jdField_a_of_type_Bage);
        return;
      }
    case 2: 
      this.jdField_a_of_type_Bage.a();
      return;
    case 3: 
      paramMessage = (String)paramMessage.obj;
      try
      {
        bage.a(this.jdField_a_of_type_Bage, paramMessage);
        return;
      }
      catch (Exception paramMessage)
      {
        QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler start fail.", paramMessage);
        bage.a(this.jdField_a_of_type_Bage);
        return;
      }
    }
    this.jdField_a_of_type_Bage.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagf
 * JD-Core Version:    0.7.0.1
 */