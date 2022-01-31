import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bfsm
  extends PopupWindow
  implements View.OnClickListener
{
  protected int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  protected Button a;
  protected ImageView a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected bfsp a;
  protected bfsq a;
  protected ArrayList<DislikeInfo> a;
  protected boolean a;
  protected int[] a;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private Button[] jdField_a_of_type_ArrayOfAndroidWidgetButton;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  protected ArrayList<DislikeInfo> b;
  private boolean jdField_b_of_type_Boolean;
  protected int[] b;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  private int e;
  
  public bfsm(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ArrayOfInt = new int[] { 2131378626, 2131378627, 2131378628, 2131378629 };
    this.jdField_b_of_type_ArrayOfInt = new int[] { 2131378631, 2131378632, 2131378633, 2131378634, 2131378635, 2131378636, 2131378637, 2131378638 };
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131699661));
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  private void e()
  {
    d();
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (i >= this.jdField_a_of_type_ArrayOfAndroidWidgetButton.length)
    {
      i = this.jdField_a_of_type_ArrayOfAndroidWidgetButton.length;
      j = 0;
      label29:
      if (j >= i) {
        break label121;
      }
      if (!TextUtils.isEmpty(((DislikeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j)).a)) {
        break label85;
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setSelected(false);
      j += 1;
      break label29;
      break;
      label85:
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setVisibility(0);
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setText(((DislikeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j)).a);
    }
    label121:
    int j = i;
    if (j < this.jdField_a_of_type_ArrayOfAndroidWidgetButton.length)
    {
      if ((j == i) && (i % 2 == 1)) {
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setVisibility(4);
      }
      for (;;)
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setSelected(false);
        j += 1;
        break;
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setVisibility(8);
      }
    }
    i = 1;
    if (i < this.jdField_a_of_type_ArrayOfAndroidWidgetButton.length)
    {
      if (this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].getVisibility() == 8) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[(i / 2)].setVisibility(8);
      }
      for (;;)
      {
        i += 2;
        break;
        this.jdField_a_of_type_ArrayOfAndroidViewView[(i / 2)].setVisibility(0);
      }
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidViewView.measure(0, 0);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
  }
  
  public void a()
  {
    this.d = ((int)bbct.i());
    this.e = ((int)bbct.j());
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2131559823, null);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378630));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131378622));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131378624);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378639));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131378621));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378625));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378623));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378642));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378641));
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[this.jdField_a_of_type_ArrayOfInt.length];
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      this.jdField_a_of_type_ArrayOfAndroidViewView[i] = this.jdField_a_of_type_AndroidViewView.findViewById(this.jdField_a_of_type_ArrayOfInt[i]);
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfAndroidWidgetButton = new Button[this.jdField_b_of_type_ArrayOfInt.length];
    i = 0;
    while (i < this.jdField_b_of_type_ArrayOfInt.length)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i] = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(this.jdField_b_of_type_ArrayOfInt[i]));
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].setOnClickListener(this);
      i += 1;
    }
    setHeight(-2);
    setBackgroundDrawable(new ColorDrawable(0));
    setOnDismissListener(new bfsn(this));
    setTouchable(true);
    setFocusable(true);
    setOutsideTouchable(false);
    this.jdField_b_of_type_Boolean = true;
  }
  
  protected void a(IBinder paramIBinder)
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.format = -3;
    localLayoutParams.type = 1000;
    localLayoutParams.token = paramIBinder;
    localLayoutParams.windowAnimations = 16973828;
    this.jdField_c_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    this.jdField_c_of_type_AndroidViewView.setBackgroundColor(-1895825408);
    this.jdField_c_of_type_AndroidViewView.setFitsSystemWindows(false);
    this.jdField_c_of_type_AndroidViewView.setOnKeyListener(new bfso(this));
    this.jdField_a_of_type_AndroidAppActivity.getWindowManager().addView(this.jdField_c_of_type_AndroidViewView, localLayoutParams);
  }
  
  public void a(View paramView, bfsq parambfsq)
  {
    this.jdField_a_of_type_Bfsq = parambfsq;
    a(paramView.getWindowToken());
    parambfsq = new int[2];
    paramView.getLocationOnScreen(parambfsq);
    int j;
    int i;
    int n;
    if (!this.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KandianPopupWindow", 2, "DeviceInfoUtil.getWidth() = " + this.d + ", DeviceInfoUtil.getHeight() = " + this.e);
      }
      if (QLog.isColorLevel()) {
        QLog.d("KandianPopupWindow", 2, "popupWidth = " + this.jdField_b_of_type_Int + ", popupHeight = " + this.jdField_c_of_type_Int);
      }
      if (QLog.isColorLevel()) {
        QLog.d("KandianPopupWindow", 2, "x = " + parambfsq[0] + ", y = " + parambfsq[1]);
      }
      if (QLog.isColorLevel()) {
        QLog.d("KandianPopupWindow", 2, "parent.getWidth() = " + paramView.getWidth() + ", parent.getHeight() = " + paramView.getHeight());
      }
      j = this.e;
      int k = parambfsq[1];
      int m = paramView.getHeight();
      i = parambfsq[1];
      i = (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298591);
      n = this.jdField_b_of_type_Int - parambfsq[0] - paramView.getWidth() / 2 + i;
      if (QLog.isColorLevel()) {
        QLog.d("KandianPopupWindow", 2, "marginRight = " + n);
      }
      if (j - (k + m) > this.jdField_c_of_type_Int) {
        if (n > this.jdField_b_of_type_Int * 0.1D)
        {
          setAnimationStyle(2131755033);
          this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, n, 0);
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          j = parambfsq[1] + paramView.getHeight() / 2 + actn.a(9.5F, this.jdField_a_of_type_AndroidAppActivity.getResources());
          showAtLocation(paramView, 0, i, j);
          if (QLog.isColorLevel()) {
            QLog.d("KandianPopupWindow", 2, "show x = " + i + ", show y = " + j);
          }
        }
      }
    }
    for (;;)
    {
      onk.jdField_a_of_type_Boolean = true;
      return;
      setAnimationStyle(2131755032);
      break;
      if (n > this.jdField_b_of_type_Int * 0.1D) {
        setAnimationStyle(2131755036);
      }
      for (;;)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, 0, n, 0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        j = parambfsq[1] + paramView.getHeight() / 2 - actn.a(9.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - this.jdField_c_of_type_Int;
        showAtLocation(paramView, 0, i, j);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("KandianPopupWindow", 2, "show x = " + i + ", show y = " + j);
        break;
        setAnimationStyle(2131755035);
      }
      setAnimationStyle(2131755034);
      showAtLocation(paramView, 0, parambfsq[0] + paramView.getWidth() / 2 - actn.a(10.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298592), parambfsq[1] + paramView.getHeight() / 2 - this.jdField_c_of_type_Int / 2);
    }
  }
  
  public void a(bfsp parambfsp)
  {
    this.jdField_a_of_type_Bfsp = parambfsp;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(int paramInt, ArrayList<DislikeInfo> paramArrayList)
  {
    if (paramInt == -1) {
      return false;
    }
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    }
    while ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298592));
      setWidth(this.jdField_b_of_type_Int);
      f();
      return true;
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_b_of_type_Int = ((int)(this.d - this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298591) * 2.0F));
    setWidth(this.jdField_b_of_type_Int);
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      e();
      break;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130842463);
    }
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842472);
      if (RelativeLayout.LayoutParams.class.isInstance(this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams()))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
        localLayoutParams.addRule(3, 2131378623);
        this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  protected void c()
  {
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidAppActivity.getWindowManager().removeView(this.jdField_c_of_type_AndroidViewView);
      this.jdField_c_of_type_AndroidViewView = null;
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    switch (paramView.getId())
    {
    default: 
      i = 0;
      if (i < this.jdField_b_of_type_ArrayOfInt.length) {
        if (paramView.getId() != this.jdField_b_of_type_ArrayOfInt[i]) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      if (i != -1)
      {
        if (!this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].isSelected()) {
          break label193;
        }
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].setSelected(false);
        this.jdField_b_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      for (;;)
      {
        if (this.jdField_b_of_type_JavaUtilArrayList.size() != 0) {
          break label267;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131699661));
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        return;
        if (this.jdField_a_of_type_Bfsq != null) {
          this.jdField_a_of_type_Bfsq.a(paramView, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaUtilArrayList, null);
        }
        dismiss();
        return;
        if (this.jdField_a_of_type_Bfsp != null) {
          this.jdField_a_of_type_Bfsp.a();
        }
        dismiss();
        return;
        i += 1;
        break;
        label193:
        if (!this.jdField_a_of_type_Boolean)
        {
          paramView = this.jdField_a_of_type_ArrayOfAndroidWidgetButton;
          int k = paramView.length;
          int j = 0;
          while (j < k)
          {
            paramView[j].setSelected(false);
            j += 1;
          }
          this.jdField_b_of_type_JavaUtilArrayList.clear();
        }
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].setSelected(true);
        this.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      label267:
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131699662), new Object[] { Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()) }));
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfsm
 * JD-Core Version:    0.7.0.1
 */