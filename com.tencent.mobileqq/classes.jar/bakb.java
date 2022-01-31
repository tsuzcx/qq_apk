import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;

class bakb
  extends xap
{
  bakb(bajy parambajy) {}
  
  protected void a(boolean paramBoolean, int paramInt, Bundle paramBundle, String paramString1, String paramString2)
  {
    if (paramBundle == null) {
      return;
    }
    int i = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298865);
    paramBundle = paramBundle.getString("fileId");
    azst.c("TroopFileManager", azst.a, "delete onActionResult: fileId:" + paramBundle + " isSuccess:" + paramBoolean + " errorCode:" + paramInt);
    if (paramBoolean)
    {
      this.a.b(paramBundle);
      return;
    }
    switch (paramInt)
    {
    default: 
      bcql.a(BaseApplicationImpl.getApplication(), ajya.a(2131715375), 0).b(i);
      return;
    case -302: 
    case -301: 
    case -103: 
      bcql.a(BaseApplicationImpl.getApplication(), ajya.a(2131715372), 0).b(i);
      this.a.a(paramBundle);
      return;
    }
    bcql.a(BaseApplicationImpl.getApplication(), ajya.a(2131715356), 0).b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bakb
 * JD-Core Version:    0.7.0.1
 */