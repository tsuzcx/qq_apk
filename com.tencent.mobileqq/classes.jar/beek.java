import com.tencent.mobileqq.app.proxy.ProxyListener;
import java.util.UUID;

class beek
  implements ProxyListener
{
  beek(beeh parambeeh, UUID paramUUID) {}
  
  public void onDeleteFinish(String paramString, int paramInt)
  {
    befc.d("TroopFileDataBaseProxy", befc.c, "[" + this.jdField_a_of_type_JavaUtilUUID.toString() + "] deleteItem finish. table:" + paramString);
  }
  
  public void onInsertFinish(String paramString)
  {
    befc.d("TroopFileDataBaseProxy", befc.c, "[" + this.jdField_a_of_type_JavaUtilUUID.toString() + "] deleteItem finish[add]. table:" + paramString);
  }
  
  public void onUpdateFinish(String paramString, int paramInt)
  {
    befc.d("TroopFileDataBaseProxy", befc.c, "[" + this.jdField_a_of_type_JavaUtilUUID.toString() + "] deleteItem finish[up]. table:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beek
 * JD-Core Version:    0.7.0.1
 */