import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amob
  implements View.OnClickListener
{
  amob(amny paramamny) {}
  
  public void onClick(View paramView)
  {
    ((SlideDetectListView)amny.a(this.a)).a();
    Object localObject = (View)paramView.getParent();
    if ((localObject instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)localObject).d();
    }
    localObject = paramView.getTag();
    if (!(localObject instanceof DiscussionInfo)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)localObject;
      if (bhnv.a(amny.a(this.a)) == 0)
      {
        localObject = (BaseActivity)amny.a(this.a);
        QQToast.a((Context)localObject, 2131695458, 0).b(((BaseActivity)localObject).getTitleBarHeight());
      }
      else if ((!localDiscussionInfo.hasCollect) && (((anws)this.a.a.getManager(53)).a() >= 80))
      {
        localObject = (BaseActivity)amny.a(this.a);
        QQToast.a((Context)localObject, amny.a(this.a).getString(2131695457, new Object[] { String.valueOf(80) }), 0).b(((BaseActivity)localObject).getTitleBarHeight());
      }
      else
      {
        anwo localanwo = (anwo)this.a.a.a(6);
        if (localDiscussionInfo.hasCollect) {}
        for (localObject = "0X8006898";; localObject = "0X8006897")
        {
          bdll.b(this.a.a, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
          if (!localDiscussionInfo.hasCollect) {
            break label269;
          }
          localanwo.e(Long.valueOf(localDiscussionInfo.uin).longValue());
          break;
        }
        label269:
        localanwo.d(Long.valueOf(localDiscussionInfo.uin).longValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amob
 * JD-Core Version:    0.7.0.1
 */