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

public class aofi
  extends RecyclerView.ViewHolder
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int;
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private aojb jdField_a_of_type_Aojb;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private int b;
  
  public aofi(View paramView, RecyclerView paramRecyclerView, int paramInt1, aojb paramaojb, int paramInt2)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.b = paramInt2;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367679));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377032));
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Aojb = paramaojb;
    paramView.setOnTouchListener(this);
  }
  
  public void a(aofi paramaofi, aogm paramaogm, int paramInt)
  {
    paramaogm = paramaofi.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    paramaogm.height = (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getHeight() - this.jdField_a_of_type_Int);
    if ((paramaogm instanceof RecyclerView.LayoutParams)) {
      ((RecyclerView.LayoutParams)paramaogm).topMargin = this.jdField_a_of_type_Int;
    }
    paramaogm = URLDrawable.URLDrawableOptions.obtain();
    paramaogm.mLoadingDrawable = aywm.a;
    paramaogm.mFailedDrawable = aywm.a;
    paramaogm = aokq.a("expand_square_blank.png");
    if (new File(paramaogm).exists())
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      paramaogm = aokq.a(paramaogm, localOptions);
      paramaofi.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new BitmapDrawable(paramaogm));
    }
    if (paramInt == 1) {
      if (this.b == 0) {
        paramInt = 2131698949;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
      return;
      paramInt = 2131698945;
      continue;
      if (this.b == 0) {
        paramInt = 2131698948;
      } else {
        paramInt = 2131698944;
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Aojb != null) && (paramMotionEvent.getAction() == 0)) {
      this.jdField_a_of_type_Aojb.c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aofi
 * JD-Core Version:    0.7.0.1
 */