package com.tencent.mobileqq.activity.richmedia;

import alwg;
import alwj;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

public class PtvTemplateAdapter$3$1
  implements Runnable
{
  public PtvTemplateAdapter$3$1(alwj paramalwj, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean) {}
  
  public void run()
  {
    int j = -1;
    int m = this.jdField_a_of_type_Alwj.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    int n = this.jdField_a_of_type_Alwj.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition();
    int i = m;
    int k = j;
    Object localObject;
    if (i <= n)
    {
      if (i < 0) {}
      do
      {
        i += 1;
        break;
        localObject = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Alwj.a.jdField_a_of_type_JavaUtilArrayList.get(i);
      } while ((localObject == null) || (!((PtvTemplateManager.PtvTemplateInfo)localObject).id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)));
      ((PtvTemplateManager.PtvTemplateInfo)localObject).downloading = false;
      ((PtvTemplateManager.PtvTemplateInfo)localObject).usable = this.jdField_a_of_type_Boolean;
      ((PtvTemplateManager.PtvTemplateInfo)localObject).doDownloadDataReport();
      localObject = this.jdField_a_of_type_Alwj.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i - m);
      if ((localObject instanceof PtvTemplateItemView))
      {
        localObject = (PtvTemplateItemView)localObject;
        if (this.jdField_a_of_type_Boolean) {
          j = 1000;
        }
        ((PtvTemplateItemView)localObject).b(j);
      }
      k = i;
    }
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if ((this.jdField_a_of_type_Alwj.a.a() == k) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Alwj.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout != null))
    {
      localObject = PtvTemplateManager.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name;
      this.jdField_a_of_type_Alwj.a.jdField_a_of_type_JavaLangString = ((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("PtvTemplateManager", 2, "current mCurrentTemplatePath:" + this.jdField_a_of_type_Alwj.a.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Alwj.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout != null)
      {
        localPtvTemplateInfo = this.jdField_a_of_type_Alwj.a.a();
        if ((localPtvTemplateInfo != null) && ((localPtvTemplateInfo == null) || (localPtvTemplateInfo.category != 0))) {
          break label342;
        }
        this.jdField_a_of_type_Alwj.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter((String)localObject);
      }
    }
    label342:
    while (localPtvTemplateInfo == null) {
      return;
    }
    this.jdField_a_of_type_Alwj.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter((String)localObject, localPtvTemplateInfo.category, localPtvTemplateInfo.gestureType, localPtvTemplateInfo.gestureWording);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter.3.1
 * JD-Core Version:    0.7.0.1
 */