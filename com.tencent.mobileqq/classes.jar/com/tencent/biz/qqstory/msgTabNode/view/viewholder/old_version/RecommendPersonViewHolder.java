package com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVideoInfo;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.Iterator;
import java.util.List;

public class RecommendPersonViewHolder
  extends FollowPersonViewHolder
{
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    this.itemView.setTag(paramMsgTabNodeInfo.d);
    this.c.setVisibility(8);
    this.e.setVisibility(0);
    this.f.setVisibility(0);
    if (!TextUtils.equals((String)this.itemView.getTag(2131442759), paramMsgTabNodeInfo.d))
    {
      Object localObject;
      if ((paramMsgTabNodeInfo.e != null) && (paramMsgTabNodeInfo.e.size() > 0))
      {
        String str = ((MsgTabNodeVideoInfo)paramMsgTabNodeInfo.e.get(0)).c;
        Iterator localIterator = paramMsgTabNodeInfo.e.iterator();
        MsgTabNodeVideoInfo localMsgTabNodeVideoInfo;
        do
        {
          localObject = str;
          if (!localIterator.hasNext()) {
            break;
          }
          localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)localIterator.next();
        } while (localMsgTabNodeVideoInfo.b);
        str = localMsgTabNodeVideoInfo.c;
        localObject = str;
        if (TextUtils.isEmpty(str))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("i");
          ((StringBuilder)localObject).append(String.valueOf(localMsgTabNodeVideoInfo.a));
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      else
      {
        localObject = "";
      }
      StoryReportor.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramMsgTabNodeInfo.d, "1", "", localObject });
      this.itemView.setTag(2131442759, paramMsgTabNodeInfo.d);
    }
  }
  
  protected String b(QQUserUIItem paramQQUserUIItem)
  {
    String str = super.b(paramQQUserUIItem);
    paramQQUserUIItem = str;
    if (str == null) {
      paramQQUserUIItem = HardCodeUtil.a(2131910745);
    }
    return paramQQUserUIItem;
  }
  
  public void b()
  {
    this.itemView.setTag(2131442759, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.RecommendPersonViewHolder
 * JD-Core Version:    0.7.0.1
 */