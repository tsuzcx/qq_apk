package com.tencent.biz.qqcircle.datacenter.data;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.utils.QFSCommonUtil;

public class QFSUserFollowData
{
  private final String a;
  private int b;
  private int c = -1;
  private int d = -1;
  private boolean e = true;
  
  public QFSUserFollowData(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public QFSUserFollowData(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramString, paramInt1);
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = false;
  }
  
  private boolean b(int paramInt)
  {
    if (f() == QCirclePluginUtil.c(paramInt)) {
      return false;
    }
    this.b = paramInt;
    int i = this.c;
    paramInt = -1;
    if (i == -1) {
      return false;
    }
    if (f()) {
      paramInt = 1;
    }
    this.c = (i + paramInt);
    return true;
  }
  
  private boolean c(int paramInt)
  {
    int j = this.d;
    int i = -1;
    if (j == -1) {
      return false;
    }
    if (QCirclePluginUtil.c(paramInt)) {
      i = 1;
    }
    this.d = (j + i);
    return true;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(QFSUserFollowData paramQFSUserFollowData)
  {
    if (!TextUtils.equals(this.a, paramQFSUserFollowData.a)) {
      return;
    }
    this.b = paramQFSUserFollowData.b;
    if (paramQFSUserFollowData.b != -1) {
      this.d = paramQFSUserFollowData.d;
    }
    int i = paramQFSUserFollowData.c;
    if (i != -1) {
      this.c = i;
    }
  }
  
  public boolean a(int paramInt)
  {
    if (QFSCommonUtil.a(this.a)) {
      return c(paramInt);
    }
    return b(paramInt);
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    int j = this.c;
    int i = j;
    if (j == -1) {
      i = 0;
    }
    return i;
  }
  
  public int d()
  {
    int j = this.d;
    int i = j;
    if (j == -1) {
      i = 0;
    }
    return i;
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return QCirclePluginUtil.c(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.datacenter.data.QFSUserFollowData
 * JD-Core Version:    0.7.0.1
 */