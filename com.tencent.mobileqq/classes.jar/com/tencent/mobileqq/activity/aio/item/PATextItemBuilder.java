package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import java.util.ArrayList;
import java.util.List;

public class PATextItemBuilder
  extends AbstractChatItemBuilder
{
  View.OnClickListener a;
  
  public PATextItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new PATextItemBuilder.1(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout.setPadding(0, AIOUtils.b(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
    if (paramView == null) {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558813, null);
    }
    Object localObject2 = (MessageForPubAccount)paramMessageRecord;
    PAMessage localPAMessage = ((MessageForPubAccount)localObject2).mPAMessage;
    paramMessageRecord = (PATextItemBuilder.Holder)paramViewHolder;
    Object localObject3 = localPAMessage.items;
    paramViewHolder = (ViewGroup)paramView.findViewById(2131372265);
    Object localObject1 = (ImageView)paramView.findViewById(2131372268);
    TextView localTextView1 = (TextView)paramView.findViewById(2131372267);
    TextView localTextView2 = (TextView)paramView.findViewById(2131372260);
    TextView localTextView3 = (TextView)paramView.findViewById(2131372261);
    TextView localTextView4 = (TextView)paramView.findViewById(2131372262);
    TextView localTextView5 = (TextView)paramView.findViewById(2131372263);
    TextView localTextView6 = (TextView)paramView.findViewById(2131372264);
    paramLinearLayout = new ArrayList();
    paramLinearLayout.add(localTextView2);
    paramLinearLayout.add(localTextView3);
    paramLinearLayout.add(localTextView4);
    paramLinearLayout.add(localTextView5);
    paramLinearLayout.add(localTextView6);
    localObject3 = (PAMessage.Item)((ArrayList)localObject3).get(0);
    paramMessageRecord.jdField_c_of_type_JavaLangString = ((PAMessage.Item)localObject3).url;
    paramMessageRecord.jdField_c_of_type_Int = localPAMessage.type;
    paramMessageRecord.jdField_b_of_type_JavaLangString = ((PAMessage.Item)localObject3).actionUrl;
    paramMessageRecord.jdField_a_of_type_JavaLangString = ((PAMessage.Item)localObject3).nativeJumpString;
    paramMessageRecord.jdField_b_of_type_Int = 6;
    paramMessageRecord.jdField_a_of_type_JavaLangObject = Long.valueOf(((MessageForPubAccount)localObject2).uniseq);
    paramMessageRecord.d = ((PAMessage.Item)localObject3).iconsString;
    int i;
    if ((!TextUtils.isEmpty(paramMessageRecord.d)) && (paramMessageRecord.d.contains("1"))) {
      i = 1;
    } else {
      i = 0;
    }
    localObject2 = localTextView1.getLayoutParams();
    if (i != 0)
    {
      if ((localObject2 instanceof ViewGroup.MarginLayoutParams))
      {
        localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
        ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = 24;
        localTextView1.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      ((ImageView)localObject1).setVisibility(0);
    }
    else
    {
      if ((localObject2 instanceof ViewGroup.MarginLayoutParams))
      {
        localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
        ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = 0;
        localTextView1.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      ((ImageView)localObject1).setVisibility(8);
    }
    localTextView1.setText(((PAMessage.Item)localObject3).title);
    localObject1 = ((PAMessage.Item)localObject3).digestList;
    if (localObject1 != null) {
      i = ((List)localObject1).size();
    } else {
      i = 0;
    }
    int j = 0;
    while (j < paramLinearLayout.size())
    {
      localTextView1 = (TextView)paramLinearLayout.get(j);
      if (i > j)
      {
        localTextView1.setText((CharSequence)((List)localObject1).get(j));
        localTextView1.setVisibility(0);
      }
      else
      {
        localTextView1.setVisibility(8);
      }
      j += 1;
    }
    paramViewHolder.setTag(paramMessageRecord);
    paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new PATextItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131365480) {
      return;
    }
    paramContext = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if ((paramContext != null) && (paramContext.uniseq == paramChatMessage.uniseq)) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    paramContext = (IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    long l = paramChatMessage.uniseq;
    boolean bool;
    if (paramChatMessage.issend == 1) {
      bool = true;
    } else {
      bool = false;
    }
    paramContext.deletePubAccountMsg(localQQAppInterface, localContext, str, paramInt, l, bool);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(2131365480, this.jdField_a_of_type_AndroidContentContext.getString(2131690788), 2130838907);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PATextItemBuilder
 * JD-Core Version:    0.7.0.1
 */