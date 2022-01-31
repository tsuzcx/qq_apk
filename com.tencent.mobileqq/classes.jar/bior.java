import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;

public class bior
  extends biwa
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 3;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private biim jdField_a_of_type_Biim;
  private bioy jdField_a_of_type_Bioy;
  private bivy jdField_a_of_type_Bivy;
  private bivz jdField_a_of_type_Bivz;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  
  public bior(Activity paramActivity, View paramView, biwb parambiwb)
  {
    super(paramActivity, paramView, parambiwb);
    this.jdField_a_of_type_Biim = ((biim)parambiwb.a(65537, new Object[0]));
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Bivy.a())
      {
        this.h.setVisibility(0);
        this.g.setVisibility(0);
        this.e.setVisibility(8);
      }
      for (;;)
      {
        this.f.setVisibility(0);
        return;
        this.e.setVisibility(0);
      }
    }
    if (this.jdField_a_of_type_Bivy.a())
    {
      this.h.setVisibility(8);
      this.g.setVisibility(8);
    }
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.f.setVisibility(8);
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Bioy == null) || (this.jdField_a_of_type_Bioy.b() == null)) {
      return false;
    }
    Boolean localBoolean = (Boolean)this.jdField_a_of_type_Bioy.b().a();
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  private void d()
  {
    if (!"VIVO;V1836T".equalsIgnoreCase(Build.MANUFACTURER + ";" + Build.MODEL)) {}
    ViewGroup.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = this.b.getLayoutParams();
    } while (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localLayoutParams;
    localMarginLayoutParams.topMargin += vpp.b(this.jdField_a_of_type_AndroidAppActivity, 20.0F);
    this.b.setLayoutParams(localLayoutParams);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bivy = ((bivy)biix.a(this.jdField_a_of_type_Biim).a(bivy.class));
    this.jdField_a_of_type_Bivy.a().a(this.jdField_a_of_type_Biim, new bios(this));
    this.jdField_a_of_type_Bioy = ((bioy)biix.a(this.jdField_a_of_type_Biim).a(bioy.class));
    this.jdField_a_of_type_Bioy.a().a(this.jdField_a_of_type_Biim, new biot(this));
    this.jdField_a_of_type_Bioy.b().a(this.jdField_a_of_type_Biim, new biou(this));
    this.jdField_a_of_type_Bivz = ((bivz)biix.a(this.jdField_a_of_type_Biim).a(bivz.class));
    this.jdField_a_of_type_Bivz.a().a(this.jdField_a_of_type_Biim, new biov(this));
    this.jdField_a_of_type_Bivz.b().a(this.jdField_a_of_type_Biim, new biow(this));
    this.jdField_a_of_type_Bivz.c().a(this.jdField_a_of_type_Biim, new biox(this));
  }
  
  protected void a()
  {
    this.b = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131376603)).inflate();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363791));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.b.findViewById(2131363857));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.c = this.b.findViewById(2131364030);
    this.d = this.b.findViewById(2131364898);
    this.f = this.b.findViewById(2131363113);
    this.f.setOnClickListener(this);
    this.e = this.b.findViewById(2131366361);
    this.g = this.b.findViewById(2131364792);
    this.g.setOnClickListener(this);
    this.h = this.b.findViewById(2131376757);
    this.h.setOnClickListener(this);
    this.h.setSelected(false);
    this.e.setOnClickListener(this);
    this.e.setSelected(this.jdField_a_of_type_Boolean);
    e();
    d();
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while ((!b()) || (this.jdField_a_of_type_Bioy == null) || (this.jdField_a_of_type_Bioy.b() == null));
    this.jdField_a_of_type_Bioy.b().a(Boolean.valueOf(true));
  }
  
  public void b()
  {
    super.b();
    if (b()) {
      this.jdField_a_of_type_Bioy.b().a(Boolean.valueOf(true));
    }
    if (this.e != null) {
      this.e.setSelected(this.jdField_a_of_type_Boolean);
    }
    bijj.a().f(this.jdField_a_of_type_Boolean);
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    boolean bool3 = true;
    switch (paramView.getId())
    {
    default: 
    case 2131363113: 
    case 2131364792: 
    case 2131376757: 
      do
      {
        int i;
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_Bivy.a()) {}
            for (;;)
            {
              bjke.a(paramView, 200L, null);
              xhe.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
              if (this.jdField_a_of_type_Biwb == null) {
                break;
              }
              if (!this.jdField_a_of_type_Bivz.a()) {
                break label139;
              }
              this.jdField_a_of_type_Biwb.a(327686, new Object[0]);
              return;
              bizc.a().q();
            }
          } while (this.jdField_a_of_type_Bivz.b());
          this.jdField_a_of_type_Biwb.a(131077, new Object[0]);
          return;
          bjke.a(paramView, 200L, null);
          paramView = (bioz)this.jdField_a_of_type_Bioy.a().a();
          if ((paramView == null) || (!paramView.a())) {
            break;
          }
          i = 1;
          paramView = this.jdField_a_of_type_Bioy.a();
          if (i != 0) {
            break label261;
          }
          bool1 = true;
          paramView.a(new bioz(bool1, this.jdField_a_of_type_Int));
        } while (!this.jdField_a_of_type_Bivy.a());
        paramView = bizg.a();
        if (i == 0) {}
        for (bool1 = bool3;; bool1 = false)
        {
          paramView.d(bool1);
          return;
          i = 0;
          break;
          bool1 = false;
          break label213;
        }
        bjke.a(paramView, 200L, null);
        bool3 = b();
        paramView = this.jdField_a_of_type_Bioy.b();
        if (bool3) {
          break;
        }
        bool1 = true;
        paramView.a(Boolean.valueOf(bool1));
      } while (!this.jdField_a_of_type_Bivy.a());
      paramView = bizg.a();
      if (!bool3) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramView.c(bool1);
        return;
        bool1 = false;
        break;
      }
    case 2131363857: 
      label139:
      label213:
      bjke.a(paramView, 200L, null);
      label261:
      this.jdField_a_of_type_Biim.u();
      return;
    }
    bjke.a(this.e, 200L, null);
    if (!this.e.isSelected()) {}
    for (;;)
    {
      if (this.jdField_a_of_type_Biim.a(bool1))
      {
        this.jdField_a_of_type_Boolean = bool1;
        this.e.setSelected(bool1);
        if (QLog.isDevelopLevel()) {
          bizq.a("AEVideoStoryTopBarPart", "onClick, mFlashButton.setSelected(), on=" + bool1);
        }
      }
      bizc.a().l();
      return;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bior
 * JD-Core Version:    0.7.0.1
 */