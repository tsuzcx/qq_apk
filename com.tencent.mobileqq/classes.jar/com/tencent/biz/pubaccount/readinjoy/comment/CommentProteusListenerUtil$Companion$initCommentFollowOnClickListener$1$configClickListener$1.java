package com.tencent.biz.pubaccount.readinjoy.comment;

import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class CommentProteusListenerUtil$Companion$initCommentFollowOnClickListener$1$configClickListener$1
  implements ViewBase.OnClickListener
{
  CommentProteusListenerUtil$Companion$initCommentFollowOnClickListener$1$configClickListener$1(CommentViewItem paramCommentViewItem) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    this.a.b();
    if (this.a.a != null)
    {
      paramViewBase = this.a.a;
      Intrinsics.checkExpressionValueIsNotNull(paramViewBase, "commentViewItem.articleInfo");
      if (paramViewBase.getSubscribeUin() != null) {
        paramViewBase = (Long)null;
      }
    }
    try
    {
      localObject = this.a.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "commentViewItem.articleInfo");
      localObject = ((ArticleInfo)localObject).getSubscribeUin();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "(commentViewItem.articleInfo.subscribeUin)");
      long l = Long.parseLong((String)localObject);
      paramViewBase = Long.valueOf(l);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject;
        QLog.w("CommentProteusUtil", 2, "initCommentFollowOnClickListener: ", localThrowable);
      }
    }
    if (paramViewBase != null)
    {
      localObject = ReadInJoyLogicEngine.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyLogicEngine.getInstance()");
      ((ReadInJoyLogicEngine)localObject).a().a(paramViewBase.longValue(), 2);
    }
    ReadInJoyLogicEngineEventDispatcher.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.CommentProteusListenerUtil.Companion.initCommentFollowOnClickListener.1.configClickListener.1
 * JD-Core Version:    0.7.0.1
 */