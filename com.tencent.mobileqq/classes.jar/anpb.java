import android.view.View;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.VoteLayer.VoteItem;
import dov.com.tencent.biz.qqstory.takevideo.vote.VoteDashItem;

public class anpb
  implements Runnable
{
  public anpb(VoteDashItem paramVoteDashItem, VoteLayer.VoteItem paramVoteItem, boolean paramBoolean, View paramView, Runnable paramRunnable) {}
  
  public void run()
  {
    VoteLayer.VoteItem localVoteItem;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.jdField_a_of_type_Boolean != this.jdField_a_of_type_Boolean)
    {
      localVoteItem = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.jdField_a_of_type_Boolean) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      localVoteItem.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidViewView.invalidate();
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_JavaLangRunnable.run();
      }
      VoteDashItem.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoVoteVoteDashItem, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anpb
 * JD-Core Version:    0.7.0.1
 */