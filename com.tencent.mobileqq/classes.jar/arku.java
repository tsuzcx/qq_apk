import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;

class arku
  implements IVideoInnerStatusListener
{
  arku(arkt paramarkt) {}
  
  public void notifyVideoClose(int paramInt) {}
  
  public void notifyVideoSeek(int paramInt) {}
  
  public void notifyVideoStart()
  {
    if (arkt.a(this.a) != null)
    {
      asgl.a().a(1, arkt.a(this.a));
      return;
    }
    this.a.a(false);
  }
  
  public void notifyVideoStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arku
 * JD-Core Version:    0.7.0.1
 */