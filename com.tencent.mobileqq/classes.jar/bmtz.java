import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

class bmtz
  implements boay
{
  bmtz(bmty parambmty) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    synchronized (bmty.a(this.a))
    {
      if (paramPtvTemplateInfo.id.equals(bmty.a(this.a).id))
      {
        bmty.a(this.a).downloading = true;
        bmty.a(this.a, 1.0F * paramInt / 100.0F);
        bmty.a(this.a, 1);
      }
      return;
    }
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    synchronized (bmty.a(this.a))
    {
      if (paramPtvTemplateInfo.id.equals(bmty.a(this.a).id))
      {
        bmty.a(this.a).downloading = false;
        bmty.a(this.a).usable = paramBoolean;
      }
      if (paramBoolean)
      {
        if (bmty.a(this.a).id.equals(paramPtvTemplateInfo.id))
        {
          bmty.a(this.a, 3);
          bmty.a(this.a, 1.0F);
          this.a.b();
        }
        return;
      }
      this.a.a(4);
      bmty.a(this.a, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmtz
 * JD-Core Version:    0.7.0.1
 */