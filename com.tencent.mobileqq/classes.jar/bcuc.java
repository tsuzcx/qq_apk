import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;

class bcuc
  implements IVideoInnerStatusListener
{
  bcuc(bcub parambcub) {}
  
  public void notifyVideoClose(int paramInt)
  {
    this.a.b();
  }
  
  public void notifyVideoSeek(int paramInt)
  {
    if (bcub.a(this.a) != null)
    {
      paramInt = (int)(paramInt * bcub.a(this.a).c() / 100.0D);
      bcub.a(this.a, paramInt);
    }
  }
  
  public void notifyVideoStart()
  {
    bcub.a(this.a);
  }
  
  public void notifyVideoStop()
  {
    bcub.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcuc
 * JD-Core Version:    0.7.0.1
 */