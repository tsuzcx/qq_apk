package com.tencent.aelight.camera.aeeditor.module.edit;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.module.edit.widgets.AEEditorCheckGroupView;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerControlPanel;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerPart;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerViewModel;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextControlPanel;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextViewModel;
import com.tencent.aelight.camera.aeeditor.module.text.TextMetaMaterialKt;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qcircle.tavcut.bean.TextEditorData;
import com.tencent.qcircle.tavcut.session.callback.StickerOperationCallback;

class AEEditorVideoEditFragment$11
  implements StickerOperationCallback
{
  AEEditorVideoEditFragment$11(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void onAddStickerDone(String paramString)
  {
    this.a.v.c(paramString);
    this.a.w.c(paramString);
  }
  
  public void onDeleteButtonClick(String paramString)
  {
    this.a.v.a();
    this.a.w.a();
    AEQLog.a(AEEditorVideoEditFragment.aj(), "[onDeleteButtonClick]textEditorData = null");
  }
  
  public void onStickerClick(TextEditorData paramTextEditorData)
  {
    int i;
    if (this.a.w.a(paramTextEditorData.getItemID()) != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (this.a.k.getVisibility() != 0)
      {
        onStickerSelect(paramTextEditorData);
        return;
      }
      onTextEditButtonClick(paramTextEditorData);
      return;
    }
    if (this.a.h.getVisibility() != 0)
    {
      onStickerSelect(paramTextEditorData);
      return;
    }
    onTextEditButtonClick(paramTextEditorData);
  }
  
  public void onStickerMoving(String paramString) {}
  
  public void onStickerOutsideClick()
  {
    AEEditorVideoEditFragment.n(this.a);
    AEQLog.a(AEEditorVideoEditFragment.aj(), "[onStickerOutsideClick]textEditorData = null");
  }
  
  public void onStickerSelect(TextEditorData paramTextEditorData)
  {
    if (paramTextEditorData == null) {
      return;
    }
    if (this.a.v.a(paramTextEditorData.getItemID()) != null)
    {
      this.a.l.a(2063991380);
      this.a.v.a(paramTextEditorData);
      return;
    }
    if (this.a.w.a(paramTextEditorData.getItemID()) != null)
    {
      this.a.l.a(2063991222);
      this.a.w.a(paramTextEditorData);
    }
  }
  
  public void onStickerTouchEnd(TextEditorData paramTextEditorData)
  {
    if (paramTextEditorData == null) {
      return;
    }
    if (this.a.v.a(paramTextEditorData.getItemID()) != null)
    {
      if (this.a.h.getVisibility() != 0)
      {
        this.a.r.removeMessages(0);
        this.a.r.sendEmptyMessageDelayed(0, 2000L);
      }
      this.a.l.a(2063991380);
      this.a.v.a(paramTextEditorData);
    }
    else if (this.a.w.a(paramTextEditorData.getItemID()) != null)
    {
      if (this.a.k.getVisibility() != 0)
      {
        this.a.r.removeMessages(0);
        this.a.r.sendEmptyMessageDelayed(0, 2000L);
      }
      this.a.l.a(2063991222);
      this.a.w.a(paramTextEditorData);
    }
    else if ("sticker_lyric".equals(paramTextEditorData.getStickerType()))
    {
      this.a.r.removeMessages(0);
      this.a.r.sendEmptyMessageDelayed(0, 2000L);
    }
    this.a.r.removeMessages(0);
  }
  
  public void onStickerTouchStart(TextEditorData paramTextEditorData)
  {
    this.a.r.removeMessages(0);
  }
  
  public void onTextEditButtonClick(TextEditorData paramTextEditorData)
  {
    if (paramTextEditorData == null) {
      return;
    }
    MetaMaterial localMetaMaterial2 = this.a.v.a(paramTextEditorData.getItemID());
    MetaMaterial localMetaMaterial1 = localMetaMaterial2;
    if (localMetaMaterial2 == null) {
      localMetaMaterial1 = this.a.w.a(paramTextEditorData.getItemID());
    }
    if (localMetaMaterial1 != null)
    {
      if ("blur".equals(TextMetaMaterialKt.b(localMetaMaterial1))) {
        this.a.d(false);
      }
      this.a.p.a(this.a.getActivity(), localMetaMaterial1, paramTextEditorData);
    }
  }
  
  public void onUpdateTextStickerDone(String paramString)
  {
    this.a.v.c(paramString);
    this.a.w.c(paramString);
    String str = AEEditorVideoEditFragment.aj();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onUpdateTextStickerDone] uniqueId:");
    localStringBuilder.append(paramString);
    AEQLog.d(str, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.11
 * JD-Core Version:    0.7.0.1
 */