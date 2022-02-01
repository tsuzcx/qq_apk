package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.IKeyboardHiddenCallback;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.PanelCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PanelManager
  implements XPanelContainer.PanelCallback
{
  private Context a;
  private XPanelContainer b;
  private SparseArrayCompat<PanelProvider<? extends View>> c = new SparseArrayCompat();
  private List<PanelListener> d = new ArrayList();
  
  public PanelManager(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void a()
  {
    XPanelContainer localXPanelContainer = this.b;
    if (localXPanelContainer != null) {
      localXPanelContainer.f();
    }
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    while (i < this.c.size())
    {
      localObject = this.c;
      ((PanelProvider)((SparseArrayCompat)localObject).get(((SparseArrayCompat)localObject).keyAt(i))).onPanelIconClickBeforeCreate(paramInt);
      i += 1;
    }
    Object localObject = this.d.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PanelListener)((Iterator)localObject).next()).onPanelIconClickBeforeCreate(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.c.size())
    {
      localObject = this.c;
      ((PanelProvider)((SparseArrayCompat)localObject).get(((SparseArrayCompat)localObject).keyAt(i))).onPanelChanged(paramInt1, paramInt2);
      i += 1;
    }
    Object localObject = this.d.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PanelListener)((Iterator)localObject).next()).onPanelChanged(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.b.a(paramInt, paramBoolean);
  }
  
  public void a(PanelListener paramPanelListener)
  {
    this.d.add(paramPanelListener);
  }
  
  public void a(PanelProvider<? extends View> paramPanelProvider)
  {
    this.c.put(paramPanelProvider.getPanelId(), paramPanelProvider);
  }
  
  public void a(IKeyboardHiddenCallback paramIKeyboardHiddenCallback)
  {
    this.b.a(paramIKeyboardHiddenCallback);
  }
  
  public void a(XPanelContainer paramXPanelContainer)
  {
    this.b = paramXPanelContainer;
  }
  
  public void a(boolean paramBoolean)
  {
    XPanelContainer localXPanelContainer = this.b;
    if (localXPanelContainer != null) {
      localXPanelContainer.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, Context paramContext, View paramView)
  {
    if (this.b.getCurrentPanel() == 1)
    {
      paramContext = (InputMethodManager)paramContext.getSystemService("input_method");
      if (paramContext.isActive(paramView)) {
        if (paramBoolean) {
          this.b.c();
        } else {
          this.b.b();
        }
      }
      if (((this.b.getCurrentPanelView() instanceof BaseVoicetoTextView)) && (paramContext.isActive()))
      {
        if (paramBoolean)
        {
          this.b.c();
          return;
        }
        this.b.b();
      }
      return;
    }
    paramContext = this.b.getCurrentPanelView();
    if ((paramContext != null) && (paramContext.getVisibility() == 0))
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("hideAllPanels  curPanel = ");
        paramContext.append(this.b.getCurrentPanel());
        QLog.d("PanelManager", 2, paramContext.toString());
      }
      if (paramBoolean)
      {
        this.b.c();
        return;
      }
      this.b.b();
    }
  }
  
  public int b()
  {
    XPanelContainer localXPanelContainer = this.b;
    if (localXPanelContainer != null) {
      return localXPanelContainer.getCurrentPanel();
    }
    return 0;
  }
  
  public View b(int paramInt)
  {
    PanelProvider localPanelProvider = (PanelProvider)this.c.get(paramInt);
    if (localPanelProvider != null) {
      return localPanelProvider.createPanel(this.a);
    }
    return null;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.c.size())
    {
      localObject = this.c;
      ((PanelProvider)((SparseArrayCompat)localObject).get(((SparseArrayCompat)localObject).keyAt(i))).postOnPanelChanged(paramInt1, paramInt2);
      i += 1;
    }
    Object localObject = this.d.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PanelListener)((Iterator)localObject).next()).postOnPanelChanged(paramInt1, paramInt2);
    }
  }
  
  public View c()
  {
    return this.b.getCurrentPanelView();
  }
  
  public boolean c(int paramInt)
  {
    PanelProvider localPanelProvider = (PanelProvider)this.c.get(paramInt);
    if (localPanelProvider != null) {
      return localPanelProvider.isNeedRecreatePanel();
    }
    return false;
  }
  
  public <T extends View> T d(int paramInt)
  {
    PanelProvider localPanelProvider = (PanelProvider)this.c.get(paramInt);
    if (localPanelProvider != null) {
      return localPanelProvider.getPanel();
    }
    return null;
  }
  
  public XPanelContainer d()
  {
    return this.b;
  }
  
  public void e(int paramInt)
  {
    PanelProvider localPanelProvider = (PanelProvider)this.c.get(paramInt);
    if (localPanelProvider != null) {
      localPanelProvider.onPanelIconClick(this.b);
    }
  }
  
  public <T extends PanelProvider<? extends View>> T f(int paramInt)
  {
    return (PanelProvider)this.c.get(paramInt);
  }
  
  public void v()
  {
    int i = 0;
    while (i < this.c.size())
    {
      localObject = this.c;
      ((PanelProvider)((SparseArrayCompat)localObject).get(((SparseArrayCompat)localObject).keyAt(i))).onHideAllPanel();
      i += 1;
    }
    Object localObject = this.d.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PanelListener)((Iterator)localObject).next()).onHideAllPanel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PanelManager
 * JD-Core Version:    0.7.0.1
 */