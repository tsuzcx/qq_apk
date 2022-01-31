import android.net.Uri;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnOverScrollHandler;

class bbck
  implements TouchWebView.OnOverScrollHandler
{
  bbck(bbcj parambbcj, TouchWebView paramTouchWebView, RefreshView paramRefreshView) {}
  
  public void onBack()
  {
    this.jdField_a_of_type_Bbcj.a = false;
    this.jdField_a_of_type_ComTencentBizUiRefreshView.onBack();
    this.jdField_a_of_type_Bbcj.b(true);
  }
  
  public void onOverScroll(int paramInt)
  {
    Object localObject;
    if (!this.jdField_a_of_type_Bbcj.a)
    {
      this.jdField_a_of_type_Bbcj.a = true;
      localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl();
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      localObject = Uri.parse((String)localObject);
      if ((localObject != null) && (((Uri)localObject).isHierarchical())) {
        this.jdField_a_of_type_Bbcj.b.setText(ajjy.a(2131648903) + ((Uri)localObject).getHost() + ajjy.a(2131648896));
      }
      this.jdField_a_of_type_Bbcj.b.setVisibility(0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        this.jdField_a_of_type_Bbcj.b.setVisibility(8);
      }
    }
    this.jdField_a_of_type_ComTencentBizUiRefreshView.onOverScroll(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bbck
 * JD-Core Version:    0.7.0.1
 */