import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qrcode.ipc.QrHandleResultCallBack;
import cooperation.qlink.QQProxyForQlink;

public class amuu
  implements DialogInterface.OnClickListener
{
  public amuu(QQProxyForQlink paramQQProxyForQlink, QrHandleResultCallBack paramQrHandleResultCallBack) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQrcodeIpcQrHandleResultCallBack.a();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amuu
 * JD-Core Version:    0.7.0.1
 */