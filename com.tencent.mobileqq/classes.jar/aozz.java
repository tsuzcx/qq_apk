import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

class aozz
  implements apca
{
  aozz(aozy paramaozy, List paramList, aodw paramaodw, apad paramapad) {}
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        this.jdField_a_of_type_Aodw.b(localFileManagerEntity);
      }
    }
    if (this.jdField_a_of_type_Apad != null) {
      this.jdField_a_of_type_Apad.a(1, 0);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Apad != null) {
      this.jdField_a_of_type_Apad.a(1, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aozz
 * JD-Core Version:    0.7.0.1
 */