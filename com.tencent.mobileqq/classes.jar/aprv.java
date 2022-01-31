import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

class aprv
  implements bcvx
{
  aprv(aprs paramaprs, List paramList, aouq paramaouq, aprx paramaprx) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 2)
    {
      aptv.d(aprs.a(this.jdField_a_of_type_Aprs).getString(2131692829));
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)localIterator.next();
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          if (bbdj.b(localFileManagerEntity.getFilePath())) {
            this.jdField_a_of_type_Aouq.a(localFileManagerEntity.getFilePath(), "", aprs.a(this.jdField_a_of_type_Aprs).getCurrentAccountUin(), 0, false);
          } else {
            this.jdField_a_of_type_Aouq.a(localFileManagerEntity, String.valueOf(localFileManagerEntity.peerUin));
          }
        }
      }
      if (this.jdField_a_of_type_Aprx != null) {
        this.jdField_a_of_type_Aprx.a(4, 0);
      }
    }
    while (this.jdField_a_of_type_Aprx == null)
    {
      Iterator localIterator;
      FileManagerEntity localFileManagerEntity;
      return;
    }
    this.jdField_a_of_type_Aprx.a(4, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aprv
 * JD-Core Version:    0.7.0.1
 */