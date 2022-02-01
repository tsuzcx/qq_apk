import com.tencent.mobileqq.structmsg.widget.CountdownTextView;

class bdto
  implements bduf
{
  bdto(bdtn parambdtn, CountdownTextView paramCountdownTextView) {}
  
  public void a()
  {
    this.jdField_a_of_type_Bdtn.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_Bdtn.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView.setText(bdtn.a(this.jdField_a_of_type_Bdtn, 0L));
  }
  
  public void a(long paramLong)
  {
    paramLong /= 1000L;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView.setText(bdtn.a(this.jdField_a_of_type_Bdtn, paramLong));
    this.jdField_a_of_type_Bdtn.jdField_d_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdto
 * JD-Core Version:    0.7.0.1
 */