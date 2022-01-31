import android.support.annotation.Nullable;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.gif.AEVideoStoryGIFTplViewModel.1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class biry
  extends bjof
{
  private bjoa<List<biqs>> jdField_a_of_type_Bjoa = new bjoa();
  private Map<String, biqq> jdField_a_of_type_JavaUtilMap = new HashMap();
  private bjoa<biqv> b = new bjoa();
  private bjoa<String> c = new bjoa();
  private bjoa<String> d = new bjoa();
  
  private void c()
  {
    Object localObject1 = biqd.a();
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
      } while (!((MetaCategory)localObject1).name.equals(ajyc.a(2131700003)));
      while ((localObject1 != null) && (((MetaCategory)localObject1).materials != null))
      {
        localObject2 = new ArrayList();
        localObject1 = ((MetaCategory)localObject1).materials.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          MetaMaterial localMetaMaterial = (MetaMaterial)((Iterator)localObject1).next();
          biqs localbiqs = new biqs();
          localbiqs.jdField_a_of_type_JavaLangString = localMetaMaterial.id;
          localbiqs.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = localMetaMaterial;
          if (biqo.a().a(localMetaMaterial)) {}
          for (int i = 2;; i = 0)
          {
            localbiqs.jdField_a_of_type_Int = i;
            ((List)localObject2).add(localbiqs);
            break;
          }
        }
        this.jdField_a_of_type_Bjoa.a(localObject2);
        return;
        localObject1 = null;
      }
    }
  }
  
  public bjoa<List<biqs>> a()
  {
    return this.jdField_a_of_type_Bjoa;
  }
  
  public void a()
  {
    this.c.a(this.c.a());
  }
  
  public void a(biim parambiim)
  {
    ThreadManager.getSubThreadHandler().post(new AEVideoStoryGIFTplViewModel.1(this));
    biqd.a().a(parambiim, new birz(this));
  }
  
  public void a(biqs parambiqs)
  {
    bisa localbisa = new bisa(this);
    this.jdField_a_of_type_JavaUtilMap.put(parambiqs.jdField_a_of_type_JavaLangString, localbisa);
    biqo.a().a(bizu.a(), parambiqs.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, localbisa);
  }
  
  public bjoa<biqv> b()
  {
    return this.b;
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void b(@Nullable biqs parambiqs)
  {
    if (parambiqs != null)
    {
      parambiqs = biqo.a().a(parambiqs.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
      this.c.a(parambiqs);
      return;
    }
    this.c.a(null);
  }
  
  public bjoa<String> c()
  {
    return this.c;
  }
  
  public void c(@Nullable biqs parambiqs)
  {
    if (parambiqs != null)
    {
      parambiqs = (String)parambiqs.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename");
      this.d.a(parambiqs);
      return;
    }
    this.d.a(null);
  }
  
  public bjoa<String> d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biry
 * JD-Core Version:    0.7.0.1
 */