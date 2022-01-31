import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;

public class ayxk
  extends ayxt
{
  public View a;
  public TextView a;
  public TextView b;
  public TextView c;
  
  public ayxk(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public static int a(Context paramContext, View... paramVarArgs)
  {
    int j = paramContext.getResources().getDisplayMetrics().widthPixels;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      paramContext = paramVarArgs[i];
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramContext.getLayoutParams();
      paramContext.measure(0, 0);
      j = j - paramContext.getMeasuredWidth() - localLayoutParams.leftMargin - localLayoutParams.rightMargin;
      i += 1;
    }
    return j;
  }
  
  private void b(aypd paramaypd)
  {
    if (a() != null) {
      a().setText(paramaypd.a());
    }
    if (b() != null) {
      b().setText(paramaypd.b());
    }
    if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramaypd.f)))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramaypd.f);
      b().setMaxWidth(a(this.jdField_b_of_type_AndroidViewView.getContext(), new View[] { a(), this.jdField_c_of_type_AndroidWidgetTextView, this.f }) - aepi.a(75.0F, b().getResources()));
    }
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    Object localObject;
    if (b() != null)
    {
      if (paramaypd.b != 0)
      {
        b().setImageResource(paramaypd.b);
        b().setVisibility(0);
      }
    }
    else if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localObject = a().getTag(2131379972);
      if (!(localObject instanceof Integer)) {
        break label545;
      }
    }
    label523:
    label535:
    label545:
    for (int i = ((Integer)localObject).intValue();; i = -1)
    {
      if (i > 0)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        label212:
        if ((c() != null) && (!TextUtils.isEmpty(paramaypd.c())))
        {
          c().setText(paramaypd.c());
          c().setVisibility(0);
        }
        if (a() != null)
        {
          if (!paramaypd.a()) {
            break label523;
          }
          a().setVisibility(0);
        }
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramaypd.h)) {
          break label535;
        }
        i = a().getResources().getDimensionPixelSize(2131298147);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
        ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "rightIcon";
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
        paramaypd = URLDrawable.getDrawable(paramaypd.h, (URLDrawable.URLDrawableOptions)localObject);
        if ((paramaypd.getStatus() != 1) && (paramaypd.getStatus() != 0)) {
          paramaypd.restartDownload();
        }
        a().setImageDrawable(paramaypd);
        a().setVisibility(0);
        return;
        if (!TextUtils.isEmpty(paramaypd.c))
        {
          i = a().getResources().getDimensionPixelSize(2131297310);
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
          ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "isAvatar";
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
          localObject = URLDrawable.getDrawable(paramaypd.c, (URLDrawable.URLDrawableOptions)localObject);
          ((URLDrawable)localObject).setDecodeHandler(bcyz.a);
          if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
            ((URLDrawable)localObject).restartDownload();
          }
          b().setImageDrawable((Drawable)localObject);
          b().setVisibility(0);
          break;
        }
        b().setVisibility(8);
        break;
        if (i != 0) {
          break label212;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        break label212;
        a().setVisibility(8);
      }
      a().setVisibility(8);
      return;
    }
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131365369);
    switch (this.jdField_c_of_type_Int)
    {
    default: 
    case 2131559665: 
      do
      {
        return;
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377607));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377609));
        a().setMaxWidth(a(this.jdField_b_of_type_AndroidViewView.getContext(), new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.f }));
        a().setTextColor(ayvm.b());
      } while (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370764));
  }
  
  public void a(aypd paramaypd)
  {
    b();
    switch (paramaypd.a)
    {
    case -2: 
    default: 
      return;
    }
    b(paramaypd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxk
 * JD-Core Version:    0.7.0.1
 */