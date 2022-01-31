package com.tencent.mobileqq.activity.contacts.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.contacts.BuddyItemBuilder;
import com.tencent.mobileqq.adapter.contacts.BuddyListDevices;
import com.tencent.mobileqq.adapter.contacts.BuddyListItem;
import com.tencent.mobileqq.adapter.contacts.BuddyListItem.ViewTag;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.PrinterStatusHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
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
import wlv;
import wlw;

public class ContactsDeviceAdapter
  extends FacePreloadBaseAdapter
  implements View.OnClickListener
{
  protected int a;
  protected Context a;
  protected QQAppInterface a;
  public ArrayList a;
  public boolean a;
  protected ArrayList b;
  private boolean b;
  private boolean c;
  
  public ContactsDeviceAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private boolean a(String paramString)
  {
    RegisterProxySvcPackHandler localRegisterProxySvcPackHandler = (RegisterProxySvcPackHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(10);
    int i;
    if (paramString.equals(AppConstants.y)) {
      i = localRegisterProxySvcPackHandler.a();
    }
    for (;;)
    {
      if ((i == 1) || (i == 2))
      {
        return true;
        if (paramString.equals(AppConstants.z)) {
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
  
  private void e()
  {
    ArrayList localArrayList = new ArrayList();
    Friends localFriends = new Friends();
    localFriends.uin = AppConstants.y;
    localFriends.remark = "我的电脑";
    localFriends.name = "我的电脑";
    if (a(AppConstants.y))
    {
      i = 10;
      localFriends.status = ((byte)i);
      localFriends.groupid = 1001;
      localArrayList.add(BuddyItemBuilder.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
      if (localFriends.status != 0) {
        this.jdField_a_of_type_Int += 1;
      }
      if ((a(AppConstants.z)) || (this.jdField_b_of_type_Boolean))
      {
        localFriends = new Friends();
        localFriends.uin = AppConstants.z;
        localFriends.remark = this.jdField_a_of_type_AndroidContentContext.getString(2131427486);
        localFriends.name = this.jdField_a_of_type_AndroidContentContext.getString(2131427486);
        if (!a(AppConstants.z)) {
          break label497;
        }
        i = 10;
        label169:
        localFriends.status = ((byte)i);
        localFriends.groupid = 1001;
        localArrayList.add(BuddyItemBuilder.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
        if (localFriends.status != 0) {
          this.jdField_a_of_type_Int += 1;
        }
        if (!this.c)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005D18", "0X8005D18", 0, 0, "", "", "", "");
          this.c = true;
          if (QLog.isColorLevel()) {
            QLog.d("ContactsDeviceAdapter", 2, "=== dataline report event show ipad 0X8005D18 ");
          }
        }
      }
      if (((PrinterStatusHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(74)).a())
      {
        localFriends = new Friends();
        localFriends.uin = AppConstants.A;
        localFriends.remark = this.jdField_a_of_type_AndroidContentContext.getString(2131427533);
        localFriends.name = this.jdField_a_of_type_AndroidContentContext.getString(2131427533);
        if (!a(AppConstants.z)) {
          break label502;
        }
      }
    }
    label497:
    label502:
    for (int i = 10;; i = 0)
    {
      localFriends.status = ((byte)i);
      localFriends.groupid = 1001;
      localArrayList.add(BuddyItemBuilder.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
      if (localFriends.status != 0) {
        this.jdField_a_of_type_Int += 1;
      }
      localFriends = new Friends();
      localFriends.uin = AppConstants.x;
      localFriends.remark = this.jdField_a_of_type_AndroidContentContext.getString(2131427531);
      localFriends.name = this.jdField_a_of_type_AndroidContentContext.getString(2131427531);
      localFriends.status = 10;
      localFriends.groupid = 1001;
      localArrayList.add(BuddyItemBuilder.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_Int += 1;
      this.jdField_b_of_type_JavaUtilArrayList.addAll(localArrayList);
      b();
      return;
      i = 0;
      break;
      i = 0;
      break label169;
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
        Object localObject2 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
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
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    super.a(paramAbsListView, paramInt);
    if (paramInt != 0) {
      ApngImage.pauseByTag(3);
    }
    if (paramInt == 0) {
      ApngImage.playByTag(3);
    }
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
      if (((localFriends.uin.equals(AppConstants.y)) || (localFriends.uin.equals(AppConstants.A))) && ((paramString.equals(AppConstants.y)) || (paramString.equals(AppConstants.A))))
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
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
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
          localFriends.uin = AppConstants.W;
          if (localDeviceInfo.userStatus == 10)
          {
            i = 1;
            label167:
            if (localDeviceInfo.productId != 1000000344) {
              break label541;
            }
            i = 1;
          }
        }
      }
    }
    label541:
    for (;;)
    {
      int j;
      label186:
      byte b1;
      Object localObject;
      if (i != 0)
      {
        j = 10;
        b1 = (byte)j;
        localObject = (String)localHashMap.get(Integer.valueOf(localDeviceInfo.productId));
        if (!"1".equals(localObject)) {
          break label354;
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
          break label475;
        }
        localArrayList1.add(BuddyItemBuilder.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
        this.jdField_a_of_type_Int += 1;
        break;
        i = 0;
        break label167;
        j = 0;
        break label186;
        label354:
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
      label475:
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
  
  public void c()
  {
    int j = 0;
    ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    if ((localArrayList == null) || (localArrayList.size() == 0)) {
      return;
    }
    int i = 0;
    if (i < localArrayList.size()) {
      if (!((Friends)((BuddyListItem)localArrayList.get(i)).a).uin.equals(AppConstants.A)) {}
    }
    for (;;)
    {
      if (((PrinterStatusHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(74)).a()) {
        if (i == -1)
        {
          Friends localFriends = new Friends();
          localFriends.uin = AppConstants.A;
          localFriends.remark = this.jdField_a_of_type_AndroidContentContext.getString(2131427533);
          localFriends.name = this.jdField_a_of_type_AndroidContentContext.getString(2131427533);
          i = j;
          if (a(AppConstants.y)) {
            i = 10;
          }
          localFriends.status = ((byte)i);
          localFriends.groupid = 1001;
          localArrayList.add(BuddyItemBuilder.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
        }
      }
      for (;;)
      {
        a(a(AppConstants.y), AppConstants.y);
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
  
  public void d()
  {
    ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    this.jdField_b_of_type_Boolean = true;
    if ((localArrayList == null) || (localArrayList.size() == 0)) {}
    label123:
    label253:
    for (;;)
    {
      return;
      int i = 0;
      if (i < localArrayList.size()) {
        if (!((Friends)((BuddyListItem)localArrayList.get(i)).a).uin.equals(AppConstants.z)) {}
      }
      for (;;)
      {
        if (i != -1) {
          break label253;
        }
        Friends localFriends = new Friends();
        localFriends.uin = AppConstants.z;
        localFriends.remark = this.jdField_a_of_type_AndroidContentContext.getString(2131427486);
        localFriends.name = this.jdField_a_of_type_AndroidContentContext.getString(2131427486);
        if (a(AppConstants.z))
        {
          i = 10;
          localFriends.status = ((byte)i);
          localFriends.groupid = 1001;
          localArrayList.add(BuddyItemBuilder.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
          if (localFriends.status == 0) {
            break label245;
          }
        }
        for (i = 1;; i = 0)
        {
          this.jdField_a_of_type_Int = i;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005D18", "0X8005D18", 0, 0, "", "", "", "");
          this.c = true;
          if (QLog.isColorLevel()) {
            QLog.d("ContactsDeviceAdapter", 2, "=== dataline report event show ipad 0X8005D18 ");
          }
          ((RegisterProxySvcPackHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(10)).c(1);
          return;
          i += 1;
          break;
          i = 0;
          break label123;
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
    paramView = ((BuddyListItem)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt)).a(0, paramInt, paramView, paramViewGroup, null);
    if (paramView != null)
    {
      a((BuddyListItem.ViewTag)paramView.getTag(), null);
      paramView.setOnClickListener(this);
    }
    return paramView;
  }
  
  public void notifyDataSetChanged()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    }
    for (;;)
    {
      e();
      super.notifyDataSetChanged();
      return;
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (BuddyListItem.ViewTag)paramView.getTag();
    if ((localObject1 != null) && ((((BuddyListItem.ViewTag)localObject1).a instanceof Friends))) {}
    for (Friends localFriends = (Friends)((BuddyListItem.ViewTag)localObject1).a;; localFriends = null)
    {
      if (localFriends == null) {}
      for (;;)
      {
        return;
        if (AppConstants.x.equals(localFriends.uin)) {
          if (QLog.isColorLevel()) {
            QLog.d("SDKQQAgentPerf", 2, "devicesearchEntry:" + System.currentTimeMillis());
          }
        }
        try
        {
          ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b("100701.100702");
          label108:
          boolean bool1;
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = false;
            if (SmartDevicePluginLoader.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
              break label325;
            }
            localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, SmartDevicePluginDownloadActivity.class);
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
            bool1 = true;
          }
          try
          {
            boolean bool2 = BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4).getBoolean("enable_public_device_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
            bool1 = bool2;
          }
          catch (Exception localException2)
          {
            label209:
            int i;
            int j;
            Object localObject3;
            Object localObject2;
            long l;
            break label209;
          }
          if (bool1)
          {
            i = 1;
            SmartDeviceReport.a(null, "Usr_NewDevice_Click", i, 0, 0);
          }
          for (;;)
          {
            paramView.postDelayed(new wlv(this), 1000L);
            if (!AppConstants.y.equals(localFriends.uin)) {
              break label674;
            }
            paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
            paramView.putExtra("targetUin", AppConstants.y);
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800603C", "0X800603C", 0, 0, "", "", "", "");
            return;
            i = 0;
            break;
            label325:
            Intent localIntent = new Intent();
            localIntent.putExtra("nickname", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
            localIntent.putExtra("bitmap", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (byte)2, false));
            localIntent.putExtra("url", "http://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
            localObject1 = "com.tencent.device.activities.DeviceSearchActivity";
            i = 2;
            j = i;
            localObject3 = localObject1;
            try
            {
              SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4);
              j = i;
              localObject3 = localObject1;
              bool1 = localSharedPreferences.getBoolean("enable_public_device_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
              j = i;
              localObject3 = localObject1;
              String str = localSharedPreferences.getString("square_url_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "");
              if (bool1)
              {
                localObject1 = "com.tencent.device.activities.DeviceSquareActivity";
                i = 3;
              }
              j = i;
              localObject3 = localObject1;
              if (!TextUtils.isEmpty(str))
              {
                j = i;
                localObject3 = localObject1;
                localIntent.putExtra("url", str);
              }
              j = i;
              localObject3 = localObject1;
              bool1 = localSharedPreferences.getBoolean("search_device_enable_https_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
              j = i;
              localObject3 = localObject1;
              if ((VersionUtils.d()) && (bool1))
              {
                j = i;
                localObject3 = localObject1;
                localIntent.putExtra("url", "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                i = j;
                localObject2 = localObject3;
              }
            }
            SmartDevicePluginLoader.a().a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localIntent, (String)localObject1, 0, null, SmartDevicePluginProxyActivity.class);
            SmartDeviceReport.a(null, "Usr_NewDevice_Click", i, 0, 0);
          }
          label674:
          if (AppConstants.z.equals(localFriends.uin))
          {
            paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
            paramView.putExtra("targetUin", AppConstants.z);
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006041", "0X8006041", 0, 0, "", "", "", "");
            return;
          }
          if (AppConstants.A.equals(localFriends.uin))
          {
            paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, PrinterActivity.class);
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
            return;
          }
          if ((AppConstants.W.equals(localFriends.uin)) && (this.jdField_a_of_type_Boolean))
          {
            this.jdField_a_of_type_Boolean = false;
            localObject2 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
            localObject3 = ((SmartDeviceProxyMgr)localObject2).a(localFriends.signature, localFriends.iTermType);
            ((SmartDeviceProxyMgr)localObject2).a((Activity)this.jdField_a_of_type_AndroidContentContext, (DeviceInfo)localObject3, false);
            paramView.postDelayed(new wlw(this), 1000L);
            if (localObject3 == null)
            {
              l = ((DeviceInfo)localObject3).din;
              if (((DeviceInfo)localObject3).isAdmin == 1)
              {
                i = 1;
                SmartDeviceReport.a(null, l, "Usr_LiteApp_Open", i, 0, ((DeviceInfo)localObject3).productId);
                l = ((DeviceInfo)localObject3).din;
                if (((DeviceInfo)localObject3).userStatus != 10) {
                  break label958;
                }
              }
              label958:
              for (i = 1;; i = 2)
              {
                SmartDeviceReport.a(null, l, "Usr_LiteApp_Open_Online", i, 0, ((DeviceInfo)localObject3).productId);
                return;
                i = 2;
                break;
              }
            }
          }
        }
        catch (Exception localException3)
        {
          break label108;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.adapter.ContactsDeviceAdapter
 * JD-Core Version:    0.7.0.1
 */