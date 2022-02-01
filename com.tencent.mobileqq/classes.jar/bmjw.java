import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
import dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView;
import java.util.List;

public class bmjw
  implements View.OnClickListener
{
  public bmjw(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  @RequiresApi(api=16)
  public void onClick(View paramView)
  {
    if (bmbv.a(paramView)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bmbc.a().C();
      if (this.a.a != null)
      {
        CutModelKt localCutModelKt = this.a.a.a();
        if (localCutModelKt != null) {
          if (AEEditorMultiCutEditFragment.a(this.a).size() == 1)
          {
            QQToast.a(this.a.getActivity(), 2131689695, 0).a();
          }
          else
          {
            FragmentActivity localFragmentActivity = this.a.getActivity();
            QQCustomDialog localQQCustomDialog = bfur.a(localFragmentActivity, 230);
            localQQCustomDialog.setTitle(localFragmentActivity.getString(2131689694));
            localQQCustomDialog.setMessage(localFragmentActivity.getString(2131689693));
            localQQCustomDialog.setPositiveButton(localFragmentActivity.getString(2131689713), new bmjx(this, localCutModelKt));
            localQQCustomDialog.setNegativeButton(localFragmentActivity.getString(2131689690), new bmjy(this));
            if (localQQCustomDialog != null) {
              try
              {
                if (!localQQCustomDialog.isShowing()) {
                  localQQCustomDialog.show();
                }
              }
              catch (Throwable localThrowable) {}
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjw
 * JD-Core Version:    0.7.0.1
 */