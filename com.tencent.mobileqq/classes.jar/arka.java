import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class arka
  implements AdapterView.OnItemClickListener
{
  arka(arjz paramarjz) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.a.a().isShowing()) {
      this.a.a.a().dismiss();
    }
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131655008;
      }
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        vvp.a(1, paramInt);
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131655009;
        }
      }
      else
      {
        switch ((int)paramLong)
        {
        default: 
          return;
        case 0: 
          arjz.a(this.a);
          return;
        case 1: 
          arjz.b(this.a);
          return;
        case 2: 
          arjz.c(this.a);
          return;
        }
        arjz.d(this.a);
        return;
      }
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arka
 * JD-Core Version:    0.7.0.1
 */