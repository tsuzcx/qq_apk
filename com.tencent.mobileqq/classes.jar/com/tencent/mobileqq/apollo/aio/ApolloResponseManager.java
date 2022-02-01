package com.tencent.mobileqq.apollo.aio;

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
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.script.ISpriteTaskStatusCallback;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class ApolloResponseManager
  implements ISpriteTaskStatusCallback, Manager
{
  private int jdField_a_of_type_Int = 0;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ApolloResponseManager.1(this);
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ApolloResponseManager.ResponseAdapter jdField_a_of_type_ComTencentMobileqqApolloAioApolloResponseManager$ResponseAdapter;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<BaseChatPie> jdField_a_of_type_JavaLangRefWeakReference;
  Comparator<ApolloActionData> jdField_a_of_type_JavaUtilComparator = new ApolloResponseManager.2(this);
  
  public ApolloResponseManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  int a(ApolloActionData paramApolloActionData)
  {
    int i = paramApolloActionData.feeType;
    if (i != 6)
    {
      if (i != 7)
      {
        if (i != 9) {
          return 1;
        }
        return 2;
      }
      return 3;
    }
    return 4;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    ListView localListView = this.jdField_a_of_type_ComTencentWidgetListView;
    if (localListView != null)
    {
      if (localListView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentWidgetListView.getParent()).removeView(this.jdField_a_of_type_ComTencentWidgetListView);
      }
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentWidgetListView = null;
      this.jdField_a_of_type_ComTencentMobileqqApolloAioApolloResponseManager$ResponseAdapter = null;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    int i = paramSpriteTaskParam.f;
    ApolloActionData localApolloActionData = ((ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionInCache(i);
    if ((localApolloActionData != null) && ((localApolloActionData.pkIds != null) || (localApolloActionData.pk3DIds != null)) && (!paramSpriteTaskParam.jdField_a_of_type_Boolean) && (paramSpriteTaskParam.g == 1))
    {
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localMqqHandler != null)
      {
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
    }
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam, long paramLong, int paramInt) {}
  
  public void a(Object paramObject, ApolloActionData paramApolloActionData, int paramInt, String paramString)
  {
    if (!(paramObject instanceof BaseChatPie)) {
      return;
    }
    Object localObject1 = (BaseChatPie)paramObject;
    int i;
    int j;
    if (((BaseChatPie)localObject1).a() != null)
    {
      if (paramApolloActionData == null) {
        return;
      }
      paramObject = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if (paramObject.is3dAvailable())
      {
        if (paramObject.getCmShowStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()) == 1) {
          paramObject = paramApolloActionData.pkIds;
        } else {
          paramObject = paramApolloActionData.pk3DIds;
        }
      }
      else if (ApolloActionData.isAction3DModel(paramApolloActionData.actionId)) {
        paramObject = "";
      } else {
        paramObject = paramApolloActionData.pkIds;
      }
      if (QLog.isColorLevel())
      {
        paramApolloActionData = new StringBuilder();
        paramApolloActionData.append("[showQuickResponseView] Ids:");
        paramApolloActionData.append(paramObject);
        QLog.d("[cmshow]ApolloResponseManager", 2, paramApolloActionData.toString());
      }
      if (TextUtils.isEmpty(paramObject)) {
        return;
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject1);
      this.jdField_a_of_type_JavaLangString = paramString;
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (((BaseChatPie)localObject1).a != null)) {
        this.jdField_a_of_type_Int = ((BaseChatPie)localObject1).a.jdField_a_of_type_Int;
      }
      paramApolloActionData = ((BaseChatPie)localObject1).a();
      localObject1 = (RelativeLayout)((BaseChatPie)localObject1).a().findViewById(2131364485);
      Object localObject2 = this.jdField_a_of_type_ComTencentWidgetListView;
      i = 0;
      if (localObject2 == null)
      {
        this.jdField_a_of_type_ComTencentWidgetListView = new ListView(paramApolloActionData);
        this.jdField_a_of_type_ComTencentWidgetListView.setDivider(null);
        this.jdField_a_of_type_ComTencentWidgetListView.setVerticalScrollBarEnabled(false);
        this.jdField_a_of_type_ComTencentWidgetListView.setSelector(paramApolloActionData.getResources().getDrawable(2130851078));
        this.jdField_a_of_type_ComTencentWidgetListView.setCacheColorHint(2131165474);
        this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramApolloActionData);
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramApolloActionData);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(11.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
        this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        j = AIOUtils.b(9.0F, paramApolloActionData.getResources());
        this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, j);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramApolloActionData.getResources().getColor(2131167063));
        localObject2 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject2).gravity = 1;
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_ComTencentWidgetListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        this.jdField_a_of_type_ComTencentMobileqqApolloAioApolloResponseManager$ResponseAdapter = new ApolloResponseManager.ResponseAdapter(this, paramApolloActionData);
        this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloAioApolloResponseManager$ResponseAdapter);
        localObject2 = new RelativeLayout.LayoutParams(AIOUtils.b(99.0F, paramApolloActionData.getResources()), -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131368875);
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(10.0F, paramApolloActionData.getResources());
        ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_ComTencentWidgetListView, (ViewGroup.LayoutParams)localObject2);
      }
      paramApolloActionData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
      j = this.jdField_a_of_type_Int;
      if (j != 0)
      {
        if ((j == 1) || (j == 3000))
        {
          paramApolloActionData = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, true);
          paramApolloActionData = String.format(HardCodeUtil.a(2131700737), new Object[] { paramApolloActionData });
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramApolloActionData);
          this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
      }
      else if (paramApolloActionData.getBoolean("first_show_resp", true))
      {
        paramApolloActionData.edit().putBoolean("first_show_resp", false).commit();
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700735));
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838403, 0);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    for (;;)
    {
      try
      {
        paramApolloActionData = new ArrayList();
        paramObject = paramObject.split(",");
        j = paramObject.length;
        if (i < j)
        {
          paramString = paramObject[i];
          if (TextUtils.isEmpty(paramString)) {
            break label767;
          }
          paramApolloActionData.add(Integer.valueOf(Integer.parseInt(paramString.trim())));
          break label767;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloAioApolloResponseManager$ResponseAdapter.a(paramApolloActionData, paramInt);
        return;
      }
      catch (Exception paramObject)
      {
        QLog.e("[cmshow]ApolloResponseManager", 1, "update Quick Response View error:", paramObject);
      }
      return;
      label767:
      i += 1;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloAioApolloResponseManager$ResponseAdapter = null;
    this.jdField_a_of_type_ComTencentWidgetListView = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ApolloResponseManager
 * JD-Core Version:    0.7.0.1
 */