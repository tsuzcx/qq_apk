package com.tencent.biz.pubaccount.readinjoy.model;

import bdcs;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import org.json.JSONArray;
import pfg;

public class ChannelCoverInfoModule$10
  implements Runnable
{
  public ChannelCoverInfoModule$10(pfg parampfg, JSONArray paramJSONArray) {}
  
  public void run()
  {
    bdcs.a(BaseApplicationImpl.getApplication().getDir("readinjoy", 0).getAbsolutePath() + "/channel_section_data", this.a.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.10
 * JD-Core Version:    0.7.0.1
 */