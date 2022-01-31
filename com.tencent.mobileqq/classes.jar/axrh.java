import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class axrh
  extends Handler
{
  protected WeakReference<axrg> a;
  
  public axrh(axrg paramaxrg1, Looper paramLooper, axrg paramaxrg2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaxrg2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    axrg localaxrg = (axrg)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localaxrg == null)
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
        localaxrg.a((byte[])paramMessage[0], ((Long)paramMessage[1]).longValue(), false);
        return;
      }
      catch (Exception paramMessage)
      {
        QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler encode audio fail.", paramMessage);
        axrg.a(this.jdField_a_of_type_Axrg);
        return;
      }
    case 2: 
      this.jdField_a_of_type_Axrg.a();
      return;
    case 3: 
      paramMessage = (String)paramMessage.obj;
      try
      {
        axrg.a(this.jdField_a_of_type_Axrg, paramMessage);
        return;
      }
      catch (Exception paramMessage)
      {
        QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler start fail.", paramMessage);
        axrg.a(this.jdField_a_of_type_Axrg);
        return;
      }
    }
    this.jdField_a_of_type_Axrg.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axrh
 * JD-Core Version:    0.7.0.1
 */