package com.tencent.avgame.gamelogic.data;

import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon.GameInfo;
import trpc.qq_vgame.game_list.AvGameList.GameListItemInfo;

public class GameItem
{
  public int a;
  public long a;
  public GameInfo a;
  public String a;
  public int b;
  public long b;
  public String b;
  public long c;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  
  public GameItem()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo = new GameInfo();
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
  }
  
  protected GameItem a()
  {
    GameItem localGameItem = new GameItem();
    try
    {
      localGameItem.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localGameItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localGameItem.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localGameItem.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localGameItem.jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo = this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo;
      localGameItem.f = this.f;
      localGameItem.g = this.g;
      localGameItem.h = this.h;
      localGameItem.i = this.i;
      localGameItem.j = this.j;
      localGameItem.d = this.d;
      localGameItem.e = this.e;
      localGameItem.k = this.k;
      localGameItem.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      localGameItem.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      localGameItem.jdField_c_of_type_Long = this.jdField_c_of_type_Long;
      localGameItem.n = this.n;
      localGameItem.m = this.m;
      localGameItem.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localGameItem.l = this.l;
      localGameItem.o = this.o;
      return localGameItem;
    }
    catch (Exception localException) {}
    return localGameItem;
  }
  
  public final void a(AvGameList.GameListItemInfo paramGameListItemInfo)
  {
    this.jdField_a_of_type_Int = paramGameListItemInfo.game_type.get();
    this.jdField_a_of_type_JavaLangString = paramGameListItemInfo.game_name.get();
    this.jdField_b_of_type_JavaLangString = paramGameListItemInfo.game_desc.get();
    this.jdField_c_of_type_JavaLangString = paramGameListItemInfo.backgroup_pic_url.get();
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.a();
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.a((AvGameCommon.GameInfo)paramGameListItemInfo.game_info.get());
    this.f = paramGameListItemInfo.answer_right_pic_url.get();
    this.g = paramGameListItemInfo.answer_right_pic_url_new.get();
    this.h = paramGameListItemInfo.game_over_pic_url.get();
    this.i = paramGameListItemInfo.tips_one_line_pic_url.get();
    this.j = paramGameListItemInfo.tips_two_line_pic_url.get();
    this.d = paramGameListItemInfo.prepare_pic_url.get();
    this.e = paramGameListItemInfo.prepare_pic_tp_url.get();
    this.k = paramGameListItemInfo.music_name.get();
    this.jdField_b_of_type_Int = paramGameListItemInfo.status.get();
    this.jdField_b_of_type_Long = paramGameListItemInfo.online_time.get();
    this.jdField_c_of_type_Long = paramGameListItemInfo.offline_time.get();
    this.n = paramGameListItemInfo.prepare_wording.get();
    this.m = paramGameListItemInfo.game_name_url.get();
    this.jdField_a_of_type_Long = paramGameListItemInfo.total_player_num.get();
    this.l = paramGameListItemInfo.backgroup_small_pic_url.get();
    this.o = paramGameListItemInfo.collaborator_logo_url.get();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("type");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("|");
    localStringBuilder.append("name");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append("desc");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append("bgUrl");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append("answerRightPicUrl");
    localStringBuilder.append("=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("|");
    localStringBuilder.append("gameOverPicUrl");
    localStringBuilder.append("=");
    localStringBuilder.append(this.h);
    localStringBuilder.append("|");
    localStringBuilder.append("oneLineTipBgPicUrl");
    localStringBuilder.append("=");
    localStringBuilder.append(this.i);
    localStringBuilder.append("|");
    localStringBuilder.append("twoLinesTipBgPicUrl");
    localStringBuilder.append("=");
    localStringBuilder.append(this.j);
    localStringBuilder.append("|");
    localStringBuilder.append("preparePicUrl");
    localStringBuilder.append("=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("|");
    localStringBuilder.append("prepareAlphaPicUrl");
    localStringBuilder.append("=");
    localStringBuilder.append(this.e);
    localStringBuilder.append("|");
    localStringBuilder.append("gameBgName");
    localStringBuilder.append("=");
    localStringBuilder.append(this.k);
    localStringBuilder.append("|");
    localStringBuilder.append("onlineStatus");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("|");
    localStringBuilder.append("onlineTime");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("|");
    localStringBuilder.append("offlineTime");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append("|");
    localStringBuilder.append("prepareWording");
    localStringBuilder.append("=");
    localStringBuilder.append(this.n);
    localStringBuilder.append("|");
    localStringBuilder.append("gameNameUrl");
    localStringBuilder.append("=");
    localStringBuilder.append(this.m);
    localStringBuilder.append("|");
    localStringBuilder.append("bgSmallUrl");
    localStringBuilder.append("=");
    localStringBuilder.append(this.l);
    localStringBuilder.append("|");
    localStringBuilder.append("playerNum");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("|");
    localStringBuilder.append("collaboratorLogoUrl=");
    localStringBuilder.append(this.o);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.GameItem
 * JD-Core Version:    0.7.0.1
 */