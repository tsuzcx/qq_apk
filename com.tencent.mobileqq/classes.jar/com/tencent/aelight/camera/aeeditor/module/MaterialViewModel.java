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
  private int jdField_a_of_type_Int;
  private final MutableLiveData<Pair<Integer, String>> jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  private String jdField_a_of_type_JavaLangString;
  private List<MetaCategory> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final MutableLiveData<Boolean> jdField_b_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  private List<MetaCategory> jdField_b_of_type_JavaUtilList;
  private int jdField_c_of_type_Int = -1;
  private List<MetaCategory> jdField_c_of_type_JavaUtilList;
  private List<MetaCategory> d;
  private List<MetaCategory> e;
  private List<MetaCategory> f;
  
  private boolean a(@NonNull Bundle paramBundle, int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramBundle.getString(paramString, null);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      AEQLog.b("MaterialViewModel", String.format("jump from scheme, materialType=%s, materialId=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString }));
      paramBundle.putString(paramString, "");
      this.jdField_a_of_type_Int = paramInt;
      return true;
    }
    return false;
  }
  
  public int a()
  {
    Object localObject1 = new MaterialViewModel.1(this).entrySet().iterator();
    int i = -1;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      k = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
      if (localObject2 != null)
      {
        localObject2 = (List)((Map.Entry)localObject2).getValue();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          j = i;
          do
          {
            i = j;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject3 = (MetaCategory)((Iterator)localObject2).next();
          } while ((localObject3 == null) || (((MetaCategory)localObject3).materials == null));
          localObject3 = ((MetaCategory)localObject3).materials.iterator();
          i = j;
          for (;;)
          {
            j = i;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            MetaMaterial localMetaMaterial = (MetaMaterial)((Iterator)localObject3).next();
            if (localMetaMaterial != null)
            {
              this.jdField_c_of_type_Int = MetaMaterialKt.a(localMetaMaterial, this.jdField_c_of_type_Int);
              if (this.jdField_c_of_type_Int == MetaMaterialKt.b(localMetaMaterial)) {
                i = k;
              }
            }
          }
        }
      }
    }
    localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = AECameraPrefsUtil.a();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((AppRuntime)localObject1).getAccount());
    ((StringBuilder)localObject3).append("SP_KEY_RED_POINT_TIME_STAMP");
    int j = ((AECameraPrefsUtil)localObject2).a(((StringBuilder)localObject3).toString(), -1, 0);
    int k = this.jdField_c_of_type_Int;
    if ((k != -1) && (k > j))
    {
      if (k <= (int)(System.currentTimeMillis() / 1000L)) {
        return -1;
      }
      return i;
    }
    return -1;
  }
  
  public LiveData<Pair<Integer, String>> a()
  {
    return this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Int += 1;
    if (this.jdField_b_of_type_Int == 6) {
      this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.postValue(Boolean.valueOf(true));
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_Int) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.postValue(new Pair(Integer.valueOf(paramInt), this.jdField_a_of_type_JavaLangString));
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
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public LiveData<Boolean> b()
  {
    return this.jdField_b_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public void b(List<MetaCategory> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
  }
  
  public void c(List<MetaCategory> paramList)
  {
    this.jdField_c_of_type_JavaUtilList = paramList;
  }
  
  public void d(List<MetaCategory> paramList)
  {
    this.d = paramList;
  }
  
  public void e(List<MetaCategory> paramList)
  {
    this.e = paramList;
  }
  
  public void f(List<MetaCategory> paramList)
  {
    this.f = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.MaterialViewModel
 * JD-Core Version:    0.7.0.1
 */