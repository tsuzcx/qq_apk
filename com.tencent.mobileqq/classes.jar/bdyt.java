import com.tencent.mobileqq.highway.api.ITransCallbackForReport;

class bdyt
  implements ITransCallbackForReport
{
  bdyt(bdyr parambdyr) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    bdyr localbdyr = this.a;
    String str2 = this.a.d;
    if (this.a.f == null) {}
    for (String str1 = this.a.l;; str1 = this.a.f)
    {
      localbdyr.a("actRichMediaNetMonitor_videoUp", false, paramInt, paramString1, paramString2, str2, str1, this.a.x + "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdyt
 * JD-Core Version:    0.7.0.1
 */