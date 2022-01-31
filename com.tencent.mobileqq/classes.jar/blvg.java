import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

class blvg
  implements bnpi
{
  blvg(blvf paramblvf) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    synchronized (blvf.a(this.a))
    {
      if (paramPtvTemplateInfo.id.equals(blvf.a(this.a).id))
      {
        blvf.a(this.a).downloading = true;
        blvf.a(this.a, 1.0F * paramInt / 100.0F);
        blvf.a(this.a, 1);
      }
      return;
    }
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    synchronized (blvf.a(this.a))
    {
      if (paramPtvTemplateInfo.id.equals(blvf.a(this.a).id))
      {
        blvf.a(this.a).downloading = false;
        blvf.a(this.a).usable = paramBoolean;
      }
      if (paramBoolean)
      {
        if (blvf.a(this.a).id.equals(paramPtvTemplateInfo.id))
        {
          blvf.a(this.a, 3);
          blvf.a(this.a, 1.0F);
          this.a.b();
        }
        return;
      }
      this.a.a(4);
      blvf.a(this.a, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvg
 * JD-Core Version:    0.7.0.1
 */