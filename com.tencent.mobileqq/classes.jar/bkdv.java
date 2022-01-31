import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public class bkdv
  implements bkbj
{
  public bkdv(DoodleLayout paramDoodleLayout) {}
  
  public void a()
  {
    ved.b("DoodleLayout", "deleteInteractPaster.");
    if (DoodleLayout.a(this.a) != null)
    {
      bjsy localbjsy = (bjsy)DoodleLayout.a(this.a).a(bjsy.class);
      if (localbjsy != null) {
        localbjsy.b();
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.a.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  public boolean a(bkbk parambkbk)
  {
    if (this.a.a != null)
    {
      this.a.a.setVisibility(0);
      DoodleLayout.b(this.a);
      this.a.a.a.a(parambkbk);
      parambkbk.k = true;
      parambkbk = parambkbk.a;
      if (!this.a.a.a()) {}
      for (boolean bool = true;; bool = false)
      {
        parambkbk.lockData(bool);
        this.a.a.requestLayout();
        vei.a("video_shoot_new", "qa_edit", 2, 0, new String[0]);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkdv
 * JD-Core Version:    0.7.0.1
 */