package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.ProtoUtils.StoryProtocolObserver;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.RspStoryMessageList;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.messagenotify.MessageData;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class MessageNotifySegment$MessageListFirstObserver
  extends ProtoUtils.StoryProtocolObserver
{
  WeakReference<MessageNotifySegment> b;
  WeakReference<ImageView> c;
  
  public MessageNotifySegment$MessageListFirstObserver(MessageNotifySegment paramMessageNotifySegment, ImageView paramImageView)
  {
    this.b = new WeakReference(paramMessageNotifySegment);
    this.c = new WeakReference(paramImageView);
  }
  
  public qqstory_struct.ErrorInfo a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "fetch message list result, code=" + paramInt);
    }
    MessageNotifySegment localMessageNotifySegment = (MessageNotifySegment)this.b.get();
    paramBundle = (ImageView)this.c.get();
    if ((localMessageNotifySegment == null) || (paramBundle == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "weak reference null.");
      }
    }
    do
    {
      for (;;)
      {
        return null;
        if ((paramInt == 0) && (paramArrayOfByte != null)) {
          try
          {
            Object localObject = new qqstory_710_message.RspStoryMessageList();
            ((qqstory_710_message.RspStoryMessageList)localObject).mergeFrom(paramArrayOfByte);
            if ((((qqstory_710_message.RspStoryMessageList)localObject).errinfo.error_code.has()) && (((qqstory_710_message.RspStoryMessageList)localObject).errinfo.error_code.get() == 0) && (((qqstory_710_message.RspStoryMessageList)localObject).message_num.get() > 0) && (!((qqstory_710_message.RspStoryMessageList)localObject).message_list.get().isEmpty()))
            {
              paramArrayOfByte = ((qqstory_710_message.RspStoryMessageList)localObject).message_list.get().iterator();
              for (;;)
              {
                if (paramArrayOfByte.hasNext())
                {
                  localObject = new MessageData((qqstory_710_message.StoryMessage)paramArrayOfByte.next());
                  if (((MessageData)localObject).d)
                  {
                    paramArrayOfByte = ((MessageData)localObject).a;
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "set bigV avatar from MessageData. unionId=" + paramArrayOfByte);
                    }
                    if (TextUtils.isEmpty(paramArrayOfByte)) {
                      break;
                    }
                    PlayModeUtils.a(paramBundle, PlayModeUtils.b(paramArrayOfByte), true, (int)DisplayUtils.a(MessageNotifySegment.b(localMessageNotifySegment), 33.0F));
                    return null;
                  }
                }
              }
            }
          }
          catch (InvalidProtocolBufferMicroException paramArrayOfByte)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "parse RspStoryMessageList error", paramArrayOfByte);
            }
          }
        }
      }
      paramArrayOfByte = ImageUtil.c();
      QQStoryContext.a();
      paramArrayOfByte = FaceDrawable.getFaceDrawable(QQStoryContext.a(), 1, Long.toString(MessageNotifySegment.a(localMessageNotifySegment)), 3, paramArrayOfByte, paramArrayOfByte);
      if (paramArrayOfByte != null) {
        paramBundle.setImageDrawable(paramArrayOfByte);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "fetch message list failed");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MessageNotifySegment.MessageListFirstObserver
 * JD-Core Version:    0.7.0.1
 */