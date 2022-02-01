import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import java.util.UUID;

class beei
  implements ProxyListener
{
  beei(beeh parambeeh, TroopFileTansferItemEntity paramTroopFileTansferItemEntity) {}
  
  public void onDeleteFinish(String paramString, int paramInt)
  {
    befc.d("TroopFileDataBaseProxy", befc.c, "[" + this.jdField_a_of_type_ComTencentMobileqqDataTroopFileTansferItemEntity.Id.toString() + "] addItem finish[del]. table:" + paramString);
  }
  
  public void onInsertFinish(String paramString)
  {
    befc.d("TroopFileDataBaseProxy", befc.c, "[" + this.jdField_a_of_type_ComTencentMobileqqDataTroopFileTansferItemEntity.Id.toString() + "] addItem finish. table:" + paramString);
  }
  
  public void onUpdateFinish(String paramString, int paramInt)
  {
    befc.d("TroopFileDataBaseProxy", befc.c, "[" + this.jdField_a_of_type_ComTencentMobileqqDataTroopFileTansferItemEntity.Id.toString() + "] addItem finish[up]. table:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beei
 * JD-Core Version:    0.7.0.1
 */