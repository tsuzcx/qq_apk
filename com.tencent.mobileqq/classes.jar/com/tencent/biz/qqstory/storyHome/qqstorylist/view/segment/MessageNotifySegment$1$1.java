package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;

class MessageNotifySegment$1$1
  implements Runnable
{
  MessageNotifySegment$1$1(MessageNotifySegment.1 param1, String paramString, UserManager paramUserManager) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a))
    {
      Object localObject = this.b.b(this.a);
      if ((localObject != null) && (((QQUserUIItem)localObject).isAvailable()))
      {
        if ((!((QQUserUIItem)localObject).isVipButNoFriend()) && ((MessageNotifySegment.a(this.c.this$0) != 1000000L) || (TextUtils.isEmpty(MessageNotifySegment.b(this.c.this$0)))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "set friend avatar.");
          }
          QQStoryContext.a();
          localObject = FaceDrawable.getFaceDrawable(QQStoryContext.j(), 1, Long.toString(MessageNotifySegment.a(this.c.this$0)), 3, this.c.b, this.c.b);
          if (localObject != null) {
            this.c.a.setImageDrawable((Drawable)localObject);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "set bigV avatar from UserUIItem");
          }
          localObject = ((QQUserUIItem)localObject).headUrl;
          if (!TextUtils.isEmpty(MessageNotifySegment.b(this.c.this$0))) {
            localObject = MessageNotifySegment.b(this.c.this$0);
          }
          PlayModeUtils.a(this.c.a, (String)localObject, true, (int)DisplayUtils.a(MessageNotifySegment.c(this.c.this$0), 33.0F));
        }
        return;
      }
    }
    this.c.this$0.a(this.c.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MessageNotifySegment.1.1
 * JD-Core Version:    0.7.0.1
 */