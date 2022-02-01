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
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArrayCompat<PanelProvider<? extends View>> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  private XPanelContainer jdField_a_of_type_ComTencentWidgetXPanelContainer;
  private List<PanelListener> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public PanelManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    XPanelContainer localXPanelContainer = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
    if (localXPanelContainer != null) {
      return localXPanelContainer.a();
    }
    return 0;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
  }
  
  public View a(int paramInt)
  {
    PanelProvider localPanelProvider = (PanelProvider)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localPanelProvider != null) {
      return localPanelProvider.createPanel(this.jdField_a_of_type_AndroidContentContext);
    }
    return null;
  }
  
  public <T extends PanelProvider<? extends View>> T a(int paramInt)
  {
    return (PanelProvider)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
  }
  
  public XPanelContainer a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
  }
  
  public void a()
  {
    XPanelContainer localXPanelContainer = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
    if (localXPanelContainer != null) {
      localXPanelContainer.d();
    }
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      localObject = this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
      ((PanelProvider)((SparseArrayCompat)localObject).get(((SparseArrayCompat)localObject).keyAt(i))).onPanelIconClickBeforeCreate(paramInt);
      i += 1;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PanelListener)((Iterator)localObject).next()).onPanelIconClickBeforeCreate(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      localObject = this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
      ((PanelProvider)((SparseArrayCompat)localObject).get(((SparseArrayCompat)localObject).keyAt(i))).onPanelChanged(paramInt1, paramInt2);
      i += 1;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PanelListener)((Iterator)localObject).next()).onPanelChanged(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(paramInt, paramBoolean);
  }
  
  public void a(PanelListener paramPanelListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramPanelListener);
  }
  
  public void a(PanelProvider<? extends View> paramPanelProvider)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramPanelProvider.getPanelId(), paramPanelProvider);
  }
  
  public void a(IKeyboardHiddenCallback paramIKeyboardHiddenCallback)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(paramIKeyboardHiddenCallback);
  }
  
  public void a(XPanelContainer paramXPanelContainer)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = paramXPanelContainer;
  }
  
  public void a(boolean paramBoolean)
  {
    XPanelContainer localXPanelContainer = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
    if (localXPanelContainer != null) {
      localXPanelContainer.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, Context paramContext, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1)
    {
      paramContext = (InputMethodManager)paramContext.getSystemService("input_method");
      if (paramContext.isActive(paramView)) {
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.b();
        } else {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        }
      }
      if (((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() instanceof BaseVoicetoTextView)) && (paramContext.isActive()))
      {
        if (paramBoolean)
        {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.b();
          return;
        }
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      }
      return;
    }
    paramContext = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if ((paramContext != null) && (paramContext.getVisibility() == 0))
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("hideAllPanels  curPanel = ");
        paramContext.append(this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
        QLog.d("PanelManager", 2, paramContext.toString());
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.b();
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
  }
  
  public boolean a(int paramInt)
  {
    PanelProvider localPanelProvider = (PanelProvider)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localPanelProvider != null) {
      return localPanelProvider.isNeedRecreatePanel();
    }
    return false;
  }
  
  public <T extends View> T b(int paramInt)
  {
    PanelProvider localPanelProvider = (PanelProvider)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localPanelProvider != null) {
      return localPanelProvider.getPanel();
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    PanelProvider localPanelProvider = (PanelProvider)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localPanelProvider != null) {
      localPanelProvider.onPanelIconClick(this.jdField_a_of_type_ComTencentWidgetXPanelContainer);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      localObject = this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
      ((PanelProvider)((SparseArrayCompat)localObject).get(((SparseArrayCompat)localObject).keyAt(i))).postOnPanelChanged(paramInt1, paramInt2);
      i += 1;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PanelListener)((Iterator)localObject).next()).postOnPanelChanged(paramInt1, paramInt2);
    }
  }
  
  public void s()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      localObject = this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
      ((PanelProvider)((SparseArrayCompat)localObject).get(((SparseArrayCompat)localObject).keyAt(i))).onHideAllPanel();
      i += 1;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PanelListener)((Iterator)localObject).next()).onHideAllPanel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PanelManager
 * JD-Core Version:    0.7.0.1
 */