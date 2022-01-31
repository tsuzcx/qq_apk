import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightItem;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.util.WeakReference;

public class amsu
  implements DialogInterface.OnClickListener
{
  public amsu(MessageForGrayTips.HightlightClickableSpan paramHightlightClickableSpan) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (badq.d(MessageForGrayTips.HightlightClickableSpan.access$100(this.a)))
    {
      paramDialogInterface.dismiss();
      MessageForGrayTips.HightlightClickableSpan.access$300(this.a, (QQAppInterface)MessageForGrayTips.HightlightClickableSpan.access$000(this.a).get(), MessageForGrayTips.HightlightClickableSpan.access$200(this.a).mMsgActionData);
      MessageForGrayTips.HightlightClickableSpan.access$300(this.a, (QQAppInterface)MessageForGrayTips.HightlightClickableSpan.access$000(this.a).get(), this.a.frienduin);
      return;
    }
    bbmy.a(BaseApplication.getContext(), 1, 2131625912, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     amsu
 * JD-Core Version:    0.7.0.1
 */