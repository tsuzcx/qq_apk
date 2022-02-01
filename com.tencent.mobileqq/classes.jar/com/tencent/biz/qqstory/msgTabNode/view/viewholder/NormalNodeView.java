package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.List;

public class NormalNodeView
  extends MsgNodeViewHolder
{
  public int a;
  
  public NormalNodeView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, 2131628093);
    this.a = paramInt;
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    int i = this.a;
    if (i != 3)
    {
      if (i != 4)
      {
        AssertUtils.fail(HardCodeUtil.a(2131905427), new Object[0]);
        return;
      }
      this.c.setNodeName(HardCodeUtil.a(2131905426), false);
      this.c.a.setImageResource(2130848415);
      this.c.a.b(false);
      return;
    }
    this.itemView.setTag(Integer.valueOf(3));
    this.c.setNodeName(paramMsgTabNodeInfo.l, false);
    String str = ThumbnailUrlHelper.b(paramMsgTabNodeInfo.p);
    if (!TextUtils.isEmpty(str)) {
      b(str);
    } else {
      this.c.a.setImageResource(2130848418);
    }
    if ((paramMsgTabNodeInfo.e == null) || (paramMsgTabNodeInfo.e.isEmpty())) {
      this.c.a(1, 1 - paramMsgTabNodeInfo.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.NormalNodeView
 * JD-Core Version:    0.7.0.1
 */