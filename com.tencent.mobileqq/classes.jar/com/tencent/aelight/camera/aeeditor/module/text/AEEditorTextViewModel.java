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
import com.tencent.qcircle.tavcut.bean.TextEditorData;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class AEEditorTextViewModel
  extends AEEditorTextBaseViewModel
{
  private final MutableLiveData<String> h = new MutableLiveData();
  private final MutableLiveData<List<MetaMaterial>> i = new MutableLiveData();
  private final MutableLiveData<Integer> j = new MutableLiveData();
  private final List<MetaMaterial> k = new ArrayList();
  private final List<MetaMaterial> l = new ArrayList();
  private final List<MetaMaterial> m = new ArrayList();
  private final String n = BaseApplicationImpl.getContext().getResources().getString(2064187537);
  private String o;
  
  private boolean a(String paramString1, String paramString2)
  {
    return ("CATEGORY_FONT_TYPE".equals(paramString1)) && ("CATEGORY_FONT_TYPE".equals(paramString2));
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    return (("CATEGORY_FONT_PATTERN".equals(paramString1)) || ("CATEGORY_FONT_STYLE".equals(paramString1))) && ("CATEGORY_FONT_TYPE".equals(paramString2));
  }
  
  private void e(String paramString)
  {
    if ((paramString != null) && (!paramString.equals(this.o)))
    {
      this.o = paramString;
      paramString = this.o;
      int i1 = -1;
      int i2 = paramString.hashCode();
      if (i2 != -1778477271)
      {
        if (i2 != 162245921)
        {
          if ((i2 == 700715906) && (paramString.equals("CATEGORY_FONT_STYLE"))) {
            i1 = 2;
          }
        }
        else if (paramString.equals("CATEGORY_FONT_PATTERN")) {
          i1 = 1;
        }
      }
      else if (paramString.equals("CATEGORY_FONT_TYPE")) {
        i1 = 0;
      }
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 == 2) {
            this.e = this.m;
          }
        }
        else {
          this.e = this.l;
        }
      }
      else {
        this.e = this.k;
      }
      this.h.postValue(this.o);
      this.i.postValue(this.e);
      k();
      l();
      return;
    }
    k();
    l();
  }
  
  private void f(String paramString)
  {
    if (this.f != null)
    {
      if (paramString == null) {
        return;
      }
      this.f.setItemID(paramString);
      this.f.setPagFilePath(AEEditorResourceManager.a().C());
      if (f()) {
        this.f.setContent(this.n);
      }
      this.c.postValue(this.f);
    }
  }
  
  private String g(String paramString)
  {
    if (a(paramString, this.k) != null) {
      return "CATEGORY_FONT_TYPE";
    }
    if (a(paramString, this.l) != null) {
      return "CATEGORY_FONT_PATTERN";
    }
    if (a(paramString, this.m) != null) {
      return "CATEGORY_FONT_STYLE";
    }
    return null;
  }
  
  private void k()
  {
    if (this.f != null)
    {
      String str = this.f.getItemID();
      boolean bool = b(g(str), this.o);
      int i3 = 0;
      int i1;
      int i2;
      if (bool)
      {
        i1 = i3;
        if (this.f.getFontPath() != null)
        {
          i1 = i3;
          if (this.k != null)
          {
            i2 = 0;
            for (;;)
            {
              i1 = i3;
              if (i2 >= this.k.size()) {
                break;
              }
              str = TextMetaMaterialKt.e((MetaMaterial)this.k.get(i2));
              if ((!str.isEmpty()) && (this.f.getFontPath().contains(str)))
              {
                i1 = i2;
                break;
              }
              i2 += 1;
            }
          }
        }
      }
      else
      {
        i1 = i3;
        if (this.e != null)
        {
          i2 = 0;
          for (;;)
          {
            i1 = i3;
            if (i2 >= this.e.size()) {
              break;
            }
            if ((this.e.get(i2) != null) && (str.equals(((MetaMaterial)this.e.get(i2)).id)))
            {
              i1 = i2;
              break;
            }
            i2 += 1;
          }
        }
      }
      this.b.postValue(Integer.valueOf(i1));
    }
  }
  
  private void l()
  {
    Integer localInteger;
    if (("CATEGORY_FONT_TYPE".equals(this.o)) && (this.f != null)) {
      localInteger = Integer.valueOf(this.f.getTextColor());
    } else {
      localInteger = null;
    }
    this.j.postValue(localInteger);
  }
  
  public MetaMaterial a(String paramString)
  {
    MetaMaterial localMetaMaterial = a(paramString, this.k);
    if (localMetaMaterial != null) {
      return localMetaMaterial;
    }
    localMetaMaterial = a(paramString, this.l);
    if (localMetaMaterial != null) {
      return localMetaMaterial;
    }
    return a(paramString, this.m);
  }
  
  void a(@NonNull MetaMaterial paramMetaMaterial)
  {
    if (this.f == null)
    {
      AEQLog.d(this.a, "[updateText] mCurText is null");
      return;
    }
    this.g = TextMetaMaterialKt.b(paramMetaMaterial);
    String str1 = AEEditorResourceManager.a().a(TextMetaMaterialKt.e(paramMetaMaterial), 0);
    this.f.setFont(str1);
    str1 = TextMetaMaterialKt.f(paramMetaMaterial);
    String str2 = g(this.f.getItemID());
    if (a(str2, MetaMaterialKt.g(paramMetaMaterial)))
    {
      this.f.setItemID(paramMetaMaterial.id);
    }
    else if (b(str2, MetaMaterialKt.g(paramMetaMaterial)))
    {
      str1 = this.f.getContent();
    }
    else
    {
      this.f.setItemID(paramMetaMaterial.id);
      this.f.setPagFilePath(TextMetaMaterialKt.m(paramMetaMaterial));
      this.f.setTextColor(TextMetaMaterialKt.g(paramMetaMaterial));
      TextEditorDataExKt.a(this.f, TextMetaMaterialKt.i(paramMetaMaterial));
    }
    a(this.f, paramMetaMaterial, this.g);
    if ((!"blur".equals(this.g)) && (f())) {
      this.f.setContent(str1);
    }
    this.c.postValue(this.f);
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
        l();
        return;
      }
      f(paramMetaMaterial.id);
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
      l();
      return;
    }
    if ("sticker_lyric".equals(this.f.getStickerType()))
    {
      this.b.postValue(Integer.valueOf(-1));
      return;
    }
    paramTextEditorData = a(paramTextEditorData);
    if (paramTextEditorData == null)
    {
      this.b.postValue(Integer.valueOf(-1));
      l();
      return;
    }
    this.g = TextMetaMaterialKt.b(paramTextEditorData);
    e(MetaMaterialKt.g(paramTextEditorData));
  }
  
  public void a(List<MetaCategory> paramList)
  {
    if (paramList.size() >= 3)
    {
      if (((MetaCategory)paramList.get(0)).materials != null)
      {
        this.k.clear();
        this.k.addAll(TextMetaMaterialKt.a("CATEGORY_FONT_TYPE", ((MetaCategory)paramList.get(0)).materials));
        if ((((MetaCategory)paramList.get(0)).materials.size() > 0) && (((MetaCategory)paramList.get(0)).materials.get(0) != null))
        {
          MetaMaterial localMetaMaterial = TextMetaMaterialHelper.a.a((MetaMaterial)((MetaCategory)paramList.get(0)).materials.get(0));
          TextMetaMaterialKt.i(localMetaMaterial, "CATEGORY_FONT_TYPE");
          this.k.add(0, localMetaMaterial);
        }
      }
      if (((MetaCategory)paramList.get(1)).materials != null)
      {
        this.l.clear();
        this.l.addAll(TextMetaMaterialKt.a("CATEGORY_FONT_PATTERN", ((MetaCategory)paramList.get(1)).materials));
        this.l.add(0, TextMetaMaterialHelper.a.a("FONT_PATTERN_NON_ID"));
      }
      if (((MetaCategory)paramList.get(2)).materials != null)
      {
        this.m.clear();
        this.m.addAll(TextMetaMaterialKt.a("CATEGORY_FONT_STYLE", ((MetaCategory)paramList.get(2)).materials));
        this.m.add(0, TextMetaMaterialHelper.a.a("FONT_STYLE_NON_ID"));
      }
      e("CATEGORY_FONT_TYPE");
    }
  }
  
  public int b(String paramString)
  {
    int i1 = b(paramString, this.k);
    if (i1 >= 0) {
      return i1;
    }
    i1 = b(paramString, this.l);
    if (i1 >= 0) {
      return i1;
    }
    return b(paramString, this.m);
  }
  
  void b(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = null;
      break;
    case 2063991540: 
      str = "CATEGORY_FONT_TYPE";
      break;
    case 2063991539: 
      str = "CATEGORY_FONT_STYLE";
      break;
    case 2063991538: 
      str = "CATEGORY_FONT_PATTERN";
    }
    e(str);
  }
  
  LiveData<String> g()
  {
    return this.h;
  }
  
  LiveData<List<MetaMaterial>> h()
  {
    return this.i;
  }
  
  LiveData<Integer> i()
  {
    return this.j;
  }
  
  public List<MetaMaterial> j()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = this.l;
    if (localList != null) {
      localArrayList.addAll(localList);
    }
    localList = this.m;
    if (localList != null) {
      localArrayList.addAll(localList);
    }
    localList = this.k;
    if (localList != null) {
      localArrayList.addAll(localList);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextViewModel
 * JD-Core Version:    0.7.0.1
 */