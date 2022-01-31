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

public class avqk
  extends avqc
{
  public avqk(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(avqj paramavqj)
  {
    return 3;
  }
  
  public View a(ViewGroup paramViewGroup, avqj paramavqj)
  {
    paramavqj = (avql)paramavqj;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561096, paramViewGroup, false);
    paramavqj.g = ((TextView)paramViewGroup.findViewById(2131379033));
    paramavqj.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368753));
    paramavqj.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368859));
    paramavqj.jdField_e_of_type_AndroidViewView = paramViewGroup.findViewById(2131366180);
    paramavqj.jdField_f_of_type_AndroidViewView = paramViewGroup.findViewById(2131366181);
    return paramViewGroup;
  }
  
  public avqj a()
  {
    return new avql(this);
  }
  
  public String b(avqj paramavqj)
  {
    return ((avsd)((avql)paramavqj).a).jdField_a_of_type_JavaLangString;
  }
  
  public void f(avqj paramavqj)
  {
    paramavqj = (avql)paramavqj;
    Object localObject1 = (avsd)paramavqj.a;
    label69:
    int j;
    if (((avsd)localObject1).c > 1)
    {
      paramavqj.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramavqj.jdField_f_of_type_AndroidViewView.setVisibility(0);
      paramavqj.g.setMovementMethod(LinkMovementMethod.getInstance());
      if (!TextUtils.isEmpty(((avsd)localObject1).n)) {
        break label307;
      }
      paramavqj.g.setVisibility(8);
      j = xsm.a(this.a, 200.0F);
      if ((((avsd)localObject1).jdField_a_of_type_Int <= 0) || (((avsd)localObject1).jdField_b_of_type_Int <= 0)) {
        break label414;
      }
    }
    label414:
    for (int i = ((avsd)localObject1).jdField_b_of_type_Int * j / ((avsd)localObject1).jdField_a_of_type_Int;; i = j)
    {
      if (i * 3 > j * 4) {
        i = j * 4 / 3;
      }
      for (;;)
      {
        for (;;)
        {
          Object localObject2;
          if (!TextUtils.equals((String)paramavqj.jdField_e_of_type_AndroidWidgetImageView.getTag(2131377450), ((avsd)localObject1).jdField_b_of_type_JavaLangString))
          {
            paramavqj.jdField_e_of_type_AndroidWidgetImageView.setTag(2131377450, ((avsd)localObject1).jdField_b_of_type_JavaLangString);
            localObject2 = (FrameLayout.LayoutParams)paramavqj.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
            if (localObject2 != null) {
              break label330;
            }
            localObject2 = new FrameLayout.LayoutParams(j, i);
            paramavqj.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          try
          {
            for (;;)
            {
              localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130845085);
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130845085);
              localObject1 = URLDrawable.getDrawable(((avsd)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
              ((URLDrawable)localObject1).setTag(bcyz.b(j, i, bdaq.a(this.a, 3.0F)));
              ((URLDrawable)localObject1).setDecodeHandler(bcyz.e);
              paramavqj.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
              return;
              paramavqj.jdField_e_of_type_AndroidViewView.setVisibility(8);
              paramavqj.jdField_f_of_type_AndroidViewView.setVisibility(8);
              break;
              label307:
              paramavqj.g.setVisibility(0);
              paramavqj.g.setText(((avsd)localObject1).n);
              break label69;
              label330:
              if ((((FrameLayout.LayoutParams)localObject2).width != j) || (((FrameLayout.LayoutParams)localObject2).height != i))
              {
                ((FrameLayout.LayoutParams)localObject2).width = j;
                ((FrameLayout.LayoutParams)localObject2).height = i;
                paramavqj.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              }
            }
          }
          catch (Exception localException)
          {
            do
            {
              paramavqj.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(this.a.getResources().getDrawable(2130845085));
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
 * Qualified Name:     avqk
 * JD-Core Version:    0.7.0.1
 */