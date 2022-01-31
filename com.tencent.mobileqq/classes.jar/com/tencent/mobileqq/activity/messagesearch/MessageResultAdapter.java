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
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
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
    MessageRecord localMessageRecord;
    if (paramView == null)
    {
      localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130969073, null);
      paramViewGroup = new BaseMessageResultAdapter.MessageHolder();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363896));
      paramViewGroup.b = ((TextView)localView.findViewById(2131363901));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362719));
      paramViewGroup.c = ((TextView)localView.findViewById(2131363201));
      localView.setTag(paramViewGroup);
      localMessageRecord = localMessageItem.a;
      paramViewGroup.b.setText(localMessageItem.a(localMessageRecord.msg));
      localObject = localMessageRecord.senderuin;
      paramView = (View)localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)
      {
        paramView = (View)localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
          if (!localMessageRecord.isSend()) {
            break label277;
          }
        }
      }
    }
    label277:
    for (paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      if (!AnonymousChatHelper.a(localMessageRecord)) {
        break label288;
      }
      paramView = AnonymousChatHelper.a(localMessageRecord);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430287) + paramView.jdField_b_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(AnonymousChatHelper.a(paramView.jdField_b_of_type_Int)));
      paramViewGroup.c.setText(localMessageItem.a(localMessageRecord.time));
      return localView;
      paramViewGroup = (BaseMessageResultAdapter.MessageHolder)paramView.getTag();
      localView = paramView;
      break;
    }
    label288:
    Object localObject = TroopBusinessUtil.a(localMessageRecord);
    if (localObject != null)
    {
      paramView = ((TroopBusinessUtil.TroopBusinessMessage)localObject).c;
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839132);
      localObject = URLDrawable.getDrawable(((TroopBusinessUtil.TroopBusinessMessage)localObject).jdField_a_of_type_JavaLangString, localDrawable, localDrawable);
      ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.a(100, 100, 6));
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.a);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageItem.a(paramView));
      break;
      localObject = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageRecord.isSend(), localMessageRecord.senderuin);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramView));
      paramView = (View)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.MessageResultAdapter
 * JD-Core Version:    0.7.0.1
 */