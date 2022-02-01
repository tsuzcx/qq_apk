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
    super(paramViewGroup, 2131561714);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    int i = this.jdField_a_of_type_Int;
    if (i != 3)
    {
      if (i != 4)
      {
        AssertUtils.fail(HardCodeUtil.a(2131707612), new Object[0]);
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName(HardCodeUtil.a(2131707611), false);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a.setImageResource(2130846863);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a.b(false);
      return;
    }
    this.itemView.setTag(Integer.valueOf(3));
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName(paramMsgTabNodeInfo.c, false);
    String str = ThumbnailUrlHelper.b(paramMsgTabNodeInfo.g);
    if (!TextUtils.isEmpty(str)) {
      b(str);
    } else {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a.setImageResource(2130846866);
    }
    if ((paramMsgTabNodeInfo.a == null) || (paramMsgTabNodeInfo.a.isEmpty())) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a(1, 1 - paramMsgTabNodeInfo.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.NormalNodeView
 * JD-Core Version:    0.7.0.1
 */