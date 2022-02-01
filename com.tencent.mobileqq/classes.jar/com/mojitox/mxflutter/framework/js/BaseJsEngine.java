package com.mojitox.mxflutter.framework.js;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.mojitox.mxflutter.framework.callback.ExecuteScriptCallback;
import java.util.HashMap;

public abstract class BaseJsEngine<T extends BaseJsExecutor>
  implements IJsEngine<T>
{
  private long jdField_a_of_type_Long = 0L;
  private T jdField_a_of_type_ComMojitoxMxflutterFrameworkJsBaseJsExecutor;
  @NonNull
  private final HashMap<String, Object> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public BaseJsEngine()
  {
    a();
  }
  
  @NonNull
  protected abstract T a();
  
  protected Object a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  protected abstract void a();
  
  protected void a(@NonNull ExecuteScriptCallback paramExecuteScriptCallback)
  {
    b().a(true, new BaseJsEngine.1(this, paramExecuteScriptCallback));
  }
  
  @NonNull
  public T b()
  {
    if (this.jdField_a_of_type_ComMojitoxMxflutterFrameworkJsBaseJsExecutor == null) {
      this.jdField_a_of_type_ComMojitoxMxflutterFrameworkJsBaseJsExecutor = a();
    }
    return this.jdField_a_of_type_ComMojitoxMxflutterFrameworkJsBaseJsExecutor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.BaseJsEngine
 * JD-Core Version:    0.7.0.1
 */