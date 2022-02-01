package com.tencent.av.camera.config;

import android.os.Build.VERSION;
import com.tencent.av.config.api.IConfigParser;
import com.tencent.qphone.base.util.QLog;

public class CameraConfigParser
{
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static String j;
  public static String k;
  public static String l;
  public static String m;
  public static String n;
  public static String o;
  public static String p;
  public static String q;
  public static String r;
  public static String s;
  public static String t;
  public static String u;
  public static String v;
  public static String w;
  public static String x;
  public static String y;
  public static String z;
  public int A = 0;
  public byte B = 0;
  public byte C = 0;
  public byte D = 0;
  public byte E = 0;
  public byte F = 0;
  public byte G = 0;
  public byte H = 0;
  public byte I = 0;
  public byte J = 0;
  public byte K = 0;
  public byte L = 0;
  public int M = 0;
  public int N = 0;
  public byte O = 0;
  public byte P = 0;
  public byte Q = 0;
  public byte R = 0;
  public byte S = 0;
  public byte T = 0;
  public byte U = 0;
  public byte V = 0;
  public byte W = 0;
  public byte X = 0;
  public byte Y = 0;
  public int Z = 0;
  @Deprecated
  IConfigParser aa = null;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sharp/camera_angle/");
    localStringBuilder.append("enable");
    a = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle/");
    localStringBuilder.append("local/");
    localStringBuilder.append("front");
    b = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle/");
    localStringBuilder.append("local/");
    localStringBuilder.append("back");
    c = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle/");
    localStringBuilder.append("remote/");
    localStringBuilder.append("front/");
    localStringBuilder.append("0");
    d = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle/");
    localStringBuilder.append("remote/");
    localStringBuilder.append("front/");
    localStringBuilder.append("90");
    e = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle/");
    localStringBuilder.append("remote/");
    localStringBuilder.append("front/");
    localStringBuilder.append("180");
    f = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle/");
    localStringBuilder.append("remote/");
    localStringBuilder.append("front/");
    localStringBuilder.append("270");
    g = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle/");
    localStringBuilder.append("remote/");
    localStringBuilder.append("back/");
    localStringBuilder.append("0");
    h = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle/");
    localStringBuilder.append("remote/");
    localStringBuilder.append("back/");
    localStringBuilder.append("90");
    i = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle/");
    localStringBuilder.append("remote/");
    localStringBuilder.append("back/");
    localStringBuilder.append("180");
    j = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle/");
    localStringBuilder.append("remote/");
    localStringBuilder.append("back/");
    localStringBuilder.append("270");
    k = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle/");
    localStringBuilder.append("sensor");
    l = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle/");
    localStringBuilder.append("mini_sdk");
    m = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle_landscape/");
    localStringBuilder.append("enable");
    n = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle_landscape/");
    localStringBuilder.append("local/");
    localStringBuilder.append("front");
    o = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle_landscape/");
    localStringBuilder.append("local/");
    localStringBuilder.append("back");
    p = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle_landscape/");
    localStringBuilder.append("remote/");
    localStringBuilder.append("front/");
    localStringBuilder.append("0");
    q = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle_landscape/");
    localStringBuilder.append("remote/");
    localStringBuilder.append("front/");
    localStringBuilder.append("90");
    r = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle_landscape/");
    localStringBuilder.append("remote/");
    localStringBuilder.append("front/");
    localStringBuilder.append("180");
    s = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle_landscape/");
    localStringBuilder.append("remote/");
    localStringBuilder.append("front/");
    localStringBuilder.append("270");
    t = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle_landscape/");
    localStringBuilder.append("remote/");
    localStringBuilder.append("back/");
    localStringBuilder.append("0");
    u = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle_landscape/");
    localStringBuilder.append("remote/");
    localStringBuilder.append("back/");
    localStringBuilder.append("90");
    v = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle_landscape/");
    localStringBuilder.append("remote/");
    localStringBuilder.append("back/");
    localStringBuilder.append("180");
    w = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle_landscape/");
    localStringBuilder.append("remote/");
    localStringBuilder.append("back/");
    localStringBuilder.append("270");
    x = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle_landscape/");
    localStringBuilder.append("sensor");
    y = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("sharp/camera_angle_landscape/");
    localStringBuilder.append("mini_sdk");
    z = localStringBuilder.toString();
    localStringBuilder.setLength(0);
  }
  
  private byte a(int paramInt)
  {
    if ((paramInt >= -128) && (paramInt <= 127)) {
      return (byte)paramInt;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" out of the range of byte");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public boolean a(IConfigParser paramIConfigParser)
  {
    return paramIConfigParser.getIntValue(a, this.A) >= 1;
  }
  
  public boolean b(IConfigParser paramIConfigParser)
  {
    boolean bool1 = a(paramIConfigParser);
    boolean bool2 = false;
    if (bool1)
    {
      try
      {
        this.M = paramIConfigParser.getIntValue(m, this.M);
        if (Build.VERSION.SDK_INT >= this.M)
        {
          this.B = a(paramIConfigParser.getIntValue(b, this.B));
          this.C = a(paramIConfigParser.getIntValue(c, this.C));
          this.D = a(paramIConfigParser.getIntValue(d, this.D));
          this.E = a(paramIConfigParser.getIntValue(e, this.E));
          this.F = a(paramIConfigParser.getIntValue(f, this.F));
          this.G = a(paramIConfigParser.getIntValue(g, this.G));
          this.H = a(paramIConfigParser.getIntValue(h, this.H));
          this.I = a(paramIConfigParser.getIntValue(i, this.I));
          this.J = a(paramIConfigParser.getIntValue(j, this.J));
          this.K = a(paramIConfigParser.getIntValue(k, this.K));
          this.L = a(paramIConfigParser.getIntValue(l, this.L));
          bool1 = true;
        }
        else
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            paramIConfigParser = new StringBuilder();
            paramIConfigParser.append("ignore camera angle config: sdk version not in range, miniSdk:");
            paramIConfigParser.append(this.M);
            QLog.d("CameraConfigParser", 2, paramIConfigParser.toString());
            bool1 = bool2;
          }
        }
      }
      catch (Exception paramIConfigParser)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CameraConfigParser", 2, "parse camera angle config error, reset data.", paramIConfigParser);
        }
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("CameraConfigParser", 2, "camera angle config disable, return");
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel())
    {
      paramIConfigParser = new StringBuilder();
      paramIConfigParser.append("valueLocalFront:");
      paramIConfigParser.append(this.B);
      paramIConfigParser.append(", valueLocalBack:");
      paramIConfigParser.append(this.C);
      paramIConfigParser.append(", valueRemoteFront0:");
      paramIConfigParser.append(this.D);
      paramIConfigParser.append(", valueRemoteFront90:");
      paramIConfigParser.append(this.E);
      paramIConfigParser.append(", valueRemoteFront180:");
      paramIConfigParser.append(this.F);
      paramIConfigParser.append(", valueRemoteFront270:");
      paramIConfigParser.append(this.G);
      paramIConfigParser.append(", valueRemoteBack0:");
      paramIConfigParser.append(this.H);
      paramIConfigParser.append(", valueRemoteBack90:");
      paramIConfigParser.append(this.I);
      paramIConfigParser.append(", valueRemoteBack180:");
      paramIConfigParser.append(this.J);
      paramIConfigParser.append(", valueRemoteBack270:");
      paramIConfigParser.append(this.K);
      paramIConfigParser.append(", valueSensor:");
      paramIConfigParser.append(this.L);
      paramIConfigParser.append(", valueMiniSdk:");
      paramIConfigParser.append(this.M);
      QLog.d("CameraConfigParser", 2, paramIConfigParser.toString());
    }
    return bool1;
  }
  
  public boolean c(IConfigParser paramIConfigParser)
  {
    return paramIConfigParser.getIntValue(n, this.N) >= 1;
  }
  
  public boolean d(IConfigParser paramIConfigParser)
  {
    boolean bool1 = c(paramIConfigParser);
    boolean bool2 = false;
    if (bool1)
    {
      try
      {
        this.Z = paramIConfigParser.getIntValue(z, this.Z);
        if (Build.VERSION.SDK_INT >= this.Z)
        {
          this.O = a(paramIConfigParser.getIntValue(o, this.O));
          this.P = a(paramIConfigParser.getIntValue(p, this.P));
          this.Q = a(paramIConfigParser.getIntValue(q, this.Q));
          this.R = a(paramIConfigParser.getIntValue(r, this.R));
          this.S = a(paramIConfigParser.getIntValue(s, this.S));
          this.T = a(paramIConfigParser.getIntValue(t, this.T));
          this.U = a(paramIConfigParser.getIntValue(u, this.U));
          this.V = a(paramIConfigParser.getIntValue(v, this.V));
          this.W = a(paramIConfigParser.getIntValue(w, this.W));
          this.X = a(paramIConfigParser.getIntValue(x, this.X));
          this.Y = a(paramIConfigParser.getIntValue(y, this.Y));
          bool1 = true;
        }
        else
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            paramIConfigParser = new StringBuilder();
            paramIConfigParser.append("ignore camera landscape angle config: sdk version not in range, miniSdk:");
            paramIConfigParser.append(this.Z);
            QLog.d("CameraConfigParser", 2, paramIConfigParser.toString());
            bool1 = bool2;
          }
        }
      }
      catch (Exception paramIConfigParser)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CameraConfigParser", 2, "parse camera landscape angle config error, reset data.", paramIConfigParser);
        }
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("CameraConfigParser", 2, "camera landscape angle config disable");
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel())
    {
      paramIConfigParser = new StringBuilder();
      paramIConfigParser.append("valueLandscapeLocalFront:");
      paramIConfigParser.append(this.O);
      paramIConfigParser.append(", valueLandscapeLocalBack:");
      paramIConfigParser.append(this.P);
      paramIConfigParser.append(", valueLandscapeRemoteFront0:");
      paramIConfigParser.append(this.Q);
      paramIConfigParser.append(", valueLandscapeRemoteFront90:");
      paramIConfigParser.append(this.R);
      paramIConfigParser.append(", valueLandscapeRemoteFront180:");
      paramIConfigParser.append(this.S);
      paramIConfigParser.append(", valueLandscapeRemoteFront270:");
      paramIConfigParser.append(this.T);
      paramIConfigParser.append(", valueLandscapeRemoteBack0:");
      paramIConfigParser.append(this.U);
      paramIConfigParser.append(", valueLandscapeRemoteBack90:");
      paramIConfigParser.append(this.V);
      paramIConfigParser.append(", valueLandscapeRemoteBack180:");
      paramIConfigParser.append(this.W);
      paramIConfigParser.append(", valueLandscapeRemoteBack270:");
      paramIConfigParser.append(this.X);
      paramIConfigParser.append(", valueLandscapeSensor:");
      paramIConfigParser.append(this.Y);
      paramIConfigParser.append(", valueLandscapeMiniSdk:");
      paramIConfigParser.append(this.Z);
      QLog.d("CameraConfigParser", 2, paramIConfigParser.toString());
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.camera.config.CameraConfigParser
 * JD-Core Version:    0.7.0.1
 */