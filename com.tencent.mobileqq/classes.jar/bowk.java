import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import dov.com.qq.im.ae.mode.AECaptureMode;

public class bowk
  extends ViewModel
{
  public final MutableLiveData<bowc> a;
  private boolean a;
  public final MutableLiveData<AECaptureMode[]> b = new MutableLiveData();
  public final MutableLiveData<Boolean> c = new MutableLiveData();
  
  public bowk()
  {
    this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.getValue() != null) && (((bowc)this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.getValue()).b == AECaptureMode.GIF);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.getValue() != null) && (((bowc)this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.getValue()).b == AECaptureMode.NORMAL);
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.getValue() != null) && (((bowc)this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.getValue()).b == AECaptureMode.PLAY);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bowk
 * JD-Core Version:    0.7.0.1
 */