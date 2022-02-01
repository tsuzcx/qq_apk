import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class biax
  extends ReportDialog
{
  private static int jdField_a_of_type_Int = 150;
  private static int b = 56;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new biay(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  biaz jdField_a_of_type_Biaz;
  
  public biax(Context paramContext)
  {
    super(paramContext, 2131755174);
  }
  
  public void a(biaz parambiaz)
  {
    this.jdField_a_of_type_Biaz = parambiaz;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131562124);
    findViewById(2131375043).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    findViewById(2131375044).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    findViewById(2131375045).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375046));
    paramBundle = new ColorDrawable(15856629);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    float f = localResources.getDisplayMetrics().density;
    localURLDrawableOptions.mRequestWidth = ((int)(localResources.getDisplayMetrics().widthPixels - b * f));
    localURLDrawableOptions.mRequestHeight = ((int)(jdField_a_of_type_Int * f));
    localURLDrawableOptions.mFailedDrawable = paramBundle;
    localURLDrawableOptions.mLoadingDrawable = paramBundle;
    paramBundle = URLDrawable.getDrawable("https://gxh.vip.qq.com/xydata/like/app/zanDoubleConfig/single.png", localURLDrawableOptions);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biax
 * JD-Core Version:    0.7.0.1
 */