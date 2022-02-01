import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;

class auae
  implements ShareActionSheet.OnItemClickListener
{
  auae(auaa paramauaa) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {}
    do
    {
      return;
      auaa.a(this.a).dismiss();
      if (paramActionSheetItem.listener != null)
      {
        paramActionSheetItem.listener.onClick(null);
        return;
      }
    } while (this.a.a == null);
    this.a.a.a(paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auae
 * JD-Core Version:    0.7.0.1
 */