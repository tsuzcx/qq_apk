import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.session.TAVCutSession;

class bocq
  implements boco
{
  bocq(bocp parambocp, TextEditorData paramTextEditorData, TAVCutSession paramTAVCutSession) {}
  
  public void a(TextEditorData paramTextEditorData)
  {
    if (paramTextEditorData != null)
    {
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setContent(paramTextEditorData.getContent());
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setTextColor(paramTextEditorData.getTextColor());
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutSession.updateTextSticker(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
      if (bocp.a(this.jdField_a_of_type_Bocp) != null)
      {
        bocp.a(this.jdField_a_of_type_Bocp).a(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
        bnrh.a("AEEditorTextPart", "[stickerInfo] update");
      }
      return;
    }
    bnrh.d("AEEditorTextPart", "update sticker back null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bocq
 * JD-Core Version:    0.7.0.1
 */