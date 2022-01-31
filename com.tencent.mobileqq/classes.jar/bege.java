import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;

class bege
  implements RadioGroup.OnCheckedChangeListener
{
  bege(begd parambegd) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    paramInt = this.a.a(paramRadioGroup);
    if (((QQBrowserActivity)this.a.a.a).b != paramInt)
    {
      paramRadioGroup = QQBrowserActivity.a(paramInt, (QQBrowserActivity)this.a.a.a);
      ((QQBrowserActivity)this.a.a.a).b = paramInt;
      if ((paramRadioGroup.a != null) && (paramRadioGroup.a.a != null)) {
        paramRadioGroup.a.a.setSelectedTab(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bege
 * JD-Core Version:    0.7.0.1
 */