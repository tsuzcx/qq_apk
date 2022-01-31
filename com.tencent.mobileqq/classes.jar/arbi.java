import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;

class arbi
  implements ShareActionSheet.OnItemClickListener
{
  arbi(arbg paramarbg) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {}
    do
    {
      return;
      arbg.a(this.a).dismiss();
      if (paramActionSheetItem.listener != null)
      {
        paramActionSheetItem.listener.onClick(null);
        return;
      }
    } while (arbg.a(this.a) == null);
    arbg.a(this.a).a(paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arbi
 * JD-Core Version:    0.7.0.1
 */