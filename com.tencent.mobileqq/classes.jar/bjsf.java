import com.tencent.qg.sdk.QGRenderer.QGEventListener;

class bjsf
  implements QGRenderer.QGEventListener
{
  bjsf(bjry parambjry) {}
  
  public void onCanvasCreated()
  {
    ved.b("StoryEffectTextMode", "Event: Canvas was created");
    bjry.e(this.a, true);
    bjry.c(this.a, true);
    bjry.d(this.a);
  }
  
  public void onDrawFrame()
  {
    if (bjry.a(this.a) != null) {
      bjry.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjsf
 * JD-Core Version:    0.7.0.1
 */