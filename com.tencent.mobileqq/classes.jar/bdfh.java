import com.tencent.qphone.base.util.QLog;

public class bdfh
  extends beip
{
  private boolean jdField_a_of_type_Boolean;
  
  public bdfh(bdfe parambdfe) {}
  
  public boolean a(int paramInt)
  {
    QLog.i("SimpleUILog.SimpleUIHandler", 1, String.format("emptyCallback postSwitch %d", new Object[] { Integer.valueOf(paramInt) }));
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    this.jdField_a_of_type_Boolean = true;
    bdfe.a(this.jdField_a_of_type_Bdfe, bdfe.a(this.jdField_a_of_type_Bdfe), -2147483648, bdfe.b(this.jdField_a_of_type_Bdfe), -2147483648, null, -2147483648);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdfh
 * JD-Core Version:    0.7.0.1
 */