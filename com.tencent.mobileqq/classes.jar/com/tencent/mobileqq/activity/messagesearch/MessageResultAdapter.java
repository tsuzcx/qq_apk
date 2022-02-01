package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;

public class MessageResultAdapter
  extends BaseMessageResultAdapter
{
  public MessageResultAdapter(Context paramContext, MqqWeakReferenceHandler paramMqqWeakReferenceHandler, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramMqqWeakReferenceHandler, paramSessionInfo, paramQQAppInterface);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MessageItem localMessageItem = (MessageItem)getItem(paramInt);
    View localView;
    BaseMessageResultAdapter.MessageHolder localMessageHolder;
    if (paramView == null)
    {
      localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559337, null);
      localMessageHolder = new BaseMessageResultAdapter.MessageHolder();
      localMessageHolder.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)localView.findViewById(2131378461));
      localMessageHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378463));
      localMessageHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368343));
      localMessageHolder.b = ((TextView)localView.findViewById(2131369727));
      localView.setTag(localMessageHolder);
    }
    else
    {
      localMessageHolder = (BaseMessageResultAdapter.MessageHolder)paramView.getTag();
      localView = paramView;
    }
    MessageRecord localMessageRecord = localMessageItem.a;
    paramView = ColorNickManager.a(localMessageRecord.msg, localMessageRecord, 32, 3);
    localMessageHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    Object localObject1 = localMessageRecord.senderuin;
    paramView = (View)localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)
    {
      paramView = (View)localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
        if (localMessageRecord.isSend()) {
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        } else {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        }
      }
    }
    Object localObject2;
    if (AnonymousChatHelper.a(localMessageRecord))
    {
      paramView = AnonymousChatHelper.a(localMessageRecord);
      localObject1 = localMessageHolder.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697238));
      ((StringBuilder)localObject2).append(paramView.jdField_b_of_type_JavaLangString);
      ((ColorNickTextView)localObject1).setText(((StringBuilder)localObject2).toString());
      localMessageHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(AnonymousChatHelper.a(paramView.jdField_b_of_type_Int)));
    }
    else
    {
      localObject1 = TroopBusinessUtil.a(localMessageRecord);
      if (localObject1 != null)
      {
        paramView = ((TroopBusinessUtil.TroopBusinessMessage)localObject1).c;
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840321);
        localObject1 = URLDrawable.getDrawable(((TroopBusinessUtil.TroopBusinessMessage)localObject1).jdField_a_of_type_JavaLangString, (Drawable)localObject2, (Drawable)localObject2);
        ((URLDrawable)localObject1).setTag(URLDrawableDecodeHandler.b(100, 100, 6));
        ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.a);
        localMessageHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject1);
      }
      else
      {
        localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageRecord.isSend(), localMessageRecord.senderuin);
        localMessageHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramView));
        paramView = (View)localObject1;
      }
      paramView = new ColorNickText(paramView, 32).a();
      localMessageHolder.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(paramView);
      ColorNickManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageHolder.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, paramView);
    }
    localMessageHolder.b.setText(localMessageItem.a(localMessageRecord.time));
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.MessageResultAdapter
 * JD-Core Version:    0.7.0.1
 */