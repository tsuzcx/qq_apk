import com.tencent.mobileqq.highway.api.ITransCallbackForReport;

class bexm
  implements ITransCallbackForReport
{
  bexm(bexk parambexk) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    bexk localbexk = this.a;
    String str2 = this.a.d;
    if (this.a.f == null) {}
    for (String str1 = this.a.l;; str1 = this.a.f)
    {
      localbexk.a("actRichMediaNetMonitor_videoUp", false, paramInt, paramString1, paramString2, str2, str1, this.a.x + "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bexm
 * JD-Core Version:    0.7.0.1
 */