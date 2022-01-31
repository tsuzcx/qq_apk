import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class birz
  extends Dialog
  implements View.OnClickListener, bisb
{
  private int jdField_a_of_type_Int;
  protected Context a;
  private View jdField_a_of_type_AndroidViewView;
  protected EditText a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private birw jdField_a_of_type_Birw;
  bisa jdField_a_of_type_Bisa;
  private bisc jdField_a_of_type_Bisc;
  private FitSystemWindowsRelativeLayout jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout;
  
  public birz(@NonNull Context paramContext, @NonNull birw parambirw, int paramInt)
  {
    super(paramContext, 2131689640);
    this.jdField_a_of_type_Birw = parambirw;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void b()
  {
    Object localObject = super.getWindow();
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = biqy.b(getContext());
    localLayoutParams.flags |= 0x20;
    localLayoutParams.gravity = 80;
    ((Window)localObject).setAttributes(localLayoutParams);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      getWindow().addFlags(67108864);
      localObject = new SystemBarCompact(this, true, getContext().getResources().getColor(17170445));
      ((SystemBarCompact)localObject).setStatusBarDrawable(null);
      ((SystemBarCompact)localObject).init();
    }
    setCanceledOnTouchOutside(true);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout = ((FitSystemWindowsRelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131309756));
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout.setFitsSystemWindows(true);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131313500));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131297465).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131313492));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131313501));
    this.jdField_a_of_type_Bisa = bisa.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bisa.a(getContext(), this.jdField_a_of_type_Bisc, this.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_AndroidWidgetTextView, this);
    View localView = this.jdField_a_of_type_Bisa.a();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localView);
  }
  
  public void a()
  {
    dismiss();
  }
  
  public void a(bisc parambisc)
  {
    this.jdField_a_of_type_Bisc = parambisc;
  }
  
  public void dismiss()
  {
    super.dismiss();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    dismiss();
  }
  
  public void onDetachedFromWindow()
  {
    this.jdField_a_of_type_Bisa.a();
    if (this.jdField_a_of_type_Birw != null) {
      this.jdField_a_of_type_Birw.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Bisa.a());
    }
    super.onDetachedFromWindow();
  }
  
  public void setContentView(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131495852, null);
    b();
    c();
    super.setContentView(this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     birz
 * JD-Core Version:    0.7.0.1
 */