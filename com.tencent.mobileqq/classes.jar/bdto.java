import com.tencent.mobileqq.highway.api.ITransCallbackForReport;

class bdto
  implements ITransCallbackForReport
{
  bdto(bdtl parambdtl) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    bdtl localbdtl = this.a;
    String str2 = this.a.c;
    if (this.a.f == null) {}
    for (String str1 = this.a.l;; str1 = this.a.f)
    {
      localbdtl.a("actRichMediaNetMonitor_pttUp", false, paramInt, paramString1, paramString2, str2, str1, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdto
 * JD-Core Version:    0.7.0.1
 */