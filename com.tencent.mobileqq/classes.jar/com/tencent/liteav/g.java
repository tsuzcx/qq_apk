package com.tencent.liteav;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.b.c;
import org.json.JSONArray;

public class g
  implements Cloneable
{
  public boolean A = false;
  public Bitmap B = null;
  public int C = 300;
  public int D = 10;
  public int E = 1;
  public Bitmap F = null;
  public int G = 0;
  public int H = 0;
  public float I = 0.0F;
  public float J = 0.0F;
  public float K = -1.0F;
  public boolean L = true;
  public boolean M = false;
  public boolean N = false;
  public boolean O = true;
  public int P = 1;
  public boolean Q = false;
  public boolean R = false;
  public int S = 0;
  public boolean T = false;
  public boolean U = true;
  public boolean V = false;
  public boolean W = false;
  public boolean X = false;
  public int Y = 0;
  public JSONArray Z = null;
  public int a = 0;
  public int b = 0;
  public int c = 1200;
  public int d = 1500;
  public int e = 800;
  public int f = 5;
  public boolean g = true;
  public boolean h = false;
  public int i = 20;
  public int j = 1;
  public int k = 2;
  public c l = c.c;
  public int m = 1;
  public boolean n = true;
  public int o = 3;
  public int p = 0;
  public boolean q = false;
  public int r = 3;
  public int s = 3;
  public int t = 48000;
  public int u = 1;
  public boolean v = true;
  public boolean w = false;
  public boolean x = false;
  public int y = 0;
  public int z = 10;
  
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
    if (this.l != c.a)
    {
      g.a locala = a(this.l);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.g
 * JD-Core Version:    0.7.0.1
 */