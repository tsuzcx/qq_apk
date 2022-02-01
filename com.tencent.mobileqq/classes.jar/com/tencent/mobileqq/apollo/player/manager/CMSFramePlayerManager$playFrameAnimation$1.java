package com.tencent.mobileqq.apollo.player.manager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class CMSFramePlayerManager$playFrameAnimation$1
  extends Lambda
  implements Function0<Unit>
{
  CMSFramePlayerManager$playFrameAnimation$1(FrameLayout paramFrameLayout, File paramFile)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Object localObject1 = this.$container.getContext();
    this.$container.removeAllViews();
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject2).mUseApngImage = true;
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localObject2 = URLDrawable.getFileDrawable(this.$frame.getAbsolutePath(), (URLDrawable.URLDrawableOptions)localObject2);
    localObject1 = new URLImageView((Context)localObject1);
    ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
    this.$container.addView((View)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSFramePlayerManager.playFrameAnimation.1
 * JD-Core Version:    0.7.0.1
 */