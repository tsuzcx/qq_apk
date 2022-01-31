import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;

class azik
  extends wlq
{
  azik(azih paramazih) {}
  
  protected void a(boolean paramBoolean, int paramInt, Bundle paramBundle, String paramString1, String paramString2)
  {
    if (paramBundle == null) {
      return;
    }
    int i = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131167766);
    paramBundle = paramBundle.getString("fileId");
    aysb.c("TroopFileManager", aysb.a, "delete onActionResult: fileId:" + paramBundle + " isSuccess:" + paramBoolean + " errorCode:" + paramInt);
    if (paramBoolean)
    {
      this.a.b(paramBundle);
      return;
    }
    switch (paramInt)
    {
    default: 
      bbmy.a(BaseApplicationImpl.getApplication(), ajjy.a(2131649574), 0).b(i);
      return;
    case -302: 
    case -301: 
    case -103: 
      bbmy.a(BaseApplicationImpl.getApplication(), ajjy.a(2131649571), 0).b(i);
      this.a.a(paramBundle);
      return;
    }
    bbmy.a(BaseApplicationImpl.getApplication(), ajjy.a(2131649555), 0).b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azik
 * JD-Core Version:    0.7.0.1
 */