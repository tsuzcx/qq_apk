import android.os.Message;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.apollo.ApolloTextureView;

class amxq
  implements amkj
{
  amxq(amxo paramamxo, DisplayMetrics paramDisplayMetrics, amxs paramamxs) {}
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Amxo.jdField_c_of_type_Boolean = true;
    float f = this.jdField_a_of_type_AndroidUtilDisplayMetrics.density;
    this.jdField_a_of_type_Amxo.jdField_c_of_type_Float = (paramInt1 / 2 / f);
    if ((this.jdField_a_of_type_Amxo.b != null) && (this.jdField_a_of_type_Amxo.a != null) && (amxo.a(this.jdField_a_of_type_Amxo) != null))
    {
      this.jdField_a_of_type_Amxo.b.onExecDispose();
      this.jdField_a_of_type_Amxo.a.onExecDispose();
      Message localMessage = amxo.a(this.jdField_a_of_type_Amxo).obtainMessage(19, this.jdField_a_of_type_Amxs.c, this.jdField_a_of_type_Amxs.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_Amxs.a) {
        localMessage.obj = Float.valueOf(this.jdField_a_of_type_Amxs.jdField_b_of_type_Float);
      }
      amxo.a(this.jdField_a_of_type_Amxo).sendMessageDelayed(localMessage, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxq
 * JD-Core Version:    0.7.0.1
 */