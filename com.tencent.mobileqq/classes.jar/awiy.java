import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awiy
  implements AdapterView.OnItemClickListener
{
  awiy(awix paramawix) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.a.getActionSheet().isShowing()) {
      this.a.a.getActionSheet().dismiss();
    }
    int i;
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.a().a()) {
        i = 2131719199;
      }
    }
    for (;;)
    {
      if (i != -1) {
        zvc.a(1, i);
      }
      for (;;)
      {
        EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        return;
        if (WXShareHelper.a().b()) {
          break label175;
        }
        i = 2131719200;
        break;
        switch ((int)paramLong)
        {
        default: 
          break;
        case 0: 
          awix.a(this.a);
          break;
        case 1: 
          awix.b(this.a);
          break;
        case 2: 
          awix.c(this.a);
          break;
        case 3: 
          awix.d(this.a);
        }
      }
      label175:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awiy
 * JD-Core Version:    0.7.0.1
 */