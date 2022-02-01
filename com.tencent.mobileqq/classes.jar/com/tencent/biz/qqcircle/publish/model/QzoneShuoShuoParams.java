package com.tencent.biz.qqcircle.publish.model;

import NS_MOBILE_OPERATION.PicInfo;
import NS_MOBILE_PHOTO.shuoshuo_privacy;
import PROTO_EXT_TO_UGCSVR.Font;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.LbsDataV2.PoiInfo;
import cooperation.qzone.model.LabelInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QzoneShuoShuoParams
{
  public ArrayList<GifInfo> A;
  public PublishEventTag B;
  public Map<String, byte[]> C;
  public HashMap<String, String> D;
  public Map<String, byte[]> E;
  public Map<String, String> F;
  public int G = 2;
  public String H;
  public boolean I;
  public HashMap<String, String> J;
  public ArrayList<MediaWrapper> K;
  public PicInfo L;
  public boolean M;
  public ArrayList<String> N;
  public String O;
  public String P;
  public boolean Q;
  public boolean R = true;
  public boolean S;
  public String T;
  public boolean U = false;
  public Map<String, String> V;
  public boolean W = true;
  public String X;
  public int Y;
  public int Z;
  public String a;
  public boolean aa = false;
  public ArrayList<LabelInfo> ab;
  public boolean ac = false;
  public String ad = "";
  public String b;
  public List<String> c;
  public List<LocalMediaInfo> d;
  public HashMap<String, String> e;
  public shuoshuo_privacy f;
  public ShuoshuoVideoInfo g;
  public HashMap<String, PicInfo> h;
  public LbsDataV2.PoiInfo i;
  public LbsDataV2.PoiInfo j;
  public boolean k;
  public boolean l;
  public boolean m;
  public int n;
  public QZonePreUploadInfo o;
  public Map<String, String> p;
  public Font q;
  public int r;
  public long s;
  public long t;
  public int u;
  public ArrayList<String> v;
  public String w;
  public LbsDataV2.GpsInfo x;
  public String y;
  public int z;
  
  public Map<String, byte[]> a()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = this.q;
    if (localObject != null)
    {
      localObject = ((Font)localObject).toByteArray();
      if (localObject != null) {
        localHashMap.put("TO_UGCSVR_FOR_FONT", localObject);
      }
    }
    return localHashMap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("title: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" content: ");
    localStringBuilder.append(this.b);
    if (this.c != null)
    {
      localStringBuilder.append(" imageFiles: ");
      localStringBuilder.append(this.c);
    }
    if (this.f != null)
    {
      localStringBuilder.append(" shuoshuoPrivacy:");
      localStringBuilder.append(this.f.mood_permission);
    }
    localStringBuilder.append(" syncWeibo:");
    localStringBuilder.append(this.k);
    localStringBuilder.append(" syncQQ:");
    localStringBuilder.append(this.l);
    localStringBuilder.append(" photoQuality:");
    localStringBuilder.append(this.r);
    localStringBuilder.append(" isSyncToQQStory:");
    localStringBuilder.append(this.I);
    localStringBuilder.append("  publishTime;:");
    localStringBuilder.append(this.s);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.model.QzoneShuoShuoParams
 * JD-Core Version:    0.7.0.1
 */