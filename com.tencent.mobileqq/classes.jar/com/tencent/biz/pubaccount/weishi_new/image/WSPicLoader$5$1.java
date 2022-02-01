package com.tencent.biz.pubaccount.weishi_new.image;

import android.widget.ImageView;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import java.lang.ref.WeakReference;

class WSPicLoader$5$1
  implements URLDrawable.URLDrawableListener
{
  WSPicLoader$5$1(WSPicLoader.5 param5) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("WeishiUtils loadAvatarImage onFail url:");
    paramURLDrawable.append(this.a.jdField_a_of_type_JavaLangString);
    WSLog.d("AvatarImageLog", paramURLDrawable.toString());
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    ImageView localImageView = (ImageView)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localImageView == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WeishiUtils loadAvatarImage onSuccess url:");
    localStringBuilder.append(this.a.jdField_a_of_type_JavaLangString);
    WSLog.b("AvatarImageLog", localStringBuilder.toString());
    localImageView.setImageDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader.5.1
 * JD-Core Version:    0.7.0.1
 */