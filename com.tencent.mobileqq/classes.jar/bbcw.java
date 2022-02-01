import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bbcw
  extends aqwt<bbcu>
{
  @NonNull
  public bbcu a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendClueConfigProcessor", 2, String.format("migrateOldOrDefaultContent type=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    return new bbcu();
  }
  
  @Nullable
  public bbcu a(aqxa[] paramArrayOfaqxa)
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    int i;
    if (paramArrayOfaqxa != null)
    {
      localObject1 = localObject3;
      if (paramArrayOfaqxa.length > 0)
      {
        int j = paramArrayOfaqxa.length;
        i = 0;
        localObject1 = localObject3;
        if (i < j)
        {
          localObject1 = paramArrayOfaqxa[i];
          if (localObject1 == null) {
            break label179;
          }
        }
      }
    }
    label179:
    Object localObject2;
    for (localObject1 = ((aqxa)localObject1).a;; localObject2 = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendClueConfigProcessor", 2, String.format("onParsed content=\n%s", new Object[] { localObject1 }));
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        try
        {
          bbcu localbbcu = new bbcu();
          localObject1 = new JSONObject((String)localObject1);
          if (((JSONObject)localObject1).has("friendClueSwitch")) {
            localbbcu.a = ((JSONObject)localObject1).getBoolean("friendClueSwitch");
          }
          if (QLog.isColorLevel()) {
            QLog.d("FriendClueConfigProcessor", 2, String.format("onParsed friendClueConfig=%s", new Object[] { localbbcu }));
          }
          localObject1 = localbbcu;
          return localObject1;
        }
        catch (Exception localException)
        {
          QLog.d("FriendClueConfigProcessor", 1, "onParsed fail.", localException);
        }
      }
      i += 1;
      break;
    }
  }
  
  public void a(bbcu parambbcu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendClueConfigProcessor", 2, String.format("onUpdate newConf=%s", new Object[] { parambbcu }));
    }
  }
  
  public Class<bbcu> clazz()
  {
    return bbcu.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("FriendClueConfigProcessor", 2, String.format("onReqFailed failCode=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public int type()
  {
    return 677;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcw
 * JD-Core Version:    0.7.0.1
 */