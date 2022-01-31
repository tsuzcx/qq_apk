import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public class bkde
  implements bkas
{
  public bkde(DoodleLayout paramDoodleLayout) {}
  
  public void a()
  {
    veg.b("DoodleLayout", "deleteInteractPaster.");
    if (DoodleLayout.a(this.a) != null)
    {
      bjsh localbjsh = (bjsh)DoodleLayout.a(this.a).a(bjsh.class);
      if (localbjsh != null) {
        localbjsh.b();
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.a.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  public boolean a(bkat parambkat)
  {
    if (this.a.a != null)
    {
      this.a.a.setVisibility(0);
      DoodleLayout.b(this.a);
      this.a.a.a.a(parambkat);
      parambkat.k = true;
      parambkat = parambkat.a;
      if (!this.a.a.a()) {}
      for (boolean bool = true;; bool = false)
      {
        parambkat.lockData(bool);
        this.a.a.requestLayout();
        vel.a("video_shoot_new", "qa_edit", 2, 0, new String[0]);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkde
 * JD-Core Version:    0.7.0.1
 */