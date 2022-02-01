import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;

class bixc
  implements IVideoInnerStatusListener
{
  bixc(bixb parambixb) {}
  
  public void notifyVideoClose(int paramInt)
  {
    this.a.b();
  }
  
  public void notifyVideoSeek(int paramInt)
  {
    if (bixb.a(this.a) != null)
    {
      paramInt = (int)(paramInt * bixb.a(this.a).c() / 100.0D);
      bixb.a(this.a, paramInt);
    }
  }
  
  public void notifyVideoStart()
  {
    bixb.a(this.a);
  }
  
  public void notifyVideoStop()
  {
    bixb.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bixc
 * JD-Core Version:    0.7.0.1
 */