import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

class apsa
  implements aptw
{
  apsa(aprw paramaprw, List paramList, aouu paramaouu, apsb paramapsb) {}
  
  public void a()
  {
    aptx.d(aprw.a(this.jdField_a_of_type_Aprw).getString(2131692830));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        if (bbdx.b(localFileManagerEntity.getFilePath())) {
          this.jdField_a_of_type_Aouu.a(localFileManagerEntity.getFilePath(), "", aprw.a(this.jdField_a_of_type_Aprw).getCurrentAccountUin(), 0, false);
        } else {
          this.jdField_a_of_type_Aouu.a(localFileManagerEntity, String.valueOf(localFileManagerEntity.peerUin));
        }
      }
    }
    if (this.jdField_a_of_type_Apsb != null) {
      this.jdField_a_of_type_Apsb.a(4, 0);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Apsb != null) {
      this.jdField_a_of_type_Apsb.a(4, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apsa
 * JD-Core Version:    0.7.0.1
 */