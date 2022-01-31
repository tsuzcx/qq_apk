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

public class bkuc
  extends blbl
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 3;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private bkle jdField_a_of_type_Bkle;
  private bkuj jdField_a_of_type_Bkuj;
  private blbj jdField_a_of_type_Blbj;
  private blbk jdField_a_of_type_Blbk;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  
  public bkuc(Activity paramActivity, View paramView, blbm paramblbm)
  {
    super(paramActivity, paramView, paramblbm);
    this.jdField_a_of_type_Bkle = ((bkle)paramblbm.a(65537, new Object[0]));
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Blbj.a())
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
    if (this.jdField_a_of_type_Blbj.a())
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
    if ((this.jdField_a_of_type_Bkuj == null) || (this.jdField_a_of_type_Bkuj.b() == null)) {
      return false;
    }
    Boolean localBoolean = (Boolean)this.jdField_a_of_type_Bkuj.b().a();
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
    localMarginLayoutParams.topMargin += xee.b(this.jdField_a_of_type_AndroidAppActivity, 20.0F);
    this.b.setLayoutParams(localLayoutParams);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Blbj = ((blbj)bklq.a(this.jdField_a_of_type_Bkle).a(blbj.class));
    this.jdField_a_of_type_Blbj.a.a(this.jdField_a_of_type_Bkle, new bkud(this));
    this.jdField_a_of_type_Bkuj = ((bkuj)bklq.a(this.jdField_a_of_type_Bkle).a(bkuj.class));
    this.jdField_a_of_type_Bkuj.a().a(this.jdField_a_of_type_Bkle, new bkue(this));
    this.jdField_a_of_type_Bkuj.b().a(this.jdField_a_of_type_Bkle, new bkuf(this));
    this.jdField_a_of_type_Blbk = ((blbk)bklq.a(this.jdField_a_of_type_Bkle).a(blbk.class));
    this.jdField_a_of_type_Blbk.a().a(this.jdField_a_of_type_Bkle, new bkug(this));
    this.jdField_a_of_type_Blbk.b().a(this.jdField_a_of_type_Bkle, new bkuh(this));
    this.jdField_a_of_type_Blbk.c().a(this.jdField_a_of_type_Bkle, new bkui(this));
  }
  
  protected void a()
  {
    this.b = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377106)).inflate();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363846));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.b.findViewById(2131363912));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.c = this.b.findViewById(2131364090);
    this.d = this.b.findViewById(2131364984);
    this.f = this.b.findViewById(2131363148);
    this.f.setOnClickListener(this);
    this.e = this.b.findViewById(2131366465);
    this.g = this.b.findViewById(2131364872);
    this.g.setOnClickListener(this);
    this.h = this.b.findViewById(2131377271);
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
    } while ((!b()) || (this.jdField_a_of_type_Bkuj == null) || (this.jdField_a_of_type_Bkuj.b() == null));
    this.jdField_a_of_type_Bkuj.b().a(Boolean.valueOf(true));
  }
  
  public void b()
  {
    super.b();
    if (b()) {
      this.jdField_a_of_type_Bkuj.b().a(Boolean.valueOf(true));
    }
    if (this.e != null) {
      this.e.setSelected(this.jdField_a_of_type_Boolean);
    }
    bkoi.a().f(this.jdField_a_of_type_Boolean);
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
    case 2131364872: 
    case 2131377271: 
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
              if (this.jdField_a_of_type_Blbj.a()) {}
              for (;;)
              {
                blwf.a(paramView, 200L, null);
                yvu.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
                if (this.jdField_a_of_type_Blbm == null) {
                  break;
                }
                if (!this.jdField_a_of_type_Blbk.a()) {
                  break label139;
                }
                this.jdField_a_of_type_Blbm.a(327686, new Object[0]);
                return;
                blen.a().w();
              }
            } while (this.jdField_a_of_type_Blbk.b());
            if (!bkwm.i(this.jdField_a_of_type_Bkle.a().getIntent())) {
              break;
            }
          } while (blff.a(paramView));
          paramView = new Intent();
          paramView.setAction("ae_editor_bottom_tab_show_hide");
          paramView.putExtra("is_show", false);
          this.jdField_a_of_type_Bkle.a().sendBroadcast(paramView);
          this.jdField_a_of_type_Blbm.a(131077, new Object[0]);
          return;
          blwf.a(paramView, 200L, null);
          paramView = (bkuk)this.jdField_a_of_type_Bkuj.a().a();
          if ((paramView == null) || (!paramView.a())) {
            break;
          }
          i = 1;
          paramView = this.jdField_a_of_type_Bkuj.a();
          if (i != 0) {
            break label320;
          }
          bool1 = true;
          paramView.a(new bkuk(bool1, this.jdField_a_of_type_Int));
        } while (!this.jdField_a_of_type_Blbj.a());
        paramView = bler.a();
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
        blwf.a(paramView, 200L, null);
        bool3 = b();
        paramView = this.jdField_a_of_type_Bkuj.b();
        if (bool3) {
          break;
        }
        bool1 = true;
        paramView.a(Boolean.valueOf(bool1));
      } while (!this.jdField_a_of_type_Blbj.a());
      paramView = bler.a();
      if (!bool3) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramView.c(bool1);
        return;
        bool1 = false;
        break;
      }
    case 2131363912: 
      label139:
      label272:
      label320:
      blwf.a(paramView, 200L, null);
      this.jdField_a_of_type_Bkle.u();
      return;
    }
    blwf.a(this.e, 200L, null);
    if (!this.e.isSelected()) {}
    for (;;)
    {
      if (this.jdField_a_of_type_Bkle.a(bool1))
      {
        this.jdField_a_of_type_Boolean = bool1;
        this.e.setSelected(bool1);
        if (QLog.isDevelopLevel()) {
          blfg.a("AEVideoStoryTopBarPart", "onClick, mFlashButton.setSelected(), on=" + bool1);
        }
      }
      blen.a().r();
      return;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkuc
 * JD-Core Version:    0.7.0.1
 */