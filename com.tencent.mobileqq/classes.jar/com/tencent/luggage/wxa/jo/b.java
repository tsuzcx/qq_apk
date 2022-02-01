package com.tencent.luggage.wxa.jo;

import java.util.ArrayList;
import java.util.Iterator;

public class b
{
  public String a;
  public String b;
  public int c;
  public int d;
  public int e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public ArrayList<f> l = new ArrayList();
  public ArrayList<Object> m = new ArrayList();
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      return (this.b.equals(paramObject.b)) && (this.c == paramObject.c) && (this.j.equals(paramObject.j));
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.l.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      localStringBuilder.append("[");
      localStringBuilder.append(localf.toString());
      localStringBuilder.append("]\n");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("host=");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("\nport=");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("\nmajor=");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("\nminor=");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append("\ndeviceType=");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append("\nfriendlyName=");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append("\nmanufacturer=");
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append("\nmodeName=");
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append("\nserviceCount=");
    ((StringBuilder)localObject).append(this.l.size());
    ((StringBuilder)localObject).append("\nserviceList=\n");
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jo.b
 * JD-Core Version:    0.7.0.1
 */