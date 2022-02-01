import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import cooperation.vip.tianshu.TianShuAdPosItemData;
import cooperation.vip.tianshu.TianShuManager;
import cooperation.vip.tianshu.TianShuReportData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class bmlf
{
  private Conversation a;
  
  public bmlf(Conversation paramConversation)
  {
    this.a = paramConversation;
  }
  
  private static List<TianShuAdPosItemData> a()
  {
    ArrayList localArrayList = new ArrayList();
    TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.mNeedCnt = 1;
    localTianShuAdPosItemData.mPosId = 596;
    localArrayList.add(localTianShuAdPosItemData);
    return localArrayList;
  }
  
  private static void a(bbbu parambbbu, QQAppInterface paramQQAppInterface, View paramView)
  {
    if ((paramQQAppInterface == null) || (paramView == null) || (parambbbu == null)) {}
    for (;;)
    {
      return;
      URLImageView localURLImageView = (URLImageView)paramView.findViewById(2131376524);
      paramView = (TextView)paramView.findViewById(2131376523);
      if ((localURLImageView != null) && (paramView != null))
      {
        localURLImageView.setVisibility(8);
        if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
          parambbbu = "#FDC256";
        }
        while (!TextUtils.isEmpty(parambbbu))
        {
          try
          {
            paramView.setTextColor(Color.parseColor(parambbbu));
            return;
          }
          catch (Exception parambbbu)
          {
            QLog.e("TianshuRenewalsBarManager", 1, parambbbu, new Object[0]);
            return;
          }
          if (!TextUtils.isEmpty(parambbbu.h))
          {
            paramQQAppInterface = URLDrawable.getDrawable(parambbbu.h);
            if (paramQQAppInterface != null)
            {
              localURLImageView.setImageDrawable(paramQQAppInterface);
              localURLImageView.setVisibility(0);
            }
          }
          if (!TextUtils.isEmpty(parambbbu.j)) {
            parambbbu = parambbbu.j;
          } else {
            parambbbu = "#4B94EA";
          }
        }
      }
    }
  }
  
  private static void a(bbbu parambbbu, boolean paramBoolean, QQAppInterface paramQQAppInterface, Resources paramResources, View paramView)
  {
    if ((paramQQAppInterface == null) || (parambbbu == null) || (paramResources == null) || (paramView == null)) {}
    TextView localTextView;
    FrameLayout localFrameLayout;
    do
    {
      return;
      localTextView = (TextView)paramView.findViewById(2131376527);
      localFrameLayout = (FrameLayout)paramView.findViewById(2131376521);
      paramView = (URLImageView)paramView.findViewById(2131376522);
    } while ((localTextView == null) || (localFrameLayout == null) || (paramView == null));
    if (ThemeUtil.isInNightMode(paramQQAppInterface))
    {
      if (Build.VERSION.SDK_INT >= 16) {
        localFrameLayout.setBackground(paramResources.getDrawable(2130839458));
      }
      paramView.setVisibility(8);
      localTextView.setTextColor(paramResources.getColorStateList(2131167033));
      return;
    }
    if (!TextUtils.isEmpty(parambbbu.g))
    {
      paramQQAppInterface = URLDrawable.getDrawable(parambbbu.g);
      if (paramQQAppInterface != null)
      {
        paramView.setImageDrawable(paramQQAppInterface);
        paramView.setVisibility(0);
      }
      if (!TextUtils.isEmpty(parambbbu.i)) {
        try
        {
          localTextView.setTextColor(Color.parseColor(parambbbu.i));
          return;
        }
        catch (Exception parambbbu)
        {
          QLog.e("TianshuRenewalsBarManager", 1, parambbbu, new Object[0]);
          return;
        }
      }
      localTextView.setTextColor(paramResources.getColorStateList(2131167033));
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      if ((!paramBoolean) || ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isSimpleDayTheme(false)))) {
        break label251;
      }
      localFrameLayout.setBackground(paramResources.getDrawable(2130839459));
    }
    for (;;)
    {
      paramView.setVisibility(8);
      localTextView.setTextColor(paramResources.getColorStateList(2131167033));
      return;
      label251:
      localFrameLayout.setBackground(paramResources.getDrawable(2130839458));
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, View paramView, bbbu parambbbu, MqqHandler paramMqqHandler, boolean paramBoolean)
  {
    if ((parambbbu == null) || (paramView == null) || (paramBaseActivity == null) || (paramMqqHandler == null)) {
      return;
    }
    Object localObject1 = (TextView)paramView.findViewById(2131376527);
    Object localObject2 = parambbbu.c;
    if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
      ((TextView)localObject1).setText((CharSequence)localObject2);
    }
    localObject1 = (URLImageView)paramView.findViewById(2131376526);
    if ((localObject1 != null) && (!TextUtils.isEmpty(parambbbu.e)))
    {
      localObject2 = URLDrawable.getDrawable(parambbbu.e);
      if (localObject2 != null) {
        ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
      }
    }
    localObject1 = (TextView)paramView.findViewById(2131376523);
    if ((localObject1 != null) && (!TextUtils.isEmpty(parambbbu.f))) {
      ((TextView)localObject1).setText(parambbbu.f);
    }
    paramView.setVisibility(0);
    localObject2 = (QQAppInterface)paramBaseActivity.getAppRuntime();
    a((QQAppInterface)localObject2, 101, parambbbu.a, parambbbu.b);
    localObject1 = new bmlg(paramMqqHandler, (QQAppInterface)localObject2, parambbbu);
    paramMqqHandler = new bmlh(parambbbu, paramBaseActivity, paramMqqHandler, (QQAppInterface)localObject2);
    localObject2 = (FrameLayout)paramView.findViewById(2131376521);
    if (localObject2 != null) {
      ((FrameLayout)localObject2).setOnClickListener(paramMqqHandler);
    }
    paramMqqHandler = (Button)paramView.findViewById(2131376525);
    if (paramMqqHandler != null) {
      paramMqqHandler.setOnClickListener((View.OnClickListener)localObject1);
    }
    a(paramBaseActivity, paramView, parambbbu, paramBoolean);
  }
  
  public static void a(BaseActivity paramBaseActivity, View paramView, bbbu parambbbu, boolean paramBoolean)
  {
    if ((paramView == null) || (parambbbu == null) || (paramBaseActivity == null)) {}
    while (paramView.getVisibility() != 0) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)paramBaseActivity.getAppRuntime();
    a(parambbbu, paramBoolean, localQQAppInterface, paramBaseActivity.getResources(), paramView);
    a(parambbbu, localQQAppInterface, paramView);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    TianShuReportData localTianShuReportData = new TianShuReportData();
    long l = System.currentTimeMillis() / 1000L;
    localTianShuReportData.mTraceId = (String.valueOf(paramQQAppInterface.getCurrentAccountUin()) + '_' + l);
    localTianShuReportData.mActionId = paramInt;
    localTianShuReportData.mActionValue = 1;
    localTianShuReportData.mItemId = String.valueOf(paramString1);
    localTianShuReportData.mOperTime = l;
    localTianShuReportData.mTraceNum = 1;
    localTianShuReportData.mAppId = "tianshu.47";
    localTianShuReportData.mModuleId = "";
    localTianShuReportData.mTriggerInfo = paramString2;
    TianShuManager.getInstance().report(localTianShuReportData);
    QLog.d("TianshuRenewalsBarManager", 1, "report actionId :" + paramInt + ", adId :" + paramString1);
  }
  
  private void a(TianShuAccess.GetAdsRsp paramGetAdsRsp, String paramString)
  {
    Object localObject = this.a;
    if ((localObject == null) || (((Conversation)localObject).a == null)) {}
    for (;;)
    {
      return;
      if (((Conversation)localObject).a.a(26) == 2) {}
      for (int i = 1; (i != 0) && ("tianshu_req_renewals_type_pull_down".equals(paramString)); i = 0)
      {
        aldh.a((Conversation)localObject);
        return;
      }
      if (paramGetAdsRsp.mapAds.has()) {}
      for (paramGetAdsRsp = paramGetAdsRsp.mapAds.get(); paramGetAdsRsp != null; paramGetAdsRsp = null)
      {
        paramString = new HashMap();
        paramGetAdsRsp = paramGetAdsRsp.iterator();
        while (paramGetAdsRsp.hasNext())
        {
          localObject = (TianShuAccess.RspEntry)paramGetAdsRsp.next();
          if ((localObject != null) && (((TianShuAccess.RspEntry)localObject).key.has())) {
            paramString.put(Integer.valueOf(((TianShuAccess.RspEntry)localObject).key.get()), localObject);
          }
        }
      }
    }
    a((TianShuAccess.RspEntry)paramString.get(Integer.valueOf(596)));
  }
  
  private void a(TianShuAccess.RspEntry paramRspEntry)
  {
    if ((paramRspEntry == null) || (paramRspEntry.value == null) || (paramRspEntry.value.lst.size() < 1)) {}
    do
    {
      return;
      paramRspEntry = (TianShuAccess.AdItem)paramRspEntry.value.lst.get(0);
    } while (paramRspEntry == null);
    TianShuManager.getInstance().cacheTraceInfo(paramRspEntry);
    a(this.a, paramRspEntry);
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(Conversation paramConversation, TianShuAccess.AdItem paramAdItem)
  {
    if ((paramAdItem == null) || (paramAdItem.argList.size() < 1)) {}
    Object localObject;
    do
    {
      return;
      HashMap localHashMap = new HashMap();
      localObject = paramAdItem.argList.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        TianShuAccess.MapEntry localMapEntry = (TianShuAccess.MapEntry)((Iterator)localObject).next();
        localHashMap.put(localMapEntry.key.get(), localMapEntry.value.get());
      }
      localObject = new bbbu();
      ((bbbu)localObject).a = (paramAdItem.iAdId.get() + "");
      ((bbbu)localObject).b = paramAdItem.traceinfo.get();
      ((bbbu)localObject).c = ((String)localHashMap.get("text_content"));
      ((bbbu)localObject).d = ((String)localHashMap.get("url"));
      ((bbbu)localObject).e = ((String)localHashMap.get("pic_icon"));
      ((bbbu)localObject).k = ((String)localHashMap.get("url_type"));
      ((bbbu)localObject).f = ((String)localHashMap.get("text_button"));
      ((bbbu)localObject).g = ((String)localHashMap.get("pic_bg"));
      ((bbbu)localObject).h = ((String)localHashMap.get("pic_button"));
      ((bbbu)localObject).i = ((String)localHashMap.get("color_content"));
      ((bbbu)localObject).j = ((String)localHashMap.get("color_button"));
    } while ((TextUtils.isEmpty(((bbbu)localObject).c)) || (TextUtils.isEmpty(((bbbu)localObject).d)) || (TextUtils.isEmpty(((bbbu)localObject).f)) || (TextUtils.isEmpty(((bbbu)localObject).e)));
    aldh.a(paramConversation, (bbbu)localObject);
  }
  
  public void a(String paramString)
  {
    TianShuManager.getInstance().requestAdv(a(), new bmli(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmlf
 * JD-Core Version:    0.7.0.1
 */