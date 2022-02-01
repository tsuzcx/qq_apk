import com.tencent.qg.sdk.QGRenderer.QGEventListener;

class bozh
  implements QGRenderer.QGEventListener
{
  bozh(boza paramboza) {}
  
  public void onCanvasCreated()
  {
    yqp.b("StoryEffectTextMode", "Event: Canvas was created");
    boza.e(this.a, true);
    boza.c(this.a, true);
    boza.d(this.a);
  }
  
  public void onDrawFrame()
  {
    if (boza.a(this.a) != null) {
      boza.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bozh
 * JD-Core Version:    0.7.0.1
 */