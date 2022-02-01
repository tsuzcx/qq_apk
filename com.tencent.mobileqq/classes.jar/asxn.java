import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.Iterator;
import java.util.List;

class asxn
  implements aszj
{
  asxn(asxj paramasxj, List paramList, asdg paramasdg, asxo paramasxo) {}
  
  public void onNo()
  {
    if (this.jdField_a_of_type_Asxo != null) {
      this.jdField_a_of_type_Asxo.a(4, 1);
    }
  }
  
  public void onYes()
  {
    aszk.d(asxj.a(this.jdField_a_of_type_Asxj).getString(2131692493));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        if (FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())) {
          this.jdField_a_of_type_Asdg.a(localFileManagerEntity.getFilePath(), "", asxj.a(this.jdField_a_of_type_Asxj).getCurrentAccountUin(), 0, false);
        } else {
          this.jdField_a_of_type_Asdg.a(localFileManagerEntity, String.valueOf(localFileManagerEntity.peerUin));
        }
      }
    }
    if (this.jdField_a_of_type_Asxo != null) {
      this.jdField_a_of_type_Asxo.a(4, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxn
 * JD-Core Version:    0.7.0.1
 */