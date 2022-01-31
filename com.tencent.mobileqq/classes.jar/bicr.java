import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;

public class bicr
{
  private static volatile bicr jdField_a_of_type_Bicr;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public static bicr a()
  {
    if (jdField_a_of_type_Bicr == null) {}
    try
    {
      if (jdField_a_of_type_Bicr == null) {
        jdField_a_of_type_Bicr = new bicr();
      }
      return jdField_a_of_type_Bicr;
    }
    finally {}
  }
  
  private void b()
  {
    this.b = true;
    if (QLog.isColorLevel()) {
      QLog.d("WadlQIPCConnector", 2, "begin connect:");
    }
    QIPCClientHelper.getInstance().getClient().addListener(new bics(this));
    long l = System.currentTimeMillis();
    QIPCClientHelper.getInstance().getClient().connect(new bict(this, l));
  }
  
  public void a()
  {
    if ((!this.jdField_a_of_type_Boolean) && (!this.b)) {
      b();
    }
    if (!this.jdField_a_of_type_Boolean) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (!bool) {}
        try
        {
          this.jdField_a_of_type_JavaLangObject.wait(500L);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bicr
 * JD-Core Version:    0.7.0.1
 */