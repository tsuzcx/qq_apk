package com.tencent.aelight.camera.aeeditor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.aelight.camera.ae.biz.circle.AECircleAutoTemplateMidPageFragment;
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
  private static final String a = "AEEditorModuleManager";
  private FragmentManager b;
  private HashMap<Class<? extends AEEditorBaseFragment>, AEEditorBaseFragment> c;
  
  public AEEditorModuleManager(FragmentManager paramFragmentManager)
  {
    this.b = paramFragmentManager;
    this.c = new HashMap();
  }
  
  private void a(AEEditorBaseFragment paramAEEditorBaseFragment, Class<? extends AEEditorBaseFragment> paramClass, String paramString, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    AEEditorBaseFragment localAEEditorBaseFragment;
    if ((this.c.containsKey(paramClass)) && (this.c.get(paramClass) != null))
    {
      localAEEditorBaseFragment = (AEEditorBaseFragment)this.c.get(paramClass);
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
      localAEEditorBaseFragment.b = paramString;
      paramBundle = this.b.beginTransaction();
      paramString = null;
      Iterator localIterator = this.c.entrySet().iterator();
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
          this.c.remove(paramString);
        }
        paramBundle.remove(paramAEEditorBaseFragment);
      }
      if (this.b.findFragmentByTag(paramClass.getName()) == null) {
        paramBundle.add(2063990865, localAEEditorBaseFragment, paramClass.getName()).commit();
      } else {
        paramBundle.show(localAEEditorBaseFragment).commit();
      }
      this.c.put(paramClass, localAEEditorBaseFragment);
      return;
    }
    catch (InstantiationException paramAEEditorBaseFragment)
    {
      paramClass = a;
      paramString = new StringBuilder();
      paramString.append("replaceFragment: ");
      paramString.append(Log.getStackTraceString(paramAEEditorBaseFragment));
      AEQLog.d(paramClass, paramString.toString());
      return;
    }
    catch (IllegalAccessException paramAEEditorBaseFragment)
    {
      paramClass = a;
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
    Iterator localIterator = this.c.entrySet().iterator();
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
        bool1 = false | localAEEditorBaseFragment.c();
      }
    }
    if (!bool1) {
      try
      {
        localAEEditorBaseFragment.d();
        String str = localAEEditorBaseFragment.b;
        if (str == null)
        {
          AEQLog.b(a, "goBack finish activity");
          b(paramActivity);
          paramActivity.finish();
          return;
        }
        paramBoolean = localAEEditorBaseFragment.b.equals("AEEditorVideoEdit");
        if ((paramBoolean) && (localAEEditorBaseFragment.a().equals("AEEditorMultiCutFragment")))
        {
          b(null, new Bundle(localAEEditorBaseFragment.getArguments()));
          return;
        }
        if ((localAEEditorBaseFragment.b.equals("AEEditorImageEdit")) && (localAEEditorBaseFragment.a().equals("AEEditorVideoEdit")))
        {
          a(null, new Bundle(localAEEditorBaseFragment.getArguments()));
          return;
        }
        if ((localAEEditorBaseFragment.b.equals("AEEditorMultiCutFragment")) && (localAEEditorBaseFragment.a().equals("AEEditorVideoEdit")))
        {
          AEQLog.b(a, "goBack finish activity");
          b(paramActivity);
          paramActivity.finish();
          return;
        }
        if ((localAEEditorBaseFragment.b.equals("AutoTemplateMidPage")) && (localAEEditorBaseFragment.a().equals("AEEditorVideoEdit")))
        {
          AEQLog.b(a, "back to auto template mid page");
          c(null, new Bundle(localAEEditorBaseFragment.getArguments()));
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        AEQLog.d(a, Log.getStackTraceString(paramActivity));
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    AEQLog.b(a, "enter");
    if (AEEditorLauncher.b(paramBundle))
    {
      a(null, paramBundle);
      return;
    }
    if (AEEditorLauncher.c(paramBundle))
    {
      b(null, paramBundle);
      return;
    }
    if (AEEditorLauncher.d(paramBundle))
    {
      b(null, paramBundle);
      return;
    }
    if (AEEditorLauncher.a(paramBundle))
    {
      c(null, paramBundle);
      return;
    }
    throw new RuntimeException("invalid editor type");
  }
  
  public void a(AEEditorBaseFragment paramAEEditorBaseFragment, String paramString, Bundle paramBundle)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gotoMultiCutEditModule from");
    localStringBuilder.append(paramString);
    AEQLog.b(str, localStringBuilder.toString());
    a(paramAEEditorBaseFragment, AEEditorMultiCutEditFragment.class, paramString, paramBundle, false, true);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    String str = a;
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
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gotoVideoEditModule from ");
    localStringBuilder.append(paramString);
    AEQLog.b(str, localStringBuilder.toString());
    a(AEEditorVideoEditFragment.class, paramString, paramBundle);
  }
  
  public void c(String paramString, Bundle paramBundle)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gotoAutoTemplateMidPage from ");
    localStringBuilder.append(paramString);
    AEQLog.b(str, localStringBuilder.toString());
    a(AECircleAutoTemplateMidPageFragment.class, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.AEEditorModuleManager
 * JD-Core Version:    0.7.0.1
 */