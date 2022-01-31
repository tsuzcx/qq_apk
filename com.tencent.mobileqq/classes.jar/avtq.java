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

public class avtq
  extends Dialog
  implements View.OnClickListener
{
  protected int a;
  protected Context a;
  protected Drawable a;
  protected Button a;
  protected ImageView a;
  protected TextView a;
  protected autz a;
  protected RoundRelativeLayout a;
  protected int b;
  protected ImageView b;
  protected TextView b;
  
  public avtq(Context paramContext)
  {
    super(paramContext, 2131755801);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  protected void a()
  {
    setContentView(2131558935);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout = ((RoundRelativeLayout)findViewById(2131364795));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363492));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363188));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368085));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377898));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370721));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout.setRoundLayoutRadius(azkz.a(3.0F));
    this.jdField_a_of_type_Int = (azkz.jdField_a_of_type_Int - azkz.a(28.0F) * 2);
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
    new azqx(null).a("dc00899").b("grp_lbs").c("home").d(paramString).e(this.jdField_a_of_type_Autz.g).a(new String[] { this.jdField_a_of_type_Autz.f }).a();
  }
  
  public boolean a(autz paramautz)
  {
    this.jdField_a_of_type_Autz = paramautz;
    if (QLog.isColorLevel()) {
      QLog.d("NearbyAppDownloadDialog", 2, "initContent=" + paramautz.toString());
    }
    a(this.jdField_a_of_type_AndroidWidgetImageView, paramautz.a);
    if (!TextUtils.isEmpty(paramautz.c))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(paramautz.c);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      if (TextUtils.isEmpty(paramautz.b)) {
        break label141;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramautz.b);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramautz.e)) {
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
    if (i == 2131368085)
    {
      dismiss();
      a("pop_new_quit");
    }
    do
    {
      return;
      if (i == 2131363492)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyAppDownloadDialog", 2, "btn onClick, jumpUrl=" + this.jdField_a_of_type_Autz.d);
        }
        avtz.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Autz.d);
        dismiss();
        a("pop_new_clk");
        return;
      }
    } while (i != 2131370721);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyAppDownloadDialog", 2, "more onClick, jumpUrl=" + this.jdField_a_of_type_Autz.e);
    }
    avtz.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Autz.e);
  }
  
  public void show()
  {
    super.show();
    a("pop_new_exp");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avtq
 * JD-Core Version:    0.7.0.1
 */