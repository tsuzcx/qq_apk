import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class aolx
  extends aokh<aolr>
{
  public static aolr b(int paramInt)
  {
    aolr localaolr = (aolr)aoks.a().a(paramInt);
    if (localaolr != null) {
      return localaolr;
    }
    return new aolr();
  }
  
  public int a()
  {
    return 0;
  }
  
  @NonNull
  public aolr a(int paramInt)
  {
    return new aolr();
  }
  
  public aolr a(String paramString)
  {
    QLog.d("ArkConfProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    return new aolr(paramString);
  }
  
  @Nullable
  public aolr a(aoko[] paramArrayOfaoko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkConfProcessor", 2, "[onParsed] config type = " + a());
    }
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      paramArrayOfaoko = paramArrayOfaoko[0].a;
      if (!TextUtils.isEmpty(paramArrayOfaoko)) {
        return a(paramArrayOfaoko);
      }
      QLog.d("ArkConfProcessor", 1, "[onParsed] content is empty, config type = " + a());
    }
    return null;
  }
  
  public Class<aolr> a()
  {
    return aolr.class;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(int paramInt)
  {
    QLog.d("ArkConfProcessor", 1, "[onReqFailed] failCode=" + paramInt + ", config type = " + a());
  }
  
  public void a(aolr paramaolr)
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
 * Qualified Name:     aolx
 * JD-Core Version:    0.7.0.1
 */