package com.tencent.av.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class MutiMemberThumbList$1$1
  implements Runnable
{
  MutiMemberThumbList$1$1(MutiMemberThumbList.1 param1, boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (MutiMemberThumbList.f(this.c.this$0))
    {
      QLog.d("MutiMemberThumbList", 1, "doDisplay quit by destroyed in UI_Thread");
      return;
    }
    View localView = this.c.this$0.findViewById(2131430993);
    if (this.c.a > 0)
    {
      localView.setVisibility(0);
      int i = 0;
      while (i < MutiMemberThumbList.a(this.c.this$0).length)
      {
        localView = this.c.this$0.findViewById(MutiMemberThumbList.a(this.c.this$0)[i]);
        ImageView localImageView = (ImageView)localView.findViewById(2131441083);
        TextView localTextView = (TextView)localView.findViewById(2131441085);
        localTextView.setVisibility(8);
        localImageView.setImageDrawable(null);
        if ((this.a) && (i == MutiMemberThumbList.a(this.c.this$0).length - 1))
        {
          localTextView.setText(String.format("%d+", new Object[] { Integer.valueOf(this.c.a - MutiMemberThumbList.a(this.c.this$0).length + 1) }));
          localTextView.setVisibility(0);
          ((ImageView)localView.findViewById(2131441083)).setImageDrawable(MutiMemberThumbList.g(this.c.this$0));
          localView.setVisibility(0);
          break;
        }
        if ((i < this.c.a) && (i < this.b.size()))
        {
          localImageView.setImageBitmap((Bitmap)this.b.get(i));
          localView.setVisibility(0);
        }
        else
        {
          localView.setVisibility(8);
        }
        i += 1;
      }
      this.c.this$0.setVisibility(0);
      if (MutiMemberThumbList.h(this.c.this$0) != null) {
        MutiMemberThumbList.h(this.c.this$0).setVisibility(0);
      }
      return;
    }
    localView.setVisibility(4);
    this.c.this$0.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MutiMemberThumbList.1.1
 * JD-Core Version:    0.7.0.1
 */