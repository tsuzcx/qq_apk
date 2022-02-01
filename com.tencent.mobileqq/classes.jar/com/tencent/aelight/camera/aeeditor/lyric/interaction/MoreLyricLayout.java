package com.tencent.aelight.camera.aeeditor.lyric.interaction;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.aeeditor.lyric.widget.LyricViewController;
import com.tencent.aelight.camera.aeeditor.lyric.widget.LyricViewSingleLine;
import com.tencent.aelight.camera.aeeditor.lyric.widget.LyricWithBuoyView;
import com.tencent.aelight.camera.aeeditor.lyric.widget.LyricWithBuoyView.OnLyricWithBuoyViewOperationListener;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicAdapter.AEEditorMusicInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.weseevideo.editor.sticker.music.LyricParseHelper;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.weseevideo.editor.sticker.music.lyric.parse.provider.WOEmptyLineProvider;

public class MoreLyricLayout
  extends LinearLayout
  implements AESlidingUpPanelLayout.PanelSlideListener, IMoreLyricLayout, LyricWithBuoyView.OnLyricWithBuoyViewOperationListener
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private AESlidingUpPanelLayout jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout;
  private IMoreLyricLayout.OnLayoutVisibleChangeListener jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionIMoreLyricLayout$OnLayoutVisibleChangeListener;
  private IMoreLyricLayout.OnMoreLyricLayoutActionListener jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionIMoreLyricLayout$OnMoreLyricLayoutActionListener;
  private IMoreLyricLayout.OnViewActionReportListener jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionIMoreLyricLayout$OnViewActionReportListener;
  private MoreLyricLayout.LyricBackgroundEffect jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionMoreLyricLayout$LyricBackgroundEffect = null;
  private MoreLyricLayout.LyricScrollListener jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionMoreLyricLayout$LyricScrollListener = new MoreLyricLayout.LyricScrollListener(this, null);
  private LyricViewController jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewController = null;
  private LyricViewSingleLine jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewSingleLine = null;
  private LyricWithBuoyView jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricWithBuoyView;
  private boolean jdField_a_of_type_Boolean = false;
  
  public MoreLyricLayout(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public MoreLyricLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  public MoreLyricLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  private void b()
  {
    IMoreLyricLayout.OnViewActionReportListener localOnViewActionReportListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionIMoreLyricLayout$OnViewActionReportListener;
    if (localOnViewActionReportListener != null) {
      localOnViewActionReportListener.a();
    }
  }
  
  private void b(int paramInt)
  {
    IMoreLyricLayout.OnMoreLyricLayoutActionListener localOnMoreLyricLayoutActionListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionIMoreLyricLayout$OnMoreLyricLayoutActionListener;
    if (localOnMoreLyricLayoutActionListener == null)
    {
      AEQLog.a("MoreLyricLayout", "notifyLyricSelection() mOnMoreLyricLayoutActionListener == null.");
      return;
    }
    localOnMoreLyricLayoutActionListener.a(paramInt);
  }
  
  private void b(boolean paramBoolean)
  {
    IMoreLyricLayout.OnViewActionReportListener localOnViewActionReportListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionIMoreLyricLayout$OnViewActionReportListener;
    if (localOnViewActionReportListener != null) {
      localOnViewActionReportListener.a(paramBoolean);
    }
  }
  
  private void c()
  {
    IMoreLyricLayout.OnViewActionReportListener localOnViewActionReportListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionIMoreLyricLayout$OnViewActionReportListener;
    if (localOnViewActionReportListener != null) {
      localOnViewActionReportListener.c();
    }
  }
  
  private void c(boolean paramBoolean)
  {
    IMoreLyricLayout.OnLayoutVisibleChangeListener localOnLayoutVisibleChangeListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionIMoreLyricLayout$OnLayoutVisibleChangeListener;
    if (localOnLayoutVisibleChangeListener != null) {
      localOnLayoutVisibleChangeListener.a(paramBoolean);
    }
  }
  
  private void d()
  {
    IMoreLyricLayout.OnViewActionReportListener localOnViewActionReportListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionIMoreLyricLayout$OnViewActionReportListener;
    if (localOnViewActionReportListener != null) {
      localOnViewActionReportListener.b();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    LyricViewSingleLine localLyricViewSingleLine = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewSingleLine;
    if (localLyricViewSingleLine == null)
    {
      AEQLog.a("MoreLyricLayout", "changeDragStyle() mLyricViewSingleLine == null.");
      return;
    }
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localLyricViewSingleLine.setVisibility(i);
  }
  
  private void e()
  {
    LayoutInflater.from(getContext()).inflate(2064318578, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2064122441));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewSingleLine = ((LyricViewSingleLine)findViewById(2064122443));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewController = new LyricViewController(this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewSingleLine);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricWithBuoyView = ((LyricWithBuoyView)findViewById(2064122442));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricWithBuoyView.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionMoreLyricLayout$LyricScrollListener);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout = ((AESlidingUpPanelLayout)findViewById(2064122412));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout.a(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout.setFadeOnClickListener(new MoreLyricLayout.1(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2064122440));
    a(true);
  }
  
  private void f()
  {
    AESlidingUpPanelLayout localAESlidingUpPanelLayout = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout;
    if (localAESlidingUpPanelLayout == null) {
      AEQLog.a("MoreLyricLayout", "resetSlidingCollapsedState() mSlidingUpPanelLayout == null.");
    } else {
      localAESlidingUpPanelLayout.setPanelState(AESlidingUpPanelLayout.PanelState.COLLAPSED);
    }
    g();
  }
  
  private void g()
  {
    LyricWithBuoyView localLyricWithBuoyView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricWithBuoyView;
    if (localLyricWithBuoyView == null)
    {
      AEQLog.a("MoreLyricLayout", "resetSlidingCollapsedState() mLyricWithBuoyView == null.");
      return;
    }
    localLyricWithBuoyView.a();
  }
  
  public void a()
  {
    b((int)this.jdField_a_of_type_Long);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewController;
    if (localObject != null) {
      ((LyricViewController)localObject).a(paramInt);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricWithBuoyView;
    if (localObject != null) {
      ((LyricWithBuoyView)localObject).a(paramInt);
    }
  }
  
  public void a(View paramView, float paramFloat)
  {
    paramView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionMoreLyricLayout$LyricBackgroundEffect;
    if (paramView != null) {
      paramView.a(paramFloat);
    }
  }
  
  public void a(View paramView, AESlidingUpPanelLayout.PanelState paramPanelState1, AESlidingUpPanelLayout.PanelState paramPanelState2)
  {
    paramView = new StringBuilder();
    paramView.append("onPanelStateChanged() newState => ");
    paramView.append(paramPanelState2);
    AEQLog.a("MoreLyricLayout", paramView.toString());
    if (paramPanelState2 == AESlidingUpPanelLayout.PanelState.DRAGGING)
    {
      d(false);
      d();
      return;
    }
    if (paramPanelState2 == AESlidingUpPanelLayout.PanelState.COLLAPSED)
    {
      d(true);
      g();
      b(false);
      return;
    }
    if (paramPanelState2 == AESlidingUpPanelLayout.PanelState.ANCHORED)
    {
      f();
      return;
    }
    d(false);
    b(true);
  }
  
  public void a(AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramAEEditorMusicInfo == null)
    {
      AEQLog.c("MoreLyricLayout", "initLyricView() mData == null.");
      return;
    }
    f();
    Object localObject2 = paramAEEditorMusicInfo.d();
    String str = paramAEEditorMusicInfo.e();
    this.jdField_a_of_type_Boolean = false;
    Object localObject1;
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(((String)localObject2).trim())))
    {
      localObject1 = localObject2;
      if (!((String)localObject2).equals("[00:00:00]此歌曲为没有填词的纯音乐，请您欣赏")) {}
    }
    else
    {
      str = "LRC";
      localObject1 = "[00:00:00]此歌曲为没有填词的纯音乐，请您欣赏";
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str)))
    {
      paramAEEditorMusicInfo = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewController;
      if (paramAEEditorMusicInfo != null) {
        paramAEEditorMusicInfo.a();
      }
      LyricViewController localLyricViewController;
      if (TextUtils.equals(str.toUpperCase(), "LRC"))
      {
        localObject2 = LyricParseHelper.parseTextToLyric(WOEmptyLineProvider.class, (String)localObject1, false);
        localLyricViewController = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewController;
        paramAEEditorMusicInfo = (AEEditorMusicAdapter.AEEditorMusicInfo)localObject2;
        if (localLyricViewController != null)
        {
          localLyricViewController.a(null, (Lyric)localObject2, null);
          paramAEEditorMusicInfo = (AEEditorMusicAdapter.AEEditorMusicInfo)localObject2;
        }
      }
      else if (TextUtils.equals(str.toUpperCase(), "QRC"))
      {
        localObject2 = LyricParseHelper.parseTextToLyric(WOEmptyLineProvider.class, (String)localObject1, true);
        localLyricViewController = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewController;
        paramAEEditorMusicInfo = (AEEditorMusicAdapter.AEEditorMusicInfo)localObject2;
        if (localLyricViewController != null)
        {
          localLyricViewController.a((Lyric)localObject2, null, null);
          paramAEEditorMusicInfo = (AEEditorMusicAdapter.AEEditorMusicInfo)localObject2;
        }
      }
      else
      {
        paramAEEditorMusicInfo = null;
      }
      if (paramAEEditorMusicInfo != null)
      {
        paramAEEditorMusicInfo = new StringBuilder();
        paramAEEditorMusicInfo.append("initLyricView() startTime => ");
        paramAEEditorMusicInfo.append(paramInt);
        paramAEEditorMusicInfo.append(",lyricFormat:");
        paramAEEditorMusicInfo.append(str);
        AEQLog.a("MoreLyricLayout", paramAEEditorMusicInfo.toString());
        paramAEEditorMusicInfo = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewController;
        if (paramAEEditorMusicInfo != null)
        {
          paramAEEditorMusicInfo.a(false);
          this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewController.a(paramInt, true);
          this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewController.a(null);
        }
        this.jdField_a_of_type_Boolean = true;
        a(paramBoolean1 ^ true);
        paramAEEditorMusicInfo = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricWithBuoyView;
        if (paramAEEditorMusicInfo != null)
        {
          paramAEEditorMusicInfo.a((String)localObject1, str, paramInt, null);
          this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricWithBuoyView.setOnLyricWithBuoyViewOperationListener(this);
        }
        if (paramBoolean1) {
          b();
        }
      }
      else
      {
        a(true);
      }
      return;
    }
    AEQLog.a("MoreLyricLayout", "initLyricView() lyric info is empty.");
    a(true);
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hideLyricLayout() hide > ");
    localStringBuilder.append(paramBoolean);
    AEQLog.a("MoreLyricLayout", localStringBuilder.toString());
    boolean bool = false;
    int i;
    if (paramBoolean) {
      i = 8;
    } else {
      i = 0;
    }
    setVisibility(i);
    f();
    paramBoolean = bool;
    if (getVisibility() == 0) {
      paramBoolean = true;
    }
    c(paramBoolean);
  }
  
  public void setLyricBackgroundEffect(MoreLyricLayout.LyricBackgroundEffect paramLyricBackgroundEffect)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionMoreLyricLayout$LyricBackgroundEffect = paramLyricBackgroundEffect;
  }
  
  public void setLyricSeek(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      AEQLog.c("MoreLyricLayout", "setLyricSeek() current not lyric.");
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewController;
    if (localObject == null) {
      AEQLog.c("MoreLyricLayout", "setLyricSeek() mLyricViewController == null.");
    } else {
      ((LyricViewController)localObject).a(paramInt, false);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricWithBuoyView;
    if (localObject == null)
    {
      AEQLog.c("MoreLyricLayout", "setLyricSeek() mLyricWithBuoyView == null.");
      return;
    }
    ((LyricWithBuoyView)localObject).setSelectedFlag(paramInt, false);
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricWithBuoyView.a();
    if (localObject != null) {
      ((TextView)localObject).setText(LyricWithBuoyView.a(paramInt));
    }
  }
  
  public void setMoreBackground(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      AEQLog.c("MoreLyricLayout", "setMoreBackground() drawable == null.");
      return;
    }
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localLinearLayout == null)
    {
      AEQLog.c("MoreLyricLayout", "setMoreBackground() mMusicBarLyricDragView == null.");
      return;
    }
    localLinearLayout.setBackgroundDrawable(paramDrawable);
  }
  
  public void setOnMoreLyricLayoutActionListener(IMoreLyricLayout.OnMoreLyricLayoutActionListener paramOnMoreLyricLayoutActionListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionIMoreLyricLayout$OnMoreLyricLayoutActionListener = paramOnMoreLyricLayoutActionListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.interaction.MoreLyricLayout
 * JD-Core Version:    0.7.0.1
 */