import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoVote;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.VoteLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.VoteLayer.VoteItem;

public class anfe
  implements DialogInterface.OnClickListener
{
  static
  {
    if (!EditVideoVote.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public anfe(EditVideoVote paramEditVideoVote, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Bundle();
    VoteLayer.VoteItem localVoteItem = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote.a().a;
    if ((!jdField_a_of_type_Boolean) && (localVoteItem == null)) {
      throw new AssertionError();
    }
    EditVideoVote.a(paramDialogInterface, localVoteItem);
    paramDialogInterface.putInt("element_index", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote.a.a(35, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anfe
 * JD-Core Version:    0.7.0.1
 */