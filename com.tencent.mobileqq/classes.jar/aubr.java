import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

class aubr
  implements audq
{
  aubr(aubq paramaubq, List paramList, athn paramathn, aubv paramaubv) {}
  
  public void onNo()
  {
    if (this.jdField_a_of_type_Aubv != null) {
      this.jdField_a_of_type_Aubv.a(1, 1);
    }
  }
  
  public void onYes()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        this.jdField_a_of_type_Athn.b(localFileManagerEntity);
      }
    }
    if (this.jdField_a_of_type_Aubv != null) {
      this.jdField_a_of_type_Aubv.a(1, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubr
 * JD-Core Version:    0.7.0.1
 */