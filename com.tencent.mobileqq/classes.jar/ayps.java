import com.tencent.mobileqq.highway.api.ITransCallbackForReport;

class ayps
  implements ITransCallbackForReport
{
  ayps(aypp paramaypp) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    aypp localaypp = this.a;
    paramInt = this.a.j;
    String str2 = this.a.c;
    if (this.a.f == null) {}
    for (String str1 = this.a.l;; str1 = this.a.f)
    {
      localaypp.a("actRichMediaNetMonitor_pttUp", false, paramInt, paramString1, paramString2, str2, str1, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayps
 * JD-Core Version:    0.7.0.1
 */