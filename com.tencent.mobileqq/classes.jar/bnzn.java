import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment;
import java.util.List;

public class bnzn
  implements View.OnClickListener
{
  public bnzn(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    if (bnrf.a(paramView)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bnqm.a().B();
      if (AEEditorMultiCutEditFragment.a(this.a).size() >= 30)
      {
        QQToast.a(this.a.getActivity(), this.a.getResources().getString(2131689704, new Object[] { Integer.valueOf(30) }), 0).a();
      }
      else
      {
        if (AEEditorMultiCutEditFragment.a(this.a).a()) {
          AEEditorMultiCutEditFragment.a(this.a).b();
        }
        Object localObject = new bnlg().a(bnlb.E).b(false).a(true);
        if (AEEditorMultiCutEditFragment.a(this.a) != null) {
          i = AEEditorMultiCutEditFragment.a(this.a).size();
        }
        localObject = ((bnlg)localObject).a(i).a();
        bnlf.a(this.a.getActivity(), (Bundle)localObject, 1024);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnzn
 * JD-Core Version:    0.7.0.1
 */