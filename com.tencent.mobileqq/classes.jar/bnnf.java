import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bnnf
  implements View.OnClickListener
{
  bnnf(bnne parambnne, int paramInt, bnkg parambnkg) {}
  
  public void onClick(View paramView)
  {
    bnng localbnng1 = null;
    Object localObject = null;
    bnrh.a("AEGIFStickerAdapter", "[ItemView.onClick] position=" + this.jdField_a_of_type_Int + ", mClickedPos=" + bnne.a(this.jdField_a_of_type_Bnne) + ", mActivatedPos=" + bnne.b(this.jdField_a_of_type_Bnne));
    bnne.a(this.jdField_a_of_type_Bnne, this.jdField_a_of_type_Int);
    if ((this.jdField_a_of_type_Bnkg.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Bnkg.b == 1))
    {
      bnrh.a("AEGIFStickerAdapter", "[ItemView.onClick] data.state == STATE_DOWNLOADED");
      bnne.a(this.jdField_a_of_type_Bnne, this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Int != bnne.b(this.jdField_a_of_type_Bnne))
      {
        bnrh.a("AEGIFStickerAdapter", "[ItemView.onClick] position != mActivatedPos");
        int i = bnne.b(this.jdField_a_of_type_Bnne);
        bnne.b(this.jdField_a_of_type_Bnne, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Bnne.notifyItemChanged(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Bnne.notifyItemChanged(i);
        if (bnne.a(this.jdField_a_of_type_Bnne) != null)
        {
          localbnng1 = bnne.a(this.jdField_a_of_type_Bnne);
          if (this.jdField_a_of_type_Bnkg.b == 1) {
            localbnng1.a((bnkg)localObject);
          }
        }
        else
        {
          bnqq.a().k(this.jdField_a_of_type_Bnkg.jdField_a_of_type_JavaLangString);
          bnqm.a().ai();
          bnrh.b("AEGIFStickerAdapter", "[ItemView.onClick] gifMaterialClick, id=" + this.jdField_a_of_type_Bnkg.jdField_a_of_type_JavaLangString);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = this.jdField_a_of_type_Bnkg;
      break;
      bnrh.a("AEGIFStickerAdapter", "[ItemView.onClick] position == mActivatedPos");
      continue;
      if (this.jdField_a_of_type_Bnkg.jdField_a_of_type_Int == 0)
      {
        bnrh.a("AEGIFStickerAdapter", "[ItemView.onClick] data.state == STATE_NOT_DOWNLOAD");
        if (bnne.a(this.jdField_a_of_type_Bnne) != null)
        {
          bnng localbnng2 = bnne.a(this.jdField_a_of_type_Bnne);
          if (this.jdField_a_of_type_Bnkg.b == 1) {}
          for (localObject = localbnng1;; localObject = this.jdField_a_of_type_Bnkg)
          {
            localbnng2.a((bnkg)localObject);
            break;
          }
        }
      }
      else
      {
        bnrh.a("AEGIFStickerAdapter", "[ItemView.onClick] data.state == STATE_DOWNLOADING");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnnf
 * JD-Core Version:    0.7.0.1
 */