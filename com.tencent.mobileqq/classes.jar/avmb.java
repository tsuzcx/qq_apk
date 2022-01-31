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

public class avmb
  extends avlt
{
  public avmb(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(avma paramavma)
  {
    return 3;
  }
  
  public View a(ViewGroup paramViewGroup, avma paramavma)
  {
    paramavma = (avmc)paramavma;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561078, paramViewGroup, false);
    paramavma.g = ((TextView)paramViewGroup.findViewById(2131378975));
    paramavma.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368739));
    paramavma.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368844));
    paramavma.jdField_e_of_type_AndroidViewView = paramViewGroup.findViewById(2131366178);
    paramavma.jdField_f_of_type_AndroidViewView = paramViewGroup.findViewById(2131366179);
    return paramViewGroup;
  }
  
  public avma a()
  {
    return new avmc(this);
  }
  
  public String b(avma paramavma)
  {
    return ((avnu)((avmc)paramavma).a).jdField_a_of_type_JavaLangString;
  }
  
  public void f(avma paramavma)
  {
    paramavma = (avmc)paramavma;
    Object localObject1 = (avnu)paramavma.a;
    label69:
    int j;
    if (((avnu)localObject1).c > 1)
    {
      paramavma.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramavma.jdField_f_of_type_AndroidViewView.setVisibility(0);
      paramavma.g.setMovementMethod(LinkMovementMethod.getInstance());
      if (!TextUtils.isEmpty(((avnu)localObject1).n)) {
        break label307;
      }
      paramavma.g.setVisibility(8);
      j = xod.a(this.a, 200.0F);
      if ((((avnu)localObject1).jdField_a_of_type_Int <= 0) || (((avnu)localObject1).jdField_b_of_type_Int <= 0)) {
        break label414;
      }
    }
    label414:
    for (int i = ((avnu)localObject1).jdField_b_of_type_Int * j / ((avnu)localObject1).jdField_a_of_type_Int;; i = j)
    {
      if (i * 3 > j * 4) {
        i = j * 4 / 3;
      }
      for (;;)
      {
        for (;;)
        {
          Object localObject2;
          if (!TextUtils.equals((String)paramavma.jdField_e_of_type_AndroidWidgetImageView.getTag(2131377396), ((avnu)localObject1).jdField_b_of_type_JavaLangString))
          {
            paramavma.jdField_e_of_type_AndroidWidgetImageView.setTag(2131377396, ((avnu)localObject1).jdField_b_of_type_JavaLangString);
            localObject2 = (FrameLayout.LayoutParams)paramavma.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
            if (localObject2 != null) {
              break label330;
            }
            localObject2 = new FrameLayout.LayoutParams(j, i);
            paramavma.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          try
          {
            for (;;)
            {
              localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130845013);
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130845013);
              localObject1 = URLDrawable.getDrawable(((avnu)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
              ((URLDrawable)localObject1).setTag(bcuq.b(j, i, bcwh.a(this.a, 3.0F)));
              ((URLDrawable)localObject1).setDecodeHandler(bcuq.e);
              paramavma.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
              return;
              paramavma.jdField_e_of_type_AndroidViewView.setVisibility(8);
              paramavma.jdField_f_of_type_AndroidViewView.setVisibility(8);
              break;
              label307:
              paramavma.g.setVisibility(0);
              paramavma.g.setText(((avnu)localObject1).n);
              break label69;
              label330:
              if ((((FrameLayout.LayoutParams)localObject2).width != j) || (((FrameLayout.LayoutParams)localObject2).height != i))
              {
                ((FrameLayout.LayoutParams)localObject2).width = j;
                ((FrameLayout.LayoutParams)localObject2).height = i;
                paramavma.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              }
            }
          }
          catch (Exception localException)
          {
            do
            {
              paramavma.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(this.a.getResources().getDrawable(2130845013));
            } while (!QLog.isColorLevel());
            QLog.i("BaseMomentItemBuilder", 1, localException.toString());
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avmb
 * JD-Core Version:    0.7.0.1
 */