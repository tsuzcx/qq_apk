import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class atxf
  implements AdapterView.OnItemClickListener
{
  atxf(atxe paramatxe) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.a.getActionSheet().isShowing()) {
      this.a.a.getActionSheet().dismiss();
    }
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131721478;
      }
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        xxb.a(1, paramInt);
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131721479;
        }
      }
      else
      {
        switch ((int)paramLong)
        {
        default: 
          return;
        case 0: 
          atxe.a(this.a);
          return;
        case 1: 
          atxe.b(this.a);
          return;
        case 2: 
          atxe.c(this.a);
          return;
        }
        atxe.d(this.a);
        return;
      }
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atxf
 * JD-Core Version:    0.7.0.1
 */