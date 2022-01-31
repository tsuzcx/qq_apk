import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.share.QZoneShareActivity;

class amiw
  implements Runnable
{
  amiw(amiv paramamiv, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Amiv.a.a == null) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Int <= 0) {
          break;
        }
        String str = "超出" + this.jdField_a_of_type_Int + "个字";
        int i = this.jdField_a_of_type_Amiv.a.getResources().getColor(2131493812);
        this.jdField_a_of_type_Amiv.a.a.setTextColor(i);
        this.jdField_a_of_type_Amiv.a.a.setText(str);
        if (this.jdField_a_of_type_Amiv.a.a.getVisibility() != 0) {
          this.jdField_a_of_type_Amiv.a.a.setVisibility(0);
        }
      } while (!this.jdField_a_of_type_Amiv.a.b);
      QQToast.a(this.jdField_a_of_type_Amiv.a, 2131432429, 0).a();
      this.jdField_a_of_type_Amiv.a.b = false;
      return;
    } while (this.jdField_a_of_type_Amiv.a.a.getVisibility() == 8);
    this.jdField_a_of_type_Amiv.a.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amiw
 * JD-Core Version:    0.7.0.1
 */