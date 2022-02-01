package com.tencent.aelight.camera.aeeditor.module.text;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.aeeditor.util.AEEditorTextPagUtils;
import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.weseevideo.model.effect.StickerModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AEEditorTextBaseViewModel
  extends ViewModel
{
  protected final MutableLiveData<Integer> a;
  protected TextEditorData a;
  protected final String a;
  protected List<MetaMaterial> a;
  private final Set<String> a;
  protected final MutableLiveData<TextEditorData> b;
  protected String b;
  protected final MutableLiveData<StickerModel> c = new MutableLiveData();
  
  public AEEditorTextBaseViewModel()
  {
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
  }
  
  private void a(@NonNull StickerModel paramStickerModel, @NonNull MetaMaterial paramMetaMaterial, String paramString)
  {
    if ("blur".equals(paramString))
    {
      paramStickerModel.setType("blur");
      paramStickerModel.setEnableRotate(false);
      paramStickerModel.setLockRatio(false);
      paramStickerModel.setTexturePngPath(TextMetaMaterialKt.h(paramMetaMaterial));
      paramStickerModel.setTextPngPath(TextMetaMaterialKt.g(paramMetaMaterial));
    }
  }
  
  public int a(String paramString)
  {
    return a(paramString, this.jdField_a_of_type_JavaUtilList);
  }
  
  final int a(String paramString, List<MetaMaterial> paramList)
  {
    if ((paramList != null) && (paramString != null))
    {
      int i = 0;
      while (i < paramList.size())
      {
        if (paramString.equals(((MetaMaterial)paramList.get(i)).id)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public LiveData<TextEditorData> a()
  {
    return this.jdField_b_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public MetaMaterial a(String paramString)
  {
    return a(paramString, this.jdField_a_of_type_JavaUtilList);
  }
  
  final MetaMaterial a(String paramString, List<MetaMaterial> paramList)
  {
    if (paramList == null) {
      return null;
    }
    int i = a(paramString, paramList);
    if (i == -1) {
      return null;
    }
    return (MetaMaterial)paramList.get(i);
  }
  
  public TextEditorData a()
  {
    return this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData;
  }
  
  public Map<String, MetaMaterial> a(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      HashMap localHashMap = new HashMap();
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        MetaMaterial localMetaMaterial = a(str);
        if (localMetaMaterial != null)
        {
          localArrayList.add(localMetaMaterial);
          localHashMap.put(str, localMetaMaterial);
        }
      }
      AEEditorTextPagUtils.a(localArrayList);
      return localHashMap;
    }
    return null;
  }
  
  public void a()
  {
    TextEditorData localTextEditorData = this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData;
    if (localTextEditorData != null) {
      this.jdField_a_of_type_JavaUtilSet.remove(localTextEditorData.getUniqueID());
    }
    a(null);
  }
  
  public final void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null)
    {
      boolean bool = "color_text".equals(this.jdField_b_of_type_JavaLangString);
      int i = 1;
      if (bool)
      {
        if (TextEditorDataExKt.a(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData) != paramInt)
        {
          TextEditorDataExKt.a(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData, paramInt);
          paramInt = i;
          break label73;
        }
      }
      else if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getTextColor() != paramInt)
      {
        this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setTextColor(paramInt);
        paramInt = i;
        break label73;
      }
      paramInt = 0;
      label73:
      if (paramInt != 0) {
        this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.postValue(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
      }
    }
  }
  
  abstract void a(MetaMaterial paramMetaMaterial);
  
  public abstract void a(@Nullable TextEditorData paramTextEditorData);
  
  final void a(@NonNull TextEditorData paramTextEditorData, @NonNull MetaMaterial paramMetaMaterial, String paramString)
  {
    if ("blur".equals(paramString))
    {
      paramTextEditorData.setStickerType("blur");
      paramTextEditorData.setBlurTextPath(AEEditorResourceManager.a().g(paramMetaMaterial));
      paramTextEditorData.setBlurTexturePath(AEEditorResourceManager.a().h(paramMetaMaterial));
      return;
    }
    paramTextEditorData.setStickerType("");
    paramTextEditorData.setBlurTextPath("");
    paramTextEditorData.setBlurTexturePath("");
  }
  
  public final void a(String paramString)
  {
    TextEditorData localTextEditorData = this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData;
    if (localTextEditorData != null) {
      localTextEditorData.setUniqueID(paramString);
    }
  }
  
  final boolean a()
  {
    return this.jdField_a_of_type_JavaUtilSet.contains(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getUniqueID()) ^ true;
  }
  
  public LiveData<StickerModel> b()
  {
    return this.c;
  }
  
  final void b(@NonNull MetaMaterial paramMetaMaterial)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void b(TextEditorData paramTextEditorData)
  {
    if ((this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null) && (paramTextEditorData.getContent() != null) && (!paramTextEditorData.getContent().equals(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getContent())))
    {
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setContent(paramTextEditorData.getContent());
      this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.postValue(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
      this.jdField_a_of_type_JavaUtilSet.add(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getUniqueID());
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaUtilSet.add(paramString);
  }
  
  LiveData<Integer> c()
  {
    return this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextBaseViewModel
 * JD-Core Version:    0.7.0.1
 */