package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import org.json.JSONArray;

class ChannelCoverInfoModule$10
  implements Runnable
{
  ChannelCoverInfoModule$10(ChannelCoverInfoModule paramChannelCoverInfoModule, JSONArray paramJSONArray) {}
  
  public void run()
  {
    FileUtils.a(BaseApplicationImpl.getApplication().getDir("readinjoy", 0).getAbsolutePath() + "/channel_section_data", this.a.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.10
 * JD-Core Version:    0.7.0.1
 */