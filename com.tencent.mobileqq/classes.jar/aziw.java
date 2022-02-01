import QC.UniBusiGetOneItemWithCheckRsp;

class aziw
  implements anil
{
  aziw(azir paramazir, aziy paramaziy) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    aziy localaziy;
    if (this.jdField_a_of_type_Aziy != null)
    {
      if (!(paramObject instanceof UniBusiGetOneItemWithCheckRsp)) {
        break label50;
      }
      localaziy = this.jdField_a_of_type_Aziy;
      if (((UniBusiGetOneItemWithCheckRsp)paramObject).ret != 0) {
        break label45;
      }
    }
    label45:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localaziy.a(paramBoolean, (UniBusiGetOneItemWithCheckRsp)paramObject);
      return;
    }
    label50:
    this.jdField_a_of_type_Aziy.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aziw
 * JD-Core Version:    0.7.0.1
 */