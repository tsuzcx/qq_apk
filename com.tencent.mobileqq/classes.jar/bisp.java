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

public class bisp
  extends bjow
{
  private bjor<List<birj>> jdField_a_of_type_Bjor = new bjor();
  private Map<String, birh> jdField_a_of_type_JavaUtilMap = new HashMap();
  private bjor<birm> b = new bjor();
  private bjor<String> c = new bjor();
  private bjor<String> d = new bjor();
  
  private void c()
  {
    Object localObject1 = biqu.a();
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
      } while (!((MetaCategory)localObject1).name.equals(ajya.a(2131700014)));
      while ((localObject1 != null) && (((MetaCategory)localObject1).materials != null))
      {
        localObject2 = new ArrayList();
        localObject1 = ((MetaCategory)localObject1).materials.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          MetaMaterial localMetaMaterial = (MetaMaterial)((Iterator)localObject1).next();
          birj localbirj = new birj();
          localbirj.jdField_a_of_type_JavaLangString = localMetaMaterial.id;
          localbirj.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = localMetaMaterial;
          if (birf.a().a(localMetaMaterial)) {}
          for (int i = 2;; i = 0)
          {
            localbirj.jdField_a_of_type_Int = i;
            ((List)localObject2).add(localbirj);
            break;
          }
        }
        this.jdField_a_of_type_Bjor.a(localObject2);
        return;
        localObject1 = null;
      }
    }
  }
  
  public bjor<List<birj>> a()
  {
    return this.jdField_a_of_type_Bjor;
  }
  
  public void a()
  {
    this.c.a(this.c.a());
  }
  
  public void a(bijd parambijd)
  {
    ThreadManager.getSubThreadHandler().post(new AEVideoStoryGIFTplViewModel.1(this));
    biqu.a().a(parambijd, new bisq(this));
  }
  
  public void a(birj parambirj)
  {
    bisr localbisr = new bisr(this);
    this.jdField_a_of_type_JavaUtilMap.put(parambirj.jdField_a_of_type_JavaLangString, localbisr);
    birf.a().a(bjal.a(), parambirj.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, localbisr);
  }
  
  public bjor<birm> b()
  {
    return this.b;
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void b(@Nullable birj parambirj)
  {
    if (parambirj != null)
    {
      parambirj = birf.a().a(parambirj.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
      this.c.a(parambirj);
      return;
    }
    this.c.a(null);
  }
  
  public bjor<String> c()
  {
    return this.c;
  }
  
  public void c(@Nullable birj parambirj)
  {
    if (parambirj != null)
    {
      parambirj = (String)parambirj.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename");
      this.d.a(parambirj);
      return;
    }
    this.d.a(null);
  }
  
  public bjor<String> d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bisp
 * JD-Core Version:    0.7.0.1
 */