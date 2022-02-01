package com.tencent.ilivesdk.avpreloadservice;

import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class AVPreloadEngine$AVPreloadPlayListener$6
  implements Runnable
{
  AVPreloadEngine$AVPreloadPlayListener$6(AVPreloadEngine.AVPreloadPlayListener paramAVPreloadPlayListener, Object paramObject) {}
  
  public void run()
  {
    try
    {
      long l = new JSONObject(this.jdField_a_of_type_JavaLangObject.toString()).getLong("gapTime");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadEngine.AVPreloadPlayListener.6
 * JD-Core Version:    0.7.0.1
 */