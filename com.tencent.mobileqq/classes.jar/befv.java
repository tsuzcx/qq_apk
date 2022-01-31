import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;

public class befv
{
  int jdField_a_of_type_Int = 255;
  Activity jdField_a_of_type_AndroidAppActivity;
  public View.OnClickListener a;
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  CustomWebView jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
  String jdField_a_of_type_JavaLangString = null;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public befv(Activity paramActivity, CustomWebView paramCustomWebView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
    a(paramViewGroup);
    a();
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public ImageView a()
  {
    return this.jdField_b_of_type_AndroidWidgetImageView;
  }
  
  public TextView a()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  public CharSequence a()
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      return this.jdField_c_of_type_AndroidWidgetTextView.getText();
    }
    return null;
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364754));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364764));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364762));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368659));
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxEms(9);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368656));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368613));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368644));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368627));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363408);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (paramInt2 == 0)
    {
      this.jdField_a_of_type_AndroidViewView.getBackground().mutate().setAlpha(paramInt1);
      this.jdField_a_of_type_Int = paramInt1;
    }
    while (this.jdField_a_of_type_Int == paramInt1) {
      return;
    }
    a(this.jdField_a_of_type_Int, paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0)
    {
      this.jdField_a_of_type_AndroidViewView.getBackground().mutate().setAlpha(paramInt2);
      return;
    }
    bdjs localbdjs = new bdjs(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), new befx(this, paramInt2));
    localbdjs.setDuration(paramInt3);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView.startAnimation(localbdjs);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  public void a(View paramView)
  {
    try
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramView, new RelativeLayout.LayoutParams(-2, -1));
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131562818, paramViewGroup, true);
  }
  
  public void a(ImageView paramImageView)
  {
    this.jdField_c_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    int i = 0;
    if (!TextUtils.isEmpty(paramString2))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString2);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.bringToFront();
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundColor(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramString3)) {}
    try
    {
      int j = Color.parseColor(paramString3);
      i = j;
    }
    catch (Exception paramString2)
    {
      label75:
      break label75;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(i);
    if (paramString1 != null)
    {
      this.jdField_a_of_type_JavaLangString = paramString1.trim();
      b(new befw(this));
      return;
    }
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public ImageView b()
  {
    return this.jdField_c_of_type_AndroidWidgetImageView;
  }
  
  public TextView b()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  public void b(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
  }
  
  public void b(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 4)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public TextView c()
  {
    return this.jdField_c_of_type_AndroidWidgetTextView;
  }
  
  public void c(View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
  }
  
  public void c(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befv
 * JD-Core Version:    0.7.0.1
 */