import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;

public class axdw
  extends axdo
{
  public axdw(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(axdv paramaxdv)
  {
    return 3;
  }
  
  public View a(ViewGroup paramViewGroup, axdv paramaxdv)
  {
    paramaxdv = (axdx)paramaxdv;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561220, paramViewGroup, false);
    paramaxdv.g = ((TextView)paramViewGroup.findViewById(2131379865));
    paramaxdv.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131369207));
    paramaxdv.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131369324));
    paramaxdv.jdField_e_of_type_AndroidViewView = paramViewGroup.findViewById(2131366510);
    paramaxdv.jdField_f_of_type_AndroidViewView = paramViewGroup.findViewById(2131366511);
    return paramViewGroup;
  }
  
  public axdv a()
  {
    return new axdx(this);
  }
  
  public String b(axdv paramaxdv)
  {
    return ((axfp)((axdx)paramaxdv).a).jdField_a_of_type_JavaLangString;
  }
  
  public void f(axdv paramaxdv)
  {
    paramaxdv = (axdx)paramaxdv;
    Object localObject1 = (axfp)paramaxdv.a;
    label69:
    int j;
    if (((axfp)localObject1).c > 1)
    {
      paramaxdv.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramaxdv.jdField_f_of_type_AndroidViewView.setVisibility(0);
      paramaxdv.g.setMovementMethod(LinkMovementMethod.getInstance());
      if (!TextUtils.isEmpty(((axfp)localObject1).n)) {
        break label307;
      }
      paramaxdv.g.setVisibility(8);
      j = UIUtils.dip2px(this.a, 200.0F);
      if ((((axfp)localObject1).jdField_a_of_type_Int <= 0) || (((axfp)localObject1).jdField_b_of_type_Int <= 0)) {
        break label414;
      }
    }
    label414:
    for (int i = ((axfp)localObject1).jdField_b_of_type_Int * j / ((axfp)localObject1).jdField_a_of_type_Int;; i = j)
    {
      if (i * 3 > j * 4) {
        i = j * 4 / 3;
      }
      for (;;)
      {
        for (;;)
        {
          Object localObject2;
          if (!TextUtils.equals((String)paramaxdv.jdField_e_of_type_AndroidWidgetImageView.getTag(2131378207), ((axfp)localObject1).jdField_b_of_type_JavaLangString))
          {
            paramaxdv.jdField_e_of_type_AndroidWidgetImageView.setTag(2131378207, ((axfp)localObject1).jdField_b_of_type_JavaLangString);
            localObject2 = (FrameLayout.LayoutParams)paramaxdv.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
            if (localObject2 != null) {
              break label330;
            }
            localObject2 = new FrameLayout.LayoutParams(j, i);
            paramaxdv.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          try
          {
            for (;;)
            {
              localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130845375);
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130845375);
              localObject1 = URLDrawable.getDrawable(((axfp)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
              ((URLDrawable)localObject1).setTag(bfol.b(j, i, DisplayUtil.dip2px(this.a, 3.0F)));
              ((URLDrawable)localObject1).setDecodeHandler(bfol.e);
              paramaxdv.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
              return;
              paramaxdv.jdField_e_of_type_AndroidViewView.setVisibility(8);
              paramaxdv.jdField_f_of_type_AndroidViewView.setVisibility(8);
              break;
              label307:
              paramaxdv.g.setVisibility(0);
              paramaxdv.g.setText(((axfp)localObject1).n);
              break label69;
              label330:
              if ((((FrameLayout.LayoutParams)localObject2).width != j) || (((FrameLayout.LayoutParams)localObject2).height != i))
              {
                ((FrameLayout.LayoutParams)localObject2).width = j;
                ((FrameLayout.LayoutParams)localObject2).height = i;
                paramaxdv.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              }
            }
          }
          catch (Exception localException)
          {
            do
            {
              paramaxdv.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(this.a.getResources().getDrawable(2130845375));
            } while (!QLog.isColorLevel());
            QLog.i("BaseMomentItemBuilder", 1, localException.toString());
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axdw
 * JD-Core Version:    0.7.0.1
 */