import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class bitd
  implements View.OnClickListener
{
  bitd(bitc parambitc, int paramInt) {}
  
  public void onClick(View paramView)
  {
    bitc.a(this.jdField_a_of_type_Bitc, this.jdField_a_of_type_Int);
    bite localbite;
    if (this.jdField_a_of_type_Int != bitc.a(this.jdField_a_of_type_Bitc))
    {
      int i = bitc.a(this.jdField_a_of_type_Bitc);
      bitc.a(this.jdField_a_of_type_Bitc, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bitc.notifyItemChanged(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bitc.notifyItemChanged(i);
      if (bitc.a(this.jdField_a_of_type_Bitc) != null)
      {
        localbite = bitc.a(this.jdField_a_of_type_Bitc);
        if (this.jdField_a_of_type_Int != 0) {
          break label127;
        }
      }
    }
    label127:
    for (paramView = null;; paramView = (biqs)bitc.a(this.jdField_a_of_type_Bitc).get(this.jdField_a_of_type_Int - 1))
    {
      localbite.a(paramView);
      if (this.jdField_a_of_type_Int != 0) {
        break;
      }
      bizg.a().k("none");
      bizc.a().G();
      bizq.b("AEGIFStickerAdapter", "【Gif Material Click】: null");
      return;
    }
    bizg.a().k(((biqs)bitc.a(this.jdField_a_of_type_Bitc).get(this.jdField_a_of_type_Int - 1)).a);
    bizc.a().G();
    bizq.b("AEGIFStickerAdapter", "【Gif Material Click】: " + ((biqs)bitc.a(this.jdField_a_of_type_Bitc).get(this.jdField_a_of_type_Int - 1)).a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bitd
 * JD-Core Version:    0.7.0.1
 */