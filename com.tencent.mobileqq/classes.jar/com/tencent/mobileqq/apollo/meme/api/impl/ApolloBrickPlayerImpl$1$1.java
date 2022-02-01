package com.tencent.mobileqq.apollo.meme.api.impl;

import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

class ApolloBrickPlayerImpl$1$1
  implements Runnable
{
  ApolloBrickPlayerImpl$1$1(ApolloBrickPlayerImpl.1 param1, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    ApolloBrickPlayerImpl.access$700(this.b.this$0).setImageDrawable(this.a);
    ApolloBrickPlayerImpl.access$800(this.b.this$0);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start getFileDrawable ");
      localStringBuilder.append(ApolloBrickPlayerImpl.access$500(this.b.this$0));
      QLog.d("[cmshow]ApolloBrickPlayer", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.api.impl.ApolloBrickPlayerImpl.1.1
 * JD-Core Version:    0.7.0.1
 */