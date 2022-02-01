import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arcr
  extends aqwt<arcq>
{
  public static boolean a()
  {
    arcq localarcq = (arcq)aqxe.a().a(632);
    if (localarcq != null) {}
    for (boolean bool = localarcq.a();; bool = false)
    {
      QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, new Object[] { "isEnableFakeMsg = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @NonNull
  public arcq a(int paramInt)
  {
    return new arcq();
  }
  
  @Nullable
  public arcq a(aqxa[] paramArrayOfaqxa)
  {
    int i = 0;
    if (paramArrayOfaqxa == null) {}
    for (;;)
    {
      QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, new Object[] { "onParsed confFiles.length=", Integer.valueOf(i) });
      if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0)) {
        break;
      }
      new arcq();
      return arcq.a(paramArrayOfaqxa);
      i = paramArrayOfaqxa.length;
    }
    return null;
  }
  
  public void a(arcq paramarcq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 2, "onUpdate " + paramarcq.toString());
    }
  }
  
  public Class<arcq> clazz()
  {
    return arcq.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 632;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arcr
 * JD-Core Version:    0.7.0.1
 */