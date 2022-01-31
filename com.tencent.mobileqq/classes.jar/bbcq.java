import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import tencent.im.oidb.cmd0xe2e.oidb_0xe2e.App;

public class bbcq
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  protected alzf a;
  protected amab a;
  public Context a;
  public FragmentActivity a;
  private View jdField_a_of_type_AndroidViewView;
  protected AdapterView.OnItemClickListener a;
  protected GridView a;
  protected bbcv a;
  public SessionInfo a;
  public QQAppInterface a;
  private Long jdField_a_of_type_JavaLangLong;
  private boolean jdField_a_of_type_Boolean = true;
  
  public bbcq(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new bbcu(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    try
    {
      this.jdField_a_of_type_Long = Long.valueOf(paramString).longValue();
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131559718, null);
      paramQQAppInterface = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376000);
      boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      if (bool) {
        paramQQAppInterface.setBackgroundDrawable(paramFragmentActivity.getResources().getDrawable(2130840249));
      }
      paramQQAppInterface = this.jdField_a_of_type_AndroidViewView.findViewById(2131377981);
      paramFragmentActivity = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363024);
      paramSessionInfo = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378993);
      if (bool) {
        paramSessionInfo.setTextColor(Color.parseColor("#ffffff"));
      }
      paramFragmentActivity.setOnClickListener(this);
      paramFragmentActivity.setOnTouchListener(new bbcr(this));
      paramSessionInfo = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370209);
      paramSessionInfo.setOnClickListener(this);
      paramSessionInfo.setOnTouchListener(new bbcs(this));
      if (AppSetting.c)
      {
        paramFragmentActivity.setContentDescription(alpo.a(2131707377));
        paramSessionInfo.setContentDescription(paramContext.getString(2131699986));
      }
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        paramFragmentActivity = (RelativeLayout.LayoutParams)paramQQAppInterface.getLayoutParams();
        int j = ImmersiveUtils.getStatusBarHeight(paramContext);
        int i = j;
        if (c()) {
          i = j - aekt.a(10.0F, paramQQAppInterface.getResources());
        }
        paramFragmentActivity.setMargins(0, i, 0, 0);
        paramQQAppInterface.setLayoutParams(paramFragmentActivity);
      }
      if (!bool)
      {
        paramQQAppInterface = URLDrawable.URLDrawableOptions.obtain();
        paramFragmentActivity = new ColorDrawable();
        paramFragmentActivity.setColor(Color.parseColor("#EBEDF5"));
        paramQQAppInterface.mRequestWidth = bdkf.a();
        paramQQAppInterface.mRequestHeight = bdkf.b();
        paramQQAppInterface.mFailedDrawable = paramFragmentActivity;
        paramQQAppInterface.mLoadingDrawable = paramFragmentActivity;
        paramQQAppInterface = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20200324170329_vqFCVSqE3E.png", paramQQAppInterface);
        if (paramQQAppInterface.getStatus() == 2) {
          paramQQAppInterface.restartDownload();
        }
        paramQQAppInterface.setDecodeHandler(bcuq.y);
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramQQAppInterface);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        this.jdField_a_of_type_Long = 0L;
        QLog.d("TroopAppShortcutContainer", 2, "TroopAppShortcutContainer troopuinerror:" + paramString);
      }
    }
  }
  
  private void a(int paramInt)
  {
    long l2;
    Object localObject;
    long l1;
    int i;
    if (b())
    {
      l2 = 0L;
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      l1 = l2;
      if (localObject == null) {
        break label294;
      }
      localObject = ((TroopManager)localObject).b(String.valueOf(this.jdField_a_of_type_Long));
      l1 = l2;
      if (localObject == null) {
        break label294;
      }
      l2 = ((TroopInfo)localObject).dwGroupClassExt;
      if (!((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) {
        break label223;
      }
      i = 1;
      l1 = l2;
    }
    for (;;)
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", "https://qun.qq.com/slidepanel/manage?_wv=16777218&_cwv=9&_wwv=129&gc=$GCODE$&gid=$GID$&gtype=$GTYPE$".replace("$GCODE$", Long.toString(this.jdField_a_of_type_Long)).replace("$GID$", Integer.toString(i)).replace("$GTYPE$", Long.toString(l1)));
      ((Intent)localObject).putExtra("webStyle", "noBottomBar");
      ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult((Intent)localObject, 20006);
      if (paramInt == 2) {
        azmj.b(null, "dc00898", "", "", "0X800AD0B", "0X800AD0B", 0, 0, Integer.toString(i), Long.toString(this.jdField_a_of_type_Long), Long.toString(l1), "");
      }
      label223:
      while (paramInt != 1)
      {
        return;
        l1 = l2;
        if (!((TroopInfo)localObject).isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) {
          break label294;
        }
        i = 2;
        l1 = l2;
        break;
      }
      azmj.b(null, "dc00898", "", "", "0X800AD0A", "0X800AD0A", 0, 0, Integer.toString(i), Long.toString(this.jdField_a_of_type_Long), Long.toString(l1), "");
      return;
      label294:
      i = 0;
    }
  }
  
  private void a(boolean paramBoolean, long paramLong, List paramList, int paramInt)
  {
    if (paramLong != this.jdField_a_of_type_Long) {
      return;
    }
    if (paramBoolean)
    {
      if ((paramList instanceof ArrayList))
      {
        Object localObject = (ArrayList)paramList;
        paramList = new ArrayList();
        paramInt = 0;
        if (paramInt < ((ArrayList)localObject).size())
        {
          oidb_0xe2e.App localApp = (oidb_0xe2e.App)((ArrayList)localObject).get(paramInt);
          if ((localApp.appid.has()) && (localApp.icon.has()) && (localApp.name.has()) && (localApp.url.has()))
          {
            bbcy localbbcy = new bbcy();
            localbbcy.jdField_a_of_type_Long = localApp.appid.get();
            localbbcy.jdField_a_of_type_JavaLangString = localApp.name.get();
            localbbcy.jdField_c_of_type_JavaLangString = localApp.url.get();
            localbbcy.jdField_b_of_type_JavaLangString = localApp.icon.get();
            if (localApp.removable.has()) {
              localbbcy.jdField_b_of_type_Int = localApp.removable.get();
            }
            if (localApp.source.has()) {
              localbbcy.jdField_c_of_type_Int = localApp.source.get();
            }
            localbbcy.jdField_a_of_type_Int = 0;
            paramList.add(localbbcy);
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopAppShortcutContainer", 2, "pbInfo:" + localApp.toString());
            }
            paramInt += 1;
            break;
            QLog.e("TroopAppShortcutContainer", 2, "get appinfo error:" + localApp.toString());
          }
        }
        localObject = (bbcz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(357);
        if (localObject != null) {
          ((bbcz)localObject).a(this.jdField_a_of_type_Long, paramList);
        }
        e();
      }
      paramList = (bbcz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(357);
      if (paramList == null) {
        break label585;
      }
    }
    label585:
    for (paramList = paramList.a(this.jdField_a_of_type_Long);; paramList = null)
    {
      if (paramList != null) {}
      for (paramInt = paramList.size();; paramInt = 0)
      {
        paramList = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        if (paramList != null)
        {
          paramList = paramList.b(String.valueOf(this.jdField_a_of_type_Long));
          if (paramList == null) {}
        }
        for (paramLong = paramList.dwGroupClassExt;; paramLong = 0L)
        {
          azmj.b(null, "dc00898", "", "", "0X800AD08", "0X800AD08", 0, 0, "", Long.toString(this.jdField_a_of_type_Long), Long.toString(paramLong), Integer.toString(paramInt));
          return;
          QLog.e("TroopAppShortcutContainer", 2, "reqGetShortcutTroopApps faild troopUin:" + this.jdField_a_of_type_Long + " errCode:" + paramInt);
          if (paramInt == 1002)
          {
            QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext.getString(2131699987), 0).a();
            break;
          }
          QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext.getString(2131699988), 0).a();
          break;
        }
      }
    }
  }
  
  private boolean b()
  {
    return (bclo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(this.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) || (bclo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(this.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
  }
  
  private boolean c()
  {
    return (Build.VERSION.SDK_INT == 28) && ("samsung".equals(Build.MANUFACTURER)) && ("SM-G9750".equals(Build.MODEL));
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370209);
      if (b()) {
        ((ImageView)localObject).setVisibility(0);
      }
    }
    else
    {
      localObject = (bbcz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(357);
      if (localObject == null) {
        break label137;
      }
    }
    label137:
    for (Object localObject = ((bbcz)localObject).a(this.jdField_a_of_type_Long);; localObject = null)
    {
      if ((localObject != null) && (this.jdField_a_of_type_Bbcv != null))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll((Collection)localObject);
        if ((localArrayList.size() < 16) && (b()))
        {
          localObject = new bbcy();
          ((bbcy)localObject).jdField_a_of_type_Int = 1;
          localArrayList.add(localObject);
        }
        this.jdField_a_of_type_Bbcv.a(localArrayList);
      }
      return;
      ((ImageView)localObject).setVisibility(8);
      break;
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      e();
      c();
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidWidgetGridView != null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378276));
    this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(4);
    int i = (((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).getDefaultDisplay().getWidth() - this.jdField_a_of_type_AndroidWidgetGridView.getPaddingLeft() - this.jdField_a_of_type_AndroidWidgetGridView.getPaddingRight() - aekt.a(11.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources()) * 3) / 4;
    this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(i);
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    this.jdField_a_of_type_Bbcv = new bbcv(this.jdField_a_of_type_AndroidContentContext, i, bool);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Bbcv);
    e();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 20006)
    {
      paramIntent = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if (paramIntent != null)
      {
        paramIntent = paramIntent.b(String.valueOf(this.jdField_a_of_type_Long));
        if ((paramIntent != null) && (this.jdField_a_of_type_Alzf != null)) {
          this.jdField_a_of_type_Alzf.b(this.jdField_a_of_type_Long, (int)paramIntent.dwGroupClassExt);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    a(true);
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Alzf = ((alzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20));
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).b(String.valueOf(this.jdField_a_of_type_Long));
      if (localObject == null) {
        break label145;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopAppShortcutContainer", 2, "reqGetShortcutTroopApps troopuin:" + this.jdField_a_of_type_Long + " dwGroupClassExt" + ((TroopInfo)localObject).dwGroupClassExt);
      }
      this.jdField_a_of_type_Alzf.b(this.jdField_a_of_type_Long, (int)((TroopInfo)localObject).dwGroupClassExt);
      if (this.jdField_a_of_type_Amab == null)
      {
        this.jdField_a_of_type_Amab = new bbct(this);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amab);
      }
    }
    return;
    label145:
    QLog.e("TroopAppShortcutContainer", 2, "get troopClassExt error");
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAppShortcutContainer", 2, "onDestroy");
    }
    if ((this.jdField_a_of_type_Amab != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amab);
      this.jdField_a_of_type_Amab = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidWidgetGridView = null;
    this.jdField_a_of_type_Bbcv = null;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void onClick(View paramView)
  {
    long l = SystemClock.elapsedRealtime();
    if ((this.jdField_a_of_type_JavaLangLong != null) && (l - this.jdField_a_of_type_JavaLangLong.longValue() < 500L)) {
      return;
    }
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(l);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363024: 
      a(true);
      return;
    }
    a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcq
 * JD-Core Version:    0.7.0.1
 */