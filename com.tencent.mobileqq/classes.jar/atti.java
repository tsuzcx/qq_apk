import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

class atti
  implements atve
{
  atti(atte paramatte, List paramList, aszd paramaszd, attj paramattj) {}
  
  public void a()
  {
    atvf.d(atte.a(this.jdField_a_of_type_Atte).getString(2131692439));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        if (bgmg.b(localFileManagerEntity.getFilePath())) {
          this.jdField_a_of_type_Aszd.a(localFileManagerEntity.getFilePath(), "", atte.a(this.jdField_a_of_type_Atte).getCurrentAccountUin(), 0, false);
        } else {
          this.jdField_a_of_type_Aszd.a(localFileManagerEntity, String.valueOf(localFileManagerEntity.peerUin));
        }
      }
    }
    if (this.jdField_a_of_type_Attj != null) {
      this.jdField_a_of_type_Attj.a(4, 0);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Attj != null) {
      this.jdField_a_of_type_Attj.a(4, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atti
 * JD-Core Version:    0.7.0.1
 */