import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.gif.giftext.viewmodel.AEGIFMaterialViewModel.1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class bivf
  extends bjow
{
  private bjor<List<birj>> jdField_a_of_type_Bjor = new bjor();
  private Map<String, birh> jdField_a_of_type_JavaUtilMap = new HashMap();
  private bjor<birm> b = new bjor();
  
  public bjor<List<birj>> a()
  {
    return this.jdField_a_of_type_Bjor;
  }
  
  public void a(bjns parambjns, String paramString)
  {
    QLog.d("AEGIFMaterialViewModel", 4, "LoadingGifTplData");
    ThreadManager.getSubThreadHandler().post(new AEGIFMaterialViewModel.1(this, paramString));
    biqu.a().a(parambjns, new bivg(this, paramString));
  }
  
  public void a(AppInterface paramAppInterface, bita parambita)
  {
    bivh localbivh = new bivh(this);
    this.jdField_a_of_type_JavaUtilMap.put(parambita.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id, localbivh);
    birf.a().a(paramAppInterface, parambita.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, localbivh);
  }
  
  public void a(String paramString)
  {
    Object localObject1 = biqu.a();
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
          birj localbirj = new birj();
          localbirj.jdField_a_of_type_JavaLangString = ((MetaMaterial)localObject2).id;
          localbirj.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = ((MetaMaterial)localObject2);
          if (birf.a().a((MetaMaterial)localObject2)) {}
          for (int i = 2;; i = 0)
          {
            localbirj.jdField_a_of_type_Int = i;
            ((List)localObject1).add(localbirj);
            break;
          }
        }
        QLog.e("AEGIFMaterialViewModel", 4, "Updating Materials size === " + ((List)localObject1).size());
        this.jdField_a_of_type_Bjor.a(localObject1);
        return;
      }
    }
  }
  
  public bjor<birm> b()
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
 * Qualified Name:     bivf
 * JD-Core Version:    0.7.0.1
 */