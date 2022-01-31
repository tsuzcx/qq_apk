import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class bitu
  implements View.OnClickListener
{
  bitu(bitt parambitt, int paramInt) {}
  
  public void onClick(View paramView)
  {
    bitt.a(this.jdField_a_of_type_Bitt, this.jdField_a_of_type_Int);
    bitv localbitv;
    if (this.jdField_a_of_type_Int != bitt.a(this.jdField_a_of_type_Bitt))
    {
      int i = bitt.a(this.jdField_a_of_type_Bitt);
      bitt.a(this.jdField_a_of_type_Bitt, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bitt.notifyItemChanged(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bitt.notifyItemChanged(i);
      if (bitt.a(this.jdField_a_of_type_Bitt) != null)
      {
        localbitv = bitt.a(this.jdField_a_of_type_Bitt);
        if (this.jdField_a_of_type_Int != 0) {
          break label127;
        }
      }
    }
    label127:
    for (paramView = null;; paramView = (birj)bitt.a(this.jdField_a_of_type_Bitt).get(this.jdField_a_of_type_Int - 1))
    {
      localbitv.a(paramView);
      if (this.jdField_a_of_type_Int != 0) {
        break;
      }
      bizx.a().k("none");
      bizt.a().G();
      bjah.b("AEGIFStickerAdapter", "【Gif Material Click】: null");
      return;
    }
    bizx.a().k(((birj)bitt.a(this.jdField_a_of_type_Bitt).get(this.jdField_a_of_type_Int - 1)).a);
    bizt.a().G();
    bjah.b("AEGIFStickerAdapter", "【Gif Material Click】: " + ((birj)bitt.a(this.jdField_a_of_type_Bitt).get(this.jdField_a_of_type_Int - 1)).a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bitu
 * JD-Core Version:    0.7.0.1
 */