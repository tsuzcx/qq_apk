public final class bohd
  implements bdvw
{
  public bohd(bohe parambohe, bogx parambogx, String paramString) {}
  
  public void onResp(bdwt parambdwt)
  {
    boolean bool2 = true;
    bnyh localbnyh;
    if ((parambdwt != null) && (parambdwt.a == 0))
    {
      bool1 = true;
      bnzb.b("AEEditorMusicHelper", "[downloadMusic], onResp, succeeded=" + bool1);
      if (this.jdField_a_of_type_Bohe != null) {
        this.jdField_a_of_type_Bohe.a(this.jdField_a_of_type_Bogx, bool1, this.jdField_a_of_type_JavaLangString);
      }
      if (parambdwt != null)
      {
        localbnyh = bnyh.a();
        if (parambdwt.a != 0) {
          break label113;
        }
      }
    }
    label113:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localbnyh.a(bool1, 5, "AEEditorMusicDownload", this.jdField_a_of_type_Bogx.a(), parambdwt.b, parambdwt.g);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bohd
 * JD-Core Version:    0.7.0.1
 */