package com.tencent.ilivesdk.avpreloadservice;

import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class AVPreloadEngine$AVPreloadPlayListener$5
  implements Runnable
{
  AVPreloadEngine$AVPreloadPlayListener$5(AVPreloadEngine.AVPreloadPlayListener paramAVPreloadPlayListener, String paramString) {}
  
  public void run()
  {
    try
    {
      long l = new JSONObject(this.jdField_a_of_type_JavaLangString).getLong("gapTime");
      AVPreloadEngine.AVPreloadPlayListener.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener).i(l);
      Iterator localIterator = AVPreloadEngine.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener.a).iterator();
      while (localIterator.hasNext())
      {
        AVPreloadEngine.PreloadResultListener localPreloadResultListener = (AVPreloadEngine.PreloadResultListener)localIterator.next();
        if (localPreloadResultListener != null) {
          localPreloadResultListener.a(AVPreloadEngine.AVPreloadPlayListener.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener), AVPreloadEngine.AVPreloadPlayListener.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine$AVPreloadPlayListener).b(), l);
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadEngine.AVPreloadPlayListener.5
 * JD-Core Version:    0.7.0.1
 */