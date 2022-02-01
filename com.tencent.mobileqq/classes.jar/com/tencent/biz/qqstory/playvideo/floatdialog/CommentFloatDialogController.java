package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.DetailFeedPushObserver;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedCommentSync;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.lang.ref.WeakReference;

public class CommentFloatDialogController
  implements IEventReceiver
{
  private int jdField_a_of_type_Int = -1;
  private CommentManager jdField_a_of_type_ComTencentBizQqstoryModelCommentManager = (CommentManager)SuperManager.a(17);
  private CommentFloatDialogController.CommentListReceiver jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController$CommentListReceiver;
  private CommentFloatDialogController.FeedInfoUpdateReceiver jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController$FeedInfoUpdateReceiver;
  private CommentFloatDialogController.GetUserInfoReceiver jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController$GetUserInfoReceiver;
  private CommentListPageLoader jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader;
  private DetailFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem = new DetailFeedItem();
  private StoryDetailPresenter.DetailFeedPushObserver jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$DetailFeedPushObserver;
  private FeedManager jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager = (FeedManager)SuperManager.a(11);
  private Stream<DetailFeedItem> jdField_a_of_type_ComTribeAsyncReactiveStream;
  public CharSequence a;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<CommentFloatDialogController.OnDataChangeListener> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  private CommentListPageLoader b;
  
  private void a(DetailFeedItem paramDetailFeedItem)
  {
    if (paramDetailFeedItem == null) {}
    label39:
    do
    {
      do
      {
        return;
        if (!paramDetailFeedItem.a()) {
          break label39;
        }
        if (!paramDetailFeedItem.b()) {
          break;
        }
      } while (this.jdField_a_of_type_Int != -1);
      this.jdField_a_of_type_Int = 1;
      return;
      this.jdField_a_of_type_Int = 1;
      return;
    } while (this.jdField_a_of_type_Int == -1);
    this.jdField_a_of_type_Int = -1;
  }
  
  private void a(@NonNull DetailFeedItem paramDetailFeedItem, ErrorMessage paramErrorMessage, boolean paramBoolean)
  {
    Object localObject;
    if (paramErrorMessage.isSuccess())
    {
      localObject = "suc";
      if (!paramBoolean) {
        break label120;
      }
    }
    label120:
    for (String str = "updated";; str = "not updated")
    {
      SLog.d("Q.qqstory.player.CommentFloatDialogController", "onFeedItemBack: %s , %s , %s", new Object[] { localObject, str, paramDetailFeedItem });
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem = paramDetailFeedItem;
        a(paramDetailFeedItem);
        c();
        e();
        if (paramBoolean)
        {
          this.b.a(null, 0);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader.a(null, 0);
        }
      }
      localObject = a();
      if (localObject != null) {
        ((CommentFloatDialogController.OnDataChangeListener)localObject).a(paramDetailFeedItem, paramErrorMessage, paramBoolean);
      }
      return;
      localObject = "fail";
      break;
    }
  }
  
  private void d()
  {
    SLog.d("Q.qqstory.player.CommentFloatDialogController", "onCreate");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem = new DetailFeedItem();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController$CommentListReceiver = new CommentFloatDialogController.CommentListReceiver(this);
    StoryDispatcher.a().registerSubscriber("CommentFloatDialogController", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController$CommentListReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController$GetUserInfoReceiver = new CommentFloatDialogController.GetUserInfoReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController$GetUserInfoReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController$FeedInfoUpdateReceiver = new CommentFloatDialogController.FeedInfoUpdateReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController$FeedInfoUpdateReceiver);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$DetailFeedPushObserver == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$DetailFeedPushObserver = new StoryDetailPresenter.DetailFeedPushObserver(this.jdField_a_of_type_JavaLangString, new CommentFloatDialogController.1(this));
      QQStoryContext.a();
      QQStoryContext.a().addObserver(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$DetailFeedPushObserver);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$DetailFeedPushObserver.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public CommentFloatDialogController.OnDataChangeListener a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (CommentFloatDialogController.OnDataChangeListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public DetailFeedItem a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem;
  }
  
  public void a()
  {
    SLog.d("Q.qqstory.player.CommentFloatDialogController", "destroy");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem = new DetailFeedItem();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController$CommentListReceiver != null) {
      StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController$CommentListReceiver);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController$GetUserInfoReceiver != null) {
      StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController$GetUserInfoReceiver);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController$FeedInfoUpdateReceiver != null) {
      StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController$FeedInfoUpdateReceiver);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$DetailFeedPushObserver != null)
    {
      QQStoryContext.a();
      QQStoryContext.a().removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter$DetailFeedPushObserver);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem, new ErrorMessage(), false);
    }
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.b(paramCommentEntry, paramBoolean);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a = ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a));
    this.jdField_a_of_type_ComTencentBizQqstoryModelCommentManager.d(paramCommentEntry);
    a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem);
  }
  
  public void a(CommentFloatDialogController.OnDataChangeListener paramOnDataChangeListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnDataChangeListener);
  }
  
  public void a(@NonNull String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      d();
    }
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString))
    {
      this.jdField_a_of_type_JavaLangCharSequence = null;
      if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null) {
        this.jdField_a_of_type_ComTribeAsyncReactiveStream.cancel();
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem = new DetailFeedItem();
      c();
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b.c();
    }
    for (;;)
    {
      StoryReportor.a("home_page", "load_detail", 0, 0, new String[] { "", StoryReportor.a(4444), "", this.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader.c();
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == -1) || (this.jdField_a_of_type_Int == 2);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null) {
      this.jdField_a_of_type_ComTribeAsyncReactiveStream.cancel();
    }
    this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(this.jdField_a_of_type_JavaLangString).map(new ThreadOffFunction("Q.qqstory.player.CommentFloatDialogController", 2)).map(new CommentFloatDialogController.GetFeedItemSegment(this)).map(new CommentFloatDialogController.GetCachedCommentListSegment(this)).map(new UIThreadOffFunction(null));
    this.jdField_a_of_type_ComTribeAsyncReactiveStream.subscribe(new CommentFloatDialogController.GetDetailFeedItemObserver(this));
    SLog.d("Q.qqstory.player.CommentFloatDialogController", "start to sync %s", new Object[] { this.jdField_a_of_type_JavaLangString });
  }
  
  public void c()
  {
    SLog.a("Q.qqstory.player.CommentFloatDialogController", "resetCommentPageLoader :%s", this.jdField_a_of_type_JavaLangString);
    if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a())
    {
      this.b = new CommentListPageLoader(new FeedCommentSync(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(true)), "CommentFloatDialogController");
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader = new CommentListPageLoader(new FeedCommentSync(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(false), 0), "CommentFloatDialogController");
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader = new CommentListPageLoader(new FeedCommentSync(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(false), 1), "CommentFloatDialogController");
    this.b = new CommentListPageLoader(new FeedCommentSync(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(true), 0), "CommentFloatDialogController");
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialogController
 * JD-Core Version:    0.7.0.1
 */