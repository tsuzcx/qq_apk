import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

class aprz
  implements bcwm
{
  aprz(aprw paramaprw, List paramList, aouu paramaouu, apsb paramapsb) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 2)
    {
      aptx.d(aprw.a(this.jdField_a_of_type_Aprw).getString(2131692830));
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)localIterator.next();
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
    while (this.jdField_a_of_type_Apsb == null)
    {
      Iterator localIterator;
      FileManagerEntity localFileManagerEntity;
      return;
    }
    this.jdField_a_of_type_Apsb.a(4, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aprz
 * JD-Core Version:    0.7.0.1
 */