package com.tencent.biz.qqstory.comment;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.atvideo.model.AtVideoTextWatcher;
import com.tencent.biz.qqstory.storyHome.detail.model.SpannableStringUtils;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.InputViewHideListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

public class StoryInputBarView
  extends RelativeLayout
  implements View.OnClickListener
{
  public Context a;
  public CommentLikeFeedItem b;
  public int c;
  public View d;
  public XEditTextEx e;
  public ImageButton f;
  public FrameLayout g;
  public Button h;
  protected SystemEmoticonPanel i;
  public View j;
  public AtVideoTextWatcher k;
  public BubbleTextView l;
  public boolean m;
  public boolean n = true;
  public CommentEntry o;
  public FeedCommentLego p;
  EmoticonCallback q = new StoryInputBarView.6(this);
  private FeedSegment.InputViewHideListener r;
  private long s = 0L;
  private Rect t = new Rect();
  private int u;
  
  public StoryInputBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StoryInputBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public StoryInputBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.StoryInputBarView);
    this.u = paramAttributeSet.getResourceId(0, 0);
    paramAttributeSet.recycle();
    this.a = paramContext;
    a(paramContext);
  }
  
  public static BubbleTextView a(Context paramContext, View paramView, EditText paramEditText, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
      if (!((Boolean)localStoryConfigManager.c("has_show_at_video_intro", Boolean.valueOf(false))).booleanValue())
      {
        BubbleTextView localBubbleTextView = new BubbleTextView(paramContext);
        localBubbleTextView.setPadding(UIUtils.a(paramContext, 10.0F), UIUtils.a(paramContext, 11.0F), UIUtils.a(paramContext, 10.0F), UIUtils.a(paramContext, 11.0F));
        localBubbleTextView.setIncludeFontPadding(false);
        localBubbleTextView.setTextSize(1, 16.0F);
        localBubbleTextView.setTextColor(-1);
        localBubbleTextView.setText(HardCodeUtil.a(2131911760));
        localBubbleTextView.a();
        Object localObject = paramView.getParent();
        int i1;
        if ((localObject != null) && (!(localObject instanceof RelativeLayout)))
        {
          localObject = ((ViewParent)localObject).getParent();
          i1 = 1;
        }
        else
        {
          i1 = 0;
        }
        if ((localObject != null) && ((localObject instanceof RelativeLayout)))
        {
          localObject = (RelativeLayout)localObject;
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          if (i1 != 0)
          {
            localLayoutParams.addRule(8, ((ViewGroup)paramView.getParent()).getId());
            localLayoutParams.bottomMargin = UIUtils.a(paramContext, 55.0F);
          }
          else
          {
            localLayoutParams.addRule(2, paramView.getId());
            localLayoutParams.bottomMargin = (-UIUtils.a(paramContext, 1.0F));
          }
          localLayoutParams.leftMargin = UIUtils.a(paramContext, 12.0F);
          ((RelativeLayout)localObject).addView(localBubbleTextView, localLayoutParams);
        }
        localBubbleTextView.setOnClickListener(new StoryInputBarView.4(paramEditText));
        localStoryConfigManager.d("has_show_at_video_intro", Boolean.valueOf(true));
        StoryReportor.a("home_page", "guide_at", 0, 0, new String[0]);
        return localBubbleTextView;
      }
    }
    return null;
  }
  
  private void e()
  {
    this.i.setVisibility(0);
    this.j.setVisibility(0);
    this.f.setSelected(true);
    Object localObject = this.b;
    if (localObject != null)
    {
      int i1 = StoryReportor.a((FeedItem)localObject);
      if (this.b.getOwner().isMe()) {
        localObject = "1";
      } else {
        localObject = "2";
      }
      StoryReportor.a("home_page", "switch_face", i1, 0, new String[] { localObject, StoryReportor.b(this.c), "", this.b.feedId });
    }
  }
  
  private void f()
  {
    this.i.setVisibility(8);
    this.j.setVisibility(8);
    this.f.setSelected(false);
  }
  
  public void a()
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      ViewParent localViewParent = ((BubbleTextView)localObject).getParent();
      localObject = localViewParent;
      if (localViewParent != null)
      {
        localObject = localViewParent;
        if (!(localViewParent instanceof RelativeLayout)) {
          localObject = localViewParent.getParent();
        }
      }
      if ((localObject != null) && ((localObject instanceof RelativeLayout))) {
        ((RelativeLayout)localObject).removeView(this.l);
      }
      this.l = null;
    }
  }
  
  public void a(Context paramContext)
  {
    this.d = LayoutInflater.from(this.a).inflate(2131628036, this, true);
    View localView;
    if (this.u != 0) {
      localView = LayoutInflater.from(this.a).inflate(2131628121, null, false);
    } else {
      localView = LayoutInflater.from(this.a).inflate(2131628014, null, false);
    }
    ((FrameLayout)this.d.findViewById(2131442716)).addView(localView);
    this.e = ((XEditTextEx)this.d.findViewById(2131432617));
    this.g = ((FrameLayout)this.d.findViewById(2131432475));
    this.i = TroopBarPublishUtils.a(this.a, this.g, this.e, this.q);
    this.j = this.d.findViewById(2131431315);
    if (QQStoryContext.e())
    {
      localView.setBackgroundColor(paramContext.getResources().getColor(2131167384));
      this.e.setBackgroundColor(paramContext.getResources().getColor(2131167383));
      this.e.setHintTextColor(paramContext.getResources().getColor(2131167385));
    }
    this.f = ((ImageButton)this.d.findViewById(2131432438));
    this.f.setOnClickListener(this);
    this.h = ((Button)this.d.findViewById(2131433920));
    this.h.setOnClickListener(this);
    this.e.setOnEditorActionListener(new StoryInputBarView.1(this));
    this.e.setOnTouchListener(new StoryInputBarView.2(this));
    this.e.setOnFocusChangeListener(new StoryInputBarView.3(this));
  }
  
  public void a(FeedCommentLego paramFeedCommentLego, CommentEntry paramCommentEntry)
  {
    if (this.b == null) {
      return;
    }
    b();
    this.p = paramFeedCommentLego;
    this.o = paramCommentEntry;
    paramFeedCommentLego = this.o;
    if (paramFeedCommentLego != null)
    {
      paramFeedCommentLego = paramFeedCommentLego.authorName;
      if (TextUtils.isEmpty(this.o.authorName))
      {
        boolean bool;
        if (this.b.getOwner().getRelationType() == 2) {
          bool = true;
        } else {
          bool = false;
        }
        paramCommentEntry = null;
        paramFeedCommentLego = paramCommentEntry;
        if ((this.b.getOwner() instanceof QQUserUIItem))
        {
          localObject = (QQUserUIItem)this.b.getOwner();
          paramFeedCommentLego = paramCommentEntry;
          if (bool) {
            paramFeedCommentLego = ((QQUserUIItem)localObject).qq;
          }
        }
        paramFeedCommentLego = SpannableStringUtils.a(this.o.authorUnionId, this.o.authorUin, bool, paramFeedCommentLego);
      }
      paramCommentEntry = this.e;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131911759));
      ((StringBuilder)localObject).append(paramFeedCommentLego);
      ((StringBuilder)localObject).append("：");
      paramCommentEntry.setHint(((StringBuilder)localObject).toString());
      return;
    }
    this.e.setHint(HardCodeUtil.a(2131911761));
  }
  
  public void b()
  {
    this.d.setVisibility(0);
    setKeyBoardState(true);
    FeedSegment.InputViewHideListener localInputViewHideListener = this.r;
    if (localInputViewHideListener != null) {
      localInputViewHideListener.c();
    }
  }
  
  public void c()
  {
    this.d.setVisibility(8);
    setKeyBoardState(false);
    f();
    FeedSegment.InputViewHideListener localInputViewHideListener = this.r;
    if (localInputViewHideListener != null) {
      localInputViewHideListener.b();
    }
  }
  
  public void d()
  {
    XEditTextEx localXEditTextEx = this.e;
    if (localXEditTextEx != null)
    {
      AtVideoTextWatcher localAtVideoTextWatcher = this.k;
      if (localAtVideoTextWatcher != null) {
        localXEditTextEx.removeTextChangedListener(localAtVideoTextWatcher);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    Object localObject1;
    if (i1 != 2131432438)
    {
      if (i1 == 2131433920)
      {
        localObject1 = this.e.getText().toString();
        if (((String)localObject1).length() > 0)
        {
          setKeyBoardState(false);
          Object localObject2 = this.p;
          if (localObject2 != null) {
            ((FeedCommentLego)localObject2).a((String)localObject1, this.o);
          }
          c();
          this.e.setText("");
          localObject2 = this.r;
          if (localObject2 != null) {
            ((FeedSegment.InputViewHideListener)localObject2).a((String)localObject1, this.o);
          }
        }
      }
    }
    else if (System.currentTimeMillis() - this.s >= 500L)
    {
      this.s = System.currentTimeMillis();
      if (this.i.getVisibility() == 0)
      {
        f();
        localObject1 = this.r;
        if (localObject1 != null) {
          ((FeedSegment.InputViewHideListener)localObject1).d();
        }
        setKeyBoardState(true);
      }
      else
      {
        setKeyBoardState(false);
        new Handler().postDelayed(new StoryInputBarView.5(this), 200L);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setFeedItemData(CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    CommentLikeFeedItem localCommentLikeFeedItem = this.b;
    if ((localCommentLikeFeedItem != null) && (!localCommentLikeFeedItem.equals(paramCommentLikeFeedItem))) {
      this.e.setText("");
    }
    this.b = paramCommentLikeFeedItem;
    this.c = paramInt1;
    paramCommentLikeFeedItem = this.b;
    if ((paramCommentLikeFeedItem != null) && (!TextUtils.isEmpty(paramCommentLikeFeedItem.feedId)))
    {
      paramCommentLikeFeedItem = this.k;
      if (paramCommentLikeFeedItem == null)
      {
        this.k = new AtVideoTextWatcher(this.a, this.b.feedId, "1_", paramInt2, paramBoolean);
        this.e.addTextChangedListener(this.k);
        return;
      }
      paramCommentLikeFeedItem.b = this.b.feedId;
      this.k.e = paramBoolean;
    }
  }
  
  public void setInputViewHideListener(FeedSegment.InputViewHideListener paramInputViewHideListener)
  {
    this.r = paramInputViewHideListener;
  }
  
  public void setKeyBoardState(boolean paramBoolean)
  {
    Object localObject = (InputMethodManager)this.a.getSystemService("input_method");
    if (localObject != null) {
      if (paramBoolean)
      {
        this.n = true;
        this.e.requestFocus();
        ((InputMethodManager)localObject).showSoftInput(this.e, 1);
        f();
      }
      else
      {
        this.n = false;
        this.e.clearFocus();
        ((InputMethodManager)localObject).hideSoftInputFromWindow(this.d.getWindowToken(), 0);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setKeyBoardState: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("Q.qqstory:StoryInputBarView", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.StoryInputBarView
 * JD-Core Version:    0.7.0.1
 */