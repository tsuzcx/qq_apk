package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.atlas.PicCropInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.gallery.gallery.PictureInfo;
import tencent.im.oidb.gallery.gallery_report.OnePicReported;

public class AtlasModelImage
  extends AtlasModel
{
  public static final int SLIDE_POS_NORMAL = 0;
  public static final int SLIDE_POS_PREVIEW = 1;
  public static URLDrawable sAttachDrawable;
  public PicCropInfo cropInfo;
  public boolean expanded;
  private boolean exposed = false;
  public int mSlidePos;
  public int measuredLines = -1;
  public long modelEnterTime;
  public long modelExitTime;
  public long modelImageShowTime;
  public gallery_report.OnePicReported onePicReported;
  public int picType;
  public gallery.PictureInfo pictureInfo;
  public String rowKey;
  
  public AtlasModelImage(String paramString, gallery.PictureInfo paramPictureInfo)
  {
    this.type = 1;
    this.rowKey = paramString;
    this.pictureInfo = paramPictureInfo;
  }
  
  private gallery_report.OnePicReported a()
  {
    this.onePicReported = new gallery_report.OnePicReported();
    this.onePicReported.index.set(this.position);
    this.onePicReported.come_in_time.set(this.modelEnterTime);
    this.onePicReported.load_completed_time.set(this.modelImageShowTime);
    this.onePicReported.go_away_time.set(this.modelExitTime);
    this.onePicReported.pic_type.set(this.picType);
    return this.onePicReported;
  }
  
  public static void clear()
  {
    sAttachDrawable = null;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof AtlasModel))
    {
      paramObject = (AtlasModel)paramObject;
      if ((paramObject.type != this.type) || (paramObject.position != this.position) || (this.jumpUrl != paramObject.jumpUrl))
      {
        bool1 = bool2;
        if (this.jumpUrl != null)
        {
          bool1 = bool2;
          if (!this.jumpUrl.equals(paramObject.jumpUrl)) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isExposed()
  {
    return this.exposed;
  }
  
  public void onLoadSucceed(int paramInt)
  {
    this.picType = paramInt;
    this.modelImageShowTime = System.currentTimeMillis();
  }
  
  public void onSlideEnter(int paramInt)
  {
    this.exposed = true;
    this.mSlidePos = paramInt;
    this.modelEnterTime = System.currentTimeMillis();
    if (this.modelImageShowTime < this.modelEnterTime) {
      this.modelImageShowTime = this.modelEnterTime;
    }
  }
  
  public void onSlideExit()
  {
    this.modelExitTime = System.currentTimeMillis();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.AtlasModelImage
 * JD-Core Version:    0.7.0.1
 */