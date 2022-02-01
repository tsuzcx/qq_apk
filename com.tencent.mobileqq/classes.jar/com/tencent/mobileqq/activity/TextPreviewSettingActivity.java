package com.tencent.mobileqq.activity;

import Override;
import aejh;
import aeji;
import almr;
import amsw;
import amtj;
import anaj;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import apeb;
import apec;
import apee;
import apfe;
import apfj;
import auem;
import auen;
import bboi;
import bfua;
import bgev;
import bgod;
import bgoe;
import bgog;
import bgoj;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.addon.DiyPendantEntity;
import com.tencent.mobileqq.addon.DiyPendantSticker;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LRULinkedHashMap;
import gb;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import nny;
import npn;

public class TextPreviewSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  bgod jdField_a_of_type_Bgod = new aeji(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  ExtensionInfo jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = null;
  private gb jdField_a_of_type_Gb;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private int e;
  private int f;
  
  private void a()
  {
    Object localObject3 = (BubbleManager)this.app.getManager(44);
    Object localObject2 = ((BubbleManager)localObject3).a(this.jdField_a_of_type_Int, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = apfe.a;
    }
    boolean bool;
    Object localObject4;
    if ((this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.equals(this.app.getAccount())))
    {
      bool = false;
      localObject2 = (TextView)findViewById(2131364028);
      if ((this.jdField_b_of_type_Int <= 0) || (localObject1 == apfe.a)) {
        break label409;
      }
      localObject4 = (HashMap)apec.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
      if ((localObject4 != null) && (((HashMap)localObject4).size() > 0))
      {
        localObject4 = ((HashMap)localObject4).values().iterator();
        do
        {
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
        } while (!((apfj)((Iterator)localObject4).next()).b.equalsIgnoreCase("static"));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject4 = (TextView)super.findViewById(2131364023);
        if (localObject4 != null) {
          ((TextView)localObject4).setText(getResources().getText(2131689953));
        }
      }
      ((apee)localObject1).a(this.app, bool, true, false, (View)localObject2, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int);
      label224:
      localObject3 = ((BubbleManager)localObject3).a(((apee)localObject1).jdField_a_of_type_Int, true);
      localObject2 = amtj.a(2131713905);
      if (bool)
      {
        i = Color.parseColor("#FFFFFF");
        label253:
        localObject1 = new File(((apee)localObject1).jdField_a_of_type_JavaLangString);
        if ((localObject3 == null) || (!((File)localObject1).exists())) {
          break label549;
        }
        localObject1 = ((apeb)localObject3).jdField_a_of_type_JavaLangString;
        i = ((apeb)localObject3).jdField_b_of_type_Int;
      }
      for (;;)
      {
        localObject2 = (TextView)findViewById(2131364024);
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setTextColor(i);
        this.jdField_a_of_type_Gb = ((gb)this.app.getManager(42));
        if (this.jdField_a_of_type_Gb != null) {}
        for (bool = this.jdField_a_of_type_Gb.jdField_a_of_type_Boolean;; bool = false)
        {
          localObject1 = (ImageView)findViewById(2131367013);
          if (this.jdField_c_of_type_Int > 0)
          {
            localObject2 = (auen)this.app.getManager(219);
            localObject3 = ((auen)localObject2).a(this.jdField_c_of_type_Int);
            if (((auem)localObject3).b != null) {
              ((ImageView)localObject1).setImageBitmap(((auem)localObject3).b);
            }
          }
          label409:
          while (!bool)
          {
            return;
            bool = true;
            break;
            ((apee)localObject1).a(this.app, bool, true, false, (View)localObject2, false);
            break label224;
            i = Color.parseColor("#808080");
            break label253;
            ThreadManagerV2.excute(new TextPreviewSettingActivity.3(this, (auen)localObject2), 64, null, true);
            return;
          }
          if (this.jdField_d_of_type_Int == -1)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo == null) {
              break label536;
            }
            this.jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.uVipFont);
            this.e = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.vipFontType;
          }
          for (;;)
          {
            localObject2 = getResources().getDrawable(2130846973);
            if (this.jdField_d_of_type_Int != 0) {
              ThreadManager.post(new TextPreviewSettingActivity.4(this), 8, null, true);
            }
            ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
            return;
            label536:
            this.jdField_d_of_type_Int = 0;
          }
        }
        label549:
        localObject1 = localObject2;
      }
    }
  }
  
  public static void a(int paramInt, QQAppInterface paramQQAppInterface, bgod parambgod)
  {
    File localFile = new File(gb.jdField_a_of_type_JavaLangString + File.separatorChar + paramInt + File.separatorChar + "fontname.png");
    Object localObject2 = bgev.a("fontAioImg");
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ((String)localObject2).replace("[id]", Integer.toString(paramInt));
    }
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("TextPreviewSettingActivity", 2, "getFontInfo fontId=" + paramInt + " will down ,file path=" + localFile.getAbsolutePath());
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("font_id", paramInt);
    localObject1 = new bgoe((String)localObject1, localFile);
    ((bgog)paramQQAppInterface.getManager(47)).a(1).a((bgoe)localObject1, parambgod, (Bundle)localObject2);
  }
  
  private void a(AppInterface paramAppInterface)
  {
    FaceDrawable localFaceDrawable;
    if (paramAppInterface != null)
    {
      localFaceDrawable = FaceDrawable.getFaceDrawable(paramAppInterface, 1, 4, this.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.isPendantValid())) {
        break label139;
      }
      paramAppInterface = ((AvatarPendantManager)paramAppInterface.getManager(46)).a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId);
      if (!bfua.a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId)) {
        break label115;
      }
      paramAppInterface = paramAppInterface.a(2, PendantInfo.g, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
    }
    for (;;)
    {
      ((ImageView)findViewById(2131367927)).setImageDrawable(localFaceDrawable);
      ((ImageView)findViewById(2131372354)).setImageDrawable(paramAppInterface);
      return;
      label115:
      paramAppInterface = paramAppInterface.a(1, PendantInfo.g, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
      continue;
      label139:
      paramAppInterface = null;
    }
  }
  
  private void b()
  {
    Intent localIntent = getIntent();
    this.jdField_a_of_type_Int = localIntent.getIntExtra("bubbleId", 0);
    this.jdField_b_of_type_Int = localIntent.getIntExtra("bubbleDiyId", 0);
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_b_of_type_Int = anaj.b(localIntent.getLongExtra("bubbleId", 0L));
    }
    this.jdField_c_of_type_Int = localIntent.getIntExtra("HiBoomId", 0);
    this.jdField_d_of_type_Int = localIntent.getIntExtra("fontId", 0);
    this.f = localIntent.getIntExtra("fontEffectId", 0);
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("real_msg_sender_uin");
    this.f = localIntent.getIntExtra("fontEffectId", 0);
  }
  
  private void c()
  {
    Object localObject1 = (bboi)this.app.getManager(12);
    int i;
    if (localObject1 != null) {
      if (((bboi)localObject1).a("100005.100006") != -1) {
        i = 1;
      }
    }
    for (;;)
    {
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.putExtra("hide_left_button", false);
      localIntent.putExtra("show_right_close_button", false);
      long l;
      label94:
      String str;
      Object localObject3;
      label160:
      label204:
      DiyPendantSticker localDiyPendantSticker;
      int j;
      int k;
      int m;
      label261:
      int n;
      if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null)
      {
        l = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId;
        str = bgev.a(this, "pendantDetail", String.valueOf(l), "mvip.gexinghua.mobile.faceaddon.client_tab_store");
        localObject2 = almr.a().a;
        localObject3 = new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append("_");
        if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo == null) {
          break label369;
        }
        localObject1 = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
        localObject1 = (DiyPendantEntity)((LRULinkedHashMap)localObject2).get(localObject1);
        if (localObject1 == null) {
          break label554;
        }
        localObject3 = new ArrayList();
        Iterator localIterator = ((DiyPendantEntity)localObject1).getStickerInfoList().iterator();
        if (!localIterator.hasNext()) {
          break label397;
        }
        localDiyPendantSticker = (DiyPendantSticker)localIterator.next();
        j = localDiyPendantSticker.type;
        k = localDiyPendantSticker.stickerId;
        m = localDiyPendantSticker.angle;
        if (!TextUtils.isEmpty(localDiyPendantSticker.text)) {
          break label377;
        }
        localObject1 = "0";
        n = localDiyPendantSticker.fontId;
        if (!TextUtils.isEmpty(localDiyPendantSticker.fontColor)) {
          break label387;
        }
      }
      label387:
      for (Object localObject2 = "0";; localObject2 = localDiyPendantSticker.fontColor)
      {
        ((List)localObject3).add(String.format("%d,%d,%d,%s,%d,%s,%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), localObject1, Integer.valueOf(n), localObject2, Integer.valueOf(localDiyPendantSticker.fontType) }));
        break label204;
        i = 0;
        break;
        l = 0L;
        break label94;
        label369:
        localObject1 = "";
        break label160;
        label377:
        localObject1 = localDiyPendantSticker.text;
        break label261;
      }
      label397:
      localObject1 = TextUtils.join(";", (Iterable)localObject3);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = URLEncoder.encode((String)localObject1);
      }
      label554:
      for (localObject1 = nny.a(str, "stickerInfo=" + (String)localObject1);; localObject1 = str)
      {
        localIntent.putExtra("url", (String)localObject1);
        localIntent.putExtra("business", 512L);
        localIntent.putExtra("individuation_url_type", 40301);
        localIntent.putExtra("isShowAd", false);
        VasWebviewUtil.openQQBrowserWithoutAD(this, (String)localObject1, 512L, localIntent, false, -1);
        localObject1 = this.jdField_a_of_type_JavaLangString;
        if (i != 0) {}
        for (i = 1;; i = 0)
        {
          VasWebviewUtil.reportCommercialDrainage((String)localObject1, "bigtextpage", "pendant_enter", "", 1, 0, i, "", String.valueOf(l), "");
          return;
        }
      }
      i = 0;
    }
  }
  
  private void d()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    Object localObject1 = (bboi)this.app.getManager(12);
    boolean bool;
    if (localObject1 != null) {
      if (((bboi)localObject1).a("100005.100003") != -1) {
        bool = true;
      }
    }
    for (;;)
    {
      localIntent.putExtra("updateFlag", bool);
      localIntent.putExtra("scrollToBubble", true);
      localIntent.putExtra("individuation_url_type", 40301);
      Object localObject2 = bgev.a(this, "bubbleDetail", String.valueOf(this.jdField_a_of_type_Int), "mvip.gongneng.android.bubble.index_dynamic_tab");
      localObject1 = apec.a();
      Object localObject4 = this.jdField_a_of_type_JavaLangString + "_" + this.jdField_b_of_type_Int;
      Object localObject3 = localObject2;
      String str;
      if (this.jdField_b_of_type_Int > 0)
      {
        str = (String)((apec)localObject1).jdField_a_of_type_JavaUtilMap.get(localObject4);
        localObject4 = (HashMap)((apec)localObject1).b.get(localObject4);
        localObject1 = localObject2;
        if (localObject4 != null)
        {
          localObject1 = localObject2;
          if (((HashMap)localObject4).size() > 0)
          {
            localObject3 = (String)((HashMap)localObject4).get("TL");
            localObject1 = localObject2;
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              localObject1 = nny.a((String)localObject2, "tl=" + (String)localObject3);
            }
            localObject3 = (String)((HashMap)localObject4).get("TR");
            localObject2 = localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              localObject2 = nny.a((String)localObject1, "tr=" + (String)localObject3);
            }
            localObject1 = (String)((HashMap)localObject4).get("BL");
            localObject3 = localObject2;
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject3 = nny.a((String)localObject2, "bl=" + (String)localObject1);
            }
            localObject2 = (String)((HashMap)localObject4).get("BR");
            localObject1 = localObject3;
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = nny.a((String)localObject3, "br=" + (String)localObject2);
            }
          }
        }
        localObject3 = localObject1;
        if (TextUtils.isEmpty(str)) {}
      }
      for (;;)
      {
        try
        {
          localObject2 = nny.a((String)localObject1, "diyText=" + URLEncoder.encode(str, "UTF-8"));
          localObject1 = localObject2;
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.i("TextPreviewSettingActivity", 2, "TextPreviewActivity bubble url: " + npn.b((String)localObject1, new String[0]));
          }
          VasWebviewUtil.openQQBrowserWithoutAD(this, (String)localObject1, 64L, localIntent, false, -1);
          localObject1 = this.jdField_a_of_type_JavaLangString;
          if (!bool) {
            break label563;
          }
          i = 1;
          VasWebviewUtil.reportCommercialDrainage((String)localObject1, "bigtextpage", "bubble_enter", "", 1, 0, i, "", String.valueOf(this.jdField_a_of_type_Int), "");
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          com.tencent.qphone.base.util.QLog.e("TextPreviewSettingActivity", 1, "URLEncoder.encode error!", localUnsupportedEncodingException);
          localObject3 = localObject1;
        }
        bool = false;
        break;
        localObject1 = localObject3;
        continue;
        label563:
        int i = 0;
      }
      bool = false;
    }
  }
  
  private void e()
  {
    if (this.jdField_c_of_type_Int > 0)
    {
      localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("fontId", this.jdField_c_of_type_Int);
      ((Intent)localObject).putExtra("fromAIO", true);
      ((Intent)localObject).putExtra("individuation_url_type", 40301);
      VasWebviewUtil.openQQBrowserWithoutAD(this, bgev.a(this, "fontDetail", String.valueOf(this.jdField_c_of_type_Int), "mvip.gexinghua.mobile.font.client_tab_store"), 4096L, (Intent)localObject, false, -1);
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "HighFont", "ClickDetail", "", 1, 0, 0, "", "" + this.jdField_c_of_type_Int, "");
      return;
    }
    Object localObject = (bboi)this.app.getManager(12);
    boolean bool;
    if (localObject != null) {
      if (((bboi)localObject).a("100005.100011") != -1) {
        bool = true;
      }
    }
    for (;;)
    {
      localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("updateFlag", bool);
      ((Intent)localObject).putExtra("fontId", this.jdField_d_of_type_Int);
      ((Intent)localObject).putExtra("fromAIO", true);
      ((Intent)localObject).putExtra("individuation_url_type", 40301);
      VasWebviewUtil.openQQBrowserWithoutAD(this, bgev.a(this, "fontDetail", String.valueOf(this.jdField_d_of_type_Int), "mvip.gexinghua.mobile.font.client_tab_store"), 4096L, (Intent)localObject, false, -1);
      localObject = this.jdField_a_of_type_JavaLangString;
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        VasWebviewUtil.reportCommercialDrainage((String)localObject, "bigtextpage", "font_enter", "", 1, 0, i, "", String.valueOf(this.jdField_d_of_type_Int), "");
        return;
        bool = false;
        break;
      }
      bool = false;
    }
  }
  
  private void f()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("individuation_url_type", 40301);
    String str2;
    String str1;
    if (this.f == 0)
    {
      str2 = bgev.a(this, "aioNoMagicFontEntrance", null);
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "https://gxh.vip.qq.com/club/zb/font_effect_detail/html/aio-font-big.html?id=[id]&_wv=1027&_wvx=3";
      }
      if (TextUtils.isEmpty(str1)) {
        break label203;
      }
      str1 = str1.replace("[id]", this.f + "");
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.i("TextPreviewSettingActivity", 2, "mFontEffectId=" + this.f + " url=" + str1);
      }
      VasWebviewUtil.openQQBrowserWithoutAD(this, str1, 0L, localIntent, false, -1);
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_JavaLangString, "bigtextpage", "font_size", "", 1, 0, 0, "", String.valueOf(this.f), "");
      return;
      str2 = bgev.a(this, "aioMagicFontEntrance", null);
      str1 = str2;
      if (!TextUtils.isEmpty(str2)) {
        break;
      }
      str1 = "https://gxh.vip.qq.com/club/zb/font_effect_detail/html/aio-font-big.html?id=[id]&_wv=16778243&_wvx=3";
      break;
      label203:
      com.tencent.qphone.base.util.QLog.e("TextPreviewSettingActivity", 2, "url is empty.");
    }
  }
  
  void a(int paramInt)
  {
    Object localObject2 = (gb)this.app.getManager(42);
    int i = paramInt;
    if (paramInt == 0) {
      i = ((gb)localObject2).jdField_c_of_type_Int;
    }
    Object localObject1 = getResources().getDrawable(2130847064);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Object localObject3 = getResources().getDrawable(2130847064);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject3);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject3);
    switch (i)
    {
    default: 
      localObject1 = (String)getResources().getText(2131689955);
      localObject1 = getResources().getDrawable(2130847080);
    }
    for (;;)
    {
      ((ImageView)findViewById(2131370524)).setImageDrawable((Drawable)localObject1);
      return;
      localObject3 = ((gb)localObject2).h;
      try
      {
        localObject2 = URLDrawable.getDrawable(((gb)localObject2).i, localURLDrawableOptions);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        com.tencent.qphone.base.util.QLog.e("TextPreviewSettingActivity", 1, "font effect exception, " + localException.getMessage());
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      ForwardUtils.onForwardActivityResult(this.app, paramIntent, this);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131558647);
    paramBundle = getAppInterface();
    if (paramBundle == null)
    {
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("TextPreviewSettingActivity", 0, "get AppInterface failed in TextPreviewSettingActivity#doOnCreate");
      }
      return false;
    }
    b();
    this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = ((amsw)paramBundle.getManager(51)).a(this.jdField_a_of_type_JavaLangString);
    setTitle(amtj.a(2131713896));
    setContentBackgroundResource(2130838891);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131372333);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131364018);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131366995);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131370522);
    a(paramBundle);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidOsHandler = new aejh(this, Looper.getMainLooper());
    this.jdField_a_of_type_Gb = ((gb)paramBundle.getManager(42));
    a(this.f);
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a();
    Object localObject = (WebProcessManager)this.app.getManager(13);
    if (localObject != null) {
      ((WebProcessManager)localObject).e();
    }
    localObject = apec.a();
    String str = this.jdField_a_of_type_JavaLangString + "_" + this.jdField_b_of_type_Int;
    if ((this.jdField_b_of_type_Int > 0) && ((!((apec)localObject).jdField_a_of_type_JavaUtilMap.containsKey(str)) || (!((apec)localObject).b.containsKey(str)))) {
      ThreadManager.post(new TextPreviewSettingActivity.2(this, (apec)localObject, str), 5, null, false);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      c();
      continue;
      d();
      continue;
      e();
      continue;
      f();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewSettingActivity
 * JD-Core Version:    0.7.0.1
 */