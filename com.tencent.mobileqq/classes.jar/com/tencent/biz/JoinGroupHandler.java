package com.tencent.biz;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import klb;
import klc;

public class JoinGroupHandler
{
  protected int a;
  public long a;
  protected Context a;
  public JoinGroupHandler.IJoinGroupCB a;
  protected QQAppInterface a;
  protected TroopObserver a;
  protected QQProgressDialog a;
  protected String a;
  
  public JoinGroupHandler(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, String paramString, JoinGroupHandler.IJoinGroupCB paramIJoinGroupCB)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new klc(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB = paramIJoinGroupCB;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    new QQToastNotifier(this.jdField_a_of_type_AndroidContentContext).a(paramInt1, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448), 0, paramInt2);
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo.cGroupOption != 3)
    {
      paramTroopInfo = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, paramTroopInfo.troopuin, paramTroopInfo.troopname, paramTroopInfo.cGroupOption, this.jdField_a_of_type_Int, paramTroopInfo.joinTroopQuestion, paramTroopInfo.joinTroopAnswer, null, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramTroopInfo);
      this.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB.b();
      return;
    }
    a(2131434447, 1);
    this.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB.a();
  }
  
  private void b(long paramLong)
  {
    try
    {
      TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      this.jdField_a_of_type_Long = paramLong;
      localTroopHandler.a(paramLong, 8390784);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      a(2131433190, 0);
      this.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB.a();
    }
  }
  
  private void c()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131435086);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new klb(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void d()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  public void a(long paramLong)
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
    {
      a(2131433227, 0);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.JoinGroupHandler
 * JD-Core Version:    0.7.0.1
 */