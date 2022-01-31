import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class avzg
  extends Handler
{
  protected WeakReference<avzf> a;
  
  public avzg(avzf paramavzf1, Looper paramLooper, avzf paramavzf2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramavzf2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    avzf localavzf = (avzf)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localavzf == null)
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
        localavzf.a((byte[])paramMessage[0], ((Long)paramMessage[1]).longValue(), false);
        return;
      }
      catch (Exception paramMessage)
      {
        QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler encode audio fail.", paramMessage);
        avzf.a(this.jdField_a_of_type_Avzf);
        return;
      }
    case 2: 
      this.jdField_a_of_type_Avzf.a();
      return;
    case 3: 
      paramMessage = (String)paramMessage.obj;
      try
      {
        avzf.a(this.jdField_a_of_type_Avzf, paramMessage);
        return;
      }
      catch (Exception paramMessage)
      {
        QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler start fail.", paramMessage);
        avzf.a(this.jdField_a_of_type_Avzf);
        return;
      }
    }
    this.jdField_a_of_type_Avzf.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avzg
 * JD-Core Version:    0.7.0.1
 */