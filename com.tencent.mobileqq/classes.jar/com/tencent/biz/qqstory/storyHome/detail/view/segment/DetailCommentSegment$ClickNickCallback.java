package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import com.tencent.biz.qqstory.storyHome.detail.model.DetailEventCallback;
import com.tencent.biz.qqstory.storyHome.detail.model.SpannableStringUtils.ClickNickCallback;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.lang.ref.WeakReference;

public class DetailCommentSegment$ClickNickCallback
  implements SpannableStringUtils.ClickNickCallback
{
  private int a;
  private WeakReference<DetailEventCallback> b;
  
  public DetailCommentSegment$ClickNickCallback(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(DetailEventCallback paramDetailEventCallback)
  {
    this.b = new WeakReference(paramDetailEventCallback);
  }
  
  public void a(String paramString, int paramInt)
  {
    SLog.a("Q.qqstory.detail.DetailCommentSegment", "on nick click. unionId = %s.", paramString);
    if (paramInt != 1002)
    {
      if (paramInt == 1003) {
        return;
      }
      if (this.b.get() != null) {
        ((DetailEventCallback)this.b.get()).a(this.a, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailCommentSegment.ClickNickCallback
 * JD-Core Version:    0.7.0.1
 */