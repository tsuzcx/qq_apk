package com.tencent.biz.pubaccount.readinjoy.webarticle;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebArticleUtil;", "", "()V", "SP_KEY_WEBVIEW_REUSE", "", "SP_KEY_WEBVIEW_TRANS_ANIMATION", "SP_KEY_WEBVIEW_VAS_SONIC", "SP_KEY_WEBVIEW_WARMUP_TEMPLATE", "SP_KEY_WEB_ARTICLE_PRELOAD", "SP_KEY_WEB_ARTICLE_SWITCH", "SP_KEY_WEB_DATA_PRELOAD", "SP_KEY_WEB_LOAD_URL_OPTIMIZE", "SP_KEY_WEB_PROCESS_FOREGROUND_PRELOAD", "TAG", "init", "", "isSupportWebArticle", "", "isSupportWebArticlePreload", "isSupportWebDataPreload", "isSupportWebLoadUrlOptimize", "isSupportWebProcessForegroundPreload", "isSupportWebViewAnimation", "isSupportWebViewReuse", "isSupportWebViewVasSonic", "isSupportWebViewWarmUpTemplate", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJWebArticleUtil
{
  public static final RIJWebArticleUtil a = new RIJWebArticleUtil();
  
  public final void a()
  {
    boolean bool9 = false;
    ReadInJoyHelper.f();
    AladdinConfig localAladdinConfig = Aladdin.getConfig(378);
    boolean bool1;
    label35:
    label49:
    boolean bool2;
    label56:
    label70:
    boolean bool3;
    label78:
    label92:
    boolean bool4;
    label100:
    label114:
    boolean bool5;
    label122:
    boolean bool6;
    label136:
    label144:
    label158:
    boolean bool7;
    label166:
    label180:
    boolean bool8;
    if (localAladdinConfig != null)
    {
      i = localAladdinConfig.getIntegerFromString("web_article_switch", 0);
      if (i != 1) {
        break label453;
      }
      bool1 = true;
      if (localAladdinConfig == null) {
        break label458;
      }
      i = localAladdinConfig.getIntegerFromString("webview_reuse", 0);
      if (i != 1) {
        break label463;
      }
      bool2 = true;
      if (localAladdinConfig == null) {
        break label468;
      }
      i = localAladdinConfig.getIntegerFromString("webview_vas_sonic", 0);
      if (i != 1) {
        break label473;
      }
      bool3 = true;
      if (localAladdinConfig == null) {
        break label479;
      }
      i = localAladdinConfig.getIntegerFromString("webview_transition_animation", 0);
      if (i != 1) {
        break label484;
      }
      bool4 = true;
      if (localAladdinConfig == null) {
        break label490;
      }
      i = localAladdinConfig.getIntegerFromString("web_article_preload", 0);
      if (i != 1) {
        break label495;
      }
      bool5 = true;
      if (localAladdinConfig == null) {
        break label501;
      }
      i = localAladdinConfig.getIntegerFromString("webview_warmup_template", 0);
      if (i != 1) {
        break label506;
      }
      bool6 = true;
      if (localAladdinConfig == null) {
        break label512;
      }
      i = localAladdinConfig.getIntegerFromString("web_data_preload", 0);
      if (i != 1) {
        break label517;
      }
      bool7 = true;
      if (localAladdinConfig == null) {
        break label523;
      }
      i = localAladdinConfig.getIntegerFromString("web_process_foreground_preload", 0);
      if (i != 1) {
        break label528;
      }
      bool8 = true;
      label188:
      if (localAladdinConfig == null) {
        break label534;
      }
    }
    label512:
    label517:
    label523:
    label528:
    label534:
    for (int i = localAladdinConfig.getIntegerFromString("web_load_url_optimize", 1);; i = 1)
    {
      if (i == 1) {
        bool9 = true;
      }
      QLog.i("RIJWebArticleUtil", 1, "[init] webArticleConfig = { " + "webArticleSwitch = " + bool1 + ", " + "webViewReuse = " + bool2 + ", " + "webViewVasSonic = " + bool3 + ", " + "webViewTransitionAnimation = " + bool4 + ", " + "webArticlePreload = " + bool5 + ", " + "webViewWarmUpTemplate = " + bool6 + ", " + "webDataPreload = " + bool7 + ", " + "webProcessForegroundPreload = " + bool8 + "webLoadUrlOptimize = " + bool9 + " }");
      ReadInJoyHelper.a("sp_key_web_article_switch", Boolean.valueOf(bool1));
      ReadInJoyHelper.a("sp_key_webview_reuse", Boolean.valueOf(bool2));
      ReadInJoyHelper.a("sp_key_webview_sonic", Boolean.valueOf(bool3));
      ReadInJoyHelper.a("sp_key_webview_trans_animation", Boolean.valueOf(bool4));
      ReadInJoyHelper.a("sp_key_web_article_preload", Boolean.valueOf(bool5));
      ReadInJoyHelper.a("sp_key_webview_warmup_template", Boolean.valueOf(bool6));
      ReadInJoyHelper.a("sp_key_web_data_preload", Boolean.valueOf(bool7));
      ReadInJoyHelper.a("sp_key_web_process_foreground_preload", Boolean.valueOf(bool8));
      ReadInJoyHelper.a("sp_key_load_url_optimize", Boolean.valueOf(bool9));
      return;
      i = 0;
      break;
      label453:
      bool1 = false;
      break label35;
      label458:
      i = 0;
      break label49;
      label463:
      bool2 = false;
      break label56;
      label468:
      i = 0;
      break label70;
      label473:
      bool3 = false;
      break label78;
      label479:
      i = 0;
      break label92;
      label484:
      bool4 = false;
      break label100;
      label490:
      i = 0;
      break label114;
      label495:
      bool5 = false;
      break label122;
      label501:
      i = 0;
      break label136;
      label506:
      bool6 = false;
      break label144;
      i = 0;
      break label158;
      bool7 = false;
      break label166;
      i = 0;
      break label180;
      bool8 = false;
      break label188;
    }
  }
  
  public final boolean a()
  {
    Object localObject = ReadInJoyHelper.a("sp_key_web_article_switch", Boolean.valueOf(false));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyHelper.getReadI…EB_ARTICLE_SWITCH, false)");
    return ((Boolean)localObject).booleanValue();
  }
  
  public final boolean b()
  {
    Object localObject = ReadInJoyHelper.a("sp_key_webview_reuse", Boolean.valueOf(false));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyHelper.getReadI…KEY_WEBVIEW_REUSE, false)");
    return ((Boolean)localObject).booleanValue();
  }
  
  public final boolean c()
  {
    Object localObject = ReadInJoyHelper.a("sp_key_webview_sonic", Boolean.valueOf(false));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyHelper.getReadI…WEBVIEW_VAS_SONIC, false)");
    return ((Boolean)localObject).booleanValue();
  }
  
  public final boolean d()
  {
    Object localObject = ReadInJoyHelper.a("sp_key_webview_trans_animation", Boolean.valueOf(false));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyHelper.getReadI…W_TRANS_ANIMATION, false)");
    return ((Boolean)localObject).booleanValue();
  }
  
  public final boolean e()
  {
    Object localObject = ReadInJoyHelper.a("sp_key_web_article_preload", Boolean.valueOf(false));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyHelper.getReadI…B_ARTICLE_PRELOAD, false)");
    return ((Boolean)localObject).booleanValue();
  }
  
  public final boolean f()
  {
    Object localObject = ReadInJoyHelper.a("sp_key_webview_warmup_template", Boolean.valueOf(false));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyHelper.getReadI…W_WARMUP_TEMPLATE, false)");
    return ((Boolean)localObject).booleanValue();
  }
  
  public final boolean g()
  {
    Object localObject = ReadInJoyHelper.a("sp_key_web_data_preload", Boolean.valueOf(false));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyHelper.getReadI…_WEB_DATA_PRELOAD, false)");
    return ((Boolean)localObject).booleanValue();
  }
  
  public final boolean h()
  {
    Object localObject = ReadInJoyHelper.a("sp_key_web_process_foreground_preload", Boolean.valueOf(false));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyHelper.getReadI…OREGROUND_PRELOAD, false)");
    return ((Boolean)localObject).booleanValue();
  }
  
  public final boolean i()
  {
    Object localObject = ReadInJoyHelper.a("sp_key_load_url_optimize", Boolean.valueOf(true));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyHelper.getReadI…_LOAD_URL_OPTIMIZE, true)");
    return ((Boolean)localObject).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebArticleUtil
 * JD-Core Version:    0.7.0.1
 */