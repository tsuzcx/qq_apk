import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.story.mode.StoryEffectTextMode.EditDialogListener.1;
import mqq.os.MqqHandler;

public class bjrv
  implements vmx
{
  Runnable a;
  public vls a;
  
  bjrv(bjrh parambjrh)
  {
    this.jdField_a_of_type_JavaLangRunnable = new StoryEffectTextMode.EditDialogListener.1(this);
  }
  
  public void a()
  {
    ((vld)bjrh.a(this.jdField_a_of_type_Bjrh).a("TextLayer")).c();
  }
  
  public void a(int paramInt)
  {
    ((vld)bjrh.a(this.jdField_a_of_type_Bjrh).a("TextLayer")).a(paramInt);
  }
  
  public void a(vls paramvls)
  {
    this.jdField_a_of_type_Vls = paramvls;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  public void a(boolean paramBoolean, vls paramvls)
  {
    vld localvld = (vld)bjrh.a(this.jdField_a_of_type_Bjrh).a("TextLayer");
    if (paramBoolean)
    {
      localvld.a(true);
      return;
    }
    paramvls.jdField_a_of_type_Int = bjrh.d(this.jdField_a_of_type_Bjrh);
    localvld.a(paramvls);
    localvld.a(false);
    if (bjrh.a(this.jdField_a_of_type_Bjrh))
    {
      bjrh.a(this.jdField_a_of_type_Bjrh).setVisibility(8);
      bjrh.a(this.jdField_a_of_type_Bjrh).setVisibility(8);
    }
    if (!TextUtils.equals(paramvls.jdField_a_of_type_JavaLangString, bjrh.a(this.jdField_a_of_type_Bjrh)))
    {
      bjrh.a(this.jdField_a_of_type_Bjrh, bjrh.a(this.jdField_a_of_type_Bjrh), paramvls.jdField_a_of_type_JavaLangString, bjrh.c(this.jdField_a_of_type_Bjrh), bjrh.d(this.jdField_a_of_type_Bjrh), 12, "onKeyboardHide");
      this.jdField_a_of_type_Bjrh.a.ac();
    }
    if ((!TextUtils.isEmpty(paramvls.jdField_a_of_type_JavaLangString)) || (bjrh.a(this.jdField_a_of_type_Bjrh))) {
      bjrh.b(this.jdField_a_of_type_Bjrh).setVisibility(8);
    }
    for (;;)
    {
      bjrh.a(this.jdField_a_of_type_Bjrh).dismiss();
      return;
      bjrh.b(this.jdField_a_of_type_Bjrh).setVisibility(0);
    }
  }
  
  public void b(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjrv
 * JD-Core Version:    0.7.0.1
 */