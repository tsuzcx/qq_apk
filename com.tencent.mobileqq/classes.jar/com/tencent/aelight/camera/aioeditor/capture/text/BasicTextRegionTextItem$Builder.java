package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.List;

public class BasicTextRegionTextItem$Builder
{
  ArrayList<BaseTextRegion> a = new ArrayList();
  Typeface b = null;
  int c;
  boolean d = false;
  float e = 0.0F;
  float f = 0.0F;
  float g = 0.0F;
  int h = 0;
  boolean i = false;
  float j = 0.0F;
  int k = 0;
  
  public BasicTextRegionTextItem$Builder()
  {
    this.a.clear();
  }
  
  public BasicTextRegionTextItem a(int paramInt, List<String> paramList)
  {
    BasicTextRegionTextItem localBasicTextRegionTextItem = new BasicTextRegionTextItem(paramInt, paramList);
    localBasicTextRegionTextItem.a.clear();
    localBasicTextRegionTextItem.a.addAll(this.a);
    Typeface localTypeface = this.b;
    if (localTypeface != null) {
      localBasicTextRegionTextItem.a(localTypeface);
    }
    localBasicTextRegionTextItem.a(this.c);
    if (this.d) {
      BasicTextRegionTextItem.a(localBasicTextRegionTextItem, this.e, this.f, this.g, this.h);
    }
    BasicTextRegionTextItem.a(localBasicTextRegionTextItem, this.i, this.j, this.k);
    if (!paramList.isEmpty()) {
      localBasicTextRegionTextItem.a(0, (String)paramList.get(0));
    }
    return localBasicTextRegionTextItem;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(Typeface paramTypeface)
  {
    this.b = paramTypeface;
  }
  
  public void a(BaseTextRegion paramBaseTextRegion)
  {
    this.a.add(paramBaseTextRegion);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.BasicTextRegionTextItem.Builder
 * JD-Core Version:    0.7.0.1
 */