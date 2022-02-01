package com.tencent.aelight.camera.aeeditor.module.toolbar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.aelight.camera.ae.util.AEThemeUtil;

public class VideoEditToolBar
  extends AEEditorToolBar
{
  private boolean b = false;
  private boolean c = false;
  
  public VideoEditToolBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoEditToolBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoEditToolBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a()
  {
    this.c = AEThemeUtil.b();
    a(0, "clip", 2063925403, 2063925294);
    a(1, "text", 2063925419, 2063925294);
    a(2, "music", 2063925466, 2063925294);
  }
  
  void a(String paramString)
  {
    VideoEditToolBar.VideoToolBarListener localVideoToolBarListener;
    if ((this.a != null) && ((this.a instanceof VideoEditToolBar.VideoToolBarListener))) {
      localVideoToolBarListener = (VideoEditToolBar.VideoToolBarListener)this.a;
    } else {
      localVideoToolBarListener = null;
    }
    if (paramString.equals("clip"))
    {
      if (localVideoToolBarListener != null) {
        localVideoToolBarListener.P();
      }
    }
    else if ((paramString.equals("music")) && (localVideoToolBarListener != null)) {
      localVideoToolBarListener.W();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.toolbar.VideoEditToolBar
 * JD-Core Version:    0.7.0.1
 */