import QC.UniBusiGetOneItemWithCheckRsp;

class babi
  implements anui
{
  babi(babd parambabd, babk parambabk) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    babk localbabk;
    if (this.jdField_a_of_type_Babk != null)
    {
      if (!(paramObject instanceof UniBusiGetOneItemWithCheckRsp)) {
        break label50;
      }
      localbabk = this.jdField_a_of_type_Babk;
      if (((UniBusiGetOneItemWithCheckRsp)paramObject).ret != 0) {
        break label45;
      }
    }
    label45:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localbabk.a(paramBoolean, (UniBusiGetOneItemWithCheckRsp)paramObject);
      return;
    }
    label50:
    this.jdField_a_of_type_Babk.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babi
 * JD-Core Version:    0.7.0.1
 */