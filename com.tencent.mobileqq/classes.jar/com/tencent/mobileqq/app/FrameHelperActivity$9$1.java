package com.tencent.mobileqq.app;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import java.lang.ref.WeakReference;

class FrameHelperActivity$9$1
  implements Runnable
{
  FrameHelperActivity$9$1(FrameHelperActivity.9 param9, Conversation paramConversation, Drawable paramDrawable, String paramString) {}
  
  public void run()
  {
    if ((this.a != null) && (this.d.a.isAdded()))
    {
      Object localObject = this.a.W;
      if (this.b != null)
      {
        i = AIOUtils.b(12.0F, this.d.a.getResources());
        this.b.setBounds(0, 0, i, i);
      }
      Drawable localDrawable = this.d.a.getResources().getDrawable(2130838755);
      int i = AIOUtils.b(9.0F, this.d.a.getResources());
      localDrawable.setBounds(0, 0, i, i);
      ((TextView)localObject).setText(this.c);
      ((TextView)localObject).setCompoundDrawablePadding(AIOUtils.b(2.0F, this.d.a.getResources()));
      ((TextView)localObject).setCompoundDrawables(this.b, null, localDrawable, null);
      localObject = ((TextView)localObject).getTag(2131432585);
      if ((localObject instanceof WeakReference))
      {
        localObject = (WeakReference)localObject;
        if ((((WeakReference)localObject).get() instanceof TextView))
        {
          localObject = (TextView)((WeakReference)localObject).get();
          break label181;
        }
      }
      localObject = null;
      label181:
      if (localObject != null)
      {
        ((TextView)localObject).setText(this.c);
        ((TextView)localObject).setCompoundDrawablePadding(AIOUtils.b(2.0F, this.d.a.getResources()));
        ((TextView)localObject).setCompoundDrawables(this.b, null, localDrawable, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.9.1
 * JD-Core Version:    0.7.0.1
 */