package com.tencent.aelight.camera.aeeditor.module.text;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.tavcut.bean.TextEditorData;
import java.util.List;

public class AEEditorStickerViewModel
  extends AEEditorTextBaseViewModel
{
  void a(@NonNull MetaMaterial paramMetaMaterial)
  {
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData == null)
    {
      AEQLog.d(this.jdField_a_of_type_JavaLangString, "[updateText] mCurSticker is null");
      return;
    }
    this.jdField_b_of_type_JavaLangString = TextMetaMaterialKt.a(paramMetaMaterial);
    this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setItemID(paramMetaMaterial.id);
    this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setPagFilePath(TextMetaMaterialKt.f(paramMetaMaterial));
    this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setTextColor(TextMetaMaterialKt.a(paramMetaMaterial));
    TextEditorDataExKt.a(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData, TextMetaMaterialKt.c(paramMetaMaterial));
    TextEditorData localTextEditorData = this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData;
    String str;
    if (TextMetaMaterialKt.b(paramMetaMaterial)) {
      str = "1";
    } else {
      str = "0";
    }
    localTextEditorData.setInteractive(str);
    a(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData, paramMetaMaterial, this.jdField_b_of_type_JavaLangString);
    paramMetaMaterial = AEEditorResourceManager.a().a(TextMetaMaterialKt.d(paramMetaMaterial), 0);
    this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setFont(paramMetaMaterial);
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.postValue(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
  }
  
  public void a(@NonNull MetaMaterial paramMetaMaterial, @Nullable Boolean paramBoolean)
  {
    if (paramBoolean != null)
    {
      if (paramMetaMaterial.id == null) {
        return;
      }
      if ((paramBoolean.booleanValue()) && (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null))
      {
        a(paramMetaMaterial);
        return;
      }
      b(paramMetaMaterial);
    }
  }
  
  public void a(@Nullable TextEditorData paramTextEditorData)
  {
    this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = paramTextEditorData;
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData == null) {
      paramTextEditorData = null;
    } else {
      paramTextEditorData = this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getItemID();
    }
    if (paramTextEditorData == null)
    {
      this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.postValue(Integer.valueOf(-1));
      return;
    }
    if ("sticker_lyric".equals(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getStickerType()))
    {
      this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.postValue(Integer.valueOf(-1));
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if ((this.jdField_a_of_type_JavaUtilList.get(i) != null) && (paramTextEditorData.equals(((MetaMaterial)this.jdField_a_of_type_JavaUtilList.get(i)).id))) {
          break label141;
        }
        i += 1;
      }
    }
    int i = 0;
    label141:
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.postValue(Integer.valueOf(i));
  }
  
  public void a(List<MetaMaterial> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerViewModel
 * JD-Core Version:    0.7.0.1
 */