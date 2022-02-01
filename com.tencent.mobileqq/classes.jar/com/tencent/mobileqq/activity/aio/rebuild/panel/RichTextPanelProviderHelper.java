package com.tencent.mobileqq.activity.aio.rebuild.panel;

import android.content.Context;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.InputRightIconUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.helper.AIOZhituHelper;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelProvider;
import com.tencent.mobileqq.hiboom.RichTextPanel;
import com.tencent.widget.XPanelContainer;

public class RichTextPanelProviderHelper
  implements ILifeCycleHelper, PanelProvider<RichTextPanel>
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  RichTextPanel jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel;
  
  public RichTextPanelProviderHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject = (AIOZhituHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b().a(116);
    ImageButton localImageButton = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b().a().a().a().a();
    if (paramInt1 == 28)
    {
      ((AIOZhituHelper)localObject).a = false;
      localImageButton.setActivated(false);
      RichTextPanel localRichTextPanel = this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel;
      if (localRichTextPanel != null) {
        localRichTextPanel.a(false);
      }
    }
    if (paramInt2 == 28)
    {
      ((AIOZhituHelper)localObject).a = true;
      localImageButton.setActivated(true);
      localObject = this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel;
      if (localObject != null) {
        ((RichTextPanel)localObject).a(true);
      }
    }
  }
  
  public RichTextPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel;
  }
  
  public RichTextPanel a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel = new RichTextPanel(paramContext);
      this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    }
    return this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel;
  }
  
  public int getPanelId()
  {
    return 28;
  }
  
  @NonNull
  public String getTag()
  {
    return "RichTextPanelProvider";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 10, 12, 15 };
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel() {}
  
  public void onMoveToState(int paramInt)
  {
    RichTextPanel localRichTextPanel;
    if (paramInt != 10)
    {
      if (paramInt != 12)
      {
        if (paramInt != 15) {
          return;
        }
        localRichTextPanel = this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel;
        if (localRichTextPanel != null) {
          localRichTextPanel.c();
        }
      }
      else
      {
        localRichTextPanel = this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel;
        if (localRichTextPanel != null) {
          localRichTextPanel.a();
        }
      }
    }
    else
    {
      localRichTextPanel = this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel;
      if (localRichTextPanel != null) {
        localRichTextPanel.b();
      }
    }
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 28) && (this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel != null))
    {
      boolean bool = true;
      if (paramInt2 != 1) {
        bool = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.c(bool);
    }
    if (paramInt2 == 28)
    {
      RichTextPanel localRichTextPanel = this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel;
      if (localRichTextPanel != null) {
        localRichTextPanel.d();
      }
    }
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer) {}
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.panel.RichTextPanelProviderHelper
 * JD-Core Version:    0.7.0.1
 */