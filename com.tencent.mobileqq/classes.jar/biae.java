import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.story.mode.StoryEffectTextMode.EditDialogListener.1;
import mqq.os.MqqHandler;

public class biae
  implements vab
{
  Runnable a;
  public uyw a;
  
  biae(bhzq parambhzq)
  {
    this.jdField_a_of_type_JavaLangRunnable = new StoryEffectTextMode.EditDialogListener.1(this);
  }
  
  public void a()
  {
    ((uyh)bhzq.a(this.jdField_a_of_type_Bhzq).a("TextLayer")).c();
  }
  
  public void a(int paramInt)
  {
    ((uyh)bhzq.a(this.jdField_a_of_type_Bhzq).a("TextLayer")).a(paramInt);
  }
  
  public void a(uyw paramuyw)
  {
    this.jdField_a_of_type_Uyw = paramuyw;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  public void a(boolean paramBoolean, uyw paramuyw)
  {
    uyh localuyh = (uyh)bhzq.a(this.jdField_a_of_type_Bhzq).a("TextLayer");
    if (paramBoolean)
    {
      localuyh.a(true);
      return;
    }
    paramuyw.jdField_a_of_type_Int = bhzq.d(this.jdField_a_of_type_Bhzq);
    localuyh.a(paramuyw);
    localuyh.a(false);
    if (bhzq.a(this.jdField_a_of_type_Bhzq))
    {
      bhzq.a(this.jdField_a_of_type_Bhzq).setVisibility(8);
      bhzq.a(this.jdField_a_of_type_Bhzq).setVisibility(8);
    }
    if (!TextUtils.equals(paramuyw.jdField_a_of_type_JavaLangString, bhzq.a(this.jdField_a_of_type_Bhzq)))
    {
      bhzq.a(this.jdField_a_of_type_Bhzq, bhzq.a(this.jdField_a_of_type_Bhzq), paramuyw.jdField_a_of_type_JavaLangString, bhzq.c(this.jdField_a_of_type_Bhzq), bhzq.d(this.jdField_a_of_type_Bhzq), 12, "onKeyboardHide");
      this.jdField_a_of_type_Bhzq.a.ad();
    }
    if ((!TextUtils.isEmpty(paramuyw.jdField_a_of_type_JavaLangString)) || (bhzq.a(this.jdField_a_of_type_Bhzq))) {
      bhzq.b(this.jdField_a_of_type_Bhzq).setVisibility(8);
    }
    for (;;)
    {
      bhzq.a(this.jdField_a_of_type_Bhzq).dismiss();
      return;
      bhzq.b(this.jdField_a_of_type_Bhzq).setVisibility(0);
    }
  }
  
  public void b(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biae
 * JD-Core Version:    0.7.0.1
 */