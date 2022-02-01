package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.LinkedList;

class PhotoListPanel$13
  implements Runnable
{
  PhotoListPanel$13(PhotoListPanel paramPhotoListPanel) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.k.getResources().getString(2131892588);
    if (PhotoListPanel.a(this.this$0)) {
      localObject1 = this.this$0.k.getResources().getString(2131892590);
    }
    int i = this.this$0.d.size();
    boolean bool2 = false;
    boolean bool1;
    if (i > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Object localObject2 = localObject1;
    if (bool1)
    {
      localObject2 = this.this$0.Q;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(this.this$0.d.size());
      localStringBuilder.append(HardCodeUtil.a(2131905901));
      ((Button)localObject2).setContentDescription(localStringBuilder.toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("(");
      ((StringBuilder)localObject2).append(this.this$0.d.size());
      ((StringBuilder)localObject2).append(")");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    this.this$0.Q.setText((CharSequence)localObject2);
    this.this$0.Q.setEnabled(bool1);
    if (!bool1)
    {
      this.this$0.J.setEnabled(false);
      this.this$0.K.setEnabled(true);
      this.this$0.L.setEnabled(true);
      this.this$0.M.setEnabled(true);
      this.this$0.I.setEnabled(true);
      this.this$0.o();
    }
    else
    {
      if (this.this$0.f.a((String)this.this$0.d.peek()) == 1)
      {
        this.this$0.J.setEnabled(false);
        if (!this.this$0.D) {
          this.this$0.I.setEnabled(false);
        }
      }
      else
      {
        this.this$0.K.setEnabled(true);
        this.this$0.L.setEnabled(true);
        this.this$0.M.setEnabled(true);
        localObject1 = this.this$0.J;
        bool1 = bool2;
        if (this.this$0.d.size() == 1)
        {
          bool1 = bool2;
          if (!PhotoListPanel.a(this.this$0)) {
            bool1 = true;
          }
        }
        ((Button)localObject1).setEnabled(bool1);
      }
      this.this$0.o();
    }
    if (this.this$0.V != null) {
      this.this$0.V.a(this.this$0.getSelectedMediaCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.13
 * JD-Core Version:    0.7.0.1
 */