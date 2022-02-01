import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

class bekk
  extends beke
{
  bekk(bekj parambekj) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("KEY_SESSION_UIN");
    int i = paramBundle.getInt("KEY_SESSION_TYPE");
    int j = paramBundle.getInt("KEY_FROM", -1);
    String str2 = paramBundle.getString("jump_url", "");
    String str1 = paramBundle.getString("error_msg", "");
    int k = paramBundle.getInt("error_code", 0);
    if ((paramBoolean) && (!TextUtils.isEmpty(str2)))
    {
      bekj.a(this.a, str2, i, (String)localObject, j);
      return;
    }
    if ((k == 10004) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)))
    {
      bekj.a(this.a, this.a.a.getApplication(), str2, i, (String)localObject, j, str1);
      return;
    }
    localObject = this.a.a.getApplication();
    paramBundle = str1;
    if (TextUtils.isEmpty(str1)) {
      paramBundle = ((Context)localObject).getString(2131692995);
    }
    QQToast.a((Context)localObject, 1, paramBundle, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bekk
 * JD-Core Version:    0.7.0.1
 */