import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.troop.activity.ExtendGridView;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.Pic_list;
import com.tencent.mobileqq.troop.data.TroopBarMyBar;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;

public class bbjh
  extends Handler
{
  public bbjh(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {
      return;
    }
    long l1;
    label254:
    long l2;
    label418:
    long l3;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1001: 
      if ((this.a.jdField_a_of_type_Bety != null) && (this.a.jdField_a_of_type_Bety.isShowing()))
      {
        this.a.c(false);
        this.a.rightViewText.setEnabled(true);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(true);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(true);
        QQToast.a(this.a.getActivity(), 2131696722, 1).b(this.a.getTitleBarHeight());
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
          break label254;
        }
      }
      for (localObject = "0";; localObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
      {
        bcmc.a("pub_page", "fail", (String)localObject, "51", TroopBarPublishActivity.b(this.a), "");
        QLog.d("tribe_publish_TroopBarPublishActivity", 2, "uploadVideoThumb failed " + paramMessage.obj);
        TroopBarPublishActivity.a(this.a, null);
        l1 = xrg.a(TroopBarPublishActivity.c(this.a));
        bcmc.a(this.a.getActivity(), "tribe_video", "video_thumb_upload", paramMessage.arg1, String.valueOf(l1), "", "");
        return;
      }
    case 1003: 
      localObject = (TroopBarPublishActivity.Pic_list)bcmc.a.get(TroopBarPublishActivity.c(this.a));
      if (localObject != null)
      {
        this.a.jdField_a_of_type_Bbct.d = ((TroopBarPublishActivity.Pic_list)localObject).url;
        QLog.d("tribe_publish_TroopBarPublishActivity", 2, "uploadVideoThumb succ " + paramMessage.obj);
        l1 = xrg.a(TroopBarPublishActivity.c(this.a));
        bcmc.a(this.a.getActivity(), "tribe_video", "video_thumb_upload", paramMessage.arg1, String.valueOf(l1), String.valueOf(paramMessage.arg2), "");
        if (!TextUtils.isEmpty(this.a.jdField_a_of_type_Bbct.jdField_a_of_type_JavaLangString)) {
          break label418;
        }
        this.a.b(this.a.H, true);
      }
      for (;;)
      {
        TroopBarPublishActivity.a(this.a, null);
        return;
        if ((this.a.jdField_a_of_type_Bety != null) && (this.a.jdField_a_of_type_Bety.isShowing())) {
          this.a.l();
        }
      }
    case 1011: 
      paramMessage = (bbes)paramMessage.obj;
      this.a.jdField_a_of_type_Bbct.b = paramMessage.jdField_c_of_type_JavaLangString;
      this.a.jdField_a_of_type_Bbct.jdField_a_of_type_JavaLangString = paramMessage.b;
      TroopBarPublishActivity.a(this.a, null);
      if ((this.a.jdField_a_of_type_Bety != null) && (this.a.jdField_a_of_type_Bety.isShowing())) {
        this.a.l();
      }
      l1 = xrg.a(paramMessage.jdField_a_of_type_JavaLangString);
      l2 = SystemClock.elapsedRealtime();
      l3 = paramMessage.jdField_a_of_type_Long;
      bcmc.a(this.a.getActivity(), "tribe_video", "video_upload", 0, String.valueOf(l1), String.valueOf(l2 - l3), "");
      return;
    }
    Object localObject = (bbes)paramMessage.obj;
    if ((this.a.jdField_a_of_type_Bety != null) && (this.a.jdField_a_of_type_Bety.isShowing()))
    {
      QQToast.a(this.a, 2131696722, 1).b(this.a.getTitleBarHeight());
      this.a.c(false);
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label732;
      }
    }
    label732:
    for (paramMessage = "0";; paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
    {
      bcmc.a("pub_page", "fail", paramMessage, "52", TroopBarPublishActivity.b(this.a), "");
      l1 = xrg.a(((bbes)localObject).jdField_a_of_type_JavaLangString);
      l2 = SystemClock.elapsedRealtime();
      l3 = ((bbes)localObject).jdField_a_of_type_Long;
      bcmc.a(this.a.getActivity(), "tribe_video", "video_upload", ((bbes)localObject).jdField_c_of_type_Int, String.valueOf(l1), String.valueOf(l2 - l3), "");
      TroopBarPublishActivity.a(this.a, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbjh
 * JD-Core Version:    0.7.0.1
 */