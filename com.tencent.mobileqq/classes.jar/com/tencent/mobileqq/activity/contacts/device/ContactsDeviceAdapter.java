package com.tencent.mobileqq.activity.contacts.device;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.PrinterActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.contacts.base.BuddyItemBuilder;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem.ViewTag;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PrinterStatusHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import cooperation.smartdevice.SmartDevicePluginDownloadActivity;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class ContactsDeviceAdapter
  extends FacePreloadBaseAdapter
  implements View.OnClickListener
{
  protected QQAppInterface a;
  protected Context b;
  public ArrayList<DeviceInfo> c = new ArrayList(1);
  protected ArrayList<BuddyListItem> d;
  protected int e;
  protected boolean f = true;
  protected boolean g = true;
  private boolean h = false;
  private boolean j = false;
  
  public ContactsDeviceAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
    this.a = paramQQAppInterface;
    this.b = paramContext;
  }
  
  private void a(View paramView)
  {
    if (this.f)
    {
      this.f = false;
      bool = SmartDevicePluginLoader.a().a(this.a);
      i = 1;
      if (!bool)
      {
        localObject1 = new Intent(this.b, SmartDevicePluginDownloadActivity.class);
        this.b.startActivity((Intent)localObject1);
      }
    }
    try
    {
      localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("enable_public_device_");
      ((StringBuilder)localObject2).append(this.a.getCurrentAccountUin());
      bool = ((SharedPreferences)localObject1).getBoolean(((StringBuilder)localObject2).toString(), true);
    }
    catch (Exception localException1)
    {
      label114:
      Intent localIntent;
      break label114;
    }
    boolean bool = true;
    if (!bool) {
      i = 0;
    }
    SmartDeviceReport.a(null, "Usr_NewDevice_Click", i, 0, 0);
    break label581;
    localIntent = new Intent();
    localIntent.putExtra("nickname", this.a.getCurrentNickname());
    Object localObject1 = this.a;
    localObject2 = ((QQAppInterface)localObject1).getCurrentAccountUin();
    int i = 2;
    localIntent.putExtra("bitmap", ((QQAppInterface)localObject1).getFaceBitmap((String)localObject2, (byte)2, false));
    localIntent.putExtra("url", "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
    localObject1 = "com.tencent.device.activities.DeviceSearchActivity";
    k = i;
    localObject2 = localObject1;
    try
    {
      localObject3 = BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4);
      k = i;
      localObject2 = localObject1;
      localObject4 = new StringBuilder();
      k = i;
      localObject2 = localObject1;
      ((StringBuilder)localObject4).append("enable_public_device_");
      k = i;
      localObject2 = localObject1;
      ((StringBuilder)localObject4).append(this.a.getCurrentAccountUin());
      k = i;
      localObject2 = localObject1;
      bool = ((SharedPreferences)localObject3).getBoolean(((StringBuilder)localObject4).toString(), true);
      k = i;
      localObject2 = localObject1;
      localObject4 = new StringBuilder();
      k = i;
      localObject2 = localObject1;
      ((StringBuilder)localObject4).append("square_url_");
      k = i;
      localObject2 = localObject1;
      ((StringBuilder)localObject4).append(this.a.getCurrentAccountUin());
      k = i;
      localObject2 = localObject1;
      localObject4 = ((SharedPreferences)localObject3).getString(((StringBuilder)localObject4).toString(), "");
      if (bool)
      {
        localObject1 = "com.tencent.device.activities.DeviceSquareActivity";
        i = 3;
      }
      k = i;
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        k = i;
        localObject2 = localObject1;
        localIntent.putExtra("url", (String)localObject4);
      }
      k = i;
      localObject2 = localObject1;
      localObject4 = new StringBuilder();
      k = i;
      localObject2 = localObject1;
      ((StringBuilder)localObject4).append("search_device_enable_https_");
      k = i;
      localObject2 = localObject1;
      ((StringBuilder)localObject4).append(this.a.getCurrentAccountUin());
      k = i;
      localObject2 = localObject1;
      bool = ((SharedPreferences)localObject3).getBoolean(((StringBuilder)localObject4).toString(), false);
      m = i;
      localObject3 = localObject1;
      k = i;
      localObject2 = localObject1;
      if (VersionUtils.d())
      {
        m = i;
        localObject3 = localObject1;
        if (bool)
        {
          k = i;
          localObject2 = localObject1;
          localIntent.putExtra("url", "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
          localObject3 = localObject1;
          m = i;
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject4;
        int m = k;
        Object localObject3 = localObject2;
      }
    }
    localObject1 = SmartDevicePluginLoader.a();
    localObject2 = (Activity)this.b;
    localObject4 = this.a;
    ((SmartDevicePluginLoader)localObject1).a((Activity)localObject2, (AppRuntime)localObject4, ((QQAppInterface)localObject4).getAccount(), localIntent, (String)localObject3, 0, null, SmartDevicePluginProxyActivity.class);
    SmartDeviceReport.a(null, "Usr_NewDevice_Click", m, 0, 0);
    label581:
    paramView.postDelayed(new ContactsDeviceAdapter.3(this), 1000L);
  }
  
  private void a(View paramView, Friends paramFriends)
  {
    this.f = false;
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    paramFriends = localSmartDeviceProxyMgr.a(paramFriends.signature, paramFriends.iTermType);
    localSmartDeviceProxyMgr.a((Activity)this.b, paramFriends, false);
    paramView.postDelayed(new ContactsDeviceAdapter.4(this), 1000L);
    if (paramFriends != null)
    {
      long l = paramFriends.din;
      int i;
      if (paramFriends.isAdmin == 1) {
        i = 1;
      } else {
        i = 2;
      }
      SmartDeviceReport.a(null, l, "Usr_LiteApp_Open", i, 0, paramFriends.productId);
      l = paramFriends.din;
      if (paramFriends.userStatus == 10) {
        i = 1;
      } else {
        i = 2;
      }
      SmartDeviceReport.a(null, l, "Usr_LiteApp_Open_Online", i, 0, paramFriends.productId);
    }
  }
  
  private void a(List<BuddyListItem> paramList)
  {
    Friends localFriends = new Friends();
    localFriends.uin = AppConstants.DATALINE_PC_UIN;
    localFriends.remark = HardCodeUtil.a(2131892059);
    localFriends.name = HardCodeUtil.a(2131892059);
    boolean bool = a(AppConstants.DATALINE_PC_UIN);
    int k = 10;
    int i;
    if (bool) {
      i = 10;
    } else {
      i = 0;
    }
    localFriends.status = ((byte)i);
    localFriends.groupid = 1001;
    paramList.add(BuddyItemBuilder.a(5, localFriends, this.a, this.b));
    if (localFriends.status != 0) {
      this.e += 1;
    }
    if ((a(AppConstants.DATALINE_IPAD_UIN)) || (this.h))
    {
      localFriends = new Friends();
      localFriends.uin = AppConstants.DATALINE_IPAD_UIN;
      localFriends.remark = this.b.getString(2131891355);
      localFriends.name = this.b.getString(2131891355);
      if (a(AppConstants.DATALINE_IPAD_UIN)) {
        i = k;
      } else {
        i = 0;
      }
      localFriends.status = ((byte)i);
      localFriends.groupid = 1001;
      paramList.add(BuddyItemBuilder.a(5, localFriends, this.a, this.b));
      if (localFriends.status != 0) {
        this.e += 1;
      }
      if (!this.j)
      {
        ReportController.b(this.a, "CliOper", "", "", "0X8005D18", "0X8005D18", 0, 0, "", "", "", "");
        this.j = true;
        if (QLog.isColorLevel()) {
          QLog.d("ContactsDeviceAdapter", 2, "=== dataline report event show ipad 0X8005D18 ");
        }
      }
    }
  }
  
  private boolean a(String paramString)
  {
    RegisterProxySvcPackHandler localRegisterProxySvcPackHandler = (RegisterProxySvcPackHandler)this.a.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
    int i;
    if (paramString.equals(AppConstants.DATALINE_PC_UIN)) {
      i = localRegisterProxySvcPackHandler.d();
    } else if (paramString.equals(AppConstants.DATALINE_IPAD_UIN)) {
      i = localRegisterProxySvcPackHandler.e();
    } else {
      i = 0;
    }
    boolean bool = true;
    if (i != 1)
    {
      if (i == 2) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void b(List<BuddyListItem> paramList)
  {
    String str = QFileAssistantUtils.b(this.a);
    Object localObject2 = ContactUtils.a(this.a, str, true);
    Object localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (!((String)localObject2).equals(str)) {}
    }
    else
    {
      localObject1 = this.b.getString(2131896189);
    }
    localObject2 = new Friends();
    ((Friends)localObject2).uin = str;
    ((Friends)localObject2).remark = ((String)localObject1);
    ((Friends)localObject2).name = ((String)localObject1);
    ((Friends)localObject2).status = 10;
    ((Friends)localObject2).groupid = 1001;
    paramList.add(BuddyItemBuilder.a(5, (Entity)localObject2, this.a, this.b));
  }
  
  private void h()
  {
    ArrayList localArrayList = new ArrayList();
    if (QFileAssistantUtils.a(this.a)) {
      b(localArrayList);
    } else {
      a(localArrayList);
    }
    Friends localFriends;
    if (((PrinterStatusHandler)this.a.getBusinessHandler(BusinessHandlerFactory.PRINTER_STATUS_HANDLER)).a())
    {
      localFriends = new Friends();
      localFriends.uin = AppConstants.DATALINE_PRINTER_UIN;
      localFriends.remark = this.b.getString(2131888327);
      localFriends.name = this.b.getString(2131888327);
      int i;
      if (a(AppConstants.DATALINE_IPAD_UIN)) {
        i = 10;
      } else {
        i = 0;
      }
      localFriends.status = ((byte)i);
      localFriends.groupid = 1001;
      localArrayList.add(BuddyItemBuilder.a(5, localFriends, this.a, this.b));
      if (localFriends.status != 0) {
        this.e += 1;
      }
    }
    if (this.g)
    {
      localFriends = new Friends();
      localFriends.uin = AppConstants.SMARTDEVICE_SEARCH_UIN;
      localFriends.remark = this.b.getString(2131888325);
      localFriends.name = this.b.getString(2131888325);
      localFriends.status = 10;
      localFriends.groupid = 1001;
      localArrayList.add(BuddyItemBuilder.a(5, localFriends, this.a, this.b));
      this.e += 1;
    }
    this.d.addAll(localArrayList);
    b();
  }
  
  public void a()
  {
    ArrayList localArrayList = this.c;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    localArrayList = this.d;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    super.notifyDataSetChanged();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != this.a) {
      this.a = paramQQAppInterface;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return;
      }
      localObject = ((List)localObject).iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        Friends localFriends = (Friends)((BuddyListItem)((Iterator)localObject).next()).f;
        boolean bool = localFriends.uin.equals(AppConstants.DATALINE_PC_UIN);
        int m = 10;
        int k;
        if (((bool) || (localFriends.uin.equals(AppConstants.DATALINE_PRINTER_UIN))) && ((paramString.equals(AppConstants.DATALINE_PC_UIN)) || (paramString.equals(AppConstants.DATALINE_PRINTER_UIN))))
        {
          if (paramBoolean) {
            k = 10;
          } else {
            k = 0;
          }
          localFriends.status = ((byte)k);
        }
        if (localFriends.uin.equals(paramString))
        {
          if (paramBoolean) {
            k = m;
          } else {
            k = 0;
          }
          localFriends.status = ((byte)k);
        }
        if (localFriends.status != 0) {
          i += 1;
        }
      }
      this.e = i;
    }
  }
  
  public void b()
  {
    ArrayList localArrayList1 = new ArrayList(this.c.size());
    ArrayList localArrayList2 = new ArrayList(this.c.size());
    HashMap localHashMap = new HashMap();
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      DeviceInfo localDeviceInfo = (DeviceInfo)localIterator.next();
      Object localObject1;
      if (localDeviceInfo.isAdmin == 2)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("share device[");
          ((StringBuilder)localObject1).append(localDeviceInfo.name);
          ((StringBuilder)localObject1).append("] is not binded");
          QLog.d("smartdevice::baseim.server_list", 2, ((StringBuilder)localObject1).toString());
        }
      }
      else
      {
        localObject1 = new Friends();
        ((Friends)localObject1).uin = AppConstants.SMARTDEVICE_UIN;
        int i = localDeviceInfo.userStatus;
        int k = 0;
        if (i == 10) {
          i = 1;
        } else {
          i = 0;
        }
        if (localDeviceInfo.productId == 1000000344) {
          i = 1;
        }
        if (i != 0) {
          k = 10;
        }
        byte b1 = (byte)k;
        Object localObject2 = (String)localHashMap.get(Integer.valueOf(localDeviceInfo.productId));
        if (!"1".equals(localObject2))
        {
          if ("2".equals(localObject2)) {}
          for (;;)
          {
            b1 = 11;
            break label363;
            localObject2 = localSmartDeviceProxyMgr.b(localDeviceInfo.productId);
            if ((localObject2 == null) || ((((ProductInfo)localObject2).deviceType != 13) && (((ProductInfo)localObject2).deviceType != 14) && ((((ProductInfo)localObject2).deviceType != 17) || (((ProductInfo)localObject2).uConnectType != 1)))) {
              break;
            }
            localHashMap.put(Integer.valueOf(localDeviceInfo.productId), "2");
          }
          if (localObject2 != null) {
            localHashMap.put(Integer.valueOf(localDeviceInfo.productId), "1");
          }
        }
        label363:
        if (DeviceHeadMgr.getInstance().isLostQfindDevice(String.valueOf(localDeviceInfo.din))) {
          b1 = 12;
        }
        ((Friends)localObject1).remark = SmartDeviceUtil.a(localDeviceInfo);
        ((Friends)localObject1).name = String.valueOf(localDeviceInfo.din);
        ((Friends)localObject1).signature = localDeviceInfo.serialNum;
        ((Friends)localObject1).status = b1;
        ((Friends)localObject1).groupid = 1001;
        ((Friends)localObject1).alias = localDeviceInfo.type;
        ((Friends)localObject1).iTermType = localDeviceInfo.productId;
        if (i != 0)
        {
          localArrayList1.add(BuddyItemBuilder.a(5, (Entity)localObject1, this.a, this.b));
          this.e += 1;
        }
        else
        {
          localArrayList2.add(BuddyItemBuilder.a(5, (Entity)localObject1, this.a, this.b));
        }
      }
    }
    if (localArrayList1.size() > 0) {
      this.d.addAll(localArrayList1);
    }
    if (localArrayList2.size() > 0) {
      this.d.addAll(localArrayList2);
    }
  }
  
  public void d()
  {
    ArrayList localArrayList = this.d;
    if (localArrayList != null)
    {
      if (localArrayList.size() == 0) {
        return;
      }
      int k = 0;
      int i = 0;
      while (i < localArrayList.size())
      {
        if (((Friends)((BuddyListItem)localArrayList.get(i)).f).uin.equals(AppConstants.DATALINE_PRINTER_UIN)) {
          break label73;
        }
        i += 1;
      }
      i = -1;
      label73:
      if (((PrinterStatusHandler)this.a.getBusinessHandler(BusinessHandlerFactory.PRINTER_STATUS_HANDLER)).a())
      {
        if (i == -1)
        {
          Friends localFriends = new Friends();
          localFriends.uin = AppConstants.DATALINE_PRINTER_UIN;
          localFriends.remark = this.b.getString(2131888327);
          localFriends.name = this.b.getString(2131888327);
          i = k;
          if (a(AppConstants.DATALINE_PC_UIN)) {
            i = 10;
          }
          localFriends.status = ((byte)i);
          localFriends.groupid = 1001;
          localArrayList.add(BuddyItemBuilder.a(5, localFriends, this.a, this.b));
        }
      }
      else if (i != -1) {
        localArrayList.remove(i);
      }
      a(a(AppConstants.DATALINE_PC_UIN), AppConstants.DATALINE_PC_UIN);
    }
  }
  
  public void e()
  {
    ArrayList localArrayList = this.d;
    this.h = true;
    if (localArrayList != null)
    {
      if (localArrayList.size() == 0) {
        return;
      }
      int k = 0;
      int i = 0;
      while (i < localArrayList.size())
      {
        if (((Friends)((BuddyListItem)localArrayList.get(i)).f).uin.equals(AppConstants.DATALINE_IPAD_UIN)) {
          break label78;
        }
        i += 1;
      }
      i = -1;
      label78:
      if (i == -1)
      {
        Friends localFriends = new Friends();
        localFriends.uin = AppConstants.DATALINE_IPAD_UIN;
        localFriends.remark = this.b.getString(2131891355);
        localFriends.name = this.b.getString(2131891355);
        if (a(AppConstants.DATALINE_IPAD_UIN)) {
          i = 10;
        } else {
          i = 0;
        }
        localFriends.status = ((byte)i);
        localFriends.groupid = 1001;
        localArrayList.add(BuddyItemBuilder.a(5, localFriends, this.a, this.b));
        i = k;
        if (localFriends.status != 0) {
          i = 1;
        }
        this.e = i;
        ReportController.b(this.a, "CliOper", "", "", "0X8005D18", "0X8005D18", 0, 0, "", "", "", "");
        this.j = true;
        if (QLog.isColorLevel()) {
          QLog.d("ContactsDeviceAdapter", 2, "=== dataline report event show ipad 0X8005D18 ");
        }
        ((RegisterProxySvcPackHandler)this.a.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).d(1);
      }
    }
  }
  
  public int f()
  {
    int i = 0;
    while (i < getCount())
    {
      Object localObject1 = getItem(i);
      if ((localObject1 != null) && ((localObject1 instanceof BuddyListDevices)))
      {
        localObject1 = (Friends)((BuddyListDevices)localObject1).f;
        Object localObject2 = (SmartDeviceProxyMgr)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
        if (localObject2 != null)
        {
          localObject2 = ((SmartDeviceProxyMgr)localObject2).l();
          if (((Friends)localObject1).name.equals(localObject2)) {
            return i;
          }
        }
      }
      i += 1;
    }
    return -1;
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.d;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    ArrayList localArrayList = this.d;
    if (localArrayList == null) {
      return null;
    }
    return localArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = ((BuddyListItem)this.d.get(paramInt)).a(0, paramInt, paramView, paramViewGroup, null);
    if (localView != null)
    {
      a((BuddyListItem.ViewTag)localView.getTag(), null);
      localView.setOnClickListener(this);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    ArrayList localArrayList = this.d;
    if (localArrayList == null) {
      this.d = new ArrayList();
    } else {
      localArrayList.clear();
    }
    h();
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (BuddyListItem.ViewTag)paramView.getTag();
    if ((localObject1 != null) && ((((BuddyListItem.ViewTag)localObject1).c instanceof Friends))) {
      localObject1 = (Friends)((BuddyListItem.ViewTag)localObject1).c;
    } else {
      localObject1 = null;
    }
    Object localObject2;
    if (localObject1 != null) {
      if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(((Friends)localObject1).uin)) {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("devicesearchEntry:");
          ((StringBuilder)localObject2).append(System.currentTimeMillis());
          QLog.d("SDKQQAgentPerf", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
    try
    {
      ((IRedTouchManager)this.a.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("100701.100702");
      label119:
      localObject2 = this.b;
      if ((localObject2 instanceof BaseActivity))
      {
        localObject2 = (BaseActivity)localObject2;
        if (Build.VERSION.SDK_INT >= 23)
        {
          if (!PermissionUtils.isStorePermissionEnable((Context)localObject2)) {
            ((BaseActivity)localObject2).requestPermissions(new ContactsDeviceAdapter.1(this, paramView, (BaseActivity)localObject2), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
          } else {
            a(paramView);
          }
        }
        else {
          a(paramView);
        }
      }
      if (AppConstants.DATALINE_PC_UIN.equals(((Friends)localObject1).uin))
      {
        localObject1 = new Intent(this.b, LiteActivity.class);
        ((Intent)localObject1).putExtra("targetUin", AppConstants.DATALINE_PC_UIN);
        this.b.startActivity((Intent)localObject1);
        ReportController.b(this.a, "CliOper", "", "", "0X800603C", "0X800603C", 0, 0, "", "", "", "");
      }
      else if (AppConstants.DATALINE_IPAD_UIN.equals(((Friends)localObject1).uin))
      {
        localObject1 = new Intent(this.b, LiteActivity.class);
        ((Intent)localObject1).putExtra("targetUin", AppConstants.DATALINE_IPAD_UIN);
        this.b.startActivity((Intent)localObject1);
        ReportController.b(this.a, "CliOper", "", "", "0X8006041", "0X8006041", 0, 0, "", "", "", "");
      }
      else if (((Friends)localObject1).uin.equals(QFileAssistantUtils.b(this.a)))
      {
        QFileAssistantUtils.a(this.b, null);
      }
      else if (AppConstants.DATALINE_PRINTER_UIN.equals(((Friends)localObject1).uin))
      {
        localObject1 = new Intent(this.b, PrinterActivity.class);
        this.b.startActivity((Intent)localObject1);
      }
      else if ((AppConstants.SMARTDEVICE_UIN.equals(((Friends)localObject1).uin)) && (this.f))
      {
        localObject2 = this.b;
        if ((localObject2 instanceof BaseActivity))
        {
          localObject2 = (BaseActivity)localObject2;
          if (Build.VERSION.SDK_INT >= 23) {
            if (!PermissionUtils.isStorePermissionEnable((Context)localObject2)) {
              ((BaseActivity)localObject2).requestPermissions(new ContactsDeviceAdapter.2(this, paramView, (Friends)localObject1, (BaseActivity)localObject2), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
            } else {
              a(paramView, (Friends)localObject1);
            }
          }
        }
        else
        {
          a(paramView, (Friends)localObject1);
        }
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label119;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt != 0) {
      ApngImage.pauseByTag(3);
    }
    if (paramInt == 0) {
      ApngImage.playByTag(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.ContactsDeviceAdapter
 * JD-Core Version:    0.7.0.1
 */