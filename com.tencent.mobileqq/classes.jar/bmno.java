import dov.com.qq.im.aeeditor.module.text.AEEditorTextBean;

final class bmno
  implements bmfg
{
  bmno(AEEditorTextBean paramAEEditorTextBean, bmnq parambmnq) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bmnq != null) {
      this.jdField_a_of_type_Bmnq.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, (int)(0.66D * paramInt));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      bmnn.b(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, this.jdField_a_of_type_Bmnq);
      bmnn.c(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, this.jdField_a_of_type_Bmnq);
      return;
    }
    if (this.jdField_a_of_type_Bmnq != null) {
      this.jdField_a_of_type_Bmnq.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, paramBoolean, "ERROR_PAG_ZIP_DOWNLOAD_FAILED");
    }
    bmbx.a("AEEditorPagStickerUtil", "[downloadPagZip] download pag zip failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmno
 * JD-Core Version:    0.7.0.1
 */