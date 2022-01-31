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

public class avuk
  extends avue
{
  public static final Paint a;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, avua paramavua, avuc paramavuc)
  {
    Context localContext = paramViewGroup.getContext();
    OCRTextSearchInfo.SougouSearchInfo localSougouSearchInfo = (OCRTextSearchInfo.SougouSearchInfo)paramavuc.jdField_a_of_type_JavaLangObject;
    paramInt = 1;
    if (paramView != null)
    {
      paramavua = (avuc)paramView.getTag();
      if ((paramavua.jdField_a_of_type_Int == paramavuc.jdField_a_of_type_Int) && (paramavua.b == paramavuc.b))
      {
        paramavua = (avum)paramView.getTag(-1);
        paramInt = 0;
      }
    }
    for (;;)
    {
      Object localObject;
      if (paramInt == 0)
      {
        localObject = paramavua;
        if (paramavua != null) {}
      }
      else
      {
        localObject = new avum(this);
        paramView = (ViewGroup)LayoutInflater.from(localContext).inflate(2131561114, paramViewGroup, false);
        ((avum)localObject).jdField_a_of_type_AndroidViewViewGroup = paramView;
        ((avum)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377884));
        ((avum)localObject).b = ((TextView)paramView.findViewById(2131361812));
        ((avum)localObject).c = ((TextView)paramView.findViewById(2131376842));
        ((avum)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367910));
        paramView.setTag(-1, localObject);
      }
      a((avum)localObject, localSougouSearchInfo);
      paramView.setTag(paramavuc);
      return paramView;
      paramavua = null;
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  void a(avum paramavum, OCRTextSearchInfo.SougouSearchInfo paramSougouSearchInfo)
  {
    Object localObject = new avtt(paramSougouSearchInfo.titleKeyWords, null);
    if (!TextUtils.isEmpty(paramSougouSearchInfo.title))
    {
      localObject = ((avtt)localObject).a(paramSougouSearchInfo.title, true);
      if (localObject != null) {
        paramavum.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
    }
    localObject = new avtt(paramSougouSearchInfo.abstractStrKeyWords, null);
    if (!TextUtils.isEmpty(paramSougouSearchInfo.abstractStr))
    {
      localObject = ((avtt)localObject).a(avtt.a(paramSougouSearchInfo.abstractStr));
      paramavum.b.setText((CharSequence)localObject);
    }
    try
    {
      if (TextUtils.isEmpty(paramSougouSearchInfo.summaryPic)) {
        paramavum.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramSougouSearchInfo.sourceFrom)) {
          break label306;
        }
        paramavum.c.setVisibility(8);
        return;
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = aekt.a(80.0F, BaseApplicationImpl.sApplication.getResources());
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = aekt.a(60.0F, BaseApplicationImpl.sApplication.getResources());
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localObject = URLDrawable.getDrawable(paramSougouSearchInfo.summaryPic, (URLDrawable.URLDrawableOptions)localObject);
        if ((localObject == null) || (((URLDrawable)localObject).getStatus() != 2)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.ocr.SearchSougouResultItemBuilder", 2, "updateNormalItem image fail," + paramSougouSearchInfo);
        }
        paramavum.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramavum.jdField_a_of_type_AndroidWidgetImageView.setTag(paramSougouSearchInfo.summaryPic);
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
        paramavum.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localException.setURLDrawableListener(new avul(this));
        paramavum.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localException);
      }
      label306:
      paramavum.c.setVisibility(0);
      paramavum.c.setText(paramSougouSearchInfo.sourceFrom);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avuk
 * JD-Core Version:    0.7.0.1
 */