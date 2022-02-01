import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

class book
  implements bqfz
{
  book(booj parambooj) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    synchronized (booj.a(this.a))
    {
      if (paramPtvTemplateInfo.id.equals(booj.a(this.a).id))
      {
        booj.a(this.a).downloading = true;
        booj.a(this.a, 1.0F * paramInt / 100.0F);
        booj.a(this.a, 1);
      }
      return;
    }
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    synchronized (booj.a(this.a))
    {
      if (paramPtvTemplateInfo.id.equals(booj.a(this.a).id))
      {
        booj.a(this.a).downloading = false;
        booj.a(this.a).usable = paramBoolean;
      }
      if (paramBoolean)
      {
        if (booj.a(this.a).id.equals(paramPtvTemplateInfo.id))
        {
          booj.a(this.a, 3);
          booj.a(this.a, 1.0F);
          this.a.b();
        }
        return;
      }
      this.a.a(4);
      booj.a(this.a, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     book
 * JD-Core Version:    0.7.0.1
 */