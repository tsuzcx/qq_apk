import QC.UniBusiGetOneItemWithCheckRsp;

class awps
  implements alkr
{
  awps(awpn paramawpn, awpu paramawpu) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    awpu localawpu;
    if (this.jdField_a_of_type_Awpu != null)
    {
      if (!(paramObject instanceof UniBusiGetOneItemWithCheckRsp)) {
        break label50;
      }
      localawpu = this.jdField_a_of_type_Awpu;
      if (((UniBusiGetOneItemWithCheckRsp)paramObject).ret != 0) {
        break label45;
      }
    }
    label45:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localawpu.a(paramBoolean, (UniBusiGetOneItemWithCheckRsp)paramObject);
      return;
    }
    label50:
    this.jdField_a_of_type_Awpu.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awps
 * JD-Core Version:    0.7.0.1
 */