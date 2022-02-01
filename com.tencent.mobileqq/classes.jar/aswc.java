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

public class aswc
  extends RecyclerView.ViewHolder
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int;
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private aszz jdField_a_of_type_Aszz;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private int b;
  
  public aswc(View paramView, RecyclerView paramRecyclerView, int paramInt1, aszz paramaszz, int paramInt2)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.b = paramInt2;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368212));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378603));
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Aszz = paramaszz;
    paramView.setOnTouchListener(this);
  }
  
  public void a(aswc paramaswc, asxh paramasxh, int paramInt)
  {
    paramasxh = paramaswc.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    paramasxh.height = (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getHeight() - this.jdField_a_of_type_Int);
    if ((paramasxh instanceof RecyclerView.LayoutParams)) {
      ((RecyclerView.LayoutParams)paramasxh).topMargin = this.jdField_a_of_type_Int;
    }
    paramasxh = URLDrawable.URLDrawableOptions.obtain();
    paramasxh.mLoadingDrawable = beyq.a;
    paramasxh.mFailedDrawable = beyq.a;
    paramasxh = atcj.a("expand_square_blank.png");
    if (new File(paramasxh).exists())
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      paramasxh = atcj.a(paramasxh, localOptions);
      paramaswc.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new BitmapDrawable(paramasxh));
    }
    if (paramInt == 1) {
      if (this.b == 0) {
        paramInt = 2131698015;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
      return;
      paramInt = 2131698011;
      continue;
      if (this.b == 0) {
        paramInt = 2131698014;
      } else {
        paramInt = 2131698010;
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Aszz != null) && (paramMotionEvent.getAction() == 0)) {
      this.jdField_a_of_type_Aszz.d();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswc
 * JD-Core Version:    0.7.0.1
 */