package com.tencent.biz.pubaccount.api;

import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import org.json.JSONArray;

@QAPI(process={"all"})
public abstract interface IPublicAccountConfigAttr
  extends QRouteApi
{
  public static final String BACK_COLOR = "background_color";
  public static final String CARD_STYLE = "card_style";
  public static final String CERT_DESP = "certified_description";
  public static final String CERT_ENT = "certified_enterprise";
  public static final String CERT_WX = "certified_weixin";
  public static final String CONFIG_ATTR = "config_arr";
  public static final String CUSTOM_ATTR = "custom_arr";
  public static final int CardStyle_Default = 0;
  public static final int CardStyle_FullScree = 1;
  public static final String FULLSCREEN_ATTR = "fullscreen_arr";
  public static final int LAYOUT_BANNER = 2;
  public static final int LAYOUT_HORIZONTAL = 1;
  public static final int LAYOUT_JIGSAW = 4;
  public static final int LAYOUT_ScreenGIF = 6;
  public static final int LAYOUT_ScreenStaticPic = 5;
  public static final int LAYOUT_VERTICAL = 0;
  public static final int LAYOUT_WINDOW = 3;
  public static final int Layout_ScreenVideo = 7;
  
  public abstract List<IPublicAccountConfigAttr> castToPaConfigAttrs(List<mobileqq_mp.ConfigGroupInfo> paramList);
  
  public abstract List<IPublicAccountConfigAttr.PaConfigInfo> getConfigs();
  
  public abstract int getType();
  
  public abstract List<IPublicAccountConfigAttr> parser(JSONArray paramJSONArray);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr
 * JD-Core Version:    0.7.0.1
 */