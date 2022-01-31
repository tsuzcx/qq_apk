import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.story.mode.StoryEffectTextMode.EditDialogListener.1;
import mqq.os.MqqHandler;

public class bjsm
  implements vmu
{
  Runnable a;
  public vlp a;
  
  bjsm(bjry parambjry)
  {
    this.jdField_a_of_type_JavaLangRunnable = new StoryEffectTextMode.EditDialogListener.1(this);
  }
  
  public void a()
  {
    ((vla)bjry.a(this.jdField_a_of_type_Bjry).a("TextLayer")).c();
  }
  
  public void a(int paramInt)
  {
    ((vla)bjry.a(this.jdField_a_of_type_Bjry).a("TextLayer")).a(paramInt);
  }
  
  public void a(vlp paramvlp)
  {
    this.jdField_a_of_type_Vlp = paramvlp;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  public void a(boolean paramBoolean, vlp paramvlp)
  {
    vla localvla = (vla)bjry.a(this.jdField_a_of_type_Bjry).a("TextLayer");
    if (paramBoolean)
    {
      localvla.a(true);
      return;
    }
    paramvlp.jdField_a_of_type_Int = bjry.d(this.jdField_a_of_type_Bjry);
    localvla.a(paramvlp);
    localvla.a(false);
    if (bjry.a(this.jdField_a_of_type_Bjry))
    {
      bjry.a(this.jdField_a_of_type_Bjry).setVisibility(8);
      bjry.a(this.jdField_a_of_type_Bjry).setVisibility(8);
    }
    if (!TextUtils.equals(paramvlp.jdField_a_of_type_JavaLangString, bjry.a(this.jdField_a_of_type_Bjry)))
    {
      bjry.a(this.jdField_a_of_type_Bjry, bjry.a(this.jdField_a_of_type_Bjry), paramvlp.jdField_a_of_type_JavaLangString, bjry.c(this.jdField_a_of_type_Bjry), bjry.d(this.jdField_a_of_type_Bjry), 12, "onKeyboardHide");
      this.jdField_a_of_type_Bjry.a.ac();
    }
    if ((!TextUtils.isEmpty(paramvlp.jdField_a_of_type_JavaLangString)) || (bjry.a(this.jdField_a_of_type_Bjry))) {
      bjry.b(this.jdField_a_of_type_Bjry).setVisibility(8);
    }
    for (;;)
    {
      bjry.a(this.jdField_a_of_type_Bjry).dismiss();
      return;
      bjry.b(this.jdField_a_of_type_Bjry).setVisibility(0);
    }
  }
  
  public void b(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjsm
 * JD-Core Version:    0.7.0.1
 */