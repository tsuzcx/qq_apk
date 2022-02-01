package com.tencent.biz.qqcircle.publish.model;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.publish.util.ImageUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class GifInfo
  implements Serializable, Cloneable
{
  private static final String a;
  public int delay;
  public boolean isBaseGif = true;
  public String mCombineImagePath;
  public String mDestPath;
  public String mDoodlePath;
  public String mOrignPath;
  public String mSavePath;
  public ArrayList<String> picsOrignPath;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append("/DCIM/Qzone_gif/");
    a = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public GifInfo(String paramString1, ArrayList<String> paramArrayList, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    this.mOrignPath = paramString1;
    this.picsOrignPath = paramArrayList;
    this.mDoodlePath = paramString2;
    this.mCombineImagePath = paramString3;
    this.delay = paramInt;
    boolean bool = TextUtils.isEmpty(this.mOrignPath);
    int i = 0;
    if ((bool) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (QLog.isColorLevel())
      {
        paramString3 = new StringBuilder();
        paramString3.append("picsOrignPath:");
        paramString3.append((String)paramArrayList.get(0));
        paramString3.append("replace gifOrignPath:");
        paramString3.append(paramString1);
        QLog.d("GifInfo", 2, paramString3.toString());
      }
      this.mOrignPath = ((String)paramArrayList.get(0));
      this.isBaseGif = false;
    }
    else
    {
      this.mOrignPath = paramString1;
      this.isBaseGif = true;
    }
    paramString3 = new File(a);
    if (!paramString3.exists()) {
      paramString3.mkdirs();
    }
    if ((paramBoolean) && (paramArrayList != null))
    {
      paramString3 = new StringBuilder();
      paramString3.append(a);
      paramString3.append(ImageUtil.a(paramArrayList));
      paramString3.append(".gif");
      this.mSavePath = paramString3.toString();
    }
    else
    {
      paramString3 = new StringBuilder();
      paramString3.append(a);
      paramString3.append(System.currentTimeMillis());
      paramString3.append(".gif");
      this.mSavePath = paramString3.toString();
    }
    if (QLog.isColorLevel())
    {
      paramString3 = new StringBuilder();
      paramString3.append("gifOrignPath:");
      paramString3.append(paramString1);
      paramString3.append(" doodlePath:");
      paramString3.append(paramString2);
      paramString3.append(" mCombineImagePath:");
      paramString3.append(this.mCombineImagePath);
      paramString3.append(" delay:");
      paramString3.append(paramInt);
      paramString3.append(" picsOrignPath size:");
      paramInt = i;
      if (paramArrayList != null) {
        paramInt = paramArrayList.size();
      }
      paramString3.append(paramInt);
      QLog.d("GifInfo", 2, paramString3.toString());
    }
  }
  
  public Object clone()
  {
    try
    {
      GifInfo localGifInfo = (GifInfo)super.clone();
      return localGifInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.model.GifInfo
 * JD-Core Version:    0.7.0.1
 */