import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoVote;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.InteractPasterLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.VoteLayer.VoteItem;
import dov.com.tencent.biz.qqstory.takevideo.interact.EditVideoInteract;

public class aobw
  implements DialogInterface.OnClickListener
{
  static
  {
    if (!EditVideoInteract.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public aobw(EditVideoInteract paramEditVideoInteract) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Bundle();
    VoteLayer.VoteItem localVoteItem = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractEditVideoInteract.a().a;
    if ((!jdField_a_of_type_Boolean) && (localVoteItem == null)) {
      throw new AssertionError();
    }
    EditVideoVote.a(paramDialogInterface, localVoteItem);
    paramDialogInterface.putInt("interact_type", EditVideoInteract.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractEditVideoInteract));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractEditVideoInteract.a.a(38, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aobw
 * JD-Core Version:    0.7.0.1
 */