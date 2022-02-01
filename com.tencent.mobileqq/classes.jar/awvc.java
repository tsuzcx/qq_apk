import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awvc
  implements AdapterView.OnItemClickListener
{
  awvc(awvb paramawvb) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.a.getActionSheet().isShowing()) {
      this.a.a.getActionSheet().dismiss();
    }
    int i;
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.a().a()) {
        i = 2131720175;
      }
    }
    for (;;)
    {
      if (i != -1) {
        znl.a(1, i);
      }
      for (;;)
      {
        EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        return;
        if (WXShareHelper.a().b()) {
          break label175;
        }
        i = 2131720176;
        break;
        switch ((int)paramLong)
        {
        default: 
          break;
        case 0: 
          awvb.a(this.a);
          break;
        case 1: 
          awvb.b(this.a);
          break;
        case 2: 
          awvb.c(this.a);
          break;
        case 3: 
          awvb.d(this.a);
        }
      }
      label175:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvc
 * JD-Core Version:    0.7.0.1
 */