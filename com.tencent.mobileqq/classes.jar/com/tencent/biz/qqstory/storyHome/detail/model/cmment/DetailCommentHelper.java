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
  public XEditTextEx a;
  public BubbleTextView b;
  private int c;
  private Context d;
  private CommentLikeFeedItem e;
  private int f;
  private DetailCommentHelper.CommentHelperCallback g;
  private View h;
  private View i;
  private IDetailCommentEventProxy j;
  private KeyboardAndEmojiManager k;
  private AtVideoTextWatcher l;
  private boolean m = true;
  private boolean n;
  private DetailCommentHelper.RepliedInfo o;
  
  public DetailCommentHelper(Context paramContext, View paramView, DetailFeedItem paramDetailFeedItem, boolean paramBoolean, int paramInt, DetailCommentHelper.CommentHelperCallback paramCommentHelperCallback)
  {
    this.d = paramContext;
    this.h = paramView;
    this.e = paramDetailFeedItem.a;
    this.f = paramInt;
    this.g = paramCommentHelperCallback;
    this.m = paramBoolean;
    h();
    a(paramDetailFeedItem.a());
  }
  
  public static CommentEntry a(int paramInt)
  {
    CommentEntry localCommentEntry = new CommentEntry();
    localCommentEntry.type = 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131901257));
    localStringBuilder.append(UIUtils.a(paramInt));
    localStringBuilder.append(HardCodeUtil.a(2131901256));
    localCommentEntry.content = localStringBuilder.toString();
    localCommentEntry.status = 0;
    return localCommentEntry;
  }
  
  private CommentEntry a(String paramString)
  {
    CommentEntry localCommentEntry = new CommentEntry();
    localCommentEntry.feedId = this.e.feedId;
    localCommentEntry.authorUin = PlayModeUtils.b().getCurrentUin();
    localCommentEntry.authorUnionId = QQStoryContext.a().i();
    localCommentEntry.content = paramString;
    localCommentEntry.replyTime = (System.currentTimeMillis() / 1000L);
    localCommentEntry.status = 1;
    if (this.o.a != null)
    {
      localCommentEntry.replierUnionId = this.o.a.authorUnionId;
      localCommentEntry.replierName = this.o.a.authorName;
      localCommentEntry.replierRole = this.o.a.authorRole;
    }
    if (((Integer)((StoryConfigManager)SuperManager.a(10)).c("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1) {
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
    localCommentEntry.authorUin = PlayModeUtils.b().getCurrentUin();
    localCommentEntry.authorUnionId = QQStoryContext.a().i();
    localCommentEntry.content = paramString2;
    localCommentEntry.replyTime = (System.currentTimeMillis() / 1000L);
    localCommentEntry.status = 0;
    if (((Integer)((StoryConfigManager)SuperManager.a(10)).c("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1) {
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
    this.a.setOnEditorActionListener(new DetailCommentHelper.1(this));
    if (this.m)
    {
      CommentLikeFeedItem localCommentLikeFeedItem = this.e;
      if ((localCommentLikeFeedItem != null) && (!android.text.TextUtils.isEmpty(localCommentLikeFeedItem.feedId)))
      {
        boolean bool;
        if ((paramList != null) && (paramList.size() > 1)) {
          bool = true;
        } else {
          bool = false;
        }
        paramList = this.l;
        if (paramList == null)
        {
          this.l = new AtVideoTextWatcher(this.d, this.e.feedId, "2_", 10000, bool);
          this.a.addTextChangedListener(this.l);
        }
        else
        {
          paramList.b = this.e.feedId;
          this.l.e = bool;
        }
      }
      this.a.setOnTouchListener(new DetailCommentHelper.2(this));
      this.a.setOnFocusChangeListener(new DetailCommentHelper.3(this));
    }
  }
  
  private void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.o.a(paramCommentEntry))
    {
      this.o.a(paramCommentEntry, paramInt);
      d(false);
    }
    a(2, new String[] { paramCommentEntry.authorName, paramCommentEntry.authorUnionId, String.valueOf(paramCommentEntry.authorUin) });
    this.k.a(true);
    StoryQQTextCacher.a().a = "4";
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.clearFocus();
    }
    this.a.setText("");
  }
  
  private void h()
  {
    this.i = this.h.findViewById(2131431280);
    this.a = ((XEditTextEx)this.h.findViewById(2131432617));
    this.k = new KeyboardAndEmojiManager(this.d, this.h, this);
    CommentLikeFeedItem localCommentLikeFeedItem = this.e;
    if ((localCommentLikeFeedItem != null) && ((localCommentLikeFeedItem.getOwner() instanceof ShareGroupItem))) {
      this.j = new DetailShareGroupCommentEventProxy(this.d, this.f, this.e, this);
    } else {
      this.j = new DetailGeneralCommentEventProxy(this.d, this.f, this.e, this);
    }
    this.o = new DetailCommentHelper.RepliedInfo(this);
    localCommentLikeFeedItem = this.e;
    if ((localCommentLikeFeedItem != null) && ((localCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) && (!((ShareGroupItem)this.e.getOwner()).isPublic()) && (!this.e.getOwner().isSubscribe()))
    {
      a(3, new String[0]);
      this.a.setOnClickListener(this);
      return;
    }
    a(1, new String[0]);
  }
  
  public void a()
  {
    if (this.j.a())
    {
      StoryQQTextCacher.a().a = "1";
      a(true);
    }
    int i1 = StoryReportor.b(this.e);
    String str;
    if ((this.e.getOwner() instanceof ShareGroupItem)) {
      str = this.e.getOwner().getUnionId();
    } else {
      str = "";
    }
    StoryReportor.a("home_page", "clk_reply", StoryReportor.a(this.e), 0, new String[] { String.valueOf(i1), StoryReportor.b(this.f), this.e.feedId, str });
  }
  
  public void a(int paramInt, String... paramVarArgs)
  {
    this.c = paramInt;
    if (paramInt != 1)
    {
      boolean bool2 = false;
      if (paramInt != 2)
      {
        if (paramInt == 3)
        {
          this.a.setHint(HardCodeUtil.a(2131901254));
          this.a.setEnabled(true);
          this.a.setFocusable(false);
          this.a.setFocusableInTouchMode(false);
        }
      }
      else if ((paramVarArgs != null) && (paramVarArgs.length >= 3))
      {
        Object localObject2 = paramVarArgs[0];
        Object localObject1 = localObject2;
        if (android.text.TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = this.e;
          boolean bool1 = bool2;
          if (localObject1 != null)
          {
            bool1 = bool2;
            if (((CommentLikeFeedItem)localObject1).getOwner() != null)
            {
              bool1 = bool2;
              if (this.e.getOwner().getRelationType() == 2) {
                bool1 = true;
              }
            }
          }
          localObject1 = null;
          if (bool1) {
            localObject1 = ((ShareGroupItem)this.e.getOwner()).ownerUnionId;
          }
          localObject1 = SpannableStringUtils.a(paramVarArgs[1], paramVarArgs[2], bool1, (String)localObject1);
        }
        paramVarArgs = this.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131901255));
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("：");
        paramVarArgs.setHint(((StringBuilder)localObject2).toString());
        this.a.setEnabled(true);
        this.a.setFocusable(true);
        this.a.setFocusableInTouchMode(true);
      }
    }
    else
    {
      this.a.setHint(HardCodeUtil.a(2131901258));
      this.a.setEnabled(true);
      this.a.setFocusable(true);
      this.a.setFocusableInTouchMode(true);
    }
    this.a.requestLayout();
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    PlayModeUtils.a(this.d, paramCommentEntry);
    StoryReportor.a("play_video", "report_reply", StoryReportor.a(this.e), 0, new String[] { "", StoryReportor.b(this.f), "", this.e.feedId });
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt)
  {
    new Handler().postDelayed(new DetailCommentHelper.4(this, paramCommentEntry, paramInt), 500L);
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (this.j.a(paramCommentEntry, paramInt1, paramInt2)) {
      b(paramCommentEntry, paramInt1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.k.a(paramBoolean);
  }
  
  public void b()
  {
    BubbleTextView localBubbleTextView = this.b;
    if (localBubbleTextView != null)
    {
      if (localBubbleTextView.getParent() != null) {
        ((ViewGroup)this.b.getParent()).removeView(this.b);
      }
      this.b = null;
    }
  }
  
  public void b(int paramInt)
  {
    this.g.b(paramInt);
    paramInt = StoryReportor.a(this.e);
    String str;
    if (this.e.getOwner().isMe()) {
      str = "1";
    } else {
      str = "2";
    }
    StoryReportor.a("play_video", "del_reply", paramInt, 0, new String[] { str, StoryReportor.b(this.f), "", this.e.feedId });
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    paramCommentEntry.status = 1;
    this.g.a();
    this.g.b(paramCommentEntry);
    if ((this.e.getOwner() instanceof QQUserUIItem)) {
      paramCommentEntry = ((QQUserUIItem)this.e.getOwner()).qq;
    } else {
      paramCommentEntry = "";
    }
    int i1 = StoryReportor.a(this.e);
    String str;
    if (this.e.getOwner().isMe()) {
      str = "1";
    } else {
      str = "2";
    }
    StoryReportor.a("play_video", "retry_reply", i1, 0, new String[] { str, StoryReportor.b(this.f), paramCommentEntry, this.e.feedId });
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (this.j.b(paramCommentEntry, paramInt1, paramInt2)) {
      b(paramCommentEntry, paramInt1);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.g.c();
    if (!paramBoolean)
    {
      StoryQQTextCacher.a().a = "2";
      this.g.bq_();
      return;
    }
    if (this.o.b != -1)
    {
      this.g.a(this.o.b);
      return;
    }
    this.g.bq_();
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
          paramCommentEntry = EmotionCodecUtils.c((String)localObject);
        }
        localObject = (ClipboardManager)this.d.getSystemService("clipboard");
        paramCommentEntry = ClipData.newPlainText("comment content", paramCommentEntry);
        ClipboardMonitor.setPrimaryClip((ClipboardManager)localObject, paramCommentEntry);
        ((ClipboardManager)localObject).setPrimaryClip(paramCommentEntry);
        int i1 = StoryReportor.a(this.e);
        if (this.e.getOwner().isMe())
        {
          paramCommentEntry = "2";
          StoryReportor.a("home_page", "copy_reply", i1, 0, new String[] { paramCommentEntry, StoryReportor.b(this.f), "", this.e.feedId });
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
      this.g.d();
      DetailCommentHelper.RepliedInfo.a(this.o);
      a(1, new String[0]);
    }
  }
  
  public boolean c()
  {
    return this.k.c();
  }
  
  public void d()
  {
    this.k.b();
  }
  
  public boolean e()
  {
    SLog.c("Q.qqstory.detail.DetailCommentHelper", "on emoji button click.");
    StoryQQTextCacher localStoryQQTextCacher = StoryQQTextCacher.a();
    String str = "2";
    localStoryQQTextCacher.a = "2";
    int i1 = StoryReportor.a(this.e);
    if (this.e.getOwner().isMe()) {
      str = "1";
    }
    StoryReportor.a("home_page", "switch_face", i1, 0, new String[] { str, StoryReportor.b(this.f), "", this.e.feedId });
    if (this.c == 3)
    {
      QQToast.makeText(BaseApplication.getContext(), 1, StoryApi.b(2131897962), 0).show();
      return true;
    }
    return false;
  }
  
  public void f()
  {
    if (!NetworkUtil.isNetSupport(this.d))
    {
      QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131901259), 0).show();
      return;
    }
    String str = this.a.getText().toString();
    if (str.length() > 0)
    {
      SLog.a("Q.qqstory.detail.DetailCommentHelper", "comment content is %s when click send button.", str);
      Object localObject = str;
      if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(str)) {
        localObject = EmotionCodecUtils.a(str);
      }
      localObject = a((String)localObject);
      this.g.a((CommentEntry)localObject);
      d(true);
      d();
      DetailCommentHelper.RepliedInfo.a(this.o);
      a(1, new String[0]);
    }
  }
  
  public void g()
  {
    XEditTextEx localXEditTextEx = this.a;
    if (localXEditTextEx != null)
    {
      AtVideoTextWatcher localAtVideoTextWatcher = this.l;
      if (localAtVideoTextWatcher != null) {
        localXEditTextEx.removeTextChangedListener(localAtVideoTextWatcher);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131432617) && (this.c == 3)) {
      QQToast.makeText(BaseApplication.getContext(), 1, StoryApi.b(2131897962), 0).show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper
 * JD-Core Version:    0.7.0.1
 */