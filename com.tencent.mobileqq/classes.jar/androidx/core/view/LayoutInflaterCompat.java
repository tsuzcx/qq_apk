package androidx.core.view;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;

public final class LayoutInflaterCompat
{
  private static final String TAG = "LayoutInflaterCompatHC";
  private static boolean sCheckedField;
  private static Field sLayoutInflaterFactory2Field;
  
  private static void forceSetFactory2(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
  {
    if (!sCheckedField)
    {
      try
      {
        sLayoutInflaterFactory2Field = LayoutInflater.class.getDeclaredField("mFactory2");
        sLayoutInflaterFactory2Field.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("forceSetFactory2 Could not find field 'mFactory2' on class ");
        localStringBuilder.append(LayoutInflater.class.getName());
        localStringBuilder.append("; inflation may have unexpected results.");
        Log.e("LayoutInflaterCompatHC", localStringBuilder.toString(), localNoSuchFieldException);
      }
      sCheckedField = true;
    }
    Object localObject = sLayoutInflaterFactory2Field;
    if (localObject != null) {
      try
      {
        ((Field)localObject).set(paramLayoutInflater, paramFactory2);
        return;
      }
      catch (IllegalAccessException paramFactory2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("forceSetFactory2 could not set the Factory2 on LayoutInflater ");
        ((StringBuilder)localObject).append(paramLayoutInflater);
        ((StringBuilder)localObject).append("; inflation may have unexpected results.");
        Log.e("LayoutInflaterCompatHC", ((StringBuilder)localObject).toString(), paramFactory2);
      }
    }
  }
  
  @Deprecated
  public static LayoutInflaterFactory getFactory(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.getFactory();
    if ((paramLayoutInflater instanceof LayoutInflaterCompat.Factory2Wrapper)) {
      return ((LayoutInflaterCompat.Factory2Wrapper)paramLayoutInflater).mDelegateFactory;
    }
    return null;
  }
  
  @Deprecated
  public static void setFactory(@NonNull LayoutInflater paramLayoutInflater, @NonNull LayoutInflaterFactory paramLayoutInflaterFactory)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject2 = null;
    Object localObject1 = null;
    if (i >= 21)
    {
      if (paramLayoutInflaterFactory != null) {
        localObject1 = new LayoutInflaterCompat.Factory2Wrapper(paramLayoutInflaterFactory);
      }
      paramLayoutInflater.setFactory2((LayoutInflater.Factory2)localObject1);
      return;
    }
    localObject1 = localObject2;
    if (paramLayoutInflaterFactory != null) {
      localObject1 = new LayoutInflaterCompat.Factory2Wrapper(paramLayoutInflaterFactory);
    }
    paramLayoutInflater.setFactory2((LayoutInflater.Factory2)localObject1);
    paramLayoutInflaterFactory = paramLayoutInflater.getFactory();
    if ((paramLayoutInflaterFactory instanceof LayoutInflater.Factory2))
    {
      forceSetFactory2(paramLayoutInflater, (LayoutInflater.Factory2)paramLayoutInflaterFactory);
      return;
    }
    forceSetFactory2(paramLayoutInflater, (LayoutInflater.Factory2)localObject1);
  }
  
  public static void setFactory2(@NonNull LayoutInflater paramLayoutInflater, @NonNull LayoutInflater.Factory2 paramFactory2)
  {
    paramLayoutInflater.setFactory2(paramFactory2);
    if (Build.VERSION.SDK_INT < 21)
    {
      LayoutInflater.Factory localFactory = paramLayoutInflater.getFactory();
      if ((localFactory instanceof LayoutInflater.Factory2))
      {
        forceSetFactory2(paramLayoutInflater, (LayoutInflater.Factory2)localFactory);
        return;
      }
      forceSetFactory2(paramLayoutInflater, paramFactory2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.LayoutInflaterCompat
 * JD-Core Version:    0.7.0.1
 */