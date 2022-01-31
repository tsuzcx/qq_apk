import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextEffectView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextPanel;

class anlc
  implements Runnable
{
  anlc(anlb paramanlb, String paramString, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Anlb.a.a == null) || (this.jdField_a_of_type_Anlb.a.a.a == null)) {}
    for (;;)
    {
      return;
      int j = this.jdField_a_of_type_Anlb.a.a.a.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = this.jdField_a_of_type_Anlb.a.a.a.getChildAt(i);
        ankz localankz = (ankz)this.jdField_a_of_type_Anlb.a.a.getChildViewHolder(localView);
        if ((localankz.a.isContainsResUrl(this.jdField_a_of_type_JavaLangString)) && (localankz.a.text_id == this.jdField_a_of_type_Int)) {
          localView.post(new anld(this, localankz));
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anlc
 * JD-Core Version:    0.7.0.1
 */