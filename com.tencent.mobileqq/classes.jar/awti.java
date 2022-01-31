import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class awti
  implements bjqf
{
  public awti(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickyNotePublishFragment", 2, String.format("publishStickyNote onResult success=%s resultCode=%s resultMsg=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramString }));
    }
    if ((StickyNotePublishFragment.a(this.a) != null) && (StickyNotePublishFragment.a(this.a).isShowing())) {
      StickyNotePublishFragment.a(this.a).dismiss();
    }
    if (paramBoolean)
    {
      QQToast.a(BaseApplication.context, 2, 2131699677, 0).a();
      if (this.a.getActivity() != null)
      {
        StickyNotePublishFragment.b(this.a, false);
        this.a.a(this.a.getActivity().app);
        this.a.getActivity().setResult(-1);
        this.a.getActivity().finish();
      }
      return;
    }
    int i = 2131699675;
    if (paramInt == awta.b) {
      i = 2131699676;
    }
    QQToast.a(BaseApplication.context, 1, i, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awti
 * JD-Core Version:    0.7.0.1
 */