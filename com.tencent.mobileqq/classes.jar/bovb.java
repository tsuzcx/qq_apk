import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.common.app.AppInterface;
import java.util.HashMap;
import java.util.Map;

public class bovb
  extends ViewModel
{
  private MutableLiveData<boqz> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private Map<String, boqp> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public MutableLiveData<boqz> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public void a(AppInterface paramAppInterface, bosw parambosw)
  {
    bovc localbovc = new bovc(this);
    this.jdField_a_of_type_JavaUtilMap.put(parambosw.a.id, localbovc);
    boqm.a().a(paramAppInterface, parambosw.a, localbovc);
  }
  
  public void onCleared()
  {
    super.onCleared();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bovb
 * JD-Core Version:    0.7.0.1
 */