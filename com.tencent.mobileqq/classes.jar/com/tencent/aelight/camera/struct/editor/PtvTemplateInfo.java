package com.tencent.aelight.camera.struct.editor;

import java.util.ArrayList;

public class PtvTemplateInfo
{
  public static int y = 1;
  public String A;
  public String B;
  public String C;
  public boolean D = true;
  public String E;
  public String F;
  public String G;
  public String H;
  public String I;
  public String J;
  public String K;
  public boolean L = true;
  public String M;
  public String N;
  public boolean O;
  public String P;
  public String Q;
  public boolean R;
  public String S = "";
  public String T = "";
  public String U = "";
  public double V = 0.0D;
  public long W;
  public long X;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public boolean f;
  public boolean g;
  public boolean h;
  public int i = 0;
  public int j = 0;
  public ArrayList<DoodleInfo> k;
  public int l;
  public int m = 0;
  public boolean n;
  public int o = 0;
  public int p = 0;
  public String q;
  public String r;
  public String s;
  public int t = 0;
  public int u = 0;
  public String v = "";
  public String w = "";
  public int x = 0;
  public boolean z;
  
  public String a(int paramInt)
  {
    if (paramInt != 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("LBS_NORMAL_FILTER_");
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LBS_MACDONALD_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PtvTemplateInfo{id='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", doodleInfo=");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(",usable=");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.struct.editor.PtvTemplateInfo
 * JD-Core Version:    0.7.0.1
 */