package com.tencent.biz.pubaccount.readinjoy.view;

import alud;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.logic.KandianFavoriteBroadcastReceiver;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import nrt;
import ohq;
import olt;
import olw;
import oop;
import oot;
import opy;
import org.json.JSONObject;
import ors;
import osk;
import otd;
import owy;
import oxb;
import pej;
import pem;
import put;
import rsj;
import rsl;
import rsm;
import rsn;
import rso;
import scl;
import sdn;
import zfy;

public class ReadInJoyFastWebBottomSocialViewNew
  extends FrameLayout
{
  public static final String a;
  public static final String b;
  private int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  private KandianFavoriteBroadcastReceiver jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private FastWebActivity jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity;
  private TemplateBean jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private oop jdField_a_of_type_Oop;
  pem jdField_a_of_type_Pem = new rsn(this);
  private zfy jdField_a_of_type_Zfy;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = alud.a(2131713226);
    jdField_b_of_type_JavaLangString = alud.a(2131713416);
  }
  
  public ReadInJoyFastWebBottomSocialViewNew(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public ReadInJoyFastWebBottomSocialViewNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new put();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramActivity);
    opy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "native_article");
  }
  
  private void a(Activity paramActivity, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    olt.a(paramActivity, paramArticleInfo, null, 4, "", null, false, null, -1);
    String str = new olw(paramArticleInfo, null).a(1).a();
    nrt.a(ors.a(), olt.a(paramArticleInfo), "0X800900C", "0X800900C", 0, 0, String.valueOf(paramArticleInfo.mArticleID), String.valueOf(paramArticleInfo.mStrategyId), paramArticleInfo.innerUniqueID, str, false);
    int i = (int)paramArticleInfo.mChannelID;
    if (paramFastWebArticleInfo.c()) {}
    for (paramFastWebArticleInfo = "2";; paramFastWebArticleInfo = "1")
    {
      sdn.a(paramArticleInfo, "0X8008990", ors.a(paramActivity, paramArticleInfo, i, paramFastWebArticleInfo).toString());
      return;
    }
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver = new KandianFavoriteBroadcastReceiver(this.jdField_a_of_type_Pem);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.process.fav");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver, (IntentFilter)localObject);
    }
    Object localObject = new ArrayList();
    ((List)localObject).add(paramArticleInfo.innerUniqueID);
    pej.a().a((List)localObject, this.jdField_a_of_type_Pem);
  }
  
  private void a(FastWebActivity paramFastWebActivity, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramFastWebActivity == null) || (paramArticleInfo == null) || (paramFastWebArticleInfo == null) || (a(paramFastWebActivity, paramArticleInfo, new rsl(this, paramFastWebActivity, paramArticleInfo, paramFastWebArticleInfo)))) {
      return;
    }
    a(paramFastWebActivity, paramArticleInfo, paramFastWebArticleInfo);
  }
  
  private void a(FastWebActivity paramFastWebActivity, FastWebArticleInfo paramFastWebArticleInfo)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
    }
    ArticleInfo localArticleInfo1;
    FastWebActivity localFastWebActivity;
    ArticleInfo localArticleInfo2;
    int i;
    if ((paramFastWebActivity != null) && (paramFastWebArticleInfo != null))
    {
      if (ohq.b() != 1) {
        break label109;
      }
      paramFastWebActivity.a(18, 0, bool);
      localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localFastWebActivity = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity;
      localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      i = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (!paramFastWebArticleInfo.c()) {
        break label115;
      }
    }
    label109:
    label115:
    for (paramFastWebActivity = "2";; paramFastWebActivity = "1")
    {
      sdn.a(localArticleInfo1, "0X8008991", ors.a(localFastWebActivity, localArticleInfo2, i, paramFastWebActivity, 0).toString());
      return;
      bool = false;
      break;
    }
  }
  
  private void a(ProteusItemData paramProteusItemData, FastWebActivity paramFastWebActivity, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (!a()) {
      return;
    }
    ViewBase localViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView();
    ViewFactory.findClickableViewListener(localViewBase, new rsj(this, paramProteusItemData, paramFastWebActivity));
    a(localViewBase, paramFastWebActivity, paramFastWebArticleInfo);
  }
  
  private void a(ViewBase paramViewBase, FastWebActivity paramFastWebActivity, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramViewBase == null) {}
    do
    {
      do
      {
        return;
        paramViewBase = paramViewBase.findViewBaseByName("id_biu");
      } while (paramViewBase == null);
      paramViewBase = paramViewBase.getNativeView();
    } while (paramViewBase == null);
    paramViewBase.setOnLongClickListener(new rso(this, paramFastWebActivity, paramFastWebArticleInfo));
  }
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.bindData(paramJSONObject);
      opy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.getViewBean());
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "refresh error!  msg=" + paramJSONObject);
    }
  }
  
  private boolean a()
  {
    String str = "";
    boolean bool;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer == null)
    {
      bool = false;
      str = "" + "mContentView is null!";
    }
    for (;;)
    {
      if (!bool) {
        QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "isParamsValidity error!  msg=" + str);
      }
      return bool;
      bool = true;
    }
  }
  
  private boolean a(FastWebActivity paramFastWebActivity, ArticleInfo paramArticleInfo, oot paramoot)
  {
    if (this.jdField_a_of_type_Oop == null) {
      this.jdField_a_of_type_Oop = new oop(paramFastWebActivity, paramArticleInfo);
    }
    if ((!this.jdField_a_of_type_Oop.a(paramArticleInfo.innerUniqueID)) && (otd.b()))
    {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        this.jdField_a_of_type_AndroidViewView = ((ViewStub)paramFastWebActivity.findViewById(2131375303)).inflate();
      }
      this.jdField_a_of_type_Oop.a(new rsm(this, paramoot));
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_Oop.a(paramArticleInfo);
      this.jdField_a_of_type_Oop.a(paramFastWebActivity.getWindow().getDecorView());
      return true;
    }
    return false;
  }
  
  private void b(FastWebActivity paramFastWebActivity, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramFastWebActivity != null) && (paramArticleInfo != null))
    {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "enter scroll");
      paramFastWebActivity.c();
      int i = (int)paramArticleInfo.mChannelID;
      if (paramFastWebArticleInfo.c()) {}
      for (paramFastWebArticleInfo = "2";; paramFastWebArticleInfo = "1")
      {
        sdn.a(paramArticleInfo, "0X8008990", ors.a(paramFastWebActivity, paramArticleInfo, i, paramFastWebArticleInfo).toString());
        return;
      }
    }
    if ("scroll to history location failed cuz activity or articleinfo is null" + paramFastWebActivity == null) {}
    for (paramFastWebActivity = "activity is null";; paramFastWebActivity = "")
    {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, paramFastWebActivity);
      return;
    }
  }
  
  private void c() {}
  
  private void c(FastWebActivity paramFastWebActivity, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramFastWebArticleInfo == null)
    {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 2, "like click event failed");
      return;
    }
    if (paramFastWebArticleInfo.jdField_a_of_type_Boolean)
    {
      paramFastWebArticleInfo.jdField_a_of_type_Boolean = false;
      paramFastWebArticleInfo.jdField_a_of_type_Int -= 1;
      sdn.b(paramArticleInfo, "0X8009765", "1");
    }
    for (;;)
    {
      d();
      a(paramFastWebArticleInfo.jdField_a_of_type_Int);
      oxb.a().d();
      owy.a().a(ors.a(), paramFastWebArticleInfo.jdField_a_of_type_Boolean, paramFastWebArticleInfo);
      return;
      paramFastWebArticleInfo.jdField_a_of_type_Boolean = true;
      paramFastWebArticleInfo.jdField_a_of_type_Int += 1;
      sdn.b(paramArticleInfo, "0X8009764", "1");
    }
  }
  
  private void d() {}
  
  private void d(FastWebActivity paramFastWebActivity, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
    }
    osk.c(paramArticleInfo.innerUniqueID);
    int i;
    if ((paramFastWebActivity != null) && (paramArticleInfo != null))
    {
      if (ohq.a() != 1) {
        break label94;
      }
      paramFastWebActivity.a(18, 0, bool);
      i = (int)paramArticleInfo.mChannelID;
      if (!paramFastWebArticleInfo.c()) {
        break label100;
      }
    }
    label94:
    label100:
    for (paramFastWebArticleInfo = "2";; paramFastWebArticleInfo = "1")
    {
      sdn.a(paramArticleInfo, "0X8008991", ors.a(paramFastWebActivity, paramArticleInfo, i, paramFastWebArticleInfo, 0).toString());
      return;
      bool = false;
      break;
    }
  }
  
  private void e() {}
  
  private void e(FastWebActivity paramFastWebActivity, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    i = 1;
    if ((paramArticleInfo == null) || (paramFastWebActivity == null) || ((!(paramFastWebActivity instanceof Activity)) && (paramFastWebArticleInfo != null)))
    {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "setFavoriteArticle but articleInfo is null.");
      return;
    }
    if (!paramFastWebArticleInfo.c) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      paramFastWebArticleInfo.a(this.jdField_b_of_type_Boolean);
      bool = paramFastWebArticleInfo.c;
      if (bool)
      {
        pej.a();
        pej.a(paramFastWebActivity, false);
      }
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, new Object[] { "setFavoriteArticle, isFavorite = ", Boolean.valueOf(bool) });
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "waiting for favorite result now, do not request again.");
      return;
    }
    if (bool)
    {
      if (this.jdField_a_of_type_Zfy != null) {
        this.jdField_a_of_type_Zfy.c();
      }
      this.jdField_a_of_type_Zfy = new zfy((QQAppInterface)ors.a(), paramFastWebActivity);
      this.jdField_a_of_type_Zfy.a(paramArticleInfo);
      this.jdField_a_of_type_Zfy.a(paramArticleInfo.mArticleContentUrl, 9, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new ReadInJoyFastWebBottomSocialViewNew.4(this), 3000L);
      try
      {
        paramFastWebActivity = new JSONObject();
        if (!bool) {
          break;
        }
      }
      catch (Exception paramFastWebActivity)
      {
        for (;;)
        {
          continue;
          i = 0;
        }
      }
      paramFastWebActivity.put("status", i);
      paramFastWebActivity.put("rowkey", paramArticleInfo.innerUniqueID);
      nrt.a(null, "", "0X8009D0F", "0X8009D0F", 0, 0, "", paramArticleInfo.mArticleID + "", "", paramFastWebActivity.toString(), false);
      oxb.a().d();
      return;
      paramFastWebArticleInfo = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      pej.a().a(paramFastWebActivity, paramFastWebArticleInfo.getAccount(), 1, paramArticleInfo.innerUniqueID, (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramArticleInfo.innerUniqueID));
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver);
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(long paramLong)
  {
    oxb.a().d();
  }
  
  public void a(FastWebActivity paramFastWebActivity, FastWebArticleInfo paramFastWebArticleInfo, ArticleInfo paramArticleInfo)
  {
    setData(paramFastWebActivity, paramFastWebArticleInfo, paramArticleInfo);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b() {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    e();
  }
  
  public void setData(FastWebActivity paramFastWebActivity, FastWebArticleInfo paramFastWebArticleInfo, ArticleInfo paramArticleInfo)
  {
    if ((paramFastWebActivity == null) || (paramFastWebArticleInfo == null) || (paramArticleInfo == null))
    {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "setData error!  params is null!");
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity = paramFastWebActivity;
    ProteusItemData localProteusItemData = scl.a(paramArticleInfo, paramFastWebArticleInfo);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null) {
      a(paramFastWebActivity);
    }
    int i;
    if (paramFastWebArticleInfo.b()) {
      i = 0;
    }
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_Int == -1) || (i != this.jdField_a_of_type_Int))
        {
          removeAllViews();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = localProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean);
          addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer);
          if (!paramFastWebArticleInfo.b()) {
            continue;
          }
          i = 0;
          this.jdField_a_of_type_Int = i;
        }
      }
      catch (Exception localException)
      {
        QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "setData error!  msg=" + localException);
        continue;
      }
      if (!a()) {
        break;
      }
      a(localProteusItemData.c);
      a(localProteusItemData, paramFastWebActivity, paramFastWebArticleInfo);
      a(paramArticleInfo);
      setVisibility(0);
      return;
      i = 1;
      continue;
      i = 1;
    }
  }
  
  public void setFavoriteArticle(FastWebActivity paramFastWebActivity, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    e(paramFastWebActivity, paramArticleInfo, paramFastWebArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew
 * JD-Core Version:    0.7.0.1
 */