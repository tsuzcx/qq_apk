package com.tencent.biz.qqcircle.immersive.viewmodel.barrage.holder;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.viewmodel.barrage.holder.bean.QFSBarrageHolderParam;
import com.tencent.biz.qqcircle.immersive.viewmodel.barrage.widgets.QFSGradientTextView;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;

public class QFSReplayBarrageHolder
  extends QFSBaseBarrageHolder
{
  private QFSGradientTextView b;
  
  public QFSReplayBarrageHolder(Context paramContext)
  {
    super(paramContext, 2131627118);
  }
  
  private void b(@NonNull QFSBarrageHolderParam paramQFSBarrageHolderParam)
  {
    FeedCloudMeta.StComment localStComment = paramQFSBarrageHolderParam.a();
    paramQFSBarrageHolderParam = paramQFSBarrageHolderParam.b();
    if (localStComment != null) {
      paramQFSBarrageHolderParam = a(localStComment);
    } else {
      paramQFSBarrageHolderParam = a(paramQFSBarrageHolderParam);
    }
    a(this.b, paramQFSBarrageHolderParam);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.b = ((QFSGradientTextView)paramView.findViewById(2131433335));
  }
  
  public void a(QFSBarrageHolderParam paramQFSBarrageHolderParam)
  {
    if (paramQFSBarrageHolderParam == null)
    {
      QLog.d("QDM-QFSReplayBarrageHolder", 1, "[onBindView] comment should not be null.");
      return;
    }
    b(paramQFSBarrageHolderParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.viewmodel.barrage.holder.QFSReplayBarrageHolder
 * JD-Core Version:    0.7.0.1
 */