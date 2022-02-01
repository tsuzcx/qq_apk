package com.tencent.aelight.camera.aeeditor.module.text;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qcircle.tavcut.bean.TextEditorData;
import java.util.List;

public class AEEditorStickerViewModel
  extends AEEditorTextBaseViewModel
{
  void a(@NonNull MetaMaterial paramMetaMaterial)
  {
    if (this.f == null)
    {
      AEQLog.d(this.a, "[updateText] mCurSticker is null");
      return;
    }
    this.g = TextMetaMaterialKt.b(paramMetaMaterial);
    this.f.setItemID(paramMetaMaterial.id);
    this.f.setPagFilePath(TextMetaMaterialKt.m(paramMetaMaterial));
    this.f.setTextColor(TextMetaMaterialKt.g(paramMetaMaterial));
    TextEditorDataExKt.a(this.f, TextMetaMaterialKt.i(paramMetaMaterial));
    TextEditorData localTextEditorData = this.f;
    String str;
    if (TextMetaMaterialKt.p(paramMetaMaterial)) {
      str = "1";
    } else {
      str = "0";
    }
    localTextEditorData.setInteractive(str);
    a(this.f, paramMetaMaterial, this.g);
    paramMetaMaterial = AEEditorResourceManager.a().a(TextMetaMaterialKt.e(paramMetaMaterial), 0);
    this.f.setFont(paramMetaMaterial);
    this.c.postValue(this.f);
  }
  
  public void a(@NonNull MetaMaterial paramMetaMaterial, @Nullable Boolean paramBoolean)
  {
    if (paramBoolean != null)
    {
      if (paramMetaMaterial.id == null) {
        return;
      }
      if ((paramBoolean.booleanValue()) && (this.f != null))
      {
        a(paramMetaMaterial);
        return;
      }
      b(paramMetaMaterial);
    }
  }
  
  public void a(@Nullable TextEditorData paramTextEditorData)
  {
    this.f = paramTextEditorData;
    if (this.f == null) {
      paramTextEditorData = null;
    } else {
      paramTextEditorData = this.f.getItemID();
    }
    if (paramTextEditorData == null)
    {
      this.b.postValue(Integer.valueOf(-1));
      return;
    }
    if ("sticker_lyric".equals(this.f.getStickerType()))
    {
      this.b.postValue(Integer.valueOf(-1));
      return;
    }
    if (this.e != null)
    {
      i = 0;
      while (i < this.e.size())
      {
        if ((this.e.get(i) != null) && (paramTextEditorData.equals(((MetaMaterial)this.e.get(i)).id))) {
          break label141;
        }
        i += 1;
      }
    }
    int i = 0;
    label141:
    this.b.postValue(Integer.valueOf(i));
  }
  
  public void a(List<MetaMaterial> paramList)
  {
    this.e = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerViewModel
 * JD-Core Version:    0.7.0.1
 */