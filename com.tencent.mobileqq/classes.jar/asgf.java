import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class asgf
  implements AdapterView.OnItemClickListener
{
  asgf(asge paramasge) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.a.a().isShowing()) {
      this.a.a.a().dismiss();
    }
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131720917;
      }
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        wij.a(1, paramInt);
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131720918;
        }
      }
      else
      {
        switch ((int)paramLong)
        {
        default: 
          return;
        case 0: 
          asge.a(this.a);
          return;
        case 1: 
          asge.b(this.a);
          return;
        case 2: 
          asge.c(this.a);
          return;
        }
        asge.d(this.a);
        return;
      }
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asgf
 * JD-Core Version:    0.7.0.1
 */