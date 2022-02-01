package com.tencent.aelight.camera.aeeditor.module.toolbar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.aelight.camera.ae.util.AEThemeUtil;

public class VideoEditToolBar
  extends AEEditorToolBar
{
  private boolean a;
  private boolean b = false;
  
  public VideoEditToolBar(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public VideoEditToolBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public VideoEditToolBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void a()
  {
    this.b = AEThemeUtil.a();
    a(0, "clip", 2064056434, 2064056357);
    a(1, "text", 2064056450, 2064056357);
    a(2, "music", 2064056503, 2064056357);
  }
  
  void a(String paramString)
  {
    VideoEditToolBar.VideoToolBarListener localVideoToolBarListener;
    if ((this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleToolbarAEEditorToolBar$ToolBarBaseListener != null) && ((this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleToolbarAEEditorToolBar$ToolBarBaseListener instanceof VideoEditToolBar.VideoToolBarListener))) {
      localVideoToolBarListener = (VideoEditToolBar.VideoToolBarListener)this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleToolbarAEEditorToolBar$ToolBarBaseListener;
    } else {
      localVideoToolBarListener = null;
    }
    if (paramString.equals("clip"))
    {
      if (localVideoToolBarListener != null) {
        localVideoToolBarListener.y();
      }
    }
    else if ((paramString.equals("music")) && (localVideoToolBarListener != null)) {
      localVideoToolBarListener.E();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.toolbar.VideoEditToolBar
 * JD-Core Version:    0.7.0.1
 */