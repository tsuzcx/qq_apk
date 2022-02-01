import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class bnyt
  implements EIPClientConnectListener
{
  bnyt(bnyr parambnyr, long paramLong) {}
  
  public void connectFailed()
  {
    bnyr.a(this.jdField_a_of_type_Bnyr, false);
    bnyr.b(this.jdField_a_of_type_Bnyr, false);
    synchronized (bnyr.a(this.jdField_a_of_type_Bnyr))
    {
      bnyr.a(this.jdField_a_of_type_Bnyr).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("WadlQIPCConnector", 2, "connectFailed:" + bnyr.a(this.jdField_a_of_type_Bnyr));
      }
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      bnyr.a(this.jdField_a_of_type_Bnyr, ???.procName);
    }
    bnyr.a(this.jdField_a_of_type_Bnyr, true);
    bnyr.b(this.jdField_a_of_type_Bnyr, false);
    synchronized (bnyr.a(this.jdField_a_of_type_Bnyr))
    {
      bnyr.a(this.jdField_a_of_type_Bnyr).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("WadlQIPCConnector", 2, "connectSuccess:" + bnyr.a(this.jdField_a_of_type_Bnyr) + "|" + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnyt
 * JD-Core Version:    0.7.0.1
 */