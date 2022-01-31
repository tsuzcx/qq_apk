import com.tencent.widget.GridView;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.qq.im.capture.view.ProviderView.ProviderViewListener;
import dov.com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import java.util.ArrayList;

class antm
  implements Runnable
{
  antm(antl paramantl, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Antl.a.jdField_a_of_type_ComTencentWidgetGridView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_Antl.a.jdField_a_of_type_ComTencentWidgetGridView.getLastVisiblePosition();
    int i = j;
    if (i <= k)
    {
      if (i < 0) {}
      do
      {
        i += 1;
        break;
        localObject1 = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Antl.a.jdField_a_of_type_JavaUtilArrayList.get(i);
      } while ((localObject1 == null) || (!((PtvTemplateManager.PtvTemplateInfo)localObject1).id.equals(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)));
      ((PtvTemplateManager.PtvTemplateInfo)localObject1).downloading = false;
      ((PtvTemplateManager.PtvTemplateInfo)localObject1).usable = this.jdField_a_of_type_Boolean;
      Object localObject2 = this.jdField_a_of_type_Antl.a.jdField_a_of_type_ComTencentWidgetGridView.getChildAt(i - j);
      if ((localObject2 instanceof PtvTemplateItemView))
      {
        localObject2 = (PtvTemplateItemView)localObject2;
        if (!this.jdField_a_of_type_Boolean) {
          break label214;
        }
        i = 1000;
        ((PtvTemplateItemView)localObject2).a(i);
      }
      if (this.jdField_a_of_type_Boolean) {
        ((QIMPtvTemplateManager)QIMManager.a(3)).a(112, localObject1);
      }
    }
    if ((QIMPtvTemplateAdapter.a(this.jdField_a_of_type_Antl.a) < 0) || (QIMPtvTemplateAdapter.a(this.jdField_a_of_type_Antl.a) >= this.jdField_a_of_type_Antl.a.jdField_a_of_type_JavaUtilArrayList.size())) {}
    label214:
    while ((!((PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Antl.a.jdField_a_of_type_JavaUtilArrayList.get(QIMPtvTemplateAdapter.a(this.jdField_a_of_type_Antl.a))).id.equals(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) || (!this.jdField_a_of_type_Boolean) || (QIMPtvTemplateAdapter.a(this.jdField_a_of_type_Antl.a) == null))
    {
      return;
      i = -1;
      break;
    }
    Object localObject1 = QIMPtvTemplateManager.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name;
    QIMPtvTemplateAdapter.jdField_a_of_type_JavaLangString = (String)localObject1;
    QIMPtvTemplateAdapter.jdField_b_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.categoryId;
    QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id;
    if (this.jdField_a_of_type_Antl.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind == 3)
    {
      QIMPtvTemplateAdapter.jdField_a_of_type_JavaLangString = "";
      QIMPtvTemplateAdapter.a(this.jdField_a_of_type_Antl.a).a((String)localObject1);
      QIMPtvTemplateAdapter.a(this.jdField_a_of_type_Antl.a).a("", false, false);
    }
    for (;;)
    {
      i = AdvancedProviderView.b();
      QIMPtvTemplateAdapter.a(this.jdField_a_of_type_Antl.a).c(i);
      i = AdvancedProviderView.c();
      QIMPtvTemplateAdapter.a(this.jdField_a_of_type_Antl.a).b(i, false);
      localObject1 = (QIMPtvTemplateManager)QIMManager.a(3);
      ((QIMPtvTemplateManager)localObject1).a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, 111);
      ((QIMPtvTemplateManager)localObject1).a(3, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.categoryId, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id);
      ((QIMPtvTemplateManager)localObject1).a(113, null);
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.templateStyle != 0) {
        break;
      }
      QIMPtvTemplateAdapter.a(this.jdField_a_of_type_Antl.a).a(101, new Object[0]);
      return;
      QIMPtvTemplateAdapter.a(this.jdField_a_of_type_Antl.a).a((String)localObject1, false, false);
      QIMPtvTemplateAdapter.a(this.jdField_a_of_type_Antl.a).a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     antm
 * JD-Core Version:    0.7.0.1
 */