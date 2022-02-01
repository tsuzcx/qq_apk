import android.text.TextUtils;
import android.view.View;

class bbrs
  implements bkzq
{
  bbrs(bbrl parambbrl, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
    }
    paramView = this.jdField_a_of_type_Bkzi.a(paramInt);
    if (paramView == null)
    {
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
    }
    if (TextUtils.isEmpty(paramView))
    {
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
    }
    this.jdField_a_of_type_Bkzi.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrs
 * JD-Core Version:    0.7.0.1
 */