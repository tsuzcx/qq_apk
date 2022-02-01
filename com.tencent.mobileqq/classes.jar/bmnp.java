import dov.com.qq.im.aeeditor.module.text.AEEditorTextBean;

final class bmnp
  implements bmfg
{
  bmnp(bmnq parambmnq, AEEditorTextBean paramAEEditorTextBean) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bmnq != null) {
      this.jdField_a_of_type_Bmnq.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, (int)(66.0D + 0.34D * paramInt));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Bmnq != null)) {
      this.jdField_a_of_type_Bmnq.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, 100);
    }
    bmnq localbmnq;
    AEEditorTextBean localAEEditorTextBean;
    if (this.jdField_a_of_type_Bmnq != null)
    {
      localbmnq = this.jdField_a_of_type_Bmnq;
      localAEEditorTextBean = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean;
      if (!paramBoolean) {
        break label62;
      }
    }
    label62:
    for (String str = "SUCCESS_FONT_DOWNLOAD_SUCCEEDED";; str = "ERROR_FONT_DOWNLOAD_FAILED")
    {
      localbmnq.a(localAEEditorTextBean, paramBoolean, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmnp
 * JD-Core Version:    0.7.0.1
 */