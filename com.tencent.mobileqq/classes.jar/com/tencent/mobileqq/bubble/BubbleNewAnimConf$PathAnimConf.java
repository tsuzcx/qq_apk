package com.tencent.mobileqq.bubble;

public class BubbleNewAnimConf$PathAnimConf
  extends BubbleNewAnimConf
{
  public boolean A = false;
  public int B = 1;
  public float m;
  public float n;
  public float o;
  public float p;
  public float q;
  public float r;
  public float s;
  public float t;
  public int u = 0;
  public boolean v = false;
  public int w = 100;
  public int x = 100;
  public int y = 0;
  public int z = 0;
  
  public PathAnimConf a()
  {
    PathAnimConf localPathAnimConf = new PathAnimConf();
    localPathAnimConf.m = this.o;
    localPathAnimConf.n = this.p;
    localPathAnimConf.o = this.m;
    localPathAnimConf.p = this.n;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("reverse");
    localPathAnimConf.a = localStringBuilder.toString();
    this.v ^= true;
    localPathAnimConf.d = this.d;
    localPathAnimConf.e = this.e;
    localPathAnimConf.w = this.x;
    localPathAnimConf.x = this.w;
    localPathAnimConf.y = this.z;
    localPathAnimConf.z = this.y;
    if (this.A)
    {
      localPathAnimConf.q = this.q;
      localPathAnimConf.s = this.s;
      localPathAnimConf.r = this.r;
      localPathAnimConf.t = this.t;
    }
    else
    {
      localPathAnimConf.q = this.s;
      localPathAnimConf.s = this.q;
      localPathAnimConf.r = this.t;
      localPathAnimConf.t = this.r;
    }
    localPathAnimConf.u = this.u;
    localPathAnimConf.A = this.A;
    localPathAnimConf.B = this.B;
    localPathAnimConf.b = this.b;
    localPathAnimConf.c = this.c;
    return localPathAnimConf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleNewAnimConf.PathAnimConf
 * JD-Core Version:    0.7.0.1
 */