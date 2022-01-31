import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aoun
  extends aofy<String>
{
  public int a()
  {
    return 462;
  }
  
  public Class<String> a()
  {
    return String.class;
  }
  
  @NonNull
  public String a(int paramInt)
  {
    return "";
  }
  
  @Nullable
  public String a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoDrawConfProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length == 0)) {
      paramArrayOfaogf = null;
    }
    String str;
    do
    {
      return paramArrayOfaogf;
      str = paramArrayOfaogf[0].a;
      paramArrayOfaogf = str;
    } while (!QLog.isColorLevel());
    QLog.d("VideoDrawConfProcessor", 2, " onParsed, content:" + str);
    return str;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoDrawConfProcessor", 2, "onReqFailed");
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoDrawConfProcessor", 2, "onUpdate");
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoun
 * JD-Core Version:    0.7.0.1
 */