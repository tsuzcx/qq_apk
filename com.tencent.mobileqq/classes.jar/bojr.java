import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

class bojr
  implements bpqq
{
  bojr(bojq parambojq) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    synchronized (bojq.a(this.a))
    {
      if (paramPtvTemplateInfo.id.equals(bojq.a(this.a).id))
      {
        bojq.a(this.a).downloading = true;
        bojq.a(this.a, 1.0F * paramInt / 100.0F);
        bojq.a(this.a, 1);
      }
      return;
    }
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    synchronized (bojq.a(this.a))
    {
      if (paramPtvTemplateInfo.id.equals(bojq.a(this.a).id))
      {
        bojq.a(this.a).downloading = false;
        bojq.a(this.a).usable = paramBoolean;
      }
      if (paramBoolean)
      {
        if (bojq.a(this.a).id.equals(paramPtvTemplateInfo.id))
        {
          bojq.a(this.a, 3);
          bojq.a(this.a, 1.0F);
          this.a.b();
        }
        return;
      }
      this.a.a(4);
      bojq.a(this.a, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bojr
 * JD-Core Version:    0.7.0.1
 */