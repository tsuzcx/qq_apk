import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmini.sdk.core.widget.TabBar;
import com.tencent.qqmini.sdk.launcher.model.TabBarInfo;
import com.tencent.qqmini.sdk.launcher.model.TabBarInfo.ButtonInfo;
import com.tencent.qqmini.sdk.utils.DisplayUtil;

public class bgsb
{
  public Drawable a;
  public View a;
  public ImageView a;
  public TextView a;
  public TabBarInfo.ButtonInfo a;
  public TabBarInfo a;
  public boolean a;
  public Drawable b;
  public View b;
  public TextView b;
  public View c;
  public View d;
  public View e;
  
  public static bgsb a(View paramView, TabBarInfo.ButtonInfo paramButtonInfo, TabBarInfo paramTabBarInfo)
  {
    bgsb localbgsb = new bgsb();
    localbgsb.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377606));
    localbgsb.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367819));
    localbgsb.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370610);
    localbgsb.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131370607);
    localbgsb.c = paramView.findViewById(2131370608);
    localbgsb.e = paramView.findViewById(2131370609);
    localbgsb.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370605));
    localbgsb.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    localbgsb.jdField_b_of_type_AndroidWidgetTextView.setMaxEms(3);
    localbgsb.jdField_b_of_type_AndroidWidgetTextView.setSingleLine();
    localbgsb.d = paramView;
    localbgsb.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo = paramTabBarInfo;
    localbgsb.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo$ButtonInfo = paramButtonInfo;
    return localbgsb;
  }
  
  public void a()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if ("top".equals(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo.position))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.bottomMargin = DisplayUtil.dip2px(this.d.getContext(), 15.0F);
      localLayoutParams.topMargin = DisplayUtil.dip2px(this.d.getContext(), 15.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 15.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo$ButtonInfo.text);
      if (!"top".equals(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo.position)) {
        break label225;
      }
    }
    for (;;)
    {
      a(false);
      return;
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.bottomMargin = DisplayUtil.dip2px(this.d.getContext(), 5.0F);
      localLayoutParams.topMargin = DisplayUtil.dip2px(this.d.getContext(), 0.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      break;
      label225:
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.d.getContext().getResources(), this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo$ButtonInfo.iconBitmap);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.d.getContext().getResources(), this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo$ButtonInfo.selectedBitmap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int j = 855638016;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.d.setBackgroundColor(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo.backgroundColor);
    if (!paramBoolean)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo.color == 0)
      {
        i = TabBar.a;
        ((TextView)localObject).setTextColor(i);
        if (!"top".equals(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo.position)) {
          break label147;
        }
        this.c.setVisibility(8);
        label76:
        if (!"top".equals(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo.position)) {
          break label244;
        }
        localObject = this.jdField_b_of_type_AndroidViewView;
        if (!"black".equals(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo.borderStyle)) {
          break label238;
        }
      }
    }
    label147:
    label224:
    label238:
    for (int i = 855638016;; i = 872415231)
    {
      ((View)localObject).setBackgroundColor(i);
      this.c.setBackgroundColor(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo.selectedColor);
      return;
      i = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo.color;
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      break label76;
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo.selectedColor == 0) {}
      for (i = TabBar.a;; i = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo.selectedColor)
      {
        ((TextView)localObject).setTextColor(i);
        if (!"top".equals(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo.position)) {
          break label224;
        }
        this.c.setVisibility(0);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      break label76;
    }
    label244:
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if ("black".equals(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo.borderStyle)) {}
    for (i = j;; i = 872415231)
    {
      ((View)localObject).setBackgroundColor(i);
      return;
    }
  }
  
  public void b()
  {
    a(this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgsb
 * JD-Core Version:    0.7.0.1
 */