package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.FaceElement;

public class V2TIMFaceElem
  extends V2TIMElem
{
  public byte[] getData()
  {
    if (getElement() == null) {
      return null;
    }
    return ((FaceElement)getElement()).getFaceData();
  }
  
  public int getIndex()
  {
    if (getElement() == null) {
      return 0;
    }
    return ((FaceElement)getElement()).getFaceIndex();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("V2TIMFaceElem--->");
    localStringBuilder.append("index:");
    localStringBuilder.append(getIndex());
    localStringBuilder.append(", has data:");
    String str;
    if (getData() == null) {
      str = "false";
    } else {
      str = "true";
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMFaceElem
 * JD-Core Version:    0.7.0.1
 */