package com.tencent.autotemplate.extra;

import java.util.HashMap;
import java.util.Map;

public class ExtraData
{
  public static final String EXTRA_FACE_INFO = "extra_face_info";
  public static final String EXTRA_FRAME_INFO = "extra_frame_info";
  public Map<String, FaceInfo> faceInfoMap = new HashMap();
  public Map<String, FrameInfo> frameInfoMap = new HashMap();
  
  public FaceInfo getFaceInfo(String paramString)
  {
    return (FaceInfo)this.faceInfoMap.get(paramString);
  }
  
  public FrameInfo getFrameInfo(String paramString)
  {
    return (FrameInfo)this.frameInfoMap.get(paramString);
  }
  
  public void putFaceInfo(String paramString, FaceInfo paramFaceInfo)
  {
    this.faceInfoMap.put(paramString, paramFaceInfo);
  }
  
  public void putFrameInfo(String paramString, FrameInfo paramFrameInfo)
  {
    this.frameInfoMap.put(paramString, paramFrameInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.extra.ExtraData
 * JD-Core Version:    0.7.0.1
 */