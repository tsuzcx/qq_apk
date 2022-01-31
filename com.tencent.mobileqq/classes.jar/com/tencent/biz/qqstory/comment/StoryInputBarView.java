package com.tencent.biz.qqstory.comment;

import ajyc;
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
import anyb;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import szv;
import tas;
import tat;
import tau;
import tav;
import taw;
import tcv;
import tdc;
import teg;
import uou;
import upz;
import vbx;
import vel;
import vzo;

public class StoryInputBarView
  extends RelativeLayout
  implements View.OnClickListener
{
  public int a;
  private long jdField_a_of_type_Long;
  public Context a;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public View a;
  public Button a;
  public FrameLayout a;
  public ImageButton a;
  anyb jdField_a_of_type_Anyb = new taw(this);
  public CommentEntry a;
  public CommentLikeFeedItem a;
  public BubbleTextView a;
  protected SystemEmoticonPanel a;
  public XEditTextEx a;
  public szv a;
  public uou a;
  private vbx jdField_a_of_type_Vbx;
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
      tcv localtcv = (tcv)tdc.a(10);
      if (!((Boolean)localtcv.b("has_show_at_video_intro", Boolean.valueOf(false))).booleanValue())
      {
        BubbleTextView localBubbleTextView = new BubbleTextView(paramContext);
        localBubbleTextView.setPadding(vzo.a(paramContext, 10.0F), vzo.a(paramContext, 11.0F), vzo.a(paramContext, 10.0F), vzo.a(paramContext, 11.0F));
        localBubbleTextView.setIncludeFontPadding(false);
        localBubbleTextView.setTextSize(1, 16.0F);
        localBubbleTextView.setTextColor(-1);
        localBubbleTextView.setText(ajyc.a(2131714436));
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
          for (localLayoutParams.bottomMargin = vzo.a(paramContext, 55.0F);; localLayoutParams.bottomMargin = (-vzo.a(paramContext, 1.0F)))
          {
            localLayoutParams.leftMargin = vzo.a(paramContext, 12.0F);
            ((RelativeLayout)localObject).addView(localBubbleTextView, localLayoutParams);
            localBubbleTextView.setOnClickListener(new tav(paramEditText));
            localtcv.b("has_show_at_video_intro", Boolean.valueOf(true));
            vel.a("home_page", "guide_at", 0, 0, new String[0]);
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
      i = vel.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
        break label100;
      }
    }
    label100:
    for (String str = "1";; str = "2")
    {
      vel.a("home_page", "switch_face", i, 0, new String[] { str, vel.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
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
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561239, this, true);
    if (this.jdField_b_of_type_Int != 0) {}
    for (View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561331, null, false);; localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561209, null, false))
    {
      ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373297)).addView(localView);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)this.jdField_a_of_type_AndroidViewView.findViewById(2131365750));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365629));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = TroopBarPublishUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_Anyb);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364685);
      if (QQStoryContext.a())
      {
        localView.setBackgroundColor(paramContext.getResources().getColor(2131166350));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundColor(paramContext.getResources().getColor(2131166349));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(paramContext.getResources().getColor(2131166351));
      }
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131365595));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131366883));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnEditorActionListener(new tas(this));
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(new tat(this));
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnFocusChangeListener(new tau(this));
      return;
    }
  }
  
  public void a(szv paramszv, CommentEntry paramCommentEntry)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem == null) {
      return;
    }
    b();
    this.jdField_a_of_type_Szv = paramszv;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    boolean bool;
    if (this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry != null)
    {
      paramszv = this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorName;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorName))
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getRelationType() != 2) {
          break label158;
        }
        bool = true;
        if (!(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof QQUserUIItem)) {
          break label177;
        }
        paramszv = (QQUserUIItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
        if (!bool) {
          break label177;
        }
      }
    }
    label158:
    label177:
    for (paramszv = paramszv.qq;; paramszv = null)
    {
      paramszv = upz.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorUnionId, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorUin, bool, paramszv);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(ajyc.a(2131714435) + paramszv + "：");
      return;
      bool = false;
      break;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(ajyc.a(2131714437));
      return;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    setKeyBoardState(true);
    if (this.jdField_a_of_type_Vbx != null) {
      this.jdField_a_of_type_Vbx.c();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    setKeyBoardState(false);
    f();
    if (this.jdField_a_of_type_Vbx != null) {
      this.jdField_a_of_type_Vbx.b();
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (this.jdField_a_of_type_Uou != null)) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this.jdField_a_of_type_Uou);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
        {
          f();
          if (this.jdField_a_of_type_Vbx != null) {
            this.jdField_a_of_type_Vbx.d();
          }
          setKeyBoardState(true);
          return;
        }
        setKeyBoardState(false);
        new Handler().postDelayed(new StoryInputBarView.5(this), 200L);
        return;
        paramView = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      } while (paramView.length() <= 0);
      setKeyBoardState(false);
      if (this.jdField_a_of_type_Szv != null) {
        this.jdField_a_of_type_Szv.a(paramView, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      }
      c();
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    } while (this.jdField_a_of_type_Vbx == null);
    this.jdField_a_of_type_Vbx.a(paramView, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
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
      if (this.jdField_a_of_type_Uou == null)
      {
        this.jdField_a_of_type_Uou = new uou(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, "1_", paramInt2, paramBoolean);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_Uou);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Uou.b = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId;
    this.jdField_a_of_type_Uou.a = paramBoolean;
  }
  
  public void setInputViewHideListener(vbx paramvbx)
  {
    this.jdField_a_of_type_Vbx = paramvbx;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.StoryInputBarView
 * JD-Core Version:    0.7.0.1
 */