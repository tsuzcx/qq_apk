import android.os.Message;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.apollo.ApolloTextureView;

class anjk
  implements amwd
{
  anjk(anji paramanji, DisplayMetrics paramDisplayMetrics, anjm paramanjm) {}
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Anji.jdField_c_of_type_Boolean = true;
    float f = this.jdField_a_of_type_AndroidUtilDisplayMetrics.density;
    this.jdField_a_of_type_Anji.jdField_c_of_type_Float = (paramInt1 / 2 / f);
    if ((this.jdField_a_of_type_Anji.b != null) && (this.jdField_a_of_type_Anji.a != null) && (anji.a(this.jdField_a_of_type_Anji) != null))
    {
      this.jdField_a_of_type_Anji.b.onExecDispose();
      this.jdField_a_of_type_Anji.a.onExecDispose();
      Message localMessage = anji.a(this.jdField_a_of_type_Anji).obtainMessage(19, this.jdField_a_of_type_Anjm.c, this.jdField_a_of_type_Anjm.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_Anjm.a) {
        localMessage.obj = Float.valueOf(this.jdField_a_of_type_Anjm.jdField_b_of_type_Float);
      }
      anji.a(this.jdField_a_of_type_Anji).sendMessageDelayed(localMessage, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anjk
 * JD-Core Version:    0.7.0.1
 */