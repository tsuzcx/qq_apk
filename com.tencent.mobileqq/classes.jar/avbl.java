import android.os.Message;
import com.tencent.mobileqq.nearby.ipc.BasicTypeDataParcel;
import com.tencent.qphone.base.util.QLog;

class avbl
  extends avbn
{
  avbl(avbj paramavbj) {}
  
  public Message a(Message paramMessage)
  {
    if (paramMessage == null) {
      return null;
    }
    return this.a.b(paramMessage);
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
      arrayOfObject = this.a.b(paramBasicTypeDataParcel.jdField_a_of_type_Int, paramBasicTypeDataParcel.jdField_a_of_type_ArrayOfJavaLangObject);
    } while (arrayOfObject == null);
    return new BasicTypeDataParcel(paramBasicTypeDataParcel.jdField_a_of_type_Int, arrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avbl
 * JD-Core Version:    0.7.0.1
 */