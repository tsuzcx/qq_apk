import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.common.app.AppInterface;
import java.util.HashMap;
import java.util.Map;

public class bnoq
  extends ViewModel
{
  private MutableLiveData<bnkn> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private Map<String, bnjz> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public MutableLiveData<bnkn> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public void a(AppInterface paramAppInterface, bnml parambnml)
  {
    bnor localbnor = new bnor(this);
    this.jdField_a_of_type_JavaUtilMap.put(parambnml.a.id, localbnor);
    bnjw.a().a(paramAppInterface, parambnml.a, localbnor);
  }
  
  public void onCleared()
  {
    super.onCleared();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnoq
 * JD-Core Version:    0.7.0.1
 */