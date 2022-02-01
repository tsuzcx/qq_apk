import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bbmk
  extends Handler
{
  protected WeakReference<bbmj> a;
  
  public bbmk(bbmj parambbmj1, Looper paramLooper, bbmj parambbmj2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambbmj2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bbmj localbbmj = (bbmj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localbbmj == null)
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
        localbbmj.a((byte[])paramMessage[0], ((Long)paramMessage[1]).longValue(), false);
        return;
      }
      catch (Exception paramMessage)
      {
        QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler encode audio fail.", paramMessage);
        bbmj.a(this.jdField_a_of_type_Bbmj);
        return;
      }
    case 2: 
      this.jdField_a_of_type_Bbmj.a();
      return;
    case 3: 
      paramMessage = (String)paramMessage.obj;
      try
      {
        bbmj.a(this.jdField_a_of_type_Bbmj, paramMessage);
        return;
      }
      catch (Exception paramMessage)
      {
        QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler start fail.", paramMessage);
        bbmj.a(this.jdField_a_of_type_Bbmj);
        return;
      }
    }
    this.jdField_a_of_type_Bbmj.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmk
 * JD-Core Version:    0.7.0.1
 */