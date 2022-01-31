import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;

public class bizm
  extends bifz
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private biyt jdField_a_of_type_Biyt;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  private View c;
  
  public bizm(@NonNull biyt parambiyt, Activity paramActivity)
  {
    super(parambiyt);
    this.jdField_a_of_type_Biyt = parambiyt;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if (vhg.a().b() == 22) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private void a(String paramString)
  {
    String str = a().getString(2131652286);
    bfpy localbfpy = bfpy.a();
    bfpr.a(this.jdField_a_of_type_AndroidAppActivity, localbfpy, paramString, QQStoryContext.a().a(), "", 1010, str, false);
  }
  
  private void d()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131299943);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131496256, localRelativeLayout, false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, bjeh.a, 0, 0);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131308372);
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131308371);
    if (this.jdField_a_of_type_Boolean)
    {
      this.b.setVisibility(8);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      return;
      this.b.setOnClickListener(new bizn(this));
      this.c.setOnClickListener(new bizo(this));
    }
  }
  
  private void j()
  {
    babr.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(2131652423).setPositiveButton(2131651963, new bizq(this)).setNegativeButton(2131653652, new bizp(this)).show();
  }
  
  private void k()
  {
    babr.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(2131652424).setPositiveButton(2131651963, new bizs(this)).setNegativeButton(2131625463, new bizr(this)).show();
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
      bcec.a().a(2131652159);
      this.jdField_a_of_type_Biyt.f = true;
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
    bglt.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bizm
 * JD-Core Version:    0.7.0.1
 */