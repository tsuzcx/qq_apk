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
    case 2064122562: 
      this.a.f();
      break;
    case 2064122558: 
      paramAEEditorCheckGroupView = this.a;
      if ((paramAEEditorCheckGroupView instanceof VideoEditToolBar.VideoToolBarListener)) {
        ((VideoEditToolBar.VideoToolBarListener)paramAEEditorCheckGroupView).E();
      }
      break;
    case 2064122555: 
      paramAEEditorCheckGroupView = this.a;
      if ((paramAEEditorCheckGroupView instanceof AEEditorImageEditFragment)) {
        paramAEEditorCheckGroupView.a.setTitle(HardCodeUtil.a(2064515153));
      } else {
        paramAEEditorCheckGroupView.a.setTitle(HardCodeUtil.a(2064515154));
      }
      break;
    case 2064122551: 
      this.a.a.setTitle(HardCodeUtil.a(2064515154));
      paramAEEditorCheckGroupView = this.a;
      if ((paramAEEditorCheckGroupView instanceof VideoEditToolBar.VideoToolBarListener)) {
        ((VideoEditToolBar.VideoToolBarListener)paramAEEditorCheckGroupView).z();
      }
      break;
    case 2064122349: 
      this.a.g();
    }
    this.a.a(paramBoolean, paramInt);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorCommonEditFragment.6
 * JD-Core Version:    0.7.0.1
 */