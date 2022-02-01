import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.teamworkforgroup.GPadInfo;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWordkMoreView;
import com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.10;
import com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.11;
import com.tencent.mobileqq.troop.widget.CountdownTimeTask;
import com.tencent.mobileqq.troop.widget.SingleLineHotwordTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.List;
import mqq.os.MqqHandler;

public class bczc
  extends ReportDialog
  implements Handler.Callback, bcts
{
  public static int d;
  public static int e;
  public int a;
  protected long a;
  protected Activity a;
  private Bitmap a;
  protected Handler a;
  protected View a;
  protected ViewGroup a;
  public EditText a;
  protected ImageButton a;
  protected RelativeLayout a;
  protected TextView a;
  protected bcxt a;
  protected bcxv a;
  protected bcyn a;
  protected QQAppInterface a;
  public GroupTeamWordkMoreView a;
  public CountdownTimeTask a;
  protected XListView a;
  protected Object a;
  public String a;
  protected List<GPadInfo> a;
  protected boolean a;
  public int b;
  protected long b;
  protected TextView b;
  public boolean b;
  protected int c;
  public boolean c;
  protected boolean d;
  protected boolean e;
  
  static
  {
    jdField_d_of_type_Int = 10;
    jdField_e_of_type_Int = 16;
  }
  
  public bczc(Activity paramActivity, View paramView, QQAppInterface paramQQAppInterface, long paramLong)
  {
    super(paramActivity, 2131755340);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Bcyn = new bczl(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bcxv = ((bcxv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(143));
    this.jdField_a_of_type_Long = paramLong;
    a(paramActivity);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376347));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131376951));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131370269));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370271));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379818));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131364579);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131368234));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    a();
    e();
    a(paramActivity, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bcyn);
    a(paramView);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new bczj(this));
    Button localButton = (Button)findViewById(2131363774);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new bczk(this));
  }
  
  protected float a()
  {
    float f2 = this.jdField_a_of_type_AndroidWidgetEditText.getWidth() - bfvh.a(this.jdField_a_of_type_AndroidAppActivity, 20.0F);
    float f1 = f2;
    if (this.jdField_b_of_type_Int > 0) {
      f1 = f2 - (this.jdField_a_of_type_AndroidWidgetEditText.getPaint().measureText(a(this.jdField_b_of_type_Int)) + bfvh.a(this.jdField_a_of_type_AndroidAppActivity, 16.0F));
    }
    f2 = f1;
    if (this.jdField_a_of_type_AndroidWidgetImageButton.getVisibility() == 0) {
      f2 = f1 - (this.jdField_a_of_type_AndroidWidgetImageButton.getWidth() + bfvh.a(this.jdField_a_of_type_AndroidAppActivity, 8.0F));
    }
    return f2;
  }
  
  protected String a(int paramInt)
  {
    if (paramInt > 1000) {
      return this.jdField_a_of_type_AndroidAppActivity.getString(2131696821);
    }
    return this.jdField_a_of_type_AndroidAppActivity.getString(2131696819, new Object[] { Integer.valueOf(paramInt) });
  }
  
  protected String a(String paramString)
  {
    float f = a();
    TextPaint localTextPaint = this.jdField_a_of_type_AndroidWidgetEditText.getPaint();
    if ((TextUtils.isEmpty(paramString)) || (localTextPaint.measureText(paramString) <= f)) {
      return paramString;
    }
    return paramString.substring(0, localTextPaint.breakText(paramString, true, f - localTextPaint.measureText("…"), null)) + "…";
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366179));
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717987));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new bczh(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new bczi(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  public final void a(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      try
      {
        int i = this.jdField_a_of_type_Int;
        if (i > 0) {
          return;
        }
        if (TextUtils.isEmpty(paramString))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("TroopTeamWorkFileSearchDialog", 4, "doReqTroopFileSearch err keyWord =" + paramString);
          continue;
        }
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      finally {}
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Bcxv != null) {
        this.jdField_a_of_type_Bcxv.a(paramLong, paramString, paramInt1, paramInt2, paramInt3);
      }
    }
  }
  
  protected void a(Activity paramActivity)
  {
    requestWindowFeature(1);
    getWindow().setSoftInputMode(36);
    if (!VersionUtils.isHoneycomb()) {
      getWindow().setBackgroundDrawable(new ColorDrawable());
    }
    for (;;)
    {
      setContentView(2131559913);
      findViewById(2131370309).setOnClickListener(new bczd(this));
      Object localObject = getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).x = 0;
      ((WindowManager.LayoutParams)localObject).y = 0;
      ((WindowManager.LayoutParams)localObject).width = -1;
      ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
      ((WindowManager.LayoutParams)localObject).gravity = 51;
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        getWindow().addFlags(67108864);
        int i = paramActivity.getResources().getColor(2131167070);
        if (ImmersiveUtils.a(getWindow(), true)) {
          i = paramActivity.getResources().getColor(2131167240);
        }
        new SystemBarCompact(this, true, i).init();
        localObject = (LinearLayout)findViewById(2131370309);
        ((LinearLayout)localObject).setFitsSystemWindows(true);
        ((LinearLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(paramActivity), 0, 0);
      }
      return;
      getWindow().setBackgroundDrawable(new ColorDrawable(paramActivity.getResources().getColor(2131165700)));
    }
  }
  
  protected void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView = new GroupTeamWordkMoreView(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setBackgroundResource(2130838891);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setTextColor(paramActivity.getResources().getColor(2131167012));
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setVisibility(8);
    this.jdField_a_of_type_Bcxt = new bcxt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bcxt);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new bcze(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new bczf(this));
    this.jdField_a_of_type_Bcxt.a(new bczg(this));
  }
  
  public void a(View paramView)
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.d("TroopTeamWorkFileSearchDialog", 2, "setBackgroundViewBlur, view :" + paramView.getHeight() + "," + paramView.getWidth());
    }
    if (paramView == null) {}
    boolean bool;
    Object localObject1;
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopTeamWorkFileSearchDialog", 2, "setBackgroundViewBlur, isDrawingCacheEnabled");
      }
      bool = paramView.isDrawingCacheEnabled();
      if (!bool) {
        paramView.setDrawingCacheEnabled(true);
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopTeamWorkFileSearchDialog", 2, "setBackgroundViewBlur, getDrawingCache");
        }
        localObject1 = paramView.getDrawingCache(true);
        if (localObject1 == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("TroopTeamWorkFileSearchDialog", 2, "getDrawingCache is return null");
        }
      }
      catch (Exception paramView)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopTeamWorkFileSearchDialog", 2, "getDrawingCache exception, " + paramView.getMessage());
        }
      }
      finally
      {
        if (0 == 0)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("TroopTeamWorkFileSearchDialog", 2, "getDrawingCache is return null");
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTeamWorkFileSearchDialog", 2, "setBackgroundViewBlur, start thread");
    }
    try
    {
      localObject1 = Bitmap.createBitmap((Bitmap)localObject1);
      a(paramView, bool, (Bitmap)localObject1);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("TroopTeamWorkFileSearchDialog", 2, "blurBitmap error", localOutOfMemoryError);
          localObject1 = localObject2;
        }
      }
    }
  }
  
  protected void a(View paramView, boolean paramBoolean, Bitmap paramBitmap)
  {
    ThreadManager.post(new TroopTeamWorkFileSearchDialog.10(this, paramBitmap, paramView, paramBoolean), 8, null, true);
  }
  
  public void a(PadInfo paramPadInfo) {}
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 533	bczc:c	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 129	bczc:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   18: iconst_1
    //   19: invokevirtual 536	android/os/Handler:sendEmptyMessage	(I)Z
    //   22: pop
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 84	bczc:jdField_a_of_type_Long	J
    //   28: aload_1
    //   29: iconst_0
    //   30: bipush 50
    //   32: iconst_0
    //   33: invokevirtual 537	bczc:a	(JLjava/lang/String;III)V
    //   36: goto -25 -> 11
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	bczc
    //   0	44	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	39	finally
    //   14	36	39	finally
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Int <= 0) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      TextPaint localTextPaint = this.jdField_a_of_type_AndroidWidgetEditText.getPaint();
      float f = a() - localTextPaint.measureText(paramString);
      if (f < 0.0F) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      while (QLog.isColorLevel())
      {
        QLog.e("zivonchen", 2, "resetResultNumTextVisible compareWidth = " + f + ", time = " + (System.currentTimeMillis() - l));
        return;
        if (paramBoolean)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(a(this.jdField_b_of_type_Int));
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130839445, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694452);
      localDrawable = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables()[0];
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).start();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables()[0];
    if ((localDrawable instanceof Animatable)) {
      ((Animatable)localDrawable).stop();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131694064));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  public void b(View paramView, boolean paramBoolean, Bitmap paramBitmap)
  {
    ThreadManager.getUIHandler().post(new TroopTeamWorkFileSearchDialog.11(this, paramView, paramBoolean));
    if (paramBitmap != null) {
      paramBitmap.recycle();
    }
  }
  
  public void b(PadInfo paramPadInfo) {}
  
  public void b(boolean paramBoolean)
  {
    a(false);
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131696816, new Object[] { this.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130843763, 0, 0);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables()[0];
    if ((localDrawable instanceof Animatable)) {
      ((Animatable)localDrawable).stop();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected void c()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.c = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask.b();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask = null;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    bjmm.a(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  protected void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setVisibility(0);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setText(2131718611);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setText(2131694452);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setTextLeftDrawable(2130839445);
  }
  
  protected void d()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a(this.jdField_b_of_type_Int));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_Boolean = true;
      String str = a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str.length());
      }
    }
  }
  
  public void dismiss()
  {
    this.c = true;
    bjmm.b(this.jdField_a_of_type_AndroidWidgetEditText);
    SingleLineHotwordTextView.a();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask.b();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_Bcxt != null)
    {
      this.jdField_a_of_type_Bcxt.a();
      this.jdField_a_of_type_Bcxt = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bcyn);
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.c) {
      return true;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      a(true);
      continue;
      a(false);
      continue;
      b(true);
      continue;
      b(false);
      continue;
      a(false);
      a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), true);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Bcxt.a();
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        bjmm.b(this.jdField_a_of_type_AndroidWidgetEditText);
      }
      c(this.jdField_e_of_type_Boolean);
      this.jdField_a_of_type_Bcxt.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Bcxt.notifyDataSetChanged();
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_b_of_type_Boolean = false;
      }
      long l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
      paramMessage = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim().toLowerCase();
      if (QLog.isColorLevel()) {
        QLog.e("zivonchen", 2, "REFRESH_LIST text = " + paramMessage + ", lastHotword = " + this.jdField_a_of_type_JavaLangString + ", time = " + l);
      }
      if ((!paramMessage.equals(this.jdField_a_of_type_JavaLangString)) && (l >= 800L))
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangString = paramMessage;
        a(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask = null;
      }
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bczc
 * JD-Core Version:    0.7.0.1
 */