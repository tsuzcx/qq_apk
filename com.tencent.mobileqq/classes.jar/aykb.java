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

public class aykb
  extends ayjt
{
  public aykb(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(ayka paramayka)
  {
    return 3;
  }
  
  public View a(ViewGroup paramViewGroup, ayka paramayka)
  {
    paramayka = (aykc)paramayka;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561281, paramViewGroup, false);
    paramayka.g = ((TextView)paramViewGroup.findViewById(2131380198));
    paramayka.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131369370));
    paramayka.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131369491));
    paramayka.jdField_e_of_type_AndroidViewView = paramViewGroup.findViewById(2131366619);
    paramayka.jdField_f_of_type_AndroidViewView = paramViewGroup.findViewById(2131366620);
    return paramViewGroup;
  }
  
  public ayka a()
  {
    return new aykc(this);
  }
  
  public String b(ayka paramayka)
  {
    return ((aylu)((aykc)paramayka).a).jdField_a_of_type_JavaLangString;
  }
  
  public void f(ayka paramayka)
  {
    paramayka = (aykc)paramayka;
    Object localObject1 = (aylu)paramayka.a;
    label69:
    int j;
    if (((aylu)localObject1).c > 1)
    {
      paramayka.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramayka.jdField_f_of_type_AndroidViewView.setVisibility(0);
      paramayka.g.setMovementMethod(LinkMovementMethod.getInstance());
      if (!TextUtils.isEmpty(((aylu)localObject1).n)) {
        break label307;
      }
      paramayka.g.setVisibility(8);
      j = UIUtils.dip2px(this.a, 200.0F);
      if ((((aylu)localObject1).jdField_a_of_type_Int <= 0) || (((aylu)localObject1).jdField_b_of_type_Int <= 0)) {
        break label414;
      }
    }
    label414:
    for (int i = ((aylu)localObject1).jdField_b_of_type_Int * j / ((aylu)localObject1).jdField_a_of_type_Int;; i = j)
    {
      if (i * 3 > j * 4) {
        i = j * 4 / 3;
      }
      for (;;)
      {
        for (;;)
        {
          Object localObject2;
          if (!TextUtils.equals((String)paramayka.jdField_e_of_type_AndroidWidgetImageView.getTag(2131378495), ((aylu)localObject1).jdField_b_of_type_JavaLangString))
          {
            paramayka.jdField_e_of_type_AndroidWidgetImageView.setTag(2131378495, ((aylu)localObject1).jdField_b_of_type_JavaLangString);
            localObject2 = (FrameLayout.LayoutParams)paramayka.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
            if (localObject2 != null) {
              break label330;
            }
            localObject2 = new FrameLayout.LayoutParams(j, i);
            paramayka.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          try
          {
            for (;;)
            {
              localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130845460);
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130845460);
              localObject1 = URLDrawable.getDrawable(((aylu)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
              ((URLDrawable)localObject1).setTag(bgxc.b(j, i, DisplayUtil.dip2px(this.a, 3.0F)));
              ((URLDrawable)localObject1).setDecodeHandler(bgxc.e);
              paramayka.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
              return;
              paramayka.jdField_e_of_type_AndroidViewView.setVisibility(8);
              paramayka.jdField_f_of_type_AndroidViewView.setVisibility(8);
              break;
              label307:
              paramayka.g.setVisibility(0);
              paramayka.g.setText(((aylu)localObject1).n);
              break label69;
              label330:
              if ((((FrameLayout.LayoutParams)localObject2).width != j) || (((FrameLayout.LayoutParams)localObject2).height != i))
              {
                ((FrameLayout.LayoutParams)localObject2).width = j;
                ((FrameLayout.LayoutParams)localObject2).height = i;
                paramayka.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              }
            }
          }
          catch (Exception localException)
          {
            do
            {
              paramayka.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(this.a.getResources().getDrawable(2130845460));
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
 * Qualified Name:     aykb
 * JD-Core Version:    0.7.0.1
 */