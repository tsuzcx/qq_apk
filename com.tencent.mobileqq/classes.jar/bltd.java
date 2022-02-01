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
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import dov.com.qq.im.ae.view.AECompoundButton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class bltd
  extends bmar
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 3;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private bljy jdField_a_of_type_Bljy;
  private bmap jdField_a_of_type_Bmap;
  private bmaq jdField_a_of_type_Bmaq;
  private AEVideoStoryTopBarViewModel jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel;
  private AECompoundButton jdField_a_of_type_DovComQqImAeViewAECompoundButton;
  private boolean jdField_a_of_type_Boolean;
  private AECompoundButton b;
  private AECompoundButton c;
  private AECompoundButton d;
  private AECompoundButton e;
  private AECompoundButton f;
  private AECompoundButton g;
  
  public bltd(Activity paramActivity, View paramView, bmas parambmas)
  {
    super(paramActivity, paramView, parambmas);
    this.jdField_a_of_type_Bljy = ((bljy)parambmas.a(65537, new Object[0]));
  }
  
  private void a()
  {
    if (!"VIVO;V1836T".equalsIgnoreCase(Build.MANUFACTURER + ";" + Build.MODEL)) {}
    ViewGroup.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    } while (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localLayoutParams;
    localMarginLayoutParams.topMargin += DisplayUtil.dip2px(this.mActivity, 20.0F);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  private void a(@NonNull bmcd parambmcd)
  {
    if (!blvr.j(this.mActivity.getIntent())) {}
    do
    {
      return;
      if (this.e != null) {
        this.e.setForegroundAndBackgroundResource(parambmcd.k, parambmcd.j);
      }
      if (this.b != null) {
        this.b.setForegroundAndBackgroundResource(parambmcd.l, parambmcd.j);
      }
      if (this.c != null) {
        this.c.setForegroundAndBackgroundResource(parambmcd.m, parambmcd.j);
      }
      if (this.d != null) {
        this.d.setForegroundAndBackgroundResource(parambmcd.n, parambmcd.j);
      }
    } while (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton == null);
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setForegroundAndBackgroundResource(parambmcd.o, parambmcd.j);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_Bmap.a())
      {
        this.g.setVisibility(0);
        this.f.setVisibility(0);
        this.c.setVisibility(8);
        this.d.setVisibility(0);
      }
    }
    for (;;)
    {
      if (a()) {
        this.d.setVisibility(8);
      }
      return;
      this.c.setVisibility(0);
      break;
      if (this.jdField_a_of_type_Bmap.a())
      {
        this.g.setVisibility(8);
        this.f.setVisibility(8);
      }
      this.b.setVisibility(8);
      this.c.setVisibility(8);
      this.d.setVisibility(8);
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_Bmap = ((bmap)blks.a(this.jdField_a_of_type_Bljy).get(bmap.class));
    this.jdField_a_of_type_Bmap.a.observe(this.jdField_a_of_type_Bljy, new bltf(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)blks.a(this.jdField_a_of_type_Bljy).get(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a().observe(this.jdField_a_of_type_Bljy, new bltg(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().observe(this.jdField_a_of_type_Bljy, new blth(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.observe(this.jdField_a_of_type_Bljy, new blti(this));
    this.jdField_a_of_type_Bmaq = ((bmaq)blks.a(this.jdField_a_of_type_Bljy).get(bmaq.class));
    this.jdField_a_of_type_Bmaq.a().observe(this.jdField_a_of_type_Bljy, new bltj(this));
    this.jdField_a_of_type_Bmaq.b().observe(this.jdField_a_of_type_Bljy, new bltk(this));
    this.jdField_a_of_type_Bmaq.c().observe(this.jdField_a_of_type_Bljy, new bltl(this));
  }
  
  private boolean b()
  {
    if (blvr.a(this.jdField_a_of_type_Bljy)) {
      return false;
    }
    Object localObject1 = new HashMap();
    Object localObject2 = new ArrayList();
    ((List)localObject2).add("PCAM10");
    ((List)localObject2).add("PBBM30");
    ((List)localObject2).add("PBAM00");
    ((List)localObject2).add("PADM00");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("Y85A");
    localArrayList.add("u3x");
    localArrayList.add("X21A");
    localArrayList.add("Y93");
    localArrayList.add("Y81s");
    localArrayList.add("V1914A");
    localArrayList.add("V1918A");
    localArrayList.add("V1818CA");
    localArrayList.add("V1732T");
    localArrayList.add("V1914T");
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
  
  protected boolean a()
  {
    return (!this.jdField_a_of_type_Bljy.b().c()) || (!this.jdField_a_of_type_Bljy.b().f()) || (!this.jdField_a_of_type_Bljy.b().a());
  }
  
  protected void initView()
  {
    ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(2131377893);
    if (localViewStub != null) {
      this.jdField_a_of_type_AndroidViewView = localViewStub.inflate();
    }
    ViewCompat.setOnApplyWindowInsetsListener(this.jdField_a_of_type_AndroidViewView, new blte(this));
    ViewCompat.requestApplyInsets(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mRootView.findViewById(2131364102));
    this.e = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131364180));
    this.e.setOnClickListener(this);
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131364360));
    this.b = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131365291));
    this.d = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363386));
    this.d.setOnClickListener(this);
    this.c = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131366811));
    this.f = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131365177));
    this.f.setOnClickListener(this);
    this.g = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131378064));
    this.g.setOnClickListener(this);
    this.g.setSelected(false);
    this.c.setOnClickListener(this);
    this.c.setSelected(this.jdField_a_of_type_Boolean);
    b();
    a();
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel != null) && (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b() != null))
    {
      bmbx.a("AEVideoStoryTopBarPart", "【抠背开关】-> onResume -> post:" + c());
      this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().postValue(Boolean.valueOf(c()));
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
    case 2131363386: 
    case 2131365177: 
    case 2131378064: 
    case 2131364180: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        bmbc.a().N();
        bmys.a(this.d.a(), 200L, null);
        zxp.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
        if (this.mPartManager != null) {
          if (this.jdField_a_of_type_Bmaq.a())
          {
            this.mPartManager.a(327686, new Object[0]);
          }
          else if (!this.jdField_a_of_type_Bmaq.b())
          {
            Object localObject;
            if (blvr.j(this.jdField_a_of_type_Bljy.a().getIntent()))
            {
              if (!bmbv.a(paramView))
              {
                localObject = new Intent();
                ((Intent)localObject).setAction("ae_editor_bottom_tab_show_hide");
                ((Intent)localObject).putExtra("is_show", false);
                this.jdField_a_of_type_Bljy.a().sendBroadcast((Intent)localObject);
              }
            }
            else
            {
              this.mPartManager.a(131077, new Object[0]);
              continue;
              bmys.a(this.f.a(), 200L, null);
              localObject = (bltn)this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a().getValue();
              int i;
              if ((localObject != null) && (((bltn)localObject).a()))
              {
                i = 1;
                label275:
                localObject = this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a();
                if (i != 0) {
                  break label343;
                }
                bool1 = true;
                label290:
                ((MutableLiveData)localObject).postValue(new bltn(bool1, this.jdField_a_of_type_Int));
                if (!this.jdField_a_of_type_Bmap.a()) {
                  continue;
                }
                localObject = bmbg.a();
                if (i != 0) {
                  break label348;
                }
              }
              label343:
              label348:
              for (bool1 = bool3;; bool1 = false)
              {
                ((bmbg)localObject).d(bool1);
                break;
                i = 0;
                break label275;
                bool1 = false;
                break label290;
              }
              bmys.a(this.g.a(), 200L, null);
              bool3 = c();
              localObject = new StringBuilder().append("【抠背开关】-> 点击 ->post:");
              if (!bool3)
              {
                bool1 = true;
                label395:
                bmbx.a("AEVideoStoryTopBarPart", bool1);
                localObject = this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b();
                if (bool3) {
                  break label478;
                }
                bool1 = true;
                label426:
                ((MutableLiveData)localObject).postValue(Boolean.valueOf(bool1));
                if (!this.jdField_a_of_type_Bmap.a()) {
                  continue;
                }
                localObject = bmbg.a();
                if (bool3) {
                  break label483;
                }
              }
              label478:
              label483:
              for (bool1 = bool2;; bool1 = false)
              {
                ((bmbg)localObject).c(bool1);
                bmbc.a().ak();
                break;
                bool1 = false;
                break label395;
                bool1 = false;
                break label426;
              }
              bmys.a(paramView, 200L, null);
              this.jdField_a_of_type_Bljy.L();
            }
          }
        }
      }
    }
    bmys.a(this.c.a(), 200L, null);
    if (!this.c.isSelected()) {}
    for (;;)
    {
      if (this.jdField_a_of_type_Bljy.a(bool1))
      {
        this.jdField_a_of_type_Boolean = bool1;
        this.c.setSelected(bool1);
        if (QLog.isDevelopLevel()) {
          bmbx.a("AEVideoStoryTopBarPart", "onClick, mFlashButton.setSelected(), on=" + bool1);
        }
      }
      bmbc.a().I();
      break;
      bool1 = false;
    }
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while ((this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel == null) || (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b() == null));
    bmbx.a("AEVideoStoryTopBarPart", "【抠背开关】-> 相机启动检查 -> post:" + c());
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().postValue(Boolean.valueOf(c()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bltd
 * JD-Core Version:    0.7.0.1
 */