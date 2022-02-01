package com.tencent.mobileqq.apollo.view;

import android.annotation.TargetApi;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.apollo.aio.ChatPieApolloViewController;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import java.lang.ref.WeakReference;

@TargetApi(11)
public class InputGlobalLayoutListener
  implements View.OnLayoutChangeListener, Runnable
{
  public int a;
  private WeakReference<BaseChatPie> b;
  
  public InputGlobalLayoutListener(BaseChatPie paramBaseChatPie)
  {
    this.b = new WeakReference(paramBaseChatPie);
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (paramInt2 != this.a)
    {
      this.a = paramInt2;
      paramView.post(this);
    }
    paramInt1 = 0;
    Object localObject = (BaseChatPie)this.b.get();
    if (localObject != null)
    {
      if (((BaseChatPie)localObject).p != null) {
        paramInt1 = ((BaseChatPie)localObject).p.getHeight();
      }
      paramView = ApolloUtilImpl.getChatPieApolloViewController((BaseChatPie)localObject);
      localObject = (FullScreenInputHelper)((BaseChatPie)localObject).q(24);
      if ((paramView != null) && (localObject != null)) {
        paramView.a(paramInt1, ((FullScreenInputHelper)localObject).e());
      }
    }
  }
  
  public void run()
  {
    Object localObject = (BaseChatPie)this.b.get();
    ChatPieApolloViewController localChatPieApolloViewController = ApolloUtilImpl.getChatPieApolloViewController((BaseChatPie)localObject);
    if (localChatPieApolloViewController == null) {
      return;
    }
    localChatPieApolloViewController.c(this.a);
    localObject = (AIOShortcutBarHelper)((BaseChatPie)localObject).q(52);
    int i;
    if ((localObject != null) && (((AIOShortcutBarHelper)localObject).x() == 2) && (((AIOShortcutBarHelper)localObject).v() == 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      localChatPieApolloViewController.d(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.InputGlobalLayoutListener
 * JD-Core Version:    0.7.0.1
 */