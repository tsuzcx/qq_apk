package com.tencent.mobileqq.apollo.game.process.ui;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
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
    boolean bool = "Dialog".equals(paramString);
    paramString = null;
    if (bool)
    {
      CmGameDialog localCmGameDialog = new CmGameDialog();
      WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localWeakReference != null) {
        paramString = (Context)localWeakReference.get();
      }
      localCmGameDialog.a(paramString);
      return localCmGameDialog;
    }
    return null;
  }
  
  public void a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject1 != null)
    {
      localObject1 = ((HashMap)localObject1).keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = (NativeUIComponent)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
          if (localObject2 != null) {
            ((NativeUIComponent)localObject2).a();
          }
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void a(NativeUIComponent paramNativeUIComponent)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if ((localHashMap != null) && (paramNativeUIComponent != null)) {
      localHashMap.remove(paramNativeUIComponent.a());
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
    if (!TextUtils.isEmpty(paramString1))
    {
      NativeUIComponent localNativeUIComponent = null;
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (localHashMap != null) {
        localNativeUIComponent = (NativeUIComponent)localHashMap.get(paramString1);
      }
      if (localNativeUIComponent != null)
      {
        localNativeUIComponent.a(paramString2, paramString4, this);
        return;
      }
      if (!"destroy".equals(paramString3))
      {
        localNativeUIComponent = a(paramString1);
        if (localNativeUIComponent != null)
        {
          if (this.jdField_a_of_type_JavaUtilHashMap == null) {
            this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localNativeUIComponent);
          a(paramString1, paramString2, paramString3, paramString4);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.ui.NativeUIManager
 * JD-Core Version:    0.7.0.1
 */