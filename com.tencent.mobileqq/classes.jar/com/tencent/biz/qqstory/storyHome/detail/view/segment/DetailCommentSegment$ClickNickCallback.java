package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import com.tencent.biz.qqstory.storyHome.detail.model.DetailEventCallback;
import com.tencent.biz.qqstory.storyHome.detail.model.SpannableStringUtils.ClickNickCallback;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.lang.ref.WeakReference;

public class DetailCommentSegment$ClickNickCallback
  implements SpannableStringUtils.ClickNickCallback
{
  private int jdField_a_of_type_Int;
  private WeakReference<DetailEventCallback> jdField_a_of_type_JavaLangRefWeakReference;
  
  public DetailCommentSegment$ClickNickCallback(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(DetailEventCallback paramDetailEventCallback)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDetailEventCallback);
  }
  
  public void a(String paramString, int paramInt)
  {
    SLog.a("Q.qqstory.detail.DetailCommentSegment", "on nick click. unionId = %s.", paramString);
    if (paramInt != 1002)
    {
      if (paramInt == 1003) {
        return;
      }
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
        ((DetailEventCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_Int, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailCommentSegment.ClickNickCallback
 * JD-Core Version:    0.7.0.1
 */