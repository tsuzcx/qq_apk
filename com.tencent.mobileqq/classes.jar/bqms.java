import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public class bqms
  implements bqkg
{
  public bqms(DoodleLayout paramDoodleLayout) {}
  
  public void a()
  {
    yuk.b("DoodleLayout", "deleteInteractPaster.");
    if (DoodleLayout.a(this.a) != null)
    {
      bqbv localbqbv = (bqbv)DoodleLayout.a(this.a).a(bqbv.class);
      if (localbqbv != null) {
        localbqbv.b();
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.a.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  public boolean a(bqkh parambqkh)
  {
    if (this.a.a != null)
    {
      this.a.a.setVisibility(0);
      DoodleLayout.b(this.a);
      this.a.a.a.a(parambqkh);
      parambqkh.k = true;
      parambqkh = parambqkh.a;
      if (!this.a.a.a()) {}
      for (boolean bool = true;; bool = false)
      {
        parambqkh.lockData(bool);
        this.a.a.requestLayout();
        yup.a("video_shoot_new", "qa_edit", 2, 0, new String[0]);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqms
 * JD-Core Version:    0.7.0.1
 */