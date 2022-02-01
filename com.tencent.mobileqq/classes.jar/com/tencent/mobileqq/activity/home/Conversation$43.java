package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class Conversation$43
  extends DiscussionObserver
{
  Conversation$43(Conversation paramConversation) {}
  
  public void a()
  {
    this.a.a(9, null, -2147483648);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onDelDiscussion");
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    this.a.a(8, Long.toString(paramLong), 3000);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_updateDiscussionInfo");
      }
      this.a.a(0L);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onChangeDiscussionName");
      }
      this.a.a(8, paramString, 3000);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "conversation onUpdateDiscussionFaceIcon|[" + paramBoolean1 + ", " + paramBoolean2 + ", " + paramString + "]");
    }
    if (paramBoolean1) {
      this.a.b(new Conversation.43.1(this, paramString));
    }
  }
  
  public void b(boolean paramBoolean, String paramString)
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
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.43
 * JD-Core Version:    0.7.0.1
 */