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

public class apxl
  extends RecyclerView.ViewHolder
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int;
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqba jdField_a_of_type_Aqba;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private int b;
  
  public apxl(View paramView, RecyclerView paramRecyclerView, int paramInt1, aqba paramaqba, int paramInt2)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.b = paramInt2;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367808));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377552));
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Aqba = paramaqba;
    paramView.setOnTouchListener(this);
  }
  
  public void a(apxl paramapxl, apyo paramapyo, int paramInt)
  {
    paramapyo = paramapxl.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    paramapyo.height = (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getHeight() - this.jdField_a_of_type_Int);
    if ((paramapyo instanceof RecyclerView.LayoutParams)) {
      ((RecyclerView.LayoutParams)paramapyo).topMargin = this.jdField_a_of_type_Int;
    }
    paramapyo = URLDrawable.URLDrawableOptions.obtain();
    paramapyo.mLoadingDrawable = baul.a;
    paramapyo.mFailedDrawable = baul.a;
    paramapyo = aqcy.a("expand_square_blank.png");
    if (new File(paramapyo).exists())
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      paramapyo = aqcy.a(paramapyo, localOptions);
      paramapxl.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new BitmapDrawable(paramapyo));
    }
    if (paramInt == 1) {
      if (this.b == 0) {
        paramInt = 2131699270;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
      return;
      paramInt = 2131699266;
      continue;
      if (this.b == 0) {
        paramInt = 2131699269;
      } else {
        paramInt = 2131699265;
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Aqba != null) && (paramMotionEvent.getAction() == 0)) {
      this.jdField_a_of_type_Aqba.d();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxl
 * JD-Core Version:    0.7.0.1
 */