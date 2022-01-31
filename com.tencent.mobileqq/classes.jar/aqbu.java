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

public class aqbu
  extends RecyclerView.ViewHolder
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int;
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqfj jdField_a_of_type_Aqfj;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private int b;
  
  public aqbu(View paramView, RecyclerView paramRecyclerView, int paramInt1, aqfj paramaqfj, int paramInt2)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.b = paramInt2;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367819));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377606));
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Aqfj = paramaqfj;
    paramView.setOnTouchListener(this);
  }
  
  public void a(aqbu paramaqbu, aqcx paramaqcx, int paramInt)
  {
    paramaqcx = paramaqbu.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    paramaqcx.height = (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getHeight() - this.jdField_a_of_type_Int);
    if ((paramaqcx instanceof RecyclerView.LayoutParams)) {
      ((RecyclerView.LayoutParams)paramaqcx).topMargin = this.jdField_a_of_type_Int;
    }
    paramaqcx = URLDrawable.URLDrawableOptions.obtain();
    paramaqcx.mLoadingDrawable = bayu.a;
    paramaqcx.mFailedDrawable = bayu.a;
    paramaqcx = aqhh.a("expand_square_blank.png");
    if (new File(paramaqcx).exists())
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      paramaqcx = aqhh.a(paramaqcx, localOptions);
      paramaqbu.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new BitmapDrawable(paramaqcx));
    }
    if (paramInt == 1) {
      if (this.b == 0) {
        paramInt = 2131699282;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
      return;
      paramInt = 2131699278;
      continue;
      if (this.b == 0) {
        paramInt = 2131699281;
      } else {
        paramInt = 2131699277;
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Aqfj != null) && (paramMotionEvent.getAction() == 0)) {
      this.jdField_a_of_type_Aqfj.d();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqbu
 * JD-Core Version:    0.7.0.1
 */