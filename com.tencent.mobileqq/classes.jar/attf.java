import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;

class attf
  implements ShareActionSheet.OnItemClickListener
{
  attf(attd paramattd) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {}
    do
    {
      return;
      attd.a(this.a).dismiss();
      if (paramActionSheetItem.listener != null)
      {
        paramActionSheetItem.listener.onClick(null);
        return;
      }
    } while (attd.a(this.a) == null);
    attd.a(this.a).a(paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     attf
 * JD-Core Version:    0.7.0.1
 */