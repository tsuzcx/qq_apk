import com.tencent.qphone.base.util.QLog;

class bfnd
  implements bfnk
{
  bfnd(bfna parambfna, bfnk parambfnk) {}
  
  public void a()
  {
    QLog.d("OpenSdkVirtualManager", 1, "updatePreAuthFromServer onSuccess");
    this.jdField_a_of_type_Bfnk.a();
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "updatePreAuthFromServer onFail errorCode=", Integer.valueOf(paramInt), ", msg=", paramString });
    this.jdField_a_of_type_Bfnk.a(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bfnd
 * JD-Core Version:    0.7.0.1
 */