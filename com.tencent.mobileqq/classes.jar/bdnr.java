import com.tencent.qphone.base.util.QLog;

class bdnr
  implements bdny
{
  bdnr(bdno parambdno, bdny parambdny) {}
  
  public void a()
  {
    QLog.d("OpenSdkVirtualManager", 1, "updatePreAuthFromServer onSuccess");
    this.jdField_a_of_type_Bdny.a();
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "updatePreAuthFromServer onFail errorCode=", Integer.valueOf(paramInt), ", msg=", paramString });
    this.jdField_a_of_type_Bdny.a(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdnr
 * JD-Core Version:    0.7.0.1
 */