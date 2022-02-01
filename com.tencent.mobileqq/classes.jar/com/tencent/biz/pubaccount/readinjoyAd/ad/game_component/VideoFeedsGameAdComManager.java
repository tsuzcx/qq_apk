package com.tencent.biz.pubaccount.readinjoyAd.ad.game_component;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager;
import com.tencent.biz.pubaccount.SoftAdExpoStatManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.GameComponentReport;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.GiftPackageManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdDialogUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftGetListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoFeedsGameAdComManager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoHolderHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.AdTagInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.KdTagItem;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoFeedsGameAdComManager
  implements View.OnClickListener, GiftGetListener, IVideoFeedsGameAdComManager
{
  private static final String a;
  private final int b;
  private Activity c;
  private boolean d;
  private Set<String> e = new HashSet();
  private Set<String> f = new HashSet();
  private VideoFeedsGameAdComBarConfigure g;
  private GameAdComData h;
  private VideoItemHolder i;
  private ADVideoAppDownloadData j;
  private ADBaseAppDownloadManager k;
  private boolean l = false;
  private boolean m = false;
  private GiftPackageDialog n;
  private VideoFeedsGameAdComManager.GameAdGiftInfo o;
  private AdvertisementInfo p;
  private String q;
  private String r;
  private int s;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.readinjoy.video.");
    localStringBuilder.append(VideoFeedsGameAdComManager.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  public VideoFeedsGameAdComManager(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.g = new VideoFeedsGameAdComBarConfigure(paramQQAppInterface);
    this.b = DisplayUtil.a(paramActivity, 3.0F);
    this.c = paramActivity;
    this.k = new ADBaseAppDownloadManager(paramActivity);
    this.k.a(new VideoFeedsGameAdComManager.1(this));
  }
  
  private void A()
  {
    if (m())
    {
      this.i.bk.setClickable(false);
      this.i.bg.setClickable(false);
    }
    else
    {
      this.i.bk.setClickable(true);
      this.i.bg.setClickable(true);
    }
    this.i.bl.setClickable(false);
    a(this.i.bk, 0);
    a(this.i.bl, 8);
  }
  
  private void B()
  {
    try
    {
      this.o = new VideoFeedsGameAdComManager.GameAdGiftInfo(this, new JSONObject(this.h.v));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void C()
  {
    if (l())
    {
      this.i.bk.setClickable(false);
      this.i.bg.setClickable(false);
    }
    else
    {
      this.i.bk.setClickable(true);
      this.i.bg.setClickable(true);
    }
    this.i.bl.setClickable(false);
    a(this.i.bk, 0);
    a(this.i.bl, 8);
  }
  
  private void D()
  {
    if (k())
    {
      ADVideoAppDownloadData localADVideoAppDownloadData = this.j;
      if ((localADVideoAppDownloadData != null) && (!TextUtils.isEmpty(localADVideoAppDownloadData.c)))
      {
        this.i.bk.setClickable(true);
        this.i.bg.setClickable(true);
        this.i.bl.setClickable(true);
        break label95;
      }
    }
    this.i.bk.setClickable(false);
    this.i.bg.setClickable(false);
    this.i.bl.setClickable(false);
    label95:
    a(this.i.bk, 0);
    a(this.i.bl, 8);
    r();
  }
  
  private boolean E()
  {
    Object localObject = this.j.d;
    HashMap localHashMap = new HashMap();
    boolean bool = PackageUtil.a(BaseApplicationImpl.getContext(), (String)localObject);
    int i1 = 5;
    if (bool)
    {
      i();
      localObject = this.h;
      ((GameAdComData)localObject).G = 1;
      if ("2".equals(((GameAdComData)localObject).t)) {
        localHashMap.put("download_state", "5");
      } else {
        i1 = 1;
      }
      localHashMap.put("vid", this.q);
      a(i1, Integer.valueOf(15), localHashMap);
      return true;
    }
    if (ADBaseAppDownloadManager.a(this.c, this.j))
    {
      localObject = DownloadManagerV2.a().c(this.j.d);
      DownloadManagerV2.a().d((DownloadInfo)localObject);
      localObject = this.h;
      ((GameAdComData)localObject).G = 5;
      if ("2".equals(((GameAdComData)localObject).t)) {
        localHashMap.put("download_state", "3");
      } else {
        i1 = 1;
      }
      localHashMap.put("vid", this.q);
      a(i1, Integer.valueOf(18), localHashMap);
      return true;
    }
    return false;
  }
  
  public static JSONObject a(AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    JSONObject localJSONObject1 = new JSONObject();
    if (paramAdvertisementInfo != null) {
      if (paramAdvertisementInfo.gameAdComData == null) {
        return localJSONObject1;
      }
    }
    for (Object localObject = paramAdvertisementInfo.gameAdComData;; localObject = "'1")
    {
      try
      {
        JSONObject localJSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(((GameAdComData)localObject).C)) {
          localJSONObject2.put("nfa_chainid", ((GameAdComData)localObject).C);
        }
        localJSONObject2.put("appid", ((GameAdComData)localObject).h);
        localObject = paramAdvertisementInfo.gameAdComData;
        String str = "2";
        if (localObject != null)
        {
          localObject = str;
          if (paramAdvertisementInfo.gameAdComData.E.equals("2")) {}
        }
        else
        {
          if (!paramAdvertisementInfo.isKolGame) {
            continue;
          }
          localObject = str;
        }
        localJSONObject2.put("obj_type", localObject);
        if (paramInt == 2) {
          localJSONObject2.put("type", 0);
        }
        localJSONObject1.put("game_gift_report", String.valueOf(localJSONObject2));
        return localJSONObject1;
      }
      catch (JSONException paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
      }
      return localJSONObject1;
    }
  }
  
  private void a(int paramInt, Integer paramInteger1, Integer paramInteger2, HashMap<String, Object> paramHashMap, boolean paramBoolean)
  {
    Object localObject = this.p;
    if (localObject == null) {
      return;
    }
    localObject = ((AdvertisementInfo)localObject).mTitle;
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("游戏组件上报 type = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" adTitle = ");
    localStringBuilder.append((String)localObject);
    QLog.d(str, 1, localStringBuilder.toString());
    paramHashMap.put("vid", this.q);
    a(paramHashMap);
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.c).a(paramInt).b(26).d(1).a(paramInteger1).b(paramInteger2).b(paramBoolean).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(null, this.p.mRowKey, this.r, this.h.t, this.h.e, paramHashMap)).e(a(this.p, paramInt)).a(this.p));
  }
  
  private void a(int paramInt, Integer paramInteger, HashMap<String, Object> paramHashMap)
  {
    a(paramInt, null, paramInteger, paramHashMap, false);
  }
  
  private void a(int paramInt, Integer paramInteger, HashMap<String, Object> paramHashMap, boolean paramBoolean)
  {
    a(paramInt, paramInteger, null, paramHashMap, paramBoolean);
  }
  
  private static void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    paramView.setVisibility(paramInt);
  }
  
  private static void a(View paramView, Object paramObject)
  {
    if (paramView == null) {
      return;
    }
    paramView.setTag(paramObject);
  }
  
  private void a(GameAdComData paramGameAdComData, VideoItemHolder paramVideoItemHolder)
  {
    this.d = true;
    this.i = paramVideoItemHolder;
    this.l = false;
    this.m = false;
    if ((paramVideoItemHolder.bg == null) && (((IVideoHolderHelper)QRoute.api(IVideoHolderHelper.class)).isShortVideoItemHolder(paramVideoItemHolder)) && (paramVideoItemHolder.aZ != null))
    {
      paramVideoItemHolder.bg = ((ViewGroup)((ViewStub)paramVideoItemHolder.aZ.findViewById(2131449594)).inflate());
      paramVideoItemHolder.bh = ((URLImageView)paramVideoItemHolder.bg.findViewById(2131433951));
      paramVideoItemHolder.bi = ((TextView)paramVideoItemHolder.bg.findViewById(2131433954));
      paramVideoItemHolder.bj = ((TextView)paramVideoItemHolder.bg.findViewById(2131433953));
      paramVideoItemHolder.bk = ((TextView)paramVideoItemHolder.bg.findViewById(2131433952));
      paramVideoItemHolder.bl = ((TextView)paramVideoItemHolder.bg.findViewById(2131433950));
      paramVideoItemHolder.bt = ((TextView)paramVideoItemHolder.bg.findViewById(2131427861));
    }
    if (paramVideoItemHolder.bg != null)
    {
      paramVideoItemHolder.bg.setVisibility(0);
      if (TextUtils.isEmpty(paramGameAdComData.k)) {}
    }
    try
    {
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      localObject2 = URLDrawable.getDrawable(paramGameAdComData.k, (URLDrawable.URLDrawableOptions)localObject1);
      ((URLDrawable)localObject2).setTag(URLDrawableDecodeHandler.b(((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth, ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight, this.b));
      ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.k);
      if (paramVideoItemHolder.bh == null) {
        break label311;
      }
      paramVideoItemHolder.bh.setImageDrawable((Drawable)localObject2);
    }
    catch (Exception localException)
    {
      Object localObject1;
      Object localObject2;
      label263:
      break label263;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("后台下发的url格式有问题：");
      ((StringBuilder)localObject2).append(paramGameAdComData.k);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    label311:
    b(paramVideoItemHolder.bi, paramGameAdComData.d);
    if ((FastWeqAdUtils.e(this.p)) && (!TextUtils.isEmpty(paramGameAdComData.o))) {
      b(paramVideoItemHolder.bj, paramGameAdComData.o);
    } else {
      b(paramVideoItemHolder.bj, paramGameAdComData.j);
    }
    a(paramGameAdComData.D);
    if (ReadInJoyAdSwitchUtil.a()) {
      b(paramVideoItemHolder.bj, Color.parseColor("#80000000"));
    }
    paramVideoItemHolder.bg.setTag(paramVideoItemHolder);
    a(paramVideoItemHolder.bk, paramVideoItemHolder);
    a(paramVideoItemHolder.bl, paramVideoItemHolder);
    paramVideoItemHolder.bg.setOnClickListener(this);
    if (paramVideoItemHolder.bk != null) {
      paramVideoItemHolder.bk.setOnClickListener(this);
    }
    if (paramVideoItemHolder.bl != null) {
      paramVideoItemHolder.bl.setOnClickListener(this);
    }
    paramVideoItemHolder.bg.setTag(2131449867, this.h);
    q();
    b(paramVideoItemHolder);
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).performViewSlideUpAnim(paramVideoItemHolder.bg, 200);
  }
  
  private void a(Long paramLong)
  {
    Object localObject = this.p;
    if (localObject != null) {
      ((AdvertisementInfo)localObject).setAdClickPos(AdClickPos.SoftAdComponent);
    }
    this.l = false;
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addGdtWebClickReport(this.p);
    Integer localInteger = FastWeqAdUtils.a(this.c, this.h.q, this.h.r, "");
    localObject = paramLong;
    if (paramLong == null)
    {
      localObject = Long.valueOf(3050107L);
      if (FastWeqAdUtils.d(this.p)) {
        localObject = Long.valueOf(3050107L);
      } else if (FastWeqAdUtils.c(this.p)) {
        localObject = Long.valueOf(3050205L);
      } else if (FastWeqAdUtils.b(this.p)) {
        localObject = Long.valueOf(3050309L);
      } else if (FastWeqAdUtils.f(this.p)) {
        localObject = Long.valueOf(3050407L);
      } else if (FastWeqAdUtils.e(this.p)) {
        localObject = Long.valueOf(3050507L);
      }
    }
    paramLong = this.p;
    if (paramLong != null)
    {
      paramLong = GameComponentReport.a(paramLong, ((Long)localObject).longValue(), 9L, "", this.r, "");
      localObject = ReadInJoyAdReportUtils.a(this.p, 39, 119, localInteger);
      ((AdReportData)localObject).e(paramLong);
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report((AdReportData)localObject);
    }
  }
  
  private void a(String paramString)
  {
    Object localObject = this.i;
    if ((localObject != null) && (((VideoItemHolder)localObject).bt != null) && (!TextUtils.isEmpty(paramString)))
    {
      a(this.i.bt, 0);
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setCornerRadius(AIOUtils.b(2.0F, this.c.getResources()));
      ((GradientDrawable)localObject).setColor(Color.parseColor("#33000000"));
      this.i.bt.setBackgroundDrawable((Drawable)localObject);
      this.i.bt.setText(paramString);
      return;
    }
    a(this.i.bt, 8);
  }
  
  private void a(HashMap<String, Object> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (this.p.isKolGame)
        {
          str = "2";
          localJSONObject.put("obj_type", str);
          paramHashMap.put("article_ad_ext", localJSONObject.toString());
          return;
        }
      }
      catch (Exception paramHashMap)
      {
        paramHashMap.printStackTrace();
        return;
      }
      String str = "1";
    }
  }
  
  private boolean a(int paramInt, HashMap<String, Object> paramHashMap, boolean paramBoolean)
  {
    Object localObject;
    if (PackageUtil.a(BaseApplicationImpl.getContext(), this.j.d))
    {
      i();
      localObject = this.h;
      ((GameAdComData)localObject).G = 1;
      if (((GameAdComData)localObject).t.equals("2"))
      {
        paramHashMap.put("download_state", "5");
        paramInt = 5;
      }
      a(paramInt, Integer.valueOf(15), paramHashMap);
      if (paramBoolean)
      {
        a(this.i.bk, 0);
        a(this.i.bl, 8);
      }
      return true;
    }
    if (ADBaseAppDownloadManager.a(this.c, this.j))
    {
      localObject = DownloadManagerV2.a().c(this.j.d);
      DownloadManagerV2.a().d((DownloadInfo)localObject);
      localObject = this.h;
      ((GameAdComData)localObject).G = 5;
      if (((GameAdComData)localObject).t.equals("2"))
      {
        paramHashMap.put("download_state", "3");
        paramInt = 5;
      }
      a(paramInt, Integer.valueOf(18), paramHashMap);
      if (paramBoolean)
      {
        a(this.i.bk, 0);
        a(this.i.bl, 8);
      }
      return true;
    }
    if (ADBaseAppDownloadManager.a(this.c, this.j))
    {
      g();
      localObject = this.h;
      ((GameAdComData)localObject).G = 5;
      if (((GameAdComData)localObject).t.equals("2"))
      {
        paramHashMap.put("download_state", "3");
        paramInt = 5;
      }
      a(paramInt, Integer.valueOf(18), paramHashMap);
      if (paramBoolean)
      {
        a(this.i.bk, 0);
        a(this.i.bl, 8);
      }
      return true;
    }
    return false;
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    if (this.e.contains(paramVideoInfo.b)) {
      return false;
    }
    if (ReadInJoyAdUtils.a(this.g)) {
      return true;
    }
    return this.f.contains(paramVideoInfo.b);
  }
  
  private static void b(TextView paramTextView, int paramInt)
  {
    if (paramTextView == null) {
      return;
    }
    paramTextView.setTextColor(paramInt);
  }
  
  private static void b(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    if (paramTextView == null) {
      return;
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  private static void b(TextView paramTextView, CharSequence paramCharSequence)
  {
    if (paramTextView == null) {
      return;
    }
    paramTextView.setText(paramCharSequence);
  }
  
  private void b(VideoItemHolder paramVideoItemHolder)
  {
    Object localObject1 = HardCodeUtil.a(2131913454);
    Object localObject2 = this.h;
    if (localObject2 == null) {
      return;
    }
    int i1 = 0;
    try
    {
      int i2 = Integer.valueOf(((GameAdComData)localObject2).t).intValue();
      i1 = i2;
    }
    catch (Exception localException)
    {
      label36:
      boolean bool;
      break label36;
    }
    bool = ReadInJoyAdSwitchUtil.a();
    if (i1 == 1)
    {
      if (l())
      {
        localObject2 = BaseApplicationImpl.getContext().getResources().getString(2131915393);
        b(paramVideoItemHolder.bk, Color.parseColor("#262626"));
        localObject1 = localObject2;
        if (bool)
        {
          b(paramVideoItemHolder.bk, Color.parseColor("#80000000"));
          localObject1 = localObject2;
        }
      }
      else
      {
        if (bool) {
          localObject1 = "预约";
        } else {
          localObject1 = HardCodeUtil.a(2131913390);
        }
        if (!TextUtils.isEmpty(this.h.w)) {
          localObject1 = this.h.w;
        }
        b(paramVideoItemHolder.bk, -1);
      }
      b(paramVideoItemHolder.bk, null, null, null, null);
    }
    else if (i1 == 2)
    {
      if (!TextUtils.isEmpty(this.h.e))
      {
        if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppInstall(BaseApplicationImpl.getContext(), this.h.e))
        {
          if (bool) {
            localObject1 = "打开";
          } else {
            localObject1 = HardCodeUtil.a(2131913419);
          }
          b(paramVideoItemHolder.bk, -1);
          b(paramVideoItemHolder.bk, null, null, null, null);
          b(paramVideoItemHolder.bk, (CharSequence)localObject1);
          return;
        }
        if (bool) {
          localObject2 = "下载";
        } else {
          localObject2 = HardCodeUtil.a(2131913388);
        }
        if (!TextUtils.isEmpty(this.h.w)) {
          localObject2 = this.h.w;
        }
        b(paramVideoItemHolder.bk, -1);
        if (!bool)
        {
          localObject1 = this.c.getResources().getDrawable(2130843959);
          b(paramVideoItemHolder.bk, null, null, (Drawable)localObject1, null);
        }
        else
        {
          b(paramVideoItemHolder.bk, null, null, null, null);
        }
        b(paramVideoItemHolder.bk, (CharSequence)localObject2);
        localObject1 = localObject2;
        if (!this.l)
        {
          localObject1 = localObject2;
          if (!this.m)
          {
            this.m = true;
            e();
          }
        }
      }
    }
    else
    {
      if (m())
      {
        localObject2 = HardCodeUtil.a(2131913387);
        b(paramVideoItemHolder.bk, Color.parseColor("#262626"));
        localObject1 = localObject2;
        if (bool)
        {
          b(paramVideoItemHolder.bk, Color.parseColor("#80000000"));
          localObject1 = localObject2;
        }
      }
      else
      {
        if (!TextUtils.isEmpty(this.h.w)) {
          localObject1 = this.h.w;
        } else {
          localObject1 = HardCodeUtil.a(2131913363);
        }
        b(paramVideoItemHolder.bk, -1);
      }
      b(paramVideoItemHolder.bk, null, null, null, null);
    }
    b(paramVideoItemHolder.bk, (CharSequence)localObject1);
  }
  
  private void c(VideoItemHolder paramVideoItemHolder)
  {
    if ((paramVideoItemHolder != null) && (paramVideoItemHolder.bg != null)) {
      paramVideoItemHolder.bg.setVisibility(8);
    }
  }
  
  private boolean v()
  {
    GameAdComData localGameAdComData = this.h;
    return (localGameAdComData != null) && (!TextUtils.isEmpty(localGameAdComData.k)) && (!TextUtils.isEmpty(this.h.d)) && (!TextUtils.isEmpty(this.h.j));
  }
  
  private String w()
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("jump_page", 6);
      ((JSONObject)localObject).put("jump_bus_type", 5);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, localException.getMessage());
      }
    }
    return "";
  }
  
  private void x()
  {
    if (this.j == null) {
      return;
    }
    boolean bool = this.l;
    int i2 = 1;
    int i1 = 1;
    if (!bool)
    {
      if (this.h.G == 4)
      {
        a(4, o());
        return;
      }
      if (this.h.G == 5)
      {
        localObject1 = this.j.d;
        if (PackageUtil.a(BaseApplicationImpl.getContext(), (String)localObject1))
        {
          this.h.G = 1;
          a(1, o());
          return;
        }
        a(5, o());
        return;
      }
      if (this.h.G == 3)
      {
        a(3, o());
        localObject1 = this.j;
        if (localObject1 != null)
        {
          localObject2 = this.k;
          if (localObject2 != null) {
            ((ADBaseAppDownloadManager)localObject2).a((ADVideoAppDownloadData)localObject1);
          }
        }
      }
      return;
    }
    Object localObject1 = new HashMap();
    if (ADBaseAppDownloadManager.a(this.c, this.j))
    {
      g();
      localObject2 = this.h;
      ((GameAdComData)localObject2).G = 5;
      if ("2".equals(((GameAdComData)localObject2).t))
      {
        ((HashMap)localObject1).put("download_state", "3");
        i1 = 5;
      }
      a(i1, Integer.valueOf(18), (HashMap)localObject1);
      return;
    }
    f();
    Object localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("queryCallback and download: appId is ");
    localStringBuilder.append(this.j.a);
    localStringBuilder.append(" appName is ");
    localStringBuilder.append(this.j.e);
    ((IRIJAdLogService)localObject2).d(str, localStringBuilder.toString());
    i1 = i2;
    if ("2".equals(this.h.t))
    {
      ((HashMap)localObject1).put("download_state", "1");
      i1 = 5;
    }
    a(i1, Integer.valueOf(3), (HashMap)localObject1);
  }
  
  private boolean y()
  {
    if (k())
    {
      Object localObject = this.j;
      if (localObject != null) {
        try
        {
          localObject = ((ADVideoAppDownloadData)localObject).d;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = DownloadManagerV2.a().c((String)localObject);
            if ((ADBaseAppDownloadManager.a(this.c, this.j)) && (localObject != null) && (((DownloadInfo)localObject).a() == 4))
            {
              j();
              return true;
            }
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            localException.printStackTrace();
          }
        }
      }
    }
    return false;
  }
  
  private void z()
  {
    a(this.i.bk, 8);
    a(this.i.bl, 0);
    if (!ReadInJoyAdSwitchUtil.a())
    {
      localTextView = this.i.bl;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131913422));
      localStringBuilder.append(this.h.H);
      localStringBuilder.append("%");
      b(localTextView, localStringBuilder.toString());
      b(this.i.bl, Color.parseColor("#262626"));
      return;
    }
    TextView localTextView = this.i.bl;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h.H);
    localStringBuilder.append("%");
    b(localTextView, localStringBuilder.toString());
    b(this.i.bl, Color.parseColor("#80000000"));
  }
  
  public VideoFeedsGameAdComBarConfigure a()
  {
    return this.g;
  }
  
  protected void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    if ((paramInt == 5) && ("2".equals(this.h.t)))
    {
      localHashMap.put("download_state", "2");
      a(5, null, null, localHashMap, false);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 8)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4)
          {
            if (paramInt1 != 5)
            {
              if (paramInt1 != 6) {
                return;
              }
              a(this.i.bk, 0);
              a(this.i.bl, 8);
              QQToast.makeText(this.c, HardCodeUtil.a(2131913432), 0).show();
              return;
            }
            a(this.i.bk, 0);
            b(this.i.bk, HardCodeUtil.a(2131913374));
            if (ReadInJoyAdSwitchUtil.a()) {
              b(this.i.bk, "安装");
            }
            b(this.i.bk, -1);
            b(this.i.bk, null, null, null, null);
            a(this.i.bl, 8);
            a(paramInt1);
            return;
          }
          a(this.i.bk, 8);
          a(this.i.bl, 0);
          b(this.i.bl, HardCodeUtil.a(2131913440));
          b(this.i.bl, -1);
          if (ReadInJoyAdSwitchUtil.a())
          {
            b(this.i.bl, "继续");
            b(this.i.bl, Color.parseColor("#80000000"));
          }
        }
        else
        {
          z();
          a(this.i.bk, 8);
          a(this.i.bl, 0);
          b(this.i.bl, Color.parseColor("#262626"));
          if (ReadInJoyAdSwitchUtil.a()) {
            b(this.i.bl, Color.parseColor("#80000000"));
          }
        }
      }
      else {
        x();
      }
    }
    else
    {
      a(this.i.bk, 0);
      b(this.i.bk, HardCodeUtil.a(2131913353));
      if (ReadInJoyAdSwitchUtil.a()) {
        b(this.i.bk, "打开");
      }
      b(this.i.bk, -1);
      b(this.i.bk, null, null, null, null);
      a(this.i.bl, 8);
    }
  }
  
  public void a(long paramLong)
  {
    if ("3".equals(this.h.t))
    {
      VideoFeedsGameAdComManager.GameAdGiftInfo localGameAdGiftInfo = this.o;
      if ((localGameAdGiftInfo != null) && (localGameAdGiftInfo.d == paramLong)) {
        this.i.bk.post(new VideoFeedsGameAdComManager.2(this));
      }
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (paramConfiguration.orientation == 2)
    {
      GiftPackageDialog localGiftPackageDialog = this.n;
      if (localGiftPackageDialog != null)
      {
        localGiftPackageDialog.a(paramConfiguration);
        this.n.dismiss();
      }
    }
    this.s = paramConfiguration.orientation;
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.p = paramAdvertisementInfo;
    this.p.scene = "RIJAdRefreshSceneFloatVideo";
    this.h = paramAdvertisementInfo.gameAdComData;
    if ("2".equals(this.h.t)) {
      this.j = ADVideoAppDownloadData.a(this.h);
    }
  }
  
  public void a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder)
  {
    if (paramVideoItemHolder.af.getVisibility() == 0) {
      return;
    }
    if ((paramVideoItemHolder.bg != null) && (paramVideoItemHolder.bg.getVisibility() == 0)) {
      return;
    }
    if ((paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.b)) && (!v()) && (a(paramVideoInfo))) {
      return;
    }
    if (paramVideoInfo != null)
    {
      Object localObject1 = this.h;
      if (localObject1 != null)
      {
        if ("3".equals(((GameAdComData)localObject1).t))
        {
          B();
          if (m())
          {
            this.f.add(paramVideoInfo.b);
            return;
          }
        }
        a(this.h, paramVideoItemHolder);
        this.q = paramVideoInfo.b;
        localObject1 = new StringBuilder();
        if ((paramVideoInfo.aC != null) && (paramVideoInfo.aC.b != null) && (!paramVideoInfo.aC.b.isEmpty()))
        {
          localObject2 = paramVideoInfo.aC.b.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            ((StringBuilder)localObject1).append(((VideoInfo.KdTagItem)((Iterator)localObject2).next()).a);
            ((StringBuilder)localObject1).append(",");
          }
        }
        localObject1 = ((StringBuilder)localObject1).toString();
        boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
        Object localObject2 = "";
        if (bool) {
          localObject1 = "";
        } else {
          localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        }
        this.r = ((String)localObject1);
        if (this.e.contains(paramVideoInfo.b)) {
          return;
        }
        this.e.add(paramVideoInfo.b);
        SoftAdExpoStatManager.a().a(paramVideoItemHolder.getAdapterPosition());
        if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo) != null) && (!((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).isKolSoftAd())) {
          this.g.a();
        }
        if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo != null)) {
          SoftAdExpoStatManager.a().a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo.ad);
        }
        paramVideoItemHolder = this.p;
        paramVideoInfo = (VideoInfo)localObject2;
        if (paramVideoItemHolder != null)
        {
          paramVideoInfo = (VideoInfo)localObject2;
          if (!TextUtils.isEmpty(paramVideoItemHolder.mAdViewId)) {
            paramVideoInfo = this.p.mAdViewId;
          }
        }
        paramVideoItemHolder = new HashMap();
        a(2, Integer.valueOf(2), paramVideoItemHolder, true);
        a(2, Integer.valueOf(1), paramVideoItemHolder, false);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009376", "0X8009376", 0, 0, String.valueOf(26), String.valueOf(1), paramVideoInfo, w());
        return;
      }
    }
    if ((paramVideoItemHolder.bg != null) && (paramVideoItemHolder.bg.getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "默认不显示引流条");
      }
      paramVideoItemHolder.bg.setVisibility(8);
    }
  }
  
  public void a(VideoItemHolder paramVideoItemHolder)
  {
    this.d = false;
    c(paramVideoItemHolder);
  }
  
  public void a(boolean paramBoolean)
  {
    ReadInJoyAdDialogUtil.a(this.c, this.h.e, new VideoFeedsGameAdComManager.5(this, paramBoolean));
  }
  
  public boolean a(VideoItemHolder paramVideoItemHolder, boolean paramBoolean)
  {
    VideoInfo localVideoInfo = paramVideoItemHolder.az.c;
    if ((localVideoInfo != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(localVideoInfo) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(localVideoInfo).mSoftAdType == 1) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(localVideoInfo).gameAdComData != null))
    {
      a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(localVideoInfo));
      if (!paramBoolean) {
        a(localVideoInfo, paramVideoItemHolder);
      }
      return true;
    }
    return false;
  }
  
  public int b()
  {
    return this.g.b();
  }
  
  public int c()
  {
    return this.g.c();
  }
  
  public void d()
  {
    this.l = false;
    this.c = null;
    ADBaseAppDownloadManager localADBaseAppDownloadManager = this.k;
    if (localADBaseAppDownloadManager != null) {
      localADBaseAppDownloadManager.a();
    }
  }
  
  protected void e()
  {
    Object localObject1 = this.k;
    if (localObject1 != null)
    {
      localObject2 = this.j;
      if (localObject2 != null)
      {
        ((ADBaseAppDownloadManager)localObject1).c((ADVideoAppDownloadData)localObject2);
        localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
        localObject2 = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("doQuery : appId is ");
        localStringBuilder.append(this.j.a);
        localStringBuilder.append(" appName is ");
        localStringBuilder.append(this.j.e);
        ((IRIJAdLogService)localObject1).d((String)localObject2, localStringBuilder.toString());
        return;
      }
    }
    localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    Object localObject2 = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doQuery cancel, manager is ");
    localStringBuilder.append(this.k);
    localStringBuilder.append(" downloadData is ");
    localStringBuilder.append(this.j);
    ((IRIJAdLogService)localObject1).d((String)localObject2, localStringBuilder.toString());
  }
  
  protected void f()
  {
    ADBaseAppDownloadManager localADBaseAppDownloadManager = this.k;
    if (localADBaseAppDownloadManager != null)
    {
      ADVideoAppDownloadData localADVideoAppDownloadData = this.j;
      if (localADVideoAppDownloadData != null) {
        localADBaseAppDownloadManager.a(localADVideoAppDownloadData);
      }
    }
    if (this.i.bl != null) {
      z();
    }
  }
  
  protected void g()
  {
    ADVideoAppDownloadData localADVideoAppDownloadData = this.j;
    if (localADVideoAppDownloadData != null)
    {
      ADBaseAppDownloadManager localADBaseAppDownloadManager = this.k;
      if (localADBaseAppDownloadManager != null) {
        localADBaseAppDownloadManager.f(localADVideoAppDownloadData);
      }
    }
  }
  
  public void h()
  {
    ThreadManager.executeOnNetWorkThread(new VideoFeedsGameAdComManager.3(this));
  }
  
  protected void i()
  {
    if (k())
    {
      Object localObject = this.j;
      if (localObject != null)
      {
        if ((((ADVideoAppDownloadData)localObject).l) && (!TextUtils.isEmpty(this.j.d)))
        {
          ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).launch(this.c, this.j.d);
          return;
        }
        localObject = (IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class);
        Activity localActivity = this.c;
        AdvertisementInfo localAdvertisementInfo = this.p;
        ((IRIJAdActionUtilService)localObject).openAppFromGdtApi(localActivity, localAdvertisementInfo, null, (int)localAdvertisementInfo.mChannelID, true);
      }
    }
  }
  
  protected void j()
  {
    GameAdComData localGameAdComData = this.h;
    localGameAdComData.G = 5;
    localGameAdComData.H = 100;
  }
  
  protected boolean k()
  {
    return true;
  }
  
  protected boolean l()
  {
    return false;
  }
  
  protected boolean m()
  {
    VideoFeedsGameAdComManager.GameAdGiftInfo localGameAdGiftInfo = this.o;
    if (localGameAdGiftInfo == null) {
      return false;
    }
    return GiftPackageManager.a(null, localGameAdGiftInfo.d);
  }
  
  protected int n()
  {
    return Integer.valueOf(this.h.t).intValue();
  }
  
  protected int o()
  {
    return this.h.H;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (VideoItemHolder)paramView.getTag();
    Object localObject2 = new HashMap();
    this.l = true;
    int i1 = paramView.getId();
    localObject1 = "";
    if (i1 != 2131433950)
    {
      if (i1 != 2131433952)
      {
        if (i1 == 2131441409) {
          a(null);
        }
      }
      else
      {
        paramView = this.p;
        if (paramView != null) {
          paramView.setAdClickPos(AdClickPos.SoftAdClickBtn);
        }
        try
        {
          i1 = Integer.valueOf(this.h.t).intValue();
          if (i1 == 1) {
            break label396;
          }
          if (i1 == 3)
          {
            h();
          }
          else if (i1 == 6)
          {
            a(Long.valueOf(3050503L));
          }
          else
          {
            if (this.j == null) {
              return;
            }
            if (!a(1, (HashMap)localObject2, false))
            {
              this.l = false;
              ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addGdtWebClickReport(this.p);
              localObject2 = FastWeqAdUtils.a(this.c, this.h.q, this.h.r, "");
              if (this.p != null)
              {
                paramView = GameComponentReport.a(this.p, 3050103L, 9L, "", this.r, "");
                localObject2 = ReadInJoyAdReportUtils.a(this.p, 39, 119, (Integer)localObject2);
                ((AdReportData)localObject2).e(paramView);
                ((IRIJAdService)QRoute.api(IRIJAdService.class)).report((AdReportData)localObject2);
              }
            }
          }
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
        }
      }
    }
    else
    {
      paramView = this.p;
      if (paramView != null) {
        paramView.setAdClickPos(AdClickPos.SoftAdClickBtn);
      }
      try
      {
        if (this.j == null) {
          return;
        }
        if (Integer.valueOf(this.h.t).intValue() == 2)
        {
          boolean bool = a(1, (HashMap)localObject2, true);
          if (!bool)
          {
            this.l = false;
            ReadInJoyAdUtils.q(this.p);
            a(1, FastWeqAdUtils.a(this.c, this.h.q, this.h.r, ""), (HashMap)localObject2);
          }
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
    label396:
    localObject2 = this.p;
    paramView = (View)localObject1;
    if (localObject2 != null)
    {
      paramView = (View)localObject1;
      if (!TextUtils.isEmpty(((AdvertisementInfo)localObject2).mAdViewId)) {
        paramView = this.p.mAdViewId;
      }
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009377", "0X8009377", 0, 0, String.valueOf(26), String.valueOf(1), paramView, w());
  }
  
  protected int p()
  {
    return this.h.G;
  }
  
  protected void q()
  {
    VideoItemHolder localVideoItemHolder = this.i;
    if (localVideoItemHolder == null) {
      return;
    }
    a(localVideoItemHolder.bl, 8);
    int i1 = n();
    if (i1 == 1)
    {
      C();
      return;
    }
    if (i1 == 2)
    {
      D();
      return;
    }
    A();
  }
  
  protected void r()
  {
    boolean bool1;
    try
    {
      if (this.j != null) {
        bool1 = PackageUtil.a(BaseApplicationImpl.getContext(), this.j.d);
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        localException.printStackTrace();
      }
      bool1 = false;
    }
    boolean bool2 = y();
    if ((!bool1) && (!bool2) && ((p() == 4) || (p() == 3)) && (o() >= 0) && (o() < 100))
    {
      a(this.i.bk, 8);
      a(this.i.bl, 0);
      a(p(), o());
      return;
    }
    a(this.i.bk, 0);
    a(this.i.bl, 8);
  }
  
  public void s()
  {
    this.l = false;
    if ((this.h != null) && (this.j != null)) {
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager
 * JD-Core Version:    0.7.0.1
 */