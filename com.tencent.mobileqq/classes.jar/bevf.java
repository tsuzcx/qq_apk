import com.tencent.mobileqq.app.proxy.ProxyListener;
import java.util.UUID;

class bevf
  implements ProxyListener
{
  bevf(bevc parambevc, UUID paramUUID) {}
  
  public void onDeleteFinish(String paramString, int paramInt)
  {
    bevx.d("TroopFileDataBaseProxy", bevx.c, "[" + this.jdField_a_of_type_JavaUtilUUID.toString() + "] deleteItem finish. table:" + paramString);
  }
  
  public void onInsertFinish(String paramString)
  {
    bevx.d("TroopFileDataBaseProxy", bevx.c, "[" + this.jdField_a_of_type_JavaUtilUUID.toString() + "] deleteItem finish[add]. table:" + paramString);
  }
  
  public void onUpdateFinish(String paramString, int paramInt)
  {
    bevx.d("TroopFileDataBaseProxy", bevx.c, "[" + this.jdField_a_of_type_JavaUtilUUID.toString() + "] deleteItem finish[up]. table:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bevf
 * JD-Core Version:    0.7.0.1
 */