package androidx.core.provider;

import android.os.Handler;
import androidx.core.content.res.ResourcesCompat.FontCallback;

class FontsContractCompat$2
  implements SelfDestructiveThread.ReplyCallback<FontsContractCompat.TypefaceResult>
{
  FontsContractCompat$2(ResourcesCompat.FontCallback paramFontCallback, Handler paramHandler) {}
  
  public void onReply(FontsContractCompat.TypefaceResult paramTypefaceResult)
  {
    if (paramTypefaceResult == null)
    {
      this.val$fontCallback.callbackFailAsync(1, this.val$handler);
      return;
    }
    if (paramTypefaceResult.mResult == 0)
    {
      this.val$fontCallback.callbackSuccessAsync(paramTypefaceResult.mTypeface, this.val$handler);
      return;
    }
    this.val$fontCallback.callbackFailAsync(paramTypefaceResult.mResult, this.val$handler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.provider.FontsContractCompat.2
 * JD-Core Version:    0.7.0.1
 */