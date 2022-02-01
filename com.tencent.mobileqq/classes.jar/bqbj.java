import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.story.mode.StoryEffectTextMode.EditDialogListener.1;
import mqq.os.MqqHandler;

public class bqbj
  implements zdb
{
  Runnable a;
  public zbw a;
  
  bqbj(bqav parambqav)
  {
    this.jdField_a_of_type_JavaLangRunnable = new StoryEffectTextMode.EditDialogListener.1(this);
  }
  
  public void a()
  {
    ((zbh)bqav.a(this.jdField_a_of_type_Bqav).a("TextLayer")).c();
  }
  
  public void a(int paramInt)
  {
    ((zbh)bqav.a(this.jdField_a_of_type_Bqav).a("TextLayer")).a(paramInt);
  }
  
  public void a(zbw paramzbw)
  {
    this.jdField_a_of_type_Zbw = paramzbw;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  public void a(boolean paramBoolean, zbw paramzbw)
  {
    zbh localzbh = (zbh)bqav.a(this.jdField_a_of_type_Bqav).a("TextLayer");
    if (paramBoolean)
    {
      localzbh.a(true);
      return;
    }
    paramzbw.jdField_a_of_type_Int = bqav.d(this.jdField_a_of_type_Bqav);
    localzbh.a(paramzbw);
    localzbh.a(false);
    if (bqav.a(this.jdField_a_of_type_Bqav))
    {
      bqav.a(this.jdField_a_of_type_Bqav).setVisibility(8);
      bqav.a(this.jdField_a_of_type_Bqav).setVisibility(8);
    }
    if (!TextUtils.equals(paramzbw.jdField_a_of_type_JavaLangString, bqav.a(this.jdField_a_of_type_Bqav)))
    {
      bqav.a(this.jdField_a_of_type_Bqav, bqav.a(this.jdField_a_of_type_Bqav), paramzbw.jdField_a_of_type_JavaLangString, bqav.c(this.jdField_a_of_type_Bqav), bqav.d(this.jdField_a_of_type_Bqav), 12, "onKeyboardHide");
      this.jdField_a_of_type_Bqav.a.ac();
    }
    if ((!TextUtils.isEmpty(paramzbw.jdField_a_of_type_JavaLangString)) || (bqav.a(this.jdField_a_of_type_Bqav))) {
      bqav.b(this.jdField_a_of_type_Bqav).setVisibility(8);
    }
    for (;;)
    {
      bqav.a(this.jdField_a_of_type_Bqav).dismiss();
      return;
      bqav.b(this.jdField_a_of_type_Bqav).setVisibility(0);
    }
  }
  
  public void b(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqbj
 * JD-Core Version:    0.7.0.1
 */