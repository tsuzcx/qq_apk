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

public class atvb
  extends atut
{
  public atvb(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(atva paramatva)
  {
    return 3;
  }
  
  public View a(ViewGroup paramViewGroup, atva paramatva)
  {
    paramatva = (atvc)paramatva;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131560895, paramViewGroup, false);
    paramatva.g = ((TextView)paramViewGroup.findViewById(2131378373));
    paramatva.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368543));
    paramatva.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368639));
    paramatva.jdField_e_of_type_AndroidViewView = paramViewGroup.findViewById(2131366091);
    paramatva.jdField_f_of_type_AndroidViewView = paramViewGroup.findViewById(2131366092);
    return paramViewGroup;
  }
  
  public atva a()
  {
    return new atvc(this);
  }
  
  public String b(atva paramatva)
  {
    return ((atwu)((atvc)paramatva).a).jdField_a_of_type_JavaLangString;
  }
  
  public void f(atva paramatva)
  {
    paramatva = (atvc)paramatva;
    Object localObject1 = (atwu)paramatva.a;
    label69:
    int j;
    if (((atwu)localObject1).c > 1)
    {
      paramatva.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramatva.jdField_f_of_type_AndroidViewView.setVisibility(0);
      paramatva.g.setMovementMethod(LinkMovementMethod.getInstance());
      if (!TextUtils.isEmpty(((atwu)localObject1).n)) {
        break label307;
      }
      paramatva.g.setVisibility(8);
      j = vzl.a(this.a, 200.0F);
      if ((((atwu)localObject1).jdField_a_of_type_Int <= 0) || (((atwu)localObject1).jdField_b_of_type_Int <= 0)) {
        break label414;
      }
    }
    label414:
    for (int i = ((atwu)localObject1).jdField_b_of_type_Int * j / ((atwu)localObject1).jdField_a_of_type_Int;; i = j)
    {
      if (i * 3 > j * 4) {
        i = j * 4 / 3;
      }
      for (;;)
      {
        for (;;)
        {
          Object localObject2;
          if (!TextUtils.equals((String)paramatva.jdField_e_of_type_AndroidWidgetImageView.getTag(2131376882), ((atwu)localObject1).jdField_b_of_type_JavaLangString))
          {
            paramatva.jdField_e_of_type_AndroidWidgetImageView.setTag(2131376882, ((atwu)localObject1).jdField_b_of_type_JavaLangString);
            localObject2 = (FrameLayout.LayoutParams)paramatva.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
            if (localObject2 != null) {
              break label330;
            }
            localObject2 = new FrameLayout.LayoutParams(j, i);
            paramatva.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          try
          {
            for (;;)
            {
              localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130844649);
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130844649);
              localObject1 = URLDrawable.getDrawable(((atwu)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
              ((URLDrawable)localObject1).setTag(bavw.b(j, i, baxn.a(this.a, 3.0F)));
              ((URLDrawable)localObject1).setDecodeHandler(bavw.e);
              paramatva.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
              return;
              paramatva.jdField_e_of_type_AndroidViewView.setVisibility(8);
              paramatva.jdField_f_of_type_AndroidViewView.setVisibility(8);
              break;
              label307:
              paramatva.g.setVisibility(0);
              paramatva.g.setText(((atwu)localObject1).n);
              break label69;
              label330:
              if ((((FrameLayout.LayoutParams)localObject2).width != j) || (((FrameLayout.LayoutParams)localObject2).height != i))
              {
                ((FrameLayout.LayoutParams)localObject2).width = j;
                ((FrameLayout.LayoutParams)localObject2).height = i;
                paramatva.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              }
            }
          }
          catch (Exception localException)
          {
            do
            {
              paramatva.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(this.a.getResources().getDrawable(2130844649));
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
 * Qualified Name:     atvb
 * JD-Core Version:    0.7.0.1
 */