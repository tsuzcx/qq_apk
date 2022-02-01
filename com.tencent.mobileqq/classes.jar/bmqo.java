import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class bmqo
  implements EIPClientConnectListener
{
  bmqo(bmqm parambmqm, long paramLong) {}
  
  public void connectFailed()
  {
    bmqm.a(this.jdField_a_of_type_Bmqm, false);
    bmqm.b(this.jdField_a_of_type_Bmqm, false);
    synchronized (bmqm.a(this.jdField_a_of_type_Bmqm))
    {
      bmqm.a(this.jdField_a_of_type_Bmqm).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("WadlQIPCConnector", 2, "connectFailed:" + bmqm.a(this.jdField_a_of_type_Bmqm));
      }
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      bmqm.a(this.jdField_a_of_type_Bmqm, ???.procName);
    }
    bmqm.a(this.jdField_a_of_type_Bmqm, true);
    bmqm.b(this.jdField_a_of_type_Bmqm, false);
    synchronized (bmqm.a(this.jdField_a_of_type_Bmqm))
    {
      bmqm.a(this.jdField_a_of_type_Bmqm).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("WadlQIPCConnector", 2, "connectSuccess:" + bmqm.a(this.jdField_a_of_type_Bmqm) + "|" + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqo
 * JD-Core Version:    0.7.0.1
 */