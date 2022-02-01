import com.tencent.common.app.AppInterface;

class blwb
  extends blur
{
  blwb(blwa paramblwa, AppInterface paramAppInterface) {}
  
  public void onUpdateRecommendText(boolean paramBoolean, blwu paramblwu)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this);
    if (paramBoolean)
    {
      blwa.a(this.jdField_a_of_type_Blwa).a(paramblwu);
      return;
    }
    blwa.a(this.jdField_a_of_type_Blwa).a(new blwu());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwb
 * JD-Core Version:    0.7.0.1
 */