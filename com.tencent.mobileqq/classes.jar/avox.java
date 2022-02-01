import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class avox
  implements AdapterView.OnItemClickListener
{
  avox(avow paramavow) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.a.getActionSheet().isShowing()) {
      this.a.a.getActionSheet().dismiss();
    }
    int i;
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.getInstance().isWXinstalled()) {
        i = 2131719722;
      }
    }
    for (;;)
    {
      if (i != -1) {
        yyi.a(1, i);
      }
      for (;;)
      {
        EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        return;
        if (WXShareHelper.getInstance().isWXsupportApi()) {
          break label175;
        }
        i = 2131719723;
        break;
        switch ((int)paramLong)
        {
        default: 
          break;
        case 0: 
          avow.a(this.a);
          break;
        case 1: 
          avow.b(this.a);
          break;
        case 2: 
          avow.c(this.a);
          break;
        case 3: 
          avow.d(this.a);
        }
      }
      label175:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avox
 * JD-Core Version:    0.7.0.1
 */