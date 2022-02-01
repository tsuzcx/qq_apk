import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.session.TAVCutSession;

class bpkc
  implements bpka
{
  bpkc(bpkb parambpkb, TextEditorData paramTextEditorData, TAVCutSession paramTAVCutSession) {}
  
  public void a(TextEditorData paramTextEditorData)
  {
    if (paramTextEditorData != null)
    {
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setContent(paramTextEditorData.getContent());
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setTextColor(paramTextEditorData.getTextColor());
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutSession.updateTextSticker(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
      if (bpkb.a(this.jdField_a_of_type_Bpkb) != null)
      {
        bpkb.a(this.jdField_a_of_type_Bpkb).a(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
        bpam.a("AEEditorTextPart", "[stickerInfo] update");
      }
      return;
    }
    bpam.d("AEEditorTextPart", "update sticker back null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpkc
 * JD-Core Version:    0.7.0.1
 */