package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.List;

public class RecommendActivityNodeViewHolder
  extends MsgNodeViewHolder
{
  public RecommendActivityNodeViewHolder(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131628093);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    this.c.setDisplayState(2);
    c(paramMsgTabNodeInfo.k);
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout;
    if (!TextUtils.isEmpty(paramMsgTabNodeInfo.y))
    {
      localStoryMsgNodeFrameLayout = this.c;
      if (TextUtils.isEmpty(paramMsgTabNodeInfo.l)) {
        str = HardCodeUtil.a(2131910743);
      } else {
        str = paramMsgTabNodeInfo.l;
      }
      localStoryMsgNodeFrameLayout.setNodeName(str, paramMsgTabNodeInfo.y);
    }
    else
    {
      localStoryMsgNodeFrameLayout = this.c;
      if (TextUtils.isEmpty(paramMsgTabNodeInfo.l)) {
        str = HardCodeUtil.a(2131910750);
      } else {
        str = paramMsgTabNodeInfo.l;
      }
      localStoryMsgNodeFrameLayout.setNodeName(str, false);
    }
    if ((paramMsgTabNodeInfo.e == null) || (paramMsgTabNodeInfo.e.isEmpty())) {
      this.c.a(1, 1 - paramMsgTabNodeInfo.i);
    }
    String str = (String)this.c.getTag(2131442759);
    if (!TextUtils.equals(paramMsgTabNodeInfo.d, str))
    {
      int i = paramMsgTabNodeInfo.b;
      if (i != 10)
      {
        if (i != 11) {
          str = "unknown";
        } else {
          str = "3";
        }
      }
      else {
        str = "2";
      }
      StoryReportor.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramMsgTabNodeInfo.d, str });
      this.c.setTag(2131442759, paramMsgTabNodeInfo.d);
    }
  }
  
  public void b()
  {
    this.c.setTag(2131442759, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.RecommendActivityNodeViewHolder
 * JD-Core Version:    0.7.0.1
 */