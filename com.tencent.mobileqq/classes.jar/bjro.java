import com.tencent.qg.sdk.QGRenderer.QGEventListener;

class bjro
  implements QGRenderer.QGEventListener
{
  bjro(bjrh parambjrh) {}
  
  public void onCanvasCreated()
  {
    veg.b("StoryEffectTextMode", "Event: Canvas was created");
    bjrh.e(this.a, true);
    bjrh.c(this.a, true);
    bjrh.d(this.a);
  }
  
  public void onDrawFrame()
  {
    if (bjrh.a(this.a) != null) {
      bjrh.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjro
 * JD-Core Version:    0.7.0.1
 */