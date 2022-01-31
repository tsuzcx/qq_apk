import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

class aprw
  implements aptu
{
  aprw(aprs paramaprs, List paramList, aouq paramaouq, aprx paramaprx) {}
  
  public void a()
  {
    aptv.d(aprs.a(this.jdField_a_of_type_Aprs).getString(2131692829));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
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
  
  public void b()
  {
    if (this.jdField_a_of_type_Aprx != null) {
      this.jdField_a_of_type_Aprx.a(4, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aprw
 * JD-Core Version:    0.7.0.1
 */