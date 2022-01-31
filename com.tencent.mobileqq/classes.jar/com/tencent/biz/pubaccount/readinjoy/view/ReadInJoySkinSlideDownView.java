package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import ayay;
import aybb;
import aybc;
import aybq;
import bbjn;
import bhvh;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import noo;
import onr;
import org.json.JSONException;
import pzc;
import rfi;
import rfj;
import rfk;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import yxy;

public class ReadInJoySkinSlideDownView
  extends RelativeLayout
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  public MediaPlayer a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ViewTreeObserver jdField_a_of_type_AndroidViewViewTreeObserver;
  private aybc jdField_a_of_type_Aybc;
  public SpriteNativeView a;
  private String jdField_a_of_type_JavaLangString;
  protected boolean a;
  private int jdField_b_of_type_Int;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  public ReadInJoySkinSlideDownView(int paramInt1, Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt2, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener3;
    LayoutInflater.from(getContext()).inflate(2131562311, this);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView = ((SpriteNativeView)findViewById(2131376251));
    setClickable(true);
    this.jdField_a_of_type_AndroidViewViewTreeObserver = getViewTreeObserver();
    this.jdField_a_of_type_AndroidViewViewTreeObserver.addOnGlobalLayoutListener(this);
  }
  
  private void a(int paramInt, Context paramContext, String paramString1, String paramString2, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    new aybq().a(paramString2).a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView.getWidth()).a(new rfk(this, paramOnClickListener1, paramString1, paramInt, paramString2, paramContext, paramOnClickListener2)).a(new rfj(this)).a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView, new rfi(this));
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    Object localObject2;
    Object localObject3;
    if ((localObject1 instanceof BaseActivity))
    {
      bbjn.u((Context)localObject1, ((BaseActivity)localObject1).getCurrentAccountUin());
      localObject2 = (BaseActivity)localObject1;
      localObject3 = (pzc)((BaseActivity)localObject2).app.getManager(270);
      localObject1 = ((pzc)localObject3).a();
      localObject2 = ((pzc)localObject3).a((Context)localObject2, 0);
      localObject3 = new onr();
    }
    for (;;)
    {
      try
      {
        ((onr)localObject3).b().c().a(paramInt1).e().f().g().h().d(0).e(2).a();
        if (TextUtils.isEmpty(paramString)) {}
        ((onr)localObject3).a("jump_url", paramString);
        ((onr)localObject3).a("guide_id", (String)localObject1);
        ((onr)localObject3).a("jump_url_type", paramInt2);
        if ((localObject2 == null) || (!((RefreshData)localObject2).isAD)) {
          continue;
        }
        paramInt1 = 1;
        ((onr)localObject3).a("ad_page", paramInt1);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        continue;
      }
      noo.a(null, "CliOper", "", "", "0X800969C", "0X800969C", 0, 0, bhvh.a("default_feeds_proteus_offline_bid"), "", "", ((onr)localObject3).a(), false);
      if ((localObject2 != null) && (((RefreshData)localObject2).isAD) && (((RefreshData)localObject2).adClickReports != null) && (((RefreshData)localObject2).adClickReports.size() > 0)) {}
      try
      {
        paramString = new qq_ad_get.QQAdGetRsp.AdInfo();
        long l = ((RefreshData)localObject2).adId.longValue();
        paramString.report_info.trace_info.aid.set(l);
        paramString.report_info.thirdparty_monitor_urls.api_click_monitor_url.set(((RefreshData)localObject2).getUrls(((RefreshData)localObject2).adClickReports));
        yxy.a(1, 1, paramString);
        return;
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
      }
      paramInt1 = 0;
    }
  }
  
  public String a()
  {
    Iterator localIterator = this.jdField_a_of_type_Aybc.a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ayay)localIterator.next();
      if ((localObject instanceof aybb))
      {
        localObject = ((aybb)localObject).a();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals("close")) && (!((String)localObject).equals("open_sound")) && (!((String)localObject).equals("use_skin"))) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView.d();
    }
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      if (this.jdField_a_of_type_AndroidViewViewTreeObserver != null)
      {
        if (Build.VERSION.SDK_INT >= 16)
        {
          if (this.jdField_a_of_type_AndroidViewViewTreeObserver.isAlive()) {
            this.jdField_a_of_type_AndroidViewViewTreeObserver.removeOnGlobalLayoutListener(this);
          }
          this.jdField_a_of_type_AndroidViewViewTreeObserver = null;
        }
      }
      else {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("ReadInJoySkinSlideDownView", 2, QLog.getStackTraceString(localException));
          continue;
          if (this.jdField_a_of_type_AndroidViewViewTreeObserver.isAlive()) {
            this.jdField_a_of_type_AndroidViewViewTreeObserver.removeGlobalOnLayoutListener(this);
          }
        }
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(0);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView.b();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoySkinSlideDownView", 2, QLog.getStackTraceString(localException));
        }
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView.c();
  }
  
  public void onGlobalLayout()
  {
    if ((this.jdField_b_of_type_Boolean) || (getWidth() <= 0) || (getHeight() <= 0)) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    if (Build.VERSION.SDK_INT >= 16) {
      if (this.jdField_a_of_type_AndroidViewViewTreeObserver.isAlive()) {
        this.jdField_a_of_type_AndroidViewViewTreeObserver.removeOnGlobalLayoutListener(this);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewTreeObserver = null;
      a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_b_of_type_AndroidViewView$OnClickListener);
      return;
      if (this.jdField_a_of_type_AndroidViewViewTreeObserver.isAlive()) {
        this.jdField_a_of_type_AndroidViewViewTreeObserver.removeGlobalOnLayoutListener(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinSlideDownView
 * JD-Core Version:    0.7.0.1
 */