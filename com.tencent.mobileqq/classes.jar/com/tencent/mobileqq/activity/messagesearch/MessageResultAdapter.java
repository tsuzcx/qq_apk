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
    MessageRecord localMessageRecord;
    if (paramView == null)
    {
      localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559463, null);
      localMessageHolder = new BaseMessageResultAdapter.MessageHolder();
      localMessageHolder.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)localView.findViewById(2131379092));
      localMessageHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379094));
      localMessageHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368603));
      localMessageHolder.b = ((TextView)localView.findViewById(2131370043));
      localView.setTag(localMessageHolder);
      localMessageRecord = localMessageItem.a;
      paramView = ColorNickManager.a(localMessageRecord.msg, localMessageRecord, 32, 3);
      localMessageHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      localObject = localMessageRecord.senderuin;
      paramView = (View)localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)
      {
        paramView = (View)localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
          if (!localMessageRecord.isSend()) {
            break label308;
          }
        }
      }
    }
    label308:
    for (paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      if (!AnonymousChatHelper.a(localMessageRecord)) {
        break label319;
      }
      paramView = AnonymousChatHelper.a(localMessageRecord);
      localMessageHolder.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697219) + paramView.jdField_b_of_type_JavaLangString);
      localMessageHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(AnonymousChatHelper.a(paramView.jdField_b_of_type_Int)));
      localMessageHolder.b.setText(localMessageItem.a(localMessageRecord.time));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localMessageHolder = (BaseMessageResultAdapter.MessageHolder)paramView.getTag();
      localView = paramView;
      break;
    }
    label319:
    Object localObject = TroopBusinessUtil.a(localMessageRecord);
    if (localObject != null)
    {
      paramView = ((TroopBusinessUtil.TroopBusinessMessage)localObject).c;
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840452);
      localObject = URLDrawable.getDrawable(((TroopBusinessUtil.TroopBusinessMessage)localObject).jdField_a_of_type_JavaLangString, localDrawable, localDrawable);
      ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.b(100, 100, 6));
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.a);
      localMessageHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    }
    for (;;)
    {
      paramView = new ColorNickText(paramView, 32).a();
      localMessageHolder.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(paramView);
      ColorNickManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageHolder.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, paramView);
      break;
      localObject = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageRecord.isSend(), localMessageRecord.senderuin);
      localMessageHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramView));
      paramView = (View)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.MessageResultAdapter
 * JD-Core Version:    0.7.0.1
 */