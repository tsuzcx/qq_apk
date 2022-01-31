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
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;

public class aygc
  extends Handler
{
  public aygc(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
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
      if ((this.a.jdField_a_of_type_Bbms != null) && (this.a.jdField_a_of_type_Bbms.isShowing()))
      {
        this.a.c(false);
        this.a.rightViewText.setEnabled(true);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(true);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(true);
        bbmy.a(this.a.getActivity(), 2131630832, 1).b(this.a.getTitleBarHeight());
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
          break label254;
        }
      }
      for (localObject = "0";; localObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
      {
        azho.a("pub_page", "fail", (String)localObject, "51", TroopBarPublishActivity.b(this.a), "");
        QLog.d("tribe_publish_TroopBarPublishActivity", 2, "uploadVideoThumb failed " + paramMessage.obj);
        TroopBarPublishActivity.a(this.a, null);
        l1 = vlm.a(TroopBarPublishActivity.c(this.a));
        azho.a(this.a.getActivity(), "tribe_video", "video_thumb_upload", paramMessage.arg1, String.valueOf(l1), "", "");
        return;
      }
    case 1003: 
      localObject = (TroopBarPublishActivity.Pic_list)azho.a.get(TroopBarPublishActivity.c(this.a));
      if (localObject != null)
      {
        this.a.jdField_a_of_type_Ayab.d = ((TroopBarPublishActivity.Pic_list)localObject).url;
        QLog.d("tribe_publish_TroopBarPublishActivity", 2, "uploadVideoThumb succ " + paramMessage.obj);
        l1 = vlm.a(TroopBarPublishActivity.c(this.a));
        azho.a(this.a.getActivity(), "tribe_video", "video_thumb_upload", paramMessage.arg1, String.valueOf(l1), String.valueOf(paramMessage.arg2), "");
        if (!TextUtils.isEmpty(this.a.jdField_a_of_type_Ayab.jdField_a_of_type_JavaLangString)) {
          break label418;
        }
        this.a.b(this.a.H, true);
      }
      for (;;)
      {
        TroopBarPublishActivity.a(this.a, null);
        return;
        if ((this.a.jdField_a_of_type_Bbms != null) && (this.a.jdField_a_of_type_Bbms.isShowing())) {
          this.a.l();
        }
      }
    case 1011: 
      paramMessage = (ayby)paramMessage.obj;
      this.a.jdField_a_of_type_Ayab.b = paramMessage.jdField_c_of_type_JavaLangString;
      this.a.jdField_a_of_type_Ayab.jdField_a_of_type_JavaLangString = paramMessage.b;
      TroopBarPublishActivity.a(this.a, null);
      if ((this.a.jdField_a_of_type_Bbms != null) && (this.a.jdField_a_of_type_Bbms.isShowing())) {
        this.a.l();
      }
      l1 = vlm.a(paramMessage.jdField_a_of_type_JavaLangString);
      l2 = SystemClock.elapsedRealtime();
      l3 = paramMessage.jdField_a_of_type_Long;
      azho.a(this.a.getActivity(), "tribe_video", "video_upload", 0, String.valueOf(l1), String.valueOf(l2 - l3), "");
      return;
    }
    Object localObject = (ayby)paramMessage.obj;
    if ((this.a.jdField_a_of_type_Bbms != null) && (this.a.jdField_a_of_type_Bbms.isShowing()))
    {
      bbmy.a(this.a, 2131630832, 1).b(this.a.getTitleBarHeight());
      this.a.c(false);
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label732;
      }
    }
    label732:
    for (paramMessage = "0";; paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
    {
      azho.a("pub_page", "fail", paramMessage, "52", TroopBarPublishActivity.b(this.a), "");
      l1 = vlm.a(((ayby)localObject).jdField_a_of_type_JavaLangString);
      l2 = SystemClock.elapsedRealtime();
      l3 = ((ayby)localObject).jdField_a_of_type_Long;
      azho.a(this.a.getActivity(), "tribe_video", "video_upload", ((ayby)localObject).jdField_c_of_type_Int, String.valueOf(l1), String.valueOf(l2 - l3), "");
      TroopBarPublishActivity.a(this.a, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aygc
 * JD-Core Version:    0.7.0.1
 */