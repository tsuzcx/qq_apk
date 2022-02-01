import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;

public class bqzj
  extends bqgi
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private bqyq jdField_a_of_type_Bqyq;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  private View c;
  
  public bqzj(@NonNull bqyq parambqyq, Activity paramActivity)
  {
    super(parambqyq);
    this.jdField_a_of_type_Bqyq = parambqyq;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if (zkg.a().b() == 22) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private void a(String paramString)
  {
    String str = a().getString(2131716775);
    bmtk localbmtk = bmtk.a();
    bmtd.a(this.jdField_a_of_type_AndroidAppActivity, localbmtk, paramString, QQStoryContext.a().a(), "", 1010, str, false);
  }
  
  private void d()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131365887);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131562332, localRelativeLayout, false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, LiuHaiUtils.a, 0, 0);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131375458);
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131375457);
    if (this.jdField_a_of_type_Boolean)
    {
      this.b.setVisibility(8);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      return;
      this.b.setOnClickListener(new bqzk(this));
      this.c.setOnClickListener(new bqzl(this));
    }
  }
  
  private void j()
  {
    bhlq.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(2131716909).setPositiveButton(2131716423, new bqzn(this)).setNegativeButton(2131718192, new bqzm(this)).show();
  }
  
  private void k()
  {
    bhlq.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(2131716910).setPositiveButton(2131716423, new bqzp(this)).setNegativeButton(2131690912, new bqzo(this)).show();
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
      bjuh.a().a(2131716645);
      this.jdField_a_of_type_Bqyq.f = true;
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
    bnqk.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqzj
 * JD-Core Version:    0.7.0.1
 */