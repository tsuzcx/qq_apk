import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.util.WeakReference;

public class apan
  implements DialogInterface.OnClickListener
{
  public apan(MessageForGrayTips.HightlightClickableSpan paramHightlightClickableSpan) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (bdee.d(MessageForGrayTips.HightlightClickableSpan.access$100(this.a)))
    {
      paramDialogInterface.dismiss();
      MessageForGrayTips.HightlightClickableSpan.access$300(this.a, (QQAppInterface)MessageForGrayTips.HightlightClickableSpan.access$000(this.a).get(), MessageForGrayTips.HightlightClickableSpan.access$200(this.a).mMsgActionData);
      MessageForGrayTips.HightlightClickableSpan.access$300(this.a, (QQAppInterface)MessageForGrayTips.HightlightClickableSpan.access$000(this.a).get(), this.a.frienduin);
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, 2131691542, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apan
 * JD-Core Version:    0.7.0.1
 */