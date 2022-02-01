import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.story.mode.StoryEffectTextMode.EditDialogListener.1;
import mqq.os.MqqHandler;

public class bozo
  implements yzg
{
  Runnable a;
  public yyb a;
  
  bozo(boza paramboza)
  {
    this.jdField_a_of_type_JavaLangRunnable = new StoryEffectTextMode.EditDialogListener.1(this);
  }
  
  public void a()
  {
    ((yxm)boza.a(this.jdField_a_of_type_Boza).a("TextLayer")).c();
  }
  
  public void a(int paramInt)
  {
    ((yxm)boza.a(this.jdField_a_of_type_Boza).a("TextLayer")).a(paramInt);
  }
  
  public void a(yyb paramyyb)
  {
    this.jdField_a_of_type_Yyb = paramyyb;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  public void a(boolean paramBoolean, yyb paramyyb)
  {
    yxm localyxm = (yxm)boza.a(this.jdField_a_of_type_Boza).a("TextLayer");
    if (paramBoolean)
    {
      localyxm.a(true);
      return;
    }
    paramyyb.jdField_a_of_type_Int = boza.d(this.jdField_a_of_type_Boza);
    localyxm.a(paramyyb);
    localyxm.a(false);
    if (boza.a(this.jdField_a_of_type_Boza))
    {
      boza.a(this.jdField_a_of_type_Boza).setVisibility(8);
      boza.a(this.jdField_a_of_type_Boza).setVisibility(8);
    }
    if (!TextUtils.equals(paramyyb.jdField_a_of_type_JavaLangString, boza.a(this.jdField_a_of_type_Boza)))
    {
      boza.a(this.jdField_a_of_type_Boza, boza.a(this.jdField_a_of_type_Boza), paramyyb.jdField_a_of_type_JavaLangString, boza.c(this.jdField_a_of_type_Boza), boza.d(this.jdField_a_of_type_Boza), 12, "onKeyboardHide");
      this.jdField_a_of_type_Boza.a.ac();
    }
    if ((!TextUtils.isEmpty(paramyyb.jdField_a_of_type_JavaLangString)) || (boza.a(this.jdField_a_of_type_Boza))) {
      boza.b(this.jdField_a_of_type_Boza).setVisibility(8);
    }
    for (;;)
    {
      boza.a(this.jdField_a_of_type_Boza).dismiss();
      return;
      boza.b(this.jdField_a_of_type_Boza).setVisibility(0);
    }
  }
  
  public void b(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bozo
 * JD-Core Version:    0.7.0.1
 */