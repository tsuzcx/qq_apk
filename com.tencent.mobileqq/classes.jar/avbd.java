import android.os.Message;
import com.tencent.mobileqq.nearby.ipc.BasicTypeDataParcel;
import com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService;
import com.tencent.qphone.base.util.QLog;

public class avbd
  extends avbf
{
  public avbd(ConnectNearbyProcService paramConnectNearbyProcService) {}
  
  public Message a(Message paramMessage)
  {
    if (paramMessage == null) {
      return null;
    }
    return ConnectNearbyProcService.a(this.a, paramMessage);
  }
  
  public BasicTypeDataParcel a(BasicTypeDataParcel paramBasicTypeDataParcel)
  {
    if (paramBasicTypeDataParcel == null) {}
    Object[] arrayOfObject;
    do
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("nearby_ipc_log_tag", 2, paramBasicTypeDataParcel.toString());
      }
      arrayOfObject = ConnectNearbyProcService.a(this.a, paramBasicTypeDataParcel.jdField_a_of_type_Int, paramBasicTypeDataParcel.jdField_a_of_type_ArrayOfJavaLangObject);
    } while (arrayOfObject == null);
    return new BasicTypeDataParcel(paramBasicTypeDataParcel.jdField_a_of_type_Int, arrayOfObject);
  }
  
  public void a(avbm paramavbm)
  {
    ConnectNearbyProcService.a(paramavbm);
    if (ConnectNearbyProcService.a(this.a) != null) {
      ConnectNearbyProcService.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avbd
 * JD-Core Version:    0.7.0.1
 */