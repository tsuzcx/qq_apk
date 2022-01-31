import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;

public class bkpy
  extends bjwu
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private bkpf jdField_a_of_type_Bkpf;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  private View c;
  
  public bkpy(@NonNull bkpf parambkpf, Activity paramActivity)
  {
    super(parambkpf);
    this.jdField_a_of_type_Bkpf = parambkpf;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if (vuc.a().b() == 22) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private void a(String paramString)
  {
    String str = a().getString(2131718105);
    bgyf localbgyf = bgyf.a();
    bgxy.a(this.jdField_a_of_type_AndroidAppActivity, localbgyf, paramString, QQStoryContext.a().a(), "", 1010, str, false);
  }
  
  private void d()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131365523);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131561853, localRelativeLayout, false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, bkur.a, 0, 0);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131374093);
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131374092);
    if (this.jdField_a_of_type_Boolean)
    {
      this.b.setVisibility(8);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      return;
      this.b.setOnClickListener(new bkpz(this));
      this.c.setOnClickListener(new bkqa(this));
    }
  }
  
  private void j()
  {
    bbcv.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(2131718242).setPositiveButton(2131717755, new bkqc(this)).setNegativeButton(2131719536, new bkqb(this)).show();
  }
  
  private void k()
  {
    bbcv.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(2131718243).setPositiveButton(2131717755, new bkqe(this)).setNegativeButton(2131691035, new bkqd(this)).show();
  }
  
  public void a()
  {
    super.a();
    d();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1010) && (paramInt2 == -1))
    {
      bdid.a().a(2131717975);
      this.jdField_a_of_type_Bkpf.f = true;
    }
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_AndroidViewView == null);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    } while (this.jdField_a_of_type_AndroidViewView == null);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void g()
  {
    super.g();
    bhuo.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkpy
 * JD-Core Version:    0.7.0.1
 */