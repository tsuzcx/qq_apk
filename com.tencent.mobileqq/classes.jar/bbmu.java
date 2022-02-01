import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bbmu
  extends Handler
{
  protected WeakReference<bbmt> a;
  
  public bbmu(bbmt parambbmt1, Looper paramLooper, bbmt parambbmt2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambbmt2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bbmt localbbmt = (bbmt)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localbbmt == null)
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
        localbbmt.a((byte[])paramMessage[0], ((Long)paramMessage[1]).longValue(), false);
        return;
      }
      catch (Exception paramMessage)
      {
        QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler encode audio fail.", paramMessage);
        bbmt.a(this.jdField_a_of_type_Bbmt);
        return;
      }
    case 2: 
      this.jdField_a_of_type_Bbmt.a();
      return;
    case 3: 
      paramMessage = (String)paramMessage.obj;
      try
      {
        bbmt.a(this.jdField_a_of_type_Bbmt, paramMessage);
        return;
      }
      catch (Exception paramMessage)
      {
        QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler start fail.", paramMessage);
        bbmt.a(this.jdField_a_of_type_Bbmt);
        return;
      }
    }
    this.jdField_a_of_type_Bbmt.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmu
 * JD-Core Version:    0.7.0.1
 */