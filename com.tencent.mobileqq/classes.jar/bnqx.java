import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.data.AEMaterialConfigParser;
import dov.com.qq.im.ae.gif.AEVideoStoryGIFTplViewModel.1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class bnqx
  extends ViewModel
{
  private MutableLiveData<List<bnpk>> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private Map<String, bnpi> jdField_a_of_type_JavaUtilMap = new HashMap();
  private MutableLiveData<bnpn> b = new MutableLiveData();
  private MutableLiveData<bnpk> c = new MutableLiveData();
  private MutableLiveData<String> d = new MutableLiveData();
  
  private void b()
  {
    Object localObject1 = bnov.a();
    if ((localObject1 == null) || (((GetCategoryMaterialRsp)localObject1).Categories == null)) {}
    for (;;)
    {
      return;
      Object localObject2 = ((GetCategoryMaterialRsp)localObject1).Categories.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (MetaCategory)((Iterator)localObject2).next();
      } while (!((MetaCategory)localObject1).name.equals(anni.a(2131698821)));
      while ((localObject1 != null) && (((MetaCategory)localObject1).materials != null))
      {
        localObject2 = new ArrayList();
        localObject1 = ((MetaCategory)localObject1).materials.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          MetaMaterial localMetaMaterial = (MetaMaterial)((Iterator)localObject1).next();
          bnpk localbnpk = new bnpk();
          localbnpk.jdField_a_of_type_JavaLangString = localMetaMaterial.id;
          localbnpk.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = AEMaterialConfigParser.a(localMetaMaterial);
          if (bnpg.a().a(localMetaMaterial)) {}
          for (int i = 2;; i = 0)
          {
            localbnpk.jdField_a_of_type_Int = i;
            ((List)localObject2).add(localbnpk);
            break;
          }
        }
        this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.postValue(localObject2);
        return;
        localObject1 = null;
      }
    }
  }
  
  public MutableLiveData<List<bnpk>> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public void a()
  {
    bnpk localbnpk = (bnpk)this.c.getValue();
    bnzb.b("AEVideoStoryGIFTplViewModel", "applyGIFTplAgain---lastMaterial=" + localbnpk);
    this.c.postValue(localbnpk);
  }
  
  public void a(bndy parambndy)
  {
    ThreadManager.getSubThreadHandler().post(new AEVideoStoryGIFTplViewModel.1(this));
    bnov.a().observe(parambndy, new bnqy(this));
  }
  
  public void a(bnpk parambnpk)
  {
    bnqz localbnqz = new bnqz(this);
    this.jdField_a_of_type_JavaUtilMap.put(parambnpk.jdField_a_of_type_JavaLangString, localbnqz);
    bnpg.a().a(bojl.a(), parambnpk.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, localbnqz);
  }
  
  public MutableLiveData<bnpn> b()
  {
    return this.b;
  }
  
  public void b(@Nullable bnpk parambnpk)
  {
    this.c.postValue(parambnpk);
  }
  
  public MutableLiveData<bnpk> c()
  {
    return this.c;
  }
  
  public void c(@Nullable bnpk parambnpk)
  {
    if (parambnpk != null)
    {
      parambnpk = (String)parambnpk.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename");
      this.d.postValue(parambnpk);
      return;
    }
    this.d.postValue(null);
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
 * Qualified Name:     bnqx
 * JD-Core Version:    0.7.0.1
 */