import mqq.app.QQPermissionCallback;

class aqsx
  implements QQPermissionCallback
{
  aqsx(aqst paramaqst, String paramString) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_Aqst.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{'result':-10, 'msg': 'no permission to read contact number'}" });
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    aqst.a(this.jdField_a_of_type_Aqst, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqsx
 * JD-Core Version:    0.7.0.1
 */