package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.os.Bundle;
import com.tencent.biz.qqstory.comment.lego.LegoResponseCallBack;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class CommentFloatDialog$OnCommentHelperCallback$2
  implements LegoResponseCallBack
{
  CommentFloatDialog$OnCommentHelperCallback$2(CommentFloatDialog.OnCommentHelperCallback paramOnCommentHelperCallback, CommentEntry paramCommentEntry, boolean paramBoolean) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    a(-1, HardCodeUtil.a(2131900370));
  }
  
  public void a(int paramInt, String paramString)
  {
    this.a.status = 0;
    QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131900367), 0).show();
    SLog.e("Q.qqstory.player.CommentFloatDialog", "delete comment failed. errorCode = %d, errorMsg=%s.", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public void a(MessageMicro paramMessageMicro)
  {
    if (!CommentFloatDialog.j(this.c.a)) {
      CommentFloatDialog.i(this.c.a).a(this.a, this.b);
    }
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.OnCommentHelperCallback.2
 * JD-Core Version:    0.7.0.1
 */