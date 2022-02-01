import QC.UniBusiGetOneItemWithCheckRsp;
import com.tencent.mobileqq.app.BusinessObserver;

class azus
  implements BusinessObserver
{
  azus(azun paramazun, azuu paramazuu) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    azuu localazuu;
    if (this.jdField_a_of_type_Azuu != null)
    {
      if (!(paramObject instanceof UniBusiGetOneItemWithCheckRsp)) {
        break label50;
      }
      localazuu = this.jdField_a_of_type_Azuu;
      if (((UniBusiGetOneItemWithCheckRsp)paramObject).ret != 0) {
        break label45;
      }
    }
    label45:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localazuu.a(paramBoolean, (UniBusiGetOneItemWithCheckRsp)paramObject);
      return;
    }
    label50:
    this.jdField_a_of_type_Azuu.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azus
 * JD-Core Version:    0.7.0.1
 */