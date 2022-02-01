import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.util.HashMap;
import java.util.Map;

public class blwr
  extends ViewModel
{
  private MutableLiveData<blvg> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private Map<String, bluw> jdField_a_of_type_JavaUtilMap = new HashMap();
  private MutableLiveData<blvd> b = new MutableLiveData();
  private MutableLiveData<String> c = new MutableLiveData();
  private MutableLiveData<String> d = new MutableLiveData();
  
  public MutableLiveData<blvg> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public void a()
  {
    blvd localblvd = (blvd)this.b.getValue();
    bmbx.b("AEVideoStoryGIFTplViewModel", "[applyGIFTplAgain], lastMaterial=" + localblvd);
    this.b.postValue(localblvd);
  }
  
  public void a(blvd paramblvd)
  {
    blws localblws = new blws(this);
    this.jdField_a_of_type_JavaUtilMap.put(paramblvd.jdField_a_of_type_JavaLangString, localblws);
    blut.a().a(bmqh.a(), paramblvd.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, localblws);
  }
  
  public MutableLiveData<blvd> b()
  {
    return this.b;
  }
  
  public void b(@Nullable blvd paramblvd)
  {
    bmbx.b("AEVideoStoryGIFTplViewModel", "[applyGIFTpl], material=" + paramblvd);
    bmbx.b("AEGIFStickerListPart", "[applyGIFTpl], material=" + paramblvd);
    this.b.postValue(paramblvd);
  }
  
  public MutableLiveData<String> c()
  {
    return this.c;
  }
  
  public void c(@Nullable blvd paramblvd)
  {
    if (paramblvd != null)
    {
      paramblvd = (String)paramblvd.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename");
      this.c.postValue(paramblvd);
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
 * Qualified Name:     blwr
 * JD-Core Version:    0.7.0.1
 */