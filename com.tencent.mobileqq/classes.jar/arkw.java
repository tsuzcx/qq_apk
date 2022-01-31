import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;

class arkw
  implements IVideoInnerStatusListener
{
  arkw(arkv paramarkv) {}
  
  public void notifyVideoClose(int paramInt) {}
  
  public void notifyVideoSeek(int paramInt) {}
  
  public void notifyVideoStart()
  {
    if (arkv.a(this.a) != null)
    {
      asgn.a().a(1, arkv.a(this.a));
      return;
    }
    this.a.a(false);
  }
  
  public void notifyVideoStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arkw
 * JD-Core Version:    0.7.0.1
 */