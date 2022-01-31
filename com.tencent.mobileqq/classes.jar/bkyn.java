import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class bkyn
  implements View.OnClickListener
{
  bkyn(bkym parambkym, int paramInt) {}
  
  public void onClick(View paramView)
  {
    bkym.a(this.jdField_a_of_type_Bkym, this.jdField_a_of_type_Int);
    bkyo localbkyo;
    if (this.jdField_a_of_type_Int != bkym.a(this.jdField_a_of_type_Bkym))
    {
      int i = bkym.a(this.jdField_a_of_type_Bkym);
      bkym.a(this.jdField_a_of_type_Bkym, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bkym.notifyItemChanged(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bkym.notifyItemChanged(i);
      if (bkym.a(this.jdField_a_of_type_Bkym) != null)
      {
        localbkyo = bkym.a(this.jdField_a_of_type_Bkym);
        if (this.jdField_a_of_type_Int != 0) {
          break label127;
        }
      }
    }
    label127:
    for (paramView = null;; paramView = (bkvz)bkym.a(this.jdField_a_of_type_Bkym).get(this.jdField_a_of_type_Int - 1))
    {
      localbkyo.a(paramView);
      if (this.jdField_a_of_type_Int != 0) {
        break;
      }
      bler.a().k("none");
      blen.a().O();
      blfg.b("AEGIFStickerAdapter", "【Gif Material Click】: null");
      return;
    }
    bler.a().k(((bkvz)bkym.a(this.jdField_a_of_type_Bkym).get(this.jdField_a_of_type_Int - 1)).a);
    blen.a().O();
    blfg.b("AEGIFStickerAdapter", "【Gif Material Click】: " + ((bkvz)bkym.a(this.jdField_a_of_type_Bkym).get(this.jdField_a_of_type_Int - 1)).a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyn
 * JD-Core Version:    0.7.0.1
 */