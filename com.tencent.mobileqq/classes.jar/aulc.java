import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

class aulc
  implements bjhv
{
  aulc(aukz paramaukz, List paramList, atqx paramatqx, aule paramaule) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 2)
    {
      auna.d(aukz.a(this.jdField_a_of_type_Aukz).getString(2131692445));
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)localIterator.next();
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
    while (this.jdField_a_of_type_Aule == null)
    {
      Iterator localIterator;
      FileManagerEntity localFileManagerEntity;
      return;
    }
    this.jdField_a_of_type_Aule.a(4, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aulc
 * JD-Core Version:    0.7.0.1
 */