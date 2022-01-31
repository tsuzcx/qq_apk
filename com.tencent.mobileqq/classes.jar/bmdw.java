import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.story.mode.StoryEffectTextMode.EditDialogListener.1;
import mqq.os.MqqHandler;

public class bmdw
  implements xbm
{
  Runnable a;
  public xah a;
  
  bmdw(bmdi parambmdi)
  {
    this.jdField_a_of_type_JavaLangRunnable = new StoryEffectTextMode.EditDialogListener.1(this);
  }
  
  public void a()
  {
    ((wzs)bmdi.a(this.jdField_a_of_type_Bmdi).a("TextLayer")).c();
  }
  
  public void a(int paramInt)
  {
    ((wzs)bmdi.a(this.jdField_a_of_type_Bmdi).a("TextLayer")).a(paramInt);
  }
  
  public void a(xah paramxah)
  {
    this.jdField_a_of_type_Xah = paramxah;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  public void a(boolean paramBoolean, xah paramxah)
  {
    wzs localwzs = (wzs)bmdi.a(this.jdField_a_of_type_Bmdi).a("TextLayer");
    if (paramBoolean)
    {
      localwzs.a(true);
      return;
    }
    paramxah.jdField_a_of_type_Int = bmdi.d(this.jdField_a_of_type_Bmdi);
    localwzs.a(paramxah);
    localwzs.a(false);
    if (bmdi.a(this.jdField_a_of_type_Bmdi))
    {
      bmdi.a(this.jdField_a_of_type_Bmdi).setVisibility(8);
      bmdi.a(this.jdField_a_of_type_Bmdi).setVisibility(8);
    }
    if (!TextUtils.equals(paramxah.jdField_a_of_type_JavaLangString, bmdi.a(this.jdField_a_of_type_Bmdi)))
    {
      bmdi.a(this.jdField_a_of_type_Bmdi, bmdi.a(this.jdField_a_of_type_Bmdi), paramxah.jdField_a_of_type_JavaLangString, bmdi.c(this.jdField_a_of_type_Bmdi), bmdi.d(this.jdField_a_of_type_Bmdi), 12, "onKeyboardHide");
      this.jdField_a_of_type_Bmdi.a.ac();
    }
    if ((!TextUtils.isEmpty(paramxah.jdField_a_of_type_JavaLangString)) || (bmdi.a(this.jdField_a_of_type_Bmdi))) {
      bmdi.b(this.jdField_a_of_type_Bmdi).setVisibility(8);
    }
    for (;;)
    {
      bmdi.a(this.jdField_a_of_type_Bmdi).dismiss();
      return;
      bmdi.b(this.jdField_a_of_type_Bmdi).setVisibility(0);
    }
  }
  
  public void b(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdw
 * JD-Core Version:    0.7.0.1
 */