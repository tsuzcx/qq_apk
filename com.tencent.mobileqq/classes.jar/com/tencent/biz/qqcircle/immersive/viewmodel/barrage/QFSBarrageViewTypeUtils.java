package com.tencent.biz.qqcircle.immersive.viewmodel.barrage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.viewmodel.barrage.holder.bean.QFSBarrageHolderParam;
import com.tencent.biz.qqcircle.utils.QCircleCommentHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;

public class QFSBarrageViewTypeUtils
{
  public static int a(Object paramObject)
  {
    if (!(paramObject instanceof QFSBarrageHolderParam)) {
      return 1;
    }
    paramObject = (QFSBarrageHolderParam)paramObject;
    if (a(paramObject)) {
      return 2;
    }
    if (b(paramObject)) {
      return 3;
    }
    return 1;
  }
  
  private static boolean a(@NonNull QFSBarrageHolderParam paramQFSBarrageHolderParam)
  {
    paramQFSBarrageHolderParam = paramQFSBarrageHolderParam.a();
    if (paramQFSBarrageHolderParam == null) {
      return false;
    }
    return QCircleCommentHelper.a(paramQFSBarrageHolderParam.typeFlag2.get(), 4);
  }
  
  private static boolean b(@NonNull QFSBarrageHolderParam paramQFSBarrageHolderParam)
  {
    FeedCloudMeta.StReply localStReply = paramQFSBarrageHolderParam.b();
    return (localStReply != null) && (TextUtils.equals(localStReply.id.get(), paramQFSBarrageHolderParam.c()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.viewmodel.barrage.QFSBarrageViewTypeUtils
 * JD-Core Version:    0.7.0.1
 */