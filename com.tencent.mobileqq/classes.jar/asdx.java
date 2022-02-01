import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoSlideBottomPanel;
import com.tencent.mobileqq.emoticonview.relateemo.RelatedEmotionPanel;

public class asdx
  implements DialogInterface.OnKeyListener
{
  public asdx(RelatedEmotionPanel paramRelatedEmotionPanel, RelatedEmoSlideBottomPanel paramRelatedEmoSlideBottomPanel) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmoSlideBottomPanel.a(4);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asdx
 * JD-Core Version:    0.7.0.1
 */