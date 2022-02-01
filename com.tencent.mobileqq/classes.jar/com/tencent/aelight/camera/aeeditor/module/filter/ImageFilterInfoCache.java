package com.tencent.aelight.camera.aeeditor.module.filter;

import com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterResult;
import com.tencent.aelight.camera.aeeditor.module.aifilter.ComicsFilterResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImageFilterInfoCache
{
  private List<ImageFilterStatus> a = new ArrayList(9);
  private String[] b = new String[9];
  private List<HashMap<Integer, Float>> c = new ArrayList();
  private int d = 0;
  
  public ImageFilterInfoCache()
  {
    b();
  }
  
  private ImageFilterStatus o(int paramInt)
  {
    return (ImageFilterStatus)this.a.get(paramInt);
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.d)
    {
      ((ImageFilterStatus)this.a.get(i)).a();
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt <= 9)
    {
      this.d = paramInt;
      return;
    }
    throw new IllegalArgumentException("image count > max count 9");
  }
  
  public void a(int paramInt, float paramFloat)
  {
    o(paramInt).a(paramFloat);
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat)
  {
    ((HashMap)this.c.get(paramInt1)).put(Integer.valueOf(paramInt2), Float.valueOf(paramFloat));
  }
  
  public void a(int paramInt, AIFilterResult paramAIFilterResult)
  {
    o(paramInt).a(paramAIFilterResult);
  }
  
  public void a(int paramInt1, ComicsFilterResult paramComicsFilterResult, int paramInt2)
  {
    o(paramInt1).a(paramComicsFilterResult, paramInt2);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.b[paramInt] = paramString;
  }
  
  public void a(int paramInt1, String paramString, float paramFloat, int paramInt2)
  {
    ((ImageFilterStatus)this.a.get(paramInt1)).a(paramString, paramFloat, paramInt2);
  }
  
  public float b(int paramInt1, int paramInt2, float paramFloat)
  {
    if (!((HashMap)this.c.get(paramInt1)).containsKey(Integer.valueOf(paramInt2))) {
      return paramFloat;
    }
    return ((Float)((HashMap)this.c.get(paramInt1)).get(Integer.valueOf(paramInt2))).floatValue();
  }
  
  public int b(int paramInt)
  {
    return o(paramInt).e();
  }
  
  public void b()
  {
    this.a.clear();
    this.c.clear();
    int i = 0;
    while (i < 9)
    {
      this.a.add(new ImageFilterStatus());
      this.c.add(new HashMap());
      this.b[i] = "";
      i += 1;
    }
  }
  
  public int c(int paramInt)
  {
    return o(paramInt).f();
  }
  
  public String d(int paramInt)
  {
    return o(paramInt).g();
  }
  
  public float e(int paramInt)
  {
    return o(paramInt).h();
  }
  
  public AIFilterResult f(int paramInt)
  {
    return o(paramInt).i();
  }
  
  public ComicsFilterResult g(int paramInt)
  {
    return o(paramInt).j();
  }
  
  public void h(int paramInt)
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((ImageFilterStatus)this.a.get(i)).a(((ImageFilterStatus)this.a.get(paramInt)).g(), ((ImageFilterStatus)this.a.get(paramInt)).h(), ((ImageFilterStatus)this.a.get(paramInt)).e());
      ((HashMap)this.c.get(i)).put(Integer.valueOf(((ImageFilterStatus)this.a.get(paramInt)).e()), Float.valueOf(((ImageFilterStatus)this.a.get(paramInt)).h()));
      i += 1;
    }
  }
  
  public void i(int paramInt)
  {
    o(paramInt).a();
  }
  
  public String j(int paramInt)
  {
    return this.b[paramInt];
  }
  
  public boolean k(int paramInt)
  {
    return o(paramInt).b();
  }
  
  public boolean l(int paramInt)
  {
    return o(paramInt).c();
  }
  
  public boolean m(int paramInt)
  {
    return o(paramInt).d();
  }
  
  public void n(int paramInt)
  {
    int i = ((ImageFilterStatus)this.a.get(paramInt)).e();
    ((ImageFilterStatus)this.a.get(paramInt)).a(null, i);
    this.c.set(paramInt, new HashMap());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.filter.ImageFilterInfoCache
 * JD-Core Version:    0.7.0.1
 */