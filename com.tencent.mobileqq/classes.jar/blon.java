public final class blon
  implements baug
{
  public blon(bloo parambloo, bloh parambloh, String paramString) {}
  
  public void onResp(bavf parambavf)
  {
    boolean bool2 = true;
    bliu localbliu;
    if ((parambavf != null) && (parambavf.a == 0))
    {
      bool1 = true;
      bljn.b("AEEditorMusicHelper", "[downloadMusic], onResp, succeeded=" + bool1);
      if (this.jdField_a_of_type_Bloo != null) {
        this.jdField_a_of_type_Bloo.a(this.jdField_a_of_type_Bloh, bool1, this.jdField_a_of_type_JavaLangString);
      }
      if (parambavf != null)
      {
        localbliu = bliu.a();
        if (parambavf.a != 0) {
          break label113;
        }
      }
    }
    label113:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localbliu.a(bool1, 5, "AEEditorMusicDownload", this.jdField_a_of_type_Bloh.a(), parambavf.b, parambavf.h);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blon
 * JD-Core Version:    0.7.0.1
 */