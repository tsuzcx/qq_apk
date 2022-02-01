import com.tencent.mobileqq.app.proxy.ProxyListener;
import java.util.UUID;

class bfln
  implements ProxyListener
{
  bfln(bflk parambflk, UUID paramUUID) {}
  
  public void onDeleteFinish(String paramString, int paramInt)
  {
    bfmf.d("TroopFileDataBaseProxy", bfmf.c, "[" + this.jdField_a_of_type_JavaUtilUUID.toString() + "] deleteItem finish. table:" + paramString);
  }
  
  public void onInsertFinish(String paramString)
  {
    bfmf.d("TroopFileDataBaseProxy", bfmf.c, "[" + this.jdField_a_of_type_JavaUtilUUID.toString() + "] deleteItem finish[add]. table:" + paramString);
  }
  
  public void onUpdateFinish(String paramString, int paramInt)
  {
    bfmf.d("TroopFileDataBaseProxy", bfmf.c, "[" + this.jdField_a_of_type_JavaUtilUUID.toString() + "] deleteItem finish[up]. table:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfln
 * JD-Core Version:    0.7.0.1
 */