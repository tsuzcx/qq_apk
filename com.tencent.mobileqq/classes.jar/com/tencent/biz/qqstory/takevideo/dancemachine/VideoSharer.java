package com.tencent.biz.qqstory.takevideo.dancemachine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.richmedia.capture.view.ShareActionSheet;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;
import omp;
import omt;

public class VideoSharer
  implements AdapterView.OnItemClickListener
{
  public static int b;
  protected int a;
  private long jdField_a_of_type_Long = -1L;
  public Activity a;
  public ShareActionSheet a;
  private WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  private String jdField_a_of_type_JavaLangString = "http://qun.qq.com/qqweb/m/qun/qun_activity/dance-game.html";
  private WeakReference jdField_a_of_type_MqqUtilWeakReference;
  protected String b;
  private int c;
  protected String c;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  public String h;
  public String i;
  public String j;
  protected String k = "";
  private String l = "?ddcat=%s&ddid=%s&uuid=%s&md5=%s&_wv=16778243&_bid=2932";
  
  static
  {
    jdField_b_of_type_Int = -1;
  }
  
  public VideoSharer()
  {
    this.jdField_c_of_type_Int = -1;
  }
  
  private void a(int paramInt)
  {
    if ((TextUtils.isEmpty(this.i)) || (TextUtils.isEmpty(this.h)) || (TextUtils.isEmpty(this.j))) {
      return;
    }
    ThreadManager.executeOnSubThread(new omp(this, paramInt));
  }
  
  private List[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131433018);
    localActionSheetItem.jdField_b_of_type_Int = 2130839210;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_c_of_type_Int = 2;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430128);
    localActionSheetItem.jdField_b_of_type_Int = 2130838345;
    localActionSheetItem.jdField_c_of_type_Int = 9;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430129);
    localActionSheetItem.jdField_b_of_type_Int = 2130838339;
    localActionSheetItem.jdField_c_of_type_Int = 10;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    a(localArrayList);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private boolean b()
  {
    String str = null;
    if (!WXShareHelper.a().a()) {
      str = "你未安装微信客户端，无法分享。";
    }
    while (!TextUtils.isEmpty(str))
    {
      jdField_b_of_type_Int = -1;
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, str, 0).a();
      return false;
      if (!WXShareHelper.a().b()) {
        str = "微信版本过低,无法分享";
      }
    }
    return true;
  }
  
  public int a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getApplicationInfo("com.sina.weibo", 8192);
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachinePKVideoSharer", 2, "shareMsgToSina installSinaWeibo:true");
      }
      if ((paramString3 == null) || (!new File(paramString3).exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DanceMachinePKVideoSharer", 2, "shareMsgToSina Thumb Path Invalid");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("DanceMachinePKVideoSharer", 2, "shareMsgToSina path:" + paramString3);
        }
        Intent localIntent = new Intent("android.intent.action.SEND");
        localIntent.setFlags(268435456);
        localIntent.setType("image/*");
        localIntent.putExtra("android.intent.extra.TEXT", paramString1 + paramString2);
        localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(paramString3)));
        localIntent.setPackage(((ApplicationInfo)localObject).packageName);
        BaseApplicationImpl.getApplication().startActivity(localIntent);
        if (QLog.isColorLevel()) {
          QLog.d("DanceMachinePKVideoSharer", 2, "shareMsgToSina start weibo!");
        }
        return 0;
      }
    }
    catch (PackageManager.NameNotFoundException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachinePKVideoSharer", 2, "shareMsgToSina installSinaWeibo:false");
      }
      return -2;
    }
    return -1;
  }
  
  protected String a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if ("S".equals(paramString1)) {
      return "[QQ高能舞室]" + paramString2 + " " + paramInt1 + "分! 炸翻全场，你们能看清我的舞步吗？";
    }
    if ("A".equals(paramString1)) {
      return "[QQ高能舞室]" + paramString2 + " " + paramInt1 + "分! 可以说是世间尬舞奇才了。";
    }
    if ("B".equals(paramString1)) {
      return "[QQ高能舞室]" + paramString2 + " " + paramInt1 + "分! 用这段视频证明我是真正的灵魂舞者。";
    }
    if ("C".equals(paramString1)) {
      return "[QQ高能舞室]" + paramString2 + " " + paramInt1 + "分! 老师慢点，这舞我快跟不上了。";
    }
    return "[QQ高能舞室]" + "老师慢点，这舞我快跟不上了。";
  }
  
  public String a(String paramString)
  {
    if (!TextUtils.isEmpty(this.h)) {
      a(this.h);
    }
    return paramString;
  }
  
  public String a(String paramString1, String paramString2)
  {
    String str5 = "";
    try
    {
      if (!TextUtils.isEmpty(this.e))
      {
        str1 = URLEncoder.encode(this.e, "UTF-8");
        str2 = str5;
        str4 = str1;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          String str2;
          if (!TextUtils.isEmpty(this.f))
          {
            str2 = URLEncoder.encode(this.f, "UTF-8");
            str4 = str1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("DanceMachinePKVideoSharer", 2, "[DanceMachine Share] encodedCategory : " + str4 + "  encodedPtvId : " + str2);
          }
          return this.jdField_a_of_type_JavaLangString + String.format(this.l, new Object[] { str4, str2, paramString1, paramString2 });
        }
        catch (Exception localException2)
        {
          String str4;
          String str3;
          continue;
        }
        localException1 = localException1;
        String str1 = "";
        localException1.printStackTrace();
        str3 = str5;
        str4 = str1;
        continue;
        str1 = "";
      }
    }
  }
  
  public void a()
  {
    a(this.h);
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null) {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    new omt(this.jdField_a_of_type_AndroidAppActivity, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramInt1, this.jdField_a_of_type_MqqUtilWeakReference, paramInt2).execute(new Void[0]);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachinePKVideoSharer", 2, "upload fail");
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, "上传失败!", 1).a();
    }
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_AndroidAppActivity;
        if (paramInt2 != 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("DanceMachinePKVideoSharer", 2, "upload canceled by user");
      return;
      localObject = this.jdField_a_of_type_AndroidAppActivity;
    } while ((paramInt2 != -1) || (paramIntent == null));
    int m = paramIntent.getExtras().getInt("share_method");
    Object localObject = paramIntent.getExtras().getString("pk_rank", "0");
    try
    {
      paramInt2 = Integer.parseInt((String)localObject);
      this.jdField_a_of_type_Long = paramIntent.getExtras().getLong("upload_time_cost", -1L);
      this.k = paramIntent.getExtras().getString("current_nickname", "");
      String str1 = paramIntent.getExtras().getString("upload_video_uuid");
      localObject = paramIntent.getExtras().getString("upload_video_md5");
      String str2 = paramIntent.getExtras().getString("upload_video_thumb");
      if (paramInt1 == 24466)
      {
        str1 = paramIntent.getExtras().getString("upload_pic_uuid");
        localObject = paramIntent.getExtras().getString("upload_pic_md5");
      }
      this.h = a(str2);
      this.i = a(str1, (String)localObject);
      this.j = a(this.jdField_a_of_type_Int, this.d, this.k, paramInt2);
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachinePKVideoSharer", 2, "[DanceMachine Share] share  uuid : " + str1 + "  md5 : " + (String)localObject + "  thumbPath : " + this.h + "  shareUrl : " + this.i + "  shareDescStr : " + this.j);
      }
      a(m);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        paramInt2 = 0;
        localNumberFormatException.printStackTrace();
      }
    }
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewShareActionSheet = new ShareActionSheet(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewShareActionSheet.a(a(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewShareActionSheet.a(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewShareActionSheet.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131433114));
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAppInterface);
    paramActivity = this.jdField_a_of_type_AndroidAppActivity.getIntent().getParcelableExtra(EditVideoParams.class.getName());
    if (paramActivity != null)
    {
      paramActivity = ((EditVideoParams)paramActivity).a;
      if (paramActivity != null)
      {
        this.d = paramActivity.getString("dance_machine_score_rate");
        this.jdField_a_of_type_Int = paramActivity.getInt("dance_machine_score", 0);
        this.e = paramActivity.getString("dance_machine_ptv_category");
        this.f = paramActivity.getString("dance_machine_ptv_id");
        this.g = paramActivity.getString("over_percent");
        paramActivity = paramActivity.getString("web_share_url");
        if (!TextUtils.isEmpty(paramActivity)) {
          this.jdField_a_of_type_JavaLangString = paramActivity;
        }
      }
    }
  }
  
  protected void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      FileUtils.a(new File(paramString).getParent());
    }
  }
  
  protected void a(List paramList) {}
  
  protected boolean a()
  {
    if ((!TextUtils.isEmpty(this.i)) && (!TextUtils.isEmpty(this.h))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachinePKVideoSharer", 2, "hasShare : " + bool + " shareUrl : " + this.i + " thumbPath : " + this.h);
      }
      return bool;
    }
  }
  
  protected boolean a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewShareActionSheet.a();
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewShareActionSheet.a().isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewShareActionSheet.a().dismiss();
    }
    paramAdapterView = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)paramView.getTag()).a;
    paramInt = paramAdapterView.jdField_c_of_type_Int;
    jdField_b_of_type_Int = paramInt;
    if (a(paramAdapterView)) {}
    do
    {
      do
      {
        return;
        switch (paramInt)
        {
        case 11: 
        default: 
          return;
        }
      } while (!b());
      CaptureReportUtil.c("wechat_friends");
      if (a())
      {
        a(1);
        return;
      }
      a(1, 0);
      return;
    } while (!b());
    CaptureReportUtil.c("wechat_moments");
    if (a())
    {
      a(2);
      return;
    }
    a(2, 0);
    return;
    CaptureReportUtil.c("weibo");
    if (a())
    {
      a(0);
      return;
    }
    a(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.dancemachine.VideoSharer
 * JD-Core Version:    0.7.0.1
 */