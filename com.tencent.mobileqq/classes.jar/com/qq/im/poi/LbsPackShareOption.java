package com.qq.im.poi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import anv;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.List;

public class LbsPackShareOption
  implements AdapterView.OnItemClickListener
{
  public long a;
  public BaseActivity a;
  ShareActionSheetBuilder jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
  WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  public String a;
  String b;
  String c;
  
  public LbsPackShareOption(BaseActivity paramBaseActivity, String paramString1, long paramLong, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Long = paramLong;
    this.c = paramString2;
  }
  
  private static Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      localBitmap = paramBitmap;
      if (i * j > 8000)
      {
        double d = Math.sqrt(8000.0D / (i * j));
        localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(i * d), (int)(j * d), true);
      }
    }
    catch (OutOfMemoryError paramBitmap)
    {
      for (;;)
      {
        System.gc();
        paramBitmap.printStackTrace();
        localBitmap = null;
      }
    }
    catch (Exception paramBitmap)
    {
      for (;;)
      {
        paramBitmap.printStackTrace();
        Bitmap localBitmap = null;
      }
    }
    return localBitmap;
  }
  
  public static void a(int paramInt, long paramLong)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      ReportController.b(null, "dc01440", "", "", "0X8007A4F", "0X8007A4F", 0, 0, String.valueOf(paramInt), String.valueOf(paramLong), "", "");
      return;
      paramInt = 1;
      continue;
      paramInt = 2;
      continue;
      paramInt = 3;
      continue;
      paramInt = 4;
    }
  }
  
  public static List[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430108);
    localActionSheetItem.jdField_b_of_type_Int = 2130838336;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.c = 2;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430114);
    localActionSheetItem.jdField_b_of_type_Int = 2130838337;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.c = 3;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430126);
    localActionSheetItem.jdField_b_of_type_Int = 2130838340;
    localActionSheetItem.c = 9;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430127);
    localActionSheetItem.jdField_b_of_type_Int = 2130838334;
    localActionSheetItem.c = 10;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(paramActivity);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(paramActivity.getString(2131433100));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(a(paramActivity));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(this);
    }
    try
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a();
      }
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + paramActivity);
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.b();
    }
    int j = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)paramAdapterView).a.c;
    Object localObject2 = (LbsPackManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface().getManager(214);
    Object localObject1 = ((LbsPackManager)localObject2).a(this.jdField_b_of_type_JavaLangString);
    paramAdapterView = ((LbsPackManager)localObject2).a(false);
    paramView = this.c;
    Object localObject3;
    switch (j)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return;
    case 2: 
      localObject1 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(1).a(paramAdapterView).c((String)localObject1).a();
      ((AbsShareMsg)localObject1).mSourceName = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131438773);
      localObject2 = StructMsgElementFactory.a(2);
      ((AbsStructMsgItem)localObject2).a("http://hb.url.cn/myapp/qq_desk/LBShongbaotest/share_icon01.png", paramAdapterView, paramView);
      ((AbsShareMsg)localObject1).addItem((AbsStructMsgElement)localObject2);
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("forward_type", -3);
      paramAdapterView.putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      paramAdapterView.putExtra("forwardDirect", true);
      ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramAdapterView, 1000);
      return;
    case 3: 
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add("http://hb.url.cn/myapp/qq_desk/LBShongbaotest/share_icon01.png");
      localObject3 = new Bundle();
      ((Bundle)localObject3).putStringArrayList("image_url", (ArrayList)localObject2);
      ((Bundle)localObject3).putString("title", paramAdapterView);
      ((Bundle)localObject3).putString("desc", paramView);
      ((Bundle)localObject3).putLong("req_share_id", 0L);
      ((Bundle)localObject3).putString("detail_url", (String)localObject1);
      QZoneShareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Bundle)localObject3, null, 1001);
      return;
    }
    int i = -1;
    if (!WXShareHelper.a().a()) {
      i = 2131435319;
    }
    while (i != -1)
    {
      QRUtils.a(1, i);
      return;
      if (!WXShareHelper.a().b()) {
        i = 2131435320;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new anv(this, j);
      WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
    }
    this.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
    try
    {
      paramAdapterView = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130842660);
      localObject3 = WXShareHelper.a();
      String str = this.jdField_a_of_type_JavaLangString;
      localObject2 = ((LbsPackManager)localObject2).a(true);
      paramAdapterView = a(paramAdapterView);
      if (paramInt == 2)
      {
        paramInt = 0;
        ((WXShareHelper)localObject3).b(str, (String)localObject2, paramAdapterView, paramView, (String)localObject1, paramInt);
        return;
      }
    }
    catch (Throwable paramAdapterView)
    {
      for (;;)
      {
        paramAdapterView.printStackTrace();
        paramAdapterView = null;
        continue;
        paramInt = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsPackShareOption
 * JD-Core Version:    0.7.0.1
 */