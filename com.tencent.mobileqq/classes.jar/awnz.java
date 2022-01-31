import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class awnz
  extends QIPCModule
{
  awnz(awny paramawny, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverIPCServer", 2, new Object[] { "onCall, action=" + paramString + ", params=" + paramBundle + ", callbackId=", Integer.valueOf(paramInt) });
    }
    if (paramBundle == null) {
      QLog.d("PrecoverIPCServer", 1, new Object[] { "onCall, params is null!!. action=" + paramString + ", callbackId=", Integer.valueOf(paramInt) });
    }
    do
    {
      Object localObject;
      do
      {
        do
        {
          return null;
          if (awny.a(this.a) == null)
          {
            QLog.d("PrecoverIPCServer", 1, new Object[] { "onCall, mManager is null!!. action=" + paramString + ", callbackId=", Integer.valueOf(paramInt) });
            return null;
          }
          paramBundle.putString("key_action", paramString);
          if (awnx.a.equals(paramString)) {
            return awny.a(this.a, paramBundle, paramInt);
          }
          if (awnx.b.equals(paramString))
          {
            paramString = awny.a(this.a, paramBundle, paramInt);
            if (paramString.isSuccess())
            {
              localObject = (PrecoverResource)paramBundle.getParcelable("resource");
              if (QLog.isColorLevel()) {
                QLog.d("PrecoverIPCServer", 2, "onCall, params.getParcelable, res=" + localObject);
              }
              if (awny.a(this.a).a().a((PrecoverResource)localObject, new Object[] { "PrecoverIPCServer_MODEL", Integer.valueOf(paramInt) })) {
                return EIPCResult.createResult(11, paramBundle);
              }
              paramBundle.putInt("errCode", -2);
              paramBundle.putString("errDesc", "args invalid or file already exist!");
              awny.a(this.a).callbackResult(paramInt, EIPCResult.createResult(-2, paramBundle));
            }
            return paramString;
          }
        } while (!awnx.c.equals(paramString));
        paramString = paramBundle.getString("businessId");
        localObject = paramBundle.getString("md5");
      } while ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty((CharSequence)localObject)));
      paramString = awny.a(this.a).a().a((String)localObject);
    } while (paramString == null);
    paramBundle.putLong("key_total", paramString.a);
    paramBundle.putLong("key_loaded", paramString.b);
    return EIPCResult.createSuccessResult(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awnz
 * JD-Core Version:    0.7.0.1
 */