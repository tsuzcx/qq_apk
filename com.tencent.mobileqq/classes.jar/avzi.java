import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class avzi
  extends Handler
{
  protected WeakReference<avzh> a;
  
  public avzi(avzh paramavzh1, Looper paramLooper, avzh paramavzh2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramavzh2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    avzh localavzh = (avzh)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localavzh == null)
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
        localavzh.a((byte[])paramMessage[0], ((Long)paramMessage[1]).longValue(), false);
        return;
      }
      catch (Exception paramMessage)
      {
        QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler encode audio fail.", paramMessage);
        avzh.a(this.jdField_a_of_type_Avzh);
        return;
      }
    case 2: 
      this.jdField_a_of_type_Avzh.a();
      return;
    case 3: 
      paramMessage = (String)paramMessage.obj;
      try
      {
        avzh.a(this.jdField_a_of_type_Avzh, paramMessage);
        return;
      }
      catch (Exception paramMessage)
      {
        QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler start fail.", paramMessage);
        avzh.a(this.jdField_a_of_type_Avzh);
        return;
      }
    }
    this.jdField_a_of_type_Avzh.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avzi
 * JD-Core Version:    0.7.0.1
 */