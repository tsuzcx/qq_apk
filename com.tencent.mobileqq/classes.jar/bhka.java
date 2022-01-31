import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

class bhka
  implements bjik
{
  bhka(bhjz parambhjz) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    synchronized (bhjz.a(this.a))
    {
      if (paramPtvTemplateInfo.id.equals(bhjz.a(this.a).id))
      {
        bhjz.a(this.a).downloading = true;
        bhjz.a(this.a, 1.0F * paramInt / 100.0F);
        bhjz.a(this.a, 1);
      }
      return;
    }
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    synchronized (bhjz.a(this.a))
    {
      if (paramPtvTemplateInfo.id.equals(bhjz.a(this.a).id))
      {
        bhjz.a(this.a).downloading = false;
        bhjz.a(this.a).usable = paramBoolean;
      }
      if (paramBoolean)
      {
        if (bhjz.a(this.a).id.equals(paramPtvTemplateInfo.id))
        {
          bhjz.a(this.a, 3);
          bhjz.a(this.a, 1.0F);
          this.a.b();
        }
        return;
      }
      this.a.a(4);
      bhjz.a(this.a, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhka
 * JD-Core Version:    0.7.0.1
 */