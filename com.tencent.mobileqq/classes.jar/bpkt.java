import dov.com.qq.im.aeeditor.module.text.AEEditorTextBean;

final class bpkt
  implements bpdw
{
  bpkt(bpku parambpku, AEEditorTextBean paramAEEditorTextBean) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bpku != null) {
      this.jdField_a_of_type_Bpku.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, (int)(66.0D + 0.34D * paramInt));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Bpku != null)) {
      this.jdField_a_of_type_Bpku.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, 100);
    }
    bpku localbpku;
    AEEditorTextBean localAEEditorTextBean;
    if (this.jdField_a_of_type_Bpku != null)
    {
      localbpku = this.jdField_a_of_type_Bpku;
      localAEEditorTextBean = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean;
      if (!paramBoolean) {
        break label62;
      }
    }
    label62:
    for (String str = "SUCCESS_FONT_DOWNLOAD_SUCCEEDED";; str = "ERROR_FONT_DOWNLOAD_FAILED")
    {
      localbpku.a(localAEEditorTextBean, paramBoolean, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpkt
 * JD-Core Version:    0.7.0.1
 */