package com.tencent.aelight.camera.aioeditor.capture.data;

import com.tencent.aelight.camera.struct.editor.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.List;

public class TemplateGroupItem
  implements Cloneable
{
  public List<PtvTemplateInfo> a;
  public int b;
  public String c;
  public boolean d;
  public String e;
  public int f;
  public boolean g;
  
  public TemplateGroupItem() {}
  
  public TemplateGroupItem(String paramString)
  {
    this.c = paramString;
  }
  
  public TemplateGroupItem a()
  {
    TemplateGroupItem localTemplateGroupItem = new TemplateGroupItem();
    localTemplateGroupItem.c = this.c;
    localTemplateGroupItem.b = this.b;
    localTemplateGroupItem.d = this.d;
    localTemplateGroupItem.e = this.e;
    localTemplateGroupItem.f = this.f;
    localTemplateGroupItem.g = this.g;
    localTemplateGroupItem.a = new ArrayList();
    localTemplateGroupItem.a.addAll(this.a);
    return localTemplateGroupItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.TemplateGroupItem
 * JD-Core Version:    0.7.0.1
 */