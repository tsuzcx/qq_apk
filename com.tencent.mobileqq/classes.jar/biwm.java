import android.view.View;
import android.view.View.OnClickListener;

class biwm
  implements View.OnClickListener
{
  biwm(biwl parambiwl, int paramInt) {}
  
  public void onClick(View paramView)
  {
    biwh.a(this.jdField_a_of_type_Biwl.a, this.jdField_a_of_type_Int);
    paramView = biwo.a(biwh.a(this.jdField_a_of_type_Biwl.a));
    if ((paramView != null) && (paramView.length > this.jdField_a_of_type_Int))
    {
      paramView = paramView[this.jdField_a_of_type_Int];
      if (paramView != biwo.c) {
        break label89;
      }
      bizt.a().p();
    }
    for (;;)
    {
      bjah.b("AEVideoStoryCaptureModePart", "【AE_CAPTURE_MODE】:" + this.jdField_a_of_type_Int);
      return;
      label89:
      if (paramView == biwo.a)
      {
        bizt.a().o();
      }
      else if (paramView == biwo.b)
      {
        bizx.a().f("3");
        bizt.a().w();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwm
 * JD-Core Version:    0.7.0.1
 */