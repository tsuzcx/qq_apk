import android.net.Uri;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnOverScrollHandler;

class birh
  implements TouchWebView.OnOverScrollHandler
{
  birh(birg parambirg, TouchWebView paramTouchWebView, RefreshView paramRefreshView) {}
  
  public void onBack()
  {
    this.jdField_a_of_type_Birg.a = false;
    this.jdField_a_of_type_ComTencentBizUiRefreshView.onBack();
    this.jdField_a_of_type_Birg.b(true);
  }
  
  public void onOverScroll(int paramInt)
  {
    Object localObject;
    if (!this.jdField_a_of_type_Birg.a)
    {
      this.jdField_a_of_type_Birg.a = true;
      localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl();
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      localObject = Uri.parse((String)localObject);
      if ((localObject != null) && (((Uri)localObject).isHierarchical())) {
        this.jdField_a_of_type_Birg.b.setText(anzj.a(2131713497) + ((Uri)localObject).getHost() + anzj.a(2131713490));
      }
      this.jdField_a_of_type_Birg.b.setVisibility(0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        this.jdField_a_of_type_Birg.b.setVisibility(8);
      }
    }
    this.jdField_a_of_type_ComTencentBizUiRefreshView.onOverScroll(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     birh
 * JD-Core Version:    0.7.0.1
 */