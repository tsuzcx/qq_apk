import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class amqr
  extends ampb<amql>
{
  public static amql b(int paramInt)
  {
    amql localamql = (amql)ampm.a().a(paramInt);
    if (localamql != null) {
      return localamql;
    }
    return new amql();
  }
  
  public int a()
  {
    return 0;
  }
  
  @NonNull
  public amql a(int paramInt)
  {
    return new amql();
  }
  
  public amql a(String paramString)
  {
    QLog.d("ArkConfProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    return new amql(paramString);
  }
  
  @Nullable
  public amql a(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkConfProcessor", 2, "[onParsed] config type = " + a());
    }
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      paramArrayOfampi = paramArrayOfampi[0].a;
      if (!TextUtils.isEmpty(paramArrayOfampi)) {
        return a(paramArrayOfampi);
      }
      QLog.d("ArkConfProcessor", 1, "[onParsed] content is empty, config type = " + a());
    }
    return null;
  }
  
  public Class<amql> a()
  {
    return amql.class;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(int paramInt)
  {
    QLog.d("ArkConfProcessor", 1, "[onReqFailed] failCode=" + paramInt + ", config type = " + a());
  }
  
  public void a(amql paramamql)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkConfProcessor", 2, "[onUpdate]  config type = " + a());
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
 * Qualified Name:     amqr
 * JD-Core Version:    0.7.0.1
 */