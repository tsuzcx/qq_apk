import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.session.TAVCutSession;

class bmmy
  implements bmmw
{
  bmmy(bmmx parambmmx, TextEditorData paramTextEditorData, TAVCutSession paramTAVCutSession) {}
  
  public void a(TextEditorData paramTextEditorData)
  {
    if (paramTextEditorData != null)
    {
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setContent(paramTextEditorData.getContent());
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setTextColor(paramTextEditorData.getTextColor());
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutSession.updateTextSticker(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
      if (bmmx.a(this.jdField_a_of_type_Bmmx) != null)
      {
        bmmx.a(this.jdField_a_of_type_Bmmx).a(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
        bmbx.a("AEEditorTextPart", "[stickerInfo] update");
      }
      return;
    }
    bmbx.d("AEEditorTextPart", "update sticker back null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmy
 * JD-Core Version:    0.7.0.1
 */