package com.tencent.biz.pubaccount.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPublicAccountBrowser
  extends QRouteApi
{
  public static final int CALL_FROM_SUBSCRIPT_FULL_RECOMMEND = 1001;
  public static final String GAME_URL = "http://browserApp.p.qq.com/";
  public static final String H5_TYPE_READ_IN_JOY = "h5_type_read_in_joy";
  public static final String KEY_BACK_TEXT = "assignBackText";
  public static final String KEY_CALL_FROM = "call_from";
  public static final String KEY_FINISH_ANIMATION_OUT_TO_BOTTOM = "public_account_finish_animation_out_to_bottom";
  public static final String KEY_HIDE_NAVBAR = "hide_operation_bar";
  public static final String KEY_HIDE_SHARE_BUTTON = "hideRightButton";
  public static final String KEY_IS_PUBLIC_ACCOUNT = "is_public_account";
  public static final String KEY_MSGID = "msg_id";
  public static final String KEY_MSG_SWITCH_BTN = "switch_msg_btn";
  public static final String KEY_PUB_UIN = "puin";
  public static final String KEY_PUB_UIN_NAME = "puin_name";
  public static final String KEY_PUB_UIN_TYPE = "puin_type";
  public static final String KEY_SLIDE_RIGHT_BACK_ENABLE = "KEY_SLIDE_RIGHT_BACK_ENABLE";
  public static final String KEY_SOURCE_NAME = "source_name";
  public static final String KEY_UIN = "uin";
  public static final String KEY_UIN_NAME = "uin_name";
  public static final String KEY_UIN_TYPE = "uin_type";
  public static final String KEY_URL = "url";
  public static final String PUB_COUPON_UIN = "2632129500";
  public static final String ROUTE_NAME = "/pubaccount/browser";
  public static final String SCHEME_ANDROID_PUBLIC_ACCOUNT_DETAIL = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=%s";
  public static final String SCHEME_IOS_PUBLIC_ACCOUNT_DETAIL = "mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1";
  public static final String SHARE_SRC_ICON = "https://url.cn/JS8oE7";
  
  public abstract String getPubUin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.IPublicAccountBrowser
 * JD-Core Version:    0.7.0.1
 */