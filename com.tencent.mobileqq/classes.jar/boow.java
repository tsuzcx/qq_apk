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
import dov.com.qq.im.ae.view.AECompoundButton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class boow
  extends bowm
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 3;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private bofh jdField_a_of_type_Bofh;
  private bowk jdField_a_of_type_Bowk;
  private bowl jdField_a_of_type_Bowl;
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
  
  public boow(Activity paramActivity, View paramView, bown parambown)
  {
    super(paramActivity, paramView, parambown);
    this.jdField_a_of_type_Bofh = ((bofh)parambown.a(65537, new Object[0]));
  }
  
  private void a(@NonNull bpas parambpas)
  {
    if (!born.j(this.jdField_a_of_type_AndroidAppActivity.getIntent())) {}
    do
    {
      return;
      if (this.e != null) {
        this.e.setForegroundAndBackgroundResource(parambpas.k, parambpas.j);
      }
      if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null) {
        this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setForegroundAndBackgroundResource(parambpas.l, parambpas.j);
      }
      if (this.c != null) {
        this.c.setForegroundAndBackgroundResource(parambpas.m, parambpas.j);
      }
      if (this.d != null) {
        this.d.setForegroundAndBackgroundResource(parambpas.n, parambpas.j);
      }
    } while (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton == null);
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setForegroundAndBackgroundResource(parambpas.o, parambpas.j);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Bowk.a())
      {
        this.g.setVisibility(0);
        this.f.setVisibility(0);
        this.c.setVisibility(8);
      }
      for (;;)
      {
        this.d.setVisibility(0);
        return;
        this.c.setVisibility(0);
      }
    }
    if (this.jdField_a_of_type_Bowk.a())
    {
      this.g.setVisibility(8);
      this.f.setVisibility(8);
    }
    this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
  }
  
  private boolean a()
  {
    if (born.a(this.jdField_a_of_type_Bofh)) {
      return false;
    }
    Object localObject1 = new HashMap();
    Object localObject2 = new ArrayList();
    ((List)localObject2).add("PCAM10");
    ((List)localObject2).add("PBBM30");
    ((List)localObject2).add("PBAM00");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("Y85A");
    localArrayList.add("u3x");
    localArrayList.add("X21A");
    localArrayList.add("Y93");
    localArrayList.add("Y81s");
    ((Map)localObject1).put("vivo", localArrayList);
    ((Map)localObject1).put("oppo", localObject2);
    if (Build.MANUFACTURER != null)
    {
      localObject1 = (List)((Map)localObject1).get(Build.MANUFACTURER.toLowerCase());
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if ((localObject2 != null) && ((((String)localObject2).equalsIgnoreCase(Build.MODEL)) || ((Build.MANUFACTURER + " " + (String)localObject2).equalsIgnoreCase(Build.MODEL)))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void b()
  {
    if (!"VIVO;V1836T".equalsIgnoreCase(Build.MANUFACTURER + ";" + Build.MODEL)) {}
    ViewGroup.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    } while (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localLayoutParams;
    localMarginLayoutParams.topMargin += zft.b(this.jdField_a_of_type_AndroidAppActivity, 20.0F);
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
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
  
  private void e()
  {
    this.jdField_a_of_type_Bowk = ((bowk)bofz.a(this.jdField_a_of_type_Bofh).get(bowk.class));
    this.jdField_a_of_type_Bowk.a.observe(this.jdField_a_of_type_Bofh, new booy(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)bofz.a(this.jdField_a_of_type_Bofh).get(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a().observe(this.jdField_a_of_type_Bofh, new booz(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().observe(this.jdField_a_of_type_Bofh, new bopa(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.observe(this.jdField_a_of_type_Bofh, new bopb(this));
    this.jdField_a_of_type_Bowl = ((bowl)bofz.a(this.jdField_a_of_type_Bofh).get(bowl.class));
    this.jdField_a_of_type_Bowl.a().observe(this.jdField_a_of_type_Bofh, new bopc(this));
    this.jdField_a_of_type_Bowl.b().observe(this.jdField_a_of_type_Bofh, new bopd(this));
    this.jdField_a_of_type_Bowl.c().observe(this.jdField_a_of_type_Bofh, new bope(this));
  }
  
  protected void a()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378122);
    if (localViewStub != null) {
      this.jdField_b_of_type_AndroidViewView = localViewStub.inflate();
    }
    ViewCompat.setOnApplyWindowInsetsListener(this.jdField_b_of_type_AndroidViewView, new boox(this));
    ViewCompat.requestApplyInsets(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364081));
    this.e = ((AECompoundButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131364158));
    this.e.setOnClickListener(this);
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131364342));
    this.jdField_b_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131365266));
    this.d = ((AECompoundButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131363359));
    this.d.setOnClickListener(this);
    this.c = ((AECompoundButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131366787));
    this.f = ((AECompoundButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131365150));
    this.f.setOnClickListener(this);
    this.g = ((AECompoundButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131378295));
    this.g.setOnClickListener(this);
    this.g.setSelected(false);
    this.c.setOnClickListener(this);
    this.c.setSelected(this.jdField_a_of_type_Boolean);
    e();
    b();
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
  
  public void c()
  {
    super.c();
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
    default: 
    case 2131363359: 
    case 2131365150: 
    case 2131378295: 
    case 2131364158: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        bozr.a().J();
        bpvq.a(this.d.a(), 200L, null);
        abbe.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
        if (this.jdField_a_of_type_Bown != null) {
          if (this.jdField_a_of_type_Bowl.a())
          {
            this.jdField_a_of_type_Bown.a(327686, new Object[0]);
          }
          else if (!this.jdField_a_of_type_Bowl.b())
          {
            Object localObject;
            if (born.j(this.jdField_a_of_type_Bofh.a().getIntent()))
            {
              if (!bpak.a(paramView))
              {
                localObject = new Intent();
                ((Intent)localObject).setAction("ae_editor_bottom_tab_show_hide");
                ((Intent)localObject).putExtra("is_show", false);
                this.jdField_a_of_type_Bofh.a().sendBroadcast((Intent)localObject);
              }
            }
            else
            {
              this.jdField_a_of_type_Bown.a(131077, new Object[0]);
              continue;
              bpvq.a(this.f.a(), 200L, null);
              localObject = (bopg)this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a().getValue();
              int i;
              if ((localObject != null) && (((bopg)localObject).a()))
              {
                i = 1;
                label275:
                localObject = this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a();
                if (i != 0) {
                  break label343;
                }
                bool1 = true;
                label290:
                ((MutableLiveData)localObject).postValue(new bopg(bool1, this.jdField_a_of_type_Int));
                if (!this.jdField_a_of_type_Bowk.a()) {
                  continue;
                }
                localObject = bozv.a();
                if (i != 0) {
                  break label348;
                }
              }
              label343:
              label348:
              for (bool1 = bool3;; bool1 = false)
              {
                ((bozv)localObject).d(bool1);
                break;
                i = 0;
                break label275;
                bool1 = false;
                break label290;
              }
              bpvq.a(this.g.a(), 200L, null);
              bool3 = c();
              localObject = this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b();
              if (!bool3)
              {
                bool1 = true;
                label389:
                ((MutableLiveData)localObject).postValue(Boolean.valueOf(bool1));
                if (!this.jdField_a_of_type_Bowk.a()) {
                  continue;
                }
                localObject = bozv.a();
                if (bool3) {
                  break label441;
                }
              }
              label441:
              for (bool1 = bool2;; bool1 = false)
              {
                ((bozv)localObject).c(bool1);
                bozr.a().af();
                break;
                bool1 = false;
                break label389;
              }
              bpvq.a(paramView, 200L, null);
              this.jdField_a_of_type_Bofh.r();
            }
          }
        }
      }
    }
    bpvq.a(this.c.a(), 200L, null);
    if (!this.c.isSelected()) {}
    for (;;)
    {
      if (this.jdField_a_of_type_Bofh.a(bool1))
      {
        this.jdField_a_of_type_Boolean = bool1;
        this.c.setSelected(bool1);
        if (QLog.isDevelopLevel()) {
          bpam.a("AEVideoStoryTopBarPart", "onClick, mFlashButton.setSelected(), on=" + bool1);
        }
      }
      bozr.a().E();
      break;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boow
 * JD-Core Version:    0.7.0.1
 */