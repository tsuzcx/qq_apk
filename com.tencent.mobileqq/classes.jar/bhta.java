import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class bhta
  implements View.OnClickListener
{
  bhta(bhsz parambhsz, int paramInt) {}
  
  public void onClick(View paramView)
  {
    bhsz.a(this.jdField_a_of_type_Bhsz, this.jdField_a_of_type_Int);
    bhtb localbhtb;
    if (this.jdField_a_of_type_Int != bhsz.a(this.jdField_a_of_type_Bhsz))
    {
      int i = bhsz.a(this.jdField_a_of_type_Bhsz);
      bhsz.a(this.jdField_a_of_type_Bhsz, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bhsz.notifyItemChanged(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bhsz.notifyItemChanged(i);
      if (bhsz.a(this.jdField_a_of_type_Bhsz) != null)
      {
        localbhtb = bhsz.a(this.jdField_a_of_type_Bhsz);
        if (this.jdField_a_of_type_Int != 0) {
          break label128;
        }
      }
    }
    label128:
    for (paramView = null;; paramView = (wqk)bhsz.a(this.jdField_a_of_type_Bhsz).get(this.jdField_a_of_type_Int - 1))
    {
      localbhtb.a(paramView);
      if (this.jdField_a_of_type_Int != 0) {
        break;
      }
      bhcm.a().j("none");
      bhci.a().E();
      bhcs.a("AEGIFStickerAdapter", 1, "【Gif Material Click】: null");
      return;
    }
    bhcm.a().j(((wqk)bhsz.a(this.jdField_a_of_type_Bhsz).get(this.jdField_a_of_type_Int - 1)).a);
    bhci.a().E();
    bhcs.a("AEGIFStickerAdapter", 1, "【Gif Material Click】: " + ((wqk)bhsz.a(this.jdField_a_of_type_Bhsz).get(this.jdField_a_of_type_Int - 1)).a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhta
 * JD-Core Version:    0.7.0.1
 */