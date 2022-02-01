import android.os.Message;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.apollo.ApolloTextureView;

class anfm
  implements ampy
{
  anfm(anfk paramanfk, DisplayMetrics paramDisplayMetrics, anfo paramanfo) {}
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Anfk.jdField_c_of_type_Boolean = true;
    float f = this.jdField_a_of_type_AndroidUtilDisplayMetrics.density;
    this.jdField_a_of_type_Anfk.jdField_c_of_type_Float = (paramInt1 / 2 / f);
    if ((this.jdField_a_of_type_Anfk.b != null) && (this.jdField_a_of_type_Anfk.a != null) && (anfk.a(this.jdField_a_of_type_Anfk) != null))
    {
      this.jdField_a_of_type_Anfk.b.onExecDispose();
      this.jdField_a_of_type_Anfk.a.onExecDispose();
      Message localMessage = anfk.a(this.jdField_a_of_type_Anfk).obtainMessage(19, this.jdField_a_of_type_Anfo.c, this.jdField_a_of_type_Anfo.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_Anfo.a) {
        localMessage.obj = Float.valueOf(this.jdField_a_of_type_Anfo.jdField_b_of_type_Float);
      }
      anfk.a(this.jdField_a_of_type_Anfk).sendMessageDelayed(localMessage, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfm
 * JD-Core Version:    0.7.0.1
 */