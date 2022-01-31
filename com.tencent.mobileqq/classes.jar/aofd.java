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

public class aofd
  extends RecyclerView.ViewHolder
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int;
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private aoiw jdField_a_of_type_Aoiw;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private int b;
  
  public aofd(View paramView, RecyclerView paramRecyclerView, int paramInt1, aoiw paramaoiw, int paramInt2)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.b = paramInt2;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367679));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377030));
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Aoiw = paramaoiw;
    paramView.setOnTouchListener(this);
  }
  
  public void a(aofd paramaofd, aogh paramaogh, int paramInt)
  {
    paramaogh = paramaofd.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    paramaogh.height = (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getHeight() - this.jdField_a_of_type_Int);
    if ((paramaogh instanceof RecyclerView.LayoutParams)) {
      ((RecyclerView.LayoutParams)paramaogh).topMargin = this.jdField_a_of_type_Int;
    }
    paramaogh = URLDrawable.URLDrawableOptions.obtain();
    paramaogh.mLoadingDrawable = aywk.a;
    paramaogh.mFailedDrawable = aywk.a;
    paramaogh = aokl.a("expand_square_blank.png");
    if (new File(paramaogh).exists())
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      paramaogh = aokl.a(paramaogh, localOptions);
      paramaofd.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new BitmapDrawable(paramaogh));
    }
    if (paramInt == 1) {
      if (this.b == 0) {
        paramInt = 2131698939;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
      return;
      paramInt = 2131698935;
      continue;
      if (this.b == 0) {
        paramInt = 2131698938;
      } else {
        paramInt = 2131698934;
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Aoiw != null) && (paramMotionEvent.getAction() == 0)) {
      this.jdField_a_of_type_Aoiw.c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aofd
 * JD-Core Version:    0.7.0.1
 */