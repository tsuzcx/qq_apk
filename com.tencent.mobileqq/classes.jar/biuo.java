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

public class biuo
  extends bjof
{
  private bjoa<List<biqs>> jdField_a_of_type_Bjoa = new bjoa();
  private Map<String, biqq> jdField_a_of_type_JavaUtilMap = new HashMap();
  private bjoa<biqv> b = new bjoa();
  
  public bjoa<List<biqs>> a()
  {
    return this.jdField_a_of_type_Bjoa;
  }
  
  public void a(bjnb parambjnb, String paramString)
  {
    QLog.d("AEGIFMaterialViewModel", 4, "LoadingGifTplData");
    ThreadManager.getSubThreadHandler().post(new AEGIFMaterialViewModel.1(this, paramString));
    biqd.a().a(parambjnb, new biup(this, paramString));
  }
  
  public void a(AppInterface paramAppInterface, bisj parambisj)
  {
    biuq localbiuq = new biuq(this);
    this.jdField_a_of_type_JavaUtilMap.put(parambisj.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id, localbiuq);
    biqo.a().a(paramAppInterface, parambisj.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, localbiuq);
  }
  
  public void a(String paramString)
  {
    Object localObject1 = biqd.a();
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
          biqs localbiqs = new biqs();
          localbiqs.jdField_a_of_type_JavaLangString = ((MetaMaterial)localObject2).id;
          localbiqs.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = ((MetaMaterial)localObject2);
          if (biqo.a().a((MetaMaterial)localObject2)) {}
          for (int i = 2;; i = 0)
          {
            localbiqs.jdField_a_of_type_Int = i;
            ((List)localObject1).add(localbiqs);
            break;
          }
        }
        QLog.e("AEGIFMaterialViewModel", 4, "Updating Materials size === " + ((List)localObject1).size());
        this.jdField_a_of_type_Bjoa.a(localObject1);
        return;
      }
    }
  }
  
  public bjoa<biqv> b()
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
 * Qualified Name:     biuo
 * JD-Core Version:    0.7.0.1
 */