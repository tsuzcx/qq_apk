import android.view.View;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.VoteLayer.VoteItem;
import dov.com.tencent.biz.qqstory.takevideo.vote.VoteDashItem;

public class aoff
  implements Runnable
{
  public aoff(VoteDashItem paramVoteDashItem, VoteLayer.VoteItem paramVoteItem, View paramView) {}
  
  public void run()
  {
    VoteLayer.VoteItem localVoteItem = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem;
    if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.a) {}
    for (boolean bool = true;; bool = false)
    {
      localVoteItem.a = bool;
      this.jdField_a_of_type_AndroidViewView.invalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoff
 * JD-Core Version:    0.7.0.1
 */