import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.giftext.viewmodel.AEGIFMaterialViewModel.1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class bhum
  extends bhwk
{
  private bhwf<List<wqk>> jdField_a_of_type_Bhwf = new bhwf();
  private Map<String, wqj> jdField_a_of_type_JavaUtilMap = new HashMap();
  private bhwf<wqg> b = new bhwf();
  
  public bhwf<List<wqk>> a()
  {
    return this.jdField_a_of_type_Bhwf;
  }
  
  public void a(bhvg parambhvg, String paramString)
  {
    QLog.d("AEGIFMaterialViewModel", 4, "LoadingGifTplData");
    ThreadManager.getSubThreadHandler().post(new AEGIFMaterialViewModel.1(this, paramString));
    avzk.a().a(parambhvg, new bhun(this, paramString));
  }
  
  public void a(AppInterface paramAppInterface, bhsf parambhsf)
  {
    bhuo localbhuo = new bhuo(this);
    this.jdField_a_of_type_JavaUtilMap.put(parambhsf.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id, localbhuo);
    wqh.a().a(paramAppInterface, parambhsf.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, localbhuo);
  }
  
  public void a(String paramString)
  {
    Object localObject1 = avzk.a();
    QLog.d("AEGIFMaterialViewModel", 4, "Parsing EmoCategories");
    if (localObject1 == null)
    {
      QLog.e("AEGIFMaterialViewModel", 4, "CategoryMaterialRsp is null");
      if ((localObject1 != null) && (((GetCategoryMaterialRsp)localObject1).Categories != null)) {
        break label54;
      }
    }
    for (;;)
    {
      return;
      if (((GetCategoryMaterialRsp)localObject1).Categories != null) {
        break;
      }
      QLog.e("AEGIFMaterialViewModel", 4, "Categories null");
      break;
      label54:
      Object localObject2 = ((GetCategoryMaterialRsp)localObject1).Categories.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (MetaCategory)((Iterator)localObject2).next();
      } while (!((MetaCategory)localObject1).name.toLowerCase().equals(paramString));
      for (paramString = (String)localObject1; (paramString != null) && (paramString.materials != null); paramString = null)
      {
        localObject1 = new ArrayList();
        paramString = paramString.materials.iterator();
        if (paramString.hasNext())
        {
          localObject2 = (MetaMaterial)paramString.next();
          wqk localwqk = new wqk();
          localwqk.jdField_a_of_type_JavaLangString = ((MetaMaterial)localObject2).id;
          localwqk.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = ((MetaMaterial)localObject2);
          if (wqh.a().a((MetaMaterial)localObject2)) {}
          for (int i = 2;; i = 0)
          {
            localwqk.jdField_a_of_type_Int = i;
            ((List)localObject1).add(localwqk);
            break;
          }
        }
        QLog.e("AEGIFMaterialViewModel", 4, "Updating Materials size === " + ((List)localObject1).size());
        this.jdField_a_of_type_Bhwf.a(localObject1);
        return;
      }
    }
  }
  
  public bhwf<wqg> b()
  {
    return this.b;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhum
 * JD-Core Version:    0.7.0.1
 */