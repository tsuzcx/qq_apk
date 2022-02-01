package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.GetFeedCommentEvent;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;

class CommentFloatDialogController$CommentListReceiver
  extends UIBaseEventReceiver<CommentFloatDialogController, CommentListPageLoader.GetFeedCommentEvent>
{
  CommentFloatDialogController$CommentListReceiver(CommentFloatDialogController paramCommentFloatDialogController)
  {
    super(paramCommentFloatDialogController);
  }
  
  public void a(@NonNull CommentFloatDialogController paramCommentFloatDialogController, @NonNull CommentListPageLoader.GetFeedCommentEvent paramGetFeedCommentEvent)
  {
    if ((paramGetFeedCommentEvent.jdField_a_of_type_JavaLangString.equals(CommentFloatDialogController.a(paramCommentFloatDialogController))) && (!paramGetFeedCommentEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) && (CommentFloatDialogController.a(paramCommentFloatDialogController) != null))
    {
      SLog.a("Q.qqstory.player.CommentFloatDialogController", "receive comment list event. %s.", paramGetFeedCommentEvent.toString());
      boolean bool2 = paramCommentFloatDialogController.a();
      boolean bool1 = true;
      if (paramGetFeedCommentEvent.jdField_a_of_type_Int == 0) {
        bool1 = false;
      }
      CommentFloatDialogController.a(paramCommentFloatDialogController).a(bool1);
      CommentFloatDialogController.a(paramCommentFloatDialogController).a(bool1, paramGetFeedCommentEvent.b);
      CommentFloatDialogController.a(paramCommentFloatDialogController).a(bool1, paramGetFeedCommentEvent.jdField_a_of_type_Boolean);
      CommentFloatDialogController.a(paramCommentFloatDialogController).a(paramGetFeedCommentEvent.jdField_a_of_type_JavaUtilList, paramGetFeedCommentEvent.c, bool1);
      if (bool2 == bool1)
      {
        CommentFloatDialogController.OnDataChangeListener localOnDataChangeListener = paramCommentFloatDialogController.a();
        if (localOnDataChangeListener != null) {
          localOnDataChangeListener.a(CommentFloatDialogController.a(paramCommentFloatDialogController), paramGetFeedCommentEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
        }
      }
      return;
    }
    SLog.b("Q.qqstory.player.CommentFloatDialogController", "ignore this comment list event. %s.", paramGetFeedCommentEvent.toString());
  }
  
  public Class acceptEventClass()
  {
    return CommentListPageLoader.GetFeedCommentEvent.class;
  }
  
  public void b(@NonNull CommentFloatDialogController paramCommentFloatDialogController, @NonNull CommentListPageLoader.GetFeedCommentEvent paramGetFeedCommentEvent)
  {
    boolean bool2 = paramCommentFloatDialogController.a();
    boolean bool1;
    if (paramGetFeedCommentEvent.jdField_a_of_type_Int == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if (bool2 == bool1)
    {
      paramGetFeedCommentEvent = paramCommentFloatDialogController.a();
      if (paramGetFeedCommentEvent != null) {
        paramGetFeedCommentEvent.a(CommentFloatDialogController.a(paramCommentFloatDialogController), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialogController.CommentListReceiver
 * JD-Core Version:    0.7.0.1
 */