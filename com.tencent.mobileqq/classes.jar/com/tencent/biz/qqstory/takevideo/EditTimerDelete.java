package com.tencent.biz.qqstory.takevideo;

import android.content.Intent;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.qqonly.QzEditPicPartManager;

public class EditTimerDelete
  extends EditVideoPart
  implements View.OnClickListener
{
  private LinearLayout a;
  
  public EditTimerDelete(@NonNull QzEditPicPartManager paramQzEditPicPartManager)
  {
    super(paramQzEditPicPartManager);
  }
  
  public void a()
  {
    super.a();
    this.a = ((LinearLayout)a(2131365536));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      this.a.setVisibility(8);
      return;
    }
    this.a.setVisibility(0);
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.arg1)
    {
    }
    for (;;)
    {
      return super.a(paramMessage);
      this.a.setVisibility(8);
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditTimerDelete
 * JD-Core Version:    0.7.0.1
 */