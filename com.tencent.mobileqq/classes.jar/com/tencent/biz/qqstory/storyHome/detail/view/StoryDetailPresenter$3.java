package com.tencent.biz.qqstory.storyHome.detail.view;

import android.os.Bundle;
import com.tencent.biz.qqstory.comment.lego.LegoResponseCallBack;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.concurrent.atomic.AtomicBoolean;

class StoryDetailPresenter$3
  implements LegoResponseCallBack
{
  StoryDetailPresenter$3(StoryDetailPresenter paramStoryDetailPresenter, CommentEntry paramCommentEntry, boolean paramBoolean) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    a(-1, HardCodeUtil.a(2131911731));
  }
  
  public void a(int paramInt, String paramString)
  {
    this.a.status = 0;
    QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131911728), 0).show();
    SLog.e("Q.qqstory.detail.StoryDetailPresenter", "delete comment failed. errorCode = %d, errorMsg=%s.", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public void a(MessageMicro paramMessageMicro)
  {
    if (!StoryDetailPresenter.d(this.c).get()) {
      StoryDetailPresenter.a(this.c, this.a, this.b);
    }
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.3
 * JD-Core Version:    0.7.0.1
 */