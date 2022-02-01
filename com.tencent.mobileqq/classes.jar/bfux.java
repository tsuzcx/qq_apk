import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import java.util.UUID;

class bfux
  implements ProxyListener
{
  bfux(bfuw parambfuw, TroopFileTansferItemEntity paramTroopFileTansferItemEntity) {}
  
  public void onDeleteFinish(String paramString, int paramInt)
  {
    bfvr.d("TroopFileDataBaseProxy", bfvr.c, "[" + this.jdField_a_of_type_ComTencentMobileqqDataTroopFileTansferItemEntity.Id.toString() + "] addItem finish[del]. table:" + paramString);
  }
  
  public void onInsertFinish(String paramString)
  {
    bfvr.d("TroopFileDataBaseProxy", bfvr.c, "[" + this.jdField_a_of_type_ComTencentMobileqqDataTroopFileTansferItemEntity.Id.toString() + "] addItem finish. table:" + paramString);
  }
  
  public void onUpdateFinish(String paramString, int paramInt)
  {
    bfvr.d("TroopFileDataBaseProxy", bfvr.c, "[" + this.jdField_a_of_type_ComTencentMobileqqDataTroopFileTansferItemEntity.Id.toString() + "] addItem finish[up]. table:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfux
 * JD-Core Version:    0.7.0.1
 */