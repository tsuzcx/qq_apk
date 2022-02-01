package com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;

public class RecommendActivityViewHolder
  extends BaseViewHolder
{
  public static final void b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    ThreadManager.post(new RecommendActivityViewHolder.1(paramMsgTabNodeInfo), 8, null, true);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    PlayModeUtils.b(this.b, paramMsgTabNodeInfo.k, true, (int)DisplayUtils.a(this.d.getContext(), 50.0F));
    TextView localTextView = this.d;
    if (TextUtils.isEmpty(paramMsgTabNodeInfo.l)) {
      localObject = HardCodeUtil.a(2131910744);
    } else {
      localObject = paramMsgTabNodeInfo.l;
    }
    localTextView.setText((CharSequence)localObject);
    this.c.setVisibility(8);
    this.e.setVisibility(0);
    this.f.setVisibility(0);
    int i;
    if (paramMsgTabNodeInfo.i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    a(1, i);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FollowPersonViewHolder userItem = ");
      ((StringBuilder)localObject).append(paramMsgTabNodeInfo.l);
      ((StringBuilder)localObject).append(", faceDrawable = ");
      ((StringBuilder)localObject).append(paramMsgTabNodeInfo.k);
      QLog.e("zivonchen", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (String)this.itemView.getTag(2131442759);
    if (!TextUtils.equals(paramMsgTabNodeInfo.d, (CharSequence)localObject))
    {
      i = paramMsgTabNodeInfo.b;
      if (i != 10)
      {
        if (i != 11) {
          localObject = "unknown";
        } else {
          localObject = "3";
        }
      }
      else {
        localObject = "2";
      }
      StoryReportor.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramMsgTabNodeInfo.d, localObject });
      this.itemView.setTag(2131442759, paramMsgTabNodeInfo.d);
    }
  }
  
  public void b()
  {
    this.itemView.setTag(2131442759, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.RecommendActivityViewHolder
 * JD-Core Version:    0.7.0.1
 */