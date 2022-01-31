import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public class bmpf
  implements bmmt
{
  public bmpf(DoodleLayout paramDoodleLayout) {}
  
  public void a()
  {
    wsv.b("DoodleLayout", "deleteInteractPaster.");
    if (DoodleLayout.a(this.a) != null)
    {
      bmei localbmei = (bmei)DoodleLayout.a(this.a).a(bmei.class);
      if (localbmei != null) {
        localbmei.b();
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.a.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  public boolean a(bmmu parambmmu)
  {
    if (this.a.a != null)
    {
      this.a.a.setVisibility(0);
      DoodleLayout.b(this.a);
      this.a.a.a.a(parambmmu);
      parambmmu.k = true;
      parambmmu = parambmmu.a;
      if (!this.a.a.a()) {}
      for (boolean bool = true;; bool = false)
      {
        parambmmu.lockData(bool);
        this.a.a.requestLayout();
        wta.a("video_shoot_new", "qa_edit", 2, 0, new String[0]);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmpf
 * JD-Core Version:    0.7.0.1
 */