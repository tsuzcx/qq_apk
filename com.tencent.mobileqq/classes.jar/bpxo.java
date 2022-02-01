import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;

public class bpxo
  extends bpen
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private bpwv jdField_a_of_type_Bpwv;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  private View c;
  
  public bpxo(@NonNull bpwv parambpwv, Activity paramActivity)
  {
    super(parambpwv);
    this.jdField_a_of_type_Bpwv = parambpwv;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if (zgl.a().b() == 22) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private void a(String paramString)
  {
    String str = a().getString(2131716659);
    blsi localblsi = blsi.a();
    blsb.a(this.jdField_a_of_type_AndroidAppActivity, localblsi, paramString, QQStoryContext.a().a(), "", 1010, str, false);
  }
  
  private void d()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131365843);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131562292, localRelativeLayout, false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, bqcd.a, 0, 0);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131375321);
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131375320);
    if (this.jdField_a_of_type_Boolean)
    {
      this.b.setVisibility(8);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      return;
      this.b.setOnClickListener(new bpxp(this));
      this.c.setOnClickListener(new bpxq(this));
    }
  }
  
  private void j()
  {
    bglp.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(2131716793).setPositiveButton(2131716309, new bpxs(this)).setNegativeButton(2131718059, new bpxr(this)).show();
  }
  
  private void k()
  {
    bglp.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(2131716794).setPositiveButton(2131716309, new bpxu(this)).setNegativeButton(2131690912, new bpxt(this)).show();
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
      biti.a().a(2131716529);
      this.jdField_a_of_type_Bpwv.f = true;
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
    bmph.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpxo
 * JD-Core Version:    0.7.0.1
 */