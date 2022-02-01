package com.tencent.aelight.camera.aeeditor.module;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

public class MaterialViewModel
  extends ViewModel
{
  private int a;
  private String b;
  private boolean c;
  private final MutableLiveData<Pair<Integer, String>> d = new MutableLiveData();
  private final MutableLiveData<Boolean> e = new MutableLiveData();
  private int f;
  private List<MetaCategory> g;
  private List<MetaCategory> h;
  private List<MetaCategory> i;
  private List<MetaCategory> j;
  private List<MetaCategory> k;
  private List<MetaCategory> l;
  private int m = -1;
  
  private boolean a(@NonNull Bundle paramBundle, int paramInt, String paramString)
  {
    this.b = paramBundle.getString(paramString, null);
    if (!TextUtils.isEmpty(this.b))
    {
      AEQLog.b("MaterialViewModel", String.format("jump from scheme, materialType=%s, materialId=%s", new Object[] { Integer.valueOf(this.a), this.b }));
      paramBundle.putString(paramString, "");
      this.a = paramInt;
      return true;
    }
    return false;
  }
  
  public LiveData<Pair<Integer, String>> a()
  {
    return this.d;
  }
  
  public void a(int paramInt)
  {
    if (paramInt != this.a) {
      return;
    }
    if (!this.c)
    {
      if (TextUtils.isEmpty(this.b)) {
        return;
      }
      this.c = true;
      this.d.postValue(new Pair(Integer.valueOf(paramInt), this.b));
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if (a(paramBundle, 1, "editor_video_template_id")) {
      return;
    }
    if (a(paramBundle, 2, "editor_image_template_id")) {
      return;
    }
    if (a(paramBundle, 3, "editor_filter_id")) {
      return;
    }
    if (a(paramBundle, 4, "editor_text_sticker_id")) {
      return;
    }
    if (a(paramBundle, 5, "editor_text_id")) {
      return;
    }
    a(paramBundle, 6, "editor_frame_id");
  }
  
  public void a(List<MetaCategory> paramList)
  {
    this.g = paramList;
  }
  
  public LiveData<Boolean> b()
  {
    return this.e;
  }
  
  public void b(List<MetaCategory> paramList)
  {
    this.h = paramList;
  }
  
  public void c()
  {
    this.f += 1;
    if (this.f == 6) {
      this.e.postValue(Boolean.valueOf(true));
    }
  }
  
  public void c(List<MetaCategory> paramList)
  {
    this.i = paramList;
  }
  
  public int d()
  {
    Object localObject3 = new MaterialViewModel.1(this).entrySet().iterator();
    Object localObject1 = "";
    int i1 = -1;
    int n = -1;
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject3).next();
      int i4 = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
      if (localObject2 != null)
      {
        localObject2 = (List)((Map.Entry)localObject2).getValue();
        if (localObject2 != null)
        {
          localObject4 = ((List)localObject2).iterator();
          i3 = n;
          localObject2 = localObject1;
          i2 = i1;
          do
          {
            i1 = i2;
            localObject1 = localObject2;
            n = i3;
            if (!((Iterator)localObject4).hasNext()) {
              break;
            }
            localObject1 = (MetaCategory)((Iterator)localObject4).next();
          } while ((localObject1 == null) || (((MetaCategory)localObject1).materials == null));
          Iterator localIterator = ((MetaCategory)localObject1).materials.iterator();
          i1 = i3;
          localObject1 = localObject2;
          n = i2;
          for (;;)
          {
            i2 = n;
            localObject2 = localObject1;
            i3 = i1;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject2 = (MetaMaterial)localIterator.next();
            if (localObject2 != null)
            {
              this.m = MetaMaterialKt.c((MetaMaterial)localObject2, this.m);
              if (this.m == MetaMaterialKt.f((MetaMaterial)localObject2))
              {
                localObject1 = ((MetaMaterial)localObject2).id;
                i1 = this.m;
                n = i4;
              }
            }
          }
        }
      }
    }
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    localObject3 = AECameraPrefsUtil.a();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(((AppRuntime)localObject2).getAccount());
    ((StringBuilder)localObject4).append("SP_KEY_RED_POINT_TIME_STAMP");
    int i2 = ((AECameraPrefsUtil)localObject3).b(((StringBuilder)localObject4).toString(), -1, 0);
    int i3 = this.m;
    if ((i3 != -1) && (i3 > i2))
    {
      if (i3 <= (int)(System.currentTimeMillis() / 1000L)) {
        return -1;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("redpoint info:redpoint view:");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append(", material: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", redpoint timestamp: ");
      ((StringBuilder)localObject2).append(n);
      AEQLog.b("MaterialViewModel", ((StringBuilder)localObject2).toString());
      return i1;
    }
    return -1;
  }
  
  public void d(List<MetaCategory> paramList)
  {
    this.j = paramList;
  }
  
  public int e()
  {
    return this.m;
  }
  
  public void e(List<MetaCategory> paramList)
  {
    this.k = paramList;
  }
  
  public void f(List<MetaCategory> paramList)
  {
    this.l = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.MaterialViewModel
 * JD-Core Version:    0.7.0.1
 */