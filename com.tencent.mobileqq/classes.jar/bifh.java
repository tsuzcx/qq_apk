import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;

class bifh
  implements IVideoInnerStatusListener
{
  bifh(bifg parambifg) {}
  
  public void notifyVideoClose(int paramInt)
  {
    this.a.b();
  }
  
  public void notifyVideoSeek(int paramInt)
  {
    if (bifg.a(this.a) != null)
    {
      paramInt = (int)(paramInt * bifg.a(this.a).c() / 100.0D);
      bifg.a(this.a, paramInt);
    }
  }
  
  public void notifyVideoStart()
  {
    bifg.a(this.a);
  }
  
  public void notifyVideoStop()
  {
    bifg.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bifh
 * JD-Core Version:    0.7.0.1
 */