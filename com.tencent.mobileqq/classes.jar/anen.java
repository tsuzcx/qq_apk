import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;

public class anen
  implements andy
{
  private anen(andw paramandw) {}
  
  public boolean a(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if ((!"ScanCode".equals(paramString)) || (paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (!paramArrayOfVariantWrapper[0].IsFunction())) {}
    for (;;)
    {
      return false;
      long l = this.a.a(paramArrayOfVariantWrapper[0].Copy());
      paramString = new Intent();
      paramString.setClassName("com.tencent.mobileqq", "com.tencent.biz.qrcode.activity.ScannerActivity");
      paramString.putExtra("from", andw.class.getName());
      paramString.putExtra("finishAfterSucc", true);
      if (andw.a(this.a) != null) {}
      try
      {
        BaseApplicationImpl.getApplication().unregisterReceiver(andw.a(this.a));
        label105:
        andw.a(this.a, null);
        andw.a(this.a, new aneo(this, l));
        paramArrayOfVariantWrapper = new IntentFilter("com.tencent.mobileqq.ark.API.scanResultAction");
        BaseApplicationImpl.getApplication().registerReceiver(andw.a(this.a), paramArrayOfVariantWrapper, "com.tencent.msg.permission.pushnotify", null);
        paramArrayOfVariantWrapper = BaseActivity.sTopActivity;
        if (paramArrayOfVariantWrapper == null) {
          continue;
        }
        paramArrayOfVariantWrapper.startActivity(paramString);
        return false;
      }
      catch (Exception paramArrayOfVariantWrapper)
      {
        break label105;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anen
 * JD-Core Version:    0.7.0.1
 */