package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class TextItemBuilder$MyOnDoubleClick
  implements AnimationTextView.OnDoubleClick
{
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<Activity> b;
  
  TextItemBuilder$MyOnDoubleClick(TextItemBuilder paramTextItemBuilder, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramActivity);
  }
  
  public void a(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Activity localActivity = (Activity)this.b.get();
    if ((localActivity != null) && (localQQAppInterface != null))
    {
      AIOUtils.o = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder.a()) {
        return;
      }
      Object localObject = AIOUtils.a(paramView);
      if (ConfessMsgUtil.a((MessageRecord)localObject)) {
        return;
      }
      if (((ChatMessage)localObject).istroop == 10007) {
        return;
      }
      if ((paramView.getId() != 2131378668) && (paramView.getId() != 2131371529))
      {
        if (paramView.getId() == 2131364549) {
          return;
        }
        BaseActivity localBaseActivity = (BaseActivity)paramView.getContext();
        localObject = null;
        if (localBaseActivity != null) {
          localObject = localBaseActivity.getChatFragment();
        }
        if (localObject == null)
        {
          ChatActivityUtils.a(localQQAppInterface, paramView, localActivity);
          return;
        }
        ChatActivityUtils.a(localQQAppInterface, paramView, localActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder.a.a);
      }
      return;
    }
    QLog.e("ChatItemBuilder", 1, "TextItemBuilder  onDoubleClick  app null fa null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextItemBuilder.MyOnDoubleClick
 * JD-Core Version:    0.7.0.1
 */