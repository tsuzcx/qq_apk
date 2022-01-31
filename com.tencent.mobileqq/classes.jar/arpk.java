import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

class arpk
  implements bezx
{
  arpk(arph paramarph, List paramList, aqsb paramaqsb, arpm paramarpm) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 2)
    {
      arri.d(arph.a(this.jdField_a_of_type_Arph).getString(2131692914));
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)localIterator.next();
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          if (bdhb.b(localFileManagerEntity.getFilePath())) {
            this.jdField_a_of_type_Aqsb.a(localFileManagerEntity.getFilePath(), "", arph.a(this.jdField_a_of_type_Arph).getCurrentAccountUin(), 0, false);
          } else {
            this.jdField_a_of_type_Aqsb.a(localFileManagerEntity, String.valueOf(localFileManagerEntity.peerUin));
          }
        }
      }
      if (this.jdField_a_of_type_Arpm != null) {
        this.jdField_a_of_type_Arpm.a(4, 0);
      }
    }
    while (this.jdField_a_of_type_Arpm == null)
    {
      Iterator localIterator;
      FileManagerEntity localFileManagerEntity;
      return;
    }
    this.jdField_a_of_type_Arpm.a(4, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arpk
 * JD-Core Version:    0.7.0.1
 */