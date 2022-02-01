package com.tencent.biz.webviewplugin;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.util.LoadedBack2;
import java.util.ArrayList;
import java.util.Iterator;

public class OfflineUpdateStatus
  implements AsyncBack
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public int g;
  private ArrayList<LoadedBack2> h = new ArrayList();
  private int i;
  private int j = 0;
  
  public OfflineUpdateStatus(String paramString)
  {
    this.a = paramString;
  }
  
  public void a()
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext()) {
      ((LoadedBack2)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(LoadedBack2 paramLoadedBack2)
  {
    if (!this.h.contains(paramLoadedBack2)) {
      this.h.add(paramLoadedBack2);
    }
  }
  
  public int b()
  {
    return this.h.size();
  }
  
  public void b(LoadedBack2 paramLoadedBack2)
  {
    this.h.remove(paramLoadedBack2);
  }
  
  public int c()
  {
    return this.i;
  }
  
  public int d()
  {
    return this.j;
  }
  
  public void loaded(String paramString, int paramInt)
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext()) {
      ((LoadedBack2)localIterator.next()).loaded(paramString, paramInt);
    }
  }
  
  public void progress(int paramInt)
  {
    this.j = paramInt;
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext()) {
      ((LoadedBack2)localIterator.next()).progress(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflineUpdateStatus
 * JD-Core Version:    0.7.0.1
 */