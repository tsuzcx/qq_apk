package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class Conversation$46
  extends DiscussionObserver
{
  Conversation$46(Conversation paramConversation) {}
  
  protected void a()
  {
    this.a.a(9, null, -2147483648);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onDelDiscussion");
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    this.a.a(8, Long.toString(paramLong), 3000);
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_updateDiscussionInfo");
      }
      this.a.a(0L);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onChangeDiscussionName");
      }
      this.a.a(8, paramString, 3000);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("conversation onUpdateDiscussionFaceIcon|[");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i("Q.recent", 2, localStringBuilder.toString());
    }
    if (paramBoolean1) {
      this.a.b(new Conversation.46.1(this, paramString));
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onQuitDiscussion");
      }
      this.a.a(8, paramString, 3000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.46
 * JD-Core Version:    0.7.0.1
 */