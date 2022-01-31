import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.nearby.now.view.widget.RoundRelativeLayout;
import com.tencent.qphone.base.util.QLog;

public class atyd
  extends Dialog
  implements View.OnClickListener
{
  protected int a;
  protected Context a;
  protected Drawable a;
  protected Button a;
  protected ImageView a;
  protected TextView a;
  protected asyt a;
  protected RoundRelativeLayout a;
  protected int b;
  protected ImageView b;
  protected TextView b;
  
  public atyd(Context paramContext)
  {
    super(paramContext, 2131755791);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  protected void a()
  {
    setContentView(2131558899);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout = ((RoundRelativeLayout)findViewById(2131364715));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363450));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363151));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367938));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377315));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370397));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout.setRoundLayoutRadius(axlk.a(3.0F));
    this.jdField_a_of_type_Int = (axlk.jdField_a_of_type_Int - axlk.a(28.0F) * 2);
    this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int * 150 / 320);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = this.jdField_a_of_type_Int;
    localLayoutParams.height = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyAppDownloadDialog", 2, "init, w=" + this.jdField_a_of_type_Int + ", h=" + this.jdField_b_of_type_Int);
    }
  }
  
  protected void a(ImageView paramImageView, String paramString)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#f4f4f4"));
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyAppDownloadDialog", 2, "loadImage, url=" + paramString);
    }
    Object localObject2 = null;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.jdField_b_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localObject1 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
      }
      for (;;)
      {
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        }
        paramImageView.setImageDrawable(paramString);
        return;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.w("NearbyAppDownloadDialog", 2, "loadImage empty url");
          localObject1 = localObject2;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.w("NearbyAppDownloadDialog", 2, "loadImage exp: url=" + paramString, localException);
          localObject1 = localObject2;
        }
      }
    }
  }
  
  protected void a(String paramString)
  {
    new axrc(null).a("dc00899").b("grp_lbs").c("home").d(paramString).e(this.jdField_a_of_type_Asyt.g).a(new String[] { this.jdField_a_of_type_Asyt.f }).a();
  }
  
  public boolean a(asyt paramasyt)
  {
    this.jdField_a_of_type_Asyt = paramasyt;
    if (QLog.isColorLevel()) {
      QLog.d("NearbyAppDownloadDialog", 2, "initContent=" + paramasyt.toString());
    }
    a(this.jdField_a_of_type_AndroidWidgetImageView, paramasyt.a);
    if (!TextUtils.isEmpty(paramasyt.c))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(paramasyt.c);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      if (TextUtils.isEmpty(paramasyt.b)) {
        break label141;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramasyt.b);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramasyt.e)) {
        break label153;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return false;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      break;
      label141:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    label153:
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131367938)
    {
      dismiss();
      a("pop_new_quit");
    }
    do
    {
      return;
      if (i == 2131363450)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyAppDownloadDialog", 2, "btn onClick, jumpUrl=" + this.jdField_a_of_type_Asyt.d);
        }
        atym.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Asyt.d);
        dismiss();
        a("pop_new_clk");
        return;
      }
    } while (i != 2131370397);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyAppDownloadDialog", 2, "more onClick, jumpUrl=" + this.jdField_a_of_type_Asyt.e);
    }
    atym.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Asyt.e);
  }
  
  public void show()
  {
    super.show();
    a("pop_new_exp");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atyd
 * JD-Core Version:    0.7.0.1
 */