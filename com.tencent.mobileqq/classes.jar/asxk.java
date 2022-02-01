import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

class asxk
  implements aszj
{
  asxk(asxj paramasxj, List paramList, asdg paramasdg, asxo paramasxo) {}
  
  public void onNo()
  {
    if (this.jdField_a_of_type_Asxo != null) {
      this.jdField_a_of_type_Asxo.a(1, 1);
    }
  }
  
  public void onYes()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        this.jdField_a_of_type_Asdg.b(localFileManagerEntity);
      }
    }
    if (this.jdField_a_of_type_Asxo != null) {
      this.jdField_a_of_type_Asxo.a(1, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxk
 * JD-Core Version:    0.7.0.1
 */