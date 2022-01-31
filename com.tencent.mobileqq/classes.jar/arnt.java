import mqq.app.QQPermissionCallback;

class arnt
  implements QQPermissionCallback
{
  arnt(arnp paramarnp, String paramString) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_Arnp.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{'result':-10, 'msg': 'no permission to read contact number'}" });
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    arnp.a(this.jdField_a_of_type_Arnp, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arnt
 * JD-Core Version:    0.7.0.1
 */