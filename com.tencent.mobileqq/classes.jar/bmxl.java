import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class bmxl
  implements EIPClientConnectListener
{
  bmxl(bmxj parambmxj, long paramLong) {}
  
  public void connectFailed()
  {
    bmxj.a(this.jdField_a_of_type_Bmxj, false);
    bmxj.b(this.jdField_a_of_type_Bmxj, false);
    synchronized (bmxj.a(this.jdField_a_of_type_Bmxj))
    {
      bmxj.a(this.jdField_a_of_type_Bmxj).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("WadlQIPCConnector", 2, "connectFailed:" + bmxj.a(this.jdField_a_of_type_Bmxj));
      }
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      bmxj.a(this.jdField_a_of_type_Bmxj, ???.procName);
    }
    bmxj.a(this.jdField_a_of_type_Bmxj, true);
    bmxj.b(this.jdField_a_of_type_Bmxj, false);
    synchronized (bmxj.a(this.jdField_a_of_type_Bmxj))
    {
      bmxj.a(this.jdField_a_of_type_Bmxj).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("WadlQIPCConnector", 2, "connectSuccess:" + bmxj.a(this.jdField_a_of_type_Bmxj) + "|" + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxl
 * JD-Core Version:    0.7.0.1
 */