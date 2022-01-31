import android.net.Uri;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnOverScrollHandler;

class bcfy
  implements TouchWebView.OnOverScrollHandler
{
  bcfy(bcfx parambcfx, TouchWebView paramTouchWebView, RefreshView paramRefreshView) {}
  
  public void onBack()
  {
    this.jdField_a_of_type_Bcfx.a = false;
    this.jdField_a_of_type_ComTencentBizUiRefreshView.onBack();
    this.jdField_a_of_type_Bcfx.b(true);
  }
  
  public void onOverScroll(int paramInt)
  {
    Object localObject;
    if (!this.jdField_a_of_type_Bcfx.a)
    {
      this.jdField_a_of_type_Bcfx.a = true;
      localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl();
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      localObject = Uri.parse((String)localObject);
      if ((localObject != null) && (((Uri)localObject).isHierarchical())) {
        this.jdField_a_of_type_Bcfx.b.setText(ajya.a(2131714703) + ((Uri)localObject).getHost() + ajya.a(2131714696));
      }
      this.jdField_a_of_type_Bcfx.b.setVisibility(0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        this.jdField_a_of_type_Bcfx.b.setVisibility(8);
      }
    }
    this.jdField_a_of_type_ComTencentBizUiRefreshView.onOverScroll(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcfy
 * JD-Core Version:    0.7.0.1
 */