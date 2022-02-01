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
  private WeakReference<QQAppInterface> b;
  private WeakReference<Activity> c;
  
  TextItemBuilder$MyOnDoubleClick(TextItemBuilder paramTextItemBuilder, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.b = new WeakReference(paramQQAppInterface);
    this.c = new WeakReference(paramActivity);
  }
  
  public void a(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
    Activity localActivity = (Activity)this.c.get();
    if ((localActivity != null) && (localQQAppInterface != null))
    {
      AIOUtils.q = true;
      if (this.a.c()) {
        return;
      }
      Object localObject = AIOUtils.a(paramView);
      if (ConfessMsgUtil.b((MessageRecord)localObject)) {
        return;
      }
      if (((ChatMessage)localObject).istroop == 10007) {
        return;
      }
      if ((paramView.getId() != 2131447325) && (paramView.getId() != 2131438908))
      {
        if (paramView.getId() == 2131430607) {
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
        ChatActivityUtils.a(localQQAppInterface, paramView, localActivity, this.a.f.a);
      }
      return;
    }
    QLog.e("ChatItemBuilder", 1, "TextItemBuilder  onDoubleClick  app null fa null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextItemBuilder.MyOnDoubleClick
 * JD-Core Version:    0.7.0.1
 */