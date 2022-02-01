package com.tencent.biz.qqcircle.immersive.viewmodel.barrage.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqcircle.immersive.viewmodel.barrage.holder.bean.QFSBarrageHolderParam;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfw.barrage.render.RFWViewBarrageRender.ViewHolder;
import com.tencent.richframework.text.rich.parser.RichTextAtParser;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;

public abstract class QFSBaseBarrageHolder
  extends RFWViewBarrageRender.ViewHolder
{
  public QFSBaseBarrageHolder(Context paramContext, int paramInt)
  {
    super(a(paramContext, paramInt));
    a(this.a);
  }
  
  private static View a(Context paramContext, int paramInt)
  {
    return LayoutInflater.from(paramContext).inflate(paramInt, null);
  }
  
  protected String a(FeedCloudMeta.StComment paramStComment)
  {
    if (paramStComment == null) {
      return null;
    }
    return paramStComment.content.get();
  }
  
  protected String a(FeedCloudMeta.StReply paramStReply)
  {
    if (paramStReply == null) {
      return null;
    }
    return paramStReply.content.get();
  }
  
  public abstract void a(View paramView);
  
  protected void a(TextView paramTextView, String paramString)
  {
    if (paramTextView == null)
    {
      QLog.d("DM-FSBaseBarrageHolder", 1, "[setViewText] view should not is null.");
      return;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramTextView.setText(RichTextAtParser.a(str));
  }
  
  public abstract void a(QFSBarrageHolderParam paramQFSBarrageHolderParam);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.viewmodel.barrage.holder.QFSBaseBarrageHolder
 * JD-Core Version:    0.7.0.1
 */