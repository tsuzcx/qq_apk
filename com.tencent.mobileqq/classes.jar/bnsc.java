import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class bnsc
  implements View.OnClickListener
{
  bnsc(bnsb parambnsb, int paramInt) {}
  
  public void onClick(View paramView)
  {
    bnsb.a(this.jdField_a_of_type_Bnsb, this.jdField_a_of_type_Int);
    bnpk localbnpk;
    if (this.jdField_a_of_type_Int != bnsb.a(this.jdField_a_of_type_Bnsb))
    {
      int i = bnsb.a(this.jdField_a_of_type_Bnsb);
      bnsb.a(this.jdField_a_of_type_Bnsb, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bnsb.notifyItemChanged(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bnsb.notifyItemChanged(i);
      if (bnsb.a(this.jdField_a_of_type_Bnsb) != null)
      {
        bnsd localbnsd = bnsb.a(this.jdField_a_of_type_Bnsb);
        if (this.jdField_a_of_type_Int != 0) {
          break label136;
        }
        localbnpk = null;
        localbnsd.a(localbnpk);
        if (this.jdField_a_of_type_Int != 0) {
          break label161;
        }
        bnyl.a().k("none");
        bnyh.a().ab();
        bnzb.b("AEGIFStickerAdapter", "【Gif Material Click】: null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label136:
      localbnpk = (bnpk)bnsb.a(this.jdField_a_of_type_Bnsb).get(this.jdField_a_of_type_Int - 1);
      break;
      label161:
      bnyl.a().k(((bnpk)bnsb.a(this.jdField_a_of_type_Bnsb).get(this.jdField_a_of_type_Int - 1)).a);
      bnyh.a().ab();
      bnzb.b("AEGIFStickerAdapter", "【Gif Material Click】: " + ((bnpk)bnsb.a(this.jdField_a_of_type_Bnsb).get(this.jdField_a_of_type_Int - 1)).a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnsc
 * JD-Core Version:    0.7.0.1
 */