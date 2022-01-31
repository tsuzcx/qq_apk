import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class asgd
  implements AdapterView.OnItemClickListener
{
  asgd(asgc paramasgc) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.a.a().isShowing()) {
      this.a.a.a().dismiss();
    }
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131720906;
      }
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        wim.a(1, paramInt);
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131720907;
        }
      }
      else
      {
        switch ((int)paramLong)
        {
        default: 
          return;
        case 0: 
          asgc.a(this.a);
          return;
        case 1: 
          asgc.b(this.a);
          return;
        case 2: 
          asgc.c(this.a);
          return;
        }
        asgc.d(this.a);
        return;
      }
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asgd
 * JD-Core Version:    0.7.0.1
 */