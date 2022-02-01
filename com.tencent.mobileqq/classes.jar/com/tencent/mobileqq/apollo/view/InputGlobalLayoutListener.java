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
  private WeakReference<BaseChatPie> a;
  
  public InputGlobalLayoutListener(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (paramInt2 != this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = paramInt2;
      paramView.post(this);
    }
    paramInt1 = 0;
    Object localObject = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null)
    {
      if (((BaseChatPie)localObject).a != null) {
        paramInt1 = ((BaseChatPie)localObject).a.getHeight();
      }
      paramView = ApolloUtilImpl.getChatPieApolloViewController((BaseChatPie)localObject);
      localObject = (FullScreenInputHelper)((BaseChatPie)localObject).a(24);
      if ((paramView != null) && (localObject != null)) {
        paramView.a(paramInt1, ((FullScreenInputHelper)localObject).c());
      }
    }
  }
  
  public void run()
  {
    Object localObject = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    ChatPieApolloViewController localChatPieApolloViewController = ApolloUtilImpl.getChatPieApolloViewController((BaseChatPie)localObject);
    if (localChatPieApolloViewController == null) {
      return;
    }
    localChatPieApolloViewController.c(this.jdField_a_of_type_Int);
    localObject = (AIOShortcutBarHelper)((BaseChatPie)localObject).a(52);
    int i;
    if ((localObject != null) && (((AIOShortcutBarHelper)localObject).d() == 2) && (((AIOShortcutBarHelper)localObject).c() == 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      localChatPieApolloViewController.d(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.InputGlobalLayoutListener
 * JD-Core Version:    0.7.0.1
 */