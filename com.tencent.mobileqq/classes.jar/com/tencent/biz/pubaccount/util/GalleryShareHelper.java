package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItem;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemAdapter;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemViewHolder;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import msw;
import msx;
import msy;
import mta;
import mtb;
import mtc;
import mtd;
import mte;
import tencent.im.oidb.gallery.gallery.GalleryInfo;

public class GalleryShareHelper
  implements AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString;
  private gallery.GalleryInfo jdField_a_of_type_TencentImOidbGalleryGallery$GalleryInfo;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  
  public GalleryShareHelper(FragmentActivity paramFragmentActivity)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidContentContext = paramFragmentActivity;
    paramFragmentActivity = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramFragmentActivity instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramFragmentActivity);
    }
  }
  
  private View a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2130968984, null);
    float f1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDisplayMetrics().density;
    ElasticHorScrView localElasticHorScrView1 = (ElasticHorScrView)localView.findViewById(2131363794);
    ElasticHorScrView localElasticHorScrView2 = (ElasticHorScrView)localView.findViewById(2131363796);
    GridView localGridView2 = (GridView)localView.findViewById(2131363795);
    GridView localGridView1 = (GridView)localView.findViewById(2131363797);
    Object localObject1 = (TextView)localView.findViewById(2131362797);
    Object localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(13.0F * f1));
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((TextView)localObject1).setText(2131432998);
    ((TextView)localObject1).setOnClickListener(new msw(this));
    if (Build.VERSION.SDK_INT >= 9)
    {
      localElasticHorScrView1.setOverScrollMode(2);
      localElasticHorScrView2.setOverScrollMode(2);
    }
    localGridView1.setSmoothScrollbarEnabled(false);
    localObject2 = a();
    if (localObject2.length > 0)
    {
      localObject1 = localObject2[0];
      if (localObject2.length <= 1) {
        break label415;
      }
    }
    label415:
    for (localObject2 = localObject2[1];; localObject2 = new ArrayList(0))
    {
      int m = ((List)localObject1).size();
      localGridView2.setNumColumns(m);
      ViewGroup.LayoutParams localLayoutParams = localGridView2.getLayoutParams();
      localLayoutParams.width = ((int)(((m - 1) * 10 + m * 75 + 3) * f1));
      localGridView2.setLayoutParams(localLayoutParams);
      localGridView2.setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, (List)localObject1));
      localGridView2.setSelector(new ColorDrawable(0));
      localGridView2.setOnItemClickListener(this);
      m = localLayoutParams.width;
      int n = ((List)localObject2).size();
      localObject1 = localGridView1.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ((int)(f1 * (n * 75 + (n - 1) * 10 + 3)));
      localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localGridView1.setNumColumns(n);
      localGridView1.setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, (List)localObject2));
      localGridView1.setSelector(new ColorDrawable(0));
      localGridView1.setOnItemClickListener(this);
      localView.post(new msx(this, localElasticHorScrView1, m, localElasticHorScrView2, ((ViewGroup.LayoutParams)localObject1).width));
      return localView;
      localObject1 = new ArrayList(0);
      break;
    }
  }
  
  private void a(URLDrawable paramURLDrawable, String paramString)
  {
    new mtd(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4)))
    {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131435286), 0).a();
      if (QLog.isColorLevel()) {
        QLog.d("GalleryShareHelper", 2, "shareToFriendparams is Empty");
      }
    }
    Bundle localBundle;
    do
    {
      return;
      localBundle = new Bundle();
      localBundle.putString("title", paramString1);
      localBundle.putString("desc", paramString2);
      localBundle.putString("detail_url", paramString3);
      paramString1 = new ArrayList(1);
      paramString1.add(paramString4);
      localBundle.putStringArrayList("image_url", paramString1);
      localBundle.putLong("req_share_id", 0L);
    } while (QZoneShareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localBundle, null));
    QRUtils.a(1, 2131435463);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString5)))
    {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131435286), 0).a();
      if (QLog.isColorLevel()) {
        QLog.d("GalleryShareHelper", 2, "shareToFriendparams is Empty");
      }
      return;
    }
    String str = paramString4;
    if (!TextUtils.isEmpty(paramString4)) {
      str = paramString4 + "&source=9";
    }
    paramString4 = paramString5;
    if (ReadInJoyUtils.a(paramString5)) {
      paramString4 = ReadInJoyUtils.a(paramString5, 260, 520, 1);
    }
    paramString5 = new Intent();
    paramString5.setClass(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ForwardRecentActivity.class);
    paramString5.putExtra("key_flag_from_plugin", true);
    paramString5.putExtra("pluginName", "web_share");
    paramString5.putExtra("title", paramString1);
    paramString5.putExtra("desc", paramString2);
    paramString5.putExtra("detail_url", paramString3);
    paramString5.putExtra("shareQQType", 13);
    paramString5.putExtra("forward_type", 1001);
    paramString5.putExtra("pkg_name", "com.tencent.mobileqq");
    paramString5.putExtra("image_url_remote", paramString4);
    paramString5.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131430100, new Object[] { paramString1 }));
    paramString5.putExtra("req_type", 1);
    paramString5.putExtra("k_back", true);
    paramString5.putExtra("new_share_service_id", "83");
    paramString1 = paramString6;
    if (TextUtils.isEmpty(paramString6)) {
      paramString1 = "";
    }
    paramString5.putExtra("app_name", paramString1);
    paramString1 = paramString8;
    if (TextUtils.isEmpty(paramString8)) {
      paramString1 = "";
    }
    paramString5.putExtra("struct_share_key_source_icon", paramString1);
    paramString5.putExtra("struct_share_key_source_action", "web");
    if (TextUtils.isEmpty(paramString7)) {}
    for (paramString1 = "";; paramString1 = paramString7.trim())
    {
      paramString5.putExtra("struct_share_key_source_url", paramString1);
      paramString5.putExtra("readinjoy_gallery", str);
      paramString5.putExtra("stuctmsg_bytes", StructMsgFactory.a(paramString5.getExtras()).getBytes());
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(paramString5, 1);
      return;
    }
  }
  
  private List[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131430091);
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130838332;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 2;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131430097);
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130838333;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 3;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131430109);
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130838336;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 9;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131430110);
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130838330;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 10;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131430115);
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130838335;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 12;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131430095);
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130840650;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 4;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    PublicAccountBrowser.ActionSheetItem localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131430124);
    localActionSheetItem.jdField_a_of_type_Int = 2130838334;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_b_of_type_Int = 23;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131430107);
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_a_of_type_Int = 2130841536;
    localActionSheetItem.jdField_b_of_type_Int = 6;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131430093);
    localActionSheetItem.jdField_a_of_type_Int = 2130838328;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_b_of_type_Int = 1;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131430094);
    localActionSheetItem.jdField_a_of_type_Int = 2130840641;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_b_of_type_Int = 11;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  private void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryShareHelper", 2, "shareMsgToSina start!");
    }
    FragmentActivity localFragmentActivity = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    paramString1 = "#QQ看点#【" + paramString1 + "】" + paramString2;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localFragmentActivity.getResources().getDimensionPixelSize(2131558448));
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GalleryShareHelper", 2, "shareMsgToSina empty title or share_url");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131435286, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131435466);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      if (QLog.isColorLevel()) {
        QLog.d("GalleryShareHelper", 2, "shareMsgToSina installSinaWeibo:false");
      }
      try
      {
        paramString1 = URLEncoder.encode(paramString1, "UTF-8");
        paramString1 = "http://v.t.sina.com.cn/share/share.php?" + "title=" + paramString1;
        paramString2 = URLEncoder.encode(paramString3, "UTF-8");
        paramString1 = paramString1 + "&url=" + paramString2;
        paramString2 = URLEncoder.encode(paramString4, "UTF-8");
        paramString1 = paramString1 + "&pic=" + paramString2;
        paramString1 = paramString1 + "&_wv=3";
        paramString2 = new Intent(localFragmentActivity, QQBrowserActivity.class);
        paramString2.putExtra("url", paramString1);
        localFragmentActivity.startActivity(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("GalleryShareHelper", 2, "shareMsgToSina start webview!");
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131435286, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
          paramString1.printStackTrace();
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          }
        }
      }
      finally
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
    } while (!QLog.isColorLevel());
    QLog.d("GalleryShareHelper", 2, "shareMsgToSina end!");
  }
  
  public void a(Activity paramActivity, File paramFile)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {
      return;
    }
    Object localObject = paramFile.getAbsolutePath();
    paramFile = new Bundle();
    paramFile.putInt("forward_type", 1);
    paramFile.putString("forward_urldrawable_thumb_url", (String)localObject);
    paramFile.putString("forward_filepath", (String)localObject);
    paramFile.putString("forward_extra", (String)localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtras(paramFile);
    ForwardBaseOption.a(paramActivity, (Intent)localObject, 1);
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {
      return;
    }
    if (!AppNetConnInfo.isNetSupport())
    {
      QQToast.a(paramActivity, 1, "分享失败，请稍后重试！", 0).a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity, 2131624515);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setContentView(2130969181);
      ((TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.findViewById(2131363381)).setText("正在发送");
    }
    for (;;)
    {
      localObject = new File(AbsDownloader.d(paramString));
      if (!((File)localObject).exists()) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      a(paramActivity, (File)localObject);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    Bundle localBundle = new Bundle();
    Object localObject = new DownloadTask(paramString, (File)localObject);
    ((DownloadTask)localObject).d = 60L;
    ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1).a((DownloadTask)localObject, new mte(this, paramActivity, paramString), localBundle);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131435531), 0).a();
      if (QLog.isColorLevel()) {
        QLog.d("GalleryShareHelper", 2, "savePicimgUrl is Empty");
      }
    }
    Object localObject;
    for (;;)
    {
      return;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      try
      {
        paramString = new URL(paramString);
        paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
        if (paramString.getStatus() == 1) {
          break label158;
        }
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131435531), 0).a();
        return;
      }
      catch (MalformedURLException paramString)
      {
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131435531), 0).a();
        paramString.printStackTrace();
      }
      if (QLog.isColorLevel())
      {
        QLog.d("GalleryShareHelper", 2, "savePic" + paramString.toString());
        return;
        label158:
        if ((paramString.getStatus() == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
          new File(AppConstants.aP).mkdirs();
          localObject = AppConstants.aP + (String)localObject + Utils.Crc64String(paramString.getURL().toString());
          File localFile = new File((String)localObject);
          if (!localFile.exists()) {
            try
            {
              if (localFile.createNewFile())
              {
                a(paramString, localFile.getPath());
                return;
              }
            }
            catch (IOException paramString)
            {
              QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131434566), 0).a();
              return;
            }
          }
        }
      }
    }
    DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131434569)).setMessage(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131434571)).setPositiveButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131434570), new mtc(this, paramString, (String)localObject)).setNegativeButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131432995), new mtb(this)).show();
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.post(new msy(this, paramString, new HashMap(1), paramInt), 8, null, false);
  }
  
  public void a(String paramString1, long paramLong1, int paramInt1, int paramInt2, String paramString2, String paramString3, long paramLong2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    this.k = paramString1;
    this.jdField_b_of_type_Long = paramLong1;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.j = paramString2;
    this.i = paramString3;
    this.jdField_a_of_type_Long = paramLong2;
    this.jdField_a_of_type_Int = paramInt3;
    this.jdField_c_of_type_JavaLangString = paramString4;
    this.jdField_b_of_type_JavaLangString = paramString5;
    this.jdField_a_of_type_JavaLangString = paramString6;
    this.d = paramString8;
    this.e = paramString7;
    this.f = paramString9;
    this.g = paramString10;
    this.h = paramString11;
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null));
      paramString1 = a();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramString1, null);
    }
    try
    {
      for (;;)
      {
        if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        }
        return;
        paramString1 = a();
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramString1, null);
      }
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("GalleryShareHelper", 2, "actionSheet.show exception=" + paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, int paramInt)
  {
    int i1 = 0;
    int n = 0;
    if (paramString1 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      if (paramString2 == null) {
        paramString2 = "";
      }
      for (;;)
      {
        int m;
        if (!WXShareHelper.a().a()) {
          m = 2131435302;
        }
        for (;;)
        {
          if (m != -1)
          {
            QRUtils.a(0, m);
            if (QLog.isColorLevel()) {
              QLog.d("GalleryShareHelper", 2, "title=" + paramString1 + ", description=" + paramString2 + ", shareUrl=" + paramString3 + ", action=" + paramInt);
            }
            return;
            if (!WXShareHelper.a().b()) {
              m = 2131435303;
            }
          }
          else
          {
            String str = String.valueOf(System.currentTimeMillis());
            Object localObject = new mta(this, str);
            WXShareHelper.a().a((WXShareHelper.WXShareListener)localObject);
            if (ReadInJoyHelper.t(ReadInJoyUtils.a()) == 1)
            {
              localObject = WXShareHelper.a();
              if (paramInt == 9) {}
              for (m = n;; m = 1)
              {
                ((WXShareHelper)localObject).b(str, paramString1, paramBitmap, paramString2, paramString3, m);
                break;
              }
            }
            localObject = WxShareHelperFromReadInjoy.a();
            if (paramInt == 9) {}
            for (m = i1;; m = 1)
            {
              ((WxShareHelperFromReadInjoy)localObject).a(str, paramString1, paramBitmap, paramString2, paramString3, m);
              break;
            }
          }
          m = -1;
        }
      }
    }
  }
  
  public void a(gallery.GalleryInfo paramGalleryInfo, String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (paramGalleryInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GalleryShareHelper", 2, "showShareActionSheet(). galleryInfo is null.");
      }
      return;
    }
    this.jdField_a_of_type_TencentImOidbGalleryGallery$GalleryInfo = paramGalleryInfo;
    this.i = paramGalleryInfo.bytes_row_key.get().toStringUtf8();
    String str1 = this.i;
    long l = paramGalleryInfo.uint64_article_id.get();
    String str2 = paramGalleryInfo.bytes_subject.get().toStringUtf8();
    String str3 = ReadInJoyUtils.e(this.i);
    ReadInJoyAtlasManager.a();
    a(paramString1, paramLong, paramInt1, paramInt2, paramString2, str1, l, paramInt3, str2, paramString3, str3, paramString4, ReadInJoyAtlasManager.a(paramGalleryInfo), paramString5, paramString6, paramString7);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    boolean bool;
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder().append("onItemClick, tag = ");
      if (paramAdapterView != null)
      {
        bool = true;
        QLog.d("GalleryShareHelper", 2, bool);
      }
    }
    else
    {
      if (paramAdapterView != null) {
        break label58;
      }
    }
    label58:
    while ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(this.d)))
    {
      return;
      bool = false;
      break;
    }
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    paramInt = ((PublicAccountBrowser.ActionSheetItemViewHolder)paramAdapterView).a.jdField_b_of_type_Int;
    int m;
    if (paramInt == 2)
    {
      a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.e, this.d, this.f, this.g, this.h);
      paramInt = 1;
      m = 0;
    }
    for (;;)
    {
      PublicAccountReportUtils.a(null, "", "0X8008E36", "0X8008E36", 0, 0, "", "", "", GalleryReportedUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.i, paramInt, m), false);
      GalleryReportedUtils.a(26, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()).longValue(), (int)this.jdField_b_of_type_Long, 1, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.i, this.j);
      return;
      if (paramInt == 3)
      {
        a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d);
        paramInt = 2;
        m = 0;
      }
      else if ((paramInt == 9) || (paramInt == 10))
      {
        a(this.d, paramInt);
        if (paramInt == 9)
        {
          paramInt = 3;
          m = 0;
        }
        else
        {
          paramInt = 4;
          m = 0;
        }
      }
      else if (paramInt == 12)
      {
        b(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d);
        paramInt = 5;
        m = 0;
      }
      else if (paramInt == 4)
      {
        paramAdapterView = new Intent("android.intent.action.VIEW", Uri.parse(this.jdField_a_of_type_JavaLangString));
        paramAdapterView.putExtra("normal", true);
        try
        {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(paramAdapterView);
          m = 0;
          paramInt = 0;
        }
        catch (ActivityNotFoundException paramAdapterView)
        {
          for (;;)
          {
            QRUtils.a(1, 2131430011);
          }
        }
      }
      else if (paramInt == 23)
      {
        a(this.k);
        m = 1;
        paramInt = 0;
      }
      else if (paramInt == 6)
      {
        paramAdapterView = new Bundle();
        paramAdapterView.putInt("picNum", (int)this.jdField_a_of_type_TencentImOidbGalleryGallery$GalleryInfo.uint64_pic_count.get());
        paramAdapterView.putLong("publishAccountUin", this.jdField_a_of_type_TencentImOidbGalleryGallery$GalleryInfo.uint64_publisher_uin.get());
        paramAdapterView.putString("publishAccountName", this.jdField_a_of_type_TencentImOidbGalleryGallery$GalleryInfo.bytes_publisher_name.get().toStringUtf8());
        ReadInJoyAtlasManager.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 3, this.i, this.jdField_c_of_type_JavaLangString, "", this.d, this.jdField_a_of_type_JavaLangString, paramAdapterView);
        m = 2;
        paramInt = 0;
      }
      else if (paramInt == 1)
      {
        paramAdapterView = this.jdField_a_of_type_AndroidContentContext;
        paramView = this.jdField_a_of_type_AndroidContentContext;
        ((ClipboardManager)paramAdapterView.getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
        QRUtils.a(2, 2131429988);
        m = 0;
        paramInt = 0;
      }
      else
      {
        if (paramInt == 11)
        {
          paramAdapterView = URLEncoder.encode(this.jdField_a_of_type_JavaLangString);
          paramAdapterView = String.format("https://post.mp.qq.com/jubao/index?_wv=3&puin=%1$d&key=%2$s&url=%3$s&type=%4$d", new Object[] { Long.valueOf(this.jdField_a_of_type_TencentImOidbGalleryGallery$GalleryInfo.uint64_publisher_uin.get()), this.i, paramAdapterView, Integer.valueOf(6) });
          paramView = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
          paramView.putExtra("url", paramAdapterView);
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(paramView);
        }
        m = 0;
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.GalleryShareHelper
 * JD-Core Version:    0.7.0.1
 */