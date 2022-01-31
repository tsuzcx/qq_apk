import com.tencent.qphone.base.util.QLog;

public class aonn
{
  public String a = "";
  
  public static aonn a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aonn localaonn = new aonn();
        localaonn.a = paramString;
        QLog.d("ConfBean", 2, "confBean = " + localaonn.toString());
        return localaonn;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("ConfBean", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("configContent:").append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aonn
 * JD-Core Version:    0.7.0.1
 */