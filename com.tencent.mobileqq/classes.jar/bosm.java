import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.util.HashMap;
import java.util.Map;

public class bosm
  extends ViewModel
{
  private MutableLiveData<boqz> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private Map<String, boqp> jdField_a_of_type_JavaUtilMap = new HashMap();
  private MutableLiveData<boqw> b = new MutableLiveData();
  private MutableLiveData<String> c = new MutableLiveData();
  private MutableLiveData<String> d = new MutableLiveData();
  
  public MutableLiveData<boqz> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public void a()
  {
    boqw localboqw = (boqw)this.b.getValue();
    bpam.b("AEVideoStoryGIFTplViewModel", "[applyGIFTplAgain], lastMaterial=" + localboqw);
    this.b.postValue(localboqw);
  }
  
  public void a(boqw paramboqw)
  {
    bosn localbosn = new bosn(this);
    this.jdField_a_of_type_JavaUtilMap.put(paramboqw.jdField_a_of_type_JavaLangString, localbosn);
    boqm.a().a(bplg.a(), paramboqw.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, localbosn);
  }
  
  public MutableLiveData<boqw> b()
  {
    return this.b;
  }
  
  public void b(@Nullable boqw paramboqw)
  {
    bpam.b("AEVideoStoryGIFTplViewModel", "[applyGIFTpl], material=" + paramboqw);
    this.b.postValue(paramboqw);
  }
  
  public MutableLiveData<String> c()
  {
    return this.c;
  }
  
  public void c(@Nullable boqw paramboqw)
  {
    if (paramboqw != null)
    {
      paramboqw = (String)paramboqw.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename");
      this.c.postValue(paramboqw);
      return;
    }
    this.c.postValue(null);
  }
  
  public MutableLiveData<String> d()
  {
    return this.d;
  }
  
  public void onCleared()
  {
    super.onCleared();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bosm
 * JD-Core Version:    0.7.0.1
 */