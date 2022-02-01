import com.tencent.qphone.base.util.QLog;

class bjzr
  implements bjzx
{
  bjzr(bjzo parambjzo, bjzx parambjzx) {}
  
  public void a()
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "updatePreAuthFromServer onSuccess");
    this.jdField_a_of_type_Bjzx.a();
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "updatePreAuthFromServer onFail errorCode=", Integer.valueOf(paramInt), ", msg=", paramString });
    this.jdField_a_of_type_Bjzx.a(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bjzr
 * JD-Core Version:    0.7.0.1
 */