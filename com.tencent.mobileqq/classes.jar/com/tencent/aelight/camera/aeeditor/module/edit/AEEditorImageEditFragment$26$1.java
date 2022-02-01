package com.tencent.aelight.camera.aeeditor.module.edit;

import androidx.fragment.app.FragmentActivity;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class AEEditorImageEditFragment$26$1
  implements Runnable
{
  AEEditorImageEditFragment$26$1(AEEditorImageEditFragment.26 param26, Collection paramCollection) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment$26.a.b();
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilCollection);
    int i = localArrayList.size();
    String str2 = "unknown";
    String str1;
    if (i > 0) {
      str1 = (String)localArrayList.get(0);
    } else {
      str1 = "unknown";
    }
    FragmentActivity localFragmentActivity = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment$26.a.getActivity();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("导出失败: error code = ");
    localStringBuilder.append(str1);
    QQToast.a(localFragmentActivity, localStringBuilder.toString(), 0).a();
    if (localArrayList.size() > 0) {
      str2 = localArrayList.toString();
    }
    AEQLog.e("AEEditorImageEditFragment", str2);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).P_EXPORT_END(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT1(), "pic"), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).DESC(), str1), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).KEY_RET_CODE(), "-90000000") }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.26.1
 * JD-Core Version:    0.7.0.1
 */