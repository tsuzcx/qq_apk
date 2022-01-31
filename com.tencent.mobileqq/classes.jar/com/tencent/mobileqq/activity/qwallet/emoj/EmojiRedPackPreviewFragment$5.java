package com.tencent.mobileqq.activity.qwallet.emoj;

import ajya;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import aywm;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

class EmojiRedPackPreviewFragment$5
  implements Runnable
{
  EmojiRedPackPreviewFragment$5(EmojiRedPackPreviewFragment paramEmojiRedPackPreviewFragment, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.val$isSucc)
      {
        this.this$0.mPercent = 100;
        this.this$0.numberProbar.setProgress(1.0F);
        this.this$0.numberProbar.setVisibility(8);
        this.this$0.reCaptureBtn.setVisibility(0);
        this.this$0.sendBtn.setVisibility(0);
        this.this$0.viewOpenAnim.setVisibility(0);
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aywm.a;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aywm.a;
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        localObject = URLDrawable.getFileDrawable(this.val$gifPath, (URLDrawable.URLDrawableOptions)localObject);
        this.this$0.previewImg.setImageDrawable((Drawable)localObject);
        AbstractGifImage.resumeAll();
        return;
      }
      this.this$0.tips.setText(ajya.a(2131704027));
      this.this$0.reCaptureBtn.setVisibility(0);
      this.this$0.numberProbar.setVisibility(8);
      this.this$0.sendBtn.setVisibility(8);
      this.this$0.viewOpenAnim.setVisibility(8);
      if (this.this$0.imgLottie != null)
      {
        this.this$0.imgLottie.setVisibility(8);
        return;
      }
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiRedPackPreviewFragment.5
 * JD-Core Version:    0.7.0.1
 */