import android.app.Activity;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.IPtvTemplateItemCallback;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.predownload.QIMPredownManager;
import dov.com.qq.im.capture.view.ProviderView.ProviderViewListener;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import java.util.ArrayList;

public class amus
  implements QIMPtvTemplateAdapter.IPtvTemplateItemCallback
{
  public amus(QIMPtvTemplateAdapter paramQIMPtvTemplateAdapter) {}
  
  public void a(int paramInt)
  {
    QIMPtvTemplateAdapter.a(this.a).f();
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "PtvTemplateAdapter onItemClicked position: " + paramInt);
    }
    if ((paramInt < 0) || (paramInt >= this.a.jdField_a_of_type_JavaUtilArrayList.size())) {}
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      return;
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    } while (localPtvTemplateInfo == null);
    QIMPtvTemplateAdapter.a(this.a, paramInt);
    QIMPtvTemplateAdapter.jdField_b_of_type_Int = localPtvTemplateInfo.categoryId;
    QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString = localPtvTemplateInfo.id;
    if (localPtvTemplateInfo.isWsBanner())
    {
      WeishiGuideUtils.a(this.a.jdField_a_of_type_AndroidContentContext, localPtvTemplateInfo);
      return;
    }
    ((QIMPredownManager)QIMManager.a(14)).a(localPtvTemplateInfo.id, 3);
    if (!localPtvTemplateInfo.id.equals("0"))
    {
      QIMPtvTemplateManager localQIMPtvTemplateManager = (QIMPtvTemplateManager)QIMManager.a(3);
      localQIMPtvTemplateManager.a(localPtvTemplateInfo, 111);
      localQIMPtvTemplateManager.a(3, localPtvTemplateInfo.categoryId, localPtvTemplateInfo.id);
    }
    this.a.a(null);
    if (!localPtvTemplateInfo.usable) {
      FlowCameraMqqAction.b("", "0X8006A1A");
    }
    ((CaptureComboManager)QIMManager.a(5)).a(this.a.c, (Activity)this.a.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amus
 * JD-Core Version:    0.7.0.1
 */