import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class bict
  implements EIPClientConnectListener
{
  bict(bicr parambicr, long paramLong) {}
  
  public void connectFailed()
  {
    bicr.a(this.jdField_a_of_type_Bicr, false);
    bicr.b(this.jdField_a_of_type_Bicr, false);
    synchronized (bicr.a(this.jdField_a_of_type_Bicr))
    {
      bicr.a(this.jdField_a_of_type_Bicr).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("WadlQIPCConnector", 2, "connectFailed:" + bicr.a(this.jdField_a_of_type_Bicr));
      }
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      bicr.a(this.jdField_a_of_type_Bicr, ???.procName);
    }
    bicr.a(this.jdField_a_of_type_Bicr, true);
    bicr.b(this.jdField_a_of_type_Bicr, false);
    synchronized (bicr.a(this.jdField_a_of_type_Bicr))
    {
      bicr.a(this.jdField_a_of_type_Bicr).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("WadlQIPCConnector", 2, "connectSuccess:" + bicr.a(this.jdField_a_of_type_Bicr) + "|" + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bict
 * JD-Core Version:    0.7.0.1
 */