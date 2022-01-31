import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.contentbox.QZoneMsgFragment;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgInteractData;
import cooperation.qzone.contentbox.model.MQShareCell;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class bfue
  implements bfum
{
  public bfue(QZoneMsgFragment paramQZoneMsgFragment) {}
  
  public void a(MQMsg paramMQMsg, View paramView, int paramInt)
  {
    QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "clicktype:" + paramInt);
    if (paramMQMsg == null) {
      QLog.e("QZoneMsgManager.QZoneMsgFragment", 1, "MsgOnClickListener msg null");
    }
    switch (paramInt)
    {
    case 2: 
    default: 
      if ((paramMQMsg == null) || (TextUtils.isEmpty(paramMQMsg.jumpUrlToDetail))) {
        break label519;
      }
      paramView = bade.a(this.a.a, this.a.getActivity(), paramMQMsg.jumpUrlToDetail);
      if (paramView != null) {
        paramView.c();
      }
      break;
    case 1: 
    case 3: 
    case 4: 
    case 5: 
      do
      {
        return;
        if ((paramMQMsg != null) && (paramMQMsg.msgInteractData != null)) {
          ((bfug)this.a.a.getManager(293)).a(paramMQMsg.msgInteractData.likeCell, paramMQMsg.pushTime);
        }
        LpReportInfo_pf00064.report(133, 5);
        return;
        if ((paramMQMsg != null) && (paramMQMsg.msgInteractData != null) && (paramMQMsg.msgInteractData.shareToFriend != null))
        {
          paramView = new Intent(this.a.getActivity(), ForwardRecentActivity.class);
          paramView.putExtra("forward_type", 2);
          paramView.putExtra("req_type", 1);
          paramView.putExtra("req_share_id", "1103584836");
          paramView.putExtra("image_url_remote", paramMQMsg.msgInteractData.shareToFriend.imgUrl);
          paramView.putExtra("detail_url", paramMQMsg.msgInteractData.shareToFriend.jumpUrl);
          paramView.putExtra("title", paramMQMsg.msgInteractData.shareToFriend.title);
          paramView.putExtra("desc", paramMQMsg.msgInteractData.shareToFriend.content);
          this.a.startActivity(paramView);
        }
        LpReportInfo_pf00064.report(133, 8);
        return;
        if ((paramMQMsg != null) && (paramMQMsg.msgInteractData != null) && (paramMQMsg.msgInteractData.shareToQzone != null))
        {
          paramView = new QZoneShareData();
          paramView.b = paramMQMsg.msgInteractData.shareToQzone.title;
          paramView.c = paramMQMsg.msgInteractData.shareToQzone.content;
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(paramMQMsg.msgInteractData.shareToQzone.imgUrl);
          paramView.a = localArrayList;
          paramView.d = paramMQMsg.msgInteractData.shareToQzone.jumpUrl;
          bfqn.a(this.a.getActivity(), BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramView, null, 0);
        }
        LpReportInfo_pf00064.report(133, 7);
        return;
        paramMQMsg = bade.a(this.a.a, this.a.getActivity(), "mqqzone://arouse/activefeed");
      } while (paramMQMsg == null);
      paramMQMsg.c();
      return;
    }
    paramView = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    paramView.putExtra("url", paramMQMsg.jumpUrlToDetail);
    bfpr.c(paramView);
    this.a.startActivity(paramView);
    return;
    label519:
    QLog.i("QZoneMsgManager.QZoneMsgFragment", 1, "msg.jumpUrlToDetail is null");
    if ((paramMQMsg != null) && (paramMQMsg.msgType == 9) && (!baip.a(paramMQMsg.uniKey)))
    {
      paramView = "mqqzone://arouse/photogrouprecommenddetail?usecache=true&checkgroup=false&unikey=" + paramMQMsg.uniKey;
      this.a.a(paramView);
      LpReportInfo_dc02880.report(2, 2, paramView, "29", false, true);
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 1, "jumpToPhotoGroupRecommendDetail: uniKey=" + paramMQMsg.uniKey);
      return;
    }
    QLog.e("QZoneMsgManager.QZoneMsgFragment", 1, "msg == null | msg.msgType != ENUM_PUSH_MSG_TYPE._ENUM_TRAVEL_ALBUM | StringUtil.isEmpty(msg.uniKey)");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfue
 * JD-Core Version:    0.7.0.1
 */