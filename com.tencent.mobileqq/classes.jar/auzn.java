import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class auzn
  extends Handler
{
  protected WeakReference<auzm> a;
  
  public auzn(auzm paramauzm1, Looper paramLooper, auzm paramauzm2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramauzm2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    auzm localauzm = (auzm)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localauzm == null)
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
        localauzm.a((byte[])paramMessage[0], ((Long)paramMessage[1]).longValue(), false);
        return;
      }
      catch (Exception paramMessage)
      {
        QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler encode audio fail.", paramMessage);
        auzm.a(this.jdField_a_of_type_Auzm);
        return;
      }
    case 2: 
      this.jdField_a_of_type_Auzm.a();
      return;
    case 3: 
      paramMessage = (String)paramMessage.obj;
      try
      {
        auzm.a(this.jdField_a_of_type_Auzm, paramMessage);
        return;
      }
      catch (Exception paramMessage)
      {
        QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler start fail.", paramMessage);
        auzm.a(this.jdField_a_of_type_Auzm);
        return;
      }
    }
    this.jdField_a_of_type_Auzm.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     auzn
 * JD-Core Version:    0.7.0.1
 */