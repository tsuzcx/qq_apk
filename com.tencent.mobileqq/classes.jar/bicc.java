import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class bicc
  implements EIPClientConnectListener
{
  bicc(bica parambica, long paramLong) {}
  
  public void connectFailed()
  {
    bica.a(this.jdField_a_of_type_Bica, false);
    bica.b(this.jdField_a_of_type_Bica, false);
    synchronized (bica.a(this.jdField_a_of_type_Bica))
    {
      bica.a(this.jdField_a_of_type_Bica).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("WadlQIPCConnector", 2, "connectFailed:" + bica.a(this.jdField_a_of_type_Bica));
      }
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      bica.a(this.jdField_a_of_type_Bica, ???.procName);
    }
    bica.a(this.jdField_a_of_type_Bica, true);
    bica.b(this.jdField_a_of_type_Bica, false);
    synchronized (bica.a(this.jdField_a_of_type_Bica))
    {
      bica.a(this.jdField_a_of_type_Bica).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("WadlQIPCConnector", 2, "connectSuccess:" + bica.a(this.jdField_a_of_type_Bica) + "|" + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bicc
 * JD-Core Version:    0.7.0.1
 */