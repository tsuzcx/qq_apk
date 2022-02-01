package com.tencent.mobileqq.activity.aio.anim;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.anim.egg.EggKeyword;
import com.tencent.mobileqq.utils.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class AioAnimationRule
{
  public int a;
  public int b = -1;
  public ArrayList<EggKeyword> c;
  public long d;
  public long e;
  public int f = 0;
  public int g = -1;
  public int h = -1;
  public boolean i = false;
  public ArrayList<AioAnimationRule.JumpImage> j;
  public AioAnimationRule.BussinessData k;
  public String l;
  public String m;
  
  public AioAnimationRule() {}
  
  public AioAnimationRule(AioAnimationRule paramAioAnimationRule)
  {
    this.a = paramAioAnimationRule.a;
    this.b = paramAioAnimationRule.b;
    this.c = paramAioAnimationRule.c;
    this.f = paramAioAnimationRule.f;
    this.g = paramAioAnimationRule.g;
    this.h = paramAioAnimationRule.h;
    this.i = paramAioAnimationRule.i;
    this.j = paramAioAnimationRule.j;
    this.k = paramAioAnimationRule.k;
    this.l = paramAioAnimationRule.l;
    this.m = paramAioAnimationRule.m;
    this.e = paramAioAnimationRule.e;
    this.d = paramAioAnimationRule.d;
  }
  
  void a(int paramInt)
  {
    if (ListUtils.a(this.j)) {
      return;
    }
    int n = this.j.size() - 1;
    int i1 = 0;
    while ((i1 < paramInt) && (n >= 0))
    {
      ((AioAnimationRule.JumpImage)this.j.get(n)).i = true;
      i1 += 1;
      n -= 1;
    }
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    Object localObject = this.c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      EggKeyword localEggKeyword = (EggKeyword)((Iterator)localObject).next();
      localStringBuilder.append(localEggKeyword.b());
      localStringBuilder.append(".");
      localStringBuilder.append(localEggKeyword.a());
      localStringBuilder.append(".");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(super.toString());
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AioAnimationRule
 * JD-Core Version:    0.7.0.1
 */