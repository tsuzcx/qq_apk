package com.tencent.aelight.camera.aeeditor.module.text;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.aeeditor.util.AEEditorTextPagUtils;
import com.tencent.qcircle.tavcut.bean.TextEditorData;
import com.tencent.qcircle.weseevideo.model.effect.StickerModel;
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
  protected final String a = getClass().getSimpleName();
  protected final MutableLiveData<Integer> b = new MutableLiveData();
  protected final MutableLiveData<TextEditorData> c = new MutableLiveData();
  protected final MutableLiveData<StickerModel> d = new MutableLiveData();
  protected List<MetaMaterial> e;
  protected TextEditorData f;
  protected String g;
  private final Set<String> h = new HashSet();
  
  private void a(@NonNull StickerModel paramStickerModel, @NonNull MetaMaterial paramMetaMaterial, String paramString)
  {
    if ("blur".equals(paramString))
    {
      paramStickerModel.setType("blur");
      paramStickerModel.setEnableRotate(false);
      paramStickerModel.setLockRatio(false);
      paramStickerModel.setTexturePngPath(TextMetaMaterialKt.o(paramMetaMaterial));
      paramStickerModel.setTextPngPath(TextMetaMaterialKt.n(paramMetaMaterial));
    }
  }
  
  public MetaMaterial a(String paramString)
  {
    return a(paramString, this.e);
  }
  
  final MetaMaterial a(String paramString, List<MetaMaterial> paramList)
  {
    if (paramList == null) {
      return null;
    }
    int i = b(paramString, paramList);
    if (i == -1) {
      return null;
    }
    return (MetaMaterial)paramList.get(i);
  }
  
  public void a()
  {
    TextEditorData localTextEditorData = this.f;
    if (localTextEditorData != null) {
      this.h.remove(localTextEditorData.getUniqueID());
    }
    a(null);
  }
  
  public final void a(int paramInt)
  {
    if (this.f != null)
    {
      boolean bool = "color_text".equals(this.g);
      int i = 1;
      if (bool)
      {
        if (TextEditorDataExKt.a(this.f) != paramInt)
        {
          TextEditorDataExKt.a(this.f, paramInt);
          paramInt = i;
          break label73;
        }
      }
      else if (this.f.getTextColor() != paramInt)
      {
        this.f.setTextColor(paramInt);
        paramInt = i;
        break label73;
      }
      paramInt = 0;
      label73:
      if (paramInt != 0) {
        this.c.postValue(this.f);
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
      paramTextEditorData.setBlurTextPath(AEEditorResourceManager.a().h(paramMetaMaterial));
      paramTextEditorData.setBlurTexturePath(AEEditorResourceManager.a().i(paramMetaMaterial));
      return;
    }
    paramTextEditorData.setStickerType("");
    paramTextEditorData.setBlurTextPath("");
    paramTextEditorData.setBlurTexturePath("");
  }
  
  public int b(String paramString)
  {
    return b(paramString, this.e);
  }
  
  final int b(String paramString, List<MetaMaterial> paramList)
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
  
  public TextEditorData b()
  {
    return this.f;
  }
  
  public Map<String, MetaMaterial> b(List<String> paramList)
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
  
  final void b(@NonNull MetaMaterial paramMetaMaterial)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void b(TextEditorData paramTextEditorData)
  {
    if ((this.f != null) && (paramTextEditorData.getContent() != null) && (!paramTextEditorData.getContent().equals(this.f.getContent())))
    {
      this.f.setContent(paramTextEditorData.getContent());
      this.c.postValue(this.f);
      this.h.add(this.f.getUniqueID());
    }
  }
  
  public LiveData<TextEditorData> c()
  {
    return this.c;
  }
  
  public final void c(String paramString)
  {
    TextEditorData localTextEditorData = this.f;
    if (localTextEditorData != null) {
      localTextEditorData.setUniqueID(paramString);
    }
  }
  
  public LiveData<StickerModel> d()
  {
    return this.d;
  }
  
  public void d(String paramString)
  {
    this.h.add(paramString);
  }
  
  LiveData<Integer> e()
  {
    return this.b;
  }
  
  final boolean f()
  {
    return this.h.contains(this.f.getUniqueID()) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextBaseViewModel
 * JD-Core Version:    0.7.0.1
 */