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

public class asgo
  extends RecyclerView.ViewHolder
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int;
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private aski jdField_a_of_type_Aski;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private int b;
  
  public asgo(View paramView, RecyclerView paramRecyclerView, int paramInt1, aski paramaski, int paramInt2)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.b = paramInt2;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368138));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378445));
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Aski = paramaski;
    paramView.setOnTouchListener(this);
  }
  
  public void a(asgo paramasgo, asht paramasht, int paramInt)
  {
    paramasht = paramasgo.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    paramasht.height = (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getHeight() - this.jdField_a_of_type_Int);
    if ((paramasht instanceof RecyclerView.LayoutParams)) {
      ((RecyclerView.LayoutParams)paramasht).topMargin = this.jdField_a_of_type_Int;
    }
    paramasht = URLDrawable.URLDrawableOptions.obtain();
    paramasht.mLoadingDrawable = bdzx.a;
    paramasht.mFailedDrawable = bdzx.a;
    paramasht = asmk.a("expand_square_blank.png");
    if (new File(paramasht).exists())
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      paramasht = asmk.a(paramasht, localOptions);
      paramasgo.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new BitmapDrawable(paramasht));
    }
    if (paramInt == 1) {
      if (this.b == 0) {
        paramInt = 2131697915;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
      return;
      paramInt = 2131697911;
      continue;
      if (this.b == 0) {
        paramInt = 2131697914;
      } else {
        paramInt = 2131697910;
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Aski != null) && (paramMotionEvent.getAction() == 0)) {
      this.jdField_a_of_type_Aski.d();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgo
 * JD-Core Version:    0.7.0.1
 */