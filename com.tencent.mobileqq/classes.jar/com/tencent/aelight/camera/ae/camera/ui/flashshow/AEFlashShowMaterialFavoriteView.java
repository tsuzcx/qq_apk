package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialFavoriteView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "favoriteState", "", "ivFavorite", "Landroid/widget/ImageView;", "tvFavorite", "Landroid/widget/TextView;", "initViews", "", "setFavorite", "favorite", "updateState", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEFlashShowMaterialFavoriteView
  extends RelativeLayout
{
  private ImageView a;
  private TextView b;
  private boolean c;
  
  public AEFlashShowMaterialFavoriteView(@NotNull Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(getContext()).inflate(2064056356, (ViewGroup)this, true);
    setBackgroundResource(2063925327);
    b();
  }
  
  public AEFlashShowMaterialFavoriteView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(getContext()).inflate(2064056356, (ViewGroup)this, true);
    setBackgroundResource(2063925327);
    b();
  }
  
  public AEFlashShowMaterialFavoriteView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(getContext()).inflate(2064056356, (ViewGroup)this, true);
    setBackgroundResource(2063925327);
    b();
  }
  
  private final void b()
  {
    this.a = ((ImageView)findViewById(2063991188));
    this.b = ((TextView)findViewById(2063991536));
    a();
  }
  
  public final void a()
  {
    Object localObject;
    if (this.c)
    {
      localObject = this.a;
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(2063925328);
      }
      localObject = this.b;
      if (localObject != null) {
        ((TextView)localObject).setText(2064187413);
      }
    }
    else
    {
      localObject = this.a;
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(2063925329);
      }
      localObject = this.b;
      if (localObject != null) {
        ((TextView)localObject).setText(2064187412);
      }
    }
  }
  
  public final void setFavorite(boolean paramBoolean)
  {
    if (this.c == paramBoolean) {
      return;
    }
    this.c = paramBoolean;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialFavoriteView
 * JD-Core Version:    0.7.0.1
 */