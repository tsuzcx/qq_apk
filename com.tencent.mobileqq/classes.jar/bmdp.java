import com.tencent.qg.sdk.QGRenderer.QGEventListener;

class bmdp
  implements QGRenderer.QGEventListener
{
  bmdp(bmdi parambmdi) {}
  
  public void onCanvasCreated()
  {
    wsv.b("StoryEffectTextMode", "Event: Canvas was created");
    bmdi.e(this.a, true);
    bmdi.c(this.a, true);
    bmdi.d(this.a);
  }
  
  public void onDrawFrame()
  {
    if (bmdi.a(this.a) != null) {
      bmdi.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdp
 * JD-Core Version:    0.7.0.1
 */