import QC.UniBusiGetOneItemWithCheckRsp;

class awub
  implements alpg
{
  awub(awtw paramawtw, awud paramawud) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    awud localawud;
    if (this.jdField_a_of_type_Awud != null)
    {
      if (!(paramObject instanceof UniBusiGetOneItemWithCheckRsp)) {
        break label50;
      }
      localawud = this.jdField_a_of_type_Awud;
      if (((UniBusiGetOneItemWithCheckRsp)paramObject).ret != 0) {
        break label45;
      }
    }
    label45:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localawud.a(paramBoolean, (UniBusiGetOneItemWithCheckRsp)paramObject);
      return;
    }
    label50:
    this.jdField_a_of_type_Awud.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awub
 * JD-Core Version:    0.7.0.1
 */