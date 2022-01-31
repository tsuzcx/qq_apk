import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;

public class bngl
  extends bmnh
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private bnfs jdField_a_of_type_Bnfs;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  private View c;
  
  public bngl(@NonNull bnfs parambnfs, Activity paramActivity)
  {
    super(parambnfs);
    this.jdField_a_of_type_Bnfs = parambnfs;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if (xna.a().b() == 22) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private void a(String paramString)
  {
    String str = a().getString(2131718503);
    bjea localbjea = bjea.a();
    bjdt.a(this.jdField_a_of_type_AndroidAppActivity, localbjea, paramString, QQStoryContext.a().a(), "", 1010, str, false);
  }
  
  private void d()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131365609);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131562058, localRelativeLayout, false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, bnle.a, 0, 0);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131374601);
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131374600);
    if (this.jdField_a_of_type_Boolean)
    {
      this.b.setVisibility(8);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      return;
      this.b.setOnClickListener(new bngm(this));
      this.c.setOnClickListener(new bngn(this));
    }
  }
  
  private void j()
  {
    bdgm.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(2131718640).setPositiveButton(2131718149, new bngp(this)).setNegativeButton(2131720091, new bngo(this)).show();
  }
  
  private void k()
  {
    bdgm.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(2131718641).setPositiveButton(2131718149, new bngr(this)).setNegativeButton(2131691089, new bngq(this)).show();
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
      bflz.a().a(2131718373);
      this.jdField_a_of_type_Bnfs.f = true;
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
    bkax.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngl
 * JD-Core Version:    0.7.0.1
 */