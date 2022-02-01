public final class bpiy
  implements beuq
{
  public bpiy(bpiz parambpiz, bpis parambpis, String paramString) {}
  
  public void onResp(bevm parambevm)
  {
    boolean bool2 = true;
    bozr localbozr;
    if ((parambevm != null) && (parambevm.a == 0))
    {
      bool1 = true;
      bpam.b("AEEditorMusicHelper", "[downloadMusic], onResp, succeeded=" + bool1);
      if (this.jdField_a_of_type_Bpiz != null) {
        this.jdField_a_of_type_Bpiz.a(this.jdField_a_of_type_Bpis, bool1, this.jdField_a_of_type_JavaLangString);
      }
      if (parambevm != null)
      {
        localbozr = bozr.a();
        if (parambevm.a != 0) {
          break label113;
        }
      }
    }
    label113:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localbozr.a(bool1, 5, "AEEditorMusicDownload", this.jdField_a_of_type_Bpis.a(), parambevm.b, parambevm.g);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpiy
 * JD-Core Version:    0.7.0.1
 */