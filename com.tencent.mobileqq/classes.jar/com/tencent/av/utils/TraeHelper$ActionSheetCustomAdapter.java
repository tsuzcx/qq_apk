package com.tencent.av.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class TraeHelper$ActionSheetCustomAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  TraeHelper.SoundOutputRes jdField_a_of_type_ComTencentAvUtilsTraeHelper$SoundOutputRes;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  
  TraeHelper$ActionSheetCustomAdapter(Context paramContext, @NonNull TraeHelper.SoundOutputRes paramSoundOutputRes)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$SoundOutputRes = paramSoundOutputRes;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramSoundOutputRes.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(Context paramContext, @NonNull TraeHelper.SoundOutputRes paramSoundOutputRes)
  {
    if (paramContext != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = paramSoundOutputRes.a();
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$SoundOutputRes = paramSoundOutputRes;
    notifyDataSetInvalidated();
  }
  
  public void a(String paramString)
  {
    int j = getCount();
    int i = 0;
    while (i < j)
    {
      TraeHelper.SoundOutputRes.IconAndName localIconAndName = (TraeHelper.SoundOutputRes.IconAndName)getItem(i);
      if ((localIconAndName != null) && (localIconAndName.jdField_a_of_type_JavaLangString != null) && (localIconAndName.jdField_a_of_type_JavaLangString.equals(paramString)))
      {
        a(i);
        return;
      }
      i += 1;
    }
  }
  
  public int getCount()
  {
    TraeHelper.SoundOutputRes localSoundOutputRes = this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$SoundOutputRes;
    if (localSoundOutputRes != null) {
      return localSoundOutputRes.a();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$SoundOutputRes.a(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TraeHelper.SoundOutputRes.IconAndName localIconAndName = (TraeHelper.SoundOutputRes.IconAndName)getItem(paramInt);
    Object localObject = paramView;
    if (localIconAndName != null) {
      if (paramView == null)
      {
        localObject = new TraeHelper.ActionSheetCustomView((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localIconAndName.jdField_a_of_type_Int, localIconAndName.b);
      }
      else
      {
        localObject = (TraeHelper.ActionSheetCustomView)paramView;
        ((TraeHelper.ActionSheetCustomView)localObject).a(localIconAndName.b);
        paramView.setContentDescription(localIconAndName.b);
        ((TraeHelper.ActionSheetCustomView)localObject).a(localIconAndName.jdField_a_of_type_Int);
        localObject = paramView;
      }
    }
    paramView = (TraeHelper.ActionSheetCustomView)localObject;
    boolean bool;
    if (paramInt == this.jdField_a_of_type_Int) {
      bool = true;
    } else {
      bool = false;
    }
    paramView.a(bool);
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.ActionSheetCustomAdapter
 * JD-Core Version:    0.7.0.1
 */