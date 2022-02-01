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

public class ayqo
  extends ayqg
{
  public ayqo(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(ayqn paramayqn)
  {
    return 3;
  }
  
  public View a(ViewGroup paramViewGroup, ayqn paramayqn)
  {
    paramayqn = (ayqp)paramayqn;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561345, paramViewGroup, false);
    paramayqn.g = ((TextView)paramViewGroup.findViewById(2131380126));
    paramayqn.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131369184));
    paramayqn.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131369314));
    paramayqn.jdField_e_of_type_AndroidViewView = paramViewGroup.findViewById(2131366483);
    paramayqn.jdField_f_of_type_AndroidViewView = paramViewGroup.findViewById(2131366484);
    return paramViewGroup;
  }
  
  public ayqn a()
  {
    return new ayqp(this);
  }
  
  public String b(ayqn paramayqn)
  {
    return ((aysh)((ayqp)paramayqn).a).jdField_a_of_type_JavaLangString;
  }
  
  public void f(ayqn paramayqn)
  {
    paramayqn = (ayqp)paramayqn;
    Object localObject1 = (aysh)paramayqn.a;
    label69:
    int j;
    if (((aysh)localObject1).c > 1)
    {
      paramayqn.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramayqn.jdField_f_of_type_AndroidViewView.setVisibility(0);
      paramayqn.g.setMovementMethod(LinkMovementMethod.getInstance());
      if (!TextUtils.isEmpty(((aysh)localObject1).n)) {
        break label307;
      }
      paramayqn.g.setVisibility(8);
      j = zps.a(this.a, 200.0F);
      if ((((aysh)localObject1).jdField_a_of_type_Int <= 0) || (((aysh)localObject1).jdField_b_of_type_Int <= 0)) {
        break label414;
      }
    }
    label414:
    for (int i = ((aysh)localObject1).jdField_b_of_type_Int * j / ((aysh)localObject1).jdField_a_of_type_Int;; i = j)
    {
      if (i * 3 > j * 4) {
        i = j * 4 / 3;
      }
      for (;;)
      {
        for (;;)
        {
          Object localObject2;
          if (!TextUtils.equals((String)paramayqn.jdField_e_of_type_AndroidWidgetImageView.getTag(2131378440), ((aysh)localObject1).jdField_b_of_type_JavaLangString))
          {
            paramayqn.jdField_e_of_type_AndroidWidgetImageView.setTag(2131378440, ((aysh)localObject1).jdField_b_of_type_JavaLangString);
            localObject2 = (FrameLayout.LayoutParams)paramayqn.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
            if (localObject2 != null) {
              break label330;
            }
            localObject2 = new FrameLayout.LayoutParams(j, i);
            paramayqn.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          try
          {
            for (;;)
            {
              localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130845496);
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130845496);
              localObject1 = URLDrawable.getDrawable(((aysh)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
              ((URLDrawable)localObject1).setTag(bhez.b(j, i, bhgr.a(this.a, 3.0F)));
              ((URLDrawable)localObject1).setDecodeHandler(bhez.e);
              paramayqn.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
              return;
              paramayqn.jdField_e_of_type_AndroidViewView.setVisibility(8);
              paramayqn.jdField_f_of_type_AndroidViewView.setVisibility(8);
              break;
              label307:
              paramayqn.g.setVisibility(0);
              paramayqn.g.setText(((aysh)localObject1).n);
              break label69;
              label330:
              if ((((FrameLayout.LayoutParams)localObject2).width != j) || (((FrameLayout.LayoutParams)localObject2).height != i))
              {
                ((FrameLayout.LayoutParams)localObject2).width = j;
                ((FrameLayout.LayoutParams)localObject2).height = i;
                paramayqn.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              }
            }
          }
          catch (Exception localException)
          {
            do
            {
              paramayqn.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(this.a.getResources().getDrawable(2130845496));
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
 * Qualified Name:     ayqo
 * JD-Core Version:    0.7.0.1
 */