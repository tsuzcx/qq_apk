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
import com.tencent.qcircle.weseevideo.editor.sticker.music.LyricParseHelper;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.provider.WOEmptyLineProvider;

public class MoreLyricLayout
  extends LinearLayout
  implements AESlidingUpPanelLayout.PanelSlideListener, IMoreLyricLayout, LyricWithBuoyView.OnLyricWithBuoyViewOperationListener
{
  private ImageView a = null;
  private LyricViewSingleLine b = null;
  private LyricViewController c = null;
  private MoreLyricLayout.LyricScrollListener d = new MoreLyricLayout.LyricScrollListener(this, null);
  private LyricWithBuoyView e;
  private AESlidingUpPanelLayout f;
  private long g;
  private boolean h = false;
  private IMoreLyricLayout.OnMoreLyricLayoutActionListener i;
  private IMoreLyricLayout.OnViewActionReportListener j;
  private IMoreLyricLayout.OnLayoutVisibleChangeListener k;
  private LinearLayout l = null;
  private MoreLyricLayout.LyricBackgroundEffect m = null;
  private int n = 0;
  
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
    IMoreLyricLayout.OnViewActionReportListener localOnViewActionReportListener = this.j;
    if (localOnViewActionReportListener != null) {
      localOnViewActionReportListener.a();
    }
  }
  
  private void b(int paramInt)
  {
    IMoreLyricLayout.OnMoreLyricLayoutActionListener localOnMoreLyricLayoutActionListener = this.i;
    if (localOnMoreLyricLayoutActionListener == null)
    {
      AEQLog.a("MoreLyricLayout", "notifyLyricSelection() mOnMoreLyricLayoutActionListener == null.");
      return;
    }
    localOnMoreLyricLayoutActionListener.a(paramInt);
  }
  
  private void b(boolean paramBoolean)
  {
    IMoreLyricLayout.OnViewActionReportListener localOnViewActionReportListener = this.j;
    if (localOnViewActionReportListener != null) {
      localOnViewActionReportListener.a(paramBoolean);
    }
  }
  
  private void c()
  {
    IMoreLyricLayout.OnViewActionReportListener localOnViewActionReportListener = this.j;
    if (localOnViewActionReportListener != null) {
      localOnViewActionReportListener.c();
    }
  }
  
  private void c(boolean paramBoolean)
  {
    IMoreLyricLayout.OnLayoutVisibleChangeListener localOnLayoutVisibleChangeListener = this.k;
    if (localOnLayoutVisibleChangeListener != null) {
      localOnLayoutVisibleChangeListener.a(paramBoolean);
    }
  }
  
  private void d()
  {
    IMoreLyricLayout.OnViewActionReportListener localOnViewActionReportListener = this.j;
    if (localOnViewActionReportListener != null) {
      localOnViewActionReportListener.b();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    LyricViewSingleLine localLyricViewSingleLine = this.b;
    if (localLyricViewSingleLine == null)
    {
      AEQLog.a("MoreLyricLayout", "changeDragStyle() mLyricViewSingleLine == null.");
      return;
    }
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localLyricViewSingleLine.setVisibility(i1);
  }
  
  private void e()
  {
    LayoutInflater.from(getContext()).inflate(2064056450, this, true);
    this.a = ((ImageView)findViewById(2063991269));
    this.b = ((LyricViewSingleLine)findViewById(2063991271));
    this.c = new LyricViewController(this.b);
    this.e = ((LyricWithBuoyView)findViewById(2063991270));
    this.e.a(this.d);
    this.f = ((AESlidingUpPanelLayout)findViewById(2063991263));
    this.f.a(this);
    this.f.setFadeOnClickListener(new MoreLyricLayout.1(this));
    this.l = ((LinearLayout)findViewById(2063991268));
    a(true);
  }
  
  private void f()
  {
    AESlidingUpPanelLayout localAESlidingUpPanelLayout = this.f;
    if (localAESlidingUpPanelLayout == null) {
      AEQLog.a("MoreLyricLayout", "resetSlidingCollapsedState() mSlidingUpPanelLayout == null.");
    } else {
      localAESlidingUpPanelLayout.setPanelState(AESlidingUpPanelLayout.PanelState.COLLAPSED);
    }
    g();
  }
  
  private void g()
  {
    LyricWithBuoyView localLyricWithBuoyView = this.e;
    if (localLyricWithBuoyView == null)
    {
      AEQLog.a("MoreLyricLayout", "resetSlidingCollapsedState() mLyricWithBuoyView == null.");
      return;
    }
    localLyricWithBuoyView.a();
  }
  
  public void a()
  {
    b((int)this.g);
  }
  
  public void a(int paramInt)
  {
    if (this.n == paramInt) {
      return;
    }
    this.n = paramInt;
    Object localObject = this.c;
    if (localObject != null) {
      ((LyricViewController)localObject).a(paramInt);
    }
    localObject = this.e;
    if (localObject != null) {
      ((LyricWithBuoyView)localObject).b(paramInt);
    }
  }
  
  public void a(View paramView, float paramFloat)
  {
    paramView = this.m;
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
    Object localObject2 = paramAEEditorMusicInfo.h();
    String str = paramAEEditorMusicInfo.i();
    this.h = false;
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
      paramAEEditorMusicInfo = this.c;
      if (paramAEEditorMusicInfo != null) {
        paramAEEditorMusicInfo.a();
      }
      LyricViewController localLyricViewController;
      if (TextUtils.equals(str.toUpperCase(), "LRC"))
      {
        localObject2 = LyricParseHelper.parseTextToLyric(WOEmptyLineProvider.class, (String)localObject1, false);
        localLyricViewController = this.c;
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
        localLyricViewController = this.c;
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
        paramAEEditorMusicInfo = this.c;
        if (paramAEEditorMusicInfo != null)
        {
          paramAEEditorMusicInfo.a(false);
          this.c.a(paramInt, true);
          this.c.a(null);
        }
        this.h = true;
        a(paramBoolean1 ^ true);
        paramAEEditorMusicInfo = this.e;
        if (paramAEEditorMusicInfo != null)
        {
          paramAEEditorMusicInfo.a((String)localObject1, str, paramInt, null);
          this.e.setOnLyricWithBuoyViewOperationListener(this);
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
    int i1;
    if (paramBoolean) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    setVisibility(i1);
    f();
    paramBoolean = bool;
    if (getVisibility() == 0) {
      paramBoolean = true;
    }
    c(paramBoolean);
  }
  
  public void setLyricBackgroundEffect(MoreLyricLayout.LyricBackgroundEffect paramLyricBackgroundEffect)
  {
    this.m = paramLyricBackgroundEffect;
  }
  
  public void setLyricSeek(int paramInt)
  {
    if (!this.h)
    {
      AEQLog.c("MoreLyricLayout", "setLyricSeek() current not lyric.");
      return;
    }
    Object localObject = this.c;
    if (localObject == null) {
      AEQLog.c("MoreLyricLayout", "setLyricSeek() mLyricViewController == null.");
    } else {
      ((LyricViewController)localObject).a(paramInt, false);
    }
    localObject = this.e;
    if (localObject == null)
    {
      AEQLog.c("MoreLyricLayout", "setLyricSeek() mLyricWithBuoyView == null.");
      return;
    }
    ((LyricWithBuoyView)localObject).setSelectedFlag(paramInt, false);
    localObject = this.e.getMusicCurrentTime();
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
    LinearLayout localLinearLayout = this.l;
    if (localLinearLayout == null)
    {
      AEQLog.c("MoreLyricLayout", "setMoreBackground() mMusicBarLyricDragView == null.");
      return;
    }
    localLinearLayout.setBackgroundDrawable(paramDrawable);
  }
  
  public void setOnMoreLyricLayoutActionListener(IMoreLyricLayout.OnMoreLyricLayoutActionListener paramOnMoreLyricLayoutActionListener)
  {
    this.i = paramOnMoreLyricLayoutActionListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.interaction.MoreLyricLayout
 * JD-Core Version:    0.7.0.1
 */