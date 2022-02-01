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
  public int a;
  private long jdField_a_of_type_Long = 0L;
  public Context a;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public View a;
  public Button a;
  public FrameLayout a;
  public ImageButton a;
  public FeedCommentLego a;
  public CommentEntry a;
  public AtVideoTextWatcher a;
  public CommentLikeFeedItem a;
  private FeedSegment.InputViewHideListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$InputViewHideListener;
  public BubbleTextView a;
  EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = new StoryInputBarView.6(this);
  protected SystemEmoticonPanel a;
  public XEditTextEx a;
  public boolean a;
  private int b;
  public View b;
  public boolean b;
  
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
    this.jdField_b_of_type_Boolean = true;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.StoryInputBarView);
    this.jdField_b_of_type_Int = paramAttributeSet.getResourceId(0, 0);
    paramAttributeSet.recycle();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
  }
  
  public static BubbleTextView a(Context paramContext, View paramView, EditText paramEditText, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
      if (!((Boolean)localStoryConfigManager.b("has_show_at_video_intro", Boolean.valueOf(false))).booleanValue())
      {
        BubbleTextView localBubbleTextView = new BubbleTextView(paramContext);
        localBubbleTextView.setPadding(UIUtils.a(paramContext, 10.0F), UIUtils.a(paramContext, 11.0F), UIUtils.a(paramContext, 10.0F), UIUtils.a(paramContext, 11.0F));
        localBubbleTextView.setIncludeFontPadding(false);
        localBubbleTextView.setTextSize(1, 16.0F);
        localBubbleTextView.setTextColor(-1);
        localBubbleTextView.setText(HardCodeUtil.a(2131714316));
        localBubbleTextView.a();
        Object localObject = paramView.getParent();
        if ((localObject != null) && (!(localObject instanceof RelativeLayout))) {
          localObject = ((ViewParent)localObject).getParent();
        }
        for (int i = 1;; i = 0)
        {
          RelativeLayout.LayoutParams localLayoutParams;
          if ((localObject != null) && ((localObject instanceof RelativeLayout)))
          {
            localObject = (RelativeLayout)localObject;
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (i == 0) {
              break label265;
            }
            localLayoutParams.addRule(8, ((ViewGroup)paramView.getParent()).getId());
          }
          for (localLayoutParams.bottomMargin = UIUtils.a(paramContext, 55.0F);; localLayoutParams.bottomMargin = (-UIUtils.a(paramContext, 1.0F)))
          {
            localLayoutParams.leftMargin = UIUtils.a(paramContext, 12.0F);
            ((RelativeLayout)localObject).addView(localBubbleTextView, localLayoutParams);
            localBubbleTextView.setOnClickListener(new StoryInputBarView.4(paramEditText));
            localStoryConfigManager.b("has_show_at_video_intro", Boolean.valueOf(true));
            StoryReportor.a("home_page", "guide_at", 0, 0, new String[0]);
            return localBubbleTextView;
            label265:
            localLayoutParams.addRule(2, paramView.getId());
          }
        }
      }
    }
    return null;
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(true);
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
    {
      i = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
        break label100;
      }
    }
    label100:
    for (String str = "1";; str = "2")
    {
      StoryReportor.a("home_page", "switch_face", i, 0, new String[] { str, StoryReportor.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView != null)
    {
      ViewParent localViewParent2 = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.getParent();
      ViewParent localViewParent1 = localViewParent2;
      if (localViewParent2 != null)
      {
        localViewParent1 = localViewParent2;
        if (!(localViewParent2 instanceof RelativeLayout)) {
          localViewParent1 = localViewParent2.getParent();
        }
      }
      if ((localViewParent1 != null) && ((localViewParent1 instanceof RelativeLayout))) {
        ((RelativeLayout)localViewParent1).removeView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = null;
    }
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561801, this, true);
    if (this.jdField_b_of_type_Int != 0) {}
    for (View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561892, null, false);; localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561773, null, false))
    {
      ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375015)).addView(localView);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)this.jdField_a_of_type_AndroidViewView.findViewById(2131366436));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366299));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = TroopBarPublishUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365287);
      if (QQStoryContext.a())
      {
        localView.setBackgroundColor(paramContext.getResources().getColor(2131166513));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundColor(paramContext.getResources().getColor(2131166512));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(paramContext.getResources().getColor(2131166514));
      }
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131366264));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131367663));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnEditorActionListener(new StoryInputBarView.1(this));
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(new StoryInputBarView.2(this));
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnFocusChangeListener(new StoryInputBarView.3(this));
      return;
    }
  }
  
  public void a(FeedCommentLego paramFeedCommentLego, CommentEntry paramCommentEntry)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem == null) {
      return;
    }
    b();
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego = paramFeedCommentLego;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    boolean bool;
    if (this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry != null)
    {
      paramFeedCommentLego = this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorName;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorName))
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getRelationType() != 2) {
          break label158;
        }
        bool = true;
        if (!(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof QQUserUIItem)) {
          break label177;
        }
        paramFeedCommentLego = (QQUserUIItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
        if (!bool) {
          break label177;
        }
      }
    }
    label158:
    label177:
    for (paramFeedCommentLego = paramFeedCommentLego.qq;; paramFeedCommentLego = null)
    {
      paramFeedCommentLego = SpannableStringUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorUnionId, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorUin, bool, paramFeedCommentLego);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(HardCodeUtil.a(2131714315) + paramFeedCommentLego + "：");
      return;
      bool = false;
      break;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(HardCodeUtil.a(2131714317));
      return;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    setKeyBoardState(true);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$InputViewHideListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$InputViewHideListener.c();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    setKeyBoardState(false);
    f();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$InputViewHideListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$InputViewHideListener.b();
    }
  }
  
  public void d()
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
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 500L)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
        {
          f();
          if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$InputViewHideListener != null) {
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$InputViewHideListener.d();
          }
          setKeyBoardState(true);
        }
        else
        {
          setKeyBoardState(false);
          new Handler().postDelayed(new StoryInputBarView.5(this), 200L);
          continue;
          String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
          if (str.length() > 0)
          {
            setKeyBoardState(false);
            if (this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego != null) {
              this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.a(str, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
            }
            c();
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
            if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$InputViewHideListener != null) {
              this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$InputViewHideListener.a(str, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
            }
          }
        }
      }
    }
  }
  
  public void setFeedItemData(CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.equals(paramCommentLikeFeedItem))) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Int = paramInt1;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId)))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher == null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher = new AtVideoTextWatcher(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, "1_", paramInt2, paramBoolean);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher.b = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher.a = paramBoolean;
  }
  
  public void setInputViewHideListener(FeedSegment.InputViewHideListener paramInputViewHideListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$InputViewHideListener = paramInputViewHideListener;
  }
  
  public void setKeyBoardState(boolean paramBoolean)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      if (!paramBoolean) {
        break label83;
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
      localInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 1);
      f();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory:StoryInputBarView", 2, "setKeyBoardState: " + paramBoolean);
      }
      return;
      label83:
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.clearFocus();
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidViewView.getWindowToken(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.StoryInputBarView
 * JD-Core Version:    0.7.0.1
 */