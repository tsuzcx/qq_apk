package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShareQzoneInfo;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import NS_COMM.COMM.Entry;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.biz.subscribe.event.SharePanelShowStateEvent;
import com.tencent.biz.subscribe.network.SubscribeDeleteFeedRequest;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.data.SerializableMap;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.QZoneShareManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class SubscribeShareHelper
{
  public static String b = "certified_account=1";
  public Activity a;
  public boolean c;
  private WXShareHelper.WXShareListener d;
  private String e;
  private QQProgressDialog f;
  private ShareInfoBean g;
  private String h;
  private SubscribeQRCodeShareHelper i;
  private IColorNoteController j;
  private ShareActionSheet k;
  
  public SubscribeShareHelper(Activity paramActivity)
  {
    this(paramActivity, null);
  }
  
  public SubscribeShareHelper(Activity paramActivity, SubscribeShareHelper.ShareActionItemClickListenr paramShareActionItemClickListenr)
  {
    boolean bool;
    if (Integer.parseInt(QzoneConfig.getInstance().getConfig("qqsubscribe", "ShowShopConfigEntrance", "0")) > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.c = bool;
    this.a = paramActivity;
    ShareActionSheetV2.Param localParam = new ShareActionSheetV2.Param();
    localParam.context = paramActivity;
    this.k = ShareActionSheetFactory.create(localParam);
    this.k.setOnDismissListener(new SubscribeShareHelper.1(this));
    this.k.setCancelListener(new SubscribeShareHelper.2(this));
    this.k.setItemClickListenerV2(new SubscribeShareHelper.SheetItemClickProcessor(this, paramShareActionItemClickListenr));
    if (this.i == null) {
      this.i = new SubscribeQRCodeShareHelper(this.a);
    }
  }
  
  public static String a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://qsubscribe");
    localStringBuilder.append("/");
    localStringBuilder.append("opendetail");
    localStringBuilder.append("?");
    localStringBuilder.append("src_type=internal");
    localStringBuilder.append("&version=1");
    localStringBuilder.append("&uin=");
    localStringBuilder.append(paramStFeed.poster.id.get());
    localStringBuilder.append("&feedId=");
    localStringBuilder.append(paramStFeed.id.get());
    localStringBuilder.append("&type=");
    localStringBuilder.append(paramStFeed.type.get());
    localStringBuilder.append("&width=");
    localStringBuilder.append(paramStFeed.video.width.get());
    localStringBuilder.append("&height=");
    localStringBuilder.append(paramStFeed.video.height.get());
    localStringBuilder.append("&createtime=");
    localStringBuilder.append(paramStFeed.createTime.get());
    return localStringBuilder.toString();
  }
  
  private static String a(CertifiedAccountMeta.StFeed paramStFeed, ExtraTypeInfo paramExtraTypeInfo)
  {
    if ((paramExtraTypeInfo != null) && (paramExtraTypeInfo.pageType == 7002)) {
      return String.format("https://h5.qzone.qq.com/subscription/report/%s?_proxy=1&_wv=3&usertype=%s", new Object[] { paramStFeed.poster.id.get(), Integer.valueOf(paramStFeed.poster.type.get()) });
    }
    return String.format("https://h5.qzone.qq.com/subscription/report/%s?_proxy=1&_wv=3&userid=%s&usertype=%s", new Object[] { paramStFeed.id.get(), paramStFeed.poster.id.get(), Integer.valueOf(paramStFeed.poster.type.get()) });
  }
  
  public static String a(ExtraTypeInfo paramExtraTypeInfo)
  {
    if (paramExtraTypeInfo == null) {
      return "";
    }
    int m = paramExtraTypeInfo.pageType;
    if (m != 8001)
    {
      switch (m)
      {
      default: 
        return "";
      case 7002: 
        return "person";
      case 7001: 
        return "multi_pic";
      }
      return "video";
    }
    return "image";
  }
  
  public static String a(ShareInfoBean paramShareInfoBean)
  {
    if (paramShareInfoBean != null)
    {
      String str = paramShareInfoBean.e();
      Object localObject = str;
      if (paramShareInfoBean.e != null) {
        if (paramShareInfoBean.e.pageType != 7002)
        {
          localObject = str;
          if (paramShareInfoBean.e.pageType != 7005) {}
        }
        else
        {
          paramShareInfoBean = paramShareInfoBean.a().poster.desc.get();
          if ((!TextUtils.isEmpty(paramShareInfoBean)) && (!paramShareInfoBean.equals(HardCodeUtil.a(2131916909))))
          {
            localObject = paramShareInfoBean;
            if (!TextUtils.isEmpty(paramShareInfoBean.trim())) {}
          }
          else
          {
            localObject = HardCodeUtil.a(2131916908);
          }
        }
      }
      return localObject;
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://qsubscribe");
    localStringBuilder.append("/");
    localStringBuilder.append("openhomepage");
    localStringBuilder.append("?");
    localStringBuilder.append("src_type=internal");
    localStringBuilder.append("&version=1");
    localStringBuilder.append("&uid=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("&nick=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("&icon=");
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt)
  {
    Object localObject1 = this.g;
    if (localObject1 != null)
    {
      if (this.a == null) {
        return;
      }
      Object localObject2 = ((ShareInfoBean)localObject1).c();
      String str1 = b(this.g.d());
      String str2 = b(this.g.e());
      localObject1 = new HashMap(1);
      if ((localObject2 != null) && (!((String)localObject2).isEmpty()))
      {
        int m;
        if (!WXShareHelper.a().b()) {
          m = 2131918154;
        } else if (!WXShareHelper.a().c()) {
          m = 2131918155;
        } else {
          m = -1;
        }
        if (m != -1)
        {
          QRUtils.a(0, m);
          return;
        }
        f();
        localObject2 = new SubscribeShareHelper.4(this, (Map)localObject1, str1, str2, (String)localObject2, paramInt);
        if (TextUtils.isEmpty(this.g.f()))
        {
          ((Runnable)localObject2).run();
          return;
        }
        a(this.a);
        this.f.c(2131891516);
        this.f.show();
        ThreadManager.post(new SubscribeShareHelper.5(this, (Map)localObject1, (Runnable)localObject2), 8, null, false);
        return;
      }
      QQToast.makeText(this.a, 1, HardCodeUtil.a(2131911948), 0).show();
    }
  }
  
  private void a(CertifiedAccountMeta.StFeed paramStFeed, int paramInt, ExtraTypeInfo paramExtraTypeInfo)
  {
    if ((paramStFeed != null) && (!StringUtil.isEmpty(paramStFeed.poster.id.get())) && (!StringUtil.isEmpty(paramStFeed.id.get())) && (paramExtraTypeInfo != null))
    {
      String str = paramStFeed.poster.id.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clk_");
      localStringBuilder.append(a(paramExtraTypeInfo));
      VSReporter.a(str, "auth_share", localStringBuilder.toString(), paramInt, 0, new String[] { "", "", paramStFeed.id.get() });
    }
  }
  
  private void a(Activity paramActivity)
  {
    if (this.f == null) {
      this.f = new QQProgressDialog(paramActivity);
    }
  }
  
  private void a(ArrayList<Integer> paramArrayList)
  {
    ShareInfoBean localShareInfoBean = this.g;
    if ((localShareInfoBean != null) && (localShareInfoBean.e != null) && (j()) && ((this.g.e.pageType == 7000) || (this.g.e.pageType == 7001) || (this.g.e.pageType == 8001))) {
      paramArrayList.add(Integer.valueOf(40));
    }
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] a(List<Integer>[] paramArrayOfList)
  {
    List[] arrayOfList = new List[paramArrayOfList.length];
    int m = 0;
    while (m < paramArrayOfList.length)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramArrayOfList[m].iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(((Integer)localIterator.next()).intValue()));
      }
      arrayOfList[m] = localArrayList;
      m += 1;
    }
    return arrayOfList;
  }
  
  public static String b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return c(paramStFeed.poster.id.get());
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if ((paramString.length() <= 30) && (paramString.getBytes().length <= 100)) {
      return paramString;
    }
    Object localObject = paramString;
    if (paramString.length() > 30) {
      localObject = paramString.substring(0, 30);
    }
    paramString = (String)localObject;
    if (Math.min(((String)localObject).getBytes().length, 100) == 100)
    {
      int m = ((String)localObject).length() / 2;
      paramString = new StringBuilder(((String)localObject).substring(0, m));
      while (paramString.toString().getBytes().length < 100)
      {
        paramString.append(((String)localObject).charAt(m));
        m += 1;
      }
      paramString = paramString.toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("...");
    return ((StringBuilder)localObject).toString();
  }
  
  @NotNull
  private List[] b(ShareInfoBean paramShareInfoBean)
  {
    List localList = c(paramShareInfoBean);
    paramShareInfoBean = d(paramShareInfoBean);
    if (((String)VSConfigManager.a().a("is_open_sharing", "1")).equals("1"))
    {
      ShareInfoBean localShareInfoBean = this.g;
      if ((localShareInfoBean != null) && (localShareInfoBean.b != null) && (SubscribeUtils.a(this.g.b.status.get())))
      {
        m = 1;
        break label81;
      }
    }
    int m = 0;
    label81:
    if (m != 0) {
      return new List[] { localList, paramShareInfoBean };
    }
    return new List[] { paramShareInfoBean };
  }
  
  public static String c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return String.format("https://h5.qzone.qq.com/subscription/imagedetail/%s?_proxy=1&_wv=16777217&_wwv=4&userid=%s&time=%d", new Object[] { paramStFeed.id.get(), paramStFeed.poster.id.get(), Long.valueOf(paramStFeed.createTime.get()) });
  }
  
  public static String c(String paramString)
  {
    return String.format("https://h5.qzone.qq.com/subscription/homepage/%s?_proxy=1&_wv=16777217&_wwv=4", new Object[] { paramString });
  }
  
  private List<Integer> c(ShareInfoBean paramShareInfoBean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(9));
    localArrayList.add(Integer.valueOf(10));
    if (paramShareInfoBean.e == null) {
      return localArrayList;
    }
    int m = paramShareInfoBean.e.pageType;
    if ((m == 7000) || (m == 8001)) {
      localArrayList.add(Integer.valueOf(6));
    }
    return localArrayList;
  }
  
  private void c()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      if (((ShareInfoBean)localObject).b == null) {
        return;
      }
      localObject = new SubscribeDeleteFeedRequest(this.g.b);
      VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, new SubscribeShareHelper.3(this));
    }
    try
    {
      VSReporter.a(this.g.b(), "auth_share", "delete", 0, 0, new String[] { "", "", ((CertifiedAccountMeta.StUser)this.g.d.author.get()).nick.get(), this.g.d() });
      return;
    }
    catch (Exception localException) {}
  }
  
  public static String d(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return String.format("https://h5.qzone.qq.com/subscription/carousel/%s?_proxy=1&_wv=16777217&_wwv=4&userid=%s&time=%d", new Object[] { paramStFeed.id.get(), paramStFeed.poster.id.get(), Long.valueOf(paramStFeed.createTime.get()) });
  }
  
  private List<Integer> d(ShareInfoBean paramShareInfoBean)
  {
    ArrayList localArrayList = new ArrayList();
    int m;
    if ((paramShareInfoBean != null) && (paramShareInfoBean.b != null) && (paramShareInfoBean.e != null))
    {
      paramShareInfoBean.b.type.get();
      m = paramShareInfoBean.e.pageType;
      Object localObject;
      if (this.a != null)
      {
        localObject = this.j;
        if ((localObject != null) && (((IColorNoteController)localObject).shouldDisplayColorNote())) {
          if (this.j.isColorNoteExist()) {
            localArrayList.add(Integer.valueOf(82));
          } else {
            localArrayList.add(Integer.valueOf(70));
          }
        }
      }
      a(localArrayList);
      if (m == 7002)
      {
        if (j())
        {
          localObject = this.a;
          if (localObject != null) {
            ((Activity)localObject).getIntent().putExtra("big_brother_source_key", "biz_src_jc_dyh_mainhp");
          }
          if (k())
          {
            localArrayList.add(Integer.valueOf(155));
            VSReporter.b(this.g.b.poster.id.get(), "auth_share", "exp_shoplist", 0, 0, new String[0]);
          }
          if (this.c)
          {
            localArrayList.add(Integer.valueOf(157));
            localObject = this.g;
            if ((localObject != null) && (((ShareInfoBean)localObject).b != null)) {
              VSReporter.a(this.g.b.poster.id.get(), "auth_share", "exp_shop", 0, 0, new String[0]);
            }
          }
        }
        else
        {
          localObject = this.a;
          if (localObject != null) {
            ((Activity)localObject).getIntent().putExtra("big_brother_source_key", "biz_src_jc_dyh_guesthp");
          }
        }
      }
      else if (this.a != null) {
        if (j()) {
          this.a.getIntent().putExtra("big_brother_source_key", "biz_src_jc_dyh_main");
        } else {
          this.a.getIntent().putExtra("big_brother_source_key", "biz_src_jc_dyh_guest");
        }
      }
      if ((paramShareInfoBean.f) && (!j())) {
        localArrayList.add(Integer.valueOf(11));
      }
      int n = QzoneConfig.getInstance().getConfig("qqsubscribe", "showFansGroupConfigEntrance", 1);
      if ((m == 7002) && (j()) && (n == 1)) {
        localArrayList.add(Integer.valueOf(152));
      }
      if ((m == 7002) && (paramShareInfoBean.g)) {
        localArrayList.add(Integer.valueOf(154));
      }
    }
    if (this.g.h)
    {
      m = this.g.e.pageType;
      if ((m == 7001) || (m == 7002) || (m == 7005) || (m == 7000)) {
        localArrayList.add(Integer.valueOf(153));
      }
    }
    return localArrayList;
  }
  
  private void d()
  {
    Object localObject = this.g;
    if ((localObject != null) && (((ShareInfoBean)localObject).b != null) && (this.g.e != null))
    {
      String str1 = this.g.d();
      this.g.e();
      String str2 = this.g.f();
      String str3 = this.g.b();
      int m = this.g.e.pageType;
      if (m != 8001) {
        switch (m)
        {
        default: 
          localObject = null;
          break;
        case 7002: 
          localObject = this.g.c();
          break;
        }
      } else {
        localObject = a(this.g.b);
      }
      String str4 = this.g.g();
      QfavBuilder.a(3, str1, (String)localObject, null, null, str2, null, null, false, -1L).c(str3).a("lCategory", 10L).b("sUin", str4).b("sName", str4).c(this.a, BaseApplicationImpl.getApplication().getRuntime().getAccount(), 2, null);
    }
  }
  
  public static String e(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return String.format("https://h5.qzone.qq.com/subscription/videodetail/%s?_proxy=1&_wv=16777217&_wwv=4&userid=%s&time=%d", new Object[] { paramStFeed.id.get(), paramStFeed.poster.id.get(), Long.valueOf(paramStFeed.createTime.get()) });
  }
  
  private void e()
  {
    SubscribeLaucher.a(a(this.g.b, this.g.e));
  }
  
  private void f()
  {
    if (this.d != null) {
      return;
    }
    this.d = new SubscribeShareHelper.6(this);
    WXShareHelper.a().a(this.d);
  }
  
  private void g()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", this.g.d());
    localBundle.putString("desc", a(this.g));
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.g.c());
    ((StringBuilder)localObject1).append("&source=qzone");
    localBundle.putString("detail_url", ((StringBuilder)localObject1).toString());
    localObject1 = new ArrayList(1);
    ((ArrayList)localObject1).add(this.g.f());
    localBundle.putStringArrayList("image_url", (ArrayList)localObject1);
    localBundle.putLong("req_share_id", 0L);
    if (this.g.d != null)
    {
      Object localObject2 = this.g.d.shareQzoneInfo.entrys.get();
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject1 = new SerializableMap();
        HashMap localHashMap = new HashMap();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          COMM.Entry localEntry = (COMM.Entry)((Iterator)localObject2).next();
          localHashMap.put(localEntry.key.get(), localEntry.value.get());
        }
        ((SerializableMap)localObject1).setMap(localHashMap);
        break label238;
      }
    }
    localObject1 = null;
    label238:
    localBundle.putSerializable("share_qzone_info", (Serializable)localObject1);
    QZoneShareManager.jumpToQzoneShare(String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()), this.a, localBundle, null, -1);
  }
  
  private void h()
  {
    Object localObject = this.g.e;
    int m = 1;
    if (localObject != null)
    {
      int n = this.g.e.pageType;
      if (n != 8001)
      {
        switch (n)
        {
        default: 
          break;
        case 7002: 
          localObject = i();
          break;
        case 7000: 
          localObject = l();
          break;
        }
      }
      else
      {
        localObject = l();
        break label92;
      }
    }
    localObject = null;
    m = 21;
    label92:
    if (localObject == null)
    {
      localObject = this.a;
      if (localObject != null) {
        QQToast.makeText((Context)localObject, HardCodeUtil.a(2131911951), 0).show();
      }
      return;
    }
    if (localObject != null)
    {
      Activity localActivity = this.a;
      if (localActivity != null) {
        localActivity.startActivityForResult((Intent)localObject, m);
      }
    }
  }
  
  private Intent i()
  {
    Object localObject = this.g;
    if ((localObject != null) && (((ShareInfoBean)localObject).b != null))
    {
      if (TextUtils.isEmpty(this.g.b.poster.nick.get())) {
        return null;
      }
      localObject = new Intent();
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "ShareActionSheet shareToFriend");
      }
      ((Intent)localObject).putExtra("isWebCompShare", true);
      ((Intent)localObject).setClass(this.a.getApplicationContext(), ForwardRecentActivity.class);
      ((Intent)localObject).putExtra("key_flag_from_plugin", true);
      ((Intent)localObject).putExtra("category", this.a.getString(2131893001));
      ((Intent)localObject).putExtra("forward_type", 1001);
      ((Intent)localObject).putExtra("detail_url", this.g.c());
      ((Intent)localObject).putExtra("title", this.g.g());
      ((Intent)localObject).putExtra("forward _key_nojump", true);
      ((Intent)localObject).putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131894173, new Object[] { this.g.g() }));
      ((Intent)localObject).putExtra("desc", b(this.g.h()));
      ((Intent)localObject).putExtra("req_type", 1);
      ((Intent)localObject).putExtra("struct_share_key_content_action", "plugin");
      ((Intent)localObject).putExtra("pubUin", this.g.b.poster.id.get());
      ((Intent)localObject).putExtra("pluginName", "public_account");
      ((Intent)localObject).putExtra("pubUin", this.g.b.poster.id.get());
      ((Intent)localObject).putExtra("image_url_remote", this.g.b.poster.icon.get());
      ((Intent)localObject).putExtra("struct_share_key_content_action_DATA", a(this.g.b.poster.id.get(), this.g.b.poster.nick.get(), this.g.b.poster.icon.get()));
      AbsStructMsg localAbsStructMsg = StructMsgFactory.a(((Intent)localObject).getExtras());
      if (localAbsStructMsg != null)
      {
        localAbsStructMsg.mMsgServiceID = 152;
        ((Intent)localObject).putExtra("stuctmsg_bytes", localAbsStructMsg.getBytes());
        ((Intent)localObject).putExtra("from_card", true);
        return localObject;
      }
    }
    return null;
  }
  
  private boolean j()
  {
    ShareInfoBean localShareInfoBean = this.g;
    if ((localShareInfoBean != null) && (localShareInfoBean.b != null)) {
      return SubscribeUtils.a(this.g.b.poster.attr.get());
    }
    return false;
  }
  
  private boolean k()
  {
    ShareInfoBean localShareInfoBean = this.g;
    if ((localShareInfoBean != null) && (localShareInfoBean.b != null)) {
      return SubscribeUtils.d(this.g.b.poster.attr.get());
    }
    return false;
  }
  
  private Intent l()
  {
    Object localObject1 = this.g;
    if ((localObject1 != null) && (((ShareInfoBean)localObject1).d != null) && (!TextUtils.isEmpty(this.g.d.shareCardInfo.get())))
    {
      localObject1 = new Intent(this.a.getApplicationContext(), ForwardRecentActivity.class);
      try
      {
        JSONObject localJSONObject = new JSONObject(this.g.d.shareCardInfo.get());
        Object localObject2 = localJSONObject.getJSONObject("aio");
        localJSONObject = localJSONObject.getJSONObject("popUp");
        String str1 = ((JSONObject)localObject2).getString("app");
        String str2 = ((JSONObject)localObject2).getString("ver");
        String str3 = ((JSONObject)localObject2).getString("view");
        String str4 = ((JSONObject)localObject2).getString("meta");
        localObject2 = ((JSONObject)localObject2).getString("prompt");
        ((Intent)localObject1).putExtra("forward_type", 27);
        ((Intent)localObject1).putExtra("is_ark_display_share", true);
        ((Intent)localObject1).putExtra("forward_ark_app_name", str1);
        ((Intent)localObject1).putExtra("forward_ark_app_view", str3);
        ((Intent)localObject1).putExtra("forward_ark_app_ver", str2);
        ((Intent)localObject1).putExtra("forward_ark_app_prompt", (String)localObject2);
        ((Intent)localObject1).putExtra("forward_ark_app_meta", str4);
        localObject2 = localJSONObject.getString("app");
        str1 = localJSONObject.getString("ver");
        str2 = localJSONObject.getString("view");
        str3 = localJSONObject.getString("meta");
        localJSONObject.getString("prompt");
        ((Intent)localObject1).putExtras(QQCustomArkDialog.AppInfo.a((String)localObject2, str2, str1, str3, ArkAppCenterUtil.d(), null, null));
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return localObject1;
      }
    }
    return null;
  }
  
  public void a()
  {
    Object localObject = this.k;
    if ((localObject != null) && (((ShareActionSheet)localObject).isShowing())) {
      this.k.dismiss();
    }
    WXShareHelper.a().b(this.d);
    localObject = this.i;
    if (localObject != null) {
      ((SubscribeQRCodeShareHelper)localObject).a();
    }
  }
  
  public void a(ShareInfoBean paramShareInfoBean, IColorNoteController paramIColorNoteController)
  {
    if (this.k == null) {
      return;
    }
    ShareInfoBean localShareInfoBean = paramShareInfoBean;
    if (paramShareInfoBean == null) {
      localShareInfoBean = new ShareInfoBean();
    }
    this.g = localShareInfoBean;
    this.j = paramIColorNoteController;
    if ((this.g.b != null) && (!TextUtils.isEmpty(this.g.b.poster.nick.get())))
    {
      paramShareInfoBean = b(localShareInfoBean);
      this.a.getIntent().putExtra("big_brother_source_key", "biz_src_feeds_kandian");
      this.k.setActionSheetItems(a(paramShareInfoBean));
      this.k.setRowVisibility(8, 0, 0);
      this.k.show();
      SimpleEventBus.getInstance().dispatchEvent(new SharePanelShowStateEvent(true));
      return;
    }
    QQToast.makeText(this.a, HardCodeUtil.a(2131911962), 0).show();
  }
  
  public void a(String paramString)
  {
    this.h = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    ShareActionSheet localShareActionSheet = this.k;
    if (localShareActionSheet != null) {
      localShareActionSheet.setEnableNotTriggerVirtualNavigationBar(paramBoolean);
    }
  }
  
  public void b()
  {
    ShareActionSheet localShareActionSheet = this.k;
    if ((localShareActionSheet != null) && (localShareActionSheet.isShowing())) {
      this.k.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeShareHelper
 * JD-Core Version:    0.7.0.1
 */