import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;

class bcur
  implements IVideoInnerStatusListener
{
  bcur(bcuq parambcuq) {}
  
  public void notifyVideoClose(int paramInt)
  {
    this.a.b();
  }
  
  public void notifyVideoSeek(int paramInt)
  {
    if (bcuq.a(this.a) != null)
    {
      paramInt = (int)(paramInt * bcuq.a(this.a).c() / 100.0D);
      bcuq.a(this.a, paramInt);
    }
  }
  
  public void notifyVideoStart()
  {
    bcuq.a(this.a);
  }
  
  public void notifyVideoStop()
  {
    bcuq.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcur
 * JD-Core Version:    0.7.0.1
 */