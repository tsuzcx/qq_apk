import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

class arlb
  implements bevo
{
  arlb(arky paramarky, List paramList, aqns paramaqns, arld paramarld) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 2)
    {
      armz.d(arky.a(this.jdField_a_of_type_Arky).getString(2131692912));
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)localIterator.next();
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          if (bdcs.b(localFileManagerEntity.getFilePath())) {
            this.jdField_a_of_type_Aqns.a(localFileManagerEntity.getFilePath(), "", arky.a(this.jdField_a_of_type_Arky).getCurrentAccountUin(), 0, false);
          } else {
            this.jdField_a_of_type_Aqns.a(localFileManagerEntity, String.valueOf(localFileManagerEntity.peerUin));
          }
        }
      }
      if (this.jdField_a_of_type_Arld != null) {
        this.jdField_a_of_type_Arld.a(4, 0);
      }
    }
    while (this.jdField_a_of_type_Arld == null)
    {
      Iterator localIterator;
      FileManagerEntity localFileManagerEntity;
      return;
    }
    this.jdField_a_of_type_Arld.a(4, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arlb
 * JD-Core Version:    0.7.0.1
 */