import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle;
import dov.com.tencent.biz.qqstory.takevideo.EditVoteExport;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.VoteLayer.LayerEventListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.VoteLayer.VoteItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public class anyr
  implements VoteLayer.LayerEventListener
{
  public anyr(DoodleLayout paramDoodleLayout) {}
  
  public void a()
  {
    SLog.b("DoodleLayout", "deleteVote.");
    if (DoodleLayout.a(this.a) != null)
    {
      EditVoteExport localEditVoteExport = (EditVoteExport)DoodleLayout.a(this.a).a(EditVoteExport.class);
      if (localEditVoteExport != null) {
        localEditVoteExport.c();
      }
    }
  }
  
  public boolean a(VoteLayer.VoteItem paramVoteItem)
  {
    boolean bool = false;
    if (this.a.a != null)
    {
      this.a.a.setVisibility(0);
      if (this.a.a.a.b()) {
        this.a.a.a.a().j = false;
      }
      this.a.a.a.a(paramVoteItem);
      paramVoteItem.j = true;
      paramVoteItem = paramVoteItem.a;
      if (!this.a.a.a()) {
        bool = true;
      }
      paramVoteItem.a(bool);
      this.a.a.requestLayout();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anyr
 * JD-Core Version:    0.7.0.1
 */