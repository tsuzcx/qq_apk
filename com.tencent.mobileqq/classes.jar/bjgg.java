import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;

class bjgg
  implements IVideoInnerStatusListener
{
  bjgg(bjgf parambjgf) {}
  
  public void notifyVideoClose(int paramInt)
  {
    this.a.b();
  }
  
  public void notifyVideoSeek(int paramInt)
  {
    if (bjgf.a(this.a) != null)
    {
      paramInt = (int)(paramInt * bjgf.a(this.a).c() / 100.0D);
      bjgf.a(this.a, paramInt);
    }
  }
  
  public void notifyVideoStart()
  {
    bjgf.a(this.a);
  }
  
  public void notifyVideoStop()
  {
    bjgf.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjgg
 * JD-Core Version:    0.7.0.1
 */