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
        localBubbleTextView.setText(HardCodeUtil.a(2131714237));
        localBubbleTextView.a();
        Object localObject = paramView.getParent();
        int i;
        if ((localObject != null) && (!(localObject instanceof RelativeLayout)))
        {
          localObject = ((ViewParent)localObject).getParent();
          i = 1;
        }
        else
        {
          i = 0;
        }
        if ((localObject != null) && ((localObject instanceof RelativeLayout)))
        {
          localObject = (RelativeLayout)localObject;
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          if (i != 0)
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
        localStoryConfigManager.b("has_show_at_video_intro", Boolean.valueOf(true));
        StoryReportor.a("home_page", "guide_at", 0, 0, new String[0]);
        return localBubbleTextView;
      }
    }
    return null;
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(true);
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    if (localObject != null)
    {
      int i = StoryReportor.a((FeedItem)localObject);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
        localObject = "1";
      } else {
        localObject = "2";
      }
      StoryReportor.a("home_page", "switch_face", i, 0, new String[] { localObject, StoryReportor.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
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
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
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
        ((RelativeLayout)localObject).removeView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = null;
    }
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561657, this, true);
    View localView;
    if (this.jdField_b_of_type_Int != 0) {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561742, null, false);
    } else {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561635, null, false);
    }
    ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131374546)).addView(localView);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)this.jdField_a_of_type_AndroidViewView.findViewById(2131366317));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366187));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = TroopBarPublishUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365162);
    if (QQStoryContext.a())
    {
      localView.setBackgroundColor(paramContext.getResources().getColor(2131166527));
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundColor(paramContext.getResources().getColor(2131166526));
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(paramContext.getResources().getColor(2131166528));
    }
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131366152));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131367417));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnEditorActionListener(new StoryInputBarView.1(this));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(new StoryInputBarView.2(this));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnFocusChangeListener(new StoryInputBarView.3(this));
  }
  
  public void a(FeedCommentLego paramFeedCommentLego, CommentEntry paramCommentEntry)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem == null) {
      return;
    }
    b();
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego = paramFeedCommentLego;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    paramFeedCommentLego = this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
    if (paramFeedCommentLego != null)
    {
      paramFeedCommentLego = paramFeedCommentLego.authorName;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorName))
      {
        boolean bool;
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getRelationType() == 2) {
          bool = true;
        } else {
          bool = false;
        }
        paramCommentEntry = null;
        paramFeedCommentLego = paramCommentEntry;
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof QQUserUIItem))
        {
          localObject = (QQUserUIItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
          paramFeedCommentLego = paramCommentEntry;
          if (bool) {
            paramFeedCommentLego = ((QQUserUIItem)localObject).qq;
          }
        }
        paramFeedCommentLego = SpannableStringUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorUnionId, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorUin, bool, paramFeedCommentLego);
      }
      paramCommentEntry = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131714236));
      ((StringBuilder)localObject).append(paramFeedCommentLego);
      ((StringBuilder)localObject).append("：");
      paramCommentEntry.setHint(((StringBuilder)localObject).toString());
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(HardCodeUtil.a(2131714238));
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    setKeyBoardState(true);
    FeedSegment.InputViewHideListener localInputViewHideListener = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$InputViewHideListener;
    if (localInputViewHideListener != null) {
      localInputViewHideListener.c();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    setKeyBoardState(false);
    f();
    FeedSegment.InputViewHideListener localInputViewHideListener = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$InputViewHideListener;
    if (localInputViewHideListener != null) {
      localInputViewHideListener.b();
    }
  }
  
  public void d()
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
    int i = paramView.getId();
    Object localObject1;
    if (i != 2131366152)
    {
      if (i == 2131367417)
      {
        localObject1 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
        if (((String)localObject1).length() > 0)
        {
          setKeyBoardState(false);
          Object localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego;
          if (localObject2 != null) {
            ((FeedCommentLego)localObject2).a((String)localObject1, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
          }
          c();
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
          localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$InputViewHideListener;
          if (localObject2 != null) {
            ((FeedSegment.InputViewHideListener)localObject2).a((String)localObject1, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
          }
        }
      }
    }
    else if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 500L)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
      {
        f();
        localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$InputViewHideListener;
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
    CommentLikeFeedItem localCommentLikeFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    if ((localCommentLikeFeedItem != null) && (!localCommentLikeFeedItem.equals(paramCommentLikeFeedItem))) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Int = paramInt1;
    paramCommentLikeFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    if ((paramCommentLikeFeedItem != null) && (!TextUtils.isEmpty(paramCommentLikeFeedItem.feedId)))
    {
      paramCommentLikeFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher;
      if (paramCommentLikeFeedItem == null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher = new AtVideoTextWatcher(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, "1_", paramInt2, paramBoolean);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher);
        return;
      }
      paramCommentLikeFeedItem.b = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher.a = paramBoolean;
    }
  }
  
  public void setInputViewHideListener(FeedSegment.InputViewHideListener paramInputViewHideListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment$InputViewHideListener = paramInputViewHideListener;
  }
  
  public void setKeyBoardState(boolean paramBoolean)
  {
    Object localObject = (InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method");
    if (localObject != null) {
      if (paramBoolean)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
        ((InputMethodManager)localObject).showSoftInput(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 1);
        f();
      }
      else
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.clearFocus();
        ((InputMethodManager)localObject).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidViewView.getWindowToken(), 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.StoryInputBarView
 * JD-Core Version:    0.7.0.1
 */