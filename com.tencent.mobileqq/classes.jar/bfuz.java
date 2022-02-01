import com.tencent.mobileqq.app.proxy.ProxyListener;
import java.util.UUID;

class bfuz
  implements ProxyListener
{
  bfuz(bfuw parambfuw, UUID paramUUID) {}
  
  public void onDeleteFinish(String paramString, int paramInt)
  {
    bfvr.d("TroopFileDataBaseProxy", bfvr.c, "[" + this.jdField_a_of_type_JavaUtilUUID.toString() + "] deleteItem finish. table:" + paramString);
  }
  
  public void onInsertFinish(String paramString)
  {
    bfvr.d("TroopFileDataBaseProxy", bfvr.c, "[" + this.jdField_a_of_type_JavaUtilUUID.toString() + "] deleteItem finish[add]. table:" + paramString);
  }
  
  public void onUpdateFinish(String paramString, int paramInt)
  {
    bfvr.d("TroopFileDataBaseProxy", bfvr.c, "[" + this.jdField_a_of_type_JavaUtilUUID.toString() + "] deleteItem finish[up]. table:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfuz
 * JD-Core Version:    0.7.0.1
 */