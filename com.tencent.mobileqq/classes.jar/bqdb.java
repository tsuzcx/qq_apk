import com.tencent.qphone.base.util.QLog;

class bqdb
  extends bpor
{
  bqdb(bqcu parambqcu) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditProviderPart", 2, "EditProviderPart onFinish key=" + paramString + " result=" + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqdb
 * JD-Core Version:    0.7.0.1
 */