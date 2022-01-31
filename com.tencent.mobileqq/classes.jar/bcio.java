import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class bcio
  extends ypi
{
  bcio(bcil parambcil) {}
  
  protected void a(boolean paramBoolean, int paramInt, Bundle paramBundle, String paramString1, String paramString2)
  {
    if (paramBundle == null) {
      return;
    }
    int i = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298914);
    paramBundle = paramBundle.getString("fileId");
    bbrc.c("TroopFileManager", bbrc.a, "delete onActionResult: fileId:" + paramBundle + " isSuccess:" + paramBoolean + " errorCode:" + paramInt);
    if (paramBoolean)
    {
      this.a.b(paramBundle);
      return;
    }
    switch (paramInt)
    {
    default: 
      QQToast.a(BaseApplicationImpl.getApplication(), alpo.a(2131715747), 0).b(i);
      return;
    case -302: 
    case -301: 
    case -103: 
      QQToast.a(BaseApplicationImpl.getApplication(), alpo.a(2131715744), 0).b(i);
      this.a.a(paramBundle);
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), alpo.a(2131715728), 0).b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcio
 * JD-Core Version:    0.7.0.1
 */