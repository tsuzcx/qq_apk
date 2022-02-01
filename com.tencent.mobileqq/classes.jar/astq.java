import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;

public class astq
  implements ShareActionSheet.OnItemClickListener
{
  public astq(AIOEmotionFragment paramAIOEmotionFragment) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    this.a.a.dismiss();
    int i = paramActionSheetItem.action;
    this.a.a(i, paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     astq
 * JD-Core Version:    0.7.0.1
 */