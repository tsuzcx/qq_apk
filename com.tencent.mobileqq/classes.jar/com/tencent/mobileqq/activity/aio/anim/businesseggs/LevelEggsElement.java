package com.tencent.mobileqq.activity.aio.anim.businesseggs;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationConfigHelper;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationRule;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationRule.JumpImage;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.io.File;

public class LevelEggsElement
{
  private View a;
  private LottieDrawable b;
  private final AIOAnimationConatiner c;
  private final ListView d;
  private final AioAnimationRule e;
  private final AioAnimationRule.JumpImage f;
  
  public LevelEggsElement(AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView, AioAnimationRule paramAioAnimationRule, AioAnimationRule.JumpImage paramJumpImage)
  {
    this.c = paramAIOAnimationConatiner;
    this.d = paramListView;
    this.e = paramAioAnimationRule;
    this.f = paramJumpImage;
  }
  
  private View a(Drawable paramDrawable)
  {
    ImageView localImageView = new ImageView(this.d.getContext());
    localImageView.setImageDrawable(paramDrawable);
    Rect localRect = paramDrawable.getBounds();
    if (localRect.isEmpty()) {
      localImageView.layout(0, 0, paramDrawable.getIntrinsicWidth() / 2, paramDrawable.getIntrinsicHeight() / 2);
    } else {
      localImageView.layout(0, 0, localRect.width() / 2, localRect.height() / 2);
    }
    localImageView.setScaleX(1.0F);
    localImageView.setScaleY(1.0F);
    localImageView.setLayerType(2, null);
    return localImageView;
  }
  
  private void a(AioAnimationRule.JumpImage paramJumpImage)
  {
    try
    {
      String str = paramJumpImage.h;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(AioAnimationConfigHelper.a);
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("/data.json");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AioAnimationConfigHelper.a);
      localStringBuilder.append(str);
      localStringBuilder.append("/images");
      str = localStringBuilder.toString();
      paramJumpImage = new LevelEggsPosition(paramJumpImage.d);
      LottieHelper.a(this.d.getContext(), (String)localObject, str, paramJumpImage.a / 2, paramJumpImage.b / 2, new LevelEggsElement.1(this));
      return;
    }
    catch (Throwable paramJumpImage)
    {
      QLog.e("LevelEggsElement", 1, "[playLottie] error with file, ", paramJumpImage);
    }
  }
  
  private void a(AioAnimationRule.JumpImage paramJumpImage, LevelEggsElement.AnimationListener paramAnimationListener)
  {
    Object localObject = paramJumpImage.h;
    paramAnimationListener = new StringBuilder();
    paramAnimationListener.append(AioAnimationConfigHelper.a);
    paramAnimationListener.append((String)localObject);
    paramAnimationListener.append("/data.json");
    paramAnimationListener = new File(paramAnimationListener.toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AioAnimationConfigHelper.a);
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("/images");
    localObject = new File(localStringBuilder.toString());
    if ((paramAnimationListener.exists()) && (((File)localObject).exists()))
    {
      a(paramJumpImage);
      return;
    }
    paramJumpImage = new StringBuilder();
    paramJumpImage.append("[playLottie] jsonFile: ");
    paramJumpImage.append(paramAnimationListener.getPath());
    paramJumpImage.append("-");
    paramJumpImage.append(paramAnimationListener.exists());
    paramJumpImage.append(", imageDir: ");
    paramJumpImage.append(((File)localObject).getPath());
    paramJumpImage.append("-");
    paramJumpImage.append(((File)localObject).exists());
    QLog.e("LevelEggsElement", 1, paramJumpImage.toString());
  }
  
  public void a(LevelEggsElement.AnimationListener paramAnimationListener)
  {
    QLog.i("LevelEggsElement", 1, "[start] start level eggs.");
    Drawable localDrawable = AioAnimationRule.JumpImage.a(this.c.getContext(), this.f);
    if (localDrawable != null)
    {
      this.a = a(localDrawable);
      this.c.addViewInLayout(this.a, -1, AIOAnimationConatiner.a, false);
      return;
    }
    if (this.f.g == 3) {
      a(this.f, paramAnimationListener);
    }
  }
  
  @NonNull
  public String toString()
  {
    return "LevelEggsElement";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.LevelEggsElement
 * JD-Core Version:    0.7.0.1
 */