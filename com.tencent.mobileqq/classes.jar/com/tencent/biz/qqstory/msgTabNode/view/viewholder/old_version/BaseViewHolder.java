package com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version;

import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.widget.RotateCircleImageView;
import com.tencent.biz.qqstory.widget.RotateCircleImageView.BorderStyle;
import java.util.List;

public class BaseViewHolder
  extends com.tencent.biz.qqstory.common.recyclerview.BaseViewHolder<MsgTabNodeInfo>
{
  protected ImageView a;
  protected TextView a;
  protected RotateCircleImageView a;
  protected ImageView b;
  protected TextView b;
  protected ImageView c = (ImageView)a(2131376272);
  
  public BaseViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView = ((RotateCircleImageView)a(2131364638));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131368041));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131378180));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131378784));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131376273));
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView.setBorderStyle(RotateCircleImageView.BorderStyle.STILL);
    int[] arrayOfInt = new int[paramInt1];
    int i = 0;
    while (i < paramInt1)
    {
      if (i < paramInt1 - paramInt2) {
        arrayOfInt[i] = Color.parseColor("#DEDFE0");
      } else {
        arrayOfInt[i] = Color.parseColor("#19D7FD");
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView.setBorderColors(arrayOfInt);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if ((paramMsgTabNodeInfo.a != null) && (!paramMsgTabNodeInfo.a.isEmpty())) {
      a(paramMsgTabNodeInfo.a.size(), paramMsgTabNodeInfo.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.BaseViewHolder
 * JD-Core Version:    0.7.0.1
 */