package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVideoInfo;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.Iterator;
import java.util.List;

public class RecommendFollowNodeViewHolder
  extends FollowNodeViewHolder
{
  public RecommendFollowNodeViewHolder(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected String a(QQUserUIItem paramQQUserUIItem)
  {
    String str = super.a(paramQQUserUIItem);
    paramQQUserUIItem = str;
    if (str == null) {
      paramQQUserUIItem = HardCodeUtil.a(2131910735);
    }
    return paramQQUserUIItem;
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    this.c.setDisplayState(2);
    if (!TextUtils.equals((String)this.c.getTag(2131442759), paramMsgTabNodeInfo.d))
    {
      Object localObject;
      if ((paramMsgTabNodeInfo.e != null) && (paramMsgTabNodeInfo.e.size() > 0))
      {
        String str = ((MsgTabNodeVideoInfo)paramMsgTabNodeInfo.e.get(0)).c;
        Iterator localIterator = paramMsgTabNodeInfo.e.iterator();
        do
        {
          localObject = str;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (MsgTabNodeVideoInfo)localIterator.next();
        } while (((MsgTabNodeVideoInfo)localObject).b);
        localObject = ((MsgTabNodeVideoInfo)localObject).c;
      }
      else
      {
        localObject = "";
      }
      StoryReportor.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramMsgTabNodeInfo.d, "1", "", localObject });
      this.c.setTag(2131442759, paramMsgTabNodeInfo.d);
    }
  }
  
  protected void a(String paramString)
  {
    c(paramString);
  }
  
  protected void a(String paramString, boolean paramBoolean, MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if ((!TextUtils.isEmpty(paramMsgTabNodeInfo.y)) && (!paramBoolean))
    {
      this.c.setNodeName(paramString, paramMsgTabNodeInfo.y);
      return;
    }
    super.a(paramString, paramBoolean, paramMsgTabNodeInfo);
  }
  
  public void b()
  {
    this.c.setTag(2131442759, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.RecommendFollowNodeViewHolder
 * JD-Core Version:    0.7.0.1
 */