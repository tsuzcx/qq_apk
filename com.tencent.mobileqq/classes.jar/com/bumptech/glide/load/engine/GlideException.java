package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class GlideException
  extends Exception
{
  private static final StackTraceElement[] a = new StackTraceElement[0];
  private static final long serialVersionUID = 1L;
  private final List<Throwable> causes;
  private Class<?> dataClass;
  private DataSource dataSource;
  private String detailMessage;
  private Key key;
  
  public GlideException(String paramString)
  {
    this(paramString, Collections.emptyList());
  }
  
  public GlideException(String paramString, Throwable paramThrowable)
  {
    this(paramString, Collections.singletonList(paramThrowable));
  }
  
  public GlideException(String paramString, List<Throwable> paramList)
  {
    this.detailMessage = paramString;
    setStackTrace(a);
    this.causes = paramList;
  }
  
  private void a(Appendable paramAppendable)
  {
    a(this, paramAppendable);
    a(getCauses(), new GlideException.IndentedAppendable(paramAppendable));
  }
  
  private static void a(Throwable paramThrowable, Appendable paramAppendable)
  {
    try
    {
      paramAppendable.append(paramThrowable.getClass().toString()).append(": ").append(paramThrowable.getMessage()).append('\n');
      return;
    }
    catch (IOException paramAppendable)
    {
      label38:
      break label38;
    }
    throw new RuntimeException(paramThrowable);
  }
  
  private void a(Throwable paramThrowable, List<Throwable> paramList)
  {
    if ((paramThrowable instanceof GlideException))
    {
      paramThrowable = ((GlideException)paramThrowable).getCauses().iterator();
      while (paramThrowable.hasNext()) {
        a((Throwable)paramThrowable.next(), paramList);
      }
    }
    paramList.add(paramThrowable);
  }
  
  private static void a(List<Throwable> paramList, Appendable paramAppendable)
  {
    try
    {
      b(paramList, paramAppendable);
      return;
    }
    catch (IOException paramList)
    {
      throw new RuntimeException(paramList);
    }
  }
  
  private static void b(List<Throwable> paramList, Appendable paramAppendable)
  {
    int k = paramList.size();
    int j;
    for (int i = 0; i < k; i = j)
    {
      Object localObject = paramAppendable.append("Cause (");
      j = i + 1;
      ((Appendable)localObject).append(String.valueOf(j)).append(" of ").append(String.valueOf(k)).append("): ");
      localObject = (Throwable)paramList.get(i);
      if ((localObject instanceof GlideException)) {
        ((GlideException)localObject).a(paramAppendable);
      } else {
        a((Throwable)localObject, paramAppendable);
      }
    }
  }
  
  public Throwable fillInStackTrace()
  {
    return this;
  }
  
  public List<Throwable> getCauses()
  {
    return this.causes;
  }
  
  public String getMessage()
  {
    StringBuilder localStringBuilder = new StringBuilder(71);
    localStringBuilder.append(this.detailMessage);
    Object localObject1 = this.dataClass;
    Object localObject2 = "";
    if (localObject1 != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(this.dataClass);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "";
    }
    localStringBuilder.append((String)localObject1);
    if (this.dataSource != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(this.dataSource);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "";
    }
    localStringBuilder.append((String)localObject1);
    localObject1 = localObject2;
    if (this.key != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(this.key);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localStringBuilder.append((String)localObject1);
    localObject1 = getRootCauses();
    if (((List)localObject1).isEmpty()) {
      return localStringBuilder.toString();
    }
    if (((List)localObject1).size() == 1)
    {
      localStringBuilder.append("\nThere was 1 cause:");
    }
    else
    {
      localStringBuilder.append("\nThere were ");
      localStringBuilder.append(((List)localObject1).size());
      localStringBuilder.append(" causes:");
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Throwable)((Iterator)localObject1).next();
      localStringBuilder.append('\n');
      localStringBuilder.append(localObject2.getClass().getName());
      localStringBuilder.append('(');
      localStringBuilder.append(((Throwable)localObject2).getMessage());
      localStringBuilder.append(')');
    }
    localStringBuilder.append("\n call GlideException#logRootCauses(String) for more detail");
    return localStringBuilder.toString();
  }
  
  public List<Throwable> getRootCauses()
  {
    ArrayList localArrayList = new ArrayList();
    a(this, localArrayList);
    return localArrayList;
  }
  
  public void logRootCauses(String paramString)
  {
    List localList = getRootCauses();
    int k = localList.size();
    int j;
    for (int i = 0; i < k; i = j)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Root cause (");
      j = i + 1;
      localStringBuilder.append(j);
      localStringBuilder.append(" of ");
      localStringBuilder.append(k);
      localStringBuilder.append(")");
      Log.i(paramString, localStringBuilder.toString(), (Throwable)localList.get(i));
    }
  }
  
  public void printStackTrace()
  {
    printStackTrace(System.err);
  }
  
  public void printStackTrace(PrintStream paramPrintStream)
  {
    a(paramPrintStream);
  }
  
  public void printStackTrace(PrintWriter paramPrintWriter)
  {
    a(paramPrintWriter);
  }
  
  void setLoggingDetails(Key paramKey, DataSource paramDataSource)
  {
    setLoggingDetails(paramKey, paramDataSource, null);
  }
  
  void setLoggingDetails(Key paramKey, DataSource paramDataSource, Class<?> paramClass)
  {
    this.key = paramKey;
    this.dataSource = paramDataSource;
    this.dataClass = paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.GlideException
 * JD-Core Version:    0.7.0.1
 */