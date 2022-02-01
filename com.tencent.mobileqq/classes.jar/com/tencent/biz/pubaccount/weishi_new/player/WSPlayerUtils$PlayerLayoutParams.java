package com.tencent.biz.pubaccount.weishi_new.player;

import android.view.View;

public class WSPlayerUtils$PlayerLayoutParams
{
  View a;
  View b;
  int c;
  int d;
  int e;
  int f;
  
  public WSPlayerUtils$PlayerLayoutParams(View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramView1;
    this.b = paramView2;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayerLayoutParams{videoWidth=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", videoHeight=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", topBarHeight=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", bottomBarHeight=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils.PlayerLayoutParams
 * JD-Core Version:    0.7.0.1
 */