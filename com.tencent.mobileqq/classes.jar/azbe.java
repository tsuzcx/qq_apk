import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.SougouSearchInfo;
import com.tencent.qphone.base.util.QLog;

public class azbe
  extends azay
{
  public static final Paint a;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, azau paramazau, azaw paramazaw)
  {
    Context localContext = paramViewGroup.getContext();
    OCRTextSearchInfo.SougouSearchInfo localSougouSearchInfo = (OCRTextSearchInfo.SougouSearchInfo)paramazaw.jdField_a_of_type_JavaLangObject;
    paramInt = 1;
    if (paramView != null)
    {
      paramazau = (azaw)paramView.getTag();
      if ((paramazau.jdField_a_of_type_Int == paramazaw.jdField_a_of_type_Int) && (paramazau.b == paramazaw.b))
      {
        paramazau = (azbg)paramView.getTag(-1);
        paramInt = 0;
      }
    }
    for (;;)
    {
      Object localObject;
      if (paramInt == 0)
      {
        localObject = paramazau;
        if (paramazau != null) {}
      }
      else
      {
        localObject = new azbg(this);
        paramView = (ViewGroup)LayoutInflater.from(localContext).inflate(2131561382, paramViewGroup, false);
        ((azbg)localObject).jdField_a_of_type_AndroidViewViewGroup = paramView;
        ((azbg)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378936));
        ((azbg)localObject).b = ((TextView)paramView.findViewById(2131361813));
        ((azbg)localObject).c = ((TextView)paramView.findViewById(2131377858));
        ((azbg)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368320));
        paramView.setTag(-1, localObject);
      }
      a((azbg)localObject, localSougouSearchInfo);
      paramView.setTag(paramazaw);
      return paramView;
      paramazau = null;
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  void a(azbg paramazbg, OCRTextSearchInfo.SougouSearchInfo paramSougouSearchInfo)
  {
    Object localObject = new azan(paramSougouSearchInfo.titleKeyWords, null);
    if (!TextUtils.isEmpty(paramSougouSearchInfo.title))
    {
      localObject = ((azan)localObject).a(paramSougouSearchInfo.title, true);
      if (localObject != null) {
        paramazbg.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
    }
    localObject = new azan(paramSougouSearchInfo.abstractStrKeyWords, null);
    if (!TextUtils.isEmpty(paramSougouSearchInfo.abstractStr))
    {
      localObject = ((azan)localObject).a(azan.a(paramSougouSearchInfo.abstractStr));
      paramazbg.b.setText((CharSequence)localObject);
    }
    try
    {
      if (TextUtils.isEmpty(paramSougouSearchInfo.summaryPic)) {
        paramazbg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramSougouSearchInfo.sourceFrom)) {
          break label306;
        }
        paramazbg.c.setVisibility(8);
        return;
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = agej.a(80.0F, BaseApplicationImpl.sApplication.getResources());
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = agej.a(60.0F, BaseApplicationImpl.sApplication.getResources());
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localObject = URLDrawable.getDrawable(paramSougouSearchInfo.summaryPic, (URLDrawable.URLDrawableOptions)localObject);
        if ((localObject == null) || (((URLDrawable)localObject).getStatus() != 2)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.ocr.SearchSougouResultItemBuilder", 2, "updateNormalItem image fail," + paramSougouSearchInfo);
        }
        paramazbg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramazbg.jdField_a_of_type_AndroidWidgetImageView.setTag(paramSougouSearchInfo.summaryPic);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.ocr.SearchSougouResultItemBuilder", 2, "updateNormalItem", localException);
        }
        localException.printStackTrace();
        continue;
        paramazbg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localException.setURLDrawableListener(new azbf(this));
        paramazbg.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localException);
      }
      label306:
      paramazbg.c.setVisibility(0);
      paramazbg.c.setText(paramSougouSearchInfo.sourceFrom);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azbe
 * JD-Core Version:    0.7.0.1
 */