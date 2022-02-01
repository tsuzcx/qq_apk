package com.tencent.mobileqq.apollo.aio.panel;

import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloViewBinder;
import com.tencent.mobileqq.apollo.model.ApolloActionPackage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.List;

public abstract class PanelStrategy
{
  protected int a;
  protected Context a;
  protected SessionInfo a;
  protected QQAppInterface a;
  private Runnable a;
  
  public PanelStrategy(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  protected int a(List<ApolloViewBinder> paramList, int paramInt)
  {
    if ((paramList != null) && (paramInt < paramList.size()))
    {
      int i = 0;
      int k;
      for (int j = 0; i < paramInt; j = k)
      {
        ApolloViewBinder localApolloViewBinder = (ApolloViewBinder)paramList.get(i);
        k = j;
        if (localApolloViewBinder != null) {
          k = j + localApolloViewBinder.a();
        }
        i += 1;
      }
      return j;
    }
    paramList = new IllegalArgumentException("packageBinderList is null or tabIndex is out");
    for (;;)
    {
      throw paramList;
    }
  }
  
  abstract ApolloViewBinder a(int paramInt1, int paramInt2);
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  abstract void a(int paramInt1, int paramInt2);
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  abstract void a(List<ApolloViewBinder> paramList, List<ApolloActionPackage> paramList1, boolean paramBoolean1, boolean paramBoolean2);
  
  abstract boolean a(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.PanelStrategy
 * JD-Core Version:    0.7.0.1
 */