import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.session.TAVCutSession;

class blkx
  implements blku
{
  blkx(blkw paramblkw, TextEditorData paramTextEditorData, TAVCutSession paramTAVCutSession) {}
  
  public void a(bllc parambllc)
  {
    if ((parambllc instanceof bllb))
    {
      parambllc = (bllb)parambllc;
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setContent(parambllc.a());
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setTextColor(parambllc.a());
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutSession.updateTextSticker(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blkx
 * JD-Core Version:    0.7.0.1
 */