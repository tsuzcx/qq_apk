package com.tencent.mobileqq.apollo;

import android.view.View;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import org.json.JSONObject;

final class ApolloRender$29
  implements APICallback
{
  ApolloRender$29(View paramView, DoraemonAPIManager paramDoraemonAPIManager, long paramLong, int paramInt) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    ApolloRender.locationEnd(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, this.jdField_a_of_type_Long, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, "", paramInt, "location permision code");
  }
  
  public void a(int paramInt, String paramString)
  {
    ApolloRender.locationEnd(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, this.jdField_a_of_type_Long, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, "", paramInt, "location failed," + paramString);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    double d1 = paramJSONObject.optDouble("altitude", 0.0D);
    double d2 = paramJSONObject.optDouble("latitude", 0.0D);
    double d3 = paramJSONObject.optDouble("longitude", 0.0D);
    double d4 = paramJSONObject.optDouble("horizontalAccuracy", 0.0D);
    paramJSONObject.optDouble("verticalAccuracy", 0.0D);
    paramJSONObject.optDouble("accuracy", 0.0D);
    double d5 = paramJSONObject.optDouble("speed", 0.0D);
    if (this.jdField_a_of_type_Int == 1)
    {
      ApolloRender.getLocationCity(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, this.jdField_a_of_type_Long, d4, d2, d3, d5, d1, 0.0D);
      return;
    }
    ApolloRender.locationEnd(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, this.jdField_a_of_type_Long, d4, d2, d3, d5, d1, 0.0D, "", 0, "location success");
  }
  
  public void b(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.29
 * JD-Core Version:    0.7.0.1
 */