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

public class audg
  extends auda
{
  public static final Paint a;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, aucw paramaucw, aucy paramaucy)
  {
    Context localContext = paramViewGroup.getContext();
    OCRTextSearchInfo.SougouSearchInfo localSougouSearchInfo = (OCRTextSearchInfo.SougouSearchInfo)paramaucy.jdField_a_of_type_JavaLangObject;
    paramInt = 1;
    if (paramView != null)
    {
      paramaucw = (aucy)paramView.getTag();
      if ((paramaucw.jdField_a_of_type_Int == paramaucy.jdField_a_of_type_Int) && (paramaucw.b == paramaucy.b))
      {
        paramaucw = (audi)paramView.getTag(-1);
        paramInt = 0;
      }
    }
    for (;;)
    {
      Object localObject;
      if (paramInt == 0)
      {
        localObject = paramaucw;
        if (paramaucw != null) {}
      }
      else
      {
        localObject = new audi(this);
        paramView = (ViewGroup)LayoutInflater.from(localContext).inflate(2131560931, paramViewGroup, false);
        ((audi)localObject).jdField_a_of_type_AndroidViewViewGroup = paramView;
        ((audi)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377350));
        ((audi)localObject).b = ((TextView)paramView.findViewById(2131361812));
        ((audi)localObject).c = ((TextView)paramView.findViewById(2131376338));
        ((audi)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367776));
        paramView.setTag(-1, localObject);
      }
      a((audi)localObject, localSougouSearchInfo);
      paramView.setTag(paramaucy);
      return paramView;
      paramaucw = null;
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  void a(audi paramaudi, OCRTextSearchInfo.SougouSearchInfo paramSougouSearchInfo)
  {
    Object localObject = new aucp(paramSougouSearchInfo.titleKeyWords, null);
    if (!TextUtils.isEmpty(paramSougouSearchInfo.title))
    {
      localObject = ((aucp)localObject).a(paramSougouSearchInfo.title, true);
      if (localObject != null) {
        paramaudi.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
    }
    localObject = new aucp(paramSougouSearchInfo.abstractStrKeyWords, null);
    if (!TextUtils.isEmpty(paramSougouSearchInfo.abstractStr))
    {
      localObject = ((aucp)localObject).a(aucp.a(paramSougouSearchInfo.abstractStr));
      paramaudi.b.setText((CharSequence)localObject);
    }
    try
    {
      if (TextUtils.isEmpty(paramSougouSearchInfo.summaryPic)) {
        paramaudi.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramSougouSearchInfo.sourceFrom)) {
          break label306;
        }
        paramaudi.c.setVisibility(8);
        return;
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = actj.a(80.0F, BaseApplicationImpl.sApplication.getResources());
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = actj.a(60.0F, BaseApplicationImpl.sApplication.getResources());
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localObject = URLDrawable.getDrawable(paramSougouSearchInfo.summaryPic, (URLDrawable.URLDrawableOptions)localObject);
        if ((localObject == null) || (((URLDrawable)localObject).getStatus() != 2)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.ocr.SearchSougouResultItemBuilder", 2, "updateNormalItem image fail," + paramSougouSearchInfo);
        }
        paramaudi.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramaudi.jdField_a_of_type_AndroidWidgetImageView.setTag(paramSougouSearchInfo.summaryPic);
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
        paramaudi.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localException.setURLDrawableListener(new audh(this));
        paramaudi.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localException);
      }
      label306:
      paramaudi.c.setVisibility(0);
      paramaudi.c.setText(paramSougouSearchInfo.sourceFrom);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audg
 * JD-Core Version:    0.7.0.1
 */