import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;

public class bkyj
  extends blfs
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 3;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private bkpl jdField_a_of_type_Bkpl;
  private bkyq jdField_a_of_type_Bkyq;
  private blfq jdField_a_of_type_Blfq;
  private blfr jdField_a_of_type_Blfr;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  
  public bkyj(Activity paramActivity, View paramView, blft paramblft)
  {
    super(paramActivity, paramView, paramblft);
    this.jdField_a_of_type_Bkpl = ((bkpl)paramblft.a(65537, new Object[0]));
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Blfq.a())
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
    if (this.jdField_a_of_type_Blfq.a())
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
    if ((this.jdField_a_of_type_Bkyq == null) || (this.jdField_a_of_type_Bkyq.b() == null)) {
      return false;
    }
    Boolean localBoolean = (Boolean)this.jdField_a_of_type_Bkyq.b().a();
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
    localMarginLayoutParams.topMargin += xin.b(this.jdField_a_of_type_AndroidAppActivity, 20.0F);
    this.b.setLayoutParams(localLayoutParams);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Blfq = ((blfq)bkpx.a(this.jdField_a_of_type_Bkpl).a(blfq.class));
    this.jdField_a_of_type_Blfq.a.a(this.jdField_a_of_type_Bkpl, new bkyk(this));
    this.jdField_a_of_type_Bkyq = ((bkyq)bkpx.a(this.jdField_a_of_type_Bkpl).a(bkyq.class));
    this.jdField_a_of_type_Bkyq.a().a(this.jdField_a_of_type_Bkpl, new bkyl(this));
    this.jdField_a_of_type_Bkyq.b().a(this.jdField_a_of_type_Bkpl, new bkym(this));
    this.jdField_a_of_type_Blfr = ((blfr)bkpx.a(this.jdField_a_of_type_Bkpl).a(blfr.class));
    this.jdField_a_of_type_Blfr.a().a(this.jdField_a_of_type_Bkpl, new bkyn(this));
    this.jdField_a_of_type_Blfr.b().a(this.jdField_a_of_type_Bkpl, new bkyo(this));
    this.jdField_a_of_type_Blfr.c().a(this.jdField_a_of_type_Bkpl, new bkyp(this));
  }
  
  protected void a()
  {
    this.b = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377160)).inflate();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363848));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.b.findViewById(2131363914));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.c = this.b.findViewById(2131364092);
    this.d = this.b.findViewById(2131364986);
    this.f = this.b.findViewById(2131363148);
    this.f.setOnClickListener(this);
    this.e = this.b.findViewById(2131366471);
    this.g = this.b.findViewById(2131364874);
    this.g.setOnClickListener(this);
    this.h = this.b.findViewById(2131377325);
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
    } while ((!b()) || (this.jdField_a_of_type_Bkyq == null) || (this.jdField_a_of_type_Bkyq.b() == null));
    this.jdField_a_of_type_Bkyq.b().a(Boolean.valueOf(true));
  }
  
  public void b()
  {
    super.b();
    if (b()) {
      this.jdField_a_of_type_Bkyq.b().a(Boolean.valueOf(true));
    }
    if (this.e != null) {
      this.e.setSelected(this.jdField_a_of_type_Boolean);
    }
    bksp.a().f(this.jdField_a_of_type_Boolean);
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    boolean bool3 = true;
    switch (paramView.getId())
    {
    default: 
    case 2131363148: 
    case 2131364874: 
    case 2131377325: 
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              return;
              if (this.jdField_a_of_type_Blfq.a()) {}
              for (;;)
              {
                bmar.a(paramView, 200L, null);
                zaj.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
                if (this.jdField_a_of_type_Blft == null) {
                  break;
                }
                if (!this.jdField_a_of_type_Blfr.a()) {
                  break label139;
                }
                this.jdField_a_of_type_Blft.a(327686, new Object[0]);
                return;
                bliu.a().w();
              }
            } while (this.jdField_a_of_type_Blfr.b());
            if (!blat.i(this.jdField_a_of_type_Bkpl.a().getIntent())) {
              break;
            }
          } while (bljm.a(paramView));
          paramView = new Intent();
          paramView.setAction("ae_editor_bottom_tab_show_hide");
          paramView.putExtra("is_show", false);
          this.jdField_a_of_type_Bkpl.a().sendBroadcast(paramView);
          this.jdField_a_of_type_Blft.a(131077, new Object[0]);
          return;
          bmar.a(paramView, 200L, null);
          paramView = (bkyr)this.jdField_a_of_type_Bkyq.a().a();
          if ((paramView == null) || (!paramView.a())) {
            break;
          }
          i = 1;
          paramView = this.jdField_a_of_type_Bkyq.a();
          if (i != 0) {
            break label320;
          }
          bool1 = true;
          paramView.a(new bkyr(bool1, this.jdField_a_of_type_Int));
        } while (!this.jdField_a_of_type_Blfq.a());
        paramView = bliy.a();
        if (i == 0) {}
        for (bool1 = bool3;; bool1 = false)
        {
          paramView.d(bool1);
          return;
          i = 0;
          break;
          bool1 = false;
          break label272;
        }
        bmar.a(paramView, 200L, null);
        bool3 = b();
        paramView = this.jdField_a_of_type_Bkyq.b();
        if (bool3) {
          break;
        }
        bool1 = true;
        paramView.a(Boolean.valueOf(bool1));
      } while (!this.jdField_a_of_type_Blfq.a());
      paramView = bliy.a();
      if (!bool3) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramView.c(bool1);
        return;
        bool1 = false;
        break;
      }
    case 2131363914: 
      label139:
      label272:
      label320:
      bmar.a(paramView, 200L, null);
      this.jdField_a_of_type_Bkpl.u();
      return;
    }
    bmar.a(this.e, 200L, null);
    if (!this.e.isSelected()) {}
    for (;;)
    {
      if (this.jdField_a_of_type_Bkpl.a(bool1))
      {
        this.jdField_a_of_type_Boolean = bool1;
        this.e.setSelected(bool1);
        if (QLog.isDevelopLevel()) {
          bljn.a("AEVideoStoryTopBarPart", "onClick, mFlashButton.setSelected(), on=" + bool1);
        }
      }
      bliu.a().r();
      return;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyj
 * JD-Core Version:    0.7.0.1
 */