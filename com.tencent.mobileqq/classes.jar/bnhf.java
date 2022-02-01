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

public class bnhf
  extends bnqb
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 3;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private bmxa jdField_a_of_type_Bmxa;
  private bnpz jdField_a_of_type_Bnpz;
  private bnqa jdField_a_of_type_Bnqa;
  private AEVideoStoryTopBarViewModel jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel;
  private AECompoundButton jdField_a_of_type_DovComQqImAeViewAECompoundButton;
  private boolean jdField_a_of_type_Boolean;
  private AECompoundButton b;
  private AECompoundButton c;
  private AECompoundButton d;
  private AECompoundButton e;
  private AECompoundButton f;
  private AECompoundButton g;
  private AECompoundButton h;
  
  public bnhf(Activity paramActivity, View paramView, bnqc parambnqc)
  {
    super(paramActivity, paramView, parambnqc);
    this.jdField_a_of_type_Bmxa = ((bmxa)parambnqc.a(65537, new Object[0]));
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
  
  private void a(@NonNull bnru parambnru)
  {
    if (!bnlb.j(this.mActivity.getIntent())) {}
    do
    {
      return;
      if (this.f != null) {
        this.f.setForegroundAndBackgroundResource(parambnru.k, parambnru.j);
      }
      if (this.b != null) {
        this.b.setForegroundAndBackgroundResource(parambnru.l, parambnru.j);
      }
      if (this.c != null) {
        this.c.setForegroundAndBackgroundResource(parambnru.m, parambnru.j);
      }
      if (this.e != null) {
        this.e.setForegroundAndBackgroundResource(parambnru.n, parambnru.j);
      }
      if (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton != null) {
        this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setForegroundAndBackgroundResource(parambnru.o, parambnru.j);
      }
    } while (this.d == null);
    this.d.setForegroundAndBackgroundResource(parambnru.p, parambnru.j);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_Bnpz.a())
      {
        this.h.setVisibility(0);
        this.g.setVisibility(0);
        this.c.setVisibility(8);
        this.e.setVisibility(0);
        if (this.d != null) {
          this.d.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (a()) {
        this.e.setVisibility(8);
      }
      return;
      this.c.setVisibility(0);
      break;
      if (this.jdField_a_of_type_Bnpz.a())
      {
        this.h.setVisibility(8);
        this.g.setVisibility(8);
      }
      this.b.setVisibility(8);
      this.c.setVisibility(8);
      this.e.setVisibility(8);
      if (this.d != null) {
        this.d.setVisibility(8);
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_Bnpz = ((bnpz)bmxz.a(this.jdField_a_of_type_Bmxa).get(bnpz.class));
    this.jdField_a_of_type_Bnpz.a.observe(this.jdField_a_of_type_Bmxa, new bnhh(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)bmxz.a(this.jdField_a_of_type_Bmxa).get(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a().observe(this.jdField_a_of_type_Bmxa, new bnhi(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().observe(this.jdField_a_of_type_Bmxa, new bnhj(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.observe(this.jdField_a_of_type_Bmxa, new bnhk(this));
    this.jdField_a_of_type_Bnqa = ((bnqa)bmxz.a(this.jdField_a_of_type_Bmxa).get(bnqa.class));
    this.jdField_a_of_type_Bnqa.a().observe(this.jdField_a_of_type_Bmxa, new bnhl(this));
    this.jdField_a_of_type_Bnqa.b().observe(this.jdField_a_of_type_Bmxa, new bnhm(this));
    this.jdField_a_of_type_Bnqa.c().observe(this.jdField_a_of_type_Bmxa, new bnhn(this));
    this.jdField_a_of_type_Bnqa.d().observe(this.jdField_a_of_type_Bmxa, new bnho(this));
  }
  
  private boolean b()
  {
    if (bnlb.a(this.jdField_a_of_type_Bmxa)) {
      return false;
    }
    Object localObject1 = new HashMap();
    Object localObject2 = new ArrayList();
    ((List)localObject2).add("PCAM10");
    ((List)localObject2).add("PBBM30");
    ((List)localObject2).add("PBAM00");
    ((List)localObject2).add("PBBM00");
    ((List)localObject2).add("PADM00");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("Y85A");
    localArrayList.add("Y85");
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
        return "meizu 17".equals(Build.MODEL);
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
    return (!this.jdField_a_of_type_Bmxa.b().c()) || (!this.jdField_a_of_type_Bmxa.b().f()) || (!this.jdField_a_of_type_Bmxa.b().a());
  }
  
  protected void initView()
  {
    ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(2131378179);
    if (localViewStub != null) {
      this.jdField_a_of_type_AndroidViewView = localViewStub.inflate();
    }
    ViewCompat.setOnApplyWindowInsetsListener(this.jdField_a_of_type_AndroidViewView, new bnhg(this));
    ViewCompat.requestApplyInsets(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mRootView.findViewById(2131364177));
    this.f = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131364255));
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131364441));
    this.b = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131365386));
    this.e = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363455));
    this.e.setOnClickListener(this);
    this.d = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131364085));
    if (this.d != null) {
      this.d.setOnClickListener(this);
    }
    this.c = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131366929));
    this.g = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131365262));
    this.g.setOnClickListener(this);
    this.h = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131378352));
    this.h.setOnClickListener(this);
    this.h.setSelected(false);
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
      bnrh.a("AEVideoStoryTopBarPart", "【抠背开关】-> onResume -> post:" + c());
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
    case 2131363455: 
    case 2131364085: 
    case 2131365262: 
    case 2131378352: 
    case 2131364255: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        bnqm.a().N();
        book.a(this.e.a(), 200L, null);
        aanb.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
        if (this.mPartManager != null) {
          if (this.jdField_a_of_type_Bnqa.a())
          {
            this.mPartManager.a(327686, new Object[0]);
          }
          else if (!this.jdField_a_of_type_Bnqa.b())
          {
            Object localObject;
            if (bnlb.j(this.jdField_a_of_type_Bmxa.a().getIntent()))
            {
              if (!bnrf.a(paramView))
              {
                localObject = new Intent();
                ((Intent)localObject).setAction("ae_editor_bottom_tab_show_hide");
                ((Intent)localObject).putExtra("is_show", false);
                this.jdField_a_of_type_Bmxa.a().sendBroadcast((Intent)localObject);
              }
            }
            else
            {
              this.mPartManager.a(131077, new Object[0]);
              continue;
              if (this.mPartManager != null) {
                if (bnlb.j(this.jdField_a_of_type_Bmxa.a().getIntent()))
                {
                  if (!bnrf.a(paramView))
                  {
                    localObject = new Intent();
                    ((Intent)localObject).setAction("ae_editor_bottom_tab_show_hide");
                    ((Intent)localObject).putExtra("is_show", false);
                    this.jdField_a_of_type_Bmxa.a().sendBroadcast((Intent)localObject);
                  }
                }
                else
                {
                  bnqm.a().ar();
                  this.mPartManager.a(131078, new Object[0]);
                  continue;
                  book.a(this.g.a(), 200L, null);
                  localObject = (bnhq)this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a().getValue();
                  int i;
                  if ((localObject != null) && (((bnhq)localObject).a()))
                  {
                    i = 1;
                    label376:
                    localObject = this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a();
                    if (i != 0) {
                      break label444;
                    }
                    bool1 = true;
                    label391:
                    ((MutableLiveData)localObject).postValue(new bnhq(bool1, this.jdField_a_of_type_Int));
                    if (!this.jdField_a_of_type_Bnpz.a()) {
                      continue;
                    }
                    localObject = bnqq.a();
                    if (i != 0) {
                      break label449;
                    }
                  }
                  label444:
                  label449:
                  for (bool1 = bool3;; bool1 = false)
                  {
                    ((bnqq)localObject).d(bool1);
                    break;
                    i = 0;
                    break label376;
                    bool1 = false;
                    break label391;
                  }
                  book.a(this.h.a(), 200L, null);
                  bool3 = c();
                  localObject = new StringBuilder().append("【抠背开关】-> 点击 ->post:");
                  if (!bool3)
                  {
                    bool1 = true;
                    label496:
                    bnrh.a("AEVideoStoryTopBarPart", bool1);
                    localObject = this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b();
                    if (bool3) {
                      break label579;
                    }
                    bool1 = true;
                    label527:
                    ((MutableLiveData)localObject).postValue(Boolean.valueOf(bool1));
                    if (!this.jdField_a_of_type_Bnpz.a()) {
                      continue;
                    }
                    localObject = bnqq.a();
                    if (bool3) {
                      break label584;
                    }
                  }
                  label579:
                  label584:
                  for (bool1 = bool2;; bool1 = false)
                  {
                    ((bnqq)localObject).c(bool1);
                    bnqm.a().ak();
                    break;
                    bool1 = false;
                    break label496;
                    bool1 = false;
                    break label527;
                  }
                  book.a(paramView, 200L, null);
                  this.jdField_a_of_type_Bmxa.U();
                }
              }
            }
          }
        }
      }
    }
    book.a(this.c.a(), 200L, null);
    if (!this.c.isSelected()) {}
    for (;;)
    {
      if (this.jdField_a_of_type_Bmxa.a(bool1))
      {
        this.jdField_a_of_type_Boolean = bool1;
        this.c.setSelected(bool1);
        if (QLog.isDevelopLevel()) {
          bnrh.a("AEVideoStoryTopBarPart", "onClick, mFlashButton.setSelected(), on=" + bool1);
        }
      }
      bnqm.a().I();
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
    bnrh.a("AEVideoStoryTopBarPart", "【抠背开关】-> 相机启动检查 -> post:" + c());
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().postValue(Boolean.valueOf(c()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnhf
 * JD-Core Version:    0.7.0.1
 */