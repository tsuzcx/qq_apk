import com.tencent.qphone.base.util.QLog;

public class bbym
  extends bdbp
{
  private boolean jdField_a_of_type_Boolean;
  
  public bbym(bbyj parambbyj) {}
  
  public boolean a(int paramInt)
  {
    QLog.i("SimpleUILog.SimpleUIHandler", 1, String.format("emptyCallback postSwitch %d", new Object[] { Integer.valueOf(paramInt) }));
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    this.jdField_a_of_type_Boolean = true;
    bbyj.a(this.jdField_a_of_type_Bbyj, bbyj.a(this.jdField_a_of_type_Bbyj), -2147483648, bbyj.b(this.jdField_a_of_type_Bbyj), -2147483648, null, -2147483648);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbym
 * JD-Core Version:    0.7.0.1
 */