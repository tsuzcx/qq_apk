import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;

public class bnbz
  extends bmiv
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private bnbg jdField_a_of_type_Bnbg;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  private View c;
  
  public bnbz(@NonNull bnbg parambnbg, Activity paramActivity)
  {
    super(parambnbg);
    this.jdField_a_of_type_Bnbg = parambnbg;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if (xir.a().b() == 22) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private void a(String paramString)
  {
    String str = a().getString(2131718491);
    bizt localbizt = bizt.a();
    bizm.a(this.jdField_a_of_type_AndroidAppActivity, localbizt, paramString, QQStoryContext.a().a(), "", 1010, str, false);
  }
  
  private void d()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131365607);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131562040, localRelativeLayout, false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, bngs.a, 0, 0);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131374550);
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131374549);
    if (this.jdField_a_of_type_Boolean)
    {
      this.b.setVisibility(8);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      return;
      this.b.setOnClickListener(new bnca(this));
      this.c.setOnClickListener(new bncb(this));
    }
  }
  
  private void j()
  {
    bdcd.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(2131718628).setPositiveButton(2131718137, new bncd(this)).setNegativeButton(2131720079, new bncc(this)).show();
  }
  
  private void k()
  {
    bdcd.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(2131718629).setPositiveButton(2131718137, new bncf(this)).setNegativeButton(2131691088, new bnce(this)).show();
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
      bfhq.a().a(2131718361);
      this.jdField_a_of_type_Bnbg.f = true;
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
    bjwq.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbz
 * JD-Core Version:    0.7.0.1
 */