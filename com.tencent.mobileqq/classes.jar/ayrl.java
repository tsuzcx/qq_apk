import com.tencent.mobileqq.highway.api.ITransCallbackForReport;

class ayrl
  implements ITransCallbackForReport
{
  ayrl(ayrj paramayrj) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    this.a.a("actRichMediaNetMonitor_pttUp", false, this.a.j, paramString1, paramString2, this.a.c, this.a.l, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayrl
 * JD-Core Version:    0.7.0.1
 */