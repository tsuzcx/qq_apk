import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.view.QRScanEntryView;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class apqm
  implements View.OnClickListener
{
  public apqm(QRScanEntryView paramQRScanEntryView) {}
  
  public void onClick(View paramView)
  {
    this.a.findViewById(2131369476).setAlpha(1.0F);
    ScanTorchActivity localScanTorchActivity = (ScanTorchActivity)this.a.jdField_a_of_type_AndroidContentContext;
    String str2 = this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    if (!TextUtils.isEmpty(localScanTorchActivity.a)) {}
    for (String str1 = localScanTorchActivity.a;; str1 = str2)
    {
      Intent localIntent = new Intent(localScanTorchActivity, QRDisplayActivity.class);
      localIntent.putExtra("from", "ScannerActivity");
      localIntent.putExtra("title", localScanTorchActivity.getString(2131716566));
      localIntent.putExtra("nick", str1);
      localIntent.putExtra("uin", str2);
      localIntent.putExtra("type", 1);
      localScanTorchActivity.startActivity(localIntent);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqm
 * JD-Core Version:    0.7.0.1
 */