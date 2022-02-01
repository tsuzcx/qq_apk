package com.dataline.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.data.PrinterEntity;
import com.dataline.data.PrinterManager;
import com.dataline.util.PrinterSessionAdapter;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.app.PrinterStatusHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.open.pcpush.OpenFileUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrinterActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static String a = "dataline.PrinterActivity";
  private long jdField_a_of_type_Long = 0L;
  public ViewGroup a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private AsyncImageView jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = null;
  private DataLineHandler jdField_a_of_type_ComTencentMobileqqAppDataLineHandler = null;
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new PrinterActivity.2(this);
  public ScrollerRunnable a;
  public XListView a;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView = null;
  private String jdField_b_of_type_JavaLangString = "";
  private TextView jdField_c_of_type_AndroidWidgetTextView = null;
  private String jdField_c_of_type_JavaLangString = "";
  private String d = "";
  
  public PrinterActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = null;
  }
  
  private void a()
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(localRelativeLayout);
      SharePreferenceUtils.a(this, "hp_bind_tip_key", String.valueOf(System.currentTimeMillis()));
    }
  }
  
  private void a(Object paramObject)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      LayoutInflater.from(this).inflate(2131559024, this.jdField_a_of_type_AndroidViewViewGroup, true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363605));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363606));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363603));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363604));
      this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366782));
      Drawable localDrawable = super.getResources().getDrawable(2130840380);
      this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageDrawable(localDrawable);
    }
    paramObject = (Object[])paramObject;
    this.jdField_a_of_type_Long = ((Long)paramObject[0]).longValue();
    this.jdField_b_of_type_JavaLangString = ((String)paramObject[1]);
    this.jdField_c_of_type_JavaLangString = ((String)paramObject[2]);
    this.d = ((String)paramObject[3]);
    paramObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (paramObject != null) {
      paramObject.setOnClickListener(this);
    }
    SmartDeviceReport.a();
    SmartDeviceReport.a(this.app, this.jdField_a_of_type_Long, "printer_hp", 1, 0, 0);
  }
  
  private boolean a()
  {
    String str = SharePreferenceUtils.a(this, "hp_bind_tip_key");
    boolean bool2 = TextUtils.isEmpty(str);
    boolean bool1 = true;
    if (!bool2)
    {
      long l = Long.parseLong(str);
      if (System.currentTimeMillis() - l > 2592000L) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1;
    if (paramInt1 == 56)
    {
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getParcelableArrayListExtra("sFilesSelected");
        localObject1 = new Intent(this, PrinterOptionActivity.class);
        ((Intent)localObject1).setClass(this, PrinterOptionActivity.class);
        ((Intent)localObject1).putParcelableArrayListExtra("sFilesSelected", paramIntent);
        ((Intent)localObject1).putExtra(AlbumConstants.h, paramInt1);
        super.startActivityForResult((Intent)localObject1, 102);
      }
    }
    else if ((paramInt1 == 102) && (paramInt2 == -1))
    {
      localObject1 = paramIntent.getParcelableArrayListExtra("sFilesSelected");
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = paramIntent.getStringExtra("sPrintParam");
      paramIntent.getLongExtra("sPrintDin", 0L);
      paramIntent.getStringExtra("sPrinterName");
      Object localObject3 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject3).hasNext()) {
        if (new VFSFile(((FileInfo)((Iterator)localObject3).next()).c()).exists())
        {
          paramInt1 = 1;
          break label172;
        }
      }
      paramInt1 = 0;
      label172:
      if (paramInt1 == 0)
      {
        LiteActivity.a(this);
        return;
      }
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a;
      if (localObject3 == null) {
        return;
      }
      boolean bool = ((PrinterEntity)localObject3).a((List)localObject1, (String)localObject2, this.app);
      if (((PrinterEntity)localObject3).jdField_a_of_type_Int == 2)
      {
        if (bool)
        {
          Object localObject4 = PrinterManager.a(this.app, ((PrinterEntity)localObject3).jdField_a_of_type_Long);
          if (localObject4 != null)
          {
            localObject2 = (SmartDeviceProxyMgr)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
            localObject3 = new Bundle();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(((DeviceInfo)localObject4).din);
            localStringBuilder.append("");
            ((Bundle)localObject3).putString("din", localStringBuilder.toString());
            localObject4 = ((SmartDeviceProxyMgr)localObject2).a(((DeviceInfo)localObject4).productId);
            if (localObject4 != null) {
              ((Bundle)localObject3).putString("devName", ((ProductInfo)localObject4).deviceName);
            }
            ((Bundle)localObject3).putBoolean("bFromLightApp", false);
            ((Bundle)localObject3).putInt("operType", 0);
            ((Bundle)localObject3).putInt("jumpTab", 0);
            ((SmartDeviceProxyMgr)localObject2).a((Bundle)localObject3);
          }
          finish();
        }
      }
      else {
        paramInt1 = ((PrinterEntity)localObject3).jdField_a_of_type_Int;
      }
      switch (paramIntent.getIntExtra(AlbumConstants.h, 0))
      {
      default: 
        break;
      case 57: 
        ReportController.b(this.app, "CliOper", "", "", "0X800405B", "0X800405B", 0, 0, "", "", "", "");
        break;
      case 56: 
        ReportController.b(this.app, "CliOper", "", "", "0X800405A", "0X800405A", 0, 0, "", "", "", "");
        break;
      case 55: 
        ReportController.b(this.app, "CliOper", "", "", "0X800405C", "0X800405C", 0, 0, "", "", "", "");
      }
      paramIntent = ((ArrayList)localObject1).iterator();
      while (paramIntent.hasNext())
      {
        localObject1 = (FileInfo)paramIntent.next();
        if (OpenFileUtil.a(((FileInfo)localObject1).d().toLowerCase(), new String[] { ".txt" })) {
          ReportController.b(this.app, "CliOper", "", "", "0X800401A", "0X800401A", 0, 0, "", "", "", "");
        } else if (OpenFileUtil.a(((FileInfo)localObject1).d().toLowerCase(), new String[] { ".doc", ".docx" })) {
          ReportController.b(this.app, "CliOper", "", "", "0X800401B", "0X800401B", 0, 0, "", "", "", "");
        } else if (OpenFileUtil.a(((FileInfo)localObject1).d().toLowerCase(), new String[] { ".ppt", ".pptx" })) {
          ReportController.b(this.app, "CliOper", "", "", "0X800401C", "0X800401C", 0, 0, "", "", "", "");
        } else if (OpenFileUtil.a(((FileInfo)localObject1).d().toLowerCase(), new String[] { ".xls", ".xlsx" })) {
          ReportController.b(this.app, "CliOper", "", "", "0X800401D", "0X800401D", 0, 0, "", "", "", "");
        } else if (OpenFileUtil.a(((FileInfo)localObject1).d().toLowerCase(), new String[] { ".jpg", ".png", ".jpeg", ".bmp" })) {
          ReportController.b(this.app, "CliOper", "", "", "0X800401E", "0X800401E", 0, 0, "", "", "", "");
        } else if (OpenFileUtil.a(((FileInfo)localObject1).d().toLowerCase(), new String[] { ".pdf" })) {
          ReportController.b(this.app, "CliOper", "", "", "0X800401F", "0X800401F", 0, 0, "", "", "", "");
        } else {
          ReportController.b(this.app, "CliOper", "", "", "0X8004020", "0X8004020", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.getWindow().setBackgroundDrawableResource(2131165419);
    super.setContentView(2131559019);
    super.setTitle(2131691372);
    super.getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidViewViewGroup = ((FrameLayout)super.findViewById(2131365395));
    this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131361813, "n/a");
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131378470));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131378471));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler = ((DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a = new PrinterSessionAdapter(this, this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131370176));
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a);
    paramBundle = LayoutInflater.from(this).inflate(2131558901, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(super.getResources().getDrawable(2130844803));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new PrinterActivity.1(this));
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    paramBundle = (PrinterStatusHandler)this.app.getBusinessHandler(BusinessHandlerFactory.PRINTER_STATUS_HANDLER);
    if (a()) {
      paramBundle.b();
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a = null;
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.b();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
    if (localObject != null) {
      ((ScrollerRunnable)localObject).b();
    }
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView((View)localObject);
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    LiteActivity.a(this, this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a.notifyDataSetChanged();
    LiteActivity.a(this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_ComTencentWidgetXListView);
    LiteActivity.a(this.jdField_a_of_type_ComTencentWidgetXListView);
    Object localObject1 = super.getIntent();
    int i = ((Intent)localObject1).getIntExtra(AlbumConstants.h, -1);
    Object localObject2;
    if ((55 == i) || (i == 57))
    {
      ((Intent)localObject1).removeExtra(AlbumConstants.h);
      localObject2 = ((Intent)localObject1).getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
    }
    for (;;)
    {
      String str;
      if (((Iterator)localObject2).hasNext()) {
        str = (String)((Iterator)localObject2).next();
      }
      try
      {
        ((ArrayList)localObject1).add(new FileInfo(str));
      }
      catch (FileNotFoundException localFileNotFoundException) {}
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject2 = new Intent(this, PrinterOptionActivity.class);
        ((Intent)localObject2).putExtra(AlbumConstants.h, i);
        ((Intent)localObject2).putParcelableArrayListExtra("sFilesSelected", (ArrayList)localObject1);
        startActivityForResult((Intent)localObject2, 102);
        return;
      }
      LiteActivity.a(this);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i == 2131378470)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a();
      ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).openFileSelectorByPrinter(this, (String[])localObject, 56);
      AlbumUtil.anim(this, false, true);
      ReportController.b(this.app, "CliOper", "", "", "0X8004018", "0X8004018", 0, 0, "", "", "", "");
    }
    else if (i == 2131378471)
    {
      localObject = new Intent(this, NewPhotoListActivity.class);
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", PrinterActivity.class.getName());
      ((Intent)localObject).putExtra("busiType", 5);
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      ((Intent)localObject).putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
      ((Intent)localObject).putExtra(AlbumConstants.h, 57);
      ((Intent)localObject).putExtra("uin", AppConstants.DATALINE_PRINTER_UIN);
      ((Intent)localObject).putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
      ((Intent)localObject).putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
      ((Intent)localObject).getExtras().remove("forward_type");
      ((Intent)localObject).putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      ((Intent)localObject).putExtra("STRING_Show_Within_Suffixs", this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a());
      super.startActivity((Intent)localObject);
      AlbumUtil.anim(this, false, true);
      ReportController.b(this.app, "CliOper", "", "", "0X8004019", "0X8004019", 0, 0, "", "", "", "");
    }
    else if (i == 2131363605)
    {
      localObject = new Intent();
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        ((Intent)localObject).setClass(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", this.d);
        ((Intent)localObject).putExtra("title", HardCodeUtil.a(2131708409));
        ((Intent)localObject).putExtra("webStyle", "noBottomBar");
        ((Intent)localObject).putExtra("hide_more_button", true);
        ((Intent)localObject).putExtra("selfSet_leftViewText", HardCodeUtil.a(2131708410));
        ((Intent)localObject).putExtra("leftViewText", HardCodeUtil.a(2131708411));
        SmartDeviceReport.a();
        SmartDeviceReport.a(this.app, this.jdField_a_of_type_Long, "printer_hp", 3, 0, 0);
      }
      else
      {
        ((Intent)localObject).setClass(this, PrinterBindTipActivity.class);
        ((Intent)localObject).putExtra("printer_bind_url", this.jdField_c_of_type_JavaLangString);
        ((Intent)localObject).putExtra("din", this.jdField_a_of_type_Long);
        SmartDeviceReport.a();
        SmartDeviceReport.a(this.app, this.jdField_a_of_type_Long, "printer_hp", 4, 0, 0);
      }
      a(this, (Intent)localObject);
      a();
      SmartDeviceReport.a();
      SmartDeviceReport.a(this.app, this.jdField_a_of_type_Long, "printer_hp", 2, 0, 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.PrinterActivity
 * JD-Core Version:    0.7.0.1
 */