import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.common.app.AppInterface;
import java.util.HashMap;
import java.util.Map;

public class blzg
  extends ViewModel
{
  private MutableLiveData<blvg> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private Map<String, bluw> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public MutableLiveData<blvg> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public void a(AppInterface paramAppInterface, blxb paramblxb)
  {
    blzh localblzh = new blzh(this);
    this.jdField_a_of_type_JavaUtilMap.put(paramblxb.a.id, localblzh);
    blut.a().a(paramAppInterface, paramblxb.a, localblzh);
  }
  
  public void onCleared()
  {
    super.onCleared();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blzg
 * JD-Core Version:    0.7.0.1
 */