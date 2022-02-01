import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.onlinestatus.OnlineStatusFriendsPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

public class axyy
  extends axzb
  implements Handler.Callback, View.OnClickListener, axuv, axvn, axvo, axvr
{
  public int a;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected ViewGroup a;
  public Button a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected TextView a;
  private axut jdField_a_of_type_Axut;
  protected axvx a;
  protected BaseActivity a;
  protected OnlineStatusPermissionChecker.OnlineStatusPermissionItem a;
  private AppRuntime.Status jdField_a_of_type_MqqAppAppRuntime$Status;
  private boolean jdField_a_of_type_Boolean = true;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  
  public axyy(@NonNull BaseActivity paramBaseActivity, axut paramaxut)
  {
    super(paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Axut = paramaxut;
    if (paramaxut == null) {
      this.jdField_a_of_type_Axut = new axut();
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    c();
  }
  
  private void c()
  {
    this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131559188, null);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131379877));
    this.jdField_d_of_type_AndroidWidgetTextView.setTypeface(Typeface.defaultFromStyle(1));
    this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131365098);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131363966));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131363794));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131364103));
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(2));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131379665));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131367280));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377016));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_c_of_type_AndroidViewView.findViewById(2131372031));
    this.jdField_b_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView;
    this.jdField_a_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView;
    setContentView(this.jdField_c_of_type_AndroidViewView);
  }
  
  private void f()
  {
    boolean bool = axvj.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
    int i;
    if (bool)
    {
      i = 0;
      if (!bool) {
        break label73;
      }
    }
    label73:
    for (int j = 32;; j = 86)
    {
      j = AIOUtils.dp2px(j, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(i);
      if (i == 0) {
        axvz.a("0X800B0F0");
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(j, 0, j, 0);
      return;
      i = 8;
      break;
    }
  }
  
  public OnlineStatusPermissionChecker.OnlineStatusPermissionItem a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
  }
  
  public ArrayList<axvj> a()
  {
    Object localObject = (apzf)apub.a().a(652);
    ArrayList localArrayList = new ArrayList();
    if ((localObject == null) || (((apzf)localObject).a == null)) {
      return localArrayList;
    }
    localObject = ((apzf)localObject).a.a(false).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add((axyc)((Iterator)localObject).next());
    }
    return localArrayList;
  }
  
  protected void a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    this.jdField_a_of_type_MqqAppAppRuntime$Status = localQQAppInterface.getOnlineStatus();
    this.jdField_a_of_type_Long = axuy.a().a(localQQAppInterface);
    f();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 999) && (paramInt2 == -1) && (paramIntent.getSerializableExtra("online_status_permission_item") != null))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramIntent.getSerializableExtra("online_status_permission_item"));
      b(false);
    }
  }
  
  public void a(View paramView) {}
  
  public void a(axvj paramaxvj1, axvj paramaxvj2, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusSelectView", 2, new Object[] { "oldItem =", paramaxvj1, " oldItem=", paramaxvj2 });
    }
    int i;
    if ((paramaxvj1 == null) && (paramaxvj2 != null))
    {
      i = 1;
      if (i != 0) {
        break label106;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691221);
    }
    for (;;)
    {
      b(false);
      if (i != 0) {
        axvz.a("0X800AF3F", (int)paramaxvj2.jdField_a_of_type_Long, String.valueOf(this.jdField_a_of_type_Int));
      }
      return;
      i = 0;
      break;
      label106:
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if ((paramaxvj2 instanceof axyc)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(((axyc)paramaxvj2).c);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
    }
  }
  
  public void a(OnlineStatusFriendsPermissionItem paramOnlineStatusFriendsPermissionItem, List<Integer> paramList)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, paramOnlineStatusFriendsPermissionItem.allHasPermission, paramOnlineStatusFriendsPermissionItem.permissionUins);
      b(true);
    }
  }
  
  public void a(OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = paramOnlineStatusPermissionItem;
    if (paramOnlineStatusPermissionItem == null) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public void a(boolean paramBoolean, Bitmap paramBitmap, int paramInt)
  {
    if ((paramBoolean) && (paramBitmap != null) && (this.jdField_c_of_type_AndroidViewView != null)) {
      this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
    }
    while (this.jdField_c_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setBackgroundColor(paramInt);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusSelectView", 2, new Object[] { "hasChange =", Boolean.valueOf(paramBoolean1), " isSmartListEmpty=", Boolean.valueOf(paramBoolean2) });
    }
    if (!axvj.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131691215);
      if (paramBoolean2)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    if ((paramBoolean1) && (paramBoolean2))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131691216);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131691216);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(1));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131692909);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(2));
  }
  
  protected void a(int[] paramArrayOfInt)
  {
    if ((this.jdField_b_of_type_AndroidViewView.getWidth() != 0) && (this.jdField_b_of_type_AndroidViewView.getHeight() != 0))
    {
      paramArrayOfInt[0] = this.jdField_b_of_type_AndroidViewView.getWidth();
      paramArrayOfInt[1] = this.jdField_b_of_type_AndroidViewView.getHeight();
      return;
    }
    paramArrayOfInt[0] = (this.jdField_b_of_type_AndroidViewView.getResources().getDisplayMetrics().widthPixels - AIOUtils.dp2px(26.0F, this.jdField_b_of_type_AndroidViewView.getResources()));
    paramArrayOfInt[1] = AIOUtils.dp2px(480.0F, this.jdField_b_of_type_AndroidViewView.getResources());
  }
  
  protected boolean a()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem == null)
    {
      OnlineStatusFriendsPermissionItem localOnlineStatusFriendsPermissionItem = ((axvp)((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getManager(370)).a(40001L, false, this);
      return (localOnlineStatusFriendsPermissionItem != null) && (!localOnlineStatusFriendsPermissionItem.allHasPermission);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.isAllHasPermission()) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  protected boolean a(boolean paramBoolean)
  {
    axvp localaxvp = (axvp)((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getManager(370);
    if ((this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem != null) && (localaxvp.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem, this))) {
      return true;
    }
    if (paramBoolean) {
      return false;
    }
    return localaxvp.a(this.jdField_a_of_type_Axvx.a());
  }
  
  public ArrayList<axvj> b()
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = ((axvp)((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getManager(370)).a();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      ArrayList localArrayList2 = a();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        Iterator localIterator = localArrayList2.iterator();
        while (localIterator.hasNext())
        {
          axvj localaxvj = (axvj)localIterator.next();
          if (localaxvj.jdField_a_of_type_Long == localInteger.intValue()) {
            localArrayList1.add(localaxvj);
          }
        }
      }
    }
    return localArrayList1;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691221);
    if (this.jdField_a_of_type_Axvx == null)
    {
      this.jdField_a_of_type_Axvx = new axvx(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidViewViewGroup, this, 3, 3, this, true);
      this.jdField_a_of_type_Axvx.a();
      return;
    }
    this.jdField_a_of_type_Axvx.b();
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (boolean bool1 = b();; bool1 = this.jdField_a_of_type_Axvx.a().isEmpty())
    {
      boolean bool2 = a();
      boolean bool3 = a(paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusSelectView", 2, new Object[] { "isSmartListEmpty =", Boolean.valueOf(bool1), " hasPartVisible=", Boolean.valueOf(bool2), " hasDataChange=", Boolean.valueOf(bool3), " fromShow=", Boolean.valueOf(paramBoolean) });
      }
      a(bool3, bool1);
      b(bool2, bool1);
      return;
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    for (;;)
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      int i = 2131691214;
      if (paramBoolean1) {
        i = 2131691220;
      }
      String str1 = getContext().getResources().getString(i);
      String str2 = getContext().getResources().getString(2131691219);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(new QQText(str1, 3, 16));
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(str1);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(str2);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new axyz(this, paramBoolean1));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(new mun());
      if (bjuk.a()) {
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837509, 0);
      }
      while (AppSetting.c)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setAccessibilityDelegate(new axza(this));
        return;
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837508, 0);
      }
    }
  }
  
  protected boolean b()
  {
    List localList = ((axvp)((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getManager(370)).a();
    if (localList == null) {
      return true;
    }
    return localList.isEmpty();
  }
  
  public ArrayList<Integer> c()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_a_of_type_Axvx.a();
    if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
      return localArrayList;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(Integer.valueOf((int)((axvj)((Iterator)localObject).next()).jdField_a_of_type_Long));
    }
    return localArrayList;
  }
  
  protected void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691221);
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131376687)
    {
      dismiss();
      axvz.a("0X800AF94");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131363794)
      {
        axvz.a("0X800B0F1");
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.updateOnlineStatus(AppRuntime.Status.online, 0L);
        dismiss();
      }
    }
  }
  
  public void show()
  {
    if (ThemeUtil.isNowThemeIsNight(null, false, ""))
    {
      this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130846045);
      a(false, null, Color.parseColor("#FF010101"));
    }
    for (;;)
    {
      b();
      a();
      b(true);
      a(this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, 2131165620, 2131167305);
      super.show();
      b(true);
      return;
      this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130846044);
      axuu localaxuu = new axuu();
      localaxuu.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      this.jdField_a_of_type_Axut.a(localaxuu, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axyy
 * JD-Core Version:    0.7.0.1
 */