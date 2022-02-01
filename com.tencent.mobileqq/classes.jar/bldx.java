import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class bldx
  implements EIPClientConnectListener
{
  bldx(bldv parambldv, long paramLong) {}
  
  public void connectFailed()
  {
    bldv.a(this.jdField_a_of_type_Bldv, false);
    bldv.b(this.jdField_a_of_type_Bldv, false);
    synchronized (bldv.a(this.jdField_a_of_type_Bldv))
    {
      bldv.a(this.jdField_a_of_type_Bldv).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("WadlQIPCConnector", 2, "connectFailed:" + bldv.a(this.jdField_a_of_type_Bldv));
      }
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      bldv.a(this.jdField_a_of_type_Bldv, ???.procName);
    }
    bldv.a(this.jdField_a_of_type_Bldv, true);
    bldv.b(this.jdField_a_of_type_Bldv, false);
    synchronized (bldv.a(this.jdField_a_of_type_Bldv))
    {
      bldv.a(this.jdField_a_of_type_Bldv).notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("WadlQIPCConnector", 2, "connectSuccess:" + bldv.a(this.jdField_a_of_type_Bldv) + "|" + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bldx
 * JD-Core Version:    0.7.0.1
 */