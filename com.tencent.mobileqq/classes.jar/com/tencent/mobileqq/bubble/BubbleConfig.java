package com.tencent.mobileqq.bubble;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class BubbleConfig
{
  public int a = 0;
  public String b;
  public int c;
  public int d;
  public int e;
  public boolean f;
  public boolean g;
  public double h;
  public int[] i;
  public AnimationConfig j;
  public AnimationConfig k;
  public AnimationConfig l;
  public ArrayList<AnimationConfig> m;
  public AnimationConfig n;
  public AnimationConfig o;
  public AnimationConfig p;
  public HashSet<String> q = new HashSet();
  @Deprecated
  public DiyBubbleConfig.DiyBubblePasterConfig r;
  public HashMap<String, DiyBubbleConfig> s = new HashMap(4);
  public ArrayList<Integer> t = null;
  public int u = 0;
  public int v = -1;
  public int w = 2;
  public ArrayList<String> x = null;
  public HashMap<String, BubbleNewAnimConf> y = null;
  
  public BubbleConfig(int paramInt)
  {
    this.a = paramInt;
  }
  
  private boolean a(File paramFile, String paramString)
  {
    paramFile = new File(paramFile, paramString);
    boolean bool3 = paramFile.exists();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (paramFile.isDirectory())
      {
        paramFile = paramFile.list();
        bool1 = bool2;
        if (paramFile != null)
        {
          bool1 = bool2;
          if (paramFile.length > 0) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int a()
  {
    if (c()) {
      return ((Integer)this.t.get(this.u)).intValue();
    }
    return -1;
  }
  
  public boolean a(int paramInt)
  {
    ArrayList localArrayList = this.t;
    return (localArrayList != null) && (localArrayList.contains(Integer.valueOf(paramInt)));
  }
  
  public boolean a(File paramFile)
  {
    Iterator localIterator = this.q.iterator();
    while (localIterator.hasNext()) {
      if (a(paramFile, (String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    if ((this.x != null) && (!TextUtils.isEmpty(paramString)))
    {
      Iterator localIterator = this.x.iterator();
      while (localIterator.hasNext()) {
        if (paramString.indexOf(((String)localIterator.next()).toLowerCase()) != -1) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void b()
  {
    if (c())
    {
      this.u = ((this.u + 1) % this.t.size());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("now change bubble sub id: ");
        localStringBuilder.append(this.t.get(this.u));
        QLog.i("BubbleConfig", 2, localStringBuilder.toString());
      }
    }
    else
    {
      this.u = 0;
    }
  }
  
  public boolean c()
  {
    ArrayList localArrayList = this.t;
    return (localArrayList != null) && (localArrayList.size() > 0);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[ bubbleId=");
    localStringBuilder.append(this.a);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuffer.append(",");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("name=");
    localStringBuilder.append(this.b);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuffer.append(" ]");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleConfig
 * JD-Core Version:    0.7.0.1
 */