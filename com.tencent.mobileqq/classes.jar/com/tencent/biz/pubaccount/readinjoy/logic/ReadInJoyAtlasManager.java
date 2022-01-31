package com.tencent.biz.pubaccount.readinjoy.logic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.AtlasModelImage;
import com.tencent.biz.pubaccount.readinjoy.model.AtlasModelRecommend;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lod;
import loe;
import lof;
import log;
import loh;
import tencent.im.oidb.FavoriteCKVData.KandianFavoriteBizData;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.Client;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ReqArticle;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ReqBody;
import tencent.im.oidb.cmd0xb2d.cmd0xb2d.ReqBody;
import tencent.im.oidb.cmd0xb3e.cmd0xb3e.ReqBody;
import tencent.im.oidb.cmd0xb40.oidb_0xb40.CheckFavoriteReqBody;
import tencent.im.oidb.cmd0xb40.oidb_0xb40.ReqBody;
import tencent.im.oidb.gallery.gallery.GalleryInfo;
import tencent.im.oidb.gallery.gallery.PictureInfo;

public class ReadInJoyAtlasManager
{
  public static ReadInJoyAtlasManager a;
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.atlas.." + ReadInJoyAtlasManager.class.getSimpleName();
  }
  
  public static ReadInJoyAtlasManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager = new ReadInJoyAtlasManager();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager;
    }
    finally {}
  }
  
  public static String a(gallery.GalleryInfo paramGalleryInfo)
  {
    if ((paramGalleryInfo.bytes_summary_pic_url.has()) && (!TextUtils.isEmpty(paramGalleryInfo.bytes_summary_pic_url.get().toStringUtf8()))) {
      return paramGalleryInfo.bytes_summary_pic_url.get().toStringUtf8();
    }
    if ((paramGalleryInfo.rpt_msg_summary_pic.has()) && (paramGalleryInfo.rpt_msg_summary_pic.size() > 0)) {
      return ((gallery.PictureInfo)paramGalleryInfo.rpt_msg_summary_pic.get().get(0)).bytes_pic_url.get().toStringUtf8();
    }
    return null;
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, ArrayList paramArrayList)
  {
    new QfavBuilder(6).a("nLinkType", 0).b("sTitle", paramString2).b("sUrl", paramString5).a("bAppShare", false).a("lAppId", 0L).b("sPublisher", "").b("sBrief", paramString3).b("sPath", paramString4).b("sResUrl", paramString5).a("lCategory", 8L).b("sBizDataList", paramArrayList).b(paramActivity, paramString1, -1, null);
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    boolean bool = false;
    if (ReadInJoyUtils.a(BaseApplicationImpl.getApplication().getRuntime(), "Key_First_ReadInJoy_Favorite", true) == null)
    {
      ReadInJoyUtils.a("Key_First_ReadInJoy_Favorite", Integer.valueOf(1), true);
      if (!paramBoolean) {
        DialogUtil.b(paramContext, 230, paramContext.getString(2131431578), "你可在看点内点击“我的”找到“我的收藏”。\n收藏的内容将会上传保存，在其他手机上登录QQ，也可以在看点内找到你收藏的内容。\n", 2131432998, 2131431581, new loh(), null).setMessageCount(null).show();
      }
      bool = true;
    }
    return bool;
  }
  
  public AtlasModelRecommend a(List paramList)
  {
    if (paramList == null) {
      return null;
    }
    int j = paramList.size();
    int i = 0;
    if (i < j)
    {
      gallery.GalleryInfo localGalleryInfo = (gallery.GalleryInfo)paramList.get(i);
      if ((!localGalleryInfo.rpt_msg_summary_pic.has()) || (localGalleryInfo.rpt_msg_summary_pic.size() <= 0)) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        return new AtlasModelRecommend(paramList);
        i += 1;
        break;
      }
      return null;
    }
  }
  
  public List a(gallery.GalleryInfo paramGalleryInfo)
  {
    if (paramGalleryInfo == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    String str = paramGalleryInfo.bytes_row_key.get().toStringUtf8();
    paramGalleryInfo = paramGalleryInfo.rpt_msg_pic_info.get().iterator();
    while (paramGalleryInfo.hasNext()) {
      localArrayList.add(new AtlasModelImage(str, (gallery.PictureInfo)paramGalleryInfo.next()));
    }
    return localArrayList;
  }
  
  public void a(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle)
  {
    FavoriteCKVData.KandianFavoriteBizData localKandianFavoriteBizData = new FavoriteCKVData.KandianFavoriteBizData();
    localKandianFavoriteBizData.bytes_rowkey.set(ByteStringMicro.copyFromUtf8(paramString2));
    localKandianFavoriteBizData.uint32_type.set(paramInt);
    paramString2 = new ArrayList();
    if (paramBundle != null)
    {
      paramInt = paramBundle.getInt("videoDuration");
      localKandianFavoriteBizData.uint32_video_duration.set(paramInt);
      paramInt = paramBundle.getInt("picNum");
      localKandianFavoriteBizData.uint32_pic_num.set(paramInt);
      long l = paramBundle.getLong("publishAccountUin");
      localKandianFavoriteBizData.uint64_account_id.set(l);
      String str = paramBundle.getString("publishAccountName");
      if (!TextUtils.isEmpty(str)) {
        localKandianFavoriteBizData.bytes_account_name.set(ByteStringMicro.copyFromUtf8(str));
      }
      l = paramBundle.getLong("feedsId");
      localKandianFavoriteBizData.uint64_feeds_id.set(l);
      paramInt = paramBundle.getInt("feedsType");
      localKandianFavoriteBizData.uint32_feeds_type.set(paramInt);
      paramInt = paramBundle.getInt("videoType");
      localKandianFavoriteBizData.uint32_video_type.set(paramInt);
    }
    paramString2.add(localKandianFavoriteBizData.toByteArray());
    a(paramActivity, paramString1, paramString3, paramString4, paramString5, paramString6, paramString2);
  }
  
  public void a(Activity paramActivity, String paramString1, int paramInt, String paramString2, ArrayList paramArrayList)
  {
    FavoriteCKVData.KandianFavoriteBizData localKandianFavoriteBizData = new FavoriteCKVData.KandianFavoriteBizData();
    localKandianFavoriteBizData.bytes_rowkey.set(ByteStringMicro.copyFromUtf8(paramString2));
    localKandianFavoriteBizData.uint32_type.set(paramInt);
    paramString2 = new ArrayList();
    paramString2.add(localKandianFavoriteBizData.toByteArray());
    new QfavBuilder(6).a("sCIDListToBeDelete", paramArrayList).b("sBizDataList", paramString2).a(paramActivity, paramString1, -1, null);
  }
  
  public void a(Context paramContext, boolean paramBoolean, int paramInt)
  {
    paramContext = new QQToast(paramContext);
    paramContext.d(2000);
    if (paramBoolean)
    {
      paramContext.b(2);
      paramContext.a(QQToast.a(2));
      if (paramInt == 1) {
        paramContext.a("已收藏");
      }
      for (;;)
      {
        paramContext.a();
        return;
        if (paramInt == 2) {
          paramContext.a("已取消收藏");
        }
      }
    }
    paramContext.b(1);
    paramContext.a(QQToast.a(1));
    if (paramInt == 1) {
      paramContext.a("收藏失败");
    }
    for (;;)
    {
      paramContext.a();
      return;
      paramContext.a("取消收藏失败");
    }
  }
  
  public void a(String paramString, ReadInJoyAtlasManager.AtlasCallback paramAtlasCallback)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new RuntimeException("fetchAtlasList(). rowKey can not be null.");
    }
    cmd0xb2d.ReqBody localReqBody = new cmd0xb2d.ReqBody();
    localReqBody.bytes_gallery_rowkey.set(ByteStringMicro.copyFromUtf8(paramString));
    ProtoUtils.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), new lod(this, paramAtlasCallback), localReqBody.toByteArray(), "OidbSvc.0xb2d", 2861, 1, null, 0L);
  }
  
  public void a(String paramString1, String paramString2, ReadInJoyAtlasManager.AtlasCallback paramAtlasCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getAtlasCommentCount, rowKey = " + paramString1 + ", reqUrl = " + paramString2 + ", callback = " + paramAtlasCallback);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramAtlasCallback == null)) {
      return;
    }
    oidb_cmd0xad6.ReqBody localReqBody = new oidb_cmd0xad6.ReqBody();
    oidb_cmd0xad6.Client localClient = new oidb_cmd0xad6.Client();
    localClient.bytes_version.set(ByteStringMicro.copyFromUtf8("7.6.0"));
    localClient.uint32_type.set(1);
    oidb_cmd0xad6.ReqArticle localReqArticle = new oidb_cmd0xad6.ReqArticle();
    localReqArticle.bytes_row_key.set(ByteStringMicro.copyFromUtf8(paramString1));
    localReqArticle.bytes_url.set(ByteStringMicro.copyFromUtf8(paramString2));
    localReqBody.msg_client.set(localClient);
    localReqBody.uint32_comment.set(1);
    localReqBody.uint32_comment_key_type.set(1);
    localReqBody.msg_req_article.set(localReqArticle);
    ProtoUtils.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), new log(this, paramAtlasCallback), localReqBody.toByteArray(), "OidbSvc.0xad6", 2774, 1, null, 0L);
  }
  
  public void a(List paramList, ReadInJoyAtlasManager.AtlasCallback paramAtlasCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getAtlasFavoriteStatus, rowKeyList = " + paramList + ", callback = " + paramAtlasCallback);
    }
    oidb_0xb40.ReqBody localReqBody = new oidb_0xb40.ReqBody();
    oidb_0xb40.CheckFavoriteReqBody localCheckFavoriteReqBody = new oidb_0xb40.CheckFavoriteReqBody();
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!TextUtils.isEmpty(str)) {
        localCheckFavoriteReqBody.rpt_bytes_rowkey.add(ByteStringMicro.copyFromUtf8(str));
      }
    }
    localReqBody.msg_check_favorite_req.set(localCheckFavoriteReqBody);
    paramList = new Bundle();
    ProtoUtils.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), new lof(this, paramAtlasCallback), localReqBody.toByteArray(), "OidbSvc.0xb40", 2880, 1, paramList, 0L);
  }
  
  public void b(String paramString, ReadInJoyAtlasManager.AtlasCallback paramAtlasCallback)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new RuntimeException("fetchAtlasRecommendList(). rowKey can not be null.");
    }
    cmd0xb3e.ReqBody localReqBody = new cmd0xb3e.ReqBody();
    localReqBody.bytes_gallery_rowkey.set(ByteStringMicro.copyFromUtf8(paramString));
    ProtoUtils.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), new loe(this, paramAtlasCallback), localReqBody.toByteArray(), "OidbSvc.0xb3e", 2878, 2, null, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager
 * JD-Core Version:    0.7.0.1
 */