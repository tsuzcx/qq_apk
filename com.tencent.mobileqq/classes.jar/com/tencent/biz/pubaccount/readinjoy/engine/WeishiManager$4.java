package com.tencent.biz.pubaccount.readinjoy.engine;

import UserGrowth.stSimpleMetaFeed;
import bgmg;
import com.google.gson.Gson;
import java.util.Map;
import pnp;
import upe;
import ups;

public final class WeishiManager$4
  implements Runnable
{
  public WeishiManager$4(pnp parampnp, stSimpleMetaFeed paramstSimpleMetaFeed) {}
  
  public void run()
  {
    byte[] arrayOfByte = bgmg.a(this.jdField_a_of_type_Pnp.b());
    if (arrayOfByte != null)
    {
      upe.a("weishi-report", "load map passback length:" + arrayOfByte.length);
      upe.b("weishi-report", "load map passback:" + ups.a(arrayOfByte));
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.map_pass_back.put(Integer.valueOf(1), arrayOfByte);
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.map_ext.put("recmd_feed_key", new Gson().toJson(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.map_pass_back));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager.4
 * JD-Core Version:    0.7.0.1
 */