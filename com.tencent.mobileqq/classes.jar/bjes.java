import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

class bjes
  implements bkyv
{
  bjes(bjer parambjer) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    synchronized (bjer.a(this.a))
    {
      if (paramPtvTemplateInfo.id.equals(bjer.a(this.a).id))
      {
        bjer.a(this.a).downloading = true;
        bjer.a(this.a, 1.0F * paramInt / 100.0F);
        bjer.a(this.a, 1);
      }
      return;
    }
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    synchronized (bjer.a(this.a))
    {
      if (paramPtvTemplateInfo.id.equals(bjer.a(this.a).id))
      {
        bjer.a(this.a).downloading = false;
        bjer.a(this.a).usable = paramBoolean;
      }
      if (paramBoolean)
      {
        if (bjer.a(this.a).id.equals(paramPtvTemplateInfo.id))
        {
          bjer.a(this.a, 3);
          bjer.a(this.a, 1.0F);
          this.a.b();
        }
        return;
      }
      this.a.a(4);
      bjer.a(this.a, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjes
 * JD-Core Version:    0.7.0.1
 */