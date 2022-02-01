package com.tencent.biz.qqstory.takevideo;

import android.os.Handler;
import com.tencent.biz.qqstory.model.DataProvider.DataUpdateListener;
import com.tencent.biz.qqstory.model.WeatherDataProvider.WeatherInfo;
import com.tencent.biz.qqstory.support.logging.SLog;

class EditVideoFilterNeo$1
  implements DataProvider.DataUpdateListener<WeatherDataProvider.WeatherInfo>
{
  EditVideoFilterNeo$1(EditVideoFilterNeo paramEditVideoFilterNeo) {}
  
  public void a(boolean paramBoolean, WeatherDataProvider.WeatherInfo paramWeatherInfo)
  {
    SLog.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramWeatherInfo != null))
    {
      SLog.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, temperature=%s", Integer.valueOf(paramWeatherInfo.a));
      int i = paramWeatherInfo.a;
      EditVideoFilterNeo.a(this.a).post(new EditVideoFilterNeo.1.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoFilterNeo.1
 * JD-Core Version:    0.7.0.1
 */