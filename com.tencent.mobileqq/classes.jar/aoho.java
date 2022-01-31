import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class aoho
  extends aofy<aohi>
{
  public static aohi b(int paramInt)
  {
    aohi localaohi = (aohi)aogj.a().a(paramInt);
    if (localaohi != null) {
      return localaohi;
    }
    return new aohi();
  }
  
  public int a()
  {
    return 0;
  }
  
  @NonNull
  public aohi a(int paramInt)
  {
    return new aohi();
  }
  
  public aohi a(String paramString)
  {
    QLog.d("ArkConfProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    return new aohi(paramString);
  }
  
  @Nullable
  public aohi a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkConfProcessor", 2, "[onParsed] config type = " + a());
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      paramArrayOfaogf = paramArrayOfaogf[0].a;
      if (!TextUtils.isEmpty(paramArrayOfaogf)) {
        return a(paramArrayOfaogf);
      }
      QLog.d("ArkConfProcessor", 1, "[onParsed] content is empty, config type = " + a());
    }
    return null;
  }
  
  public Class<aohi> a()
  {
    return aohi.class;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(int paramInt)
  {
    QLog.d("ArkConfProcessor", 1, "[onReqFailed] failCode=" + paramInt + ", config type = " + a());
  }
  
  public void a(aohi paramaohi)
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
 * Qualified Name:     aoho
 * JD-Core Version:    0.7.0.1
 */