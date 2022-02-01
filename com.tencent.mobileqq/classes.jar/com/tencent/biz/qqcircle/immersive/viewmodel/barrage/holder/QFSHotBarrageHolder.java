package com.tencent.biz.qqcircle.immersive.viewmodel.barrage.holder;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.viewmodel.barrage.holder.bean.QFSBarrageHolderParam;
import com.tencent.biz.qqcircle.immersive.viewmodel.barrage.widgets.QFSGradientTextView;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;

public class QFSHotBarrageHolder
  extends QFSBaseBarrageHolder
{
  private QFSGradientTextView b;
  
  public QFSHotBarrageHolder(Context paramContext)
  {
    super(paramContext, 2131627116);
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
    this.b = ((QFSGradientTextView)paramView.findViewById(2131433333));
  }
  
  public void a(QFSBarrageHolderParam paramQFSBarrageHolderParam)
  {
    if (paramQFSBarrageHolderParam == null)
    {
      QLog.d("DM-FSHotBarrageHolder", 1, "[onBindView] param should not be null.");
      return;
    }
    b(paramQFSBarrageHolderParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.viewmodel.barrage.holder.QFSHotBarrageHolder
 * JD-Core Version:    0.7.0.1
 */