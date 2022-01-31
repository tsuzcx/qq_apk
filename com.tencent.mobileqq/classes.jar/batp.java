import com.tencent.mobileqq.highway.api.ITransCallbackForReport;

class batp
  implements ITransCallbackForReport
{
  batp(batn parambatn) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    this.a.a("actRichMediaNetMonitor_pttUp", false, paramInt, paramString1, paramString2, this.a.c, this.a.l, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     batp
 * JD-Core Version:    0.7.0.1
 */