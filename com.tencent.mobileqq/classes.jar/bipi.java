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

public class bipi
  extends biwr
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 3;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private bijd jdField_a_of_type_Bijd;
  private bipp jdField_a_of_type_Bipp;
  private biwp jdField_a_of_type_Biwp;
  private biwq jdField_a_of_type_Biwq;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  
  public bipi(Activity paramActivity, View paramView, biws parambiws)
  {
    super(paramActivity, paramView, parambiws);
    this.jdField_a_of_type_Bijd = ((bijd)parambiws.a(65537, new Object[0]));
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Biwp.a())
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
    if (this.jdField_a_of_type_Biwp.a())
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
    if ((this.jdField_a_of_type_Bipp == null) || (this.jdField_a_of_type_Bipp.b() == null)) {
      return false;
    }
    Boolean localBoolean = (Boolean)this.jdField_a_of_type_Bipp.b().a();
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
    localMarginLayoutParams.topMargin += vpm.b(this.jdField_a_of_type_AndroidAppActivity, 20.0F);
    this.b.setLayoutParams(localLayoutParams);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Biwp = ((biwp)bijo.a(this.jdField_a_of_type_Bijd).a(biwp.class));
    this.jdField_a_of_type_Biwp.a().a(this.jdField_a_of_type_Bijd, new bipj(this));
    this.jdField_a_of_type_Bipp = ((bipp)bijo.a(this.jdField_a_of_type_Bijd).a(bipp.class));
    this.jdField_a_of_type_Bipp.a().a(this.jdField_a_of_type_Bijd, new bipk(this));
    this.jdField_a_of_type_Bipp.b().a(this.jdField_a_of_type_Bijd, new bipl(this));
    this.jdField_a_of_type_Biwq = ((biwq)bijo.a(this.jdField_a_of_type_Bijd).a(biwq.class));
    this.jdField_a_of_type_Biwq.a().a(this.jdField_a_of_type_Bijd, new bipm(this));
    this.jdField_a_of_type_Biwq.b().a(this.jdField_a_of_type_Bijd, new bipn(this));
    this.jdField_a_of_type_Biwq.c().a(this.jdField_a_of_type_Bijd, new bipo(this));
  }
  
  protected void a()
  {
    this.b = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131376605)).inflate();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363790));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.b.findViewById(2131363856));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.c = this.b.findViewById(2131364029);
    this.d = this.b.findViewById(2131364897);
    this.f = this.b.findViewById(2131363112);
    this.f.setOnClickListener(this);
    this.e = this.b.findViewById(2131366361);
    this.g = this.b.findViewById(2131364791);
    this.g.setOnClickListener(this);
    this.h = this.b.findViewById(2131376759);
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
    } while ((!b()) || (this.jdField_a_of_type_Bipp == null) || (this.jdField_a_of_type_Bipp.b() == null));
    this.jdField_a_of_type_Bipp.b().a(Boolean.valueOf(true));
  }
  
  public void b()
  {
    super.b();
    if (b()) {
      this.jdField_a_of_type_Bipp.b().a(Boolean.valueOf(true));
    }
    if (this.e != null) {
      this.e.setSelected(this.jdField_a_of_type_Boolean);
    }
    bika.a().f(this.jdField_a_of_type_Boolean);
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    boolean bool3 = true;
    switch (paramView.getId())
    {
    default: 
    case 2131363112: 
    case 2131364791: 
    case 2131376759: 
      do
      {
        int i;
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_Biwp.a()) {}
            for (;;)
            {
              bjkv.a(paramView, 200L, null);
              xhb.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
              if (this.jdField_a_of_type_Biws == null) {
                break;
              }
              if (!this.jdField_a_of_type_Biwq.a()) {
                break label139;
              }
              this.jdField_a_of_type_Biws.a(327686, new Object[0]);
              return;
              bizt.a().q();
            }
          } while (this.jdField_a_of_type_Biwq.b());
          this.jdField_a_of_type_Biws.a(131077, new Object[0]);
          return;
          bjkv.a(paramView, 200L, null);
          paramView = (bipq)this.jdField_a_of_type_Bipp.a().a();
          if ((paramView == null) || (!paramView.a())) {
            break;
          }
          i = 1;
          paramView = this.jdField_a_of_type_Bipp.a();
          if (i != 0) {
            break label261;
          }
          bool1 = true;
          paramView.a(new bipq(bool1, this.jdField_a_of_type_Int));
        } while (!this.jdField_a_of_type_Biwp.a());
        paramView = bizx.a();
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
        bjkv.a(paramView, 200L, null);
        bool3 = b();
        paramView = this.jdField_a_of_type_Bipp.b();
        if (bool3) {
          break;
        }
        bool1 = true;
        paramView.a(Boolean.valueOf(bool1));
      } while (!this.jdField_a_of_type_Biwp.a());
      paramView = bizx.a();
      if (!bool3) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramView.c(bool1);
        return;
        bool1 = false;
        break;
      }
    case 2131363856: 
      label139:
      label213:
      bjkv.a(paramView, 200L, null);
      label261:
      this.jdField_a_of_type_Bijd.u();
      return;
    }
    bjkv.a(this.e, 200L, null);
    if (!this.e.isSelected()) {}
    for (;;)
    {
      if (this.jdField_a_of_type_Bijd.a(bool1))
      {
        this.jdField_a_of_type_Boolean = bool1;
        this.e.setSelected(bool1);
        if (QLog.isDevelopLevel()) {
          bjah.a("AEVideoStoryTopBarPart", "onClick, mFlashButton.setSelected(), on=" + bool1);
        }
      }
      bizt.a().l();
      return;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bipi
 * JD-Core Version:    0.7.0.1
 */