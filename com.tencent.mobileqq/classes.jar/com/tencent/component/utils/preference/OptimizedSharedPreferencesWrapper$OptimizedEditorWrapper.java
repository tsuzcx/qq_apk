package com.tencent.component.utils.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class OptimizedSharedPreferencesWrapper$OptimizedEditorWrapper
  extends SharedPreferencesWrapper.EditorWrapper
{
  public OptimizedSharedPreferencesWrapper$OptimizedEditorWrapper(OptimizedSharedPreferencesWrapper paramOptimizedSharedPreferencesWrapper, SharedPreferences.Editor paramEditor)
  {
    super(paramEditor, paramOptimizedSharedPreferencesWrapper.getKeyGenerator());
  }
  
  public SharedPreferences.Editor clear()
  {
    if (TextUtils.isEmpty(OptimizedSharedPreferencesWrapper.access$100(this.this$0)))
    {
      super.clear();
      return this;
    }
    Object localObject = this.this$0.getWrappedSharedPreferences().getAll();
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      localObject = ((Map)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (OptimizedSharedPreferencesWrapper.access$400(OptimizedSharedPreferencesWrapper.access$100(this.this$0), str)) {
          super.remove(str);
        }
      }
    }
    return this;
  }
  
  public boolean commit()
  {
    if ((OptimizedSharedPreferencesWrapper.access$500(this.this$0)) && (Build.VERSION.SDK_INT >= 9))
    {
      super.apply();
      return true;
    }
    return super.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.utils.preference.OptimizedSharedPreferencesWrapper.OptimizedEditorWrapper
 * JD-Core Version:    0.7.0.1
 */