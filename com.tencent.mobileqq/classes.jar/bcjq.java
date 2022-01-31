import com.tencent.qphone.base.util.QLog;

class bcjq
  implements bcjx
{
  bcjq(bcjn parambcjn, bcjx parambcjx) {}
  
  public void a()
  {
    QLog.d("OpenSdkVirtualManager", 1, "updatePreAuthFromServer onSuccess");
    this.jdField_a_of_type_Bcjx.a();
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "updatePreAuthFromServer onFail errorCode=", Integer.valueOf(paramInt), ", msg=", paramString });
    this.jdField_a_of_type_Bcjx.a(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bcjq
 * JD-Core Version:    0.7.0.1
 */