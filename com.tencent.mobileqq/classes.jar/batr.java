import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class batr
  extends Handler
{
  protected WeakReference<batq> a;
  
  public batr(batq parambatq1, Looper paramLooper, batq parambatq2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambatq2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    batq localbatq = (batq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localbatq == null)
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
        localbatq.a((byte[])paramMessage[0], ((Long)paramMessage[1]).longValue(), false);
        return;
      }
      catch (Exception paramMessage)
      {
        QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler encode audio fail.", paramMessage);
        batq.a(this.jdField_a_of_type_Batq);
        return;
      }
    case 2: 
      this.jdField_a_of_type_Batq.a();
      return;
    case 3: 
      paramMessage = (String)paramMessage.obj;
      try
      {
        batq.a(this.jdField_a_of_type_Batq, paramMessage);
        return;
      }
      catch (Exception paramMessage)
      {
        QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler start fail.", paramMessage);
        batq.a(this.jdField_a_of_type_Batq);
        return;
      }
    }
    this.jdField_a_of_type_Batq.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     batr
 * JD-Core Version:    0.7.0.1
 */