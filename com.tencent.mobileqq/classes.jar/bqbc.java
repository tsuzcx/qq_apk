import com.tencent.qg.sdk.QGRenderer.QGEventListener;

class bqbc
  implements QGRenderer.QGEventListener
{
  bqbc(bqav parambqav) {}
  
  public void onCanvasCreated()
  {
    yuk.b("StoryEffectTextMode", "Event: Canvas was created");
    bqav.e(this.a, true);
    bqav.c(this.a, true);
    bqav.d(this.a);
  }
  
  public void onDrawFrame()
  {
    if (bqav.a(this.a) != null) {
      bqav.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqbc
 * JD-Core Version:    0.7.0.1
 */