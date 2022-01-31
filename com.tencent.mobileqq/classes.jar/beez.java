import android.net.Uri;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnOverScrollHandler;

class beez
  implements TouchWebView.OnOverScrollHandler
{
  beez(beey parambeey, TouchWebView paramTouchWebView, RefreshView paramRefreshView) {}
  
  public void onBack()
  {
    this.jdField_a_of_type_Beey.a = false;
    this.jdField_a_of_type_ComTencentBizUiRefreshView.onBack();
    this.jdField_a_of_type_Beey.b(true);
  }
  
  public void onOverScroll(int paramInt)
  {
    Object localObject;
    if (!this.jdField_a_of_type_Beey.a)
    {
      this.jdField_a_of_type_Beey.a = true;
      localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl();
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      localObject = Uri.parse((String)localObject);
      if ((localObject != null) && (((Uri)localObject).isHierarchical())) {
        this.jdField_a_of_type_Beey.b.setText(alpo.a(2131715075) + ((Uri)localObject).getHost() + alpo.a(2131715068));
      }
      this.jdField_a_of_type_Beey.b.setVisibility(0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        this.jdField_a_of_type_Beey.b.setVisibility(8);
      }
    }
    this.jdField_a_of_type_ComTencentBizUiRefreshView.onOverScroll(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beez
 * JD-Core Version:    0.7.0.1
 */