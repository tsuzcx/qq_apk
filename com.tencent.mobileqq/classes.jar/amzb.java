import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.share.QZoneShareActivity;

class amzb
  implements Runnable
{
  amzb(amza paramamza, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Amza.a.a == null) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Int <= 0) {
          break;
        }
        String str = "超出" + this.jdField_a_of_type_Int + "个字";
        int i = this.jdField_a_of_type_Amza.a.getResources().getColor(2131493818);
        this.jdField_a_of_type_Amza.a.a.setTextColor(i);
        this.jdField_a_of_type_Amza.a.a.setText(str);
        if (this.jdField_a_of_type_Amza.a.a.getVisibility() != 0) {
          this.jdField_a_of_type_Amza.a.a.setVisibility(0);
        }
      } while (!this.jdField_a_of_type_Amza.a.b);
      QQToast.a(this.jdField_a_of_type_Amza.a, 2131432446, 0).a();
      this.jdField_a_of_type_Amza.a.b = false;
      return;
    } while (this.jdField_a_of_type_Amza.a.a.getVisibility() == 8);
    this.jdField_a_of_type_Amza.a.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amzb
 * JD-Core Version:    0.7.0.1
 */