import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class aubo
  implements AdapterView.OnItemClickListener
{
  aubo(aubn paramaubn) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.a.getActionSheet().isShowing()) {
      this.a.a.getActionSheet().dismiss();
    }
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131721491;
      }
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        ybk.a(1, paramInt);
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131721492;
        }
      }
      else
      {
        switch ((int)paramLong)
        {
        default: 
          return;
        case 0: 
          aubn.a(this.a);
          return;
        case 1: 
          aubn.b(this.a);
          return;
        case 2: 
          aubn.c(this.a);
          return;
        }
        aubn.d(this.a);
        return;
      }
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aubo
 * JD-Core Version:    0.7.0.1
 */