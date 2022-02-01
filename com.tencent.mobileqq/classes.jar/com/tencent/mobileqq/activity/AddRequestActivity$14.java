package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.DiscussionObserver;
import java.util.ArrayList;

class AddRequestActivity$14
  extends DiscussionObserver
{
  AddRequestActivity$14(AddRequestActivity paramAddRequestActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if ((paramBoolean) && (paramLong == this.a.b) && (this.a.b != 0L)) {
      this.a.runOnUiThread(new AddRequestActivity.14.3(this));
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if ((this.a.b != 0L) && (paramBoolean) && ((paramObject instanceof ArrayList)) && (((ArrayList)paramObject).contains(Long.valueOf(this.a.b)))) {
      this.a.runOnUiThread(new AddRequestActivity.14.2(this));
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.b != 0L) && (String.valueOf(this.a.b).equals(paramString))) {
      this.a.runOnUiThread(new AddRequestActivity.14.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.14
 * JD-Core Version:    0.7.0.1
 */