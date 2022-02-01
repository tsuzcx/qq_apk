package com.tencent.biz.qqstory.comment;

import android.os.Bundle;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.comment.lego.LegoResponseCallBack;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAddFeedComment;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tribe.async.dispatch.Dispatcher;

final class FeedCommentDataProvider$1
  implements LegoResponseCallBack
{
  public void a(int paramInt, Bundle paramBundle)
  {
    SLog.e("Q.qqstory:FeedCommentDataProvider", "onNetError. errorCode=&d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void a(int paramInt, String paramString)
  {
    SLog.e("Q.qqstory:FeedCommentDataProvider", "onErrorInfo. errorCode=&d, errorMsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public void a(MessageMicro paramMessageMicro)
  {
    paramMessageMicro = (qqstory_service.RspAddFeedComment)paramMessageMicro;
    GamePKCommentEvent localGamePKCommentEvent = new GamePKCommentEvent();
    localGamePKCommentEvent.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localGamePKCommentEvent.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    localGamePKCommentEvent.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localGamePKCommentEvent.jdField_a_of_type_Int = paramMessageMicro.comment_id.get();
    localGamePKCommentEvent.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localGamePKCommentEvent.c = this.c;
    localGamePKCommentEvent.d = this.d;
    localGamePKCommentEvent.e = this.e;
    localGamePKCommentEvent.f = this.f;
    StoryDispatcher.a().dispatch(localGamePKCommentEvent);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      paramBundle = "true";
    } else {
      paramBundle = "false";
    }
    SLog.e("Q.qqstory:FeedCommentDataProvider", "onComplete. isSuccess=%s", new Object[] { paramBundle });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentDataProvider.1
 * JD-Core Version:    0.7.0.1
 */