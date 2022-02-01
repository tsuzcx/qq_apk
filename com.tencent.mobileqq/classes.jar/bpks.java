import dov.com.qq.im.aeeditor.module.text.AEEditorTextBean;

final class bpks
  implements bpdw
{
  bpks(AEEditorTextBean paramAEEditorTextBean, bpku parambpku) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bpku != null) {
      this.jdField_a_of_type_Bpku.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, (int)(0.66D * paramInt));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      bpkr.b(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, this.jdField_a_of_type_Bpku);
      bpkr.c(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, this.jdField_a_of_type_Bpku);
      return;
    }
    if (this.jdField_a_of_type_Bpku != null) {
      this.jdField_a_of_type_Bpku.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, paramBoolean, "ERROR_PAG_ZIP_DOWNLOAD_FAILED");
    }
    bpam.a("AEEditorPagStickerUtil", "[downloadPagZip] download pag zip failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpks
 * JD-Core Version:    0.7.0.1
 */