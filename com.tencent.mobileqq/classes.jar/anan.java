import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class anan
  extends ampb<anao>
{
  public int a()
  {
    return 589;
  }
  
  @NonNull
  public anao a(int paramInt)
  {
    return new anao();
  }
  
  @Nullable
  public anao a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      anao localanao = anao.a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.i("UinSearchConfProcessor", 2, "onParsed: " + paramArrayOfampi[0].a);
      }
      return localanao;
    }
    return new anao();
  }
  
  public Class<anao> a()
  {
    return anao.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UinSearchConfProcessor", 2, "onReqFailed: " + paramInt);
    }
  }
  
  public void a(anao paramanao)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UinSearchConfProcessor", 2, "onUpdate");
    }
  }
  
  public boolean a()
  {
    return true;
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
 * Qualified Name:     anan
 * JD-Core Version:    0.7.0.1
 */