package com.tencent.av.share.api;

import android.content.Intent;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.utils.JumpAction;

@QAPI(process={"all"})
public abstract interface IShareChatApi
  extends QRouteApi
{
  public static final String GAV_ARK_APP_NAME = "com.tencent.qqavchat";
  public static final String GAV_ARK_FROM_CHATTING = "gav_ark_share_from_chatting";
  public static final String GAV_ARK_FROM_TYPE = "gav_ark_from_type";
  public static final String GAV_ARK_GROUP_ADMIN_KEY = "gav_ark_group_admin_key";
  public static final String GAV_ARK_GROUP_CARD_KEY = "gav_ark_group_card_key";
  public static final String GAV_ARK_GROUP_NAME_KEY = "gav_ark_group_name_key";
  public static final String GAV_ARK_GROUP_OWNER_KEY = "gav_ark_group_owner_key";
  public static final String GAV_ARK_GROUP_UIN_KEY = "gav_ark_group_uin_key";
  public static final String GAV_ARK_ROOM_CREATE_TIME_KEY = "gav_ark_room_create_time_key";
  public static final String GAV_ARK_ROOM_ID_KEY = "gav_ark_room_id_key";
  public static final String GAV_META_CHILD_KEY = "news";
  
  public abstract int getLinkTypeNeedVerify();
  
  public abstract int getLinkTypeNoVerify();
  
  public abstract boolean jump(JumpAction paramJumpAction);
  
  public abstract void share(BaseQQAppInterface paramBaseQQAppInterface, QBaseActivity paramQBaseActivity, View paramView, Intent paramIntent);
  
  public abstract boolean shareGAVArkMsg(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.share.api.IShareChatApi
 * JD-Core Version:    0.7.0.1
 */