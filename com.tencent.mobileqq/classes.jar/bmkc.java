import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.MusicProviderView;

class bmkc
  implements View.OnClickListener
{
  bmkc(bmkb parambmkb) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "mRecognitionBubble onClick: invoked. ");
    }
    paramView = ((blua)blqr.a().c(8)).a();
    if ((MusicProviderView.a) && (paramView != null) && (paramView.mItemId != bmkb.a(this.a).mItemId) && (paramView.mType == 5))
    {
      this.a.c();
      return;
    }
    bmkb.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkc
 * JD-Core Version:    0.7.0.1
 */