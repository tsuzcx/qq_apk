import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;

class bcsq
  implements DialogInterface.OnClickListener
{
  bcsq(bcsp parambcsp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = String.format("https://qun.qq.com/qunpay/gifts/buy.html?_bid=2204&_wvSb=1&from=7&troopUin=%s", new Object[] { this.a.a.b });
    Intent localIntent = new Intent(this.a.a, QQBrowserActivity.class);
    localIntent.putExtra("selfSet_leftViewText", alpo.a(2131716076));
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", this.a.a.a(paramDialogInterface));
    this.a.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsq
 * JD-Core Version:    0.7.0.1
 */