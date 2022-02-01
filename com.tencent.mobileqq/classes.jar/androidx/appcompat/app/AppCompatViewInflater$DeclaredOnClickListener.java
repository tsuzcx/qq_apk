package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class AppCompatViewInflater$DeclaredOnClickListener
  implements View.OnClickListener
{
  private final View mHostView;
  private final String mMethodName;
  private Context mResolvedContext;
  private Method mResolvedMethod;
  
  public AppCompatViewInflater$DeclaredOnClickListener(@NonNull View paramView, @NonNull String paramString)
  {
    this.mHostView = paramView;
    this.mMethodName = paramString;
  }
  
  @NonNull
  private void resolveMethod(@Nullable Context paramContext, @NonNull String paramString)
  {
    while (paramContext != null)
    {
      try
      {
        if (!paramContext.isRestricted())
        {
          paramString = paramContext.getClass().getMethod(this.mMethodName, new Class[] { View.class });
          if (paramString != null)
          {
            this.mResolvedMethod = paramString;
            this.mResolvedContext = paramContext;
            return;
          }
        }
      }
      catch (NoSuchMethodException paramString)
      {
        label47:
        int i;
        break label47;
      }
      if ((paramContext instanceof ContextWrapper)) {
        paramContext = ((ContextWrapper)paramContext).getBaseContext();
      } else {
        paramContext = null;
      }
    }
    i = this.mHostView.getId();
    if (i == -1)
    {
      paramContext = "";
    }
    else
    {
      paramContext = new StringBuilder();
      paramContext.append(" with id '");
      paramContext.append(this.mHostView.getContext().getResources().getResourceEntryName(i));
      paramContext.append("'");
      paramContext = paramContext.toString();
    }
    paramString = new StringBuilder();
    paramString.append("Could not find method ");
    paramString.append(this.mMethodName);
    paramString.append("(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
    paramString.append(this.mHostView.getClass());
    paramString.append(paramContext);
    paramContext = new IllegalStateException(paramString.toString());
    for (;;)
    {
      throw paramContext;
    }
  }
  
  public void onClick(@NonNull View paramView)
  {
    if (this.mResolvedMethod == null) {
      resolveMethod(this.mHostView.getContext(), this.mMethodName);
    }
    try
    {
      this.mResolvedMethod.invoke(this.mResolvedContext, new Object[] { paramView });
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (InvocationTargetException paramView)
    {
      throw new IllegalStateException("Could not execute method for android:onClick", paramView);
    }
    catch (IllegalAccessException paramView)
    {
      throw new IllegalStateException("Could not execute non-public method for android:onClick", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatViewInflater.DeclaredOnClickListener
 * JD-Core Version:    0.7.0.1
 */