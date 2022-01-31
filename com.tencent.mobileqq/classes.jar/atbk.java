import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;

class atbk
  implements IVideoInnerStatusListener
{
  atbk(atbj paramatbj) {}
  
  public void notifyVideoClose(int paramInt) {}
  
  public void notifyVideoSeek(int paramInt) {}
  
  public void notifyVideoStart()
  {
    if (atbj.a(this.a) != null)
    {
      atxn.a().a(1, atbj.a(this.a));
      return;
    }
    this.a.a(false);
  }
  
  public void notifyVideoStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbk
 * JD-Core Version:    0.7.0.1
 */