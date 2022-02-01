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
  RichTextPanel a;
  private BaseChatPie b;
  
  public RichTextPanelProviderHelper(BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject = (AIOZhituHelper)this.b.bv().a(116);
    ImageButton localImageButton = this.b.bv().p().d().c().b();
    if (paramInt1 == 28)
    {
      ((AIOZhituHelper)localObject).a = false;
      localImageButton.setActivated(false);
      RichTextPanel localRichTextPanel = this.a;
      if (localRichTextPanel != null) {
        localRichTextPanel.a(false);
      }
    }
    if (paramInt2 == 28)
    {
      ((AIOZhituHelper)localObject).a = true;
      localImageButton.setActivated(true);
      localObject = this.a;
      if (localObject != null) {
        ((RichTextPanel)localObject).a(true);
      }
    }
  }
  
  public RichTextPanel a()
  {
    return this.a;
  }
  
  public RichTextPanel a(Context paramContext)
  {
    if (this.a == null)
    {
      this.a = new RichTextPanel(paramContext);
      this.a.a(this.b);
    }
    return this.a;
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
        localRichTextPanel = this.a;
        if (localRichTextPanel != null) {
          localRichTextPanel.c();
        }
      }
      else
      {
        localRichTextPanel = this.a;
        if (localRichTextPanel != null) {
          localRichTextPanel.a();
        }
      }
    }
    else
    {
      localRichTextPanel = this.a;
      if (localRichTextPanel != null) {
        localRichTextPanel.b();
      }
    }
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 28) && (this.a != null))
    {
      boolean bool = true;
      if (paramInt2 != 1) {
        bool = false;
      }
      this.a.c(bool);
    }
    if (paramInt2 == 28)
    {
      RichTextPanel localRichTextPanel = this.a;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.panel.RichTextPanelProviderHelper
 * JD-Core Version:    0.7.0.1
 */