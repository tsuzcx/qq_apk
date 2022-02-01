import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import cooperation.qzone.util.QZLog;
import cooperation.vip.manager.FileBannerTianshuManger.1;
import cooperation.vip.manager.FileBannerTianshuManger.4;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

public class blax
{
  public static int a;
  public View a;
  private ViewStub a;
  public RelativeLayout a;
  public blbv a;
  public URLImageView a;
  public TianShuAccess.AdItem a;
  public String a;
  public WeakReference<Activity> a;
  public int b;
  public View b;
  public String b;
  
  static
  {
    jdField_a_of_type_Int = 488;
  }
  
  public blax(Activity paramActivity, View paramView, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Blbv = new blay(this);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramActivity);
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return ViewUtils.getScreenWidth();
  }
  
  public void a()
  {
    ThreadManagerV2.excute(new FileBannerTianshuManger.1(this), 16, null, true);
  }
  
  public void a(TianShuAccess.AdItem paramAdItem, int paramInt)
  {
    if (paramAdItem == null)
    {
      QZLog.e("FileBannerTianshuManger", "item is  null");
      return;
    }
    int i = paramAdItem.iAdId.get();
    paramAdItem = paramAdItem.traceinfo.get();
    if (TextUtils.isEmpty(paramAdItem))
    {
      QZLog.e("FileBannerTianshuManger", "rtraceInfo is  null");
      return;
    }
    blbx localblbx = new blbx();
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localblbx.jdField_a_of_type_Int = 1;
    localblbx.jdField_e_of_type_JavaLangString = "tianshu.99";
    localblbx.jdField_f_of_type_JavaLangString = "tianshu.99";
    localblbx.g = (i + "");
    localblbx.h = "";
    localblbx.jdField_a_of_type_Long = l;
    localblbx.d = paramInt;
    localblbx.jdField_e_of_type_Int = 1;
    localblbx.jdField_f_of_type_Int = 1;
    localblbx.l = paramAdItem;
    blbw.a().a(localblbx);
    QZLog.i("FileBannerTianshuManger", "report appid" + i + "actionid" + paramInt);
  }
  
  public void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)) {}
    do
    {
      Object localObject1;
      for (;;)
      {
        return;
        try
        {
          localObject2 = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
          localObject1 = localObject2;
          if ((localObject2 instanceof BasePluginActivity)) {
            localObject1 = ((BasePluginActivity)localObject2).getOutActivity();
          }
          if ((paramString.startsWith("http")) || (paramString.startsWith("https")))
          {
            localObject2 = new Intent((Context)localObject1, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", paramString);
            ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_jc_vip");
            ((Context)localObject1).startActivity((Intent)localObject2);
            a(this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem, 102);
            if (this.jdField_b_of_type_Int != 1) {
              continue;
            }
            a(this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem, 138);
          }
        }
        catch (Exception paramString)
        {
          QZLog.e("FileBannerTianshuManger", paramString.toString());
          return;
        }
      }
      Object localObject2 = new Intent((Context)localObject1, JumpActivity.class);
      ((Intent)localObject2).setData(Uri.parse(paramString));
      ((Context)localObject1).startActivity((Intent)localObject2);
      a(this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem, 102);
    } while (this.jdField_b_of_type_Int != 1);
    a(this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem, 138);
  }
  
  public void a(String paramString, URLDrawable paramURLDrawable)
  {
    try
    {
      if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null))
      {
        QZLog.i("FileBannerTianshuManger", "showFileBanner activity is null ");
        return;
      }
      ((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).runOnUiThread(new FileBannerTianshuManger.4(this, paramURLDrawable, paramString));
      return;
    }
    catch (Exception paramString)
    {
      QZLog.e("FileBannerTianshuManger", paramString.toString());
    }
  }
  
  public void a(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("FileBannerTianshuManger", "onGetAdvs isSucc:" + paramBoolean);
    }
    if ((!paramBoolean) || (paramGetAdsRsp == null)) {
      return;
    }
    if (paramGetAdsRsp.mapAds.has()) {}
    for (paramGetAdsRsp = paramGetAdsRsp.mapAds.get(); paramGetAdsRsp == null; paramGetAdsRsp = null)
    {
      QZLog.e("FileBannerTianshuManger", "rspEntries == null");
      return;
    }
    Object localObject1 = new HashMap();
    paramGetAdsRsp = paramGetAdsRsp.iterator();
    while (paramGetAdsRsp.hasNext())
    {
      localObject2 = (TianShuAccess.RspEntry)paramGetAdsRsp.next();
      if ((localObject2 != null) && (((TianShuAccess.RspEntry)localObject2).key.has())) {
        ((Map)localObject1).put(Integer.valueOf(((TianShuAccess.RspEntry)localObject2).key.get()), localObject2);
      }
    }
    localObject1 = (TianShuAccess.RspEntry)((Map)localObject1).get(Integer.valueOf(jdField_a_of_type_Int));
    if ((localObject1 == null) || (((TianShuAccess.RspEntry)localObject1).value == null) || (((TianShuAccess.RspEntry)localObject1).value.lst.size() == 0) || (((TianShuAccess.RspEntry)localObject1).value.lst.get(0) == null) || (((TianShuAccess.AdItem)((TianShuAccess.RspEntry)localObject1).value.lst.get(0)).argList == null) || (((TianShuAccess.AdItem)((TianShuAccess.RspEntry)localObject1).value.lst.get(0)).argList.get() == null))
    {
      QZLog.e("FileBannerTianshuManger", "data is error");
      return;
    }
    Object localObject2 = ((TianShuAccess.AdItem)((TianShuAccess.RspEntry)localObject1).value.lst.get(0)).argList.get();
    paramGetAdsRsp = new HashMap();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (TianShuAccess.MapEntry)((Iterator)localObject2).next();
      String str = ((TianShuAccess.MapEntry)localObject3).key.get();
      localObject3 = ((TianShuAccess.MapEntry)localObject3).value.get();
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
        paramGetAdsRsp.put(str, localObject3);
      }
    }
    localObject1 = (TianShuAccess.AdItem)((TianShuAccess.RspEntry)localObject1).value.lst.get(0);
    this.jdField_b_of_type_JavaLangString = ((String)paramGetAdsRsp.get("pic"));
    this.jdField_a_of_type_JavaLangString = ((String)paramGetAdsRsp.get("url"));
    this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem = ((TianShuAccess.AdItem)localObject1);
    b();
  }
  
  public int b()
  {
    return (int)(a() * 0.1449275F);
  }
  
  public void b()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        URLDrawable localURLDrawable = URLDrawable.getDrawable(this.jdField_b_of_type_JavaLangString, localURLDrawableOptions);
        localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
        localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
        localURLDrawableOptions.mRequestWidth = a();
        localURLDrawableOptions.mRequestHeight = b();
        if (localURLDrawable.getStatus() == 1)
        {
          QZLog.i("FileBannerTianshuManger", "showFileBanner URLDrawable success ");
          a(this.jdField_a_of_type_JavaLangString, localURLDrawable);
          a(this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem, 101);
          if (this.jdField_b_of_type_Int != 1) {
            return;
          }
          a(this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem, 137);
          return;
        }
        localURLDrawable.setURLDrawableListener(new blaz(this));
        localURLDrawable.startDownload();
        return;
      }
      catch (Exception localException)
      {
        QZLog.e("FileBannerTianshuManger", "onGetAdvs pic erro");
        return;
      }
    } else if (QZLog.isColorLevel()) {
      QZLog.i("FileBannerTianshuManger", "onGetAdvs pic url is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blax
 * JD-Core Version:    0.7.0.1
 */