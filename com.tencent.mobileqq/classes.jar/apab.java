import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

class apab
  implements bbrx
{
  apab(aozy paramaozy, List paramList, aodw paramaodw, apad paramapad) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 2)
    {
      apcb.d(aozy.a(this.jdField_a_of_type_Aozy).getString(2131627191));
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)localIterator.next();
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          if (bace.b(localFileManagerEntity.getFilePath())) {
            this.jdField_a_of_type_Aodw.a(localFileManagerEntity.getFilePath(), "", aozy.a(this.jdField_a_of_type_Aozy).getCurrentAccountUin(), 0, false);
          } else {
            this.jdField_a_of_type_Aodw.a(localFileManagerEntity, String.valueOf(localFileManagerEntity.peerUin));
          }
        }
      }
      if (this.jdField_a_of_type_Apad != null) {
        this.jdField_a_of_type_Apad.a(4, 0);
      }
    }
    while (this.jdField_a_of_type_Apad == null)
    {
      Iterator localIterator;
      FileManagerEntity localFileManagerEntity;
      return;
    }
    this.jdField_a_of_type_Apad.a(4, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apab
 * JD-Core Version:    0.7.0.1
 */