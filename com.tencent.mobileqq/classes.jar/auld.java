import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

class auld
  implements aumz
{
  auld(aukz paramaukz, List paramList, atqx paramatqx, aule paramaule) {}
  
  public void a()
  {
    auna.d(aukz.a(this.jdField_a_of_type_Aukz).getString(2131692445));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        if (bhmi.b(localFileManagerEntity.getFilePath())) {
          this.jdField_a_of_type_Atqx.a(localFileManagerEntity.getFilePath(), "", aukz.a(this.jdField_a_of_type_Aukz).getCurrentAccountUin(), 0, false);
        } else {
          this.jdField_a_of_type_Atqx.a(localFileManagerEntity, String.valueOf(localFileManagerEntity.peerUin));
        }
      }
    }
    if (this.jdField_a_of_type_Aule != null) {
      this.jdField_a_of_type_Aule.a(4, 0);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aule != null) {
      this.jdField_a_of_type_Aule.a(4, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auld
 * JD-Core Version:    0.7.0.1
 */