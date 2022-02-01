package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.CustomElement;

public class V2TIMCustomElem
  extends V2TIMElem
{
  private byte[] data;
  private String description;
  private byte[] extension;
  
  public byte[] getData()
  {
    if (getElement() == null) {
      return this.data;
    }
    return ((CustomElement)getElement()).getData();
  }
  
  public String getDescription()
  {
    if (getElement() == null) {
      return this.description;
    }
    return ((CustomElement)getElement()).getDescription();
  }
  
  public byte[] getExtension()
  {
    if (getElement() == null) {
      return this.extension;
    }
    return ((CustomElement)getElement()).getExtension();
  }
  
  public void setData(byte[] paramArrayOfByte)
  {
    if (getElement() == null)
    {
      this.data = paramArrayOfByte;
      return;
    }
    ((CustomElement)getElement()).setData(paramArrayOfByte);
  }
  
  public void setDescription(String paramString)
  {
    if (getElement() == null)
    {
      this.description = paramString;
      return;
    }
    ((CustomElement)getElement()).setDescription(paramString);
  }
  
  public void setExtension(byte[] paramArrayOfByte)
  {
    if (getElement() == null)
    {
      this.extension = paramArrayOfByte;
      return;
    }
    ((CustomElement)getElement()).setExtension(paramArrayOfByte);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = getData();
    String str2 = "";
    if (localObject != null) {
      localObject = new String((byte[])localObject);
    } else {
      localObject = "";
    }
    String str1;
    if (getDescription() != null) {
      str1 = getDescription();
    } else {
      str1 = "";
    }
    if (getExtension() != null) {
      str2 = new String(getExtension());
    }
    localStringBuilder.append("V2TIMCustomElem--->");
    localStringBuilder.append("data2String:");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", description:");
    localStringBuilder.append(str1);
    localStringBuilder.append(", extension2String:");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMCustomElem
 * JD-Core Version:    0.7.0.1
 */