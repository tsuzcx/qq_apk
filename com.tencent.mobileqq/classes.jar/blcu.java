import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class blcu
  implements View.OnClickListener
{
  blcu(blct paramblct, int paramInt) {}
  
  public void onClick(View paramView)
  {
    blct.a(this.jdField_a_of_type_Blct, this.jdField_a_of_type_Int);
    blcv localblcv;
    if (this.jdField_a_of_type_Int != blct.a(this.jdField_a_of_type_Blct))
    {
      int i = blct.a(this.jdField_a_of_type_Blct);
      blct.a(this.jdField_a_of_type_Blct, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Blct.notifyItemChanged(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Blct.notifyItemChanged(i);
      if (blct.a(this.jdField_a_of_type_Blct) != null)
      {
        localblcv = blct.a(this.jdField_a_of_type_Blct);
        if (this.jdField_a_of_type_Int != 0) {
          break label127;
        }
      }
    }
    label127:
    for (paramView = null;; paramView = (blag)blct.a(this.jdField_a_of_type_Blct).get(this.jdField_a_of_type_Int - 1))
    {
      localblcv.a(paramView);
      if (this.jdField_a_of_type_Int != 0) {
        break;
      }
      bliy.a().k("none");
      bliu.a().O();
      bljn.b("AEGIFStickerAdapter", "【Gif Material Click】: null");
      return;
    }
    bliy.a().k(((blag)blct.a(this.jdField_a_of_type_Blct).get(this.jdField_a_of_type_Int - 1)).a);
    bliu.a().O();
    bljn.b("AEGIFStickerAdapter", "【Gif Material Click】: " + ((blag)blct.a(this.jdField_a_of_type_Blct).get(this.jdField_a_of_type_Int - 1)).a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blcu
 * JD-Core Version:    0.7.0.1
 */