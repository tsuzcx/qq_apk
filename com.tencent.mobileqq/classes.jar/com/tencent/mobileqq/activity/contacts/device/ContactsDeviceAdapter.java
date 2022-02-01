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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
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

public class ContactsDeviceAdapter
  extends FacePreloadBaseAdapter
  implements View.OnClickListener
{
  protected int a;
  protected Context a;
  protected QQAppInterface a;
  public ArrayList<DeviceInfo> a;
  protected boolean a;
  protected ArrayList<BuddyListItem> b;
  protected boolean b;
  private boolean c = false;
  private boolean d = false;
  
  public ContactsDeviceAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(View paramView)
  {
    int i = 1;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (SmartDevicePluginLoader.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label134;
      }
      Intent localIntent1 = new Intent(this.jdField_a_of_type_AndroidContentContext, SmartDevicePluginDownloadActivity.class);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent1);
    }
    for (;;)
    {
      boolean bool;
      try
      {
        bool = BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4).getBoolean("enable_public_device_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
        if (bool)
        {
          SmartDeviceReport.a(null, "Usr_NewDevice_Click", i, 0, 0);
          paramView.postDelayed(new ContactsDeviceAdapter.3(this), 1000L);
          return;
        }
      }
      catch (Exception localException1)
      {
        bool = true;
        continue;
        i = 0;
        continue;
      }
      label134:
      Intent localIntent2 = new Intent();
      localIntent2.putExtra("nickname", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
      localIntent2.putExtra("bitmap", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (byte)2, false));
      localIntent2.putExtra("url", "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
      String str1 = "com.tencent.device.activities.DeviceSearchActivity";
      try
      {
        localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4);
        bool = localSharedPreferences.getBoolean("enable_public_device_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
        str2 = localSharedPreferences.getString("square_url_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "");
        if (bool)
        {
          str1 = "com.tencent.device.activities.DeviceSquareActivity";
          i = 3;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          try
          {
            SharedPreferences localSharedPreferences;
            String str2;
            if (!TextUtils.isEmpty(str2)) {
              localIntent2.putExtra("url", str2);
            }
            bool = localSharedPreferences.getBoolean("search_device_enable_https_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
            if ((VersionUtils.d()) && (bool)) {
              localIntent2.putExtra("url", "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
            }
            SmartDevicePluginLoader.a().a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localIntent2, str1, 0, null, SmartDevicePluginProxyActivity.class);
            SmartDeviceReport.a(null, "Usr_NewDevice_Click", i, 0, 0);
          }
          catch (Exception localException3)
          {
            continue;
          }
          localException2 = localException2;
          i = 2;
          continue;
          i = 2;
        }
      }
    }
  }
  
  private void a(View paramView, Friends paramFriends)
  {
    this.jdField_a_of_type_Boolean = false;
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    paramFriends = localSmartDeviceProxyMgr.a(paramFriends.signature, paramFriends.iTermType);
    localSmartDeviceProxyMgr.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramFriends, false);
    paramView.postDelayed(new ContactsDeviceAdapter.4(this), 1000L);
    long l;
    if (paramFriends != null)
    {
      l = paramFriends.din;
      if (paramFriends.isAdmin != 1) {
        break label130;
      }
      i = 1;
      SmartDeviceReport.a(null, l, "Usr_LiteApp_Open", i, 0, paramFriends.productId);
      l = paramFriends.din;
      if (paramFriends.userStatus != 10) {
        break label135;
      }
    }
    label130:
    label135:
    for (int i = 1;; i = 2)
    {
      SmartDeviceReport.a(null, l, "Usr_LiteApp_Open_Online", i, 0, paramFriends.productId);
      return;
      i = 2;
      break;
    }
  }
  
  private void a(List<BuddyListItem> paramList)
  {
    int j = 10;
    Friends localFriends = new Friends();
    localFriends.uin = AppConstants.DATALINE_PC_UIN;
    localFriends.remark = HardCodeUtil.a(2131694415);
    localFriends.name = HardCodeUtil.a(2131694415);
    if (a(AppConstants.DATALINE_PC_UIN))
    {
      i = 10;
      localFriends.status = ((byte)i);
      localFriends.groupid = 1001;
      paramList.add(BuddyItemBuilder.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
      if (localFriends.status != 0) {
        this.jdField_a_of_type_Int += 1;
      }
      if ((a(AppConstants.DATALINE_IPAD_UIN)) || (this.c))
      {
        localFriends = new Friends();
        localFriends.uin = AppConstants.DATALINE_IPAD_UIN;
        localFriends.remark = this.jdField_a_of_type_AndroidContentContext.getString(2131693827);
        localFriends.name = this.jdField_a_of_type_AndroidContentContext.getString(2131693827);
        if (!a(AppConstants.DATALINE_IPAD_UIN)) {
          break label301;
        }
      }
    }
    label301:
    for (int i = j;; i = 0)
    {
      localFriends.status = ((byte)i);
      localFriends.groupid = 1001;
      paramList.add(BuddyItemBuilder.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
      if (localFriends.status != 0) {
        this.jdField_a_of_type_Int += 1;
      }
      if (!this.d)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005D18", "0X8005D18", 0, 0, "", "", "", "");
        this.d = true;
        if (QLog.isColorLevel()) {
          QLog.d("ContactsDeviceAdapter", 2, "=== dataline report event show ipad 0X8005D18 ");
        }
      }
      return;
      i = 0;
      break;
    }
  }
  
  private boolean a(String paramString)
  {
    RegisterProxySvcPackHandler localRegisterProxySvcPackHandler = (RegisterProxySvcPackHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
    int i;
    if (paramString.equals(AppConstants.DATALINE_PC_UIN)) {
      i = localRegisterProxySvcPackHandler.a();
    }
    for (;;)
    {
      if ((i == 1) || (i == 2))
      {
        return true;
        if (paramString.equals(AppConstants.DATALINE_IPAD_UIN)) {
          i = localRegisterProxySvcPackHandler.b();
        }
      }
      else
      {
        return false;
      }
      i = 0;
    }
  }
  
  private void b(List<BuddyListItem> paramList)
  {
    String str = QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject2 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, true);
    Object localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (!((String)localObject2).equals(str)) {}
    }
    else
    {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131698224);
    }
    localObject2 = new Friends();
    ((Friends)localObject2).uin = str;
    ((Friends)localObject2).remark = ((String)localObject1);
    ((Friends)localObject2).name = ((String)localObject1);
    ((Friends)localObject2).status = 10;
    ((Friends)localObject2).groupid = 1001;
    paramList.add(BuddyItemBuilder.a(5, (Entity)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
  }
  
  private void f()
  {
    ArrayList localArrayList = new ArrayList();
    Friends localFriends;
    if (QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      b(localArrayList);
      if (((PrinterStatusHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.PRINTER_STATUS_HANDLER)).a())
      {
        localFriends = new Friends();
        localFriends.uin = AppConstants.DATALINE_PRINTER_UIN;
        localFriends.remark = this.jdField_a_of_type_AndroidContentContext.getString(2131691450);
        localFriends.name = this.jdField_a_of_type_AndroidContentContext.getString(2131691450);
        if (!a(AppConstants.DATALINE_IPAD_UIN)) {
          break label263;
        }
      }
    }
    label263:
    for (int i = 10;; i = 0)
    {
      localFriends.status = ((byte)i);
      localFriends.groupid = 1001;
      localArrayList.add(BuddyItemBuilder.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
      if (localFriends.status != 0) {
        this.jdField_a_of_type_Int += 1;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        localFriends = new Friends();
        localFriends.uin = AppConstants.SMARTDEVICE_SEARCH_UIN;
        localFriends.remark = this.jdField_a_of_type_AndroidContentContext.getString(2131691448);
        localFriends.name = this.jdField_a_of_type_AndroidContentContext.getString(2131691448);
        localFriends.status = 10;
        localFriends.groupid = 1001;
        localArrayList.add(BuddyItemBuilder.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
        this.jdField_a_of_type_Int += 1;
      }
      this.jdField_b_of_type_JavaUtilArrayList.addAll(localArrayList);
      b();
      return;
      a(localArrayList);
      break;
    }
  }
  
  public int a()
  {
    int i = 0;
    while (i < getCount())
    {
      Object localObject1 = getItem(i);
      if ((localObject1 != null) && ((localObject1 instanceof BuddyListDevices)))
      {
        localObject1 = (Friends)((BuddyListDevices)localObject1).a;
        Object localObject2 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
        if (localObject2 != null)
        {
          localObject2 = ((SmartDeviceProxyMgr)localObject2).b();
          if (((Friends)localObject1).name.equals(localObject2)) {
            return i;
          }
        }
      }
      i += 1;
    }
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_b_of_type_JavaUtilArrayList != null) {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
    super.notifyDataSetChanged();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    Object localObject = this.jdField_b_of_type_JavaUtilArrayList;
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return;
    }
    localObject = ((List)localObject).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject).hasNext())
    {
      Friends localFriends = (Friends)((BuddyListItem)((Iterator)localObject).next()).a;
      if (((localFriends.uin.equals(AppConstants.DATALINE_PC_UIN)) || (localFriends.uin.equals(AppConstants.DATALINE_PRINTER_UIN))) && ((paramString.equals(AppConstants.DATALINE_PC_UIN)) || (paramString.equals(AppConstants.DATALINE_PRINTER_UIN))))
      {
        if (paramBoolean)
        {
          j = 10;
          label117:
          localFriends.status = ((byte)j);
        }
      }
      else
      {
        if (localFriends.uin.equals(paramString))
        {
          if (!paramBoolean) {
            break label174;
          }
          j = 10;
          label145:
          localFriends.status = ((byte)j);
        }
        if (localFriends.status == 0) {
          break label186;
        }
        i += 1;
      }
    }
    label174:
    label186:
    for (;;)
    {
      break;
      j = 0;
      break label117;
      j = 0;
      break label145;
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public void b()
  {
    ArrayList localArrayList1 = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
    ArrayList localArrayList2 = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
    HashMap localHashMap = new HashMap();
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    DeviceInfo localDeviceInfo;
    Friends localFriends;
    int i;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localDeviceInfo = (DeviceInfo)localIterator.next();
        if (localDeviceInfo.isAdmin == 2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("smartdevice::baseim.server_list", 2, "share device[" + localDeviceInfo.name + "] is not binded");
          }
        }
        else
        {
          localFriends = new Friends();
          localFriends.uin = AppConstants.SMARTDEVICE_UIN;
          if (localDeviceInfo.userStatus == 10)
          {
            i = 1;
            label171:
            if (localDeviceInfo.productId != 1000000344) {
              break label546;
            }
            i = 1;
          }
        }
      }
    }
    label546:
    for (;;)
    {
      int j;
      label191:
      byte b1;
      Object localObject;
      if (i != 0)
      {
        j = 10;
        b1 = (byte)j;
        localObject = (String)localHashMap.get(Integer.valueOf(localDeviceInfo.productId));
        if (!"1".equals(localObject)) {
          break label359;
        }
      }
      for (;;)
      {
        if (DeviceHeadMgr.getInstance().isLostQfindDevice(String.valueOf(localDeviceInfo.din))) {
          b1 = 12;
        }
        localFriends.remark = SmartDeviceUtil.a(localDeviceInfo);
        localFriends.name = String.valueOf(localDeviceInfo.din);
        localFriends.signature = localDeviceInfo.serialNum;
        localFriends.status = b1;
        localFriends.groupid = 1001;
        localFriends.alias = localDeviceInfo.type;
        localFriends.iTermType = localDeviceInfo.productId;
        if (i == 0) {
          break label480;
        }
        localArrayList1.add(BuddyItemBuilder.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
        this.jdField_a_of_type_Int += 1;
        break;
        i = 0;
        break label171;
        j = 0;
        break label191;
        label359:
        if ("2".equals(localObject))
        {
          b1 = 11;
        }
        else
        {
          localObject = localSmartDeviceProxyMgr.a(localDeviceInfo.productId);
          if ((localObject != null) && ((((ProductInfo)localObject).deviceType == 13) || (((ProductInfo)localObject).deviceType == 14) || ((((ProductInfo)localObject).deviceType == 17) && (((ProductInfo)localObject).uConnectType == 1))))
          {
            localHashMap.put(Integer.valueOf(localDeviceInfo.productId), "2");
            b1 = 11;
          }
          else if (localObject != null)
          {
            localHashMap.put(Integer.valueOf(localDeviceInfo.productId), "1");
          }
        }
      }
      label480:
      localArrayList2.add(BuddyItemBuilder.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
      break;
      if (localArrayList1.size() > 0) {
        this.jdField_b_of_type_JavaUtilArrayList.addAll(localArrayList1);
      }
      if (localArrayList2.size() > 0) {
        this.jdField_b_of_type_JavaUtilArrayList.addAll(localArrayList2);
      }
      return;
    }
  }
  
  public void d()
  {
    int j = 0;
    ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    if ((localArrayList == null) || (localArrayList.size() == 0)) {
      return;
    }
    int i = 0;
    if (i < localArrayList.size()) {
      if (!((Friends)((BuddyListItem)localArrayList.get(i)).a).uin.equals(AppConstants.DATALINE_PRINTER_UIN)) {}
    }
    for (;;)
    {
      if (((PrinterStatusHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.PRINTER_STATUS_HANDLER)).a()) {
        if (i == -1)
        {
          Friends localFriends = new Friends();
          localFriends.uin = AppConstants.DATALINE_PRINTER_UIN;
          localFriends.remark = this.jdField_a_of_type_AndroidContentContext.getString(2131691450);
          localFriends.name = this.jdField_a_of_type_AndroidContentContext.getString(2131691450);
          i = j;
          if (a(AppConstants.DATALINE_PC_UIN)) {
            i = 10;
          }
          localFriends.status = ((byte)i);
          localFriends.groupid = 1001;
          localArrayList.add(BuddyItemBuilder.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
        }
      }
      for (;;)
      {
        a(a(AppConstants.DATALINE_PC_UIN), AppConstants.DATALINE_PC_UIN);
        return;
        i += 1;
        break;
        if (i != -1) {
          localArrayList.remove(i);
        }
      }
      i = -1;
    }
  }
  
  public void e()
  {
    ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    this.c = true;
    if ((localArrayList == null) || (localArrayList.size() == 0)) {}
    label261:
    for (;;)
    {
      return;
      int i = 0;
      if (i < localArrayList.size()) {
        if (!((Friends)((BuddyListItem)localArrayList.get(i)).a).uin.equals(AppConstants.DATALINE_IPAD_UIN)) {}
      }
      for (;;)
      {
        if (i != -1) {
          break label261;
        }
        Friends localFriends = new Friends();
        localFriends.uin = AppConstants.DATALINE_IPAD_UIN;
        localFriends.remark = this.jdField_a_of_type_AndroidContentContext.getString(2131693827);
        localFriends.name = this.jdField_a_of_type_AndroidContentContext.getString(2131693827);
        if (a(AppConstants.DATALINE_IPAD_UIN))
        {
          i = 10;
          label125:
          localFriends.status = ((byte)i);
          localFriends.groupid = 1001;
          localArrayList.add(BuddyItemBuilder.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
          if (localFriends.status == 0) {
            break label253;
          }
        }
        label253:
        for (i = 1;; i = 0)
        {
          this.jdField_a_of_type_Int = i;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005D18", "0X8005D18", 0, 0, "", "", "", "");
          this.d = true;
          if (QLog.isColorLevel()) {
            QLog.d("ContactsDeviceAdapter", 2, "=== dataline report event show ipad 0X8005D18 ");
          }
          ((RegisterProxySvcPackHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).d(1);
          return;
          i += 1;
          break;
          i = 0;
          break label125;
        }
        i = -1;
      }
    }
  }
  
  public int getCount()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return null;
    }
    return (BuddyListItem)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = ((BuddyListItem)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt)).a(0, paramInt, paramView, paramViewGroup, null);
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
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    }
    for (;;)
    {
      f();
      super.notifyDataSetChanged();
      return;
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void onClick(View paramView)
  {
    BuddyListItem.ViewTag localViewTag = (BuddyListItem.ViewTag)paramView.getTag();
    BaseActivity localBaseActivity = null;
    Object localObject = localBaseActivity;
    if (localViewTag != null)
    {
      localObject = localBaseActivity;
      if ((localViewTag.a instanceof Friends)) {
        localObject = (Friends)localViewTag.a;
      }
    }
    if (localObject == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(((Friends)localObject).uin)) {
        if (QLog.isColorLevel()) {
          QLog.d("SDKQQAgentPerf", 2, "devicesearchEntry:" + System.currentTimeMillis());
        }
      }
      try
      {
        ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).b("100701.100702");
        label119:
        if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
        {
          localBaseActivity = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
          if (Build.VERSION.SDK_INT < 23) {
            break label271;
          }
          if (PermissionUtils.isStorePermissionEnable(localBaseActivity)) {
            break label263;
          }
          localBaseActivity.requestPermissions(new ContactsDeviceAdapter.1(this, paramView, localBaseActivity), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        }
        for (;;)
        {
          if (!AppConstants.DATALINE_PC_UIN.equals(((Friends)localObject).uin)) {
            break label279;
          }
          localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
          ((Intent)localObject).putExtra("targetUin", AppConstants.DATALINE_PC_UIN);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800603C", "0X800603C", 0, 0, "", "", "", "");
          break;
          label263:
          a(paramView);
          continue;
          label271:
          a(paramView);
        }
        label279:
        if (AppConstants.DATALINE_IPAD_UIN.equals(((Friends)localObject).uin))
        {
          localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
          ((Intent)localObject).putExtra("targetUin", AppConstants.DATALINE_IPAD_UIN);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006041", "0X8006041", 0, 0, "", "", "", "");
          continue;
        }
        if (((Friends)localObject).uin.equals(QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
        {
          QFileAssistantUtils.b(this.jdField_a_of_type_AndroidContentContext, null);
          continue;
        }
        if (AppConstants.DATALINE_PRINTER_UIN.equals(((Friends)localObject).uin))
        {
          localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, PrinterActivity.class);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
          continue;
        }
        if ((!AppConstants.SMARTDEVICE_UIN.equals(((Friends)localObject).uin)) || (!this.jdField_a_of_type_Boolean)) {
          continue;
        }
        if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
        {
          localBaseActivity = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
          if (Build.VERSION.SDK_INT < 23) {
            continue;
          }
          if (!PermissionUtils.isStorePermissionEnable(localBaseActivity))
          {
            localBaseActivity.requestPermissions(new ContactsDeviceAdapter.2(this, paramView, (Friends)localObject, localBaseActivity), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
            continue;
          }
          a(paramView, (Friends)localObject);
          continue;
        }
        a(paramView, (Friends)localObject);
      }
      catch (Exception localException)
      {
        break label119;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.ContactsDeviceAdapter
 * JD-Core Version:    0.7.0.1
 */