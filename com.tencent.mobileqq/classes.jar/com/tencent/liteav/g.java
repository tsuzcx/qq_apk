package com.tencent.liteav;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.a.c;
import org.json.JSONArray;

public class g
  implements Cloneable
{
  public Bitmap A = null;
  public int B = 300;
  public int C = 10;
  public int D = 1;
  public Bitmap E = null;
  public int F = 0;
  public int G = 0;
  public float H = 0.0F;
  public float I = 0.0F;
  public float J = -1.0F;
  public boolean K = true;
  public boolean L = false;
  public boolean M = false;
  public boolean N = true;
  public int O = 1;
  public boolean P = false;
  public boolean Q = false;
  public int R = 0;
  public boolean S = false;
  public boolean T = true;
  public boolean U = false;
  public boolean V = false;
  public boolean W = false;
  public int X = 0;
  public JSONArray Y = null;
  public int a = 0;
  public int b = 0;
  public int c = 1200;
  public int d = 1500;
  public int e = 800;
  public int f = 5;
  public boolean g = true;
  public int h = 20;
  public int i = 1;
  public int j = 2;
  public c k = c.c;
  public int l = 1;
  public boolean m = true;
  public int n = 3;
  public int o = 0;
  public boolean p = false;
  public int q = 3;
  public int r = 3;
  public int s = 48000;
  public int t = 1;
  public boolean u = true;
  public boolean v = false;
  public boolean w = false;
  public int x = 0;
  public int y = 10;
  public boolean z = false;
  
  public static g.a a(c paramc)
  {
    g.a locala = new g.a();
    switch (g.1.a[paramc.ordinal()])
    {
    default: 
      locala.a = 368;
      locala.b = 640;
      return locala;
    case 23: 
      locala.a = 1920;
      locala.b = 1088;
      return locala;
    case 22: 
      locala.a = 1088;
      locala.b = 1920;
      return locala;
    case 21: 
      locala.a = 128;
      locala.b = 128;
      return locala;
    case 20: 
      locala.a = 320;
      locala.b = 192;
      return locala;
    case 19: 
      locala.a = 480;
      locala.b = 272;
      return locala;
    case 18: 
      locala.a = 320;
      locala.b = 240;
      return locala;
    case 17: 
      locala.a = 480;
      locala.b = 368;
      return locala;
    case 16: 
      locala.a = 640;
      locala.b = 480;
      return locala;
    case 15: 
      locala.a = 1280;
      locala.b = 720;
      return locala;
    case 14: 
      locala.a = 960;
      locala.b = 544;
      return locala;
    case 13: 
      locala.a = 640;
      locala.b = 368;
      return locala;
    case 12: 
      locala.a = 160;
      locala.b = 160;
      return locala;
    case 11: 
      locala.a = 272;
      locala.b = 272;
      return locala;
    case 10: 
      locala.a = 480;
      locala.b = 480;
      return locala;
    case 9: 
      locala.a = 480;
      locala.b = 640;
      return locala;
    case 8: 
      locala.a = 368;
      locala.b = 480;
      return locala;
    case 7: 
      locala.a = 240;
      locala.b = 320;
      return locala;
    case 6: 
      locala.a = 272;
      locala.b = 480;
      return locala;
    case 5: 
      locala.a = 192;
      locala.b = 320;
      return locala;
    case 4: 
      locala.a = 320;
      locala.b = 480;
      return locala;
    case 3: 
      locala.a = 720;
      locala.b = 1280;
      return locala;
    case 2: 
      locala.a = 544;
      locala.b = 960;
      return locala;
    }
    locala.a = 368;
    locala.b = 640;
    return locala;
  }
  
  public boolean a()
  {
    if (this.k != c.a)
    {
      g.a locala = a(this.k);
      this.a = locala.a;
      this.b = locala.b;
    }
    return this.a > this.b;
  }
  
  protected Object clone()
  {
    return (g)super.clone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.g
 * JD-Core Version:    0.7.0.1
 */