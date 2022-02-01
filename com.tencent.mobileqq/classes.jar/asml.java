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

public class asml
  extends RecyclerView.ViewHolder
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int;
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private asqm jdField_a_of_type_Asqm;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private int b;
  
  public asml(View paramView, RecyclerView paramRecyclerView, int paramInt1, asqm paramasqm, int paramInt2)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.b = paramInt2;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368381));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378658));
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Asqm = paramasqm;
    paramView.setOnTouchListener(this);
  }
  
  public void a(asml paramasml, asnq paramasnq, int paramInt)
  {
    paramasnq = paramasml.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    paramasnq.height = (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getHeight() - this.jdField_a_of_type_Int);
    if ((paramasnq instanceof RecyclerView.LayoutParams)) {
      ((RecyclerView.LayoutParams)paramasnq).topMargin = this.jdField_a_of_type_Int;
    }
    paramasnq = URLDrawable.URLDrawableOptions.obtain();
    paramasnq.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    paramasnq.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    paramasnq = assx.a("expand_square_blank.png");
    if (new File(paramasnq).exists())
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      paramasnq = assx.a(paramasnq, localOptions);
      paramasml.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new BitmapDrawable(paramasnq));
    }
    if (paramInt == 1) {
      if (this.b == 0) {
        paramInt = 2131698458;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
      return;
      paramInt = 2131698454;
      continue;
      if (this.b == 0) {
        paramInt = 2131698457;
      } else {
        paramInt = 2131698453;
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Asqm != null) && (paramMotionEvent.getAction() == 0)) {
      this.jdField_a_of_type_Asqm.d();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asml
 * JD-Core Version:    0.7.0.1
 */