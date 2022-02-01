package com.tencent.map.sdk.a;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;

public final class nq
{
  int a;
  np b;
  np c;
  Interpolator d;
  ArrayList<np> e;
  
  private nq(np... paramVarArgs)
  {
    this.a = paramVarArgs.length;
    this.e = new ArrayList();
    this.e.addAll(Arrays.asList(paramVarArgs));
    this.b = ((np)this.e.get(0));
    this.c = ((np)this.e.get(this.a - 1));
    this.d = this.c.a;
  }
  
  public final nq a()
  {
    ArrayList localArrayList = this.e;
    int j = localArrayList.size();
    np[] arrayOfnp = new np[j];
    int i = 0;
    while (i < j)
    {
      arrayOfnp[i] = ((np)localArrayList.get(i)).b();
      i += 1;
    }
    return new nq(arrayOfnp);
  }
  
  public final String toString()
  {
    String str = " ";
    int i = 0;
    while (i < this.a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(((np)this.e.get(i)).a());
      localStringBuilder.append("  ");
      str = localStringBuilder.toString();
      i += 1;
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.nq
 * JD-Core Version:    0.7.0.1
 */