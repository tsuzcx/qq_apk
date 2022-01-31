import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aoqq
  extends aokh<aoqo>
{
  public int a()
  {
    return 534;
  }
  
  @NonNull
  public aoqo a(int paramInt)
  {
    return new aoqo();
  }
  
  @Nullable
  public aoqo a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0) && (paramArrayOfaoko[0] != null))
    {
      aoqo localaoqo = aoqo.a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("QQComicConfProcessor", 2, "onParsed  " + paramArrayOfaoko[0].a);
      }
      return localaoqo;
    }
    return null;
  }
  
  public Class<aoqo> a()
  {
    return aoqo.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aoqo paramaoqo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicConfProcessor", 2, "onUpdate " + paramaoqo.toString());
    }
  }
  
  public boolean a()
  {
    return false;
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
 * Qualified Name:     aoqq
 * JD-Core Version:    0.7.0.1
 */