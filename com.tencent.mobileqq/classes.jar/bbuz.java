import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class bbuz
  extends aofy<bbuy>
{
  public int a()
  {
    return 605;
  }
  
  @NonNull
  public bbuy a(int paramInt)
  {
    QLog.d("PublishHwkThirdPartyEntryConfig.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bbuy();
  }
  
  @Nullable
  public bbuy a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0)) {
      return bbuy.a(paramArrayOfaogf[0].a);
    }
    return null;
  }
  
  public Class<bbuy> a()
  {
    return bbuy.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("PublishHwkThirdPartyEntryConfig.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public void a(bbuy parambbuy) {}
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbuz
 * JD-Core Version:    0.7.0.1
 */