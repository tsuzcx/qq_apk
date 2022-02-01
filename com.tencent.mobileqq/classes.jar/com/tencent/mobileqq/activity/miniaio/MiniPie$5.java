package com.tencent.mobileqq.activity.miniaio;

import android.app.Activity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.utils.SoftKeyboardHeight;
import com.tencent.qphone.base.util.QLog;

class MiniPie$5
  implements Runnable
{
  MiniPie$5(MiniPie paramMiniPie) {}
  
  public void run()
  {
    int j = this.this$0.y.getView().getHeight();
    int i = j;
    if (j <= 0)
    {
      QLog.e(this.this$0.a, 1, "emoHeight <=0 reset to 196dp");
      i = SoftKeyboardHeight.a(0);
    }
    Object localObject = this.this$0;
    j = MiniPie.a((MiniPie)localObject, ((MiniPie)localObject).q);
    int k = this.this$0.q.getHeight();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = this.this$0.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dialogHeight");
      localStringBuilder.append(k);
      localStringBuilder.append(" emoh ");
      localStringBuilder.append(i);
      localStringBuilder.append(" dY ");
      localStringBuilder.append(j);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (k + j + i > MiniChatConstants.SCREEN_HEIGHT)
    {
      i = MiniChatConstants.SCREEN_HEIGHT - j - i - 2;
      j = 300;
      if (i < 300) {
        i = j;
      }
      localObject = ((Activity)this.this$0.b).getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).height = i;
      ((Activity)this.this$0.b).getWindow().setAttributes((WindowManager.LayoutParams)localObject);
      if (QLog.isColorLevel())
      {
        localObject = this.this$0.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("new dialogHeight");
        localStringBuilder.append(i);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPie.5
 * JD-Core Version:    0.7.0.1
 */