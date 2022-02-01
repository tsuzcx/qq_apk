import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.util.HashMap;
import java.util.Map;

public class bnmb
  extends ViewModel
{
  private MutableLiveData<bnkn> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private Map<String, bnjz> jdField_a_of_type_JavaUtilMap = new HashMap();
  private MutableLiveData<bnkg> b = new MutableLiveData();
  private MutableLiveData<String> c = new MutableLiveData();
  private MutableLiveData<String> d = new MutableLiveData();
  
  public MutableLiveData<bnkn> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public void a()
  {
    bnkg localbnkg = (bnkg)this.b.getValue();
    bnrh.b("AEVideoStoryGIFTplViewModel", "[applyGIFTplAgain], lastMaterial=" + localbnkg);
    this.b.postValue(localbnkg);
  }
  
  public void a(bnkg parambnkg)
  {
    bnmc localbnmc = new bnmc(this);
    this.jdField_a_of_type_JavaUtilMap.put(parambnkg.jdField_a_of_type_JavaLangString, localbnmc);
    bnjw.a().a(bofz.a(), parambnkg.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, localbnmc);
  }
  
  public MutableLiveData<bnkg> b()
  {
    return this.b;
  }
  
  public void b(@Nullable bnkg parambnkg)
  {
    bnrh.b("AEVideoStoryGIFTplViewModel", "[applyGIFTpl], material=" + parambnkg);
    bnrh.b("AEGIFStickerListPart", "[applyGIFTpl], material=" + parambnkg);
    this.b.postValue(parambnkg);
  }
  
  public MutableLiveData<String> c()
  {
    return this.c;
  }
  
  public void c(@Nullable bnkg parambnkg)
  {
    if (parambnkg != null)
    {
      parambnkg = (String)parambnkg.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename");
      this.c.postValue(parambnkg);
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
 * Qualified Name:     bnmb
 * JD-Core Version:    0.7.0.1
 */