package com.tencent.mobileqq.apollo.api.impl;

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
import com.tencent.mobileqq.apollo.api.IApolloResponseManager;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
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
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ApolloResponseManagerImpl
  implements IApolloResponseManager
{
  static final String KEY_FIRST_SHOW_RESP = "first_show_resp";
  static final String TAG = "ApolloResponseManager";
  FrameLayout headerContainer;
  TextView headerTextView;
  ApolloResponseManagerImpl.ResponseAdapter mAdapter;
  QQAppInterface mApp;
  WeakReference<BaseChatPie> mChatPieRef;
  Comparator<ApolloActionData> mComparator = new ApolloResponseManagerImpl.2(this);
  View.OnClickListener mOnResponseClickLis = new ApolloResponseManagerImpl.1(this);
  ListView mResponseList;
  String mSenderUin;
  int mSessionType = 0;
  
  int getPriority(ApolloActionData paramApolloActionData)
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
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      this.mApp = ((QQAppInterface)paramAppRuntime);
    }
  }
  
  public void onDestroy()
  {
    this.mChatPieRef = null;
    this.mAdapter = null;
    this.mResponseList = null;
    this.headerContainer = null;
    this.headerTextView = null;
    this.mApp = null;
  }
  
  public void onTaskComplete(SpriteTaskParam paramSpriteTaskParam, long paramLong, int paramInt) {}
  
  public void onTaskStart(SpriteTaskParam paramSpriteTaskParam, long paramLong)
  {
    if (this.mApp == null) {}
    int i;
    ApolloActionData localApolloActionData;
    MqqHandler localMqqHandler;
    do
    {
      do
      {
        return;
        i = paramSpriteTaskParam.f;
        localApolloActionData = ((ApolloDaoManagerServiceImpl)this.mApp.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionInCache(i);
      } while ((localApolloActionData == null) || ((localApolloActionData.pkIds == null) && (localApolloActionData.pk3DIds == null)) || (paramSpriteTaskParam.jdField_a_of_type_Boolean) || (paramSpriteTaskParam.g != 1));
      localMqqHandler = this.mApp.getHandler(ChatActivity.class);
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
  
  public void removeResponseView()
  {
    this.mChatPieRef = null;
    if (this.mResponseList != null)
    {
      if (this.mResponseList.getParent() != null) {
        ((ViewGroup)this.mResponseList.getParent()).removeView(this.mResponseList);
      }
      this.mResponseList.setAdapter(null);
      this.mResponseList = null;
      this.mAdapter = null;
    }
    this.headerContainer = null;
    this.headerTextView = null;
  }
  
  public void updateQuickResponseView(BaseChatPie paramBaseChatPie, ApolloActionData paramApolloActionData, int paramInt, String paramString)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.a() == null) || (paramApolloActionData == null)) {
      return;
    }
    Object localObject1 = (IApolloManagerService)this.mApp.getRuntimeService(IApolloManagerService.class, "all");
    if (((IApolloManagerService)localObject1).is3dAvailable(this.mApp)) {
      if (((IApolloManagerService)localObject1).getCmShowStatus(this.mApp, this.mApp.getCurrentUin()) == 1) {
        paramApolloActionData = paramApolloActionData.pkIds;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResponseManager", 2, "[showQuickResponseView] Ids:" + paramApolloActionData);
      }
      if (TextUtils.isEmpty(paramApolloActionData)) {
        break;
      }
      this.mChatPieRef = new WeakReference(paramBaseChatPie);
      this.mSenderUin = paramString;
      if ((this.mChatPieRef != null) && (paramBaseChatPie.a != null)) {
        this.mSessionType = paramBaseChatPie.a.a;
      }
      localObject1 = paramBaseChatPie.a();
      paramBaseChatPie = (RelativeLayout)paramBaseChatPie.a().findViewById(2131364598);
      int i;
      if (this.mResponseList == null)
      {
        this.mResponseList = new ListView((Context)localObject1);
        this.mResponseList.setDivider(null);
        this.mResponseList.setVerticalScrollBarEnabled(false);
        this.mResponseList.setSelector(((Context)localObject1).getResources().getDrawable(2130851162));
        this.mResponseList.setCacheColorHint(2131165498);
        this.headerContainer = new FrameLayout((Context)localObject1);
        this.headerTextView = new TextView((Context)localObject1);
        this.headerTextView.setTextSize(11.0F);
        this.headerTextView.setMaxLines(1);
        this.headerTextView.setIncludeFontPadding(false);
        this.headerTextView.setEllipsize(TextUtils.TruncateAt.END);
        i = AIOUtils.a(9.0F, ((Context)localObject1).getResources());
        this.headerTextView.setPadding(0, 0, 0, i);
        this.headerTextView.setTextColor(((Context)localObject1).getResources().getColor(2131167040));
        Object localObject2 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject2).gravity = 1;
        this.headerContainer.addView(this.headerTextView, (ViewGroup.LayoutParams)localObject2);
        this.mResponseList.addHeaderView(this.headerContainer);
        this.mAdapter = new ApolloResponseManagerImpl.ResponseAdapter(this, (Context)localObject1);
        this.mResponseList.setAdapter(this.mAdapter);
        localObject2 = new RelativeLayout.LayoutParams(AIOUtils.a(99.0F, ((Context)localObject1).getResources()), -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131369142);
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(10.0F, ((Context)localObject1).getResources());
        paramBaseChatPie.addView(this.mResponseList, (ViewGroup.LayoutParams)localObject2);
      }
      paramBaseChatPie = this.mApp.getApplication().getSharedPreferences("apollo_sp", 0);
      switch (this.mSessionType)
      {
      }
      try
      {
        for (;;)
        {
          paramBaseChatPie = new ArrayList();
          paramApolloActionData = paramApolloActionData.split(",");
          int j = paramApolloActionData.length;
          i = 0;
          while (i < j)
          {
            paramString = paramApolloActionData[i];
            if (!TextUtils.isEmpty(paramString)) {
              paramBaseChatPie.add(Integer.valueOf(Integer.parseInt(paramString.trim())));
            }
            i += 1;
          }
          paramApolloActionData = paramApolloActionData.pk3DIds;
          break;
          if (ApolloActionData.isAction3DModel(paramApolloActionData.actionId))
          {
            paramApolloActionData = "";
            break;
          }
          paramApolloActionData = paramApolloActionData.pkIds;
          break;
          if (paramBaseChatPie.getBoolean("first_show_resp", true))
          {
            paramBaseChatPie.edit().putBoolean("first_show_resp", false).commit();
            this.headerTextView.setText(HardCodeUtil.a(2131700594));
            this.headerTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838561, 0);
          }
          else
          {
            this.headerTextView.setVisibility(8);
            continue;
            paramBaseChatPie = ContactUtils.c(this.mApp, paramString, true);
            paramBaseChatPie = String.format(HardCodeUtil.a(2131700596), new Object[] { paramBaseChatPie });
            this.headerTextView.setText(paramBaseChatPie);
            this.headerTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          }
        }
        this.mAdapter.a(paramBaseChatPie, paramInt);
        return;
      }
      catch (Exception paramBaseChatPie)
      {
        QLog.e("ApolloResponseManager", 1, "update Quick Response View error:", paramBaseChatPie);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloResponseManagerImpl
 * JD-Core Version:    0.7.0.1
 */