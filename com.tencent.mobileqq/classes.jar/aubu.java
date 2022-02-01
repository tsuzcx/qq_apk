import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.Iterator;
import java.util.List;

class aubu
  implements audq
{
  aubu(aubq paramaubq, List paramList, athn paramathn, aubv paramaubv) {}
  
  public void onNo()
  {
    if (this.jdField_a_of_type_Aubv != null) {
      this.jdField_a_of_type_Aubv.a(4, 1);
    }
  }
  
  public void onYes()
  {
    audr.d(aubq.a(this.jdField_a_of_type_Aubq).getString(2131692595));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        if (FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())) {
          this.jdField_a_of_type_Athn.a(localFileManagerEntity.getFilePath(), "", aubq.a(this.jdField_a_of_type_Aubq).getCurrentAccountUin(), 0, false);
        } else {
          this.jdField_a_of_type_Athn.a(localFileManagerEntity, String.valueOf(localFileManagerEntity.peerUin));
        }
      }
    }
    if (this.jdField_a_of_type_Aubv != null) {
      this.jdField_a_of_type_Aubv.a(4, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubu
 * JD-Core Version:    0.7.0.1
 */