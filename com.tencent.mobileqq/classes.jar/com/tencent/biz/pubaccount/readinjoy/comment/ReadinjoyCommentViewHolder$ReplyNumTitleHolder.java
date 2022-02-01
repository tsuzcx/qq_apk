package com.tencent.biz.pubaccount.readinjoy.comment;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.app.HardCodeUtil;

public class ReadinjoyCommentViewHolder$ReplyNumTitleHolder
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  View b;
  
  public View a(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = paramReadinjoyCommentListBaseAdapter.a().inflate(2131560232, paramViewGroup, false);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380651));
      if (this.jdField_a_of_type_AndroidWidgetTextView.getPaint() != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      }
      this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131381618);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.b = localView.findViewById(2131381606);
      this.b.setVisibility(0);
    }
    localView.setTag(this);
    return localView;
  }
  
  public void a(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, int paramInt)
  {
    if (paramReadinjoyCommentListBaseAdapter == null) {
      return;
    }
    CommentViewItem localCommentViewItem = (CommentViewItem)paramReadinjoyCommentListBaseAdapter.getItem(paramInt);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = HardCodeUtil.a(2131712683);
    if ((localCommentViewItem.a != null) && (paramReadinjoyCommentListBaseAdapter.a() != null)) {}
    for (paramReadinjoyCommentListBaseAdapter = String.valueOf(paramReadinjoyCommentListBaseAdapter.a().a(localCommentViewItem.a.commentId));; paramReadinjoyCommentListBaseAdapter = "")
    {
      localSpannableStringBuilder.append(str + " ");
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#262626")), 0, str.length(), 34);
      localSpannableStringBuilder.append(paramReadinjoyCommentListBaseAdapter);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#737373")), str.length(), localSpannableStringBuilder.length(), 34);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadinjoyCommentViewHolder.ReplyNumTitleHolder
 * JD-Core Version:    0.7.0.1
 */