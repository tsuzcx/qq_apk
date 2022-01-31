import android.content.Context;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

final class bfda
  implements bfdg
{
  bfda(bfdf parambfdf) {}
  
  public void a(boolean paramBoolean, Context paramContext, bfdi parambfdi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "openActivityForResult onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bfcz.d(paramContext, parambfdi);
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.a(paramBoolean);
      }
      return;
      Toast.makeText(BaseApplicationImpl.getContext(), ajjy.a(2131640049), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfda
 * JD-Core Version:    0.7.0.1
 */