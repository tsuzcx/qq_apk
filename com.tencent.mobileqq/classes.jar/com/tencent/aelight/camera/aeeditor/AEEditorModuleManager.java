package com.tencent.aelight.camera.aeeditor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.aelight.camera.aeeditor.arch.AEEditorBaseFragment;
import com.tencent.aelight.camera.aeeditor.arch.IAEEditor;
import com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment;
import com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class AEEditorModuleManager
  implements IAEEditor
{
  private static final String jdField_a_of_type_JavaLangString = "AEEditorModuleManager";
  private FragmentManager jdField_a_of_type_AndroidxFragmentAppFragmentManager;
  private HashMap<Class<? extends AEEditorBaseFragment>, AEEditorBaseFragment> jdField_a_of_type_JavaUtilHashMap;
  
  public AEEditorModuleManager(FragmentManager paramFragmentManager)
  {
    this.jdField_a_of_type_AndroidxFragmentAppFragmentManager = paramFragmentManager;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private void a(AEEditorBaseFragment paramAEEditorBaseFragment, Class<? extends AEEditorBaseFragment> paramClass, String paramString, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    AEEditorBaseFragment localAEEditorBaseFragment;
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramClass)) && (this.jdField_a_of_type_JavaUtilHashMap.get(paramClass) != null))
    {
      localAEEditorBaseFragment = (AEEditorBaseFragment)this.jdField_a_of_type_JavaUtilHashMap.get(paramClass);
      localAEEditorBaseFragment.a(this);
    }
    try
    {
      localAEEditorBaseFragment = (AEEditorBaseFragment)paramClass.newInstance();
      localAEEditorBaseFragment.a(this);
      if (localAEEditorBaseFragment.getArguments() == null) {
        localAEEditorBaseFragment.setArguments(paramBundle);
      } else {
        localAEEditorBaseFragment.getArguments().putAll(paramBundle);
      }
      localAEEditorBaseFragment.jdField_a_of_type_JavaLangString = paramString;
      paramBundle = this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.beginTransaction();
      paramString = null;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramBoolean1) && (paramAEEditorBaseFragment != null) && (((AEEditorBaseFragment)localEntry.getValue()).equals(paramAEEditorBaseFragment))) {
          paramString = (Class)localEntry.getKey();
        } else {
          paramBundle.hide((Fragment)localEntry.getValue());
        }
      }
      if ((paramBoolean1) && (paramAEEditorBaseFragment != null))
      {
        if (paramString != null) {
          this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        }
        paramBundle.remove(paramAEEditorBaseFragment);
      }
      if (this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.findFragmentByTag(paramClass.getName()) == null) {
        paramBundle.add(2064121931, localAEEditorBaseFragment, paramClass.getName()).commit();
      } else {
        paramBundle.show(localAEEditorBaseFragment).commit();
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramClass, localAEEditorBaseFragment);
      return;
    }
    catch (InstantiationException paramAEEditorBaseFragment)
    {
      paramClass = jdField_a_of_type_JavaLangString;
      paramString = new StringBuilder();
      paramString.append("replaceFragment: ");
      paramString.append(Log.getStackTraceString(paramAEEditorBaseFragment));
      AEQLog.d(paramClass, paramString.toString());
      return;
    }
    catch (IllegalAccessException paramAEEditorBaseFragment)
    {
      paramClass = jdField_a_of_type_JavaLangString;
      paramString = new StringBuilder();
      paramString.append("replaceFragment: ");
      paramString.append(Log.getStackTraceString(paramAEEditorBaseFragment));
      AEQLog.d(paramClass, paramString.toString());
    }
  }
  
  private void a(Class<? extends AEEditorBaseFragment> paramClass, String paramString, Bundle paramBundle)
  {
    a(null, paramClass, paramString, paramBundle, false, false);
  }
  
  public AEEditorBaseFragment a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((AEEditorBaseFragment)localEntry.getValue()).isVisible()) {
        return (AEEditorBaseFragment)localEntry.getValue();
      }
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AEEditorBaseFragment localAEEditorBaseFragment = a();
    if (localAEEditorBaseFragment != null) {
      localAEEditorBaseFragment.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Activity paramActivity)
  {
    a(paramActivity, false);
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity == null) {
      return;
    }
    AEEditorBaseFragment localAEEditorBaseFragment = a();
    if (localAEEditorBaseFragment == null) {
      return;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localAEEditorBaseFragment.isVisible())
    {
      bool1 = bool2;
      if (paramBoolean) {
        bool1 = false | localAEEditorBaseFragment.a();
      }
    }
    if (!bool1) {
      try
      {
        localAEEditorBaseFragment.a();
        String str = localAEEditorBaseFragment.jdField_a_of_type_JavaLangString;
        if (str == null)
        {
          AEQLog.b(jdField_a_of_type_JavaLangString, "goBack finish activity");
          b(paramActivity);
          paramActivity.finish();
          return;
        }
        paramBoolean = localAEEditorBaseFragment.jdField_a_of_type_JavaLangString.equals("AEEditorVideoEdit");
        if ((paramBoolean) && (localAEEditorBaseFragment.a().equals("AEEditorMultiCutFragment")))
        {
          b(null, new Bundle(localAEEditorBaseFragment.getArguments()));
          return;
        }
        if ((localAEEditorBaseFragment.jdField_a_of_type_JavaLangString.equals("AEEditorImageEdit")) && (localAEEditorBaseFragment.a().equals("AEEditorVideoEdit")))
        {
          a(null, new Bundle(localAEEditorBaseFragment.getArguments()));
          return;
        }
        if ((localAEEditorBaseFragment.jdField_a_of_type_JavaLangString.equals("AEEditorMultiCutFragment")) && (localAEEditorBaseFragment.a().equals("AEEditorVideoEdit")))
        {
          AEQLog.b(jdField_a_of_type_JavaLangString, "goBack finish activity");
          b(paramActivity);
          paramActivity.finish();
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        AEQLog.d(jdField_a_of_type_JavaLangString, Log.getStackTraceString(paramActivity));
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    AEQLog.b(jdField_a_of_type_JavaLangString, "enter");
    if (AEEditorLauncher.a(paramBundle))
    {
      a(null, paramBundle);
      return;
    }
    if (AEEditorLauncher.b(paramBundle))
    {
      b(null, paramBundle);
      return;
    }
    if (AEEditorLauncher.c(paramBundle))
    {
      b(null, paramBundle);
      return;
    }
    throw new RuntimeException("invalid editor type");
  }
  
  public void a(AEEditorBaseFragment paramAEEditorBaseFragment, String paramString, Bundle paramBundle)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gotoMultiCutEditModule from");
    localStringBuilder.append(paramString);
    AEQLog.b(str, localStringBuilder.toString());
    a(paramAEEditorBaseFragment, AEEditorMultiCutEditFragment.class, paramString, paramBundle, false, true);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gotoImageEditModule from ");
    localStringBuilder.append(paramString);
    AEQLog.b(str, localStringBuilder.toString());
    a(AEEditorImageEditFragment.class, paramString, paramBundle);
  }
  
  public void a(boolean paramBoolean)
  {
    AEEditorBaseFragment localAEEditorBaseFragment = a();
    if (localAEEditorBaseFragment != null) {
      localAEEditorBaseFragment.onWindowFocusChanged(paramBoolean);
    }
  }
  
  public void b(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    paramActivity.finish();
  }
  
  public void b(String paramString, Bundle paramBundle)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gotoVideoEditModule from ");
    localStringBuilder.append(paramString);
    AEQLog.b(str, localStringBuilder.toString());
    a(AEEditorVideoEditFragment.class, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.AEEditorModuleManager
 * JD-Core Version:    0.7.0.1
 */