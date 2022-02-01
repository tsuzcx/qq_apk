package com.tencent.mobileqq.apollo.process.ui;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class NativeUIManager
{
  private int jdField_a_of_type_Int;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  public HashMap<String, NativeUIComponent> a;
  
  public NativeUIManager(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public NativeUIComponent a(String paramString)
  {
    CmGameDialog localCmGameDialog = null;
    Object localObject = null;
    if ("Dialog".equals(paramString))
    {
      localCmGameDialog = new CmGameDialog();
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
        break label38;
      }
    }
    label38:
    for (paramString = localObject;; paramString = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      localCmGameDialog.a(paramString);
      return localCmGameDialog;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = (NativeUIComponent)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
          if (localObject != null) {
            ((NativeUIComponent)localObject).a();
          }
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void a(NativeUIComponent paramNativeUIComponent)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (paramNativeUIComponent != null)) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramNativeUIComponent.a());
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = CmGameUtil.a(this.jdField_a_of_type_Int);
    if (paramString1 != null)
    {
      paramString1 = paramString1.a();
      if (paramString1 != null) {
        paramString1.runRenderTask(new NativeUIManager.1(this, paramString1, paramString2, paramString3));
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    NativeUIComponent localNativeUIComponent;
    if (!TextUtils.isEmpty(paramString1))
    {
      localNativeUIComponent = null;
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        localNativeUIComponent = (NativeUIComponent)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
      }
      if (localNativeUIComponent == null) {
        break label45;
      }
      localNativeUIComponent.a(paramString2, paramString4, this);
    }
    label45:
    do
    {
      do
      {
        return;
      } while ("destroy".equals(paramString3));
      localNativeUIComponent = a(paramString1);
    } while (localNativeUIComponent == null);
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localNativeUIComponent);
    a(paramString1, paramString2, paramString3, paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.NativeUIManager
 * JD-Core Version:    0.7.0.1
 */