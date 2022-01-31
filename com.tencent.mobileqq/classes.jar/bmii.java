import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.story.mode.StoryEffectTextMode.EditDialogListener.1;
import mqq.os.MqqHandler;

public class bmii
  implements xfv
{
  Runnable a;
  public xeq a;
  
  bmii(bmhu parambmhu)
  {
    this.jdField_a_of_type_JavaLangRunnable = new StoryEffectTextMode.EditDialogListener.1(this);
  }
  
  public void a()
  {
    ((xeb)bmhu.a(this.jdField_a_of_type_Bmhu).a("TextLayer")).c();
  }
  
  public void a(int paramInt)
  {
    ((xeb)bmhu.a(this.jdField_a_of_type_Bmhu).a("TextLayer")).a(paramInt);
  }
  
  public void a(xeq paramxeq)
  {
    this.jdField_a_of_type_Xeq = paramxeq;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  public void a(boolean paramBoolean, xeq paramxeq)
  {
    xeb localxeb = (xeb)bmhu.a(this.jdField_a_of_type_Bmhu).a("TextLayer");
    if (paramBoolean)
    {
      localxeb.a(true);
      return;
    }
    paramxeq.jdField_a_of_type_Int = bmhu.d(this.jdField_a_of_type_Bmhu);
    localxeb.a(paramxeq);
    localxeb.a(false);
    if (bmhu.a(this.jdField_a_of_type_Bmhu))
    {
      bmhu.a(this.jdField_a_of_type_Bmhu).setVisibility(8);
      bmhu.a(this.jdField_a_of_type_Bmhu).setVisibility(8);
    }
    if (!TextUtils.equals(paramxeq.jdField_a_of_type_JavaLangString, bmhu.a(this.jdField_a_of_type_Bmhu)))
    {
      bmhu.a(this.jdField_a_of_type_Bmhu, bmhu.a(this.jdField_a_of_type_Bmhu), paramxeq.jdField_a_of_type_JavaLangString, bmhu.c(this.jdField_a_of_type_Bmhu), bmhu.d(this.jdField_a_of_type_Bmhu), 12, "onKeyboardHide");
      this.jdField_a_of_type_Bmhu.a.ac();
    }
    if ((!TextUtils.isEmpty(paramxeq.jdField_a_of_type_JavaLangString)) || (bmhu.a(this.jdField_a_of_type_Bmhu))) {
      bmhu.b(this.jdField_a_of_type_Bmhu).setVisibility(8);
    }
    for (;;)
    {
      bmhu.a(this.jdField_a_of_type_Bmhu).dismiss();
      return;
      bmhu.b(this.jdField_a_of_type_Bmhu).setVisibility(0);
    }
  }
  
  public void b(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmii
 * JD-Core Version:    0.7.0.1
 */