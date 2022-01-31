package com.tencent.mobileqq.apollo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.callback.ISpriteTaskStatusCallback;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import yjc;
import yje;
import yjg;

public class ApolloResponseManager
  implements ISpriteTaskStatusCallback, Manager
{
  public int a;
  public View.OnClickListener a;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public BaseChatPie a;
  public QQAppInterface a;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  public String a;
  public Comparator a;
  yjg jdField_a_of_type_Yjg;
  
  public ApolloResponseManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new yjc(this);
    this.jdField_a_of_type_JavaUtilComparator = new yje(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a(ApolloActionData paramApolloActionData)
  {
    switch (paramApolloActionData.feeType)
    {
    case 8: 
    default: 
      return 1;
    case 6: 
      return 4;
    case 7: 
      return 3;
    }
    return 2;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    if (this.jdField_a_of_type_ComTencentWidgetListView != null)
    {
      if (this.jdField_a_of_type_ComTencentWidgetListView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentWidgetListView.getParent()).removeView(this.jdField_a_of_type_ComTencentWidgetListView);
      }
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentWidgetListView = null;
      this.jdField_a_of_type_Yjg = null;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
  }
  
  public void a(BaseChatPie paramBaseChatPie, String paramString1, int paramInt, String paramString2)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.a() == null) || (paramString1 == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_JavaLangString = paramString2;
    if ((paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null) && (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a()))
    {
      QLog.e("ApolloResponseManager", 1, "ark bubble is showing, return.");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    }
    BaseActivity localBaseActivity = paramBaseChatPie.a();
    paramBaseChatPie = (RelativeLayout)paramBaseChatPie.a().findViewById(2131363474);
    int i;
    if (this.jdField_a_of_type_ComTencentWidgetListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetListView = new ListView(localBaseActivity);
      this.jdField_a_of_type_ComTencentWidgetListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetListView.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetListView.setSelector(localBaseActivity.getResources().getDrawable(2130846277));
      this.jdField_a_of_type_ComTencentWidgetListView.setCacheColorHint(2131492880);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(localBaseActivity);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(localBaseActivity);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(11.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
      this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      i = AIOUtils.a(9.0F, localBaseActivity.getResources());
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, i);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(localBaseActivity.getResources().getColor(2131494212));
      Object localObject = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 1;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentWidgetListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      this.jdField_a_of_type_Yjg = new yjg(this, localBaseActivity);
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Yjg);
      localObject = new RelativeLayout.LayoutParams(AIOUtils.a(99.0F, localBaseActivity.getResources()), -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131363476);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(10.0F, localBaseActivity.getResources());
      paramBaseChatPie.addView(this.jdField_a_of_type_ComTencentWidgetListView, (ViewGroup.LayoutParams)localObject);
    }
    paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
    switch (this.jdField_a_of_type_Int)
    {
    }
    try
    {
      for (;;)
      {
        paramBaseChatPie = new ArrayList();
        paramString1 = paramString1.split(",");
        int j = paramString1.length;
        i = 0;
        while (i < j)
        {
          paramString2 = paramString1[i];
          if (!TextUtils.isEmpty(paramString2)) {
            paramBaseChatPie.add(Integer.valueOf(Integer.parseInt(paramString2.trim())));
          }
          i += 1;
        }
        if (paramBaseChatPie.getBoolean("first_show_resp", true))
        {
          paramBaseChatPie.edit().putBoolean("first_show_resp", false).commit();
          this.jdField_a_of_type_AndroidWidgetTextView.setText("快速回应");
          this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838011, 0);
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          continue;
          paramBaseChatPie = String.format("回应%s", new Object[] { ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, true) });
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatPie);
          this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
      }
      this.jdField_a_of_type_Yjg.a(paramBaseChatPie, paramInt);
      return;
    }
    catch (Exception paramBaseChatPie)
    {
      QLog.e("ApolloResponseManager", 1, "update Quick Response View error:", paramBaseChatPie);
    }
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    int i;
    ApolloActionData localApolloActionData;
    MqqHandler localMqqHandler;
    do
    {
      do
      {
        return;
        i = paramSpriteTaskParam.f;
        localApolloActionData = ((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154)).b(i);
      } while ((localApolloActionData == null) || (localApolloActionData.pkIds == null) || (paramSpriteTaskParam.jdField_a_of_type_Boolean) || (paramSpriteTaskParam.g != 1));
      localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
    } while (localMqqHandler == null);
    localMqqHandler.removeMessages(82);
    localMqqHandler.removeMessages(83);
    Message localMessage = localMqqHandler.obtainMessage();
    localMessage.what = 82;
    localMessage.obj = localApolloActionData;
    localMessage.arg1 = i;
    localMessage.getData().putString("senderUin", paramSpriteTaskParam.jdField_a_of_type_JavaLangString);
    localMqqHandler.sendMessageDelayed(localMessage, 500L);
    localMqqHandler.sendEmptyMessageDelayed(83, 4000L);
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam, long paramLong, int paramInt) {}
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    this.jdField_a_of_type_Yjg = null;
    this.jdField_a_of_type_ComTencentWidgetListView = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloResponseManager
 * JD-Core Version:    0.7.0.1
 */