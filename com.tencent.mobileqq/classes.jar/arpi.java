import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

class arpi
  implements arrh
{
  arpi(arph paramarph, List paramList, aqsb paramaqsb, arpm paramarpm) {}
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        this.jdField_a_of_type_Aqsb.b(localFileManagerEntity);
      }
    }
    if (this.jdField_a_of_type_Arpm != null) {
      this.jdField_a_of_type_Arpm.a(1, 0);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Arpm != null) {
      this.jdField_a_of_type_Arpm.a(1, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arpi
 * JD-Core Version:    0.7.0.1
 */