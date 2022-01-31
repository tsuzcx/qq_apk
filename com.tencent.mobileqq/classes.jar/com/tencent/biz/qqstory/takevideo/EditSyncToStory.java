package com.tencent.biz.qqstory.takevideo;

import android.content.Intent;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.qqonly.QzEditPicPartManager;

public class EditSyncToStory
  extends EditVideoPart
  implements View.OnClickListener
{
  private View a;
  
  public EditSyncToStory(@NonNull QzEditPicPartManager paramQzEditPicPartManager)
  {
    super(paramQzEditPicPartManager);
  }
  
  public void a()
  {
    super.a();
    this.a = a(2131373566);
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
      if (this.a != null) {
        this.a.setVisibility(8);
      }
      break;
    }
    do
    {
      return;
    } while (this.a == null);
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
      if (this.a != null) {
        this.a.setVisibility(8);
      }
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditSyncToStory
 * JD-Core Version:    0.7.0.1
 */