import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.animation.rebound.Spring;
import com.tencent.component.animation.rebound.SpringConfig;
import com.tencent.component.animation.rebound.SpringSystem;
import java.util.ArrayList;

public class bkhk
  extends PopupWindow
{
  private static final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(2130850193);
  private static final SpringConfig jdField_a_of_type_ComTencentComponentAnimationReboundSpringConfig = SpringConfig.fromOrigamiTensionAndFriction(60.0D, 8.0D);
  private static final Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = a(2130850194);
  private static final Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(2130706432);
  private float jdField_a_of_type_Float = 0.1F;
  private int jdField_a_of_type_Int;
  public Activity a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnKeyListener jdField_a_of_type_AndroidViewView$OnKeyListener = new bkhn(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new bkho(this);
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bkhp jdField_a_of_type_Bkhp;
  private Spring jdField_a_of_type_ComTencentComponentAnimationReboundSpring;
  public ArrayList<bkhq> a;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = true;
  private int d;
  
  public bkhk(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    f();
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5)
  {
    return (paramDouble1 - paramDouble2) / (paramDouble3 - paramDouble2) * (paramDouble5 - paramDouble4) + paramDouble4;
  }
  
  public static Drawable a(int paramInt)
  {
    try
    {
      Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt);
      return localDrawable;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private void a(int paramInt)
  {
    Activity localActivity;
    if (this.jdField_a_of_type_AndroidViewLayoutInflater == null)
    {
      localActivity = a();
      if (localActivity != null) {}
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(localActivity);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt, null));
    } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null);
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusableInTouchMode(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnKeyListener(this.jdField_a_of_type_AndroidViewView$OnKeyListener);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    bdoo.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, jdField_c_of_type_AndroidGraphicsDrawableDrawable);
    super.setContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  private void a(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setAlpha(paramFloat);
  }
  
  private int c()
  {
    if (a() == null) {
      return 0;
    }
    Rect localRect = new Rect();
    a().getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    if (localRect.top > 0) {
      return localRect.top;
    }
    return bdoo.b() - localRect.height();
  }
  
  private void f()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    a(2131562475);
    setFocusable(true);
    setBackgroundDrawable(null);
    setWidth(-1);
    setHeight(-1);
    this.jdField_a_of_type_ComTencentComponentAnimationReboundSpring = SpringSystem.create().createSpring().setSpringConfig(jdField_a_of_type_ComTencentComponentAnimationReboundSpringConfig).addListener(new bkhl(this));
    this.jdField_a_of_type_Bkhp = new bkhp(this, this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365498));
    this.jdField_a_of_type_AndroidWidgetListView.setFooterDividersEnabled(false);
    this.jdField_a_of_type_AndroidWidgetListView.setHeaderDividersEnabled(false);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Bkhp);
    this.jdField_a_of_type_AndroidWidgetListView.setOnTouchListener(new bkhm(this));
  }
  
  private void g()
  {
    super.dismiss();
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentComponentAnimationReboundSpring == null) {
      return;
    }
    float f1 = (float)this.jdField_a_of_type_ComTencentComponentAnimationReboundSpring.getCurrentValue();
    float f2 = (float)a(f1, 0.0D, 1.0D, 0.0D, 1.0D);
    if (f1 < 0.0F) {
      this.jdField_a_of_type_Boolean = true;
    }
    float f3;
    if (this.jdField_a_of_type_Boolean)
    {
      f1 = (float)this.jdField_a_of_type_ComTencentComponentAnimationReboundSpring.getEndValue();
      f3 = (float)this.jdField_a_of_type_ComTencentComponentAnimationReboundSpring.getEndValue();
    }
    for (;;)
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, f1);
      a(this.jdField_a_of_type_AndroidWidgetListView, 1.0F);
      bdoo.b(this.jdField_a_of_type_AndroidWidgetListView, f3);
      bdoo.c(this.jdField_a_of_type_AndroidWidgetListView, f3);
      if (this.jdField_c_of_type_Boolean)
      {
        bdoo.e(this.jdField_a_of_type_AndroidWidgetListView, 0.0F);
        bdoo.d(this.jdField_a_of_type_AndroidWidgetListView, this.jdField_c_of_type_Int);
      }
      for (;;)
      {
        if ((this.jdField_b_of_type_Boolean) || (f3 != 0.0F)) {
          break label221;
        }
        g();
        return;
        if (!this.jdField_b_of_type_Boolean) {
          break label223;
        }
        float f4 = this.jdField_b_of_type_Float;
        this.jdField_b_of_type_Float += this.jdField_a_of_type_Float;
        f1 = f4;
        f3 = f2;
        if (this.jdField_b_of_type_Float <= 1.0F) {
          break;
        }
        this.jdField_b_of_type_Float = 1.0F;
        f1 = f4;
        f3 = f2;
        break;
        bdoo.e(this.jdField_a_of_type_AndroidWidgetListView, this.d);
        bdoo.d(this.jdField_a_of_type_AndroidWidgetListView, this.jdField_c_of_type_Int);
      }
      label221:
      break;
      label223:
      f1 = f2;
      f3 = f2;
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public View a()
  {
    return a().findViewById(16908290).getRootView();
  }
  
  public void a()
  {
    if (isShowing()) {
      return;
    }
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0.0F);
    bdoo.a(this.jdField_a_of_type_AndroidWidgetListView, jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    super.showAtLocation(a(), 17, 0, 0);
    c();
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    if ((this.jdField_a_of_type_AndroidWidgetListView != null) && (paramOnItemClickListener != null)) {
      this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(paramOnItemClickListener);
    }
  }
  
  public void a(bkhq parambkhq)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (parambkhq != null)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(parambkhq);
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_AndroidWidgetListView == null)) {
      return false;
    }
    paramInt1 = bdoo.a() - this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight() * 2;
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetListView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new RelativeLayout.LayoutParams(paramInt1, this.jdField_b_of_type_Int);
    }
    int i = b();
    localLayoutParams1.width = paramInt1;
    localLayoutParams1.height = this.jdField_b_of_type_Int;
    localLayoutParams1.topMargin = (paramInt2 - i - bdoo.b(5.0F));
    this.jdField_a_of_type_AndroidWidgetListView.setLayoutParams(localLayoutParams1);
    this.d = this.jdField_b_of_type_Int;
    this.jdField_c_of_type_Int = (paramInt1 - (this.jdField_a_of_type_Int / 2 - this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight()));
    return true;
  }
  
  public int b()
  {
    int i;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() > 0)
    {
      i = bdoo.b() - this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
      if (i > bdoo.b(25.0F)) {}
    }
    int j;
    do
    {
      return i;
      j = c();
      i = j;
    } while (j > 0);
    return bdoo.b(25.0F);
  }
  
  public void b()
  {
    if (isShowing()) {
      return;
    }
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0.0F);
    bdoo.a(this.jdField_a_of_type_AndroidWidgetListView, jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    if (this.jdField_a_of_type_AndroidWidgetListView != null) {
      this.jdField_a_of_type_AndroidWidgetListView.setPadding(this.jdField_a_of_type_AndroidWidgetListView.getPaddingLeft(), this.jdField_a_of_type_AndroidWidgetListView.getPaddingTop() + bdoo.b(9.0F), this.jdField_a_of_type_AndroidWidgetListView.getPaddingRight(), this.jdField_a_of_type_AndroidWidgetListView.getPaddingBottom());
    }
    super.showAtLocation(a(), 17, 0, 0);
    c();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentComponentAnimationReboundSpring == null) {}
    while (this.jdField_a_of_type_ComTencentComponentAnimationReboundSpring.getCurrentValue() != this.jdField_a_of_type_ComTencentComponentAnimationReboundSpring.getEndValue()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentComponentAnimationReboundSpring.getEndValue() == 0.0D)
    {
      this.jdField_a_of_type_ComTencentComponentAnimationReboundSpring.setEndValue(1.0D);
      return;
    }
    this.jdField_a_of_type_ComTencentComponentAnimationReboundSpring.setEndValue(0.0D);
  }
  
  public void d()
  {
    dismiss();
  }
  
  public void dismiss()
  {
    this.jdField_b_of_type_Boolean = false;
    c();
  }
  
  public void e()
  {
    int i = 0;
    int j = 0;
    while (i < this.jdField_a_of_type_Bkhp.getCount())
    {
      View localView = this.jdField_a_of_type_Bkhp.getView(i, null, this.jdField_a_of_type_AndroidWidgetListView);
      localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      j += localView.getMeasuredHeight();
      i += 1;
    }
    this.jdField_b_of_type_Int = (bdoo.b(9.0F) + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkhk
 * JD-Core Version:    0.7.0.1
 */