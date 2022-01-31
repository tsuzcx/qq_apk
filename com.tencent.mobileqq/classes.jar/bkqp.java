import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;

public class bkqp
  extends bjxl
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private bkpw jdField_a_of_type_Bkpw;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  private View c;
  
  public bkqp(@NonNull bkpw parambkpw, Activity paramActivity)
  {
    super(parambkpw);
    this.jdField_a_of_type_Bkpw = parambkpw;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if (vtz.a().b() == 22) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private void a(String paramString)
  {
    String str = a().getString(2131718116);
    bgyw localbgyw = bgyw.a();
    bgyp.a(this.jdField_a_of_type_AndroidAppActivity, localbgyw, paramString, QQStoryContext.a().a(), "", 1010, str, false);
  }
  
  private void d()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131365522);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131561852, localRelativeLayout, false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, bkvi.a, 0, 0);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131374095);
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131374094);
    if (this.jdField_a_of_type_Boolean)
    {
      this.b.setVisibility(8);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      return;
      this.b.setOnClickListener(new bkqq(this));
      this.c.setOnClickListener(new bkqr(this));
    }
  }
  
  private void j()
  {
    bbdj.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(2131718253).setPositiveButton(2131717766, new bkqt(this)).setNegativeButton(2131719547, new bkqs(this)).show();
  }
  
  private void k()
  {
    bbdj.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(2131718254).setPositiveButton(2131717766, new bkqv(this)).setNegativeButton(2131691035, new bkqu(this)).show();
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
      bdis.a().a(2131717986);
      this.jdField_a_of_type_Bkpw.f = true;
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
    bhvf.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkqp
 * JD-Core Version:    0.7.0.1
 */