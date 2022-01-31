import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class bkiw
  implements EIPClientConnectListener
{
  bkiw(bkiu parambkiu, long paramLong) {}
  
  public void connectFailed()
  {
    bkiu.a(this.jdField_a_of_type_Bkiu, false);
    bkiu.b(this.jdField_a_of_type_Bkiu, false);
    synchronized (bkiu.a(this.jdField_a_of_type_Bkiu))
    {
      bkiu.a(this.jdField_a_of_type_Bkiu).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("WadlQIPCConnector", 2, "connectFailed:" + bkiu.a(this.jdField_a_of_type_Bkiu));
      }
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      bkiu.a(this.jdField_a_of_type_Bkiu, ???.procName);
    }
    bkiu.a(this.jdField_a_of_type_Bkiu, true);
    bkiu.b(this.jdField_a_of_type_Bkiu, false);
    synchronized (bkiu.a(this.jdField_a_of_type_Bkiu))
    {
      bkiu.a(this.jdField_a_of_type_Bkiu).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("WadlQIPCConnector", 2, "connectSuccess:" + bkiu.a(this.jdField_a_of_type_Bkiu) + "|" + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkiw
 * JD-Core Version:    0.7.0.1
 */