import com.tencent.qphone.base.util.QLog;

class bfrm
  implements bfrt
{
  bfrm(bfrj parambfrj, bfrt parambfrt) {}
  
  public void a()
  {
    QLog.d("OpenSdkVirtualManager", 1, "updatePreAuthFromServer onSuccess");
    this.jdField_a_of_type_Bfrt.a();
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "updatePreAuthFromServer onFail errorCode=", Integer.valueOf(paramInt), ", msg=", paramString });
    this.jdField_a_of_type_Bfrt.a(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bfrm
 * JD-Core Version:    0.7.0.1
 */