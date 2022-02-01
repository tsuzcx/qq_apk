import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

class atth
  implements bigw
{
  atth(atte paramatte, List paramList, aszd paramaszd, attj paramattj) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 2)
    {
      atvf.d(atte.a(this.jdField_a_of_type_Atte).getString(2131692439));
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)localIterator.next();
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
    while (this.jdField_a_of_type_Attj == null)
    {
      Iterator localIterator;
      FileManagerEntity localFileManagerEntity;
      return;
    }
    this.jdField_a_of_type_Attj.a(4, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atth
 * JD-Core Version:    0.7.0.1
 */