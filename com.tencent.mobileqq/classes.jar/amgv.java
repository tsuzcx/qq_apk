import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amgv
  implements View.OnClickListener
{
  amgv(amgs paramamgs) {}
  
  public void onClick(View paramView)
  {
    ((SlideDetectListView)amgs.a(this.a)).resetSlideStatus();
    Object localObject = (View)paramView.getParent();
    if ((localObject instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)localObject).hideDirectly();
    }
    localObject = paramView.getTag();
    if (!(localObject instanceof DiscussionInfo)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)localObject;
      if (NetworkUtil.getSystemNetwork(amgs.a(this.a)) == 0)
      {
        localObject = (BaseActivity)amgs.a(this.a);
        QQToast.a((Context)localObject, 2131695849, 0).b(((BaseActivity)localObject).getTitleBarHeight());
      }
      else if ((!localDiscussionInfo.hasCollect) && (((antp)this.a.a.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a() >= 80))
      {
        localObject = (BaseActivity)amgs.a(this.a);
        QQToast.a((Context)localObject, amgs.a(this.a).getString(2131695848, new Object[] { String.valueOf(80) }), 0).b(((BaseActivity)localObject).getTitleBarHeight());
      }
      else
      {
        antl localantl = (antl)this.a.a.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
        if (localDiscussionInfo.hasCollect) {}
        for (localObject = "0X8006898";; localObject = "0X8006897")
        {
          bdla.b(this.a.a, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
          if (!localDiscussionInfo.hasCollect) {
            break label271;
          }
          localantl.e(Long.valueOf(localDiscussionInfo.uin).longValue());
          break;
        }
        label271:
        localantl.d(Long.valueOf(localDiscussionInfo.uin).longValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amgv
 * JD-Core Version:    0.7.0.1
 */