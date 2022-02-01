package com.tencent.image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ArgumentsRunnable<T>
  implements Runnable
{
  private ArrayList<T> args = null;
  
  private final List<T> getArguments()
  {
    try
    {
      ArrayList localArrayList = this.args;
      this.args = null;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void add(T... paramVarArgs)
  {
    int i = 1;
    try
    {
      if (this.args == null)
      {
        i = 0;
        this.args = new ArrayList();
      }
      Collections.addAll(this.args, paramVarArgs);
      if (i == 0) {
        submit();
      }
      return;
    }
    finally {}
  }
  
  public final void run()
  {
    run(getArguments());
  }
  
  protected abstract void run(List<T> paramList);
  
  protected abstract void submit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.ArgumentsRunnable
 * JD-Core Version:    0.7.0.1
 */