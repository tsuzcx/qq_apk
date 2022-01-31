import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;

class beua
  implements IVideoInnerStatusListener
{
  beua(betz parambetz) {}
  
  public void notifyVideoClose(int paramInt)
  {
    this.a.b();
  }
  
  public void notifyVideoSeek(int paramInt)
  {
    if (betz.a(this.a) != null)
    {
      paramInt = (int)(paramInt * betz.a(this.a).c() / 100.0D);
      betz.a(this.a, paramInt);
    }
  }
  
  public void notifyVideoStart()
  {
    betz.a(this.a);
  }
  
  public void notifyVideoStop()
  {
    betz.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beua
 * JD-Core Version:    0.7.0.1
 */