import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class blxv
  implements View.OnClickListener
{
  blxv(blxu paramblxu, int paramInt, blvd paramblvd) {}
  
  public void onClick(View paramView)
  {
    blxw localblxw1 = null;
    Object localObject = null;
    bmbx.a("AEGIFStickerAdapter", "[ItemView.onClick] position=" + this.jdField_a_of_type_Int + ", mClickedPos=" + blxu.a(this.jdField_a_of_type_Blxu) + ", mActivatedPos=" + blxu.b(this.jdField_a_of_type_Blxu));
    blxu.a(this.jdField_a_of_type_Blxu, this.jdField_a_of_type_Int);
    if ((this.jdField_a_of_type_Blvd.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Blvd.b == 1))
    {
      bmbx.a("AEGIFStickerAdapter", "[ItemView.onClick] data.state == STATE_DOWNLOADED");
      blxu.a(this.jdField_a_of_type_Blxu, this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Int != blxu.b(this.jdField_a_of_type_Blxu))
      {
        bmbx.a("AEGIFStickerAdapter", "[ItemView.onClick] position != mActivatedPos");
        int i = blxu.b(this.jdField_a_of_type_Blxu);
        blxu.b(this.jdField_a_of_type_Blxu, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Blxu.notifyItemChanged(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Blxu.notifyItemChanged(i);
        if (blxu.a(this.jdField_a_of_type_Blxu) != null)
        {
          localblxw1 = blxu.a(this.jdField_a_of_type_Blxu);
          if (this.jdField_a_of_type_Blvd.b == 1) {
            localblxw1.a((blvd)localObject);
          }
        }
        else
        {
          bmbg.a().k(this.jdField_a_of_type_Blvd.jdField_a_of_type_JavaLangString);
          bmbc.a().ai();
          bmbx.b("AEGIFStickerAdapter", "[ItemView.onClick] gifMaterialClick, id=" + this.jdField_a_of_type_Blvd.jdField_a_of_type_JavaLangString);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = this.jdField_a_of_type_Blvd;
      break;
      bmbx.a("AEGIFStickerAdapter", "[ItemView.onClick] position == mActivatedPos");
      continue;
      if (this.jdField_a_of_type_Blvd.jdField_a_of_type_Int == 0)
      {
        bmbx.a("AEGIFStickerAdapter", "[ItemView.onClick] data.state == STATE_NOT_DOWNLOAD");
        if (blxu.a(this.jdField_a_of_type_Blxu) != null)
        {
          blxw localblxw2 = blxu.a(this.jdField_a_of_type_Blxu);
          if (this.jdField_a_of_type_Blvd.b == 1) {}
          for (localObject = localblxw1;; localObject = this.jdField_a_of_type_Blvd)
          {
            localblxw2.a((blvd)localObject);
            break;
          }
        }
      }
      else
      {
        bmbx.a("AEGIFStickerAdapter", "[ItemView.onClick] data.state == STATE_DOWNLOADING");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blxv
 * JD-Core Version:    0.7.0.1
 */