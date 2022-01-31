import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;

class beyj
  implements IVideoInnerStatusListener
{
  beyj(beyi parambeyi) {}
  
  public void notifyVideoClose(int paramInt)
  {
    this.a.b();
  }
  
  public void notifyVideoSeek(int paramInt)
  {
    if (beyi.a(this.a) != null)
    {
      paramInt = (int)(paramInt * beyi.a(this.a).c() / 100.0D);
      beyi.a(this.a, paramInt);
    }
  }
  
  public void notifyVideoStart()
  {
    beyi.a(this.a);
  }
  
  public void notifyVideoStop()
  {
    beyi.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beyj
 * JD-Core Version:    0.7.0.1
 */