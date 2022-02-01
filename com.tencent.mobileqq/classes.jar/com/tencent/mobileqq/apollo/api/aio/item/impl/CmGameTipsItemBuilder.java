package com.tencent.mobileqq.apollo.api.aio.item.impl;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.lightGame.CmGameSessionUtil;
import com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler;
import com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler.TopGameInfo;
import com.tencent.mobileqq.apollo.lightGame.GameInfoAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForCmGameTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.lang.ref.WeakReference;
import java.util.List;

public class CmGameTipsItemBuilder
  extends AbstractChatItemBuilder
  implements AdapterView.OnItemClickListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private WeakReference<CmGameTipsItemBuilder.ISessionHandler> jdField_a_of_type_JavaLangRefWeakReference;
  private List<ApolloGameData> jdField_a_of_type_JavaUtilList;
  
  public CmGameTipsItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private void a(ApolloGameData paramApolloGameData)
  {
    if (paramApolloGameData == null)
    {
      b();
      QLog.e("ChatItemBuilder", 1, "[showNoGameRoleDialog] gameData null");
      return;
    }
    if (TextUtils.isEmpty(paramApolloGameData.gameAppid))
    {
      b();
      QLog.e("ChatItemBuilder", 1, "[showNoGameRoleDialog] gameAppid null");
      return;
    }
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690148)).setPositiveButton(2131690136, new CmGameTipsItemBuilder.2(this, paramApolloGameData)).setNegativeButton(2131690137, new CmGameTipsItemBuilder.1(this)).show();
  }
  
  private void b()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 1, 2131690135, 0).a();
  }
  
  private void b(ApolloGameData paramApolloGameData)
  {
    if (paramApolloGameData == null)
    {
      b();
      QLog.e("ChatItemBuilder", 1, "[showFriendNoGameRoleDialog] gameData null");
      return;
    }
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690138)).setPositiveButton(2131690137, new CmGameTipsItemBuilder.3(this)).show();
  }
  
  public View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout = (MessageForCmGameTips)paramMessageRecord;
    if (!(paramViewHolder instanceof CmGameTipsItemBuilder.Holder)) {
      return paramView;
    }
    paramViewHolder = (CmGameTipsItemBuilder.Holder)paramViewHolder;
    if (paramView != null)
    {
      paramMessageRecord = paramView;
      if (paramViewHolder != null)
      {
        paramMessageRecord = paramView;
        if (paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {}
      }
    }
    else
    {
      paramMessageRecord = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558971, null, true);
      paramMessageRecord.setId(2131374505);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = paramMessageRecord;
    }
    if (paramLinearLayout.gameInfo != null) {
      this.jdField_a_of_type_JavaUtilList = paramLinearLayout.gameInfo.jdField_b_of_type_JavaUtilList;
    }
    a(paramViewHolder, paramLinearLayout);
    return paramMessageRecord;
  }
  
  public AbstractChatItemBuilder.ViewHolder a()
  {
    return new CmGameTipsItemBuilder.Holder();
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      CmGameTipsItemBuilder.ISessionHandler localISessionHandler = (CmGameTipsItemBuilder.ISessionHandler)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localISessionHandler != null)
      {
        ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getGameTempMsgHandler().b(localISessionHandler);
        this.jdField_a_of_type_JavaLangRefWeakReference = null;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public void a(CmGameTipsItemBuilder.Holder paramHolder, MessageForCmGameTips paramMessageForCmGameTips)
  {
    if (paramMessageForCmGameTips.needTopPadding) {
      paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, AIOUtils.a(86.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
    for (;;)
    {
      if (paramHolder.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
        paramHolder.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377225));
      }
      if (paramHolder.jdField_b_of_type_AndroidWidgetTextView == null) {
        paramHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380301));
      }
      if (paramHolder.jdField_a_of_type_ComTencentWidgetGridView == null)
      {
        paramHolder.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368184));
        paramHolder.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(2);
      }
      paramHolder.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(3);
      paramHolder.jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(AIOUtils.a(103.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramHolder.jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramHolder.jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramHolder.jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
      Object localObject = new GameInfoAdapter(paramMessageForCmGameTips.gameInfo, this.jdField_a_of_type_AndroidContentContext);
      paramHolder.jdField_a_of_type_ComTencentWidgetGridView.setAdapter((ListAdapter)localObject);
      paramHolder.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this);
      paramHolder.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(2);
      int i = paramMessageForCmGameTips.gameInfo.jdField_b_of_type_JavaUtilList.size() / 3;
      int j = AIOUtils.a(339.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int k = AIOUtils.a(73.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject = new RelativeLayout.LayoutParams(j, AIOUtils.a((i - 1) * 68, this.jdField_a_of_type_AndroidContentContext.getResources()) + k);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131380301);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      paramHolder.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForCmGameTips.gameInfo.jdField_b_of_type_JavaLangString);
      return;
      paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, AIOUtils.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getGameTempMsgHandler();
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null))
    {
      paramView = new CmGameTipsItemBuilder.ISessionHandler(this);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
      paramAdapterView.a(paramView);
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      paramView = (ApolloGameData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (paramView == null) {
        QLog.e("ChatItemBuilder", 1, "[onClick] no game data for id:" + paramInt);
      }
    }
    else
    {
      return;
    }
    VipUtils.a(null, "cmshow", "Apollo", "mutualhobby", 0, 0, new String[] { paramView.gameId + "" });
    paramInt = (int)(System.currentTimeMillis() / 1000L);
    ((CmGameTipsItemBuilder.ISessionHandler)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a = paramInt;
    if (!paramView.isGameApp)
    {
      paramAdapterView.a(paramView.gameId, paramInt);
      return;
    }
    CmGameSessionUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.item.impl.CmGameTipsItemBuilder
 * JD-Core Version:    0.7.0.1
 */