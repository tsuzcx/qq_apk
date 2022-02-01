package com.tencent.mobileqq.ark;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkAppModuleCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;

public class ArkAiAppPanel
{
  private static int b = 3;
  AdapterView.OnItemClickListener a = new ArkAiAppPanel.5(this);
  private AIOContext c;
  private ArkAppRootLayout d;
  private Button e;
  private RelativeLayout f;
  private List<ArkAiInfo> g;
  private ArkAiAppPanel.DismissCallback h;
  private boolean i = true;
  private HorizontalListView j;
  private ArkAiAppPanel.ArkInputPanelTabAdapter k;
  private ArkAppView l;
  private ArrayList<ArkAioContainerWrapper> m;
  private ArrayList<Boolean> n;
  private int o = 0;
  private ArkAppContainer.ArkAppModuleCallback p = new ArkAiAppPanel.1(this);
  
  public ArkAiAppPanel(AIOContext paramAIOContext)
  {
    this.c = paramAIOContext;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.c == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkAiAppPanel", 2, "initArkApp.aioContext == null!");
      }
      return;
    }
    Object localObject1 = this.g;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      int i1 = this.g.size();
      int i2 = this.o;
      if (i1 <= i2) {
        return;
      }
      localObject1 = (ArkAiInfo)this.g.get(i2);
      this.c.b();
      i2 = BaseChatItemLayout.z;
      int i3 = XPanelContainer.a;
      Object localObject2 = this.d;
      i1 = i2;
      if (localObject2 != null)
      {
        i1 = i2;
        if (((ArkAppRootLayout)localObject2).getParent() != null) {
          i1 = ((View)this.d.getParent()).getMeasuredWidth();
        }
      }
      localObject2 = (ArkAioContainerWrapper)this.m.get(this.o);
      ((ArkAioContainerWrapper)localObject2).a(((ArkAiInfo)localObject1).a, ((ArkAiInfo)localObject1).b, ((ArkAiInfo)localObject1).c, ((ArkAiInfo)localObject1).e, ArkAppCenterUtil.d(), null, (SessionInfo)this.c.O());
      if (Boolean.FALSE.equals(this.n.get(this.o)))
      {
        ArkAppDataReport.a(this.c.a(), "ShowView", ((ArkAiInfo)localObject1).a, null, ArkAppDataReport.g, 0, 0);
        this.n.set(this.o, Boolean.TRUE);
      }
      if (paramBoolean)
      {
        i2 = MessageForArkApp.dp2px(36.0F);
        this.f.setVisibility(0);
      }
      else
      {
        this.f.setVisibility(8);
        i2 = 0;
      }
      i3 -= i2;
      ((ArkAioContainerWrapper)localObject2).setViewRect(((ArkAioContainerWrapper)localObject2).descaleRect(new Rect(0, 0, i1, i3)));
      ((ArkAioContainerWrapper)localObject2).setFixSize(i1, i3);
      ((ArkAioContainerWrapper)localObject2).setMaxSize(i1, i3);
      ((ArkAioContainerWrapper)localObject2).a(this.p);
      QLog.d("ArkAiAppPanel", 2, String.format("ArkAiAppPanel.initArkApp app:%s view%s width:%d height:%d.", new Object[] { ((ArkAiInfo)localObject1).a, ((ArkAiInfo)localObject1).b, Integer.valueOf(i1), Integer.valueOf(i3) }));
      this.l.a((ArkAppContainer)localObject2, null);
      localObject1 = new RelativeLayout.LayoutParams(this.l.getLayoutParams());
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, i2);
      this.l.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
  }
  
  private void e()
  {
    Object localObject1 = this.g;
    if (localObject1 != null)
    {
      if (((List)localObject1).size() <= 0) {
        return;
      }
      if (this.m == null)
      {
        this.m = new ArrayList();
        this.n = new ArrayList();
      }
      else
      {
        i1 = 0;
        while (i1 < this.m.size())
        {
          localObject1 = (ArkAioContainerWrapper)this.m.get(i1);
          if (localObject1 != null) {
            ((ArkAioContainerWrapper)localObject1).doOnEvent(2);
          }
          i1 += 1;
        }
        this.m.clear();
        this.n.clear();
      }
      localObject1 = new ArrayList();
      Object localObject2 = this.g;
      if (localObject2 == null) {
        i1 = 0;
      } else {
        i1 = ((List)localObject2).size();
      }
      int i2 = 0;
      while ((i2 < b) && (i2 < i1))
      {
        ((ArrayList)localObject1).add(this.g.get(i2));
        localObject2 = new ArkAioContainerWrapper();
        ((ArkAioContainerWrapper)localObject2).d = new ArkAppMessage.Config();
        ((ArkAioContainerWrapper)localObject2).d.round = Integer.valueOf(1);
        this.m.add(localObject2);
        this.n.add(Boolean.FALSE);
        i2 += 1;
      }
      this.k.a((List)localObject1);
      localObject1 = this.j.getSelectedView();
      if (localObject1 != null) {
        ((View)localObject1).setSelected(false);
      }
      int i1 = this.o;
      if ((i1 < 0) || (i1 >= this.g.size())) {
        this.o = 0;
      }
      this.j.setSelection(this.o);
      this.j.postDelayed(new ArkAiAppPanel.2(this), 500L);
    }
  }
  
  private void f()
  {
    BaseActivity localBaseActivity = this.c.b();
    this.d = ((ArkAppRootLayout)LayoutInflater.from(localBaseActivity).inflate(2131625170, null));
    this.d.setDisableParentReturn(true);
    this.l = ((ArkAppView)this.d.findViewById(2131428746));
    this.l.setBorderType(0);
    ArkAppView localArkAppView = this.l;
    localArkAppView.setOnTouchListener(localArkAppView);
    this.l.setCallback(new ArkAiAppPanel.3(this));
    this.j = ((HorizontalListView)this.d.findViewById(2131428749));
    this.j.setOnItemClickListener(this.a);
    this.k = new ArkAiAppPanel.ArkInputPanelTabAdapter(this, localBaseActivity);
    this.j.setAdapter(this.k);
    this.e = ((Button)this.d.findViewById(2131428761));
    this.e.setOnClickListener(new ArkAiAppPanel.4(this));
    this.f = ((RelativeLayout)this.d.findViewById(2131428763));
  }
  
  public ArkAppRootLayout a()
  {
    if (this.d == null) {
      f();
    }
    List localList = this.g;
    if ((localList != null) && (localList.size() > 0))
    {
      this.i = true;
      return this.d;
    }
    return null;
  }
  
  public void a(List<ArkAiInfo> paramList, int paramInt, ArkAiAppPanel.DismissCallback paramDismissCallback)
  {
    this.h = paramDismissCallback;
    this.g = paramList;
    this.o = paramInt;
    if (this.c.q().b() != 22)
    {
      this.c.q().e(22);
      return;
    }
    e();
    this.i = true;
    a(this.i);
  }
  
  public void b()
  {
    if (this.m != null)
    {
      int i1 = 0;
      while (i1 < this.m.size())
      {
        ArkAioContainerWrapper localArkAioContainerWrapper = (ArkAioContainerWrapper)this.m.get(i1);
        if (localArkAioContainerWrapper != null) {
          localArkAioContainerWrapper.doOnEvent(2);
        }
        i1 += 1;
      }
      this.m.clear();
      this.n.clear();
    }
  }
  
  public void c()
  {
    e();
    a(this.i);
  }
  
  public void d()
  {
    Object localObject = this.l;
    if (localObject != null) {
      ((ArkAppView)localObject).setOnTouchListener(null);
    }
    if (this.g != null)
    {
      int i1 = 0;
      while (i1 < this.g.size())
      {
        localObject = (ArkAiInfo)this.g.get(i1);
        if (localObject != null) {
          ArkAppCenterCheckEvent.a(((ArkAiInfo)localObject).a);
        }
        i1 += 1;
      }
      localObject = this.h;
      if (localObject != null) {
        ((ArkAiAppPanel.DismissCallback)localObject).a(this.g);
      }
      this.g = null;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiAppPanel
 * JD-Core Version:    0.7.0.1
 */