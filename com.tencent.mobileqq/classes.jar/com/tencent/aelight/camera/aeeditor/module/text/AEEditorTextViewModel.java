package com.tencent.aelight.camera.aeeditor.module.text;

import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tavcut.bean.TextEditorData;
import java.util.ArrayList;
import java.util.List;

public class AEEditorTextViewModel
  extends AEEditorTextBaseViewModel
{
  private final List<MetaMaterial> b;
  private final String jdField_c_of_type_JavaLangString = BaseApplicationImpl.getContext().getResources().getString(2064515191);
  private final List<MetaMaterial> jdField_c_of_type_JavaUtilList = new ArrayList();
  private final MutableLiveData<String> jdField_d_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  private String jdField_d_of_type_JavaLangString;
  private final List<MetaMaterial> jdField_d_of_type_JavaUtilList = new ArrayList();
  private final MutableLiveData<List<MetaMaterial>> e = new MutableLiveData();
  private final MutableLiveData<Integer> f = new MutableLiveData();
  
  public AEEditorTextViewModel()
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private String a(String paramString)
  {
    if (a(paramString, this.jdField_b_of_type_JavaUtilList) != null) {
      return "CATEGORY_FONT_TYPE";
    }
    if (a(paramString, this.jdField_c_of_type_JavaUtilList) != null) {
      return "CATEGORY_FONT_PATTERN";
    }
    if (a(paramString, this.jdField_d_of_type_JavaUtilList) != null) {
      return "CATEGORY_FONT_STYLE";
    }
    return null;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    return ("CATEGORY_FONT_TYPE".equals(paramString1)) && ("CATEGORY_FONT_TYPE".equals(paramString2));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null)
    {
      String str = this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getItemID();
      boolean bool = b(a(str), this.jdField_d_of_type_JavaLangString);
      int k = 0;
      int i;
      int j;
      if (bool)
      {
        i = k;
        if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getFontPath() != null)
        {
          i = k;
          if (this.jdField_b_of_type_JavaUtilList != null)
          {
            j = 0;
            for (;;)
            {
              i = k;
              if (j >= this.jdField_b_of_type_JavaUtilList.size()) {
                break;
              }
              str = TextMetaMaterialKt.d((MetaMaterial)this.jdField_b_of_type_JavaUtilList.get(j));
              if ((!str.isEmpty()) && (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getFontPath().contains(str)))
              {
                i = j;
                break;
              }
              j += 1;
            }
          }
        }
      }
      else
      {
        i = k;
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          j = 0;
          for (;;)
          {
            i = k;
            if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
              break;
            }
            if ((this.jdField_a_of_type_JavaUtilList.get(j) != null) && (str.equals(((MetaMaterial)this.jdField_a_of_type_JavaUtilList.get(j)).id)))
            {
              i = j;
              break;
            }
            j += 1;
          }
        }
      }
      this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.postValue(Integer.valueOf(i));
    }
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    return (("CATEGORY_FONT_PATTERN".equals(paramString1)) || ("CATEGORY_FONT_STYLE".equals(paramString1))) && ("CATEGORY_FONT_TYPE".equals(paramString2));
  }
  
  private void c()
  {
    Integer localInteger;
    if (("CATEGORY_FONT_TYPE".equals(this.jdField_d_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null)) {
      localInteger = Integer.valueOf(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getTextColor());
    } else {
      localInteger = null;
    }
    this.f.postValue(localInteger);
  }
  
  private void c(String paramString)
  {
    if ((paramString != null) && (!paramString.equals(this.jdField_d_of_type_JavaLangString)))
    {
      this.jdField_d_of_type_JavaLangString = paramString;
      paramString = this.jdField_d_of_type_JavaLangString;
      int i = -1;
      int j = paramString.hashCode();
      if (j != -1778477271)
      {
        if (j != 162245921)
        {
          if ((j == 700715906) && (paramString.equals("CATEGORY_FONT_STYLE"))) {
            i = 2;
          }
        }
        else if (paramString.equals("CATEGORY_FONT_PATTERN")) {
          i = 1;
        }
      }
      else if (paramString.equals("CATEGORY_FONT_TYPE")) {
        i = 0;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            this.jdField_a_of_type_JavaUtilList = this.jdField_d_of_type_JavaUtilList;
          }
        }
        else {
          this.jdField_a_of_type_JavaUtilList = this.jdField_c_of_type_JavaUtilList;
        }
      }
      else {
        this.jdField_a_of_type_JavaUtilList = this.jdField_b_of_type_JavaUtilList;
      }
      this.jdField_d_of_type_AndroidxLifecycleMutableLiveData.postValue(this.jdField_d_of_type_JavaLangString);
      this.e.postValue(this.jdField_a_of_type_JavaUtilList);
      b();
      c();
      return;
    }
    b();
    c();
  }
  
  private void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null)
    {
      if (paramString == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setItemID(paramString);
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setPagFilePath(AEEditorResourceManager.a().c());
      if (a()) {
        this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setContent(this.jdField_c_of_type_JavaLangString);
      }
      this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.postValue(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
    }
  }
  
  public int a(String paramString)
  {
    int i = a(paramString, this.jdField_b_of_type_JavaUtilList);
    if (i >= 0) {
      return i;
    }
    i = a(paramString, this.jdField_c_of_type_JavaUtilList);
    if (i >= 0) {
      return i;
    }
    return a(paramString, this.jdField_d_of_type_JavaUtilList);
  }
  
  public MetaMaterial a(String paramString)
  {
    MetaMaterial localMetaMaterial = a(paramString, this.jdField_b_of_type_JavaUtilList);
    if (localMetaMaterial != null) {
      return localMetaMaterial;
    }
    localMetaMaterial = a(paramString, this.jdField_c_of_type_JavaUtilList);
    if (localMetaMaterial != null) {
      return localMetaMaterial;
    }
    return a(paramString, this.jdField_d_of_type_JavaUtilList);
  }
  
  public List<MetaMaterial> a()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = this.jdField_c_of_type_JavaUtilList;
    if (localList != null) {
      localArrayList.addAll(localList);
    }
    localList = this.jdField_d_of_type_JavaUtilList;
    if (localList != null) {
      localArrayList.addAll(localList);
    }
    localList = this.jdField_b_of_type_JavaUtilList;
    if (localList != null) {
      localArrayList.addAll(localList);
    }
    return localArrayList;
  }
  
  void a(@NonNull MetaMaterial paramMetaMaterial)
  {
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData == null)
    {
      AEQLog.d(this.jdField_a_of_type_JavaLangString, "[updateText] mCurText is null");
      return;
    }
    this.jdField_b_of_type_JavaLangString = TextMetaMaterialKt.a(paramMetaMaterial);
    String str1 = AEEditorResourceManager.a().a(TextMetaMaterialKt.d(paramMetaMaterial), 0);
    this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setFont(str1);
    str1 = TextMetaMaterialKt.e(paramMetaMaterial);
    String str2 = a(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getItemID());
    if (a(str2, MetaMaterialKt.d(paramMetaMaterial)))
    {
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setItemID(paramMetaMaterial.id);
    }
    else if (b(str2, MetaMaterialKt.d(paramMetaMaterial)))
    {
      str1 = this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getContent();
    }
    else
    {
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setItemID(paramMetaMaterial.id);
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setPagFilePath(TextMetaMaterialKt.f(paramMetaMaterial));
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setTextColor(TextMetaMaterialKt.a(paramMetaMaterial));
      TextEditorDataExKt.a(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData, TextMetaMaterialKt.c(paramMetaMaterial));
    }
    a(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData, paramMetaMaterial, this.jdField_b_of_type_JavaLangString);
    if ((!"blur".equals(this.jdField_b_of_type_JavaLangString)) && (a())) {
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setContent(str1);
    }
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.postValue(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
  }
  
  public void a(@NonNull MetaMaterial paramMetaMaterial, @Nullable Boolean paramBoolean)
  {
    if (paramBoolean != null)
    {
      if (paramMetaMaterial.id == null) {
        return;
      }
      if ((!"FONT_PATTERN_NON_ID".equals(paramMetaMaterial.id)) && (!"FONT_STYLE_NON_ID".equals(paramMetaMaterial.id)))
      {
        if (paramBoolean.booleanValue())
        {
          a(paramMetaMaterial);
          return;
        }
        b(paramMetaMaterial);
        c();
        return;
      }
      d(paramMetaMaterial.id);
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
      c();
      return;
    }
    if ("sticker_lyric".equals(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getStickerType()))
    {
      this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.postValue(Integer.valueOf(-1));
      return;
    }
    paramTextEditorData = a(paramTextEditorData);
    if (paramTextEditorData == null)
    {
      this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.postValue(Integer.valueOf(-1));
      c();
      return;
    }
    this.jdField_b_of_type_JavaLangString = TextMetaMaterialKt.a(paramTextEditorData);
    c(MetaMaterialKt.d(paramTextEditorData));
  }
  
  public void a(List<MetaCategory> paramList)
  {
    if (paramList.size() >= 3)
    {
      if (((MetaCategory)paramList.get(0)).materials != null)
      {
        this.jdField_b_of_type_JavaUtilList.clear();
        this.jdField_b_of_type_JavaUtilList.addAll(TextMetaMaterialKt.a("CATEGORY_FONT_TYPE", ((MetaCategory)paramList.get(0)).materials));
        if ((((MetaCategory)paramList.get(0)).materials.size() > 0) && (((MetaCategory)paramList.get(0)).materials.get(0) != null))
        {
          MetaMaterial localMetaMaterial = TextMetaMaterialHelper.a.a((MetaMaterial)((MetaCategory)paramList.get(0)).materials.get(0));
          TextMetaMaterialKt.i(localMetaMaterial, "CATEGORY_FONT_TYPE");
          this.jdField_b_of_type_JavaUtilList.add(0, localMetaMaterial);
        }
      }
      if (((MetaCategory)paramList.get(1)).materials != null)
      {
        this.jdField_c_of_type_JavaUtilList.clear();
        this.jdField_c_of_type_JavaUtilList.addAll(TextMetaMaterialKt.a("CATEGORY_FONT_PATTERN", ((MetaCategory)paramList.get(1)).materials));
        this.jdField_c_of_type_JavaUtilList.add(0, TextMetaMaterialHelper.a.a("FONT_PATTERN_NON_ID"));
      }
      if (((MetaCategory)paramList.get(2)).materials != null)
      {
        this.jdField_d_of_type_JavaUtilList.clear();
        this.jdField_d_of_type_JavaUtilList.addAll(TextMetaMaterialKt.a("CATEGORY_FONT_STYLE", ((MetaCategory)paramList.get(2)).materials));
        this.jdField_d_of_type_JavaUtilList.add(0, TextMetaMaterialHelper.a.a("FONT_STYLE_NON_ID"));
      }
      c("CATEGORY_FONT_TYPE");
    }
  }
  
  void b(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = null;
      break;
    case 2064122765: 
      str = "CATEGORY_FONT_TYPE";
      break;
    case 2064122764: 
      str = "CATEGORY_FONT_STYLE";
      break;
    case 2064122763: 
      str = "CATEGORY_FONT_PATTERN";
    }
    c(str);
  }
  
  LiveData<String> d()
  {
    return this.jdField_d_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  LiveData<List<MetaMaterial>> e()
  {
    return this.e;
  }
  
  LiveData<Integer> f()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextViewModel
 * JD-Core Version:    0.7.0.1
 */