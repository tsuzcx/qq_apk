import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment;
import java.util.List;

public class bmjv
  implements View.OnClickListener
{
  public bmjv(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    if (bmbv.a(paramView)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bmbc.a().B();
      if (AEEditorMultiCutEditFragment.a(this.a).size() >= 30)
      {
        QQToast.a(this.a.getActivity(), this.a.getResources().getString(2131689696, new Object[] { Integer.valueOf(30) }), 0).a();
      }
      else
      {
        if (AEEditorMultiCutEditFragment.a(this.a).a()) {
          AEEditorMultiCutEditFragment.a(this.a).b();
        }
        Object localObject = new blvw().a(blvr.E).b(false).a(true);
        if (AEEditorMultiCutEditFragment.a(this.a) != null) {
          i = AEEditorMultiCutEditFragment.a(this.a).size();
        }
        localObject = ((blvw)localObject).a(i).a();
        blvv.a(this.a.getActivity(), (Bundle)localObject, 1024);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjv
 * JD-Core Version:    0.7.0.1
 */