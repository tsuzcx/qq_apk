package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.newfriend.QIMFollowMessage;
import java.util.Locale;
import wpd;

public class QIMFollowerAddBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public QIMFollowerAddBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    QIMFollowerAddBuilder.QIMFollowerAddHolder localQIMFollowerAddHolder;
    QIMFollwerAdd localQIMFollwerAdd;
    label231:
    label251:
    Object localObject;
    int i;
    if ((paramView == null) || (!(paramView.getTag() instanceof QIMFollowerAddBuilder.QIMFollowerAddHolder)))
    {
      localQIMFollowerAddHolder = new QIMFollowerAddBuilder.QIMFollowerAddHolder();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2130970650, localQIMFollowerAddHolder);
      localQIMFollowerAddHolder.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366543));
      localQIMFollowerAddHolder.h = ((TextView)paramView.findViewById(2131362899));
      localQIMFollowerAddHolder.i = ((TextView)paramView.findViewById(2131369991));
      localQIMFollowerAddHolder.l = ((TextView)paramView.findViewById(2131371530));
      localQIMFollowerAddHolder.j = ((TextView)paramView.findViewById(2131369993));
      localQIMFollowerAddHolder.k = ((TextView)paramView.findViewById(2131368975));
      localQIMFollowerAddHolder.a = ((Button)paramView.findViewById(2131368974));
      paramView.setTag(localQIMFollowerAddHolder);
      localQIMFollowerAddHolder.jdField_f_of_type_AndroidViewView.setTag(localQIMFollowerAddHolder);
      localQIMFollowerAddHolder.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage, localQIMFollowerAddHolder, this);
      localQIMFollowerAddHolder.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130838591);
      localQIMFollwerAdd = ((QIMFollowMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a;
      if (TextUtils.isEmpty(localQIMFollwerAdd.smartRemark)) {
        break label556;
      }
      localQIMFollowerAddHolder.h.setVisibility(0);
      localQIMFollowerAddHolder.h.setText(localQIMFollwerAdd.smartRemark);
      if (this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage.a()) {
        break label569;
      }
      localQIMFollowerAddHolder.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130838595);
      localObject = new StringBuilder(256);
      switch (localQIMFollwerAdd.gender)
      {
      default: 
        localQIMFollowerAddHolder.l.setBackgroundResource(2130843152);
        paramInt = 0;
        i = 0;
      }
    }
    for (;;)
    {
      label306:
      localQIMFollowerAddHolder.l.setText("");
      localQIMFollowerAddHolder.l.setCompoundDrawablesWithIntrinsicBounds(paramInt, 0, 0, 0);
      if (i != 0)
      {
        localQIMFollowerAddHolder.l.setVisibility(0);
        localQIMFollowerAddHolder.l.setPadding(8, 4, 8, 4);
        label355:
        if (!TextUtils.isEmpty(localQIMFollwerAdd.longNick)) {
          break label675;
        }
        localQIMFollowerAddHolder.i.setVisibility(8);
        label376:
        if (TextUtils.isEmpty(localQIMFollwerAdd.source)) {
          break label722;
        }
        localObject = String.format(Locale.getDefault(), "来源：%s", new Object[] { localQIMFollwerAdd.source });
        localQIMFollowerAddHolder.j.setText((CharSequence)localObject);
        localQIMFollowerAddHolder.j.setVisibility(0);
      }
      for (;;)
      {
        localQIMFollowerAddHolder.k.setVisibility(8);
        localQIMFollowerAddHolder.a.setText("查看");
        localQIMFollowerAddHolder.a.setVisibility(0);
        localQIMFollowerAddHolder.a.setOnClickListener(this);
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494243);
        if (localObject != null) {
          localQIMFollowerAddHolder.a.setTextColor((ColorStateList)localObject);
        }
        localQIMFollowerAddHolder.a.setBackgroundResource(2130838515);
        localQIMFollowerAddHolder.jdField_f_of_type_JavaLangString = String.valueOf(localQIMFollwerAdd.uin);
        localQIMFollowerAddHolder.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a(1, String.valueOf(localQIMFollwerAdd.uin)));
        return paramView;
        localQIMFollowerAddHolder = (QIMFollowerAddBuilder.QIMFollowerAddHolder)paramView.getTag();
        break;
        label556:
        localQIMFollowerAddHolder.h.setVisibility(8);
        break label231;
        label569:
        localQIMFollowerAddHolder.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130838591);
        break label251;
        i = 2130843151;
        localQIMFollowerAddHolder.l.setBackgroundResource(2130843152);
        paramInt = i;
        if (!AppSetting.b) {
          break label735;
        }
        ((StringBuilder)localObject).append("男");
        int j = 1;
        paramInt = i;
        i = j;
        break label306;
        i = 2130843149;
        localQIMFollowerAddHolder.l.setBackgroundResource(2130843150);
        paramInt = i;
        if (!AppSetting.b) {
          break label735;
        }
        ((StringBuilder)localObject).append("女");
        j = 1;
        paramInt = i;
        i = j;
        break label306;
        localQIMFollowerAddHolder.l.setVisibility(8);
        break label355;
        label675:
        localQIMFollowerAddHolder.i.setVisibility(0);
        localQIMFollowerAddHolder.i.setText(localQIMFollwerAdd.longNick);
        if (!AppSetting.b) {
          break label376;
        }
        ((StringBuilder)localObject).append(",").append(localQIMFollwerAdd.longNick);
        break label376;
        label722:
        localQIMFollowerAddHolder.j.setVisibility(8);
      }
      label735:
      i = 1;
    }
  }
  
  protected void a()
  {
    ThreadManager.postImmediately(new wpd(this), null, true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    case 2131366542: 
      return;
    }
    ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216)).a(this.jdField_a_of_type_AndroidContentContext, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.QIMFollowerAddBuilder
 * JD-Core Version:    0.7.0.1
 */