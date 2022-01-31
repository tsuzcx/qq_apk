import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextEffectView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextPanel;

class aobh
  implements Runnable
{
  aobh(aobg paramaobg, String paramString, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Aobg.a.a == null) || (this.jdField_a_of_type_Aobg.a.a.a == null)) {}
    for (;;)
    {
      return;
      int j = this.jdField_a_of_type_Aobg.a.a.a.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = this.jdField_a_of_type_Aobg.a.a.a.getChildAt(i);
        aobe localaobe = (aobe)this.jdField_a_of_type_Aobg.a.a.getChildViewHolder(localView);
        if ((localaobe.a.isContainsResUrl(this.jdField_a_of_type_JavaLangString)) && (localaobe.a.text_id == this.jdField_a_of_type_Int)) {
          localView.post(new aobi(this, localaobe));
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aobh
 * JD-Core Version:    0.7.0.1
 */