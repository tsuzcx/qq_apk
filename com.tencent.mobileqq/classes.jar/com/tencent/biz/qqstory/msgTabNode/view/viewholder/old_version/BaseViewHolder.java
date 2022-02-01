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
  protected RotateCircleImageView a = (RotateCircleImageView)a(2131430724);
  protected ImageView b = (ImageView)a(2131434889);
  protected ImageView c = (ImageView)a(2131446694);
  protected TextView d = (TextView)a(2131447463);
  protected TextView e = (TextView)a(2131444481);
  protected ImageView f = (ImageView)a(2131444480);
  
  public BaseViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    this.a.setBorderStyle(RotateCircleImageView.BorderStyle.STILL);
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
    this.a.setBorderColors(arrayOfInt);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if ((paramMsgTabNodeInfo.e != null) && (!paramMsgTabNodeInfo.e.isEmpty())) {
      a(paramMsgTabNodeInfo.e.size(), paramMsgTabNodeInfo.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.BaseViewHolder
 * JD-Core Version:    0.7.0.1
 */