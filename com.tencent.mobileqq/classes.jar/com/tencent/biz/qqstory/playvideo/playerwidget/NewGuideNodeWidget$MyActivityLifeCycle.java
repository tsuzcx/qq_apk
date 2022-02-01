package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.SimpleActivityLifeCycle;

public class NewGuideNodeWidget$MyActivityLifeCycle
  extends SimpleActivityLifeCycle
{
  public NewGuideNodeWidget$MyActivityLifeCycle(NewGuideNodeWidget paramNewGuideNodeWidget) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 20000) && (paramInt2 == -1)) {
      this.a.y().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.NewGuideNodeWidget.MyActivityLifeCycle
 * JD-Core Version:    0.7.0.1
 */