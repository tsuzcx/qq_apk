package com.tencent.mobileqq.activity.aio.helper;

import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.PokePanel;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgUpdateCallback;
import com.tencent.mobileqq.activity.aio.item.PokeItemAnimationManager;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.panel.PokeAndEmoPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import java.util.HashMap;

public class PokeAndEmoPanelHelper
  implements OnFinishListener, IMsgUpdateCallback, ILifeCycleHelper
{
  private final AIOContext a;
  private final QQAppInterface b;
  private PanelManager c;
  
  public PokeAndEmoPanelHelper(AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
    this.b = paramAIOContext.a();
    paramAIOContext.d().a(this);
  }
  
  private void a()
  {
    ViewGroup localViewGroup = this.a.r();
    PokeItemAnimationManager.c().a((FitSystemWindowsRelativeLayout)localViewGroup);
  }
  
  private void b()
  {
    PokeAndEmoPanel localPokeAndEmoPanel = h();
    if (localPokeAndEmoPanel != null) {
      localPokeAndEmoPanel.a();
    }
  }
  
  private void d()
  {
    PokePanel.a(this.b);
    if (!PokeItemHelper.I) {
      ThreadManager.executeOnSubThread(new PokeAndEmoPanelHelper.1(this));
    }
  }
  
  private void e()
  {
    PokeAndEmoPanel localPokeAndEmoPanel = h();
    if (localPokeAndEmoPanel != null) {
      localPokeAndEmoPanel.c();
    }
  }
  
  private void f()
  {
    PokeAndEmoPanel localPokeAndEmoPanel = h();
    if (localPokeAndEmoPanel != null)
    {
      localPokeAndEmoPanel.b();
      PokeItemHelper.b(this.b.getAccount(), PokeItemHelper.k);
    }
    PokeItemHelper.b();
    PokeItemHelper.d();
    g();
    this.b.getMsgCache().h.clear();
  }
  
  private void g()
  {
    PokeItemAnimationManager.c().a(3);
    PokeItemAnimationManager.c().a(6);
    PokeItemAnimationManager.c().a(12);
    PokeItemAnimationManager.c().a(15);
    PokeItemAnimationManager.c().a(18);
    PokeItemAnimationManager.c().a(9);
  }
  
  private PokeAndEmoPanel h()
  {
    if (this.c == null) {
      this.c = this.a.q();
    }
    return (PokeAndEmoPanel)this.c.d(23);
  }
  
  public boolean a(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public void b(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    if ((!paramChatMessage.isread) && ((paramChatMessage instanceof MessageForPoke)) && (!paramChatMessage.isSend()))
    {
      this.b.getMsgCache().h.put(Long.valueOf(paramChatMessage.uniseq), paramChatMessage);
      ((MessageForPoke)paramChatMessage).isPlayed = false;
    }
  }
  
  public int bM_()
  {
    return 0;
  }
  
  public void c(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
  
  public boolean d(int paramInt)
  {
    return false;
  }
  
  public boolean d(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public void e(int paramInt) {}
  
  public void e(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
  
  public String getTag()
  {
    return "PokeAndEmoPanelHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 0, 9, 10, 12, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 12)
      {
        if (paramInt != 15)
        {
          if (paramInt != 9)
          {
            if (paramInt != 10) {
              return;
            }
            b();
            return;
          }
          d();
          return;
        }
        f();
        return;
      }
      e();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.PokeAndEmoPanelHelper
 * JD-Core Version:    0.7.0.1
 */