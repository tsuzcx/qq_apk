package com.tencent.biz.pubaccount.readinjoy.comment;

import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuTextBuilder;

final class ReadInJoyCommentComponentFragment$5
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof BiuTextBuilder)) {
      return (Editable)paramCharSequence;
    }
    return new BiuTextBuilder(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment.5
 * JD-Core Version:    0.7.0.1
 */