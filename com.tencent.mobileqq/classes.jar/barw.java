import com.tencent.mobileqq.highway.api.ITransCallbackForReport;

class barw
  implements ITransCallbackForReport
{
  barw(bart parambart) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    bart localbart = this.a;
    String str2 = this.a.c;
    if (this.a.f == null) {}
    for (String str1 = this.a.l;; str1 = this.a.f)
    {
      localbart.a("actRichMediaNetMonitor_pttUp", false, paramInt, paramString1, paramString2, str2, str1, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     barw
 * JD-Core Version:    0.7.0.1
 */