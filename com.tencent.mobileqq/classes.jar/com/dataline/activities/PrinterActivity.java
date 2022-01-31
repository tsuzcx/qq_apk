package com.dataline.activities;

import aagb;
import alof;
import alqo;
import alqv;
import alud;
import alyw;
import alyz;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import azqs;
import bdea;
import bdez;
import bdfa;
import bfrb;
import co;
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
import com.tencent.widget.XListView;
import cp;
import de;
import df;
import en;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ztp;

public class PrinterActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static String a;
  private long jdField_a_of_type_Long;
  private alqo jdField_a_of_type_Alqo;
  private alqv jdField_a_of_type_Alqv = new cp(this);
  public ViewGroup a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
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
      bdea.a(this, "hp_bind_tip_key", String.valueOf(System.currentTimeMillis()));
    }
  }
  
  private void a(Object paramObject)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      LayoutInflater.from(this).inflate(2131558985, this.jdField_a_of_type_AndroidViewViewGroup, true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363272));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363273));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363270));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363271));
      this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366302));
      Drawable localDrawable = super.getResources().getDrawable(2130840135);
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
    aagb.a();
    aagb.a(this.app, this.jdField_a_of_type_Long, "printer_hp", 1, 0, 0);
  }
  
  private boolean a()
  {
    String str = bdea.a(this, "hp_bind_tip_key");
    long l;
    if (!TextUtils.isEmpty(str)) {
      l = Long.parseLong(str);
    }
    return System.currentTimeMillis() - l > 2592000L;
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
        ((Intent)localObject1).putExtra(bdez.h, paramInt1);
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
      localObject3 = this.jdField_a_of_type_Alqo.jdField_a_of_type_Df.a;
      if (localObject3 == null) {
        break;
      }
      boolean bool = ((de)localObject3).a((List)localObject1, (String)localObject2, this.app);
      label396:
      if (((de)localObject3).jdField_a_of_type_Int == 2)
      {
        if (bool)
        {
          Object localObject4 = df.a(this.app, ((de)localObject3).jdField_a_of_type_Long);
          if (localObject4 != null)
          {
            localObject2 = (ztp)this.app.a(51);
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("din", ((DeviceInfo)localObject4).din + "");
            localObject4 = ((ztp)localObject2).a(((DeviceInfo)localObject4).productId);
            if (localObject4 != null) {
              ((Bundle)localObject3).putString("devName", ((ProductInfo)localObject4).deviceName);
            }
            ((Bundle)localObject3).putBoolean("bFromLightApp", false);
            ((Bundle)localObject3).putInt("operType", 0);
            ((Bundle)localObject3).putInt("jumpTab", 0);
            ((ztp)localObject2).a((Bundle)localObject3);
          }
          finish();
        }
        label362:
        switch (paramIntent.getIntExtra(bdez.h, 0))
        {
        default: 
          paramIntent = ((ArrayList)localObject1).iterator();
        }
      }
      while (paramIntent.hasNext())
      {
        localObject1 = (FileInfo)paramIntent.next();
        if (bfrb.a(((FileInfo)localObject1).d().toLowerCase(), new String[] { ".txt" }))
        {
          azqs.b(this.app, "CliOper", "", "", "0X800401A", "0X800401A", 0, 0, "", "", "", "");
          continue;
          if ((((de)localObject3).jdField_a_of_type_Int != 1) || (!bool)) {
            break label362;
          }
          break label362;
          azqs.b(this.app, "CliOper", "", "", "0X800405C", "0X800405C", 0, 0, "", "", "", "");
          break label396;
          azqs.b(this.app, "CliOper", "", "", "0X800405A", "0X800405A", 0, 0, "", "", "", "");
          break label396;
          azqs.b(this.app, "CliOper", "", "", "0X800405B", "0X800405B", 0, 0, "", "", "", "");
          break label396;
        }
        if (bfrb.a(((FileInfo)localObject1).d().toLowerCase(), new String[] { ".doc", ".docx" })) {
          azqs.b(this.app, "CliOper", "", "", "0X800401B", "0X800401B", 0, 0, "", "", "", "");
        } else if (bfrb.a(((FileInfo)localObject1).d().toLowerCase(), new String[] { ".ppt", ".pptx" })) {
          azqs.b(this.app, "CliOper", "", "", "0X800401C", "0X800401C", 0, 0, "", "", "", "");
        } else if (bfrb.a(((FileInfo)localObject1).d().toLowerCase(), new String[] { ".xls", ".xlsx" })) {
          azqs.b(this.app, "CliOper", "", "", "0X800401D", "0X800401D", 0, 0, "", "", "", "");
        } else if (bfrb.a(((FileInfo)localObject1).d().toLowerCase(), new String[] { ".jpg", ".png", ".jpeg", ".bmp" })) {
          azqs.b(this.app, "CliOper", "", "", "0X800401E", "0X800401E", 0, 0, "", "", "", "");
        } else if (bfrb.a(((FileInfo)localObject1).d().toLowerCase(), new String[] { ".pdf" })) {
          azqs.b(this.app, "CliOper", "", "", "0X800401F", "0X800401F", 0, 0, "", "", "", "");
        } else {
          azqs.b(this.app, "CliOper", "", "", "0X8004020", "0X8004020", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.getWindow().setBackgroundDrawableResource(2131165395);
    super.setContentView(2131558980);
    super.setTitle(2131691433);
    super.getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidViewViewGroup = ((FrameLayout)super.findViewById(2131364991));
    this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131361806, "n/a");
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131377617));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131377618));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_Alqo = ((alqo)this.app.a(8));
    this.jdField_a_of_type_Alqo.jdField_a_of_type_Alyw.a = new en(this, this.jdField_a_of_type_Alqo);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131369582));
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Alqo.jdField_a_of_type_Alyw.a);
    paramBundle = LayoutInflater.from(this).inflate(2131558860, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(super.getResources().getDrawable(2130844413));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new co(this));
    this.app.addObserver(this.jdField_a_of_type_Alqv);
    paramBundle = (alyz)this.app.a(74);
    if (a()) {
      paramBundle.b();
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_Alqo.jdField_a_of_type_Alyw.a = null;
    this.jdField_a_of_type_Alqo.jdField_a_of_type_Alyw.b();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b();
    }
    this.app.removeObserver(this.jdField_a_of_type_Alqv);
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
    this.jdField_a_of_type_Alqo.jdField_a_of_type_Alyw.a.notifyDataSetChanged();
    LiteActivity.a(this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_ComTencentWidgetXListView);
    LiteActivity.a(this.jdField_a_of_type_ComTencentWidgetXListView);
    Object localObject1 = super.getIntent();
    int i = ((Intent)localObject1).getIntExtra(bdez.h, -1);
    if ((55 == i) || (i == 57))
    {
      ((Intent)localObject1).removeExtra(bdez.h);
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
        ((Intent)localObject2).putExtra(bdez.h, i);
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
    if (i == 2131377617)
    {
      paramView = new Intent(super.getApplicationContext(), FMLocalFileActivity.class);
      paramView.putExtra("category", 6);
      paramView.putExtra("busiType", 5);
      paramView.putExtra("selectMode", true);
      paramView.putExtra("targetUin", alof.B);
      paramView.putExtra("peerType", 6001);
      paramView.putExtra("STRING_Show_Music_Category", false);
      paramView.putExtra("STRING_Show_Video_Category", false);
      paramView.putExtra("STRING_Show_Apk_Category", false);
      paramView.putExtra("STRING_Show_Pic_Category", false);
      paramView.putExtra("STRING_SingleSelect", true);
      paramView.putExtra(bdez.h, 56);
      paramView.putExtra("STRING_Show_Within_Suffixs", this.jdField_a_of_type_Alqo.jdField_a_of_type_Alyw.a());
      super.startActivityForResult(paramView, 56);
      bdfa.anim(this, false, true);
      azqs.b(this.app, "CliOper", "", "", "0X8004018", "0X8004018", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if (i == 2131377618)
      {
        paramView = new Intent(this, NewPhotoListActivity.class);
        paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", PrinterActivity.class.getName());
        paramView.putExtra("busiType", 5);
        paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramView.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
        paramView.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
        paramView.putExtra(bdez.h, 57);
        paramView.putExtra("uin", alof.B);
        paramView.putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
        paramView.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
        paramView.getExtras().remove("forward_type");
        paramView.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
        paramView.putExtra("STRING_Show_Within_Suffixs", this.jdField_a_of_type_Alqo.jdField_a_of_type_Alyw.a());
        super.startActivity(paramView);
        bdfa.anim(this, false, true);
        azqs.b(this.app, "CliOper", "", "", "0X8004019", "0X8004019", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2131363272);
    paramView = new Intent();
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      paramView.setClass(this, QQBrowserActivity.class);
      paramView.putExtra("url", this.d);
      paramView.putExtra("title", alud.a(2131708812));
      paramView.putExtra("webStyle", "noBottomBar");
      paramView.putExtra("hide_more_button", true);
      paramView.putExtra("selfSet_leftViewText", alud.a(2131708813));
      paramView.putExtra("leftViewText", alud.a(2131708814));
      aagb.a();
      aagb.a(this.app, this.jdField_a_of_type_Long, "printer_hp", 3, 0, 0);
    }
    for (;;)
    {
      a(this, paramView);
      a();
      aagb.a();
      aagb.a(this.app, this.jdField_a_of_type_Long, "printer_hp", 2, 0, 0);
      return;
      paramView.setClass(this, PrinterBindTipActivity.class);
      paramView.putExtra("printer_bind_url", this.jdField_c_of_type_JavaLangString);
      paramView.putExtra("din", this.jdField_a_of_type_Long);
      aagb.a();
      aagb.a(this.app, this.jdField_a_of_type_Long, "printer_hp", 4, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.dataline.activities.PrinterActivity
 * JD-Core Version:    0.7.0.1
 */