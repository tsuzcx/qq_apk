import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.8;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.9;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import mqq.app.AppRuntime;

public class bbhb
  extends bbhl
  implements DialogInterface.OnDismissListener, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  Resources jdField_a_of_type_AndroidContentResResources = null;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  public WindowManager.LayoutParams a;
  public WindowManager a;
  public EditText a;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  public RelativeLayout a;
  protected ScrollView a;
  private bbjr jdField_a_of_type_Bbjr;
  bbjt jdField_a_of_type_Bbjt = new bbhc(this);
  EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = null;
  SystemEmoticonPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = null;
  public SoftReference<Context> a;
  public boolean a;
  boolean b = false;
  public boolean c;
  int h = 1;
  
  public bbhb(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_Boolean = true;
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    if (localLayoutParams != null) {
      localLayoutParams.gravity = 17;
    }
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramContext);
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    getWindow().setSoftInputMode(19);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    boolean bool;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label194;
      }
    }
    label194:
    for (paramInt = bbjr.a(0);; paramInt = (int)(150.0F * this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density))
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams(-1, paramInt, 2, 32, -1);
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 81;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = 2131755180;
      return;
      bool = false;
      break;
    }
  }
  
  private void a()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.height = -2;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
    }
  }
  
  public int a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      return "";
    }
    Object localObject;
    if ((this.jdField_a_of_type_AndroidWidgetEditText.getText() instanceof aykx))
    {
      localObject = (aykx)this.jdField_a_of_type_AndroidWidgetEditText.getText();
      if (localObject != null) {
        return ((aykx)localObject).a();
      }
    }
    else if ((this.jdField_a_of_type_AndroidWidgetEditText.getText() instanceof ayks))
    {
      localObject = (ayks)this.jdField_a_of_type_AndroidWidgetEditText.getText();
      if (localObject != null) {
        return ((ayks)localObject).a();
      }
    }
    return this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
  }
  
  void a(Context paramContext)
  {
    bbhk localbbhk = new bbhk(this);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      int i = getContext().getResources().getDimensionPixelSize(2131298865);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)View.inflate(getContext(), 2131559018, null));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(localbbhk);
      paramContext = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
      if (this.h == 7) {}
      for (boolean bool = true;; bool = false)
      {
        paramContext.b = bool;
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a((QQAppInterface)localAppRuntime, 100003, getContext(), i, null, null, false);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.s();
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = this.jdField_a_of_type_Int;
        return;
      }
    }
    QLog.e("QQCustomDialogWtihEmoticonInput", 1, "get QQAppInterface fail");
    if (this.h == 7)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = new SystemAndEmojiEmoticonPanel(paramContext, localbbhk);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = new SystemEmoticonPanel(paramContext, localbbhk);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(aykx.c);
    }
  }
  
  public void b(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void b(String paramString)
  {
    if (paramString != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new bbhj(this, paramInt));
    }
  }
  
  public String getEditString()
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    return this.jdField_a_of_type_AndroidWidgetEditText.getHint().toString();
  }
  
  public EditText getEditText()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText;
  }
  
  public String getInputValue()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
  }
  
  public void hideSoftInputFromWindow()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (this.jdField_a_of_type_Boolean) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
    }
    while (paramView.getId() == 2131365561)
    {
      if (localObject != null)
      {
        if (this.c)
        {
          a();
          this.jdField_a_of_type_AndroidViewWindowManager.removeView((View)localObject);
          this.c = false;
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839619);
          this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130839619));
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new QQCustomDialogWtihEmoticonInput.8(this), 200L);
          paramView = getWindow().getAttributes();
          paramView.y = 0;
          getWindow().setAttributes(paramView);
        }
      }
      else
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel;
        continue;
      }
      paramView = this.jdField_a_of_type_AndroidWidgetImageView.getTag();
      if ((paramView != null) && ((paramView instanceof Integer)) && (((Integer)paramView).intValue() == 2130839620))
      {
        bfmr.a(this.jdField_a_of_type_AndroidWidgetEditText);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839619);
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130839619));
        this.c = false;
        return;
      }
      bfmr.b(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839620);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130839620));
      if (this.jdField_a_of_type_Boolean) {
        ((View)localObject).setMinimumHeight(bbjr.a(0));
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new QQCustomDialogWtihEmoticonInput.9(this, (View)localObject), 200L);
      return;
    }
    if (this.c)
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeView((View)localObject);
      this.c = false;
      a();
    }
    paramView = getWindow().getAttributes();
    paramView.y = 0;
    getWindow().setAttributes(paramView);
    bfmr.b(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i();
    }
    if (this.jdField_a_of_type_Bbjr != null) {
      this.jdField_a_of_type_Bbjr.a();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 1) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (this.c)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label86;
      }
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
    }
    for (;;)
    {
      this.c = false;
      WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
      localLayoutParams.y = 0;
      getWindow().setAttributes(localLayoutParams);
      a();
      bfmr.b(this.jdField_a_of_type_AndroidWidgetEditText);
      super.onTouchEvent(paramMotionEvent);
      return true;
      label86:
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel);
    }
  }
  
  @TargetApi(11)
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365143));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131368186));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365561));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    findViewById(2131375657).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(ayks.b);
    this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine(this.b);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new bbhf(this));
    Object localObject = (Context)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    if (localObject == null) {
      return;
    }
    ynw.a((Context)localObject, this.jdField_a_of_type_AndroidWidgetEditText);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Bbjr = new bbjr(((ViewGroup)getWindow().getDecorView().findViewById(16908290)).getChildAt(0), this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getHeight(), this.jdField_a_of_type_Bbjt);
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Bbjr.a();
      this.jdField_a_of_type_Int = bbjr.a(this.jdField_a_of_type_Int);
      setOnDismissListener(this);
      a((Context)localObject);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setDispatchKeyEventListener(new bbhg(this));
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375650);
      if ((localObject instanceof ScrollView)) {
        this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)localObject);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new bbhi(this));
      return;
      a((Context)localObject);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setBackgroundResource(2130837709);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setMinimumHeight(actn.a(150.0F, this.jdField_a_of_type_AndroidContentResResources));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setDispatchKeyEventListener(new bbhh(this));
    }
  }
  
  public void setEditLint(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramString);
  }
  
  public bbgg setNegativeButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    hideSoftInputFromWindow();
    this.lBtn.setText(paramInt);
    this.lBtn.setContentDescription(getContext().getString(paramInt) + getContext().getString(2131691105));
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new bbhd(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public bbgg setPositiveButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramInt);
    this.rBtn.setContentDescription(getContext().getString(paramInt));
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new bbhe(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public bbgg setPreviewImage(Drawable paramDrawable, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    int i = paramDrawable.getIntrinsicWidth();
    Object localObject;
    if (paramDrawable.getIntrinsicHeight() > i)
    {
      localObject = ((URLDrawable)paramDrawable).getCurrDrawable();
      if ((localObject instanceof RegionDrawable))
      {
        localObject = ((RegionDrawable)localObject).getBitmap();
        if (localObject != null)
        {
          Matrix localMatrix = new Matrix();
          localMatrix.postScale(0.5F, 0.5F);
          localObject = Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), localMatrix, true);
          if (localObject != null)
          {
            localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentResResources, (Bitmap)localObject);
            ((BitmapDrawable)localObject).setBounds(0, 0, ((BitmapDrawable)localObject).getIntrinsicWidth(), ((BitmapDrawable)localObject).getIntrinsicHeight());
          }
        }
      }
    }
    for (;;)
    {
      if (localObject == null) {
        return super.setPreviewImage(paramDrawable, paramBoolean1, paramInt, paramBoolean2);
      }
      return super.setPreviewImage((Drawable)localObject, paramBoolean1, paramInt, paramBoolean2);
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbhb
 * JD-Core Version:    0.7.0.1
 */