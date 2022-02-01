package com.dataline.activities;

import Override;
import abur;
import achd;
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
import antf;
import anvu;
import anwb;
import anzj;
import aodj;
import aodm;
import bdll;
import bhjc;
import bhkc;
import bhkd;
import bjzg;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import ct;
import cu;
import dj;
import dk;
import es;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrinterActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static String a;
  private long jdField_a_of_type_Long;
  public ViewGroup a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anvu jdField_a_of_type_Anvu;
  private anwb jdField_a_of_type_Anwb = new cu(this);
  private AsyncImageView jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView;
  public ScrollerRunnable a;
  public XListView a;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "";
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString = "";
  private String d = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "dataline.PrinterActivity";
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      bhjc.a(this, "hp_bind_tip_key", String.valueOf(System.currentTimeMillis()));
    }
  }
  
  private void a(Object paramObject)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      LayoutInflater.from(this).inflate(2131559052, this.jdField_a_of_type_AndroidViewViewGroup, true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363486));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363487));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363484));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363485));
      this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366605));
      Drawable localDrawable = super.getResources().getDrawable(2130840324);
      this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageDrawable(localDrawable);
    }
    paramObject = (Object[])paramObject;
    this.jdField_a_of_type_Long = ((Long)paramObject[0]).longValue();
    this.jdField_b_of_type_JavaLangString = ((String)paramObject[1]);
    this.jdField_c_of_type_JavaLangString = ((String)paramObject[2]);
    this.d = ((String)paramObject[3]);
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    }
    achd.a();
    achd.a(this.app, this.jdField_a_of_type_Long, "printer_hp", 1, 0, 0);
  }
  
  private boolean a()
  {
    String str = bhjc.a(this, "hp_bind_tip_key");
    long l;
    if (!TextUtils.isEmpty(str)) {
      l = Long.parseLong(str);
    }
    return System.currentTimeMillis() - l > 2592000L;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1;
    if (paramInt1 == 56) {
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getParcelableArrayListExtra("sFilesSelected");
        localObject1 = new Intent(this, PrinterOptionActivity.class);
        ((Intent)localObject1).setClass(this, PrinterOptionActivity.class);
        ((Intent)localObject1).putParcelableArrayListExtra("sFilesSelected", paramIntent);
        ((Intent)localObject1).putExtra(bhkc.h, paramInt1);
        super.startActivityForResult((Intent)localObject1, 102);
      }
    }
    do
    {
      do
      {
        return;
      } while ((paramInt1 != 102) || (paramInt2 != -1));
      localObject1 = paramIntent.getParcelableArrayListExtra("sFilesSelected");
    } while (localObject1 == null);
    Object localObject2 = paramIntent.getStringExtra("sPrintParam");
    paramIntent.getLongExtra("sPrintDin", 0L);
    paramIntent.getStringExtra("sPrinterName");
    Object localObject3 = ((ArrayList)localObject1).iterator();
    do
    {
      if (!((Iterator)localObject3).hasNext()) {
        break;
      }
    } while (!new VFSFile(((FileInfo)((Iterator)localObject3).next()).c()).exists());
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0)
      {
        LiteActivity.a(this);
        return;
      }
      localObject3 = this.jdField_a_of_type_Anvu.jdField_a_of_type_Dk.a;
      if (localObject3 == null) {
        break;
      }
      boolean bool = ((dj)localObject3).a((List)localObject1, (String)localObject2, this.app);
      label396:
      if (((dj)localObject3).jdField_a_of_type_Int == 2)
      {
        if (bool)
        {
          Object localObject4 = dk.a(this.app, ((dj)localObject3).jdField_a_of_type_Long);
          if (localObject4 != null)
          {
            localObject2 = (abur)this.app.a(51);
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("din", ((DeviceInfo)localObject4).din + "");
            localObject4 = ((abur)localObject2).a(((DeviceInfo)localObject4).productId);
            if (localObject4 != null) {
              ((Bundle)localObject3).putString("devName", ((ProductInfo)localObject4).deviceName);
            }
            ((Bundle)localObject3).putBoolean("bFromLightApp", false);
            ((Bundle)localObject3).putInt("operType", 0);
            ((Bundle)localObject3).putInt("jumpTab", 0);
            ((abur)localObject2).a((Bundle)localObject3);
          }
          finish();
        }
        label362:
        switch (paramIntent.getIntExtra(bhkc.h, 0))
        {
        default: 
          paramIntent = ((ArrayList)localObject1).iterator();
        }
      }
      while (paramIntent.hasNext())
      {
        localObject1 = (FileInfo)paramIntent.next();
        if (bjzg.a(((FileInfo)localObject1).d().toLowerCase(), new String[] { ".txt" }))
        {
          bdll.b(this.app, "CliOper", "", "", "0X800401A", "0X800401A", 0, 0, "", "", "", "");
          continue;
          if ((((dj)localObject3).jdField_a_of_type_Int != 1) || (!bool)) {
            break label362;
          }
          break label362;
          bdll.b(this.app, "CliOper", "", "", "0X800405C", "0X800405C", 0, 0, "", "", "", "");
          break label396;
          bdll.b(this.app, "CliOper", "", "", "0X800405A", "0X800405A", 0, 0, "", "", "", "");
          break label396;
          bdll.b(this.app, "CliOper", "", "", "0X800405B", "0X800405B", 0, 0, "", "", "", "");
          break label396;
        }
        if (bjzg.a(((FileInfo)localObject1).d().toLowerCase(), new String[] { ".doc", ".docx" })) {
          bdll.b(this.app, "CliOper", "", "", "0X800401B", "0X800401B", 0, 0, "", "", "", "");
        } else if (bjzg.a(((FileInfo)localObject1).d().toLowerCase(), new String[] { ".ppt", ".pptx" })) {
          bdll.b(this.app, "CliOper", "", "", "0X800401C", "0X800401C", 0, 0, "", "", "", "");
        } else if (bjzg.a(((FileInfo)localObject1).d().toLowerCase(), new String[] { ".xls", ".xlsx" })) {
          bdll.b(this.app, "CliOper", "", "", "0X800401D", "0X800401D", 0, 0, "", "", "", "");
        } else if (bjzg.a(((FileInfo)localObject1).d().toLowerCase(), new String[] { ".jpg", ".png", ".jpeg", ".bmp" })) {
          bdll.b(this.app, "CliOper", "", "", "0X800401E", "0X800401E", 0, 0, "", "", "", "");
        } else if (bjzg.a(((FileInfo)localObject1).d().toLowerCase(), new String[] { ".pdf" })) {
          bdll.b(this.app, "CliOper", "", "", "0X800401F", "0X800401F", 0, 0, "", "", "", "");
        } else {
          bdll.b(this.app, "CliOper", "", "", "0X8004020", "0X8004020", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.getWindow().setBackgroundDrawableResource(2131165429);
    super.setContentView(2131559047);
    super.setTitle(2131691216);
    super.getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidViewViewGroup = ((FrameLayout)super.findViewById(2131365271));
    this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131361807, "n/a");
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131378614));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131378615));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_Anvu = ((anvu)this.app.a(8));
    this.jdField_a_of_type_Anvu.jdField_a_of_type_Aodj.a = new es(this, this.jdField_a_of_type_Anvu);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131370075));
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Anvu.jdField_a_of_type_Aodj.a);
    paramBundle = LayoutInflater.from(this).inflate(2131558931, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(super.getResources().getDrawable(2130844821));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new ct(this));
    this.app.addObserver(this.jdField_a_of_type_Anwb);
    paramBundle = (aodm)this.app.a(74);
    if (a()) {
      paramBundle.b();
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_Anvu.jdField_a_of_type_Aodj.a = null;
    this.jdField_a_of_type_Anvu.jdField_a_of_type_Aodj.b();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b();
    }
    this.app.removeObserver(this.jdField_a_of_type_Anwb);
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    LiteActivity.a(this, this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_Anvu.jdField_a_of_type_Aodj.a.notifyDataSetChanged();
    LiteActivity.a(this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_ComTencentWidgetXListView);
    LiteActivity.a(this.jdField_a_of_type_ComTencentWidgetXListView);
    Object localObject1 = super.getIntent();
    int i = ((Intent)localObject1).getIntExtra(bhkc.h, -1);
    if ((55 == i) || (i == 57))
    {
      ((Intent)localObject1).removeExtra(bhkc.h);
      Object localObject2 = ((Intent)localObject1).getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        try
        {
          ((ArrayList)localObject1).add(new FileInfo(str));
        }
        catch (FileNotFoundException localFileNotFoundException) {}
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject2 = new Intent(this, PrinterOptionActivity.class);
        ((Intent)localObject2).putExtra(bhkc.h, i);
        ((Intent)localObject2).putParcelableArrayListExtra("sFilesSelected", (ArrayList)localObject1);
        startActivityForResult((Intent)localObject2, 102);
      }
    }
    else
    {
      return;
    }
    LiteActivity.a(this);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131378614)
    {
      localIntent = new Intent(super.getApplicationContext(), FMLocalFileActivity.class);
      localIntent.putExtra("category", 6);
      localIntent.putExtra("busiType", 5);
      localIntent.putExtra("selectMode", true);
      localIntent.putExtra("targetUin", antf.B);
      localIntent.putExtra("peerType", 6001);
      localIntent.putExtra("STRING_Show_Music_Category", false);
      localIntent.putExtra("STRING_Show_Video_Category", false);
      localIntent.putExtra("STRING_Show_Apk_Category", false);
      localIntent.putExtra("STRING_Show_Pic_Category", false);
      localIntent.putExtra("STRING_SingleSelect", true);
      localIntent.putExtra(bhkc.h, 56);
      localIntent.putExtra("STRING_Show_Within_Suffixs", this.jdField_a_of_type_Anvu.jdField_a_of_type_Aodj.a());
      super.startActivityForResult(localIntent, 56);
      bhkd.anim(this, false, true);
      bdll.b(this.app, "CliOper", "", "", "0X8004018", "0X8004018", 0, 0, "", "", "", "");
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (i != 2131378615) {
          break;
        }
        localIntent = new Intent(this, NewPhotoListActivity.class);
        localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", PrinterActivity.class.getName());
        localIntent.putExtra("busiType", 5);
        localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
        localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
        localIntent.putExtra(bhkc.h, 57);
        localIntent.putExtra("uin", antf.B);
        localIntent.putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
        localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
        localIntent.getExtras().remove("forward_type");
        localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
        localIntent.putExtra("STRING_Show_Within_Suffixs", this.jdField_a_of_type_Anvu.jdField_a_of_type_Aodj.a());
        super.startActivity(localIntent);
        bhkd.anim(this, false, true);
        bdll.b(this.app, "CliOper", "", "", "0X8004019", "0X8004019", 0, 0, "", "", "", "");
      }
    } while (i != 2131363486);
    Intent localIntent = new Intent();
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      localIntent.setClass(this, QQBrowserActivity.class);
      localIntent.putExtra("url", this.d);
      localIntent.putExtra("title", anzj.a(2131707297));
      localIntent.putExtra("webStyle", "noBottomBar");
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("selfSet_leftViewText", anzj.a(2131707298));
      localIntent.putExtra("leftViewText", anzj.a(2131707299));
      achd.a();
      achd.a(this.app, this.jdField_a_of_type_Long, "printer_hp", 3, 0, 0);
    }
    for (;;)
    {
      a(this, localIntent);
      a();
      achd.a();
      achd.a(this.app, this.jdField_a_of_type_Long, "printer_hp", 2, 0, 0);
      break;
      localIntent.setClass(this, PrinterBindTipActivity.class);
      localIntent.putExtra("printer_bind_url", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("din", this.jdField_a_of_type_Long);
      achd.a();
      achd.a(this.app, this.jdField_a_of_type_Long, "printer_hp", 4, 0, 0);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.dataline.activities.PrinterActivity
 * JD-Core Version:    0.7.0.1
 */