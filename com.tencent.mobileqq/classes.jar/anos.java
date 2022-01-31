import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import java.io.File;

public class anos
  extends RecyclerView.ViewHolder
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int;
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private ansk jdField_a_of_type_Ansk;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private int b;
  
  public anos(View paramView, RecyclerView paramRecyclerView, int paramInt1, ansk paramansk, int paramInt2)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.b = paramInt2;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131302061));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131311220));
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Ansk = paramansk;
    paramView.setOnTouchListener(this);
  }
  
  public void a(anos paramanos, anpv paramanpv, int paramInt)
  {
    paramanpv = paramanos.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    paramanpv.height = (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getHeight() - this.jdField_a_of_type_Int);
    if ((paramanpv instanceof RecyclerView.LayoutParams)) {
      ((RecyclerView.LayoutParams)paramanpv).topMargin = this.jdField_a_of_type_Int;
    }
    paramanpv = URLDrawable.URLDrawableOptions.obtain();
    paramanpv.mLoadingDrawable = axwd.a;
    paramanpv.mFailedDrawable = axwd.a;
    paramanpv = antz.a("expand_square_blank.png");
    if (new File(paramanpv).exists())
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      paramanpv = antz.a(paramanpv, localOptions);
      paramanos.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new BitmapDrawable(paramanpv));
    }
    if (paramInt == 1) {
      if (this.b == 0) {
        paramInt = 2131633203;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
      return;
      paramInt = 2131633199;
      continue;
      if (this.b == 0) {
        paramInt = 2131633202;
      } else {
        paramInt = 2131633198;
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Ansk != null) && (paramMotionEvent.getAction() == 0)) {
      this.jdField_a_of_type_Ansk.c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anos
 * JD-Core Version:    0.7.0.1
 */