import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.Iterator;
import java.util.List;

class aubt
  implements biyc
{
  aubt(aubq paramaubq, List paramList, athn paramathn, aubv paramaubv) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 2)
    {
      audr.d(aubq.a(this.jdField_a_of_type_Aubq).getString(2131692595));
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)localIterator.next();
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
    while (this.jdField_a_of_type_Aubv == null)
    {
      Iterator localIterator;
      FileManagerEntity localFileManagerEntity;
      return;
    }
    this.jdField_a_of_type_Aubv.a(4, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubt
 * JD-Core Version:    0.7.0.1
 */