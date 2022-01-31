import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class azwq
  extends ampa<azwp>
{
  public int a()
  {
    return 605;
  }
  
  @NonNull
  public azwp a(int paramInt)
  {
    QLog.d("PublishHwkThirdPartyEntryConfig.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new azwp();
  }
  
  @Nullable
  public azwp a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0)) {
      return azwp.a(paramArrayOfamph[0].a);
    }
    return null;
  }
  
  public Class<azwp> a()
  {
    return azwp.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("PublishHwkThirdPartyEntryConfig.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public void a(azwp paramazwp) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azwq
 * JD-Core Version:    0.7.0.1
 */