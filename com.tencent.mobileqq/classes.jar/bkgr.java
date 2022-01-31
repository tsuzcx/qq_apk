import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextEffectView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextPanel;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextPanel.2.1;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextPanel.2.2;
import mqq.os.MqqHandler;

public class bkgr
  implements bjgv
{
  public bkgr(EditTextPanel paramEditTextPanel) {}
  
  public void a(float paramFloat, String paramString, int paramInt)
  {
    this.a.post(new EditTextPanel.2.1(this, paramString, paramInt));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((this.a.a == null) || (this.a.a.a == null)) {}
    for (;;)
    {
      return;
      int j = this.a.a.a.getChildCount();
      DynamicTextConfigManager localDynamicTextConfigManager = (DynamicTextConfigManager)bjae.a(7);
      int i = 0;
      while (i < j)
      {
        Object localObject = this.a.a.a.getChildAt(i);
        localObject = (bkgq)this.a.a.getChildViewHolder((View)localObject);
        if (((bkgq)localObject).a.isContainsResUrl(paramString)) {
          ThreadManager.getUIHandler().post(new EditTextPanel.2.2(this, paramBoolean, (bkgq)localObject, localDynamicTextConfigManager));
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkgr
 * JD-Core Version:    0.7.0.1
 */