public final class blkb
  implements bapx
{
  public blkb(blkc paramblkc, bljv parambljv, String paramString) {}
  
  public void onResp(baqw parambaqw)
  {
    boolean bool2 = true;
    blen localblen;
    if ((parambaqw != null) && (parambaqw.a == 0))
    {
      bool1 = true;
      blfg.b("AEEditorMusicHelper", "[downloadMusic], onResp, succeeded=" + bool1);
      if (this.jdField_a_of_type_Blkc != null) {
        this.jdField_a_of_type_Blkc.a(this.jdField_a_of_type_Bljv, bool1, this.jdField_a_of_type_JavaLangString);
      }
      if (parambaqw != null)
      {
        localblen = blen.a();
        if (parambaqw.a != 0) {
          break label113;
        }
      }
    }
    label113:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localblen.a(bool1, 5, "AEEditorMusicDownload", this.jdField_a_of_type_Bljv.a(), parambaqw.b, parambaqw.h);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blkb
 * JD-Core Version:    0.7.0.1
 */