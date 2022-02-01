import com.tencent.qphone.base.util.QLog;

class bjqd
  implements bjqj
{
  bjqd(bjqa parambjqa, bjqj parambjqj) {}
  
  public void a()
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "updatePreAuthFromServer onSuccess");
    this.jdField_a_of_type_Bjqj.a();
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "updatePreAuthFromServer onFail errorCode=", Integer.valueOf(paramInt), ", msg=", paramString });
    this.jdField_a_of_type_Bjqj.a(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bjqd
 * JD-Core Version:    0.7.0.1
 */