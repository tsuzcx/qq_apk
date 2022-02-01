import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class bgrq
  extends aavd
{
  bgrq(bgrn parambgrn) {}
  
  protected void a(boolean paramBoolean, int paramInt, Bundle paramBundle, String paramString1, String paramString2)
  {
    if (paramBundle == null) {
      return;
    }
    int i = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299011);
    paramBundle = paramBundle.getString("fileId");
    bfvr.c("TroopFileManager", bfvr.a, "delete onActionResult: fileId:" + paramBundle + " isSuccess:" + paramBoolean + " errorCode:" + paramInt);
    if (paramBoolean)
    {
      this.a.b(paramBundle);
      return;
    }
    switch (paramInt)
    {
    default: 
      QQToast.a(BaseApplicationImpl.getApplication(), anzj.a(2131714149), 0).b(i);
      return;
    case -302: 
    case -301: 
    case -103: 
      QQToast.a(BaseApplicationImpl.getApplication(), anzj.a(2131714146), 0).b(i);
      this.a.a(paramBundle);
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), anzj.a(2131714130), 0).b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgrq
 * JD-Core Version:    0.7.0.1
 */