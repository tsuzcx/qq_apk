import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.vip.diy.TemplateLikeView;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bebb
  extends bkfr
{
  private String a;
  
  public bebb(String paramString1, View paramView, String paramString2)
  {
    super(paramString1, paramView);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramString2;
    ((TemplateLikeView)paramView).a(1);
  }
  
  protected ViewGroup.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams, JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Int = -2;
    this.b = a(paramJSONObject.optString("height"));
    paramLayoutParams.width = -2;
    paramLayoutParams.height = -2;
    int i = xsm.a(this.jdField_a_of_type_AndroidViewView.getContext(), paramJSONObject.optInt("lpd", 2) / 2);
    int j = xsm.a(this.jdField_a_of_type_AndroidViewView.getContext(), paramJSONObject.optInt("rpd", 2) / 2);
    ((TemplateLikeView)this.jdField_a_of_type_AndroidViewView).setContainerLayoutParams(this.jdField_a_of_type_Int, this.b, i, j);
    return paramLayoutParams;
  }
  
  protected URLDrawable a(String paramString, DownloadParams.DecodeHandler paramDecodeHandler)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = paramString;
    if (!paramString.startsWith("http"))
    {
      str = paramString;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        if (!this.jdField_a_of_type_JavaLangString.startsWith("http")) {
          break label114;
        }
      }
    }
    for (str = this.jdField_a_of_type_JavaLangString + paramString;; str = paramString)
    {
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mLoadingDrawable = bayu.a;
      paramString.mFailedDrawable = bayu.a;
      paramString.mPlayGifImage = false;
      if (paramDecodeHandler != null) {
        paramString.mMemoryCacheKeySuffix = paramDecodeHandler.toString();
      }
      paramString = URLDrawable.getDrawable(str, paramString);
      paramString.setDecodeHandler(paramDecodeHandler);
      return paramString;
      label114:
      QLog.e("JsonInflateViewModel", 1, "it have the illegal url prefix=" + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if ("bg".equals(paramString1)) {
      if ((this.jdField_a_of_type_AndroidViewView instanceof TemplateLikeView)) {
        ((TemplateLikeView)this.jdField_a_of_type_AndroidViewView).setVoteContainerBackground(a(paramString2, null));
      }
    }
    do
    {
      return;
      if (!"style".equals(paramString1)) {
        break;
      }
    } while (!(this.jdField_a_of_type_AndroidViewView instanceof TemplateLikeView));
    paramString1 = (TemplateLikeView)this.jdField_a_of_type_AndroidViewView;
    if ("1".equals(paramString2)) {}
    for (int i = 0;; i = 1)
    {
      paramString1.a(i);
      return;
    }
    super.a(paramString1, paramString2);
  }
  
  public void c()
  {
    super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebb
 * JD-Core Version:    0.7.0.1
 */