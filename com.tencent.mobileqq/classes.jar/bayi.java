import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qphone.base.util.QLog;

class bayi
  implements wiu
{
  bayi(bayh parambayh, String paramString, boolean paramBoolean) {}
  
  public void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Bayh.isDestroy) {}
    do
    {
      return;
      if (TextUtils.equals(this.jdField_a_of_type_Bayh.b, this.jdField_a_of_type_JavaLangString)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("WebSecurityPluginV2", 2, "receive check result but not current url");
    return;
    int i = paramBundle.getInt("result", -1);
    int j;
    int k;
    int m;
    int n;
    long l;
    Object localObject;
    if (i == 0)
    {
      j = paramBundle.getInt("jumpResult");
      k = paramBundle.getInt("level");
      m = paramBundle.getInt("subLevel");
      n = paramBundle.getInt("umrType");
      l = paramBundle.getLong("operationBit");
      localObject = this.jdField_a_of_type_Bayh;
      int i1 = ((bayh)localObject).jdField_a_of_type_Boolean;
      if (k == 15)
      {
        i = 1;
        label116:
        ((bayh)localObject).jdField_a_of_type_Boolean = (i & i1);
        if (j != 0) {
          break label252;
        }
        if (this.jdField_a_of_type_Boolean) {
          break label362;
        }
      }
    }
    label167:
    label360:
    label362:
    for (paramBundle = this.jdField_a_of_type_JavaLangString;; paramBundle = null)
    {
      QLog.i("UrlCheckLog", 1, "check pass l=" + k);
      this.jdField_a_of_type_Bayh.a(l);
      for (;;)
      {
        if (TextUtils.isEmpty(paramBundle)) {
          break label360;
        }
        localObject = this.jdField_a_of_type_Bayh.mRuntime.a();
        if (localObject == null) {
          break;
        }
        QLog.i("WebSecurityPluginV2", 1, "now jump url=" + mpw.b(paramBundle, new String[0]));
        this.jdField_a_of_type_Bayh.jdField_a_of_type_JavaLangString = paramBundle;
        ((CustomWebView)localObject).loadUrl(paramBundle);
        return;
        i = 0;
        break label116;
        label252:
        paramBundle = paramBundle.getString("jumpUrl");
        QLog.i("UrlCheckLog", 1, "check finish jr=" + j + ", l=" + k + ", sl=" + m + ", umr=" + n);
        break label167;
        QLog.i("UrlCheckLog", 1, "check fail r=" + i);
        if (!this.jdField_a_of_type_Boolean) {
          paramBundle = this.jdField_a_of_type_JavaLangString;
        } else {
          paramBundle = null;
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bayi
 * JD-Core Version:    0.7.0.1
 */