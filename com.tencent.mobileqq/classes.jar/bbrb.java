import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;

class bbrb
  implements IVideoInnerStatusListener
{
  bbrb(bbra parambbra) {}
  
  public void notifyVideoClose(int paramInt)
  {
    this.a.b();
  }
  
  public void notifyVideoSeek(int paramInt)
  {
    if (bbra.a(this.a) != null)
    {
      paramInt = (int)(paramInt * bbra.a(this.a).c() / 100.0D);
      bbra.a(this.a, paramInt);
    }
  }
  
  public void notifyVideoStart()
  {
    bbra.a(this.a);
  }
  
  public void notifyVideoStop()
  {
    bbra.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbrb
 * JD-Core Version:    0.7.0.1
 */