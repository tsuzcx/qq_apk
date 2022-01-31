import android.widget.PopupWindow.OnDismissListener;
import com.tencent.widget.KandianPopupWindow;

public class amjt
  implements PopupWindow.OnDismissListener
{
  public amjt(KandianPopupWindow paramKandianPopupWindow) {}
  
  public void onDismiss()
  {
    this.a.a = null;
    KandianPopupWindow.a(this.a, 1.0F);
    com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amjt
 * JD-Core Version:    0.7.0.1
 */