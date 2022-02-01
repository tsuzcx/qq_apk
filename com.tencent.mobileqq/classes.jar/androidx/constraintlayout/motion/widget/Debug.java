package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Debug
{
  public static void dumpLayoutParams(ViewGroup.LayoutParams paramLayoutParams, String paramString)
  {
    Object localObject1 = new Throwable().getStackTrace()[1];
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(".(");
    ((StringBuilder)localObject2).append(((StackTraceElement)localObject1).getFileName());
    ((StringBuilder)localObject2).append(":");
    ((StringBuilder)localObject2).append(((StackTraceElement)localObject1).getLineNumber());
    ((StringBuilder)localObject2).append(") ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("  ");
    paramString = ((StringBuilder)localObject2).toString();
    localObject1 = System.out;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" >>>>>>>>>>>>>>>>>>. dump ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("  ");
    ((StringBuilder)localObject2).append(paramLayoutParams.getClass().getName());
    ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
    localObject1 = paramLayoutParams.getClass().getFields();
    int i = 0;
    while (i < localObject1.length)
    {
      String str = localObject1[i];
      try
      {
        localObject2 = str.get(paramLayoutParams);
        str = str.getName();
        if ((str.contains("To")) && (!localObject2.toString().equals("-1")))
        {
          PrintStream localPrintStream = System.out;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("       ");
          localStringBuilder.append(str);
          localStringBuilder.append(" ");
          localStringBuilder.append(localObject2);
          localPrintStream.println(localStringBuilder.toString());
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        label273:
        break label273;
      }
      i += 1;
    }
    paramLayoutParams = System.out;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" <<<<<<<<<<<<<<<<< dump ");
    ((StringBuilder)localObject1).append(paramString);
    paramLayoutParams.println(((StringBuilder)localObject1).toString());
  }
  
  public static void dumpLayoutParams(ViewGroup paramViewGroup, String paramString)
  {
    Object localObject1 = new Throwable().getStackTrace()[1];
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(".(");
    ((StringBuilder)localObject2).append(((StackTraceElement)localObject1).getFileName());
    ((StringBuilder)localObject2).append(":");
    ((StringBuilder)localObject2).append(((StackTraceElement)localObject1).getLineNumber());
    ((StringBuilder)localObject2).append(") ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("  ");
    localObject1 = ((StringBuilder)localObject2).toString();
    int k = paramViewGroup.getChildCount();
    localObject2 = System.out;
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(paramString);
    localStringBuilder1.append(" children ");
    localStringBuilder1.append(k);
    ((PrintStream)localObject2).println(localStringBuilder1.toString());
    int i = 0;
    while (i < k)
    {
      paramString = paramViewGroup.getChildAt(i);
      localObject2 = System.out;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append((String)localObject1);
      localStringBuilder1.append("     ");
      localStringBuilder1.append(getName(paramString));
      ((PrintStream)localObject2).println(localStringBuilder1.toString());
      paramString = paramString.getLayoutParams();
      localObject2 = paramString.getClass().getFields();
      int j = 0;
      while (j < localObject2.length)
      {
        localStringBuilder1 = localObject2[j];
        try
        {
          Object localObject3 = localStringBuilder1.get(paramString);
          if ((localStringBuilder1.getName().contains("To")) && (!localObject3.toString().equals("-1")))
          {
            PrintStream localPrintStream = System.out;
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append((String)localObject1);
            localStringBuilder2.append("       ");
            localStringBuilder2.append(localStringBuilder1.getName());
            localStringBuilder2.append(" ");
            localStringBuilder2.append(localObject3);
            localPrintStream.println(localStringBuilder2.toString());
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          label344:
          break label344;
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  public static void dumpPoc(Object paramObject)
  {
    Object localObject1 = new Throwable().getStackTrace()[1];
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(".(");
    ((StringBuilder)localObject2).append(((StackTraceElement)localObject1).getFileName());
    ((StringBuilder)localObject2).append(":");
    ((StringBuilder)localObject2).append(((StackTraceElement)localObject1).getLineNumber());
    ((StringBuilder)localObject2).append(")");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = paramObject.getClass();
    Object localObject3 = System.out;
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append((String)localObject1);
    localStringBuilder1.append("------------- ");
    localStringBuilder1.append(((Class)localObject2).getName());
    localStringBuilder1.append(" --------------------");
    ((PrintStream)localObject3).println(localStringBuilder1.toString());
    localObject3 = ((Class)localObject2).getFields();
    int i = 0;
    while (i < localObject3.length)
    {
      localStringBuilder1 = localObject3[i];
      try
      {
        Object localObject4 = localStringBuilder1.get(paramObject);
        if ((localStringBuilder1.getName().startsWith("layout_constraint")) && ((!(localObject4 instanceof Integer)) || (!localObject4.toString().equals("-1"))) && ((!(localObject4 instanceof Integer)) || (!localObject4.toString().equals("0"))) && ((!(localObject4 instanceof Float)) || (!localObject4.toString().equals("1.0"))) && ((!(localObject4 instanceof Float)) || (!localObject4.toString().equals("0.5"))))
        {
          PrintStream localPrintStream = System.out;
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append((String)localObject1);
          localStringBuilder2.append("    ");
          localStringBuilder2.append(localStringBuilder1.getName());
          localStringBuilder2.append(" ");
          localStringBuilder2.append(localObject4);
          localPrintStream.println(localStringBuilder2.toString());
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        label334:
        break label334;
      }
      i += 1;
    }
    paramObject = System.out;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("------------- ");
    ((StringBuilder)localObject3).append(((Class)localObject2).getSimpleName());
    ((StringBuilder)localObject3).append(" --------------------");
    paramObject.println(((StringBuilder)localObject3).toString());
  }
  
  public static String getActionType(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getAction();
    paramMotionEvent = MotionEvent.class.getFields();
    int i = 0;
    while (i < paramMotionEvent.length)
    {
      String str = paramMotionEvent[i];
      try
      {
        if ((Modifier.isStatic(str.getModifiers())) && (str.getType().equals(Integer.TYPE)) && (str.getInt(null) == j))
        {
          str = str.getName();
          return str;
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        label62:
        break label62;
      }
      i += 1;
    }
    return "---";
  }
  
  public static String getCallFrom(int paramInt)
  {
    StackTraceElement localStackTraceElement = new Throwable().getStackTrace()[(paramInt + 2)];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(".(");
    localStringBuilder.append(localStackTraceElement.getFileName());
    localStringBuilder.append(":");
    localStringBuilder.append(localStackTraceElement.getLineNumber());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static String getLoc()
  {
    StackTraceElement localStackTraceElement = new Throwable().getStackTrace()[1];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(".(");
    localStringBuilder.append(localStackTraceElement.getFileName());
    localStringBuilder.append(":");
    localStringBuilder.append(localStackTraceElement.getLineNumber());
    localStringBuilder.append(") ");
    localStringBuilder.append(localStackTraceElement.getMethodName());
    localStringBuilder.append("()");
    return localStringBuilder.toString();
  }
  
  public static String getLocation()
  {
    StackTraceElement localStackTraceElement = new Throwable().getStackTrace()[1];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(".(");
    localStringBuilder.append(localStackTraceElement.getFileName());
    localStringBuilder.append(":");
    localStringBuilder.append(localStackTraceElement.getLineNumber());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static String getLocation2()
  {
    StackTraceElement localStackTraceElement = new Throwable().getStackTrace()[2];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(".(");
    localStringBuilder.append(localStackTraceElement.getFileName());
    localStringBuilder.append(":");
    localStringBuilder.append(localStackTraceElement.getLineNumber());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static String getName(Context paramContext, int paramInt)
  {
    if (paramInt != -1) {}
    try
    {
      return paramContext.getResources().getResourceEntryName(paramInt);
    }
    catch (Exception paramContext)
    {
      break label17;
    }
    return "UNKNOWN";
    label17:
    paramContext = new StringBuilder();
    paramContext.append("?");
    paramContext.append(paramInt);
    return paramContext.toString();
  }
  
  public static String getName(Context paramContext, int[] paramArrayOfInt)
  {
    for (;;)
    {
      try
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramArrayOfInt.length);
        ((StringBuilder)localObject1).append("[");
        localObject1 = ((StringBuilder)localObject1).toString();
        i = 0;
        if (i < paramArrayOfInt.length)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          if (i != 0) {
            break label207;
          }
          localObject1 = "";
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject2 = ((StringBuilder)localObject2).toString();
        }
      }
      catch (Exception paramContext)
      {
        Object localObject1;
        int i;
        Object localObject2;
        StringBuilder localStringBuilder;
        Log.v("DEBUG", paramContext.toString());
        return "UNKNOWN";
      }
      try
      {
        localObject1 = paramContext.getResources().getResourceEntryName(paramArrayOfInt[i]);
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        continue;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("? ");
      ((StringBuilder)localObject1).append(paramArrayOfInt[i]);
      ((StringBuilder)localObject1).append(" ");
      localObject1 = ((StringBuilder)localObject1).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append((String)localObject1);
      localObject1 = localStringBuilder.toString();
      i += 1;
      continue;
      paramContext = new StringBuilder();
      paramContext.append((String)localObject1);
      paramContext.append("]");
      paramContext = paramContext.toString();
      return paramContext;
      label207:
      String str = " ";
    }
  }
  
  public static String getName(View paramView)
  {
    try
    {
      paramView = paramView.getContext().getResources().getResourceEntryName(paramView.getId());
      return paramView;
    }
    catch (Exception paramView)
    {
      label17:
      break label17;
    }
    return "UNKNOWN";
  }
  
  public static String getState(MotionLayout paramMotionLayout, int paramInt)
  {
    if (paramInt == -1) {
      return "UNDEFINED";
    }
    return paramMotionLayout.getContext().getResources().getResourceEntryName(paramInt);
  }
  
  public static void logStack(String paramString1, String paramString2, int paramInt)
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    int j = arrayOfStackTraceElement.length;
    int i = 1;
    j = Math.min(paramInt, j - 1);
    String str = " ";
    paramInt = i;
    while (paramInt <= j)
    {
      Object localObject = arrayOfStackTraceElement[paramInt];
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(".(");
      ((StringBuilder)localObject).append(arrayOfStackTraceElement[paramInt].getFileName());
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(arrayOfStackTraceElement[paramInt].getLineNumber());
      ((StringBuilder)localObject).append(") ");
      ((StringBuilder)localObject).append(arrayOfStackTraceElement[paramInt].getMethodName());
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" ");
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(str);
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(str);
      Log.v(paramString1, localStringBuilder.toString());
      paramInt += 1;
    }
  }
  
  public static void printStack(String paramString, int paramInt)
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    int j = arrayOfStackTraceElement.length;
    int i = 1;
    j = Math.min(paramInt, j - 1);
    String str = " ";
    paramInt = i;
    while (paramInt <= j)
    {
      Object localObject1 = arrayOfStackTraceElement[paramInt];
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(".(");
      ((StringBuilder)localObject1).append(arrayOfStackTraceElement[paramInt].getFileName());
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append(arrayOfStackTraceElement[paramInt].getLineNumber());
      ((StringBuilder)localObject1).append(") ");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(" ");
      str = ((StringBuilder)localObject2).toString();
      localObject2 = System.out;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(str);
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(str);
      ((PrintStream)localObject2).println(localStringBuilder.toString());
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.Debug
 * JD-Core Version:    0.7.0.1
 */