import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class bexw
  extends ReportDialog
{
  private static String a = "https://sola.gtimg.cn/aoi/sola/20200515111445_ChpLurYZBA.png";
  
  public bexw(Context paramContext)
  {
    super(paramContext, 2131755174);
    a();
  }
  
  private void a()
  {
    setCancelable(false);
    setCanceledOnTouchOutside(false);
    setContentView(2131559020);
    Object localObject1 = (URLImageView)findViewById(2131368344);
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#FFEBEDF5"));
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localColorDrawable;
    ((URLImageView)localObject1).setBackgroundDrawable(URLDrawable.getDrawable(a, (URLDrawable.URLDrawableOptions)localObject2));
    localObject1 = (TextView)findViewById(2131369567);
    ((TextView)localObject1).setClickable(true);
    localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setCornerRadius(12.0F);
    ((GradientDrawable)localObject2).setColor(-1315339);
    ((TextView)localObject1).setBackgroundDrawable((Drawable)localObject2);
    ((TextView)localObject1).setOnClickListener(new bexx(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bexw
 * JD-Core Version:    0.7.0.1
 */