import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import cooperation.qzone.contentbox.MsgPhotoView;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQUserPersonalData;
import cooperation.qzone.util.QZLog;

public class bjio
  implements View.OnClickListener
{
  public bjio(MsgPhotoView paramMsgPhotoView) {}
  
  public void onClick(View paramView)
  {
    MQUserPersonalData localMQUserPersonalData = this.a.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg.mqUserPersonalData;
    if (localMQUserPersonalData == null)
    {
      QZLog.i("MsgPhotoView", 1, " vip icon click data = null");
      return;
    }
    Object localObject = "";
    switch (paramView.getId())
    {
    default: 
      paramView = (View)localObject;
    }
    for (;;)
    {
      if (QZLog.isColorLevel()) {
        QZLog.i("MsgPhotoView", 2, "MsgVip vip icon click url = " + paramView);
      }
      localObject = new Intent(this.a.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_jc_vip");
      this.a.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return;
      paramView = localMQUserPersonalData.mBVJumpUrl;
      bkdx.a(12, 2);
      continue;
      localObject = localMQUserPersonalData.mYJumpUrl;
      paramView = paramView.getTag();
      if ((paramView != null) && ((paramView instanceof Boolean)))
      {
        if (((Boolean)paramView).booleanValue()) {}
        for (int i = 11;; i = 10)
        {
          bkdx.a(i, 2);
          paramView = (View)localObject;
          break;
        }
        paramView = localMQUserPersonalData.mLYJumpUrl;
        bkdx.a(13, 2);
      }
      else
      {
        paramView = (View)localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjio
 * JD-Core Version:    0.7.0.1
 */