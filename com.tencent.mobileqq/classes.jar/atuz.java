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

public class atuz
  extends atur
{
  public atuz(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(atuy paramatuy)
  {
    return 3;
  }
  
  public View a(ViewGroup paramViewGroup, atuy paramatuy)
  {
    paramatuy = (atva)paramatuy;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131560896, paramViewGroup, false);
    paramatuy.g = ((TextView)paramViewGroup.findViewById(2131378370));
    paramatuy.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368544));
    paramatuy.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368640));
    paramatuy.jdField_e_of_type_AndroidViewView = paramViewGroup.findViewById(2131366091);
    paramatuy.jdField_f_of_type_AndroidViewView = paramViewGroup.findViewById(2131366092);
    return paramViewGroup;
  }
  
  public atuy a()
  {
    return new atva(this);
  }
  
  public String b(atuy paramatuy)
  {
    return ((atws)((atva)paramatuy).a).jdField_a_of_type_JavaLangString;
  }
  
  public void f(atuy paramatuy)
  {
    paramatuy = (atva)paramatuy;
    Object localObject1 = (atws)paramatuy.a;
    label69:
    int j;
    if (((atws)localObject1).c > 1)
    {
      paramatuy.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramatuy.jdField_f_of_type_AndroidViewView.setVisibility(0);
      paramatuy.g.setMovementMethod(LinkMovementMethod.getInstance());
      if (!TextUtils.isEmpty(((atws)localObject1).n)) {
        break label307;
      }
      paramatuy.g.setVisibility(8);
      j = vzo.a(this.a, 200.0F);
      if ((((atws)localObject1).jdField_a_of_type_Int <= 0) || (((atws)localObject1).jdField_b_of_type_Int <= 0)) {
        break label414;
      }
    }
    label414:
    for (int i = ((atws)localObject1).jdField_b_of_type_Int * j / ((atws)localObject1).jdField_a_of_type_Int;; i = j)
    {
      if (i * 3 > j * 4) {
        i = j * 4 / 3;
      }
      for (;;)
      {
        for (;;)
        {
          Object localObject2;
          if (!TextUtils.equals((String)paramatuy.jdField_e_of_type_AndroidWidgetImageView.getTag(2131376880), ((atws)localObject1).jdField_b_of_type_JavaLangString))
          {
            paramatuy.jdField_e_of_type_AndroidWidgetImageView.setTag(2131376880, ((atws)localObject1).jdField_b_of_type_JavaLangString);
            localObject2 = (FrameLayout.LayoutParams)paramatuy.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
            if (localObject2 != null) {
              break label330;
            }
            localObject2 = new FrameLayout.LayoutParams(j, i);
            paramatuy.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          try
          {
            for (;;)
            {
              localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130844648);
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130844648);
              localObject1 = URLDrawable.getDrawable(((atws)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
              ((URLDrawable)localObject1).setTag(bavi.b(j, i, bawz.a(this.a, 3.0F)));
              ((URLDrawable)localObject1).setDecodeHandler(bavi.e);
              paramatuy.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
              return;
              paramatuy.jdField_e_of_type_AndroidViewView.setVisibility(8);
              paramatuy.jdField_f_of_type_AndroidViewView.setVisibility(8);
              break;
              label307:
              paramatuy.g.setVisibility(0);
              paramatuy.g.setText(((atws)localObject1).n);
              break label69;
              label330:
              if ((((FrameLayout.LayoutParams)localObject2).width != j) || (((FrameLayout.LayoutParams)localObject2).height != i))
              {
                ((FrameLayout.LayoutParams)localObject2).width = j;
                ((FrameLayout.LayoutParams)localObject2).height = i;
                paramatuy.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              }
            }
          }
          catch (Exception localException)
          {
            do
            {
              paramatuy.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(this.a.getResources().getDrawable(2130844648));
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
 * Qualified Name:     atuz
 * JD-Core Version:    0.7.0.1
 */