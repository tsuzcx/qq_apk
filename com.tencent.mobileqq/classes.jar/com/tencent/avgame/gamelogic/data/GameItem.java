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
    localStringBuilder.append("type").append("=").append(this.jdField_a_of_type_Int).append("|");
    localStringBuilder.append("name").append("=").append(this.jdField_a_of_type_JavaLangString).append("|");
    localStringBuilder.append("desc").append("=").append(this.jdField_b_of_type_JavaLangString).append("|");
    localStringBuilder.append("bgUrl").append("=").append(this.jdField_c_of_type_JavaLangString).append("|");
    localStringBuilder.append("answerRightPicUrl").append("=").append(this.f).append("|");
    localStringBuilder.append("gameOverPicUrl").append("=").append(this.h).append("|");
    localStringBuilder.append("oneLineTipBgPicUrl").append("=").append(this.i).append("|");
    localStringBuilder.append("twoLinesTipBgPicUrl").append("=").append(this.j).append("|");
    localStringBuilder.append("preparePicUrl").append("=").append(this.d).append("|");
    localStringBuilder.append("prepareAlphaPicUrl").append("=").append(this.e).append("|");
    localStringBuilder.append("gameBgName").append("=").append(this.k).append("|");
    localStringBuilder.append("onlineStatus").append("=").append(this.jdField_b_of_type_Int).append("|");
    localStringBuilder.append("onlineTime").append("=").append(this.jdField_b_of_type_Long).append("|");
    localStringBuilder.append("offlineTime").append("=").append(this.jdField_c_of_type_Long).append("|");
    localStringBuilder.append("prepareWording").append("=").append(this.n).append("|");
    localStringBuilder.append("gameNameUrl").append("=").append(this.m).append("|");
    localStringBuilder.append("bgSmallUrl").append("=").append(this.l).append("|");
    localStringBuilder.append("playerNum").append("=").append(this.jdField_a_of_type_Long).append("|");
    localStringBuilder.append("collaboratorLogoUrl=").append(this.o).append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.GameItem
 * JD-Core Version:    0.7.0.1
 */