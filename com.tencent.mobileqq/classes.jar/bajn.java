import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;

class bajn
  extends xas
{
  bajn(bajk parambajk) {}
  
  protected void a(boolean paramBoolean, int paramInt, Bundle paramBundle, String paramString1, String paramString2)
  {
    if (paramBundle == null) {
      return;
    }
    int i = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298865);
    paramBundle = paramBundle.getString("fileId");
    azsr.c("TroopFileManager", azsr.a, "delete onActionResult: fileId:" + paramBundle + " isSuccess:" + paramBoolean + " errorCode:" + paramInt);
    if (paramBoolean)
    {
      this.a.b(paramBundle);
      return;
    }
    switch (paramInt)
    {
    default: 
      bcpw.a(BaseApplicationImpl.getApplication(), ajyc.a(2131715364), 0).b(i);
      return;
    case -302: 
    case -301: 
    case -103: 
      bcpw.a(BaseApplicationImpl.getApplication(), ajyc.a(2131715361), 0).b(i);
      this.a.a(paramBundle);
      return;
    }
    bcpw.a(BaseApplicationImpl.getApplication(), ajyc.a(2131715345), 0).b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bajn
 * JD-Core Version:    0.7.0.1
 */