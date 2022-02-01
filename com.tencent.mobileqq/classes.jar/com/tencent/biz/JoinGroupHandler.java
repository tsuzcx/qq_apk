package com.tencent.biz;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;

public class JoinGroupHandler
{
  protected int a;
  protected long a;
  protected Context a;
  protected JoinGroupHandler.IJoinGroupCB a;
  protected QQAppInterface a;
  protected TroopBusinessObserver a;
  protected QQProgressDialog a;
  protected Runnable a;
  protected String a;
  protected long b = 0L;
  
  public JoinGroupHandler(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, String paramString, JoinGroupHandler.IJoinGroupCB paramIJoinGroupCB)
  {
    this.jdField_a_of_type_JavaLangRunnable = new JoinGroupHandler.2(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new JoinGroupHandler.3(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB = paramIJoinGroupCB;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    new QQToastNotifier(this.jdField_a_of_type_AndroidContentContext).a(paramInt1, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166), 0, paramInt2);
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo.cGroupOption != 3)
    {
      paramTroopInfo = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, paramTroopInfo.troopuin, paramTroopInfo.troopname, paramTroopInfo.cGroupOption, this.jdField_a_of_type_Int, paramTroopInfo.joinTroopQuestion, paramTroopInfo.joinTroopAnswer, null, this.jdField_a_of_type_JavaLangString, null);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramTroopInfo);
      this.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB.b();
      return;
    }
    a(2131720199, 1);
    this.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB.a();
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.b;
        if ((!paramBoolean) && (l1 - l2 < 1000L))
        {
          ThreadManager.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void b(long paramLong)
  {
    try
    {
      TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      this.jdField_a_of_type_Long = paramLong;
      localTroopHandler.a(paramLong, 8390784);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      a(2131719697, 0);
      this.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB.a();
    }
  }
  
  private void c()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694694);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new JoinGroupHandler.1(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      this.b = System.currentTimeMillis();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
  }
  
  public void a(long paramLong)
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
    {
      a(2131694457, 0);
      this.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB.a();
      return;
    }
    if (0L == paramLong)
    {
      this.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB.a();
      return;
    }
    this.jdField_a_of_type_Long = paramLong;
    c();
    b(paramLong);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.JoinGroupHandler
 * JD-Core Version:    0.7.0.1
 */