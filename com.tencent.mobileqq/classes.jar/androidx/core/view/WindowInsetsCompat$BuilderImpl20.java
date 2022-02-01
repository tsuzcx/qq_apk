package androidx.core.view;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

@RequiresApi(api=20)
class WindowInsetsCompat$BuilderImpl20
  extends WindowInsetsCompat.BuilderImpl
{
  private static Constructor<WindowInsets> sConstructor;
  private static boolean sConstructorFetched = false;
  private static Field sConsumedField;
  private static boolean sConsumedFieldFetched = false;
  private WindowInsets mInsets;
  
  WindowInsetsCompat$BuilderImpl20()
  {
    this.mInsets = createWindowInsetsInstance();
  }
  
  WindowInsetsCompat$BuilderImpl20(@NonNull WindowInsetsCompat paramWindowInsetsCompat)
  {
    this.mInsets = paramWindowInsetsCompat.toWindowInsets();
  }
  
  @Nullable
  private static WindowInsets createWindowInsetsInstance()
  {
    if (!sConsumedFieldFetched)
    {
      try
      {
        sConsumedField = WindowInsets.class.getDeclaredField("CONSUMED");
      }
      catch (ReflectiveOperationException localReflectiveOperationException1)
      {
        Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", localReflectiveOperationException1);
      }
      sConsumedFieldFetched = true;
    }
    Object localObject1 = sConsumedField;
    if (localObject1 != null) {
      try
      {
        localObject1 = (WindowInsets)((Field)localObject1).get(null);
        if (localObject1 != null)
        {
          localObject1 = new WindowInsets((WindowInsets)localObject1);
          return localObject1;
        }
      }
      catch (ReflectiveOperationException localReflectiveOperationException2)
      {
        Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", localReflectiveOperationException2);
      }
    }
    if (!sConstructorFetched)
    {
      try
      {
        sConstructor = WindowInsets.class.getConstructor(new Class[] { Rect.class });
      }
      catch (ReflectiveOperationException localReflectiveOperationException3)
      {
        Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", localReflectiveOperationException3);
      }
      sConstructorFetched = true;
    }
    Object localObject2 = sConstructor;
    if (localObject2 != null) {
      try
      {
        localObject2 = (WindowInsets)((Constructor)localObject2).newInstance(new Object[] { new Rect() });
        return localObject2;
      }
      catch (ReflectiveOperationException localReflectiveOperationException4)
      {
        Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", localReflectiveOperationException4);
      }
    }
    return null;
  }
  
  @NonNull
  WindowInsetsCompat build()
  {
    return WindowInsetsCompat.toWindowInsetsCompat(this.mInsets);
  }
  
  void setSystemWindowInsets(@NonNull Insets paramInsets)
  {
    WindowInsets localWindowInsets = this.mInsets;
    if (localWindowInsets != null) {
      this.mInsets = localWindowInsets.replaceSystemWindowInsets(paramInsets.left, paramInsets.top, paramInsets.right, paramInsets.bottom);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.WindowInsetsCompat.BuilderImpl20
 * JD-Core Version:    0.7.0.1
 */