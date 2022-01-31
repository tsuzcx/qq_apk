import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class bkep
  implements EIPClientConnectListener
{
  bkep(bken parambken, long paramLong) {}
  
  public void connectFailed()
  {
    bken.a(this.jdField_a_of_type_Bken, false);
    bken.b(this.jdField_a_of_type_Bken, false);
    synchronized (bken.a(this.jdField_a_of_type_Bken))
    {
      bken.a(this.jdField_a_of_type_Bken).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("WadlQIPCConnector", 2, "connectFailed:" + bken.a(this.jdField_a_of_type_Bken));
      }
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      bken.a(this.jdField_a_of_type_Bken, ???.procName);
    }
    bken.a(this.jdField_a_of_type_Bken, true);
    bken.b(this.jdField_a_of_type_Bken, false);
    synchronized (bken.a(this.jdField_a_of_type_Bken))
    {
      bken.a(this.jdField_a_of_type_Bken).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("WadlQIPCConnector", 2, "connectSuccess:" + bken.a(this.jdField_a_of_type_Bken) + "|" + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkep
 * JD-Core Version:    0.7.0.1
 */