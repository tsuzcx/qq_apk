import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;

class atft
  implements IVideoInnerStatusListener
{
  atft(atfs paramatfs) {}
  
  public void notifyVideoClose(int paramInt) {}
  
  public void notifyVideoSeek(int paramInt) {}
  
  public void notifyVideoStart()
  {
    if (atfs.a(this.a) != null)
    {
      aubw.a().a(1, atfs.a(this.a));
      return;
    }
    this.a.a(false);
  }
  
  public void notifyVideoStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atft
 * JD-Core Version:    0.7.0.1
 */