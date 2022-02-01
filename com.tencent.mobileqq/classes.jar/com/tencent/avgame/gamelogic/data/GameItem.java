package com.tencent.avgame.gamelogic.data;

import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon.GameInfo;
import trpc.qq_vgame.game_list.AvGameList.GameListItemInfo;

public class GameItem
{
  public int a = 0;
  public String b;
  public String c;
  public String d;
  public GameInfo e = new GameInfo();
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public long o;
  public int p = 0;
  public long q = 0L;
  public long r = 0L;
  public String s;
  public String t;
  public String u;
  
  protected GameItem a()
  {
    GameItem localGameItem = new GameItem();
    try
    {
      localGameItem.a = this.a;
      localGameItem.b = this.b;
      localGameItem.c = this.c;
      localGameItem.d = this.d;
      localGameItem.e = this.e;
      localGameItem.h = this.h;
      localGameItem.i = this.i;
      localGameItem.j = this.j;
      localGameItem.k = this.k;
      localGameItem.l = this.l;
      localGameItem.f = this.f;
      localGameItem.g = this.g;
      localGameItem.m = this.m;
      localGameItem.p = this.p;
      localGameItem.q = this.q;
      localGameItem.r = this.r;
      localGameItem.t = this.t;
      localGameItem.s = this.s;
      localGameItem.o = this.o;
      localGameItem.n = this.n;
      localGameItem.u = this.u;
      return localGameItem;
    }
    catch (Exception localException) {}
    return localGameItem;
  }
  
  public final void a(AvGameList.GameListItemInfo paramGameListItemInfo)
  {
    this.a = paramGameListItemInfo.game_type.get();
    this.b = paramGameListItemInfo.game_name.get();
    this.c = paramGameListItemInfo.game_desc.get();
    this.d = paramGameListItemInfo.backgroup_pic_url.get();
    this.e.a();
    this.e.a((AvGameCommon.GameInfo)paramGameListItemInfo.game_info.get());
    this.h = paramGameListItemInfo.answer_right_pic_url.get();
    this.i = paramGameListItemInfo.answer_right_pic_url_new.get();
    this.j = paramGameListItemInfo.game_over_pic_url.get();
    this.k = paramGameListItemInfo.tips_one_line_pic_url.get();
    this.l = paramGameListItemInfo.tips_two_line_pic_url.get();
    this.f = paramGameListItemInfo.prepare_pic_url.get();
    this.g = paramGameListItemInfo.prepare_pic_tp_url.get();
    this.m = paramGameListItemInfo.music_name.get();
    this.p = paramGameListItemInfo.status.get();
    this.q = paramGameListItemInfo.online_time.get();
    this.r = paramGameListItemInfo.offline_time.get();
    this.t = paramGameListItemInfo.prepare_wording.get();
    this.s = paramGameListItemInfo.game_name_url.get();
    this.o = paramGameListItemInfo.total_player_num.get();
    this.n = paramGameListItemInfo.backgroup_small_pic_url.get();
    this.u = paramGameListItemInfo.collaborator_logo_url.get();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("type");
    localStringBuilder.append("=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("|");
    localStringBuilder.append("name");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    localStringBuilder.append("desc");
    localStringBuilder.append("=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|");
    localStringBuilder.append("bgUrl");
    localStringBuilder.append("=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("|");
    localStringBuilder.append("answerRightPicUrl");
    localStringBuilder.append("=");
    localStringBuilder.append(this.h);
    localStringBuilder.append("|");
    localStringBuilder.append("gameOverPicUrl");
    localStringBuilder.append("=");
    localStringBuilder.append(this.j);
    localStringBuilder.append("|");
    localStringBuilder.append("oneLineTipBgPicUrl");
    localStringBuilder.append("=");
    localStringBuilder.append(this.k);
    localStringBuilder.append("|");
    localStringBuilder.append("twoLinesTipBgPicUrl");
    localStringBuilder.append("=");
    localStringBuilder.append(this.l);
    localStringBuilder.append("|");
    localStringBuilder.append("preparePicUrl");
    localStringBuilder.append("=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("|");
    localStringBuilder.append("prepareAlphaPicUrl");
    localStringBuilder.append("=");
    localStringBuilder.append(this.g);
    localStringBuilder.append("|");
    localStringBuilder.append("gameBgName");
    localStringBuilder.append("=");
    localStringBuilder.append(this.m);
    localStringBuilder.append("|");
    localStringBuilder.append("onlineStatus");
    localStringBuilder.append("=");
    localStringBuilder.append(this.p);
    localStringBuilder.append("|");
    localStringBuilder.append("onlineTime");
    localStringBuilder.append("=");
    localStringBuilder.append(this.q);
    localStringBuilder.append("|");
    localStringBuilder.append("offlineTime");
    localStringBuilder.append("=");
    localStringBuilder.append(this.r);
    localStringBuilder.append("|");
    localStringBuilder.append("prepareWording");
    localStringBuilder.append("=");
    localStringBuilder.append(this.t);
    localStringBuilder.append("|");
    localStringBuilder.append("gameNameUrl");
    localStringBuilder.append("=");
    localStringBuilder.append(this.s);
    localStringBuilder.append("|");
    localStringBuilder.append("bgSmallUrl");
    localStringBuilder.append("=");
    localStringBuilder.append(this.n);
    localStringBuilder.append("|");
    localStringBuilder.append("playerNum");
    localStringBuilder.append("=");
    localStringBuilder.append(this.o);
    localStringBuilder.append("|");
    localStringBuilder.append("collaboratorLogoUrl=");
    localStringBuilder.append(this.u);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.GameItem
 * JD-Core Version:    0.7.0.1
 */