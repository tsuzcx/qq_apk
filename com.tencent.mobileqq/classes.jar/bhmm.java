import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;

class bhmm
  implements IVideoInnerStatusListener
{
  bhmm(bhml parambhml) {}
  
  public void notifyVideoClose(int paramInt)
  {
    this.a.b();
  }
  
  public void notifyVideoSeek(int paramInt)
  {
    if (bhml.a(this.a) != null)
    {
      paramInt = (int)(paramInt * bhml.a(this.a).c() / 100.0D);
      bhml.a(this.a, paramInt);
    }
  }
  
  public void notifyVideoStart()
  {
    bhml.a(this.a);
  }
  
  public void notifyVideoStop()
  {
    bhml.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhmm
 * JD-Core Version:    0.7.0.1
 */