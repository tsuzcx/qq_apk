package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import java.util.ArrayList;

class AddRequestActivity$14
  extends DiscussionObserver
{
  AddRequestActivity$14(AddRequestActivity paramAddRequestActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if ((paramBoolean) && (paramLong == this.a.r) && (this.a.r != 0L)) {
      this.a.runOnUiThread(new AddRequestActivity.14.3(this));
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((this.a.r != 0L) && (paramBoolean) && ((paramObject instanceof ArrayList)) && (((ArrayList)paramObject).contains(Long.valueOf(this.a.r)))) {
      this.a.runOnUiThread(new AddRequestActivity.14.2(this));
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.r != 0L) && (String.valueOf(this.a.r).equals(paramString))) {
      this.a.runOnUiThread(new AddRequestActivity.14.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.14
 * JD-Core Version:    0.7.0.1
 */