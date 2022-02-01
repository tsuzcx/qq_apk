package com.tencent.biz.qqstory.comment;

import android.os.Bundle;
import com.tencent.biz.qqstory.comment.lego.LegoResponseCallBack;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class FeedCommentLego$3
  implements LegoResponseCallBack
{
  FeedCommentLego$3(FeedCommentLego paramFeedCommentLego, int paramInt, CommentEntry paramCommentEntry) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    a(-1, HardCodeUtil.a(2131902423));
  }
  
  public void a(int paramInt, String paramString)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131902444));
    localStringBuilder.append(paramInt);
    QQToast.makeText(localBaseApplication, 1, localStringBuilder.toString(), 0).show();
    this.b.status = 0;
    this.c.g();
    if (QLog.isColorLevel()) {
      QLog.e("FeedCommentLego", 2, new Object[] { "ReqGetLikeList ErrorCode:", Integer.valueOf(paramInt), " | ErrorMsg: ", paramString });
    }
  }
  
  public void a(MessageMicro paramMessageMicro)
  {
    this.c.d.remove(this.a);
    this.c.g();
    this.c.m.d(this.b);
    StoryFailCommentCacher.a().b();
    this.c.a(false, null);
    QQToast.makeText(BaseApplication.getContext(), 2, HardCodeUtil.a(2131902445), 0).show();
    FeedCommentLego.a(this.c.h, 2, this.b.feedId, this.b.commentId);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentLego.3
 * JD-Core Version:    0.7.0.1
 */