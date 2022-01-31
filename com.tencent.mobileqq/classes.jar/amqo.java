import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import cooperation.qqpim.QQPimDefineList;
import cooperation.qqpim.QQPimGetTipsInfoIPC;

public class amqo
  implements Runnable
{
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public amqo(QQPimGetTipsInfoIPC paramQQPimGetTipsInfoIPC, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public void run()
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString(QQPimDefineList.l, this.jdField_a_of_type_JavaLangString);
      localBundle.putString(QQPimDefineList.m, this.b);
      QIPCServerHelper.getInstance().callClient(QQPimDefineList.b, QQPimDefineList.c, QQPimDefineList.d, localBundle, new amqp(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amqo
 * JD-Core Version:    0.7.0.1
 */