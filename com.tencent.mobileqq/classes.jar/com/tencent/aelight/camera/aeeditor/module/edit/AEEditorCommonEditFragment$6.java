package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.aelight.camera.aeeditor.module.edit.widgets.AEEditorCheckGroupView;
import com.tencent.aelight.camera.aeeditor.module.edit.widgets.AEEditorCheckGroupView.OnCheckedChangeListener;
import com.tencent.aelight.camera.aeeditor.module.toolbar.VideoEditToolBar.VideoToolBarListener;
import com.tencent.aelight.camera.aeeditor.module.topbar.AEEditorTopBar;
import com.tencent.mobileqq.app.HardCodeUtil;
import org.jetbrains.annotations.NotNull;

class AEEditorCommonEditFragment$6
  implements AEEditorCheckGroupView.OnCheckedChangeListener
{
  AEEditorCommonEditFragment$6(AEEditorCommonEditFragment paramAEEditorCommonEditFragment) {}
  
  public boolean a(boolean paramBoolean, @NotNull AEEditorCheckGroupView paramAEEditorCheckGroupView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      break;
    case 2063991380: 
      this.a.m();
      break;
    case 2063991375: 
      paramAEEditorCheckGroupView = this.a;
      if ((paramAEEditorCheckGroupView instanceof VideoEditToolBar.VideoToolBarListener)) {
        ((VideoEditToolBar.VideoToolBarListener)paramAEEditorCheckGroupView).W();
      }
      break;
    case 2063991372: 
      paramAEEditorCheckGroupView = this.a;
      if ((paramAEEditorCheckGroupView instanceof AEEditorImageEditFragment)) {
        paramAEEditorCheckGroupView.f.setTitle(HardCodeUtil.a(2064187495));
      } else {
        paramAEEditorCheckGroupView.f.setTitle(HardCodeUtil.a(2064187496));
      }
      break;
    case 2063991368: 
      this.a.f.setTitle(HardCodeUtil.a(2064187496));
      paramAEEditorCheckGroupView = this.a;
      if ((paramAEEditorCheckGroupView instanceof VideoEditToolBar.VideoToolBarListener)) {
        ((VideoEditToolBar.VideoToolBarListener)paramAEEditorCheckGroupView).V();
      }
      break;
    case 2063991222: 
      this.a.n();
    }
    this.a.a(paramBoolean, paramInt);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorCommonEditFragment.6
 * JD-Core Version:    0.7.0.1
 */