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

public class atgd
  extends atfx
{
  public static final Paint a;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, atft paramatft, atfv paramatfv)
  {
    Context localContext = paramViewGroup.getContext();
    OCRTextSearchInfo.SougouSearchInfo localSougouSearchInfo = (OCRTextSearchInfo.SougouSearchInfo)paramatfv.jdField_a_of_type_JavaLangObject;
    paramInt = 1;
    if (paramView != null)
    {
      paramatft = (atfv)paramView.getTag();
      if ((paramatft.jdField_a_of_type_Int == paramatfv.jdField_a_of_type_Int) && (paramatft.b == paramatfv.b))
      {
        paramatft = (atgf)paramView.getTag(-1);
        paramInt = 0;
      }
    }
    for (;;)
    {
      Object localObject;
      if (paramInt == 0)
      {
        localObject = paramatft;
        if (paramatft != null) {}
      }
      else
      {
        localObject = new atgf(this);
        paramView = (ViewGroup)LayoutInflater.from(localContext).inflate(2131495352, paramViewGroup, false);
        ((atgf)localObject).jdField_a_of_type_AndroidViewViewGroup = paramView;
        ((atgf)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131311534));
        ((atgf)localObject).b = ((TextView)paramView.findViewById(2131296277));
        ((atgf)localObject).c = ((TextView)paramView.findViewById(2131310544));
        ((atgf)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302158));
        paramView.setTag(-1, localObject);
      }
      a((atgf)localObject, localSougouSearchInfo);
      paramView.setTag(paramatfv);
      return paramView;
      paramatft = null;
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  void a(atgf paramatgf, OCRTextSearchInfo.SougouSearchInfo paramSougouSearchInfo)
  {
    Object localObject = new atfm(paramSougouSearchInfo.titleKeyWords, null);
    if (!TextUtils.isEmpty(paramSougouSearchInfo.title))
    {
      localObject = ((atfm)localObject).a(paramSougouSearchInfo.title, true);
      if (localObject != null) {
        paramatgf.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
    }
    localObject = new atfm(paramSougouSearchInfo.abstractStrKeyWords, null);
    if (!TextUtils.isEmpty(paramSougouSearchInfo.abstractStr))
    {
      localObject = ((atfm)localObject).a(atfm.a(paramSougouSearchInfo.abstractStr));
      paramatgf.b.setText((CharSequence)localObject);
    }
    try
    {
      if (TextUtils.isEmpty(paramSougouSearchInfo.summaryPic)) {
        paramatgf.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramSougouSearchInfo.sourceFrom)) {
          break label306;
        }
        paramatgf.c.setVisibility(8);
        return;
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = aciy.a(80.0F, BaseApplicationImpl.sApplication.getResources());
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = aciy.a(60.0F, BaseApplicationImpl.sApplication.getResources());
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localObject = URLDrawable.getDrawable(paramSougouSearchInfo.summaryPic, (URLDrawable.URLDrawableOptions)localObject);
        if ((localObject == null) || (((URLDrawable)localObject).getStatus() != 2)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.ocr.SearchSougouResultItemBuilder", 2, "updateNormalItem image fail," + paramSougouSearchInfo);
        }
        paramatgf.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramatgf.jdField_a_of_type_AndroidWidgetImageView.setTag(paramSougouSearchInfo.summaryPic);
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
        paramatgf.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localException.setURLDrawableListener(new atge(this));
        paramatgf.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localException);
      }
      label306:
      paramatgf.c.setVisibility(0);
      paramatgf.c.setText(paramSougouSearchInfo.sourceFrom);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atgd
 * JD-Core Version:    0.7.0.1
 */