import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class bgta
  implements EIPClientConnectListener
{
  bgta(bgsy parambgsy, long paramLong) {}
  
  public void connectFailed()
  {
    bgsy.a(this.jdField_a_of_type_Bgsy, false);
    bgsy.b(this.jdField_a_of_type_Bgsy, false);
    synchronized (bgsy.a(this.jdField_a_of_type_Bgsy))
    {
      bgsy.a(this.jdField_a_of_type_Bgsy).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("WadlQIPCConnector", 2, "connectFailed:" + bgsy.a(this.jdField_a_of_type_Bgsy));
      }
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      bgsy.a(this.jdField_a_of_type_Bgsy, ???.procName);
    }
    bgsy.a(this.jdField_a_of_type_Bgsy, true);
    bgsy.b(this.jdField_a_of_type_Bgsy, false);
    synchronized (bgsy.a(this.jdField_a_of_type_Bgsy))
    {
      bgsy.a(this.jdField_a_of_type_Bgsy).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("WadlQIPCConnector", 2, "connectSuccess:" + bgsy.a(this.jdField_a_of_type_Bgsy) + "|" + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgta
 * JD-Core Version:    0.7.0.1
 */