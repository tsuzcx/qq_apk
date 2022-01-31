import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

class bjfj
  implements bkzm
{
  bjfj(bjfi parambjfi) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    synchronized (bjfi.a(this.a))
    {
      if (paramPtvTemplateInfo.id.equals(bjfi.a(this.a).id))
      {
        bjfi.a(this.a).downloading = true;
        bjfi.a(this.a, 1.0F * paramInt / 100.0F);
        bjfi.a(this.a, 1);
      }
      return;
    }
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    synchronized (bjfi.a(this.a))
    {
      if (paramPtvTemplateInfo.id.equals(bjfi.a(this.a).id))
      {
        bjfi.a(this.a).downloading = false;
        bjfi.a(this.a).usable = paramBoolean;
      }
      if (paramBoolean)
      {
        if (bjfi.a(this.a).id.equals(paramPtvTemplateInfo.id))
        {
          bjfi.a(this.a, 3);
          bjfi.a(this.a, 1.0F);
          this.a.b();
        }
        return;
      }
      this.a.a(4);
      bjfi.a(this.a, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjfj
 * JD-Core Version:    0.7.0.1
 */