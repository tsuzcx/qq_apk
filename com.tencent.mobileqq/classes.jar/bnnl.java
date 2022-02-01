import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.view.AECompoundButton;

public class bnnl
  extends bnva
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 3;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private bndy jdField_a_of_type_Bndy;
  private bnuy jdField_a_of_type_Bnuy;
  private bnuz jdField_a_of_type_Bnuz;
  private AEVideoStoryTopBarViewModel jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel;
  private AECompoundButton jdField_a_of_type_DovComQqImAeViewAECompoundButton;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private AECompoundButton jdField_b_of_type_DovComQqImAeViewAECompoundButton;
  private AECompoundButton c;
  private AECompoundButton d;
  private AECompoundButton e;
  private AECompoundButton f;
  private AECompoundButton g;
  private AECompoundButton h;
  
  public bnnl(Activity paramActivity, View paramView, bnvb parambnvb)
  {
    super(paramActivity, paramView, parambnvb);
    this.jdField_a_of_type_Bndy = ((bndy)parambnvb.a(65537, new Object[0]));
  }
  
  private void a(@NonNull bnzg parambnzg)
  {
    if (!bnqb.j(this.jdField_a_of_type_AndroidAppActivity.getIntent())) {}
    do
    {
      return;
      if (this.e != null) {
        this.e.setForegroundAndBackgroundResource(parambnzg.h, parambnzg.g);
      }
      if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null) {
        this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setForegroundAndBackgroundResource(parambnzg.i, parambnzg.g);
      }
      if (this.h != null) {
        this.h.setForegroundAndBackgroundResource(parambnzg.j, parambnzg.g);
      }
      if (this.c != null) {
        this.c.setForegroundAndBackgroundResource(parambnzg.k, parambnzg.g);
      }
      if (this.d != null) {
        this.d.setForegroundAndBackgroundResource(parambnzg.l, parambnzg.g);
      }
    } while (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton == null);
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setForegroundAndBackgroundResource(parambnzg.m, parambnzg.g);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Bnuy.a())
      {
        this.g.setVisibility(0);
        this.f.setVisibility(0);
        this.c.setVisibility(8);
        this.h.setVisibility(8);
      }
      for (;;)
      {
        this.d.setVisibility(0);
        return;
        this.c.setVisibility(0);
        if (bnqb.j(this.jdField_a_of_type_AndroidAppActivity.getIntent())) {
          this.h.setVisibility(0);
        }
      }
    }
    if (this.jdField_a_of_type_Bnuy.a())
    {
      this.g.setVisibility(8);
      this.f.setVisibility(8);
    }
    this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.h.setVisibility(8);
  }
  
  private boolean b()
  {
    return "OPPO;PBBM30".equalsIgnoreCase(Build.MANUFACTURER + ";" + Build.MODEL);
  }
  
  private boolean c()
  {
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel == null) || (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b() == null)) {
      return false;
    }
    Boolean localBoolean = (Boolean)this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().getValue();
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
      localLayoutParams = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    } while (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localLayoutParams;
    localMarginLayoutParams.topMargin += zby.b(this.jdField_a_of_type_AndroidAppActivity, 20.0F);
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bnuy = ((bnuy)bner.a(this.jdField_a_of_type_Bndy).get(bnuy.class));
    this.jdField_a_of_type_Bnuy.a.observe(this.jdField_a_of_type_Bndy, new bnnn(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)bner.a(this.jdField_a_of_type_Bndy).get(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a().observe(this.jdField_a_of_type_Bndy, new bnno(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().observe(this.jdField_a_of_type_Bndy, new bnnp(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.observe(this.jdField_a_of_type_Bndy, new bnnq(this));
    this.jdField_a_of_type_Bnuz = ((bnuz)bner.a(this.jdField_a_of_type_Bndy).get(bnuz.class));
    this.jdField_a_of_type_Bnuz.a().observe(this.jdField_a_of_type_Bndy, new bnnr(this));
    this.jdField_a_of_type_Bnuz.b().observe(this.jdField_a_of_type_Bndy, new bnns(this));
    this.jdField_a_of_type_Bnuz.c().observe(this.jdField_a_of_type_Bndy, new bnnt(this));
  }
  
  protected void a()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377967);
    if (localViewStub != null) {
      this.jdField_b_of_type_AndroidViewView = localViewStub.inflate();
    }
    ViewCompat.setOnApplyWindowInsetsListener(this.jdField_b_of_type_AndroidViewView, new bnnm(this));
    ViewCompat.requestApplyInsets(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364054));
    this.e = ((AECompoundButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131364117));
    this.e.setOnClickListener(this);
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131364298));
    this.jdField_b_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131365222));
    this.d = ((AECompoundButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131363335));
    this.d.setOnClickListener(this);
    this.c = ((AECompoundButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131366736));
    this.f = ((AECompoundButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131365104));
    this.f.setOnClickListener(this);
    this.g = ((AECompoundButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131378138));
    this.g.setOnClickListener(this);
    this.g.setSelected(false);
    this.c.setOnClickListener(this);
    this.c.setSelected(this.jdField_a_of_type_Boolean);
    this.h = ((AECompoundButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131378131));
    this.h.setOnClickListener(this);
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
    } while ((!c()) || (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel == null) || (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b() == null));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().postValue(Boolean.valueOf(true));
  }
  
  public void b()
  {
    super.b();
    if (c()) {
      this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().postValue(Boolean.valueOf(true));
    }
    if (this.c != null) {
      this.c.setSelected(this.jdField_a_of_type_Boolean);
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    boolean bool3 = true;
    switch (paramView.getId())
    {
    }
    label410:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Bnuy.a()) {}
      for (;;)
      {
        botv.a(this.d.a(), 200L, null);
        aaxb.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
        if (this.jdField_a_of_type_Bnvb == null) {
          break;
        }
        if (!this.jdField_a_of_type_Bnuz.a()) {
          break label162;
        }
        this.jdField_a_of_type_Bnvb.a(327686, new Object[0]);
        break;
        bnyh.a().J();
      }
      label162:
      if (!this.jdField_a_of_type_Bnuz.b())
      {
        Object localObject;
        if (bnqb.j(this.jdField_a_of_type_Bndy.a().getIntent()))
        {
          if (!bnyz.a(paramView))
          {
            localObject = new Intent();
            ((Intent)localObject).setAction("ae_editor_bottom_tab_show_hide");
            ((Intent)localObject).putExtra("is_show", false);
            this.jdField_a_of_type_Bndy.a().sendBroadcast((Intent)localObject);
          }
        }
        else
        {
          this.jdField_a_of_type_Bnvb.a(131077, new Object[0]);
          continue;
          botv.a(this.f.a(), 200L, null);
          localObject = (bnnv)this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a().getValue();
          int i;
          if ((localObject != null) && (((bnnv)localObject).a()))
          {
            i = 1;
            label296:
            localObject = this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a();
            if (i != 0) {
              break label364;
            }
            bool1 = true;
            label311:
            ((MutableLiveData)localObject).postValue(new bnnv(bool1, this.jdField_a_of_type_Int));
            if (!this.jdField_a_of_type_Bnuy.a()) {
              continue;
            }
            localObject = bnyl.a();
            if (i != 0) {
              break label369;
            }
          }
          label364:
          label369:
          for (bool1 = bool3;; bool1 = false)
          {
            ((bnyl)localObject).d(bool1);
            break;
            i = 0;
            break label296;
            bool1 = false;
            break label311;
          }
          botv.a(this.g.a(), 200L, null);
          bool3 = c();
          localObject = this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b();
          if (!bool3)
          {
            bool1 = true;
            ((MutableLiveData)localObject).postValue(Boolean.valueOf(bool1));
            if (!this.jdField_a_of_type_Bnuy.a()) {
              continue;
            }
            localObject = bnyl.a();
            if (bool3) {
              break label456;
            }
          }
          label456:
          for (bool1 = bool2;; bool1 = false)
          {
            ((bnyl)localObject).c(bool1);
            break;
            bool1 = false;
            break label410;
          }
          botv.a(paramView, 200L, null);
          this.jdField_a_of_type_Bndy.r();
          continue;
          botv.a(this.c.a(), 200L, null);
          if (!this.c.isSelected()) {}
          for (;;)
          {
            if (this.jdField_a_of_type_Bndy.a(bool1))
            {
              this.jdField_a_of_type_Boolean = bool1;
              this.c.setSelected(bool1);
              if (QLog.isDevelopLevel()) {
                bnzb.a("AEVideoStoryTopBarPart", "onClick, mFlashButton.setSelected(), on=" + bool1);
              }
            }
            bnyh.a().E();
            break;
            bool1 = false;
          }
          botv.a(this.h.a(), 200L, null);
          localObject = (AEVideoStoryTopBarViewModel.Ratio)this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.getValue();
          if (localObject != null) {
            this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.postValue(((AEVideoStoryTopBarViewModel.Ratio)localObject).next());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnnl
 * JD-Core Version:    0.7.0.1
 */