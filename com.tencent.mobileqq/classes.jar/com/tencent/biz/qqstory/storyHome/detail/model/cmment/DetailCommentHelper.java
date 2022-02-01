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
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class DetailCommentHelper
  implements View.OnClickListener, DetailGeneralCommentEventProxy.ActionSheetEventCallback, KeyboardAndEmojiManager.KeyboardAndEmojiStateChangeListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private AtVideoTextWatcher jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher;
  private DetailCommentHelper.CommentHelperCallback jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$CommentHelperCallback;
  private DetailCommentHelper.RepliedInfo jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$RepliedInfo;
  private IDetailCommentEventProxy jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentIDetailCommentEventProxy;
  private KeyboardAndEmojiManager jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  public BubbleTextView a;
  public XEditTextEx a;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  
  public DetailCommentHelper(Context paramContext, View paramView, DetailFeedItem paramDetailFeedItem, boolean paramBoolean, int paramInt, DetailCommentHelper.CommentHelperCallback paramCommentHelperCallback)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramDetailFeedItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$CommentHelperCallback = paramCommentHelperCallback;
    this.jdField_a_of_type_Boolean = paramBoolean;
    f();
    a(paramDetailFeedItem.a());
  }
  
  public static CommentEntry a(int paramInt)
  {
    CommentEntry localCommentEntry = new CommentEntry();
    localCommentEntry.type = 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131703296));
    localStringBuilder.append(UIUtils.a(paramInt));
    localStringBuilder.append(HardCodeUtil.a(2131703295));
    localCommentEntry.content = localStringBuilder.toString();
    localCommentEntry.status = 0;
    return localCommentEntry;
  }
  
  private CommentEntry a(String paramString)
  {
    CommentEntry localCommentEntry = new CommentEntry();
    localCommentEntry.feedId = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId;
    localCommentEntry.authorUin = PlayModeUtils.a().getCurrentUin();
    localCommentEntry.authorUnionId = QQStoryContext.a().b();
    localCommentEntry.content = paramString;
    localCommentEntry.replyTime = (System.currentTimeMillis() / 1000L);
    localCommentEntry.status = 1;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$RepliedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry != null)
    {
      localCommentEntry.replierUnionId = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$RepliedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorUnionId;
      localCommentEntry.replierName = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$RepliedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorName;
      localCommentEntry.replierRole = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$RepliedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorRole;
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
    localCommentEntry.authorUin = PlayModeUtils.a().getCurrentUin();
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
  
  public static CommentEntry a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramString1 = a(paramString1, paramInt, paramLong, 4, paramString2);
    paramString1.putExtra("vid", paramString3);
    paramString1.putExtra("feedid", paramString4);
    paramString1.putExtra("pvid", paramString5);
    try
    {
      paramString1.putExtra("styles", new JSONArray(paramString6));
      return paramString1;
    }
    catch (JSONException paramString2)
    {
      label55:
      break label55;
    }
    SLog.e("Q.qqstory.detail.DetailCommentHelper", "createGamePKCommentEntry styles error. styles=%s", new Object[] { paramString6 });
    return paramString1;
  }
  
  private void a(List<StoryVideoItem> paramList)
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnEditorActionListener(new DetailCommentHelper.1(this));
    if (this.jdField_a_of_type_Boolean)
    {
      CommentLikeFeedItem localCommentLikeFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
      if ((localCommentLikeFeedItem != null) && (!android.text.TextUtils.isEmpty(localCommentLikeFeedItem.feedId)))
      {
        boolean bool;
        if ((paramList != null) && (paramList.size() > 1)) {
          bool = true;
        } else {
          bool = false;
        }
        paramList = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher;
        if (paramList == null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher = new AtVideoTextWatcher(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, "2_", 10000, bool);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher);
        }
        else
        {
          paramList.b = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId;
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher.jdField_a_of_type_Boolean = bool;
        }
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(new DetailCommentHelper.2(this));
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnFocusChangeListener(new DetailCommentHelper.3(this));
    }
  }
  
  private void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$RepliedInfo.a(paramCommentEntry))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$RepliedInfo.a(paramCommentEntry, paramInt);
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
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365132);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)this.jdField_a_of_type_AndroidViewView.findViewById(2131366317));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager = new KeyboardAndEmojiManager(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView, this);
    CommentLikeFeedItem localCommentLikeFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    if ((localCommentLikeFeedItem != null) && ((localCommentLikeFeedItem.getOwner() instanceof ShareGroupItem))) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentIDetailCommentEventProxy = new DetailShareGroupCommentEventProxy(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this);
    } else {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentIDetailCommentEventProxy = new DetailGeneralCommentEventProxy(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$RepliedInfo = new DetailCommentHelper.RepliedInfo(this);
    localCommentLikeFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    if ((localCommentLikeFeedItem != null) && ((localCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) && (!((ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner()).isPublic()) && (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isSubscribe()))
    {
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
    String str;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {
      str = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();
    } else {
      str = "";
    }
    StoryReportor.a("home_page", "clk_reply", StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), StoryReportor.a(this.jdField_b_of_type_Int), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, str });
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$CommentHelperCallback.b(paramInt);
    paramInt = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    String str;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
      str = "1";
    } else {
      str = "2";
    }
    StoryReportor.a("play_video", "del_reply", paramInt, 0, new String[] { str, StoryReportor.a(this.jdField_b_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
  }
  
  public void a(int paramInt, String... paramVarArgs)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt != 1)
    {
      boolean bool2 = false;
      if (paramInt != 2)
      {
        if (paramInt == 3)
        {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(HardCodeUtil.a(2131703293));
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
        }
      }
      else if ((paramVarArgs != null) && (paramVarArgs.length >= 3))
      {
        Object localObject2 = paramVarArgs[0];
        Object localObject1 = localObject2;
        if (android.text.TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
          boolean bool1 = bool2;
          if (localObject1 != null)
          {
            bool1 = bool2;
            if (((CommentLikeFeedItem)localObject1).getOwner() != null)
            {
              bool1 = bool2;
              if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getRelationType() == 2) {
                bool1 = true;
              }
            }
          }
          localObject1 = null;
          if (bool1) {
            localObject1 = ((ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner()).ownerUnionId;
          }
          localObject1 = SpannableStringUtils.a(paramVarArgs[1], paramVarArgs[2], bool1, (String)localObject1);
        }
        paramVarArgs = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131703294));
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("：");
        paramVarArgs.setHint(((StringBuilder)localObject2).toString());
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(true);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(true);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(HardCodeUtil.a(2131703297));
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(true);
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestLayout();
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    PlayModeUtils.a(this.jdField_a_of_type_AndroidContentContext, paramCommentEntry);
    StoryReportor.a("play_video", "report_reply", StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { "", StoryReportor.a(this.jdField_b_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt)
  {
    new Handler().postDelayed(new DetailCommentHelper.4(this, paramCommentEntry, paramInt), 500L);
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
    BubbleTextView localBubbleTextView = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
    if (localBubbleTextView != null)
    {
      if (localBubbleTextView.getParent() != null) {
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
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof QQUserUIItem)) {
      paramCommentEntry = ((QQUserUIItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner()).qq;
    } else {
      paramCommentEntry = "";
    }
    int i = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    String str;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
      str = "1";
    } else {
      str = "2";
    }
    StoryReportor.a("play_video", "retry_reply", i, 0, new String[] { str, StoryReportor.a(this.jdField_b_of_type_Int), paramCommentEntry, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentIDetailCommentEventProxy.b(paramCommentEntry, paramInt1, paramInt2)) {
      b(paramCommentEntry, paramInt1);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$CommentHelperCallback.c();
    if (!paramBoolean)
    {
      StoryQQTextCacher.a().a = "2";
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$CommentHelperCallback.K_();
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$RepliedInfo.jdField_a_of_type_Int != -1)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$CommentHelperCallback.e_(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$RepliedInfo.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$CommentHelperCallback.K_();
  }
  
  public boolean b()
  {
    SLog.c("Q.qqstory.detail.DetailCommentHelper", "on emoji button click.");
    StoryQQTextCacher localStoryQQTextCacher = StoryQQTextCacher.a();
    String str = "2";
    localStoryQQTextCacher.a = "2";
    int i = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
      str = "1";
    }
    StoryReportor.a("home_page", "switch_face", i, 0, new String[] { str, StoryReportor.a(this.jdField_b_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
    if (this.jdField_a_of_type_Int == 3)
    {
      QQToast.a(BaseApplication.getContext(), 1, StoryApi.a(2131699909), 0).a();
      return true;
    }
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager.b();
  }
  
  public void c(CommentEntry paramCommentEntry)
  {
    for (;;)
    {
      try
      {
        Object localObject = paramCommentEntry.content;
        paramCommentEntry = (CommentEntry)localObject;
        if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion((String)localObject)) {
          paramCommentEntry = EmotionCodecUtils.b((String)localObject);
        }
        localObject = (ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard");
        paramCommentEntry = ClipData.newPlainText("comment content", paramCommentEntry);
        ClipboardMonitor.setPrimaryClip((ClipboardManager)localObject, paramCommentEntry);
        ((ClipboardManager)localObject).setPrimaryClip(paramCommentEntry);
        int i = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
        {
          paramCommentEntry = "2";
          StoryReportor.a("home_page", "copy_reply", i, 0, new String[] { paramCommentEntry, StoryReportor.a(this.jdField_b_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
          return;
        }
      }
      catch (Exception paramCommentEntry)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.detail.DetailCommentHelper", 2, paramCommentEntry.toString());
        }
        return;
      }
      paramCommentEntry = "1";
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$CommentHelperCallback.d();
      DetailCommentHelper.RepliedInfo.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$RepliedInfo);
      a(1, new String[0]);
    }
  }
  
  public void d()
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131703298), 0).a();
      return;
    }
    String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    if (str.length() > 0)
    {
      SLog.a("Q.qqstory.detail.DetailCommentHelper", "comment content is %s when click send button.", str);
      Object localObject = str;
      if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(str)) {
        localObject = EmotionCodecUtils.a(str);
      }
      localObject = a((String)localObject);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$CommentHelperCallback.a((CommentEntry)localObject);
      d(true);
      c();
      DetailCommentHelper.RepliedInfo.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper$RepliedInfo);
      a(1, new String[0]);
    }
  }
  
  public void e()
  {
    XEditTextEx localXEditTextEx = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
    if (localXEditTextEx != null)
    {
      AtVideoTextWatcher localAtVideoTextWatcher = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher;
      if (localAtVideoTextWatcher != null) {
        localXEditTextEx.removeTextChangedListener(localAtVideoTextWatcher);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131366317) && (this.jdField_a_of_type_Int == 3)) {
      QQToast.a(BaseApplication.getContext(), 1, StoryApi.a(2131699909), 0).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper
 * JD-Core Version:    0.7.0.1
 */