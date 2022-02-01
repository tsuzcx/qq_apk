import com.tencent.mobileqq.structmsg.widget.CountdownTextView;

class bdta
  implements bdtr
{
  bdta(bdsz parambdsz, CountdownTextView paramCountdownTextView) {}
  
  public void a()
  {
    this.jdField_a_of_type_Bdsz.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_Bdsz.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView.setText(bdsz.a(this.jdField_a_of_type_Bdsz, 0L));
  }
  
  public void a(long paramLong)
  {
    paramLong /= 1000L;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView.setText(bdsz.a(this.jdField_a_of_type_Bdsz, paramLong));
    this.jdField_a_of_type_Bdsz.jdField_d_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdta
 * JD-Core Version:    0.7.0.1
 */