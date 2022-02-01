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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.SougouSearchInfo;
import com.tencent.qphone.base.util.QLog;

public class ayuv
  extends ayup
{
  public static final Paint a;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, ayul paramayul, ayun paramayun)
  {
    Context localContext = paramViewGroup.getContext();
    OCRTextSearchInfo.SougouSearchInfo localSougouSearchInfo = (OCRTextSearchInfo.SougouSearchInfo)paramayun.jdField_a_of_type_JavaLangObject;
    paramInt = 1;
    if (paramView != null)
    {
      paramayul = (ayun)paramView.getTag();
      if ((paramayul.jdField_a_of_type_Int == paramayun.jdField_a_of_type_Int) && (paramayul.b == paramayun.b))
      {
        paramayul = (ayux)paramView.getTag(-1);
        paramInt = 0;
      }
    }
    for (;;)
    {
      Object localObject;
      if (paramInt == 0)
      {
        localObject = paramayul;
        if (paramayul != null) {}
      }
      else
      {
        localObject = new ayux(this);
        paramView = (ViewGroup)LayoutInflater.from(localContext).inflate(2131561318, paramViewGroup, false);
        ((ayux)localObject).jdField_a_of_type_AndroidViewViewGroup = paramView;
        ((ayux)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379001));
        ((ayux)localObject).b = ((TextView)paramView.findViewById(2131361815));
        ((ayux)localObject).c = ((TextView)paramView.findViewById(2131377902));
        ((ayux)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368501));
        paramView.setTag(-1, localObject);
      }
      a((ayux)localObject, localSougouSearchInfo);
      paramView.setTag(paramayun);
      return paramView;
      paramayul = null;
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  void a(ayux paramayux, OCRTextSearchInfo.SougouSearchInfo paramSougouSearchInfo)
  {
    Object localObject = new ayue(paramSougouSearchInfo.titleKeyWords, null);
    if (!TextUtils.isEmpty(paramSougouSearchInfo.title))
    {
      localObject = ((ayue)localObject).a(paramSougouSearchInfo.title, true);
      if (localObject != null) {
        paramayux.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
    }
    localObject = new ayue(paramSougouSearchInfo.abstractStrKeyWords, null);
    if (!TextUtils.isEmpty(paramSougouSearchInfo.abstractStr))
    {
      localObject = ((ayue)localObject).a(ayue.a(paramSougouSearchInfo.abstractStr));
      paramayux.b.setText((CharSequence)localObject);
    }
    try
    {
      if (TextUtils.isEmpty(paramSougouSearchInfo.summaryPic)) {
        paramayux.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramSougouSearchInfo.sourceFrom)) {
          break label310;
        }
        paramayux.c.setVisibility(8);
        return;
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.dp2px(80.0F, BaseApplicationImpl.sApplication.getResources());
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.dp2px(60.0F, BaseApplicationImpl.sApplication.getResources());
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localObject = URLDrawable.getDrawable(paramSougouSearchInfo.summaryPic, (URLDrawable.URLDrawableOptions)localObject);
        if ((localObject == null) || (((URLDrawable)localObject).getStatus() != 2)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.ocr.SearchSougouResultItemBuilder", 2, "updateNormalItem image fail," + paramSougouSearchInfo);
        }
        paramayux.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramayux.jdField_a_of_type_AndroidWidgetImageView.setTag(paramSougouSearchInfo.summaryPic);
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
        paramayux.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (localException != null) {
          localException.setURLDrawableListener(new ayuw(this));
        }
        paramayux.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localException);
      }
      label310:
      paramayux.c.setVisibility(0);
      paramayux.c.setText(paramSougouSearchInfo.sourceFrom);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayuv
 * JD-Core Version:    0.7.0.1
 */