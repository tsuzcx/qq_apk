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

public class asyv
  extends asyn
{
  public asyv(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(asyu paramasyu)
  {
    return 3;
  }
  
  public View a(ViewGroup paramViewGroup, asyu paramasyu)
  {
    paramasyu = (asyw)paramasyu;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131495318, paramViewGroup, false);
    paramasyu.g = ((TextView)paramViewGroup.findViewById(2131312545));
    paramasyu.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131302919));
    paramasyu.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131303006));
    paramasyu.jdField_e_of_type_AndroidViewView = paramViewGroup.findViewById(2131300489);
    paramasyu.jdField_f_of_type_AndroidViewView = paramViewGroup.findViewById(2131300490);
    return paramViewGroup;
  }
  
  public asyu a()
  {
    return new asyw(this);
  }
  
  public String b(asyu paramasyu)
  {
    return ((atao)((asyw)paramasyu).a).jdField_a_of_type_JavaLangString;
  }
  
  public void f(asyu paramasyu)
  {
    paramasyu = (asyw)paramasyu;
    Object localObject1 = (atao)paramasyu.a;
    label69:
    int j;
    if (((atao)localObject1).c > 1)
    {
      paramasyu.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramasyu.jdField_f_of_type_AndroidViewView.setVisibility(0);
      paramasyu.g.setMovementMethod(LinkMovementMethod.getInstance());
      if (!TextUtils.isEmpty(((atao)localObject1).n)) {
        break label307;
      }
      paramasyu.g.setVisibility(8);
      j = vms.a(this.a, 200.0F);
      if ((((atao)localObject1).jdField_a_of_type_Int <= 0) || (((atao)localObject1).jdField_b_of_type_Int <= 0)) {
        break label414;
      }
    }
    label414:
    for (int i = ((atao)localObject1).jdField_b_of_type_Int * j / ((atao)localObject1).jdField_a_of_type_Int;; i = j)
    {
      if (i * 3 > j * 4) {
        i = j * 4 / 3;
      }
      for (;;)
      {
        for (;;)
        {
          Object localObject2;
          if (!TextUtils.equals((String)paramasyu.jdField_e_of_type_AndroidWidgetImageView.getTag(2131311070), ((atao)localObject1).jdField_b_of_type_JavaLangString))
          {
            paramasyu.jdField_e_of_type_AndroidWidgetImageView.setTag(2131311070, ((atao)localObject1).jdField_b_of_type_JavaLangString);
            localObject2 = (FrameLayout.LayoutParams)paramasyu.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
            if (localObject2 != null) {
              break label330;
            }
            localObject2 = new FrameLayout.LayoutParams(j, i);
            paramasyu.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          try
          {
            for (;;)
            {
              localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130844567);
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130844567);
              localObject1 = URLDrawable.getDrawable(((atao)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
              ((URLDrawable)localObject1).setTag(azue.b(j, i, azvv.a(this.a, 3.0F)));
              ((URLDrawable)localObject1).setDecodeHandler(azue.e);
              paramasyu.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
              return;
              paramasyu.jdField_e_of_type_AndroidViewView.setVisibility(8);
              paramasyu.jdField_f_of_type_AndroidViewView.setVisibility(8);
              break;
              label307:
              paramasyu.g.setVisibility(0);
              paramasyu.g.setText(((atao)localObject1).n);
              break label69;
              label330:
              if ((((FrameLayout.LayoutParams)localObject2).width != j) || (((FrameLayout.LayoutParams)localObject2).height != i))
              {
                ((FrameLayout.LayoutParams)localObject2).width = j;
                ((FrameLayout.LayoutParams)localObject2).height = i;
                paramasyu.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              }
            }
          }
          catch (Exception localException)
          {
            do
            {
              paramasyu.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(this.a.getResources().getDrawable(2130844567));
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
 * Qualified Name:     asyv
 * JD-Core Version:    0.7.0.1
 */