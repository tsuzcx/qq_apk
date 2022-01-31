import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class bbzi
  extends aokh<bbzh>
{
  public int a()
  {
    return 605;
  }
  
  @NonNull
  public bbzh a(int paramInt)
  {
    QLog.d("PublishHwkThirdPartyEntryConfig.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bbzh();
  }
  
  @Nullable
  public bbzh a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0)) {
      return bbzh.a(paramArrayOfaoko[0].a);
    }
    return null;
  }
  
  public Class<bbzh> a()
  {
    return bbzh.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("PublishHwkThirdPartyEntryConfig.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public void a(bbzh parambbzh) {}
  
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
 * Qualified Name:     bbzi
 * JD-Core Version:    0.7.0.1
 */