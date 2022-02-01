package com.tencent.mobileqq.activity.richmedia;

import alko;
import alkt;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

public class PtvTemplateAdapter$5$1
  implements Runnable
{
  public PtvTemplateAdapter$5$1(alkt paramalkt, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Alkt.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_Alkt.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition();
    int i = j;
    for (;;)
    {
      Object localObject;
      if (i <= k)
      {
        localObject = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Alkt.a.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localObject == null) || (!((PtvTemplateManager.PtvTemplateInfo)localObject).id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id))) {
          break label148;
        }
        ((PtvTemplateManager.PtvTemplateInfo)localObject).downloading = false;
        ((PtvTemplateManager.PtvTemplateInfo)localObject).usable = this.jdField_a_of_type_Boolean;
        localObject = this.jdField_a_of_type_Alkt.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i - j);
        if ((localObject instanceof PtvTemplateItemView))
        {
          localObject = (PtvTemplateItemView)localObject;
          if (!this.jdField_a_of_type_Boolean) {
            break label143;
          }
        }
      }
      label143:
      for (i = 1000;; i = -1)
      {
        ((PtvTemplateItemView)localObject).b(i);
        return;
      }
      label148:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter.5.1
 * JD-Core Version:    0.7.0.1
 */