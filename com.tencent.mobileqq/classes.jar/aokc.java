import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextEffectView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextPanel;
import mqq.os.MqqHandler;

class aokc
  implements Runnable
{
  aokc(aokb paramaokb, String paramString, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Aokb.a.a == null) || (this.jdField_a_of_type_Aokb.a.a.a == null)) {}
    for (;;)
    {
      return;
      int j = this.jdField_a_of_type_Aokb.a.a.a.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = this.jdField_a_of_type_Aokb.a.a.a.getChildAt(i);
        localObject = (aojz)this.jdField_a_of_type_Aokb.a.a.getChildViewHolder((View)localObject);
        if ((((aojz)localObject).a.isContainsResUrl(this.jdField_a_of_type_JavaLangString)) && (((aojz)localObject).a.text_id == this.jdField_a_of_type_Int)) {
          ThreadManager.getUIHandler().post(new aokd(this, (aojz)localObject));
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aokc
 * JD-Core Version:    0.7.0.1
 */