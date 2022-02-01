package com.tencent.biz.pubaccount.weishi_new.util;

import NS_KING_SOCIALIZE_META.stShareBody;
import NS_KING_SOCIALIZE_META.stShareInfo;
import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.share.WSShareParam;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalDialogListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdUtil;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.open.base.ToastUtil;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.Map;
import mqq.os.MqqHandler;

public class WeishiShareUtil
{
  private static void a(int paramInt, WSShareParam paramWSShareParam)
  {
    if (paramWSShareParam == null) {
      return;
    }
    WSPublicAccReport.getInstance().reportShareClick(paramWSShareParam.f, paramInt, paramWSShareParam.d, paramWSShareParam.e, paramWSShareParam.a, paramWSShareParam.g);
  }
  
  public static void a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt1, int paramInt2)
  {
    ToastUtil.a().a(2131918100);
  }
  
  public static void a(Context paramContext, WSShareParam paramWSShareParam)
  {
    if (!WeishiUtils.o())
    {
      if (paramWSShareParam == null) {
        return;
      }
      Object localObject = new ShareActionSheetV2.Param();
      ((ShareActionSheetV2.Param)localObject).context = paramContext;
      localObject = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject);
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      if ((paramWSShareParam.a != null) && (paramWSShareParam.a.gdt_ad_type == 1) && (paramWSShareParam.a.gdt_ad_info != null))
      {
        ((ShareActionSheet)localObject).setActionSheetTitle("");
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(90));
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(89));
        ((ShareActionSheet)localObject).setActionSheetItems(localArrayList1, localArrayList2);
        ((ShareActionSheet)localObject).setRowVisibility(8, 8, 0);
      }
      else
      {
        ((ShareActionSheet)localObject).setActionSheetTitle(paramContext.getString(2131889851));
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        if (QFileAssistantUtils.b()) {
          localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(26));
        }
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        if (paramWSShareParam.h)
        {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(44));
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
        }
        ((ShareActionSheet)localObject).setActionSheetItems(localArrayList1, localArrayList2);
        ((ShareActionSheet)localObject).setRowVisibility(0, 0, 0);
      }
      ((ShareActionSheet)localObject).setItemClickListenerV2(new WeishiShareUtil.3(paramContext, paramWSShareParam));
      paramContext = (Activity)paramContext;
      if (paramContext != null)
      {
        paramContext.getIntent().putExtra("big_brother_source_key", "biz_src_jc_gzh_weishi");
        ((ShareActionSheet)localObject).setIntentForStartForwardRecentActivity(paramContext.getIntent());
      }
      ((ShareActionSheet)localObject).setOnShowListener(new WeishiShareUtil.4(paramWSShareParam));
      ((ShareActionSheet)localObject).setCancelListener(new WeishiShareUtil.5(paramWSShareParam));
      ((ShareActionSheet)localObject).setOnDismissListener(new WeishiShareUtil.6(paramWSShareParam));
      ((ShareActionSheet)localObject).show();
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramContext == null) {
      return;
    }
    paramString2 = (Activity)paramContext;
    paramContext = paramString2;
    if ((paramString2 instanceof BasePluginActivity)) {
      paramContext = ((BasePluginActivity)paramString2).getOutActivity();
    }
    paramString2 = new Intent(paramContext, ForwardRecentActivity.class);
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString2.putExtra("forward_type", 2);
      paramString2.putExtra("req_type", 1);
      paramString2.putExtra("req_share_id", Long.parseLong("1101083114"));
      paramString2.putExtra("title", paramString1);
      paramString2.putExtra("app_name", HardCodeUtil.a(2131913836));
      paramString2.putExtra("image_url_remote", paramString3);
      paramString2.putExtra("desc", HardCodeUtil.a(2131913835));
      paramString2.putExtra("detail_url", paramString4);
    }
    paramContext.startActivity(paramString2);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    Object localObject = (Activity)paramContext;
    paramContext = (Context)localObject;
    if ((localObject instanceof BasePluginActivity)) {
      paramContext = ((BasePluginActivity)localObject).getOutActivity();
    }
    localObject = new Intent();
    if (!TextUtils.isEmpty(paramString3))
    {
      ((Intent)localObject).putExtra("forward_type", 2);
      ((Intent)localObject).putExtra("req_type", 1);
      ((Intent)localObject).putExtra("req_share_id", Long.parseLong("1101083114"));
      ((Intent)localObject).putExtra("title", paramString1);
      ((Intent)localObject).putExtra("app_name", HardCodeUtil.a(2131913836));
      ((Intent)localObject).putExtra("image_url_remote", paramString2);
      ((Intent)localObject).putExtra("desc", HardCodeUtil.a(2131913835));
      ((Intent)localObject).putExtra("detail_url", paramString3);
      ((Intent)localObject).putExtra("key_req", 1);
      ((Intent)localObject).putExtra("key_direct_show_uin_type", paramInt);
      ((Intent)localObject).putExtra("key_direct_show_uin", paramString4);
      ForwardBaseOption.a(paramContext, (Intent)localObject, ForwardRecentTranslucentActivity.class, 1);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    Object localObject = (Activity)paramContext;
    paramContext = (Context)localObject;
    if ((localObject instanceof BasePluginActivity)) {
      paramContext = ((BasePluginActivity)localObject).getOutActivity();
    }
    localObject = new QZoneShareData();
    ((QZoneShareData)localObject).mTitle = paramString1;
    ((QZoneShareData)localObject).mSummary = paramString2;
    ((QZoneShareData)localObject).mImageUrls = new ArrayList();
    ((QZoneShareData)localObject).mImageUrls.add(paramString3);
    ((QZoneShareData)localObject).from = 0;
    ((QZoneShareData)localObject).targetUrl = paramString4;
    ((QZoneShareData)localObject).shareUin = paramString5;
    QZoneShareManager.shareToQzone(paramContext, paramString5, (QZoneShareData)localObject, null, paramInt);
  }
  
  public static void b(Context paramContext, WSShareParam paramWSShareParam)
  {
    if (WeishiUtils.o()) {
      return;
    }
    Object localObject = new ShareActionSheetV2.Param();
    ((ShareActionSheetV2.Param)localObject).context = paramContext;
    localObject = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject);
    ((ShareActionSheet)localObject).setActionSheetTitle("");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(44));
    ((ShareActionSheet)localObject).setItemClickListenerV2(new WeishiShareUtil.7(paramContext, paramWSShareParam));
    ((ShareActionSheet)localObject).setActionSheetItems(localArrayList1, localArrayList2);
    ((ShareActionSheet)localObject).setRowVisibility(8, 8, 0);
    paramContext = (Activity)paramContext;
    if (paramContext != null)
    {
      paramContext.getIntent().putExtra("big_brother_source_key", "biz_src_jc_gzh_weishi");
      ((ShareActionSheet)localObject).setIntentForStartForwardRecentActivity(paramContext.getIntent());
    }
    ((ShareActionSheet)localObject).setOnShowListener(new WeishiShareUtil.8(paramWSShareParam));
    ((ShareActionSheet)localObject).setCancelListener(new WeishiShareUtil.9(paramWSShareParam));
    ((ShareActionSheet)localObject).setOnDismissListener(new WeishiShareUtil.10(paramWSShareParam));
    ((ShareActionSheet)localObject).show();
  }
  
  private static void b(Context paramContext, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, WSShareParam paramWSShareParam)
  {
    int i = paramActionSheetItem.action;
    int j = paramActionSheetItem.uinType;
    Object localObject1 = paramActionSheetItem.uin;
    if (paramWSShareParam == null) {
      return;
    }
    stSimpleMetaFeed localstSimpleMetaFeed = paramWSShareParam.a;
    if (localstSimpleMetaFeed != null)
    {
      if (localstSimpleMetaFeed.share_info == null) {
        return;
      }
      String str = localstSimpleMetaFeed.share_info.jump_url;
      int k = paramWSShareParam.c;
      int m = paramWSShareParam.b;
      Object localObject4 = null;
      Object localObject5 = null;
      Object localObject2 = null;
      paramActionSheetItem = null;
      Object localObject6 = null;
      Object localObject3 = null;
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 26)
          {
            if (i != 44)
            {
              paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
              if (i == 72) {
                break label407;
              }
              if (i != 73)
              {
                if (i != 89)
                {
                  if (i != 90)
                  {
                    switch (i)
                    {
                    default: 
                      return;
                    case 11: 
                      a(1003012, paramWSShareParam);
                      ToastUtil.a().a("已收到你的举报，我们会及时处理");
                      return;
                    case 10: 
                      paramActionSheetItem = localObject3;
                      if (localstSimpleMetaFeed.share_info.body_map != null) {
                        paramActionSheetItem = (stShareBody)localstSimpleMetaFeed.share_info.body_map.get(Integer.valueOf(3));
                      }
                      if (paramActionSheetItem == null) {
                        return;
                      }
                      a(1003005, paramWSShareParam);
                      b(paramContext, paramActionSheetItem.title, paramActionSheetItem.desc, paramActionSheetItem.image_url, str, 1);
                      return;
                    }
                    paramActionSheetItem = localObject4;
                    if (localstSimpleMetaFeed.share_info.body_map != null) {
                      paramActionSheetItem = (stShareBody)localstSimpleMetaFeed.share_info.body_map.get(Integer.valueOf(3));
                    }
                    if (paramActionSheetItem == null) {
                      return;
                    }
                    a(1003004, paramWSShareParam);
                    b(paramContext, paramActionSheetItem.title, paramActionSheetItem.desc, paramActionSheetItem.image_url, str, 0);
                  }
                }
                else {
                  GdtAdUtil.a(paramContext, 131072, localstSimpleMetaFeed, k);
                }
              }
              else
              {
                paramActionSheetItem = localObject5;
                if (localstSimpleMetaFeed.share_info.body_map != null) {
                  paramActionSheetItem = (stShareBody)localstSimpleMetaFeed.share_info.body_map.get(Integer.valueOf(1));
                }
                if (paramActionSheetItem == null) {
                  return;
                }
                a(1003020, paramWSShareParam);
                a(paramContext, paramActionSheetItem.title, paramActionSheetItem.desc, paramActionSheetItem.image_url, str);
                return;
              }
            }
            a(1003008, paramWSShareParam);
            a(localstSimpleMetaFeed, k, m);
          }
          else
          {
            paramActionSheetItem = "3636666661";
          }
          label407:
          localObject1 = localObject2;
          if (localstSimpleMetaFeed.share_info.body_map != null) {
            localObject1 = (stShareBody)localstSimpleMetaFeed.share_info.body_map.get(Integer.valueOf(1));
          }
          if (localObject1 == null) {
            return;
          }
          a(1003002, paramWSShareParam);
          a(paramContext, ((stShareBody)localObject1).title, ((stShareBody)localObject1).image_url, str, paramActionSheetItem, j);
          return;
        }
        if (localstSimpleMetaFeed.share_info.body_map != null) {
          paramActionSheetItem = (stShareBody)localstSimpleMetaFeed.share_info.body_map.get(Integer.valueOf(0));
        }
        if (paramActionSheetItem == null) {
          return;
        }
        try
        {
          a(1003003, paramWSShareParam);
          a(paramContext, paramActionSheetItem.title, paramActionSheetItem.desc, paramActionSheetItem.image_url, str, (String)localObject1, 0);
          return;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          paramActionSheetItem = new StringBuilder();
          paramActionSheetItem.append("shareToQzone error:");
          paramActionSheetItem.append(paramContext);
          WSLog.d("WeishiShareUtil", paramActionSheetItem.toString());
          return;
        }
      }
      paramActionSheetItem = localObject6;
      if (localstSimpleMetaFeed.share_info.body_map != null) {
        paramActionSheetItem = (stShareBody)localstSimpleMetaFeed.share_info.body_map.get(Integer.valueOf(1));
      }
      if (paramActionSheetItem == null) {
        return;
      }
      a(1003019, paramWSShareParam);
      a(paramContext, paramActionSheetItem.title, paramActionSheetItem.desc, paramActionSheetItem.image_url, str);
    }
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (!WXShareHelper.a().b()) {
      ToastUtil.a().a(2131918154);
    } else if (!WXShareHelper.a().c()) {
      ToastUtil.a().a(2131918155);
    }
    long l = System.currentTimeMillis();
    ThreadManager.getSubThreadHandler().post(new WeishiShareUtil.1(paramString3, String.valueOf(l), paramString1, paramString2, paramString4, paramInt));
    WXShareHelper.a().a(new WeishiShareUtil.2());
  }
  
  private static void c(WSShareParam paramWSShareParam)
  {
    if ((paramWSShareParam != null) && (paramWSShareParam.a() != null)) {
      paramWSShareParam.a().a(2);
    }
  }
  
  private static void d(WSShareParam paramWSShareParam)
  {
    if ((paramWSShareParam != null) && (paramWSShareParam.a() != null)) {
      paramWSShareParam.a().b(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiShareUtil
 * JD-Core Version:    0.7.0.1
 */