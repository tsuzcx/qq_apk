package com.tencent.biz.qqstory.storyHome.detail.model.cmment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.comment.StoryQQTextCacher;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.atvideo.model.AtVideoTextWatcher;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.SpannableStringUtils;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.List;
import nth;
import nti;
import ntj;
import ntl;
import ntm;
import ntq;

public class DetailCommentHelper
  implements View.OnClickListener, DetailGeneralCommentEventProxy.ActionSheetEventCallback, ntq
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private AtVideoTextWatcher jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher;
  private DetailCommentHelper.CommentHelperCallback jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$CommentHelperCallback;
  private IDetailCommentEventProxy jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentIDetailCommentEventProxy;
  private KeyboardAndEmojiManager jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  public BubbleTextView a;
  public XEditTextEx a;
  private ntm jdField_a_of_type_Ntm;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  
  public DetailCommentHelper(Context paramContext, View paramView, DetailFeedItem paramDetailFeedItem, int paramInt, DetailCommentHelper.CommentHelperCallback paramCommentHelperCallback)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramDetailFeedItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$CommentHelperCallback = paramCommentHelperCallback;
    f();
    a(paramDetailFeedItem.a());
  }
  
  public static CommentEntry a(int paramInt)
  {
    CommentEntry localCommentEntry = new CommentEntry();
    localCommentEntry.type = 1;
    localCommentEntry.content = ("查看其余" + UIUtils.a(paramInt) + "条评论");
    localCommentEntry.status = 0;
    return localCommentEntry;
  }
  
  private CommentEntry a(String paramString)
  {
    CommentEntry localCommentEntry = new CommentEntry();
    localCommentEntry.feedId = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId;
    localCommentEntry.authorUin = PlayModeUtils.a().c();
    localCommentEntry.authorUnionId = QQStoryContext.a().b();
    localCommentEntry.content = paramString;
    localCommentEntry.replyTime = (System.currentTimeMillis() / 1000L);
    localCommentEntry.status = 1;
    if (this.jdField_a_of_type_Ntm.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry != null)
    {
      localCommentEntry.replierUnionId = this.jdField_a_of_type_Ntm.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorUnionId;
      localCommentEntry.replierName = this.jdField_a_of_type_Ntm.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorName;
      localCommentEntry.replierRole = this.jdField_a_of_type_Ntm.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorRole;
    }
    if (((Integer)((StoryConfigManager)SuperManager.a(10)).b("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1) {
      localCommentEntry.authorRole = 2;
    }
    SLog.a("Q.qqstory.detail.DetailCommentHelper", "create comment entry: %s.", localCommentEntry.toString());
    return localCommentEntry;
  }
  
  public static CommentEntry a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    CommentEntry localCommentEntry = new CommentEntry();
    localCommentEntry.commentId = paramInt1;
    localCommentEntry.fakeId = paramLong;
    localCommentEntry.feedId = paramString1;
    localCommentEntry.commentType = paramInt2;
    localCommentEntry.authorUin = PlayModeUtils.a().c();
    localCommentEntry.authorUnionId = QQStoryContext.a().b();
    localCommentEntry.content = paramString2;
    localCommentEntry.replyTime = (System.currentTimeMillis() / 1000L);
    localCommentEntry.status = 0;
    if (((Integer)((StoryConfigManager)SuperManager.a(10)).b("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1) {
      localCommentEntry.authorRole = 2;
    }
    SLog.a("Q.qqstory.detail.DetailCommentHelper", "create fake vote comment entry: %s.", localCommentEntry.toString());
    return localCommentEntry;
  }
  
  private void a(List paramList)
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnEditorActionListener(new nth(this));
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) && (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId)))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher != null) {
        break label112;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher = new AtVideoTextWatcher(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, "2_", 10000, paramList);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(new nti(this));
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnFocusChangeListener(new ntj(this));
      return;
      label112:
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher.b = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher.a = paramList;
    }
  }
  
  private void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_Ntm.a(paramCommentEntry))
    {
      this.jdField_a_of_type_Ntm.a(paramCommentEntry, paramInt);
      d(false);
    }
    a(2, new String[] { paramCommentEntry.authorName, paramCommentEntry.authorUnionId, String.valueOf(paramCommentEntry.authorUin) });
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager.a(true);
    StoryQQTextCacher.a().a = "4";
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.clearFocus();
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
  }
  
  private void f()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131362823);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)this.jdField_a_of_type_AndroidViewView.findViewById(2131371502));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager = new KeyboardAndEmojiManager(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView, this);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {}
    for (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentIDetailCommentEventProxy = new DetailShareGroupCommentEventProxy(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this);; this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentIDetailCommentEventProxy = new DetailGeneralCommentEventProxy(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this))
    {
      this.jdField_a_of_type_Ntm = new ntm(this);
      if ((!(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) || (((ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner()).isPublic()) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isSubscribe())) {
        break;
      }
      a(3, new String[0]);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnClickListener(this);
      return;
    }
    a(1, new String[0]);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentIDetailCommentEventProxy.a())
    {
      StoryQQTextCacher.a().a = "1";
      a(true);
    }
    int i = StoryReportor.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {}
    for (String str = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();; str = "")
    {
      StoryReportor.a("home_page", "clk_reply", StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), StoryReportor.a(this.jdField_b_of_type_Int), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, str });
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$CommentHelperCallback.c(paramInt);
    paramInt = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (String str = "1";; str = "2")
    {
      StoryReportor.a("play_video", "del_reply", paramInt, 0, new String[] { str, StoryReportor.a(this.jdField_b_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  public void a(int paramInt, String... paramVarArgs)
  {
    boolean bool2 = false;
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint("评论");
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
      return;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint("评论");
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(true);
      return;
    } while ((paramVarArgs == null) || (paramVarArgs.length < 3));
    String str2 = paramVarArgs[0];
    String str1 = str2;
    if (android.text.TextUtils.isEmpty(str2))
    {
      boolean bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getRelationType() == 2) {
            bool1 = true;
          }
        }
      }
      str1 = null;
      if (bool1) {
        str1 = ((ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner()).ownerUnionId;
      }
      str1 = SpannableStringUtils.a(paramVarArgs[1], paramVarArgs[2], bool1, str1);
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint("回复" + str1 + "：");
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(true);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(true);
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    PlayModeUtils.a(this.jdField_a_of_type_AndroidContentContext, paramCommentEntry);
    StoryReportor.a("play_video", "report_reply", StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { "", StoryReportor.a(this.jdField_b_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt)
  {
    new Handler().postDelayed(new ntl(this, paramCommentEntry, paramInt), 500L);
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentIDetailCommentEventProxy.a(paramCommentEntry, paramInt1, paramInt2)) {
      b(paramCommentEntry, paramInt1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager.a(paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView != null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.getParent()).removeView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = null;
    }
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    paramCommentEntry.status = 1;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$CommentHelperCallback.a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$CommentHelperCallback.b(paramCommentEntry);
    paramCommentEntry = "";
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof QQUserUIItem)) {
      paramCommentEntry = ((QQUserUIItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner()).qq;
    }
    int i = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (String str = "1";; str = "2")
    {
      StoryReportor.a("play_video", "retry_reply", i, 0, new String[] { str, StoryReportor.a(this.jdField_b_of_type_Int), paramCommentEntry, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentIDetailCommentEventProxy.b(paramCommentEntry, paramInt1, paramInt2)) {
      b(paramCommentEntry, paramInt1);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      StoryQQTextCacher.a().a = "2";
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$CommentHelperCallback.e();
      return;
    }
    if (this.jdField_a_of_type_Ntm.jdField_a_of_type_Int != -1)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$CommentHelperCallback.b(this.jdField_a_of_type_Ntm.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$CommentHelperCallback.e();
  }
  
  public boolean b()
  {
    SLog.c("Q.qqstory.detail.DetailCommentHelper", "on emoji button click.");
    StoryQQTextCacher.a().a = "2";
    int i = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (String str = "1";; str = "2")
    {
      StoryReportor.a("home_page", "switch_face", i, 0, new String[] { str, StoryReportor.a(this.jdField_b_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      if (this.jdField_a_of_type_Int != 3) {
        break;
      }
      QQToast.a(BaseApplication.getContext(), 1, StoryApi.a(2131432086), 0).a();
      return true;
    }
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager.a();
  }
  
  public void c(CommentEntry paramCommentEntry)
  {
    for (;;)
    {
      try
      {
        paramCommentEntry = paramCommentEntry.content;
        if (com.tencent.mobileqq.text.TextUtils.a(paramCommentEntry))
        {
          paramCommentEntry = MessageUtils.b(paramCommentEntry);
          ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("comment content", paramCommentEntry));
          return;
        }
      }
      catch (Exception paramCommentEntry)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("Q.qqstory.detail.DetailCommentHelper", 2, paramCommentEntry.toString());
          return;
        }
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ntm.a(this.jdField_a_of_type_Ntm);
      a(1, new String[0]);
    }
  }
  
  public void d()
  {
    String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    if (str.length() > 0)
    {
      SLog.a("Q.qqstory.detail.DetailCommentHelper", "comment content is %s when click send button.", str);
      Object localObject = str;
      if (com.tencent.mobileqq.text.TextUtils.a(str)) {
        localObject = MessageUtils.a(str);
      }
      localObject = a((String)localObject);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$CommentHelperCallback.a((CommentEntry)localObject);
      d(true);
      c();
      ntm.a(this.jdField_a_of_type_Ntm);
      a(1, new String[0]);
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher != null)) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_Int != 3);
    QQToast.a(BaseApplication.getContext(), 1, StoryApi.a(2131432086), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper
 * JD-Core Version:    0.7.0.1
 */