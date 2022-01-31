import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

class apac
  implements apca
{
  apac(aozy paramaozy, List paramList, aodw paramaodw, apad paramapad) {}
  
  public void a()
  {
    apcb.d(aozy.a(this.jdField_a_of_type_Aozy).getString(2131627191));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        if (bace.b(localFileManagerEntity.getFilePath())) {
          this.jdField_a_of_type_Aodw.a(localFileManagerEntity.getFilePath(), "", aozy.a(this.jdField_a_of_type_Aozy).getCurrentAccountUin(), 0, false);
        } else {
          this.jdField_a_of_type_Aodw.a(localFileManagerEntity, String.valueOf(localFileManagerEntity.peerUin));
        }
      }
    }
    if (this.jdField_a_of_type_Apad != null) {
      this.jdField_a_of_type_Apad.a(4, 0);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Apad != null) {
      this.jdField_a_of_type_Apad.a(4, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apac
 * JD-Core Version:    0.7.0.1
 */