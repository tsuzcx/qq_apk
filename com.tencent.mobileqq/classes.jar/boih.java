import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.session.TAVCutSession;

class boih
  implements boif
{
  boih(boig paramboig, TextEditorData paramTextEditorData, TAVCutSession paramTAVCutSession) {}
  
  public void a(TextEditorData paramTextEditorData)
  {
    if (paramTextEditorData != null)
    {
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setContent(paramTextEditorData.getContent());
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setTextColor(paramTextEditorData.getTextColor());
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutSession.updateTextSticker(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
      if (boig.a(this.jdField_a_of_type_Boig) != null)
      {
        boig.a(this.jdField_a_of_type_Boig).a(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
        bnzb.a("AEEditorTextPart", "[stickerInfo] update");
      }
      return;
    }
    bnzb.d("AEEditorTextPart", "update sticker back null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boih
 * JD-Core Version:    0.7.0.1
 */