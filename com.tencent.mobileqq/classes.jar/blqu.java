import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

class blqu
  implements bnkw
{
  blqu(blqt paramblqt) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    synchronized (blqt.a(this.a))
    {
      if (paramPtvTemplateInfo.id.equals(blqt.a(this.a).id))
      {
        blqt.a(this.a).downloading = true;
        blqt.a(this.a, 1.0F * paramInt / 100.0F);
        blqt.a(this.a, 1);
      }
      return;
    }
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    synchronized (blqt.a(this.a))
    {
      if (paramPtvTemplateInfo.id.equals(blqt.a(this.a).id))
      {
        blqt.a(this.a).downloading = false;
        blqt.a(this.a).usable = paramBoolean;
      }
      if (paramBoolean)
      {
        if (blqt.a(this.a).id.equals(paramPtvTemplateInfo.id))
        {
          blqt.a(this.a, 3);
          blqt.a(this.a, 1.0F);
          this.a.b();
        }
        return;
      }
      this.a.a(4);
      blqt.a(this.a, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqu
 * JD-Core Version:    0.7.0.1
 */