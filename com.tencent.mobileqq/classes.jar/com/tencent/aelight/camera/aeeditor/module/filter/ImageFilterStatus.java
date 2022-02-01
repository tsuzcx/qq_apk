package com.tencent.aelight.camera.aeeditor.module.filter;

import com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterResult;
import com.tencent.aelight.camera.aeeditor.module.aifilter.ComicsFilterResult;

public class ImageFilterStatus
{
  private int a = -1;
  private int b = -1;
  private String c = null;
  private float d = 1.0F;
  private AIFilterResult e;
  private ComicsFilterResult f;
  private AEEditorFilterBean.FilterID g = AEEditorFilterBean.FilterID.NON;
  
  public void a()
  {
    this.c = null;
    this.d = 1.0F;
    this.a = this.b;
    this.b = -1;
    this.g = AEEditorFilterBean.FilterID.NON;
  }
  
  public void a(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public void a(AIFilterResult paramAIFilterResult)
  {
    this.c = null;
    this.e = paramAIFilterResult;
    this.a = this.b;
    this.b = AEEditorFilterControlPanel.a;
    this.g = AEEditorFilterBean.FilterID.AIFilter;
  }
  
  public void a(ComicsFilterResult paramComicsFilterResult, int paramInt)
  {
    this.f = paramComicsFilterResult;
    this.a = this.b;
    this.b = paramInt;
    this.g = AEEditorFilterBean.FilterID.NETWORK;
  }
  
  public void a(String paramString, float paramFloat, int paramInt)
  {
    this.c = paramString;
    this.d = paramFloat;
    this.a = this.b;
    this.b = paramInt;
    this.g = AEEditorFilterBean.FilterID.CLIENT;
  }
  
  public boolean b()
  {
    return this.g == AEEditorFilterBean.FilterID.NON;
  }
  
  public boolean c()
  {
    return this.g == AEEditorFilterBean.FilterID.AIFilter;
  }
  
  public boolean d()
  {
    return this.g == AEEditorFilterBean.FilterID.NETWORK;
  }
  
  public int e()
  {
    return this.b;
  }
  
  public int f()
  {
    return this.a;
  }
  
  public String g()
  {
    return this.c;
  }
  
  public float h()
  {
    return this.d;
  }
  
  public AIFilterResult i()
  {
    return this.e;
  }
  
  public ComicsFilterResult j()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.filter.ImageFilterStatus
 * JD-Core Version:    0.7.0.1
 */