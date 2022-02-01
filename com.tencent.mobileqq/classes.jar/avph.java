import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class avph
  extends Handler
{
  avph(avpg paramavpg, Looper paramLooper, avpf paramavpf)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    synchronized (avpf.a(this.jdField_a_of_type_Avpg.jdField_a_of_type_Avpf))
    {
      avpj localavpj = avpf.a(this.jdField_a_of_type_Avpg.jdField_a_of_type_Avpf, (String)paramMessage.obj);
      if (localavpj != null) {
        localavpj.a(paramMessage.what);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avph
 * JD-Core Version:    0.7.0.1
 */