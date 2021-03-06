package com.tencent.biz.qqstory.model.item;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.Address;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import org.json.JSONException;
import org.json.JSONObject;

public class AddressItem
  extends BaseUIItem
  implements Copyable
{
  public String building;
  public String city;
  public int coordinate;
  public String country;
  public String district;
  public int latitude;
  public int longitude;
  public int poiType;
  public String province;
  public String street;
  
  public static String convertFromItem(AddressItem paramAddressItem)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("country", paramAddressItem.country);
      localJSONObject.put("city", paramAddressItem.city);
      localJSONObject.put("province", paramAddressItem.province);
      localJSONObject.put("street", paramAddressItem.street);
      localJSONObject.put("building", paramAddressItem.building);
      localJSONObject.put("longitude", paramAddressItem.longitude);
      localJSONObject.put("latitude", paramAddressItem.latitude);
      localJSONObject.put("coordinate", paramAddressItem.coordinate);
      localJSONObject.put("district", paramAddressItem.district);
    }
    catch (JSONException paramAddressItem)
    {
      paramAddressItem.printStackTrace();
    }
    SLog.b("AddressItem convertFromItem: ", localJSONObject.toString());
    return localJSONObject.toString();
  }
  
  public static AddressItem convertFromJson(String paramString)
  {
    AddressItem localAddressItem = new AddressItem();
    paramString = new JSONObject(paramString);
    localAddressItem.country = paramString.optString("country");
    localAddressItem.city = paramString.optString("city");
    localAddressItem.province = paramString.optString("province");
    localAddressItem.street = paramString.optString("street");
    localAddressItem.building = paramString.optString("building");
    localAddressItem.longitude = paramString.optInt("longitude");
    localAddressItem.latitude = paramString.optInt("latitude");
    localAddressItem.coordinate = paramString.optInt("coordinate");
    localAddressItem.district = paramString.optString("district");
    return localAddressItem;
  }
  
  public static String generatePoiJson(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("country", paramString2);
      localJSONObject.put("province", paramString4);
      localJSONObject.put("city", paramString3);
      localJSONObject.put("street", paramString5);
      localJSONObject.put("building", paramString6);
      localJSONObject.put("latitude", paramInt2);
      localJSONObject.put("longitude", paramInt1);
      localJSONObject.put("uid", paramString1);
      localJSONObject.put("coordinate", paramInt3);
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      label103:
      break label103;
    }
    return "";
  }
  
  public static AddressItem getAddressFromProtoObject(qqstory_struct.Address paramAddress)
  {
    AddressItem localAddressItem = new AddressItem();
    if (paramAddress != null)
    {
      localAddressItem.country = paramAddress.country.get().toStringUtf8();
      localAddressItem.city = paramAddress.city.get().toStringUtf8();
      localAddressItem.province = paramAddress.province.get().toStringUtf8();
      localAddressItem.street = paramAddress.street.get().toStringUtf8();
      localAddressItem.building = paramAddress.building.get().toStringUtf8();
      if (paramAddress.gps.has())
      {
        localAddressItem.longitude = paramAddress.gps.lng.get();
        localAddressItem.latitude = paramAddress.gps.lat.get();
      }
      localAddressItem.coordinate = paramAddress.coordinate.get();
      if (paramAddress.district.has()) {
        localAddressItem.district = paramAddress.district.get().toStringUtf8();
      }
      return localAddressItem;
    }
    SLog.b("AddressItem :getAddressFromProtoObject()", "address is null");
    return null;
  }
  
  public void convertFrom(qqstory_struct.Address paramAddress)
  {
    this.country = paramAddress.country.get().toStringUtf8();
    this.city = paramAddress.city.get().toStringUtf8();
    this.province = paramAddress.province.get().toStringUtf8();
    this.street = paramAddress.street.get().toStringUtf8();
    this.building = paramAddress.building.get().toStringUtf8();
    if (paramAddress.gps.has())
    {
      this.longitude = paramAddress.gps.lng.get();
      this.latitude = paramAddress.gps.lat.get();
    }
    this.coordinate = paramAddress.coordinate.get();
    if (paramAddress.district.has()) {
      this.district = paramAddress.district.get().toStringUtf8();
    }
  }
  
  public qqstory_struct.Address convertToProtoObject()
  {
    qqstory_struct.Address localAddress = new qqstory_struct.Address();
    if (!TextUtils.isEmpty(this.country)) {
      localAddress.country.set(ByteStringMicro.copyFromUtf8(this.country));
    }
    if (!TextUtils.isEmpty(this.city)) {
      localAddress.city.set(ByteStringMicro.copyFromUtf8(this.city));
    }
    if (!TextUtils.isEmpty(this.province)) {
      localAddress.province.set(ByteStringMicro.copyFromUtf8(this.province));
    }
    if (!TextUtils.isEmpty(this.street)) {
      localAddress.street.set(ByteStringMicro.copyFromUtf8(this.street));
    }
    if (!TextUtils.isEmpty(this.building)) {
      localAddress.building.set(ByteStringMicro.copyFromUtf8(this.building));
    }
    if (!TextUtils.isEmpty(this.district)) {
      localAddress.district.set(ByteStringMicro.copyFromUtf8(this.district));
    }
    localAddress.gps.lng.set(this.longitude);
    localAddress.gps.lat.set(this.latitude);
    localAddress.gps.setHasFlag(true);
    localAddress.coordinate.set(this.coordinate);
    return localAddress;
  }
  
  public void copy(Object paramObject)
  {
    paramObject = (AddressItem)paramObject;
    this.country = paramObject.country;
    this.city = paramObject.city;
    this.province = paramObject.province;
    this.street = paramObject.street;
    this.building = paramObject.building;
    this.longitude = paramObject.longitude;
    this.latitude = paramObject.latitude;
    this.coordinate = paramObject.coordinate;
    this.district = paramObject.district;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"_class\":\"AddressItem\", \"country\":");
    Object localObject = this.country;
    String str = "null";
    if (localObject == null)
    {
      localObject = "null";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("\"");
      ((StringBuilder)localObject).append(this.country);
      ((StringBuilder)localObject).append("\"");
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", \"city\":");
    if (this.city == null)
    {
      localObject = "null";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("\"");
      ((StringBuilder)localObject).append(this.city);
      ((StringBuilder)localObject).append("\"");
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", \"province\":");
    if (this.province == null)
    {
      localObject = "null";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("\"");
      ((StringBuilder)localObject).append(this.province);
      ((StringBuilder)localObject).append("\"");
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", \"street\":");
    if (this.street == null)
    {
      localObject = "null";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("\"");
      ((StringBuilder)localObject).append(this.street);
      ((StringBuilder)localObject).append("\"");
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", \"building\":");
    if (this.building == null)
    {
      localObject = str;
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("\"");
      ((StringBuilder)localObject).append(this.building);
      ((StringBuilder)localObject).append("\"");
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", \"longitude\":\"");
    localStringBuilder.append(this.longitude);
    localStringBuilder.append("\", \"latitude\":\"");
    localStringBuilder.append(this.latitude);
    localStringBuilder.append("\", \"coordinate\":\"");
    localStringBuilder.append(this.coordinate);
    localStringBuilder.append("\"\"district\":\"");
    localStringBuilder.append(this.district);
    localStringBuilder.append("\"}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.AddressItem
 * JD-Core Version:    0.7.0.1
 */