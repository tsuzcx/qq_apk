import android.os.Message;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.apollo.ApolloTextureView;

class amee
  implements alqx
{
  amee(amec paramamec, DisplayMetrics paramDisplayMetrics, ameg paramameg) {}
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Amec.jdField_c_of_type_Boolean = true;
    float f = this.jdField_a_of_type_AndroidUtilDisplayMetrics.density;
    this.jdField_a_of_type_Amec.jdField_c_of_type_Float = (paramInt1 / 2 / f);
    if ((this.jdField_a_of_type_Amec.b != null) && (this.jdField_a_of_type_Amec.a != null) && (amec.a(this.jdField_a_of_type_Amec) != null))
    {
      this.jdField_a_of_type_Amec.b.onExecDispose();
      this.jdField_a_of_type_Amec.a.onExecDispose();
      Message localMessage = amec.a(this.jdField_a_of_type_Amec).obtainMessage(19, this.jdField_a_of_type_Ameg.c, this.jdField_a_of_type_Ameg.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_Ameg.a) {
        localMessage.obj = Float.valueOf(this.jdField_a_of_type_Ameg.jdField_b_of_type_Float);
      }
      amec.a(this.jdField_a_of_type_Amec).sendMessageDelayed(localMessage, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amee
 * JD-Core Version:    0.7.0.1
 */