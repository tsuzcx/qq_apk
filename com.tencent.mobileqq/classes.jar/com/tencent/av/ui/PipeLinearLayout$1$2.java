package com.tencent.av.ui;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;

class PipeLinearLayout$1$2
  implements Runnable
{
  PipeLinearLayout$1$2(PipeLinearLayout.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (!PipeLinearLayout.e(this.b.this$0))
    {
      int i = 0;
      while ((i < this.a.size()) && (i < PipeLinearLayout.g(this.b.this$0).length))
      {
        localObject = (ImageView)this.b.this$0.findViewById(PipeLinearLayout.g(this.b.this$0)[i]);
        ((ImageView)localObject).setImageBitmap(PipeLinearLayout.a(this.b.this$0, ((Long)PipeLinearLayout.b(this.b.this$0).get(i)).longValue()));
        ((ImageView)localObject).setVisibility(0);
        i += 1;
      }
      Object localObject = (TextView)this.b.this$0.findViewById(2131438048);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PipeLinearLayout.h(this.b.this$0).size());
      localStringBuilder.append(HardCodeUtil.a(2131905977));
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.PipeLinearLayout.1.2
 * JD-Core Version:    0.7.0.1
 */