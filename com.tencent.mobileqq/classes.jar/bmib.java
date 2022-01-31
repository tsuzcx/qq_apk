import com.tencent.qg.sdk.QGRenderer.QGEventListener;

class bmib
  implements QGRenderer.QGEventListener
{
  bmib(bmhu parambmhu) {}
  
  public void onCanvasCreated()
  {
    wxe.b("StoryEffectTextMode", "Event: Canvas was created");
    bmhu.e(this.a, true);
    bmhu.c(this.a, true);
    bmhu.d(this.a);
  }
  
  public void onDrawFrame()
  {
    if (bmhu.a(this.a) != null) {
      bmhu.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmib
 * JD-Core Version:    0.7.0.1
 */