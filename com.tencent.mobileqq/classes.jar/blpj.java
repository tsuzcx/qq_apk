import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.session.TAVCutSession;

class blpj
  implements blpg
{
  blpj(blpi paramblpi, TextEditorData paramTextEditorData, TAVCutSession paramTAVCutSession) {}
  
  public void a(blpo paramblpo)
  {
    if ((paramblpo instanceof blpn))
    {
      paramblpo = (blpn)paramblpo;
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setContent(paramblpo.a());
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setTextColor(paramblpo.a());
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutSession.updateTextSticker(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpj
 * JD-Core Version:    0.7.0.1
 */