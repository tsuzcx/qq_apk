import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.IDynamicTextResDownloadCallback;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextEffectView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextPanel;
import mqq.os.MqqHandler;

public class aokb
  implements DynamicTextConfigManager.IDynamicTextResDownloadCallback
{
  public aokb(EditTextPanel paramEditTextPanel) {}
  
  public void a(float paramFloat, String paramString, int paramInt)
  {
    this.a.post(new aokc(this, paramString, paramInt));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((this.a.a == null) || (this.a.a.a == null)) {}
    for (;;)
    {
      return;
      int j = this.a.a.a.getChildCount();
      DynamicTextConfigManager localDynamicTextConfigManager = (DynamicTextConfigManager)QIMManager.a(7);
      int i = 0;
      while (i < j)
      {
        Object localObject = this.a.a.a.getChildAt(i);
        localObject = (aojz)this.a.a.getChildViewHolder((View)localObject);
        if (((aojz)localObject).a.isContainsResUrl(paramString)) {
          ThreadManager.getUIHandler().post(new aoke(this, paramBoolean, (aojz)localObject, localDynamicTextConfigManager));
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aokb
 * JD-Core Version:    0.7.0.1
 */