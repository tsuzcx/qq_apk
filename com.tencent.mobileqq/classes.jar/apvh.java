import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class apvh
  extends aptq<apvg>
{
  public static void a()
  {
    apvg localapvg = (apvg)apub.a().a(430);
    apvg.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), false, localapvg);
  }
  
  @NonNull
  public apvg a(int paramInt)
  {
    return new apvg();
  }
  
  @Nullable
  public apvg a(aptx[] paramArrayOfaptx)
  {
    return apvg.a(paramArrayOfaptx);
  }
  
  public void a(apvg paramapvg)
  {
    QLog.w("ApolloConfig_GrayProcessor", 1, "onUpdate");
    apvg.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, paramapvg);
  }
  
  public Class<apvg> clazz()
  {
    return apvg.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.e("ApolloConfig_GrayProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public int type()
  {
    return 430;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apvh
 * JD-Core Version:    0.7.0.1
 */