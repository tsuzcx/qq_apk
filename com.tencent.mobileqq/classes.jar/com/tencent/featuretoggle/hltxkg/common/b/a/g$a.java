package com.tencent.featuretoggle.hltxkg.common.b.a;

final class g$a
{
  long a;
  long b;
  long c;
  long d;
  long e;
  long f;
  long g = -1L;
  long h = -1L;
  long i = -1L;
  long j = -1L;
  long k = -1L;
  
  public final void a()
  {
    long l2 = this.b;
    this.g = (l2 - this.a);
    long l1 = this.c;
    this.h = (l1 - l2);
    l2 = this.d;
    this.i = (l2 - l1);
    l1 = this.e;
    this.j = (l1 - l2);
    this.k = (this.f - l1);
    l1 = this.g;
    if (l1 < 0L) {
      l1 = -1L;
    }
    this.g = l1;
    l1 = this.h;
    if (l1 < 0L) {
      l1 = -1L;
    }
    this.h = l1;
    l1 = this.i;
    if (l1 < 0L) {
      l1 = -1L;
    }
    this.i = l1;
    l1 = this.j;
    if (l1 < 0L) {
      l1 = -1L;
    }
    this.j = l1;
    l1 = this.k;
    if (l1 < 0L) {
      l1 = -1L;
    }
    this.k = l1;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Stat{startToTryConnect=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", connectCost=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", connectToPost=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", postToRsp=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", rspToRead=");
    localStringBuilder.append(this.k);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.b.a.g.a
 * JD-Core Version:    0.7.0.1
 */