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
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import java.io.File;

public class arif
  extends RecyclerView.ViewHolder
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int;
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private armg jdField_a_of_type_Armg;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private int b;
  
  public arif(View paramView, RecyclerView paramRecyclerView, int paramInt1, armg paramarmg, int paramInt2)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.b = paramInt2;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368236));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378367));
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Armg = paramarmg;
    paramView.setOnTouchListener(this);
  }
  
  public void a(arif paramarif, arjk paramarjk, int paramInt)
  {
    paramarjk = paramarif.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    paramarjk.height = (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getHeight() - this.jdField_a_of_type_Int);
    if ((paramarjk instanceof RecyclerView.LayoutParams)) {
      ((RecyclerView.LayoutParams)paramarjk).topMargin = this.jdField_a_of_type_Int;
    }
    paramarjk = URLDrawable.URLDrawableOptions.obtain();
    paramarjk.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    paramarjk.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    paramarjk = aror.a("expand_square_blank.png");
    if (new File(paramarjk).exists())
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      paramarjk = aror.a(paramarjk, localOptions);
      paramarif.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new BitmapDrawable(paramarjk));
    }
    if (paramInt == 1) {
      if (this.b == 0) {
        paramInt = 2131698172;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
      return;
      paramInt = 2131698168;
      continue;
      if (this.b == 0) {
        paramInt = 2131698171;
      } else {
        paramInt = 2131698167;
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Armg != null) && (paramMotionEvent.getAction() == 0)) {
      this.jdField_a_of_type_Armg.d();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arif
 * JD-Core Version:    0.7.0.1
 */