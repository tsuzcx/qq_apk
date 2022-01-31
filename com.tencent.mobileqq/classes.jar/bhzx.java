import com.tencent.qg.sdk.QGRenderer.QGEventListener;

class bhzx
  implements QGRenderer.QGEventListener
{
  bhzx(bhzq parambhzq) {}
  
  public void onCanvasCreated()
  {
    urk.b("StoryEffectTextMode", "Event: Canvas was created");
    bhzq.e(this.a, true);
    bhzq.c(this.a, true);
    bhzq.d(this.a);
  }
  
  public void onDrawFrame()
  {
    if (bhzq.a(this.a) != null) {
      bhzq.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhzx
 * JD-Core Version:    0.7.0.1
 */