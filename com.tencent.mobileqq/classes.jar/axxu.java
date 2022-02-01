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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class axxu
  extends axxm
{
  public axxu(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(axxt paramaxxt)
  {
    return 3;
  }
  
  public View a(ViewGroup paramViewGroup, axxt paramaxxt)
  {
    paramaxxt = (axxv)paramaxxt;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561307, paramViewGroup, false);
    paramaxxt.g = ((TextView)paramViewGroup.findViewById(2131379942));
    paramaxxt.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131369094));
    paramaxxt.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131369223));
    paramaxxt.jdField_e_of_type_AndroidViewView = paramViewGroup.findViewById(2131366434);
    paramaxxt.jdField_f_of_type_AndroidViewView = paramViewGroup.findViewById(2131366435);
    return paramViewGroup;
  }
  
  public axxt a()
  {
    return new axxv(this);
  }
  
  public String b(axxt paramaxxt)
  {
    return ((axzn)((axxv)paramaxxt).a).jdField_a_of_type_JavaLangString;
  }
  
  public void f(axxt paramaxxt)
  {
    paramaxxt = (axxv)paramaxxt;
    Object localObject1 = (axzn)paramaxxt.a;
    label69:
    int j;
    if (((axzn)localObject1).c > 1)
    {
      paramaxxt.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramaxxt.jdField_f_of_type_AndroidViewView.setVisibility(0);
      paramaxxt.g.setMovementMethod(LinkMovementMethod.getInstance());
      if (!TextUtils.isEmpty(((axzn)localObject1).n)) {
        break label307;
      }
      paramaxxt.g.setVisibility(8);
      j = zlx.a(this.a, 200.0F);
      if ((((axzn)localObject1).jdField_a_of_type_Int <= 0) || (((axzn)localObject1).jdField_b_of_type_Int <= 0)) {
        break label414;
      }
    }
    label414:
    for (int i = ((axzn)localObject1).jdField_b_of_type_Int * j / ((axzn)localObject1).jdField_a_of_type_Int;; i = j)
    {
      if (i * 3 > j * 4) {
        i = j * 4 / 3;
      }
      for (;;)
      {
        for (;;)
        {
          Object localObject2;
          if (!TextUtils.equals((String)paramaxxt.jdField_e_of_type_AndroidWidgetImageView.getTag(2131378283), ((axzn)localObject1).jdField_b_of_type_JavaLangString))
          {
            paramaxxt.jdField_e_of_type_AndroidWidgetImageView.setTag(2131378283, ((axzn)localObject1).jdField_b_of_type_JavaLangString);
            localObject2 = (FrameLayout.LayoutParams)paramaxxt.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
            if (localObject2 != null) {
              break label330;
            }
            localObject2 = new FrameLayout.LayoutParams(j, i);
            paramaxxt.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          try
          {
            for (;;)
            {
              localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130845481);
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130845481);
              localObject1 = URLDrawable.getDrawable(((axzn)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
              ((URLDrawable)localObject1).setTag(bgey.b(j, i, bggq.a(this.a, 3.0F)));
              ((URLDrawable)localObject1).setDecodeHandler(bgey.e);
              paramaxxt.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
              return;
              paramaxxt.jdField_e_of_type_AndroidViewView.setVisibility(8);
              paramaxxt.jdField_f_of_type_AndroidViewView.setVisibility(8);
              break;
              label307:
              paramaxxt.g.setVisibility(0);
              paramaxxt.g.setText(((axzn)localObject1).n);
              break label69;
              label330:
              if ((((FrameLayout.LayoutParams)localObject2).width != j) || (((FrameLayout.LayoutParams)localObject2).height != i))
              {
                ((FrameLayout.LayoutParams)localObject2).width = j;
                ((FrameLayout.LayoutParams)localObject2).height = i;
                paramaxxt.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              }
            }
          }
          catch (Exception localException)
          {
            do
            {
              paramaxxt.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(this.a.getResources().getDrawable(2130845481));
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
 * Qualified Name:     axxu
 * JD-Core Version:    0.7.0.1
 */