package com.tencent.aelight.camera.aeeditor.view.reorder;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/aeeditor/view/reorder/SelectableThumbClipView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "durationView", "Landroid/widget/TextView;", "getDurationView", "()Landroid/widget/TextView;", "setDurationView", "(Landroid/widget/TextView;)V", "foregroundView", "Landroid/view/View;", "thumbView", "Lcom/tencent/aelight/camera/aeeditor/view/reorder/ThumbClipView;", "getThumbView", "()Lcom/tencent/aelight/camera/aeeditor/view/reorder/ThumbClipView;", "setSelected", "", "selected", "", "aelight_impl_release"}, k=1, mv={1, 1, 16})
@RequiresApi(16)
public final class SelectableThumbClipView
  extends FrameLayout
{
  private final View a;
  @NotNull
  private final ThumbClipView b;
  @NotNull
  private TextView c;
  
  @JvmOverloads
  public SelectableThumbClipView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public SelectableThumbClipView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public SelectableThumbClipView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = new View(paramContext);
    this.b = new ThumbClipView(paramContext, null, 0, 6, null);
    this.c = new TextView(paramContext);
    this.a.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(getResources().getDimensionPixelSize(2063859780), getResources().getDimensionPixelSize(2063859778)));
    this.a.setBackground(getResources().getDrawable(2063925396));
    this.a.setVisibility(4);
    paramAttributeSet = new FrameLayout.LayoutParams(-2, (int)getResources().getDimension(2063859763));
    paramAttributeSet.leftMargin = ((int)getResources().getDimension(2063859739));
    paramAttributeSet.bottomMargin = ((int)getResources().getDimension(2063859741));
    paramAttributeSet.gravity = 83;
    this.c.setTextSize(0, getResources().getDimension(2063859759));
    TextView localTextView = this.c;
    localTextView.setTextColor(localTextView.getResources().getColor(2131168464));
    this.c.setShadowLayer(2.0F, 1.0F, 1.0F, 2131165578);
    this.c.setIncludeFontPadding(false);
    this.c.setSingleLine();
    this.c.setGravity(80);
    this.c.setPadding((int)getResources().getDimension(2063859740), 0, (int)getResources().getDimension(2063859740), 0);
    this.c.setTypeface(((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getTypeface(paramContext, "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"));
    this.c.setLayoutParams((ViewGroup.LayoutParams)paramAttributeSet);
    addView((View)this.b);
    addView(this.a);
    addView((View)this.c);
  }
  
  @NotNull
  public final TextView getDurationView()
  {
    return this.c;
  }
  
  @NotNull
  public final ThumbClipView getThumbView()
  {
    return this.b;
  }
  
  public final void setDurationView(@NotNull TextView paramTextView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "<set-?>");
    this.c = paramTextView;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    View localView = this.a;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 4;
    }
    localView.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.reorder.SelectableThumbClipView
 * JD-Core Version:    0.7.0.1
 */