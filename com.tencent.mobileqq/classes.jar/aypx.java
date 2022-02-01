import QC.UniBusiGetOneItemWithCheckRsp;
import com.tencent.mobileqq.app.BusinessObserver;

class aypx
  implements BusinessObserver
{
  aypx(ayps paramayps, aypz paramaypz) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    aypz localaypz;
    if (this.jdField_a_of_type_Aypz != null)
    {
      if (!(paramObject instanceof UniBusiGetOneItemWithCheckRsp)) {
        break label50;
      }
      localaypz = this.jdField_a_of_type_Aypz;
      if (((UniBusiGetOneItemWithCheckRsp)paramObject).ret != 0) {
        break label45;
      }
    }
    label45:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localaypz.a(paramBoolean, (UniBusiGetOneItemWithCheckRsp)paramObject);
      return;
    }
    label50:
    this.jdField_a_of_type_Aypz.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypx
 * JD-Core Version:    0.7.0.1
 */