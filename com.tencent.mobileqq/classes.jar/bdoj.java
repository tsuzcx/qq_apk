import com.tencent.mobileqq.data.troop.TroopInfo;

class bdoj
  extends andd
{
  bdoj(bdoi parambdoi) {}
  
  protected void onGetAddTroopWebInfo(String paramString)
  {
    bdoi.a(this.a, paramString);
  }
  
  protected void onOIDB0X88D_1_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    bdoi.a(this.a, paramBoolean, paramLong, paramTroopInfo);
  }
  
  protected void onTroopManagerFailed(int paramInt1, int paramInt2)
  {
    bdoi.a(this.a, false, paramInt1, paramInt2, null);
  }
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    bdoi.a(this.a, true, paramInt1, paramInt2, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdoj
 * JD-Core Version:    0.7.0.1
 */