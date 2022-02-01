import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import java.util.UUID;

class bflm
  implements ProxyListener
{
  bflm(bflk parambflk, TroopFileTansferItemEntity paramTroopFileTansferItemEntity) {}
  
  public void onDeleteFinish(String paramString, int paramInt)
  {
    bfmf.d("TroopFileDataBaseProxy", bfmf.c, "[" + this.jdField_a_of_type_ComTencentMobileqqDataTroopFileTansferItemEntity.Id.toString() + "] updateItem finish[del]. table:" + paramString);
  }
  
  public void onInsertFinish(String paramString)
  {
    bfmf.d("TroopFileDataBaseProxy", bfmf.c, "[" + this.jdField_a_of_type_ComTencentMobileqqDataTroopFileTansferItemEntity.Id.toString() + "] updateItem finish[add]. table:" + paramString);
  }
  
  public void onUpdateFinish(String paramString, int paramInt)
  {
    bfmf.d("TroopFileDataBaseProxy", bfmf.c, "[" + this.jdField_a_of_type_ComTencentMobileqqDataTroopFileTansferItemEntity.Id.toString() + "] updateItem finish. table:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflm
 * JD-Core Version:    0.7.0.1
 */