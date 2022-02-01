import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class botq
  implements View.OnClickListener
{
  botq(botp parambotp, int paramInt, boqw paramboqw) {}
  
  public void onClick(View paramView)
  {
    botp.a(this.jdField_a_of_type_Botp, this.jdField_a_of_type_Int);
    botr localbotr;
    if (this.jdField_a_of_type_Int != botp.a(this.jdField_a_of_type_Botp))
    {
      int i = botp.a(this.jdField_a_of_type_Botp);
      botp.a(this.jdField_a_of_type_Botp, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Botp.notifyItemChanged(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Botp.notifyItemChanged(i);
      if (botp.a(this.jdField_a_of_type_Botp) != null)
      {
        localbotr = botp.a(this.jdField_a_of_type_Botp);
        if (this.jdField_a_of_type_Boqw.b != 1) {
          break label161;
        }
      }
    }
    label161:
    for (boqw localboqw = null;; localboqw = this.jdField_a_of_type_Boqw)
    {
      localbotr.a(localboqw);
      bozv.a().k(this.jdField_a_of_type_Boqw.a);
      bozr.a().ae();
      bpam.b("AEGIFStickerAdapter", "【Gif Material Click】: " + this.jdField_a_of_type_Boqw.a);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     botq
 * JD-Core Version:    0.7.0.1
 */