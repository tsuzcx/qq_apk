import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class amqq
  extends ampa<amqk>
{
  public static amqk b(int paramInt)
  {
    amqk localamqk = (amqk)ampl.a().a(paramInt);
    if (localamqk != null) {
      return localamqk;
    }
    return new amqk();
  }
  
  public int a()
  {
    return 0;
  }
  
  @NonNull
  public amqk a(int paramInt)
  {
    return new amqk();
  }
  
  public amqk a(String paramString)
  {
    QLog.d("ArkConfProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    return new amqk(paramString);
  }
  
  @Nullable
  public amqk a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkConfProcessor", 2, "[onParsed] config type = " + a());
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      paramArrayOfamph = paramArrayOfamph[0].a;
      if (!TextUtils.isEmpty(paramArrayOfamph)) {
        return a(paramArrayOfamph);
      }
      QLog.d("ArkConfProcessor", 1, "[onParsed] content is empty, config type = " + a());
    }
    return null;
  }
  
  public Class<amqk> a()
  {
    return amqk.class;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(int paramInt)
  {
    QLog.d("ArkConfProcessor", 1, "[onReqFailed] failCode=" + paramInt + ", config type = " + a());
  }
  
  public void a(amqk paramamqk)
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
 * Qualified Name:     amqq
 * JD-Core Version:    0.7.0.1
 */