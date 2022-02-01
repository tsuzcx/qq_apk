import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

class bpqf
  implements brhk
{
  bpqf(bpqe parambpqe) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    synchronized (bpqe.a(this.a))
    {
      if (paramPtvTemplateInfo.id.equals(bpqe.a(this.a).id))
      {
        bpqe.a(this.a).downloading = true;
        bpqe.a(this.a, 1.0F * paramInt / 100.0F);
        bpqe.a(this.a, 1);
      }
      return;
    }
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    synchronized (bpqe.a(this.a))
    {
      if (paramPtvTemplateInfo.id.equals(bpqe.a(this.a).id))
      {
        bpqe.a(this.a).downloading = false;
        bpqe.a(this.a).usable = paramBoolean;
      }
      if (paramBoolean)
      {
        if (bpqe.a(this.a).id.equals(paramPtvTemplateInfo.id))
        {
          bpqe.a(this.a, 3);
          bpqe.a(this.a, 1.0F);
          this.a.b();
        }
        return;
      }
      this.a.a(4);
      bpqe.a(this.a, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpqf
 * JD-Core Version:    0.7.0.1
 */